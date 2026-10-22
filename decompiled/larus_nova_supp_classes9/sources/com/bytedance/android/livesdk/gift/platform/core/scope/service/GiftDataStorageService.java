package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.bytedance.android.livesdk.revenue.log.LogCommon;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftDataStorageService implements com.bytedance.android.scope.o {
    public int a;
    public int b;
    public long c;
    public long d;
    public long e;
    public long f;
    public final Map<Integer, Integer> g;
    public final Map<Integer, Integer> h;
    public int i;
    public final LinkedHashSet<String> j;
    public int k;
    public final LinkedHashSet<Long> l;
    public long m;
    public final Lazy n;
    public int o;
    public int p;
    public final int q;
    public final SendGiftRelationService r;

    public final void onStart() {
        final SendGiftRelationService r0 = this.r;
        if (r0.b == true) goto L7;
        Single.create(new q3(new SendGiftRelationService$loadCacheData$1(r0))).subscribeOn(Schedulers.io()).subscribe(new com.bytedance.android.livesdk.user.h());
        return;
    }

    public final void onStop() {
        String r0 = com.bytedance.android.livesdk.gift.platform.core.utils.h.a;
        Pair[] r3 = {TuplesKt.to("predict_value", String.valueOf(this.o)), TuplesKt.to("open_panel_count", String.valueOf(this.p))};
        LinkedHashMap r1 = new LinkedHashMap();
        MapsKt.putAll(r1, r3);
        mz0.n r4 = new mz0.n();
        Map r5 = r4.a;
        Intrinsics.checkNotNullParameter(r5, "map");
        Intrinsics.checkNotNullParameter(r1, "map");
        r5.putAll(r1);
        mz0.m r2 = new mz0.m();
        LogCommon r6 = LogCommon.ROOM;
        r2.b(r6);
        com.bytedance.android.livesdk.revenue.log.i r7 = vh6.c.b(kr2.a.class).ud();
        Intrinsics.checkNotNullParameter(r7, "pageSourceLog");
        ((ArrayList) r2.a).add(r7.a);
        ((ArrayList) r4.b).addAll(r2.a);
        cy0.e.a.getClass();
        cy0.j r8 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r9 = com.bytedance.android.scope.m.b(r8).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r9);
        ((f80.a) r9).w3("livesdk_revenue_open_gift_panel_predict_tracking", r4.a, r4.b);
        long r10 = this.e;
        long r11 = this.f;
        if (r10 == 0) goto L11;
        Pair[] r13 = {TuplesKt.to("send_big_gift_count", String.valueOf(r10)), TuplesKt.to("my_effect_show_count", String.valueOf(r11))};
        LinkedHashMap r14 = new LinkedHashMap();
        MapsKt.putAll(r14, r13);
        if (r10 != r11) goto L8;
        TuplesKt.to("success", "1");
    L9:
        mz0.n r15 = new mz0.n();
        Map r16 = r15.a;
        Intrinsics.checkNotNullParameter(r16, "map");
        Intrinsics.checkNotNullParameter(r14, "map");
        r16.putAll(r14);
        mz0.m r17 = new mz0.m();
        r17.b(r6);
        com.bytedance.android.livesdk.revenue.log.i r18 = vh6.c.b(kr2.a.class).ud();
        Intrinsics.checkNotNullParameter(r18, "pageSourceLog");
        ((ArrayList) r17.a).add(r18.a);
        ((ArrayList) r15.b).addAll(r17.a);
        Object r19 = com.bytedance.android.scope.m.b(r8).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r19);
        ((f80.a) r19).w3("livesdk_effect_show_local_data", r15.a, r15.b);
        return;
    L8:
        TuplesKt.to("success", "0");
        goto L9
    }

    public GiftDataStorageService(SendGiftRelationService r2) {
        Intrinsics.checkNotNullParameter(r2, "sendGiftRelationService");
        this.r = r2;
        this.g = new LinkedHashMap();
        this.h = new LinkedHashMap();
        this.j = new LinkedHashSet();
        this.l = new LinkedHashSet();
        this.n = LazyKt.lazy(GiftDataStorageService$giftContext$2.INSTANCE);
        this.o = -1;
        rq2.b r3 = vh6.c.b(rq2.b.class);
        if (r3 == null) goto L5;
        Integer r4 = Integer.valueOf(r3.mostUsedHand(false));
    L6:
        this.q = r4.intValue();
        return;
    L5:
        r4 = null;
        goto L6
    }
}
