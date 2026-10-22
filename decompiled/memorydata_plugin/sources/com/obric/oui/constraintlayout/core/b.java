package com.obric.oui.constraintlayout.core;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes5.dex */
public class b implements d.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    SolverVariable f13520a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    float f13521b;
    boolean c;
    ArrayList<SolverVariable> d;
    public a e;
    boolean f;

    public interface a {
        float a(SolverVariable r1, boolean r2);

        float a(b r1, boolean r2);

        SolverVariable a(int r1);

        void a();

        void a(float r1);

        void a(SolverVariable r1, float r2);

        void a(SolverVariable r1, float r2, boolean r3);

        boolean a(SolverVariable r1);

        float b(int r1);

        float b(SolverVariable r1);

        void b();

        int c();
    }

    public b() {
        this.f13520a = null;
        this.f13521b = 0.0f;
        this.c = false;
        this.d = new ArrayList();
        this.f = false;
    }

    public b(c r3) {
        this.f13520a = null;
        this.f13521b = 0.0f;
        this.c = false;
        this.d = new ArrayList();
        this.f = false;
        this.e = new com.obric.oui.constraintlayout.core.a(this, r3);
    }

    private SolverVariable a(boolean[] r10, SolverVariable r11) {
        int r0 = this.e.c();
        SolverVariable r2 = null;
        int r3 = 0;
        float r4 = 0.0f;
    L3:
        if (r3 >= r0) goto L19;
        float r5 = this.e.b(r3);
        if (r5 >= 0.0f) goto L18;
        SolverVariable r6 = this.e.a(r3);
        if (r10 != null) goto L9;
    L10:
        if (r6 == r11) goto L18;
        if (r6.i == SolverVariable.Type.SLACK) goto L16;
        if (r6.i != SolverVariable.Type.ERROR) goto L18;
    L16:
        if (r5 >= r4) goto L18;
        r4 = r5;
        r2 = r6;
        goto L18
    L9:
        if (r10[r6.f13517b] == false) goto L10;
    L18:
        r3 = r3 + 1;
        goto L3
    L19:
        return r2;
    }

    private boolean a(SolverVariable r1, d r2) {
        if (r1.l <= 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.obric.oui.constraintlayout.core.d.a
    public SolverVariable a(d r1, boolean[] r2) {
        return a(r2, null);
    }

    public b a(float r5, float r6, float r7, SolverVariable r8, SolverVariable r9, SolverVariable r10, SolverVariable r11) {
        this.f13521b = 0.0f;
        if (r6 != 0.0f) goto L5;
    L14:
        this.e.a(r8, 1.0f);
        this.e.a(r9, -1.0f);
        this.e.a(r11, 1.0f);
        this.e.a(r10, -1.0f);
    L15:
        return this;
    L5:
        if (r5 == r7) goto L14;
        if (r5 != 0.0f) goto L11;
        this.e.a(r8, 1.0f);
        this.e.a(r9, -1.0f);
        goto L15
    L11:
        if (r7 != 0.0f) goto L13;
        this.e.a(r10, 1.0f);
        this.e.a(r11, -1.0f);
        goto L15
    L13:
        float r12 = (r5 / r6) / (r7 / r6);
        this.e.a(r8, 1.0f);
        this.e.a(r9, -1.0f);
        this.e.a(r11, r12);
        this.e.a(r10, -r12);
        goto L15
    }

    b a(SolverVariable r1, int r2) {
        this.f13520a = r1;
        float r3 = r2;
        r1.e = r3;
        this.f13521b = r3;
        this.f = true;
        return this;
    }

    b a(SolverVariable r3, SolverVariable r4, float r5) {
        this.e.a(r3, -1.0f);
        this.e.a(r4, r5);
        return this;
    }

    public b a(SolverVariable r3, SolverVariable r4, int r5) {
        boolean r0 = false;
        if (r5 == 0) goto L8;
        if (r5 >= 0) goto L6;
        r5 = r5 * (-1);
        r0 = true;
    L6:
        this.f13521b = r5;
    L8:
        if (r0 == true) goto L10;
        this.e.a(r3, -1.0f);
        this.e.a(r4, 1.0f);
    L11:
        return this;
    L10:
        this.e.a(r3, 1.0f);
        this.e.a(r4, -1.0f);
        goto L11
    }

    b a(SolverVariable r6, SolverVariable r7, int r8, float r9, SolverVariable r10, SolverVariable r11, int r12) {
        if (r7 != r10) goto L7;
        this.e.a(r6, 1.0f);
        this.e.a(r11, 1.0f);
        this.e.a(r7, -2.0f);
        return this;
    L7:
        if (r9 != 0.5f) goto L14;
        this.e.a(r6, 1.0f);
        this.e.a(r7, -1.0f);
        this.e.a(r10, -1.0f);
        this.e.a(r11, 1.0f);
        if (r8 > 0) goto L11;
        if (r12 > 0) goto L11;
    L24:
        return this;
    L11:
        int r13 = (-r8) + r12;
    L12:
        float r14 = r13;
    L16:
        this.f13521b = r14;
        goto L24
    L14:
        if (r9 > 0.0f) goto L18;
        this.e.a(r6, -1.0f);
        this.e.a(r7, 1.0f);
        r14 = r8;
        goto L16
    L18:
        if (r9 < 1.0f) goto L20;
        this.e.a(r11, -1.0f);
        this.e.a(r10, 1.0f);
        r13 = -r12;
        goto L12
    L20:
        float r3 = 1.0f - r9;
        this.e.a(r6, r3 * 1.0f);
        this.e.a(r7, r3 * (-1.0f));
        this.e.a(r10, (-1.0f) * r9);
        this.e.a(r11, 1.0f * r9);
        if (r8 > 0) goto L23;
        if (r12 <= 0) goto L24;
    L23:
        r14 = ((-r8) * r3) + (r12 * r9);
        goto L16
    }

    public b a(SolverVariable r3, SolverVariable r4, SolverVariable r5, int r6) {
        boolean r0 = false;
        if (r6 == 0) goto L8;
        if (r6 >= 0) goto L6;
        r6 = r6 * (-1);
        r0 = true;
    L6:
        this.f13521b = r6;
    L8:
        if (r0 == true) goto L10;
        this.e.a(r3, -1.0f);
        this.e.a(r4, 1.0f);
        this.e.a(r5, 1.0f);
    L11:
        return this;
    L10:
        this.e.a(r3, 1.0f);
        this.e.a(r4, -1.0f);
        this.e.a(r5, -1.0f);
        goto L11
    }

    public b a(SolverVariable r3, SolverVariable r4, SolverVariable r5, SolverVariable r6, float r7) {
        this.e.a(r3, -1.0f);
        this.e.a(r4, 1.0f);
        this.e.a(r5, r7);
        this.e.a(r6, -r7);
        return this;
    }

    public b a(d r4, int r5) {
        this.e.a(r4.a(r5, "ep"), 1.0f);
        this.e.a(r4.a(r5, "em"), -1.0f);
        return this;
    }

    @Override // com.obric.oui.constraintlayout.core.d.a
    public void a(d.a r6) {
        d.a r7 = (d.a) ZeusTransformUtils.wrapperContextForParams(r6, d.a.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r7, b.class) == false) goto L8;
        b r8 = (b) ZeusTransformUtils.preCheckCast(r7, b.class, "com.obric.memorydata.plugin");
        this.f13520a = null;
        this.e.a();
        int r0 = 0;
    L6:
        if (r0 >= r8.e.c()) goto L10;
        SolverVariable r1 = r8.e.a(r0);
        float r2 = r8.e.b(r0);
        this.e.a(r1, r2, true);
        r0 = r0 + 1;
        goto L6
    L10:
        return;
    }

    public void a(d r4, SolverVariable r5, boolean r6) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.f == false) goto L18;
        this.f13521b += r5.e * this.e.b(r5);
        this.e.a(r5, r6);
        if (r6 == false) goto L10;
        r5.b(this);
    L10:
        if (d.c == true) goto L12;
        return;
    L12:
        if (this.e.c() != 0) goto L17;
        this.f = true;
        r4.g = true;
        return;
    L17:
        return;
    }

    public void a(d r4, b r5, boolean r6) {
        this.f13521b += r5.f13521b * this.e.a(r5, r6);
        if (r6 == false) goto L6;
        r5.f13520a.b(this);
    L6:
        if (d.c == true) goto L8;
        return;
    L8:
        if (this.f13520a != null) goto L10;
        return;
    L10:
        if (this.e.c() != 0) goto L15;
        this.f = true;
        r4.g = true;
        return;
    }

    boolean a() {
        SolverVariable r0 = this.f13520a;
        if (r0 != null) goto L5;
    L9:
        return false;
    L5:
        if (r0.i != SolverVariable.Type.UNRESTRICTED) goto L7;
    L8:
        return true;
    L7:
        if (this.f13521b < 0.0f) goto L9;
        goto L8
    }

    boolean a(SolverVariable r1) {
        return this.e.a(r1);
    }

    boolean a(d r3) {
        SolverVariable r4 = b(r3);
        if (r4 != null) goto L5;
        boolean r5 = true;
    L7:
        if (this.e.c() != 0) goto L9;
        this.f = true;
    L9:
        return r5;
    L5:
        b(r4);
        r5 = false;
        goto L7
    }

    SolverVariable b(d r15) {
        int r0 = this.e.c();
        SolverVariable r1 = null;
        int r4 = 0;
        boolean r5 = false;
        boolean r6 = false;
        float r7 = 0.0f;
        float r8 = 0.0f;
        SolverVariable r2 = null;
    L3:
        if (r4 >= r0) goto L28;
        float r9 = this.e.b(r4);
        SolverVariable r10 = this.e.a(r4);
        if (r10.i != SolverVariable.Type.UNRESTRICTED) goto L15;
        if (r1 != null) goto L9;
    L7:
        r5 = a(r10, r15);
        r7 = r9;
        r1 = r10;
    L27:
        r4 = r4 + 1;
        goto L3
    L9:
        if (r7 > r9) goto L7;
        if (r5 == true) goto L27;
        if (a(r10, r15) == false) goto L27;
        r7 = r9;
        r1 = r10;
        r5 = true;
        goto L27
    L15:
        if (r1 != null) goto L27;
        if (r9 >= 0.0f) goto L27;
        if (r2 != null) goto L21;
    L19:
        r6 = a(r10, r15);
        r8 = r9;
        r2 = r10;
        goto L27
    L21:
        if (r8 > r9) goto L19;
        if (r6 == true) goto L27;
        if (a(r10, r15) == false) goto L27;
        r8 = r9;
        r2 = r10;
        r6 = true;
        goto L27
    L28:
        if (r1 == null) goto L30;
        return r1;
    L30:
        return r2;
    }

    public b b(SolverVariable r2, int r3) {
        if (r3 >= 0) goto L4;
        this.f13521b = r3 * (-1);
        a r4 = this.e;
        float r0 = 1.0f;
    L5:
        r4.a(r2, r0);
        return this;
    L4:
        this.f13521b = r3;
        r4 = this.e;
        r0 = -1.0f;
        goto L5
    }

    public b b(SolverVariable r3, SolverVariable r4, SolverVariable r5, int r6) {
        boolean r0 = false;
        if (r6 == 0) goto L8;
        if (r6 >= 0) goto L6;
        r6 = r6 * (-1);
        r0 = true;
    L6:
        this.f13521b = r6;
    L8:
        if (r0 == true) goto L10;
        this.e.a(r3, -1.0f);
        this.e.a(r4, 1.0f);
        this.e.a(r5, -1.0f);
    L11:
        return this;
    L10:
        this.e.a(r3, 1.0f);
        this.e.a(r4, -1.0f);
        this.e.a(r5, 1.0f);
        goto L11
    }

    public b b(SolverVariable r3, SolverVariable r4, SolverVariable r5, SolverVariable r6, float r7) {
        this.e.a(r5, 0.5f);
        this.e.a(r6, 0.5f);
        this.e.a(r3, -0.5f);
        this.e.a(r4, -0.5f);
        this.f13521b = -r7;
        return this;
    }

    String b() {
        if (this.f13520a != null) goto L5;
        StringBuilder r0 = new StringBuilder().append("").append("0");
    L6:
        String r1 = r0.toString() + " = ";
        int r3 = 0;
        if (this.f13521b == 0.0f) goto L9;
        r1 = r1 + this.f13521b;
        boolean r2 = true;
    L10:
        int r5 = this.e.c();
    L11:
        if (r3 >= r5) goto L34;
        SolverVariable r6 = this.e.a(r3);
        if (r6 == null) goto L33;
        float r7 = this.e.b(r3);
        if (r7 == 0.0f) goto L33;
        String r8 = r6.toString();
        if (r2 == true) goto L24;
        if (r7 >= 0.0f) goto L29;
        StringBuilder r4 = new StringBuilder().append(r1);
        String r9 = "- ";
    L27:
        r1 = r4.append(r9).toString();
        r7 = r7 * (-1.0f);
    L29:
        if (r7 != 1.0f) goto L31;
        StringBuilder r10 = new StringBuilder().append(r1);
    L32:
        r1 = r10.append(r8).toString();
        r2 = true;
        goto L33
    L31:
        r10 = new StringBuilder().append(r1).append(r7).append(" ");
        goto L32
    L24:
        if (r7 <= 0.0f) goto L26;
        r1 = r1 + " + ";
        goto L29
    L26:
        r4 = new StringBuilder().append(r1);
        r9 = " - ";
    L33:
        r3 = r3 + 1;
        goto L11
    L34:
        if (r2 == false) goto L36;
        return r1;
    L36:
        return r1 + "0.0";
    L9:
        r2 = false;
        goto L10
    L5:
        r0 = new StringBuilder().append("").append(this.f13520a);
        goto L6
    }

    void b(SolverVariable r4) {
        SolverVariable r0 = this.f13520a;
        if (r0 == null) goto L5;
        this.e.a(r0, -1.0f);
        this.f13520a.c = -1;
        this.f13520a = null;
    L5:
        float r1 = this.e.a(r4, true) * (-1.0f);
        this.f13520a = r4;
        if (r1 != 1.0f) goto L8;
        return;
    L8:
        this.f13521b /= r1;
        this.e.a(r1);
    }

    public void b(d r4, SolverVariable r5, boolean r6) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.m == false) goto L18;
        float r0 = this.e.b(r5);
        this.f13521b += r5.o * r0;
        this.e.a(r5, r6);
        if (r6 == false) goto L9;
        r5.b(this);
    L9:
        this.e.a(r4.n.d[r5.n], r0, r6);
        if (d.c == true) goto L12;
        return;
    L12:
        if (this.e.c() != 0) goto L17;
        this.f = true;
        r4.g = true;
        return;
    L17:
        return;
    }

    public SolverVariable c(SolverVariable r2) {
        return a(null, r2);
    }

    b c(SolverVariable r2, int r3) {
        this.e.a(r2, r3);
        return this;
    }

    public void c() {
        this.f13520a = null;
        this.e.a();
        this.f13521b = 0.0f;
        this.f = false;
    }

    public void c(d r9) {
        if (r9.i.length != 0) goto L5;
        return;
    L5:
        boolean r1 = false;
    L7:
        if (r1 == true) goto L33;
        int r3 = this.e.c();
        int r4 = 0;
    L9:
        if (r4 >= r3) goto L18;
        SolverVariable r5 = this.e.a(r4);
        if (r5.c == (-1)) goto L13;
    L16:
        this.d.add(r5);
    L17:
        r4 = r4 + 1;
        goto L9
    L13:
        if (r5.f == true) goto L16;
        if (r5.m == false) goto L17;
    L18:
        int r6 = this.d.size();
        if (r6 > 0) goto L20;
        r1 = true;
        goto L7
    L20:
        int r7 = 0;
    L21:
        if (r7 >= r6) goto L30;
        SolverVariable r8 = (SolverVariable) ZeusTransformUtils.preCheckCast(this.d.get(r7), SolverVariable.class, "com.obric.memorydata.plugin");
        if (r8.f == false) goto L26;
        a(r9, r8, true);
    L29:
        r7 = r7 + 1;
        goto L21
    L26:
        if (r8.m == false) goto L28;
        b(r9, r8, true);
        goto L29
    L28:
        a(r9, r9.i[r8.c], true);
        goto L29
    L30:
        this.d.clear();
        goto L7
    L33:
        if (d.c == true) goto L35;
        return;
    L35:
        if (this.f13520a != null) goto L37;
        return;
    L37:
        if (this.e.c() != 0) goto L55;
        this.f = true;
        r9.g = true;
        return;
    }

    void d() {
        float r0 = this.f13521b;
        if (r0 >= 0.0f) goto L6;
        this.f13521b = r0 * (-1.0f);
        this.e.b();
        return;
    }

    @Override // com.obric.oui.constraintlayout.core.d.a
    public void d(SolverVariable r4) {
        float r1 = 1.0f;
        if (r4.d != 1) goto L6;
    L17:
        this.e.a(r4, r1);
        return;
    L6:
        if (r4.d != 2) goto L9;
        r1 = 1000.0f;
        goto L17
    L9:
        if (r4.d != 3) goto L12;
        r1 = 1000000.0f;
        goto L17
    L12:
        if (r4.d != 4) goto L15;
        r1 = 1.0E9f;
        goto L17
    L15:
        if (r4.d != 5) goto L17;
        r1 = 1.0E12f;
        goto L17
    }

    @Override // com.obric.oui.constraintlayout.core.d.a
    public boolean e() {
        if (this.f13520a == null) goto L5;
    L9:
        return false;
    L5:
        if (this.f13521b != 0.0f) goto L9;
        if (this.e.c() != 0) goto L9;
        return true;
    }

    @Override // com.obric.oui.constraintlayout.core.d.a
    public void f() {
        this.e.a();
        this.f13520a = null;
        this.f13521b = 0.0f;
    }

    @Override // com.obric.oui.constraintlayout.core.d.a
    public SolverVariable g() {
        return this.f13520a;
    }

    public String toString() {
        return b();
    }
}
