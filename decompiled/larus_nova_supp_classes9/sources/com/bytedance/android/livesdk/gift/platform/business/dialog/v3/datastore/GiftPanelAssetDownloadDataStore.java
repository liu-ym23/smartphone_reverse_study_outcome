package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore;

import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.gift.model.g0;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.l1;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.GiftExtraRepo;
import com.bytedance.android.livesdk.gift.platform.core.manager.GiftManagerKt;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.AssetsService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftPanelAssetDownloadDataStore implements com.bytedance.android.scope.o {
    public final List<Long> a;
    public final Map<Integer, Integer> b;
    public final int c;
    public final int d;
    public long e;
    public final GiftExtraRepo f;
    public final AssetsService g;

    public final void onStart() {
    }

    public final void onStop() {
    }

    public final List<Long> a(long r5) {
        g0 r6 = this.f.q(r5);
        if (r6 == null) goto L5;
        List<l1> r7 = r6.getGiftBuffInfos();
    L6:
        ArrayList r0 = new ArrayList();
        if (r7 == null) goto L15;
        Iterator<T> r8 = r7.iterator();
    L10:
        if (r8.hasNext() == false) goto L15;
        h1 r1 = GiftManagerKt.j(((l1) r8.next()).getBuffGiftId(), null);
        if (r1 == null) goto L10;
        r0.add(Long.valueOf(r1.getPrimaryEffectId()));
        r0.addAll(r1.getAssetIds());
    L15:
        return r0;
    L5:
        r7 = null;
        goto L6
    }

    public GiftPanelAssetDownloadDataStore(GiftExtraRepo r2, AssetsService r3) {
        Intrinsics.checkNotNullParameter(r2, "giftExtraRepo");
        Intrinsics.checkNotNullParameter(r3, "assetService");
        this.f = r2;
        this.g = r3;
        this.a = new ArrayList();
        this.b = com.bytedance.android.livesdk.gift.platform.business.i.f().g8();
        this.c = com.bytedance.android.livesdk.gift.platform.business.i.f().s4();
        this.d = com.bytedance.android.livesdk.gift.platform.business.i.f().K5();
    }

    public final void c(LinkedHashMap<Integer, List<vz1.e>> r19, List<Long> r20) {
        Intrinsics.checkNotNullParameter(r19, "giftMap");
        Intrinsics.checkNotNullParameter(r20, "notSupportShowNowList");
        long r4 = System.currentTimeMillis();
        if ((r4 - this.e) >= this.d) goto L5;
        return;
    L5:
        this.e = r4;
        if (com.bytedance.android.livesdk.gift.platform.business.i.f().Q1() == false) goto L42;
        ArrayList r2 = new ArrayList();
        r2.addAll(r20);
        Iterator<Map.Entry<Integer, List<vz1.e>>> r8 = r19.entrySet().iterator();
    L9:
        if (r8.hasNext() == false) goto L31;
        Map.Entry<Integer, List<vz1.e>> r9 = r8.next();
        int r10 = r9.getKey().intValue();
        List<vz1.e> r11 = r9.getValue();
        Map<Integer, Integer> r13 = this.b;
        if (r13 == null) goto L15;
        Integer r14 = r13.get(Integer.valueOf(r10));
        if (r14 == null) goto L15;
        int r15 = r14.intValue();
    L16:
        Iterator<vz1.e> r16 = r11.iterator();
        int r17 = 0;
    L18:
        if (r16.hasNext() == false) goto L9;
        vz1.e r18 = r16.next();
        r17 = r17 + 1;
        if (r17 >= r15) goto L18;
        List r110 = CollectionsKt.plus(CollectionsKt.plus(CollectionsKt.listOf(Long.valueOf(r18.a.getPrimaryEffectId())), r18.a.getAssetIds()), a(r18.b));
        ArrayList r111 = new ArrayList();
        Iterator r112 = r110.iterator();
    L23:
        if (r112.hasNext() == false) goto L30;
        Object r113 = r112.next();
        if (((Number) r113).longValue() <= 0) goto L27;
        boolean r114 = true;
    L28:
        if (r114 == false) goto L23;
        r111.add(r113);
        goto L23
    L27:
        r114 = false;
        goto L28
    L30:
        r2.addAll(r111);
    L15:
        r15 = this.c;
        goto L16
    L31:
        ArrayList r21 = new ArrayList();
        Iterator r3 = r2.iterator();
    L33:
        if (r3.hasNext() == false) goto L40;
        Object r23 = r3.next();
        if (((Number) r23).longValue() <= 0) goto L37;
        boolean r115 = true;
    L38:
        if (r115 == false) goto L33;
        r21.add(r23);
        goto L33
    L37:
        r115 = false;
        goto L38
    L40:
        final List r5 = CollectionsKt.distinct(r21);
        UtilityKotlinExtentionsKt.s(0, false, false, new GiftPanelAssetDownloadDataStore$updateShowSort$1(this, r5), 7);
    L42:
        if (com.bytedance.android.livesdk.gift.platform.business.i.f().S2() == false) goto L85;
        List<Long> r1 = r20;
        Collection<List<vz1.e>> r6 = r19.values();
        ArrayList r7 = new ArrayList();
        Iterator<T> r24 = r6.iterator();
    L45:
        if (r24.hasNext() == false) goto L51;
        List r25 = (List) r24.next();
        ArrayList r26 = new ArrayList();
        Iterator r27 = r25.iterator();
    L48:
        if (r27.hasNext() == false) goto L50;
        vz1.e r116 = (vz1.e) r27.next();
        CollectionsKt.addAll(r26, CollectionsKt.plus(CollectionsKt.plus(CollectionsKt.listOf(Long.valueOf(r116.a.getPrimaryEffectId())), r116.a.getAssetIds()), a(r116.b)));
        goto L48
    L50:
        CollectionsKt.addAll(r7, r26);
        goto L45
    L51:
        List r28 = CollectionsKt.plus(r1, r7);
        ArrayList r29 = new ArrayList();
        Iterator r30 = r28.iterator();
    L53:
        if (r30.hasNext() == false) goto L60;
        Object r31 = r30.next();
        if (((Number) r31).longValue() <= 0) goto L57;
        boolean r33 = true;
    L58:
        if (r33 == false) goto L53;
        r29.add(r31);
        goto L53
    L57:
        r33 = false;
        goto L58
    L60:
        final List r34 = CollectionsKt.distinct(r29);
        UtilityKotlinExtentionsKt.s(0, false, false, new GiftPanelAssetDownloadDataStore$updateShowSort$2(this, r34), 7);
        return;
    }
}
