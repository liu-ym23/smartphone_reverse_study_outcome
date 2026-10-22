package t;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile c f12830b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile boolean f12831c = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile InterfaceC0293c f12832a;

    class a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f12833c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ long[] f12834g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ c f12835h;

        a(c r10, long r11, long[] r12) {
            this.f12835h = r10;
            this.f12833c = r11;
            this.f12834g = r12;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.a(this.f12835h).b(this.f12833c, this.f12834g);
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ c f12836c;

        b(c r10) {
            this.f12836c = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.a(this.f12836c).a();
        }
    }

    /* JADX INFO: renamed from: t.c$c, reason: collision with other inner class name */
    public interface InterfaceC0293c {
        void a();

        void b(long r10, long[] r11);

        boolean needFilter();
    }

    static {
    }

    private c() {
    }

    static /* synthetic */ InterfaceC0293c a(c r10) {
        return r10.f12832a;
    }

    public static c c() {
        if (f12830b != null) goto L15;
        monitor-enter(c.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f12830b != null) goto L9;
        f12830b = new c();     // Catch: Throwable -> L11
    L9:
        monitor-exit(c.class);     // Catch: Throwable -> L11
    L15:
        return f12830b;
    }

    public void b(long[] r10, long r11) {
        if (this.f12832a != null) goto L6;
        return;
    L6:
        if (this.f12832a.needFilter() == true) goto L10;
        e.B().f12854o.b(new a(this, r11, r10));
        boolean r12 = true;
    L8:
        f12831c = r12;
        return;
    L10:
        if (f12831c == false) goto L13;
        e.B().f12854o.b(new b(this));
        r12 = false;
        goto L8
    }
}
