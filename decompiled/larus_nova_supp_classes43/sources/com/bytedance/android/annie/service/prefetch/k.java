package com.bytedance.android.annie.service.prefetch;

import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class k<T> implements Consumer {
    public final /* synthetic */ AnniePrefetchProcessor a;

    public k(AnniePrefetchProcessor r1) {
        this.a = r1;
    }

    public final void accept(Object r10) {
        List r11 = (List) r10;
        AnniePrefetchProcessor r0 = this.a;
        r0.getClass();
        if (r11.isEmpty() == true) goto L17;
        List r12 = r11;
        LinkedHashMap r13 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r12, 10)), 16));
        Iterator<T> r14 = r12.iterator();
    L7:
        if (r14.hasNext() == false) goto L9;
        o.a r15 = (o.a) r14.next();
        Pair r16 = new Pair(r15.a, AnniePrefetchProcessor.c(r0, CollectionsKt.listOf(r15.b)));
        r13.put(r16.getFirst(), r16.getSecond());
        goto L7
    L9:
        ArrayList r17 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10));
        Iterator<T> r18 = r12.iterator();
    L11:
        if (r18.hasNext() == false) goto L13;
        r17.add(((o.a) r18.next()).b);
        goto L11
    L13:
        r0.a = MapsKt.plus(r13, new Pair(null, AnniePrefetchProcessor.c(r0, r17)));
        return;
    }
}
