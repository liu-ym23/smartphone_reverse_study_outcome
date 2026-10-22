package com.obric.sva.sdk.utils;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.graphics.BlurMaskFilter;
import android.media.AudioRecord;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.os.UserHandle;
import android.os.UserManager;
import android.provider.Settings;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.common.apphost.AppHost;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.obric.capabilitykit.PackageUtils;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.obric.sva.sdk.controller.Global;
import com.obric.sva.sdk.controller.HotwordRecorderMgr;
import com.obric.sva.sdk.effectplatform.EffectConstant;
import com.obric.sva.sdk.sami.SamiPhoneEnrollManager;
import com.obric.sva.sdk.sami.SamiWakeupParamProvider;
import com.obric.sva.sdk.service.WakeupService;
import com.obric.sva.sdk.session.IWakeupSessionConstant;
import com.obric.sva.sdk.session.SessionType;
import el9.a;
import java.io.Closeable;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import me.ele.lancet.base.annotations.Skip;
import t9a.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\u0018\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0005H\u0007J\u0010\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\u0010\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\u0010\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J \u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0005H\u0007J\u0012\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0005H\u0007J\u0010\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u001eH\u0007J\u0010\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u0005H\u0007J\u0010\u0010\"\u001a\u00020\u00052\u0006\u0010$\u001a\u00020%H\u0007J\u0014\u0010&\u001a\u00020\u0010*\u00020'2\u0006\u0010(\u001a\u00020)H\u0007J\f\u0010*\u001a\u00020\u0010*\u00020'H\u0007J\u000e\u0010+\u001a\u00020,2\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010-\u001a\u00020,2\u0006\u0010\u0011\u001a\u00020\u0012J\b\u0010.\u001a\u00020\u0005H\u0002J\u0010\u0010/\u001a\u00020,2\u0006\u0010\u0011\u001a\u00020\u0012H\u0007JB\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u0002052\b\b\u0002\u00106\u001a\u00020,2\u001e\u00107\u001a\u001a\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020\u001008H\u0007J\u0013\u00109\u001a\u00020\u0005*\u0004\u0018\u00010:H\u0007¢\u0006\u0002\u0010;J\u000e\u0010<\u001a\u00020\u0010*\u0004\u0018\u00010=H\u0007J\u0017\u0010>\u001a\u00020\u0010*\b\u0012\u0004\u0012\u00020@0?H\u0007¢\u0006\u0002\u0010AJ+\u0010B\u001a\u00020\u00102\u001c\u0010C\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100E\u0012\u0006\u0012\u0004\u0018\u00010\u00010DH\u0007¢\u0006\u0002\u0010FJ\b\u0010I\u001a\u00020,H\u0007J\b\u0010J\u001a\u000205H\u0007J\b\u0010K\u001a\u000205H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0019\u0010\u0007\u001a\n \b*\u0004\u0018\u00010\u00050\u00058F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\n\"\u0004\b\r\u0010\u000eR\u0011\u0010G\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\bH\u0010\n¨\u0006L"}, d2 = {"Lcom/obric/sva/sdk/utils/KtUtils;", "", "<init>", "()V", "TAG", "", "GENESIS_R", "now", "kotlin.jvm.PlatformType", "getNow", "()Ljava/lang/String;", "sProcessName", "getSProcessName", "setSProcessName", "(Ljava/lang/String;)V", "onAccountLogout", "", "context", "Landroid/content/Context;", "onEnterpriseAccountLogout", "onAccountBecomeActive", "newUid", "onAccountSwitchAway", "onAccountLogin", "reloadSamiCore", "Flogger", "name", "tag", "msg", "findSessionTypeBySmName", "Lcom/obric/sva/sdk/session/SessionType;", IWakeupSessionConstant.KEY_EXTRA_SM_NAME, "findSmNameBySessionType", "sessionType", "md5", "filePath", "stream", "Ljava/io/InputStream;", "setBlur", "Landroid/widget/TextView;", "radius", "", "clearBlur", "isMainProcess", "", "isWakeupProcess", "getCurProcessName", "isDozeModeEnable", "readBuffer", "", "audioRecord", "Landroid/media/AudioRecord;", "targetLength", "", "onlyCache", "action", "Lkotlin/Function3;", "short", "", "(Ljava/lang/Double;)Ljava/lang/String;", "closeQuitely", "Ljava/io/Closeable;", "closeAll", "", "Landroid/os/ParcelFileDescriptor;", "([Landroid/os/ParcelFileDescriptor;)V", "runInIo", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "(Lkotlin/jvm/functions/Function1;)V", "platformName", "getPlatformName", "isMainUser", "myUserId", "myPid", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class KtUtils {
    private static final String GENESIS_R = "genesis-r";
    public static final KtUtils INSTANCE = null;
    public static final String TAG = "KtUtils";
    private static String sProcessName;

    private KtUtils() {
    }

    public static /* synthetic */ Class access$000(String r0) throws ClassNotFoundException {
        return Class.forName(r0);
    }

    @JvmStatic
    public static final int myUserId() {
        Method r1 = UserHandle.class.getDeclaredMethod("myUserId", new Class[0]);     // Catch: Exception -> L5
        r1.setAccessible(true);     // Catch: Exception -> L5
        Object r2 = r1.invoke(null, new Object[0]);     // Catch: Exception -> L5
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type kotlin.Int");     // Catch: Exception -> L5
        int r3 = ((Integer) r2).intValue();     // Catch: Exception -> L5
    L6:
        LogUtils.d(TAG, "myUserId " + r3, new Object[0]);
        return r3;
    L5:
        r3 = Process.myUid() / 100000;
        goto L6
    }

    static {
        INSTANCE = new KtUtils();
        sProcessName = "";
    }

    private final String getCurProcessName() {
        boolean r1 = true;
        if (sProcessName.length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        return sProcessName;
    L10:
        if (Build.VERSION.SDK_INT < 28) goto L16;
        String r2 = Application.getProcessName();
        if (r2 != null) goto L14;
        r2 = "";
    L14:
        sProcessName = r2;
    L16:
        if (sProcessName.length() > 0) goto L19;
        r1 = false;
    L19:
        if (r1 == true) goto L21;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L36
        InputStreamReader r4 = new InputStreamReader(new PolarisFileInputStreamWrapper("/proc/self/cmdline"));     // Catch: Throwable -> L36
        StringBuilder r5 = new StringBuilder();     // Catch: Throwable -> L31
    L24:
        int r6 = r4.read();     // Catch: Throwable -> L31
        if (r6 <= 0) goto L27;
        r5.append((char) r6);     // Catch: Throwable -> L31
        goto L24
    L27:
        String r7 = r5.toString();     // Catch: Throwable -> L31
    L29:
        CloseableKt.closeFinally(r4, null);     // Catch: Throwable -> L36
        Object r8 = Result.constructor-impl(r7);     // Catch: Throwable -> L36
    L39:
        if (Result.isSuccess-impl(r8) == false) goto L41;
        sProcessName = (String) r8;
    L41:
        Throwable r9 = Result.exceptionOrNull-impl(r8);
        if (r9 == null) goto L45;
        LogUtils.e(TAG, "getCurProcessName failed: " + r9.getMessage(), new Object[0]);
    L45:
        return sProcessName;
    L31:
        th = move-exception;
        throw th;     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        CloseableKt.closeFinally(r4, th);     // Catch: Throwable -> L36
        throw th;     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L39
    L21:
        return sProcessName;
    L5:
        r0 = false;
        goto L6
    }

    @JvmStatic
    public static final boolean isMainUser() {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 23) goto L5;
        UserManager r2 = (UserManager) ContextCompat.getSystemService(AppHost.a.getApplication(), UserManager.class);
    L10:
        if (r0 < 23) goto L14;
        if (r2 == null) goto L13;
        boolean r1 = r2.isSystemUser();
    L15:
        LogUtils.d(TAG, "isMainUser? " + r1, new Object[0]);
        return r1;
    L13:
        r1 = true;
        goto L15
    L14:
        r1 = false;
        goto L15
    L5:
        Object r3 = AppHost.a.getApplication().getSystemService("user");
        if ((r3 instanceof UserManager) == false) goto L8;
        r2 = (UserManager) r3;
        goto L10
    L8:
        r2 = null;
        goto L10
    }

    public final String getNow() {
        return new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Long.valueOf(System.currentTimeMillis()));
    }

    @JvmStatic
    public static final int myPid() {
        int r0 = Process.myPid();
        LogUtils.d(TAG, "myPid " + r0, new Object[0]);
        return r0;
    }

    public final String getPlatformName() {
        String r0 = b.a().d();
        LogUtils.d(TAG, "@platform name@ is " + r0, new Object[0]);
        if (Intrinsics.areEqual(r0.toLowerCase(Locale.ROOT), GENESIS_R) == true) goto L7;
        return "default";
    L7:
        return GENESIS_R;
    }

    public final String getSProcessName() {
        return sProcessName;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_obric_sva_sdk_utils_KtUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r3) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r2 = access$000(r3);     // Catch: Throwable -> L8
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
        Class r4 = access$000(r3);     // Catch: Throwable -> L17
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

    @JvmStatic
    public static final void clearBlur(TextView r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        LogUtils.i(TAG, "setBlur radius : clear", new Object[0]);
        r3.getPaint().setMaskFilter(null);
        r3.postInvalidate();
    }

    @JvmStatic
    public static final void closeAll(ParcelFileDescriptor[] r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        int r0 = r3.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        closeQuitely(r3[r1]);
        r1 = r1 + 1;
        goto L3
    }

    @JvmStatic
    public static final void closeQuitely(Closeable r0) {
        if (r0 == null) goto L10;
        r0.close();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    @JvmStatic
    public static final SessionType findSessionTypeBySmName(String r4) {
        if (r4 == null) goto L4;
        SessionType r0 = Global.sSessionTypeMap.get(r4);
        if (r0 == null) goto L9;
        return r0;
    L9:
        if (StringsKt.contains$default(r4, "breath", false, 2, null) == false) goto L12;
        return SessionType.BREATH;
    L12:
        return SessionType.VOICE;
    L4:
        return SessionType.VOICE;
    }

    @JvmStatic
    public static final String findSmNameBySessionType(SessionType r4) {
        Intrinsics.checkNotNullParameter(r4, "sessionType");
        Map<String, SessionType> r0 = Global.sSessionTypeMap;
        LinkedHashMap r1 = new LinkedHashMap();
        Iterator<Map.Entry<String, SessionType>> r2 = r0.entrySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L11;
        Map.Entry<String, SessionType> r3 = r2.next();
        if (r3.getValue() != r4) goto L8;
        boolean r5 = true;
    L9:
        if (r5 == false) goto L4;
        r1.put(r3.getKey(), r3.getValue());
        goto L4
    L8:
        r5 = false;
        goto L9
    L11:
        String r6 = (String) CollectionsKt.firstOrNull(r1.keySet());
        if (r6 != null) goto L20;
        return "";
    L20:
        return r6;
    }

    @JvmStatic
    public static final boolean isDozeModeEnable(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        if (Settings.Secure.getInt(r2.getContentResolver(), "doze_always_on", 0) != 1) goto L6;
        return true;
    L6:
        return false;
    }

    @JvmStatic
    public static final String md5(String r12) {
        Intrinsics.checkNotNullParameter(r12, "filePath");
        if (rna.c.c(r12) == true) goto L6;
        LogUtils.e(TAG, "md5 : file not exist", new Object[0]);
        return "";
    L6:
        PolarisFileWrapper r0 = new PolarisFileWrapper(r12);
        PolarisFileInputStreamWrapper r4 = new PolarisFileInputStreamWrapper(r12);     // Catch: Exception -> L16
        MessageDigest r13 = MessageDigest.getInstance("MD5");     // Catch: Exception -> L16
        byte[] r5 = new byte[8192];     // Catch: Exception -> L16
    L8:
        int r6 = r4.read(r5);     // Catch: Exception -> L16
        if (r6 == (-1)) goto L11;
        r13.update(r5, 0, r6);     // Catch: Exception -> L16
        goto L8
    L11:
        byte[] r14 = r13.digest();     // Catch: Exception -> L16
        Intrinsics.checkNotNull(r14);     // Catch: Exception -> L16
        int r7 = r14.length;     // Catch: Exception -> L16
        String r8 = "";
        int r9 = 0;
    L12:
        if (r9 >= r7) goto L14;
        r8 = r8 + String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(r14[r9])}, 1));     // Catch: Exception -> L16
        r9 = r9 + 1;     // Catch: Exception -> L16
        goto L12
    L14:
        r4.close();     // Catch: Exception -> L16
        LogUtils.e(TAG, "md5 : [" + r8 + "] of file " + r0.getName(), new Object[0]);     // Catch: Exception -> L16
        return r8;
    L16:
        e = move-exception;
        e.printStackTrace();
        return "";
    }

    @JvmStatic
    public static final void onAccountLogin(Context r7) {
        Intrinsics.checkNotNullParameter(r7, "context");
        String[] r0 = rna.b.j(r7.getApplicationContext());
        boolean r3 = true;
        if (r0[0].length() <= 0) goto L5;
        boolean r2 = true;
    L6:
        String r5 = "";
        if (r2 == true) goto L9;
    L14:
        String r1 = "";
    L16:
        if (r1.length() == 0) goto L20;
        r3 = false;
    L20:
        if (r3 == false) goto L22;
        LogUtils.d(TAG, "empty uid or did", new Object[0]);
    L22:
        Intrinsics.checkNotNullParameter(r1, "uuid");
        if (rna.b.k(StringsKt.substringBefore(r1, '-', ""), StringsKt.substringAfter(r1, '-', "")) == false) goto L25;
        r5 = r1;
    L26:
        rna.b.a = r5;
        LogUtils.i(TAG, "onLogin , cache uid/did and broadcast model download intent", new Object[0]);
        Intent r4 = new Intent();
        r4.setAction(EffectConstant.USER_LOGIN_INTENT);
        r4.setPackage(PackageUtils.NOVA_PKG_NAME);
        r7.sendBroadcast(r4);
        return;
    L25:
        rna.b.l(r1);
        goto L26
    L9:
        if (r0[1].length() <= 0) goto L11;
        boolean r6 = true;
    L12:
        if (r6 == false) goto L14;
        r1 = r0[0] + '-' + r0[1];
        goto L16
    L11:
        r6 = false;
        goto L12
    L5:
        r2 = false;
        goto L6
    }

    @JvmStatic
    public static final void onAccountLogout(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        LogUtils.i(TAG, "onLogout, destroy wakeup service samicore, and set wakeup status to OFF", new Object[0]);
        Global.sWakeupStatus = false;
        Global.setBreathStatus(false);
        sna.f.c(Global.SETTINGS_VOICE_ASSISTANT_WAKEUP_STATUS, -1);
        sna.f.c("breath_wakeup_status", -1);
        Intent r1 = new Intent();
        r1.setAction(Global.DESTROY_SAMICORE_ACTIVITY_ACTION);
        r1.setPackage(PackageUtils.NOVA_PKG_NAME);
        r1.setClass(r4, WakeupService.class);
        r4.startService(r1);
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L5
        SamiPhoneEnrollManager.INSTANCE.releasePhoneEnrollHandle("personal_logout");     // Catch: Throwable -> L5
        Object r6 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r7 = Result.exceptionOrNull-impl(r6);
        if (r7 == null) goto L13;
        LogUtils.e(TAG, "onAccountLogout release phone enroll handle failed: " + r7.getMessage(), new Object[0]);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    @JvmStatic
    public static final void onAccountSwitchAway(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        LogUtils.i(TAG, "onAccountSwitchAway: release phone enroll handle only", new Object[0]);
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        SamiPhoneEnrollManager.INSTANCE.releasePhoneEnrollHandle("switch_away");     // Catch: Throwable -> L5
        Object r1 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r2 = Result.exceptionOrNull-impl(r1);
        if (r2 == null) goto L13;
        LogUtils.e(TAG, "onAccountSwitchAway release handle failed: " + r2.getMessage(), new Object[0]);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    @JvmStatic
    public static final void onEnterpriseAccountLogout(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        LogUtils.i(TAG, "onEnterpriseAccountLogout: release phone enroll handle only", new Object[0]);
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        SamiPhoneEnrollManager.INSTANCE.releasePhoneEnrollHandle("enterprise_logout");     // Catch: Throwable -> L5
        Object r1 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r2 = Result.exceptionOrNull-impl(r1);
        if (r2 == null) goto L13;
        LogUtils.e(TAG, "onEnterpriseAccountLogout release handle failed: " + r2.getMessage(), new Object[0]);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    @JvmStatic
    public static final void reloadSamiCore(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        LogUtils.i(TAG, "reloadSamiCore: send RELOAD_SAMICORE_ACTIVITY_ACTION", new Object[0]);
        Intent r0 = new Intent();
        r0.setAction(Global.RELOAD_SAMICORE_ACTIVITY_ACTION);
        r0.setPackage(PackageUtils.NOVA_PKG_NAME);
        r0.setClass(r3, WakeupService.class);
        r3.startService(r0);
    }

    @JvmStatic
    public static final void runInIo(Function1<? super Continuation<? super Unit>, ? extends Object> r7) {
        Intrinsics.checkNotNullParameter(r7, "block");
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new runInIo.1(r7, null), 3, null);
    }

    @JvmStatic
    /* JADX INFO: renamed from: short, reason: not valid java name */
    public static final String m18short(Double r3) {
        if (r3 != null) goto L5;
        return "nil";
    L5:
        StringCompanionObject r0 = StringCompanionObject.INSTANCE;
        return String.format("%.5f", Arrays.copyOf(new Object[]{r3}, 1));
    }

    public final boolean isMainProcess(Context r6) {
        Intrinsics.checkNotNullParameter(r6, "context");
        String r0 = getCurProcessName();
        if (StringsKt.contains$default(r0, ":", false, 2, null) == false) goto L6;
        return false;
    L6:
        return Intrinsics.areEqual(r0, r6.getPackageName());
    }

    public final boolean isWakeupProcess(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        return StringsKt.contains$default(getCurProcessName(), ":interactor", false, 2, null);
    }

    public final void setSProcessName(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        sProcessName = r2;
    }

    @JvmStatic
    public static final String md5(InputStream r10) {
        Intrinsics.checkNotNullParameter(r10, "stream");
        MessageDigest r1 = MessageDigest.getInstance("MD5");     // Catch: Exception -> L12
        byte[] r2 = new byte[8192];     // Catch: Exception -> L12
    L4:
        int r3 = r10.read(r2);     // Catch: Exception -> L12
        if (r3 == (-1)) goto L7;
        r1.update(r2, 0, r3);     // Catch: Exception -> L12
        goto L4
    L7:
        byte[] r4 = r1.digest();     // Catch: Exception -> L12
        Intrinsics.checkNotNull(r4);     // Catch: Exception -> L12
        int r5 = r4.length;     // Catch: Exception -> L12
        String r6 = "";
        int r7 = 0;
    L8:
        if (r7 >= r5) goto L10;
        r6 = r6 + String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(r4[r7])}, 1));     // Catch: Exception -> L12
        r7 = r7 + 1;     // Catch: Exception -> L12
        goto L8
    L10:
        r10.close();     // Catch: Exception -> L12
        LogUtils.e(TAG, "md5 : [" + r6 + ']', new Object[0]);     // Catch: Exception -> L12
        return r6;
    L12:
        e = move-exception;
        e.printStackTrace();
        return "";
    }

    @JvmStatic
    public static final void onAccountBecomeActive(Context r7, String r8) {
        String r0 = "";
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r8, "newUid");
        LogUtils.i(TAG, "onAccountBecomeActive newUidLen=" + r8.length(), new Object[0]);
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        SamiPhoneEnrollManager.INSTANCE.releasePhoneEnrollHandle("account_active");     // Catch: Throwable -> L5
        Object r2 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r3 = Result.exceptionOrNull-impl(r2);
        if (r3 == null) goto L11;
        LogUtils.e(TAG, "onAccountBecomeActive release handle failed: " + r3.getMessage(), new Object[0]);
    L11:
        if (StringsKt.isBlank(r8) == false) goto L13;
        return;
    L13:
        Context r4 = r7.getApplicationContext();
        Intrinsics.checkNotNull(r4);     // Catch: Throwable -> L19
        String r5 = (String) ArraysKt.getOrNull(rna.b.j(r4), 1);     // Catch: Throwable -> L19
        if (r5 != null) goto L17;
        r5 = "";
    L17:
        Object r6 = Result.constructor-impl(r5);     // Catch: Throwable -> L19
    L21:
        Throwable r9 = Result.exceptionOrNull-impl(r6);
        if (r9 == null) goto L25;
        LogUtils.e(TAG, "onAccountBecomeActive get did failed: " + r9.getMessage(), new Object[0]);
    L25:
        if (Result.isFailure-impl(r6) == false) goto L27;
        r6 = "";
    L27:
        String r10 = (String) r6;
        if (StringsKt.isBlank(r10) == false) goto L31;
        LogUtils.w(TAG, "onAccountBecomeActive skip prepareBaseSnapshot: did blank", new Object[0]);
        return;
    L31:
        String r11 = r8 + '-' + r10;
        String r12 = rna.b.a;     // Catch: Throwable -> L42
        Intrinsics.checkNotNullParameter(r11, "uuid");     // Catch: Throwable -> L42
        if (r11 != null) goto L35;
        String r13 = "";
    L37:
        if (rna.b.k(StringsKt.substringBefore(r13, '-', ""), StringsKt.substringAfter(r13, '-', "")) == false) goto L39;
        r0 = r11;
    L40:
        rna.b.a = r0;     // Catch: Throwable -> L42
        Object r14 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L42
    L44:
        Throwable r15 = Result.exceptionOrNull-impl(r14);
        if (r15 == null) goto L55;
        LogUtils.e(TAG, "onAccountBecomeActive setUidAndDid failed: " + r15.getMessage(), new Object[0]);
    L55:
        SamiWakeupParamProvider.INSTANCE.prepareBaseSnapshot(r7, r11);     // Catch: Throwable -> L49
        Object r16 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L49
    L51:
        Throwable r17 = Result.exceptionOrNull-impl(r16);
        if (r17 == null) goto L63;
        LogUtils.e(TAG, "onAccountBecomeActive prepareBaseSnapshot failed: " + r17.getMessage(), new Object[0]);
        return;
    L63:
        return;
    L49:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L51
    L39:
        rna.b.l(r11);     // Catch: Throwable -> L42
        goto L40
    L35:
        r13 = r11;
    L42:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
    L19:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
    L5:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    @JvmStatic
    public static final void setBlur(TextView r3, float r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        LogUtils.i(TAG, "setBlur radius : [" + r4 + ']', new Object[0]);
        r3.getPaint().setMaskFilter(new BlurMaskFilter(r4, BlurMaskFilter.Blur.NORMAL));
        r3.postInvalidate();
    }

    @JvmStatic
    public static final void Flogger(String r7, String r8, String r9) {
        Intrinsics.checkNotNullParameter(r7, "name");
        Intrinsics.checkNotNullParameter(r8, "tag");
        Intrinsics.checkNotNullParameter(r9, "msg");
        Class r1 = INVOKESTATIC_com_obric_sva_sdk_utils_KtUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.larus.utils.logger.FLogger");     // Catch: Throwable -> L5
        Object r2 = r1.getDeclaredField("INSTANCE").get(null);     // Catch: Throwable -> L5
        r1.getMethod(r7, new Class[]{String.class, String.class}).invoke(r2, new Object[]{r8, r9});     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
        LogUtils.e(TAG, "Flogger error , use Sdk Logger", new Object[0]);
        LogUtils.e(TAG, r9, new Object[0]);
    }

    @JvmStatic
    public static final byte[] readBuffer(AudioRecord r7, int r8, boolean r9, Function3<? super Integer, ? super Integer, ? super byte[], Unit> r10) {
        Intrinsics.checkNotNullParameter(r7, "audioRecord");
        Intrinsics.checkNotNullParameter(r10, "action");
        byte[] r0 = new byte[r8];
        LogUtils.i(TAG, "readBuffer: onlyCache = " + r9, new Object[0]);
        if (HotwordRecorderMgr.ensureStarted(r7, SessionType.VOICE) == true) goto L6;
        LogUtils.d(TAG, "readBuffer: startRecording failed before first read", new Object[0]);
        return r0;
    L6:
        int r1 = 0;
    L7:
        if (r1 >= r8) goto L20;
        if (r7.getRecordingState() == 1) goto L20;
        if ((r1 + r8) <= r8) goto L13;
        int r3 = r8 - r1;
    L14:
        int r4 = r7.read(r0, r1, r3);
        if (r4 < 0) goto L16;
        r10.invoke(Integer.valueOf(r1), Integer.valueOf(r4), r0);
        r1 = r1 + r4;
        if (r9 == false) goto L7;
        if (r4 != 0) goto L7;
    L16:
        LogUtils.d(TAG, "startHotWordRecording: read failed!  error = " + r4, new Object[0]);
        goto L20
    L13:
        r3 = r8;
    L20:
        return r0;
    }

    public static /* synthetic */ byte[] readBuffer$default(AudioRecord r0, int r1, boolean r2, Function3 r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r2 = false;
    L6:
        return readBuffer(r0, r1, r2, r3);
    }
}
