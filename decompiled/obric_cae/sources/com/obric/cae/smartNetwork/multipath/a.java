package com.obric.cae.smartNetwork.multipath;

import java.util.function.ToIntFunction;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class a implements ToIntFunction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5770a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f5771b;

    public /* synthetic */ a(int r8, int r10) {
        this.f5770a = r10;
        this.f5771b = r8;
    }

    @Override // java.util.function.ToIntFunction
    public final int applyAsInt(Object r8) {
        int r10 = this.f5770a;
        int r11 = this.f5771b;
        switch(r10) {
            case 0: goto L6;
            default: goto L8;
        };
    L6:
        return MPAJitterEvaluate.a(r11, (Integer) r8);
    L8:
        return MPAJitterEvaluate.b(r11, (Integer) r8);
    }
}
