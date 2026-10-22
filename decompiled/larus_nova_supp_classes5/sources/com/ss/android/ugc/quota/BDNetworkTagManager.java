package com.ss.android.ugc.quota;

import android.app.Application;
import android.util.Pair;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.concurrent.atomic.AtomicBoolean;
import jm9.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class BDNetworkTagManager {
    private static final Pair<String, String> DEFAULT_TAG = null;
    public static final String KEY_BD_NETWORK_REQUEST_TAG = "x-tt-request-tag";
    private static final String TAG = "BDNetworkTagManager";
    private static volatile BDNetworkTagManager sInstance;
    private ghc.b<Application> contextLazy;
    private ghc.b<ghc.a> dependLazy;
    private AtomicBoolean enable;
    private boolean firstInstallLaunch;
    private ghc.b<hhc.b> launchMonitorLazy;
    private int launchType;

    public class a extends ghc.b<Application> {
        @Override // ghc.b
        public final Application b() {
            IBDNetworkTagConfig r0 = (IBDNetworkTagConfig) ServiceManager.get().getService(IBDNetworkTagConfig.class);
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.getApplication();
        }

        public a() {
        }
    }

    public class b extends ghc.b<ghc.a> {
        public final /* synthetic */ BDNetworkTagManager d;

        @Override // ghc.b
        public final ghc.a b() {
            IBDNetworkTagConfig r0 = (IBDNetworkTagConfig) ServiceManager.get().getService(IBDNetworkTagConfig.class);
            if (r0 == null) goto L5;
            ghc.a r1 = r0.a();
        L6:
            if (r1 == null) goto L8;
            AtomicBoolean r2 = BDNetworkTagManager.access$000(this.d);
            r1.enable();
            r2.set(true);
            BDNetworkTagManager.access$102(this.d, r1.b());
        L8:
            return r1;
        L5:
            r1 = null;
            goto L6
        }

        public b(BDNetworkTagManager r1) {
            this.d = r1;
        }
    }

    public class c extends ghc.b<hhc.b> {
        public final /* synthetic */ BDNetworkTagManager d;

        public final hhc.b c() {
            if (BDNetworkTagManager.access$200(this.d).a() == null) goto L7;
            ((ghc.a) BDNetworkTagManager.access$200(this.d).a()).c();
            return d.a;
        L7:
            return new hhc.a((Application) BDNetworkTagManager.access$300(this.d).a());
        }

        @Override // ghc.b
        public final /* bridge */ /* synthetic */ hhc.b b() {
            return c();
        }

        public c(BDNetworkTagManager r1) {
            this.d = r1;
        }
    }

    static {
        DEFAULT_TAG = new Pair(KEY_BD_NETWORK_REQUEST_TAG, "");
    }

    private boolean enabled() {
        if (this.dependLazy.a() != null) goto L5;
    L7:
        return false;
    L5:
        if (this.enable.get() == false) goto L7;
        return true;
    }

    public static BDNetworkTagManager getInstance() {
        if (sInstance != null) goto L15;
        monitor-enter(BDNetworkTagManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new BDNetworkTagManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(BDNetworkTagManager.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private BDNetworkTagManager() {
        this.contextLazy = new a();
        this.dependLazy = new b(this);
        this.launchMonitorLazy = new c(this);
        this.enable = new AtomicBoolean(false);
        this.launchType = -999;
    }

    public int currentLaunchType() {
        if (enabled() == true) goto L7;
        return -999;
    L7:
        return this.launchType;
    }

    public boolean isFirstInstallLaunch() {
        if (enabled() == true) goto L7;
        return false;
    L7:
        return this.firstInstallLaunch;
    }

    public static /* synthetic */ AtomicBoolean access$000(BDNetworkTagManager r0) {
        return r0.enable;
    }

    public static /* synthetic */ ghc.b access$200(BDNetworkTagManager r0) {
        return r0.dependLazy;
    }

    public static /* synthetic */ ghc.b access$300(BDNetworkTagManager r0) {
        return r0.contextLazy;
    }

    public Pair<String, String> buildBDNetworkTag(IBDNetworkTagContextProvider r3) {
        if (enabled() == false) goto L5;
        if (r3 == null) goto L8;
        int r0 = this.launchMonitorLazy.a().a();
        if (this.launchType == r0) goto L13;
        updateLaunchType(r0);
    L13:
        return new Pair(KEY_BD_NETWORK_REQUEST_TAG, "t=" + r3.triggerType() + ";n=" + (r3.markAsNewUser() ? 1 : 0));
    L8:
        return DEFAULT_TAG;
    L5:
        return DEFAULT_TAG;
    }

    public void enable(boolean r2) {
        this.enable.set(r2);
    }

    public void updateLaunchType(int r2) {
        if (enabled() == true) goto L5;
        return;
    L5:
        this.launchType = r2;
        if (this.dependLazy.a() == null) goto L9;
        this.dependLazy.a().a();
        return;
    }

    public static /* synthetic */ boolean access$102(BDNetworkTagManager r0, boolean r1) {
        r0.firstInstallLaunch = r1;
        return r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [T, jm9.d] */
    public void init(Application r3, ghc.a r4) {
        if (this.dependLazy.a == false) goto L5;
        return;
    L5:
        if (r3 == 0) goto L10;
        if (r4 == 0) goto L10;
        ghc.b<Application> r0 = this.contextLazy;
        r0.c = r3;
        r0.a = true;
        AtomicBoolean r1 = this.enable;
        r4.enable();
        r1.set(true);
        r4.c();
        ?? r2 = d.a;
        ghc.b<hhc.b> r5 = this.launchMonitorLazy;
        r5.c = r2;
        r5.a = true;
        this.firstInstallLaunch = r4.b();
        ghc.b<ghc.a> r6 = this.dependLazy;
        r6.c = r4;
        r6.a = true;
        return;
    L10:
        throw new IllegalArgumentException("Context or depend is NULL");
    }
}
