package com.obric.assistant.state;

import android.app.Application;
import android.os.Build;
import android.os.Process;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.account.base.api.IAccountService;
import com.larus.account.base.api.ILoginService;
import com.larus.account.base.model.profile.AvatarInfo;
import com.larus.common.apphost.AppHost;
import com.larus.home.api.main.IPrivacyService;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.network.HttpConst;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.sharedstate.SharedState;
import com.obric.aiagent.sharedstate.log.SharedStateLogger;
import com.obric.assistant.account.IObricAccountService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import f09.a;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import me.ele.lancet.base.annotations.Skip;
import n38.j;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u00007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u000b*\u0001\u0007\b\u0007\u0018\u0000 %2\u00020\u0001:\u0001%B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\f\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\nH\u0002J\b\u0010\u000e\u001a\u00020\nH\u0002J\b\u0010\u000f\u001a\u00020\nH\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002J\u001f\u0010\u0014\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0011H\u0016¢\u0006\u0002\u0010\u0017J\u0018\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u0011H\u0016J\u001f\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u001bH\u0016¢\u0006\u0002\u0010\u001cJ\u0018\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001bH\u0016J\u001f\u0010\u001e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u001fJ\u0018\u0010 \u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u0005H\u0016J\u001a\u0010!\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0013H\u0016J\u0018\u0010\"\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u0013H\u0016J\b\u0010#\u001a\u00020\u0005H\u0002J\n\u0010$\u001a\u0004\u0018\u00010\u0013H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\b¨\u0006&"}, d2 = {"Lcom/obric/assistant/state/ShareStateServiceImpl;", "Lcom/obric/assistant/state/ISharedStateService;", "<init>", "()V", "initialized", "", "listener", "com/obric/assistant/state/ShareStateServiceImpl$listener$1", "Lcom/obric/assistant/state/ShareStateServiceImpl$listener$1;", "init", "", "initSharedSDKLogger", "prepareDoubaoData", "prepareDoubaoDataEarly", "updateAccountState", "clearAccountState", "getOsUserId", "", "getAccountTokenMapJsonStr", "", "getSharedStateInt", "key", "defaultValue", "(Ljava/lang/String;I)Ljava/lang/Integer;", "putSharedStateInt", "value", "getSharedStateLong", "", "(Ljava/lang/String;J)Ljava/lang/Long;", "putSharedStateLong", "getSharedStateBoolean", "(Ljava/lang/String;Z)Ljava/lang/Boolean;", "putSharedStateBoolean", "getSharedStateString", "putSharedStateString", "isMainProcess", "getProcessName", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShareStateServiceImpl implements ISharedStateService {
    public static final /* synthetic */ int d = 0;
    public boolean b;
    public final b c;

    public static final class b implements a.b {
        public b() {
        }

        public final void onAllActivityDestroyed() {
            FLogger.a.i("ISharedStateService", "onAllActivityDestroyed");
        }

        public final void onAppBackground() {
            FLogger.a.i("ISharedStateService", "onAppBackground");
            SharedState.INSTANCE.putBoolean("flow_app_background", true);
        }

        public final void onAppForeground() {
            FLogger.a.i("ISharedStateService", "onAppForeground");
            SharedState.INSTANCE.putBoolean("flow_app_background", false);
        }
    }

    public static final class c implements j {
        public final /* synthetic */ ShareStateServiceImpl a;

        public c(ShareStateServiceImpl r1) {
            this.a = r1;
        }

        public final void a(n38.a r4) {
            Intrinsics.checkNotNullParameter(r4, "event");
            ShareStateServiceImpl r5 = this.a;
            int r0 = ShareStateServiceImpl.d;
            r5.getClass();
            SharedState r6 = SharedState.INSTANCE;
            r6.putBoolean("doubao_login_state", false);
            r6.putString("doubao_account_uid", "");
            r6.putString("doubao_account_token", "");
            r6.putString("doubao_account_user_name", "");
            r6.putString("doubao_account_nick_name", "");
            r6.putString("doubao_account_avatar_url", "");
            r6.putString("doubao_account_token_map", "");
            r6.putBoolean("doubao_account_is_enterprise", false);
            r6.putString("doubao_account_personal_uid", "");
            FLogger.a.i("ISharedStateService", "clearAccountState");
        }

        public final void b(n38.a r2) {
            Intrinsics.checkNotNullParameter(r2, "event");
            ShareStateServiceImpl r3 = this.a;
            int r0 = ShareStateServiceImpl.d;
            r3.getClass();
            ShareStateServiceImpl.i();
        }
    }

    static {
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class g() throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r2 = Class.forName("android.os.UserHandle");     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.os.UserHandle");     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.os.UserHandle");
    L12:
        throw th;
    L34:
        Class<?> r3 = Class.forName("android.os.UserHandle");     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.os.UserHandle");     // Catch: Throwable -> L17
    L16:
        return r3;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("android.os.UserHandle");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("android.os.UserHandle");
    }

    public static boolean h() {
        if (Build.VERSION.SDK_INT < 28) goto L41;
        String r1 = Application.getProcessName();
        FLogger.a.i("ISharedStateService", "getProcessName " + r1);
        if (r1 == null) goto L41;
    L29:
        if (r1 != null) goto L32;
        return false;
    L32:
        if (StringsKt.contains$default(r1, ":", false, 2, null) == false) goto L35;
        FLogger.a.i("ISharedStateService", "isMainProcess contains :");
        return false;
    L35:
        boolean r0 = Intrinsics.areEqual(r1, AppHost.a.getApplication().getPackageName());
        FLogger.a.i("ISharedStateService", "isMainProcess " + r0);
        return r0;
    L41:
        PolarisFileWrapper r2 = new PolarisFileWrapper("/proc/" + Process.myPid() + "/cmdline");     // Catch: Throwable -> L27
        Reader r3 = new InputStreamReader(new PolarisFileInputStreamWrapper(r2), Charsets.UTF_8);     // Catch: Throwable -> L27
        if ((r3 instanceof BufferedReader) == false) goto L11;
        BufferedReader r4 = (BufferedReader) r3;     // Catch: Throwable -> L27
    L37:
        String r5 = StringsKt.trim(r4.readLine()).toString();     // Catch: Throwable -> L22
        CloseableKt.closeFinally(r4, null);     // Catch: Throwable -> L27
        if (r5.length() <= 0) goto L16;
        boolean r6 = true;
    L17:
        if (r6 == true) goto L19;
    L28:
        r1 = null;
        goto L29
    L19:
        if (StringsKt.contains$default(r5, 0, false, 2, null) == false) goto L21;
        r5 = StringsKt.substringBefore$default(r5, 0, null, 2, null);     // Catch: Throwable -> L27
    L21:
        r1 = r5;
        goto L29
    L16:
        r6 = false;
        goto L17
    L22:
        th = move-exception;
        throw th;     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        CloseableKt.closeFinally(r4, th);     // Catch: Throwable -> L27
        throw th;     // Catch: Throwable -> L27
    L11:
        r4 = new BufferedReader(r3, 8192);     // Catch: Throwable -> L27
    L27:
        FLogger.a.i("ISharedStateService", "getProcessName crash");
        goto L28
    }

    public static void i() {
        ILoginService.Companion r1 = ILoginService.a;
        q38.a r2 = r1.getAccountInfo();
        String r4 = null;
        if (r2.a == false) goto L5;
        r38.b r3 = IAccountService.a.getUserInfo();
    L6:
        boolean r5 = true;
        String r6 = "";
        if (r3 == null) goto L20;
        AvatarInfo r7 = r3.a();
        if (r7 == null) goto L20;
        String r8 = r7.a();
        if (r8 == null) goto L20;
        String r9 = StringsKt.trim(r8).toString();
        if (r9 == null) goto L20;
        if ((!StringsKt.isBlank(r9)) == true) goto L18;
        r9 = null;
    L18:
        if (r9 == null) goto L20;
    L33:
        SharedState r10 = SharedState.INSTANCE;
        r10.putBoolean("doubao_login_state", r2.a);
        r10.putString("doubao_account_uid", r2.c);
        r10.putString("doubao_account_token", r1.K());
        if (r3 == null) goto L37;
        String r11 = r3.g();
        if (r11 == null) goto L37;
    L38:
        r10.putString("doubao_account_user_name", r11);
        if (r3 == null) goto L42;
        String r12 = r3.d();
        if (r12 == null) goto L42;
    L43:
        r10.putString("doubao_account_nick_name", r12);
        r10.putString("doubao_account_avatar_url", r9);
        String r13 = new JSONObject().put("X-Tt-Token", r1.K()).put("sdk-version", "2").put("passport-sdk-version", 60592).toString();     // Catch: Throwable -> L46
    L48:
        if (r13 != null) goto L50;
        r13 = "";
    L50:
        r10.putString("doubao_account_token_map", r13);
        SharedState r14 = SharedState.INSTANCE;
        if (r2.a == true) goto L53;
    L55:
        r5 = false;
    L56:
        r14.putBoolean("doubao_account_is_enterprise", r5);
        IObricAccountService r15 = (IObricAccountService) ServiceManager.get().getService(IObricAccountService.class);
        if (r15 == null) goto L59;
        r4 = r15.a();
    L59:
        if (r4 == null) goto L62;
        r6 = r4;
    L62:
        r14.putString("doubao_account_personal_uid", r6);
        FLogger r16 = FLogger.a;
        StringBuilder r17 = new StringBuilder("updateAccountState: isLogin: ");
        r17.append(r2.a);
        r17.append(", userId: ");
        r17.append(r2.c);
        r17.append(", isEnterpriseAccount: ");
        r17.append(r2.g);
        r17.append(", personalUid: ");
        boolean r18 = com.obric.assistant.utils.j.a;
        if (r6.length() <= 8) goto L66;
        r6 = StringsKt.take(r6, 4) + StringsKt.repeat("*", r6.length() - 8) + StringsKt.takeLast(r6, 4);
    L66:
        r17.append(r6);
        r16.i("ISharedStateService", r17.toString());
        return;
    L53:
        if (r2.g == false) goto L55;
    L46:
        th = move-exception;
        FLogger.a.e("ISharedStateService", "getAccountTokenMapJsonStr: crash", th);
        r13 = null;
    L42:
        r12 = "";
    L37:
        r11 = "";
    L20:
        if (r3 == null) goto L30;
        AvatarInfo r19 = r3.a();
        if (r19 == null) goto L30;
        String r20 = r19.b();
        if (r20 == null) goto L30;
        r9 = StringsKt.trim(r20).toString();
        if (r9 == null) goto L30;
        if ((!StringsKt.isBlank(r9)) == false) goto L30;
    L31:
        if (r9 != null) goto L33;
        r9 = "";
    L30:
        r9 = null;
        goto L31
    L5:
        r3 = null;
        goto L6
    }

    public final void init() {
        SharedStateLogger r0 = SharedStateLogger.INSTANCE;
        r0.setLogger(new yga.c());
        AppHost.Companion r1 = AppHost.a;
        r0.setDebug(r1.isDebug());
        SharedState r2 = SharedState.INSTANCE;
        r2.init(r1.getApplication());
        FLogger r3 = FLogger.a;
        r3.i("ISharedStateService", "ISharedStateService init done " + Process.myPid());
        if (h() == true) goto L5;
        r3.i("ISharedStateService", "prepareDoubaoDataEarly not main process");
    L10:
        this.b = true;
        return;
    L5:
        r2.putString("doubao_channel", r1.getBuildChannel());
        IPrivacyService r4 = (IPrivacyService) ServiceManager.get().getService(IPrivacyService.class);
        if (r4 == null) goto L8;
        boolean r5 = r4.a();
    L9:
        r2.putBoolean("doubao_privacy_allowed", r5);
        goto L10
    L8:
        r5 = false;
        goto L9
    }

    public ShareStateServiceImpl() {
        this.c = new b();
    }

    public final void c() {
        if (h() == true) goto L7;
        FLogger.a.i("ISharedStateService", "prepareDoubaoData not main process");
        return;
    L7:
        if (this.b == true) goto L10;
        FLogger.a.i("ISharedStateService", "sdk not initialized");
        return;
    L10:
        AppHost.Companion r0 = AppHost.a;
        r0.a().j(this.c);
        boolean r1 = r0.a().isAppBackground();
        SharedState r2 = SharedState.INSTANCE;
        r2.putBoolean("flow_app_background", r1);
        ILoginService.a.f(new c(this), Boolean.FALSE);
        i();
        boolean r3 = false;
        Class r4 = g();     // Catch: Throwable -> L18
        Method r5 = r4.getDeclaredMethod("myUserId", new Class[0]);     // Catch: Throwable -> L18
        r5.setAccessible(true);     // Catch: Throwable -> L18
        Object r6 = r5.invoke(r4, new Object[0]);     // Catch: Throwable -> L18
        if ((r6 instanceof Integer) == false) goto L14;
        Integer r7 = (Integer) r6;     // Catch: Throwable -> L18
    L15:
        if (r7 == null) goto L20;
        int r8 = r7.intValue();     // Catch: Throwable -> L18
    L21:
        r2.putInt("doubao_os_user_id", r8);
        SharedState r9 = SharedState.INSTANCE;
        AppHost.Companion r10 = AppHost.a;
        r9.putInt("doubao_version_code", r10.getVersionCode());
        r9.putString("doubao_version_name", r10.getVersionName());
        r9.putInt("doubao_update_version_code", r10.getUpdateVersionCode());
        r9.putString("doubao_channel", r10.getBuildChannel());
        IPrivacyService r11 = (IPrivacyService) ServiceManager.get().getService(IPrivacyService.class);
        if (r11 == null) goto L24;
        r3 = r11.a();
    L24:
        r9.putBoolean("doubao_privacy_allowed", r3);
        HttpConst.a.getClass();
        r9.putString("doubao_privacy_url", HttpConst.M);
        return;
    L20:
        r8 = 0;
        goto L21
    L14:
        r7 = null;
    L18:
        th = move-exception;
        FLogger.a.e("ISharedStateService", "getOsUserId: crash", th);
        goto L20
    }

    public final Integer b(String r3) {
        Intrinsics.checkNotNullParameter(r3, "key");
        if (this.b == true) goto L7;
        FLogger.a.w("ISharedStateService", "sdk not initialized");
        return null;
    L7:
        return Integer.valueOf(SharedState.INSTANCE.getInt(r3, -1));
    }

    public final Boolean e(String r3) {
        Intrinsics.checkNotNullParameter(r3, "key");
        if (this.b == true) goto L7;
        FLogger.a.w("ISharedStateService", "sdk not initialized");
        return null;
    L7:
        return Boolean.valueOf(SharedState.INSTANCE.getBoolean(r3, false));
    }

    public final boolean a(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "value");
        if (this.b == true) goto L6;
        FLogger.a.w("ISharedStateService", "sdk not initialized");
        return false;
    L6:
        SharedState.INSTANCE.putString(r2, r3);
        return true;
    }

    public final boolean d(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        if (this.b == true) goto L6;
        FLogger.a.w("ISharedStateService", "sdk not initialized");
        return false;
    L6:
        SharedState.INSTANCE.putInt(r2, r3);
        return true;
    }

    public final boolean f(String r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        if (this.b == true) goto L6;
        FLogger.a.w("ISharedStateService", "sdk not initialized");
        return false;
    L6:
        SharedState.INSTANCE.putLong(r2, r3);
        return true;
    }
}
