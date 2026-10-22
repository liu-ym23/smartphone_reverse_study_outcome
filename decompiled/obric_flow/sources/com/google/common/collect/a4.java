package com.google.common.collect;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class a4 implements BiConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8886a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Consumer f8887b;

    public /* synthetic */ a4(Consumer r5, int r10) {
        this.f8886a = r10;
        this.f8887b = r5;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object r5, Object r10) {
        Consumer r11 = this.f8887b;
        switch(this.f8886a) {
            case 0: goto L10;
            case 1: goto L8;
            case 2: goto L6;
            default: goto L4;
        };
    L4:
        r11.accept(r10);
        return;
    L6:
        r11.accept(r5);
        return;
    L8:
        int r12 = ImmutableMapValues.f8827b;
        r11.accept(r10);
        return;
    L10:
        int r13 = ImmutableMapKeySet.f8826c;
        r11.accept(r5);
    }
}
