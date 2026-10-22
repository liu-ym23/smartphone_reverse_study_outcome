package com.bytedance.android.livesdk.interactivity.publicscreen.strategy.queueutils;

import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.n;
import java.util.Iterator;
import java.util.Queue;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class NormalStrategy extends k {
    public NormalStrategy(com.bytedance.android.livesdk.interactivity.api.settings.config.m r2) {
        Intrinsics.checkNotNullParameter(r2, "config");
        super(r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.strategy.queueutils.k
    public final void a(Queue<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> r4, Queue<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> r5, Queue<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> r6, Queue<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> r7) {
        Intrinsics.checkNotNullParameter(r4, "highQueue");
        Intrinsics.checkNotNullParameter(r5, "midQueue");
        Intrinsics.checkNotNullParameter(r6, "lowQueue");
        Intrinsics.checkNotNullParameter(r7, "targetBuffer");
        int r0 = Math.min((r4.size() + r5.size()) + r6.size(), 5);
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L6;
        int r2 = ScrollComposePriorityQueue.g;
        r7.add((com.bytedance.android.livesdk.interactivity.api.entity.f) ((Queue) ComparisonsKt.minOf(r4, r5, r6, ScrollComposePriorityQueue.a.a)).poll());
        r1 = r1 + 1;
        goto L3
    L6:
        if (v.a() == false) goto L17;
        boolean r8 = n.a;
        if (n.a == false) goto L18;
        n.b(NormalStrategy$fillBuffer$1.INSTANCE);
        Iterator<T> r9 = r7.iterator();
    L11:
        if (r9.hasNext() == false) goto L13;
        final com.bytedance.android.livesdk.interactivity.api.entity.f r10 = (com.bytedance.android.livesdk.interactivity.api.entity.f) r9.next();
        n.b(new NormalStrategy$fillBuffer$2$1(r10));
        goto L11
    L13:
        n.b(NormalStrategy$fillBuffer$3.INSTANCE);
        return;
    L18:
        return;
    }
}
