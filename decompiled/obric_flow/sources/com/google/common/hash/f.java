package com.google.common.hash;

import java.util.function.BinaryOperator;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class f implements BinaryOperator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9286a;

    public /* synthetic */ f(int r5) {
        this.f9286a = r5;
    }

    @Override // java.util.function.BiFunction
    public final Object apply(Object r5, Object r10) {
        switch(this.f9286a) {
            case 0: goto L13;
            case 1: goto L11;
            default: goto L4;
        };
    L4:
        com.squareup.javapoet.h r11 = (com.squareup.javapoet.h) r5;
        r11.getClass();
        com.squareup.javapoet.i r12 = new com.squareup.javapoet.i(((com.squareup.javapoet.h) r10).f14968b);
        if (r12.f14971a.isEmpty() == true) goto L10;
        boolean r13 = r11.f14969c;
        com.squareup.javapoet.g r14 = r11.f14968b;
        if (r13 == true) goto L9;
        r14.b(r11.f14967a, new Object[0]);
    L9:
        r11.f14969c = false;
        r14.a(r12);
    L10:
        return r11;
    L11:
        com.google.common.math.l r15 = (com.google.common.math.l) r5;
        r15.b((com.google.common.math.l) r10);
        return r15;
    L13:
        BloomFilter r16 = (BloomFilter) r5;
        r16.putAll((BloomFilter) r10);
        return r16;
    }
}
