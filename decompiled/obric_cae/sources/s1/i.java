package s1;

/* JADX INFO: loaded from: classes.dex */
public final class i implements androidx.lifecycle.u<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f11980a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ u1.a f11981b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f11982c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ k.a f11983d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ androidx.lifecycle.r f11984e;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f11985a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ i f11986b;

        public a(i r8, Object r10) {
            this.f11986b = r8;
            this.f11985a = r10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Object r8 = this.f11986b.f11982c;
            monitor-enter(r8);
            Object r10 = this.f11986b.f11983d.apply(this.f11985a);     // Catch: Throwable -> L15
            i r11 = this.f11986b;     // Catch: Throwable -> L15
            Object r12 = r11.f11980a;     // Catch: Throwable -> L15
            if (r12 != null) goto L9;
            if (r10 == null) goto L9;
            r11.f11980a = r10;     // Catch: Throwable -> L15
            androidx.lifecycle.r r13 = r11.f11984e;     // Catch: Throwable -> L15
        L8:
            r13.g(r10);     // Catch: Throwable -> L15
        L13:
            monitor-exit(r8);     // Catch: Throwable -> L15
            return;
        L9:
            if (r12 == null) goto L13;
            if (r12.equals(r10) == true) goto L13;
            i r14 = this.f11986b;     // Catch: Throwable -> L15
            r14.f11980a = r10;     // Catch: Throwable -> L15
            r13 = r14.f11984e;     // Catch: Throwable -> L15
        L15:
            th = move-exception;
            throw th;
        }
    }

    public i(u1.a r8, Object r10, j1.a0 r11, androidx.lifecycle.r r12) {
        this.f11981b = r8;
        this.f11982c = r10;
        this.f11983d = r11;
        this.f11984e = r12;
        this.f11980a = null;
    }

    @Override // androidx.lifecycle.u
    public final void a(Object r8) {
        a r10 = new a(this, r8);
        this.f11981b.a(r10);
    }
}
