package pe;

/* JADX INFO: loaded from: classes2.dex */
public abstract class s0 extends w {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ int f10060p = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f10061m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f10062n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public yd.d<m0<?>> f10063o;

    public s0() {
    }

    public void shutdown() {
    }

    public final void t0(boolean r8) {
        long r10 = this.f10061m;
        if (r8 == false) goto L5;
        long r11 = 4294967296L;
    L6:
        long r12 = r10 - r11;
        this.f10061m = r12;
        if (r12 <= 0) goto L10;
        return;
    L10:
        if (this.f10062n == false) goto L13;
        shutdown();
        return;
    L13:
        return;
    L5:
        r11 = 1;
        goto L6
    }

    public final void u0(boolean r8) {
        long r10 = this.f10061m;
        if (r8 == false) goto L5;
        long r11 = 4294967296L;
    L6:
        this.f10061m = r11 + r10;
        if (r8 == true) goto L10;
        this.f10062n = true;
        return;
    L10:
        return;
    L5:
        r11 = 1;
        goto L6
    }

    public long v0() {
        if (w0() == true) goto L6;
        return Long.MAX_VALUE;
    L6:
        return 0;
    }

    public final boolean w0() {
        yd.d<m0<?>> r8 = this.f10063o;
        if (r8 != null) goto L6;
        return false;
    L6:
        if (r8.isEmpty() == false) goto L8;
        m0<?> r10 = null;
    L9:
        m0<?> r11 = r10;
        if (r11 != null) goto L12;
        return false;
    L12:
        r11.run();
        return true;
    L8:
        r10 = r8.removeFirst();
        goto L9
    }
}
