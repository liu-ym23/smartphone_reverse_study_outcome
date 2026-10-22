package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.bytedance.android.anya.BaseMVIDataStore;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.revenue.platform.network.api.INetworkService;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.MostlyUsedGiftOperateAction;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import kotlin.reflect.TypesJVMKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftMostlyUsedDataStore extends BaseMVIDataStore<GiftMostlyUsedDataStore> implements com.bytedance.android.scope.o {
    public static final /* synthetic */ KProperty[] n = null;
    public final ReadOnlyProperty e;
    public final com.bytedance.android.anya.t f;
    public final Set<Long> g;
    public final Map<Long, Boolean> h;
    public boolean i;
    public int j;
    public int k;
    public final GiftListPreLoadService l;
    public final com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.c0 m;

    static {
        n = new KProperty[]{Reflection.property1(new PropertyReference1Impl(GiftMostlyUsedDataStore.class, "mostlyUsedEmpty", "getMostlyUsedEmpty()Lcom/bytedance/android/anya/MVIExternalDataProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftMostlyUsedDataStore.class, "_mostlyUsedEmpty", "get_mostlyUsedEmpty()Z", 0))};
    }

    public final void onStart() {
    }

    public final com.bytedance.android.anya.t<GiftMostlyUsedDataStore, Boolean> w() {
        return (com.bytedance.android.anya.t) this.e.getValue(this, n[0]);
    }

    public final boolean y() {
        return ((Boolean) this.f.getValue(this, n[1])).booleanValue();
    }

    public final void o() {
        if (this.g.isEmpty() == y()) goto L6;
        g(null, new GiftMostlyUsedDataStore$changeMostlyUsedEmptyState$1(this));
        return;
    }

    public final void onStop() {
        if (this.j == this.k) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        GiftListPreLoadService r1 = this.l;
        ReadOnlyProperty r2 = GiftListPreLoadService.i;
        r1.a(18, null, null);
        return;
    L9:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final boolean s() {
        if (com.bytedance.android.livesdk.gift.platform.business.i.n().getEnable() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.i == false) goto L7;
        return true;
    }

    public final boolean F(long r2) {
        Map<Long, Boolean> r0 = this.h;
        LinkedHashMap r1 = (LinkedHashMap) r0;
        Boolean r3 = (Boolean) r1.get(Long.valueOf(r2));
        if (r3 != null) goto L7;
        return false;
    L7:
        return r3.booleanValue();
    }

    public final void I(long r2) {
        this.g.remove(Long.valueOf(r2));
        o();
    }

    public final void J(int r1) {
        this.k = r1;
    }

    public final void L(List<? extends com.bytedance.android.livesdk.gift.model.w1> r5) {
        Intrinsics.checkNotNullParameter(r5, "giftPages");
        this.g.clear();
        Iterator<T> r6 = r5.iterator();
    L3:
        com.bytedance.android.livesdk.gift.model.w1 r1 = null;
        if (r6.hasNext() == false) goto L11;
        Object r0 = r6.next();
        if (((com.bytedance.android.livesdk.gift.model.w1) r0).getPageType() != 17) goto L8;
        boolean r2 = true;
    L9:
        if (r2 == false) goto L3;
    L12:
        com.bytedance.android.livesdk.gift.model.w1 r3 = (com.bytedance.android.livesdk.gift.model.w1) r0;
        if (r3 != null) goto L15;
    L25:
        o();
        return;
    L15:
        if (r3.getDisplay() == false) goto L17;
        r1 = r3;
    L17:
        if (r1 == null) goto L25;
        List<com.bytedance.android.livesdk.gift.model.h1> r7 = r1.getGifts();
        if (r7 == null) goto L25;
        Set<Long> r4 = this.g;
        List<com.bytedance.android.livesdk.gift.model.h1> r8 = r7;
        ArrayList r9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator<T> r10 = r8.iterator();
    L22:
        if (r10.hasNext() == false) goto L24;
        r9.add(Long.valueOf(((com.bytedance.android.livesdk.gift.model.h1) r10.next()).getId()));
        goto L22
    L24:
        r4.addAll(r9);
        goto L25
    L8:
        r2 = false;
        goto L9
    L11:
        r0 = null;
        goto L12
    }

    public final void k(long r2) {
        this.g.add(Long.valueOf(r2));
        o();
    }

    public GiftMostlyUsedDataStore(GiftListPreLoadService r2, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.c0 r3) {
        Intrinsics.checkNotNullParameter(r2, "giftListPreloadService");
        Intrinsics.checkNotNullParameter(r3, "giftMostlyUsedRepo");
        this.l = r2;
        this.m = r3;
        this.e = i(Boolean.FALSE).a().a(n[0]);
        this.f = w();
        this.g = new LinkedHashSet();
        this.h = new LinkedHashMap();
    }

    public final void q(int r13, int r14, long r15) {
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.c0 r0 = this.m;
        r0.getClass();
        tz0.b r1 = tz0.b.a;
        uz0.c r2 = new uz0.c();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "$this$beforeConfigureRequest");
        Map r3 = ((uz0.a) r2).b;
        Intrinsics.checkNotNullParameter(r3, "queriesMap");
        String r4 = Integer.valueOf(r13).toString();
        Intrinsics.checkNotNullParameter("sort_strategy", "$this$setTo");
        if (r4 == null) goto L5;
        r3.put("sort_strategy", r4);
    L5:
        String r5 = Long.valueOf(r15).toString();
        Intrinsics.checkNotNullParameter("room_id", "$this$setTo");
        if (r5 == null) goto L8;
        r3.put("room_id", r5);
    L8:
        Intrinsics.checkNotNullParameter(r2, "$this$afterConfigureRequest");
        RxUtilKt.c(com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class).x0(INetworkService.Biz.Revenue, "/webcast/gift/mostly_used_page/pin_page_top/", TypesJVMKt.getJavaType(Reflection.typeOf(com.bytedance.android.livesdk.gift.model.d3.class)), Extra.class, ((uz0.a) r2).d, ((uz0.a) r2).a, ((uz0.a) r2).b, ((uz0.a) r2).c).compose(RxUtil.rxSchedulerHelper()).subscribe(new com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.a0(r14, r13, r15), new com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.b0(r13, r14, r15)), r0.a);
    }

    public final void n(long r14, long r16, @MostlyUsedGiftOperateAction int r18, int r19) {
        this.h.put(Long.valueOf(r14), Boolean.TRUE);
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.c0 r1 = this.m;
        r1.getClass();
        tz0.b r2 = tz0.b.a;
        uz0.c r3 = new uz0.c();
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "$this$beforeConfigureRequest");
        Map r4 = ((uz0.a) r3).b;
        Intrinsics.checkNotNullParameter(r4, "queriesMap");
        String r5 = Integer.valueOf(r18).toString();
        Intrinsics.checkNotNullParameter("action", "$this$setTo");
        if (r5 == null) goto L5;
        r4.put("action", r5);
    L5:
        String r6 = Long.valueOf(r14).toString();
        Intrinsics.checkNotNullParameter("gift_id", "$this$setTo");
        if (r6 == null) goto L8;
        r4.put("gift_id", r6);
    L8:
        String r7 = Long.valueOf(r16).toString();
        Intrinsics.checkNotNullParameter("room_id", "$this$setTo");
        if (r7 == null) goto L11;
        r4.put("room_id", r7);
    L11:
        Intrinsics.checkNotNullParameter(r3, "$this$afterConfigureRequest");
        RxUtilKt.c(com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class).x0(INetworkService.Biz.Revenue, "/webcast/gift/mostly_used_page/operate_gift/", TypesJVMKt.getJavaType(Reflection.typeOf(Object.class)), Extra.class, ((uz0.a) r3).d, ((uz0.a) r3).a, ((uz0.a) r3).b, ((uz0.a) r3).c).compose(RxUtil.rxSchedulerHelper()).subscribe(new com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.y(r1, r14, r16, r18, r19), new com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.z(r1, r14, r18, r19, r16)), r1.a);
    }
}
