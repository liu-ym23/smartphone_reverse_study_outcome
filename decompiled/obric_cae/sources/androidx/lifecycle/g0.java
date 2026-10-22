package androidx.lifecycle;

import android.os.Handler;

/* JADX INFO: loaded from: classes.dex */
public final class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n f2150a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f2151b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f2152c;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final n f2153a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final h.a f2154b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f2155m;

        public a(n r8, h.a r10) {
            he.i.f(r8, "registry");
            he.i.f(r10, "event");
            this.f2153a = r8;
            this.f2154b = r10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.f2155m == true) goto L6;
            this.f2153a.f(this.f2154b);
            this.f2155m = true;
            return;
        }
    }

    public g0(m r8) {
        he.i.f(r8, "provider");
        this.f2150a = new n(r8);
        this.f2151b = new Handler();
    }

    public final void a(h.a r8) {
        a r10 = this.f2152c;
        if (r10 == null) goto L5;
        r10.run();
    L5:
        a r11 = new a(this.f2150a, r8);
        this.f2152c = r11;
        this.f2151b.postAtFrontOfQueue(r11);
    }
}
