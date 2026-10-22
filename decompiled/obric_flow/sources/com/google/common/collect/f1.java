package com.google.common.collect;

import java.util.function.BiConsumer;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class f1 implements BiConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8964a;

    public /* synthetic */ f1(int r5) {
        this.f8964a = r5;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object r5, Object r10) {
        switch(this.f8964a) {
            case 0: goto L10;
            case 1: goto L8;
            case 2: goto L6;
            default: goto L4;
        };
    L4:
        ((y4) r5).F0(r10);
        return;
    L6:
        m4 r11 = (m4) r5;
        Range r12 = (Range) r10;
        r11.getClass();
        com.google.common.base.b0.h("range must not be empty, but was %s", !r12.isEmpty(), r12);
        r11.f9072a.add(r12);
        return;
    L8:
        ((n4) r5).B0(r10);
        return;
    L10:
        ((u3) r5).B0(r10);
    }
}
