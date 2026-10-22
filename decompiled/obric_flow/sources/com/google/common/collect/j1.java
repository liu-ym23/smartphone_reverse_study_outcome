package com.google.common.collect;

import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.ToIntFunction;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class j1 implements BiConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9032a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f9033b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f9034c;

    public /* synthetic */ j1(int r5, Object r10, Object r11) {
        this.f9032a = r5;
        this.f9033b = r10;
        this.f9034c = r11;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object r5, Object r10) {
        Object r11 = this.f9034c;
        Object r12 = this.f9033b;
        switch(this.f9032a) {
            case 0: goto L8;
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        BiConsumer r13 = (BiConsumer) r11;
        r13.accept(r5, ((com.google.common.base.q) ((k7) r12).f9058b.f8976a).apply(r10));
        return;
    L6:
        int r14 = ImmutableSortedMultiset.e;
        Object r15 = ((Function) r12).apply(r10);
        r15.getClass();
        ((z7) r5).add(r15, ((ToIntFunction) r11).applyAsInt(r10));
        return;
    L8:
        Object r16 = ((Function) r12).apply(r10);
        r16.getClass();
        ((z7) r5).add(r16, ((ToIntFunction) r11).applyAsInt(r10));
    }
}
