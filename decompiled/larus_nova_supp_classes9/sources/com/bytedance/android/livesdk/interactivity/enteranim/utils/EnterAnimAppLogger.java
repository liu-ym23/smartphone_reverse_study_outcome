package com.bytedance.android.livesdk.interactivity.enteranim.utils;

import am2.x;
import android.text.TextUtils;
import com.bytedance.android.live.base.model.message.g4;
import com.bytedance.android.live.base.model.message.h3;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.utils.h1;
import com.bytedance.android.live.core.utils.i1;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.gift.model.CardLockInfo;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.RevenueUtils;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.message.model.pg;
import com.bytedance.android.livesdk.message.model.va;
import com.bytedance.android.livesdk.utils.p6;
import com.bytedance.android.livesdk.utils.t;
import com.bytedance.android.livesdkapi.depend.model.live.ILiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.live.datacontext.m;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class EnterAnimAppLogger extends com.bytedance.android.livesdk.interactivity.common.utils.b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final HashMap<String, String> c(k32.a r5) {
        IRoomContextService r0 = jc1.k.f(IRoomContextService.class);
        if (r0 == null) goto L9;
        o r1 = IRoomContextService.a.a(r0, null, 0, 3);
        if (r1 == null) goto L9;
        Boolean r2 = r1.isAnchor();
        if (r2 == null) goto L9;
        boolean r3 = r2.booleanValue();
    L10:
        HashMap<String, String> r4 = new HashMap();
        if (r3 == false) goto L13;
        String r6 = "1";
    L14:
        r4.put("is_anchor", r6);
        if ((r5 instanceof k32.d) == false) goto L44;
        k32.d r7 = (k32.d) r5;
        h3 r8 = r7.t;
        String r9 = "unknown_notifyMessage";
        if (r8 == null) goto L22;
        pg.c r10 = r8.M();
        if (r10 == null) goto L22;
        String r11 = r10.e();
        if (r11 == null) goto L22;
    L23:
        r4.put("message_type", r11);
        h3 r13 = r7.t;
        if (r13 == null) goto L31;
        pg.c r14 = r13.M();
        if (r14 == null) goto L31;
        String r15 = r14.getScene();
        if (r15 == null) goto L31;
        r9 = r15;
    L31:
        r4.put("scene", r9);
        h3 r16 = r7.t;
        if (r16 == null) goto L37;
        Map r17 = r16.getBuriedPoint();
        if (r17 == null) goto L37;
        String r18 = (String) r17.get("duration");
        if (r18 == null) goto L37;
    L38:
        r4.put("duration", r18);
        h3 r19 = r7.t;
        if (r19 == null) goto L61;
        Map<? extends String, ? extends String> r20 = r19.getBuriedPoint();
        if (r20 == null) goto L61;
        r4.putAll(r20);
    L61:
        return r4;
    L37:
        r18 = CardLockInfo.sUNKNOWN;
    L22:
        r11 = "unknown_notifyMessage";
        goto L23
    L44:
        if ((r5 instanceof k32.b) == false) goto L47;
        r4.put("scene", "ecom_barrage_buy");
        goto L61
    L47:
        if ((r5 instanceof y72.a) == false) goto L50;
        r4.put("scene", "game_download");
        goto L61
    L50:
        if ((r5 instanceof k32.c) == false) goto L52;
        r4.put("scene", "effect");
        goto L61
    L52:
        va.a r21 = r5.k;
        if (r21 != null) goto L55;
        return r4;
    L55:
        r4.put("scene", "member");
        if (d(r21, r5) == false) goto L58;
        r4.put("scene", "prize_notice");
    L58:
        Map<String, String> r23 = r5.s;
        if (r23 == null) goto L61;
        r4.putAll(r23);
        goto L61
    L13:
        r6 = "0";
    L9:
        r3 = false;
        goto L10
    }

    @Deprecated(message = "后续用通用埋点上报了, 参考本类中的通用埋点方法 sendhightlevelShowLog")
    @JvmStatic
    public static final void f(h3 r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        pg.c r0 = r10.M();
        ILiveMode r1 = null;
        if (r0 == null) goto L7;
        String r2 = r0.getScene();
    L8:
        boolean r3 = true;
        if (TextUtils.equals(r2, "traffic_strategy") == true) goto L90;
        pg.c r4 = r10.M();
        if (r4 == null) goto L13;
        String r5 = r4.getScene();
    L15:
        if (TextUtils.equals(r5, "valuable_newuser_strategy") == true) goto L90;
        pg.c r6 = r10.M();
        if (r6 == null) goto L20;
        String r7 = r6.getScene();
    L22:
        if (TextUtils.equals(r7, "sell_well") == false) goto L24;
        HashMap r8 = new HashMap();
        r8.put("ecom_group_type", "live");
        r8.put("EVENT_ORIGIN_FEATURE", "TEMAI");
        i("livesdk_hot_sale_comment_show", r8, r10.getBuriedPoint());
        return;
    L24:
        g4.e0.getClass();
        List r9 = g4.a.a;
        pg.c r11 = r10.M();
        if (r11 == null) goto L27;
        String r13 = r11.getScene();
    L29:
        if (CollectionsKt.contains(r9, r13) == false) goto L44;
        HashMap r14 = new HashMap();
        r14.put("ecom_group_type", "live");
        r14.put("EVENT_ORIGIN_FEATURE", "TEMAI");
        i("livesdk_video_product_comment_show", r14, r10.getBuriedPoint());
        ILiveMode r15 = r10.getBuriedPoint();
        if (r15 != null) goto L33;
        return;
    L33:
        if (r15.containsKey("ab_group") == true) goto L35;
    L39:
        r3 = false;
    L40:
        if (r3 == false) goto L42;
        r1 = r15;
    L42:
        if (r1 == null) goto L121;
        r14.put("ecom_entrance_form", "video_product_comment");
        i("livesdk_show_product", r14, r10.getBuriedPoint());
        return;
    L121:
        return;
    L35:
        if (TextUtils.equals((CharSequence) r15.get("ab_group"), "ab2") == true) goto L40;
        if (TextUtils.equals((CharSequence) r15.get("ab_group"), "ab4") == false) goto L39;
    L44:
        List r16 = g4.a.b;
        pg.c r17 = r10.M();
        if (r17 == null) goto L47;
        String r18 = r17.getScene();
    L49:
        if (CollectionsKt.contains(r16, r18) == false) goto L123;
        IRoomContextService r19 = jc1.k.f(IRoomContextService.class);
        if (r19 == null) goto L53;
        o r20 = IRoomContextService.a.a(r19, null, 0, 3);
    L54:
        Map r21 = r10.getBuriedPoint();
        if (r21 != null) goto L57;
    L60:
        boolean r23 = true;
    L61:
        if (r23 == false) goto L63;
        return;
    L63:
        if (r20 == null) goto L67;
        m r24 = r20.getRoom();
        if (r24 == null) goto L67;
        IRoom r25 = (IRoom) r24.getValue();
    L68:
        IMiddlewareUserService r26 = jc1.k.f(IMiddlewareUserService.class);
        String r27 = BuildConfig.FLAVOR;
        if (r26 == null) goto L74;
        com.bytedance.android.livesdk.user.e r28 = r26.user();
        if (r28 == null) goto L74;
        String r29 = r28.n();
        if (r29 == null) goto L74;
    L75:
        Pair[] r30 = new Pair[4];
        if (r25 == null) goto L79;
        String r31 = String.valueOf(r25.getRoomId());
        if (r31 == null) goto L79;
    L80:
        r30[0] = TuplesKt.to("room_id", r31);
        if (r25 == null) goto L86;
        String r33 = r25.getAnchorId();
        if (r33 == null) goto L86;
        r27 = r33;
    L86:
        r30[1] = TuplesKt.to("anchor_id", r27);
        r30[2] = TuplesKt.to("user_id", r29);
        if (r25 == null) goto L89;
        r1 = r25.getStreamType();
    L89:
        int r34 = h1.a;
        r30[3] = TuplesKt.to("live_type", i1.a(r1));
        i("livesdk_game_promote_user_book_message_show", MapsKt.mapOf(r30), r10.getBuriedPoint());
        return;
    L79:
        r31 = BuildConfig.FLAVOR;
    L74:
        r29 = BuildConfig.FLAVOR;
    L67:
        r25 = null;
        goto L68
    L57:
        if (r21.isEmpty() == true) goto L60;
        r23 = false;
        goto L61
    L53:
        r20 = null;
        goto L54
    L123:
        return;
    L47:
        r18 = null;
        goto L49
    L27:
        r13 = null;
        goto L29
    L20:
        r7 = null;
        goto L22
    L13:
        r5 = null;
    L90:
        HashMap r35 = new HashMap();
        pg.c r36 = r10.M();
        String r37 = CardLockInfo.sUNKNOWN;
        if (r36 == null) goto L94;
        String r38 = r36.e();
        if (r38 == null) goto L94;
    L95:
        r35.put("message_type", r38);
        r35.put("show_time", String.valueOf(p6.b()));
        pg.c r39 = r10.M();
        if (r39 == null) goto L99;
        String r40 = r39.getScene();
        if (r40 == null) goto L99;
    L100:
        r35.put("scene", r40);
        Map r41 = r10.getBuriedPoint();
        if (r41 == null) goto L106;
        String r43 = (String) r41.get("duration");
        if (r43 == null) goto L106;
        r37 = r43;
    L106:
        r35.put("duration", r37);
        i("livesdk_anchor_room_content_opt_msg_show", r35, r10.getBuriedPoint());
        ILiveMode r44 = r10.getBuriedPoint();
        if (r44 != null) goto L109;
        return;
    L109:
        if (r44.containsKey("message_type") == true) goto L111;
    L113:
        boolean r45 = false;
    L114:
        if (r45 == false) goto L116;
        r1 = r44;
    L116:
        if (r1 == null) goto L126;
        i("livesdk_anchor_special_message_show", MapsKt.hashMapOf(new Pair[]{TuplesKt.to("event_page", "live_take_detail")}), r10.getBuriedPoint());
        return;
    L126:
        return;
    L111:
        if (r44.containsKey("flow_cnt") == false) goto L113;
        r45 = true;
    L99:
        r40 = CardLockInfo.sUNKNOWN;
    L94:
        r38 = CardLockInfo.sUNKNOWN;
        goto L95
    L7:
        r2 = null;
        goto L8
    }

    @JvmStatic
    public static final void j(k32.a r3) {
        Intrinsics.checkNotNullParameter(r3, "message");
        HashMap<String, String> r0 = c(r3);
        r0.put("click_time", String.valueOf(p6.b()));
        if ((r3 instanceof k32.d) == false) goto L9;
        h3 r4 = ((k32.d) r3).t;
        if (r4 == null) goto L9;
        Map<? extends String, ? extends String> r5 = r4.getBuriedPoint();
        if (r5 == null) goto L9;
        r0.putAll(r5);
    L9:
        i("livesdk_high_level_common_message_click", r0, null);
    }

    @JvmStatic
    public static final boolean d(va.a r4, k32.a r5) {
        Intrinsics.checkNotNullParameter(r4, "effectConfig");
        Intrinsics.checkNotNullParameter(r5, "message");
        com.bytedance.android.live.core.resources.e r0 = null;
        t.b r6 = r5.l;     // Catch: Exception -> L18
        if (r6 != null) goto L6;
    L8:
        long r7 = r4.a();     // Catch: Exception -> L18
        boolean r2 = com.bytedance.android.live.revenue.core.util.h.a;     // Catch: Exception -> L18
        IAssetsManager r3 = com.bytedance.android.live.revenue.core.util.h.d(ca0.j.class).getAssetsManager();     // Catch: Exception -> L18
        if (r3 != null) goto L11;
        return false;
    L11:
        RevenueUtils.i.getClass();     // Catch: Exception -> L18
        Intrinsics.checkNotNullParameter(r3, "mgr");     // Catch: Exception -> L18
        com.bytedance.android.live.core.resources.e r8 = r3.G1(r7);     // Catch: Exception -> L18
        if (r8 == null) goto L20;
        if (r8.getResourceType() != 4) goto L20;
        r0 = r8;
    L20:
        if (r0 != null) goto L22;
        return false;
    L22:
        return true;
    L6:
        if (((t.a) r6).a == null) goto L8;
        return false;
    L18:
        e = move-exception;
        SafetyGuard.a(null, e, null);
        return false;
    }

    @JvmStatic
    public static final void e(h3 r2, final long r3) {
        if (r2 != null) goto L4;
        return;
    L4:
        pg.c r0 = r2.M();
        if (r0 == null) goto L7;
        String r1 = r0.getScene();
    L9:
        if (TextUtils.equals(r1, "sell_well") == false) goto L12;
        final Map r4 = r2.getBuriedPoint();
        com.bytedance.android.livesdk.interactivity.common.utils.b.a("livesdk_hot_sale_comment_duration", new EnterAnimAppLogger$sendSellWellDismissEvent$1(r3, r4));
        return;
    L12:
        return;
    L7:
        r1 = null;
        goto L9
    }

    @JvmStatic
    public static final void g(int r8, k32.a r9, int r10) {
        if (r9 != null) goto L4;
        return;
    L4:
        LinkedHashMap r0 = new LinkedHashMap();
        va.a r1 = r9.k;
        if (r1 != null) goto L7;
        r0.put("effect_id", String.valueOf(r9.i));
        r0.put("effect_source", "honor_level");
    L10:
        IRoomContextService r2 = jc1.k.f(IRoomContextService.class);
        String r3 = null;
        if (r2 == null) goto L32;
        o r4 = IRoomContextService.a.a(r2, null, 0, 3);
        if (r4 == null) goto L32;
        m r5 = r4.getRoom();
        if (r5 == null) goto L32;
        IRoom r6 = (IRoom) r5.getValue();
        if (r6 == null) goto L32;
        r0.put("room_id", String.valueOf(r6.getRoomId()));
        String r7 = r6.getAnchorId();
        String r11 = BuildConfig.FLAVOR;
        if (r7 != null) goto L21;
        r7 = BuildConfig.FLAVOR;
    L21:
        r0.put("anchor_id", r7);
        String r13 = r6.getRequestId();
        if (r13 != null) goto L24;
    L27:
        boolean r14 = true;
    L28:
        if (r14 == true) goto L31;
        r11 = r6.getRequestId();
    L31:
        r0.put("request_id", r11);
        goto L32
    L24:
        if (r13.length() == 0) goto L27;
        r14 = false;
    L32:
        String r15 = r9.a;
        if (r15 != null) goto L35;
    L47:
        boolean r16 = false;
    L49:
        if (r8 != 1) goto L53;
        if (r16 == false) goto L52;
        String r17 = "livesdk_enter_effect_show";
    L62:
        j0.l().sendLog(r17, r0, new Object[]{x.class, IRoom.class});
        return;
    L52:
        r0.put("order", String.valueOf(r10));
        r17 = "livesdk_enter_effect_show_others";
        goto L62
    L53:
        String r18 = "0";
        if (r16 == false) goto L56;
        String r19 = "1";
    L57:
        r0.put("is_self", r19);
        if (r16 == true) goto L61;
        r18 = String.valueOf(r10);
    L61:
        r0.put("order", r18);
        r17 = "livesdk_enter_effect_click";
        goto L62
    L56:
        r19 = "0";
        goto L57
    L35:
        if (r15.length() <= 0) goto L37;
        boolean r20 = true;
    L38:
        if (r20 != true) goto L47;
        String r21 = r9.a;
        IMiddlewareUserService r23 = jc1.k.f(IMiddlewareUserService.class);
        if (r23 == null) goto L45;
        com.bytedance.android.livesdk.user.e r24 = r23.user();
        if (r24 == null) goto L45;
        r3 = r24.n();
    L45:
        if (Intrinsics.areEqual(r21, r3) == false) goto L47;
        r16 = true;
        goto L49
    L37:
        r20 = false;
        goto L38
    L7:
        Map r25 = r1.getExtra();
        if (r25 == null) goto L10;
        r0.putAll(r25);
        goto L10
    }

    @JvmStatic
    public static final void h(String r1, final Map<String, String> r2, final Map<String, String> r3) {
        com.bytedance.android.livesdk.interactivity.common.utils.b.a(r1, new EnterAnimAppLogger$sendGeneralClickEvent$1(r2, r3));
    }

    @JvmStatic
    public static final void i(String r1, final Map<String, String> r2, final Map<String, String> r3) {
        com.bytedance.android.livesdk.interactivity.common.utils.b.a(r1, new EnterAnimAppLogger$sendGeneralShowEvent$1(r2, r3));
    }
}
