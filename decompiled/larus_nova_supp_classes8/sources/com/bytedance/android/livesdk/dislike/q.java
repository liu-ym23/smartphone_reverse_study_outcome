package com.bytedance.android.livesdk.dislike;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.android.live.base.model.longpresspanel.ItemConfig;
import com.bytedance.android.live.base.model.longpresspanel.ItemIdentity;
import com.bytedance.android.live.base.model.longpresspanel.LiveLongPressItemType;
import com.bytedance.android.live.base.model.user.FollowInfo;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.TTLiveSDKContext;
import com.bytedance.android.livesdk.dislike.recommendlive.RecommendLiveHelper;
import com.bytedance.android.livesdk.user.f0;
import com.bytedance.android.livesdk.utils.i1;
import com.bytedance.android.livesdk.utils.w5;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatusStyle;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomAuthStatus;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class q {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final dz.b a(final Room r22, final DataCenter r23, String r24, String r25, Boolean r26, Context r27) {
        Intrinsics.checkNotNullParameter(r27, "context");
        p r2 = new p(r27);
        String r10 = "";
        if (r24 != null) goto L5;
        String r4 = "";
    L6:
        if (r25 != null) goto L8;
        String r5 = "";
    L9:
        ActionsManager r9 = new ActionsManager(r2, r22, r4, r5, r26, 32);
        ArrayList r1 = new ArrayList();
        Room r3 = r9.d;
        if (r3 == null) goto L16;
        User r6 = r3.getOwner();
        if (r6 == null) goto L16;
        FollowInfo r7 = r6.getFollowInfo();
        if (r7 == null) goto L16;
        long r8 = r7.getPushStatus();
    L17:
        u r11 = r9.p(r8, true);
        if (r11 == null) goto L20;
        r1.add(r11);
    L20:
        u r12 = r9.q(true);
        if (r12 == null) goto L23;
        r1.add(r12);
    L23:
        List<String> r13 = r9.b;
        ItemType r14 = ItemType.DISLIKE_CURRENT_LIVE;
        String r15 = r14.name();
        Locale r16 = Locale.ROOT;
        if (r15 == null) goto L175;
        boolean r17 = ((ArrayList) r13).contains(r15.toLowerCase(r16));
        IRoomAuthStatusStyle r18 = null;
        if (r17 == true) goto L28;
        u r19 = null;
    L29:
        if (r19 == null) goto L31;
        r1.add(r19);
    L31:
        n r20 = r9.d(2131916158, true, true);
        if (r20 == null) goto L34;
        r1.add(r20);
    L34:
        n r21 = r9.h(true, true);
        if (r21 == null) goto L37;
        r1.add(r21);
    L37:
        u r28 = r9.u(true);
        if (r28 == null) goto L40;
        r1.add(r28);
    L40:
        y r29 = r9.s(true);
        if (r29 == null) goto L43;
        r1.add(r29);
    L43:
        u r30 = r9.k(true, null);
        if (r30 == null) goto L46;
        r1.add(r30);
    L46:
        u r31 = r9.n(true);
        if (r31 == null) goto L49;
        r1.add(r31);
    L49:
        u r32 = r9.b(true);
        if (r32 == null) goto L52;
        r1.add(r32);
    L52:
        w5.a();
        u r33 = r9.t(true);
        if (r33 == null) goto L55;
        r1.add(r33);
    L55:
        u r34 = r9.c(true);
        if (r34 == null) goto L58;
        r1.add(r34);
    L58:
        u r35 = r9.r(true);
        if (r35 == null) goto L61;
        r1.add(r35);
    L61:
        u r36 = r9.i();
        if (r36 == null) goto L64;
        r1.add(r36);
    L64:
        dz.b r37 = new dz.b();
        Iterator r38 = r1.iterator();
    L66:
        if (r38.hasNext() == false) goto L110;
        final n r39 = (n) r38.next();
        dz.a r40 = new dz.a();
        boolean r110 = false;
        if ((r39 instanceof u) == false) goto L82;
        r40.b = r39.a.getItemType(false).intValue();
        r40.c = LiveLongPressItemType.NORMAL.getValue();
        ItemIdentity r111 = r39.a.getIdentity();
        Intrinsics.checkNotNullParameter(r111, "<set-?>");
        r40.a = r111;
        r39.a.getPriority(false).intValue();
        r39.a.getClearColorFilter();
        r39.a.getHasLandingPage();
        Integer r112 = r39.a.getImgRes();
        if (r112 == null) goto L72;
        r40.d = s1.m(r112.intValue());
    L72:
        u r113 = (u) r39;
        String r114 = r113.c.c;
        if (r114 != null) goto L75;
    L76:
        r110 = true;
    L77:
        if (r110 == false) goto L79;
        String r115 = s1.B(r113.c.b);
    L80:
        r40.e = r115;
        r40.f = new LiveLongPressPanelHelper$liveLongPressItemConverter$$inlined$apply$lambda$1(r39);
        new LiveLongPressPanelHelper$liveLongPressItemConverter$$inlined$apply$lambda$2(r39);
        new LiveLongPressPanelHelper$liveLongPressItemConverter$$inlined$apply$lambda$3(r39);
    L109:
        Intrinsics.checkNotNullParameter(r40, "liveLongPressItem");
        ((ArrayList) r37.a).add(r40);
        goto L66
    L79:
        r115 = r113.c.c;
        goto L80
    L75:
        if (r114.length() != 0) goto L77;
    L82:
        if ((r39 instanceof y) == false) goto L92;
        r40.b = r39.a.getItemType(false).intValue();
        r40.c = LiveLongPressItemType.NORMAL.getValue();
        ItemIdentity r116 = r39.a.getIdentity();
        Intrinsics.checkNotNullParameter(r116, "<set-?>");
        r40.a = r116;
        r39.a.getPriority(false).intValue();
        r39.a.getClearColorFilter();
        r39.a.getHasLandingPage();
        Integer r117 = r39.a.getImgRes();
        if (r117 == null) goto L86;
        r40.d = s1.m(r117.intValue());
    L86:
        int r118 = RecommendLiveHelper.a;
        if (RecommendLiveHelper.g(r22.getRoomId()) == false) goto L89;
        String r119 = s1.B(2131921924);
    L90:
        r40.e = r119;
        r40.f = new LiveLongPressPanelHelper$liveLongPressItemConverter$$inlined$apply$lambda$4(r39, r22);
        new LiveLongPressPanelHelper$liveLongPressItemConverter$$inlined$apply$lambda$5(r39, r22);
        new LiveLongPressPanelHelper$liveLongPressItemConverter$$inlined$apply$lambda$6(r39, r22);
        goto L109
    L89:
        r119 = s1.B(2131921932);
        goto L90
    L92:
        if ((r39 instanceof j) == false) goto L105;
        r40.b = r39.a.getItemType(false).intValue();
        r40.c = LiveLongPressItemType.NORMAL.getValue();
        ItemIdentity r120 = r39.a.getIdentity();
        Intrinsics.checkNotNullParameter(r120, "<set-?>");
        r40.a = r120;
        r39.a.getPriority(false).intValue();
        r39.a.getClearColorFilter();
        r39.a.getHasLandingPage();
        Integer r121 = r39.a.getImgRes();
        if (r121 == null) goto L96;
        r40.d = s1.m(r121.intValue());
    L96:
        j r122 = (j) r39;
        String r123 = r122.c.c;
        if (r123 != null) goto L99;
    L100:
        r110 = true;
    L101:
        if (r110 == false) goto L103;
        String r124 = s1.B(r122.c.b);
    L104:
        r40.e = r124;
        r40.f = new LiveLongPressPanelHelper$liveLongPressItemConverter$$inlined$apply$lambda$7(r39);
        new LiveLongPressPanelHelper$liveLongPressItemConverter$$inlined$apply$lambda$8(r39);
        new LiveLongPressPanelHelper$liveLongPressItemConverter$$inlined$apply$lambda$9(r39);
        goto L109
    L103:
        r124 = r122.c.c;
        goto L104
    L99:
        if (r123.length() != 0) goto L101;
    L105:
        r40.b = r39.a.getItemType(false).intValue();
        r40.c = LiveLongPressItemType.NORMAL.getValue();
        ItemIdentity r125 = r39.a.getIdentity();
        Intrinsics.checkNotNullParameter(r125, "<set-?>");
        r40.a = r125;
        r39.a.getPriority(false).intValue();
        r39.a.getClearColorFilter();
        r39.a.getHasLandingPage();
        Integer r126 = r39.a.getImgRes();
        if (r126 == null) goto L108;
        r40.d = s1.m(r126.intValue());
    L108:
        r40.e = r39.a.getDesc();
        r40.f = new LiveLongPressPanelHelper$liveLongPressItemConverter$$inlined$apply$lambda$10(r39);
        new LiveLongPressPanelHelper$liveLongPressItemConverter$$inlined$apply$lambda$11(r39);
        new LiveLongPressPanelHelper$liveLongPressItemConverter$$inlined$apply$lambda$12(r39);
        goto L109
    L110:
        new LiveLongPressPanelHelper$getLiveLongPressItems$1(r22, r23);
        new LiveLongPressPanelHelper$getLiveLongPressItems$2(r22);
        Bundle r41 = r37.b;
        if (r23 == null) goto L114;
        String r0 = (String) r23.get("data_member_count_str", "");
        if (r0 == null) goto L114;
    L115:
        r41.putString("room_member_count", r0);
        int r42 = i1.a;
        JSONObject r43 = new JSONObject();
        if (r22.isHasCommerceGoods() == true) goto L176;
    L139:
        String r44 = "";
    L140:
        r41.putString("ecom_share_track_params", r44);
        String r45 = (String) com.bytedance.android.livesdk.log.u.l().c(Room.class).getMap().get("request_id");
        if (r45 == null) goto L144;
        r10 = r45;
    L144:
        r41.putString("request_id", r10);
        RoomAuthStatus r46 = r22.getRoomAuthStatus();
        if (r46 == null) goto L147;
        long r47 = r46.getShowShare();
    L148:
        RoomAuthStatus r48 = r22.getRoomAuthStatus();
        if (r48 == null) goto L154;
        RoomAuthStatus.RoomAuthSpecialStyle r49 = r48.roomAuthSpecialStyle;
        if (r49 == null) goto L154;
        r18 = r49.getShareStyle();
    L154:
        if (r47 != 2) goto L158;
        if (r18 != null) goto L157;
    L173:
        return r37;
    L157:
        if (r18.getUnableStyle() == 0) goto L173;
    L158:
        User r50 = r22.getOwner();
        if (r50 != null) goto L161;
    L163:
        Iterator<T> r51 = com.bytedance.android.livesdk.config.setting.l.b().iterator();
    L165:
        if (r51.hasNext() == false) goto L173;
        String r52 = ((ItemConfig) r51.next()).getIdentity();
        String r53 = ItemType.IM_MESSAGE.name();
        Locale r54 = Locale.ROOT;
        if (r53 == null) goto L172;
        if (Intrinsics.areEqual(r52, r53.toLowerCase(r54)) == false) goto L165;
    L172:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L161:
        if (r50.getSecret() != 1) goto L163;
    L147:
        r47 = 0;
        goto L148
    L176:
        r43.put("is_ec_shopping", "1");     // Catch: Exception -> L137
        com.bytedance.android.livesdk.service.f r55 = TTLiveSDKContext.getHostService();     // Catch: Exception -> L137
        if (r55 == null) goto L130;
        f0 r56 = r55.h();     // Catch: Exception -> L137
        if (r56 == null) goto L130;
        String r57 = r56.n();     // Catch: Exception -> L137
        if (r57 == null) goto L130;
        r43.put("from_user_id", r57);     // Catch: Exception -> L137
        com.bytedance.android.livesdk.service.f r127 = TTLiveSDKContext.getHostService();     // Catch: Exception -> L137
        if (r127 == null) goto L130;
        f0 r128 = r127.h();     // Catch: Exception -> L137
        if (r128 == null) goto L130;
        String r58 = r128.a(r57);     // Catch: Exception -> L137
        if (r58 == null) goto L130;
        r43.put("secuid", r58);     // Catch: Exception -> L137
    L130:
        User r59 = r22.getOwner();     // Catch: Exception -> L137
        if (r59 == null) goto L135;
        String r60 = r59.getIdStr();     // Catch: Exception -> L137
        if (r60 == null) goto L135;
        r43.put("author_id", r60);     // Catch: Exception -> L137
    L135:
        r43.put("live_id", String.valueOf(r22.id));     // Catch: Exception -> L137
        r43.put("share_action_type", "press");     // Catch: Exception -> L137
        r43.put("enter_from", "live");     // Catch: Exception -> L137
        r44 = r43.toString();     // Catch: Exception -> L137
    L137:
        e = move-exception;
        SafetyGuard.a(null, null, e.getMessage());
    L114:
        r0 = "";
        goto L115
    L28:
        r19 = new u(new nt1.c(2131250345, 2131916232, null, false, false, false, null, 124), new com.bytedance.android.livesdk.dislike.action.h(r9), r14);
        goto L29
    L175:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L16:
        r8 = 2;
        goto L17
    L8:
        r5 = r25;
        goto L9
    L5:
        r4 = r24;
        goto L6
    }
}
