package t3;

/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected h f12942a;

    public h(h r10) {
        this.f12942a = null;
        this.f12942a = r10;
    }

    public void a() {
        h r10 = this.f12942a;
        if (r10 == null) goto L6;
        r10.a();
        return;
    }

    public void b(String r10, int r11, long r12) {
        h r13 = this.f12942a;
        if (r13 == null) goto L6;
        r13.b(r10, r11, r12);
        return;
    }

    public e c(int r10, int r11, long r12) {
        h r13 = this.f12942a;
        if (r13 != null) goto L5;
        return null;
    L5:
        return r13.c(r10, r11, r12);
    }

    public void d(int r10, f r11, int r12, f r13, int r14, long r15) {
        h r16 = this.f12942a;
        if (r16 == null) goto L6;
        r16.d(r10, r11, r12, r13, r14, r15);
        return;
    }

    public void e(f r11, f r12, f r13, f r14, int r15, int r16, int r17, long r18) {
        h r10 = this.f12942a;
        if (r10 == null) goto L6;
        r10.e(r11, r12, r13, r14, r15, r16, r17, r18);
        return;
    }

    public void f(int r10, int r11, f[] r12, int r13, long r14) {
        h r15 = this.f12942a;
        if (r15 == null) goto L6;
        r15.f(r10, r11, r12, r13, r14);
        return;
    }

    public void g(f r10, String r11, int r12, long r13) {
        h r14 = this.f12942a;
        if (r14 == null) goto L6;
        r14.g(r10, r11, r12, r13);
        return;
    }

    public void h(int r10, int r11, long r12, byte[] r13) {
        h r14 = this.f12942a;
        if (r14 == null) goto L6;
        r14.h(r10, r11, r12, r13);
        return;
    }
}
