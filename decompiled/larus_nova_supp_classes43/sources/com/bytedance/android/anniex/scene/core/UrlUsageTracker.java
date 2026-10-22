package com.bytedance.android.anniex.scene.core;

import android.os.Build;
import android.os.Message;
import com.byted.cast.sink.api.IServerListener;
import com.bytedance.ai.event.MessageIndication;
import com.bytedance.android.anniex.optimize.UsageLynxOptimize;
import com.bytedance.android.anniex.scene.connect.SceneConnectCenter;
import com.bytedance.android.anniex.scene.data.SceneDbManager;
import com.bytedance.android.anniex.scene.handler.idle.TaskType;
import com.bytedance.android.anniex.scene.settings.SwitchCenter;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.service.base.c1;
import com.bytedance.ies.bullet.service.base.r;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class UrlUsageTracker {
    public static UrlUsageTracker n;
    public final Lazy a;
    public final ConcurrentHashMap<String, a> b;
    public volatile int c;
    public final int d;
    public final int e;
    public boolean f;
    public final Lazy g;
    public final Lazy h;
    public final Lazy i;
    public boolean j;
    public boolean k;
    public boolean l;
    public final ConcurrentLinkedDeque<String> m;

    public static final class a {
        public int a;
        public final String b;
        public final String c;
        public final int d;

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
            if (Intrinsics.areEqual(this.b, r11.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r11.c) == true) goto L18;
            return false;
        L18:
            if (this.d == r11.d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r0 = ((this.a * 31) + this.b.hashCode()) * 31;
            String r1 = this.c;
            if (r1 != null) goto L5;
            int r10 = 0;
        L7:
            return ((r0 + r10) * 31) + this.d;
        L5:
            r10 = r1.hashCode();
            goto L7
        }

        public final String toString() {
            return "CacheRecord(count=" + this.a + ", url=" + this.b + ", identifyUrl=" + this.c + ", status=" + this.d + ')';
        }

        public a(String r10, String r11, int r12) {
            Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
            this.a = 1;
            this.b = r10;
            this.c = r11;
            this.d = r12;
        }
    }

    public static final class b {
        public static UrlUsageTracker a() {
            if (UrlUsageTracker.n != null) goto L5;
            UrlUsageTracker.n = new UrlUsageTracker();
        L5:
            UrlUsageTracker r0 = UrlUsageTracker.n;
            Intrinsics.checkNotNull(r0);
            return r0;
        }
    }

    public static final class c implements va.d {
        public final /* synthetic */ UrlUsageTracker a;

        public c(UrlUsageTracker r1) {
            this.a = r1;
        }

        @Override // va.d
        public final void a(Message r10) {
            Intrinsics.checkNotNullParameter(r10, MessageIndication.MESSAGE_TYPE_MSG);
            if (r10.what != 5) goto L11;
            UrlUsageTracker.b(this.a);     // Catch: Exception -> L6
            return;
        L6:
            e = move-exception;
            HybridLogger r0 = HybridLogger.a;
            UrlUsageTracker r1 = UrlUsageTracker.n;
            HybridLogger.i("UrlUsageTracker", "queryTopUrls 数据查询异常：" + e.getMessage(), null, 12);
            return;
        }

        @Override // va.d
        public final void b(Message r10) {
            Intrinsics.checkNotNullParameter(r10, MessageIndication.MESSAGE_TYPE_MSG);
            if (r10.what != 4) goto L14;
            Map<String, a> r11 = MapsKt.toMap(this.a.b);     // Catch: Exception -> L9
            Intrinsics.checkNotNullParameter(r11, "data");     // Catch: Exception -> L9
            SceneDbManager r0 = (SceneDbManager) this.a.a.getValue();     // Catch: Exception -> L9
            if (r0 == null) goto L7;
            r0.d(UrlUsageTracker.a(this.a), r11);     // Catch: Exception -> L9
        L7:
            this.a.b.clear();     // Catch: Exception -> L9
            this.a.c = 0;     // Catch: Exception -> L9
            return;
        L9:
            e = move-exception;
            HybridLogger r1 = HybridLogger.a;
            UrlUsageTracker r12 = UrlUsageTracker.n;
            HybridLogger.i("UrlUsageTracker", "flushBatch 数据入库异常：" + e.getMessage(), null, 12);
            return;
        }
    }

    static {
    }

    public final void d() {
        if (((Boolean) SwitchCenter.w.getValue()).booleanValue() == true) goto L5;
        return;
    L5:
        if (Build.VERSION.SDK_INT >= 26) goto L7;
        return;
    L7:
        if (this.j == true) goto L12;
        va.a.C0207a r0 = va.a.g;
        r0.a().a();
        va.a r1 = r0.a();
        c r10 = new c(this);
        Intrinsics.checkNotNullParameter(r10, "urlUsageHandlerAPI");
        r1.e = r10;
        this.j = true;
        return;
    }

    public UrlUsageTracker() {
        this.a = LazyKt.lazy(UrlUsageTracker$sceneDbHelper$2.INSTANCE);
        this.b = new ConcurrentHashMap();
        this.d = ((Number) SwitchCenter.z.getValue()).intValue();
        this.e = ((Number) SwitchCenter.A.getValue()).intValue();
        this.g = LazyKt.lazy(UrlUsageTracker$preloadData$2.INSTANCE);
        this.h = LazyKt.lazy(new UrlUsageTracker$preloadMap$2(this));
        this.i = LazyKt.lazy(new UrlUsageTracker$lastPreloadedList$2(this));
        this.m = new ConcurrentLinkedDeque();
    }

    public static final j a(UrlUsageTracker r10) {
        r10.getClass();
        List r11 = (List) SwitchCenter.Q.getValue();
        if (r11 == null) goto L8;
        if (r11.size() != 2) goto L8;
        return new j(((Number) ListProtector.get(r11, 0)).floatValue(), ((Number) ListProtector.get(r11, 1)).floatValue());
    L8:
        return new j(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.util.ArrayList] */
    public static final void b(UrlUsageTracker r20) {
        r20.getClass();
        if (((Boolean) SwitchCenter.O.getValue()).booleanValue() == false) goto L7;
        SceneDbManager r0 = (SceneDbManager) r20.a.getValue();
        if (r0 == null) goto L8;
        Triple<List<com.bytedance.android.anniex.scene.data.c>, Double, Double> r10 = r0.h(((Number) SwitchCenter.H.getValue()).longValue());
    L10:
        if (r10 == null) goto L27;
        Lazy r1 = SceneConnectCenter.a;
        List r11 = (List) r10.getFirst();
        double r12 = ((Number) r10.getSecond()).doubleValue();
        double r13 = ((Number) r10.getThird()).doubleValue();
        Intrinsics.checkNotNullParameter(r11, "hotUrls");
        HybridLogger r14 = HybridLogger.a;
        HybridLogger.f("UrlUsageTracker", "reportPredictUrlUsage url size:" + r11.size() + ", ratio:" + r12 + ", enableRatio:" + r13, null, 12);
        s26.d r15 = s26.d.c;
        r r16 = s26.d.c.c(r.class);
        if (r16 == null) goto L27;
        c1 r17 = new c1("bdx_monitor_annie_hot_url_usage", null, null, null, null, 254);
        JSONObject r18 = new JSONObject();     // Catch: Exception -> L23
        Iterator r19 = CollectionsKt.take(r11, 20).iterator();     // Catch: Exception -> L23
        int r110 = 0;
    L16:
        if (r19.hasNext() == false) goto L21;
        Object r111 = r19.next();     // Catch: Exception -> L23
        int r21 = r110 + 1;     // Catch: Exception -> L23
        if (r110 >= 0) goto L20;
        CollectionsKt.throwIndexOverflow();     // Catch: Exception -> L23
    L20:
        r18.put("top_" + r21 + "_url_usage", ((com.bytedance.android.anniex.scene.data.c) r111).a);     // Catch: Exception -> L23
        r110 = r21;
        goto L16
    L21:
        r18.put("report_type", "predict");     // Catch: Exception -> L23
        r17.d = r18;     // Catch: Exception -> L23
        JSONObject r22 = new JSONObject();     // Catch: Exception -> L23
        r22.put("ratio", r12);     // Catch: Exception -> L23
        r22.put("enable_ratio", r13);     // Catch: Exception -> L23
        r22.put("hot_list_size", r11.size());     // Catch: Exception -> L23
        r17.e = r22;     // Catch: Exception -> L23
    L25:
        r16.S(r17);
    L23:
        e = move-exception;
        HybridLogger r23 = HybridLogger.a;
        HybridLogger.i("UrlUsageTracker", "reportPredictUrlUsage error:" + e.getMessage(), null, 12);
    L27:
        if (((Boolean) SwitchCenter.L.getValue()).booleanValue() == false) goto L55;
        if (r20.f == false) goto L31;
    L53:
        r20.f = true;
        goto L55
    L31:
        if (((String[]) r20.i.getValue()).length != 0) goto L33;
        boolean r24 = true;
    L35:
        if ((!r24) == false) goto L53;
        ArrayList r25 = new ArrayList(((String[]) r20.i.getValue()).length);
        String[] r26 = (String[]) r20.i.getValue();
        int r27 = r26.length;
        int r28 = 0;
    L37:
        if (r28 >= r27) goto L43;
        String r112 = r26[r28];
        if (((HashSet) r20.h.getValue()).contains(r112) == true) goto L41;
        r25.add(r112);
    L41:
        r28 = r28 + 1;
        goto L37
    L43:
        if ((!r25.isEmpty()) == false) goto L53;
        HybridLogger r29 = HybridLogger.a;
        HybridLogger.f("UrlUsageTracker", "准备清理不再高热的URL缓存，数量: " + r25.size(), null, 12);
        Iterator r30 = r25.iterator();
    L46:
        if (r30.hasNext() == false) goto L53;
        final String r31 = (String) r30.next();
        if (r31.length() <= 0) goto L50;
        boolean r32 = true;
    L51:
        if (r32 == false) goto L46;
        com.bytedance.android.anniex.scene.handler.idle.c.a r33 = new com.bytedance.android.anniex.scene.handler.idle.c.a();
        r33.c = 100;
        r33.e = 0;
        r33.f = false;
        Intrinsics.checkNotNullParameter("clear_not_hot_usage_cache", com.bytedance.android.ec.core.event.a.KEY_LUBAN_TAG);
        r33.b = "clear_not_hot_usage_cache";
        r33.e = ((Number) SwitchCenter.M.getValue()).longValue();
        Function1<com.bytedance.android.anniex.scene.data.c, Unit> r34 = new UrlUsageTracker$doClearNotHotUsageCache$1$preloadTask$1(r31);
        Intrinsics.checkNotNullParameter(r34, "r");
        r33.h = r34;
        com.bytedance.android.anniex.scene.handler.idle.h.a.a(r33.a(TaskType.CLEAR_NOT_HOT_USAGE_CACHE));
        goto L46
    L50:
        r32 = false;
        goto L51
    L33:
        r24 = false;
    L55:
        if (((Boolean) SwitchCenter.x.getValue()).booleanValue() == false) goto L108;
        if (r10 == null) goto L83;
        List r35 = (List) r10.getFirst();
        if (r35 == null) goto L83;
        List r36 = (List) SwitchCenter.F.getValue();
        if (r36 != null) goto L62;
        r36 = CollectionsKt.emptyList();
    L62:
        ?? r37 = new ArrayList();
        Iterator r38 = r35.iterator();
    L64:
        if (r38.hasNext() == false) goto L84;
        Object r39 = r38.next();
        com.bytedance.android.anniex.scene.data.c r40 = (com.bytedance.android.anniex.scene.data.c) r39;
        if (Intrinsics.areEqual(r40.a, "lynxview") == true) goto L80;
        List r113 = r36;
        if ((r113 instanceof Collection) == true) goto L70;
    L72:
        Iterator r114 = r113.iterator();
    L74:
        if (r114.hasNext() == false) goto L71;
        if (StringsKt.contains$default(r40.a, (String) r114.next(), false, 2, null) == false) goto L74;
        boolean r41 = false;
    L78:
        if (r41 == false) goto L80;
        boolean r42 = true;
    L81:
        if (r42 == false) goto L64;
        r37.add(r39);
    L71:
        r41 = true;
        goto L78
    L70:
        if (r113.isEmpty() == false) goto L72;
    L80:
        r42 = false;
    L84:
        Lazy r43 = SceneConnectCenter.a;
        Intrinsics.checkNotNullParameter(r37, com.bytedance.android.ec.core.event.a.KEY_LIST);
        Iterable r44 = (Iterable) r37;
        ArrayList r45 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r44, 10));
        Iterator r46 = r44.iterator();
    L86:
        if (r46.hasNext() == false) goto L88;
        r45.add(((com.bytedance.android.anniex.scene.data.c) r46.next()).a);
        goto L86
    L88:
        Object[] r47 = r45.toArray(new String[0]);
        if (r47 == null) goto L107;
        String[] r48 = (String[]) r47;
        HybridLogger r49 = HybridLogger.a;
        HybridLogger.f("UrlUsageTracker", "recordLastCodeCacheMap identifyUrl Size : " + r48.length, null, 12);
        SceneConnectCenter.a().storeStringArray("bdx_anniex_last_code_preload_list_url", r48);
        if (((Boolean) SwitchCenter.y.getValue()).booleanValue() == true) goto L93;
        return;
    L93:
        if (((Boolean) SwitchCenter.j0.getValue()).booleanValue() == false) goto L95;
        boolean r50 = true;
    L96:
        if (r50 == false) goto L132;
        long r51 = System.currentTimeMillis();
        if (SceneConnectCenter.c != 0) goto L101;
        SceneConnectCenter.c = SceneConnectCenter.a().getLong("bdx_anniex_last_code_preload_task", 0);
    L101:
        if ((r51 - SceneConnectCenter.c) <= ((((Number) SwitchCenter.J.getValue()).longValue() * ((long) 60)) * ((long) IServerListener.WHAT_BYTELINK_SINK_ERROR))) goto L103;
        long r52 = System.currentTimeMillis();
        SceneConnectCenter.c = r52;
        SceneConnectCenter.a().storeLong("bdx_anniex_last_code_preload_task", r52);
        boolean r53 = true;
    L104:
        if (r53 == false) goto L133;
        r20.l = true;
        UsageLynxOptimize.d(r37);
        return;
    L133:
        return;
    L103:
        r53 = false;
        goto L104
    L132:
        return;
    L95:
        r50 = !r20.l;
        goto L96
    L107:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L83:
        r37 = CollectionsKt.emptyList();
        goto L84
    L108:
        return;
    L8:
        r10 = null;
        goto L10
    L7:
        ((Boolean) SwitchCenter.P.getValue()).booleanValue();
        goto L8
    }

    public final boolean c(String r10, String r11) {
        if (r11 == null) goto L8;
        if (((HashSet) this.h.getValue()).contains(r11) == false) goto L8;
        return true;
    L8:
        if (SwitchCenter.c() == false) goto L29;
        this.m.add(r10);
        if ((this.m.size() % ((Number) SwitchCenter.z.getValue()).intValue()) != 0) goto L30;
        Lazy r12 = SceneConnectCenter.a;
        List r13 = CollectionsKt.toList(this.m);
        Intrinsics.checkNotNullParameter(r13, "urls");
        if (r13.isEmpty() == false) goto L14;
    L24:
        this.m.clear();
        return false;
    L14:
        if (SwitchCenter.c() == false) goto L24;
        s26.d r14 = s26.d.c;
        r r15 = s26.d.c.c(r.class);
        if (r15 == null) goto L24;
        c1 r16 = new c1("bdx_anniex_code_cache_failed_urls", null, null, null, null, 254);
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L21
        r0.put("failed_urls", r13.toString());     // Catch: Exception -> L21
        r16.d = r0;     // Catch: Exception -> L21
        JSONObject r1 = new JSONObject();     // Catch: Exception -> L21
        r1.put("size", r13.size());     // Catch: Exception -> L21
        r16.e = r1;     // Catch: Exception -> L21
    L23:
        r15.S(r16);
    L21:
        e = move-exception;
        HybridLogger r17 = HybridLogger.a;
        HybridLogger.i("UrlUsageTracker", "reportCodeCacheFailedUrls error:" + e.getMessage(), null, 12);
        goto L23
    L30:
        return false;
    L29:
        return false;
    }
}
