package ny1;

import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.android.live.revlink.api.ILinkService;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.livesdk.gift.platform.core.model.k;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.e1;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.g1;
import com.bytedance.android.livesdk.gift.platform.core.utils.h;
import com.bytedance.android.livesdk.gift.platform.core.utils.u;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.revenue.log.i;
import com.bytedance.bdlocation.BuildConfig;
import cy0.e;
import cy0.j;
import i12.o;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import l01.d;
import mz0.m;
import mz0.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ h1 a;
    public final /* synthetic */ long b;
    public final /* synthetic */ long c;
    public final /* synthetic */ long d;
    public final /* synthetic */ k e;

    public a(h1 r1, long r2, long r4, long r6, k r8, k r9) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
        this.d = r6;
        this.e = r8;
    }

    public final void accept(Object r29) {
        ExtraResponse r1 = (ExtraResponse) r29;
        Map r2 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("request_page", "gift_tab_suit_icon"), TuplesKt.to("anchor_id", String.valueOf(this.b)), TuplesKt.to("room_id", String.valueOf(this.c)), TuplesKt.to("gift_id", String.valueOf(this.a.getId())), TuplesKt.to("money", String.valueOf(this.a.getDiamondCount())), TuplesKt.to("show_from", "gift_tab"), TuplesKt.to("user_type", "normal"), TuplesKt.to("page_type", "default"), TuplesKt.to("request_page", "gift_tab_suit_icon"), TuplesKt.to("goods_id", String.valueOf(this.d))});
        n r9 = new n();
        Map r11 = r9.a;
        Intrinsics.checkNotNullParameter(r11, "map");
        Intrinsics.checkNotNullParameter(r2, "map");
        r11.putAll(r2);
        m r3 = new m();
        LogCommon r13 = LogCommon.ROOM;
        r3.b(r13);
        i r8 = vh6.c.b(kr2.a.class).ud();
        Intrinsics.checkNotNullParameter(r8, "pageSourceLog");
        ((ArrayList) r3.a).add(r8.a);
        ((ArrayList) r9.b).addAll(r3.a);
        e.a.getClass();
        j r4 = e.a.a;
        com.bytedance.android.scope.m r5 = com.bytedance.android.scope.m.e;
        r5.getClass();
        Object r7 = com.bytedance.android.scope.m.b(r4).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r7);
        ((f80.a) r7).w3("livesdk_package_get_success", r9.a, r9.b);
        long r10 = this.a.getId();
        int r14 = this.a.getDiamondCount();
        long r15 = this.b;
        long r16 = this.c;
        k r17 = this.e;
        String r23 = f.a(d.class).getCurrentUserId();
        if (r17 == null) goto L5;
        int r0 = r17.a;
    L6:
        int r24 = r0 % 8;
        if (r24 != 0) goto L9;
        int r25 = 0;
    L10:
        int r6 = x12.b.a();
        Pair[] r18 = new Pair[19];
        r18[0] = TuplesKt.to("anchor_id", String.valueOf(r15));
        r18[1] = TuplesKt.to("room_id", String.valueOf(r16));
        r18[2] = TuplesKt.to("gift_id", String.valueOf(r10));
        r18[3] = TuplesKt.to("business_type", "1");
        r18[4] = TuplesKt.to("consume_type", "direct");
        r18[5] = TuplesKt.to("user_id", r23.toString());
        String r19 = h.a;
        String r20 = null;
        if (r17 == null) goto L13;
        Integer r21 = Integer.valueOf(r17.a);
    L14:
        r18[6] = TuplesKt.to("gift_column_location", String.valueOf(h.d(r21)));
        if (r17 == null) goto L17;
        Integer r26 = Integer.valueOf(r17.a);
    L18:
        r18[7] = TuplesKt.to("gift_row_location", String.valueOf(h.h(r26)));
        r18[8] = TuplesKt.to("page_location", String.valueOf((r0 / 8) + r25));
        int[] r27 = h.b;
        if (r25 != 0) goto L21;
        int r110 = 8;
    L22:
        r18[9] = TuplesKt.to("gift_location", String.valueOf(r27[r110]));
        GiftContext r28 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r28 == null) goto L28;
        com.bytedance.live.datacontext.m<String> r30 = r28.getGiftListResultLogId();
        if (r30 == null) goto L28;
        String r31 = (String) r30.getValue();
        if (r31 == null) goto L28;
    L29:
        r18[10] = TuplesKt.to("gift_dialog_request_id", r31);
        r18[11] = TuplesKt.to("send_gift_scene", vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class).changeMode2String(r6));
        r18[12] = TuplesKt.to("connection_type", h.e());
        r18[13] = TuplesKt.to("anchor_cnt", f.a(ILinkService.class).getLinkAnchorCount());
        r18[14] = TuplesKt.to("gift_cnt", "1");
        r18[15] = TuplesKt.to("gift_source", "gift_tab");
        r18[16] = TuplesKt.to("money", String.valueOf(r14));
        r18[17] = TuplesKt.to("order_type", tz1.a.b());
        h1 r33 = ((e1) f.a(e1.class)).findGiftById(r10);
        if (r33 == null) goto L32;
        int r111 = r33.getGiftSource();
    L33:
        r18[18] = TuplesKt.to("gift_creation_source", String.valueOf(r111));
        Map<String, String> r34 = MapsKt.mutableMapOf(r18);
        if (u.r() == true) goto L42;
        i12.e r35 = o.b();
        if (r35 == null) goto L38;
        Object r36 = r5.d(r35, g1.class);
    L39:
        g1 r37 = (g1) r36;
        if (r37 == null) goto L43;
        r37.d(r34);
    L43:
        GiftContext r38 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r38 == null) goto L49;
        Bundle r39 = (Bundle) r38.getGiftLogExtra().getValue();
        if (r39 == null) goto L49;
        r20 = r39.getString("gift_show_from");
    L49:
        if (TextUtils.isEmpty(r20) == false) goto L51;
        r34.put("gift_show_from", h.a);
    L62:
        n r40 = new n();
        Map r41 = r40.a;
        Intrinsics.checkNotNullParameter(r41, "map");
        Intrinsics.checkNotNullParameter(r34, "map");
        r41.putAll(r34);
        m r43 = new m();
        r43.b(r13);
        i r44 = vh6.c.b(kr2.a.class).ud();
        Intrinsics.checkNotNullParameter(r44, "pageSourceLog");
        ((ArrayList) r43.a).add(r44.a);
        ((ArrayList) r40.b).addAll(r43.a);
        Object r45 = com.bytedance.android.scope.m.b(r4).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r45);
        ((f80.a) r45).w3("livesdk_send_gift", r40.a, r40.b);
        return;
    L51:
        if (Intrinsics.areEqual("hourly", r20) == false) goto L53;
    L60:
        r34.put("gift_show_from", "hour_rank");
        goto L62
    L53:
        if (Intrinsics.areEqual("regional", r20) == true) goto L60;
        if (Intrinsics.areEqual("bottom_tab", r20) == false) goto L58;
        r34.put("gift_show_from", "icon");
        goto L62
    L58:
        if (r20 == null) goto L62;
        r34.put("gift_show_from", r20);
        goto L62
    L38:
        r36 = null;
        goto L39
    L42:
        r34.put("tab_name", ((e1) f.a(e1.class)).F5(com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.f()));
        r34.put("tab_location", String.valueOf(com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.h() + 1));
        goto L43
    L32:
        r111 = 0;
    L28:
        r31 = BuildConfig.FLAVOR;
        goto L29
    L21:
        r110 = r24;
        goto L22
    L17:
        r26 = null;
        goto L18
    L13:
        r21 = null;
        goto L14
    L9:
        r25 = 1;
        goto L10
    L5:
        r0 = 0;
        goto L6
    }
}
