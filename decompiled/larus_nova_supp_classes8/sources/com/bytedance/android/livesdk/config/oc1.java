package com.bytedance.android.livesdk.config;

import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class oc1 {
    public static final void a(List<nc1> r4, nc1 r5) {
        Intrinsics.checkNotNullParameter(r4, "$this$record");
        Intrinsics.checkNotNullParameter(r5, "record");
        Iterator<T> r0 = r4.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        nc1 r1 = (nc1) r0.next();
        if (Intrinsics.areEqual(r1.a(), r5.a()) == false) goto L4;
        r1.c(r5.b());
        return;
    L9:
        r4.add(r5);
    }
}
