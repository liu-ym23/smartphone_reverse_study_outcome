package ra;

import android.graphics.Point;
import android.net.Uri;
import android.view.View;
import com.bytedance.forest.Forest;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.lynx.init.e;
import com.bytedance.ies.bullet.lynx.init.h;
import com.bytedance.ies.bullet.lynx.resource.forest.ForestDynamicComponentProvider;
import com.bytedance.ies.bullet.lynx.resource.forest.ForestExternalJSProvider;
import com.bytedance.ies.bullet.lynx.resource.forest.ForestLynxGenericResourceProvider;
import com.bytedance.ies.bullet.lynx.resource.forest.ForestTemplateResourceProvider;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.lynx.jsbridge.f;
import com.lynx.tasm.LynxBooleanOption;
import com.lynx.tasm.LynxGroup;
import com.lynx.tasm.LynxViewBuilder;
import com.lynx.tasm.ThreadStrategyForRendering;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.t;
import d8a.k;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import w26.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {
    public static final a B = null;
    public String A;
    public final boolean a;
    public final ThreadStrategyForRendering b;
    public final LynxGroup c;
    public final String d;
    public final int e;
    public final int f;
    public final float g;
    public final boolean h;
    public final boolean i;
    public final Function1<LynxViewBuilder, Unit> j;
    public final boolean k;
    public final int l;
    public final int m;
    public final List<com.lynx.tasm.behavior.a> n;
    public final List<f> o;
    public final Map<String, k<?, ?>> p;
    public final w7a.a.b q;
    public final boolean r;
    public final boolean s;
    public final boolean t;
    public final boolean u;
    public final String v;
    public final boolean w;
    public final float x;
    public HashMap<String, String> y;
    public Uri z;

    public static final class a {
        public a() {
        }

        public final b c(Uri r38) {
            Intrinsics.checkNotNullParameter(r38, "uri");
            if (r38.isHierarchical() == false) goto L5;
            HashMap<String, String> r1 = new HashMap();
            if (r38.getBooleanQueryParameter("enable_lynx_config", false) == false) goto L14;
            Iterator r10 = UriProtector.getQueryParameterNames(r38).iterator();
        L10:
            if (r10.hasNext() == false) goto L14;
            String r11 = (String) r10.next();
            String r12 = UriProtector.getQueryParameter(r38, r11);
            if (com.bytedance.ies.bullet.kit.resourceloader.loader.b.d(r12) == false) goto L10;
            r1.put(r11, r12);
        L14:
            String r13 = UriProtector.getQueryParameter(r38, "group");
            if (r13 != null) goto L17;
            r13 = "";
        L17:
            boolean r14 = r38.getBooleanQueryParameter("use_storage_group", false);
            boolean r15 = r38.getBooleanQueryParameter("enable_canvas", false);
            boolean r16 = r38.getBooleanQueryParameter("enable_canvas_optimize", false);
            boolean r17 = r38.getBooleanQueryParameter("enable_dynamic_v8", false);
            boolean r18 = r38.getBooleanQueryParameter("share_group", true);
            if (r15 == true) goto L20;
        L22:
            HybridLogger r19 = HybridLogger.a;
            Float r110 = null;
            HybridLogger.m("LynxViewBuilderParams", "shareGroup=" + r18 + ", useStorageGroup=" + r14, null, null, 12);
            if (r14 == false) goto L26;
            LynxGroup r20 = a(r13, r18, r15, new String[]{"assets://bdlynx_core.js"}, r17, r16, true);
        L25:
            LynxGroup r111 = r20;
            boolean r32 = r38.getBooleanQueryParameter("enable_code_cache", false);
            String r21 = UriProtector.getQueryParameter(r38, "lynx_preset_height");
            String r22 = UriProtector.getQueryParameter(r38, "lynx_preset_width");
            String r23 = UriProtector.getQueryParameter(r38, "lynx_preset_height_spec");
            String r24 = UriProtector.getQueryParameter(r38, "lynx_preset_width_spec");
            if (r22 != null) goto L35;
            if (r21 != null) goto L35;
            int r25 = 0;
            int r26 = 0;
        L41:
            if (r24 == null) goto L44;
            if (r23 == null) goto L44;
            int r27 = CastIntegerProtector.parseInt(r24);
            int r112 = CastIntegerProtector.parseInt(r23);
        L45:
            String r28 = UriProtector.getQueryParameter(r38, "thread_strategy");
            if (r28 == null) goto L48;
            Integer r29 = Integer.valueOf(CastIntegerProtector.parseInt(r28));
        L49:
            ThreadStrategyForRendering r30 = ThreadStrategyForRendering.ALL_ON_UI;
            int r31 = r30.id();
            if (r29 != null) goto L53;
        L55:
            ThreadStrategyForRendering r33 = ThreadStrategyForRendering.MOST_ON_TASM;
            int r34 = r33.id();
            if (r29 != null) goto L59;
        L61:
            r33 = ThreadStrategyForRendering.PART_ON_LAYOUT;
            int r35 = r33.id();
            if (r29 != null) goto L65;
        L67:
            r33 = ThreadStrategyForRendering.MULTI_THREADS;
            int r36 = r33.id();
            if (r29 != null) goto L71;
        L73:
            ThreadStrategyForRendering r113 = r30;
        L74:
            boolean r37 = r38.getBooleanQueryParameter("enable_font_scale", false);
            String r39 = UriProtector.getQueryParameter(r38, "font_scale");
            if (r37 == false) goto L78;
            if (r39 != null) goto L78;
            Float r40 = h.d;
        L82:
            if (r40 == null) goto L84;
            float r210 = r40.floatValue();
        L85:
            boolean r41 = r38.getBooleanQueryParameter("enable_view_zoom", false);
            String r42 = UriProtector.getQueryParameter(r38, "view_zoom");
            if (r41 == false) goto L89;
            if (r42 != null) goto L89;
            r110 = h.e;
        L91:
            if (r110 == null) goto L93;
            float r310 = r110.floatValue();
        L94:
            boolean r211 = r38.getBooleanQueryParameter("create_view_async", false);
            Function1 r212 = null;
            int r213 = 0;
            int r214 = 0;
            List r215 = null;
            boolean r311 = false;
            String r114 = r13;
            b r43 = new b(r38.getBooleanQueryParameter("preset_safe_point", false), r113, r111, r114, r112, r27, r210, r211, r38.getBooleanQueryParameter("enable_sync_flush", false), r212, !r38.getBooleanQueryParameter("disable_auto_expose", false), r213, r214, r215, r38.getBooleanQueryParameter("enable_pending_js_task", false), r311, r38.getBooleanQueryParameter("air_strict_mode", false), r32, null, r38.getBooleanQueryParameter("enable_vsync_aligned_message_loop", false), r310, 2488832);
            r43.y = r1;
            r43.z = r38;
            return r43;
        L93:
            r310 = 1.0f;
        L89:
            if (r42 == null) goto L91;
            r110 = Float.valueOf(CastFloatProtector.parseFloat(r42));
            goto L91
        L84:
            r210 = 1.0f;
        L78:
            if (r39 == null) goto L80;
            r40 = Float.valueOf(CastFloatProtector.parseFloat(r39));
            goto L82
        L80:
            r40 = null;
            goto L82
        L71:
            if (r29.intValue() != r36) goto L73;
        L72:
            r113 = r33;
            goto L74
        L65:
            if (r29.intValue() != r35) goto L67;
        L59:
            if (r29.intValue() != r34) goto L61;
        L53:
            if (r29.intValue() != r31) goto L55;
        L48:
            r29 = null;
        L44:
            r112 = r25;
            r27 = r26;
        L35:
            if (r22 == null) goto L37;
            r26 = View.MeasureSpec.makeMeasureSpec(CastIntegerProtector.parseInt(r22), 1073741824);
        L38:
            if (r21 == null) goto L40;
            r25 = View.MeasureSpec.makeMeasureSpec(CastIntegerProtector.parseInt(r21), 1073741824);
            goto L41
        L40:
            r25 = View.MeasureSpec.makeMeasureSpec(0, 0);
            goto L41
        L37:
            r26 = View.MeasureSpec.makeMeasureSpec(0, 0);
            goto L38
        L26:
            if (r16 == false) goto L28;
            r20 = b(this, r13, r18, r15, new String[]{"assets://bdlynx_core.js"}, r17, r16);
            goto L25
        L28:
            Intrinsics.checkNotNullParameter(r13, "groupName");
            r20 = e.b(r13, r18, r15, new String[]{"assets://bdlynx_core.js"}, r17, false);
            goto L25
        L20:
            if (Intrinsics.areEqual(r13, "-1") == true) goto L22;
            r13 = r13.concat("_canvas");
            goto L22
        L5:
            return new b(false, null, null, null, 0, 0, 0.0f, false, false, null, false, 0, 0, null, false, false, false, false, null, false, 0.0f, 16777215);
        }

        public static LynxGroup a(String r10, boolean r11, boolean r12, String[] r13, boolean r14, boolean r15, boolean r16) {
            Intrinsics.checkNotNullParameter(r10, "groupName");
            if (r16 == false) goto L6;
            Object r17 = e.a;
            return e.c(r10, r13, r12, r14, r15, true);
        L6:
            Map r18 = x26.a.a;
            g r19 = (g) x26.a.a(g.class);
            if (r19 == null) goto L13;
            w26.e r110 = (w26.e) r19.n0(w26.e.class);
            if (r110 == null) goto L13;
            Boolean r111 = r110.J();
            if (r111 == null) goto L13;
            boolean r112 = r111.booleanValue();
        L14:
            if (r112 == false) goto L18;
            Object r113 = e.a;
            return e.b(r10, r11, r12, r13, r14, r15);
        L18:
            if (Intrinsics.areEqual(r10, "-1") == true) goto L20;
            if (r11 == false) goto L24;
            return e.d(r10, r13, r12, r14, r15);
        L24:
            return LynxGroup.Create(r10, r13, false, r12, r14, r15);
        L20:
            return LynxGroup.Create(r10, r10, r13, false, r12, r14, r15);
        L13:
            r112 = false;
            goto L14
        }

        public static /* synthetic */ LynxGroup b(a r10, String r11, boolean r12, boolean r13, String[] r14, boolean r15, boolean r16) {
            r10.getClass();
            return a(r11, r12, r13, r14, r15, r16, false);
        }
    }

    static {
        B = new a();
    }

    public b() {
        this(false, null, null, null, 0, 0, 0.0f, false, false, null, false, 0, 0, null, false, false, false, false, null, false, 0.0f, 16777215);
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof b) == true) goto L8;
        return false;
    L8:
        b r11 = (b) r10;
        if (this.a == r11.a) goto L12;
        return false;
    L12:
        if (this.b == r11.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r11.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r11.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r11.e) goto L24;
        return false;
    L24:
        if (this.f == r11.f) goto L27;
        return false;
    L27:
        if (Float.compare(this.g, r11.g) == 0) goto L30;
        return false;
    L30:
        if (this.h == r11.h) goto L33;
        return false;
    L33:
        if (this.i == r11.i) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r11.j) == true) goto L39;
        return false;
    L39:
        if (this.k == r11.k) goto L42;
        return false;
    L42:
        if (this.l == r11.l) goto L45;
        return false;
    L45:
        if (this.m == r11.m) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.n, r11.n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.o, r11.o) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.p, r11.p) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.q, r11.q) == true) goto L60;
        return false;
    L60:
        if (this.r == r11.r) goto L63;
        return false;
    L63:
        if (this.s == r11.s) goto L66;
        return false;
    L66:
        if (this.t == r11.t) goto L69;
        return false;
    L69:
        if (this.u == r11.u) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.v, r11.v) == true) goto L75;
        return false;
    L75:
        if (this.w == r11.w) goto L78;
        return false;
    L78:
        if (Float.compare(this.x, r11.x) == 0) goto L80;
        return false;
    L80:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r10 = ((r0 * 31) + this.b.hashCode()) * 31;
        LynxGroup r11 = this.c;
        int r12 = 0;
        if (r11 != null) goto L9;
        int r13 = 0;
    L10:
        int r14 = (r10 + r13) * 31;
        String r15 = this.d;
        if (r15 != null) goto L13;
        int r16 = 0;
    L14:
        int r17 = (((((((r14 + r16) * 31) + this.e) * 31) + this.f) * 31) + Float.floatToIntBits(this.g)) * 31;
        if (this.h == false) goto L17;
        int r18 = 1231;
    L18:
        int r19 = (r17 + r18) * 31;
        if (this.i == false) goto L21;
        int r20 = 1231;
    L22:
        int r21 = (r19 + r20) * 31;
        Function1<LynxViewBuilder, Unit> r22 = this.j;
        if (r22 != null) goto L25;
        int r23 = 0;
    L26:
        int r24 = (r21 + r23) * 31;
        if (this.k == false) goto L29;
        int r25 = 1231;
    L30:
        int r26 = (((((((((((r24 + r25) * 31) + this.l) * 31) + this.m) * 31) + this.n.hashCode()) * 31) + this.o.hashCode()) * 31) + this.p.hashCode()) * 31;
        w7a.a.b r27 = this.q;
        if (r27 != null) goto L33;
        int r28 = 0;
    L34:
        int r29 = (r26 + r28) * 31;
        if (this.r == false) goto L37;
        int r30 = 1231;
    L38:
        int r31 = (r29 + r30) * 31;
        if (this.s == false) goto L41;
        int r32 = 1231;
    L42:
        int r33 = (r31 + r32) * 31;
        if (this.t == false) goto L45;
        int r34 = 1231;
    L46:
        int r35 = (r33 + r34) * 31;
        if (this.u == false) goto L49;
        int r36 = 1231;
    L50:
        int r37 = (r35 + r36) * 31;
        String r38 = this.v;
        if (r38 == null) goto L54;
        r12 = r38.hashCode();
    L54:
        int r39 = (r37 + r12) * 31;
        if (this.w == true) goto L59;
        r1 = 1237;
    L59:
        return ((r39 + r1) * 31) + Float.floatToIntBits(this.x);
    L49:
        r36 = 1237;
        goto L50
    L45:
        r34 = 1237;
        goto L46
    L41:
        r32 = 1237;
        goto L42
    L37:
        r30 = 1237;
        goto L38
    L33:
        r28 = r27.hashCode();
        goto L34
    L29:
        r25 = 1237;
        goto L30
    L25:
        r23 = r22.hashCode();
        goto L26
    L21:
        r20 = 1237;
        goto L22
    L17:
        r18 = 1237;
        goto L18
    L13:
        r16 = r15.hashCode();
        goto L14
    L9:
        r13 = r11.hashCode();
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "LynxViewBuilderParams(enableLayoutSafepoint=" + this.a + ", threadStrategy=" + this.b + ", lynxGroup=" + this.c + ", lynxGroupName=" + this.d + ", presetHeightMeasureSpec=" + this.e + ", presetWidthMeasureSpec=" + this.f + ", fontScale=" + this.g + ", enableCreateViewAsync=" + this.h + ", enableSyncFlush=" + this.i + ", customInit=" + this.j + ", enableAutoExpose=" + this.k + ", screenWidth=" + this.l + ", screenHeight=" + this.m + ", behaviors=" + this.n + ", modules=" + this.o + ", resourceProviders=" + this.p + ", fontLoader=" + this.q + ", enablePendingJsTask=" + this.r + ", enableJSRuntime=" + this.s + ", enableAirStrictMode=" + this.t + ", enableUserCodeCache=" + this.u + ", codeCacheSourceUrl=" + this.v + ", enableVSyncAlignedMessageLoop=" + this.w + ", viewZoom=" + this.x + ')';
    }

    public static final Point a(b r10, b r11) {
        r10.getClass();
        Point r12 = new Point();
        int r0 = r11.l;
        int r1 = r11.m;
        int r13 = com.bytedance.android.anniex.utils.b.a;
        com.bytedance.android.anniex.utils.b.a(r11.z);
        r12.x = r0;
        r12.y = r1;
        HybridLogger r14 = HybridLogger.a;
        HybridLogger.m("LynxViewBuilderParams", "contentSize===" + r12, null, null, 12);
        return r12;
    }

    public final t c(String r13, String r14, Forest r15) {
        Intrinsics.checkNotNullParameter(r13, "sessionId");
        Intrinsics.checkNotNullParameter(r14, "bid");
        TraceEvent.beginSection("LynxViewBuilderParams:toLynxEngineBuilder");
        TraceEvent.beginSection("LynxViewBuilder:<init>");     // Catch: Throwable -> L45
        t r10 = new t();     // Catch: Throwable -> L42
        TraceEvent.endSection("LynxViewBuilder:<init>");     // Catch: Throwable -> L45
        r10.setEnableVSyncAlignedMessageLoop(this.w);     // Catch: Throwable -> L45
        r10.setEnableLayoutSafepoint(this.a);     // Catch: Throwable -> L45
        r10.setThreadStrategyForRendering(this.b);     // Catch: Throwable -> L45
        r10.setLynxGroup(this.c);     // Catch: Throwable -> L45
        Point r11 = a(this, this);     // Catch: Throwable -> L45
        Point r12 = new Point();     // Catch: Throwable -> L45
        int r16 = this.f;     // Catch: Throwable -> L45
        int r17 = this.e;     // Catch: Throwable -> L45
        int r18 = com.bytedance.android.anniex.utils.b.a;     // Catch: Throwable -> L45
        com.bytedance.android.anniex.utils.b.a(this.z);     // Catch: Throwable -> L45
        r12.x = r16;     // Catch: Throwable -> L45
        r12.y = r17;     // Catch: Throwable -> L45
        r10.setPresetMeasuredSpec(r16, r17);     // Catch: Throwable -> L45
        r10.setFontScale(this.g);     // Catch: Throwable -> L45
        r10.setEnableCreateViewAsync(this.h);     // Catch: Throwable -> L45
        r10.setEnableSyncFlush(this.i);     // Catch: Throwable -> L45
        r10.enableAutoExpose(this.k);     // Catch: Throwable -> L45
        r10.setScreenSize(r11.x, r11.y);     // Catch: Throwable -> L45
        TraceEvent.beginSection("LynxViewBuilder:addBehaviors");     // Catch: Throwable -> L45
        r10.addBehaviors(this.n);     // Catch: Throwable -> L39
        TraceEvent.endSection("LynxViewBuilder:addBehaviors");     // Catch: Throwable -> L45
        TraceEvent.beginSection("LynxViewBuilder:registerModule");     // Catch: Throwable -> L45
        Iterator<T> r19 = this.o.iterator();     // Catch: Throwable -> L36
    L10:
        if (r19.hasNext() == false) goto L12;
        f r20 = (f) r19.next();     // Catch: Throwable -> L36
        r10.registerModule(r20.b(), r20.a(), r20.c());     // Catch: Throwable -> L36
        goto L10
    L12:
        Unit r21 = Unit.INSTANCE;     // Catch: Throwable -> L36
        TraceEvent.endSection("LynxViewBuilder:registerModule");     // Catch: Throwable -> L45
        Iterator r22 = MapsKt.asSequence(this.p).iterator();     // Catch: Throwable -> L45
    L15:
        if (r22.hasNext() == false) goto L18;
        Map.Entry r23 = (Map.Entry) r22.next();     // Catch: Throwable -> L45
        r10.setResourceProvider((String) r23.getKey(), (k) r23.getValue());     // Catch: Throwable -> L45
        goto L15
    L18:
        if (com.bytedance.ies.bullet.service.base.h.a0() == false) goto L20;
        r10.setLynxViewConfig(this.y);     // Catch: Throwable -> L45
    L20:
        r10.setFontLoader(this.q);     // Catch: Throwable -> L45
        r10.setEnablePendingJsTask(this.r);     // Catch: Throwable -> L45
        r10.setEnableJSRuntime(this.s);     // Catch: Throwable -> L45
        r10.setEnableAirStrictMode(this.t);     // Catch: Throwable -> L45
        r10.setEnableUserCodeCache(this.u);     // Catch: Throwable -> L45
        r10.setCodeCacheSourceUrl(this.v);     // Catch: Throwable -> L45
        r10.setDynamicComponentFetcher(new ForestDynamicComponentProvider("ttnet", r13, r14));     // Catch: Throwable -> L45
        Uri r24 = r10.getUri();     // Catch: Throwable -> L45
        if (com.bytedance.ies.bullet.service.base.h.Z() == false) goto L23;
        r24 = this.z;     // Catch: Throwable -> L45
    L23:
        boolean r25 = false;
        if (r24 != null) goto L26;
    L28:
        if (r25 == false) goto L30;
        r10.setGenericResourceFetcher(new ForestLynxGenericResourceProvider("ttnet", r13, r14, r15));     // Catch: Throwable -> L45
        r10.setMediaResourceFetcher(new com.bytedance.ies.bullet.lynx.resource.forest.a("ttnet", r13, r14, r15));     // Catch: Throwable -> L45
        r10.setTemplateResourceFetcher(new ForestTemplateResourceProvider("ttnet", r13, null, r14, r15, 4));     // Catch: Throwable -> L45
        r10.setEnableGenericResourceFetcher(LynxBooleanOption.TRUE);     // Catch: Throwable -> L45
    L30:
        r10.setResourceProvider("EXTERNAL_JS_SOURCE", new ForestExternalJSProvider("ttnet", r13, r14));     // Catch: Throwable -> L45
        Function1<LynxViewBuilder, Unit> r110 = this.j;     // Catch: Throwable -> L45
        if (r110 == null) goto L33;
        r110.invoke(r10);     // Catch: Throwable -> L45
    L33:
        r10.setThreadStrategyForRendering(ThreadStrategyForRendering.MOST_ON_TASM);     // Catch: Throwable -> L45
        r10.setEnablePendingJsTask(true);     // Catch: Throwable -> L45
        TraceEvent.endSection("LynxViewBuilderParams:toLynxEngineBuilder");
        return r10;
    L26:
        if (r24.getBooleanQueryParameter("enable_lynx_generic_fetcher", false) != true) goto L28;
        r25 = true;
        goto L28
    L36:
        th = move-exception;
        TraceEvent.endSection("LynxViewBuilder:registerModule");     // Catch: Throwable -> L45
        throw th;     // Catch: Throwable -> L45
    L39:
        th = move-exception;
        TraceEvent.endSection("LynxViewBuilder:addBehaviors");     // Catch: Throwable -> L45
        throw th;     // Catch: Throwable -> L45
    L42:
        th = move-exception;
        TraceEvent.endSection("LynxViewBuilder:<init>");     // Catch: Throwable -> L45
        throw th;     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        TraceEvent.endSection("LynxViewBuilderParams:toLynxEngineBuilder");
        throw th;
    }

    public final LynxViewBuilder d(String r12, String r13, Forest r14) {
        Intrinsics.checkNotNullParameter(r12, "sessionId");
        Intrinsics.checkNotNullParameter(r13, "bid");
        TraceEvent.beginSection("LynxViewBuilderParams:toLynxViewBuilder");
        TraceEvent.beginSection("LynxViewBuilder:<init>");     // Catch: Throwable -> L45
        LynxViewBuilder r10 = new LynxViewBuilder();     // Catch: Throwable -> L42
        TraceEvent.endSection("LynxViewBuilder:<init>");     // Catch: Throwable -> L45
        r10.setEnableVSyncAlignedMessageLoop(this.w);     // Catch: Throwable -> L45
        r10.setEnableLayoutSafepoint(this.a);     // Catch: Throwable -> L45
        r10.setThreadStrategyForRendering(this.b);     // Catch: Throwable -> L45
        r10.setLynxGroup(this.c);     // Catch: Throwable -> L45
        Point r11 = a(this, this);     // Catch: Throwable -> L45
        Point r15 = new Point();     // Catch: Throwable -> L45
        int r16 = this.f;     // Catch: Throwable -> L45
        int r17 = this.e;     // Catch: Throwable -> L45
        int r18 = com.bytedance.android.anniex.utils.b.a;     // Catch: Throwable -> L45
        com.bytedance.android.anniex.utils.b.a(this.z);     // Catch: Throwable -> L45
        r15.x = r16;     // Catch: Throwable -> L45
        r15.y = r17;     // Catch: Throwable -> L45
        r10.setPresetMeasuredSpec(r16, r17);     // Catch: Throwable -> L45
        r10.setFontScale(this.g);     // Catch: Throwable -> L45
        r10.setEnableCreateViewAsync(this.h);     // Catch: Throwable -> L45
        r10.setEnableSyncFlush(this.i);     // Catch: Throwable -> L45
        r10.enableAutoExpose(this.k);     // Catch: Throwable -> L45
        r10.setScreenSize(r11.x, r11.y);     // Catch: Throwable -> L45
        if (com.bytedance.ies.bullet.service.base.h.a0() == false) goto L8;
        r10.setLynxViewConfig(this.y);     // Catch: Throwable -> L45
    L9:
        TraceEvent.beginSection("LynxViewBuilder:addBehaviors");     // Catch: Throwable -> L45
        r10.addBehaviors(this.n);     // Catch: Throwable -> L39
        TraceEvent.endSection("LynxViewBuilder:addBehaviors");     // Catch: Throwable -> L45
        TraceEvent.beginSection("LynxViewBuilder:registerModule");     // Catch: Throwable -> L45
        Iterator<T> r19 = this.o.iterator();     // Catch: Throwable -> L36
    L14:
        if (r19.hasNext() == false) goto L16;
        f r20 = (f) r19.next();     // Catch: Throwable -> L36
        r10.registerModule(r20.b(), r20.a(), r20.c());     // Catch: Throwable -> L36
        goto L14
    L16:
        Unit r21 = Unit.INSTANCE;     // Catch: Throwable -> L36
        TraceEvent.endSection("LynxViewBuilder:registerModule");     // Catch: Throwable -> L45
        Iterator r22 = MapsKt.asSequence(this.p).iterator();     // Catch: Throwable -> L45
    L19:
        if (r22.hasNext() == false) goto L21;
        Map.Entry r23 = (Map.Entry) r22.next();     // Catch: Throwable -> L45
        r10.setResourceProvider((String) r23.getKey(), (k) r23.getValue());     // Catch: Throwable -> L45
        goto L19
    L21:
        r10.setFontLoader(this.q);     // Catch: Throwable -> L45
        r10.setEnablePendingJsTask(this.r);     // Catch: Throwable -> L45
        r10.setEnableJSRuntime(this.s);     // Catch: Throwable -> L45
        r10.setEnableAirStrictMode(this.t);     // Catch: Throwable -> L45
        r10.setEnableUserCodeCache(this.u);     // Catch: Throwable -> L45
        r10.setCodeCacheSourceUrl(this.v);     // Catch: Throwable -> L45
        r10.setDynamicComponentFetcher(new ForestDynamicComponentProvider("ttnet", r12, r13));     // Catch: Throwable -> L45
        Uri r24 = r10.getUri();     // Catch: Throwable -> L45
        if (com.bytedance.ies.bullet.service.base.h.Z() == false) goto L24;
        r24 = this.z;     // Catch: Throwable -> L45
    L24:
        boolean r25 = false;
        if (r24 != null) goto L27;
    L29:
        if (r25 == false) goto L31;
        r10.setGenericResourceFetcher(new ForestLynxGenericResourceProvider("ttnet", r12, r13, r14));     // Catch: Throwable -> L45
        r10.setMediaResourceFetcher(new com.bytedance.ies.bullet.lynx.resource.forest.a("ttnet", r12, r13, r14));     // Catch: Throwable -> L45
        r10.setTemplateResourceFetcher(new ForestTemplateResourceProvider("ttnet", r12, null, r13, r14, 4));     // Catch: Throwable -> L45
        r10.setEnableGenericResourceFetcher(LynxBooleanOption.TRUE);     // Catch: Throwable -> L45
    L31:
        r10.setResourceProvider("EXTERNAL_JS_SOURCE", new ForestExternalJSProvider("ttnet", r12, r13));     // Catch: Throwable -> L45
        Function1<LynxViewBuilder, Unit> r110 = this.j;     // Catch: Throwable -> L45
        if (r110 == null) goto L34;
        r110.invoke(r10);     // Catch: Throwable -> L45
    L34:
        TraceEvent.endSection("LynxViewBuilderParams:toLynxViewBuilder");
        return r10;
    L27:
        if (r24.getBooleanQueryParameter("enable_lynx_generic_fetcher", false) != true) goto L29;
        r25 = true;
        goto L29
    L36:
        th = move-exception;
        TraceEvent.endSection("LynxViewBuilder:registerModule");     // Catch: Throwable -> L45
        throw th;     // Catch: Throwable -> L45
    L39:
        th = move-exception;
        TraceEvent.endSection("LynxViewBuilder:addBehaviors");     // Catch: Throwable -> L45
        throw th;     // Catch: Throwable -> L45
    L8:
        r10.setLynxViewConfig(r10.getLynxViewConfig());     // Catch: Throwable -> L45
        goto L9
    L42:
        th = move-exception;
        TraceEvent.endSection("LynxViewBuilder:<init>");     // Catch: Throwable -> L45
        throw th;     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        TraceEvent.endSection("LynxViewBuilderParams:toLynxViewBuilder");
        throw th;
    }

    public static b b(b r28, boolean r29, ThreadStrategyForRendering r30, LynxGroup r31, String r32, int r33, int r34, float r35, boolean r36, boolean r37, Function1 r38, boolean r39, List r40, List r41, boolean r42, boolean r43, boolean r44, String r45, boolean r46, float r47, int r48) {
        if ((r48 & 1) == 0) goto L5;
        boolean r10 = r28.a;
    L7:
        if ((r48 & 2) == 0) goto L9;
        ThreadStrategyForRendering r11 = r28.b;
    L11:
        if ((r48 & 4) == 0) goto L13;
        LynxGroup r12 = r28.c;
    L15:
        if ((r48 & 8) == 0) goto L17;
        String r13 = r28.d;
    L19:
        if ((r48 & 16) == 0) goto L21;
        int r14 = r28.e;
    L23:
        if ((r48 & 32) == 0) goto L25;
        int r15 = r28.f;
    L27:
        if ((r48 & 64) == 0) goto L29;
        float r16 = r28.g;
    L31:
        if ((r48 & 128) == 0) goto L33;
        boolean r17 = r28.h;
    L35:
        if ((r48 & 256) == 0) goto L37;
        boolean r18 = r28.i;
    L39:
        if ((r48 & 512) == 0) goto L41;
        Function1 r19 = r28.j;
    L43:
        if ((r48 & 1024) == 0) goto L45;
        boolean r110 = r28.k;
    L47:
        if ((r48 & 2048) == 0) goto L49;
        int r111 = r28.l;
    L51:
        if ((r48 & 4096) == 0) goto L53;
        int r112 = r28.m;
    L55:
        if ((r48 & 8192) == 0) goto L57;
        List r20 = r28.n;
    L59:
        if ((r48 & 16384) == 0) goto L61;
        List r21 = r28.o;
    L62:
        int r310 = r111;
        if ((r48 & 32768) == 0) goto L65;
        Map<String, k<?, ?>> r113 = r28.p;
    L66:
        boolean r311 = r110;
        if ((r48 & 65536) == 0) goto L69;
        w7a.a.b r22 = r28.q;
    L71:
        if ((131072 & r48) == 0) goto L73;
        boolean r23 = r28.r;
    L75:
        if ((262144 & r48) == 0) goto L77;
        boolean r24 = r28.s;
    L79:
        if ((524288 & r48) == 0) goto L81;
        boolean r25 = r28.t;
    L83:
        if ((1048576 & r48) == 0) goto L85;
        boolean r26 = r28.u;
    L87:
        if ((2097152 & r48) == 0) goto L89;
        String r27 = r28.v;
    L91:
        if ((4194304 & r48) == 0) goto L93;
        boolean r210 = r28.w;
    L95:
        if ((r48 & 8388608) == 0) goto L97;
        float r211 = r28.x;
    L98:
        r28.getClass();
        Intrinsics.checkNotNullParameter(r11, "threadStrategy");
        Intrinsics.checkNotNullParameter(r20, "behaviors");
        Intrinsics.checkNotNullParameter(r21, "modules");
        Intrinsics.checkNotNullParameter(r113, "resourceProviders");
        return new b(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r311, r310, r112, r20, r21, r113, r22, r23, r24, r25, r26, r27, r210, r211);
    L97:
        r211 = r47;
        goto L98
    L93:
        r210 = r46;
        goto L95
    L89:
        r27 = r45;
        goto L91
    L85:
        r26 = r44;
        goto L87
    L81:
        r25 = r43;
        goto L83
    L77:
        r24 = false;
        goto L79
    L73:
        r23 = r42;
        goto L75
    L69:
        r22 = null;
        goto L71
    L65:
        r113 = null;
        goto L66
    L61:
        r21 = r41;
        goto L62
    L57:
        r20 = r40;
        goto L59
    L53:
        r112 = 0;
        goto L55
    L49:
        r111 = 0;
        goto L51
    L45:
        r110 = r39;
        goto L47
    L41:
        r19 = r38;
        goto L43
    L37:
        r18 = r37;
        goto L39
    L33:
        r17 = r36;
        goto L35
    L29:
        r16 = r35;
        goto L31
    L25:
        r15 = r34;
        goto L27
    L21:
        r14 = r33;
        goto L23
    L17:
        r13 = r32;
        goto L19
    L13:
        r12 = r31;
        goto L15
    L9:
        r11 = r30;
        goto L11
    L5:
        r10 = r29;
        goto L7
    }

    public /* synthetic */ b(boolean r29, ThreadStrategyForRendering r30, LynxGroup r31, String r32, int r33, int r34, float r35, boolean r36, boolean r37, Function1 r38, boolean r39, int r40, int r41, List r42, boolean r43, boolean r44, boolean r45, boolean r46, String r47, boolean r48, float r49, int r50) {
        if ((r50 & 1) == 0) goto L5;
        boolean r10 = false;
    L7:
        if ((r50 & 2) == 0) goto L9;
        ThreadStrategyForRendering r11 = ThreadStrategyForRendering.ALL_ON_UI;
    L11:
        if ((r50 & 4) == 0) goto L13;
        LynxGroup r12 = null;
    L15:
        if ((r50 & 8) == 0) goto L17;
        String r13 = null;
    L19:
        if ((r50 & 16) == 0) goto L21;
        int r14 = 0;
    L23:
        if ((r50 & 32) == 0) goto L25;
        int r15 = 0;
    L27:
        if ((r50 & 64) == 0) goto L29;
        float r1 = 1.0f;
    L31:
        if ((r50 & 128) == 0) goto L33;
        boolean r16 = false;
    L35:
        if ((r50 & 256) == 0) goto L37;
        boolean r17 = false;
    L39:
        if ((r50 & 512) == 0) goto L41;
        Function1 r18 = null;
    L43:
        if ((r50 & 1024) == 0) goto L45;
        boolean r19 = true;
    L46:
        int r110 = -1;
        if ((r50 & 2048) == 0) goto L49;
        int r20 = -1;
    L51:
        if ((r50 & 4096) != 0) goto L55;
        r110 = r41;
    L55:
        if ((r50 & 8192) == 0) goto L57;
        List r111 = CollectionsKt.emptyList();
    L59:
        if ((r50 & 16384) == 0) goto L61;
        List r112 = CollectionsKt.emptyList();
    L63:
        if ((32768 & r50) == 0) goto L65;
        Map r21 = MapsKt.emptyMap();
    L67:
        if ((131072 & r50) == 0) goto L69;
        boolean r22 = false;
    L71:
        if ((262144 & r50) == 0) goto L73;
        boolean r23 = true;
    L75:
        if ((524288 & r50) == 0) goto L77;
        boolean r24 = false;
    L79:
        if ((1048576 & r50) == 0) goto L81;
        boolean r25 = false;
    L83:
        if ((2097152 & r50) == 0) goto L85;
        String r26 = null;
    L87:
        if ((4194304 & r50) == 0) goto L89;
        boolean r27 = false;
    L91:
        if ((r50 & 8388608) == 0) goto L93;
        float r0 = 1.0f;
    L94:
        this(r10, r11, r12, r13, r14, r15, r1, r16, r17, r18, r19, r20, r110, r111, r112, r21, null, r22, r23, r24, r25, r26, r27, r0);
        return;
    L93:
        r0 = r49;
        goto L94
    L89:
        r27 = r48;
        goto L91
    L85:
        r26 = r47;
        goto L87
    L81:
        r25 = r46;
        goto L83
    L77:
        r24 = r45;
        goto L79
    L73:
        r23 = r44;
        goto L75
    L69:
        r22 = r43;
        goto L71
    L65:
        r21 = null;
        goto L67
    L61:
        r112 = null;
        goto L63
    L57:
        r111 = r42;
        goto L59
    L49:
        r20 = r40;
        goto L51
    L45:
        r19 = r39;
        goto L46
    L41:
        r18 = r38;
        goto L43
    L37:
        r17 = r37;
        goto L39
    L33:
        r16 = r36;
        goto L35
    L29:
        r1 = r35;
        goto L31
    L25:
        r15 = r34;
        goto L27
    L21:
        r14 = r33;
        goto L23
    L17:
        r13 = r32;
        goto L19
    L13:
        r12 = r31;
        goto L15
    L9:
        r11 = r30;
        goto L11
    L5:
        r10 = r29;
        goto L7
    }

    public b(boolean r10, ThreadStrategyForRendering r11, LynxGroup r12, String r13, int r14, int r15, float r16, boolean r17, boolean r18, Function1<? super LynxViewBuilder, Unit> r19, boolean r110, int r111, int r112, List<? extends com.lynx.tasm.behavior.a> r20, List<? extends f> r21, Map<String, ? extends k<?, ?>> r22, w7a.a.b r23, boolean r24, boolean r25, boolean r26, boolean r27, String r28, boolean r29, float r30) {
        Intrinsics.checkNotNullParameter(r11, "threadStrategy");
        Intrinsics.checkNotNullParameter(r20, "behaviors");
        Intrinsics.checkNotNullParameter(r21, "modules");
        Intrinsics.checkNotNullParameter(r22, "resourceProviders");
        this.a = r10;
        this.b = r11;
        this.c = r12;
        this.d = r13;
        this.e = r14;
        this.f = r15;
        this.g = r16;
        this.h = r17;
        this.i = r18;
        this.j = r19;
        this.k = r110;
        this.l = r111;
        this.m = r112;
        this.n = r20;
        this.o = r21;
        this.p = r22;
        this.q = r23;
        this.r = r24;
        this.s = r25;
        this.t = r26;
        this.u = r27;
        this.v = r28;
        this.w = r29;
        this.x = r30;
    }
}
