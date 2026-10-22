package com.bytedance.android.livesdk.interactivity.publicscreen.strategy.queueutils;

import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.n;
import java.util.Iterator;
import java.util.Queue;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class FoldStrategy extends k {
    public FoldStrategy(com.bytedance.android.livesdk.interactivity.api.settings.config.m r2) {
        Intrinsics.checkNotNullParameter(r2, "config");
        super(r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.strategy.queueutils.k
    public final void a(Queue<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> r5, Queue<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> r6, Queue<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> r7, Queue<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> r8) {
        Intrinsics.checkNotNullParameter(r5, "highQueue");
        Intrinsics.checkNotNullParameter(r6, "midQueue");
        Intrinsics.checkNotNullParameter(r7, "lowQueue");
        Intrinsics.checkNotNullParameter(r8, "targetBuffer");
        int r9 = RangesKt.coerceAtMost(r5.size(), this.b.personalizedFoldCount);
        int r0 = 0;
        int r1 = 0;
    L3:
        if (r1 >= r9) goto L5;
        this.a.add(r5.poll());
        r1 = r1 + 1;
        goto L3
    L5:
        int r10 = Math.min(5 - this.a.size(), r6.size());
        int r2 = 0;
    L6:
        if (r2 >= r10) goto L8;
        this.a.add(r6.poll());
        r2 = r2 + 1;
        goto L6
    L8:
        int r11 = Math.min(r5.size(), 5 - this.a.size());
    L9:
        if (r0 >= r11) goto L12;
        this.a.add(r5.poll());
        r0 = r0 + 1;
    L12:
        if ((!this.a.isEmpty()) == false) goto L15;
        r8.add(this.a.poll());
        goto L12
    L15:
        if (v.a() == false) goto L23;
        boolean r13 = n.a;
        if (n.a == false) goto L23;
        n.b(FoldStrategy$fillBuffer$1.INSTANCE);
        Iterator r14 = r8.iterator();
    L20:
        if (r14.hasNext() == false) goto L22;
        final com.bytedance.android.livesdk.interactivity.api.entity.f r15 = (com.bytedance.android.livesdk.interactivity.api.entity.f) r14.next();
        n.b(new FoldStrategy$fillBuffer$2$1(r15));
        goto L20
    L22:
        n.b(FoldStrategy$fillBuffer$3.INSTANCE);
    L23:
        this.a.clear();
    }
}
