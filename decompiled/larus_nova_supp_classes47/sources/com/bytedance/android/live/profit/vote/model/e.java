package com.bytedance.android.live.profit.vote.model;

import com.bytedance.android.live.profit.vote.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e {
    public static final List<g> a(List<? extends com.bytedance.android.live.profit.vote.a> r12) {
        if (r12 == null) goto L8;
        List<? extends com.bytedance.android.live.profit.vote.a> r13 = r12;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10));
        Iterator<T> r14 = r13.iterator();
    L5:
        if (r14.hasNext() == false) goto L10;
        com.bytedance.android.live.profit.vote.a r1 = (com.bytedance.android.live.profit.vote.a) r14.next();
        Intrinsics.checkNotNullParameter(r1, "$this$toVoteItem");
        r0.add(new g(r1.getCount(), r1.getGiftId(), r1.getGiftName(), r1.getText(), r1.getIcon()));
        goto L5
    L10:
        return r0;
    L8:
        return CollectionsKt.emptyList();
    }
}
