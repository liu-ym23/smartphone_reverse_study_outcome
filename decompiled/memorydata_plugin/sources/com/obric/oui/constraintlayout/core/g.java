package com.obric.oui.constraintlayout.core;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public class g extends b {
    a g;
    c h;
    private int i;
    private SolverVariable[] j;
    private SolverVariable[] k;
    private int l;

    class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        SolverVariable f13552a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        g f13553b;
        final /* synthetic */ g c;

        a(g r1, g r2) {
            this.c = r1;
            this.f13553b = r2;
        }

        public void a(SolverVariable r1) {
            this.f13552a = r1;
        }

        public final boolean a() {
            int r0 = 8;
        L4:
            if (r0 < 0) goto L13;
            float r2 = this.f13552a.h[r0];
            if (r2 > 0.0f) goto L7;
            if (r2 < 0.0f) goto L10;
            r0 = r0 - 1;
            goto L4
        L10:
            return true;
        L7:
            return false;
        L13:
            return false;
        }

        public boolean a(SolverVariable r10, float r11) {
            boolean r4 = true;
            int r5 = 0;
            if (this.f13552a.f13516a == false) goto L14;
            int r0 = 0;
        L5:
            if (r0 >= 9) goto L11;
            float[] r6 = this.f13552a.h;
            r6[r0] = r6[r0] + (r10.h[r0] * r11);
            if (Math.abs(this.f13552a.h[r0]) >= 1.0E-4f) goto L9;
            this.f13552a.h[r0] = 0.0f;
        L10:
            r0 = r0 + 1;
            goto L5
        L9:
            r4 = false;
            goto L10
        L11:
            if (r4 == false) goto L13;
            g.a(this.c, this.f13552a);
        L13:
            return false;
        L14:
            if (r5 >= 9) goto L23;
            float r1 = r10.h[r5];
            if (r1 == 0.0f) goto L21;
            float r2 = r1 * r11;
            if (Math.abs(r2) >= 1.0E-4f) goto L20;
            r2 = 0.0f;
        L20:
            this.f13552a.h[r5] = r2;
        L22:
            r5 = r5 + 1;
            goto L14
        L21:
            this.f13552a.h[r5] = 0.0f;
            goto L22
        L23:
            return true;
        }

        public void b() {
            Arrays.fill(this.f13552a.h, 0.0f);
        }

        public final boolean b(SolverVariable r6) {
            int r0 = 8;
        L4:
            if (r0 < 0) goto L15;
            float r2 = r6.h[r0];
            float r3 = this.f13552a.h[r0];
            if (r3 != r2) goto L9;
            r0 = r0 - 1;
            goto L4
        L9:
            if (r3 >= r2) goto L14;
            return true;
        L14:
            return false;
        L15:
            return false;
        }

        public String toString() {
            String r1 = "[ ";
            if (this.f13552a == null) goto L9;
            int r0 = 0;
        L6:
            if (r0 >= 9) goto L9;
            r1 = r1 + this.f13552a.h[r0] + " ";
            r0 = r0 + 1;
        L9:
            return r1 + "] " + this.f13552a;
        }
    }

    public g(c r3) {
        super(r3);
        this.i = 128;
        this.j = new SolverVariable[128];
        this.k = new SolverVariable[128];
        this.l = 0;
        this.g = new a(this, this);
        this.h = r3;
    }

    static /* synthetic */ void a(g r0, SolverVariable r1) {
        r0.f(r1);
    }

    private void e(SolverVariable r6) {
        int r0 = this.l + 1;
        SolverVariable[] r2 = this.j;
        if (r0 <= r2.length) goto L5;
        SolverVariable[] r1 = (SolverVariable[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r2, r2.length * 2), SolverVariable[].class, "com.obric.memorydata.plugin");
        this.j = r1;
        this.k = (SolverVariable[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r1, r1.length * 2), SolverVariable[].class, "com.obric.memorydata.plugin");
    L5:
        SolverVariable[] r3 = this.j;
        int r4 = this.l;
        r3[r4] = r6;
        int r5 = r4 + 1;
        this.l = r5;
        if (r5 > 1) goto L8;
    L17:
        r6.f13516a = true;
        r6.a(this);
        return;
    L8:
        if (r3[r5 - 1].f13517b <= r6.f13517b) goto L17;
        int r7 = 0;
        int r8 = 0;
    L10:
        int r9 = this.l;
        if (r8 >= r9) goto L13;
        this.k[r8] = this.j[r8];
        r8 = r8 + 1;
        goto L10
    L13:
        Arrays.sort(this.k, 0, r9, new AnonymousClass1(this));
    L15:
        if (r7 >= this.l) goto L17;
        this.j[r7] = this.k[r7];
        r7 = r7 + 1;
        goto L15
    }

    private void f(SolverVariable r6) {
        int r1 = 0;
    L4:
        if (r1 >= this.l) goto L13;
        if (this.j[r1] == r6) goto L7;
        r1 = r1 + 1;
    L7:
        int r2 = this.l;
        if (r1 >= (r2 - 1)) goto L10;
        SolverVariable[] r3 = this.j;
        int r4 = r1 + 1;
        r3[r1] = r3[r4];
        r1 = r4;
        goto L7
    L10:
        this.l = r2 - 1;
        r6.f13516a = false;
        return;
    }

    @Override // com.obric.oui.constraintlayout.core.b, com.obric.oui.constraintlayout.core.d.a
    public SolverVariable a(d r5, boolean[] r6) {
        int r0 = 0;
        int r1 = -1;
    L4:
        if (r0 >= this.l) goto L17;
        SolverVariable r2 = this.j[r0];
        if (r6[r2.f13517b] == true) goto L16;
        this.g.a(r2);
        a r3 = this.g;
        if (r1 != (-1)) goto L14;
        if (r3.a() == false) goto L16;
    L15:
        r1 = r0;
        goto L16
    L14:
        if (r3.b(this.j[r1]) == true) goto L15;
    L16:
        r0 = r0 + 1;
        goto L4
    L17:
        if (r1 != (-1)) goto L21;
        return null;
    L21:
        return this.j[r1];
    }

    @Override // com.obric.oui.constraintlayout.core.b
    public void a(d r6, b r7, boolean r8) {
        SolverVariable r9 = r7.f13520a;
        if (r9 != null) goto L5;
        return;
    L5:
        b.a r10 = r7.e;
        int r0 = r10.c();
        int r1 = 0;
    L6:
        if (r1 >= r0) goto L11;
        SolverVariable r2 = r10.a(r1);
        float r3 = r10.b(r1);
        this.g.a(r2);
        if (this.g.a(r9, r3) == false) goto L10;
        e(r2);
    L10:
        this.f13521b += r7.f13521b * r3;
        r1 = r1 + 1;
        goto L6
    L11:
        f(r9);
    }

    @Override // com.obric.oui.constraintlayout.core.b, com.obric.oui.constraintlayout.core.d.a
    public void d(SolverVariable r4) {
        this.g.a(r4);
        this.g.b();
        r4.h[r4.d] = 1.0f;
        e(r4);
    }

    @Override // com.obric.oui.constraintlayout.core.b, com.obric.oui.constraintlayout.core.d.a
    public boolean e() {
        if (this.l != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.oui.constraintlayout.core.b, com.obric.oui.constraintlayout.core.d.a
    public void f() {
        this.l = 0;
        this.f13521b = 0.0f;
    }

    @Override // com.obric.oui.constraintlayout.core.b
    public String toString() {
        String r0 = " goal -> (" + this.f13521b + ") : ";
        int r1 = 0;
    L4:
        if (r1 >= this.l) goto L6;
        this.g.a(this.j[r1]);
        r0 = r0 + this.g + " ";
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    }
}
