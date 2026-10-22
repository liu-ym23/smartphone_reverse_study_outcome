package com.bytedance.android.livesdk.interactivity.publicscreen.strategy.queueutils;

import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.n;
import java.util.Iterator;
import java.util.Queue;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class DoubleHitStrategy extends k {
    public DoubleHitStrategy(com.bytedance.android.livesdk.interactivity.api.settings.config.m r2) {
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
        int r10 = Math.min(this.b.highPriorityCount, r6.size());
        int r3 = 0;
    L6:
        if (r3 >= r10) goto L8;
        this.a.add(r6.poll());
        r3 = r3 + 1;
        goto L6
    L8:
        int r11 = Math.min(r7.size(), 5 - this.a.size());
        int r4 = 0;
    L9:
        if (r4 >= r11) goto L11;
        this.a.add(r7.poll());
        r4 = r4 + 1;
        goto L9
    L11:
        int r13 = Math.min(r6.size(), 5 - this.a.size());
    L12:
        if (r1 >= r13) goto L15;
        this.a.add(r6.poll());
        r1 = r1 + 1;
    L15:
        if ((!this.a.isEmpty()) == false) goto L18;
        r9.add(this.a.poll());
        goto L15
    L18:
        if (v.a() == false) goto L26;
        boolean r14 = n.a;
        if (n.a == false) goto L26;
        n.b(DoubleHitStrategy$fillBuffer$1.INSTANCE);
        Iterator r15 = r9.iterator();
    L23:
        if (r15.hasNext() == false) goto L25;
        final com.bytedance.android.livesdk.interactivity.api.entity.f r16 = (com.bytedance.android.livesdk.interactivity.api.entity.f) r15.next();
        n.b(new DoubleHitStrategy$fillBuffer$2$1(r16));
        goto L23
    L25:
        n.b(DoubleHitStrategy$fillBuffer$3.INSTANCE);
    L26:
        this.a.clear();
    }
}
