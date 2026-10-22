package com.google.common.cache;

import java.util.concurrent.atomic.AtomicLong;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.LongUnaryOperator;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class l implements BiFunction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8727a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f8728b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f8729c;

    public /* synthetic */ l(int r5, Object r10, Object r11) {
        this.f8727a = r5;
        this.f8728b = r10;
        this.f8729c = r11;
    }

    @Override // java.util.function.BiFunction
    public final Object apply(Object r5, Object r10) {
        switch(this.f8727a) {
            case 0: goto L13;
            case 1: goto L10;
            default: goto L4;
        };
    L4:
        Long r11 = (Long) r10;
        if (r11 != null) goto L7;
        long r12 = 0;
    L8:
        ((AtomicLong) this.f8728b).set(r12);
        return Long.valueOf(((LongUnaryOperator) this.f8729c).applyAsLong(r12));
    L7:
        r12 = r11.longValue();
        goto L8
    L10:
        if (r10 == null) goto L12;
        return r10;
    L12:
        return ((Function) this.f8729c).apply(this.f8728b);
    L13:
        Object r13 = this.f8728b;
        if (r10 != null) goto L17;
        return r13;
    L17:
        return ((BiFunction) this.f8729c).apply(r10, r13);
    }

    public /* synthetic */ l(Object r5, Function r10) {
        this.f8727a = 1;
        this.f8729c = r10;
        this.f8728b = r5;
    }
}
