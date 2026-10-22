package com.bytedance.android.live.recharge.utils;

import com.bytedance.android.live.recharge.order.Order;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class LastCustomRechargeRecoder {
    public static final boolean a = false;
    public static final long b = 0;
    public static final boolean c = false;

    public static final class a<T> implements Comparator<T> {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r3, T r4) {
            return ComparisonsKt.compareValues(Long.valueOf(((com.bytedance.android.live.recharge.deal.u) r3).c), Long.valueOf(((com.bytedance.android.live.recharge.deal.u) r4).c));
        }
    }

    static {
        a = t.a().m6();
        b = t.a().v7();
        c = t.a().I2();
    }

    public static String a() {
        cy0.e.a.getClass();
        cy0.j r1 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r0 = com.bytedance.android.scope.m.b(r1).b(com.bytedance.android.livesdk.revenue.service.user.a.class);
        Intrinsics.checkNotNull(r0);
        return ((com.bytedance.live.kmp.core.c) r0).getCurrentUserId();
    }

    public static void b(Order r6, com.bytedance.android.live.recharge.panel.context.c r7) {
        Intrinsics.checkNotNullParameter(r6, "order");
        Intrinsics.checkNotNullParameter(r7, "panelContext");
        com.bytedance.android.live.recharge.deal.f r0 = r6.o();
        if ((r0 instanceof com.bytedance.android.live.recharge.deal.u) == false) goto L11;
        if (((com.bytedance.android.live.recharge.deal.u) r0).h == true) goto L8;
    L15:
        boolean r8 = false;
    L16:
        if (r8 == true) goto L18;
    L20:
        long r9 = 0;
    L21:
        HashMap r10 = MapsKt.hashMapOf(new Pair[]{TuplesKt.to(a(), Long.valueOf(r9))});
        KProperty[] r12 = i.a;
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        i.d.setValue(null, i.a[2], r10);
        return;
    L18:
        if (r6.o().g() > b) goto L20;
        r9 = r6.o().g();
        goto L21
    L8:
        if (r7.a().e == true) goto L11;
    L14:
        r8 = true;
    L11:
        if ((r0 instanceof com.bytedance.android.live.recharge.deal.d) == false) goto L15;
        if (((com.bytedance.android.live.recharge.deal.d) r0).k == false) goto L15;
        goto L14
    }

    public static com.bytedance.android.live.recharge.deal.i c(com.bytedance.android.live.recharge.deal.i r14, com.bytedance.android.live.recharge.panel.context.c r15) {
        Intrinsics.checkNotNullParameter(r14, "dealSet");
        Object r0 = null;
        if (r15 == null) goto L7;
        com.bytedance.android.live.recharge.model.d r16 = r15.a();
        if (r16 == null) goto L7;
        String r17 = r16.b;
    L9:
        if ((!Intrinsics.areEqual(r17, "click")) == false) goto L12;
        return r14;
    L12:
        if (a == true) goto L14;
        return r14;
    L14:
        Long r18 = (Long) ((HashMap) i.d.getValue(null, i.a[2])).get(a());
        long r2 = 0;
        if (r18 == null) goto L17;
        final long r4 = r18.longValue();
    L19:
        if (r4 > 0) goto L22;
        return r14;
    L22:
        if (r14.c().isEmpty() == false) goto L25;
        return r14;
    L25:
        if (c == false) goto L43;
        Iterator<T> r19 = r14.c().iterator();
    L28:
        if (r19.hasNext() == false) goto L35;
        Object r7 = r19.next();
        if (((com.bytedance.android.live.recharge.deal.u) r7).b != r14.d()) goto L32;
        boolean r8 = true;
    L33:
        if (r8 == false) goto L28;
        r0 = r7;
        goto L35
    L32:
        r8 = false;
    L35:
        com.bytedance.android.live.recharge.deal.u r1 = (com.bytedance.android.live.recharge.deal.u) r0;
        if (r1 != null) goto L38;
        r1 = (com.bytedance.android.live.recharge.deal.u) CollectionsKt.firstOrNull(r14.c());
    L38:
        if (r1 == null) goto L41;
        r2 = r1.c;
    L41:
        if (r4 > r2) goto L43;
        return r14;
    L43:
        com.bytedance.android.live.recharge.deal.u r110 = com.bytedance.android.live.recharge.deal.dto.a.a((int) r4, "上次使用");
        List r3 = CollectionsKt.toMutableList(CollectionsKt.sortedWith(r14.c(), new a()));
        int r5 = CollectionsKt.binarySearch$default(r3, 0, 0, new LastCustomRechargeRecoder$tryInsertLastUseDeal$index$1(r4), 3, null);
        if (r5 < 0) goto L46;
        com.bytedance.android.live.recharge.deal.f r6 = (com.bytedance.android.live.recharge.deal.f) ListProtector.get(r3, r5);
        ListProtector.set(r3, r5, r110);
    L56:
        int r9 = com.bytedance.android.live.recharge.deal.k.a;
        Long r10 = Long.valueOf(r110.b);
        Long r12 = Long.valueOf(r110.b);
        Map<Long, com.bytedance.android.live.recharge.platform.business.model.diamond.g> r111 = r14.getPanelExtraInfo();
        LinkedHashMap r13 = new LinkedHashMap();
        Iterator<Map.Entry<Long, com.bytedance.android.live.recharge.platform.business.model.diamond.g>> r112 = r111.entrySet().iterator();
    L58:
        if (r112.hasNext() == false) goto L65;
        Map.Entry<Long, com.bytedance.android.live.recharge.platform.business.model.diamond.g> r20 = r112.next();
        if (r20.getKey().longValue() == r6.g()) goto L62;
        boolean r22 = true;
    L63:
        if (r22 == false) goto L58;
        r13.put(r20.getKey(), r20.getValue());
        goto L58
    L62:
        r22 = false;
        goto L63
    L65:
        Map<Long, com.bytedance.android.live.recharge.model.diamond.e> r113 = r14.j();
        LinkedHashMap r114 = new LinkedHashMap();
        Iterator<Map.Entry<Long, com.bytedance.android.live.recharge.model.diamond.e>> r115 = r113.entrySet().iterator();
    L67:
        if (r115.hasNext() == false) goto L75;
        Map.Entry<Long, com.bytedance.android.live.recharge.model.diamond.e> r23 = r115.next();
        if (r23.getKey().longValue() == r6.g()) goto L71;
        boolean r24 = true;
    L72:
        if (r24 == false) goto L67;
        r114.put(r23.getKey(), r23.getValue());
        goto L67
    L71:
        r24 = false;
        goto L72
    L75:
        return com.bytedance.android.live.recharge.deal.k.a(r14, r3, r10, r12, r114, r13, 4);
    L46:
        int r25 = (-r5) - 1;
        if (r25 != 0) goto L50;
        r6 = (com.bytedance.android.live.recharge.deal.f) ListProtector.get(r3, r25);
        ListProtector.set(r3, r25, r110);
        goto L56
    L50:
        if (r25 != r3.size()) goto L52;
        r6 = (com.bytedance.android.live.recharge.deal.f) ListProtector.remove(r3, 0);
        r3.add(r110);
        goto L56
    L52:
        int r26 = r25 - 1;
        com.bytedance.android.live.recharge.deal.u r27 = (com.bytedance.android.live.recharge.deal.u) ListProtector.get(r3, r26);
        com.bytedance.android.live.recharge.deal.u r28 = (com.bytedance.android.live.recharge.deal.u) ListProtector.get(r3, r25);
        long r29 = r110.c;
        if ((r29 - r27.c) > (r28.c - r29)) goto L55;
        r25 = r26;
    L55:
        r6 = (com.bytedance.android.live.recharge.deal.f) ListProtector.get(r3, r25);
        ListProtector.set(r3, r25, r110);
        goto L56
    L17:
        r4 = 0;
    L7:
        r17 = null;
        goto L9
    }
}
