package com.obric.memorydata.middleware.impl.bdtracker;

import android.content.Context;
import android.os.Handler;
import com.bytedance.applog.AppLog;
import com.bytedance.applog.g;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.InstallInfo;
import com.bytedance.bdinstall.OnResetListener;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.bdtracker.IMemoryAppLogSettings;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.utils.handler.GlobalMainHandler;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000G\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f*\u0001\u0010\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0012\u001a\u00020\u0000H\u0007J\u0006\u0010\u0013\u001a\u00020\u0014J\u0016\u0010\u0015\u001a\u00020\u00142\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00140\u0017H\u0016JD\u0010\u0018\u001a\u00020\u00142\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00140\u001a2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00140\u001a2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00140\u001aH\u0016J0\u0010\u001d\u001a\u00020\u00142\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00140\u001a2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00140\u001aH\u0002J&\u0010\u001e\u001a\u00020\u00142\b\u0010\u001f\u001a\u0004\u0018\u00010\u00052\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00140\u001aH\u0002J\b\u0010!\u001a\u00020\u0014H\u0002J\u0010\u0010\"\u001a\u00020\u00142\u0006\u0010#\u001a\u00020\tH\u0002J\b\u0010$\u001a\u00020\u0005H\u0016J\b\u0010%\u001a\u00020\u0005H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011¨\u0006&"}, d2 = {"Lcom/obric/memorydata/middleware/impl/bdtracker/MemoryAppLogSettings;", "Lcom/obric/memorydata/middleware/api/bdtracker/IMemoryAppLogSettings;", "<init>", "()V", "TAG", "", "EVENT_VERIFY_HOST", "INVALID_DID", "DID_REINSTALL_CHECK_INTERVAL_MS", "", "DID_REINSTALL_TIMEOUT_MS", "didReinstallHandler", "Landroid/os/Handler;", "didReinstallInFlight", "", "didReinstallCheck", "com/obric/memorydata/middleware/impl/bdtracker/MemoryAppLogSettings$didReinstallCheck$1", "Lcom/obric/memorydata/middleware/impl/bdtracker/MemoryAppLogSettings$didReinstallCheck$1;", "getInst", "onMemoryAppLogInitialized", "", "registerDidReadyListener", "onDidReady", "Lkotlin/Function0;", "registerDidListener", "onRemoteDidChanged", "Lkotlin/Function1;", "onIdLoaded", "onCurrentDid", "registerMemoryAppLogDidListener", "handleDid", "did", "onDidAvailable", "reinstallDidUntilAvailable", "scheduleDidReinstallCheck", "delayMillis", "getServerDeviceId", "getIid", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MemoryAppLogSettings implements IMemoryAppLogSettings {
    private static final long DID_REINSTALL_CHECK_INTERVAL_MS = 1000;
    private static final long DID_REINSTALL_TIMEOUT_MS = 3000;
    private static final String EVENT_VERIFY_HOST = "https://log.snssdk.com";
    public static final MemoryAppLogSettings INSTANCE = null;
    private static final String INVALID_DID = "0";
    private static final String TAG = "MemoryAppLogSettings";
    private static final a didReinstallCheck = null;
    private static final Handler didReinstallHandler = null;
    private static boolean didReinstallInFlight;

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/obric/memorydata/middleware/impl/bdtracker/MemoryAppLogSettings$didReinstallCheck$1", "Ljava/lang/Runnable;", "run", "", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements Runnable {

        /* JADX INFO: renamed from: com.obric.memorydata.middleware.impl.bdtracker.MemoryAppLogSettings$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, d2 = {"com/obric/memorydata/middleware/impl/bdtracker/MemoryAppLogSettings$didReinstallCheck$1$run$1", "Lcom/bytedance/bdinstall/OnResetListener;", "onDidUpdate", "", "installInfo", "Lcom/bytedance/bdinstall/InstallInfo;", "onTimeout", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class C0631a implements OnResetListener {
            C0631a() {
            }

            @Override // com.bytedance.bdinstall.OnResetListener
            public void onDidUpdate(InstallInfo r7) {
                Intrinsics.checkNotNullParameter(r7, "installInfo");
                MemoryAppLogSettings r6 = MemoryAppLogSettings.INSTANCE;
                boolean r8 = false;
                MemoryAppLogSettings.access$setDidReinstallInFlight$p(false);
                CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r7.getDid(), CharSequence.class, "com.obric.memorydata.plugin");
                if (r0 != null) goto L5;
            L8:
                boolean r1 = true;
            L9:
                if (r1 == false) goto L11;
            L13:
                IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), MemoryAppLogSettings.TAG, "AppLog 重新安装回调，didValid=" + r8, false, 4, null);
                if (r8 == true) goto L17;
                MemoryAppLogSettings.access$scheduleDidReinstallCheck(MemoryAppLogSettings.INSTANCE, 1000);
                return;
            L17:
                return;
            L11:
                if (Intrinsics.areEqual(r7.getDid(), "0") == true) goto L13;
                r8 = true;
                goto L13
            L5:
                if (r0.length() == 0) goto L8;
                r1 = false;
                goto L9
            }

            @Override // com.bytedance.bdinstall.OnResetListener
            public void onTimeout() {
                MemoryAppLogSettings r6 = MemoryAppLogSettings.INSTANCE;
                MemoryAppLogSettings.access$setDidReinstallInFlight$p(false);
                IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), MemoryAppLogSettings.TAG, "AppLog 重新安装超时，继续重试", false, 4, null);
                MemoryAppLogSettings.access$scheduleDidReinstallCheck(MemoryAppLogSettings.INSTANCE, 1000);
            }
        }

        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            String r8 = AppLog.getDid();
            CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin");
            if (r0 != null) goto L5;
        L8:
            boolean r1 = true;
        L9:
            if (r1 == true) goto L14;
            if (Intrinsics.areEqual(r8, "0") == true) goto L14;
            return;
        L14:
            if (MemoryAppLogSettings.access$getDidReinstallInFlight$p() == false) goto L16;
            return;
        L16:
            MemoryAppLogSettings r9 = MemoryAppLogSettings.INSTANCE;
            MemoryAppLogSettings.access$setDidReinstallInFlight$p(true);
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), MemoryAppLogSettings.TAG, "DID 未获取到，触发 AppLog 重新安装", false, 4, null);
            AppLog.resetAndReInstall(3000, (OnResetListener) ZeusTransformUtils.preCheckCast(new C0631a(), OnResetListener.class, "com.obric.memorydata.plugin"));
            return;
        L5:
            if (r0.length() == 0) goto L8;
            r1 = false;
            goto L9
        }
    }

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JL\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u0007H\u0016J&\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u001a\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0013H\u0016J\u001c\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\u0019"}, d2 = {"com/obric/memorydata/middleware/impl/bdtracker/MemoryAppLogSettings$registerMemoryAppLogDidListener$1", "Lcom/bytedance/applog/IDataObserver;", "onRemoteIdGet", "", "changed", "", "oldDid", "", "newDid", "oldIid", "newIid", "oldSsid", "newSsid", "onIdLoaded", "did", "iid", Api.KEY_SSID, "onRemoteConfigGet", "config", "Lorg/json/JSONObject;", "onRemoteAbConfigGet", "abConfig", "onAbVidsChange", "vids", "extVids", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<String, Unit> f11704a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function1<String, Unit> f11705b;

        b(Function1<? super String, Unit> r3, Function1<? super String, Unit> r4) {
            Function1<String, Unit> r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
            Function1<String, Unit> r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
            this.f11704a = r5;
            this.f11705b = r6;
        }

        @Override // com.bytedance.applog.g
        public void a(String r1, String r2, String r3) {
            MemoryAppLogSettings.access$handleDid(MemoryAppLogSettings.INSTANCE, r1, this.f11705b);
        }

        @Override // com.bytedance.applog.g
        public void a(boolean r1, String r2, String r3, String r4, String r5, String r6, String r7) {
            if (r1 == true) goto L13;
            CharSequence r8 = (CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin");
            if (r8 != null) goto L6;
        L9:
            boolean r9 = true;
        L10:
            if (r9 == true) goto L13;
            if (Intrinsics.areEqual(r3, "0") == true) goto L13;
            return;
        L6:
            if (r8.length() == 0) goto L9;
            r9 = false;
        L13:
            MemoryAppLogSettings.access$handleDid(MemoryAppLogSettings.INSTANCE, r3, this.f11704a);
        }

        @Override // com.bytedance.applog.g
        public void a(boolean r1, JSONObject r2) {
        }
    }

    static {
        INSTANCE = new MemoryAppLogSettings();
        didReinstallHandler = GlobalMainHandler.Companion.getInstance();
        didReinstallCheck = new a();
    }

    private MemoryAppLogSettings() {
    }

    public static final /* synthetic */ boolean access$getDidReinstallInFlight$p() {
        return didReinstallInFlight;
    }

    public static final /* synthetic */ void access$handleDid(MemoryAppLogSettings r2, String r3, Function1 r4) {
        r2.handleDid(r3, (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ void access$scheduleDidReinstallCheck(MemoryAppLogSettings r0, long r1) {
        r0.scheduleDidReinstallCheck(r1);
    }

    public static final /* synthetic */ void access$setDidReinstallInFlight$p(boolean r0) {
        didReinstallInFlight = r0;
    }

    @JvmStatic
    public static final MemoryAppLogSettings getInst() {
        return INSTANCE;
    }

    private final void handleDid(String r3, Function1<? super String, Unit> r4) {
        Function1 r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
    L14:
        reinstallDidUntilAvailable();
        return;
    L11:
        if (Intrinsics.areEqual(r3, "0") == true) goto L14;
        r5.invoke(r3);
        return;
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public static /* synthetic */ Unit lambda$5VY2wmyPFg7HhIdNTLiqfwMIPr0(Function0 r0, String r1) {
        return registerDidReadyListener$lambda$1(r0, r1);
    }

    public static /* synthetic */ void lambda$CEUZ6v7rBzIbDJdowcaY14xrUXc() {
        reinstallDidUntilAvailable$lambda$3();
    }

    public static /* synthetic */ Unit lambda$JlSC8tza8csKSJ_ursWk7I0Xjx0(Function0 r0, String r1) {
        return registerDidReadyListener$lambda$2(r0, r1);
    }

    public static /* synthetic */ Unit lambda$JwfH1pGMzZLSuLxLqclJqGhCqQg(Function0 r0, String r1) {
        return registerDidReadyListener$lambda$0(r0, r1);
    }

    private static final Unit registerDidReadyListener$lambda$0(Function0 r2, String r3) {
        Function0 r4 = (Function0) ZeusTransformUtils.wrapperContextForParams(r2, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "it");
        r4.invoke();
        return Unit.INSTANCE;
    }

    private static final Unit registerDidReadyListener$lambda$1(Function0 r2, String r3) {
        Function0 r4 = (Function0) ZeusTransformUtils.wrapperContextForParams(r2, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "it");
        r4.invoke();
        return Unit.INSTANCE;
    }

    private static final Unit registerDidReadyListener$lambda$2(Function0 r2, String r3) {
        Function0 r4 = (Function0) ZeusTransformUtils.wrapperContextForParams(r2, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "it");
        r4.invoke();
        return Unit.INSTANCE;
    }

    private final void registerMemoryAppLogDidListener(Function1<? super String, Unit> r2, Function1<? super String, Unit> r3) {
        AppLog.addDataObserver((g) ZeusTransformUtils.preCheckCast(new b((Function1) ZeusTransformUtils.wrapperContextForParams(r2, Function1.class, "com.obric.memorydata.plugin"), (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin")), g.class, "com.obric.memorydata.plugin"));
    }

    private final void reinstallDidUntilAvailable() {
        didReinstallHandler.post($$Lambda$MemoryAppLogSettings$CEUZ6v7rBzIbDJdowcaY14xrUXc.INSTANCE);
    }

    private static final void reinstallDidUntilAvailable$lambda$3() {
        INSTANCE.scheduleDidReinstallCheck(1000);
    }

    private final void scheduleDidReinstallCheck(long r4) {
        Handler r3 = didReinstallHandler;
        a r0 = didReinstallCheck;
        r3.removeCallbacks((Runnable) ZeusTransformUtils.preCheckCast(r0, Runnable.class, "com.obric.memorydata.plugin"));
        r3.postDelayed((Runnable) ZeusTransformUtils.preCheckCast(r0, Runnable.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.obric.memorydata.middleware.api.bdtracker.IMemoryAppLogSettings
    public String getIid() {
        String r0 = AppLog.getIid();
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    @Override // com.obric.memorydata.middleware.api.bdtracker.IMemoryAppLogSettings
    public String getServerDeviceId() {
        String r0 = AppLog.getDid();
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    public final void onMemoryAppLogInitialized() {
        if (AppContext.INSTANCE.isAdminMode() == false) goto L5;
    L7:
        String r4 = String.valueOf(AppContext.INSTANCE.getAid());
        com.bytedance.applog.util.g.a(r4, true, (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        com.bytedance.applog.util.g.a(r4, EVENT_VERIFY_HOST);
        return;
    L5:
        if (AppContext.INSTANCE.isLocalTest() == true) goto L7;
    }

    @Override // com.obric.memorydata.middleware.api.bdtracker.IMemoryAppLogSettings
    public void registerDidListener(Function1<? super String, Unit> r3, Function1<? super String, Unit> r4, Function1<? super String, Unit> r5) {
        Function1<? super String, Unit> r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        Function1<? super String, Unit> r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        Function1<? super String, Unit> r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "onRemoteDidChanged");
        Intrinsics.checkNotNullParameter(r7, "onIdLoaded");
        Intrinsics.checkNotNullParameter(r8, "onCurrentDid");
        registerMemoryAppLogDidListener(r6, r7);
        handleDid(AppLog.getDid(), r8);
    }

    @Override // com.obric.memorydata.middleware.api.bdtracker.IMemoryAppLogSettings
    public void registerDidReadyListener(Function0<Unit> r4) {
        final Function0 r5 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "onDidReady");
        registerDidListener(new $$Lambda$MemoryAppLogSettings$JwfH1pGMzZLSuLxLqclJqGhCqQg(r5), new $$Lambda$MemoryAppLogSettings$5VY2wmyPFg7HhIdNTLiqfwMIPr0(r5), new $$Lambda$MemoryAppLogSettings$JlSC8tza8csKSJ_ursWk7I0Xjx0(r5));
    }
}
