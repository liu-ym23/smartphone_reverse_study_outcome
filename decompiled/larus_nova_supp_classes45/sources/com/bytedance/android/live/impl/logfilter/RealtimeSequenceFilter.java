package com.bytedance.android.live.impl.logfilter;

import am2.x;
import android.text.TextUtils;
import android.util.LongSparseArray;
import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.live.core.utils.k0;
import com.bytedance.android.live.feature.config.LivePostClientSequenceConfig;
import com.bytedance.android.live.impl.service.FeatureManager;
import com.bytedance.android.live.impl.service.FeedFeatureManager;
import com.bytedance.android.live.impl.utils.LimitSizeQueue;
import com.bytedance.android.livehostapi.TTMiddlewareLiveSDK;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.service.IMiddleWarePerformanceManager;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import j40.a2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class RealtimeSequenceFilter implements f {
    public static final RealtimeSequenceFilter A = null;
    public static final LivePostClientSequenceConfig a = null;
    public static final int b = 0;
    public static final LimitSizeQueue<JSONObject> c = null;
    public static final ConcurrentLinkedQueue<Pair<Long, Integer>> d = null;
    public static final ConcurrentLinkedQueue<Pair<Long, Integer>> e = null;
    public static final ConcurrentLinkedQueue<Pair<Long, Integer>> f = null;
    public static final boolean g = false;
    public static final boolean h = false;
    public static final Map<String, String> i = null;
    public static final Map<String, Boolean> j = null;
    public static final Set<Pair<Long, Long>> k = null;
    public static int l;
    public static int m;
    public static final boolean n = false;
    public static final boolean o = false;
    public static final boolean p = false;
    public static final int q = 0;
    public static final Map<String, String> r = null;
    public static final List<String> s = null;
    public static final List<String> t = null;
    public static final Map<String, JSONObject> u = null;
    public static final Map<String, String> v = null;
    public static final boolean w = false;
    public static final Lazy x = null;
    public static final Lazy y = null;
    public static final Lazy z = null;

    public RealtimeSequenceFilter() {
    }

    static {
        A = new RealtimeSequenceFilter();
        LivePostClientSequenceConfig r0 = a2.a.getValue();
        a = r0;
        int r1 = r0.getSize();
        b = r1;
        c = new LimitSizeQueue(r1);
        d = new ConcurrentLinkedQueue();
        e = new ConcurrentLinkedQueue();
        f = new ConcurrentLinkedQueue();
        g = r0.getSubmitRequestEnableV2();
        h = r0.getSubmitRequestEnableV3();
        Map<String, String> r2 = r0.getFeedSingleFeatureToIndexMap();
        if (r2 != null) goto L5;
        r2 = MapsKt.emptyMap();
    L5:
        i = r2;
        Map<String, Boolean> r3 = r0.getLiveSingleFeatureMap();
        if (r3 != null) goto L8;
        r3 = MapsKt.emptyMap();
    L8:
        j = r3;
        k = new LinkedHashSet();
        n = r0.getLivePlayBeginEnable();
        o = r0.getEnterAnchorIdOptEnable();
        p = r0.getChangeReportFormEnable();
        q = r0.getCacheFeaturesEnableType();
        r = new LinkedHashMap();
        Map<String, List<Integer>> r4 = r0.getLiveRecommendInfoFeatureMap();
        Set r5 = null;
        if (r4 == null) goto L17;
        LinkedHashMap r6 = new LinkedHashMap();
        Iterator<Map.Entry<String, List<Integer>>> r7 = r4.entrySet().iterator();
    L12:
        if (r7.hasNext() == false) goto L16;
        Map.Entry<String, List<Integer>> r8 = r7.next();
        if (r8.getValue().contains(1) == false) goto L12;
        r6.put(r8.getKey(), r8.getValue());
        goto L12
    L16:
        Set r9 = r6.keySet();
    L18:
        if (r9 == null) goto L21;
        List<String> r11 = CollectionsKt.toMutableList(r9);
        if (r11 == null) goto L21;
    L22:
        s = r11;
        Map<String, List<Integer>> r12 = a.getLiveRecommendInfoFeatureMap();
        if (r12 == null) goto L31;
        LinkedHashMap r13 = new LinkedHashMap();
        Iterator<Map.Entry<String, List<Integer>>> r14 = r12.entrySet().iterator();
    L26:
        if (r14.hasNext() == false) goto L30;
        Map.Entry<String, List<Integer>> r15 = r14.next();
        if (r15.getValue().contains(2) == false) goto L26;
        r13.put(r15.getKey(), r15.getValue());
        goto L26
    L30:
        r5 = r13.keySet();
    L31:
        if (r5 == null) goto L34;
        List<String> r16 = CollectionsKt.toMutableList(r5);
        if (r16 == null) goto L34;
    L35:
        t = r16;
        u = new LinkedHashMap();
        v = new LinkedHashMap();
        w = a.getEnableSendLogAsync();
        x = LazyKt.lazy(RealtimeSequenceFilter$kevaOrSpHelper$2.INSTANCE);
        y = LazyKt.lazy(RealtimeSequenceFilter$featureManagerSingleFeatureMap$2.INSTANCE);
        z = LazyKt.lazy(RealtimeSequenceFilter$sequenceFeatureNameToIndexMap$2.INSTANCE);
        z90.a.C0301a.a(FeatureManager.u, "live_index_in_session", Integer.valueOf(m));
        return;
    L34:
        r16 = new ArrayList();
    L21:
        r11 = new ArrayList();
        goto L22
    L17:
        r9 = null;
        goto L18
    }

    public static void d() {
        if (d.isEmpty() == false) goto L5;
        return;
    L5:
        long r0 = System.currentTimeMillis();
        long r2 = ((long) a.getLimitTimeInSec()) * 1000;
    L6:
        ConcurrentLinkedQueue<Pair<Long, Integer>> r4 = d;
        if ((!r4.isEmpty()) == false) goto L11;
        if ((r0 - ((Number) r4.peek().getFirst()).longValue()) <= r2) goto L11;
        r4.poll();
    L11:
        ConcurrentLinkedQueue<Pair<Long, Integer>> r5 = f;
        if ((!r5.isEmpty()) == false) goto L16;
        if ((r0 - ((Number) r5.peek().getFirst()).longValue()) <= r2) goto L16;
        r5.poll();
    L16:
        ConcurrentLinkedQueue<Pair<Long, Integer>> r6 = e;
        if ((!r6.isEmpty()) == false) goto L21;
        if ((r0 - ((Number) r6.peek().getFirst()).longValue()) <= r2) goto L30;
        r6.poll();
        goto L16
    L30:
        return;
    }

    public static JSONObject a(JSONObject r15) {
        JSONObject r0 = new JSONObject();
        int r2 = 0;
        if (g == false) goto L40;
        String r1 = b("processor");
        int r4 = g.a;
        IMiddleWarePerformanceManager r5 = jc1.k.n(IMiddleWarePerformanceManager.class);
        double r8 = 100;
        JSONObject r3 = r0.put(r1, (((int) (r5.getCpuRate() * r8)) * 1000) + ((int) (r5.getGpuUsed() * r8)));
        String r6 = b("memory");
        IMiddleWarePerformanceManager r7 = jc1.k.n(IMiddleWarePerformanceManager.class);
        if (r7.getJavaHeapSum() > r7.getJavaHeapLeave()) goto L7;
    L9:
        int r9 = 0;
    L11:
        if (r7.getNativeHeapSum() > r7.getNativeHeapLeave()) goto L13;
    L15:
        int r11 = 0;
    L16:
        JSONObject r12 = r3.put(r6, (r9 * 1000) + r11);
        String r13 = b("battery");
        IMiddleWarePerformanceManager r14 = jc1.k.n(IMiddleWarePerformanceManager.class);
        JSONObject r16 = r12.put(r13, (r14.getBatteryChange() * 1000) + ((int) r14.getBatteryCurrent())).put(b("temperature"), (int) jc1.k.n(IMiddleWarePerformanceManager.class).getTemperature()).put(b("net_quality"), jc1.k.n(IMiddleWarePerformanceManager.class).getNetQuality());
        String r17 = b("brightness");
        List<String> r18 = FeedFeatureManager.a;
        Number r19 = FeedFeatureManager.c("common", "brightness_auto");
        if (r19 == null) goto L19;
        int r21 = r19.intValue();
    L20:
        Number r22 = FeedFeatureManager.c("common", "brightness_screen");
        if (r22 == null) goto L23;
        float r23 = r22.floatValue();
    L24:
        int r24 = (int) (r23 * 100);
        Number r25 = FeedFeatureManager.c("common", "brightness_env");
        if (r25 == null) goto L28;
        r2 = r25.intValue();
    L28:
        if (r2 <= 2000) goto L30;
        r2 = 2000;
    L30:
        JSONObject r26 = r16.put(r17, (((r21 * 1000) * 1000) + (r24 * 1000)) + ((r2 * 100) / 2000));
        String r27 = b("ohr");
        FeatureManager r28 = FeatureManager.u;
        r28.getClass();
        Intrinsics.checkNotNullParameter("live_ohr_realtime_result", "name");
        ConcurrentHashMap<String, Object> r29 = FeatureManager.a;
        if (r29.containsKey("live_ohr_realtime_result") == false) goto L33;
        int r31 = ((Number) r28.getFeature("live_ohr_realtime_result", 0)).intValue();
    L34:
        JSONObject r32 = r26.put(r27, r31);
        String r33 = b("har");
        Intrinsics.checkNotNullParameter("live_har_status", "name");
        if (r29.containsKey("live_har_status") == false) goto L37;
        int r34 = ((Number) r28.getFeature("live_har_status", 0)).intValue();
    L38:
        r32.put(r33, r34);
        goto L40
    L37:
        r34 = ((Number) r28.getFeature("solaria_features_cl_ai_har", 0)).intValue();
        goto L38
    L33:
        r31 = ((Number) r28.getFeature("solaria_features_cl_ai_ohr", 0)).intValue();
        goto L34
    L23:
        r23 = 0.0f;
        goto L24
    L19:
        r21 = 0;
        goto L20
    L13:
        if (r7.getNativeHeapLeave() <= 0) goto L15;
        r11 = (int) ((r7.getNativeHeapLeave() * ((long) 100)) / r7.getNativeHeapSum());
        goto L16
    L7:
        if (r7.getJavaHeapLeave() <= 0) goto L9;
        r9 = (int) ((r7.getJavaHeapLeave() * ((long) 100)) / r7.getJavaHeapSum());
    L40:
        if (h == false) goto L50;
        JSONObject r35 = TTMiddlewareLiveSDK.hostMiddlewareService().action().getLiveFeaturesFromSingleFeatureCenterService();
        Iterator<String> r36 = i.keySet().iterator();
    L43:
        if (r36.hasNext() == false) goto L49;
        String r37 = r36.next();
        String r38 = i.get(r37);
        if (r35 == null) goto L47;
        Object r39 = r35.opt(r37);
    L48:
        r0.putOpt(r38, r39);
        goto L43
    L47:
        r39 = null;
        goto L48
    L49:
        String r41 = b("live_index_in_session");
        FeatureManager r42 = FeatureManager.u;
        r0.putOpt(r41, r42.getFeature("live_index_in_session", 0));
        r0.putOpt(b("refer_page"), r42.getFeature("homepage_hot_refer_page", ""));
    L50:
        Iterator<String> r43 = r15.keys();
        if (r43 != null) goto L53;
    L55:
        return r0;
    L53:
        if (r43.hasNext() == false) goto L55;
        String r44 = r43.next();
        r0.putOpt(r44, r15.get(r44));
        goto L53
    }

    public static String b(String r3) {
        Intrinsics.checkNotNullParameter(r3, "featureName");
        Map<String, String> r0 = i;
        if (r0.containsKey(r3) == false) goto L9;
        String r4 = r0.get(r3);
        if (r4 != null) goto L8;
        return "-1";
    L8:
        return r4;
    L9:
        Lazy r1 = z;
        if (((Map) r1.getValue()).containsKey(r3) == false) goto L17;
        String r5 = (String) ((Map) r1.getValue()).get(r3);
        if (r5 != null) goto L15;
        return "-1";
    L15:
        return r5;
    L17:
        return "-1";
    }

    private final void update(Map<String, String> r8) {
        LimitSizeQueue<JSONObject> r0 = c;
        if (r0.isEmpty() == false) goto L6;
        boolean r9 = com.bytedance.android.live.impl.utils.a.a;
        com.bytedance.android.live.impl.utils.a.c("LFM-RealtimeSequenceFilter", AnonymousClass1.INSTANCE);
        return;
    L6:
        JSONObject r1 = (JSONObject) CollectionsKt.lastOrNull(r0);
        if (r1 == null) goto L37;
        long r2 = ((JSONObject) CollectionsKt.last(r0)).optLong(b("show_ts"), System.currentTimeMillis());
        if (String.valueOf(r2).length() > 10) goto L12;
        r2 = r2 * ((long) 1000);
    L12:
        String r4 = b("watch_dur");
        if (r8 == null) goto L17;
        String r5 = r8.get("duration");
        if (r5 == null) goto L17;
        long r3 = CastLongProtector.parseLong(r5);
    L18:
        r1.put(r4, r3);
        LongSparseArray r6 = (LongSparseArray) FeatureManager.u.getFeature("live_room_type", new LongSparseArray());
        if (r8 == null) goto L26;
        String r11 = r8.get("room_id");
        if (r11 == null) goto L26;
        String r7 = b("room_tags");
        String r12 = (String) r6.get(CastLongProtector.parseLong(r11));
        if (r12 != null) goto L25;
        r12 = "";
    L25:
        r1.put(r7, r12);
    L26:
        IRoomContextService r13 = jc1.k.f(IRoomContextService.class);
        Room r14 = null;
        if (r13 == null) goto L31;
        com.bytedance.android.livesdk.chatroom.o r15 = IRoomContextService.a.a(r13, null, 0, 3);
        if (r15 == null) goto L31;
        r14 = r15.o2();
    L31:
        if (r14 == null) goto L33;
        long r16 = r14.getUserCount();
    L35:
        if (r16 <= 0) goto L37;
        r1.put(b("user_count_in_cur_room"), r16);
        goto L37
    L33:
        r16 = 0;
    L17:
        r3 = System.currentTimeMillis() - r2;
    L37:
        monitor-enter(this);
        d();     // Catch: Throwable -> L59
        JSONObject r17 = (JSONObject) CollectionsKt.lastOrNull(r0);     // Catch: Throwable -> L59
        if (r17 == null) goto L57;
        String r18 = b("like_cnt");     // Catch: Throwable -> L59
        Iterator<Pair<Long, Integer>> r19 = d.iterator();     // Catch: Throwable -> L59
        int r21 = 0;
        int r22 = 0;
    L42:
        if (r19.hasNext() == false) goto L44;
        r22 = r22 + ((Number) r19.next().getSecond()).intValue();     // Catch: Throwable -> L59
        goto L42
    L44:
        JSONObject r23 = r17.put(r18, r22);     // Catch: Throwable -> L59
        if (r23 == null) goto L57;
        String r24 = b("message_cnt");     // Catch: Throwable -> L59
        Iterator<Pair<Long, Integer>> r25 = e.iterator();     // Catch: Throwable -> L59
        int r26 = 0;
    L48:
        if (r25.hasNext() == false) goto L50;
        r26 = r26 + ((Number) r25.next().getSecond()).intValue();     // Catch: Throwable -> L59
        goto L48
    L50:
        JSONObject r27 = r23.put(r24, r26);     // Catch: Throwable -> L59
        if (r27 == null) goto L57;
        String r28 = b("send_gift_cnt");     // Catch: Throwable -> L59
        Iterator<Pair<Long, Integer>> r29 = f.iterator();     // Catch: Throwable -> L59
    L54:
        if (r29.hasNext() == false) goto L56;
        r21 = r21 + ((Number) r29.next().getSecond()).intValue();     // Catch: Throwable -> L59
        goto L54
    L56:
        r27.put(r28, r21);     // Catch: Throwable -> L59
    L57:
        monitor-exit(this);
        return;
    L59:
        th = move-exception;
        throw th;
    }

    public static JSONArray f(JSONArray r9, Object r11) {
        if (q <= 0) goto L5;
        JSONArray r0 = new JSONArray();
        int r1 = r9.length();
        int r2 = b;
        int r3 = 0;
        if (r1 < r2) goto L9;
        r3 = (r1 - r2) + 1;
    L9:
        boolean r4 = false;
    L10:
        if (r3 >= r1) goto L23;
        Object r5 = r9.opt(r3);
        if (r5 == null) goto L22;
        r0.put(r5);
        if ((r11 instanceof JSONObject) == false) goto L22;
        if ((r5 instanceof JSONObject) == false) goto L22;
        JSONObject r6 = (JSONObject) r11;
        JSONObject r7 = (JSONObject) r5;
        if (Intrinsics.areEqual(r6.opt(b("room_id")).toString(), r7.opt(b("room_id")).toString()) == false) goto L22;
        if (Intrinsics.areEqual(r6.opt(b("show_ts")).toString(), r7.opt(b("show_ts")).toString()) == false) goto L22;
        r4 = true;
    L22:
        r3 = r3 + 1;
        goto L10
    L23:
        if (r4 == true) goto L26;
        if (r11 == null) goto L26;
        r0.put(r11);
    L26:
        return r0;
    L5:
        return new JSONArray();
    }

    public final String c(int r31, JSONObject r32) {
        String r3 = "enter_source";
        String r4 = "LFM-RealtimeSequenceFilter";
        if (r31 == 1) goto L23;
        if (r31 == 2) goto L23;
        if (r31 != 3) goto L245;
        final long r8 = System.currentTimeMillis();
        final JSONArray r2 = new JSONArray();
        Iterator<JSONObject> r5 = c.iterator();
    L10:
        if (r5.hasNext() == false) goto L18;
        JSONObject r11 = r5.next();
        if ((!Intrinsics.areEqual(r11.optString("enter_source"), "homepage_follow-live_cover")) == true) goto L10;
        if (r2.length() == (c.size() - 1)) goto L16;
        r2.put(r11);
        goto L10
    L16:
        r2.put(a(r11));
        goto L10
    L18:
        e(r2, 3, null);
        if (r2.length() <= 0) goto L21;
        final String r0 = new JSONObject().putOpt("follow_skylight_live_feature_sequence", r2).toString();
    L22:
        boolean r6 = com.bytedance.android.live.impl.utils.a.a;
        com.bytedance.android.live.impl.utils.a.d("LFM-RealtimeSequenceFilter", new RealtimeSequenceFilter$getFollowSkylightSequenceJson$1(r2, r8));
        com.bytedance.android.live.impl.utils.a.c("LFM-RealtimeSequenceFilter", new RealtimeSequenceFilter$getFollowSkylightSequenceJson$2(r0));
        return r0;
    L21:
        r0 = new JSONObject().toString();
        goto L22
    L245:
        return new JSONObject().toString();
    L23:
        long r9 = System.currentTimeMillis();
        if (r31 != 1) goto L26;
        m++;
        z90.a.C0301a.a(FeatureManager.u, "live_index_in_session", Integer.valueOf(m));
    L26:
        update(null);
        final JSONArray r12 = new JSONArray();
        String r13 = "realtime_feature_sequence_feat";
        String r14 = "seq_feat";
        if (q <= 0) goto L33;
        JSONObject r15 = ((k0) x.getValue()).b("realtime_feature_sequence_feat");
        if (r15 == null) goto L32;
        JSONArray r16 = r15.optJSONArray("seq_feat");
        if (r16 == null) goto L32;
    L34:
        Iterator<JSONObject> r17 = c.iterator();
    L35:
        String r7 = "";
        if (r17.hasNext() == false) goto L94;
        final JSONObject r18 = r17.next();
        aa0.b r19 = SkipSequenceHelper.a;
        Intrinsics.checkNotNullParameter(r18, "seq");
        boolean r21 = com.bytedance.android.live.impl.utils.a.a;
        com.bytedance.android.live.impl.utils.a.a("LFM-SkipSequence", new SkipSequenceHelper$addSkipSequence$1(r18));
        String r22 = "live_show_time";
        Iterator<JSONObject> r110 = r17;
        long r111 = r9;
        if (String.valueOf(r18.optLong(SkipSequenceHelper.a("live_show_time"), -1)).length() != 10) goto L41;
        String r26 = r3;
        String r23 = r4;
        String r27 = r13;
        String r28 = r14;
    L86:
        long r24 = r18.optLong(b("show_ts"), System.currentTimeMillis());
        if (String.valueOf(r24).length() <= 10) goto L89;
        r24 = r24 / 1000;
    L89:
        r18.put(b("show_ts"), r24);
        r16 = f(r16, r18);
        if (r12.length() != (c.size() - 1)) goto L92;
        r12.put(a(r18));
    L93:
        r17 = r110;
        r9 = r111;
        r4 = r23;
        r3 = r26;
        r13 = r27;
        r14 = r28;
        goto L35
    L92:
        r12.put(r18);
        goto L93
    L41:
        if (SkipSequenceHelper.c(r18) == false) goto L45;
        r26 = r3;
        r23 = r4;
        if ((r18.optLong(SkipSequenceHelper.a("live_duration"), 0) + r18.optLong(SkipSequenceHelper.a("live_window_stay_duration"), 0)) < SkipSequenceHelper.d) goto L47;
    L48:
        boolean r25 = false;
    L49:
        if (r25 == false) goto L85;
        com.bytedance.android.live.impl.utils.a.a("LFM-SkipSequence", SkipSequenceHelper$addSkipSequence$2.INSTANCE);
        Map<String, Long> r29 = SkipSequenceHelper.c;
        String r33 = "gid";
        Long r34 = (Long) ((LinkedHashMap) r29).get(r18.optString(SkipSequenceHelper.a("gid"), ""));
        r27 = r13;
        r28 = r14;
        long r112 = r18.optLong(SkipSequenceHelper.a("live_show_time"), -1);
        if (r34 != null) goto L54;
    L56:
        r29.put(r18.optString(SkipSequenceHelper.a("gid"), ""), Long.valueOf(r18.optLong(SkipSequenceHelper.a("live_show_time"), 0)));
        JSONObject r35 = new JSONObject();
        Iterator<String> r36 = SkipSequenceHelper.g.keySet().iterator();
    L58:
        if (r36.hasNext() == false) goto L84;
        String r37 = r36.next();
        switch(r37.hashCode()) {
            case -1988424674: goto L77;
            case -1657144516: goto L75;
            case 96572: goto L72;
            case 102338: goto L69;
            case 1394584663: goto L66;
            case 1479612295: goto L63;
            default: goto L58;
        };
    L63:
        if (r37.equals("live_duration") == false) goto L58;
    L76:
        String r210 = r33;
        String r113 = r22;
        r35.putOpt(r37, Long.valueOf(r18.optLong(SkipSequenceHelper.a(r37), 0)));
    L83:
        r22 = r113;
        r33 = r210;
        goto L58
    L66:
        if (r37.equals("live_time_gap") == false) goto L58;
        r35.putOpt(r37, 0);
        goto L58
    L69:
        if (r37.equals(r33) == false) goto L58;
    L73:
        r35.putOpt(r37, r18.optString(SkipSequenceHelper.a(r37), ""));
        goto L58
    L72:
        if (r37.equals("aid") == false) goto L58;
    L75:
        if (r37.equals(r22) == false) goto L58;
    L77:
        r210 = r33;
        r113 = r22;
        if (r37.equals("live_window_stay_duration") == false) goto L83;
        if (SkipSequenceHelper.c(r18) == false) goto L82;
        r35.putOpt(r37, Long.valueOf(r18.optLong(SkipSequenceHelper.a(r37), 0)));
        goto L83
    L82:
        r35.putOpt(r37, 0L);
        goto L83
    L84:
        SkipSequenceHelper.b.offer(r35);
        goto L86
    L54:
        if (r34.longValue() != r112) goto L56;
    L85:
        r27 = r13;
        r28 = r14;
        com.bytedance.android.live.impl.utils.a.a("LFM-SkipSequence", SkipSequenceHelper$addSkipSequence$3.INSTANCE);
    L47:
        r25 = true;
        goto L49
    L45:
        r26 = r3;
        r23 = r4;
        if (r18.optLong(SkipSequenceHelper.a("live_duration"), 0) >= SkipSequenceHelper.d) goto L48;
    L94:
        String r211 = r3;
        String r212 = r4;
        final long r114 = r9;
        String r213 = r13;
        String r214 = r14;
        e(r12, r31, r32);
        int r38 = q;
        if (r38 > 0) goto L97;
    L103:
        String r39 = r214;
    L105:
        if (p == false) goto L185;
        JSONObject r41 = new JSONObject().putOpt(r39, r12);
        if (r38 != 1) goto L111;
        if (r12.length() != 0) goto L111;
    L112:
        r41.putOpt(r39, r16);
    L113:
        if (r32 == null) goto L116;
        Object r42 = r32.opt(r211);
        if (r42 == null) goto L116;
    L117:
        String r43 = (String) ((LinkedHashMap) v).get(r42);
        if (r43 != null) goto L122;
        if (r32 == null) goto L121;
        r43 = r32.optString("draw_room_id");
        goto L122
    L121:
        r43 = null;
    L122:
        if (r43 == null) goto L126;
        r7 = r43;
    L126:
        if (r31 != 1) goto L180;
        JSONObject r44 = new JSONObject();
        HashMap r45 = new HashMap();
        if (r32 == null) goto L194;
        Iterator<String> r46 = r32.keys();
        if (r46 == null) goto L194;
    L132:
        if (r46.hasNext() == false) goto L194;
        String r47 = r46.next();
        if (Intrinsics.areEqual(j.get(r47.toString()), Boolean.TRUE) == false) goto L132;
        String r48 = r32.optString(r47);
        r44.putOpt(r47, r48);
        String r49 = (String) r45.put(r47, r48.toString());
    L194:
        Result.Companion r51 = Result.Companion;     // Catch: Throwable -> L176
        JSONObject r52 = (JSONObject) ((LinkedHashMap) u).get(r7);     // Catch: Throwable -> L176
        if (r52 != null) goto L139;
        r52 = new JSONObject();     // Catch: Throwable -> L176
    L139:
        if (r32 == null) goto L146;
        String r1 = r32.optString("live_recommend_info");     // Catch: Throwable -> L176
        if (r1 == null) goto L146;
        if (StringsKt.isBlank(r1) == true) goto L146;
        JSONObject r53 = new JSONObject(r1);     // Catch: Throwable -> L176
    L147:
        Iterator<String> r54 = t.iterator();     // Catch: Throwable -> L176
    L149:
        if (r54.hasNext() == false) goto L155;
        String r55 = r54.next();     // Catch: Throwable -> L176
        if (r53 == null) goto L149;
        Object r115 = r53.opt(r55);     // Catch: Throwable -> L176
        if (r115 == null) goto L149;
        r52.putOpt(r55, r115);     // Catch: Throwable -> L176
        String r56 = (String) r45.put(r55, r115.toString());     // Catch: Throwable -> L176
        goto L149
    L155:
        r52.putOpt("room_id", r7);     // Catch: Throwable -> L176
        u.put(r7, r52);     // Catch: Throwable -> L176
        r44.putOpt("entrance_room", r52);     // Catch: Throwable -> L176
        Map r57 = (Map) y.getValue();     // Catch: Throwable -> L176
        if (r57 == null) goto L159;
        Set r58 = r57.entrySet();     // Catch: Throwable -> L176
        if (r58 == null) goto L159;
    L160:
        Iterator r59 = r58.iterator();     // Catch: Throwable -> L176
    L162:
        if (r59.hasNext() == false) goto L174;
        Map.Entry r61 = (Map.Entry) r59.next();     // Catch: Throwable -> L176
        Object r62 = new Object();     // Catch: Throwable -> L176
        String r63 = FeatureManager.u.getFeature((String) r61.getValue(), r62).toString();     // Catch: Throwable -> L176
        if (TextUtils.equals(r63, r62.toString()) == false) goto L166;
    L168:
        boolean r64 = false;
    L169:
        if (r64 == true) goto L172;
        r63 = null;
    L172:
        if (r63 == null) goto L162;
        r44.putOpt((String) r61.getKey(), r63);     // Catch: Throwable -> L176
        goto L162
    L166:
        if ((!StringsKt.isBlank(r63)) == false) goto L168;
        r64 = true;
        goto L169
    L174:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L176
    L178:
        r45.put("report_type", String.valueOf(r31));
        r45.put("seq_type", GamePromoteDataContext.GAME_TYPE_MINI);
        r45.put("request_count", String.valueOf(l));
        g("livesdk_realtime_sequence_report", r45);
        Object r65 = r44;
    L183:
        r41.putOpt("single_feat", r65);
        final String r66 = r41.toString();
    L192:
        boolean r67 = com.bytedance.android.live.impl.utils.a.a;
        com.bytedance.android.live.impl.utils.a.d(r212, new RealtimeSequenceFilter$getLiveSequenceJson$1(r12, r114));
        com.bytedance.android.live.impl.utils.a.c(r212, new RealtimeSequenceFilter$getLiveSequenceJson$2(r66));
        return r66;
    L159:
        r58 = SetsKt.emptySet();     // Catch: Throwable -> L176
    L146:
        r53 = null;
    L176:
        th = move-exception;
        Result.Companion r68 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L178
    L180:
        if (r31 != 2) goto L182;
        u.remove(r7);
    L182:
        r65 = null;
    L116:
        r42 = "";
    L111:
        if (r38 != 2) goto L113;
    L185:
        if (r38 != 1) goto L189;
        if (r12.length() != 0) goto L189;
    L190:
        r66 = r16.toString();
    L189:
        if (r38 == 2) goto L190;
        r66 = r12.toString();
        goto L192
    L97:
        if (r16.length() <= 0) goto L103;
        if (r31 != 2) goto L101;
        r39 = r214;
        ((k0) x.getValue()).f(r213, new JSONObject().putOpt(r39, r16));
    L102:
        r16.remove(r16.length() - 1);
        r16 = f(r16, r12.optJSONObject(r12.length() - 1));
        goto L105
    L101:
        r39 = r214;
    L32:
        r16 = new JSONArray();
        goto L34
    L33:
        r16 = new JSONArray();
        goto L34
    }

    public final void g(String r5, Map<String, String> r6) {
        if (w == false) goto L5;
        j0.l().o("livesdk_realtime_sequence_report", r6, new Object[]{x.class});
        return;
    L5:
        j0.l().sendLog("livesdk_realtime_sequence_report", r6, new Object[]{x.class});
    }

    @Override // com.bytedance.android.live.impl.logfilter.f
    public final void onEvent(String r12, Map<String, String> r13) {
        Intrinsics.checkNotNullParameter(r12, "eventName");
        Intrinsics.checkNotNullParameter(r13, "params");
        int r4 = 0;
        switch(r12.hashCode()) {
            case -1122536402: goto L183;
            case -1115849514: goto L162;
            case -1103263308: goto L157;
            case -804282046: goto L152;
            case -773966155: goto L143;
            case -505186085: goto L138;
            case 21313630: goto L133;
            case 228634976: goto L56;
            case 516631638: goto L46;
            case 1059589542: goto L41;
            case 1499179894: goto L38;
            case 1881558686: goto L11;
            case 2041791848: goto L6;
            default: goto L234;
        };
    L234:
        return;
    L6:
        if (r12.equals("livesdk_like") == false) goto L202;
        JSONObject r14 = (JSONObject) CollectionsKt.lastOrNull(c);
        if (r14 == null) goto L203;
        r14.put(b("audience_like_cnt"), r14.optInt(b("audience_like_cnt"), 0) + 1);
        return;
    L203:
        return;
    L202:
        return;
    L11:
        if (r12.equals("livesdk_screen_message_show_summary") == false) goto L205;
        long r2 = System.currentTimeMillis();
        monitor-enter(this);
        ConcurrentLinkedQueue<Pair<Long, Integer>> r15 = d;     // Catch: Throwable -> L34
        Long r0 = Long.valueOf(r2);     // Catch: Throwable -> L34
        String r5 = r13.get("like_pv");     // Catch: Throwable -> L34
        if (r5 == null) goto L19;
        Integer r6 = StringsKt.toIntOrNull(r5);     // Catch: Throwable -> L34
        if (r6 == null) goto L19;
        int r7 = r6.intValue();     // Catch: Throwable -> L34
    L20:
        r15.offer(TuplesKt.to(r0, Integer.valueOf(r7)));     // Catch: Throwable -> L34
        ConcurrentLinkedQueue<Pair<Long, Integer>> r16 = e;     // Catch: Throwable -> L34
        Long r1 = Long.valueOf(r2);     // Catch: Throwable -> L34
        String r8 = r13.get("comment_pv");     // Catch: Throwable -> L34
        if (r8 == null) goto L25;
        Integer r9 = StringsKt.toIntOrNull(r8);     // Catch: Throwable -> L34
        if (r9 == null) goto L25;
        int r11 = r9.intValue();     // Catch: Throwable -> L34
    L26:
        r16.offer(TuplesKt.to(r1, Integer.valueOf(r11)));     // Catch: Throwable -> L34
        ConcurrentLinkedQueue<Pair<Long, Integer>> r17 = f;     // Catch: Throwable -> L34
        Long r3 = Long.valueOf(r2);     // Catch: Throwable -> L34
        String r18 = r13.get("gift_message_pv");     // Catch: Throwable -> L34
        if (r18 == null) goto L31;
        Integer r19 = StringsKt.toIntOrNull(r18);     // Catch: Throwable -> L34
        if (r19 == null) goto L31;
        r4 = r19.intValue();     // Catch: Throwable -> L34
    L31:
        r17.offer(TuplesKt.to(r3, Integer.valueOf(r4)));     // Catch: Throwable -> L34
        monitor-exit(this);
        update(null);
        boolean r110 = com.bytedance.android.live.impl.utils.a.a;
        com.bytedance.android.live.impl.utils.a.c("LFM-RealtimeSequenceFilter", AnonymousClass6.INSTANCE);
        return;
    L25:
        r11 = 0;
    L19:
        r7 = 0;
    L34:
        th = move-exception;
        throw th;
    L205:
        return;
    L38:
        if (r12.equals("livesdk_live_play") == true) goto L58;
        return;
    L58:
        if (Intrinsics.areEqual(r12, "livesdk_live_play") == false) goto L62;
        if (n == false) goto L62;
    L66:
        Map<String, String> r111 = r;
        String r21 = r13.get("room_id");
        if (r21 != null) goto L69;
        r21 = "";
    L69:
        String r22 = r13.get("anchor_id");
        if (r22 != null) goto L72;
        r22 = "";
    L72:
        r111.put(r21, r22);
        monitor-enter(this);
        ConcurrentLinkedQueue<Pair<Long, Integer>> r23 = d;     // Catch: Throwable -> L128
        if ((true ^ r23.isEmpty()) == false) goto L77;
        r23.clear();     // Catch: Throwable -> L128
        f.clear();     // Catch: Throwable -> L128
        e.clear();     // Catch: Throwable -> L128
    L77:
        Unit r24 = Unit.INSTANCE;     // Catch: Throwable -> L128
        monitor-exit(this);
        boolean r25 = com.bytedance.android.live.impl.utils.a.a;
        com.bytedance.android.live.impl.utils.a.c("LFM-RealtimeSequenceFilter", AnonymousClass2.INSTANCE);
        LimitSizeQueue<JSONObject> r26 = c;
        long r27 = 0;
        r26.add(new JSONObject().put(b("room_id"), "").put(b("anchor_id"), "").put(b("enter_anchor_id"), "").put(b("channel_id"), "").put(b("room_type"), 0).put(b("room_tags"), "").put(b("show_ts"), System.currentTimeMillis()).put(b("user_count_in_cur_room"), 0).put(b("like_cnt"), 0).put(b("message_cnt"), 0).put(b("send_gift_cnt"), 0).put(b("watch_dur"), 0).put(b("preview_watch_dur"), 0).put(b("audience_like_cnt"), 0).put(b("audience_message_cnt"), 0).put(b("audience_send_gift_cnt"), 0).put(b("follow"), 0).put(b("is_share"), 0).put(b("dislike"), 0).put(b("audience_send_gift_money_cnt"), 0).put(b("report"), 0).put(b("live_content_abslot0"), "").put(b("live_content_abslot1"), "").put(b("live_content_abslot2"), "").put(b("live_content_cluster_500"), "").put(b("live_content_cluster_2k"), "").put(b("live_content_cluster_5w"), "").put(b("live_content_his_cluster_5k"), "").put(b("live_content_his_cluster_20w"), ""));
        String r28 = r13.get("entrance_room_id");
        if (r28 != null) goto L82;
        r28 = "";
    L82:
        StringBuilder r29 = new StringBuilder();
        String r31 = r13.get("enter_from_merge");
        if (r31 != null) goto L85;
        r31 = "";
    L85:
        r29.append(r31);
        r29.append("-");
        String r32 = r13.get("enter_method");
        if (r32 != null) goto L88;
        r32 = "";
    L88:
        r29.append(r32);
        String r33 = r29.toString();
        Map<String, String> r34 = v;
        LinkedHashMap r35 = (LinkedHashMap) r34;
        if (r35.get(r33) != null) goto L91;
        r34.put(r33, r28);
    L95:
        if (o == false) goto L99;
        String r112 = (String) ((LinkedHashMap) r111).get(r28);
        if (r112 != null) goto L100;
        r112 = "";
    L100:
        JSONObject r36 = (JSONObject) CollectionsKt.lastOrNull(r26);
        if (r36 == null) goto L127;
        String r37 = b("room_id");
        String r38 = r13.get("room_id");
        if (r38 != null) goto L105;
        r38 = "";
    L105:
        JSONObject r39 = r36.put(r37, r38).put("enter_source", r33);
        String r41 = b("anchor_id");
        String r42 = r13.get("anchor_id");
        if (r42 != null) goto L108;
        r42 = "";
    L108:
        JSONObject r113 = r39.put(r41, r42).put(b("enter_anchor_id"), r112);
        String r43 = b("room_type");
        IRoomContextService r44 = jc1.k.f(IRoomContextService.class);
        if (r44 == null) goto L116;
        com.bytedance.android.livesdk.chatroom.o r45 = IRoomContextService.a.a(r44, null, 0, 3);
        if (r45 == null) goto L116;
        Room r46 = r45.o2();
        if (r46 == null) goto L116;
        String r47 = String.valueOf(r46.getLiveRoomMode());
        if (r47 == null) goto L116;
    L117:
        JSONObject r114 = r113.put(r43, r47).put(b("show_ts"), System.currentTimeMillis());
        String r48 = b("user_count_in_cur_room");
        FeatureManager r49 = FeatureManager.u;
        JSONObject r115 = r114.put(r48, ((Number) r49.getFeature("user_count_in_cur_room", 0)).intValue());
        String r51 = b("preview_watch_dur");
        Long r52 = StringsKt.toLongOrNull(((String) r49.getFeature("last_preview_duration", "0")).toString());
        if (r52 == null) goto L120;
        r27 = r52.longValue();
    L120:
        r115.put(r51, r27).put("entrance_room_id", r28);
        String r116 = r13.get("is_fans");
        if (r116 == null) goto L125;
        Integer r117 = StringsKt.toIntOrNull(r116);
        if (r117 == null) goto L125;
        r4 = r117.intValue();
    L125:
        if (r4 == 0) goto L127;
        r36.put(b("follow"), 2);
    L116:
        r47 = "";
    L127:
        com.bytedance.android.live.impl.utils.a.c("LFM-RealtimeSequenceFilter", AnonymousClass4.INSTANCE);
        return;
    L99:
        r112 = (String) FeatureManager.u.getFeature("enter_anchor_id", "");
        goto L100
    L91:
        r28 = (String) r35.get(r33);
        if (r28 != null) goto L95;
        r28 = "";
    L128:
        th = move-exception;
        throw th;
    L62:
        if (Intrinsics.areEqual(r12, "livesdk_enter_room_duration") == true) goto L64;
        return;
    L64:
        if (n == false) goto L66;
        return;
    L41:
        if (r12.equals("livesdk_live_user_report") == false) goto L208;
        JSONObject r118 = (JSONObject) CollectionsKt.lastOrNull(c);
        if (r118 == null) goto L209;
        r118.put(b("report"), 1);
        return;
    L209:
        return;
    L208:
        return;
    L46:
        if (r12.equals("livesdk_send_gift") == false) goto L211;
        JSONObject r119 = (JSONObject) CollectionsKt.lastOrNull(c);
        if (r119 == null) goto L212;
        JSONObject r53 = r119.put(b("audience_send_gift_cnt"), r119.optInt("audience_send_gift_cnt", 0) + 1);
        String r54 = b("audience_send_gift_money_cnt");
        int r120 = r119.optInt("audience_send_gift_money_cnt", 0);
        String r121 = r13.get("money");
        if (r121 == null) goto L54;
        Integer r122 = StringsKt.toIntOrNull(r121);
        if (r122 == null) goto L54;
        r4 = r122.intValue();
    L54:
        r53.put(r54, r120 + r4);
        return;
    L212:
        return;
    L211:
        return;
    L56:
        if (r12.equals("livesdk_enter_room_duration") == true) goto L58;
        return;
    L133:
        if (r12.equals("livesdk_audience_live_message") == false) goto L216;
        JSONObject r123 = (JSONObject) CollectionsKt.lastOrNull(c);
        if (r123 == null) goto L217;
        r123.put(b("audience_message_cnt"), r123.optInt("audience_message_cnt", 0) + 1);
        return;
    L217:
        return;
    L216:
        return;
    L138:
        if (r12.equals("livesdk_unfollow") == false) goto L219;
        JSONObject r124 = (JSONObject) CollectionsKt.lastOrNull(c);
        if (r124 == null) goto L220;
        r124.put(b("follow"), 3);
        return;
    L220:
        return;
    L219:
        return;
    L143:
        if (r12.equals("livesdk_live_leave") == false) goto L222;
        StringBuilder r125 = new StringBuilder();
        String r55 = r13.get("enter_from_merge");
        if (r55 != null) goto L147;
        r55 = "";
    L147:
        r125.append(r55);
        r125.append("-");
        String r126 = r13.get("enter_method");
        if (r126 != null) goto L150;
        r126 = "";
    L150:
        r125.append(r126);
        String r127 = r125.toString();
        v.remove(r127);
        return;
    L222:
        return;
    L152:
        if (r12.equals("livesdk_follow") == false) goto L224;
        JSONObject r128 = (JSONObject) CollectionsKt.lastOrNull(c);
        if (r128 == null) goto L225;
        r128.put(b("follow"), 1);
        return;
    L225:
        return;
    L224:
        return;
    L157:
        if (r12.equals("livesdk_dislike") == false) goto L227;
        JSONObject r129 = (JSONObject) CollectionsKt.lastOrNull(c);
        if (r129 == null) goto L228;
        r129.put(b("dislike"), 1);
        return;
    L228:
        return;
    L227:
        return;
    L162:
        if (r12.equals("livesdk_live_duration") == false) goto L230;
        if (r13 == null) goto L181;
        String r130 = r13.get("live_recommend_info");
        if (r130 == null) goto L181;
        if (StringsKt.isBlank(r130) == true) goto L181;
        Result.Companion r56 = Result.Companion;     // Catch: Throwable -> L179
        JSONObject r57 = new JSONObject(r130);     // Catch: Throwable -> L179
        Iterator<String> r131 = s.iterator();     // Catch: Throwable -> L179
    L171:
        if (r131.hasNext() == false) goto L177;
        String r58 = r131.next();     // Catch: Throwable -> L179
        Object r59 = r57.opt(r58);     // Catch: Throwable -> L179
        if (r59 == null) goto L171;
        JSONObject r61 = (JSONObject) CollectionsKt.lastOrNull(c);     // Catch: Throwable -> L179
        if (r61 == null) goto L171;
        r61.put(b(r58), r59);     // Catch: Throwable -> L179
        goto L171
    L177:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L179
    L179:
        th = move-exception;
        Result.Companion r62 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L181:
        update(r13);
        boolean r132 = com.bytedance.android.live.impl.utils.a.a;
        com.bytedance.android.live.impl.utils.a.c("LFM-RealtimeSequenceFilter", AnonymousClass10.INSTANCE);
        return;
    L230:
        return;
    L183:
        if (r12.equals("livesdk_share") == false) goto L232;
        JSONObject r133 = (JSONObject) CollectionsKt.lastOrNull(c);
        if (r133 == null) goto L233;
        r133.put(b("is_share"), 1);
        return;
    L233:
        return;
    }

    public final void e(JSONArray r21, int r22, JSONObject r23) {
        if (a.getLogEnable() == false) goto L37;
        int r2 = r21.length();
        l++;
        int r7 = 0;
        g("livesdk_realtime_sequence_report", MapsKt.mapOf(new Pair[]{TuplesKt.to("sequence_count", String.valueOf(r2)), TuplesKt.to("request_count", String.valueOf(l)), TuplesKt.to("report_type", String.valueOf(r22)), TuplesKt.to("seq_type", GamePromoteDataContext.GAME_TYPE_MOBILE)}));
    L5:
        if (r7 >= r2) goto L53;
        JSONObject r11 = r21.optJSONObject(r7);
        Pair<Long, Long> r12 = TuplesKt.to(Long.valueOf(r11.optLong(b("room_id"), 0)), Long.valueOf(r11.optLong(b("show_ts"), 0)));
        if (k.contains(r12) == true) goto L36;
        HashMap r13 = new HashMap();
        Iterator<String> r14 = r11.keys();
    L11:
        if (r14.hasNext() == false) goto L27;
        String r15 = r14.next();
        if (StringsKt.toIntOrNull(r15) != null) goto L17;
        Object r16 = r11.opt(r15);
        if (r16 == null) goto L11;
        String r3 = (String) r13.put(r15, r16.toString());
        goto L11
    L17:
        Iterator r4 = ((Map) z.getValue()).entrySet().iterator();
    L19:
        if (r4.hasNext() == false) goto L11;
        Map.Entry r17 = (Map.Entry) r4.next();
        Iterator r18 = r4;
        if (Intrinsics.areEqual((String) r17.getValue(), r15) == true) goto L22;
        r4 = r18;
        goto L19
    L22:
        Object r5 = r11.opt(r15);
        if (r5 == null) goto L11;
        String r6 = (String) r13.put(r17.getKey(), r5.toString());
        goto L11
    L27:
        r13.put("room_order", String.valueOf(k.size()));
        r13.put("sequence_count", String.valueOf(r2));
        r13.put("request_count", String.valueOf(l));
        r13.put("report_type", String.valueOf(r22));
        r13.put("seq_type", GamePromoteDataContext.GAME_TYPE_MOBILE);
        if (r23 == null) goto L35;
        Iterator<String> r8 = r23.keys();
    L31:
        if (r8.hasNext() == false) goto L35;
        String r19 = r8.next();
        Object r110 = r23.opt(r19);
        if (r110 == null) goto L31;
        String r111 = (String) r13.put(r19, r110.toString());
    L35:
        k.add(r12);
        g("livesdk_realtime_sequence_report", r13);
    L36:
        r7 = r7 + 1;
        goto L5
    L53:
        return;
    }
}
