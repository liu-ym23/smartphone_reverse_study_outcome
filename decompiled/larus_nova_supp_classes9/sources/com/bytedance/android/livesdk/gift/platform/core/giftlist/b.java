package com.bytedance.android.livesdk.gift.platform.core.giftlist;

import com.bytedance.android.livesdk.gift.configmodel.n0;
import com.bytedance.android.livesdk.gift.model.c1;
import com.bytedance.android.livesdk.gift.model.j1;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b implements g, com.bytedance.android.scope.o {
    public final Map<Long, c1> a;
    public long b;

    public final void onStart() {
    }

    public final void onStop() {
    }

    public b() {
        this.a = new LinkedHashMap();
        if (((n0) nz1.a.b0.getValue(null, nz1.a.a[52])).a() == false) goto L5;
        long r0 = 1;
    L6:
        this.b = r0;
        return;
    L5:
        r0 = 0;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.giftlist.g
    public final Map<Long, c1> D2() {
        return this.a;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.giftlist.g
    public final long J1() {
        return this.b;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.giftlist.g
    public final void L5(j1 r6) {
        this.b = r6.getVersion();
        Map<Long, c1> r0 = this.a;
        List<c1> r7 = r6.getBaseGiftList();
        LinkedHashMap r2 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r7, 10)), 16));
        Iterator<T> r8 = r7.iterator();
    L4:
        if (r8.hasNext() == false) goto L6;
        Object r1 = r8.next();
        r2.put(Long.valueOf(((c1) r1).getId()), r1);
        goto L4
    L6:
        r0.putAll(r2);
    }
}
