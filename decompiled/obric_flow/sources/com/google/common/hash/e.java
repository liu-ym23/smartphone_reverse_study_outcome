package com.google.common.hash;

import java.util.function.BiConsumer;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class e implements BiConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9285a;

    public /* synthetic */ e(int r5) {
        this.f9285a = r5;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object r5, Object r10) {
        switch(this.f9285a) {
            case 0: goto L13;
            case 1: goto L11;
            case 2: goto L9;
            default: goto L4;
        };
    L4:
        com.squareup.javapoet.h r11 = (com.squareup.javapoet.h) r5;
        com.squareup.javapoet.i r12 = (com.squareup.javapoet.i) r10;
        boolean r13 = r11.f14969c;
        com.squareup.javapoet.g r14 = r11.f14968b;
        if (r13 == true) goto L7;
        r14.b(r11.f14967a, new Object[0]);
    L7:
        r11.f14969c = false;
        r14.a(r12);
        return;
    L9:
        ((com.google.common.math.l) r5).a(((Number) r10).doubleValue());
        return;
    L11:
        ((com.google.common.math.l) r5).b((com.google.common.math.l) r10);
        return;
    L13:
        ((BloomFilter) r5).put(r10);
    }
}
