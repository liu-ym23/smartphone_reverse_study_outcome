package com.bytedance.android.livesdk.gift.platform.core.preview;

import java.util.Collections;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i {
    public static final <T> List<T> b(Iterable<? extends T> r1, Iterable<? extends T> r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$subtractWithSort");
        Intrinsics.checkNotNullParameter(r2, "other");
        List<T> r3 = CollectionsKt.toMutableList(r1);
        r3.removeAll(CollectionsKt.intersect(r3, CollectionsKt.toSet(r2)));
        return r3;
    }

    public static final <T> void a(List<T> r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "$this$move");
        if (r4 != r5) goto L5;
        return;
    L5:
        IntProgression r6 = IntProgression.Companion.fromClosedRange(r4, r5, Intrinsics.compare(r5, r4));
        int r0 = r6.getFirst();
        int r1 = r6.getLast();
        int r7 = r6.getStep();
        if (r7 < 0) goto L9;
        if (r0 <= r1) goto L10;
        return;
    L10:
        Collections.swap(r3, r4, r0);
        if (r0 == r1) goto L17;
        int r2 = r0;
        r0 = r0 + r7;
        r4 = r2;
        goto L10
    L17:
        return;
    L9:
        if (r0 >= r1) goto L10;
    }
}
