package com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.consumechain;

import com.bytedance.android.livesdk.link.model.i6;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f {
    public final EventProcessorDispatch<i6> a;
    public final EventProcessorDispatch<j> b;
    public final EventProcessorDispatch<j> c;
    public final EventProcessorDispatch<r> d;
    public final EventProcessorDispatch<r> e;
    public final com.bytedance.android.live.revlink.impl.global.c f;

    public f(com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.f r9, com.bytedance.android.live.revlink.impl.global.c r10) {
        Intrinsics.checkNotNullParameter(r9, "strategyContext");
        Intrinsics.checkNotNullParameter(r10, "linkInstanceService");
        this.f = r10;
        if (r41.b.a == false) goto L5;
        List r1 = CollectionsKt.listOf(new Object[]{new c(r9, r10), new g(r9, r10)});
    L6:
        this.a = new EventProcessorDispatch(r1);
        this.b = new EventProcessorDispatch(CollectionsKt.listOf(new Object[]{new o(r9, r10), new k(r9, r10), new m(r9, r10), new l(r9, r10)}));
        this.c = new EventProcessorDispatch(CollectionsKt.listOf(new Object[]{new o(r9, r10), new k(r9, r10), new n(r9, r10)}));
        this.d = new EventProcessorDispatch(CollectionsKt.listOf(new Object[]{new q(r9, r10), new e(r9, r10), new i(r9, r10)}));
        this.e = new EventProcessorDispatch(CollectionsKt.listOf(new Object[]{new q(r9, r10), new e(r9, r10), new p(r9, r10)}));
        return;
    L5:
        r1 = CollectionsKt.listOf(new Object[]{new c(r9, r10), new d(r9, r10), new g(r9, r10), new h(r9, r10), new b(r9, r10)});
        goto L6
    }
}
