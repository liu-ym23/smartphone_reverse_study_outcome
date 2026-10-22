package com.google.common.collect;

import java.util.Collection;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.ObjIntConsumer;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class m1 implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9066a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f9067b;

    public /* synthetic */ m1(Object r5, int r10) {
        this.f9066a = r10;
        this.f9067b = r5;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object r5) {
        switch(this.f9066a) {
            case 0: goto L8;
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        y7 r10 = (y7) r5;
        Object r11 = r10.getElement();
        int r12 = r10.getCount();
        ((ObjIntConsumer) this.f9067b).accept(r11, r12);
        return;
    L6:
        u1 r13 = (u1) this.f9067b;
        r13.f9176a = (Spliterator) r13.f9178c.apply(r5);
        return;
    L8:
        ((Collection) this.f9067b).add(r5);
    }
}
