package com.bytedance.android.anniex.scene.next;

import com.bytedance.android.anniex.scene.connect.SceneConnectCenter;
import com.bytedance.android.anniex.scene.next.base.PredictElementType;
import com.bytedance.android.anniex.scene.settings.SwitchCenter;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class Evaluator {
    public static final Lazy a = null;
    public static final Lazy b = null;
    public static final Map<String, Map<String, h>> c = null;
    public static final Map<String, Map<String, h>> d = null;
    public static final a e = null;
    public static boolean f;
    public static int g;

    public static final class a {
        public volatile int a;
        public volatile int b;
        public volatile int c;
        public volatile int d;
        public volatile int e;

        public a() {
            this(0);
        }

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof a) == true) goto L8;
            return false;
        L8:
            a r11 = (a) r10;
            if (this.a == r11.a) goto L12;
            return false;
        L12:
            if (this.b == r11.b) goto L15;
            return false;
        L15:
            if (this.c == r11.c) goto L18;
            return false;
        L18:
            if (this.d == r11.d) goto L21;
            return false;
        L21:
            if (this.e == r11.e) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            return (((((((this.a * 31) + this.b) * 31) + this.c) * 31) + this.d) * 31) + this.e;
        }

        public final String toString() {
            return "SceneSwitchStats(sceneSwitchCount=" + this.a + ", sceneShowCount=" + this.b + ", skipByAvgCount=" + this.c + ", skipByFrequencyCount=" + this.d + ", skipByNoTransitionCount=" + this.e + ')';
        }

        public a(int r1) {
            this.a = 0;
            this.b = 0;
            this.c = 0;
            this.d = 0;
            this.e = 0;
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[PredictElementType.values().length];
            r0[PredictElementType.SceneId.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[PredictElementType.SceneRepeat.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
        a = LazyKt.lazy(Evaluator$sceneIdEvaluator$2.INSTANCE);
        b = LazyKt.lazy(Evaluator$sceneRepeatEvaluator$2.INSTANCE);
        c = new LinkedHashMap();
        d = new LinkedHashMap();
        e = new a(0);
        f = true;
    }

    public static void b() {
        a r1 = e;
        r1.b++;
        if (f == true) goto L6;
        r1.a++;
    L6:
        if ((r1.b % ((Number) SwitchCenter.Y.getValue()).intValue()) != 0) goto L53;
        d r0 = (d) a.getValue();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "context");
        Map r10 = MapsKt.toMap(r0.a);
        ((ConcurrentHashMap) r0.a).clear();
        Iterator r11 = r10.entrySet().iterator();
    L9:
        if (r11.hasNext() == false) goto L53;
        Map.Entry r12 = (Map.Entry) r11.next();
        String r13 = (String) r12.getKey();
        d.a r14 = (d.a) r12.getValue();
        int r15 = r14.a;
        if (r15 <= 0) goto L13;
        double r16 = ((double) r14.d) / ((double) r15);
    L14:
        if (r15 <= 0) goto L16;
        double r17 = ((double) r14.e) / ((double) r15);
    L17:
        if (r15 <= 0) goto L19;
        double r18 = ((double) r14.f) / ((double) r15);
    L21:
        if (r1.a <= 0) goto L23;
        double r19 = ((double) r14.d) / ((double) r1.a);
    L25:
        if (r1.a <= 0) goto L27;
        double r20 = ((double) r14.e) / ((double) r1.a);
    L29:
        if (r1.a <= 0) goto L31;
        double r21 = ((double) r14.f) / ((double) r1.a);
    L33:
        if (r1.b <= 0) goto L35;
        double r22 = ((double) r14.a) / ((double) r1.b);
    L37:
        if (r1.b <= 0) goto L39;
        double r23 = ((double) r1.c) / ((double) r1.b);
    L41:
        if (r1.b <= 0) goto L43;
        double r24 = ((double) r1.d) / ((double) r1.b);
    L45:
        if (r1.b <= 0) goto L47;
        double r25 = ((double) r1.e) / ((double) r1.b);
    L55:
        Lazy r110 = SceneConnectCenter.a;     // Catch: Exception -> L50
        JSONObject r111 = new JSONObject();     // Catch: Exception -> L50
        r111.put("strategy", r13);     // Catch: Exception -> L50
        JSONObject r26 = new JSONObject();     // Catch: Exception -> L50
        r26.put("predict_ratio", r22);     // Catch: Exception -> L50
        r26.put("avg_skip_ratio", r23);     // Catch: Exception -> L50
        r26.put("no_transition_skip_ratio", r25);     // Catch: Exception -> L50
        r26.put("frequency_skip_ratio", r24);     // Catch: Exception -> L50
        r26.put("predict_delay_hit_rate", r18);     // Catch: Exception -> L50
        r26.put("real_top1_recall", r19);     // Catch: Exception -> L50
        r26.put("real_topN_recall", r20);     // Catch: Exception -> L50
        r26.put("real_delay_hit_rate", r21);     // Catch: Exception -> L50
        r26.put("predict_top1_precision", r16);     // Catch: Exception -> L50
        r26.put("predict_topN_precision", r17);     // Catch: Exception -> L50
        Unit r27 = Unit.INSTANCE;     // Catch: Exception -> L50
        SceneConnectCenter.c(r111, r26);     // Catch: Exception -> L50
    L52:
        r1 = r1;
    L50:
        e = move-exception;
        HybridLogger r28 = HybridLogger.a;
        HybridLogger.i("PredictManager", "reportStrategyStats error:" + e.getMessage(), null, 12);
        goto L52
    L47:
        r25 = 0.0d;
        goto L55
    L43:
        r24 = 0.0d;
        goto L45
    L39:
        r23 = 0.0d;
        goto L41
    L35:
        r22 = 0.0d;
        goto L37
    L31:
        r21 = 0.0d;
        goto L33
    L27:
        r20 = 0.0d;
        goto L29
    L23:
        r19 = 0.0d;
        goto L25
    L19:
        r18 = 0.0d;
        goto L21
    L16:
        r17 = 0.0d;
        goto L17
    L13:
        r16 = 0.0d;
    L53:
        f = false;
    }

    public static void a(String r10, Object r11, PredictElementType r12, Function2 r13) {
        int r0 = b.a[r12.ordinal()];
        if (r0 != 1) goto L5;
        Map r14 = (Map) ((LinkedHashMap) c).get(r10);
    L10:
        if (r14 != null) goto L12;
        return;
    L12:
        Collection r1 = r14.values();
        ArrayList r15 = new ArrayList();
        Iterator r16 = r1.iterator();
    L14:
        if (r16.hasNext() == false) goto L22;
        Object r17 = r16.next();
        if (((h) r17).a != r12) goto L18;
        boolean r18 = true;
    L19:
        if (r18 == false) goto L14;
        r15.add(r17);
        goto L14
    L18:
        r18 = false;
        goto L19
    L22:
        if ((!r15.isEmpty()) == false) goto L52;
        LinkedHashMap r19 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r15, 10)), 16));
        Iterator r20 = r15.iterator();
    L25:
        if (r20.hasNext() == false) goto L39;
        Object r21 = r20.next();
        h r22 = (h) r21;
        Iterator r23 = r14.entrySet().iterator();
    L28:
        if (r23.hasNext() == false) goto L32;
        Object r24 = r23.next();
        if (Intrinsics.areEqual(((Map.Entry) r24).getValue(), r22) == false) goto L28;
    L33:
        Map.Entry r25 = (Map.Entry) r24;
        if (r25 == null) goto L37;
        String r26 = (String) r25.getKey();
        if (r26 == null) goto L37;
    L38:
        r19.put(r26, r21);
    L37:
        r26 = "Unknown";
        goto L38
    L32:
        r24 = null;
        goto L33
    L39:
        r13.invoke(r11, r19);
        return;
    L52:
        return;
    L5:
        if (r0 != 2) goto L8;
        r14 = (Map) ((LinkedHashMap) d).get(r10);
        goto L10
    L8:
        throw new NoWhenBranchMatchedException();
    }
}
