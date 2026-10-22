package com.google.common.collect;

import java.util.function.Consumer;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class o1 implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9098a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Consumer f9099b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function f9100c;

    public /* synthetic */ o1(Consumer r5, Function r10, int r11) {
        this.f9098a = r11;
        this.f9099b = r5;
        this.f9100c = r10;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object r5) {
        switch(this.f9098a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        Object r10 = this.f9100c.apply(r5);
        this.f9099b.accept(r10);
        return;
    L6:
        Object r11 = this.f9100c.apply(r5);
        this.f9099b.accept(r11);
    }
}
