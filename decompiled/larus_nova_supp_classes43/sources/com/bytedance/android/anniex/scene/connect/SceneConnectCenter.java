package com.bytedance.android.anniex.scene.connect;

import com.bytedance.android.anniex.scene.core.SceneManager;
import com.bytedance.android.anniex.scene.core.UrlUsageTracker;
import com.bytedance.android.anniex.scene.settings.SwitchCenter;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.service.base.c1;
import com.bytedance.ies.bullet.service.base.h;
import com.bytedance.ies.bullet.service.base.r;
import com.bytedance.ies.xbridge.event.Event;
import com.bytedance.ies.xbridge.event.EventCenter;
import com.bytedance.keva.Keva;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONArray;
import org.json.JSONObject;
import s26.d;
import za.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class SceneConnectCenter {
    public static final Lazy a = null;
    public static long b;
    public static long c;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/anniex/scene/connect/SceneConnectCenter$HitType;", "", "", "type", "I", "getType", "()I", "HIT", "TOP_N_HIT", "DELAY_HIT", "anniex_release"}, k = 1, mv = {1, 4, 3})
    public static final enum HitType extends Enum<HitType> {
        public static final HitType DELAY_HIT = null;
        public static final HitType HIT = null;
        public static final HitType TOP_N_HIT = null;
        public static final /* synthetic */ HitType[] a = null;
        private final int type;

        public static HitType valueOf(String r1) {
            return (HitType) r27.a.a(HitType.class, r1);
        }

        public static HitType[] values() {
            return (HitType[]) a.clone();
        }

        static {
            HitType r0 = new HitType("HIT", 0, 1);
            HIT = r0;
            HitType r1 = new HitType("TOP_N_HIT", 1, 2);
            TOP_N_HIT = r1;
            HitType r10 = new HitType("DELAY_HIT", 2, 3);
            DELAY_HIT = r10;
            a = new HitType[]{r0, r1, r10};
        }

        public final int getType() {
            return this.type;
        }

        public HitType(String r1, int r10, int r11) {
            super(r1, r10);
            this.type = r11;
        }
    }

    static {
        a = LazyKt.lazy(SceneConnectCenter$keva$2.INSTANCE);
    }

    public static Keva a() {
        return (Keva) a.getValue();
    }

    public static void b(List r10) {
        Intrinsics.checkNotNullParameter(r10, "urls");
        ArrayList r0 = (ArrayList) r10;
        if (r0.isEmpty() == false) goto L5;
        return;
    L5:
        if (SwitchCenter.c() == false) goto L20;
        d r1 = d.c;
        r r11 = d.c.c(r.class);
        if (r11 == null) goto L19;
        c1 r12 = new c1("bdx_anniex_usage_illegal_urls", null, null, null, null, 254);
        JSONObject r13 = new JSONObject();     // Catch: Exception -> L12
        r13.put("illegal_urls", r10.toString());     // Catch: Exception -> L12
        r12.d = r13;     // Catch: Exception -> L12
        JSONObject r14 = new JSONObject();     // Catch: Exception -> L12
        r14.put("size", r0.size());     // Catch: Exception -> L12
        r12.e = r14;     // Catch: Exception -> L12
    L14:
        r11.S(r12);
        return;
    L12:
        e = move-exception;
        HybridLogger r15 = HybridLogger.a;
        UrlUsageTracker r16 = UrlUsageTracker.n;
        HybridLogger.i("UrlUsageTracker", "reportIllegalUrl error:" + e.getMessage(), null, 12);
        goto L14
    L19:
        return;
    }

    public static void e(String r10) {
        Intrinsics.checkNotNullParameter(r10, "errorMsg");
        d r0 = d.c;
        r r1 = d.c.c(r.class);
        if (r1 == null) goto L6;
        c1 r11 = new c1("bdx_monitor_next_sqlite_error", null, null, null, null, 254);
        JSONObject r12 = new JSONObject();
        r12.put(com.bytedance.android.ec.core.event.a.KEY_ERROR_MSG, r10);
        r12.put("version", "9");
        r11.d = r12;
        r1.S(r11);
        return;
    }

    public static void c(final JSONObject r10, final JSONObject r11) {
        int r0 = b.a;
        b.a("PredictManager", new SceneConnectCenter$reportNextPredictStats$1(r10, r11));
        d r1 = d.c;
        r r12 = d.c.c(r.class);
        if (r12 == null) goto L6;
        c1 r13 = new c1("bdx_monitor_annie_next_predict_stats", null, null, null, null, 254);
        r13.d = r10;
        r13.e = r11;
        r12.S(r13);
        return;
    }

    public static void d(final JSONObject r10, final JSONObject r11) {
        int r0 = b.a;
        b.a("PredictManager", new SceneConnectCenter$reportRepeatPredictStats$1(r10, r11));
        d r1 = d.c;
        r r12 = d.c.c(r.class);
        if (r12 == null) goto L6;
        c1 r13 = new c1("bdx_monitor_annie_repeat_predict_stats", null, null, null, null, 254);
        r13.d = r10;
        r13.e = r11;
        r12.S(r13);
        return;
    }

    public static void g(final String r10, final String r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        Intrinsics.checkNotNullParameter(r11, "strategy");
        if (h.N() == true) goto L12;
        return;
    L12:
        int r1 = b.a;     // Catch: Exception -> L9
        b.a("PredictManager", new SceneConnectCenter$reportUrlPredict$1(r10, r11));     // Catch: Exception -> L9
        d r12 = d.c;     // Catch: Exception -> L9
        r r13 = d.c.c(r.class);     // Catch: Exception -> L9
        if (r13 == null) goto L14;
        c1 r14 = new c1("bdx_monitor_annie_next_url_predict", null, null, null, null, 254);     // Catch: Exception -> L9
        JSONObject r15 = new JSONObject();     // Catch: Exception -> L9
        r15.put("predict_url", r10);     // Catch: Exception -> L9
        r15.put("strategy", r11);     // Catch: Exception -> L9
        r14.d = r15;     // Catch: Exception -> L9
        r13.S(r14);     // Catch: Exception -> L9
        return;
    L14:
        return;
    L9:
        e = move-exception;
        HybridLogger r16 = HybridLogger.a;
        UrlUsageTracker r17 = UrlUsageTracker.n;
        HybridLogger.i("UrlUsageTracker", "reportUrlPredict error:" + e.getMessage(), null, 12);
    }

    public static void i(com.bytedance.android.anniex.scene.core.h r10, com.bytedance.android.anniex.scene.data.b r11) {
        Intrinsics.checkNotNullParameter(r10, "currentScene");
        Intrinsics.checkNotNullParameter(r11, "sceneQueryInfo");
        LinkedHashMap r0 = new LinkedHashMap();
        int r1 = za.a.a;
        String r12 = r10.a;
        Intrinsics.checkNotNullParameter(r12, "base64Input");
        r0.put("path_name", r12);
        r0.put("next", r11.d.toString());
        r0.put("attach_scene", r10.e);
        String r13 = r10.g;
        if (r13 == null) goto L5;
        r0.put("client_component", r13);
    L5:
        JSONObject r14 = r10.j;
        if (r14 == null) goto L8;
        r0.put("bcm_chain", r14);
    L8:
        LinkedHashMap r15 = new LinkedHashMap();
        r15.put("pv", Integer.valueOf(r11.a));
        r15.put("avg_duration", Double.valueOf(r11.c));
        Integer r16 = r10.h;
        if (r16 == null) goto L11;
        r15.put("view_count", Integer.valueOf(r16.intValue()));
    L11:
        Integer r17 = r10.k;
        if (r17 == null) goto L14;
        int r18 = r17.intValue();
    L15:
        r15.put("repeat_count", Integer.valueOf(r18));
        d r19 = d.c;
        r r20 = d.c.c(r.class);
        if (r20 == null) goto L19;
        c1 r110 = new c1("bdx_monitor_annie_next_scene_feature", null, null, null, null, 254);
        r110.d = new JSONObject(r0);
        r110.e = new JSONObject(r15);
        r20.S(r110);
        return;
    L19:
        return;
    L14:
        r18 = 0;
        goto L15
    }

    public static void j(com.bytedance.android.anniex.scene.core.h r10, com.bytedance.android.anniex.scene.data.b r11) {
        Intrinsics.checkNotNullParameter(r10, "currentScene");
        Intrinsics.checkNotNullParameter(r11, "sceneQueryInfo");
        int r0 = com.bytedance.ies.bullet.kit.resourceloader.loader.b.a;
        if (com.bytedance.ies.bullet.kit.resourceloader.loader.b.d(r10.e) == false) goto L25;
        List r1 = CollectionsKt.take(CollectionsKt.sortedWith(r11.d.entrySet(), new a()), 3);
        LinkedHashMap r12 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r1, 10)), 16));
        Iterator r13 = r1.iterator();
    L6:
        if (r13.hasNext() == false) goto L8;
        Map.Entry r14 = (Map.Entry) r13.next();
        Pair r15 = TuplesKt.to(r14.getKey(), r14.getValue());
        r12.put(r15.getFirst(), r15.getSecond());
        goto L6
    L8:
        final LinkedHashMap r16 = new LinkedHashMap();
        int r17 = za.a.a;
        String r18 = r10.a;
        Intrinsics.checkNotNullParameter(r18, "base64Input");
        r16.put("path_name", r18);
        r16.put("pv", Integer.valueOf(r11.a));
        JSONArray r19 = new JSONArray();
        Iterator r20 = r12.entrySet().iterator();
    L10:
        if (r20.hasNext() == false) goto L12;
        Map.Entry r21 = (Map.Entry) r20.next();
        String r22 = (String) r21.getKey();
        Pair r23 = (Pair) r21.getValue();
        JSONObject r24 = new JSONObject();
        r24.put("pathname", r22);
        r24.put("pv", ((Number) r23.getFirst()).intValue());
        r24.put("clickRate", ((Number) r23.getSecond()).doubleValue());
        r19.put(r24);
        goto L10
    L12:
        r16.put("next", r19);
        r16.put("attach_scene", r10.e);
        Integer r25 = r10.h;
        if (r25 == null) goto L15;
        r16.put("view_count", Integer.valueOf(r25.intValue()));
    L15:
        String r26 = r10.g;
        if (r26 == null) goto L18;
        r16.put("client_component", r26);
    L18:
        JSONObject r27 = r10.j;
        if (r27 == null) goto L21;
        r16.put("bcm_chain", r27);
    L21:
        r16.put("attach_scene", r10.e);
        r16.put("avg_duration", Double.valueOf(r11.c));
        final String r28 = "anniex_next_scene_features_" + r10.e;
        Event r29 = new Event(r28, System.currentTimeMillis(), null, 4, null);
        r29.setMapParams(r16);
        EventCenter.enqueueEvent(r29);
        int r30 = b.a;
        SceneManager r31 = SceneManager.n;
        b.a("AnnieXSceneManager", new SceneConnectCenter$sendSceneFeatureEvent$2(r28, r16));
        return;
    }

    public static void h(final String r10, final String r11, final HitType r12) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        Intrinsics.checkNotNullParameter(r11, "strategy");
        Intrinsics.checkNotNullParameter(r12, "hitType");
        if (h.N() == true) goto L12;
        return;
    L12:
        int r1 = b.a;     // Catch: Exception -> L9
        b.a("PredictManager", new SceneConnectCenter$reportUrlPredictHit$1(r10, r11, r12));     // Catch: Exception -> L9
        d r13 = d.c;     // Catch: Exception -> L9
        r r14 = d.c.c(r.class);     // Catch: Exception -> L9
        if (r14 == null) goto L14;
        c1 r15 = new c1("bdx_monitor_annie_next_url_predict_hit", null, null, null, null, 254);     // Catch: Exception -> L9
        JSONObject r16 = new JSONObject();     // Catch: Exception -> L9
        r16.put("predict_url", r10);     // Catch: Exception -> L9
        r16.put("strategy", r11);     // Catch: Exception -> L9
        r16.put("hit_type", r12.getType());     // Catch: Exception -> L9
        r15.d = r16;     // Catch: Exception -> L9
        r14.S(r15);     // Catch: Exception -> L9
        return;
    L14:
        return;
    L9:
        e = move-exception;
        HybridLogger r17 = HybridLogger.a;
        UrlUsageTracker r18 = UrlUsageTracker.n;
        HybridLogger.i("UrlUsageTracker", "reportUrlPredictHit error:" + e.getMessage(), null, 12);
    }

    public static void k(com.bytedance.android.anniex.scene.core.h r10, com.bytedance.android.anniex.scene.core.h r11, com.bytedance.android.anniex.scene.data.b r12) {
        Intrinsics.checkNotNullParameter(r10, "fromScene");
        Intrinsics.checkNotNullParameter(r11, "toScene");
        Intrinsics.checkNotNullParameter(r12, "sceneQueryInfo");
        final LinkedHashMap r0 = new LinkedHashMap();
        int r1 = za.a.a;
        String r13 = r10.a;
        Intrinsics.checkNotNullParameter(r13, "base64Input");
        r0.put("pre_pathname", r13);
        String r14 = r11.a;
        Intrinsics.checkNotNullParameter(r14, "base64Input");
        r0.put("pathname", r14);
        r0.put("next_prob", r12.d.toString());
        r0.put("pre_attach_scene", r10.e);
        r0.put("attach_scene", r11.e);
        String r15 = r11.g;
        if (r15 == null) goto L5;
        r0.put("client_component", r15);
    L5:
        LinkedHashMap r16 = new LinkedHashMap();
        Integer r17 = r10.k;
        int r18 = 0;
        if (r17 == null) goto L8;
        int r19 = r17.intValue();
    L9:
        r16.put("pre_repeat_count", Integer.valueOf(r19));
        Integer r20 = r10.h;
        if (r20 == null) goto L12;
        int r21 = r20.intValue();
    L13:
        r16.put("pre_view_count", Integer.valueOf(r21));
        Integer r22 = r10.i;
        if (r22 == null) goto L16;
        r18 = r22.intValue();
    L16:
        r16.put("pre_load_count", Integer.valueOf(r18));
        r16.put("pv", Integer.valueOf(r12.a));
        r16.put("avg_duration", Double.valueOf(r12.c));
        Pair<Integer, Double> r23 = r12.d.get(r11.a);
        if (r23 == null) goto L19;
        double r24 = ((Number) r23.getSecond()).doubleValue();
    L20:
        r16.put("clickRate", Double.valueOf(r24));
        Integer r25 = r11.h;
        if (r25 == null) goto L23;
        r16.put("view_count", Integer.valueOf(r25.intValue()));
    L23:
        d r26 = d.c;
        r r27 = d.c.c(r.class);
        if (r27 == null) goto L26;
        c1 r110 = new c1("bdx_monitor_annie_next_scene_goto_feature", null, null, null, null, 254);
        r110.d = new JSONObject(r0);
        r110.e = new JSONObject(r16);
        r27.S(r110);
    L26:
        int r28 = b.a;
        SceneManager r29 = SceneManager.n;
        b.a("AnnieXSceneManager", new SceneConnectCenter$sendSceneGotoFeature$2(r0));
        return;
    L19:
        r24 = 0.0d;
        goto L20
    L12:
        r21 = 0;
        goto L13
    L8:
        r19 = 0;
        goto L9
    }

    public static void f(final int r10, final int r11, final int r12, final int r13) {
        d r0 = d.c;
        r r1 = d.c.c(r.class);
        if (r1 == null) goto L5;
        c1 r14 = new c1("bdx_monitor_next_sqlite_status", null, null, null, null, 254);
        JSONObject r15 = new JSONObject();
        r15.put("scene_table_size", r10);
        r15.put("trans_table_size", r11);
        r15.put("url_record_table_size", r12);
        r15.put("db_file_size", r13);
        r14.e = r15;
        r1.S(r14);
    L5:
        int r16 = b.a;
        SceneManager r17 = SceneManager.n;
        b.a("AnnieXSceneManager", new SceneConnectCenter$reportSqliteStatus$2(r10, r11, r12, r13));
    }
}
