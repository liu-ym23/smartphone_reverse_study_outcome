package com.bytedance.android.live.browser.jsbridge.prefetch;

import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ LivePrefetchProcessor a;

    public f(LivePrefetchProcessor r1) {
        this.a = r1;
    }

    public final void accept(Object r13) {
        List r14 = (List) r13;
        LivePrefetchProcessor r0 = this.a;
        r0.getClass();
        if (r14.isEmpty() == true) goto L23;
        LivePrefetchProcessor$initProcessors$1 r1 = LivePrefetchProcessor$initProcessors$1.INSTANCE;
        List r2 = r14;
        LinkedHashMap r5 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r2, 10)), 16));
        Iterator<T> r4 = r2.iterator();
    L6:
        String r7 = "live_prefetch_v3_";
        if (r4.hasNext() == false) goto L13;
        com.bytedance.android.live.browser.jsbridge.g.a r6 = (com.bytedance.android.live.browser.jsbridge.g.a) r4.next();
        String r9 = r6.a;
        LivePrefetchProcessor$initProcessors$1 r11 = LivePrefetchProcessor$initProcessors$1.INSTANCE;
        List<String> r12 = CollectionsKt.listOf(r6.b);
        String r8 = r6.a;
        if (r8 == null) goto L12;
        r7 = r8;
    L12:
        Pair r15 = new Pair(r9, r11.invoke(r12, r7));
        r5.put(r15.getFirst(), r15.getSecond());
        goto L6
    L13:
        ArrayList r16 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator<T> r3 = r2.iterator();
    L15:
        if (r3.hasNext() == false) goto L17;
        r16.add(((com.bytedance.android.live.browser.jsbridge.g.a) r3.next()).b);
        goto L15
    L17:
        r0.a = MapsKt.plus(r5, new Pair(null, r1.invoke(r16, "live_prefetch_v3_")));
        int r17 = x8.a.a;
        x8.a.d("LivePrefetchProcessor", "init processors success, config list size: " + r14.size(), false);
        return;
    }
}
