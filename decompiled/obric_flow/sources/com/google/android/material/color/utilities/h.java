package com.google.android.material.color.utilities;

import com.google.common.math.l;
import com.squareup.javapoet.i;
import java.util.ArrayList;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class h implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8548a;

    public /* synthetic */ h(int r5) {
        this.f8548a = r5;
    }

    @Override // java.util.function.Function
    public final Object apply(Object r5) {
        switch(this.f8548a) {
            case 0: goto L13;
            case 1: goto L11;
            case 2: goto L9;
            case 3: goto L6;
            default: goto L5;
        };
    L6:
        String r10 = (String) r5;
        return new ArrayList();
    L5:
        return new i(((com.squareup.javapoet.h) r5).f14968b);
    L9:
        return ((l) r5).d();
    L11:
        return MaterialDynamicColors.h1((DynamicScheme) r5);
    L13:
        return MaterialDynamicColors.P1((DynamicScheme) r5);
    }
}
