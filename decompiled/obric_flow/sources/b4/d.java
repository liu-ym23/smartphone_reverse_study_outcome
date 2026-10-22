package b4;

import com.bytedance.ies.bullet.lynx.resource.forest.f;
import com.lynx.jsbridge.r;
import com.lynx.tasm.ThreadStrategyForRendering;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.k;
import com.lynx.tasm.l0;
import com.lynx.tasm.u;
import fo.h;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kn.e;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f866a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ThreadStrategyForRendering f867b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final u f868c;
    public final String d;
    public final int e;
    public final int f;
    public final float g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f869h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f870i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f871j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f872k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f873l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final List f874m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final List f875n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Map f876o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f877p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final boolean f878q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final boolean f879r;
    public final boolean s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final String f880t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final boolean f881u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final float f882v;

    public d(boolean r10, ThreadStrategyForRendering r11, u r12, String r13, int r14, int r15, float r16, boolean r17, boolean r18, boolean r19, int r110, int r111, List r112, List r20, Map r21, boolean r22, boolean r23, boolean r24, boolean r25, String r26, boolean r27, float r28) {
        Intrinsics.checkNotNullParameter(r11, "threadStrategy");
        Intrinsics.checkNotNullParameter(r112, "behaviors");
        Intrinsics.checkNotNullParameter(r20, "modules");
        Intrinsics.checkNotNullParameter(r21, "resourceProviders");
        this.f866a = r10;
        this.f867b = r11;
        this.f868c = r12;
        this.d = r13;
        this.e = r14;
        this.f = r15;
        this.g = r16;
        this.f869h = r17;
        this.f870i = r18;
        this.f871j = r19;
        this.f872k = r110;
        this.f873l = r111;
        this.f874m = r112;
        this.f875n = r20;
        this.f876o = r21;
        this.f877p = r22;
        this.f878q = r23;
        this.f879r = r24;
        this.s = r25;
        this.f880t = r26;
        this.f881u = r27;
        this.f882v = r28;
    }

    public static d a(d r25, List r26, String r27, int r28) {
        boolean r5 = r25.f866a;
        if ((r28 & 8192) == 0) goto L5;
        List r14 = r25.f874m;
    L7:
        if ((r28 & 2097152) == 0) goto L9;
        String r21 = r25.f880t;
    L10:
        ThreadStrategyForRendering r10 = r25.f867b;
        Intrinsics.checkNotNullParameter(r10, "threadStrategy");
        Intrinsics.checkNotNullParameter(r14, "behaviors");
        List r11 = r25.f875n;
        Intrinsics.checkNotNullParameter(r11, "modules");
        Map r12 = r25.f876o;
        Intrinsics.checkNotNullParameter(r12, "resourceProviders");
        boolean r13 = r25.f881u;
        float r15 = r25.f882v;
        return new d(r5, r10, r25.f868c, r25.d, r25.e, r25.f, r25.g, r25.f869h, r25.f870i, r25.f871j, r25.f872k, r25.f873l, r14, r11, r12, r25.f877p, r25.f878q, r25.f879r, r25.s, r21, r13, r15);
    L9:
        r21 = r27;
        goto L10
    L5:
        r14 = r26;
        goto L7
    }

    public final l0 b(String r12) {
        Intrinsics.checkNotNullParameter(r12, "sessionId");
        TraceEvent.c("LynxViewBuilderParams:toLynxViewBuilder");
        TraceEvent.c("LynxViewBuilder:<init>");     // Catch: Throwable -> L8
        l0 r5 = new l0();     // Catch: Throwable -> L32
        k r10 = r5.f10900c;     // Catch: Throwable -> L32
        TraceEvent.a(0, "LynxViewBuilder:<init>");     // Catch: Throwable -> L8
        r5.f10901h = this.f881u;     // Catch: Throwable -> L8
        r5.e = this.f866a;     // Catch: Throwable -> L8
        ThreadStrategyForRendering r11 = this.f867b;     // Catch: Throwable -> L8
        if (r11 == null) goto L10;
        r5.f10910q = r11;     // Catch: Throwable -> L8
    L10:
        r10.f10894c = this.f868c;     // Catch: Throwable -> L8
        int r13 = this.f;     // Catch: Throwable -> L8
        r5.f10907n = this.e;     // Catch: Throwable -> L8
        r5.f10906m = r13;     // Catch: Throwable -> L8
        r5.f10908o = this.g;     // Catch: Throwable -> L8
        r5.g = this.f870i;     // Catch: Throwable -> L8
        r5.d = this.f871j;     // Catch: Throwable -> L8
        int r14 = this.f872k;     // Catch: Throwable -> L8
        int r15 = this.f873l;     // Catch: Throwable -> L8
        r5.f10911r = r14;     // Catch: Throwable -> L8
        r5.s = r15;     // Catch: Throwable -> L8
        r5.f10917y = r5.f10917y;     // Catch: Throwable -> L8
        TraceEvent.c("LynxViewBuilder:addBehaviors");     // Catch: Throwable -> L8
        r5.c(this.f874m);     // Catch: Throwable -> L29
        TraceEvent.a(0, "LynxViewBuilder:addBehaviors");     // Catch: Throwable -> L8
        TraceEvent.c("LynxViewBuilder:registerModule");     // Catch: Throwable -> L8
        Iterator r16 = this.f875n.iterator();     // Catch: Throwable -> L17
    L15:
        if (r16.hasNext() == false) goto L19;
        r r17 = (r) r16.next();     // Catch: Throwable -> L17
        String r18 = r17.f9939a;     // Catch: Throwable -> L17
        r5.a(r17.f9940b, r17.f9941c, r18);     // Catch: Throwable -> L17
        goto L15
    L19:
        Unit r19 = Unit.INSTANCE;     // Catch: Throwable -> L17
        TraceEvent.a(0, "LynxViewBuilder:registerModule");     // Catch: Throwable -> L8
        Iterator r20 = MapsKt.asSequence(this.f876o).iterator();     // Catch: Throwable -> L8
    L22:
        if (r20.hasNext() == false) goto L24;
        Map.Entry r21 = (Map.Entry) r20.next();     // Catch: Throwable -> L8
        r5.b((String) r21.getKey(), (h) r21.getValue());     // Catch: Throwable -> L8
        goto L22
    L24:
        r5.f10902i = this.f877p;     // Catch: Throwable -> L8
        r5.f10903j = true;     // Catch: Throwable -> L8
        r5.f10904k = this.f878q;     // Catch: Throwable -> L8
        r5.f10905l = this.f879r;     // Catch: Throwable -> L8
        r10.f10892a = this.s;     // Catch: Throwable -> L8
        r10.f10893b = this.f880t;     // Catch: Throwable -> L8
        r5.f10915w = new com.bytedance.ies.bullet.lynx.resource.forest.b("ttnet", r12);     // Catch: Throwable -> L8
        r10.f = new com.bytedance.ies.bullet.lynx.resource.forest.d("ttnet", r12);     // Catch: Throwable -> L8
        r10.g = new f(r12);     // Catch: Throwable -> L8
        r10.f10895h = new com.bytedance.ies.bullet.lynx.resource.forest.h("ttnet", r12, null);     // Catch: Throwable -> L8
        r5.b("EXTERNAL_JS_SOURCE", new com.bytedance.ies.bullet.lynx.resource.forest.c("ttnet", r12));     // Catch: Throwable -> L8
        TraceEvent.a(0, "LynxViewBuilderParams:toLynxViewBuilder");
        return r5;
    L17:
        th = move-exception;
        TraceEvent.a(0, "LynxViewBuilder:registerModule");     // Catch: Throwable -> L8
        throw th;     // Catch: Throwable -> L8
    L29:
        th = move-exception;
        TraceEvent.a(0, "LynxViewBuilder:addBehaviors");     // Catch: Throwable -> L8
        throw th;     // Catch: Throwable -> L8
    L32:
        th = move-exception;
        TraceEvent.a(0, "LynxViewBuilder:<init>");     // Catch: Throwable -> L8
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        TraceEvent.a(0, "LynxViewBuilderParams:toLynxViewBuilder");
        throw th;
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof d) == true) goto L8;
        return false;
    L8:
        d r11 = (d) r10;
        boolean r5 = r11.f866a;
        if (this.f866a == r5) goto L12;
        return false;
    L12:
        if (this.f867b == r11.f867b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f868c, r11.f868c) == true) goto L18;
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
        if (this.f869h == r11.f869h) goto L33;
        return false;
    L33:
        if (this.f870i == r11.f870i) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(null, null) == true) goto L39;
        return false;
    L39:
        if (this.f871j == r11.f871j) goto L42;
        return false;
    L42:
        if (this.f872k == r11.f872k) goto L45;
        return false;
    L45:
        if (this.f873l == r11.f873l) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f874m, r11.f874m) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.f875n, r11.f875n) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.f876o, r11.f876o) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(null, null) == true) goto L60;
        return false;
    L60:
        if (this.f877p == r11.f877p) goto L63;
        return false;
    L63:
        if (this.f878q == r11.f878q) goto L66;
        return false;
    L66:
        if (this.f879r == r11.f879r) goto L69;
        return false;
    L69:
        if (this.s == r11.s) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.f880t, r11.f880t) == true) goto L75;
        return false;
    L75:
        if (this.f881u == r11.f881u) goto L78;
        return false;
    L78:
        if (Float.compare(this.f882v, r11.f882v) == 0) goto L80;
        return false;
    L80:
        return true;
    }

    public final int hashCode() {
        int r5 = (this.f867b.hashCode() + (Boolean.hashCode(this.f866a) * 31)) * 31;
        int r10 = 0;
        u r11 = this.f868c;
        if (r11 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = (r5 + r12) * 31;
        String r14 = this.d;
        if (r14 != null) goto L9;
        int r15 = 0;
    L10:
        int r16 = e.a(e.a(e.a(e.a((this.f876o.hashCode() + androidx.constraintlayout.motion.widget.a.f(this.f875n, androidx.constraintlayout.motion.widget.a.f(this.f874m, k5.d.a(this.f873l, k5.d.a(this.f872k, e.a(e.a(e.a(androidx.constraintlayout.motion.widget.a.b(this.g, k5.d.a(this.f, k5.d.a(this.e, (r13 + r15) * 31)), 31), 31, this.f869h), 961, this.f870i), 31, this.f871j))), 31), 31)) * 961, 31, this.f877p), 31, this.f878q), 31, this.f879r), 31, this.s);
        String r17 = this.f880t;
        if (r17 == null) goto L15;
        r10 = r17.hashCode();
    L15:
        return Float.hashCode(this.f882v) + e.a((r16 + r10) * 31, 31, this.f881u);
    L9:
        r15 = r14.hashCode();
        goto L10
    L5:
        r12 = r11.hashCode();
        goto L6
    }

    public final String toString() {
        return "LynxViewBuilderParams(enableLayoutSafepoint=" + this.f866a + ", threadStrategy=" + this.f867b + ", lynxGroup=" + this.f868c + ", lynxGroupName=" + this.d + ", presetHeightMeasureSpec=" + this.e + ", presetWidthMeasureSpec=" + this.f + ", fontScale=" + this.g + ", enableCreateViewAsync=" + this.f869h + ", enableSyncFlush=" + this.f870i + ", customInit=null, enableAutoExpose=" + this.f871j + ", screenWidth=" + this.f872k + ", screenHeight=" + this.f873l + ", behaviors=" + this.f874m + ", modules=" + this.f875n + ", resourceProviders=" + this.f876o + ", fontLoader=null, enablePendingJsTask=" + this.f877p + ", enableJSRuntime=" + this.f878q + ", enableAirStrictMode=" + this.f879r + ", enableUserCodeCache=" + this.s + ", codeCacheSourceUrl=" + this.f880t + ", enableVSyncAlignedMessageLoop=" + this.f881u + ", viewZoom=" + this.f882v + ')';
    }

    public /* synthetic */ d(boolean r27, ThreadStrategyForRendering r28, u r29, String r30, int r31, int r32, float r33, boolean r34, boolean r35, boolean r36, boolean r37, boolean r38, boolean r39, boolean r40, float r41, int r42) {
        if ((r42 & 1) == 0) goto L5;
        boolean r5 = false;
    L7:
        if ((r42 & 2) == 0) goto L9;
        ThreadStrategyForRendering r10 = ThreadStrategyForRendering.f10065b;
    L11:
        if ((r42 & 4) == 0) goto L13;
        u r11 = null;
    L15:
        if ((r42 & 8) == 0) goto L17;
        String r12 = null;
    L19:
        if ((r42 & 16) == 0) goto L21;
        int r13 = 0;
    L23:
        if ((r42 & 32) == 0) goto L25;
        int r14 = 0;
    L27:
        if ((r42 & 64) == 0) goto L29;
        float r15 = 1.0f;
    L31:
        if ((r42 & 128) == 0) goto L33;
        boolean r16 = false;
    L35:
        if ((r42 & 256) == 0) goto L37;
        boolean r17 = false;
    L39:
        if ((r42 & 1024) == 0) goto L41;
        boolean r18 = true;
    L42:
        List r19 = CollectionsKt.emptyList();
        List r110 = CollectionsKt.emptyList();
        Map r111 = MapsKt.emptyMap();
        if ((131072 & r42) == 0) goto L45;
        boolean r112 = false;
    L47:
        if ((524288 & r42) == 0) goto L49;
        boolean r21 = false;
    L51:
        if ((1048576 & r42) == 0) goto L53;
        boolean r22 = false;
    L55:
        if ((4194304 & r42) == 0) goto L57;
        boolean r24 = false;
    L59:
        if ((r42 & 8388608) == 0) goto L61;
        float r25 = 1.0f;
    L62:
        this(r5, r10, r11, r12, r13, r14, r15, r16, r17, r18, -1, -1, r19, r110, r111, r112, true, r21, r22, null, r24, r25);
        return;
    L61:
        r25 = r41;
        goto L62
    L57:
        r24 = r40;
        goto L59
    L53:
        r22 = r39;
        goto L55
    L49:
        r21 = r38;
        goto L51
    L45:
        r112 = r37;
        goto L47
    L41:
        r18 = r36;
        goto L42
    L37:
        r17 = r35;
        goto L39
    L33:
        r16 = r34;
        goto L35
    L29:
        r15 = r33;
        goto L31
    L25:
        r14 = r32;
        goto L27
    L21:
        r13 = r31;
        goto L23
    L17:
        r12 = r30;
        goto L19
    L13:
        r11 = r29;
        goto L15
    L9:
        r10 = r28;
        goto L11
    L5:
        r5 = r27;
        goto L7
    }
}
