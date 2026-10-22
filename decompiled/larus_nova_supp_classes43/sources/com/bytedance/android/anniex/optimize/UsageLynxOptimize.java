package com.bytedance.android.anniex.optimize;

import android.os.Message;
import com.byted.cast.sink.api.IServerListener;
import com.bytedance.android.anniex.scene.connect.SceneConnectCenter;
import com.bytedance.android.anniex.scene.core.UrlUsageTracker;
import com.bytedance.android.anniex.scene.data.c;
import com.bytedance.android.anniex.scene.handler.idle.TaskType;
import com.bytedance.android.anniex.scene.handler.idle.b;
import com.bytedance.android.anniex.scene.handler.idle.h;
import com.bytedance.android.anniex.scene.next.element.ResPreloadElement;
import com.bytedance.android.anniex.scene.settings.SwitchCenter;
import com.bytedance.forest.chain.fetchers.GeckoXAdapter;
import com.bytedance.forest.model.Scene;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.forest.ForestLoader;
import com.bytedance.ies.bullet.forest.f;
import com.bytedance.ies.bullet.service.base.c1;
import com.bytedance.ies.bullet.service.base.r;
import com.lynx.tasm.LynxViewBuilder;
import com.lynx.tasm.TemplateBundle;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;
import s26.d;
import v26.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class UsageLynxOptimize {
    public static volatile int a;
    public static volatile int b;
    public static volatile int c;
    public static volatile int d;
    public static final int e = 0;

    public static final class a {
        public final boolean a;
        public final boolean b;
        public final boolean c;

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
            if (this.c == r11.c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r1 = 1231;
            if (this.a == false) goto L5;
            int r0 = 1231;
        L6:
            int r10 = r0 * 31;
            if (this.b == false) goto L9;
            int r11 = 1231;
        L10:
            int r12 = (r10 + r11) * 31;
            if (this.c == true) goto L15;
            r1 = 1237;
        L15:
            return r12 + r1;
        L9:
            r11 = 1237;
            goto L10
        L5:
            r0 = 1237;
            goto L6
        }

        public final String toString() {
            return "CodeCacheInfo(disableBySet=" + this.a + ", enableBySet=" + this.b + ", hitPredict=" + this.c + ')';
        }

        public a(boolean r1, boolean r10, boolean r11) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
        }
    }

    static {
        e = ((Number) SwitchCenter.z.getValue()).intValue();
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [T, com.bytedance.android.anniex.scene.data.c] */
    public static void d(List r10) {
        Intrinsics.checkNotNullParameter(r10, "filteredUrls");
        if (((Boolean) SwitchCenter.y.getValue()).booleanValue() == false) goto L10;
        Iterator r11 = r10.iterator();
    L6:
        if (r11.hasNext() == false) goto L16;
        final ?? r0 = (c) r11.next();
        if (GeckoXAdapter.Companion.canParsed(r0.a) == false) goto L6;
        com.bytedance.android.anniex.scene.handler.idle.c.a r1 = new com.bytedance.android.anniex.scene.handler.idle.c.a();
        r1.c = 100;
        r1.e = 0;
        r1.f = false;
        r1.g = r0;
        Intrinsics.checkNotNullParameter("preload_task_by_usage", com.bytedance.android.ec.core.event.a.KEY_LUBAN_TAG);
        r1.b = "preload_task_by_usage";
        r1.e = ((Number) SwitchCenter.K.getValue()).longValue();
        Function1<c, Unit> r12 = new UsageLynxOptimize$startCodeCachePreloadTasks$1$preloadTask$1(r0);
        Intrinsics.checkNotNullParameter(r12, "r");
        r1.h = r12;
        b r13 = r1.a(TaskType.NEXT_THRESHOLD_PREDICT);
        h.a.a(r13);
        goto L6
    L16:
        return;
    }

    public static TemplateBundle b(String r19, String r20) {
        if (SwitchCenter.b() == true) goto L5;
    L35:
        return null;
    L5:
        if (((Boolean) SwitchCenter.h0.getValue()).booleanValue() == false) goto L35;
        if (r19.length() != 0) goto L10;
        boolean r1 = true;
    L11:
        if (r1 == true) goto L35;
        if (r20 != null) goto L14;
    L17:
        boolean r10 = true;
    L18:
        if (r10 == true) goto L35;
        long r11 = System.currentTimeMillis();
        String r12 = za.c.a(r19);     // Catch: Exception -> L36
        final Ref.ObjectRef r15 = new Ref.ObjectRef();     // Catch: Exception -> L36
        UsageLynxOptimize$getTemplateBundleByClientAI$onRequestParamsBuilt$1 r14 = UsageLynxOptimize$getTemplateBundleByClientAI$onRequestParamsBuilt$1.INSTANCE;     // Catch: Exception -> L36
        final Ref.ObjectRef r13 = new Ref.ObjectRef();     // Catch: Exception -> L36
        if (r12 == null) goto L26;
        int r16 = ResPreloadElement.a;     // Catch: Exception -> L36
        Intrinsics.checkNotNullParameter(r12, com.bytedance.android.ec.core.event.a.KEY_URL);     // Catch: Exception -> L36
        if (Intrinsics.areEqual(ResPreloadElement.b.get(r12), Boolean.TRUE) == false) goto L26;
        f r17 = ForestLoader.a;     // Catch: Exception -> L36
        ForestLoader.f(null, r12, null, Scene.LYNX_TEMPLATE, null, new l(), false, r14, new UsageLynxOptimize$getTemplateBundleByClientAI$1(r13, r15), 5);     // Catch: Exception -> L36
    L26:
        HybridLogger r18 = HybridLogger.a;     // Catch: Exception -> L36
        StringBuilder r21 = new StringBuilder("getBundleByClientAI cost:");     // Catch: Exception -> L36
        r21.append(System.currentTimeMillis() - r11);     // Catch: Exception -> L36
        r21.append(",hit cache:");     // Catch: Exception -> L36
        if (r15.element == null) goto L29;
        boolean r0 = true;
    L30:
        r21.append(r0);     // Catch: Exception -> L36
        r21.append(", errorInfo:");     // Catch: Exception -> L36
        String r22 = (String) r13.element;     // Catch: Exception -> L36
        if (r22 != null) goto L33;
        r22 = "";
    L33:
        r21.append(r22);     // Catch: Exception -> L36
        r21.append(", url:");     // Catch: Exception -> L36
        r21.append(r12);     // Catch: Exception -> L36
        HybridLogger.m("PredictManager", r21.toString(), null, null, 12);     // Catch: Exception -> L36
        return (TemplateBundle) r15.element;
    L29:
        r0 = false;
        goto L30
    L14:
        if (r20.length() == 0) goto L17;
        r10 = false;
        goto L18
    L10:
        r1 = false;
        goto L11
    }

    public static void a(ra.b r10, LynxViewBuilder r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "builderParams");
        Intrinsics.checkNotNullParameter(r11, "builder");
        Intrinsics.checkNotNullParameter(r12, "targetUrl");
        if (((Boolean) SwitchCenter.x.getValue()).booleanValue() == true) goto L5;
        return;
    L5:
        long r0 = System.currentTimeMillis();
        if (r10.u == false) goto L17;
        String r13 = r10.v;
        if (r13 != null) goto L10;
    L13:
        boolean r14 = true;
    L14:
        if (r14 == true) goto L17;
        c(new a(false, true, false), r12, null);
        HybridLogger r15 = HybridLogger.a;
        UrlUsageTracker r16 = UrlUsageTracker.n;
        HybridLogger.f("UrlUsageTracker", "lite enable code cache bySet：" + r12 + ", cost:" + (System.currentTimeMillis() - r0), null, 12);
        return;
    L10:
        if (r13.length() == 0) goto L13;
        r14 = false;
    L17:
        String r17 = za.c.a(r12);
        UrlUsageTracker r18 = UrlUsageTracker.n;
        if (UrlUsageTracker.b.a().c(r12, r17) == false) goto L20;
        r11.setEnableUserBytecode(true);
        r11.setBytecodeSourceUrl(r17);
        c(new a(false, false, true), r12, r17);
        HybridLogger r19 = HybridLogger.a;
        HybridLogger.m("UrlUsageTracker", "lite enable code cache by usage：" + r12 + ", cost:" + (System.currentTimeMillis() - r0), null, null, 12);
        return;
    L20:
        c(new a(false, false, false), r12, null);
        HybridLogger r20 = HybridLogger.a;
        HybridLogger.f("UrlUsageTracker", "lite unable code cache：" + r12 + ", cost:" + (System.currentTimeMillis() - r0), null, 12);
    }

    public static void c(a r21, String r22, String r23) {
        Intrinsics.checkNotNullParameter(r21, "codeCacheInfo");
        a++;
        if (r21.b == false) goto L6;
        b++;
    L6:
        if (r21.c == false) goto L9;
        c++;
    L9:
        if (r21.a == false) goto L12;
        d++;
    L12:
        if ((a % e) != 0) goto L23;
        Lazy r0 = SceneConnectCenter.a;
        int r1 = a;
        int r10 = b;
        int r11 = c;
        int r12 = d;
        HybridLogger r13 = HybridLogger.a;
        UrlUsageTracker r14 = UrlUsageTracker.n;
        HybridLogger.f("UrlUsageTracker", "reportRealUrlUsage createCount:" + r1 + ", enableBySetCount:" + r10 + ", hitCount:" + r11, null, 12);
        d r15 = d.c;
        r r16 = d.c.c(r.class);
        if (r16 == null) goto L21;
        c1 r17 = new c1("bdx_monitor_annie_hot_url_usage", null, null, null, null, 254);
        JSONObject r18 = new JSONObject();     // Catch: Exception -> L18
        r18.put("report_type", "recall");     // Catch: Exception -> L18
        r17.d = r18;     // Catch: Exception -> L18
        JSONObject r19 = new JSONObject();     // Catch: Exception -> L18
        double r20 = r1;
        r19.put("set_ratio", ((double) r10) / r20);     // Catch: Exception -> L18
        r19.put("hit_ratio", ((double) r11) / r20);     // Catch: Exception -> L18
        r19.put("enable_ratio", ((double) (r10 + r11)) / r20);     // Catch: Exception -> L18
        r19.put("disable_ratio", ((double) r12) / r20);     // Catch: Exception -> L18
        r17.e = r19;     // Catch: Exception -> L18
    L20:
        r16.S(r17);
    L18:
        e = move-exception;
        HybridLogger r24 = HybridLogger.a;
        UrlUsageTracker r25 = UrlUsageTracker.n;
        HybridLogger.i("UrlUsageTracker", "reportRealUrlUsage error:" + e.getMessage(), null, 12);
    L21:
        a = 0;
        b = 0;
        c = 0;
        d = 0;
    L23:
        if (r22 == null) goto L78;
        UrlUsageTracker r26 = UrlUsageTracker.n;
        UrlUsageTracker r27 = UrlUsageTracker.b.a();
        if (r21.a == false) goto L28;
        int r28 = 2;
    L31:
        r27.getClass();
        if (((Boolean) SwitchCenter.w.getValue()).booleanValue() == false) goto L81;
        UrlUsageTracker.a r29 = r27.b.get(r22);
        if (r29 == null) goto L37;
        r29.a++;
    L38:
        r27.c++;
        Lazy r30 = SwitchCenter.i0;
        if (((Boolean) r30.getValue()).booleanValue() == false) goto L41;
        boolean r31 = true;
    L42:
        if (r31 == false) goto L68;
        if (r27.c < r27.e) goto L68;
        r27.d();
        if (r27.j == false) goto L68;
        if (((Boolean) r30.getValue()).booleanValue() == false) goto L50;
        boolean r32 = true;
    L51:
        if (r32 == false) goto L68;
        Lazy r33 = SceneConnectCenter.a;
        long r34 = System.currentTimeMillis();
        if (SceneConnectCenter.b != 0) goto L56;
        SceneConnectCenter.b = SceneConnectCenter.a().getLong("bdx_anniex_last_code_preload", 0);
    L56:
        if ((r34 - SceneConnectCenter.b) <= ((((Number) SwitchCenter.I.getValue()).longValue() * ((long) 60)) * ((long) IServerListener.WHAT_BYTELINK_SINK_ERROR))) goto L58;
        long r35 = System.currentTimeMillis();
        SceneConnectCenter.b = r35;
        SceneConnectCenter.a().storeLong("bdx_anniex_last_code_preload", r35);
        boolean r36 = true;
    L59:
        if (r36 == false) goto L68;
        HybridLogger r37 = HybridLogger.a;
        StringBuilder r38 = new StringBuilder("recordUrlUsage query, internal:");
        Lazy r39 = SwitchCenter.N;
        r38.append(((Number) r39.getValue()).longValue());
        HybridLogger.f("UrlUsageTracker", r38.toString(), null, 12);
        va.a.C0207a r40 = va.a.g;
        va.a.b r41 = r40.a().b;
        if (r41 == null) goto L63;
        r41.removeMessages(5);
    L63:
        Message r42 = Message.obtain();
        r42.what = 5;
        va.a.b r43 = r40.a().b;
        if (r43 == null) goto L66;
        r43.sendMessageDelayed(r42, ((Number) r39.getValue()).longValue());
    L66:
        r27.k = true;
        goto L68
    L58:
        r36 = false;
        goto L59
    L50:
        r32 = !r27.k;
    L68:
        if ((r27.c % r27.d) != 0) goto L79;
        r27.d();
        va.a.C0207a r44 = va.a.g;
        va.a.b r45 = r44.a().b;
        if (r45 == null) goto L72;
        r45.removeMessages(4);
    L72:
        Message r46 = Message.obtain();
        r46.what = 4;
        va.a.b r47 = r44.a().b;
        if (r47 == null) goto L80;
        r47.sendMessageDelayed(r46, ((Number) SwitchCenter.B.getValue()).longValue());
        return;
    L80:
        return;
    L79:
        return;
    L41:
        r31 = !r27.k;
        goto L42
    L37:
        r27.b.put(r22, new UrlUsageTracker.a(r22, r23, r28));
        goto L38
    L81:
        return;
    L28:
        if (r21.b == false) goto L30;
        r28 = 1;
        goto L31
    L30:
        r28 = 0;
        goto L31
    }
}
