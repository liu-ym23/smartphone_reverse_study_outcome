package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper;

import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.s0;
import com.bytedance.android.anya.t0;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftVerticalState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ItemListData;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.PagerListData;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.e1;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.u1;
import com.bytedance.bdlocation.BuildConfig;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i0 {
    public final Map<Integer, IntRange> a;
    public long b;
    public final Map<Integer, Long> c;
    public final u1 d;
    public final e1 e;
    public final Function1<Integer, Integer> f;

    public final void c(com.bytedance.android.anya.l0<GiftVerticalState> r5, IntRange r6) {
        Intrinsics.checkNotNullParameter(r5, "$this$initCurrentRangeTime");
        if (r6 != null) goto L5;
        return;
    L5:
        int r7 = r6.getFirst();
        int r8 = r6.getLast();
        if (r7 > r8) goto L12;
    L7:
        Map<Integer, Long> r0 = this.c;
        LinkedHashMap r1 = (LinkedHashMap) r0;
        if (r1.get(Integer.valueOf(r7)) != null) goto L10;
        this.c.put(Integer.valueOf(r7), Long.valueOf(System.currentTimeMillis()));
    L10:
        if (r7 == r8) goto L14;
        r7 = r7 + 1;
        goto L7
    L14:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public i0(u1 r2, e1 r3, Function1<? super Integer, Integer> r4) {
        Intrinsics.checkNotNullParameter(r2, "giftPanelLogService");
        Intrinsics.checkNotNullParameter(r3, "giftListService");
        Intrinsics.checkNotNullParameter(r4, "getOrder");
        this.d = r2;
        this.e = r3;
        this.f = r4;
        this.a = new LinkedHashMap();
        this.c = new LinkedHashMap();
    }

    public final void a(com.bytedance.android.anya.l0<GiftVerticalState> r24, GiftVerticalState r25, int r26) {
        Intrinsics.checkNotNullParameter(r24, "$this$clear");
        Intrinsics.checkNotNullParameter(r25, "state");
        Iterator r0 = ((LinkedHashMap) this.c).entrySet().iterator();
        int r4 = r26;
    L4:
        if (r0.hasNext() == false) goto L52;
        Map.Entry r5 = (Map.Entry) r0.next();
        int r6 = ((Number) r5.getKey()).intValue();
        long r15 = ((Number) r5.getValue()).longValue();
        t0<GiftVerticalState, PagerListData> r7 = r25.getPanelList();
        r24.getClass();
        if (com.bytedance.android.anya.h.a(r7) <= r4) goto L50;
        com.bytedance.android.anya.internal.u r8 = r25.getPanelList();
        MVIState r14 = (MVIState) ((s0) r8.c()).get(r4);
        new com.bytedance.android.anya.k0.a();     // Catch: Throwable -> L44
        PagerListData r9 = (PagerListData) r14;     // Catch: Throwable -> L44
        if (((s0) r9.getItemDataList().c()).size() > r6) goto L54;
        Iterator r21 = r0;
        MVIState r3 = r14;
    L40:
        if ((!r3.modifiedProperties.isEmpty()) == false) goto L42;
        int r2 = r26;
        ((com.bytedance.android.anya.internal.t) r8.c()).d(r2);
    L43:
        r4 = r2;
    L51:
        r0 = r21;
        goto L4
    L42:
        r2 = r26;
        goto L43
    L54:
        com.bytedance.android.anya.internal.u r10 = r9.getItemDataList();     // Catch: Throwable -> L35
        com.bytedance.android.anya.internal.u r11 = r10;     // Catch: Throwable -> L35
        MVIState r13 = (MVIState) ((s0) r10.c()).get(r6);     // Catch: Throwable -> L35
        new com.bytedance.android.anya.k0.a();     // Catch: Throwable -> L27
        vz1.e r16 = (vz1.e) ((ItemListData) r13).getItemData().c();     // Catch: Throwable -> L27
        u1 r17 = this.d;     // Catch: Throwable -> L27
        long r18 = r16.b;     // Catch: Throwable -> L27
        if (r16.e == true) goto L14;
        boolean r19 = true;
    L15:
        r21 = r0;
        Integer r1 = (Integer) ((LinkedHashMap) this.e.c).get(Integer.valueOf(r26));     // Catch: Throwable -> L27
        if (r1 == null) goto L18;
        int r20 = r1.intValue();     // Catch: Throwable -> L27
    L19:
        m0.e.getClass();     // Catch: Throwable -> L27
        MVIState r23 = r13;
        r3 = r14;
        r17.y0(r18, r19, r20, r26, r6, m0.a.a(r16), r15, System.currentTimeMillis(), ((Number) this.f.invoke(Integer.valueOf(r26))).intValue());     // Catch: Throwable -> L25
    L33:
        th = th;
    L37:
        r4 = r26;
    L47:
        if ((!r3.modifiedProperties.isEmpty()) == false) goto L49;
        ((com.bytedance.android.anya.internal.t) r8.c()).d(r4);
    L49:
        throw th;
    L23:
        if ((!r23.modifiedProperties.isEmpty()) == false) goto L40;
        ((com.bytedance.android.anya.internal.t) r10.c()).d(r6);     // Catch: Throwable -> L33
    L25:
        th = th;
    L30:
        if ((!r23.modifiedProperties.isEmpty()) == false) goto L32;
        ((com.bytedance.android.anya.internal.t) r10.c()).d(r6);     // Catch: Throwable -> L33
    L32:
        throw th;     // Catch: Throwable -> L33
    L18:
        r20 = 0;
        goto L19
    L14:
        r19 = false;
    L27:
        th = th;
        r23 = r13;
        r3 = r14;
    L35:
        th = th;
        r3 = r14;
    L44:
        th = th;
        r3 = r14;
        goto L47
    L50:
        r21 = r0;
        goto L51
    L52:
        ((LinkedHashMap) this.c).clear();
    }

    public final void b(com.bytedance.android.anya.l0<GiftVerticalState> r18, GiftVerticalState r19, int r20, IntRange r21) {
        Intrinsics.checkNotNullParameter(r18, "$this$endScroll");
        Intrinsics.checkNotNullParameter(r19, "state");
        Intrinsics.checkNotNullParameter(r21, "currentRange");
        u1 r2 = this.d;
        Integer r3 = (Integer) ((LinkedHashMap) ((e1) com.bytedance.android.live.revenue.core.util.f.a(e1.class)).c).get(Integer.valueOf(r20));
        if (r3 == null) goto L5;
        int r4 = r3.intValue();
    L6:
        IntRange r5 = (IntRange) ((LinkedHashMap) this.a).get(Integer.valueOf(r20));
        if (r5 == null) goto L9;
        Intrinsics.checkNotNullParameter(r5, "$this$iconRangeToShowRange");
        IntRange r9 = new IntRange((r5.getFirst() / 4) + 1, (r5.getLast() / 4) + 1);
    L10:
        IntRange r6 = (IntRange) ((LinkedHashMap) this.a).get(Integer.valueOf(r20));
        if (r6 == null) goto L13;
        int r7 = r6.getLast();
    L14:
        IntRange r8 = (IntRange) ((LinkedHashMap) this.a).get(Integer.valueOf(r20));
        if (r8 == null) goto L17;
        int r10 = r8.getFirst();
    L18:
        long r11 = (System.currentTimeMillis() - this.b) / ((long) IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW);
        r2.getClass();
        Intrinsics.checkNotNullParameter(r9, "rowLocation");
        Intrinsics.checkNotNullParameter(BuildConfig.FLAVOR, "vsSeasonID");
        Pair[] r13 = new Pair[7];
        r13[0] = TuplesKt.to("tab_name", ((e1) com.bytedance.android.live.revenue.core.util.f.a(e1.class)).F5(r4));
        r13[1] = TuplesKt.to("tab_location", String.valueOf(r20 + 1));
        r13[2] = TuplesKt.to("scroll_rows", String.valueOf((r9.getLast() - r9.getFirst()) + 1));
        r13[3] = TuplesKt.to("start_row_location", String.valueOf(r9.getFirst()));
        r13[4] = TuplesKt.to("end_row_location", String.valueOf(r9.getLast()));
        r13[5] = TuplesKt.to("scroll_gift_num", String.valueOf((r7 - r10) * 4));
        long r14 = 10000;
        if (0 <= r11) goto L22;
    L24:
        String r15 = "0";
    L25:
        r13[6] = TuplesKt.to("scroll_duration", r15);
        Map<String, String> r16 = MapsKt.mutableMapOf(r13);
        r16.put("is_vs", String.valueOf(0));
        r16.put("vs_season_id", BuildConfig.FLAVOR);
        if (r4 != 5) goto L28;
        String r17 = "1";
    L29:
        r16.put("is_prop", r17);
        r2.p1("livesdk_gift_panel_scroll", r16, true);
        this.a.put(Integer.valueOf(r20), r21);
        return;
    L28:
        r17 = "2";
        goto L29
    L22:
        if (r14 < r11) goto L24;
        r15 = String.valueOf(r11);
        goto L25
    L17:
        r10 = 0;
        goto L18
    L13:
        r7 = 0;
        goto L14
    L9:
        r9 = new IntRange(-1, -1);
        goto L10
    L5:
        r4 = 0;
        goto L6
    }

    public final void d(com.bytedance.android.anya.l0<GiftVerticalState> r2, GiftVerticalState r3, int r4, IntRange r5) {
        Intrinsics.checkNotNullParameter(r2, "$this$startScroll");
        Intrinsics.checkNotNullParameter(r3, "state");
        Intrinsics.checkNotNullParameter(r5, "currentRange");
        this.b = System.currentTimeMillis();
        this.a.put(Integer.valueOf(r4), r5);
    }
}
