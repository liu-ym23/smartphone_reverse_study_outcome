package com.obric.oui.constraintlayout.core.widgets;

/* JADX INFO: loaded from: classes5.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static boolean[] f13643a;

    static {
        f13643a = new boolean[3];
    }

    static void a(d r5, com.obric.oui.constraintlayout.core.d r6, ConstraintWidget r7) {
        r7.l = -1;
        r7.m = -1;
        if (r5.L[0] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L8;
        if (r7.L[0] != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L8;
        int r0 = r7.B.d;
        int r1 = r5.F() - r7.D.d;
        ConstraintAnchor r2 = r7.B;
        r2.f = r6.a(r7.B);
        ConstraintAnchor r3 = r7.D;
        r3.f = r6.a(r7.D);
        r6.a(r7.B.f, r0);
        r6.a(r7.D.f, r1);
        r7.l = 2;
        r7.f(r0, r1);
    L8:
        if (r5.L[1] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L10;
        return;
    L10:
        if (r7.L[1] != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L19;
        int r4 = r7.C.d;
        int r8 = r5.G() - r7.E.d;
        ConstraintAnchor r9 = r7.C;
        r9.f = r6.a(r7.C);
        ConstraintAnchor r10 = r7.E;
        r10.f = r6.a(r7.E);
        r6.a(r7.C.f, r4);
        r6.a(r7.E.f, r8);
        if (r7.X <= 0) goto L14;
    L15:
        ConstraintAnchor r11 = r7.F;
        r11.f = r6.a(r7.F);
        r6.a(r7.F.f, r7.X + r4);
    L16:
        r7.m = 2;
        r7.g(r4, r8);
        return;
    L14:
        if (r7.B() != 8) goto L16;
    }

    public static final boolean a(int r0, int r1) {
        if ((r0 & r1) != r1) goto L5;
        return true;
    L5:
        return false;
    }
}
