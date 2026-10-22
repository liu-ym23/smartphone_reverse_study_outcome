package com.bytedance.android.ec.core.utils;

import io.reactivex.functions.Function;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class s1<T, R> implements Function {
    public final /* synthetic */ List a;

    public s1(List r1) {
        this.a = r1;
    }

    public final Object apply(Object r10) {
        Object[] r11 = (Object[]) r10;
        Intrinsics.checkNotNullParameter(r11, "rets");
        Iterator<T> r12 = ArraysKt.sortedWith(r11, new r1()).iterator();
    L4:
        if (r12.hasNext() == false) goto L12;
        T r0 = r12.next();
        if ((r0 instanceof m1) == true) goto L8;
        r0 = (T) null;
    L8:
        m1 r1 = r0;
        if (r1 == null) goto L4;
        p1.c.d(r1.c, r1.b);
        this.a.add(r1.b);
        goto L4
    L12:
        return Unit.INSTANCE;
    }
}
