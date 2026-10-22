package e3;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f8573a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f8574b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private a f8575c;

    public b(int r10, int r11, a r12) {
        this.f8573a = r10;
        this.f8574b = r11;
        this.f8575c = r12;
    }

    public b(int r10, a r11) {
        this(r10, 0, r11);
    }

    public int a() {
        return this.f8573a;
    }

    public int b() {
        return this.f8574b;
    }

    public a c() {
        return this.f8575c;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if (r10 != null) goto L8;
    L19:
        return false;
    L8:
        if (b.class != r10.getClass()) goto L19;
        b r11 = (b) r10;
        if (this.f8573a != r11.f8573a) goto L18;
        if (this.f8574b != r11.f8574b) goto L18;
        if (this.f8575c.equals(r11.f8575c) == false) goto L18;
        return true;
    L18:
        return false;
    }
}
