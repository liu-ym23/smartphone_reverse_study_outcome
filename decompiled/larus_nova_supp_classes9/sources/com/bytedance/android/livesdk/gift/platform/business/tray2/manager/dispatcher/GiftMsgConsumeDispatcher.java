package com.bytedance.android.livesdk.gift.platform.business.tray2.manager.dispatcher;

import android.os.Message;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.i0;
import com.bytedance.android.livesdk.gift.model.ExtraEffectDisplayFrom;
import com.bytedance.android.livesdk.gift.model.h2;
import com.bytedance.android.livesdk.gift.model.j3;
import com.bytedance.android.livesdk.gift.model.w;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.gift.platform.business.normal.model.NormalGiftMessage;
import com.bytedance.android.livesdk.gift.platform.business.tray2.manager.f;
import com.bytedance.android.livesdk.gift.platform.business.tray2.manager.g;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.livesdk.gift.platform.core.b0;
import com.bytedance.android.livesdk.gift.platform.core.utils.c;
import com.bytedance.android.livesdk.gift.platform.core.utils.l;
import com.bytedance.android.livesdk.gift.platform.core.utils.recorder.ErrorNo;
import com.bytedance.android.livesdk.gift.platform.core.utils.recorder.d;
import com.bytedance.android.livesdk.message.model.o7;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import i02.e;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftMsgConsumeDispatcher implements g {
    public final String a;
    public f<NormalGiftMessage> b;
    public final TreeMap<Integer, b<NormalGiftMessage>> c;
    public final long d;
    public final Lazy e;
    public boolean f;

    public static final class a<T> implements Comparator {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(Object r1, Object r2) {
            return ((Integer) r2).intValue() - ((Integer) r1).intValue();
        }
    }

    public final void a() {
        GiftMsgConsumeDispatcher r0 = this;
        GiftContext r1 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r1 == null) goto L257;
        n<i02.a> r2 = r1.getCurrentSendTogetherInfo();
        if (r2 == null) goto L257;
        i02.a r25 = (i02.a) r2.getValue();
        if (r25 == null) goto L257;
        List<e> r3 = r25.b;
        if (r3 != null) goto L12;
        return;
    L12:
        LinkedHashMap r4 = new LinkedHashMap();
        LinkedHashMap r20 = new LinkedHashMap();
        LinkedHashMap r5 = new LinkedHashMap();
        Iterator<e> r6 = r3.iterator();
        int r8 = 0;
    L14:
        if (r6.hasNext() == false) goto L20;
        e r9 = r6.next();
        String r10 = r9.a.toString();
        Iterator<Integer> r11 = r9.a.iterator();
    L17:
        if (r11.hasNext() == false) goto L19;
        r4.put(Long.valueOf(r11.next().intValue()), r10);
        goto L17
    L19:
        r5.put(r10, new ArrayList());
        r20.put(r10, Integer.valueOf(r9.b));
        r8 = r8 + r9.b;
        goto L14
    L20:
        c.a(r0.a, "slotInfoList is " + r3);
        f<NormalGiftMessage> r7 = r0.b;
        if (r7 == null) goto L255;
        y02.g<NormalGiftMessage> r13 = r7.iterator();
        if (r13 == null) goto L255;
        ArrayList r14 = new ArrayList();
        LinkedHashMap r17 = new LinkedHashMap();
        ArrayList r15 = new ArrayList();
        ArrayList r16 = new ArrayList();
        ArrayList r18 = new ArrayList();
        ArrayList r19 = new ArrayList();
        ArrayList r110 = new ArrayList();
        StringBuilder r21 = new StringBuilder();
        ArrayList r111 = r15;
        int r112 = 0;
        int r113 = 0;
    L26:
        List<e> r114 = r3;
        ArrayList r23 = r16;
        if (r13.hasNext() == false) goto L92;
        LinkedHashMap r115 = r5;
        NormalGiftMessage r24 = r13.next();
        if (r24 == null) goto L30;
        j3 r116 = r24.D;
        if (r116 == null) goto L34;
        String r117 = r116.getId();
    L35:
        if (r117 == null) goto L88;
        j3 r118 = r24.D;
        if (r118 == null) goto L43;
        String r119 = r118.getId();
        if (r119 == null) goto L43;
        ArrayList r26 = r110;
        if (r119.equals(r25.a) == false) goto L42;
    L44:
        j3 r120 = r24.D;
        if (r120 == null) goto L47;
        long r27 = r120.getEndTime();
    L48:
        ArrayList r121 = r18;
        if (r27 >= (com.bytedance.live.kmp.util.e.b() / ((long) IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW))) goto L51;
        c.a(r0.a, "消息过期丢弃，消息ID " + r24.a + ", islocal is " + r24.v);
        r13.remove();
        r4 = r4;
        ArrayList r28 = r19;
        ArrayList r29 = r111;
        ArrayList r30 = r23;
        ArrayList r31 = r26;
        r20 = r20;
        ArrayList r33 = r121;
        r17 = r17;
        LinkedHashMap r122 = r115;
    L87:
        r19 = r28;
        r16 = r30;
        r18 = r33;
        r5 = r122;
        r17 = r17;
        r3 = r114;
        r20 = r20;
        r4 = r4;
        r110 = r31;
        r0 = this;
        r111 = r29;
        r25 = r25;
        goto L26
    L51:
        int r34 = r112 + 1;
        r113 = r113 + 1;
        r19.add(r24);
        if (r8 > 0) goto L54;
    L53:
        r29 = r111;
        r30 = r23;
        r31 = r26;
        r28 = r19;
        r33 = r121;
    L82:
        r122 = r115;
    L86:
        r112 = r34;
        goto L87
    L54:
        h2 r35 = r24.w;
        if (r35 == null) goto L57;
        Long r123 = Long.valueOf(r35.getPrimaryEffectId());
    L58:
        if (r123 == null) goto L53;
        if (r4.get(r123) == null) goto L53;
        String r124 = (String) r4.get(r123);
        if (r124 == null) goto L53;
        Integer r125 = (Integer) r20.get(r124);
        if (r125 == null) goto L53;
        int r126 = r125.intValue();
        if (r126 <= 0) goto L83;
        r20.put(r124, Integer.valueOf(r126 - 1));
        r14.add(r123);
        r28 = r19;
        r30 = r23;
        r33 = r121;
        r31 = r26;
        r29 = r111;
        com.bytedance.android.livesdk.gift.platform.business.tray2.manager.dispatcher.a.a(r17, r35.getId(), r35.getDiamondCount(), r123.longValue());
        com.bytedance.android.livesdk.gift.platform.business.tray2.manager.dispatcher.a.b(r29, r24);
        o7 r127 = r24.r();
        if (r127 != null) goto L71;
    L73:
        String r128 = "[]";
    L74:
        r30.add(r128);
        r33.add(Boolean.FALSE);
        w r129 = r24.E;
        if (r129 != null) goto L77;
    L81:
        r8 = r8 - 1;
        r21.append(r24.a);
        r28.remove(r24);
        r13.remove();
        goto L82
    L77:
        if (r129.getDisplayFrom() != ExtraEffectDisplayFrom.DisplayFormParalell.getValue()) goto L81;
        if (r129.getAssetId() <= 0) goto L81;
        r14.add(Long.valueOf(r129.getAssetId()));
        r29.add(new LinkedHashMap());
        r30.add("[]");
        r33.add(Boolean.TRUE);
        goto L81
    L71:
        if (r127.getDiyItemInfoList() == null) goto L73;
        r128 = r127.getDiyItemInfoList();
        goto L74
    L83:
        r4 = r4;
        r29 = r111;
        r30 = r23;
        r31 = r26;
        r34 = r34;
        r20 = r20;
        r28 = r19;
        r33 = r121;
        r17 = r17;
        r122 = r115;
        List r36 = (List) r122.get(r124);
        if (r36 == null) goto L86;
        r36.add(r24);
        goto L86
    L57:
        r123 = null;
        goto L58
    L47:
        r27 = Long.MAX_VALUE;
        goto L48
    L42:
        r0 = r0;
        r110 = r26;
    L89:
        c.a(r0.a, "下一条为非一起送消息");
        boolean r37 = r24.v;
        if (r37 == false) goto L94;
        r113 = 0;
    L94:
        int r38 = r114.size() - 1;
        int r130 = 0;
    L95:
        if (r38 < 0) goto L151;
        List<e> r131 = r114;
        e r132 = (e) ListProtector.get(r131, r38);
        String r133 = r132.a.toString();
        boolean r210 = r37;
        LinkedHashMap r39 = r20;
        Integer r211 = (Integer) r39.get(r133);
        if (r211 == null) goto L99;
        int r134 = r211.intValue();
    L100:
        r132.b = r134;
        Integer r135 = (Integer) r39.get(r133);
        if (r135 == null) goto L103;
        int r136 = r135.intValue();
    L104:
        r130 = r130 + r136;
        List r137 = (List) r115.get(r133);
        if (r137 != null) goto L107;
        int r212 = r38;
        LinkedHashMap r138 = r115;
        int r310 = r112;
        r114 = r131;
        i02.a r213 = r25;
        LinkedHashMap r214 = r39;
    L150:
        r38 = r212 - 1;
        r115 = r138;
        r37 = r210;
        r112 = r310;
        LinkedHashMap r311 = r214;
        r25 = r213;
        r20 = r311;
        goto L95
    L107:
        Iterator r215 = r137.iterator();
        int r216 = r130;
    L109:
        if (r215.hasNext() == false) goto L149;
        NormalGiftMessage r139 = (NormalGiftMessage) r215.next();
        if (r216 <= 0) goto L149;
        j3 r140 = r139.D;
        if (r140 == null) goto L115;
        String r141 = r140.getId();
    L116:
        if (r141 == null) goto L147;
        j3 r142 = r139.D;
        if (r142 == null) goto L120;
        String r143 = r142.getId();
    L121:
        LinkedHashMap r217 = r39;
        i02.a r144 = r25;
        LinkedHashMap r218 = r115;
        int r145 = r112;
        if (StringsKt.equals$default(r143, r25.a, false, 2, null) == false) goto L146;
        h2 r40 = r139.w;
        if (r40 == null) goto L146;
        if (r40.getPrimaryEffectId() <= 0) goto L129;
        r14.add(Long.valueOf(r40.getPrimaryEffectId()));
    L129:
        long r219 = r40.getId();
        int r312 = r40.getDiamondCount();
        long r313 = r40.getPrimaryEffectId();
        e r41 = r132;
        List<e> r314 = r131;
        i02.a r220 = r144;
        List<e> r146 = r314;
        int r315 = r145;
        LinkedHashMap r147 = r218;
        com.bytedance.android.livesdk.gift.platform.business.tray2.manager.dispatcher.a.a(r17, r219, r312, r313);
        com.bytedance.android.livesdk.gift.platform.business.tray2.manager.dispatcher.a.b(r111, r139);
        o7 r148 = r139.r();
        if (r148 != null) goto L132;
    L134:
        String r149 = "[]";
    L135:
        r23.add(r149);
        r18.add(Boolean.FALSE);
        f<NormalGiftMessage> r150 = r0.b;
        if (r150 == null) goto L138;
        r150.d(r139);
    L138:
        r19.remove(r139);
        r21.append(r139.t.getCommonData().getMessageId());
        w r43 = r139.E;
        if (r43 != null) goto L141;
    L145:
        r216 = r216 - 1;
        r41.b--;
    L148:
        r132 = r41;
        r115 = r147;
        r39 = r217;
        r38 = r38;
        r112 = r315;
        r25 = r220;
        r131 = r146;
        goto L109
    L141:
        if (r43.getDisplayFrom() != ExtraEffectDisplayFrom.DisplayFormParalell.getValue()) goto L145;
        if (r43.getAssetId() <= 0) goto L145;
        r14.add(Long.valueOf(r43.getAssetId()));
        r111.add(new LinkedHashMap());
        r23.add("[]");
        r18.add(Boolean.TRUE);
        goto L145
    L132:
        if (r148.getDiyItemInfoList() == null) goto L134;
        r149 = r148.getDiyItemInfoList();
    L146:
        r41 = r132;
        r315 = r145;
        r147 = r218;
        List<e> r316 = r131;
        r220 = r144;
        r146 = r316;
        goto L148
    L120:
        r143 = null;
        goto L121
    L147:
        r147 = r115;
        r315 = r112;
        r146 = r131;
        r220 = r25;
        r217 = r39;
        r41 = r132;
        goto L148
    L115:
        r141 = null;
    L149:
        r212 = r38;
        r138 = r115;
        r310 = r112;
        r114 = r131;
        r213 = r25;
        r214 = r39;
        r130 = r216;
        goto L150
    L103:
        r136 = 0;
        goto L104
    L99:
        r134 = r132.b;
        goto L100
    L151:
        boolean r221 = r37;
        int r317 = r112;
        i02.a r222 = r25;
        Iterator r44 = r19.iterator();
    L152:
        boolean r45 = r44.hasNext();
        String r151 = BuildConfig.FLAVOR;
        if (r45 == false) goto L177;
        NormalGiftMessage r46 = (NormalGiftMessage) r44.next();
        LinkedHashMap r152 = new LinkedHashMap();
        r152.put("sender_user_id", r46.getFromUserId());
        IBaseUser r153 = r46.e;
        if (r153 == null) goto L170;
        k r154 = r153.getAvatarThumbKt();
        if (r154 == null) goto L170;
        List r155 = r154.getUrls();
        if (r155 == null) goto L170;
        if (r155.size() <= 0) goto L163;
        boolean r47 = true;
    L164:
        if (r47 == true) goto L167;
        r155 = null;
    L167:
        if (r155 == null) goto L170;
        String r156 = (String) ListProtector.get(r155, 0);
        if (r156 == null) goto L170;
    L171:
        r152.put("sender_avatar", r156);
        IBaseUser r48 = r46.e;
        if (r48 == null) goto L176;
        String r49 = r48.getNickName();
        if (r49 == null) goto L176;
        r151 = r49;
    L176:
        r152.put("sender_name", r151);
        r110.add(r152);
        goto L152
    L163:
        r47 = false;
    L170:
        r156 = BuildConfig.FLAVOR;
        goto L171
    L177:
        ArrayList r50 = r110;
        Iterator<e> r51 = r114.iterator();
    L178:
        int r157 = 0;
    L180:
        if (r51.hasNext() == false) goto L186;
        e r158 = r51.next();
        int r159 = r158.b;
        if (r159 >= r157) goto L183;
        if (r159 >= r157) goto L180;
        r157 = r157 - r159;
        r158.b = 0;
        goto L180
    L183:
        r158.b = r159 - r157;
        goto L178
    L186:
        GiftContext r53 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r53 == null) goto L191;
        m<Integer> r54 = r53.getMsgCount();
        if (r54 == null) goto L191;
        r54.setValue(Integer.valueOf(r113));
    L191:
        GiftContext r55 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r55 == null) goto L197;
        m<Boolean> r56 = r55.isIntercept();
        if (r56 == null) goto L197;
        r56.setValue(Boolean.valueOf(r221));
    L197:
        if (r14.size() <= 0) goto L253;
        c.b(r0.a, "发送给Lynx的ID " + r14 + ", waitCount is " + r317);
        GiftContext r57 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r57 == null) goto L203;
        n<i02.a> r58 = r57.getCurrentSendTogetherInfo();
        if (r58 == null) goto L203;
        r58.setValue(r222);
    L203:
        String r59 = "H5_webcastNotification";
        if (((Boolean) nz1.a.N.getValue(null, nz1.a.a[38])).booleanValue() == false) goto L249;
        String r318 = r21.toString();
        ArrayList r60 = new ArrayList();
        Iterator r61 = r14.iterator();
        int r63 = 0;
    L207:
        if (r61.hasNext() == false) goto L246;
        Object r223 = r61.next();
        int r224 = r63 + 1;
        if (r63 >= 0) goto L211;
        CollectionsKt.throwIndexOverflow();
    L211:
        long r225 = ((Number) r223).longValue();
        Iterator r226 = r61;
        LinkedHashMap r64 = new LinkedHashMap();
        String r227 = r59;
        r64.put("assetId", Long.valueOf(r225));
        if (r63 >= r18.size()) goto L214;
        boolean r65 = ((Boolean) ListProtector.get(r18, r63)).booleanValue();
    L215:
        ArrayList r319 = r18;
        r64.put("displayFromParalell", Boolean.valueOf(r65));
        if (r65 == true) goto L245;
        LinkedHashMap r66 = r17;
        Map r67 = (Map) r66.get(String.valueOf(r225));
        if (r67 == null) goto L221;
        Object r68 = r67.get("gift_id");
        if (r68 == null) goto L221;
    L222:
        r17 = r66;
        r64.put("giftId", r68);
        if (r67 == null) goto L226;
        Object r69 = r67.get("money");
        if (r69 == null) goto L226;
    L227:
        r64.put("money", r69);
        if (r63 >= r111.size()) goto L243;
        Map r70 = (Map) ListProtector.get(r111, r63);
        Object r71 = r70.get("sender_user_id");
        if (r71 != null) goto L232;
        r71 = "-1";
    L232:
        r64.put("senderUserId", r71);
        Object r73 = r70.get("send_time");
        if (r73 != null) goto L235;
        r73 = 0L;
    L235:
        r64.put("sendTime", r73);
        Object r74 = r70.get("send_avatar");
        if (r74 != null) goto L238;
        r74 = BuildConfig.FLAVOR;
    L238:
        r64.put("sender_avatar", r74);
        Object r75 = r70.get("sender_name");
        if (r75 != null) goto L241;
        r75 = BuildConfig.FLAVOR;
    L241:
        r64.put("sender_name", r75);
    L243:
        if (r63 >= r23.size()) goto L245;
        r64.put("diyItemInfo", ListProtector.get(r23, r63));
    L226:
        r69 = 0;
    L221:
        r68 = 0L;
    L245:
        r60.add(r64);
        r61 = r226;
        r63 = r224;
        r59 = r227;
        r18 = r319;
        goto L207
    L214:
        r65 = true;
        goto L215
    L246:
        com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class).sendEventToAllJsBridges(r59, MapsKt.mapOf(new Pair[]{TuplesKt.to("eventName", "push_together_message_data"), TuplesKt.to("messageDataList", r60), TuplesKt.to("waitCount", Integer.valueOf(r317)), TuplesKt.to("waiting_assets", r50)}));
        c.b(this.a, "send to lynx " + r60);
        f<NormalGiftMessage> r76 = this.b;
        if (r76 == null) goto L288;
        r76.a(this.d, r318, ((Number) ListProtector.get(r14, 0)).longValue());
        return;
    L288:
        return;
    L249:
        GiftMsgConsumeDispatcher r77 = r0;
        String r78 = r21.toString();
        com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class).sendEventToAllJsBridges("H5_webcastNotification", MapsKt.mapOf(new Pair[]{TuplesKt.to("eventName", "push_together_message_list"), TuplesKt.to("assetIds", r14), TuplesKt.to("waitCount", Integer.valueOf(r317)), TuplesKt.to("gift_data", r17), TuplesKt.to("send_info", r111), TuplesKt.to("waiting_assets", r50), TuplesKt.to("diyItemInfoList", r23)}));
        c.b(r77.a, "send to lynx " + r14);
        f<NormalGiftMessage> r79 = r77.b;
        if (r79 == null) goto L290;
        r79.a(r77.d, r78, ((Number) ListProtector.get(r14, 0)).longValue());
        return;
    L290:
        return;
    L253:
        return;
    L43:
        r26 = r110;
        goto L44
    L88:
        r110 = r110;
        r0 = this;
        goto L89
    L34:
        r117 = null;
        goto L35
    L30:
        r115 = r115;
    L93:
        r37 = false;
        goto L94
    L92:
        r115 = r5;
    L255:
        return;
    }

    public final boolean b() {
        f<NormalGiftMessage> r1 = this.b;
        if (r1 == null) goto L48;
        NormalGiftMessage r2 = r1.c();
        GiftMsgConsumeDispatcher r3 = this;
        GiftMsgConsumeDispatcher r4 = r3;
        GiftMsgConsumeDispatcher r5 = r4;
    L7:
        boolean r6 = false;
        if (r2 == null) goto L28;
        int r7 = l.a;
        Intrinsics.checkNotNullParameter(r2, "message");
        long r8 = System.currentTimeMillis() - 0;
        long r11 = l.a();
        if (0 <= r11) goto L13;
    L15:
        boolean r9 = false;
    L16:
        if (r9 == false) goto L18;
    L24:
        b0.a.b(r2.b, r2.getAssetId(), r2.getLogId(), 0, l.a(), 0);
        c.c(r3.a, "message expired " + r2.b);
        f<NormalGiftMessage> r10 = r3.b;
        if (r10 != null) goto L26;
        r3 = r3;
        r2 = null;
        r5 = r5;
        r4 = r4;
        goto L7
    L26:
        r2 = r10.c();
        goto L7
    L18:
        if (r2.P == true) goto L20;
    L22:
        boolean r13 = false;
    L23:
        if (r13 == false) goto L28;
    L20:
        if (r2.Q == false) goto L22;
        c.b(r3.a, "rtcRoomMessage is Expire, skip play");
        r13 = true;
        goto L23
    L13:
        if (r8 <= r11) goto L15;
        r9 = true;
    L28:
        if (r2 != null) goto L34;
        c.a(r4.a, "no more message");
        f<NormalGiftMessage> r14 = r4.b;
        if (r14 == null) goto L32;
        r14.e();
    L32:
        return false;
    L34:
        if (r4.c.size() != 0) goto L36;
        c.b(r4.a, "no consumer!!!");
    L36:
        Iterator<Map.Entry<Integer, b<NormalGiftMessage>>> r15 = r4.c.entrySet().iterator();
    L38:
        if (r15.hasNext() == false) goto L42;
        final Map.Entry<Integer, b<NormalGiftMessage>> r16 = r15.next();
        r16.getValue().pg(r2);
        if (r16.getValue().lh(r2) == false) goto L38;
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.d.getClass();
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.a.C0075a.e.c.g(Long.valueOf(r2.a), "start consume by " + r16.getValue(), new GiftMsgConsumeDispatcher$notifyConsumeMsg$1(r16));
        r6 = true;
    L42:
        if (r6 == true) goto L44;
        c.c(r4.a, "no consumer consume the msg " + r2);
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.d.getClass();
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.a.C0075a.e.c.a(Long.valueOf(r2.a), "no consumer consume the msg gid:" + r2.b + " aid:" + r2.getAssetId(), new d(ErrorNo.NORMAL_ERROR, "no one consume the msg "));
        v12.f.v(r2, 1);
        r5.c();
    L47:
        return r6;
    L44:
        v12.f.v(r2, 2);
        f<NormalGiftMessage> r17 = r4.b;
        if (r17 == null) goto L47;
        r17.a(r4.d, String.valueOf(r2.a), r2.getAssetId());
        goto L47
    L48:
        r3 = this;
        r2 = null;
        r5 = this;
        r4 = this;
        goto L7
    }

    public final void c() {
        ReadOnlyProperty r0 = com.bytedance.android.livesdk.gift.platform.business.b.h;
        KProperty[] r1 = com.bytedance.android.livesdk.gift.platform.business.b.a;
        if (((Number) r0.getValue(null, r1[6])).intValue() <= 0) goto L5;
        this.f = true;
        i0.c().postDelayed((Runnable) this.e.getValue(), ((Number) r0.getValue(null, r1[6])).intValue());
        return;
    L5:
        b();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.tray2.manager.g
    public final boolean og() {
        Iterator<Map.Entry<Integer, b<NormalGiftMessage>>> r0 = this.c.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Map.Entry<Integer, b<NormalGiftMessage>> r1 = r0.next();
        if (r1.getValue().isIdle() == true) goto L4;
        c.c(this.a, r1 + " is busy");
        boolean r2 = false;
    L9:
        if (r2 == true) goto L11;
    L14:
        a();
        c.c(this.a, "one of consumers is not idle or interval is " + this.f + ", ignore");
        return false;
    L11:
        if (this.f == true) goto L14;
        return b();
    L8:
        r2 = true;
        goto L9
    }

    public GiftMsgConsumeDispatcher() {
        this.a = "GiftMsgConsumeDispatcher";
        this.c = new TreeMap(a.a);
        this.d = ((long) ((Number) com.bytedance.android.livesdk.gift.platform.business.e.g.getValue(null, com.bytedance.android.livesdk.gift.platform.business.e.a[5])).intValue()) * 1000;
        this.e = LazyKt.lazy(new GiftMsgConsumeDispatcher$notifyConsumeMsgRunnable$2(this));
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.tray2.manager.g
    public final void Ge(Message r6) {
        c.c(this.a, "comsume timeout , force Idle,then notify consume next message");
        Iterator<Map.Entry<Integer, b<NormalGiftMessage>>> r0 = this.c.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().getValue().ei();
        goto L4
    L6:
        Object r1 = null;
        if (r6 == null) goto L23;
        Object r2 = r6.obj;
        if ((r2 instanceof Map) == true) goto L11;
        r2 = null;
    L11:
        Map r3 = (Map) r2;
        if (r3 == null) goto L14;
        Object r4 = r3.get("msgId");
    L15:
        String r5 = String.valueOf(r4);
        Object r7 = r6.obj;
        if ((r7 instanceof Map) == true) goto L18;
        r7 = null;
    L18:
        Map r8 = (Map) r7;
        if (r8 == null) goto L21;
        Object r9 = r8.get("assetId");
    L22:
        v12.f.x(r5, String.valueOf(r9));
        goto L23
    L21:
        r9 = null;
        goto L22
    L14:
        r4 = null;
    L23:
        b();
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.d.getClass();
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.g r10 = com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.a.C0075a.e.c;
        if (r6 == null) goto L26;
        Object r11 = r6.obj;
    L28:
        if ((r11 instanceof Map) == false) goto L31;
        r1 = r11;
    L31:
        Map r13 = (Map) r1;
        if (r13 == null) goto L35;
        Object r14 = r13.get("msgId");
        if (r14 == null) goto L35;
    L36:
        r10.a(r14, "consume timeout", new d(ErrorNo.CONSUME_TIMEOUT, this.a + " consume timeout"));
        return;
    L35:
        r14 = BuildConfig.FLAVOR;
        goto L36
    L26:
        r11 = null;
        goto L28
    }

    public final void d(b<NormalGiftMessage> r4) {
        Intrinsics.checkNotNullParameter(r4, "consumer");
        Iterator<Map.Entry<Integer, b<NormalGiftMessage>>> r0 = this.c.entrySet().iterator();
        boolean r1 = false;
    L4:
        if (r0.hasNext() == false) goto L8;
        if (Intrinsics.areEqual(r0.next().getValue(), r4) == false) goto L4;
        r0.remove();
        r1 = true;
        goto L4
    L8:
        if (r1 == true) goto L16;
        c.b(this.a, "unregisterConsumer failed " + r4);
        return;
    }
}
