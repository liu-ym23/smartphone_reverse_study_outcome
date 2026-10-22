package com.bytedance.news.common.settings.internal;

import com.bytedance.news.common.settings.SettingsConfigProvider;
import com.bytedance.services.apm.api.IEnsure;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes.dex */
public class IEnsureWrapper implements IEnsure {
    private static volatile IEnsureWrapper INSTANCE;
    private IEnsure iEnsure;
    private Executor mExecutor;

    class a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ IEnsureWrapper f2384c;

        a(IEnsureWrapper r10) {
            this.f2384c = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            IEnsureWrapper.access$000(this.f2384c).ensureNotReachHere();
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f2385c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ IEnsureWrapper f2386g;

        b(IEnsureWrapper r10, String r11) {
            this.f2386g = r10;
            this.f2385c = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            IEnsureWrapper.access$000(this.f2386g).ensureNotReachHere(this.f2385c);
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Throwable f2387c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ IEnsureWrapper f2388g;

        c(IEnsureWrapper r10, Throwable r11) {
            this.f2388g = r10;
            this.f2387c = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            IEnsureWrapper.access$000(this.f2388g).ensureNotReachHere(this.f2387c);
        }
    }

    class d implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Throwable f2389c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f2390g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ IEnsureWrapper f2391h;

        d(IEnsureWrapper r10, Throwable r11, String r12) {
            this.f2391h = r10;
            this.f2389c = r11;
            this.f2390g = r12;
        }

        @Override // java.lang.Runnable
        public void run() {
            IEnsureWrapper.access$000(this.f2391h).ensureNotReachHere(this.f2389c, this.f2390g);
        }
    }

    class e implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f2392c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ Map f2393g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ IEnsureWrapper f2394h;

        e(IEnsureWrapper r10, String r11, Map r12) {
            this.f2394h = r10;
            this.f2392c = r11;
            this.f2393g = r12;
        }

        @Override // java.lang.Runnable
        public void run() {
            IEnsureWrapper.access$000(this.f2394h).ensureNotReachHere(this.f2392c, this.f2393g);
        }
    }

    class f implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Throwable f2395c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f2396g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ Map f2397h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ IEnsureWrapper f2398i;

        f(IEnsureWrapper r10, Throwable r11, String r12, Map r13) {
            this.f2398i = r10;
            this.f2395c = r11;
            this.f2396g = r12;
            this.f2397h = r13;
        }

        @Override // java.lang.Runnable
        public void run() {
            IEnsureWrapper.access$000(this.f2398i).ensureNotReachHere(this.f2395c, this.f2396g, this.f2397h);
        }
    }

    private IEnsureWrapper() {
        this.iEnsure = (IEnsure) c4.d.a(IEnsure.class);
        SettingsConfigProvider r10 = (SettingsConfigProvider) c4.d.a(SettingsConfigProvider.class);
        if (r10 == null) goto L8;
        if (r10.getConfig() == null) goto L8;
        this.mExecutor = r10.getConfig().d();
    L8:
        if (this.mExecutor != null) goto L11;
        this.mExecutor = Executors.newCachedThreadPool();
        return;
    }

    static /* synthetic */ IEnsure access$000(IEnsureWrapper r10) {
        return r10.iEnsure;
    }

    public static IEnsureWrapper getInstance() {
        if (INSTANCE != null) goto L15;
        monitor-enter(IEnsureWrapper.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (INSTANCE != null) goto L9;
        INSTANCE = new IEnsureWrapper();     // Catch: Throwable -> L11
    L9:
        monitor-exit(IEnsureWrapper.class);     // Catch: Throwable -> L11
    L15:
        return INSTANCE;
    }

    @Override // com.bytedance.services.apm.api.IEnsure
    public boolean ensureFalse(boolean r10) {
        IEnsure r11 = this.iEnsure;
        if (r11 != null) goto L5;
        return false;
    L5:
        return r11.ensureFalse(r10);
    }

    @Override // com.bytedance.services.apm.api.IEnsure
    public boolean ensureFalse(boolean r10, String r11) {
        IEnsure r12 = this.iEnsure;
        if (r12 != null) goto L5;
        return false;
    L5:
        return r12.ensureFalse(r10, r11);
    }

    @Override // com.bytedance.services.apm.api.IEnsure
    public boolean ensureFalse(boolean r10, String r11, Map<String, String> r12) {
        IEnsure r13 = this.iEnsure;
        if (r13 != null) goto L5;
        return false;
    L5:
        return r13.ensureFalse(r10, r11, r12);
    }

    @Override // com.bytedance.services.apm.api.IEnsure
    public boolean ensureNotEmpty(Collection r10) {
        IEnsure r11 = this.iEnsure;
        if (r11 != null) goto L5;
        return false;
    L5:
        return r11.ensureNotEmpty(r10);
    }

    @Override // com.bytedance.services.apm.api.IEnsure
    public boolean ensureNotNull(Object r10) {
        IEnsure r11 = this.iEnsure;
        if (r11 != null) goto L5;
        return false;
    L5:
        return r11.ensureNotNull(r10);
    }

    @Override // com.bytedance.services.apm.api.IEnsure
    public boolean ensureNotNull(Object r10, String r11) {
        IEnsure r12 = this.iEnsure;
        if (r12 != null) goto L5;
        return false;
    L5:
        return r12.ensureNotNull(r10, r11);
    }

    @Override // com.bytedance.services.apm.api.IEnsure
    public void ensureNotReachHere() {
        if (this.iEnsure == null) goto L6;
        this.mExecutor.execute(new a(this));
        return;
    }

    @Override // com.bytedance.services.apm.api.IEnsure
    public void ensureNotReachHere(String r10) {
        if (this.iEnsure == null) goto L6;
        this.mExecutor.execute(new b(this, r10));
        return;
    }

    @Override // com.bytedance.services.apm.api.IEnsure
    public void ensureNotReachHere(String r10, Map<String, String> r11) {
        if (this.iEnsure == null) goto L6;
        this.mExecutor.execute(new e(this, r10, r11));
        return;
    }

    @Override // com.bytedance.services.apm.api.IEnsure
    public void ensureNotReachHere(Throwable r10) {
        if (this.iEnsure == null) goto L6;
        this.mExecutor.execute(new c(this, r10));
        return;
    }

    @Override // com.bytedance.services.apm.api.IEnsure
    public void ensureNotReachHere(Throwable r10, String r11) {
        if (this.iEnsure == null) goto L6;
        this.mExecutor.execute(new d(this, r10, r11));
        return;
    }

    @Override // com.bytedance.services.apm.api.IEnsure
    public void ensureNotReachHere(Throwable r10, String r11, Map<String, String> r12) {
        if (this.iEnsure == null) goto L6;
        this.mExecutor.execute(new f(this, r10, r11, r12));
        return;
    }

    @Override // com.bytedance.services.apm.api.IEnsure
    public boolean ensureTrue(boolean r10) {
        IEnsure r11 = this.iEnsure;
        if (r11 != null) goto L5;
        return false;
    L5:
        return r11.ensureTrue(r10);
    }

    @Override // com.bytedance.services.apm.api.IEnsure
    public boolean ensureTrue(boolean r10, String r11) {
        IEnsure r12 = this.iEnsure;
        if (r12 != null) goto L5;
        return false;
    L5:
        return r12.ensureTrue(r10, r11);
    }

    @Override // com.bytedance.services.apm.api.IEnsure
    public boolean ensureTrue(boolean r10, String r11, Map<String, String> r12) {
        IEnsure r13 = this.iEnsure;
        if (r13 != null) goto L5;
        return false;
    L5:
        return r13.ensureTrue(r10, r11, r12);
    }

    @Override // com.bytedance.services.apm.api.IEnsure
    public void reportLogException(int r10, Throwable r11, String r12) {
        IEnsure r13 = this.iEnsure;
        if (r13 == null) goto L6;
        r13.reportLogException(r10, r11, r12);
        return;
    }

    @Override // com.bytedance.services.apm.api.IEnsure
    public void reportLogException(Throwable r10) {
        IEnsure r11 = this.iEnsure;
        if (r11 == null) goto L6;
        r11.reportLogException(r10);
        return;
    }

    @Override // com.bytedance.services.apm.api.IEnsure
    public void reportLogException(Throwable r10, String r11) {
        IEnsure r12 = this.iEnsure;
        if (r12 == null) goto L6;
        r12.reportLogException(r10, r11);
        return;
    }
}
