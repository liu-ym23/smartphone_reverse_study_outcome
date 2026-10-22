package com.bytedance.android.livesdk.gift.platform.core.utils;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.GiftReceiverRepoService;
import com.bytedance.android.livesdk.message.model.o7;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.bdlocation.BuildConfig;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.random.Random;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftFrequencyUtils {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(GiftFrequencyUtils$bigGiftConfig$2.INSTANCE);
    }

    public static void a(o7 r9, Long r10) {
        Intrinsics.checkNotNullParameter(r9, "$this$frequency");
        if (r10 == null) goto L5;
        long r0 = r10.longValue();
    L6:
        Lazy r11 = a;
        if (((com.bytedance.android.livesdk.gift.configmodel.j) r11.getValue()).c() == false) goto L48;
        List<Integer> r2 = com.bytedance.android.livesdk.gift.platform.core.h.a().d();
        if (r2 != null) goto L12;
    L14:
        List<Long> r3 = com.bytedance.android.livesdk.gift.platform.core.h.a().b();
        if (r3 != null) goto L17;
    L20:
        boolean r4 = true;
    L21:
        if (r4 == true) goto L28;
        List<Long> r5 = com.bytedance.android.livesdk.gift.platform.core.h.a().b();
        if (r5 == null) goto L28;
        if (r5.contains(Long.valueOf(r9.getGiftId())) == false) goto L48;
    L28:
        if (g02.a.e() == true) goto L48;
        i12.e r6 = i12.o.b();
        if (r6 == null) goto L32;
        Object r7 = com.bytedance.android.scope.m.e.d(r6, GiftReceiverRepoService.class);
    L33:
        GiftReceiverRepoService r8 = (GiftReceiverRepoService) r7;
        if (r8 == null) goto L39;
        if (r8.L(com.bytedance.android.live.revenue.core.util.f.a(l01.d.class).b().getIdString()) == true) goto L48;
    L39:
        if (r0 <= 0) goto L48;
        if ((r0 % ((long) (((com.bytedance.android.livesdk.gift.configmodel.j) r11.getValue()).a() + 1))) != 0) goto L48;
        if (Random.Default.nextInt(0, 100) > ((com.bytedance.android.livesdk.gift.configmodel.j) r11.getValue()).e()) goto L45;
        boolean r1 = true;
    L46:
        if (r1 == false) goto L48;
        boolean r13 = true;
    L49:
        if (r13 == false) goto L59;
        r9.setBannedDisplayEffects(r9.getBannedDisplayEffects() | 4);
        c.b("GiftFrequencyUtils", "BigGift Is Frequency, GiftId = " + r9.getGiftId() + ", rate is " + ((com.bytedance.android.livesdk.gift.configmodel.j) r11.getValue()).e());
        yz0.k r14 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        String r15 = h.a;
        if (r14 == null) goto L56;
        IBaseUser r16 = r14.getUser();
        if (r16 == null) goto L56;
        String r17 = r16.getIdString();
        if (r17 == null) goto L56;
    L57:
        long r18 = r9.getGiftId();
        Intrinsics.checkNotNullParameter(r17, "userId");
        Pair[] r19 = {TuplesKt.to("user_id", r17), TuplesKt.to("gift_id", String.valueOf(r18))};
        LinkedHashMap r110 = new LinkedHashMap();
        MapsKt.putAll(r110, r19);
        mz0.n r20 = new mz0.n();
        Map r21 = r20.a;
        Intrinsics.checkNotNullParameter(r21, "map");
        Intrinsics.checkNotNullParameter(r110, "map");
        r21.putAll(r110);
        mz0.m r111 = new mz0.m();
        r111.b(LogCommon.ROOM);
        r111.b(LogCommon.PAGE_SOURCE_LOG);
        ((ArrayList) r20.b).addAll(r111.a);
        cy0.e.a.getClass();
        cy0.j r112 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r113 = com.bytedance.android.scope.m.b(r112).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r113);
        ((f80.a) r113).w3("livesdk_gift_effect_discard", r20.a, r20.b);
        return;
    L56:
        r17 = BuildConfig.FLAVOR;
        goto L57
    L59:
        return;
    L45:
        r1 = false;
        goto L46
    L32:
        r7 = null;
        goto L33
    L17:
        if (r3.isEmpty() == true) goto L20;
        r4 = false;
        goto L21
    L12:
        if (r2.contains(Integer.valueOf(ay1.b.u())) == true) goto L14;
    L48:
        r13 = false;
        goto L49
    L5:
        r0 = r9.getTotalCount();
        goto L6
    }
}
