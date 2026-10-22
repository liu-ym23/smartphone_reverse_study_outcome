package com.google.android.material.color.utilities;

import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class g implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8546a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MaterialDynamicColors f8547b;

    public /* synthetic */ g(MaterialDynamicColors r5, int r10) {
        this.f8546a = r10;
        this.f8547b = r5;
    }

    @Override // java.util.function.Function
    public final Object apply(Object r5) {
        int r10 = this.f8546a;
        MaterialDynamicColors r11 = this.f8547b;
        DynamicScheme r12 = (DynamicScheme) r5;
        switch(r10) {
            case 0: goto L25;
            case 1: goto L23;
            case 2: goto L21;
            case 3: goto L19;
            case 4: goto L17;
            case 5: goto L15;
            case 6: goto L13;
            case 7: goto L11;
            case 8: goto L9;
            case 9: goto L7;
            default: goto L5;
        };
    L5:
        return r11.highestSurface(r12);
    L7:
        return MaterialDynamicColors.y0(r11, r12);
    L9:
        return MaterialDynamicColors.f(r11, r12);
    L11:
        return MaterialDynamicColors.a(r11, r12);
    L13:
        return MaterialDynamicColors.s0(r11, r12);
    L15:
        return MaterialDynamicColors.f1(r11, r12);
    L17:
        return MaterialDynamicColors.A0(r11, r12);
    L19:
        return MaterialDynamicColors.J1(r11, r12);
    L21:
        return MaterialDynamicColors.h(r11, r12);
    L23:
        return MaterialDynamicColors.v1(r11, r12);
    L25:
        return MaterialDynamicColors.q1(r11, r12);
    }
}
