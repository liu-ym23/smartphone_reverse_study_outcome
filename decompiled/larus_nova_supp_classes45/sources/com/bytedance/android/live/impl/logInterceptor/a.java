package com.bytedance.android.live.impl.logInterceptor;

import android.text.TextUtils;
import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.live.feature.api.FeatureType;
import com.bytedance.android.live.impl.service.FeatureManager;
import com.bytedance.android.live.impl.service.RoomService;
import com.bytedance.android.livehostapi.platform.IMiddlewareHostAction;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.config.o71;
import com.bytedance.android.livesdkapi.api.IUtilsCommonService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomCart;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.model.LivePreviewWormholePredictConfig;
import com.bytedance.common.utility.concurrent.TTExecutors;
import j40.d0;
import j40.f;
import j40.g2;
import j40.u2;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import jc1.k;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a {
    public static final Integer a = null;
    public static final o71 b = null;
    public static final List<String> c = null;
    public static final Map<String, List<String>> d = null;
    public static final Map<String, List<String>> e = null;
    public static final List<String> f = null;
    public static final List<String> g = null;
    public static final C0197a h = null;

    /* JADX INFO: renamed from: com.bytedance.android.live.impl.logInterceptor.a$a, reason: collision with other inner class name */
    public static final class C0197a implements IMiddlewareHostAction.LiveFeatureInterceptor {
        public C0197a() {
        }

        public final boolean onSend(String r1, int r2, Map<String, Object> r3, String r4) {
            return true;
        }

        public final boolean onEnqueue(final String r28, int r29, final Map<String, Object> r31) {
            PreviewFeedFeatureInterceptor r0 = PreviewFeedFeatureInterceptor.j;
            r0.getClass();
            PreviewFeedFeatureInterceptor.b = System.currentTimeMillis();
            if (r28 != null) goto L6;
            Object r3 = "anchor_id";
        L274:
            if (a.a.intValue() <= 0) goto L277;
            ShuffleSequenceInterceptor.l.getClass();
            ShuffleSequenceInterceptor.f(r28, r31);
        L277:
            if (f.a.getValue().isEnable() == false) goto L285;
            LivePreviewWormholePredictConfig r1 = PreviewWormholePredictInterceptor.a;
            if (r28 == null) goto L285;
            if (PreviewWormholePredictInterceptor.b(r28) == false) goto L285;
            IUtilsCommonService r2 = k.f(IUtilsCommonService.class);
            if (r2 == null) goto L285;
            r2.runOnUIThread(new PreviewWormholePredictInterceptor$onEnqueue$$inlined$let$lambda$1(r28, r31));
        L285:
            List<String> r4 = a.c;
            if (r4 != null) goto L288;
        L305:
            Integer r5 = a.a;
            if (r28 != null) goto L308;
            return true;
        L308:
            if (r31 == null) goto L429;
            Map<String, List<String>> r6 = a.d;
            if (r6 != null) goto L313;
        L316:
            boolean r7 = true;
        L317:
            if (r7 == false) goto L319;
        L329:
            Map<String, List<String>> r8 = a.e;
            if (r8 != null) goto L332;
        L335:
            boolean r9 = true;
        L336:
            if (r9 == false) goto L338;
        L356:
            Object r11 = null;
        L357:
            List<String> r12 = a.f;
            if (r12 == null) goto L375;
            if ((!r12.isEmpty()) != true) goto L375;
            List<String> r13 = a.g;
            if (r13 != null) goto L365;
            r13 = CollectionsKt.emptyList();
        L365:
            if (r13.contains(r28) == false) goto L375;
            Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L372
            JSONObject r15 = new JSONObject();     // Catch: Throwable -> L372
            Iterator<String> r16 = r12.iterator();     // Catch: Throwable -> L372
        L368:
            if (r16.hasNext() == false) goto L370;
            String r17 = r16.next();     // Catch: Throwable -> L372
            r15.putOpt(r17, FeatureManager.u.getFeature(r17, new Object()));     // Catch: Throwable -> L372
            goto L368
        L370:
            r31.put("live_features_collection", r15.toString());     // Catch: Throwable -> L372
            Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L372
        L372:
            th = move-exception;
            Result.Companion r18 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        L375:
            if (TextUtils.equals(String.valueOf(r31.get("enter_from_merge")), "homepage_tablive") == false) goto L428;
            Iterator r19 = CollectionsKt.listOf(new String[]{"tablive_guide_id", "tablive_guide_anchor_id"}).iterator();
        L378:
            if (r19.hasNext() == false) goto L430;
            String r21 = (String) r19.next();
            Object r22 = FeatureManager.u.getFeature(r21, "");
            if ((!StringsKt.isBlank((String) r22)) == true) goto L383;
            r22 = r11;
        L383:
            String r23 = (String) r22;
            if (r23 == null) goto L378;
            r31.put(r21, r23);
            goto L378
        L430:
            return true;
        L428:
            return true;
        L338:
            if (r8.keySet().contains(r28) == false) goto L356;
            List<String> r24 = r8.get(r28);
            if (r24 != null) goto L342;
            r24 = CollectionsKt.emptyList();
        L342:
            Iterator<String> r25 = r24.iterator();
        L344:
            if (r25.hasNext() == false) goto L347;
            String r26 = r25.next();
            r31.put(r26, FeatureManager.u.getFeature(r26, new Object()).toString());
            goto L344
        L347:
            if (r31.containsKey(r3) == false) goto L356;
            Map<String, List<String>> r27 = a.e;
            if (r27 == null) goto L352;
            List<String> r32 = r27.get(r28);
            if (r32 == null) goto L352;
        L354:
            if (r32.contains("is_topn_room") == false) goto L356;
            r11 = null;
            r31.put("is_topn_room", String.valueOf(StringsKt.contains$default((CharSequence) FeatureManager.u.getFeature("solaria_features_topn_anchors", ""), String.valueOf(r31.get(r3)), false, 2, null)));
        L352:
            r32 = CollectionsKt.emptyList();
            goto L354
        L332:
            if (r8.isEmpty() == true) goto L335;
            r9 = false;
            goto L336
        L319:
            if (r6.keySet().contains(r28) == false) goto L329;
            FeatureManager.u.getClass();
            ConcurrentHashMap<String, Object> r33 = FeatureManager.a;
            List<String> r34 = r6.get(r28);
            if (r34 != null) goto L323;
            r34 = CollectionsKt.emptyList();
        L323:
            Iterator<String> r35 = r34.iterator();
        L325:
            if (r35.hasNext() == false) goto L329;
            String r36 = r35.next();
            if (r33.containsKey(r36) == false) goto L325;
            r31.put(r36, String.valueOf(r33.get(r36)));
            goto L325
        L313:
            if (r6.isEmpty() == true) goto L316;
            r7 = false;
            goto L317
        L429:
            return true;
        L288:
            if (CollectionsKt.contains(r4, r28) != true) goto L305;
            if (r31 == null) goto L305;
            Object r37 = r31.get("live_recommend_info");
            if (r37 == null) goto L305;
            Result.Companion r38 = Result.Companion;     // Catch: Throwable -> L302
            JSONObject r39 = new JSONObject(r37.toString());     // Catch: Throwable -> L302
            List r41 = a.b.a();     // Catch: Throwable -> L302
            if (r41 != null) goto L296;
            r41 = CollectionsKt.emptyList();     // Catch: Throwable -> L302
        L296:
            Iterator r42 = r41.iterator();     // Catch: Throwable -> L302
        L298:
            if (r42.hasNext() == false) goto L300;
            r39.remove((String) r42.next());     // Catch: Throwable -> L302
            goto L298
        L300:
            Object r43 = Result.constructor-impl(r31.put("live_recommend_info", r39.toString()));     // Catch: Throwable -> L302
        L304:
            Result.box-impl(r43);
        L302:
            th = move-exception;
            Result.Companion r44 = Result.Companion;
            r43 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L304
        L6:
            switch(r28.hashCode()) {
                case -1886261773: goto L228;
                case -1772881225: goto L202;
                case -1768568925: goto L199;
                case -1678672904: goto L191;
                case -1617503898: goto L188;
                case -1235807369: goto L166;
                case -1128063126: goto L157;
                case -773966155: goto L136;
                case -74476671: goto L129;
                case 21313630: goto L126;
                case 36692321: goto L123;
                case 228634976: goto L106;
                case 662329751: goto L103;
                case 778162112: goto L100;
                case 1011870511: goto L97;
                case 1171098609: goto L95;
                case 1427929973: goto L93;
                case 1499179894: goto L69;
                case 1499265855: goto L13;
                case 1763681274: goto L10;
                case 1860446899: goto L8;
                default: goto L272;
            };
        L8:
            r28.equals("livesdk_live_player_play_start");
            goto L272
        L95:
            r28.equals("livesdk_enter_window_from_draw_duration");
        L272:
            r3 = "anchor_id";
            goto L274
        L10:
            if (r28.equals("livesdk_live_window_duration_v2") == false) goto L272;
        L203:
            if (r31 == null) goto L206;
            r31.put("client_code", FeatureManager.u.getFeature("client_code", ""));
        L206:
            if (PreviewFeedFeatureInterceptor.c.getStallLogInfoEnable() == false) goto L272;
            if (r31 == null) goto L209;
            r31.put("downstream_throughput_kbps", FeatureManager.u.getFeature("downstream_throughput_kbps", ""));
        L209:
            if (r31 == null) goto L211;
            r31.put("http_rtt", FeatureManager.u.getFeature(r23, ""));
        L211:
            if (r31 == null) goto L213;
            r31.put("transport_rtt", FeatureManager.u.getFeature(r21, ""));
        L213:
            if (r31 == null) goto L215;
            r31.put("video_download_speed", FeatureManager.u.getFeature(r19, ""));
        L215:
            if (r31 == null) goto L217;
            r31.put("stall_counter_15s", String.valueOf(((Number) FeatureManager.u.getFeature(r26, 0)).intValue()));
        L217:
            if (r31 == null) goto L219;
            r31.put("stall_counter_30s", String.valueOf(((Number) FeatureManager.u.getFeature(r25, r16)).intValue()));
        L219:
            if (r31 == null) goto L221;
            r31.put("stall_counter_60s", String.valueOf(((Number) FeatureManager.u.getFeature(r24, r16)).intValue()));
        L221:
            if (r31 == null) goto L223;
            r31.put("stall_counter_300s", String.valueOf(((Number) FeatureManager.u.getFeature(r22, r16)).intValue()));
        L223:
            if (r31 == null) goto L225;
            r31.put("player_stall_status", FeatureManager.u.getFeature(r20, ""));
        L225:
            if (r31 == null) goto L272;
            r31.put("player_stall_duration", FeatureManager.u.getFeature(r18, ""));
            goto L272
        L13:
            if (r28.equals("livesdk_live_show") == false) goto L272;
            IRoomContextService r45 = k.f(IRoomContextService.class);
            if (r45 == null) goto L19;
            o r46 = IRoomContextService.a.a(r45, null, 0, 3);
            if (r46 == null) goto L19;
            Room r47 = r46.o2();
        L20:
            if (r47 == null) goto L22;
            String r48 = r47.isEcomCart();
        L24:
            if (TextUtils.equals(r48, GamePromoteDataContext.GAME_TYPE_MOBILE) == true) goto L32;
            if (r47 == null) goto L31;
            IRoomCart r49 = r47.getRoomCart();
            if (r49 == null) goto L31;
            if (r49.getShowCartExt() == 1) goto L32;
        L31:
            int r51 = 0;
        L33:
            if (r31 == null) goto L35;
            r31.put("is_shopping", String.valueOf(r51));
        L35:
            if (r31 == null) goto L37;
            r31.put("client_code", FeatureManager.u.getFeature("client_code", ""));
        L37:
            List<String> r52 = PreviewFeedFeatureInterceptor.c.getLiveShowRecordParams();
            if (r52 != null) goto L40;
            r52 = CollectionsKt.listOf(new String[]{"live_gap_info_item_count", "live_position", "live_gap_info_time"});
        L40:
            if (r31 == null) goto L42;
            Object r53 = r31.get("room_id");
        L43:
            if (r31 == null) goto L51;
            Object r54 = r31.get("live_gap_info_item_count");
            if (r54 == null) goto L51;
            String r55 = r54.toString();
            if (r55 == null) goto L51;
            Integer r56 = StringsKt.toIntOrNull(r55);
            if (r56 == null) goto L51;
            int r57 = r56.intValue();
        L53:
            if (r57 < (-1)) goto L272;
            if (r53 == null) goto L272;
            JSONObject r58 = new JSONObject();
            Result.Companion r59 = Result.Companion;     // Catch: Throwable -> L66
            Iterator<String> r61 = r52.iterator();     // Catch: Throwable -> L66
        L58:
            if (r61.hasNext() == false) goto L64;
            String r62 = r61.next();     // Catch: Throwable -> L66
            if (r31 == null) goto L62;
            Object r63 = r31.get(r62);     // Catch: Throwable -> L66
        L63:
            r58.putOpt(r62, r63);     // Catch: Throwable -> L66
            goto L58
        L62:
            r63 = null;
            goto L63
        L64:
            Result.constructor-impl(PreviewFeedFeatureInterceptor.i.put(r53.toString(), r58));     // Catch: Throwable -> L66
        L66:
            th = move-exception;
            Result.Companion r64 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        L51:
            r57 = -10000;
            goto L53
        L42:
            r53 = null;
        L32:
            r51 = 1;
            goto L33
        L22:
            r48 = null;
        L19:
            r47 = null;
            goto L20
        L69:
            if (r28.equals("livesdk_live_play") == false) goto L272;
            if (r31 == null) goto L72;
            r31.put("client_code", FeatureManager.u.getFeature("client_code", ""));
        L72:
            if (r31 == null) goto L74;
            Object r65 = r31.get("room_id");
        L75:
            if (r31 == null) goto L77;
            Object r66 = r31.get("enter_from_merge");
        L78:
            if (r65 == null) goto L272;
            if (CollectionsKt.contains(CollectionsKt.listOf(new String[]{"homepage_hot", "ad_feedslive", "ad_link"}), r66) == false) goto L272;
            JSONObject r67 = (JSONObject) ((LinkedHashMap) PreviewFeedFeatureInterceptor.i).get(r65.toString());
            List<String> r68 = PreviewFeedFeatureInterceptor.c.getLiveShowRecordParams();
            if (r68 != null) goto L84;
            r68 = CollectionsKt.listOf(new String[]{"live_gap_info_item_count", "live_position", "live_gap_info_time"});
        L84:
            Iterator<String> r69 = r68.iterator();
        L86:
            if (r69.hasNext() == false) goto L272;
            String r71 = r69.next();
            if (r67 == null) goto L86;
            Object r72 = r67.opt(r71);
            if (r72 == null) goto L86;
            r31.put(r71, r72);
            goto L86
        L77:
            r66 = null;
            goto L78
        L74:
            r65 = null;
            goto L75
        L93:
            if (r28.equals("livesdk_definition_setting") == false) goto L272;
        L97:
            if (r28.equals("livesdk_mini_window_live_duration") == false) goto L272;
        L100:
            if (r28.equals("livesdk_use_behavior_analysis") == false) goto L272;
        L103:
            if (r28.equals("livesdk_toolbar_icon_click") == false) goto L272;
            z90.a.C0301a.a(FeatureManager.u, "background_handle_enable", Boolean.FALSE);
            goto L272
        L106:
            if (r28.equals("livesdk_enter_room_duration") == false) goto L272;
            if (r31 == null) goto L109;
            r31.put("media_volume_percent", FeatureManager.u.getFeature("current_media_volume_percent", Float.valueOf(-1.0f)));
        L109:
            if (r31 == null) goto L111;
            Object r73 = r31.get("type");
        L113:
            if (TextUtils.equals(String.valueOf(r73), "type_preview") == false) goto L119;
            if (PreviewFeedFeatureInterceptor.f == true) goto L117;
            TTExecutors.getNormalExecutor().submit(new c(false));
            goto L119
        L117:
            PreviewFeedFeatureInterceptor.f = false;
        L119:
            if (PreviewFeedFeatureInterceptor.e == false) goto L121;
            TTExecutors.getNormalExecutor().submit(new c(true));
            TTExecutors.getNormalExecutor().submit(new b(true));
            PreviewFeedFeatureInterceptor.e = false;
        L121:
            boolean r74 = com.bytedance.android.live.impl.utils.a.a;
            com.bytedance.android.live.impl.utils.a.a(r0.a, PreviewFeedFeatureInterceptor$onEnqueue$3.INSTANCE);
            goto L272
        L111:
            r73 = null;
            goto L113
        L123:
            if (r28.equals("livesdk_wormhole_preview_stream_duration") == false) goto L272;
        L126:
            if (r28.equals("livesdk_audience_live_message") == false) goto L272;
        L129:
            if (r28.equals("livesdk_live_window_duration") == false) goto L272;
            PreviewFeedFeatureInterceptor.f(false);
            PreviewFeedFeatureInterceptor.d = 0;
            FeatureManager r75 = FeatureManager.u;
            r75.g("preview_room_id");
            if (r31 == null) goto L133;
            Object r76 = r31.get("enter_from_merge");
        L134:
            z90.a.C0301a.a(r75, String.valueOf(r76).concat("_livesdk_live_window_duration_time"), Long.valueOf(System.currentTimeMillis()));
            goto L272
        L133:
            r76 = null;
            goto L134
        L136:
            if (r28.equals("livesdk_live_leave") == false) goto L272;
            Iterator r77 = CollectionsKt.listOf(new String[]{"live_end", "drawer"}).iterator();
        L139:
            if (r77.hasNext() == false) goto L155;
            String r78 = (String) r77.next();
            if (r31 == null) goto L139;
            Object r79 = r31.get("enter_from_merge");
            if (r79 == null) goto L139;
            String r81 = r79.toString();
            if (r81 == null) goto L139;
            if (StringsKt.contains$default(r81, r78, false, 2, null) != true) goto L139;
            Object r82 = r31.get("leave_type");
            if (r82 == null) goto L151;
            String r83 = r82.toString();
        L153:
            if (TextUtils.equals(r83, "draw") == false) goto L139;
        L151:
            r83 = null;
            goto L153
        L155:
            PreviewFeedFeatureInterceptor.e = true;
            FeatureManager r84 = FeatureManager.u;
            r84.g("last_preview_duration");
            r84.g("enter_anchor_id");
            PreviewFeedFeatureInterceptor.f = true;
            goto L272
        L157:
            if (r28.equals("livesdk_live_window_show") == false) goto L272;
            PreviewFeedFeatureInterceptor.d = PreviewFeedFeatureInterceptor.b;
            FeatureManager r85 = FeatureManager.u;
            if (r31 == null) goto L163;
            Object r86 = r31.get("room_id");
            if (r86 == null) goto L163;
            String r87 = r86.toString();
        L164:
            z90.a.C0301a.a(r85, "preview_room_id", r87);
            r85.i("preview_room_order", Integer.valueOf(((Number) r85.getFeature("preview_room_order", 0)).intValue() + 1), FeatureType.MONITOR);
            PreviewFeedFeatureInterceptor.f(true);
        L163:
            r87 = null;
            goto L164
        L166:
            if (r28.equals("livesdk_performance_monitor_base_new") == false) goto L272;
            if (PreviewFeedFeatureInterceptor.c.getStallLogInfoEnable() == false) goto L272;
            if (r31 == null) goto L171;
            r31.put("stall_counter_15s", String.valueOf(((Number) FeatureManager.u.getFeature("stall_counter_15s", 0)).intValue()));
        L171:
            if (r31 == null) goto L173;
            r31.put("stall_counter_30s", String.valueOf(((Number) FeatureManager.u.getFeature("stall_counter_30s", 0)).intValue()));
        L173:
            if (r31 == null) goto L175;
            r31.put("stall_counter_60s", String.valueOf(((Number) FeatureManager.u.getFeature("stall_counter_60s", 0)).intValue()));
        L175:
            if (r31 == null) goto L177;
            r31.put("stall_counter_300s", String.valueOf(((Number) FeatureManager.u.getFeature("stall_counter_300s", 0)).intValue()));
        L177:
            if (r31 == null) goto L179;
            r31.put("player_stall_status", FeatureManager.u.getFeature("player_stall_status", ""));
        L179:
            if (r31 == null) goto L181;
            r31.put("player_stall_duration", FeatureManager.u.getFeature("player_stall_duration", ""));
        L181:
            if (r31 == null) goto L183;
            r31.put("http_rtt", FeatureManager.u.getFeature("http_rtt", ""));
        L183:
            if (r31 == null) goto L185;
            r31.put("transport_rtt", FeatureManager.u.getFeature("transport_rtt", ""));
        L185:
            if (r31 == null) goto L272;
            r31.put("video_download_speed", FeatureManager.u.getFeature("video_download_speed", ""));
            goto L272
        L188:
            if (r28.equals("livesdk_first_frame_duration") == false) goto L272;
        L191:
            if (r28.equals("livesdk_audience_audio_feedback") == false) goto L272;
            if (r31 == null) goto L194;
            Object r88 = r31.get("feedback_tag");
        L196:
            if (TextUtils.equals(String.valueOf(r88), "直播画面模糊") == false) goto L272;
            int r89 = r0.e().a("key_live_fuzzy_feedback_count") + 1;
            z90.a.C0301a.a(FeatureManager.u, "live_fuzzy_feedback_count", Integer.valueOf(r89));
            r0.e().e("key_live_fuzzy_feedback_count", Integer.valueOf(r89));
            goto L272
        L194:
            r88 = null;
            goto L196
        L199:
            if (r28.equals("livesdk_live_theme_preview_duration") == false) goto L272;
            boolean r91 = com.bytedance.android.live.impl.utils.a.a;
            com.bytedance.android.live.impl.utils.a.a(r0.a, PreviewFeedFeatureInterceptor$onEnqueue$4.INSTANCE);
            goto L272
        L202:
            if (r28.equals("livesdk_live_duration_new") == false) goto L272;
        L228:
            if (r28.equals("livesdk_live_window_cover_click") == false) goto L272;
            TTExecutors.getNormalExecutor().submit(new b(false));
            FeatureManager r92 = FeatureManager.u;
            r3 = "anchor_id";
            if (r31 == null) goto L232;
            Object r93 = r31.get(r3);
        L233:
            z90.a.C0301a.a(r92, "enter_anchor_id", r93);
            z90.a.C0301a.a(r92, "last_preview_duration", String.valueOf(System.currentTimeMillis() - PreviewFeedFeatureInterceptor.d));
            if (r31 == null) goto L236;
            Object r94 = r31.get("enter_from_merge");
        L238:
            if (TextUtils.equals(String.valueOf(r94), "homepage_hot") == true) goto L244;
            if (r31 == null) goto L241;
            Object r95 = r31.get("enter_from_merge");
        L243:
            if (TextUtils.equals(String.valueOf(r95), "ad_feedslive") == false) goto L274;
        L241:
            r95 = null;
        L244:
            if (r31 == null) goto L246;
            Object r96 = r31.get("room_id");
        L247:
            z90.a.C0301a.a(r92, "last_enter_inner_room_id_for_show_gap", r96);
            WeakReference<IRoom> r97 = RoomService.a;
            WeakReference<IRoom> r98 = RoomService.a;
            if (r98 == null) goto L252;
            IRoom r99 = r98.get();
            if (r99 == null) goto L252;
            Long r100 = Long.valueOf(r99.getId());
        L253:
            String r101 = String.valueOf(r100);
            if (r31 == null) goto L256;
            Object r102 = r31.get("room_id");
        L258:
            if (TextUtils.equals(r101, String.valueOf(r102)) == false) goto L274;
            WeakReference<IRoom> r103 = RoomService.a;
            if (r103 == null) goto L266;
            IRoom r104 = r103.get();
            if (r104 == null) goto L266;
            com.bytedance.android.livesdk.strategy.a r105 = r104.getAdStrategyFeatures();
            if (r105 == null) goto L266;
            boolean r106 = r105.a();
        L267:
            if (r106 == true) goto L274;
            if (r31 == null) goto L270;
            Object r107 = r31.get("room_id");
        L271:
            z90.a.C0301a.a(r92, "last_enter_inner_common_room_id_for_show_gap", r107);
            goto L274
        L270:
            r107 = null;
        L266:
            r106 = false;
            goto L267
        L256:
            r102 = null;
        L252:
            r100 = null;
            goto L253
        L246:
            r96 = null;
            goto L247
        L236:
            r94 = null;
            goto L238
        L232:
            r93 = null;
            goto L233
        }
    }

    static {
        a = u2.a.getValue();
        o71 r0 = g2.a.getValue();
        b = r0;
        if (r0.b() == false) goto L5;
        List<String> r1 = r0.c();
    L6:
        c = r1;
        d0 r2 = d0.a;
        d = r2.getValue().getLiveAppendParamsMap();
        e = r2.getValue().getLiveAppendRealtimeParamsMap();
        f = r2.getValue().getLiveFeaturesCollection();
        g = r2.getValue().getLiveFeaturesCollectionEventList();
        h = new C0197a();
        return;
    L5:
        r1 = CollectionsKt.emptyList();
        goto L6
    }
}
