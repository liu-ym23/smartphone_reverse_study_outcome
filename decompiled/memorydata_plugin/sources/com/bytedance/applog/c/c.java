package com.bytedance.applog.c;

import android.accounts.Account;
import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.applog.o;
import com.bytedance.bdinstall.BDInstall;
import com.bytedance.bdinstall.Builder;
import com.bytedance.bdinstall.Env;
import com.bytedance.bdinstall.ExecutorOptions;
import com.bytedance.bdinstall.HeaderUpdateListener;
import com.bytedance.bdinstall.IBDInstallApi;
import com.bytedance.bdinstall.IEventDepend;
import com.bytedance.bdinstall.IExtraParams;
import com.bytedance.bdinstall.IInstallListener;
import com.bytedance.bdinstall.ILogger;
import com.bytedance.bdinstall.InstallInfo;
import com.bytedance.bdinstall.InstallOptions;
import com.bytedance.bdinstall.Level;
import com.bytedance.bdinstall.OnResetListener;
import com.bytedance.bdinstall.service.NUApi;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class c implements e, IInstallListener {
    private static volatile boolean k = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile Builder f1534a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile InstallOptions f1535b;
    private volatile d c;
    private final com.bytedance.applog.b d;
    private volatile IBDInstallApi e;
    private final ConcurrentHashMap<String, Object> f;
    private InstallInfo g;
    private String h;
    private String i;
    private String j;

    private static class a implements HeaderUpdateListener, IInstallListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final IInstallListener f1547a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final b f1548b;
        private JSONObject c;
        private InstallInfo d;
        private boolean e;

        public a(IInstallListener r3, b r4) {
            IInstallListener r5 = (IInstallListener) ZeusTransformUtils.wrapperContextForParams(r3, IInstallListener.class, "com.obric.memorydata.plugin");
            b r6 = (b) ZeusTransformUtils.wrapperContextForParams(r4, b.class, "com.obric.memorydata.plugin");
            this.e = false;
            this.f1547a = r5;
            this.f1548b = r6;
        }

        private void a() {
            monitor-enter(this);
        L13:
            th = move-exception;
            throw th;
        L4:
            if (this.e == false) goto L6;
            this.f1548b.b(this.c, this.d);     // Catch: Throwable -> L13
        L11:
            monitor-exit(this);     // Catch: Throwable -> L13
            return;
        L6:
            JSONObject r0 = this.c;     // Catch: Throwable -> L13
            if (r0 == null) goto L11;
            InstallInfo r1 = this.d;     // Catch: Throwable -> L13
            if (r1 == null) goto L11;
            this.e = true;     // Catch: Throwable -> L13
            this.f1548b.a(r0, r1);     // Catch: Throwable -> L13
            goto L11
        }

        @Override // com.bytedance.bdinstall.IInstallListener
        public void installFinished(InstallInfo r2) {
            this.f1547a.installFinished(r2);
            this.d = r2;
            a();
        }

        @Override // com.bytedance.bdinstall.HeaderUpdateListener
        public void onHeaderUpdate(JSONObject r1) {
            this.c = r1;
            a();
        }
    }

    public interface b {
        void a(JSONObject r1, InstallInfo r2);

        void b(JSONObject r1, InstallInfo r2);
    }

    static {
    }

    public c(com.bytedance.applog.b r2) {
        this.f1534a = new Builder();
        this.f = new ConcurrentHashMap();
        this.d = r2;
    }

    static /* synthetic */ com.bytedance.applog.b a(c r0) {
        return r0.d;
    }

    static /* synthetic */ String a(c r0, String r1) {
        r0.h = r1;
        return r1;
    }

    static /* synthetic */ String b(c r0, String r1) {
        r0.i = r1;
        return r1;
    }

    static /* synthetic */ String c(c r0, String r1) {
        r0.j = r1;
        return r1;
    }

    private IBDInstallApi o() {
        if (this.e != null) goto L18;
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L6:
        if (this.e == null) goto L8;
    L12:
        monitor-exit(this);     // Catch: Throwable -> L14
        goto L18
    L8:
        if (com.bytedance.applog.a.a(this.d) == false) goto L11;
        IBDInstallApi r0 = BDInstall.getInstance();     // Catch: Throwable -> L14
    L10:
        this.e = r0;     // Catch: Throwable -> L14
        goto L12
    L11:
        r0 = BDInstall.newInstance();     // Catch: Throwable -> L14
    L18:
        return this.e;
    }

    @Override // com.bytedance.applog.c.e
    public String a(Context r3, StringBuilder r4, boolean r5, Level r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        return o().addNetCommonParams(r7, r4, r5, r6);
    }

    @Override // com.bytedance.applog.c.e
    public void a() {
        o().start();
    }

    @Override // com.bytedance.applog.c.e
    public void a(Account r3) {
        monitor-enter(c.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.f1534a == null) goto L7;
        this.f1534a.setAccount(r3);     // Catch: Throwable -> L10
    L8:
        monitor-exit(c.class);     // Catch: Throwable -> L10
        return;
    L7:
        o().setAccount(r3);     // Catch: Throwable -> L10
        goto L8
    }

    @Override // com.bytedance.applog.c.e
    public void a(Application r3, String r4) {
        Application r5 = (Application) ZeusTransformUtils.wrapperContextForParams(r3, Application.class, "com.obric.memorydata.plugin");
        o().setUserUniqueId(r5, r4);
    }

    @Override // com.bytedance.applog.c.e
    public void a(Context r9, Env r10, long r11, OnResetListener r13) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        OnResetListener r7 = (OnResetListener) ZeusTransformUtils.wrapperContextForParams(r13, OnResetListener.class, "com.obric.memorydata.plugin");
        o().resetInstallInfoWhenSwitchChildMode(r3, r10, r11, r7);
    }

    @Override // com.bytedance.applog.c.e
    public void a(Context r3, String r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        monitor-enter(c.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.f1534a == null) goto L7;
        this.f1534a.setUserAgent(r4);     // Catch: Throwable -> L10
    L8:
        monitor-exit(c.class);     // Catch: Throwable -> L10
        return;
    L7:
        o().setUserAgent(r5, r4);     // Catch: Throwable -> L10
        goto L8
    }

    @Override // com.bytedance.applog.c.e
    public void a(Context r3, String r4, String r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        o().updateLanguageAndRegion(r6, r4, r5);
    }

    @Override // com.bytedance.applog.c.e
    public void a(Context r3, Map<String, String> r4, boolean r5, Level r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Map<String, String> r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        o().putCommonParams(r7, r8, r5, r6);
    }

    @Override // com.bytedance.applog.c.e
    public void a(Context r3, JSONObject r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        monitor-enter(c.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.f1534a == null) goto L7;
        this.f1534a.setAppTrack(r4);     // Catch: Throwable -> L10
    L8:
        monitor-exit(c.class);     // Catch: Throwable -> L10
        return;
    L7:
        o().setAppTrack(r5, r4);     // Catch: Throwable -> L10
        goto L8
    }

    @Override // com.bytedance.applog.c.e
    public void a(Context r3, boolean r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        NUApi r2 = o().newUserMode();
        if (r2 == null) goto L6;
        r2.setNUMode(r4).done();
        return;
    }

    @Override // com.bytedance.applog.c.e
    public void a(b r3) {
        a r0 = new a(this, (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin"));
        o().addHeaderChangeListener(true, r0);
        o().addInstallListener(true, r0);
    }

    @Override // com.bytedance.applog.c.e
    public void a(com.bytedance.applog.k.b r8, Env r9, Looper r10, com.bytedance.applog.c r11) {
        com.bytedance.applog.c r12 = (com.bytedance.applog.c) ZeusTransformUtils.wrapperContextForParams(r11, com.bytedance.applog.c.class, "com.obric.memorydata.plugin");
        final o r0 = r8.c();
        this.c = new d(this.d, o());
        if (this.f.isEmpty() == true) goto L6;
        this.c.a(this.f);
        this.f.clear();
    L6:
        if (k == false) goto L8;
        final Handler r1 = new Handler(r10);
        ExecutorOptions r2 = new ExecutorOptions();
        r2.networkExecutor = new AnonymousClass1(this, r1);
        r2.workLooper = r10;
        o().setExecutor(r2, r0.f());
    L8:
        IEventDepend r13 = new AnonymousClass2(this);
        if (this.d.aN() == false) goto L11;
        ILogger r3 = new AnonymousClass3(this);
    L12:
        this.f1534a.setContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.d.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).setAccount(r0.p()).setAutoActive(r0.B()).setAid(Integer.parseInt(r0.f())).setAnonymous(r0.n()).setAppLanguage(r0.h()).setAppRegion(r0.i()).setAppName(r0.r()).setBDTrackerDepend(r13).setLogger(r3).setChannel(r0.g()).setTweakedChannel(r0.t()).setIsLocalTest(r0.o()).setTouristMode(r0.u()).setSSTInfoProvider(r0.I()).setAbContext(r0.G()).setDebug(false).setEncryptAndCompress(this.d.k()).setCustomInfo(r0.d()).setNetworkClient(new com.bytedance.applog.c.a(this.d)).setManifestVersionCode(r0.x()).setVersionCode(r0.v()).setVersionName(r0.s()).setUpdateVersionCode(r0.w()).setUpdateVersionName(r0.y()).setReleaseBuild(r0.c()).setSilenceInBackground(r0.A()).setSpFileName(r0.F()).setZijiePackage(r0.z()).setAntiCheatingEnable(r0.k()).isMainProcess(r8.q()).setPreInstallChannelCallback(r0.H()).setCustomHeaders(this.c).setAppTraitCallback(r0.L()).enableListenNetChange(r0.N()).setLogger(r0.a()).setDeviceCategory(r0.R()).setEnableNetCommOpt(r0.S()).enableOneKeyMigrateDetect(r0.T()).setSensitiveInterceptor(r0.V()).enableGetIPV6(r0.U());
        if (r0.m() == null) goto L15;
        this.f1534a.setEncryptor(new AnonymousClass4(this, r0));
    L15:
        if (r12 == null) goto L18;
        r12.a(this.f1534a);
    L18:
        monitor-enter(c.class);
        InstallOptions r14 = this.f1534a.build();     // Catch: Throwable -> L24
        o().init(r14, r9);     // Catch: Throwable -> L24
        this.f1534a = null;     // Catch: Throwable -> L24
        this.f1535b = r14;     // Catch: Throwable -> L24
        monitor-exit(c.class);     // Catch: Throwable -> L24
        if (r12 == null) goto L29;
        r12.a();
        return;
    L29:
        return;
    L24:
        th = move-exception;
        throw th;
    L11:
        r3 = null;
        goto L12
    }

    @Override // com.bytedance.applog.c.e
    public void a(Env r1) {
        o().changeUriRuntimeAndReInstall(r1);
    }

    @Override // com.bytedance.applog.c.e
    public void a(IExtraParams r3) {
        IExtraParams r4 = (IExtraParams) ZeusTransformUtils.wrapperContextForParams(r3, IExtraParams.class, "com.obric.memorydata.plugin");
        o().setCommonExtraParam(r4);
    }

    @Override // com.bytedance.applog.c.e
    public void a(String r2) {
        if (this.c == null) goto L5;
        this.c.a(r2);
        return;
    L5:
        this.f.remove(r2);
    }

    @Override // com.bytedance.applog.c.e
    public void a(HashMap<String, Object> r2) {
        if (this.c == null) goto L5;
        this.c.a(r2);
        return;
    L5:
        this.f.putAll(r2);
    }

    @Override // com.bytedance.applog.c.e
    public boolean a(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        return o().isNewUserMode();
    }

    @Override // com.bytedance.applog.c.e
    public boolean a(JSONObject r1) {
        return o().getCurrentHeader(r1);
    }

    @Override // com.bytedance.applog.c.e
    public NUApi b(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        return o().newUserMode();
    }

    @Override // com.bytedance.applog.c.e
    public void b(Context r9, Env r10, long r11, OnResetListener r13) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        OnResetListener r7 = (OnResetListener) ZeusTransformUtils.wrapperContextForParams(r13, OnResetListener.class, "com.obric.memorydata.plugin");
        o().resetAndReInstall(r3, r10, r11, r7);
    }

    @Override // com.bytedance.applog.c.e
    public void b(Context r3, JSONObject r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        com.bytedance.applog.c.b.a(o(), r5, r4);
    }

    @Override // com.bytedance.applog.c.e
    public void b(Env r1) {
        o().clearInstallInfoWhenSwitchChildMode(r1);
    }

    @Override // com.bytedance.applog.c.e
    public boolean b() {
        return o().activeManually();
    }

    @Override // com.bytedance.applog.c.e
    public InstallInfo c() {
        if (this.g != null) goto L6;
        this.g = o().getInstallInfo();
    L6:
        return this.g;
    }

    @Override // com.bytedance.applog.c.e
    public void c(Env r1) {
        o().clearAndSetEnv(r1);
    }

    @Override // com.bytedance.applog.c.e
    public String d() {
        if (TextUtils.isEmpty(this.h) == false) goto L6;
        this.h = o().getDid();
    L6:
        return this.h;
    }

    @Override // com.bytedance.applog.c.e
    public String e() {
        InstallInfo r0 = c();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getClientUdid();
    }

    @Override // com.bytedance.applog.c.e
    public String f() {
        if (TextUtils.isEmpty(this.i) == false) goto L10;
        InstallInfo r0 = c();
        if (r0 == null) goto L7;
        String r1 = r0.getIid();
    L8:
        this.i = r1;
        goto L10
    L7:
        r1 = null;
    L10:
        return this.i;
    }

    @Override // com.bytedance.applog.c.e
    public String g() {
        InstallInfo r0 = c();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getOpenUdid();
    }

    @Override // com.bytedance.applog.c.e
    public String h() {
        if (TextUtils.isEmpty(this.j) == false) goto L10;
        InstallInfo r0 = c();
        if (r0 == null) goto L7;
        String r1 = r0.getSsid();
    L8:
        this.j = r1;
        goto L10
    L7:
        r1 = null;
    L10:
        return this.j;
    }

    @Override // com.bytedance.applog.c.e
    public boolean i() {
        return o().isNewUserModeAvailable();
    }

    @Override // com.bytedance.bdinstall.IInstallListener
    public void installFinished(InstallInfo r1) {
        this.g = r1;
    }

    @Override // com.bytedance.applog.c.e
    public InstallOptions j() {
        return this.f1535b;
    }

    @Override // com.bytedance.applog.c.e
    public boolean k() {
        return o().isNewUserFirstLaunch();
    }

    @Override // com.bytedance.applog.c.e
    public Map<String, String> l() {
        return o().getRequestHeader();
    }

    @Override // com.bytedance.applog.c.e
    public void m() {
        o().addOnDataObserver(new AnonymousClass5(this));
    }

    @Override // com.bytedance.applog.c.e
    public IBDInstallApi n() {
        return o();
    }
}
