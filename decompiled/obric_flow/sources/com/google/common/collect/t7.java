package com.google.common.collect;

import java.util.Map;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class t7 implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9170a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Consumer f9171b;

    public /* synthetic */ t7(Consumer r5, int r10) {
        this.f9170a = r10;
        this.f9171b = r5;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object r5) {
        switch(this.f9170a) {
            case 0: goto L8;
            default: goto L4;
        };
    L4:
        y7 r10 = (y7) r5;
        Object r11 = r10.getElement();
        int r12 = r10.getCount();
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L7;
        this.f9171b.accept(r11);
        r13 = r13 + 1;
        goto L5
    L7:
        return;
    L8:
        Object r14 = ((Map.Entry) r5).getKey();
        this.f9171b.accept(r14);
    }
}
