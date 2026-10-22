package w0;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.bytedance.applog.n;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.BDInstall;
import com.bytedance.bdinstall.Builder;
import com.bytedance.bdinstall.Env;
import com.bytedance.bdinstall.ExecutorOptions;
import com.bytedance.bdinstall.HeaderUpdateListener;
import com.bytedance.bdinstall.IBDInstallApi;
import com.bytedance.bdinstall.IDataObserver;
import com.bytedance.bdinstall.IEncryptor;
import com.bytedance.bdinstall.IEventDepend;
import com.bytedance.bdinstall.IInstallListener;
import com.bytedance.bdinstall.ILogger;
import com.bytedance.bdinstall.InstallInfo;
import com.bytedance.bdinstall.InstallOptions;
import com.bytedance.bdinstall.Level;
import com.bytedance.bdinstall.OnResetListener;
import f1.m;
import java.util.Map;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class b implements w0.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    private volatile Builder f13214a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile InstallOptions f13215b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private w0.c f13216c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.bytedance.applog.c f13217d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile IBDInstallApi f13218e;

    class a implements Executor {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Handler f13219c;

        a(b r10, Handler r11) {
            this.f13219c = r11;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable r10) {
            if (this.f13219c.getLooper() != Looper.myLooper()) goto L5;
            r10.run();
            return;
        L5:
            this.f13219c.post(r10);
        }
    }

    /* JADX INFO: renamed from: w0.b$b, reason: collision with other inner class name */
    class C0307b implements IEventDepend {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ n f13220a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f13221b;

        C0307b(b r10, n r11) {
            this.f13221b = r10;
            this.f13220a = r11;
        }

        @Override // com.bytedance.bdinstall.IEventDepend
        public void onEvent(String r10, JSONObject r11) {
            if (this.f13220a.h() == false) goto L6;
            b.e(this.f13221b).a(r10, r11);
            return;
        }
    }

    class c implements ILogger {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f13222a;

        c(b r10) {
            this.f13222a = r10;
        }

        @Override // com.bytedance.bdinstall.ILogger
        public void d(String r10, Throwable r11) {
            b.e(this.f13222a).P().h(1, r10, new Object[0]);
            if (r11 == null) goto L6;
            b.e(this.f13222a).P().v(1, r10, r11, new Object[0]);
            return;
        }

        @Override // com.bytedance.bdinstall.ILogger
        public void e(String r10, Throwable r11) {
            b.e(this.f13222a).P().v(1, r10, r11, new Object[0]);
        }

        @Override // com.bytedance.bdinstall.ILogger
        public void i(String r10, Throwable r11) {
            b.e(this.f13222a).P().d(1, r10, new Object[0]);
            if (r11 == null) goto L6;
            b.e(this.f13222a).P().v(1, r10, r11, new Object[0]);
            return;
        }

        @Override // com.bytedance.bdinstall.ILogger
        public void v(String r10, Throwable r11) {
            b.e(this.f13222a).P().a(1, r10, new Object[0]);
            if (r11 == null) goto L6;
            b.e(this.f13222a).P().v(1, r10, r11, new Object[0]);
            return;
        }

        @Override // com.bytedance.bdinstall.ILogger
        public void w(String r10, Throwable r11) {
            b.e(this.f13222a).P().s(1, r10, new Object[0]);
            if (r11 == null) goto L6;
            b.e(this.f13222a).P().v(1, r10, r11, new Object[0]);
            return;
        }
    }

    class d implements IEncryptor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ n f13223a;

        d(b r10, n r11) {
            this.f13223a = r11;
        }

        @Override // com.bytedance.bdinstall.IEncryptor
        public byte[] encrypt(byte[] r10, int r11) {
            b4.a r12 = this.f13223a.o();
            if (r12 == null) goto L6;
            return r12.encrypt(r10, r11);
        L6:
            return new byte[0];
        }
    }

    class e implements IDataObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f13224a;

        class a implements f1.e.b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f13225a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f13226b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ String f13227c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ e f13228d;

            a(e r10, String r11, String r12, String r13) {
                this.f13228d = r10;
                this.f13225a = r11;
                this.f13226b = r12;
                this.f13227c = r13;
            }

            @Override // f1.e.b
            public Object a() {
                JSONObject r10 = new JSONObject();
                r10.put("appId", b.e(this.f13228d.f13224a).getAppId());     // Catch: Throwable -> L5
                r10.put("did", this.f13225a);     // Catch: Throwable -> L5
                r10.put(Api.KEY_SSID, this.f13226b);     // Catch: Throwable -> L5
                r10.put("installId", this.f13227c);     // Catch: Throwable -> L5
            L4:
                return r10;
            }
        }

        /* JADX INFO: renamed from: w0.b$e$b, reason: collision with other inner class name */
        class C0308b implements f1.e.b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f13229a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f13230b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ String f13231c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ e f13232d;

            C0308b(e r10, String r11, String r12, String r13) {
                this.f13232d = r10;
                this.f13229a = r11;
                this.f13230b = r12;
                this.f13231c = r13;
            }

            @Override // f1.e.b
            public Object a() {
                JSONObject r10 = new JSONObject();
                r10.put("appId", b.e(this.f13232d.f13224a).getAppId());     // Catch: Throwable -> L5
                r10.put("did", this.f13229a);     // Catch: Throwable -> L5
                r10.put("installId", this.f13230b);     // Catch: Throwable -> L5
                r10.put(Api.KEY_SSID, this.f13231c);     // Catch: Throwable -> L5
            L4:
                return r10;
            }
        }

        e(b r10) {
            this.f13224a = r10;
        }

        @Override // com.bytedance.bdinstall.IDataObserver
        public void onIdLoaded(String r10, String r11, String r12) {
            if (b.e(this.f13224a).A() == null) goto L5;
            b.e(this.f13224a).A().onIdLoaded(r10, r11, r12);
        L5:
            m.d("local_did_load", new a(this, r10, r12, r11));
        }

        @Override // com.bytedance.bdinstall.IDataObserver
        public void onRemoteIdGet(boolean r11, String r12, String r13, String r14, String r15, String r16, String r17) {
            if (b.e(this.f13224a).A() == null) goto L5;
            b.e(this.f13224a).A().onRemoteIdGet(r11, r12, r13, r14, r15, r16, r17);
        L5:
            m.d("device_register_end", new C0308b(this, r13, r15, r17));
        }
    }

    private static class f implements IInstallListener, HeaderUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final g f13233a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private JSONObject f13234b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private InstallInfo f13235c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f13236d;

        public f(g r10) {
            this.f13236d = false;
            this.f13233a = r10;
        }

        private void a() {
            monitor-enter(this);
        L13:
            th = move-exception;
            throw th;
        L4:
            if (this.f13236d == false) goto L6;
            this.f13233a.a(this.f13234b, this.f13235c);     // Catch: Throwable -> L13
        L11:
            monitor-exit(this);     // Catch: Throwable -> L13
            return;
        L6:
            JSONObject r10 = this.f13234b;     // Catch: Throwable -> L13
            if (r10 == null) goto L11;
            InstallInfo r11 = this.f13235c;     // Catch: Throwable -> L13
            if (r11 == null) goto L11;
            this.f13236d = true;     // Catch: Throwable -> L13
            this.f13233a.b(r10, r11);     // Catch: Throwable -> L13
            goto L11
        }

        @Override // com.bytedance.bdinstall.IInstallListener
        public void installFinished(@NonNull InstallInfo r10) {
            this.f13235c = r10;
            a();
        }

        @Override // com.bytedance.bdinstall.HeaderUpdateListener
        public void onHeaderUpdate(JSONObject r10) {
            this.f13234b = r10;
            a();
        }
    }

    public interface g {
        void a(JSONObject r10, InstallInfo r11);

        void b(JSONObject r10, InstallInfo r11);
    }

    public b(com.bytedance.applog.c r10) {
        this.f13214a = new Builder();
        this.f13217d = r10;
    }

    static /* synthetic */ com.bytedance.applog.c e(b r10) {
        return r10.f13217d;
    }

    private IBDInstallApi f() {
        if (this.f13218e != null) goto L18;
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L6:
        if (this.f13218e == null) goto L8;
    L12:
        monitor-exit(this);     // Catch: Throwable -> L14
        goto L18
    L8:
        if (com.bytedance.applog.b.d(this.f13217d) == false) goto L11;
        IBDInstallApi r10 = BDInstall.getInstance();     // Catch: Throwable -> L14
    L10:
        this.f13218e = r10;     // Catch: Throwable -> L14
        goto L12
    L11:
        r10 = BDInstall.newInstance();     // Catch: Throwable -> L14
    L18:
        return this.f13218e;
    }

    @Override // w0.d
    public void a(g1.b r10, Env r11, Looper r12, com.bytedance.applog.d r13) {
        n r14 = r10.q();
        this.f13216c = new w0.c(this.f13217d);
        Handler r15 = new Handler(r12);
        ExecutorOptions r16 = new ExecutorOptions();
        r16.networkExecutor = new a(this, r15);
        r16.workLooper = r12;
        f().setExecutor(r16, r14.d());
        C0307b r17 = new C0307b(this, r14);
        this.f13214a.setContext(this.f13217d.w()).setAccount(r14.c()).setAutoActive(r14.J()).setAid(Integer.parseInt(r14.d())).setAnonymous(r14.e()).setAppLanguage(r14.q()).setAppRegion(r14.x()).setAppName(r14.f()).setBDTrackerDepend(r17).setLogger(new c(this)).setChannel(r14.j()).setTweakedChannel(r14.B()).setIsLocalTest(r14.r()).setTouristMode(r14.Y()).setSSTInfoProvider(r14.z()).setAbContext(r14.b()).setDebug(this.f13217d.b0()).setEncryptAndCompress(this.f13217d.E()).setCustomInfo(r14.k()).setNetworkClient(new w0.a(this.f13217d)).setManifestVersionCode(r14.t()).setVersionCode(r14.F()).setVersionName(r14.E()).setUpdateVersionCode(r14.C()).setUpdateVersionName(r14.G()).setReleaseBuild(r14.y()).setSilenceInBackground(r14.W()).setSpFileName(r14.A()).setZijiePackage(r14.H()).setAntiCheatingEnable(r14.I()).isMainProcess(r10.D()).setPreInstallChannelCallback(r14.v()).setCustomHeaders(this.f13216c).setAppTraitCallback(r14.g()).enableListenNetChange(r14.N()).setLogger(r14.s()).setDeviceCategory(r14.n()).setEnableNetCommOpt(r14.T()).enableOneKeyMigrateDetect(r14.U()).setSensitiveInterceptor(r14.m()).enableGetIPV6(r14.L()).enableMediaID(r14.K());
        if (r14.o() == null) goto L5;
        this.f13214a.setEncryptor(new d(this, r14));
    L5:
        if (r13 == null) goto L8;
        r13.b(this.f13214a);
    L8:
        monitor-enter(b.class);
        InstallOptions r18 = this.f13214a.build();     // Catch: Throwable -> L14
        f().init(r18, r11);     // Catch: Throwable -> L14
        this.f13214a = null;     // Catch: Throwable -> L14
        this.f13215b = r18;     // Catch: Throwable -> L14
        monitor-exit(b.class);     // Catch: Throwable -> L14
        if (r13 == null) goto L19;
        r13.a();
        return;
    L19:
        return;
    L14:
        th = move-exception;
        throw th;
    }

    @Override // w0.d
    public String addNetCommonParams(Context r10, StringBuilder r11, boolean r12, Level r13) {
        return f().addNetCommonParams(r10, r11, r12, r13);
    }

    @Override // w0.d
    public void b() {
        f().addOnDataObserver(new e(this));
    }

    @Override // w0.d
    public void c(Application r10, String r11) {
        f().setUserUniqueId(r10, r11);
    }

    @Override // w0.d
    public void clearAndSetEnv(Env r10) {
        f().clearAndSetEnv(r10);
    }

    @Override // w0.d
    public void clearInstallInfoWhenSwitchChildMode(Env r10) {
        f().clearInstallInfoWhenSwitchChildMode(r10);
    }

    @Override // w0.d
    public void d(g r10) {
        f r11 = new f(r10);
        f().addHeaderChangeListener(true, r11);
        f().addInstallListener(true, r11);
    }

    @Override // w0.d
    public boolean getCurrentHeader(JSONObject r10) {
        return f().getCurrentHeader(r10);
    }

    @Override // w0.d
    public String getDid() {
        return f().getDid();
    }

    @Override // w0.d
    public InstallInfo getInstallInfo() {
        return f().getInstallInfo();
    }

    @Override // w0.d
    public InstallOptions getInstallOptions() {
        return this.f13215b;
    }

    @Override // w0.d
    public void putCommonParams(Context r10, Map<String, String> r11, boolean r12, Level r13) {
        f().putCommonParams(r10, r11, r12, r13);
    }

    @Override // w0.d
    public void resetAndReInstall(Context r10, Env r11, long r12, OnResetListener r13) {
        f().resetAndReInstall(r10, r11, r12, r13);
    }

    @Override // w0.d
    public void resetInstallInfoWhenSwitchChildMode(Context r10, Env r11, long r12, OnResetListener r13) {
        f().resetInstallInfoWhenSwitchChildMode(r10, r11, r12, r13);
    }

    @Override // w0.d
    public void start() {
        f().start();
    }
}
