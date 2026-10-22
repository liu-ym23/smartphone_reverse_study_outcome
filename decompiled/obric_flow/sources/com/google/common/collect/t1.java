package com.google.common.collect;

import java.util.Spliterator;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class t1 implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9162a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Consumer f9163b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f9164c;

    public /* synthetic */ t1(Object r5, Consumer r10, int r11) {
        this.f9162a = r11;
        this.f9164c = r5;
        this.f9163b = r10;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object r5) {
        switch(this.f9162a) {
            case 0: goto L10;
            case 1: goto L7;
            default: goto L4;
        };
    L4:
        Object r10 = ((com.google.common.base.q) this.f9164c).apply(r5);
        this.f9163b.accept(r10);
        return;
    L10:
        Spliterator r11 = (Spliterator) ((u1) this.f9164c).f9178c.apply(r5);
        if (r11 == null) goto L15;
        r11.forEachRemaining(this.f9163b);
        return;
    L15:
        return;
    L7:
        if (((com.google.common.base.z) this.f9164c).test(r5) == false) goto L14;
        this.f9163b.accept(r5);
        return;
    }

    public /* synthetic */ t1(Consumer r5, com.google.common.base.q r10) {
        this.f9162a = 2;
        this.f9163b = r5;
        this.f9164c = r10;
    }
}
