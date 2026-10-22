package com.bytedance.android.live.impl.logInterceptor;

import am2.x;
import android.text.TextUtils;
import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.live.impl.service.FeatureManager;
import com.bytedance.android.livehostapi.IMiddleHostService;
import com.bytedance.android.livehostapi.TTMiddlewareLiveSDK;
import com.bytedance.android.livehostapi.platform.IMiddlewareHostAction;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import j40.t2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class ShuffleSequenceInterceptor implements IMiddlewareHostAction.IShuffleSequenceCallback, IMiddlewareHostAction.ILiveSequenceItemProvider {
    public static final Map<Pair<String, String>, Map<String, Object>> a = null;
    public static final Map<String, String> b = null;
    public static final Map<String, Integer> c = null;
    public static final Map<String, Integer> d = null;
    public static final Map<String, Long> e = null;
    public static final List<String> f = null;
    public static volatile Map<String, Long> g;
    public static final boolean h = false;
    public static final List<String> i = null;
    public static final Map<String, String> j = null;
    public static final boolean k = false;
    public static final ShuffleSequenceInterceptor l = null;

    public ShuffleSequenceInterceptor() {
    }

    static {
        l = new ShuffleSequenceInterceptor();
        a = new HashMap();
        b = new HashMap();
        c = new HashMap();
        d = new HashMap();
        e = new HashMap();
        Map r0 = t2.a.getValue().getLiveRecommendInfosMap();
        Set r1 = null;
        if (r0 == null) goto L11;
        LinkedHashMap r2 = new LinkedHashMap();
        Iterator r3 = r0.entrySet().iterator();
    L6:
        if (r3.hasNext() == false) goto L10;
        Map.Entry r4 = (Map.Entry) r3.next();
        if (((Boolean) r4.getValue()).booleanValue() == false) goto L6;
        r2.put(r4.getKey(), r4.getValue());
        goto L6
    L10:
        Set r5 = r2.keySet();
    L12:
        if (r5 == null) goto L15;
        List<String> r6 = CollectionsKt.toList(r5);
        if (r6 == null) goto L15;
    L16:
        f = r6;
        g = new HashMap();
        t2 r7 = t2.a;
        h = r7.getValue().getEnableFixLivePreviewTimeSum();
        Map r8 = r7.getValue().getLiveFeatureMap();
        if (r8 == null) goto L25;
        LinkedHashMap r9 = new LinkedHashMap();
        Iterator r11 = r8.entrySet().iterator();
    L20:
        if (r11.hasNext() == false) goto L24;
        Map.Entry r12 = (Map.Entry) r11.next();
        if (((Boolean) r12.getValue()).booleanValue() == false) goto L20;
        r9.put(r12.getKey(), r12.getValue());
        goto L20
    L24:
        r1 = r9.keySet();
    L25:
        if (r1 == null) goto L28;
        List<String> r13 = CollectionsKt.toMutableList(r1);
        if (r13 == null) goto L28;
    L29:
        i = r13;
        t2 r14 = t2.a;
        Map<String, String> r15 = r14.getValue().getLiveFeatureManagerFeaturesMap();
        if (r15 != null) goto L32;
        r15 = MapsKt.emptyMap();
    L32:
        j = r15;
        k = r14.getValue().getDisableResetFeatureMap();
        return;
    L28:
        r13 = new ArrayList();
    L15:
        r6 = CollectionsKt.emptyList();
        goto L16
    L11:
        r5 = null;
        goto L12
    }

    public static boolean c() {
        return !((Boolean) FeatureManager.u.getFeature("enter_inner_live_scene", Boolean.FALSE)).booleanValue();
    }

    public static Map g() {
        return MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("previewRoomId", ""), TuplesKt.to("liveAnchorId", ""), TuplesKt.to("livePreviewDuration", 0L), TuplesKt.to("liveFirstInnerDuration", 0L), TuplesKt.to("liveInnerDuration", 0L), TuplesKt.to("liveDislikeCnt", 0), TuplesKt.to("liveReportCnt", 0), TuplesKt.to("liveFollowCnt", 0), TuplesKt.to("giftDiamond", 0), TuplesKt.to("enterInnerFromPreview", Boolean.FALSE), TuplesKt.to("drawToNext", 0), TuplesKt.to("enterCurPreviewMs", 0L), TuplesKt.to("enterFromMerge", ""), TuplesKt.to("live_time_gap", 0L), TuplesKt.to("live_duration", 0L), TuplesKt.to("live_window_stay_duration", 0L), TuplesKt.to("live_show_time", 0L), TuplesKt.to("room_type", 0), TuplesKt.to("live_preview_enter_duration", "-1"), TuplesKt.to("live_preview_is_no_stream", "-1"), TuplesKt.to("live_inner_first_room_duration", "-1"), TuplesKt.to("live_inner_first_room_is_no_stream", "-1"), TuplesKt.to("live_download_speed", "-1")});
    }

    public static boolean d(Map r2) {
        if (r2 != null) goto L5;
        return false;
    L5:
        Pair r3 = TuplesKt.to(String.valueOf(r2.get("room_id")), String.valueOf(r2.get("enter_from_merge")));
        return ((HashMap) a).keySet().contains(r3);
    }

    public final Map<Object, Object> onGetFeatureSequence(final String r11) {
        String r0 = (String) FeatureManager.u.getFeature("preview_enter_from_merge", "");
        Pair r1 = TuplesKt.to(r11, r0);
        boolean r2 = com.bytedance.android.live.impl.utils.a.a;
        com.bytedance.android.live.impl.utils.a.a("LFM-ShuffleSequenceInterceptor", new C03201(r11));
        if (r11 != null) goto L5;
    L20:
        com.bytedance.android.live.impl.utils.a.d("LFM-ShuffleSequenceInterceptor", AnonymousClass4.INSTANCE);
        return null;
    L5:
        if (CollectionsKt.contains(((HashMap) a).keySet(), r1) == false) goto L20;
        final LinkedHashMap r8 = new LinkedHashMap();
        long r4 = b(r11, r0, false);
        Iterator<String> r3 = i.iterator();
    L8:
        if (r3.hasNext() == false) goto L15;
        String r5 = r3.next();
        if (TextUtils.equals("live_preview_time_sum", r5) == false) goto L11;
        r8.put("live_preview_time_sum", Long.valueOf(r4));
        goto L8
    L11:
        Object r6 = a(r0, r5, r11, false);
        if (r6 == null) goto L8;
        r8.put(r5, r6);
        goto L8
    L15:
        e(r8, r0, r11, r4, "v1");
        boolean r7 = com.bytedance.android.live.impl.utils.a.a;
        com.bytedance.android.live.impl.utils.a.a("LFM-ShuffleSequenceInterceptor", new C03213(r8));
        if (k == true) goto L19;
        Map<Pair<String, String>, Map<String, Object>> r9 = a;
        HashMap r12 = (HashMap) r9;
        r12.remove(new Pair(r11, r0));
        ((HashMap) c).remove(r11);
    L19:
        return r8;
    }

    public static void f(String r22, final Map r23) {
        if (r22 == null) goto L498;
        long r17 = 0;
        Object r19 = null;
        Object r21 = "enterCurPreviewMs";
        switch(r22.hashCode()) {
            case -1886261773: goto L408;
            case -1128063126: goto L372;
            case -1115849514: goto L300;
            case -1103263308: goto L268;
            case -804282046: goto L247;
            case -773966155: goto L245;
            case -505186085: goto L226;
            case -74476671: goto L194;
            case 228634976: goto L157;
            case 516631638: goto L124;
            case 1059589542: goto L97;
            case 1499265855: goto L12;
            case 1763681274: goto L9;
            default: goto L499;
        };
    L245:
        r22.equals("livesdk_live_leave");
        return;
    L499:
        return;
    L9:
        if (r22.equals("livesdk_live_window_duration_v2") == true) goto L410;
        return;
    L410:
        if (TextUtils.equals(r22, "livesdk_live_window_duration_v2") == false) goto L416;
        if (r23 == null) goto L414;
        r19 = r23.get("next_action");
    L414:
        if (TextUtils.equals(GamePromoteDataContext.ENTER, String.valueOf(r19)) == true) goto L416;
        return;
    L416:
        if (r23 == null) goto L496;
        Object r0 = r23.get("room_id");
        if (r0 == null) goto L497;
        Object r2 = r23.get("enter_from_merge");
        if (r2 == null) goto L423;
        String r3 = r2.toString();
        if (r3 == null) goto L423;
    L424:
        Pair r1 = TuplesKt.to(r0.toString(), r3);
        HashMap r4 = (HashMap) a;
        if (r4.keySet().contains(r1) == false) goto L432;
        Map r5 = (Map) r4.get(r1);
        if (r5 == null) goto L429;
        r5.put("enterInnerFromPreview", Boolean.TRUE);
    L429:
        Map r6 = (Map) r4.get(r1);
        if (r6 == null) goto L432;
        r6.put("liveAnchorId", String.valueOf(r23.get("anchor_id")));
    L432:
        Unit r7 = Unit.INSTANCE;
        return;
    L423:
        r3 = "";
        goto L424
    L497:
        return;
    L496:
        return;
    L12:
        if (r22.equals("livesdk_live_show") == false) goto L447;
        if (r23 == null) goto L448;
        Object r8 = r23.get("room_id");
        if (r8 == null) goto L449;
        HashMap r9 = (HashMap) c;
        Integer r11 = (Integer) r9.get(r8.toString());
        if (r11 == null) goto L19;
        int r12 = r11.intValue();
    L20:
        int r13 = 2;
        if (r12 == 2) goto L23;
        if (r12 == 0) goto L23;
    L28:
        Object r14 = r23.get("live_gap_info_time");
        if (r14 == null) goto L41;
        Long r15 = StringsKt.toLongOrNull(r14.toString());
        if (r15 == null) goto L33;
        long r16 = r15.longValue();
    L35:
        if (r16 <= 0) goto L40;
        Map<String, Long> r18 = e;
        String r24 = r8.toString();
        Long r25 = StringsKt.toLongOrNull(r14.toString());
        if (r25 == null) goto L39;
        r17 = r25.longValue();
    L39:
        ((HashMap) r18).put(r24, Long.valueOf(r17));
    L40:
        Unit r26 = Unit.INSTANCE;
        goto L41
    L33:
        r16 = 0;
    L41:
        Object r27 = r23.get("enter_from_merge");
        if (r27 == null) goto L45;
        String r28 = r27.toString();
        if (r28 == null) goto L45;
    L46:
        Pair r29 = TuplesKt.to(r8.toString(), r28);
        HashMap r31 = (HashMap) a;
        if (r31.keySet().contains(r29) == true) goto L56;
        l.getClass();
        if (TextUtils.equals(String.valueOf(r23.get("enter_method")), "live_cell") == true) goto L51;
    L53:
        boolean r32 = false;
    L54:
        if (r32 == false) goto L56;
        r31.put(r29, g());
        goto L56
    L51:
        if (TextUtils.equals(String.valueOf(r23.get("action_type")), "draw") == true) goto L53;
        r32 = true;
    L56:
        Object r33 = r23.get("live_recommend_info");
        if (r33 != null) goto L59;
    L74:
        Object r34 = r23.get("live_room_type");
        if (r34 == null) goto L84;
        Map r35 = (Map) ((HashMap) a).get(r29);
        if (r35 == null) goto L84;
        Integer r36 = StringsKt.toIntOrNull(r34.toString());
        if (r36 == null) goto L81;
        int r37 = r36.intValue();
    L82:
        r35.put("room_type", Integer.valueOf(r37));
        goto L84
    L81:
        r37 = 0;
    L84:
        if (Intrinsics.areEqual(r23.get("enter_method"), "live_cell") == true) goto L86;
    L95:
        Unit r38 = Unit.INSTANCE;
        return;
    L86:
        if (Intrinsics.areEqual(r23.get("action_type"), "click") == false) goto L95;
        HashMap r39 = (HashMap) a;
        Map r41 = (Map) r39.get(r29);
        if (r41 == null) goto L91;
        r19 = r41.get("live_preview_is_no_stream");
    L91:
        if (Intrinsics.areEqual(r19, "-1") == false) goto L95;
        Map r42 = (Map) r39.get(r29);
        if (r42 == null) goto L95;
        r42.put("live_preview_is_no_stream", GamePromoteDataContext.GAME_TYPE_MOBILE);
        goto L95
    L59:
        if (StringsKt.isBlank(r33.toString()) == false) goto L434;
    L73:
        Unit r43 = Unit.INSTANCE;
        goto L74
    L434:
        Result.Companion r44 = Result.Companion;     // Catch: Throwable -> L71
        JSONObject r45 = new JSONObject(r33.toString());     // Catch: Throwable -> L71
        Iterator<String> r46 = f.iterator();     // Catch: Throwable -> L71
    L63:
        if (r46.hasNext() == false) goto L69;
        String r47 = r46.next();     // Catch: Throwable -> L71
        Object r48 = r45.opt(r47);     // Catch: Throwable -> L71
        if (r48 == null) goto L63;
        Map r49 = (Map) ((HashMap) a).get(r29);     // Catch: Throwable -> L71
        if (r49 == null) goto L63;
        r49.put(r47, r48.toString());     // Catch: Throwable -> L71
        goto L63
    L69:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L71
    L71:
        th = move-exception;
        Result.Companion r51 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L45:
        r28 = "";
    L23:
        String r52 = r8.toString();
        if (TextUtils.equals(String.valueOf(r23.get("is_fans")), GamePromoteDataContext.GAME_TYPE_MOBILE) == true) goto L27;
        r13 = 0;
    L27:
        r9.put(r52, Integer.valueOf(r13));
        goto L28
    L19:
        r12 = 0;
        goto L20
    L449:
        return;
    L448:
        return;
    L447:
        return;
    L97:
        if (r22.equals("livesdk_live_user_report") == true) goto L99;
        return;
    L99:
        if (c() == false) goto L101;
    L102:
        if (r23 == null) goto L453;
        Object r53 = r23.get("room_id");
        if (r53 == null) goto L454;
        Object r54 = r23.get("enter_from_merge");
        if (r54 == null) goto L109;
        String r55 = r54.toString();
        if (r55 == null) goto L109;
    L110:
        Pair r56 = TuplesKt.to(r53.toString(), r55);
        HashMap r57 = (HashMap) a;
        if (r57.keySet().contains(r56) == false) goto L122;
        Map r58 = (Map) r57.get(r56);
        if (r58 == null) goto L122;
        Map r59 = (Map) r57.get(r56);
        if (r59 == null) goto L117;
        r19 = r59.get("liveReportCnt");
    L117:
        Integer r61 = StringsKt.toIntOrNull(String.valueOf(r19));
        if (r61 == null) goto L120;
        int r62 = r61.intValue();
        int r63 = 1;
    L121:
        r58.put("liveReportCnt", Integer.valueOf(r62 + r63));
        goto L122
    L120:
        r63 = 1;
        r62 = 0;
    L122:
        Unit r64 = Unit.INSTANCE;
        return;
    L109:
        r55 = "";
        goto L110
    L454:
        return;
    L453:
        return;
    L101:
        if (d(r23) == true) goto L102;
        return;
    L124:
        if (r22.equals("livesdk_send_gift") == true) goto L126;
        return;
    L126:
        if (c() == false) goto L128;
    L129:
        if (r23 == null) goto L458;
        Object r65 = r23.get("room_id");
        if (r65 == null) goto L459;
        Object r66 = r23.get("enter_from_merge");
        if (r66 == null) goto L136;
        String r67 = r66.toString();
        if (r67 == null) goto L136;
    L137:
        Pair r68 = TuplesKt.to(r65.toString(), r67);
        HashMap r69 = (HashMap) a;
        if (r69.keySet().contains(r68) == false) goto L155;
        Object r71 = r23.get("money");
        if (r71 == null) goto L155;
        Map r72 = (Map) r69.get(r68);
        if (r72 == null) goto L155;
        Map r73 = (Map) r69.get(r68);
        if (r73 == null) goto L146;
        r19 = r73.get("giftDiamond");
    L146:
        Integer r74 = StringsKt.toIntOrNull(String.valueOf(r19));
        if (r74 == null) goto L149;
        int r75 = r74.intValue();
    L150:
        Integer r76 = StringsKt.toIntOrNull(r71.toString());
        if (r76 == null) goto L153;
        int r77 = r76.intValue();
    L154:
        r72.put("giftDiamond", Integer.valueOf(r75 + r77));
        goto L155
    L153:
        r77 = 0;
        goto L154
    L149:
        r75 = 0;
    L155:
        Unit r78 = Unit.INSTANCE;
        return;
    L136:
        r67 = "";
        goto L137
    L459:
        return;
    L458:
        return;
    L128:
        if (d(r23) == true) goto L129;
        return;
    L157:
        if (r22.equals("livesdk_enter_room_duration") == false) goto L461;
        boolean r79 = com.bytedance.android.live.impl.utils.a.a;
        com.bytedance.android.live.impl.utils.a.a("LFM-ShuffleSequenceInterceptor", ShuffleSequenceInterceptor$onEnqueue$11.INSTANCE);
        if (c() == false) goto L161;
    L162:
        if (r23 == null) goto L463;
        Object r81 = r23.get("room_id");
        if (r81 == null) goto L464;
        Object r82 = r23.get("enter_from_merge");
        if (r82 == null) goto L169;
        String r83 = r82.toString();
        if (r83 == null) goto L169;
    L170:
        final Pair r84 = TuplesKt.to(r81.toString(), r83);
        String r85 = String.valueOf(r23.get("scene_type"));
        String r86 = String.valueOf(r23.get("action_type"));
        if (Intrinsics.areEqual(r85, GamePromoteDataContext.GAME_TYPE_MOBILE) == false) goto L181;
        com.bytedance.android.live.impl.utils.a.a("LFM-ShuffleSequenceInterceptor", new ShuffleSequenceInterceptor$onEnqueue$$inlined$let$lambda$1(r84, r23));
        HashMap r87 = (HashMap) a;
        if (r87.keySet().contains(r84) == false) goto L192;
        Map r88 = (Map) r87.get(r84);
        if (r88 == null) goto L177;
        r88.put("live_preview_enter_duration", String.valueOf(r23.get("duration")));
    L177:
        Map r89 = (Map) r87.get(r84);
        if (r89 == null) goto L192;
        r89.put("live_preview_is_no_stream", "0");
    L192:
        Unit r91 = Unit.INSTANCE;
        return;
    L181:
        if (Intrinsics.areEqual(r85, "0") == false) goto L192;
        if (Intrinsics.areEqual(r86, "click") == false) goto L192;
        HashMap r92 = (HashMap) a;
        if (r92.keySet().contains(r84) == false) goto L192;
        com.bytedance.android.live.impl.utils.a.a("LFM-ShuffleSequenceInterceptor", new ShuffleSequenceInterceptor$onEnqueue$$inlined$let$lambda$2(r23));
        Map r93 = (Map) r92.get(r84);
        if (r93 == null) goto L189;
        r93.put("live_inner_first_room_duration", String.valueOf(r23.get("duration")));
    L189:
        Map r94 = (Map) r92.get(r84);
        if (r94 == null) goto L192;
        r94.put("live_inner_first_room_is_no_stream", "0");
    L169:
        r83 = "";
        goto L170
    L464:
        return;
    L463:
        return;
    L161:
        if (d(r23) == true) goto L162;
        return;
    L461:
        return;
    L194:
        if (r22.equals("livesdk_live_window_duration") == false) goto L466;
        if (r23 == null) goto L197;
        Object r95 = r23.get("duration");
    L198:
        Long r96 = StringsKt.toLongOrNull(String.valueOf(r95));
        if (r96 == null) goto L201;
        r17 = r96.longValue();
    L201:
        if (r23 == null) goto L467;
        Object r97 = r23.get("room_id");
        if (r97 == null) goto L468;
        Object r98 = r23.get("anchor_id");
        if (r98 == null) goto L207;
        String r99 = (String) ((HashMap) b).put(r98.toString(), r97.toString());
    L207:
        Object r100 = r23.get("enter_from_merge");
        if (r100 == null) goto L211;
        String r101 = r100.toString();
        if (r101 == null) goto L211;
    L212:
        Pair r102 = TuplesKt.to(r97.toString(), r101);
        HashMap r103 = (HashMap) a;
        if (r103.keySet().contains(r102) == false) goto L224;
        Map r104 = (Map) r103.get(r102);
        if (r104 == null) goto L224;
        Map r105 = (Map) r103.get(r102);
        if (r105 == null) goto L219;
        r19 = r105.get("livePreviewDuration");
    L219:
        Integer r106 = StringsKt.toIntOrNull(String.valueOf(r19));
        if (r106 == null) goto L222;
        int r107 = r106.intValue();
    L223:
        r104.put("livePreviewDuration", Long.valueOf(r17 + ((long) r107)));
        goto L224
    L222:
        r107 = 0;
    L224:
        Unit r108 = Unit.INSTANCE;
        return;
    L211:
        r101 = "";
        goto L212
    L468:
        return;
    L467:
        return;
    L197:
        r95 = null;
        goto L198
    L466:
        return;
    L226:
        if (r22.equals("livesdk_unfollow") == true) goto L228;
        return;
    L228:
        if (c() == false) goto L230;
    L231:
        if (r23 == null) goto L472;
        Object r109 = r23.get("room_id");
        if (r109 == null) goto L473;
        Object r110 = r23.get("enter_from_merge");
        if (r110 == null) goto L238;
        String r111 = r110.toString();
        if (r111 == null) goto L238;
    L239:
        Pair r112 = TuplesKt.to(r109.toString(), r111);
        HashMap r113 = (HashMap) a;
        if (r113.keySet().contains(r112) == false) goto L244;
        Map r114 = (Map) r113.get(r112);
        if (r114 == null) goto L244;
        r114.put("liveFollowCnt", 3);
    L244:
        Integer r115 = (Integer) ((HashMap) c).put(r109.toString(), 3);
        return;
    L238:
        r111 = "";
        goto L239
    L473:
        return;
    L472:
        return;
    L230:
        if (d(r23) == true) goto L231;
        return;
    L247:
        if (r22.equals("livesdk_follow") == true) goto L249;
        return;
    L249:
        if (c() == false) goto L251;
    L252:
        if (r23 == null) goto L478;
        Object r116 = r23.get("room_id");
        if (r116 == null) goto L479;
        Object r117 = r23.get("enter_from_merge");
        if (r117 == null) goto L259;
        String r118 = r117.toString();
        if (r118 == null) goto L259;
    L260:
        Pair r119 = TuplesKt.to(r116.toString(), r118);
        HashMap r120 = (HashMap) a;
        if (r120.keySet().contains(r119) == false) goto L265;
        Map r121 = (Map) r120.get(r119);
        if (r121 == null) goto L265;
        int r122 = 1;
        r121.put("liveFollowCnt", 1);
    L266:
        Integer r123 = (Integer) ((HashMap) c).put(r116.toString(), Integer.valueOf(r122));
        return;
    L265:
        r122 = 1;
    L259:
        r118 = "";
        goto L260
    L479:
        return;
    L478:
        return;
    L251:
        if (d(r23) == true) goto L252;
        return;
    L268:
        if (r22.equals("livesdk_dislike") == true) goto L270;
        return;
    L270:
        if (c() == false) goto L272;
    L273:
        if (r23 == null) goto L483;
        Object r124 = r23.get("room_id");
        if (r124 == null) goto L484;
        Object r125 = r23.get("enter_from_merge");
        if (r125 == null) goto L280;
        String r126 = r125.toString();
        if (r126 == null) goto L280;
    L281:
        Pair r127 = TuplesKt.to(r124.toString(), r126);
        HashMap r128 = (HashMap) a;
        if (r128.keySet().contains(r127) == true) goto L284;
    L298:
        Unit r129 = Unit.INSTANCE;
        return;
    L284:
        if (r23.get("dislike_type") == null) goto L286;
        boolean r130 = true;
    L287:
        if (r130 == false) goto L298;
        Map r131 = (Map) r128.get(r127);
        if (r131 == null) goto L298;
        Map r132 = (Map) r128.get(r127);
        if (r132 == null) goto L293;
        r19 = r132.get("liveDislikeCnt");
    L293:
        Integer r133 = StringsKt.toIntOrNull(String.valueOf(r19));
        if (r133 == null) goto L296;
        int r134 = r133.intValue();
        int r135 = 1;
    L297:
        r131.put("liveDislikeCnt", Integer.valueOf(r134 + r135));
        goto L298
    L296:
        r135 = 1;
        r134 = 0;
        goto L297
    L286:
        r130 = false;
    L280:
        r126 = "";
        goto L281
    L484:
        return;
    L483:
        return;
    L272:
        if (d(r23) == true) goto L273;
        return;
    L300:
        if (r22.equals("livesdk_live_duration") == false) goto L486;
        if (r23 == null) goto L487;
        Object r136 = r23.get("enter_from_merge");
        if (r136 == null) goto L488;
        Iterator r137 = ((HashMap) a).keySet().iterator();
    L306:
        if (r137.hasNext() == false) goto L370;
        Pair r138 = (Pair) r137.next();
        if (TextUtils.equals((CharSequence) r138.getSecond(), r136.toString()) == false) goto L367;
        HashMap r139 = (HashMap) a;
        Map r140 = (Map) r139.get(r138);
        if (r140 == null) goto L312;
        Object r141 = r140.get("enterInnerFromPreview");
    L314:
        if (TextUtils.equals(String.valueOf(r141), String.valueOf(true)) == false) goto L316;
    L319:
        Map r142 = (Map) r139.get(r138);
        if (r142 == null) goto L322;
        Object r143 = r142.get("liveFirstInnerDuration");
    L323:
        Long r144 = StringsKt.toLongOrNull(String.valueOf(r143));
        if (r144 == null) goto L326;
        long r145 = r144.longValue();
    L328:
        if (r145 != 0) goto L344;
        Map r146 = (Map) r139.get(r138);
        if (r146 == null) goto L344;
        Map r147 = (Map) r139.get(r138);
        if (r147 == null) goto L334;
        Object r148 = r147.get("liveFirstInnerDuration");
    L335:
        Long r149 = StringsKt.toLongOrNull(String.valueOf(r148));
        if (r149 == null) goto L338;
        long r150 = r149.longValue();
    L339:
        Long r151 = StringsKt.toLongOrNull(String.valueOf(r23.get("duration")));
        if (r151 == null) goto L342;
        long r152 = r151.longValue();
    L343:
        r146.put("liveFirstInnerDuration", Long.valueOf(r150 + r152));
        goto L344
    L342:
        r152 = 0;
        goto L343
    L338:
        r150 = 0;
        goto L339
    L334:
        r148 = null;
    L344:
        Map r153 = (Map) r139.get(r138);
        if (r153 == null) goto L359;
        Map r154 = (Map) r139.get(r138);
        if (r154 == null) goto L349;
        Object r155 = r154.get("liveInnerDuration");
    L350:
        Long r156 = StringsKt.toLongOrNull(String.valueOf(r155));
        if (r156 == null) goto L353;
        long r157 = r156.longValue();
    L354:
        Long r158 = StringsKt.toLongOrNull(String.valueOf(r23.get("duration")));
        if (r158 == null) goto L357;
        long r159 = r158.longValue();
    L358:
        r153.put("liveInnerDuration", Long.valueOf(r157 + r159));
        goto L359
    L357:
        r159 = 0;
        goto L358
    L353:
        r157 = 0;
        goto L354
    L349:
        r155 = null;
    L359:
        Map r160 = (Map) r139.get(r138);
        if (r160 != null) goto L361;
    L318:
        Object r161 = r21;
    L363:
        if (TextUtils.equals((CharSequence) r138.getFirst(), String.valueOf(r23.get("room_id"))) == true) goto L369;
        Map r162 = (Map) r139.get(r138);
        if (r162 == null) goto L369;
        r162.put("drawToNext", 1);
    L369:
        r21 = r161;
        goto L306
    L361:
        r161 = r21;
        r160.put(r161, Long.valueOf(System.currentTimeMillis()));
        goto L363
    L326:
        r145 = 0;
        goto L328
    L322:
        r143 = null;
        goto L323
    L316:
        if (TextUtils.equals(String.valueOf(r23.get("enter_method")), "live_cell") == false) goto L318;
    L312:
        r141 = null;
        goto L314
    L367:
        r161 = r21;
        goto L369
    L370:
        Unit r163 = Unit.INSTANCE;
        return;
    L488:
        return;
    L487:
        return;
    L486:
        return;
    L372:
        if (r22.equals("livesdk_live_window_show") == false) goto L490;
        if (r23 == null) goto L491;
        Object r164 = r23.get("room_id");
        if (r164 == null) goto L492;
        Object r165 = r23.get("anchor_id");
        if (r165 == null) goto L379;
        String r166 = (String) ((HashMap) b).put(r165.toString(), r164.toString());
    L379:
        Object r167 = r23.get("enter_from_merge");
        if (r167 == null) goto L383;
        String r168 = r167.toString();
        if (r168 == null) goto L383;
    L384:
        Pair r169 = TuplesKt.to(r164.toString(), r168);
        HashMap r170 = (HashMap) a;
        if (r170.keySet().contains(r169) == true) goto L387;
        l.getClass();
        r170.put(r169, g());
    L387:
        Map r171 = (Map) r170.get(r169);
        if (r171 == null) goto L390;
        r171.put("previewRoomId", r164.toString());
    L390:
        Map r172 = (Map) r170.get(r169);
        if (r172 == null) goto L393;
        r172.put(r21, Long.valueOf(System.currentTimeMillis()));
    L393:
        Map r173 = (Map) r170.get(r169);
        if (r173 == null) goto L399;
        Object r174 = r23.get("enter_from_merge");
        if (r174 != null) goto L398;
        r174 = "";
    L398:
        r173.put("enterFromMerge", r174);
    L399:
        FeatureManager r175 = FeatureManager.u;
        Object r176 = r23.get("enter_from_merge");
        if (r176 == null) goto L403;
        String r177 = r176.toString();
        if (r177 == null) goto L403;
    L404:
        z90.a.C0301a.a(r175, "preview_enter_from_merge", r177);
        Map r178 = (Map) r170.get(r169);
        if (r178 == null) goto L493;
        r178.put("live_show_time", Long.valueOf(System.currentTimeMillis()));
        return;
    L493:
        return;
    L403:
        r177 = "";
    L383:
        r168 = "";
        goto L384
    L492:
        return;
    L491:
        return;
    L490:
        return;
    L408:
        if (r22.equals("livesdk_live_window_cover_click") == true) goto L410;
        return;
    }

    public static long b(String r13, String r14, boolean r15) {
        long r0 = 0;
        if (r13 != null) goto L5;
        return 0;
    L5:
        HashMap r2 = (HashMap) a;
        if (r2.keySet().contains(new Pair(r13, r14)) == false) goto L41;
        Map r3 = (Map) r2.get(new Pair(r13, r14));
        if (r3 == null) goto L16;
        Object r4 = r3.get("enterCurPreviewMs");
        if (r4 == null) goto L16;
        String r5 = r4.toString();
        if (r5 == null) goto L16;
        Long r6 = StringsKt.toLongOrNull(r5);
        if (r6 == null) goto L16;
        long r7 = r6.longValue();
    L18:
        if (h == true) goto L20;
    L22:
        long r8 = System.currentTimeMillis() - r7;
        Map r9 = (Map) r2.get(new Pair(r13, r14));
        if (r9 == null) goto L31;
        Object r11 = r9.get("livePreviewDuration");
        if (r11 == null) goto L31;
        String r12 = r11.toString();
        if (r12 == null) goto L31;
        Long r16 = StringsKt.toLongOrNull(r12);
        if (r16 == null) goto L31;
        long r17 = r16.longValue();
    L32:
        long r18 = r8 + r17;
        if (r15 == false) goto L40;
        long r19 = System.currentTimeMillis();
        Long r110 = (Long) ((HashMap) g).get(r13);
        if (r110 == null) goto L38;
        r0 = r110.longValue();
    L38:
        if ((r19 - r0) < 500) goto L40;
        e(null, r14, r13, r18, "v2");
        ((HashMap) g).put(r13, Long.valueOf(System.currentTimeMillis()));
    L40:
        return r18;
    L31:
        r17 = 0;
        goto L32
    L20:
        if (r7 > 0) goto L22;
        r7 = System.currentTimeMillis();
    L16:
        r7 = 0;
        goto L18
    L41:
        return 0;
    }

    public static Object a(final String r6, final String r7, final String r8, final boolean r9) {
        boolean r0 = com.bytedance.android.live.impl.utils.a.a;
        com.bytedance.android.live.impl.utils.a.a("LFM-ShuffleSequenceInterceptor", new ShuffleSequenceInterceptor$getFeature$1(r6, r7, r8, r9));
        Pair r1 = TuplesKt.to(r8, r6);
        Map<Pair<String, String>, Map<String, Object>> r2 = a;
        if (r2 == null) goto L164;
        HashMap r3 = (HashMap) r2;
        Object r4 = null;
        if (r3.containsKey(r1) == true) goto L8;
        return null;
    L8:
        if (Intrinsics.areEqual(r7, "live_preview_time_sum") == true) goto L165;
        long r5 = 0;
        if (Intrinsics.areEqual(r7, "live_first_inner_time_sum") == false) goto L13;
    L155:
        Map r11 = (Map) r3.get(r1);
        if (r11 == null) goto L158;
        r4 = r11.get("liveFirstInnerDuration");
    L158:
        Long r12 = StringsKt.toLongOrNull(String.valueOf(r4));
        if (r12 == null) goto L162;
        r5 = r12.longValue();
    L162:
        return Long.valueOf(r5);
    L13:
        if (Intrinsics.areEqual(r7, "live_duration") == true) goto L155;
        if (Intrinsics.areEqual(r7, "live_inner_time_sum") == false) goto L24;
        Map r13 = (Map) r3.get(r1);
        if (r13 == null) goto L20;
        r4 = r13.get("liveInnerDuration");
    L20:
        Long r14 = StringsKt.toLongOrNull(String.valueOf(r4));
        if (r14 == null) goto L166;
        r5 = r14.longValue();
    L166:
        return Long.valueOf(r5);
    L24:
        int r15 = 0;
        if (Intrinsics.areEqual(r7, "live_dislike") == false) goto L34;
        Map r16 = (Map) r3.get(r1);
        if (r16 == null) goto L29;
        r4 = r16.get("liveDislikeCnt");
    L29:
        Integer r17 = StringsKt.toIntOrNull(String.valueOf(r4));
        if (r17 == null) goto L167;
        r15 = r17.intValue();
    L167:
        return Integer.valueOf(r15);
    L34:
        if (Intrinsics.areEqual(r7, "live_user_report") == false) goto L43;
        Map r18 = (Map) r3.get(r1);
        if (r18 == null) goto L38;
        r4 = r18.get("liveReportCnt");
    L38:
        Integer r19 = StringsKt.toIntOrNull(String.valueOf(r4));
        if (r19 == null) goto L168;
        r15 = r19.intValue();
    L168:
        return Integer.valueOf(r15);
    L43:
        if (Intrinsics.areEqual(r7, "live_follow") == false) goto L49;
        Integer r21 = (Integer) ((HashMap) c).get(r8);
        if (r21 == null) goto L169;
        r15 = r21.intValue();
    L169:
        return Integer.valueOf(r15);
    L49:
        if (Intrinsics.areEqual(r7, "live_gift_diamond") == false) goto L58;
        Map r22 = (Map) r3.get(r1);
        if (r22 == null) goto L53;
        r4 = r22.get("giftDiamond");
    L53:
        Integer r23 = StringsKt.toIntOrNull(String.valueOf(r4));
        if (r23 == null) goto L170;
        r15 = r23.intValue();
    L170:
        return Integer.valueOf(r15);
    L58:
        if (Intrinsics.areEqual(r7, "live_draw_to_next") == false) goto L67;
        Map r24 = (Map) r3.get(r1);
        if (r24 == null) goto L62;
        r4 = r24.get("drawToNext");
    L62:
        Integer r25 = StringsKt.toIntOrNull(String.valueOf(r4));
        if (r25 == null) goto L171;
        r15 = r25.intValue();
    L171:
        return Integer.valueOf(r15);
    L67:
        if (Intrinsics.areEqual(r7, "live_window_stay_duration") == false) goto L70;
        return Long.valueOf(b(r8, r6, false));
    L70:
        if (Intrinsics.areEqual(r7, "live_show_time") == false) goto L79;
        Map r26 = (Map) r3.get(r1);
        if (r26 == null) goto L74;
        r4 = r26.get("live_show_time");
    L74:
        Long r27 = StringsKt.toLongOrNull(String.valueOf(r4));
        if (r27 == null) goto L173;
        r5 = r27.longValue();
    L173:
        return Long.valueOf(r5);
    L79:
        if (Intrinsics.areEqual(r7, "live_time_gap") == false) goto L89;
        Long r28 = (Long) ((HashMap) e).get(r8);
        if (r28 == null) goto L174;
        String r29 = String.valueOf(r28.longValue());
        if (r29 == null) goto L174;
        Long r31 = StringsKt.toLongOrNull(r29);
        if (r31 == null) goto L174;
        r5 = r31.longValue();
    L174:
        return Long.valueOf(r5);
    L89:
        if (f.contains(r7) == false) goto L96;
        Map r32 = (Map) r3.get(r1);
        if (r32 == null) goto L175;
        Object r33 = r32.get(r7);
        if (r33 != null) goto L177;
        return null;
    L177:
        return r33.toString();
    L175:
        return null;
    L96:
        if (Intrinsics.areEqual(r7, "room_type") == false) goto L104;
        Map r34 = (Map) r3.get(r1);
        if (r34 == null) goto L100;
        r4 = r34.get("room_type");
    L100:
        Integer r35 = StringsKt.toIntOrNull(String.valueOf(r4));
        if (r35 == null) goto L178;
        r15 = r35.intValue();
    L178:
        return Integer.valueOf(r15);
    L104:
        Map<String, String> r36 = j;
        if (r36.keySet().contains(r7) == false) goto L108;
        FeatureManager.u.getClass();
        return FeatureManager.a.get(r36.get(r7));
    L108:
        if (Intrinsics.areEqual(r7, "live_preview_enter_duration") == false) goto L115;
        Map r37 = (Map) r3.get(r1);
        if (r37 == null) goto L145;
        Object r38 = r37.get("live_preview_enter_duration");
        if (r38 == null) goto L145;
        return r38;
    L145:
        return "-1";
    L115:
        if (Intrinsics.areEqual(r7, "live_preview_is_no_stream") == false) goto L124;
        Map r39 = (Map) r3.get(r1);
        if (r39 == null) goto L145;
        Object r41 = r39.get("live_preview_is_no_stream");
        if (r41 == null) goto L145;
        String r42 = r41.toString();
        if (r42 == null) goto L145;
        return r42;
    L124:
        if (Intrinsics.areEqual(r7, "live_inner_first_room_duration") == false) goto L131;
        Map r43 = (Map) r3.get(r1);
        if (r43 == null) goto L145;
        Object r44 = r43.get("live_inner_first_room_duration");
        if (r44 == null) goto L145;
        return r44;
    L131:
        if (Intrinsics.areEqual(r7, "live_inner_first_room_is_no_stream") == false) goto L138;
        Map r45 = (Map) r3.get(r1);
        if (r45 == null) goto L145;
        Object r46 = r45.get("live_inner_first_room_is_no_stream");
        if (r46 == null) goto L145;
        return r46;
    L138:
        if (Intrinsics.areEqual(r7, "live_download_speed") == false) goto L146;
        IMiddleHostService r47 = TTMiddlewareLiveSDK.hostMiddlewareService();
        if (r47 == null) goto L145;
        IMiddlewareHostAction r48 = r47.action();
        if (r48 == null) goto L145;
        String r49 = r48.getLiveDownloadSpeed(r8);
        if (r49 == null) goto L145;
        return r49;
    L146:
        Map r51 = (Map) r3.get(r1);
        if (r51 == null) goto L186;
        Set r52 = r51.keySet();
        if (r52 != null) goto L151;
        return null;
    L151:
        if (r52.contains(r7) != true) goto L188;
        Map r53 = (Map) r3.get(r1);
        if (r53 != null) goto L190;
        return null;
    L190:
        return r53.get(r7);
    L188:
        return null;
    L186:
        return null;
    L165:
        return Long.valueOf(b(r8, r6, r9));
    L164:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
    }

    public final Object getItemInfo(final String r3, final String r4, final String r5, String r6) {
        Intrinsics.checkNotNullParameter(r3, "tab");
        Intrinsics.checkNotNullParameter(r4, "itemName");
        if (r5 != null) goto L7;
        if (r6 != null) goto L7;
        boolean r7 = com.bytedance.android.live.impl.utils.a.a;
        com.bytedance.android.live.impl.utils.a.d("LFM-ShuffleSequenceInterceptor", new AnonymousClass1(r3, r4));
        return null;
    L7:
        if (r5 != null) goto L9;
        r5 = (String) ((HashMap) b).get(r6);
    L9:
        if (r5 != null) goto L12;
        boolean r8 = com.bytedance.android.live.impl.utils.a.a;
        com.bytedance.android.live.impl.utils.a.d("LFM-ShuffleSequenceInterceptor", new ShuffleSequenceInterceptor$getItemInfo$$inlined$let$lambda$1(r3, r4));
        return null;
    L12:
        final Object r9 = a(r3, r4, r5, true);
        boolean r0 = com.bytedance.android.live.impl.utils.a.a;
        com.bytedance.android.live.impl.utils.a.a("LFM-ShuffleSequenceInterceptor", new AnonymousClass3(r3, r4, r5, r9));
        return r9;
    }

    public static void e(Map r8, String r9, String r11, long r12, String r13) {
        Map r1 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("room_id", r11), TuplesKt.to("enter_from", r9)});
        if (r8 == null) goto L8;
        Iterator r14 = ((LinkedHashMap) r8).entrySet().iterator();
    L6:
        if (r14.hasNext() == false) goto L22;
        Map.Entry r15 = (Map.Entry) r14.next();
        r1.put(r15.getKey().toString(), r15.getValue().toString());
    L22:
        r1.put("report_type", r13);
        j0.l().sendLog("livesdk_shuffle_sequence_report", r1, new Object[]{x.class, IRoom.class});
        return;
    L8:
        Iterator<String> r16 = i.iterator();
    L10:
        if (r16.hasNext() == false) goto L17;
        String r2 = r16.next();
        if (CollectionsKt.listOf(new String[]{"live_preview_time_sum", "live_window_stay_duration"}).contains(r2) == false) goto L13;
        r1.put("live_preview_time_sum", String.valueOf(r12));
        r1.put("live_window_stay_duration", String.valueOf(r12));
        goto L10
    L13:
        Object r5 = a(r9, r2, r11, false);
        if (r5 == null) goto L10;
        String r3 = (String) r1.put(r2, r5.toString());
        goto L10
    L17:
        HashMap r17 = (HashMap) d;
        Integer r18 = (Integer) r17.get(r11);
        if (r18 == null) goto L20;
        int r19 = r18.intValue();
    L21:
        int r21 = r19 + 1;
        r1.put("report_count", String.valueOf(r21));
        r17.put(r11, Integer.valueOf(r21));
        goto L22
    L20:
        r19 = 0;
        goto L21
    }
}
