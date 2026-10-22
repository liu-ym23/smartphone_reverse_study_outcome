package com.google.android.material.color.utilities;

import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class c implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8541a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MaterialDynamicColors f8542b;

    public /* synthetic */ c(MaterialDynamicColors r5, int r10) {
        this.f8541a = r10;
        this.f8542b = r5;
    }

    @Override // java.util.function.Function
    public final Object apply(Object r5) {
        int r10 = this.f8541a;
        MaterialDynamicColors r11 = this.f8542b;
        DynamicScheme r12 = (DynamicScheme) r5;
        switch(r10) {
            case 0: goto L63;
            case 1: goto L61;
            case 2: goto L59;
            case 3: goto L57;
            case 4: goto L55;
            case 5: goto L53;
            case 6: goto L51;
            case 7: goto L49;
            case 8: goto L47;
            case 9: goto L45;
            case 10: goto L43;
            case 11: goto L41;
            case 12: goto L39;
            case 13: goto L37;
            case 14: goto L35;
            case 15: goto L33;
            case 16: goto L31;
            case 17: goto L29;
            case 18: goto L27;
            case 19: goto L25;
            case 20: goto L23;
            case 21: goto L21;
            case 22: goto L19;
            case 23: goto L17;
            case 24: goto L15;
            case 25: goto L13;
            case 26: goto L11;
            case 27: goto L9;
            case 28: goto L7;
            default: goto L5;
        };
    L5:
        return MaterialDynamicColors.J(r11, r12);
    L7:
        return MaterialDynamicColors.e1(r11, r12);
    L9:
        return MaterialDynamicColors.x(r11, r12);
    L11:
        return MaterialDynamicColors.f0(r11, r12);
    L13:
        return MaterialDynamicColors.S1(r11, r12);
    L15:
        return MaterialDynamicColors.u(r11, r12);
    L17:
        return MaterialDynamicColors.Q(r11, r12);
    L19:
        return MaterialDynamicColors.E1(r11, r12);
    L21:
        return MaterialDynamicColors.Z0(r11, r12);
    L23:
        return MaterialDynamicColors.o(r11, r12);
    L25:
        return MaterialDynamicColors.S(r11, r12);
    L27:
        return MaterialDynamicColors.z1(r11, r12);
    L29:
        return MaterialDynamicColors.y(r11, r12);
    L31:
        return MaterialDynamicColors.H0(r11, r12);
    L33:
        return MaterialDynamicColors.m1(r11, r12);
    L35:
        return MaterialDynamicColors.X1(r11, r12);
    L37:
        return MaterialDynamicColors.o0(r11, r12);
    L39:
        return MaterialDynamicColors.B(r11, r12);
    L41:
        return MaterialDynamicColors.D(r11, r12);
    L43:
        return MaterialDynamicColors.V0(r11, r12);
    L45:
        return MaterialDynamicColors.B0(r11, r12);
    L47:
        return MaterialDynamicColors.K1(r11, r12);
    L49:
        return MaterialDynamicColors.m(r11, r12);
    L51:
        return MaterialDynamicColors.i0(r11, r12);
    L53:
        return MaterialDynamicColors.g1(r11, r12);
    L55:
        return MaterialDynamicColors.L1(r11, r12);
    L57:
        return MaterialDynamicColors.Q1(r11, r12);
    L59:
        return MaterialDynamicColors.A1(r11, r12);
    L61:
        return MaterialDynamicColors.C(r11, r12);
    L63:
        return MaterialDynamicColors.Z1(r11, r12);
    }
}
