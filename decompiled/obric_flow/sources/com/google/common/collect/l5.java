package com.google.common.collect;

import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class l5 implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9061a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BiConsumer f9062b;

    public /* synthetic */ l5(BiConsumer r5, int r10) {
        this.f9061a = r10;
        this.f9062b = r5;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object r5) {
        Map.Entry r10 = (Map.Entry) r5;
        switch(this.f9061a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        Object r11 = r10.getKey();
        Object r12 = r10.getValue();
        this.f9062b.accept(r11, r12);
        return;
    L6:
        Object r13 = r10.getKey();
        Object r14 = r10.getValue();
        this.f9062b.accept(r13, r14);
    }
}
