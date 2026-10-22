package com.google.android.material.color.utilities;

import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class a implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8538a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f8539b;

    public /* synthetic */ a(Object r5, int r10) {
        this.f8538a = r10;
        this.f8539b = r5;
    }

    @Override // java.util.function.Function
    public final Object apply(Object r5) {
        int r10 = this.f8538a;
        Object r11 = this.f8539b;
        switch(r10) {
            case 0: goto L9;
            case 1: goto L7;
            default: goto L5;
        };
    L5:
        return TemperatureCache.a((TemperatureCache) r11, (Hct) r5);
    L7:
        return DynamicColor.a((Hct) r11, (DynamicScheme) r5);
    L9:
        return DynamicColor.b((TonalPalette) r11, (DynamicScheme) r5);
    }
}
