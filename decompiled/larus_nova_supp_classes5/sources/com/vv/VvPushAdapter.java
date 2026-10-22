package com.vv;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.common.push.ActivityLifecycleObserver;
import com.bytedance.common.push.interfaze.RequestResultCallback;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.push.PushSupporter;
import com.bytedance.push.third.IPushAdapter;
import com.bytedance.push.third.PushChannelHelper;
import com.bytedance.push.third.b;
import com.bytedance.push.utils.f;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import com.ss.android.message.AppProvider;
import com.ss.android.message.PushThreadHandlerManager;
import com.ss.android.message.util.ToolUtils;
import com.vivo.push.PushClient;
import com.vivo.push.PushConfig;
import com.vivo.push.util.VivoPushException;
import el9.a;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import me.ele.lancet.base.annotations.Skip;
import s67.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class VvPushAdapter extends b implements IPushAdapter {
    private static final String TAG = "VivoPush";
    private static int VV_PUSH = -1;
    private static boolean hasSendValidToken;
    private static boolean sHasRegistered;
    private final long DIALOG_SHOW_TIME_OUT;
    private final String SUCCESS;
    private volatile boolean appStatusHasChanged;
    private boolean hasShown;
    private final Handler mHandler;

    public static /* synthetic */ Class access$001(String r0) throws ClassNotFoundException {
        return Class.forName(r0);
    }

    public int getPushType() {
        return 11;
    }

    public boolean requestRemoveVoipNotification(Context r1, int r2) {
        return false;
    }

    public void trackPush(Context r1, int r2, Object r3) {
    }

    public static int getVvPush() {
        if (VV_PUSH != (-1)) goto L6;
        VV_PUSH = PushChannelHelper.inst(AppProvider.getApp()).getChannelId(VvPushAdapter.class.getName());
    L6:
        return VV_PUSH;
    }

    private Boolean isPushServiceAvailable() {
        PackageInfo r2 = AppProvider.getApp().getPackageManager().getPackageInfo("com.vivo.pushservice", 0);     // Catch: Exception -> L10
        f.e(TAG, "com.vivo.pushservice versionName: " + r2.versionName);     // Catch: Exception -> L10
        if (r2.versionCode < 5380000) goto L8;
        f.e(TAG, "com.vivo.pushservice versionCode: " + r2.versionCode + " is available!");     // Catch: Exception -> L10
        return Boolean.TRUE;
    L8:
        f.e(TAG, "com.vivo.pushservice versionCode: " + r2.versionCode + " version not supported!");     // Catch: Exception -> L10
        return Boolean.FALSE;
    L10:
        e = move-exception;
        throw new RuntimeException(e);
    }

    private String requestNotificationInternal() {
        PushSupporter.logger().d(TAG, "requestNotificationInternal");
        Application r1 = AppProvider.getApp();
        IBinder r2 = (IBinder) INVOKESTATIC_com_vv_VvPushAdapter_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.os.ServiceManager").getDeclaredMethod("getService", new Class[]{String.class}).invoke(null, new Object[]{"notification"});     // Catch: Throwable -> L19 NoSuchMethodException -> L22
        if (r2 != null) goto L7;
        PushSupporter.logger().e(TAG, "get service failed.");     // Catch: Throwable -> L19 NoSuchMethodException -> L22
        return "notification service is null";
    L7:
        Parcel r4 = Parcel.obtain();     // Catch: Throwable -> L19 NoSuchMethodException -> L22
        Parcel r7 = Parcel.obtain();     // Catch: Throwable -> L19 NoSuchMethodException -> L22
        INVOKEINTERFACE_com_vv_VvPushAdapter_com_obric_assistant_interaction_impl_BinderLancet_transact(r2, 1598968902, r4, r7, 0);     // Catch: Throwable -> L19 NoSuchMethodException -> L22
        String r5 = r7.readString();     // Catch: Throwable -> L19 NoSuchMethodException -> L22
        if (r5 != null) goto L10;
        return "readString is null";
    L10:
        if (r5.equals("") == true) goto L26;
        Object r0 = INVOKESTATIC_com_vv_VvPushAdapter_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r5.concat("$Stub")).getDeclaredMethod("asInterface", new Class[]{IBinder.class}).invoke(null, new Object[]{r2});     // Catch: Throwable -> L19 NoSuchMethodException -> L22
        if (r0 == null) goto L15;
        r0.getClass().getDeclaredMethod("requestNotificationPermission", new Class[]{String.class}).invoke(r0, new Object[]{r1.getPackageName()});     // Catch: Throwable -> L19 NoSuchMethodException -> L22
        return "success";
    L15:
        return "asInterface is null";
    L26:
        return "readString is null";
    L22:
        e = move-exception;
        return "not support device:" + e.getLocalizedMessage();
    L19:
        th = move-exception;
        f.f(TAG, "requestNotificationInternal error ", th);
        return "exception:" + th.getLocalizedMessage();
    }

    public VvPushAdapter() {
        this.mHandler = new Handler(Looper.getMainLooper());
        this.appStatusHasChanged = false;
        this.hasShown = false;
        this.DIALOG_SHOW_TIME_OUT = 2000;
        this.SUCCESS = "success";
    }

    public static boolean hasTryRegistered() {
        return sHasRegistered;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_vv_VvPushAdapter_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r3) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r2 = access$001(r3);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r3);
    L12:
        throw th;
    L34:
        Class r4 = access$001(r3);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L17
    L16:
        return r4;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r3);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r3);
    }

    public static /* synthetic */ Handler access$000(VvPushAdapter r0) {
        return r0.mHandler;
    }

    public static /* synthetic */ boolean access$400(VvPushAdapter r0) {
        return r0.appStatusHasChanged;
    }

    public static /* synthetic */ boolean access$500(VvPushAdapter r0) {
        return r0.hasShown;
    }

    private void requestNotificationOfficial(k r6) {
        PushSupporter.logger().d(TAG, "requestNotificationOfficial");
        Application r0 = AppProvider.getApp();
        Activity r2 = ActivityLifecycleObserver.getIns().getTopActivity();     // Catch: Exception -> L5
        PushClient.getInstance(r0).isNotifyGuideDialogAllowed(r2, new j(r0, r2, r6));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        f.f(TAG, "requestNotificationOfficial error ", e);
        if (r6 == null) goto L12;
        ((g) r6).a(false);
        return;
    }

    public static /* synthetic */ boolean access$402(VvPushAdapter r0, boolean r1) {
        r0.appStatusHasChanged = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$502(VvPushAdapter r0, boolean r1) {
        r0.hasShown = r1;
        return r1;
    }

    public static void sendToken(Context r3, String r4) {
        if (r3 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r4) == true) goto L10;
        f.b(TAG, "[sendToken]hasSendValidToken:" + hasSendValidToken);
        if (hasSendValidToken == true) goto L13;
        hasSendValidToken = true;
        PushSupporter.thirdService().registerSenderSuccessAndUploadToken(r3, getVvPush(), r4);
        return;
    L13:
        return;
    L10:
        if (PushSupporter.thirdService().isMainProcess(r3) == false) goto L15;
        PushSupporter.monitor().monitorRegisterSenderFailed(getVvPush(), 102, "0", "token is empty");
        return;
    }

    public boolean checkThirdPushConfig(String r3, Context r4) throws Exception {
        PushClient.getInstance(r4).checkManifest();     // Catch: VivoPushException -> L5
        return true;
    L5:
        e = move-exception;
        f.e(r3, "VivoPush Errcode = " + e.getCode() + " " + e.getMessage());
        e.printStackTrace();
        return false;
    }

    public boolean deleteProfileId(Context r14, String r15) {
        long r5 = System.currentTimeMillis();
        int r3 = PushClient.getInstance(r14).isSupportSyncProfileInfo();     // Catch: Throwable -> L20
        PushSupporter.logger().i(TAG, "[deleteProfileId]supportProfile:" + r3 + " profileId:" + r15);     // Catch: Throwable -> L20
        String r2 = null;
        if (r3 != 0) goto L18;
        CountDownLatch r4 = new CountDownLatch(1);     // Catch: Throwable -> L20
        Boolean[] r6 = {null};     // Catch: Throwable -> L20
        String[] r7 = {""};     // Catch: Throwable -> L20
        PushClient.getInstance(r14).deleteProfileId(r15, new f(r6, r4, r7));     // Catch: Throwable -> L20
        r4.await(10000, TimeUnit.MILLISECONDS);     // Catch: InterruptedException -> L8 Throwable -> L20
    L10:
        Boolean r16 = r6[0];     // Catch: Throwable -> L20
        if (r16 != null) goto L13;
        int r17 = 4;
    L19:
        String r8 = r2;
    L22:
        onDeleteProfileIdResult(getVvPush(), r5, r17, r8);
        if (r17 != 1) goto L30;
        return true;
    L30:
        return false;
    L13:
        if (r16.booleanValue() == false) goto L15;
        r17 = 1;
        goto L19
    L15:
        f.b(TAG, "error msg is :" + r7[0]);     // Catch: Throwable -> L20
        r2 = r7[0];     // Catch: Throwable -> L20
        r17 = 6;
        goto L19
    L8:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L20
        goto L10
    L18:
        r17 = 3;
    L20:
        th = move-exception;
        r8 = th.getLocalizedMessage();
        r17 = 5;
        goto L22
    }

    public String isBusinessAlertDialogAvailable(Context r1, boolean r2) {
        if (isPushAvailable(r1, VV_PUSH) == true) goto L6;
        f.g(TAG, "[isBusinessAlertDialogAvailable]return false because push is not available");
        return "push is not available";
    L6:
        com.ss.android.pushmanager.setting.b.b().getClass();
        if (com.ss.android.pushmanager.setting.b.d().H() == true) goto L10;
        f.g(TAG, "[isBusinessAlertDialogAvailable]return false because enableVvBusinessNotificationDialog is false");
        return "enableVvBusinessNotificationDialog is false";
    L10:
        f.g(TAG, "[isBusinessAlertDialogAvailable]return true");
        return "1";
    }

    public boolean isPushAvailable(Context r5, int r6) {
        if (Build.VERSION.SDK_INT < 23) goto L25;
        String r7 = Build.BRAND;
        if (TextUtils.isEmpty(r7) == false) goto L7;
    L9:
        String r8 = Build.MODEL;
        if (TextUtils.isEmpty(r8) == false) goto L12;
    L14:
        String r9 = Build.MANUFACTURER;
        if (TextUtils.isEmpty(r9) == false) goto L17;
    L19:
        boolean r10 = false;
    L20:
        if (r10 == true) goto L22;
        return false;
    L22:
        if (PushClient.getInstance(r5.getApplicationContext()).isSupport() == false) goto L27;
        return true;
    L27:
        return false;
    L17:
        if (r9.toLowerCase().contains("vivo") == false) goto L19;
    L8:
        r10 = true;
        goto L20
    L12:
        if (r8.toLowerCase().contains("vivo") == false) goto L14;
    L7:
        if (r7.toLowerCase().contains("vivo") == false) goto L9;
    L25:
        return false;
    }

    public void registerPush(Context r5, int r6) {
        PushSupporter.logger().i(TAG, "registerVivoPush");     // Catch: Exception -> L8
        if (PushSupporter.logger().debug() == false) goto L6;
        PushClient.getInstance(r5).checkManifest();     // Catch: Exception -> L8
    L6:
        sHasRegistered = true;     // Catch: Exception -> L8
        PushClient.getInstance(r5.getApplicationContext()).initialize(new PushConfig.Builder().agreePrivacyStatement(true).build());     // Catch: Exception -> L8
        PushClient.getInstance(r5).turnOnPush(new a(this, r6, r5));     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        PushSupporter.logger().e(TAG, "error when register vv push ", e);
        e.printStackTrace();
    }

    public boolean setProfileId(Context r18, String r19) {
        long r5 = System.currentTimeMillis();
        int r3 = PushClient.getInstance(r18).isSupportSyncProfileInfo();     // Catch: Throwable -> L21
        PushSupporter.logger().i(TAG, "[setProfileId]supportProfile:" + r3 + " profileId len:" + r19.length() + " profileId：" + r19);     // Catch: Throwable -> L21
        if (r3 != 0) goto L18;
        CountDownLatch r4 = new CountDownLatch(1);     // Catch: Throwable -> L21
        Boolean[] r7 = {null};     // Catch: Throwable -> L21
        String[] r8 = {""};     // Catch: Throwable -> L21
        PushThreadHandlerManager.inst().postRunnable(new e(r18, r19, r7, r4, r8));     // Catch: Throwable -> L21
        r4.await(10000, TimeUnit.MILLISECONDS);     // Catch: InterruptedException -> L8 Throwable -> L21
    L10:
        Boolean r0 = r7[0];     // Catch: Throwable -> L21
        if (r0 != null) goto L13;
        int r1 = 4;
    L19:
        String r6 = null;
    L20:
        String r9 = r6;
    L23:
        f.b(TAG, "onSetProfileIdResult,resultStatus:" + r1 + " extra:" + r9);
        onSetProfileIdResult(getVvPush(), r5, r1, r9);
        if (r1 != 1) goto L31;
        return true;
    L31:
        return false;
    L13:
        if (r0.booleanValue() == false) goto L15;
        r1 = 1;
        goto L19
    L15:
        f.b(TAG, "error msg is :" + r8[0]);     // Catch: Throwable -> L21
        r6 = r8[0];     // Catch: Throwable -> L21
        r1 = 6;
        goto L20
    L8:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L21
        goto L10
    L18:
        r1 = 3;
    L21:
        th = move-exception;
        r9 = th.getLocalizedMessage();
        r1 = 5;
        goto L23
    }

    public void unregisterPush(Context r2, int r3) {
        PushClient.getInstance(r2).turnOffPush(new d());     // Catch: Throwable -> L4
        PushSupporter.logger().i(TAG, "unregisterPush");     // Catch: Throwable -> L4
        return;
    }

    private void onUserClickResult(String r3, boolean r4, RequestResultCallback r5) {
        f.g(TAG, "on request vv notification permission result,report click event,hasAgree:" + r4);
        PushThreadHandlerManager.inst().postRunnable(new b(r3, r4, r5));
    }

    private void setComponentStatus(Context r5, Class r6, boolean r7) {
        ComponentName r0 = new ComponentName(r5, r6);
        PushSupporter.logger().i(TAG, "set " + r6.getName() + " to:" + r7);
        PackageManager r8 = r5.getPackageManager();
        if (r7 == false) goto L5;
        int r9 = 1;
    L11:
        r8.setComponentEnabledSetting(r0, r9, 1);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        return;
    L5:
        r9 = 2;
        goto L11
    }

    public void setAlias(Context r4, String r5, int r6) {
        PushSupporter.logger().i(TAG, "setAlias alias = " + r5);     // Catch: Throwable -> L5
        PushClient.getInstance(r4).bindAlias(r5, new c());     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
    }

    public static /* synthetic */ void access$200(VvPushAdapter r0, String r1, boolean r2, RequestResultCallback r3) {
        r0.onUserClickResult(r1, r2, r3);
    }

    private void requestNotificationHook(String r11, int r12, int r13, RequestResultCallback r14) {
        Application r5 = AppProvider.getApp();
        if (this.hasShown == false) goto L5;
        f.e(TAG, "can't requestNotificationPermission because cur has showing");
    L5:
        this.hasShown = true;
        this.appStatusHasChanged = false;
        ((b) this).hasCallbackShowResult = false;
        d.a().addObserver(new h(this, r11, r12, r14, r5));
        String r6 = requestNotificationInternal();
        if (TextUtils.equals(r6, "success") == true) goto L8;
        onGuideRequestResult(r11, r12, "vv", false, r6, r14);
        this.hasShown = false;
        return;
    L8:
        f.b(TAG, "backup detect dialog show result after 2000");
        PushThreadHandlerManager.inst().postRunnable(new i(this, r11, r12, r14), 2000);
    }

    public synchronized boolean requestNotificationPermission(String r12, int r13, int r14, RequestResultCallback r15) {
        monitor-enter(this);
        PushSupporter.logger().d(TAG, "[requestNotificationPermission]");     // Catch: Throwable -> L31
        if (r13 == getVvPush()) goto L10;
        f.e(TAG, "invalid push_type:" + r13);     // Catch: Throwable -> L31
        onGuideRequestResult(r12, r13, "vv", false, "invalid push_type:" + r13, r15);     // Catch: Throwable -> L31
        monitor-exit(this);
        return false;
    L10:
        if (ToolUtils.areNotificationsEnabled(AppProvider.getApp()) != 1) goto L15;
        f.e(TAG, "cur notification are enabled,needn't request");     // Catch: Throwable -> L31
        onGuideRequestResult(r12, r13, "vv", false, "cur notification are enabled,needn't request", r15);     // Catch: Throwable -> L31
        monitor-exit(this);
        return false;
    L15:
        if (ActivityLifecycleObserver.getIns().getTopActivity() != null) goto L19;
        f.e(TAG, "can't requestNotificationPermission on vv device because topActivity is null");     // Catch: Throwable -> L31
        onGuideRequestResult(r12, r13, "vv", false, "topActivity is null,app is not in the foreground!", r15);     // Catch: Throwable -> L31
        monitor-exit(this);
        return false;
    L19:
        ((b) this).hasCallbackShowResult = false;     // Catch: Throwable -> L31
        ((b) this).hasCallbackClickResult = false;     // Catch: Throwable -> L31
        int r0 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L31
        if (r0 < 30) goto L25;
        if (r0 > 32) goto L25;
        requestNotificationHook(r12, r13, r14, r15);     // Catch: Throwable -> L31
    L29:
        monitor-exit(this);
        return true;
    L25:
        if (r0 < 28) goto L29;
        if (isPushServiceAvailable().booleanValue() == false) goto L29;
        requestNotificationOfficial(new g(this, r12, r13, r15));     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        throw th;
    }

    @Skip({"com.obric.assistant.interaction.impl.performance"})
    public static boolean INVOKEINTERFACE_com_vv_VvPushAdapter_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r15, int r16, Parcel r17, Parcel r18, int r19) throws RemoteException {
        if (Looper.myLooper() != Looper.getMainLooper()) goto L5;
        long r2 = SystemClock.uptimeMillis();
        boolean r0 = r15.transact(r16, r17, r18, r19);     // Catch: Throwable -> L12
        long r8 = SystemClock.uptimeMillis() - r2;
        if (r8 < 100) goto L11;
        BinderPerformanceReporter.report(r8, r15.getClass().getName(), r16, r19, new Throwable("Slow main-thread Binder transaction"));
    L11:
        return r0;
    L12:
        th = move-exception;
        long r9 = SystemClock.uptimeMillis() - r2;
        if (r9 < 100) goto L22;
        if (r15 != null) goto L17;
        String r1 = "";
    L18:
        BinderPerformanceReporter.report(r9, r1, r16, r19, new Throwable("Slow main-thread Binder transaction"));
        throw th;
    L17:
        r1 = r15.getClass().getName();
        goto L18
    L22:
        throw th;
    L5:
        return r15.transact(r16, r17, r18, r19);
    }

    public static /* synthetic */ void access$100(VvPushAdapter r0, String r1, int r2, String r3, boolean r4, String r5, RequestResultCallback r6) {
        r0.onGuideRequestResult(r1, r2, r3, r4, r5, r6);
    }

    public static /* synthetic */ void access$300(VvPushAdapter r0, String r1, int r2, String r3, boolean r4, String r5, RequestResultCallback r6) {
        r0.onGuideRequestResult(r1, r2, r3, r4, r5, r6);
    }

    public static /* synthetic */ void access$600(VvPushAdapter r0, String r1, int r2, String r3, boolean r4, String r5, RequestResultCallback r6) {
        r0.onGuideRequestResult(r1, r2, r3, r4, r5, r6);
    }

    public static /* synthetic */ void access$700(VvPushAdapter r0, String r1, int r2, String r3, boolean r4, String r5, RequestResultCallback r6) {
        r0.onGuideRequestResult(r1, r2, r3, r4, r5, r6);
    }

    public static /* synthetic */ void access$800(VvPushAdapter r0, String r1, int r2, String r3, boolean r4, String r5, RequestResultCallback r6) {
        r0.onGuideRequestResult(r1, r2, r3, r4, r5, r6);
    }
}
