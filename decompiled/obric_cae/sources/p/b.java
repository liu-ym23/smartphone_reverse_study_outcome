package p;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class b implements d.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public h f9861a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f9862b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<h> f9863c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f9864d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f9865e;

    public interface a {
        h a(int r8);

        void b();

        float c(b r8, boolean r10);

        void clear();

        float d(h r8, boolean r10);

        void e(h r8, float r10);

        void f(h r8, float r10, boolean r11);

        int g();

        float h(int r8);

        boolean i(h r8);

        float j(h r8);

        void k(float r8);
    }

    public b() {
        this.f9861a = null;
        this.f9862b = 0.0f;
        this.f9863c = new ArrayList();
        this.f9865e = false;
    }

    @Override // p.d.a
    public h a(boolean[] r8) {
        return f(r8, null);
    }

    public final void b(d r8, int r10) {
        this.f9864d.e(r8.k(r10), 1.0f);
        this.f9864d.e(r8.k(r10), -1.0f);
    }

    public final void c(h r8, h r10, h r11, int r12) {
        boolean r13 = false;
        if (r12 == 0) goto L8;
        if (r12 >= 0) goto L6;
        r12 = r12 * (-1);
        r13 = true;
    L6:
        this.f9862b = r12;
    L8:
        if (r13 == true) goto L10;
        this.f9864d.e(r8, -1.0f);
        this.f9864d.e(r10, 1.0f);
        this.f9864d.e(r11, 1.0f);
        return;
    L10:
        this.f9864d.e(r8, 1.0f);
        this.f9864d.e(r10, -1.0f);
        this.f9864d.e(r11, -1.0f);
    }

    public final void d(h r8, h r10, h r11, int r12) {
        boolean r13 = false;
        if (r12 == 0) goto L8;
        if (r12 >= 0) goto L6;
        r12 = r12 * (-1);
        r13 = true;
    L6:
        this.f9862b = r12;
    L8:
        if (r13 == true) goto L10;
        this.f9864d.e(r8, -1.0f);
        this.f9864d.e(r10, 1.0f);
        this.f9864d.e(r11, -1.0f);
        return;
    L10:
        this.f9864d.e(r8, 1.0f);
        this.f9864d.e(r10, -1.0f);
        this.f9864d.e(r11, 1.0f);
    }

    public boolean e() {
        if (this.f9861a == null) goto L5;
    L9:
        return false;
    L5:
        if (this.f9862b != 0.0f) goto L9;
        if (this.f9864d.g() != 0) goto L9;
        return true;
    }

    public final h f(boolean[] r10, h r11) {
        int r8 = this.f9864d.g();
        h r12 = null;
        int r13 = 0;
        float r14 = 0.0f;
    L3:
        if (r13 >= r8) goto L19;
        float r15 = this.f9864d.h(r13);
        if (r15 >= 0.0f) goto L18;
        h r16 = this.f9864d.a(r13);
        if (r10 != null) goto L9;
    L10:
        if (r16 == r11) goto L18;
        h.a r17 = r16.f9903s;
        if (r17 == h.a.f9908b) goto L16;
        if (r17 != h.a.f9909m) goto L18;
    L16:
        if (r15 >= r14) goto L18;
        r14 = r15;
        r12 = r16;
        goto L18
    L9:
        if (r10[r16.f9896b] == false) goto L10;
    L18:
        r13 = r13 + 1;
        goto L3
    L19:
        return r12;
    }

    public final void g(h r8) {
        h r10 = this.f9861a;
        if (r10 == null) goto L5;
        this.f9864d.e(r10, -1.0f);
        this.f9861a.f9897m = -1;
        this.f9861a = null;
    L5:
        float r11 = this.f9864d.d(r8, true) * (-1.0f);
        this.f9861a = r8;
        if (r11 != 1.0f) goto L8;
        return;
    L8:
        this.f9862b /= r11;
        this.f9864d.k(r11);
    }

    public final void h(d r8, h r10, boolean r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.f9900p == false) goto L15;
        float r12 = this.f9864d.j(r10);
        float r13 = this.f9862b;
        this.f9862b = (r10.f9899o * r12) + r13;
        this.f9864d.d(r10, r11);
        if (r11 == false) goto L10;
        r10.b(this);
    L10:
        if (this.f9864d.g() != 0) goto L14;
        this.f9865e = true;
        r8.f9872b = true;
        return;
    L14:
        return;
    }

    public void i(d r8, b r10, boolean r11) {
        float r12 = this.f9864d.c(r10, r11);
        float r13 = this.f9862b;
        this.f9862b = (r10.f9862b * r12) + r13;
        if (r11 == false) goto L6;
        r10.f9861a.b(this);
    L6:
        if (this.f9861a != null) goto L8;
        return;
    L8:
        if (this.f9864d.g() != 0) goto L12;
        this.f9865e = true;
        r8.f9872b = true;
        return;
    }

    public String toString() {
        if (this.f9861a != null) goto L5;
        String r8 = "0";
    L6:
        String r10 = defpackage.a.e(r8, " = ");
        int r11 = 0;
        if (this.f9862b == 0.0f) goto L9;
        StringBuilder r12 = android.aimedia.a.j(r10);
        r12.append(this.f9862b);
        r10 = r12.toString();
        boolean r13 = true;
    L10:
        int r14 = this.f9864d.g();
    L11:
        if (r11 >= r14) goto L34;
        h r15 = this.f9864d.a(r11);
        if (r15 == null) goto L33;
        float r16 = this.f9864d.h(r11);
        if (r16 == 0.0f) goto L33;
        String r17 = r15.toString();
        if (r13 == false) goto L21;
        StringBuilder r18 = android.aimedia.a.j(r10);
        if (r16 <= 0.0f) goto L26;
        r18.append(" + ");
        r10 = r18.toString();
    L29:
        if (r16 != 1.0f) goto L31;
        StringBuilder r19 = new StringBuilder();
    L32:
        r10 = android.aimedia.a.i(r19, r10, r17);
        r13 = true;
        goto L33
    L31:
        r19 = new StringBuilder();
        r19.append(r10);
        r19.append(r16);
        r10 = " ";
        goto L32
    L26:
        String r20 = " - ";
    L27:
        r18.append(r20);
        r10 = r18.toString();
        r16 = r16 * (-1.0f);
        goto L29
    L21:
        if (r16 >= 0.0f) goto L29;
        r18 = android.aimedia.a.j(r10);
        r20 = "- ";
    L33:
        r11 = r11 + 1;
        goto L11
    L34:
        if (r13 == false) goto L36;
        return r10;
    L36:
        return defpackage.a.e(r10, "0.0");
    L9:
        r13 = false;
        goto L10
    L5:
        r8 = "" + this.f9861a;
        goto L6
    }

    public b(c r8) {
        this.f9861a = null;
        this.f9862b = 0.0f;
        this.f9863c = new ArrayList();
        this.f9865e = false;
        this.f9864d = new p.a(this, r8);
    }
}
