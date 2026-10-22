package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import androidx.collection.LongSparseArray;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.GiftListSortDataStore;
import io.reactivex.Observable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e1 implements com.bytedance.android.scope.o, dy0.c, mc6.b, sc6.a {
    public long a;
    public Observable<Unit> b;
    public final Map<Integer, Integer> c;
    public final Map<Integer, String> d;
    public final cy0.e e;

    public final void onStart() {
    }

    public final void onStop() {
    }

    public static LongSparseArray a() {
        i12.d r0 = i12.m.e2.a();
        if (r0 == null) goto L5;
        Object r1 = com.bytedance.android.scope.m.e.d(r0, GiftListSortDataStore.class);
    L6:
        GiftListSortDataStore r2 = (GiftListSortDataStore) r1;
        if (r2 == null) goto L12;
        LongSparseArray<Integer> r3 = r2.f;
        if (r3 == null) goto L12;
        return r3;
    L12:
        i12.e r4 = i12.o.b();
        if (r4 == null) goto L15;
        Object r5 = com.bytedance.android.scope.m.e.d(r4, f1.class);
    L16:
        f1 r6 = (f1) r5;
        if (r6 != null) goto L19;
        return null;
    L19:
        return r6.d;
    L15:
        r5 = null;
        goto L16
    L5:
        r1 = null;
        goto L6
    }

    public static void f() {
        i12.d r0 = i12.m.e2.a();
        Object r1 = null;
        if (r0 == null) goto L5;
        Object r2 = com.bytedance.android.scope.m.e.d(r0, GiftListSortDataStore.class);
    L7:
        if (((GiftListSortDataStore) r2) == null) goto L9;
        return;
    L9:
        i12.e r3 = i12.o.b();
        if (r3 == null) goto L12;
        r1 = com.bytedance.android.scope.m.e.d(r3, f1.class);
    L12:
        f1 r4 = (f1) r1;
        return;
    L5:
        r2 = null;
        goto L7
    }

    public final com.bytedance.android.livesdk.gift.platform.core.model.j N3() {
        return ((com.bytedance.android.livesdk.gift.platform.core.giftlist.i) com.bytedance.android.live.revenue.core.util.f.a(com.bytedance.android.livesdk.gift.platform.core.giftlist.i.class)).N3();
    }

    public final Map<Integer, Integer> g() {
        return this.c;
    }

    public e1(cy0.e r3) {
        Intrinsics.checkNotNullParameter(r3, "scope");
        this.e = r3;
        this.a = -1;
        new LongSparseArray();
        this.c = new LinkedHashMap();
        this.d = new LinkedHashMap();
    }

    public final String F5(int r2) {
        return ((com.bytedance.android.livesdk.gift.platform.core.giftlist.i) com.bytedance.android.live.revenue.core.util.f.a(com.bytedance.android.livesdk.gift.platform.core.giftlist.i.class)).F5(r2);
    }

    public final kc6.d checkGiftResourceReadyById(long r4) {
        com.bytedance.android.livesdk.gift.model.h1 r5 = findGiftById(r4);
        kc6.d r6 = new kc6.d();
        AssetsService r0 = (AssetsService) com.bytedance.android.live.revenue.core.util.f.a(AssetsService.class);
        if (r5 == null) goto L5;
        long r1 = r5.getPrimaryEffectId();
    L6:
        r6.setResult(r0.g1(r1));
        return r6;
    L5:
        r1 = 0;
        goto L6
    }

    public final com.bytedance.android.livesdk.gift.model.h1 findGiftById(long r3) {
        return ((com.bytedance.android.livesdk.gift.platform.core.giftlist.i) com.bytedance.android.live.revenue.core.util.f.a(com.bytedance.android.livesdk.gift.platform.core.giftlist.i.class)).o4(r3, null);
    }

    public final kc6.j getGiftById(long r3) {
        com.bytedance.android.livesdk.gift.model.h1 r4 = ((com.bytedance.android.livesdk.gift.platform.core.giftlist.i) com.bytedance.android.live.revenue.core.util.f.a(com.bytedance.android.livesdk.gift.platform.core.giftlist.i.class)).o4(r3, null);
        kc6.j r5 = new kc6.j();
        r5.a(r4);
        return r5;
    }

    public final void h(List<? extends com.bytedance.android.livesdk.gift.model.w1> r4) {
        Intrinsics.checkNotNullParameter(r4, "pages");
        Iterator<? extends com.bytedance.android.livesdk.gift.model.w1> r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        com.bytedance.android.livesdk.gift.model.w1 r0 = r5.next();
        this.d.put(Integer.valueOf(r0.getPageType()), r0.getPageName());
        goto L4
    }
}
