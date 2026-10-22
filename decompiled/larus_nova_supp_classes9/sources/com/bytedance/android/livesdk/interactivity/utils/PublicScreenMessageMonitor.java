package com.bytedance.android.livesdk.interactivity.utils;

import am2.x;
import android.text.TextUtils;
import com.bytedance.android.live.base.model.message.c4;
import com.bytedance.android.live.base.model.message.l4;
import com.bytedance.android.live.base.model.message.u3;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.livesdk.chatroom.viewmodule.IWidget;
import com.bytedance.android.livesdk.interactivity.api.entity.PSMessageHeatState;
import com.bytedance.android.livesdk.interactivity.publicscreen.widget.TextMessageWidget;
import com.bytedance.android.livesdk.interactivity.textmessage.utils.PSInteractionMsgClickUtil;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.message.model.h7;
import com.bytedance.android.livesdk.message.model.o7;
import com.bytedance.android.livesdk.message.model.va;
import com.bytedance.android.livesdk.utils.p6;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.message.IPublicAreaCommon;
import com.bytedance.android.livesdkapi.message.SuffixText;
import com.bytedance.bdlocation.BuildConfig;
import com.larus.apm.impl.protector.RunnableProtector;
import ec2.i1;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class PublicScreenMessageMonitor implements s42.c {
    public static final SimpleDateFormat a = null;
    public static String b;
    public static long c;
    public static long d;
    public static final Map<String, String> e = null;
    public static final ArrayList<c> f = null;
    public static final Map<String, Integer> g = null;
    public static final Lazy h = null;
    public static final Lazy i = null;
    public static final Lazy j = null;
    public static final Lazy k = null;
    public static final Lazy l = null;
    public static final Lazy m = null;
    public static final Lazy n = null;
    public static final Lazy o = null;
    public static final Lazy p = null;
    public static final Lazy q = null;
    public static boolean r;
    public static PSMessageHeatState s;
    public static final Lazy t = null;
    public static final Lazy u = null;
    public static final Lazy v = null;
    public static final long w = 0;
    public static final a x = null;
    public static final PublicScreenMessageMonitor y = null;

    public static final class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            SimpleDateFormat r0 = PublicScreenMessageMonitor.a;     // Catch: Throwable -> L4
            PublicScreenMessageMonitor.w();     // Catch: Throwable -> L4
            long r1 = System.currentTimeMillis() + PublicScreenMessageMonitor.d;     // Catch: Throwable -> L4
            String r2 = PublicScreenMessageMonitor.a.format(new Date(r1));     // Catch: Throwable -> L4
            Intrinsics.checkNotNullParameter(r2, "<set-?>");     // Catch: Throwable -> L4
            PublicScreenMessageMonitor.b = r2;     // Catch: Throwable -> L4
            PublicScreenMessageMonitor.c = r1;     // Catch: Throwable -> L4
            MainThreadPostUtils.c(this, PublicScreenMessageMonitor.v(r1));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public PublicScreenMessageMonitor() {
    }

    public static n u() {
        return (n) p.getValue();
    }

    @Override // s42.c
    public final void b(int r1) {
    }

    @Override // s42.c
    public final void c() {
    }

    @Override // s42.c
    public final void d(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r1) {
    }

    @Override // s42.c
    public final void e(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r1) {
    }

    @Override // s42.c
    public final void f(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r1) {
    }

    @Override // s42.c
    public final void h(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r1) {
    }

    @Override // s42.c
    public final void i() {
    }

    @Override // s42.c
    public final void k(tlc.d r1) {
    }

    @Override // s42.c
    public final void l(tlc.d r1) {
    }

    @Override // s42.c
    public final void p(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r1) {
    }

    @Override // s42.c
    public final void q(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r1) {
    }

    @Override // s42.c
    public final void r(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r1) {
    }

    @Override // s42.c
    public final void t(tlc.d r1) {
    }

    static {
        y = new PublicScreenMessageMonitor();
        a = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        b = BuildConfig.FLAVOR;
        e = new LinkedHashMap();
        f = new ArrayList();
        g = new HashMap();
        h = LazyKt.lazy(PublicScreenMessageMonitor$commentMessageInfo$2.INSTANCE);
        i = LazyKt.lazy(PublicScreenMessageMonitor$enterMessageInfo$2.INSTANCE);
        j = LazyKt.lazy(PublicScreenMessageMonitor$giftMessageInfo$2.INSTANCE);
        k = LazyKt.lazy(PublicScreenMessageMonitor$followMessageInfo$2.INSTANCE);
        l = LazyKt.lazy(PublicScreenMessageMonitor$likeMessageInfo$2.INSTANCE);
        m = LazyKt.lazy(PublicScreenMessageMonitor$shareMessageInfo$2.INSTANCE);
        n = LazyKt.lazy(PublicScreenMessageMonitor$highLevelMessageInfo$2.INSTANCE);
        o = LazyKt.lazy(PublicScreenMessageMonitor$shoppingMessageInfo$2.INSTANCE);
        p = LazyKt.lazy(PublicScreenMessageMonitor$publicScreenStrategyInfo$2.INSTANCE);
        q = LazyKt.lazy(PublicScreenMessageMonitor$messageActionAndPriorityInfo$2.INSTANCE);
        s = PSMessageHeatState.NORMAL;
        t = LazyKt.lazy(PublicScreenMessageMonitor$anchorColdStrategyMessageInfo$2.INSTANCE);
        u = LazyKt.lazy(PublicScreenMessageMonitor$chatAlignStreamInfo$2.INSTANCE);
        v = LazyKt.lazy(PublicScreenMessageMonitor$selectedMsgShowReporter$2.INSTANCE);
        w = ((Number) i1.a.getValue()).longValue() * 1000;
        x = new a();
    }

    public static void w() {
        Map<String, String> r0 = e;
        ((LinkedHashMap) r0).clear();
        long r1 = c;
        SimpleDateFormat r3 = a;
        b = r3.format(new Date(r1));
        long r2 = System.currentTimeMillis() + d;
        r0.put("summary_start_time", b);
        r0.put("summary_start_ts", String.valueOf(c));
        r0.put("summary_end_time", r3.format(new Date(r2)));
        r0.put("summary_end_ts", String.valueOf(r2));
        r0.put("high_priority_effect_cnt", String.valueOf(u().a));
        r0.put("low_priority_effect_cnt", String.valueOf(u().b));
        r0.put("both_priority_effect_cnt", String.valueOf(u().c));
        u().getClass();
        r0.put("message_hover_cnt", String.valueOf(0));
        if (r == false) goto L5;
        String r4 = "1";
    L6:
        r0.put("is_anchor", r4);
        r0.put("room_hot_level", String.valueOf(s.getValue()));
        Iterator r5 = ((HashMap) g).entrySet().iterator();
    L8:
        if (r5.hasNext() == false) goto L10;
        Map.Entry r6 = (Map.Entry) r5.next();
        e.put((String) r6.getKey(), String.valueOf(((Number) r6.getValue()).intValue()));
        goto L8
    L10:
        ((HashMap) g).clear();
        Iterator<c> r7 = f.iterator();
    L12:
        if (r7.hasNext() == false) goto L14;
        c r8 = r7.next();
        r8.b(e);
        r8.e();
        goto L12
    L14:
        n r9 = u();
        r9.a = 0;
        r9.b = 0;
        r9.c = 0;
        j0.l().sendLog("livesdk_screen_message_show_summary", e, new Object[]{IRoom.class, x.class});
        t r10 = (t) v.getValue();
        if (r10.d == false) goto L17;
    L19:
        Map r11 = MapsKt.mapOf(new Pair[]{TuplesKt.to("diamond_message_number", String.valueOf(r10.a)), TuplesKt.to("comment_number", String.valueOf(r10.b)), TuplesKt.to("barrage_number", String.valueOf(r10.c))});
        j0.l().sendLog("livesdk_selected_message_show", r11, new Object[]{IRoom.class});
        r10.a = 0;
        r10.b = 0;
        r10.c = 0;
        return;
    L17:
        if (((r10.a + r10.b) + r10.c) != 0) goto L19;
        return;
    L5:
        r4 = "0";
        goto L6
    }

    public static long v(long r3) {
        Calendar r0 = Calendar.getInstance();
        r0.setTimeInMillis(r3);
        int r4 = r0.get(12);
        int r5 = r0.get(13);
        long r6 = (((long) ((r4 * 60) + r5)) * 1000) + ((long) r0.get(14));
        long r1 = w;
        return r1 - (r6 % r1);
    }

    @Override // s42.c
    public final void g(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r2) {
        if (r2 == null) goto L5;
        r2.v = true;
        return;
    }

    @Override // s42.c
    public final void m(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r23) {
        if (r23 != null) goto L5;
        return;
    L5:
        if (((HashMap) r23.n).containsKey("show_tag_for_public_screen_track_stat") == false) goto L7;
        return;
    L7:
        Map<String, String> r1 = r23.n;
        if (r1 == null) goto L10;
        ((HashMap) r1).put("show_tag_for_public_screen_track_stat", "has_show");
    L10:
        IPublicAreaCommon r2 = r23.v();
        if (r2 == null) goto L15;
        Map r3 = r2.getTrackingParams();
        if (r3 == null) goto L15;
        String r4 = (String) r3.get("pv_show_stat_key");
    L17:
        if (r4 != null) goto L19;
    L22:
        boolean r5 = true;
    L23:
        if (r5 == true) goto L35;
        String[] r6 = TextUtils.split(r4, ",");
        int r7 = r6.length;
        int r8 = 0;
    L25:
        if (r8 >= r7) goto L35;
        String r9 = r6[r8];
        if (r9 == null) goto L34;
        HashMap r10 = (HashMap) g;
        Integer r11 = (Integer) r10.get(r9);
        if (r11 == null) goto L32;
        int r13 = r11.intValue();
    L33:
        r10.put(r9, Integer.valueOf(r13 + 1));
        goto L34
    L32:
        r13 = 0;
    L34:
        r8 = r8 + 1;
    L35:
        boolean r14 = r;
        String r15 = BuildConfig.FLAVOR;
        String r16 = "1";
        if (r14 == false) goto L100;
        u3 r17 = r23.b;
        if ((r17 instanceof u3) == true) goto L40;
        r17 = null;
    L40:
        u3 r18 = r17;
        if (r18 == null) goto L71;
        IPublicAreaCommon r19 = r18.getOrInitPublicAreaCommon();
        if (r19 == null) goto L71;
        SuffixText r110 = r19.getSuffixText();
        if (r110 == null) goto L71;
        if (r110.getBizType() != 300) goto L49;
        boolean r111 = true;
    L50:
        HashMap r20 = new HashMap();
        if (r111 == false) goto L53;
        Object r112 = "1";
    L54:
        r20.put("is_mark", r112);
        T r113 = r23.b;
        if (r113 == 0) goto L58;
        String r114 = r113.getMessageMethod();
        if (r114 == null) goto L58;
    L59:
        r20.put("message_type", r114);
        r20.put("user_id", r23.y());
        Map r21 = r19.getTrackingParams();
        if (r21 == null) goto L62;
        r20.putAll(r21);
    L62:
        c4 r24 = r23.b;
        if ((r24 instanceof c4) == true) goto L65;
        r24 = null;
    L65:
        c4 r25 = r24;
        if (r25 == null) goto L70;
        String r26 = r25.getBizScene();
        if (r26 == null) goto L70;
        r20.put("biz_scene", r26);
    L70:
        j0.l().sendLog("livesdk_anchor_tag_priority_display_user_message_show", r20, new Object[]{IRoom.class, x.class});
    L58:
        r114 = BuildConfig.FLAVOR;
        goto L59
    L53:
        r112 = "0";
        goto L54
    L49:
        r111 = false;
    L71:
        u3 r27 = r23.b;
        if ((r27 instanceof u3) == true) goto L74;
        r27 = null;
    L74:
        u3 r28 = r27;
        if (r28 == null) goto L100;
        IPublicAreaCommon r29 = r28.getOrInitPublicAreaCommon();
        if (r29 == null) goto L100;
        if (r29.getWithUserFeatureLabel() == true) goto L82;
        r29 = null;
    L82:
        if (r29 == null) goto L100;
        HashMap r30 = new HashMap();
        T r31 = r23.b;
        if (r31 == 0) goto L87;
        String r33 = r31.getMessageMethod();
        if (r33 == null) goto L87;
    L88:
        r30.put("message_type", r33);
        Map r34 = r29.getTrackingParams();
        if (r34 == null) goto L91;
        r30.putAll(r34);
    L91:
        c4 r35 = r23.b;
        if ((r35 instanceof c4) == true) goto L94;
        r35 = null;
    L94:
        c4 r36 = r35;
        if (r36 == null) goto L99;
        String r37 = r36.getBizScene();
        if (r37 == null) goto L99;
        r30.put("biz_scene", r37);
    L99:
        j0.l().sendLog("livesdk_public_screen_msg_feature_tag_show", r30, new Object[]{IRoom.class, x.class});
    L87:
        r33 = BuildConfig.FLAVOR;
    L100:
        u3 r38 = r23.b;
        if ((r38 instanceof u3) == true) goto L103;
        r38 = null;
    L103:
        u3 r39 = r38;
        if (r39 == null) goto L122;
        IPublicAreaCommon r40 = r39.getOrInitPublicAreaCommon();
        if (r40 == null) goto L122;
        if (r40.getShouldLogLightInteractMob() == false) goto L122;
        LinkedHashMap r41 = new LinkedHashMap();
        T r43 = r23.b;
        if (r43 == 0) goto L113;
        String r44 = String.valueOf(r43.getMessageId());
        if (r44 == null) goto L113;
    L114:
        r41.put("msg_id", r44);
        if (r == false) goto L117;
        Object r45 = "1";
    L118:
        r41.put("is_anchor", r45);
        Map r46 = r40.getLightInteractMobParams();
        if (r46 == null) goto L121;
        r41.putAll(r46);
    L121:
        j0.l().sendLog("livesdk_public_screen_light_interaction_show", r41, new Object[]{IRoom.class, x.class});
        goto L122
    L117:
        r45 = "0";
    L113:
        r44 = BuildConfig.FLAVOR;
    L122:
        T r47 = r23.b;
        if (r47 == 0) goto L125;
        String r48 = r47.getMessageMethod();
    L127:
        if (r48 != null) goto L130;
    L230:
        u3 r49 = r23.b;
        if ((r49 instanceof u3) == true) goto L233;
        r49 = null;
    L233:
        u3 r50 = r49;
        if (r50 == null) goto L263;
        IPublicAreaCommon r51 = r50.getOrInitPublicAreaCommon();
        if (r51 == null) goto L263;
        if (r51.isLikeComment() == false) goto L240;
        IPublicAreaCommon r53 = r51;
    L241:
        if (r53 == null) goto L263;
        Map r54 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("msg_show_type", "public_screen_highly_like")});
        SuffixText r55 = r53.getSuffixText();
        if (r55 != null) goto L245;
    L252:
        T r56 = r23.b;
        if (r56 == 0) goto L258;
        String r57 = r56.getMessageMethod();
        if (r57 == null) goto L258;
        r15 = r57;
    L258:
        r54.put("message_type", r15);
        r54.put("user_id", r23.y());
        Map r58 = r53.getTrackingParams();
        if (r58 == null) goto L261;
        r54.putAll(r58);
    L261:
        j0.l().sendLog("livesdk_public_screen_high_priority_message_show", r54, new Object[]{x.class, IRoom.class});
        goto L263
    L245:
        if (r55.getBizType() != 300) goto L247;
        boolean r59 = true;
    L248:
        if (r59 == true) goto L251;
        r16 = "0";
    L251:
        r54.put("is_mark", r16);
        goto L252
    L247:
        r59 = false;
        goto L248
    L240:
        r53 = null;
    L263:
        p r60 = (p) q.getValue();
        r60.getClass();
        int r61 = o.a[r23.A.ordinal()];
        int r63 = 1;
        if (r61 == 1) goto L288;
        if (r61 == 2) goto L287;
        if (r61 == 3) goto L268;
        r63 = 1;
    L289:
        int r0 = o.b[r23.z.ordinal()];
        if (r0 == r63) goto L296;
        if (r0 == 2) goto L295;
        if (r0 != 3) goto L304;
        r60.r += r63;
        return;
    L304:
        return;
    L295:
        r60.s += r63;
        return;
    L296:
        r60.q += r63;
        return;
    L268:
        c4 r64 = r23.b;
        if ((r64 instanceof o7) == false) goto L271;
    L286:
        r63 = 1;
        r60.v++;
        goto L289
    L271:
        if ((r64 instanceof kc2.b) == true) goto L286;
        boolean r65 = r64 instanceof c4;
        if (r65 == true) goto L275;
    L277:
        int r66 = com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.r.a;
        if (r65 == true) goto L280;
    L282:
        boolean r67 = false;
    L283:
        if (r67 == false) goto L285;
        r63 = 1;
        r60.w++;
        goto L289
    L285:
        r63 = 1;
        r60.x++;
        goto L289
    L280:
        if (Intrinsics.areEqual(r64.getBizScene(), "ecom_order_msg") == false) goto L282;
        r67 = true;
        goto L283
    L275:
        if (r64.isGiftTypeMessage() == false) goto L277;
    L287:
        r63 = 1;
        r60.u++;
        goto L289
    L288:
        r60.t++;
        goto L289
    L130:
        switch(r48.hashCode()) {
            case -1988298150: goto L210;
            case -1975915993: goto L186;
            case -1441604104: goto L183;
            case -1367943111: goto L180;
            case -1317144130: goto L170;
            case -778540718: goto L142;
            case 41447196: goto L139;
            case 324745274: goto L136;
            case 799725124: goto L133;
            default: goto L230;
        };
    L133:
        if (r48.equals("WebcastGiftMessage") == false) goto L230;
        ((l) j.getValue()).a(r23);
        goto L230
    L136:
        if (r48.equals("WebcastLinkMessage") == false) goto L230;
        ((q) l.getValue()).a(r23);
        goto L230
    L139:
        if (r48.equals("WebcastChatMessage") == false) goto L230;
        ((h) h.getValue()).a(r23);
        goto L230
    L142:
        if (r48.equals("WebcastTopAggregateChatMessage") == false) goto L230;
        Map r68 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("is_interaction_available", "1")});
        u3 r69 = r23.b;
        if ((r69 instanceof u3) == true) goto L146;
        r69 = null;
    L146:
        u3 r70 = r69;
        if (r70 == null) goto L230;
        IPublicAreaCommon r71 = r70.getOrInitPublicAreaCommon();
        if (r71 == null) goto L230;
        SuffixText r73 = r71.getSuffixText();
        if (r73 != null) goto L153;
    L160:
        T r74 = r23.b;
        if (r74 == 0) goto L164;
        String r75 = r74.getMessageMethod();
        if (r75 == null) goto L164;
    L165:
        r68.put("message_type", r75);
        r68.put("user_id", r23.y());
        Map r76 = r71.getTrackingParams();
        if (r76 == null) goto L168;
        r68.putAll(r76);
    L168:
        j0.l().sendLog("livesdk_screen_system_msg_show", r68, new Object[]{x.class, IRoom.class});
    L164:
        r75 = BuildConfig.FLAVOR;
        goto L165
    L153:
        if (r73.getBizType() != 300) goto L155;
        boolean r77 = true;
    L156:
        if (r77 == false) goto L158;
        Object r78 = "1";
    L159:
        r68.put("is_mark", r78);
        goto L160
    L158:
        r78 = "0";
        goto L159
    L155:
        r77 = false;
        goto L156
    L170:
        if (r48.equals("WebcastFansclubMessage") == false) goto L230;
        if (((Boolean) PSInteractionMsgClickUtil.c.getValue()).booleanValue() == false) goto L230;
        h7 r79 = r23.b;
        if ((r79 instanceof h7) == true) goto L177;
        r79 = null;
    L177:
        if (PSInteractionMsgClickUtil.b(r79) == false) goto L230;
        PSInteractionMsgClickUtil.g("fansclub", r);
        goto L230
    L180:
        if (r48.equals("WebcastRoomMessage") == false) goto L230;
        ((l) j.getValue()).a(r23);
        goto L230
    L183:
        if (r48.equals("GiftGroupMessage") == false) goto L230;
        ((l) j.getValue()).a(r23);
        goto L230
    L186:
        if (r48.equals("WebcastSocialMessage") == false) goto L230;
        l4 r80 = r23.b;
        if ((r80 instanceof l4) == true) goto L190;
        r80 = null;
    L190:
        l4 r81 = r80;
        if (r81 != null) goto L193;
    L195:
        if (r81 != null) goto L197;
    L199:
        Lazy r83 = PSInteractionMsgClickUtil.c;
        if (((Boolean) r83.getValue()).booleanValue() == false) goto L205;
        if (PSInteractionMsgClickUtil.a(r81) == false) goto L205;
        PSInteractionMsgClickUtil.g("follow", r);
    L205:
        if (((Boolean) r83.getValue()).booleanValue() == false) goto L230;
        if (PSInteractionMsgClickUtil.d(r81) == false) goto L230;
        PSInteractionMsgClickUtil.g("share", r);
        goto L230
    L197:
        if (r81.getAction() != 3) goto L199;
        ((q) m.getValue()).a(r23);
        goto L199
    L193:
        if (r81.getAction() != 1) goto L195;
        ((q) k.getValue()).a(r23);
        goto L199
    L210:
        if (r48.equals("WebcastMemberMessage") == false) goto L230;
        va r84 = r23.b;
        if ((r84 instanceof va) == true) goto L214;
        r84 = null;
    L214:
        va r85 = r84;
        if (r85 == null) goto L229;
        Map r86 = r85.getBuriedPoint();
        if (r86 != null) goto L219;
    L222:
        boolean r87 = true;
    L223:
        if (r87 == true) goto L229;
        HashMap r88 = new HashMap();
        r88.putAll(r86);
        if (r == false) goto L227;
        Object r89 = "1";
    L228:
        r88.put("is_anchor", r89);
        r88.put("show_time", String.valueOf(p6.b()));
        j0.l().sendLog("livesdk_anchor_enterroom_show", r88, new Object[]{new x(), IRoom.class});
        goto L229
    L227:
        r89 = "0";
        goto L228
    L219:
        if (r86.isEmpty() == true) goto L222;
        r87 = false;
    L229:
        ((k) i.getValue()).a(r23);
        goto L230
    L125:
        r48 = null;
        goto L127
    L19:
        if (r4.length() == 0) goto L22;
        r5 = false;
    L15:
        r4 = null;
        goto L17
    }

    @Override // s42.c
    public final void n(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.b.isInsert() == false) goto L6;
        r10.o = 0L;
        r10.p = Long.valueOf(System.currentTimeMillis() - r10.b.getReceiveTime());
    L7:
        ((com.bytedance.android.livesdk.interactivity.utils.a) t.getValue()).a(r10);
        return;
    L6:
        long r3 = r10.b.getReceiveTime() + com.bytedance.android.livesdk.utils.ntp.a.a;
        long r5 = System.currentTimeMillis() + com.bytedance.android.livesdk.utils.ntp.a.a;
        r10.o = Long.valueOf(RangesKt.coerceAtLeast(r3 - r10.b.getTimestamp(), 0));
        r10.p = Long.valueOf(RangesKt.coerceAtLeast(r5 - r3, 0));
        goto L7
    }

    @Override // s42.c
    public final void o(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r10) {
        if (r10.b.isInsert() == false) goto L5;
        r10.o = 0L;
        r10.p = Long.valueOf(System.currentTimeMillis() - r10.b.getReceiveTime());
        return;
    L5:
        long r3 = r10.b.getReceiveTime() + com.bytedance.android.livesdk.utils.ntp.a.a;
        long r5 = System.currentTimeMillis() + com.bytedance.android.livesdk.utils.ntp.a.a;
        r10.o = Long.valueOf(RangesKt.coerceAtLeast(r3 - r10.b.getTimestamp(), 0));
        r10.p = Long.valueOf(RangesKt.coerceAtLeast(r5 - r3, 0));
    }

    @Override // s42.c
    public final void j(IWidget r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "widget");
        Intrinsics.checkNotNullParameter(r3, "cause");
        s42.c.a.b(r2, r3);
    }

    @Override // s42.c
    public final void s(IWidget r2, IRoom r3, s42.c.b r4) {
        Intrinsics.checkNotNullParameter(r2, "widget");
        Intrinsics.checkNotNullParameter(r3, "room");
        Intrinsics.checkNotNullParameter(r2, "widget");
        Intrinsics.checkNotNullParameter(r3, "room");
        MainThreadPostUtils.d(x);
        w();
        ((LinkedHashMap) e).clear();
        Iterator<c> r5 = f.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        r5.next().d();
        goto L4
    L6:
        f.clear();
    }

    @Override // s42.c
    public final void a(TextMessageWidget r1, IRoom r2, boolean r3, boolean r4, com.bytedance.android.livesdk.interactivity.api.publicscreen.api.m r5) {
        Intrinsics.checkNotNullParameter(r1, "widget");
        Intrinsics.checkNotNullParameter(r2, "room");
        Intrinsics.checkNotNullParameter(r5, "publicScreenData");
        s42.c.a.a(r1, r2, r5);
        r = r3;
        Lazy r6 = t;
        ((com.bytedance.android.livesdk.interactivity.utils.a) r6.getValue()).r = r3;
        ((com.bytedance.android.livesdk.interactivity.utils.a) r6.getValue()).s = r2;
        ((com.bytedance.android.livesdk.interactivity.utils.a) r6.getValue()).t = r5;
        f.addAll(CollectionsKt.listOf(new c[]{(h) h.getValue(), (k) i.getValue(), (l) j.getValue(), (q) k.getValue(), (q) l.getValue(), (q) m.getValue(), (m) n.getValue(), (w) o.getValue(), (com.bytedance.android.livesdk.interactivity.utils.a) r6.getValue(), (p) q.getValue(), (g) u.getValue()}));
        d = com.bytedance.android.livesdk.utils.ntp.a.a;
        long r7 = System.currentTimeMillis() + d;
        b = a.format(new Date(r7));
        c = r7;
        long r8 = v(r7);
        a r9 = x;
        MainThreadPostUtils.d(r9);
        MainThreadPostUtils.c(r9, r8);
    }
}
