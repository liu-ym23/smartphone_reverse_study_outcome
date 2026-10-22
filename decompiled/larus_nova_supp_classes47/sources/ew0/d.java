package ew0;

import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.recharge.deal.i;
import com.bytedance.android.live.recharge.deal.r;
import com.bytedance.android.live.recharge.deal.u;
import com.bytedance.android.live.recharge.utils.LastCustomRechargeRecoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d implements dw0.a {
    public static final d a = null;

    public d() {
    }

    static {
        a = new d();
    }

    @Override // dw0.a
    public final void a(String r19, Map<String, String> r20, Collection<? extends Object> r22) {
        Intrinsics.checkNotNullParameter(r19, "eventName");
        Intrinsics.checkNotNullParameter(r20, "eventProperties");
        Intrinsics.checkNotNullParameter(r22, "eventContext");
        com.bytedance.android.live.recharge.panel.context.c r1 = com.bytedance.android.live.recharge.panel.g.a();
        if (r1 == null) goto L7;
        com.bytedance.android.live.revenue.common.reactive.e<i> r3 = r1.g();
        if (r3 == null) goto L7;
        i r4 = r3.getValue();
    L8:
        if (r4 != null) goto L10;
        return;
    L10:
        if (Intrinsics.areEqual(r4, r.b) == true) goto L126;
        long r5 = r4.l();
        Iterator<T> r6 = r4.c().iterator();
    L13:
        boolean r8 = true;
        if (r6.hasNext() == false) goto L21;
        Object r7 = r6.next();
        if (((u) r7).b != r5) goto L18;
        boolean r10 = true;
    L19:
        if (r10 == false) goto L13;
    L22:
        u r9 = (u) r7;
        if (r9 == null) goto L25;
        long r12 = r9.c;
    L26:
        if (r9 == null) goto L28;
        boolean r13 = r9.h;
    L29:
        List<u> r14 = r4.c();
        ListIterator<u> r15 = r14.listIterator(r14.size());
    L31:
        if (r15.hasPrevious() == false) goto L38;
        u r16 = r15.previous();
        if (r16.e <= 0) goto L35;
        boolean r17 = true;
    L36:
        if (r17 == false) goto L31;
    L39:
        u r18 = r16;
        if (r18 == null) goto L42;
        int r110 = r18.e;
    L43:
        ArrayList r111 = new ArrayList();
        Iterator<u> r112 = r4.c().iterator();
    L45:
        if (r112.hasNext() == false) goto L47;
        u r113 = r112.next();
        r111.add(MapsKt.mapOf(new Pair[]{TuplesKt.to("money", String.valueOf(r113.d)), TuplesKt.to("given_scores", String.valueOf(r113.e)), TuplesKt.to("money_paid", String.valueOf(r113.c))}));
        goto L45
    L47:
        r20.put("charge_packages", r111.toString());
        long r23 = 0;
        if (r12 <= 0) goto L50;
        String r24 = String.valueOf(r12);
    L64:
        r20.put("recommend_package", r24);
        r20.put("discount_scores", String.valueOf(r110));
        if (r12 > 0) goto L67;
    L69:
        if (r12 <= 0) goto L81;
        if (r13 == false) goto L81;
        boolean r2 = LastCustomRechargeRecoder.a;
        if (r9 == null) goto L78;
        String r25 = r9.f;
        if (r25 == null) goto L78;
        if (r25.equals("上次使用") != true) goto L78;
        boolean r26 = true;
    L79:
        if (r26 == false) goto L81;
        String r27 = "last_recharge";
    L82:
        r20.put("recommend_package_source", r27);
        boolean r28 = r4.m();
        String r29 = DataType.TRUE;
        if (r28 == false) goto L85;
        String r30 = DataType.TRUE;
    L86:
        r20.put("is_first_recharge", r30);
        Iterator<T> r32 = r4.c().iterator();
    L88:
        if (r32.hasNext() == false) goto L95;
        Object r33 = r32.next();
        if (((u) r33).e <= 0) goto L92;
        boolean r34 = true;
    L93:
        if (r34 == false) goto L88;
    L96:
        if (r33 == null) goto L99;
        r8 = false;
    L99:
        if (r8 == true) goto L102;
        r29 = DataType.FALSE;
    L102:
        r20.put("is_include_discount_package", r29);
        return;
    L92:
        r34 = false;
        goto L93
    L95:
        r33 = null;
        goto L96
    L85:
        r30 = DataType.FALSE;
    L78:
        r26 = false;
    L81:
        r27 = "default";
        goto L82
    L67:
        if (r1.a().e == false) goto L69;
        r27 = "balance";
        goto L82
    L50:
        Iterator<T> r114 = r4.c().iterator();
    L52:
        if (r114.hasNext() == false) goto L59;
        Object r115 = r114.next();
        if (((u) r115).b != r4.d()) goto L56;
        boolean r116 = true;
    L57:
        if (r116 == false) goto L52;
    L60:
        u r117 = (u) r115;
        if (r117 == null) goto L63;
        r23 = r117.c;
    L63:
        r24 = String.valueOf(r23);
        goto L64
    L56:
        r116 = false;
        goto L57
    L59:
        r115 = null;
        goto L60
    L42:
        r110 = 0;
        goto L43
    L35:
        r17 = false;
        goto L36
    L38:
        r16 = null;
        goto L39
    L28:
        r13 = false;
        goto L29
    L25:
        r12 = 0;
        goto L26
    L18:
        r10 = false;
        goto L19
    L21:
        r7 = null;
        goto L22
    L126:
        return;
    L7:
        r4 = null;
        goto L8
    }
}
