package com.bytedance.android.livesdk.interactivity.common.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class k {
    public static final <T> List<T> c(Queue<T> r3, Function1<? super T, Boolean> r4) {
        Intrinsics.checkNotNullParameter(r3, "$this$removeUntil");
        Intrinsics.checkNotNullParameter(r4, "predicate");
        ArrayList r0 = new ArrayList();
        Iterator<T> r5 = r3.iterator();
    L4:
        if (r5.hasNext() == false) goto L9;
        T r1 = r5.next();
        if (((Boolean) r4.invoke(r1)).booleanValue() == true) goto L9;
        r5.remove();
        r0.add(r1);
    L9:
        return r0;
    }

    public static final <T> List<T> d(Queue<T> r3, Function1<? super T, Boolean> r4) {
        Intrinsics.checkNotNullParameter(r3, "$this$removeWith");
        Intrinsics.checkNotNullParameter(r4, "predicate");
        ArrayList r0 = new ArrayList();
        Iterator<T> r5 = r3.iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        T r1 = r5.next();
        if (((Boolean) r4.invoke(r1)).booleanValue() == false) goto L4;
        r5.remove();
        r0.add(r1);
        goto L4
    L8:
        return r0;
    }

    public static final <T> int b(Queue<T> r3, int r4, List<T> r5) {
        Intrinsics.checkNotNullParameter(r3, "$this$pollBatch");
        Intrinsics.checkNotNullParameter(r5, "pollList");
        int r6 = RangesKt.coerceAtMost(r4, r3.size());
        if (r6 <= 0) goto L10;
        int r0 = 0;
    L5:
        if (r0 >= r6) goto L10;
        T r1 = r3.poll();
        if (r1 == null) goto L9;
        ((ArrayList) r5).add(r1);
    L9:
        r0 = r0 + 1;
    L10:
        return r6;
    }

    public static final <T> void a(Queue<T> r3, int r4, T r5, Function2<? super T, ? super List<? extends T>, Unit> r6) {
        Intrinsics.checkNotNullParameter(r3, "$this$addWithCheckMaxSize");
        Intrinsics.checkNotNullParameter(r6, "callback");
        r3.add(r5);
        if (r3.size() <= r4) goto L13;
        ArrayList r0 = new ArrayList();
        int r1 = r3.size() - r4;
        if (r1 <= 0) goto L12;
        int r7 = 0;
    L7:
        if (r7 >= r1) goto L12;
        T r2 = r3.poll();
        if (r2 == null) goto L11;
        r0.add(r2);
    L11:
        r7 = r7 + 1;
    L12:
        r6.invoke(r5, r0);
        return;
    L13:
        r6.invoke(r5, null);
    }
}
