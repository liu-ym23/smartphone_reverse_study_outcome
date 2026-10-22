package com.google.common.collect;

import java.util.function.IntFunction;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class t0 implements IntFunction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9160a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ArrayTable f9161b;

    public /* synthetic */ t0(ArrayTable r5, int r10) {
        this.f9160a = r10;
        this.f9161b = r5;
    }

    @Override // java.util.function.IntFunction
    public final Object apply(int r5) {
        int r10 = this.f9160a;
        ArrayTable r11 = this.f9161b;
        switch(r10) {
            case 0: goto L7;
            default: goto L4;
        };
    L4:
        r11.getClass();
        return new v0(r11, r5);
    L7:
        return r11.a(r5);
    }
}
