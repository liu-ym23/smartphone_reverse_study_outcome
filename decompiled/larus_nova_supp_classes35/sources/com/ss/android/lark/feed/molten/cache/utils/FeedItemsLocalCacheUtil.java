package com.ss.android.lark.feed.molten.cache.utils;

import com.ss.android.lark.feed.app.entity.UIFeedCard;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class FeedItemsLocalCacheUtil {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static List a(List r10) {
        Intrinsics.checkNotNullParameter(r10, "latestItems");
        List r11 = SequencesKt.toList(SequencesKt.distinctBy(SequencesKt.filter(CollectionsKt.asSequence(r10), FeedItemsLocalCacheUtil$normalizeHumanSidebarSnapshot$distinctItems$1.INSTANCE), FeedItemsLocalCacheUtil$normalizeHumanSidebarSnapshot$distinctItems$2.INSTANCE));
        ArrayList r0 = new ArrayList();
        Iterator r1 = r11.iterator();
    L3:
        boolean r3 = true;
        if (r1.hasNext() == false) goto L11;
        Object r2 = r1.next();
        if (((UIFeedCard) r2).getOnTopRankTime() > 0) goto L9;
        r3 = false;
    L9:
        if (r3 == false) goto L3;
        r0.add(r2);
        goto L3
    L11:
        ArrayList r4 = new ArrayList();
        Iterator r12 = r11.iterator();
    L13:
        if (r12.hasNext() == false) goto L21;
        Object r5 = r12.next();
        if (((UIFeedCard) r5).getOnTopRankTime() > 0) goto L17;
        boolean r7 = true;
    L18:
        if (r7 == false) goto L13;
        r4.add(r5);
        goto L13
    L17:
        r7 = false;
        goto L18
    L21:
        return CollectionsKt.plus(r0, CollectionsKt.take(r4, RangesKt.coerceAtLeast(20, 0)));
    }

    public static List b(List r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "latestItems");
        return SequencesKt.toList(SequencesKt.take(SequencesKt.distinctBy(SequencesKt.filter(CollectionsKt.asSequence(r1), FeedItemsLocalCacheUtil$normalizeSnapshot$1.INSTANCE), FeedItemsLocalCacheUtil$normalizeSnapshot$2.INSTANCE), r2));
    }
}
