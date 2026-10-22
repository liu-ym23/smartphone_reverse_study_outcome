package ob;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f11615h = "a";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private d f11616a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private d f11617b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile int f11618c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile int f11619d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile boolean f11620e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile boolean f11621f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile b f11622g;

    static {
    }

    public a(b r10) {
        this.f11616a = new d(5);
        this.f11617b = new d(5);
        this.f11618c = 0;
        this.f11619d = 3;
        this.f11620e = true;
        this.f11621f = false;
        this.f11622g = null;
        this.f11622g = r10;
    }

    private void a(c r10) {
        if (r10 != null) goto L5;
        return;
    L5:
        if (this.f11616a.g() == false) goto L29;
        if (this.f11616a.i(r10, 1.0f, 20, (int) (((double) this.f11618c) * 0.05d)) <= 0) goto L29;
        int r11 = this.f11617b.c(r10);
        if (r11 <= 0) goto L29;
        this.f11617b.a(r10);
        if (this.f11617b.g() == true) goto L13;
        return;
    L13:
        if ((r11 & 1) <= 0) goto L15;
    L26:
        f();
        return;
    L15:
        if ((r11 & 2) > 0) goto L26;
        if ((r11 & 4) > 0) goto L26;
        if ((r11 & 8) > 0) goto L26;
        if ((r11 & 16) > 0) goto L26;
        if ((r11 & 32) > 0) goto L26;
        if ((r11 & 64) > 0) goto L26;
        return;
    L29:
        if (this.f11617b.f() == true) goto L31;
        this.f11616a.b(this.f11617b);
    L31:
        this.f11616a.a(r10);
    }

    private void b(c r10) {
        if (r10 != null) goto L5;
        return;
    L5:
        if (lb.a.a() == false) goto L7;
        lb.a.b(f11615h, "doDynamicBalance", "avgSpeed" + r10.f11626d + ",avgTcpRtt=" + r10.f11623a + ",avgHttpRtt=" + r10.f11624b + ",avgNqeType=" + r10.f11625c + ",checkResult=" + r10.f11628f);
    L7:
        int r11 = r10.f11626d;
        int r12 = 51200;
        if (r11 >= 512000) goto L11;
    L17:
        this.f11618c = r12;
        if (this.f11621f == false) goto L20;
        return;
    L20:
        if (this.f11622g == null) goto L24;
        this.f11622g.a(r12);
        return;
    L24:
        return;
    L11:
        if (r11 < 1048576) goto L13;
        r12 = r11 / 2;
        goto L17
    L13:
        int r13 = r11 - 512000;
        if (r13 <= 51200) goto L17;
        r12 = r13;
        goto L17
    }

    private void f() {
        if (this.f11622g == null) goto L5;
        this.f11618c = 0;
        this.f11622g.a(0);
    L5:
        this.f11619d = 3;
    }

    public boolean c() {
        return this.f11621f;
    }

    public void d(int r10, int r11, int r12, int r13) {
        if (this.f11621f == false) goto L6;
        return;
    L6:
        if (this.f11620e == false) goto L9;
        this.f11620e = false;
        return;
    L9:
        if (r13 > 0) goto L11;
        return;
    L11:
        c r14 = new c(r10, r11, r12, r13, this.f11618c);
        if (this.f11619d <= 0) goto L17;
        this.f11616a.a(r14);
        int r15 = this.f11619d - 1;
        this.f11619d = r15;
        if (r15 > 0) goto L19;
        c r16 = this.f11616a.e();
        this.f11619d = -1;
        b(r16);
        this.f11616a.d();
        this.f11617b.d();
        return;
    L19:
        return;
    L17:
        a(r14);
    }

    public void e() {
        if (this.f11621f == true) goto L5;
        return;
    L5:
        this.f11621f = false;
    }

    public void g() {
        if (this.f11621f == false) goto L5;
        return;
    L5:
        this.f11621f = true;
        if (this.f11622g != null) goto L8;
    L10:
        this.f11618c = 0;
        this.f11619d = 3;
        this.f11616a.d();
        this.f11617b.d();
        return;
    L8:
        if (this.f11618c == 0) goto L10;
        this.f11622g.a(0);
        goto L10
    }
}
