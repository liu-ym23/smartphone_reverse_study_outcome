package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo;

import com.bytedance.android.livesdk.gift.model.d2;
import com.bytedance.android.livesdk.gift.model.o2;
import com.bytedance.android.livesdk.gift.model.w1;
import com.bytedance.android.livesdk.gift.platform.core.giftlist.GiftListRepository;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class q0 implements com.bytedance.android.scope.o {
    public final Map<Long, List<d2>> a;
    public final Map<Long, Map<Long, String>> b;
    public List<? extends o2> c;
    public final GiftListRepository d;

    public final void onStop() {
    }

    public final void onStart() {
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v.g() == true) goto L5;
        return;
    L5:
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v.b() == false) goto L27;
        com.bytedance.android.livesdk.gift.platform.core.model.l r0 = this.d.b;
        if (r0 == null) goto L28;
        List<com.bytedance.android.livesdk.gift.platform.core.giftlist.j> r1 = r0.a;
        if (r1 == null) goto L29;
        Iterator<com.bytedance.android.livesdk.gift.platform.core.giftlist.j> r2 = r1.iterator();
    L12:
        if (r2.hasNext() == false) goto L30;
        com.bytedance.android.livesdk.gift.platform.core.giftlist.j r3 = r2.next();
        List<d2> r4 = r3.n;
        if (r4 == null) goto L12;
        this.a.put(Long.valueOf(r3.a), new ArrayList(r4));
        List<d2> r5 = r4;
        LinkedHashMap r6 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r5, 10)), 16));
        Iterator<T> r7 = r5.iterator();
    L17:
        if (r7.hasNext() == false) goto L19;
        d2 r8 = (d2) r7.next();
        Pair r9 = TuplesKt.to(Long.valueOf(r8.getId()), r8.getName());
        r6.put(r9.getFirst(), r9.getSecond());
        goto L17
    L19:
        this.b.put(Long.valueOf(r3.a), r6);
        goto L12
    L30:
        return;
    L29:
        return;
    L28:
        return;
    }

    public q0(GiftListRepository r2) {
        Intrinsics.checkNotNullParameter(r2, "giftListRepository");
        this.d = r2;
        this.a = new LinkedHashMap();
        this.b = new LinkedHashMap();
    }

    public final List<d2> a(long r2) {
        Map<Long, List<d2>> r0 = this.a;
        LinkedHashMap r1 = (LinkedHashMap) r0;
        List<d2> r3 = (List) r1.get(Long.valueOf(r2));
        if (r3 == null) goto L5;
        return r3;
    L5:
        return new ArrayList();
    }

    public final void d(List<? extends w1> r7) {
        Intrinsics.checkNotNullParameter(r7, "pageList");
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v.g() == false) goto L12;
        Iterator<? extends w1> r8 = r7.iterator();
    L6:
        if (r8.hasNext() == false) goto L15;
        w1 r0 = r8.next();
        this.a.put(Long.valueOf(r0.getPageType()), new ArrayList(r0.getTopicList()));
        List<d2> r1 = r0.getTopicList();
        LinkedHashMap r3 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r1, 10)), 16));
        Iterator<T> r2 = r1.iterator();
    L9:
        if (r2.hasNext() == false) goto L11;
        d2 r4 = (d2) r2.next();
        Pair r5 = TuplesKt.to(Long.valueOf(r4.getId()), r4.getName());
        r3.put(r5.getFirst(), r5.getSecond());
        goto L9
    L11:
        this.b.put(Long.valueOf(r0.getPageType()), r3);
        goto L6
    L15:
        return;
    }

    public final String c(long r2, long r4) {
        Map<Long, Map<Long, String>> r0 = this.b;
        LinkedHashMap r1 = (LinkedHashMap) r0;
        Map r3 = (Map) r1.get(Long.valueOf(r2));
        if (r3 != null) goto L7;
        return null;
    L7:
        return (String) r3.get(Long.valueOf(r4));
    }
}
