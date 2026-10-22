package com.bytedance.android.live.broadcastgame.opengame.runtime;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class i<T> implements InvocationHandler {
    public final List<T> a;

    public i(List<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "listeners");
        this.a = r2;
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object r6, Method r7, Object[] r8) {
        Intrinsics.checkNotNullParameter(r6, "p0");
        Intrinsics.checkNotNullParameter(r7, "method");
        Iterator<T> r9 = this.a.iterator();
        Object r1 = null;
    L4:
        if (r9.hasNext() == false) goto L16;
        T r2 = r9.next();
        if (r8 == null) goto L8;
        Integer r3 = Integer.valueOf(r8.length);
    L10:
        if (r3 == null) goto L11;
        if (r3.intValue() == 1) goto L14;
        r1 = r7.invoke(r2, new Object[]{r8});
        goto L4
    L14:
        r1 = r7.invoke(r2, new Object[]{r8[0]});
        goto L4
    L11:
        r1 = r7.invoke(r2, new Object[0]);
        goto L4
    L8:
        r3 = null;
        goto L10
    L16:
        return r1;
    }
}
