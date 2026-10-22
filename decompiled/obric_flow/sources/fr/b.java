package fr;

import ai.j0;
import com.google.common.reflect.w;
import com.obric.oui.constraintlayout.core.SolverVariable$Type;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f16981a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f16982b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f16983c;
    public final a d;
    public boolean e;

    public b(w r5) {
        this.f16981a = null;
        this.f16982b = 0.0f;
        this.f16983c = new ArrayList();
        this.e = false;
        this.d = new a(this, r5);
    }

    public final void a(c r5, int r10) {
        this.d.g(r5.j(r10), 1.0f);
        this.d.g(r5.j(r10), -1.0f);
    }

    public final void b(e r5, e r10, e r11, int r12) {
        boolean r13 = false;
        if (r12 == 0) goto L8;
        if (r12 >= 0) goto L6;
        r12 = r12 * (-1);
        r13 = true;
    L6:
        this.f16982b = r12;
    L8:
        if (r13 == true) goto L10;
        this.d.g(r5, -1.0f);
        this.d.g(r10, 1.0f);
        this.d.g(r11, 1.0f);
        return;
    L10:
        this.d.g(r5, 1.0f);
        this.d.g(r10, -1.0f);
        this.d.g(r11, -1.0f);
    }

    public final void c(e r5, e r10, e r11, int r12) {
        boolean r13 = false;
        if (r12 == 0) goto L8;
        if (r12 >= 0) goto L6;
        r12 = r12 * (-1);
        r13 = true;
    L6:
        this.f16982b = r12;
    L8:
        if (r13 == true) goto L10;
        this.d.g(r5, -1.0f);
        this.d.g(r10, 1.0f);
        this.d.g(r11, -1.0f);
        return;
    L10:
        this.d.g(r5, 1.0f);
        this.d.g(r10, -1.0f);
        this.d.g(r11, 1.0f);
    }

    public e d(boolean[] r5) {
        return f(r5, null);
    }

    public boolean e() {
        if (this.f16981a == null) goto L5;
    L9:
        return false;
    L5:
        if (this.f16982b != 0.0f) goto L9;
        if (this.d.d() != 0) goto L9;
        return true;
    }

    public final e f(boolean[] r10, e r11) {
        int r5 = this.d.d();
        e r12 = null;
        int r13 = 0;
        float r14 = 0.0f;
    L3:
        if (r13 >= r5) goto L19;
        float r15 = this.d.f(r13);
        if (r15 >= 0.0f) goto L18;
        e r16 = this.d.e(r13);
        if (r10 != null) goto L9;
    L10:
        if (r16 == r11) goto L18;
        SolverVariable$Type r17 = r16.f17003i;
        if (r17 == SolverVariable$Type.SLACK) goto L16;
        if (r17 != SolverVariable$Type.ERROR) goto L18;
    L16:
        if (r15 >= r14) goto L18;
        r14 = r15;
        r12 = r16;
        goto L18
    L9:
        if (r10[r16.f17000b] == false) goto L10;
    L18:
        r13 = r13 + 1;
        goto L3
    L19:
        return r12;
    }

    public final void g(e r5) {
        e r10 = this.f16981a;
        if (r10 == null) goto L5;
        this.d.g(r10, -1.0f);
        this.f16981a.f17001c = -1;
        this.f16981a = null;
    L5:
        float r11 = this.d.h(r5, true) * (-1.0f);
        this.f16981a = r5;
        if (r11 != 1.0f) goto L8;
        return;
    L8:
        this.f16982b /= r11;
        a r12 = this.d;
        int r13 = r12.f16978h;
        int r14 = 0;
    L10:
        if (r13 == (-1)) goto L14;
        if (r14 >= r12.f16975a) goto L17;
        float[] r15 = r12.g;
        r15[r13] = r15[r13] / r11;
        r13 = r12.f[r13];
        r14 = r14 + 1;
        goto L10
    L17:
        return;
    }

    public final void h(c r5, e r10, boolean r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.f == false) goto L15;
        float r12 = this.d.c(r10);
        float r13 = this.f16982b;
        this.f16982b = (r10.e * r12) + r13;
        this.d.h(r10, r11);
        if (r11 == false) goto L10;
        r10.b(this);
    L10:
        if (this.d.d() != 0) goto L14;
        this.e = true;
        r5.f16986b = true;
        return;
    L14:
        return;
    }

    public void i(c r10, b r11, boolean r12) {
        a r5 = this.d;
        r5.getClass();
        float r13 = r5.c(r11.f16981a);
        r5.h(r11.f16981a, r12);
        a r14 = r11.d;
        int r15 = r14.d();
        int r16 = 0;
    L3:
        if (r16 >= r15) goto L5;
        e r17 = r14.e(r16);
        r5.a(r17, r14.c(r17) * r13, r12);
        r16 = r16 + 1;
        goto L3
    L5:
        float r18 = this.f16982b;
        this.f16982b = (r11.f16982b * r13) + r18;
        if (r12 == false) goto L9;
        r11.f16981a.b(this);
    L9:
        if (this.f16981a != null) goto L11;
        return;
    L11:
        if (this.d.d() != 0) goto L16;
        this.e = true;
        r10.f16986b = true;
        return;
    }

    public String toString() {
        if (this.f16981a != null) goto L5;
        String r5 = "0";
    L6:
        String r10 = j0.j(r5, " = ");
        int r11 = 0;
        if (this.f16982b == 0.0f) goto L9;
        StringBuilder r12 = j0.u(r10);
        r12.append(this.f16982b);
        r10 = r12.toString();
        boolean r13 = true;
    L10:
        int r14 = this.d.d();
    L11:
        if (r11 >= r14) goto L33;
        e r15 = this.d.e(r11);
        if (r15 == null) goto L32;
        float r16 = this.d.f(r11);
        if (r16 == 0.0f) goto L32;
        String r17 = r15.toString();
        if (r13 == false) goto L21;
        if (r16 <= 0.0f) goto L26;
        r10 = j0.j(r10, " + ");
    L28:
        if (r16 != 1.0f) goto L30;
        r10 = j0.j(r10, r17);
    L31:
        r13 = true;
        goto L32
    L30:
        r10 = r10 + r16 + " " + r17;
        goto L31
    L26:
        r10 = j0.j(r10, " - ");
    L23:
        r16 = r16 * (-1.0f);
        goto L28
    L21:
        if (r16 >= 0.0f) goto L28;
        r10 = j0.j(r10, "- ");
    L32:
        r11 = r11 + 1;
        goto L11
    L33:
        if (r13 == false) goto L35;
        return r10;
    L35:
        return j0.j(r10, "0.0");
    L9:
        r13 = false;
        goto L10
    L5:
        r5 = "" + this.f16981a;
        goto L6
    }
}
