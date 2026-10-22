package com.bytedance.android.livesdk.interactivity.publicscreen.strategy.queueutils;

import java.util.Queue;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f extends k {
    public f(com.bytedance.android.livesdk.interactivity.api.settings.config.m r2) {
        Intrinsics.checkNotNullParameter(r2, "config");
        super(r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.strategy.queueutils.k
    public final void a(Queue<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> r8, Queue<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> r9, Queue<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> r10, Queue<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> r11) {
        Intrinsics.checkNotNullParameter(r8, "highQueue");
        Intrinsics.checkNotNullParameter(r9, "midQueue");
        Intrinsics.checkNotNullParameter(r10, "lowQueue");
        Intrinsics.checkNotNullParameter(r11, "targetBuffer");
        int r1 = 0;
        if (((r8.size() + r9.size()) + r10.size()) > 5) goto L13;
        int r0 = r8.size();
        int r2 = 0;
    L5:
        if (r2 >= r0) goto L7;
        this.a.add(r8.poll());
        r2 = r2 + 1;
        goto L5
    L7:
        int r13 = r9.size();
        int r3 = 0;
    L8:
        if (r3 >= r13) goto L10;
        this.a.add(r9.poll());
        r3 = r3 + 1;
        goto L8
    L10:
        int r14 = r10.size();
    L11:
        if (r1 >= r14) goto L23;
        this.a.add(r10.poll());
        r1 = r1 + 1;
    L23:
        if ((!this.a.isEmpty()) == false) goto L25;
        r11.add(this.a.poll());
        goto L23
    L25:
        this.a.clear();
        return;
    L13:
        int r4 = this.b.highPriorityCount;
        int r5 = r9.size() + r10.size();
        int r6 = Math.min(r4, r8.size());
        int r7 = 0;
    L14:
        if (r7 >= r6) goto L16;
        this.a.add(r8.poll());
        r7 = r7 + 1;
        goto L14
    L16:
        int r15 = Math.min(5 - this.a.size(), r5);
        int r16 = 0;
    L17:
        if (r16 >= r15) goto L19;
        int r17 = ScrollComposePriorityQueue.g;
        this.a.add((com.bytedance.android.livesdk.interactivity.api.entity.f) ((Queue) ComparisonsKt.minOf(r9, r10, ScrollComposePriorityQueue.a.a)).poll());
        r16 = r16 + 1;
        goto L17
    L19:
        int r18 = Math.min(5 - this.a.size(), r8.size());
    L20:
        if (r1 >= r18) goto L23;
        this.a.add(r8.poll());
        r1 = r1 + 1;
        goto L20
    }
}
