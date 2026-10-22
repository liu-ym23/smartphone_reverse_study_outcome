package com.bytedance.android.ec.core.imagex.common;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class w<T> {
    public final Set<T> a;
    public final T b;

    public w(T r10) {
        this.b = r10;
        LinkedHashSet r0 = new LinkedHashSet();
        this.a = r0;
        if (r10 == null) goto L6;
        r0.add(r10);
        return;
    }

    public final void a(Function1<? super T, Unit> r10) {
        Intrinsics.checkNotNullParameter(r10, "block");
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        T r1 = r0.next();
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L8
        r10.invoke(r1);     // Catch: Throwable -> L8
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L4
    }
}
