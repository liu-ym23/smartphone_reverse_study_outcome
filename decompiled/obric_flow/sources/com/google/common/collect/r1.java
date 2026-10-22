package com.google.common.collect;

import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class r1 implements IntConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9140a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Consumer f9141b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ IntFunction f9142c;

    public /* synthetic */ r1(Consumer r5, IntFunction r10, int r11) {
        this.f9140a = r11;
        this.f9141b = r5;
        this.f9142c = r10;
    }

    @Override // java.util.function.IntConsumer
    public final void accept(int r5) {
        switch(this.f9140a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        Object r10 = this.f9142c.apply(r5);
        this.f9141b.accept(r10);
        return;
    L6:
        Object r11 = this.f9142c.apply(r5);
        this.f9141b.accept(r11);
    }
}
