package r9;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f21707a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f21708b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f21709c;
    public int d;
    public long e;
    public long f;
    public long g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f21710h;

    public d a() {
        d r5 = new d();
        r5.f21707a = 8;
        r5.f21708b = 8;
        r5.f21709c = 8;
        r5.d = 8;
        r5.e = 30;
        r5.f = 10;
        r5.g = 10;
        r5.f21710h = true;
        int r10 = this.f21707a;
        if (r10 <= 0) goto L5;
        r5.f21707a = r10;
    L5:
        int r11 = this.f21708b;
        if (r11 <= 0) goto L8;
        r5.f21708b = r11;
    L8:
        int r12 = this.f21709c;
        if (r12 <= 0) goto L11;
        r5.f21709c = r12;
    L11:
        int r13 = this.d;
        if (r13 <= 0) goto L14;
        r5.d = r13;
    L14:
        long r14 = this.e;
        if (r14 <= 0) goto L17;
        r5.e = r14;
    L17:
        long r15 = this.f;
        if (r15 <= 0) goto L20;
        r5.f = r15;
    L20:
        long r16 = this.g;
        if (r16 <= 0) goto L23;
        r5.g = r16;
    L23:
        r5.f21710h = this.f21710h;
        return r5;
    }
}
