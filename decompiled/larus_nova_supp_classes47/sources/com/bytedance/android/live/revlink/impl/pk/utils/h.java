package com.bytedance.android.live.revlink.impl.pk.utils;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.core.utils.x1;
import com.bytedance.android.live.revlink.impl.global.LinkFakeGlobalService;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import fr2.h1;
import fr2.i1;
import fr2.j1;
import java.util.Iterator;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h {
    public final ld.a a;
    public final com.bytedance.android.livesdk.revenue.service.room.c b;
    public final com.bytedance.android.live.revlink.impl.global.c c;

    public static qr2.b d() {
        b03.a r0 = b03.a.a;
        int r1 = s1.y();
        int r2 = (r1 * 16) / 9;
        if (PadConfigUtils.a() == false) goto L7;
        if (b03.a.c() == true) goto L7;
    L8:
        int r3 = s1.w();
        int r4 = (r3 * 9) / 16;
        int r5 = (r1 - r4) / 2;
        r1 = r4;
        int r6 = r3;
    L10:
        jy0.b.c("testSingle", "obtainRenderP w-h:" + r1 + ' ' + r6, null, 4);
        return new qr2.b(r1, r6, r5, 0);
    L7:
        if (FoldScreenUtils.f() == true) goto L8;
        r6 = r2;
        r5 = 0;
        goto L10
    }

    public final String a() {
        com.bytedance.android.livesdk.revenue.service.room.c r0 = this.b;
        if (r0 == null) goto L15;
        com.bytedance.android.livesdk.revenue.room.a r1 = r0.getRoomContext();
        if (r1 == null) goto L15;
        com.bytedance.android.livesdk.revenue.pushstream.a r2 = r1.getCommonLiveStream();
        if (r2 == null) goto L15;
        j1 r3 = r2.j();
        if (r3 == null) goto L15;
        i1 r4 = r3.f3();
        if (r4 == null) goto L15;
        h1 r5 = r4.K0();
        if (r5 == null) goto L15;
        return r5.b();
    L15:
        return "";
    }

    public static String c(Map r6) {
        Intrinsics.checkNotNullParameter(r6, "regions");
        JSONObject r0 = new JSONObject();
        JSONArray r1 = new JSONArray();
        Iterator r7 = r6.entrySet().iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        pc0.c r2 = (pc0.c) ((Map.Entry) r7.next()).getValue();
        Intrinsics.checkNotNullParameter(r2, "$this$toJsonObj");
        JSONObject r3 = new JSONObject();
        r3.put("areaKey", r2.a);
        r3.put("x", Float.valueOf(r2.b));
        r3.put("y", Float.valueOf(r2.c));
        r3.put("w", Float.valueOf(r2.d));
        r3.put("h", Float.valueOf(r2.e));
        r1.put(r3);
        goto L4
    L6:
        r0.put("LiveGrids", r1);
        return r0.toString();
    }

    public final Pair<Integer, Integer> b(o51.e r10) {
        Intrinsics.checkNotNullParameter(r10, "uiLayout");
        boolean r12 = r10 instanceof o51.e.d;
        if (r12 == false) goto L5;
    L8:
        ld.a r0 = this.a;
        if (r0 == null) goto L13;
        NextLiveData r1 = r0.Ii();
        if (r1 == null) goto L13;
        Pair r2 = (Pair) r1.getValue();
    L14:
        int r3 = 0;
        if (r2 == null) goto L19;
        Integer r4 = (Integer) r2.getFirst();
        if (r4 == null) goto L19;
        int r5 = r4.intValue();
    L20:
        if (r2 == null) goto L24;
        Integer r6 = (Integer) r2.getSecond();
        if (r6 == null) goto L24;
        int r7 = r6.intValue();
    L25:
        d51.c r8 = d51.c.A0;
        r8.getClass();
        if (((Boolean) d51.c.q.getValue(r8, d51.c.a[15])).booleanValue() == false) goto L38;
        int r9 = com.bytedance.android.live.revenue.common.i.b(52);
        b03.a r13 = b03.a.a;
        boolean r14 = s1.d(s1.getContext());
        if (s1.d(s1.getContext()) == false) goto L30;
        int r15 = s1.o();
    L31:
        int r16 = (x1.e(s1.getContext()) - s1.A()) - r9;
        if (r14 == false) goto L34;
        r16 = r16 - r15;
    L34:
        if (r12 == false) goto L38;
        if (r5 <= 0) goto L38;
        if (r7 >= r16) goto L38;
        r7 = r16;
        goto L38
    L30:
        r15 = 0;
    L38:
        if (r7 <= 0) goto L43;
        if (r5 <= 0) goto L43;
        return TuplesKt.to(Integer.valueOf(r5), Integer.valueOf(r7));
    L43:
        int r17 = com.bytedance.android.live.revenue.common.i.b(52);
        b03.a r18 = b03.a.a;
        boolean r19 = s1.d(s1.getContext());
        if (s1.d(s1.getContext()) == false) goto L46;
        r3 = s1.o();
    L46:
        int r20 = x1.e(s1.getContext()) - s1.A();
        if (r19 == false) goto L49;
        r20 = r20 - r3;
    L49:
        int r22 = s1.y();
        int r23 = r22 * 16;
        if ((r20 * 9) <= r23) goto L55;
        int r110 = r20 - r17;
        if ((r23 / 9) > r110) goto L55;
        r20 = r110;
    L55:
        return TuplesKt.to(Integer.valueOf(r22), Integer.valueOf(r20));
    L24:
        r7 = 0;
    L19:
        r5 = 0;
    L13:
        r2 = null;
        goto L14
    L5:
        if (d51.c.A0.g() == false) goto L8;
        qr2.b r111 = d();
        return TuplesKt.to(Integer.valueOf(r111.a), Integer.valueOf(r111.b));
    }

    public h(ld.a r1, com.bytedance.android.livesdk.revenue.service.room.c r2, LinkFakeGlobalService r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
