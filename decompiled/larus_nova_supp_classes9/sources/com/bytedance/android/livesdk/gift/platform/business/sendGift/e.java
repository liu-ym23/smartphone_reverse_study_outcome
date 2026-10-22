package com.bytedance.android.livesdk.gift.platform.business.sendGift;

import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.gift.model.h2;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.livesdk.gift.platform.core.model.b0;
import com.bytedance.android.livesdk.gift.platform.core.model.t;
import com.bytedance.android.livesdk.gift.platform.core.utils.u;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.utils.c1;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.ugc.effectmanager.common.utils.JsonExtKt;
import i12.o;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String b(String r1, mz0.e r2) {
        Intrinsics.checkNotNullParameter(r2, "logFilter");
        Map r3 = r2.getMap();
        if (r3 == null) goto L6;
        String r4 = (String) r3.get(r1);
        if (r4 == null) goto L6;
        return r4;
    L6:
        return BuildConfig.FLAVOR;
    }

    public static JSONObject a(IRoom r11, DataCenter r13, t r14, int r15) {
        JSONObject r0 = vh6.c.b(kr2.a.class).Ga(r13);
        String r1 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.room.b.class).Ub(r13);
        Integer r2 = null;
        if (r1 != null) goto L5;
    L10:
        boolean r3 = c1.b(r13);
        boolean r4 = false;
        String r5 = BuildConfig.FLAVOR;
        if (r3 == false) goto L48;
        JSONObject r6 = new JSONObject();
        String r7 = (String) c1.e(r13).get("log_extra");
        if (r7 != null) goto L15;
        r7 = BuildConfig.FLAVOR;
    L15:
        Set r8 = SetsKt.setOf(new String[]{"req_id", "rit", "orit"});
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L24
        if (r7.length() != 0) goto L19;
        boolean r10 = true;
    L20:
        if (r10 == false) goto L22;
        r7 = "{}";
    L22:
        Object r16 = Result.constructor-impl(new JSONObject(r7));     // Catch: Throwable -> L24
    L27:
        if (Result.isFailure-impl(r16) == false) goto L29;
        r16 = null;
    L29:
        JSONObject r17 = (JSONObject) r16;
        if (r17 == null) goto L47;
        Map r18 = JsonExtKt.toMap(r17);
        if (r18 == null) goto L47;
        LinkedHashMap r19 = new LinkedHashMap();
        Iterator r20 = r18.entrySet().iterator();
    L35:
        if (r20.hasNext() == false) goto L39;
        Map.Entry r21 = (Map.Entry) r20.next();
        if (r8.contains((String) r21.getKey()) == false) goto L35;
        r19.put(r21.getKey(), r21.getValue());
        goto L35
    L39:
        Iterator r23 = r19.entrySet().iterator();
    L41:
        if (r23.hasNext() == false) goto L43;
        Map.Entry r24 = (Map.Entry) r23.next();
        r6.put((String) r24.getKey(), r24.getValue().toString());
        goto L41
    L43:
        String r110 = (String) c1.e(r13).get("value");
        if (r110 != null) goto L46;
        r110 = BuildConfig.FLAVOR;
    L46:
        r6.put("value", r110);
        r6.put("is_ad_event", "1");
        r6.put("category", "umeng");
        r6.put("event_source", "ad.promotionorder.extfaas");
        r6.put("os", "android");
    L47:
        r0.put("douplus_info", r6);
        goto L48
    L19:
        r10 = false;
    L24:
        th = move-exception;
        Result.Companion r25 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
    L48:
        if (r14 == null) goto L112;
        boolean r111 = u.p();
        if (r111 == false) goto L52;
        int r26 = 1;
    L53:
        r0.put("is_vs", r26);
        h2 r27 = r14.a().a;
        if (r27 == null) goto L56;
        int r28 = r27.getDiamondCount();
    L57:
        int r112 = r15 * r28;
        i12.e r29 = o.b();
        if (r29 == null) goto L60;
        Object r30 = com.bytedance.android.scope.m.e.d(r29, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.a.class);
    L61:
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.a r31 = (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.a) r30;
        if (r31 != null) goto L64;
    L75:
        r0.put("diamond", r112);
        i12.e r113 = o.b();
        if (r113 == null) goto L78;
        Object r114 = com.bytedance.android.scope.m.e.d(r113, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.a.class);
    L79:
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.a r115 = (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.a) r114;
        if (r115 != null) goto L82;
    L84:
        if (r11 == null) goto L86;
        String r116 = r11.getAnchorId();
    L88:
        if (Intrinsics.areEqual(r116, r14.i().g()) == true) goto L92;
        if (r111 == true) goto L92;
        r0.put("to_user_type", "guest");
    L93:
        b0 r117 = r14.i();
        if (TextUtils.isEmpty(r117.h) == true) goto L96;
        String r118 = r117.h;
    L105:
        if (TextUtils.isEmpty(r118) == true) goto L107;
        String r119 = String.valueOf(r118);
    L108:
        r0.put("gift_source", r119);
        if (TextUtils.equals("gift_tab", r119) == false) goto L111;
        r0.put("is_search", r14.i().V ? 1 : 0);
        r0.put("page_type", r14.i().y);
    L111:
        r0.put("gift_source_method", "gift_source_method_unknown");
        goto L112
    L107:
        r119 = "gift_tab";
        goto L108
    L96:
        GiftContext r120 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r120 == null) goto L103;
        com.bytedance.live.datacontext.n<Bundle> r121 = r120.getGiftLogExtra();
        if (r121 == null) goto L103;
        Bundle r122 = (Bundle) r121.getValue();
        if (r122 == null) goto L103;
        r118 = r122.getString("gift_source");
    L103:
        r118 = null;
    L92:
        r0.put("to_user_type", "anchor");
        goto L93
    L86:
        r116 = null;
        goto L88
    L82:
        if (r115.j() != true) goto L84;
        r0.put("to_user_type", "all_mic");
        goto L93
    L78:
        r114 = null;
        goto L79
    L64:
        if (r31.j() != true) goto L75;
        i12.e r33 = o.b();
        if (r33 == null) goto L68;
        Object r34 = com.bytedance.android.scope.m.e.d(r33, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.a.class);
    L69:
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.a r35 = (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.a) r34;
        if (r35 == null) goto L72;
        List<IBaseUser> r36 = r35.i();
    L73:
        if (r36 == null) goto L75;
        r112 = r112 * r36.size();
        goto L75
    L72:
        r36 = null;
        goto L73
    L68:
        r34 = null;
        goto L69
    L60:
        r30 = null;
        goto L61
    L56:
        r28 = 0;
        goto L57
    L52:
        r26 = -1;
    L112:
        if (r11 == null) goto L114;
        long r37 = r11.getLiveRoomMode();
    L115:
        r0.put("live_room_mode", r37);
        String r123 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class).changeMode2String(x12.b.a());
        if (r123 != null) goto L118;
    L119:
        r4 = true;
    L120:
        if (r4 == false) goto L122;
        r123 = "send_gift_scene_unknown";
    L122:
        r0.put("send_gift_scene", r123);
        GiftContext r124 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r124 == null) goto L150;
        Bundle r125 = (Bundle) r124.getGiftLogExtra().getValue();
        if (r125 == null) goto L131;
        String r38 = r125.getString("gift_show_from");
        if (r38 == null) goto L131;
        r5 = r38;
    L131:
        if (TextUtils.isEmpty(r5) == false) goto L133;
        r0.put("gift_show_from", "icon");
    L144:
        if (r125 == null) goto L146;
        long r39 = r125.getLong("guest_link_channel_id");
    L148:
        if (r39 == 0) goto L150;
        r0.put("guest_link_channel_id", r39);
        goto L150
    L146:
        r39 = 0;
        goto L148
    L133:
        if (Intrinsics.areEqual("hourly", r5) == false) goto L135;
    L140:
        r5 = "hour_rank";
    L141:
        r0.put("gift_show_from", r5);
        goto L144
    L135:
        if (Intrinsics.areEqual("regional", r5) == true) goto L140;
        if (Intrinsics.areEqual("bottom_tab", r5) == false) goto L141;
        r5 = "icon";
    L150:
        r0.put("gift_show_method", "gift_show_method_unknown");
        mz0.c r126 = com.bytedance.android.live.revenue.core.util.f.a(mz0.c.class);
        LogCommon r127 = LogCommon.LIVE_AD_LOG;
        com.bytedance.android.live.revenue.platform.log.impl.filterimpl.a r128 = r126.W2(r127);
        Object r40 = "null";
        if (r128 != null) goto L153;
        String r129 = "null";
    L155:
        if (TextUtils.isEmpty(r129) == true) goto L160;
        com.bytedance.android.live.revenue.platform.log.impl.filterimpl.a r130 = com.bytedance.android.live.revenue.core.util.f.a(mz0.c.class).W2(r127);
        if (r130 == null) goto L164;
        r40 = b("is_other_channel", r130);
    L164:
        r0.put("is_other_channel", r40);
        com.bytedance.android.live.revenue.platform.log.impl.filterimpl.a r131 = com.bytedance.android.live.revenue.core.util.f.a(mz0.c.class).W2(LogCommon.PAGE_SOURCE_LOG);
        if ((r131 instanceof mz0.f) == true) goto L167;
        r131 = null;
    L167:
        mz0.f r132 = (mz0.f) r131;
        if (r132 == null) goto L170;
        r0.put("homepage_hot_scene", r132.getCommonParams());
    L170:
        JSONObject r133 = new JSONObject();
        com.bytedance.android.live.revenue.platform.log.impl.filterimpl.a r134 = com.bytedance.android.live.revenue.core.util.f.a(mz0.c.class).W2(LogCommon.LIVE_SEARCH_LOG);
        if ((r134 instanceof mz0.g) == true) goto L173;
        r134 = null;
    L173:
        mz0.g r135 = (mz0.g) r134;
        if (r135 == null) goto L189;
        Map r136 = r135.a(r11);
        if (r136 == null) goto L189;
        String r137 = (String) r136.get("search_id");
        if (r137 == null) goto L180;
        r133.put("sid", r137);
    L180:
        String r138 = (String) r136.get("search_result_id");
        if (r138 == null) goto L183;
        r133.put("srid", r138);
    L183:
        String r139 = (String) r136.get("list_item_id");
        if (r139 == null) goto L186;
        r133.put("liid", r139);
    L186:
        String r140 = (String) r136.get("search_third_item_id");
        if (r140 == null) goto L189;
        r133.put("stiid", r140);
    L189:
        r0.put("live_enter_search_attr", r133);
        if (r14 == null) goto L196;
        b0 r141 = r14.i();
        if (r141 == null) goto L196;
        com.bytedance.android.livesdk.gift.platform.core.model.k r142 = r141.Q;
        if (r142 == null) goto L196;
        r2 = Integer.valueOf(r142.a);
    L196:
        if (r2 == null) goto L202;
        int r143 = r2.intValue() - 1;
        if (com.bytedance.android.livesdk.gift.platform.core.utils.t.b() == false) goto L200;
        int r144 = r143 / 4;
    L201:
        String r145 = com.bytedance.android.livesdk.gift.platform.core.utils.h.a;
        com.bytedance.android.livesdk.gift.platform.core.utils.h.k();
        r0.put("gift_row_location", r144 + 1);
        r0.put("gift_column_location", (r143 % 4) + 1);
        goto L202
    L200:
        r144 = (r143 % 8) / 4;
    L202:
        if (r14 == null) goto L211;
        b0 r146 = r14.i();
        if (r146 == null) goto L211;
        Map<String, String> r147 = r146.c0;
        if (r147 == null) goto L211;
        Iterator<Map.Entry<String, String>> r148 = r147.entrySet().iterator();
    L209:
        if (r148.hasNext() == false) goto L211;
        Map.Entry<String, String> r149 = r148.next();
        r0.put(r149.getKey(), r149.getValue());
    L211:
        LinkedHashMap r150 = new LinkedHashMap();
        com.bytedance.android.live.revenue.platform.log.impl.filterimpl.a r151 = com.bytedance.android.live.revenue.core.util.f.a(mz0.c.class).W2(LogCommon.ROOM);
        if (r151 == null) goto L214;
        r151.h(r150);
    L214:
        Object r152 = (String) r150.get("request_id");
        if (r152 == null) goto L217;
        r0.put("request_id", r152);
    L217:
        return r0;
    L160:
        com.bytedance.android.live.revenue.platform.log.impl.filterimpl.a r153 = com.bytedance.android.live.revenue.core.util.f.a(mz0.c.class).W2(LogCommon.PAGE_SOURCE_LOG);
        if (r153 == null) goto L164;
        r40 = b("is_other_channel", r153);
        goto L164
    L153:
        r129 = b("is_other_channel", r128);
        goto L155
    L118:
        if (r123.length() != 0) goto L120;
    L114:
        r37 = -1;
        goto L115
    L5:
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.b.a(r1) == true) goto L8;
        r1 = null;
    L8:
        if (r1 == null) goto L10;
        r0.put("multi_stream_log_pb", r1);
        goto L10
    }
}
