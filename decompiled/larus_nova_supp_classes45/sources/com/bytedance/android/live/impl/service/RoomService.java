package com.bytedance.android.live.impl.service;

import am2.x;
import android.os.Handler;
import android.text.TextUtils;
import android.util.LongSparseArray;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.live.core.feature.DynamicDataRespItem;
import com.bytedance.android.live.core.feature.RoomFeatureUtils;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.StreamDataUtil;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.u5;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdk.widget.o2;
import com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrl;
import com.bytedance.android.livesdkapi.depend.model.live.IGroupLiveData;
import com.bytedance.android.livesdkapi.depend.model.live.ILiveCoreSDKData;
import com.bytedance.android.livesdkapi.depend.model.live.IQuality;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomCart;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomOthersData;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomStats;
import com.bytedance.android.livesdkapi.depend.model.live.PayloadStartMicrogameStamp;
import com.bytedance.android.livesdkapi.depend.model.live.RoomExtra;
import com.bytedance.android.livesdkapi.depend.model.live.toolbar.RoomStreamDataObject;
import com.bytedance.android.livesdkapi.model.LiveHandleRoomOptimizeConfig;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import j40.c0;
import j40.e0;
import j40.g0;
import j40.v1;
import j40.z2;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;
import py.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class RoomService {
    public static volatile WeakReference<IRoom> a;
    public static String b;
    public static JSONObject c;
    public static final Boolean d = null;
    public static final LiveHandleRoomOptimizeConfig e = null;
    public static final Set<String> f = null;
    public static final CopyOnWriteArrayList<String> g = null;
    public static final Lazy h = null;
    public static final aa0.a i = null;

    static {
        b = "";
        d = g0.a.getValue();
        e = (LiveHandleRoomOptimizeConfig) u5.a.getValue();
        f = new LinkedHashSet();
        if (e0.a.getValue().booleanValue() == false) goto L5;
        CopyOnWriteArrayList<String> r0 = new CopyOnWriteArrayList();
    L6:
        g = r0;
        h = LazyKt.lazy(RoomService$clearRealtimeFeatureWhiteList$2.INSTANCE);
        i = v1.a.getValue();
        return;
    L5:
        r0 = null;
        goto L6
    }

    public static Map a(IRoom r5) {
        Pair[] r0 = new Pair[11];
        r0[0] = TuplesKt.to("room_id", String.valueOf(r5.getRoomId()));
        r0[1] = TuplesKt.to("anchor_id", String.valueOf(r5.getAnchorId()));
        r0[2] = TuplesKt.to("room_user_count", String.valueOf(r5.getUserCount()));
        IRoomStats r1 = r5.getStats();
        Integer r2 = null;
        if (r1 == null) goto L5;
        Integer r3 = Integer.valueOf(r1.getTotalUser());
    L6:
        r0[3] = TuplesKt.to("room_total_user_count", String.valueOf(r3));
        IBaseUser r4 = r5.getOwner();
        if (r4 == null) goto L11;
        j r6 = r4.getFollowInfo();
        if (r6 == null) goto L11;
        Long r7 = Long.valueOf(r6.getFollowerCount());
    L12:
        r0[4] = TuplesKt.to("anchor_fans_count", String.valueOf(r7));
        IBaseUser r8 = r5.getOwner();
        if (r8 == null) goto L17;
        j r9 = r8.getFollowInfo();
        if (r9 == null) goto L17;
        Long r11 = Long.valueOf(r9.getFollowingCount());
    L18:
        r0[5] = TuplesKt.to("anchor_follow_count", String.valueOf(r11));
        IBaseUser r12 = r5.getOwner();
        if (r12 == null) goto L23;
        j r13 = r12.getFollowInfo();
        if (r13 == null) goto L23;
        Long r14 = Long.valueOf(r13.getFollowStatus());
    L24:
        r0[6] = TuplesKt.to("follow_status", String.valueOf(r14));
        IBaseUser r15 = r5.getOwner();
        if (r15 == null) goto L27;
        Integer r16 = Integer.valueOf(r15.getGender());
    L28:
        r0[7] = TuplesKt.to("anchor_gender", String.valueOf(r16));
        IBaseUser r17 = r5.getOwner();
        if (r17 == null) goto L31;
        r2 = Integer.valueOf(r17.getAgeRange());
    L31:
        r0[8] = TuplesKt.to("anchor_age_range", String.valueOf(r2));
        IBaseUser r18 = r5.getOwner();
        String r19 = "";
        if (r18 == null) goto L36;
        String r21 = r18.getCity();
        if (r21 == null) goto L36;
    L37:
        r0[9] = TuplesKt.to("anchor_city", r21);
        IBaseUser r22 = r5.getOwner();
        if (r22 == null) goto L42;
        String r23 = r22.getLocationCity();
        if (r23 == null) goto L42;
        r19 = r23;
    L42:
        r0[10] = TuplesKt.to("anchor_location_city", r19);
        return MapsKt.mapOf(r0);
    L36:
        r21 = "";
        goto L37
    L27:
        r16 = null;
    L23:
        r14 = null;
    L17:
        r11 = null;
    L11:
        r7 = null;
        goto L12
    L5:
        r3 = null;
        goto L6
    }

    public static void c(IRoom r21) {
        long r2 = System.currentTimeMillis();
        String r6 = "";
        if (e.getSameRoomOptimize() == false) goto L11;
        if (r21 == null) goto L6;
        Long r0 = Long.valueOf(r21.getId());
    L8:
        if (TextUtils.equals(String.valueOf(r0), (CharSequence) FeatureManager.u.getFeature("live_roomid", "")) == false) goto L11;
        return;
    L6:
        r0 = null;
    L11:
        if (r21 == null) goto L46;
        e(r21);
        FeatureManager r1 = FeatureManager.u;
        String r9 = (String) r1.getFeature("video_live_ad_features", "{}");
        long r11 = ((Number) r1.getFeature("video_live_ad_room_id", -1L)).longValue();
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L15
        Object r4 = Result.constructor-impl(new JSONObject(r9));     // Catch: Throwable -> L15
    L18:
        if (Result.isFailure-impl(r4) == false) goto L20;
        r4 = null;
    L20:
        final JSONObject r5 = (JSONObject) r4;
        if (r21.getAdStrategyFeatures() == null) goto L23;
    L25:
        com.bytedance.android.livesdk.strategy.a r12 = r21.getAdStrategyFeatures();
        if (r12 == null) goto L389;
        HashMap r13 = r12.a;
        if (r13 == null) goto L389;
        Iterator r14 = r13.entrySet().iterator();
    L31:
        if (r14.hasNext() == false) goto L389;
        final Map.Entry r15 = (Map.Entry) r14.next();
        f.add((String) r15.getKey());
        boolean r16 = com.bytedance.android.live.impl.utils.a.a;
        com.bytedance.android.live.impl.utils.a.a("AdSmartFeatureLog", new RoomService$putAdFeatures$2$1(r15));
        z90.a.C0301a.a(FeatureManager.u, (String) r15.getKey(), r15.getValue());
    L389:
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L44
        if (r5 == null) goto L41;
        Iterator<String> r18 = r5.keys();     // Catch: Throwable -> L44
        if (r18 == null) goto L41;
    L38:
        if (r18.hasNext() == false) goto L40;
        final String r19 = r18.next();     // Catch: Throwable -> L44
        f.add(r19);     // Catch: Throwable -> L44
        boolean r110 = com.bytedance.android.live.impl.utils.a.a;     // Catch: Throwable -> L44
        com.bytedance.android.live.impl.utils.a.a("AdSmartFeatureLog", new RoomService$putAdFeatures$$inlined$runCatching$lambda$1(r19, r5));     // Catch: Throwable -> L44
        z90.a.C0301a.a(FeatureManager.u, r19, r5.opt(r19));     // Catch: Throwable -> L44
        goto L38
    L40:
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L44
    L42:
        Result.constructor-impl(r7);     // Catch: Throwable -> L44
    L41:
        r7 = null;
    L44:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L46
    L23:
        if (r11 == r21.getRoomId()) goto L25;
        boolean r8 = com.bytedance.android.live.impl.utils.a.a;
        com.bytedance.android.live.impl.utils.a.a("AdSmartFeatureLog", RoomService$putAdFeatures$1.INSTANCE);
        z90.a.C0301a.a(FeatureManager.u, "live_is_ad", Boolean.FALSE);
    L15:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
    L46:
        if (r21 == null) goto L48;
        Long r24 = Long.valueOf(r21.getId());
    L49:
        String r25 = String.valueOf(r24);
        FeatureManager r26 = FeatureManager.u;
        if (TextUtils.equals(r25, (CharSequence) r26.getFeature("live_roomid", "")) == false) goto L52;
        return;
    L52:
        final Ref.ObjectRef r111 = new Ref.ObjectRef();
        r111.element = new ArrayList();
        o r27 = j0.l().c(x.class);
        if (r27 == null) goto L58;
        Map r112 = r27.getMap();
        if (r112 == null) goto L58;
        String r113 = (String) r112.get("enter_from_merge");
        if (r113 == null) goto L58;
    L59:
        z90.a.C0301a.a(r26, "enter_from_merge", r113);
        if (r27 == null) goto L65;
        Map r114 = r27.getMap();
        if (r114 == null) goto L65;
        String r115 = (String) r114.get("enter_method");
        if (r115 == null) goto L65;
    L66:
        z90.a.C0301a.a(r26, "enter_method", r115);
        if (r27 == null) goto L72;
        Map r28 = r27.getMap();
        if (r28 == null) goto L72;
        String r29 = (String) r28.get("action_type");
        if (r29 == null) goto L72;
    L73:
        z90.a.C0301a.a(r26, "action_type", r29);
        String r31 = "0";
        if (r21 == null) goto L77;
        String r116 = r21.getAnchorId();
        if (r116 == null) goto L77;
    L79:
        if (Intrinsics.areEqual(b, "") == false) goto L81;
        b = (String) r26.getFeature("solaria_features_topn_anchors", "");
    L81:
        Lazy r117 = RoomFeatureUtils.a;
        Intrinsics.checkNotNullParameter(r116, "anchorId");
        com.bytedance.android.live.core.feature.a<String, DynamicDataRespItem> r118 = RoomFeatureUtils.b;
        DynamicDataRespItem r119 = (DynamicDataRespItem) ((ConcurrentHashMap) r118.a).get(r116);
        int r120 = 0;
        if (r119 == null) goto L86;
        Integer r121 = r119.getAnchorLayer();
        if (r121 == null) goto L86;
        int r122 = r121.intValue();
    L87:
        z90.a.C0301a.a(r26, "anchor_layer", Integer.valueOf(r122));
        ((List) r111.element).add("anchor_layer");
        Intrinsics.checkNotNullParameter(r116, "anchorId");
        DynamicDataRespItem r32 = (DynamicDataRespItem) ((ConcurrentHashMap) r118.a).get(r116);
        if (r32 == null) goto L92;
        Integer r33 = r32.getAnchorInteraction();
        if (r33 == null) goto L92;
        int r34 = r33.intValue();
    L93:
        z90.a.C0301a.a(r26, "anchor_interaction", Integer.valueOf(r34));
        ((List) r111.element).add("anchor_interaction");
        List r35 = (List) r111.element;
        if (c != null) goto L103;
        String r36 = (String) r26.getFeature("solaria_features_topn_anchors_profile", "");     // Catch: JSONException -> L112
        if (r36.length() != 0) goto L99;
        boolean r123 = true;
    L100:
        if (r123 == true) goto L113;
        c = new JSONObject(r36);     // Catch: JSONException -> L112
        goto L103
    L99:
        r123 = false;
    L103:
        JSONObject r37 = c;     // Catch: JSONException -> L112
        if (r37 == null) goto L113;
        JSONObject r38 = r37.optJSONObject(r116);     // Catch: JSONException -> L112
        if (r38 == null) goto L113;
        Iterator<String> r124 = r38.keys();     // Catch: JSONException -> L112
    L108:
        if (r124.hasNext() == false) goto L113;
        String r125 = r124.next();     // Catch: JSONException -> L112
        z90.a.C0301a.a(FeatureManager.u, r125, r38.get(r125));     // Catch: JSONException -> L112
        r35.add(r125);     // Catch: JSONException -> L112
    L113:
        FeatureManager r39 = FeatureManager.u;
        int r41 = 2;
        z90.a.C0301a.a(r39, "is_topn_room", Boolean.valueOf(StringsKt.contains$default(b, r116, false, 2, null)));
        ((List) r111.element).add("is_topn_room");
        if (r21 == null) goto L119;
        IBaseStreamUrl r42 = r21.getStreamUrl();
        if (r42 == null) goto L119;
        String r43 = r42.getDefaultQualityStrategy();
        if (r43 == null) goto L119;
    L120:
        z90.a.C0301a.a(r39, "quality_strategy", r43);
        ((List) r111.element).add("quality_strategy");
        long r126 = 0;
        if (r21 == null) goto L123;
        long r127 = r21.getUserCount();
    L124:
        z90.a.C0301a.a(r39, "user_count_in_cur_room", Long.valueOf(r127));
        ((List) r111.element).add("user_count_in_cur_room");
        if (r21 == null) goto L130;
        String r44 = String.valueOf(r21.getId());
        if (r44 == null) goto L130;
        r31 = r44;
    L130:
        z90.a.C0301a.a(r39, "live_roomid", r31);
        ((List) r111.element).add("live_roomid");
        z90.a.C0301a.a(r39, "live_is_vs_sports", Boolean.FALSE);
        ((List) r111.element).add("live_is_vs_sports");
        if (r21 == null) goto L133;
        boolean r45 = r21.isMergeVSRoom();
    L134:
        z90.a.C0301a.a(r39, "is_vs_live_room", Boolean.valueOf(r45));
        ((List) r111.element).add("is_vs_live_room");
        if (r21 == null) goto L137;
        int r46 = (int) r21.getLiveRoomMode();
    L138:
        z90.a.C0301a.a(r39, "live_room_mode", Integer.valueOf(r46));
        ((List) r111.element).add("live_room_mode");
        if (r21 == null) goto L143;
        IRoomStats r47 = r21.getStats();
        if (r47 == null) goto L143;
        int r48 = r47.getTotalUser();
    L144:
        z90.a.C0301a.a(r39, "total_user_count_in_cur_room", Integer.valueOf(r48));
        ((List) r111.element).add("total_user_count_in_cur_room");
        if (r21 == null) goto L148;
        String r49 = r21.getMultiStreamDefaultQualitySdkKey();
        if (r49 == null) goto L148;
    L149:
        z90.a.C0301a.a(r39, "stream_sdkkey", r49);
        ((List) r111.element).add("stream_sdkkey");
        if (r21 == null) goto L153;
        String r51 = r21.getRoomRevenueOpenGameAppId();
        if (r51 == null) goto L153;
    L154:
        z90.a.C0301a.a(r39, "open_game_app_id", r51);
        ((List) r111.element).add("open_game_app_id");
        if (r21 == null) goto L163;
        RoomExtra r52 = r21.getExtra();
        if (r52 == null) goto L163;
        PayloadStartMicrogameStamp r53 = r52.getPayloadStartMicrogameStamp();
        if (r53 == null) goto L163;
        String r54 = r53.getMpId();
        if (r54 == null) goto L163;
        boolean r55 = r2.a(r54);
    L164:
        z90.a.C0301a.a(r39, "payload_start_microgame_stamp", Boolean.valueOf(r55));
        ((List) r111.element).add("payload_start_microgame_stamp");
        if (r21 == null) goto L171;
        String r56 = r21.getRoomRevenueOpenGameAppId();
        if (r56 == null) goto L171;
        if (r56.length() <= 0) goto L171;
        boolean r57 = true;
    L172:
        z90.a.C0301a.a(r39, "is_open_game_app_id", Boolean.valueOf(r57));
        ((List) r111.element).add("is_open_game_app_id");
        if (r21 == null) goto L177;
        IBaseStreamUrl r58 = r21.getStreamUrl();
        if (r58 == null) goto L177;
        boolean r59 = r58.getVPassDefault();
    L178:
        z90.a.C0301a.a(r39, "vpaas", Boolean.valueOf(r59));
        ((List) r111.element).add("vpaas");
        if (r21 == null) goto L181;
        int r61 = r21.getVRType();
    L182:
        z90.a.C0301a.a(r39, "vr_type", Integer.valueOf(r61));
        ((List) r111.element).add("vr_type");
        if (r21 == null) goto L188;
        String r62 = r21.getOwnerUserIdString();
        if (r62 == null) goto L188;
        r6 = r62;
    L188:
        z90.a.C0301a.a(r39, "live_author_id", r6);
        ((List) r111.element).add("live_author_id");
        if (r21 == null) goto L191;
        String r63 = r21.isEcomCart();
    L193:
        if (TextUtils.equals(r63, GamePromoteDataContext.GAME_TYPE_MOBILE) == true) goto L201;
        if (r21 == null) goto L200;
        IRoomCart r64 = r21.getRoomCart();
        if (r64 == null) goto L200;
        if (r64.getShowCartExt() == 1) goto L201;
    L200:
        int r65 = 0;
    L202:
        z90.a.C0301a.a(r39, "is_ecom_live", Integer.valueOf(r65));
        ((List) r111.element).add("is_ecom_live");
        if (r21 == null) goto L209;
        IRoomOthersData r66 = r21.getRoomOthers();
        if (r66 == null) goto L209;
        IGroupLiveData r67 = r66.getGroupData();
        if (r67 == null) goto L209;
        int r68 = r67.isGroupLive();
    L210:
        z90.a.C0301a.a(r39, "is_group_live", Integer.valueOf(r68));
        ((List) r111.element).add("is_group_live");
        if (r21 == null) goto L213;
        String r69 = r21.isEcomCart();
    L215:
        if (TextUtils.equals(r69, GamePromoteDataContext.GAME_TYPE_MOBILE) == true) goto L223;
        if (r21 == null) goto L222;
        IRoomCart r71 = r21.getRoomCart();
        if (r71 == null) goto L222;
        if (r71.getShowCartExt() == 1) goto L223;
    L222:
        int r72 = -1;
    L225:
        if (r21 != null) goto L227;
    L237:
        if (r21 != null) goto L239;
    L240:
        if (r21 != null) goto L242;
    L244:
        r41 = r72;
    L245:
        z90.a.C0301a.a(r39, "live_toolbar_status", Integer.valueOf(r41));
        ((List) r111.element).add("live_toolbar_status");
        if (r21 == null) goto L248;
        int r73 = r21.isGameRoom();
    L249:
        z90.a.C0301a.a(r39, "is_game_live", Integer.valueOf(r73));
        ((List) r111.element).add("is_game_live");
        if (r21 == null) goto L252;
        long r128 = r21.getGameTagId();
    L253:
        z90.a.C0301a.a(r39, "game_tag_id", Long.valueOf(r128));
        ((List) r111.element).add("game_tag_id");
        if (r21 == null) goto L256;
        boolean r74 = r21.isGameCPRoom();
    L257:
        z90.a.C0301a.a(r39, "has_game_cp", Boolean.valueOf(r74));
        ((List) r111.element).add("has_game_cp");
        if (r21 == null) goto L260;
        int r75 = r21.getCompoundSceneType();
    L261:
        z90.a.C0301a.a(r39, "dual_live_type", Integer.valueOf(r75));
        ((List) r111.element).add("dual_live_type");
        if (r21 == null) goto L274;
        int r76 = 1;
        if (r21.getBusinessLive() != 1) goto L274;
        IRoomAuthStatus r77 = r21.getRoomAuthStatus();
        if (r77 != null) goto L268;
    L269:
        IRoomAuthStatus r78 = r21.getRoomAuthStatus();
        if (r78 == null) goto L274;
        if (r78.getCommerceCard() != 1) goto L274;
    L275:
        z90.a.C0301a.a(r39, "is_life_live", Integer.valueOf(r76));
        ((List) r111.element).add("is_life_live");
        if (r21 == null) goto L293;
        IBaseStreamUrl r79 = r21.getStreamUrl();
        if (r79 == null) goto L293;
        ILiveCoreSDKData r81 = r79.getLiveCoreSDKData();
        if (r81 == null) goto L293;
        List r82 = r81.getQualityList();
        if (r82 == null) goto L293;
        Iterator r83 = r82.iterator();
    L285:
        if (r83.hasNext() == false) goto L289;
        Object r84 = r83.next();
        if (Intrinsics.areEqual(((IQuality) r84).getSdkKey(), r21.getMultiStreamDefaultQualitySdkKey()) == false) goto L285;
    L290:
        IQuality r85 = (IQuality) r84;
        if (r85 == null) goto L293;
        r120 = r85.getLevel();
        goto L293
    L289:
        r84 = null;
    L293:
        z90.a.C0301a.a(r39, "stream_qualitylevel", Integer.valueOf(r120));
        ((List) r111.element).add("stream_qualitylevel");
        Result.Companion r86 = Result.Companion;     // Catch: Throwable -> L320
        FeatureManager r87 = FeatureManager.u;     // Catch: Throwable -> L320
        LongSparseArray r88 = (LongSparseArray) r87.getFeature("room_tag_array_level1", new LongSparseArray());     // Catch: Throwable -> L320
        if (r21 == null) goto L297;
        long r89 = r21.getRoomId();     // Catch: Throwable -> L320
    L298:
        Long r91 = (Long) r88.get(r89);     // Catch: Throwable -> L320
        if (r91 == null) goto L301;
        long r92 = r91.longValue();     // Catch: Throwable -> L320
    L302:
        z90.a.C0301a.a(r87, "room_content_tag_l1", Long.valueOf(r92));     // Catch: Throwable -> L320
        ((List) r111.element).add("room_content_tag_l1");     // Catch: Throwable -> L320
        LongSparseArray r93 = (LongSparseArray) r87.getFeature("room_tag_array_level2", new LongSparseArray());     // Catch: Throwable -> L320
        if (r21 == null) goto L305;
        long r94 = r21.getRoomId();     // Catch: Throwable -> L320
    L306:
        Long r95 = (Long) r93.get(r94);     // Catch: Throwable -> L320
        if (r95 == null) goto L309;
        long r96 = r95.longValue();     // Catch: Throwable -> L320
    L310:
        z90.a.C0301a.a(r87, "room_content_tag_l2", Long.valueOf(r96));     // Catch: Throwable -> L320
        ((List) r111.element).add("room_content_tag_l2");     // Catch: Throwable -> L320
        LongSparseArray r97 = (LongSparseArray) r87.getFeature("room_tag_array_level3", new LongSparseArray());     // Catch: Throwable -> L320
        if (r21 == null) goto L313;
        long r98 = r21.getRoomId();     // Catch: Throwable -> L320
    L314:
        Long r99 = (Long) r97.get(r98);     // Catch: Throwable -> L320
        if (r99 == null) goto L317;
        long r129 = r99.longValue();     // Catch: Throwable -> L320
    L318:
        z90.a.C0301a.a(r87, "room_content_tag_l3", Long.valueOf(r129));     // Catch: Throwable -> L320
        Object r100 = Result.constructor-impl(Boolean.valueOf(((List) r111.element).add("room_content_tag_l3")));     // Catch: Throwable -> L320
    L322:
        final Throwable r101 = Result.exceptionOrNull-impl(r100);
        if (r101 == null) goto L325;
        boolean r102 = com.bytedance.android.live.impl.utils.a.a;
        com.bytedance.android.live.impl.utils.a.d(null, new RoomService$handleRoom$3$1(r101));
    L325:
        z90.a.C0301a.a(FeatureManager.u, "avg_duration_per_room", Long.valueOf(o2.a(z2.a.getValue().intValue())));
        ((List) r111.element).add("avg_duration_per_room");
        CopyOnWriteArrayList<String> r103 = g;
        if (r103 == null) goto L334;
        Iterator<T> r104 = r103.iterator();
    L329:
        if (r104.hasNext() == false) goto L333;
        String r105 = (String) r104.next();
        if (r105 == null) goto L329;
        FeatureManager.u.g(r105);
        goto L329
    L333:
        Unit r106 = Unit.INSTANCE;
    L334:
        List r107 = (List) h.getValue();
        if (r107 == null) goto L343;
        Iterator r108 = r107.iterator();
    L338:
        if (r108.hasNext() == false) goto L342;
        String r109 = (String) r108.next();
        if (r109 == null) goto L338;
        FeatureManager.u.g(r109);
        goto L338
    L342:
        Unit r130 = Unit.INSTANCE;
    L343:
        CopyOnWriteArrayList<String> r131 = g;
        if (r131 == null) goto L346;
        r131.clear();
        Unit r132 = Unit.INSTANCE;
    L346:
        Lazy r133 = RoomFeatureUtils.a;
        if (r21 == null) goto L349;
        long r134 = r21.getRoomId();
    L350:
        Map r135 = RoomFeatureUtils.a(r134);
        if (r135 == null) goto L361;
        Set r136 = r135.entrySet();
        if (r136 == null) goto L361;
        Iterator r137 = r136.iterator();
    L356:
        if (r137.hasNext() == false) goto L360;
        Map.Entry r138 = (Map.Entry) r137.next();
        z90.a.C0301a.a(FeatureManager.u, (String) r138.getKey(), r138.getValue());
        ((List) r111.element).add(r138.getKey());
        CopyOnWriteArrayList<String> r139 = g;
        if (r139 == null) goto L356;
        r139.add((String) r138.getKey());
        goto L356
    L360:
        Unit r140 = Unit.INSTANCE;
    L361:
        FeatureManager r141 = FeatureManager.u;
        Function2<String, Object, Unit> r142 = new RoomService$handleRoom$7(r111);
        r141.getClass();
        FeatureManager.m(r116, r142);
        d(r21, (List) r111.element);
        if (e.getEnableHandleRoomExplicit() == false) goto L367;
        if (r21 == null) goto L367;
        String r143 = r21.getItemExplicitInfo();
        if (r143 == null) goto L367;
        b(r143, (List) r111.element);
        Unit r144 = Unit.INSTANCE;
    L367:
        if (r21 == null) goto L379;
        IBaseStreamUrl r145 = r21.getStreamUrl();
        if (r145 == null) goto L379;
        ILiveCoreSDKData r146 = r145.getLiveCoreSDKData();
        if (r146 == null) goto L379;
        List r147 = r146.getQualityList();
        if (r147 == null) goto L379;
        Iterator r148 = r147.iterator();
    L376:
        if (r148.hasNext() == false) goto L378;
        IQuality r149 = (IQuality) r148.next();
        z90.a.C0301a.a(FeatureManager.u, "quanlity_resolution_" + r149.getSdkKey(), r149.getResolution());
        goto L376
    L378:
        Unit r150 = Unit.INSTANCE;
    L379:
        long r151 = System.currentTimeMillis();
        long r152 = r151 - r2;
        FeatureManager r153 = FeatureManager.u;
        r153.getClass();
        z90.a.c r154 = FeatureManager.o;
        if (r154 == null) goto L382;
        r154.a((List) r111.element);
        Unit r155 = Unit.INSTANCE;
    L382:
        long r156 = System.currentTimeMillis();
        z90.a.C0301a.a(r153, "handle_room_time", Long.valueOf(r156 - r2));
        z90.a.C0301a.a(r153, "data_change_time", Long.valueOf(r156 - r151));
        z90.a.C0301a.a(r153, "handle_feature_time", Long.valueOf(r152));
        long r157 = System.currentTimeMillis();
        if (r21 == null) goto L387;
        Long r158 = r21.getInitTime();
        if (r158 == null) goto L387;
        r126 = r158.longValue();
    L387:
        z90.a.C0301a.a(r153, "room_use_gap", Long.valueOf(r157 - r126));
        return;
    L349:
        r134 = 0;
        goto L350
    L317:
        r129 = -1;
        goto L318
    L313:
        r98 = 0;
        goto L314
    L309:
        r96 = -1;
        goto L310
    L305:
        r94 = 0;
        goto L306
    L301:
        r92 = -1;
        goto L302
    L297:
        r89 = 0;
    L320:
        th = move-exception;
        Result.Companion r159 = Result.Companion;
        r100 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L322
    L268:
        if (r77.getCommerceCard() == 0) goto L275;
    L274:
        r76 = 0;
        goto L275
    L260:
        r75 = 0;
        goto L261
    L256:
        r74 = false;
        goto L257
    L252:
        r128 = 0;
        goto L253
    L248:
        r73 = 0;
        goto L249
    L242:
        if (r21.isGameRoom() != 1) goto L244;
    L239:
        if (r21.getHasGamePromote() == 1) goto L245;
    L227:
        if (r21.getBusinessLive() != 1) goto L237;
        IRoomAuthStatus r160 = r21.getRoomAuthStatus();
        if (r160 != null) goto L231;
    L232:
        IRoomAuthStatus r161 = r21.getRoomAuthStatus();
        if (r161 == null) goto L237;
        if (r161.getCommerceCard() != 1) goto L237;
    L236:
        r72 = 1;
        goto L237
    L231:
        if (r160.getCommerceCard() == 0) goto L236;
    L223:
        r72 = 0;
        goto L225
    L213:
        r69 = null;
    L209:
        r68 = 0;
    L201:
        r65 = 1;
        goto L202
    L191:
        r63 = null;
        goto L193
    L181:
        r61 = 0;
    L177:
        r59 = false;
    L171:
        r57 = false;
    L163:
        r55 = false;
    L153:
        r51 = "";
    L148:
        r49 = "";
    L143:
        r48 = 0;
        goto L144
    L137:
        r46 = 0;
        goto L138
    L133:
        r45 = false;
        goto L134
    L123:
        r127 = 0;
    L119:
        r43 = "";
    L92:
        r34 = 0;
    L86:
        r122 = 0;
    L77:
        r116 = "0";
    L72:
        r29 = "";
    L65:
        r115 = "";
    L58:
        r113 = "";
        goto L59
    L48:
        r24 = null;
        goto L49
    }

    public static void e(IRoom r11) {
        if (r11 != null) goto L61;
        return;
    L61:
        JSONObject r1 = new JSONObject().putOpt("room_id", Long.valueOf(r11.getRoomId())).putOpt("anchor_id", r11.getAnchorId()).putOpt("room_user_count", Long.valueOf(r11.getUserCount()));     // Catch: JSONException -> L58
        IRoomStats r3 = r11.getStats();     // Catch: JSONException -> L58
        String r4 = null;
        if (r3 == null) goto L8;
        Integer r5 = Integer.valueOf(r3.getTotalUser());     // Catch: JSONException -> L58
    L9:
        JSONObject r2 = r1.putOpt("room_total_user_count", r5);     // Catch: JSONException -> L58
        IBaseUser r6 = r11.getOwner();     // Catch: JSONException -> L58
        if (r6 == null) goto L14;
        j r7 = r6.getFollowInfo();     // Catch: JSONException -> L58
        if (r7 == null) goto L14;
        Long r8 = Long.valueOf(r7.getFollowerCount());     // Catch: JSONException -> L58
    L15:
        JSONObject r9 = r2.putOpt("anchor_fans_count", r8);     // Catch: JSONException -> L58
        IBaseUser r12 = r11.getOwner();     // Catch: JSONException -> L58
        if (r12 == null) goto L20;
        j r13 = r12.getFollowInfo();     // Catch: JSONException -> L58
        if (r13 == null) goto L20;
        Long r14 = Long.valueOf(r13.getFollowingCount());     // Catch: JSONException -> L58
    L21:
        JSONObject r15 = r9.putOpt("anchor_follow_count", r14);     // Catch: JSONException -> L58
        IBaseUser r16 = r11.getOwner();     // Catch: JSONException -> L58
        if (r16 == null) goto L26;
        j r17 = r16.getFollowInfo();     // Catch: JSONException -> L58
        if (r17 == null) goto L26;
        Long r18 = Long.valueOf(r17.getFollowStatus());     // Catch: JSONException -> L58
    L27:
        JSONObject r19 = r15.putOpt("follow_status", r18);     // Catch: JSONException -> L58
        IBaseUser r21 = r11.getOwner();     // Catch: JSONException -> L58
        if (r21 == null) goto L30;
        Integer r22 = Integer.valueOf(r21.getGender());     // Catch: JSONException -> L58
    L31:
        JSONObject r23 = r19.putOpt("anchor_gender", r22);     // Catch: JSONException -> L58
        IBaseUser r24 = r11.getOwner();     // Catch: JSONException -> L58
        if (r24 == null) goto L34;
        Integer r25 = Integer.valueOf(r24.getAgeRange());     // Catch: JSONException -> L58
    L35:
        JSONObject r26 = r23.putOpt("anchor_age_range", r25);     // Catch: JSONException -> L58
        IBaseUser r27 = r11.getOwner();     // Catch: JSONException -> L58
        if (r27 == null) goto L38;
        String r28 = r27.getCity();     // Catch: JSONException -> L58
    L39:
        JSONObject r29 = r26.putOpt("anchor_city", r28);     // Catch: JSONException -> L58
        IBaseUser r31 = r11.getOwner();     // Catch: JSONException -> L58
        if (r31 == null) goto L42;
        r4 = r31.getLocationCity();     // Catch: JSONException -> L58
    L42:
        JSONObject r32 = r29.putOpt("anchor_location_city", r4).putOpt("live_mode", Integer.valueOf(r11.getStreamType().ordinal()));     // Catch: JSONException -> L58
        if (d.booleanValue() == true) goto L46;
        j0.l().sendLog("livesdk_handle_room", a(r11), new Object[]{x.class, IRoom.class});     // Catch: JSONException -> L58
        z90.a.C0301a.a(FeatureManager.u, "handle_room_params", r32);     // Catch: JSONException -> L58
    L47:
        Handler r33 = UtilityKotlinExtentionsKt.a;     // Catch: JSONException -> L58
        a = new WeakReference(r11);     // Catch: JSONException -> L58
        FeatureManager r34 = FeatureManager.u;     // Catch: JSONException -> L58
        z90.a.C0301a.a(r34, "handle_weak_room", new WeakReference(r11));     // Catch: JSONException -> L58
        Intrinsics.checkNotNullParameter("preview_show_score_predict_room_id", "name");     // Catch: JSONException -> L58
        if (FeatureManager.a.containsKey("preview_show_score_predict_room_id") == true) goto L51;
        return;
    L51:
        if ((!Intrinsics.areEqual(String.valueOf(r11.getRoomId()), (String) r34.getFeature("preview_show_score_predict_room_id", ""))) == false) goto L56;
        JSONObject r0 = (JSONObject) r34.getFeature("preview_show_score_predict_results", new JSONObject());     // Catch: JSONException -> L58
        z90.a.C0301a.a(r34, "preview_show_score_predict_is_same_room", Boolean.FALSE);     // Catch: JSONException -> L58
        Object r110 = r0.opt(String.valueOf(r11.getRoomId()));     // Catch: JSONException -> L58
        if (r110 != null) goto L55;
        r110 = 0;     // Catch: JSONException -> L58
    L55:
        z90.a.C0301a.a(r34, "preview_show_score_predict_score_cache", r110);     // Catch: JSONException -> L58
        return;
    L56:
        z90.a.C0301a.a(r34, "preview_show_score_predict_is_same_room", Boolean.TRUE);     // Catch: JSONException -> L58
        r34.g("preview_show_score_predict_score_cache");     // Catch: JSONException -> L58
        return;
    L46:
        FeatureManager.u.c("handle_room_params", r32);     // Catch: JSONException -> L58
        goto L47
    L38:
        r28 = null;
        goto L39
    L34:
        r25 = null;
        goto L35
    L30:
        r22 = null;
    L26:
        r18 = null;
    L20:
        r14 = null;
    L14:
        r8 = null;
        goto L15
    L8:
        r5 = null;
    L58:
        e = move-exception;
        boolean r35 = com.bytedance.android.live.impl.utils.a.a;
        com.bytedance.android.live.impl.utils.a.b("LFM-RoomService", RoomService$putRoomFeatures$1.INSTANCE, e);
    }

    public static void b(String r11, List r12) {
        JSONObject r0 = new JSONObject(r11);     // Catch: JSONException -> L19
        Iterator<String> r13 = r0.keys();     // Catch: JSONException -> L19
    L3:
        if (r13.hasNext() == false) goto L26;
        String r1 = r13.next();     // Catch: JSONException -> L19
        Object r2 = r0.get(r1);     // Catch: JSONException -> L19
        if (Intrinsics.areEqual("client_targets_rec_info", r1) == true) goto L11;
        if (Intrinsics.areEqual("feed_draw_client_targets_rec_info", r1) == true) goto L11;
    L16:
        z90.a.C0301a.a(FeatureManager.u, "explicit_" + r1, r2);     // Catch: JSONException -> L19
        r12.add("explicit_" + r1);     // Catch: JSONException -> L19
    L11:
        if ((r2 instanceof String) == false) goto L16;
        JSONObject r3 = new JSONObject((String) r2);     // Catch: JSONException -> L19
        Iterator<String> r5 = r3.keys();     // Catch: JSONException -> L19
    L14:
        if (r5.hasNext() == false) goto L16;
        String r6 = r5.next();     // Catch: JSONException -> L19
        z90.a.C0301a.a(FeatureManager.u, "explicit_" + r6, r3.get(r6));     // Catch: JSONException -> L19
        r12.add("explicit_" + r6);     // Catch: JSONException -> L19
        goto L14
    L26:
        return;
    }

    public static void d(final IRoom r34, final List r35) {
        String r9 = "h2qu";
        String r17 = "stream_";
        Intrinsics.checkNotNullParameter(r35, "list");
        if (r34 == null) goto L5;
        String r18 = r34.getMultiStreamData();
    L6:
        if (r18 != null) goto L8;
    L11:
        boolean r19 = true;
    L13:
        if (r19 == false) goto L16;
        z90.a.C0301a.a(FeatureManager.u, "stream_orientation", 0);
    L16:
        FeatureManager r0 = FeatureManager.u;
        r0.g("pcdn_download_enable");
        r0.g("major_anchor_level");
        r0.g("stream_ld");
        r0.g("stream_sd");
        r0.g("stream_hd");
        r0.g("stream_uhd");
        r0.g("stream_md");
        r0.g("stream_ao");
        r0.g("stream_xuhd");
        r0.g("stream_origin");
        r0.g("vr_fov");
        if (r34 == null) goto L253;
        String r6 = r34.getMultiStreamData();
        if (r6 != null) goto L21;
        return;
    L21:
        if (r6.length() <= 0) goto L23;
        boolean r24 = true;
    L24:
        if (r24 == false) goto L255;
        final Ref.ObjectRef r1 = new Ref.ObjectRef();     // Catch: Exception -> L243
        r1.element = null;     // Catch: Exception -> L243
        if (e.getEnableCache() == false) goto L38;
        RoomStreamDataObject r5 = r34.getRoomStreamDataObject();     // Catch: Exception -> L243
        if (r5 == null) goto L31;
        JSONObject r7 = r5.getStreamDataObject();     // Catch: Exception -> L243
    L32:
        if (r7 == null) goto L38;
        RoomStreamDataObject r8 = r34.getRoomStreamDataObject();     // Catch: Exception -> L243
        if (r8 == null) goto L36;
        JSONObject r11 = r8.getStreamDataObject();     // Catch: Exception -> L243
    L37:
        JSONObject r12 = r11;
        JSONObject r13 = null;
    L53:
        if (r13 == null) goto L55;
        boolean r14 = r13.optBoolean("PCDNDownloadEnabled");     // Catch: Exception -> L243
    L56:
        z90.a.C0301a.a(r0, "pcdn_download_enable", Boolean.valueOf(r14));     // Catch: Exception -> L243
        r35.add("pcdn_download_enable");     // Catch: Exception -> L243
        JSONObject r15 = (JSONObject) r1.element;     // Catch: Exception -> L243
        if (r15 == null) goto L60;
        String r16 = r15.optString("major_anchor_level");     // Catch: Exception -> L243
        if (r16 == null) goto L60;
    L61:
        z90.a.C0301a.a(r0, "major_anchor_level", r16);     // Catch: Exception -> L243
        r35.add("major_anchor_level");     // Catch: Exception -> L243
        if (r13 == null) goto L73;
        String r4 = r13.optString("SuggestFormatAndProtocol");     // Catch: Exception -> L243
        if (r4 == null) goto L73;
        if (r4.length() <= 0) goto L68;
        boolean r21 = true;
    L69:
        if (r21 == true) goto L72;
        r4 = null;
    L72:
        if (r4 == null) goto L73;
    L76:
        if (r4 != null) goto L78;
        r4 = r8;
    L78:
        JSONObject r33 = r13;
        if (StringsKt.contains$default(r4, "tcp", false, 2, null) == false) goto L82;
    L108:
        String r22 = "tcp";
    L109:
        z90.a.C0301a.a(r0, "suggest_protocol", r22);     // Catch: Exception -> L243
        r35.add("suggest_protocol");     // Catch: Exception -> L243
        r0.g("publish_point");     // Catch: Exception -> L243
        String[] r2 = c0.a.getValue().getPublishPointList();     // Catch: Exception -> L243
        if (r12 == null) goto L114;
        Iterator<String> r23 = r12.keys();     // Catch: Exception -> L243
        if (r23 == null) goto L114;
        String r25 = r23.next();     // Catch: Exception -> L243
    L115:
        if (r12 == null) goto L122;
        JSONObject r26 = r12.optJSONObject(r25);     // Catch: Exception -> L243
        if (r26 == null) goto L122;
        JSONObject r27 = r26.optJSONObject("main");     // Catch: Exception -> L243
        if (r27 == null) goto L122;
        String r28 = r27.optString("flv");     // Catch: Exception -> L243
        if (r28 == null) goto L122;
    L123:
        int r29 = r2.length;     // Catch: Exception -> L243
        int r31 = 0;
    L124:
        if (r31 >= r29) goto L129;
        String r32 = r2[r31];     // Catch: Exception -> L243
        Integer r110 = null;
        if (StringsKt.contains$default(r28, '/' + r32 + '/', false, 2, null) == true) goto L127;
        r31 = r31 + 1;     // Catch: Exception -> L243
        goto L124
    L127:
        z90.a.C0301a.a(FeatureManager.u, "publish_point", r32);     // Catch: Exception -> L243
        r35.add("publish_point");     // Catch: Exception -> L243
    L130:
        FeatureManager r3 = FeatureManager.u;     // Catch: Exception -> L243
        r3.g("stream_business_type");     // Catch: Exception -> L243
        String r36 = (String) r3.getFeature("publish_point", "");     // Catch: Exception -> L243
        if (r36 != null) goto L133;
    L136:
        boolean r37 = true;
    L137:
        if (r37 == true) goto L156;
        aa0.a r38 = i;     // Catch: Exception -> L243
        if (r38.a() == false) goto L156;
        String[] r39 = r38.b();     // Catch: Exception -> L243
        if (r39 != null) goto L144;
    L150:
        boolean r41 = true;
    L151:
        if (r41 == true) goto L156;
        String[] r42 = r38.b();     // Catch: Exception -> L243
        if (r42 == null) goto L156;
        boolean r43 = ArraysKt.contains(r42, r36);     // Catch: Exception -> L243
    L157:
        if (r43 == false) goto L170;
        Object r44 = r1.element;     // Catch: Exception -> L243
        if (((JSONObject) r44) == null) goto L170;
        String r45 = ((JSONObject) r44).optString("common_trace");     // Catch: Exception -> L243
        if (r45 != null) goto L164;
        r45 = "";
    L164:
        if (r45.length() <= 0) goto L166;
        boolean r46 = true;
    L167:
        if (r46 == false) goto L170;
        final String r47 = new JSONObject(r45).optString("BusinessType");     // Catch: Exception -> L243
        z90.a.C0301a.a(r3, "stream_business_type", r47);     // Catch: Exception -> L243
        boolean r48 = com.bytedance.android.live.impl.utils.a.a;     // Catch: Exception -> L243
        com.bytedance.android.live.impl.utils.a.a("AdSmartFeatureLog", new RoomService$handleStreamData$$inlined$let$lambda$1(r47, r1, r34, r35));     // Catch: Exception -> L243
        goto L170
    L166:
        r46 = false;
    L170:
        if (r12 == null) goto L176;
        Iterator<String> r49 = r12.keys();     // Catch: Exception -> L243
        if (r49 == null) goto L176;
    L174:
        if (r49.hasNext() == false) goto L176;
        String r51 = r49.next();     // Catch: Exception -> L243
        FeatureManager r52 = FeatureManager.u;     // Catch: Exception -> L243
        StringBuilder r53 = new StringBuilder();     // Catch: Exception -> L243
        String r54 = r17;
        r53.append(r54);     // Catch: Exception -> L243
        r53.append(r51);     // Catch: Exception -> L243
        z90.a.C0301a.a(r52, r53.toString(), r51);     // Catch: Exception -> L243
        r35.add(r54 + r51);     // Catch: Exception -> L243
        r17 = r54;
    L176:
        JSONObject r55 = StreamDataUtil.getSdkParamsObject$default(StreamDataUtil.INSTANCE, r6, r12, null, null, 12, null);     // Catch: Exception -> L243
        Result.Companion r56 = Result.Companion;     // Catch: Throwable -> L195
        if (r33 == null) goto L186;
        JSONObject r57 = r33;
    L193:
        th = th;
    L197:
        Result.Companion r58 = Result.Companion;     // Catch: Exception -> L243
        Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Exception -> L243
    L198:
        String r59 = StreamDataUtil.INSTANCE.getCdnName(r12);     // Catch: Exception -> L243
        if (r59 == null) goto L201;
        z90.a.C0301a.a(FeatureManager.u, "cdn_name", r59);     // Catch: Exception -> L243
        r35.add("cdn_name");     // Catch: Exception -> L243
    L201:
        IBaseStreamUrl r61 = r34.getStreamUrl();     // Catch: Exception -> L243
        if (r61 != null) goto L204;
    L205:
        IBaseStreamUrl r62 = r34.getStreamUrl();     // Catch: Exception -> L243
        if (r62 != null) goto L208;
    L214:
        String r63 = "stream_orientation";
        if (r12 == null) goto L240;
        Iterator<String> r64 = r12.keys();     // Catch: Exception -> L243
        if (r64 == null) goto L240;
        if (r64.hasNext() != true) goto L240;
        if (r57 != null) goto L224;
    L228:
        if (r55 == null) goto L233;
        String r65 = r55.optString("resolution");     // Catch: Exception -> L243
        if (r65 == null) goto L233;
    L232:
        String r66 = r65;
    L234:
        List r67 = StringsKt.split$default(r66, new String[]{"x"}, false, 0, 6, null);     // Catch: Exception -> L243
        if (r67.size() == 2) goto L237;
    L241:
        r35.add(r63);     // Catch: Exception -> L243
        return;
    L237:
        if (CastIntegerProtector.parseInt((String) ListProtector.get(r67, 0)) <= CastIntegerProtector.parseInt((String) ListProtector.get(r67, 1))) goto L239;
        z90.a.C0301a.a(FeatureManager.u, r63, 2);     // Catch: Exception -> L243
        goto L241
    L239:
        z90.a.C0301a.a(FeatureManager.u, r63, 1);     // Catch: Exception -> L243
    L233:
        r66 = "";
        goto L234
    L224:
        if (r57.has("resolution") != true) goto L228;
        r65 = r57.optString("resolution");     // Catch: Exception -> L243
        if (r65 != null) goto L232;
    L240:
        z90.a.C0301a.a(FeatureManager.u, r63, 0);     // Catch: Exception -> L243
        goto L241
    L208:
        if (r62.getStreamOrientation() != 2) goto L214;
    L209:
        FeatureManager r68 = FeatureManager.u;     // Catch: Exception -> L243
        IBaseStreamUrl r69 = r34.getStreamUrl();     // Catch: Exception -> L243
        if (r69 == null) goto L212;
        Integer r71 = Integer.valueOf(r69.getStreamOrientation());     // Catch: Exception -> L243
    L213:
        r63 = "stream_orientation";
        z90.a.C0301a.a(r68, r63, r71);     // Catch: Exception -> L243
        goto L241
    L212:
        r71 = r110;
        goto L213
    L204:
        if (r61.getStreamOrientation() == 1) goto L209;
    L182:
        if (r57.has("VR") != true) goto L187;
        JSONObject r72 = r57.optJSONObject("VR");     // Catch: Throwable -> L193
        if (r72 == null) goto L190;
        int r73 = JSONObjectProtectorUtils.getInt(r72, "FOV");     // Catch: Throwable -> L193
    L191:
        z90.a.C0301a.a(FeatureManager.u, "vr_fov", Integer.valueOf(r73));     // Catch: Throwable -> L193
        Result.constructor-impl(Boolean.valueOf(r35.add("vr_fov")));     // Catch: Throwable -> L193
    L190:
        r73 = -1;
    L187:
        JSONObject r74 = r55.optJSONObject("VR");     // Catch: Throwable -> L193
        if (r74 == null) goto L190;
        r73 = JSONObjectProtectorUtils.getInt(r74, "FOV");     // Catch: Throwable -> L193
        goto L191
    L186:
        r57 = r33;
    L195:
        th = th;
        r57 = r33;
        goto L197
    L144:
        if (r39.length != 0) goto L146;
        boolean r75 = true;
    L147:
        if (r75 == true) goto L150;
        r41 = false;
        goto L151
    L146:
        r75 = false;
    L156:
        r43 = false;
        goto L157
    L133:
        if (r36.length() == 0) goto L136;
        r37 = false;
        goto L137
    L129:
        r110 = null;
    L122:
        r28 = r6;
    L114:
        r25 = null;
        goto L115
    L82:
        if (StringsKt.contains$default(r4, "udpsdp", false, 2, null) == false) goto L85;
        r22 = "udpsdp";
        goto L109
    L85:
        if (StringsKt.contains$default(r4, "tls", false, 2, null) == false) goto L88;
        r22 = "tls";
        goto L109
    L88:
        if (StringsKt.contains$default(r4, "quicsdp", false, 2, null) == false) goto L91;
        r22 = "quicsdp";
        goto L109
    L91:
        if (StringsKt.contains$default(r4, "quicu", false, 2, null) == false) goto L94;
        r22 = "quicu";
        goto L109
    L94:
        if (StringsKt.contains$default(r4, "quic", false, 2, null) == false) goto L97;
        r22 = "quic";
        goto L109
    L97:
        if (StringsKt.contains$default(r4, "h2qu", false, 2, null) == true) goto L104;
        r9 = "h2q";
        if (StringsKt.contains$default(r4, r9, false, 2, null) == true) goto L104;
        r9 = "h2";
        if (StringsKt.contains$default(r4, r9, false, 2, null) == true) goto L104;
        r9 = "kcp";
        if (StringsKt.contains$default(r4, r9, false, 2, null) == false) goto L108;
    L104:
        r22 = r9;
        goto L109
    L68:
        r21 = false;
    L73:
        if (r13 == null) goto L75;
        r4 = r13.optString("SuggestProtocol");     // Catch: Exception -> L243
        goto L76
    L75:
        r4 = null;
    L60:
        r16 = r8;
        goto L61
    L55:
        r14 = false;
        goto L56
    L36:
        r11 = null;
        goto L37
    L31:
        r7 = null;
    L38:
        JSONObject r76 = StreamDataUtil.INSTANCE.getStreamDataObject(r6);     // Catch: Exception -> L243
        JSONObject r77 = r76.optJSONObject("data");     // Catch: Exception -> L243
        JSONObject r78 = r76.optJSONObject("common");     // Catch: Exception -> L243
        r1.element = r78;     // Catch: Exception -> L243
        if (r78 == null) goto L51;
        JSONObject r79 = r78.optJSONObject("common_sdk_params");     // Catch: Exception -> L243
        if (r79 == null) goto L44;
        String r81 = r79.optString("main");     // Catch: Exception -> L243
        if (r81 == null) goto L44;
    L46:
        if (r81.length() <= 0) goto L48;
        boolean r82 = true;
    L49:
        if (r82 == false) goto L51;
        JSONObject r83 = new JSONObject(r81);     // Catch: Exception -> L243
    L52:
        r13 = r83;
        r12 = r77;
        goto L53
    L48:
        r82 = false;
    L44:
        r81 = "";
    L51:
        r83 = null;
    L256:
        return;
    L255:
        return;
    L23:
        r24 = false;
        goto L24
    L253:
        return;
    L8:
        if (r18.length() == 0) goto L11;
        r19 = false;
        goto L13
    L5:
        r18 = null;
        goto L6
    }
}
