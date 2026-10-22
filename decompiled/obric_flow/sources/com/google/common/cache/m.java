package com.google.common.cache;

import java.util.function.BiFunction;
import java.util.function.LongUnaryOperator;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class m implements BiFunction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8731a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f8732b;

    public /* synthetic */ m(Object r5, int r10) {
        this.f8731a = r10;
        this.f8732b = r5;
    }

    @Override // java.util.function.BiFunction
    public final Object apply(Object r5, Object r10) {
        switch(this.f8731a) {
            case 0: goto L10;
            default: goto L4;
        };
    L4:
        Long r11 = (Long) r10;
        if (r11 != null) goto L7;
        long r12 = 0;
    L9:
        return Long.valueOf(((LongUnaryOperator) this.f8732b).applyAsLong(r12));
    L7:
        r12 = r11.longValue();
        goto L9
    L10:
        if (r10 != null) goto L13;
        return null;
    L13:
        return ((BiFunction) this.f8732b).apply(r5, r10);
    }
}
