package com.google.common.collect;

import java.util.function.Function;
import java.util.stream.Stream;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class h1 implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9002a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function f9003b;

    public /* synthetic */ h1(Function r5, int r10) {
        this.f9002a = r10;
        this.f9003b = r5;
    }

    @Override // java.util.function.Function
    public final Object apply(Object r5) {
        switch(this.f9002a) {
            case 0: goto L10;
            case 1: goto L9;
            case 2: goto L6;
            default: goto L5;
        };
    L6:
        Object r10 = this.f9003b.apply(r5);
        r10.getClass();
        return r10;
    L10:
        Object r11 = this.f9003b.apply(r5);
        r11.getClass();
        return r11;
    L5:
        return ((Stream) this.f9003b.apply(r5)).peek(new l1());
    L9:
        return ((Stream) this.f9003b.apply(r5)).peek(new l1());
    }
}
