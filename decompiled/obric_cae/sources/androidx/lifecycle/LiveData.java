package androidx.lifecycle;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class LiveData<T> {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Object f2097k = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f2098a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j.b<u<? super T>, LiveData<T>.c> f2099b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f2100c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f2101d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile Object f2102e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile Object f2103f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f2104g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f2105h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f2106i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final a f2107j;

    public class LifecycleBoundObserver extends LiveData<T>.c implements k {
        public LifecycleBoundObserver() {
            throw null;
        }

        @Override // androidx.lifecycle.LiveData.c
        public final void c() {
            throw null;
        }

        @Override // androidx.lifecycle.LiveData.c
        public final boolean d() {
            throw null;
        }

        @Override // androidx.lifecycle.k
        public final void onStateChanged(m r8, h.a r10) {
            throw null;
        }
    }

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveData f2108a;

        public a(LiveData r8) {
            this.f2108a = r8;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public final void run() {
            Object r8 = this.f2108a.f2098a;
            monitor-enter(r8);
            Object r10 = this.f2108a.f2103f;     // Catch: Throwable -> L8
            LiveData r11 = this.f2108a;     // Catch: Throwable -> L8
            r11.f2103f = LiveData.f2097k;     // Catch: Throwable -> L8
            monitor-exit(r8);     // Catch: Throwable -> L8
            this.f2108a.i(r10);
            return;
        L8:
            th = move-exception;
            throw th;
        }
    }

    public class b extends LiveData<T>.c {
        @Override // androidx.lifecycle.LiveData.c
        public final boolean d() {
            return true;
        }
    }

    public abstract class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final u<? super T> f2109a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f2110b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f2111m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ LiveData f2112n;

        public c(LiveData r8, u<? super T> r10) {
            this.f2112n = r8;
            this.f2111m = -1;
            this.f2109a = r10;
        }

        public final void b(boolean r8) {
            if (r8 != this.f2110b) goto L5;
            return;
        L5:
            this.f2110b = r8;
            if (r8 == false) goto L8;
            int r10 = 1;
        L9:
            LiveData r11 = this.f2112n;
            int r12 = r11.f2100c;
            r11.f2100c = r10 + r12;
            if (r11.f2101d == true) goto L31;
            r11.f2101d = true;
        L37:
            int r13 = r11.f2100c;     // Catch: Throwable -> L34
            if (r12 == r13) goto L29;
            if (r12 != 0) goto L19;
            if (r13 <= 0) goto L19;
            boolean r14 = true;
        L20:
            if (r12 <= 0) goto L23;
            if (r13 != 0) goto L23;
            boolean r15 = true;
        L24:
            if (r14 == false) goto L26;
            r11.e();     // Catch: Throwable -> L34
        L28:
            r12 = r13;
            goto L37
        L26:
            if (r15 == false) goto L28;
            r11.f();     // Catch: Throwable -> L34
        L23:
            r15 = false;
        L19:
            r14 = false;
            goto L20
        L29:
            r11.f2101d = false;
        L34:
            th = move-exception;
            r11.f2101d = false;
            throw th;
        L31:
            if (this.f2110b == false) goto L43;
            r11.c(this);
            return;
        L43:
            return;
        L8:
            r10 = -1;
            goto L9
        }

        public void c() {
        }

        public abstract boolean d();
    }

    static {
        f2097k = new Object();
    }

    public LiveData() {
        this.f2098a = new Object();
        this.f2099b = new j.b();
        this.f2100c = 0;
        Object r8 = f2097k;
        this.f2103f = r8;
        this.f2107j = new a(this);
        this.f2102e = r8;
        this.f2104g = -1;
    }

    public static void a(String r8) {
        if (i.c.A().B() == false) goto L6;
        return;
    L6:
        throw new IllegalStateException(defpackage.b.d("Cannot invoke ", r8, " on a background thread"));
    }

    public final void b(LiveData<T>.c r8) {
        if (r8.f2110b == true) goto L6;
        return;
    L6:
        if (r8.d() == true) goto L9;
        r8.b(false);
        return;
    L9:
        int r10 = r8.f2111m;
        int r11 = this.f2104g;
        if (r10 < r11) goto L12;
        return;
    L12:
        r8.f2111m = r11;
        r8.f2109a.a((Object) this.f2102e);
    }

    public final void c(LiveData<T>.c r8) {
        if (this.f2105h == false) goto L6;
        this.f2106i = true;
        return;
    L6:
        this.f2105h = true;
    L7:
        this.f2106i = false;
        if (r8 == null) goto L10;
        b(r8);
        r8 = null;
    L16:
        if (this.f2106i == true) goto L7;
        this.f2105h = false;
        return;
    L10:
        j.b<u<? super T>, LiveData<T>.c> r10 = this.f2099b;
        r10.getClass();
        j.b.d r11 = new j.b.d(r10);
        r10.f8358m.put(r11, Boolean.FALSE);
    L12:
        if (r11.hasNext() == false) goto L16;
        b((c) ((Map.Entry) r11.next()).getValue());
        if (this.f2106i == false) goto L12;
        goto L16
    }

    public void d(u<? super T> r8) {
        a("observeForever");
        b r10 = new b(this, r8);
        LiveData<T>.c r11 = this.f2099b.b(r8, r10);
        if ((r11 instanceof LifecycleBoundObserver) == true) goto L9;
        if (r11 == null) goto L6;
        return;
    L6:
        r10.b(true);
        return;
    L9:
        throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
    }

    public void e() {
    }

    public void f() {
    }

    public void g(T r8) {
        Object r10 = this.f2098a;
        monitor-enter(r10);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.f2103f != f2097k) goto L7;
        boolean r11 = true;
    L8:
        this.f2103f = r8;     // Catch: Throwable -> L14
        monitor-exit(r10);     // Catch: Throwable -> L14
        if (r11 == true) goto L12;
        return;
    L12:
        i.c.A().C(this.f2107j);
        return;
    L7:
        r11 = false;
        goto L8
    }

    public void h(u<? super T> r8) {
        a("removeObserver");
        LiveData<T>.c r10 = this.f2099b.c(r8);
        if (r10 != null) goto L5;
        return;
    L5:
        r10.c();
        r10.b(false);
    }

    public void i(T r8) {
        a("setValue");
        this.f2104g++;
        this.f2102e = r8;
        c(null);
    }
}
