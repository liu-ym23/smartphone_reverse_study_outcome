package com.google.common.collect;

import java.util.function.ToIntFunction;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class g4 implements ToIntFunction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8990a;

    public /* synthetic */ g4(int r5) {
        this.f8990a = r5;
    }

    @Override // java.util.function.ToIntFunction
    public final int applyAsInt(Object r5) {
        switch(this.f8990a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        int r10 = ImmutableSortedMultiset.e;
        return 1;
    L6:
        int r11 = ImmutableMultiset.d;
        return 1;
    }
}
