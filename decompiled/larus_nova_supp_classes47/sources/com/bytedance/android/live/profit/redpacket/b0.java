package com.bytedance.android.live.profit.redpacket;

import android.net.Uri;
import android.view.ViewGroup;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.revenue.model.extension.IMainRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b0 {
    public static final void b(y0.a r1, bv0.b r2, RedPacketDressType r3) {
        Intrinsics.checkNotNullParameter(r1, "iconState");
        Intrinsics.checkNotNullParameter(r2, "redPacketDressService");
        Intrinsics.checkNotNullParameter(r3, "dressType");
    }

    public static final void c(ViewGroup r1, y0.a r2, bv0.b r3) {
        Intrinsics.checkNotNullParameter(r2, "state");
        Intrinsics.checkNotNullParameter(r3, "redPacketDressService");
        if (r1 == null) goto L8;
        HSImageView r4 = r1.findViewById(2131363806);
        if (r4 == null) goto L9;
        b(r2, r3, RedPacketDressType.ShortTouchWaitingPng);
        ImageUtil.loadImage(r4, null, 0);
        return;
    L9:
        return;
    }

    public static final Uri a(IRoom r15, n0 r16, Long r17, String r18) {
        Intrinsics.checkNotNullParameter(r18, "openTime");
        String r2 = (String) com.bytedance.android.live.core.utils.h1.a(r15).get("interact_function");
        String r4 = "";
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        Pair[] r6 = new Pair[4];
        if (r15 == null) goto L8;
        LiveMode r8 = r15.getStreamType();
    L9:
        r6[0] = TuplesKt.to("live_type", com.bytedance.android.live.core.utils.i1.a(r8));
        r6[1] = TuplesKt.to("interact_function", r2);
        if (r15 == null) goto L14;
        IMainRoom r3 = iy0.e.a(r15);
        if (r3 == null) goto L14;
        iy0.a r5 = r3.mo398getOfficialChannelInfo();
    L15:
        if (r5 != null) goto L17;
        String r7 = "";
    L18:
        r6[2] = TuplesKt.to("room_type", r7);
        if (r15 == null) goto L21;
        Long r9 = Long.valueOf(r15.getId());
    L22:
        r6[3] = TuplesKt.to("from_room_id", String.valueOf(r9));
        Map r10 = MapsKt.mutableMapOf(r6);
        Intrinsics.checkNotNullParameter(r10, "m");
        Pair[] r12 = new Pair[11];
        if (r16 == null) goto L25;
        Integer r13 = Integer.valueOf(r16.m);
    L26:
        r12[0] = TuplesKt.to("diamond_count", String.valueOf(r13));
        Gson r14 = GsonHelper.get();
        if (r16 == null) goto L34;
        List<m> r19 = r16.n;
        if (r19 == null) goto L34;
        List<m> r110 = r19;
        ArrayList r111 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r110, 10));
        Iterator<T> r112 = r110.iterator();
    L32:
        if (r112.hasNext() == false) goto L35;
        r111.add(x0.h((m) r112.next()));
    L35:
        r12[1] = TuplesKt.to("description_list", GsonProtectorUtils.toJson(r14, r111));
        if (r16 == null) goto L38;
        Boolean r20 = Boolean.valueOf(r16.p);
    L39:
        r12[2] = TuplesKt.to("is_risky_owner", String.valueOf(r20));
        if (r16 == null) goto L43;
        String r22 = r16.q;
        if (r22 == null) goto L43;
    L44:
        r12[3] = TuplesKt.to("activity_id", r22);
        if (r16 == null) goto L47;
        Long r23 = Long.valueOf(r16.l);
    L48:
        r12[4] = TuplesKt.to("business_type", String.valueOf(r23));
        if (r16 == null) goto L51;
        Integer r24 = Integer.valueOf(r16.getType());
    L52:
        r12[5] = TuplesKt.to("box_type", String.valueOf(r24));
        if (r16 == null) goto L55;
        String r25 = r16.d;
    L56:
        r12[6] = TuplesKt.to("box_id", String.valueOf(r25));
        r12[7] = TuplesKt.to("count_down", String.valueOf(r17));
        if (r16 == null) goto L61;
        com.bytedance.android.live.revenue.common.u0 r26 = r16.f;
        if (r26 == null) goto L61;
        Long r27 = Long.valueOf(r26.a);
    L62:
        r12[8] = TuplesKt.to("send_time", String.valueOf(r27));
        if (r16 == null) goto L67;
        com.bytedance.android.live.revenue.common.u0 r28 = r16.g;
        if (r28 == null) goto L67;
        Long r29 = Long.valueOf(r28.a / com.bytedance.android.live.revenue.common.u0.b);
    L68:
        r12[9] = TuplesKt.to("delay_time", String.valueOf(r29));
        if (r15 == null) goto L71;
        Long r30 = Long.valueOf(r15.getRoomId());
    L72:
        r12[10] = TuplesKt.to("room_id", String.valueOf(r30));
        r10.putAll(MapsKt.mutableMapOf(r12));
        if (r16 == null) goto L87;
        IBaseUser r32 = r16.j;
        if (r32 == null) goto L87;
        String r33 = r32.getIdString();
        if (r33 != null) goto L79;
        r33 = "";
    L79:
        r10.put("sender_id", r33);
        Intrinsics.checkNotNullParameter(r32, "$this$secUidExt");
        String r34 = r32.getCastSecUid();
        if (r34 != null) goto L82;
        r34 = "";
    L82:
        r10.put("sender_sec_uid", r34);
        String r35 = r32.getNickName();
        if (r35 == null) goto L86;
        r4 = r35;
    L86:
        r10.put("sender_nick_name", r4);
        r10.put("sender_avtar_url", x0.f(r32.getAvatarThumbKt()));
    L87:
        Gson r36 = GsonHelper.get();
        if (r16 == null) goto L98;
        Intrinsics.checkNotNullParameter(r16, "$this$toLuckyBoxResponse");
        com.bytedance.android.live.profit.redpacket.model.b r37 = (com.bytedance.android.live.profit.redpacket.model.b) vh7.f.c(com.bytedance.android.live.profit.redpacket.model.b.class);
        IBaseUser r38 = r16.j;
        Intrinsics.checkNotNullParameter(r38, "sender");
        IBaseUser r113 = vh7.f.c(IBaseUser.class);
        iy0.c r114 = (iy0.c) r113.castToOrNull(iy0.c.class);
        iy0.c r115 = (iy0.c) r38.castToOrNull(iy0.c.class);
        if (r114 == null) goto L93;
        if (r115 == null) goto L93;
        r114.setId(r115.getId());
    L93:
        r113.setIdString(r38.getIdString());
        r113.setNickName(r38.getNickName());
        r113.setAvatarThumbImplicit(r38.getAvatarThumbKt());
        Intrinsics.checkNotNullParameter(r38, "$this$secUidExt");
        String r116 = r38.getCastSecUid();
        Intrinsics.checkNotNullParameter(r113, "$this$secUidExt");
        r113.setCastSecUid(r116);
        r113.setFollowInfoExt(r38.getFollowInfo());
        r37.setUser(r113);
        r37.setSendTime(r16.f.a);
        r37.setDelayTime(r16.g.a / com.bytedance.android.live.revenue.common.u0.b);
        r37.setBoxType(r16.getType());
        r37.setDiamondCount(r16.m);
        List<m> r39 = r16.n;
        ArrayList r40 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r39, 10));
        Iterator<T> r42 = r39.iterator();
    L95:
        if (r42.hasNext() == false) goto L97;
        m r117 = (m) r42.next();
        Intrinsics.checkNotNullParameter(r117, "description");
        com.bytedance.android.live.profit.redpacket.model.c r118 = (com.bytedance.android.live.profit.redpacket.model.c) vh7.f.c(com.bytedance.android.live.profit.redpacket.model.c.class);
        r118.setImage(r117.a);
        r118.setText(r117.b);
        r40.add(r118);
        goto L95
    L97:
        r37.setDescriptionList(r40);
        r37.setDisplayDuration(r16.i.b(r16.h).a / com.bytedance.android.live.revenue.common.u0.b);
        r37.setRiskyOwner(r16.p);
    L99:
        r10.put("boxData", GsonProtectorUtils.toJson(r36, r37));
        if (r16 != null) goto L102;
    L104:
        yz0.k r0 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r0 != null) goto L107;
    L109:
        int r1 = -1;
    L111:
        return UriProtector.parse(com.bytedance.android.live.revenue.common.u.b(RedPacketHybridService.f, r10)).buildUpon().appendQueryParameter("hybrid_type", "lynx").appendQueryParameter("open_time", r18).appendQueryParameter("preset_width_px", String.valueOf(r1)).build();
    L107:
        if (r0.isPortraitInteraction() == true) goto L109;
        r1 = com.bytedance.android.annie.util.p.a.a(350.0f);
        goto L111
    L102:
        if (r16.p != true) goto L104;
        r10.put("riskyAvatarUrl", com.bytedance.android.live.revenue.common.v0.a((String) ListProtector.get((List) i1.d.getValue(null, i1.a[2]), Math.abs(r16.j.getIdString().hashCode()) % 10)));
        r10.put("riskyNickName", r16.j.getNickName());
        goto L104
    L98:
        r37 = null;
        goto L99
    L71:
        r30 = null;
    L67:
        r29 = null;
    L61:
        r27 = null;
        goto L62
    L55:
        r25 = null;
        goto L56
    L51:
        r24 = null;
        goto L52
    L47:
        r23 = null;
    L43:
        r22 = "";
        goto L44
    L38:
        r20 = null;
    L34:
        r111 = null;
        goto L35
    L25:
        r13 = null;
        goto L26
    L21:
        r9 = null;
        goto L22
    L17:
        r7 = "carousel";
    L14:
        r5 = null;
        goto L15
    L8:
        r8 = null;
        goto L9
    }
}
