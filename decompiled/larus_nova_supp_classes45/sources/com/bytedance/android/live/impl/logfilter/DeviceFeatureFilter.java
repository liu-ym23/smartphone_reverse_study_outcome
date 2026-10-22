package com.bytedance.android.live.impl.logfilter;

import android.app.ActivityManager;
import android.content.Context;
import android.media.AudioManager;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.LongSparseArray;
import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.live.core.utils.FileUtils;
import com.bytedance.android.live.core.utils.NetworkUtils;
import com.bytedance.android.live.core.utils.i0;
import com.bytedance.android.live.core.utils.k0;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.feature.api.FeatureType;
import com.bytedance.android.live.impl.service.FeatureManager;
import com.bytedance.android.live.impl.service.FeedFeatureManager;
import com.bytedance.android.live.impl.utils.LimitSizeQueue;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdkapi.api.IUtilsCommonService;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.service.ILiveNetworkPredict;
import com.bytedance.android.livesdkapi.service.IMiddleWarePerformanceManager;
import com.bytedance.common.utility.concurrent.TTExecutors;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import j40.c0;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class DeviceFeatureFilter extends d implements f, z90.a.b {
    public static volatile boolean A;
    public static final Object B = null;
    public static volatile boolean C;
    public static volatile boolean D;
    public static volatile boolean E;
    public static volatile boolean F;
    public static h G;
    public static JSONObject H;
    public static final List<String> I = null;
    public static long J;
    public static long K;
    public static final Lazy L = null;
    public static ScheduledFuture<?> M;
    public static final b N = null;
    public static final DeviceFeatureFilter O = null;
    public static float b;
    public static float c;
    public static final Deque<Float> d = null;
    public static final Deque<Integer> e = null;
    public static float f;
    public static float g;
    public static int h;
    public static final ArrayList<Float> i = null;
    public static final ArrayList<Float> j = null;
    public static final ArrayList<Float> k = null;
    public static final LongSparseArray<Float> l = null;
    public static final LongSparseArray<Float> m = null;
    public static final LongSparseArray<Float> n = null;
    public static long o;
    public static long p;
    public static final LimitSizeQueue<Long> q = null;
    public static final LimitSizeQueue<Long> r = null;
    public static boolean s;
    public static volatile long t;
    public static boolean u;
    public static boolean v;
    public static int w;
    public static final Deque<Long> x = null;
    public static long y;
    public static long z;

    public static final class a implements Runnable {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public static void a() {
            IMiddleWareHostContext r0 = jc1.k.f(IMiddleWareHostContext.class);
            Integer r1 = null;
            if (r0 == null) goto L7;
            Context r2 = r0.context();
            if (r2 == null) goto L7;
            Object r3 = r2.getSystemService("audio");
        L9:
            if ((r3 instanceof AudioManager) == true) goto L11;
            r3 = null;
        L11:
            AudioManager r4 = (AudioManager) r3;
            if (r4 == null) goto L14;
            Integer r5 = Integer.valueOf(r4.getStreamVolume(3));
        L15:
            if (r4 == null) goto L17;
            r1 = Integer.valueOf(r4.getStreamMaxVolume(3));
        L17:
            FeatureManager r6 = FeatureManager.u;
            z90.a.C0301a.a(r6, "current_media_volume", r5);
            z90.a.C0301a.a(r6, "max_media_volume", r1);
            float r7 = DeviceFeatureFilter.b;
            DeviceFeatureFilter.C = false;
            z90.a.C0301a.a(r6, "media_volume_obtain_time", Long.valueOf(System.currentTimeMillis()));
            return;
        L14:
            r5 = null;
        L7:
            r3 = null;
            goto L9
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b implements Runnable {
        public b() {
        }

        public final void a() {
            List<String> r0 = FeedFeatureManager.a;
            Float r1 = Float.valueOf(0.0f);
            Float r2 = (Float) FeedFeatureManager.a("aweme_common_cpu_proc_rate", r1);
            Float r3 = (Float) FeedFeatureManager.a("aweme_common_cpu_rate", r1);
            FeatureManager r4 = FeatureManager.u;
            z90.a.C0301a.a(r4, "preview_cpu_proc_rate", r2);
            z90.a.C0301a.a(r4, "preview_cpu_rate", r3);
            float r5 = ((Number) r4.getFeature("downstream_throughput_kbps", 0)).intValue();
            float r6 = ((Number) r4.getFeature("net_quality", 0)).intValue();
            h r7 = DeviceFeatureFilter.G;
            Float r11 = null;
            if (r7 == null) goto L5;
            r7.b(false, new Float[]{null, null, null, Float.valueOf(r5), Float.valueOf(r6), r2, r3});
        L5:
            h r8 = DeviceFeatureFilter.G;
            if (r8 == null) goto L8;
            List<Float> r9 = r8.a();
        L9:
            if (r9 == null) goto L11;
            Float r12 = (Float) ListProtector.get(r9, 3);
        L12:
            z90.a.C0301a.a(r4, "downstream_throughput_kbps_in_last_minute", r12);
            if (r9 == null) goto L15;
            Float r13 = (Float) ListProtector.get(r9, 4);
        L16:
            z90.a.C0301a.a(r4, "net_quality_in_last_minute", r13);
            if (r9 == null) goto L19;
            Float r14 = (Float) ListProtector.get(r9, 5);
        L20:
            z90.a.C0301a.a(r4, "preview_cpu_proc_rate_in_last_minute", r14);
            if (r9 == null) goto L23;
            r11 = (Float) ListProtector.get(r9, 6);
        L23:
            z90.a.C0301a.a(r4, "preview_cpu_rate_in_last_minute", r11);
            DeviceFeatureFilter.M = TTExecutors.getScheduledThreadPool().schedule(this, 10, TimeUnit.SECONDS);
            return;
        L19:
            r14 = null;
            goto L20
        L15:
            r13 = null;
            goto L16
        L11:
            r12 = null;
            goto L12
        L8:
            r9 = null;
            goto L9
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // com.bytedance.android.live.impl.logfilter.d
    public final void b(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "event");
        Intrinsics.checkNotNullParameter(r3, "name");
    }

    static {
        DeviceFeatureFilter r0 = new DeviceFeatureFilter();
        O = r0;
        b = -1.0f;
        c = -1.0f;
        d = new LinkedList();
        e = new LinkedList();
        i = new ArrayList();
        j = new ArrayList();
        k = new ArrayList();
        l = new LongSparseArray();
        m = new LongSparseArray();
        n = new LongSparseArray();
        o = -1;
        p = -1;
        q = new LimitSizeQueue(0, 1, null);
        r = new LimitSizeQueue(0, 1, null);
        s = true;
        t = System.currentTimeMillis();
        x = new LinkedList();
        y = Long.MAX_VALUE;
        z = Long.MAX_VALUE;
        B = new Object();
        I = CollectionsKt.listOf(new String[]{"cpu_rate", "gpu_rate", "fps_ui", "fps_stream", "temperature_android", "ui_total_stall_rate", "video_total_stall_rate", "ui_slight_stall_rate", "ui_moderate_stall_rate", "ui_serious_stall_rate", "video_ui_total_stall_rate"});
        L = LazyKt.lazy(DeviceFeatureFilter$kevaOrSpHelper$2.INSTANCE);
        FeatureManager r1 = FeatureManager.u;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r0, FileUtils.FILTER);
        FeatureManager.m.add(r0);
        r1.e(r0, CollectionsKt.listOf(new String[]{"livesdk_performance_monitor_base_new", "livesdk_performance_base_data_ready", "livesdk_performance_fps_data_ready"}));
        TTExecutors.getNormalExecutor().submit(new DeviceFeatureFilter$updateStallSp$1(false));
        j(false);
        TTExecutors.getNormalExecutor().submit(com.bytedance.android.live.impl.logfilter.a.a);
        G = new h();
        h(true);
        TTExecutors.getNormalExecutor().submit(new DeviceFeatureFilter$updateFirstRoomPerformance$1(false));
        TTExecutors.getNormalExecutor().submit(new DeviceFeatureFilter$updateStopLiveReasonCount$1(true, null));
        N = new b();
    }

    public static Pair f() {
        FeatureManager r0 = FeatureManager.u;
        long r1 = ((Number) r0.getFeature("media_volume_obtain_time", 0L)).longValue();
        if ((System.currentTimeMillis() - r1) <= 10000) goto L8;
        if (C == true) goto L8;
        C = true;
        TTExecutors.getNormalExecutor().submit(a.a);
    L8:
        return TuplesKt.to(r0.getFeature("current_media_volume", 0), r0.getFeature("max_media_volume", 0));
    }

    public DeviceFeatureFilter() {
    }

    public static final k0 e(DeviceFeatureFilter r0) {
        r0.getClass();
        return (k0) L.getValue();
    }

    public static void g(Map r16) {
        FeatureManager r1 = FeatureManager.u;
        z90.a.C0301a.a(r1, "performance_report_count", Integer.valueOf(((Number) r1.getFeature("performance_report_count", 0)).intValue() + 1));
        String r7 = (String) r16.get("cpu_rate");
        if (r7 == null) goto L5;
        r1.i("cpu_rate", Float.valueOf(CastFloatProtector.parseFloat(r7)), FeatureType.DYNAMIC);
        Float r5 = Float.valueOf(CastFloatProtector.parseFloat(r7));
    L6:
        IRoomContextService r8 = jc1.k.f(IRoomContextService.class);
        if (r8 == null) goto L15;
        com.bytedance.android.livesdk.chatroom.o r9 = IRoomContextService.a.a(r8, null, 0, 3);
        if (r9 == null) goto L15;
        ILivePlayerClient r11 = r9.V1();
        if (r11 == null) goto L15;
        String r12 = r11.getCurrentResolution();
        if (r12 == null) goto L15;
        r16.put("current_resolution", r12);
        z90.a.C0301a.a(r1, "current_resolution", r12);
    L15:
        String r13 = (String) r16.get("gpu_usage");
        if (r13 == null) goto L18;
        r1.i("gpu_rate", Float.valueOf(CastFloatProtector.parseFloat(r13)), FeatureType.DYNAMIC);
    L18:
        String r14 = (String) r16.get("battery_level");
        if (r14 == null) goto L21;
        r1.i("battery_level", Float.valueOf(CastFloatProtector.parseFloat(r14)), FeatureType.DYNAMIC);
    L21:
        String r15 = (String) r16.get("fps");
        if (r15 == null) goto L24;
        r1.i("fps_ui", Float.valueOf(CastFloatProtector.parseFloat(r15)), FeatureType.DYNAMIC);
    L24:
        String r17 = (String) r16.get("stream_real_fps");
        if (r17 == null) goto L27;
        r1.i("fps_stream", Float.valueOf(CastFloatProtector.parseFloat(r17)), FeatureType.DYNAMIC);
    L27:
        String r18 = (String) r16.get("net_quality");
        if (r18 == null) goto L30;
        r1.i("net_quality", Integer.valueOf(CastIntegerProtector.parseInt(r18)), FeatureType.DYNAMIC);
        Float r19 = Float.valueOf(CastFloatProtector.parseFloat(r18));
    L31:
        String r110 = (String) r16.get("battery_state_android");
        if (r110 == null) goto L34;
        r1.i("battery_state_android", Integer.valueOf(CastIntegerProtector.parseInt(r110)), FeatureType.DYNAMIC);
    L34:
        String r111 = (String) r16.get("temperature_android");
        if (r111 == null) goto L37;
        r1.i("temperature_android", Float.valueOf(CastFloatProtector.parseFloat(r111)), FeatureType.DYNAMIC);
    L37:
        String r112 = (String) r16.get("mem_pss_native");
        if (r112 == null) goto L40;
        z90.a.C0301a.a(r1, "mem_pss_native", Float.valueOf(CastFloatProtector.parseFloat(r112)));
    L40:
        String r113 = (String) r16.get("mem_java_used");
        if (r113 == null) goto L43;
        z90.a.C0301a.a(r1, "mem_java_used", Float.valueOf(CastFloatProtector.parseFloat(r113)));
    L43:
        String r114 = (String) r16.get("mem_pss_total");
        if (r114 == null) goto L46;
        z90.a.C0301a.a(r1, "mem_pss_total", Float.valueOf(CastFloatProtector.parseFloat(r114)));
    L46:
        String r115 = (String) r16.get("stall_ui_rate");
        if (r115 == null) goto L49;
        Float r116 = Float.valueOf(CastFloatProtector.parseFloat(r115));
    L50:
        String r117 = (String) r16.get("stall_video_rate");
        if (r117 == null) goto L53;
        Float r118 = Float.valueOf(CastFloatProtector.parseFloat(r117));
    L54:
        float r119 = ((Number) r1.getFeature("downstream_throughput_kbps", 0)).intValue();
        if (G != null) goto L57;
        G = new h();
    L57:
        h r120 = G;
        if (r120 == null) goto L60;
        r120.b(false, new Float[]{r5, r116, r118, Float.valueOf(r119), r19});
    L60:
        h r6 = G;
        if (r6 == null) goto L63;
        List<Float> r21 = r6.a();
    L64:
        if (r21 == null) goto L66;
        Float r2 = (Float) ListProtector.get(r21, 0);
    L67:
        z90.a.C0301a.a(r1, "cpu_rate_in_last_minute", r2);
        if (r21 == null) goto L70;
        Float r3 = (Float) ListProtector.get(r21, 1);
    L71:
        z90.a.C0301a.a(r1, "stall_ui_rate_in_last_minute", r3);
        if (r21 == null) goto L74;
        Float r4 = (Float) ListProtector.get(r21, 2);
    L75:
        z90.a.C0301a.a(r1, "stall_video_rate_in_last_minute", r4);
        if (r21 == null) goto L78;
        Float r22 = (Float) ListProtector.get(r21, 3);
    L79:
        z90.a.C0301a.a(r1, "downstream_throughput_kbps_in_last_minute", r22);
        if (r21 == null) goto L82;
        Float r23 = (Float) ListProtector.get(r21, 4);
    L83:
        z90.a.C0301a.a(r1, "net_quality_in_last_minute", r23);
        String r24 = (String) r16.get("has_stall");
        if (r24 == null) goto L86;
        Integer r25 = Integer.valueOf(CastIntegerProtector.parseInt(r24));
    L87:
        FeatureType r26 = FeatureType.DYNAMIC;
        r1.i("has_stall", r25, r26);
        if (r25 != null) goto L91;
    L99:
        String r27 = (String) r16.get("stall_monitor_duration");
        if (r27 == null) goto L102;
        Long r28 = Long.valueOf(CastLongProtector.parseLong(r27));
    L103:
        String r29 = (String) r16.get("stall_ui_duration");
        if (r29 == null) goto L106;
        float r31 = CastFloatProtector.parseFloat(r29);
    L107:
        String r32 = (String) r16.get("stall_video_duration");
        if (r32 == null) goto L110;
        float r33 = CastFloatProtector.parseFloat(r32);
    L111:
        if (r28 == null) goto L152;
        if (r31 > r28.longValue()) goto L152;
        if (r33 > r28.longValue()) goto L152;
        h++;
        String r34 = (String) r16.get("stall_ui_rate");
        if (r34 != null) goto L119;
    L121:
        String r35 = (String) r16.get("stall_video_rate");
        if (r35 != null) goto L124;
    L126:
        String r36 = (String) r16.get("stall_ui_slight_rate");
        if (r36 == null) goto L129;
        r1.i("ui_slight_stall_rate", Float.valueOf(CastFloatProtector.parseFloat(r36)), r26);
    L129:
        String r37 = (String) r16.get("stall_ui_moderate_rate");
        if (r37 == null) goto L132;
        r1.i("ui_moderate_stall_rate", Float.valueOf(CastFloatProtector.parseFloat(r37)), r26);
    L132:
        String r38 = (String) r16.get("stall_ui_serious_rate");
        if (r38 == null) goto L135;
        r1.i("ui_serious_stall_rate", Float.valueOf(CastFloatProtector.parseFloat(r38)), r26);
    L135:
        String r39 = (String) r16.get("stall_video_ui_rate");
        if (r39 == null) goto L152;
        if (r1.i("video_ui_total_stall_rate", Float.valueOf(CastFloatProtector.parseFloat(r39)), r26) == false) goto L152;
        DeviceFeatureFilter r41 = O;
        float r121 = CastFloatProtector.parseFloat(r39);
        r41.getClass();
        Deque<Float> r42 = d;
        LinkedList r122 = (LinkedList) r42;
        Float r123 = (Float) r122.pollLast();
        if (r123 == null) goto L142;
        r122.offerLast(Float.valueOf(r123.floatValue() + r121));
    L143:
        Deque<Integer> r124 = e;
        LinkedList r125 = (LinkedList) r124;
        Integer r126 = (Integer) r125.pollFirst();
        if (r126 == null) goto L146;
        r125.offerLast(Integer.valueOf(r126.intValue() + 1));
    L148:
        if (CollectionsKt.sumOfInt(r124) == 0) goto L150;
        r1.i("latest_room_video_ui_total_stall_rate_avg", Float.valueOf(CollectionsKt.sumOfFloat(r42) / CollectionsKt.sumOfInt(r124)), r26);
    L150:
        f += r121;
        r1.i("ui_stall_duration_sum", Float.valueOf(CastFloatProtector.parseFloat(r39) * r28.longValue()), r26);
        ArrayList<Float> r43 = k;
        r43.add(Float.valueOf(CastFloatProtector.parseFloat(r39)));
        r1.i("ui_video_total_stall_rate_cur_room", Float.valueOf(CollectionsKt.sumOfFloat(r43) / r43.size()), r26);
        i("avg_ui_video_total_stall_rate_last_one_minute", CastFloatProtector.parseFloat(r39), n);
        goto L152
    L146:
        r125.offerLast(1);
        goto L148
    L142:
        r122.offerLast(Float.valueOf(r121));
        goto L143
    L124:
        if (r1.i("video_total_stall_rate", Float.valueOf(CastFloatProtector.parseFloat(r35)), r26) == false) goto L126;
        r1.i("video_stall_duration", Float.valueOf(CastFloatProtector.parseFloat(r35) * r28.longValue()), r26);
        ArrayList<Float> r44 = j;
        r44.add(Float.valueOf(CastFloatProtector.parseFloat(r35)));
        r1.i("video_total_stall_rate_cur_room", Float.valueOf(CollectionsKt.sumOfFloat(r44) / r44.size()), r26);
        DeviceFeatureFilter r45 = O;
        float r46 = CastFloatProtector.parseFloat(r35);
        LongSparseArray<Float> r127 = m;
        r45.getClass();
        i("avg_video_total_stall_rate_last_one_minute", r46, r127);
        goto L126
    L119:
        if (r1.i("ui_total_stall_rate", Float.valueOf(CastFloatProtector.parseFloat(r34)), r26) == false) goto L121;
        ArrayList<Float> r47 = i;
        r47.add(Float.valueOf(CastFloatProtector.parseFloat(r34)));
        r1.i("ui_total_stall_rate_cur_room", Float.valueOf(CollectionsKt.sumOfFloat(r47) / r47.size()), r26);
        DeviceFeatureFilter r48 = O;
        float r128 = CastFloatProtector.parseFloat(r34);
        LongSparseArray<Float> r129 = l;
        r48.getClass();
        i("avg_ui_total_stall_rate_last_one_minute", r128, r129);
        g += CastFloatProtector.parseFloat(r34);
        r1.i("ui_stall_duration", Float.valueOf(CastFloatProtector.parseFloat(r34) * r28.longValue()), r26);
    L152:
        if (TextUtils.equals((CharSequence) r16.get("draw_room_count"), GamePromoteDataContext.GAME_TYPE_MOBILE) == true) goto L154;
        return;
    L154:
        if (H != null) goto L156;
        H = new JSONObject();
    L156:
        JSONObject r0 = H;
        if (r0 == null) goto L159;
        r0.putOpt("performance_report_count", r1.getFeature("performance_report_count", 0));
    L159:
        Iterator<String> r49 = I.iterator();
    L161:
        if (r49.hasNext() == false) goto L179;
        String r51 = r49.next();
        JSONObject r52 = H;
        if (r52 == null) goto L161;
        Object r53 = r52.opt(r51);
        if (r53 == null) goto L171;
        String r54 = r53.toString();
        if (r54 == null) goto L171;
        Float r55 = StringsKt.toFloatOrNull(r54);
        if (r55 == null) goto L171;
        float r56 = r55.floatValue();
    L172:
        r52.putOpt(r51, Float.valueOf(r56 + ((Number) FeatureManager.u.getFeature(r51, Float.valueOf(0.0f))).floatValue()));
    L171:
        r56 = 0.0f;
        goto L172
    L179:
        return;
    L110:
        r33 = 0.0f;
        goto L111
    L106:
        r31 = 0.0f;
        goto L107
    L102:
        r28 = null;
        goto L103
    L91:
        if (r25.intValue() != 1) goto L99;
        if (u == true) goto L95;
        u = true;
        int r57 = w + 1;
        w = r57;
        r1.i("stall_room_count", Integer.valueOf(r57), FeatureType.MONITOR);
        d.c("stall_room_count_in_last_minute", x, t);
    L97:
        if (v == true) goto L99;
        v = true;
        goto L99
    L95:
        d.d("stall_room_count_in_last_minute", x, 1, t);
        goto L97
    L86:
        r25 = null;
        goto L87
    L82:
        r23 = null;
        goto L83
    L78:
        r22 = null;
        goto L79
    L74:
        r4 = null;
        goto L75
    L70:
        r3 = null;
        goto L71
    L66:
        r2 = null;
        goto L67
    L63:
        r21 = null;
        goto L64
    L53:
        r118 = null;
        goto L54
    L49:
        r116 = null;
        goto L50
    L30:
        r19 = null;
        goto L31
    L5:
        r5 = null;
        goto L6
    }

    public static void h(boolean r3) {
        if (c0.a.getValue().getTimerUpdatePreviewPerformanceDataEnable() == true) goto L5;
        return;
    L5:
        if (r3 == false) goto L7;
        i0.c().postDelayed(N, 10000);
        return;
    L7:
        FeatureManager r4 = FeatureManager.u;
        r4.g("preview_cpu_proc_rate_in_last_minute");
        r4.g("preview_cpu_rate_in_last_minute");
        i0.c().removeCallbacks(N);
        ScheduledFuture<?> r5 = M;
        if (r5 == null) goto L12;
        r5.cancel(true);
        M = null;
        return;
    }

    public static void j(final boolean r6) {
        final boolean r0 = false;
        if (r6 == true) goto L5;
        TTExecutors.getNormalExecutor().submit(new DeviceFeatureFilter$updateStallLiveSensitivity$1(r6, r0));
        return;
    L5:
        if ((t - z) > 4000) goto L7;
    L10:
        v = false;
        z = Long.MAX_VALUE;
        return;
    L7:
        if (v == false) goto L9;
        final boolean r3 = true;
        TTExecutors.getNormalExecutor().submit(new DeviceFeatureFilter$updateStallLiveSensitivity$1(r6, r3));
        goto L10
    L9:
        TTExecutors.getNormalExecutor().submit(new DeviceFeatureFilter$updateStallLiveSensitivity$1(r6, r0));
        goto L10
    }

    public static void k(final boolean r6) {
        final boolean r0 = false;
        if (r6 == true) goto L5;
        TTExecutors.getNormalExecutor().submit(new DeviceFeatureFilter$updateStallRoomSensitivity$1(r6, r0, r0));
        return;
    L5:
        if ((t - y) <= 4000) goto L10;
        final boolean r2 = true;
        if (u == false) goto L9;
        TTExecutors.getNormalExecutor().submit(new DeviceFeatureFilter$updateStallRoomSensitivity$1(r6, r2, r2));
        goto L10
    L9:
        TTExecutors.getNormalExecutor().submit(new DeviceFeatureFilter$updateStallRoomSensitivity$1(r6, r0, r2));
    L10:
        y = Long.MAX_VALUE;
    }

    @Override // z90.d
    public final <T> T getFeature(String r21) {
        Intrinsics.checkNotNullParameter(r21, "name");
        float r8 = 0.0f;
        Object r18 = null;
        switch(r21.hashCode()) {
            case -1647524527: goto L230;
            case -1558685080: goto L214;
            case -1461836708: goto L204;
            case -1397544228: goto L178;
            case -1229254350: goto L170;
            case -1122782410: goto L163;
            case -1092696215: goto L156;
            case -1043617622: goto L147;
            case -673046076: goto L140;
            case -539088102: goto L133;
            case -517803827: goto L130;
            case -222188874: goto L122;
            case -195248236: goto L110;
            case -132747717: goto L107;
            case 64034871: goto L100;
            case 153580274: goto L97;
            case 486611476: goto L94;
            case 516859105: goto L76;
            case 872743585: goto L50;
            case 948624559: goto L44;
            case 1033970781: goto L25;
            case 1735689732: goto L6;
            default: goto L236;
        };
    L236:
        T r0 = (T) r18;
        z90.a.C0301a.a(FeatureManager.u, r21, r0);
        return r0;
    L6:
        if (r21.equals("screen_brightness") == false) goto L236;
        if ((System.currentTimeMillis() - ((Number) FeatureManager.u.getFeature("screen_brightness_obtain_time", 0L)).longValue()) > 10000) goto L10;
    L12:
        Object r1 = FeatureManager.a.get("screen_brightness");
        if ((r1 instanceof Float) == true) goto L15;
        r1 = null;
    L15:
        Float r2 = (Float) r1;
        if (r2 == null) goto L18;
        float r3 = r2.floatValue();
    L20:
        if (r3 == (-1.0f)) goto L236;
        Object r4 = Float.valueOf(r3);
        if ((r4 instanceof Object) == false) goto L236;
    L48:
        r18 = r4;
        goto L236
    L18:
        r3 = -1.0f;
        goto L20
    L10:
        if (D == true) goto L12;
        D = true;
        TTExecutors.getNormalExecutor().submit(DeviceFeatureFilter$getScreenBrightness$1.a);
        goto L12
    L25:
        if (r21.equals("net_quality") == false) goto L236;
        if (A == true) goto L236;
        if ((System.currentTimeMillis() - K) >= 1000) goto L31;
        return null;
    L31:
        IMiddlewareHostApp r5 = jc1.k.f(IMiddlewareHostApp.class);
        if (r5 == null) goto L36;
        Map r6 = r5.getNQEParams();
        if (r6 == null) goto L36;
        String r7 = (String) r6.get("net_effective_connection_type");
    L37:
        if (r7 == null) goto L42;
        Integer r9 = StringsKt.toIntOrNull(r7);
        if ((r9 instanceof Object) == false) goto L42;
        r18 = r9;
    L42:
        K = System.currentTimeMillis();
    L36:
        r7 = null;
        goto L37
    L44:
        if (r21.equals("performance_monitor_ready") == false) goto L236;
        r4 = Boolean.valueOf(A);
        if ((r4 instanceof Object) == true) goto L48;
    L50:
        if (r21.equals("auto_brightness_enable") == false) goto L236;
        FeatureManager r11 = FeatureManager.u;
        if ((System.currentTimeMillis() - ((Number) r11.getFeature("brightness_auto_mode_fetch_time", 0L)).longValue()) > 10000) goto L54;
    L64:
        FeatureManager.u.getClass();
        Object r12 = FeatureManager.a.get("auto_brightness_enable");
        if ((r12 instanceof Integer) == true) goto L67;
        r12 = null;
    L67:
        Integer r13 = (Integer) r12;
        if (r13 == null) goto L70;
        int r14 = r13.intValue();
    L71:
        if (r14 == (-1)) goto L236;
        r4 = Integer.valueOf(r14);
        if ((r4 instanceof Object) == true) goto L48;
    L70:
        r14 = -1;
        goto L71
    L54:
        if (F == true) goto L64;
        F = true;
        List<String> r15 = FeedFeatureManager.a;     // Catch: Throwable -> L62
        Number r16 = FeedFeatureManager.c("common", "brightness_auto");     // Catch: Throwable -> L62
        if (r16 == null) goto L59;
        int r17 = r16.intValue();     // Catch: Throwable -> L62
    L60:
        z90.a.C0301a.a(r11, "auto_brightness_enable", Integer.valueOf(r17));     // Catch: Throwable -> L62
        z90.a.C0301a.a(r11, "brightness_auto_mode_fetch_time", Long.valueOf(System.currentTimeMillis()));     // Catch: Throwable -> L62
        F = false;     // Catch: Throwable -> L62
        goto L64
    L59:
        r17 = -1;
    L62:
        th = move-exception;
        boolean r19 = com.bytedance.android.live.impl.utils.a.a;
        com.bytedance.android.live.impl.utils.a.b(this.a, new DeviceFeatureFilter$getBrightnessAutoMode$1(th), th);
        goto L64
    L76:
        if (r21.equals("current_media_volume_percent") == false) goto L236;
        Integer r22 = (Integer) f().getFirst();
        Integer r23 = (Integer) f().getSecond();
        if (r23 == null) goto L80;
        Float r24 = Float.valueOf(r23.intValue());
    L81:
        if (r24 != null) goto L83;
    L86:
        r4 = null;
    L87:
        FeatureManager r25 = FeatureManager.u;
        if (z90.a.C0301a.a(r25, r21, r4) == true) goto L90;
        r25.g(r21);
        goto L236
    L90:
        if ((r4 instanceof Object) == true) goto L48;
    L83:
        if ((!Intrinsics.areEqual(r24, 0.0f)) == false) goto L86;
        if (r22 == null) goto L86;
        r4 = Float.valueOf(r22.intValue() / r24.floatValue());
        goto L87
    L80:
        r24 = null;
        goto L81
    L94:
        if (r21.equals("video_download_speed") == false) goto L236;
    L206:
        if ((System.currentTimeMillis() - J) >= 1000) goto L208;
        return null;
    L208:
        JSONObject r26 = jc1.k.n(IUtilsCommonService.class).nQECommonParamsBuild();
        if ((r26 instanceof JSONObject) == false) goto L211;
        Integer r27 = Integer.valueOf(r26.optInt("downstream_throughput_kbps"));
        Integer r28 = Integer.valueOf(r26.optInt("http_rtt"));
        Integer r29 = Integer.valueOf(r26.optInt("tcp_rtt"));
        Integer r31 = Integer.valueOf(r26.optInt("video_download_speed"));
        Integer r32 = Integer.valueOf(r31.intValue() * 8);
    L212:
        FeatureManager r33 = FeatureManager.u;
        z90.a.C0301a.a(r33, "downstream_throughput_kbps", r27);
        z90.a.C0301a.a(r33, "video_download_speed", r31);
        z90.a.C0301a.a(r33, "video_download_speed_8", r32);
        z90.a.C0301a.a(r33, "http_rtt", r28);
        z90.a.C0301a.a(r33, "transport_rtt", r29);
        J = System.currentTimeMillis();
        goto L236
    L211:
        r31 = null;
        r27 = null;
        r28 = null;
        r29 = null;
        r32 = null;
        goto L212
    L97:
        if (r21.equals("downstream_throughput_kbps") == false) goto L236;
    L100:
        if (r21.equals("net_predict") == false) goto L236;
        ILiveNetworkPredict r34 = jc1.k.f(ILiveNetworkPredict.class);
        if (r34 == null) goto L236;
        int r35 = r34.obtainNetPredict();
        z90.a.C0301a.a(FeatureManager.u, r21, Integer.valueOf(r35));
        r4 = Integer.valueOf(r35);
        if ((r4 instanceof Object) == true) goto L48;
    L107:
        if (r21.equals("http_rtt") == false) goto L236;
    L110:
        if (r21.equals("memory_available_rate") == false) goto L236;
        Context r36 = jc1.k.n(IMiddleWareHostContext.class).context();
        if (r36 == null) goto L114;
        Object r37 = r36.getSystemService("activity");
    L115:
        if (r37 == null) goto L120;
        ActivityManager.MemoryInfo r38 = new ActivityManager.MemoryInfo();
        ((ActivityManager) r37).getMemoryInfo(r38);
        r4 = Float.valueOf(r38.availMem / r38.totalMem);
        if ((r4 instanceof Object) == true) goto L48;
    L120:
        throw new NullPointerException("null cannot be cast to non-null type android.app.ActivityManager");
    L114:
        r37 = null;
        goto L115
    L122:
        if (r21.equals("avg_stall_ui_rate_per_week") == false) goto L236;
        float r39 = c;
        if (r39 < 0) goto L236;
        r4 = Float.valueOf(r39);
        if ((r4 instanceof Object) == true) goto L48;
    L130:
        if (r21.equals("video_download_speed_8") == false) goto L236;
    L133:
        if (r21.equals("stream_predict") == false) goto L236;
        ILiveNetworkPredict r41 = jc1.k.f(ILiveNetworkPredict.class);
        if (r41 == null) goto L236;
        int r42 = r41.obtainStreamPredict();
        z90.a.C0301a.a(FeatureManager.u, r21, Integer.valueOf(r42));
        r4 = Integer.valueOf(r42);
        if ((r4 instanceof Object) == true) goto L48;
    L140:
        if (r21.equals("synthesize_predict") == false) goto L236;
        ILiveNetworkPredict r43 = jc1.k.f(ILiveNetworkPredict.class);
        if (r43 == null) goto L236;
        int r44 = r43.obtainSynthesizePredict();
        z90.a.C0301a.a(FeatureManager.u, r21, Integer.valueOf(r44));
        r4 = Integer.valueOf(r44);
        if ((r4 instanceof Object) == true) goto L48;
    L147:
        if (r21.equals("ui_stall_rate") == false) goto L236;
        float r45 = jc1.k.n(IMiddleWarePerformanceManager.class).getUIStallRate();
        if (r45 < 0) goto L152;
        r8 = r45;
    L152:
        r4 = Float.valueOf(r8);
        if ((r4 instanceof Object) == true) goto L48;
    L156:
        if (r21.equals("net_predict_value") == false) goto L236;
        ILiveNetworkPredict r46 = jc1.k.f(ILiveNetworkPredict.class);
        if (r46 == null) goto L236;
        int r47 = r46.obtainNetPredictValue();
        z90.a.C0301a.a(FeatureManager.u, r21, Integer.valueOf(r47));
        r4 = Integer.valueOf(r47);
        if ((r4 instanceof Object) == true) goto L48;
    L163:
        if (r21.equals("synthesize_predict_value") == false) goto L236;
        ILiveNetworkPredict r48 = jc1.k.f(ILiveNetworkPredict.class);
        if (r48 == null) goto L236;
        int r49 = r48.obtainSynthesizePredictValue();
        z90.a.C0301a.a(FeatureManager.u, r21, Integer.valueOf(r49));
        r4 = Integer.valueOf(r49);
        if ((r4 instanceof Object) == true) goto L48;
    L170:
        if (r21.equals("avg_stall_ui_video_rate_per_week") == false) goto L236;
        float r51 = b;
        if (r51 < 0) goto L236;
        r4 = Float.valueOf(r51);
        if ((r4 instanceof Object) == true) goto L48;
    L178:
        if (r21.equals("cur_environment_brightness") == false) goto L236;
        FeatureManager r52 = FeatureManager.u;
        if ((System.currentTimeMillis() - ((Number) r52.getFeature("env_brightness_fetch_time", 0L)).longValue()) > 10000) goto L182;
    L192:
        FeatureManager.u.getClass();
        Object r53 = FeatureManager.a.get("cur_environment_brightness");
        if ((r53 instanceof Integer) == true) goto L195;
        r53 = null;
    L195:
        Integer r54 = (Integer) r53;
        if (r54 == null) goto L198;
        int r55 = r54.intValue();
    L199:
        if (r55 == (-1)) goto L236;
        r4 = Integer.valueOf(r55);
        if ((r4 instanceof Object) == true) goto L48;
    L198:
        r55 = -1;
        goto L199
    L182:
        if (E == true) goto L192;
        E = true;
        List<String> r56 = FeedFeatureManager.a;     // Catch: Throwable -> L190
        Number r57 = FeedFeatureManager.c("common", "brightness_env");     // Catch: Throwable -> L190
        if (r57 == null) goto L187;
        int r58 = r57.intValue();     // Catch: Throwable -> L190
    L188:
        z90.a.C0301a.a(r52, "cur_environment_brightness", Integer.valueOf(r58));     // Catch: Throwable -> L190
        z90.a.C0301a.a(r52, "env_brightness_fetch_time", Long.valueOf(System.currentTimeMillis()));     // Catch: Throwable -> L190
        E = false;     // Catch: Throwable -> L190
        goto L192
    L187:
        r58 = -1;
    L190:
        th = move-exception;
        boolean r59 = com.bytedance.android.live.impl.utils.a.a;
        com.bytedance.android.live.impl.utils.a.b(this.a, new DeviceFeatureFilter$getEnvBrightness$1(th), th);
        goto L192
    L204:
        if (r21.equals("transport_rtt") == false) goto L236;
    L214:
        if (r21.equals("low_power_mode") == false) goto L236;
        IMiddleWareHostContext r61 = jc1.k.f(IMiddleWareHostContext.class);
        if (r61 == null) goto L220;
        Context r62 = r61.context();
        if (r62 == null) goto L220;
        Object r63 = r62.getSystemService("power");
    L222:
        if ((r63 instanceof PowerManager) == true) goto L224;
        r63 = null;
    L224:
        PowerManager r64 = (PowerManager) r63;
        if (r64 == null) goto L236;
        r4 = Boolean.valueOf(r64.isPowerSaveMode());
        if ((r4 instanceof Object) == true) goto L48;
    L220:
        r63 = null;
        goto L222
    L230:
        if (r21.equals("avg_enter_room_duration_per_week") == false) goto L236;
        long r65 = o;
        if (r65 < 0) goto L236;
        r4 = Long.valueOf(r65);
        if ((r4 instanceof Object) == true) goto L48;
        goto L48
    }

    @Override // z90.a.b
    public final <T> void a(String r13, T r14) {
        Intrinsics.checkNotNullParameter(r13, "name");
        int r0 = r13.hashCode();
        Float r2 = null;
        if (r0 == (-1235807369)) goto L73;
        if (r0 != 1938029796) goto L7;
        r13.equals("livesdk_performance_fps_data_ready");
        return;
    L7:
        if (r0 == 2061061116) goto L10;
        return;
    L10:
        if (r13.equals("livesdk_performance_base_data_ready") == false) goto L83;
        IMiddleWarePerformanceManager r15 = jc1.k.f(IMiddleWarePerformanceManager.class);
        if (r15 == null) goto L14;
        FeatureManager r5 = FeatureManager.u;
        z90.a.C0301a.a(r5, "cpu_rate", Double.valueOf(r15.getCpuRate()));
        z90.a.C0301a.a(r5, "gpu_rate", Double.valueOf(r15.getGpuUsed()));
        z90.a.C0301a.a(r5, "battery_level", Float.valueOf(r15.getBatteryLevel()));
        z90.a.C0301a.a(r5, "net_quality", Integer.valueOf(r15.getNetQuality()));
        z90.a.C0301a.a(r5, "battery_state_android", Integer.valueOf(r15.getBatteryChange()));
        z90.a.C0301a.a(r5, "temperature_android", Float.valueOf(r15.getTemperature()));
        z90.a.C0301a.a(r5, "mem_summary_native_heap", Long.valueOf(r15.getNativeHeapSum()));
        z90.a.C0301a.a(r5, "mem_summary_java_heap", Long.valueOf(r15.getJavaHeapSum()));
    L14:
        FeatureManager r16 = FeatureManager.u;
        Boolean r6 = Boolean.FALSE;
        if (((Boolean) r16.getFeature("client_asr_enable", r6)).booleanValue() == false) goto L96;
        ls1.c r7 = j40.d.a.getValue();
        Float r4 = Float.valueOf(((Number) r16.getFeature("cpu_rate", Float.valueOf(0.0f))).floatValue());
        boolean r11 = true;
        if (r4.floatValue() >= r7.b()) goto L20;
        boolean r8 = true;
    L21:
        if (r8 == true) goto L24;
        r4 = null;
    L24:
        if (r4 == null) goto L26;
        r4.floatValue();
        z90.a.C0301a.a(r16, "asr_cpu_rate_fit", r6);
        return;
    L26:
        Float r9 = Float.valueOf(((Number) r16.getFeature("memory_available_rate", Float.valueOf(0.0f))).floatValue());
        if (r9.floatValue() >= r7.d()) goto L29;
        boolean r12 = true;
    L30:
        if (r12 == true) goto L33;
        r9 = null;
    L33:
        if (r9 == null) goto L35;
        r9.floatValue();
        z90.a.C0301a.a(r16, "asr_memory_available_rate_fit", r6);
        return;
    L35:
        float r1 = ((Number) r16.getFeature("battery_level", Float.valueOf(0.0f))).floatValue();
        int r17 = ((Number) r16.getFeature("battery_state_android", 1)).intValue();
        Float r3 = Float.valueOf(r1);
        if (r3.floatValue() >= r7.a()) goto L38;
        boolean r18 = true;
    L39:
        if (r18 == true) goto L42;
        r3 = null;
    L42:
        if (r3 == null) goto L49;
        r3.floatValue();
        if (r17 != 3) goto L46;
    L47:
        z90.a.C0301a.a(r16, "asr_battery_rate_fit", r6);
        return;
    L46:
        if (r17 == 4) goto L47;
    L49:
        if (NetworkUtils.g(s1.getContext()) == false) goto L51;
    L53:
        Integer r19 = Integer.valueOf(((Number) r16.getFeature("net_quality", 0)).intValue());
        if (r19.intValue() >= r7.e()) goto L56;
        boolean r21 = true;
    L57:
        if (r21 == true) goto L60;
        r19 = null;
    L60:
        if (r19 == null) goto L62;
        r19.intValue();
        z90.a.C0301a.a(r16, "asr_net_quality_fit", r6);
        return;
    L62:
        Float r110 = Float.valueOf(((Number) r16.getFeature("gpu_rate", Float.valueOf(0.0f))).floatValue());
        if (r110.floatValue() < r7.c()) goto L66;
        r11 = false;
    L66:
        if (r11 == false) goto L68;
        r2 = r110;
    L68:
        if (r2 == null) goto L70;
        r2.floatValue();
        z90.a.C0301a.a(r16, "asr_gpu_rate_fit", r6);
        return;
    L70:
        z90.a.C0301a.a(r16, "asr_performance_fit", Boolean.TRUE);
        return;
    L56:
        r21 = false;
        goto L57
    L51:
        if (r7.g() == false) goto L53;
        z90.a.C0301a.a(r16, "asr_wifi_fit", r6);
        return;
    L38:
        r18 = false;
        goto L39
    L29:
        r12 = false;
        goto L30
    L20:
        r8 = false;
        goto L21
    L96:
        return;
    L83:
        return;
    L73:
        if (r13.equals("livesdk_performance_monitor_base_new") == true) goto L75;
        return;
    L75:
        if (A == false) goto L77;
        return;
    L77:
        if (TypeIntrinsics.isMutableMap(r14) == true) goto L79;
        r14 = null;
    L79:
        Map r111 = (Map) r14;
        if (r111 == null) goto L94;
        O.getClass();
        g(r111);
        return;
    }

    @Override // com.bytedance.android.live.impl.logfilter.f
    public final void onEvent(String r14, Map<String, String> r15) {
        Intrinsics.checkNotNullParameter(r14, "eventName");
        Intrinsics.checkNotNullParameter(r15, "params");
        t = System.currentTimeMillis();
        int r0 = r14.hashCode();
        Float r1 = Float.valueOf(0.0f);
        Long r8 = null;
        final boolean r9 = true;
        final boolean r11 = false;
        switch(r0) {
            case -1284480695: goto L38;
            case -1235807369: goto L32;
            case -901624339: goto L29;
            case -70209228: goto L26;
            case 228634976: goto L9;
            case 272490898: goto L6;
            default: goto L41;
        };
    L6:
        if (r14.equals("livesdk_restart_live_alert_show") == false) goto L41;
        TTExecutors.getNormalExecutor().submit(new DeviceFeatureFilter$updateStopLiveReasonCount$1(false, r15.get("reason")));
        return;
    L9:
        if (r14.equals("livesdk_enter_room_duration") == false) goto L41;
        if (s == false) goto L13;
        h(false);
        z = t;
        s = false;
    L13:
        y = t;
        ((LinkedList) d).offerLast(r1);
        ((LinkedList) e).offerLast(0);
    L14:
        LinkedList r16 = (LinkedList) d;
        int r2 = r16.size();
        FeatureManager r3 = FeatureManager.u;
        r3.getClass();
        if (r2 <= FeatureManager.g) goto L17;
        r16.pollFirst();
        ((LinkedList) e).pollFirst();
        goto L14
    L17:
        String r17 = r15.get("duration");
        if (r17 == null) goto L20;
        r8 = Long.valueOf(CastLongProtector.parseLong(r17));
    L20:
        if (r8 == null) goto L24;
        final long r18 = r8.longValue();
        Long r4 = Long.valueOf(r18);
        FeatureType r5 = FeatureType.DYNAMIC;
        if (r3.i("enter_room_duration_single", r4, r5) == false) goto L24;
        O.getClass();
        TTExecutors.getNormalExecutor().submit(new DeviceFeatureFilter$updateEnterRoomDuration$1(r11, r18));
        LimitSizeQueue<Long> r6 = q;
        r6.add(Long.valueOf(r18));
        LimitSizeQueue<Long> r7 = r;
        r7.add(Long.valueOf(r18));
        r3.i("avg_enter_room_duration_recent", Long.valueOf(CollectionsKt.sumOfLong(r6) / ((long) r6.size())), r5);
        r3.i("avg_enter_room_duration_recent_live", Long.valueOf(CollectionsKt.sumOfLong(r7) / ((long) r7.size())), r5);
    L24:
        k(false);
        i.clear();
        j.clear();
        k.clear();
        return;
    L26:
        if (r14.equals("livesdk_live_take_room_start") == false) goto L41;
        h(false);
        return;
    L29:
        if (r14.equals("livesdk_anchor_close_live_confirm") == false) goto L41;
        FeatureManager r19 = FeatureManager.u;
        r19.g("cpu_rate_in_last_minute");
        r19.g("stall_ui_rate_in_last_minute");
        r19.g("stall_video_rate_in_last_minute");
        r19.g("live_loading_show_num");
        r19.g("performance_report_count");
        h(true);
        return;
    L32:
        if (r14.equals("livesdk_performance_monitor_base_new") == false) goto L41;
        if (A == true) goto L36;
        A = true;
        z90.a.C0301a.a(FeatureManager.u, "performance_monitor_ready", Boolean.valueOf(A));
    L36:
        g(r15);
        return;
    L38:
        if (r14.equals("livesdk_room_enter_success") == false) goto L41;
        return;
    L41:
        if (s == true) goto L94;
        int r12 = r14.hashCode();
        if (r12 == (-1617503898)) goto L75;
        if (r12 == (-1115849514)) goto L66;
        if (r12 == (-773966155)) goto L50;
        return;
    L50:
        if (r14.equals("livesdk_live_leave") == false) goto L95;
        Iterator r110 = CollectionsKt.listOf(new String[]{"live_end", "drawer"}).iterator();
    L53:
        if (r110.hasNext() == false) goto L61;
        String r13 = (String) r110.next();
        String r111 = r15.get("enter_from_merge");
        if (r111 == null) goto L53;
        if (StringsKt.contains$default(r111, r13, false, 2, null) != true) goto L53;
        if (TextUtils.equals(r15.get("leave_type"), "draw") == false) goto L53;
        return;
    L61:
        s = true;
        final long r112 = 0;
        TTExecutors.getNormalExecutor().submit(new DeviceFeatureFilter$updateEnterRoomDuration$1(r9, r112));
        TTExecutors.getNormalExecutor().submit(new DeviceFeatureFilter$updateFirstFrameLoadDuration$1(r9, r112));
        j(true);
        A = false;
        r.clear();
        h r113 = G;
        if (r113 == null) goto L64;
        r113.b(true, new Float[]{null, null, null, r1, r1, null, null});
    L64:
        FeatureManager r114 = FeatureManager.u;
        r114.g("cpu_rate_in_last_minute");
        r114.g("stall_ui_rate_in_last_minute");
        r114.g("stall_video_rate_in_last_minute");
        r114.g("live_loading_show_num");
        r114.g("performance_report_count");
        h(true);
        TTExecutors.getNormalExecutor().submit(new DeviceFeatureFilter$updateFirstRoomPerformance$1(true));
        return;
    L95:
        return;
    L66:
        if (r14.equals("livesdk_live_duration") == false) goto L97;
        k(true);
        if (u == false) goto L70;
        d.d("stall_room_count_in_last_minute", x, 1, t);
        u = false;
    L70:
        Deque<Integer> r115 = e;
        if (CollectionsKt.sumOfInt(r115) == 0) goto L73;
        FeatureManager.u.i("pre_room_video_ui_total_stall_rate_avg", Float.valueOf(CollectionsKt.sumOfFloat(d) / CollectionsKt.sumOfInt(r115)), FeatureType.DYNAMIC);
    L73:
        TTExecutors.getNormalExecutor().submit(new DeviceFeatureFilter$updateStallSp$1(true));
        FeatureManager.u.g("room_loading_show_num");
        return;
    L97:
        return;
    L75:
        if (r14.equals("livesdk_first_frame_duration") == false) goto L99;
        String r116 = r15.get("duration");
        if (r116 == null) goto L100;
        FeatureManager.u.i("first_frame_load_duration", Long.valueOf(CastLongProtector.parseLong(r116)), FeatureType.DYNAMIC);
        DeviceFeatureFilter r117 = O;
        final long r21 = CastLongProtector.parseLong(r116);
        r117.getClass();
        TTExecutors.getNormalExecutor().submit(new DeviceFeatureFilter$updateFirstFrameLoadDuration$1(r11, r21));
        return;
    L100:
        return;
    L99:
        return;
    }

    public static void i(String r8, float r9, LongSparseArray r11) {
        r11.put(t, Float.valueOf(r9));
        int r12 = 0;
        float r0 = 0.0f;
    L4:
        if (r12 >= r11.size()) goto L10;
        long r1 = r11.keyAt(r12);
        if ((t - r1) <= 60000) goto L8;
        r11.removeAt(r12);
    L9:
        r12 = r12 + 1;
        goto L4
    L8:
        r0 = r0 + ((Number) r11.get(r1)).floatValue();
        goto L9
    L10:
        FeatureManager.u.i(r8, Float.valueOf(r0 / r11.size()), FeatureType.DYNAMIC);
    }
}
