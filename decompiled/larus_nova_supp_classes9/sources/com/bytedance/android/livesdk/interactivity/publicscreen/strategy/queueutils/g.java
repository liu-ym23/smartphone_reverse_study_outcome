package com.bytedance.android.livesdk.interactivity.publicscreen.strategy.queueutils;

import java.util.Queue;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g extends k {
    public g(com.bytedance.android.livesdk.interactivity.api.settings.config.m r2) {
        Intrinsics.checkNotNullParameter(r2, "config");
        super(r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.strategy.queueutils.k
    public final void a(Queue<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> r6, Queue<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> r7, Queue<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> r8, Queue<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> r9) {
        Intrinsics.checkNotNullParameter(r6, "highQueue");
        Intrinsics.checkNotNullParameter(r7, "midQueue");
        Intrinsics.checkNotNullParameter(r8, "lowQueue");
        Intrinsics.checkNotNullParameter(r9, "targetBuffer");
        int r0 = Math.min(r8.size(), this.b.lowPriorityCount);
        int r1 = 0;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        this.a.add(r8.poll());
        r2 = r2 + 1;
        goto L3
    L5:
        int r10 = Math.min(5 - this.a.size(), r6.size() + r7.size());
    L6:
        if (r1 >= r10) goto L9;
        int r3 = ScrollComposePriorityQueue.g;
        this.a.add((com.bytedance.android.livesdk.interactivity.api.entity.f) ((Queue) ComparisonsKt.minOf(r6, r7, ScrollComposePriorityQueue.a.a)).poll());
        r1 = r1 + 1;
    L9:
        if ((!this.a.isEmpty()) == false) goto L11;
        r9.add(this.a.poll());
        goto L9
    L11:
        this.a.clear();
    }
}
