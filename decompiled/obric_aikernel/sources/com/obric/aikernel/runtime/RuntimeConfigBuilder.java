package com.obric.aikernel.runtime;

import android.content.Context;
import android.os.Build;
import com.obric.aikernel.res.PackageResourceManager;
import com.obric.aikernel.runtime.utils.DeviceUtils;
import com.obric.aikernel.runtime.utils.ModelCenterConfigs;
import com.obric.aikernel.runtime.utils.i;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.flow.g1;
import kotlinx.coroutines.flow.q1;
import okhttp3.y;

/* JADX INFO: loaded from: classes2.dex */
public final class RuntimeConfigBuilder {
    public static final a R = null;
    private static final long S = 0;
    private static final String T = null;
    private g1<String> A;
    private Function0<Long> B;
    private Function0<Integer> C;
    private Function2<? super y, ? super Continuation<? super String>, ? extends Object> D;
    private Function0<Boolean> E;
    private Function0<Boolean> F;
    private String G;
    private Function0<Boolean> H;
    private List<Pair<String, String>> I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private boolean f5316J;
    private String K;
    private boolean L;
    private Function0<Unit> M;
    private Function0<Unit> N;
    private Map<String, AIInferRuntime.d.C0119d> O;
    private AIInferRuntime.d.b P;
    private Map<String, String> Q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f5317a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f5318b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f5319c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f5320d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f5321e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Function1<Continuation<? super String>, Object> f5322f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f5323g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f5324h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f5325i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f5326j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f5327k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private List<? extends Pair<String, ? extends Object>> f5328l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private AIInferRuntime.c f5329m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private Function0<Long> f5330n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private Function0<Long> f5331o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private String f5332p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private String f5333q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private AIInferRuntime.d.a f5334r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private String f5335s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private Function0<Integer> f5336t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private String f5337u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private String f5338v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private com.obric.aikernel.runtime.utils.c f5339w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private PackageResourceManager.PresmConfig.d f5340x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private String f5341y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private g1<Pair<Boolean, String>> f5342z;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final long a() {
            return RuntimeConfigBuilder.a();
        }
    }

    public static final class b implements PackageResourceManager.PresmConfig.d {
        b() {
        }

        @Override // com.obric.aikernel.res.PackageResourceManager.PresmConfig.d
        public boolean a(int r10, String r11, String r12) {
            return PackageResourceManager.PresmConfig.d.a.a(this, r10, r11, r12);
        }
    }

    static {
        R = new a(null);
        Duration.Companion r10 = Duration.Companion;
        S = Duration.m1430toLongimpl(DurationKt.toDuration(1, DurationUnit.HOURS), DurationUnit.MILLISECONDS);
        i r11 = i.f5431a;
        T = r11.a();
        r11.b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RuntimeConfigBuilder(Context r10, String r11, String r12, String r13, String r14, Function1<? super Continuation<? super String>, ? extends Object> r15, String r16, boolean r17) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "aid");
        Intrinsics.checkNotNullParameter(r12, "projectId");
        Intrinsics.checkNotNullParameter(r13, "appVersion");
        Intrinsics.checkNotNullParameter(r14, "channel");
        Intrinsics.checkNotNullParameter(r15, "did");
        Intrinsics.checkNotNullParameter(r16, "compatAppVersion");
        this.f5317a = r10;
        this.f5318b = r11;
        this.f5319c = r12;
        this.f5320d = r13;
        this.f5321e = r14;
        this.f5322f = r15;
        this.f5323g = r16;
        this.f5324h = r17;
        this.f5325i = DeviceUtils.f5383a.g();
        this.f5326j = 50;
        this.f5330n = RuntimeConfigBuilder$inferNotResponseTimeMills$1.INSTANCE;
        this.f5331o = RuntimeConfigBuilder$updateInterval$1.INSTANCE;
        String r18 = r10.getFilesDir().getPath();
        Intrinsics.checkNotNullExpressionValue(r18, "context.filesDir.path");
        this.f5332p = r18;
        this.f5336t = RuntimeConfigBuilder$hostUserId$1.INSTANCE;
        this.f5337u = T;
        this.f5340x = new b();
        this.f5341y = ModelCenterConfigs.f5396a.b();
        this.f5342z = q1.a(new Pair(Boolean.FALSE, "default disable background update."));
        this.B = RuntimeConfigBuilder$autoCleanResourceInterval$1.INSTANCE;
        this.C = RuntimeConfigBuilder$autoCleanResourceTotalGB$1.INSTANCE;
        this.E = RuntimeConfigBuilder$autoDeleteDebugPackage$1.INSTANCE;
        this.F = RuntimeConfigBuilder$checkPackageResource$1.INSTANCE;
        this.H = RuntimeConfigBuilder$allowNetworkRequest$1.INSTANCE;
        this.K = Build.SOC_MODEL;
        this.M = RuntimeConfigBuilder$startDownloadForegroundService$1.INSTANCE;
        this.N = RuntimeConfigBuilder$stopDownloadForegroundService$1.INSTANCE;
    }

    public /* synthetic */ RuntimeConfigBuilder(Context r12, String r13, String r14, String r15, String r16, Function1 r17, String r18, boolean r19, int r20, DefaultConstructorMarker r21) {
        if ((r20 & 64) == 0) goto L5;
        String r10 = "";
    L7:
        if ((r20 & 128) == 0) goto L9;
        boolean r11 = false;
    L10:
        this(r12, r13, r14, r15, r16, r17, r10, r11);
        return;
    L9:
        r11 = r19;
        goto L10
    L5:
        r10 = r18;
        goto L7
    }

    public static final /* synthetic */ long a() {
        return S;
    }

    public final void A(AIInferRuntime.c r10) {
        this.f5329m = r10;
    }

    public final void B(Function0<Unit> r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.M = r10;
    }

    public final void C(Function0<Unit> r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.N = r10;
    }

    public final void D(AIInferRuntime.d.b r10) {
        this.P = r10;
    }

    public final void E(Function0<Long> r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.f5331o = r10;
    }

    public final void F(boolean r10) {
        this.f5316J = r10;
    }

    public final void G(Map<String, String> r10) {
        this.Q = r10;
    }

    public final AIInferRuntime.d b() {
        if (this.f5324h == false) goto L5;
        String r10 = '/' + this.f5319c;
    L6:
        String r11 = new File(this.f5332p, "prs" + r10).getPath();
        String r12 = this.f5333q;
        if (r12 == null) goto L12;
        String r13 = new File(r12, "prs" + r10).getPath();
        if (r13 == null) goto L12;
        String r14 = r13;
    L13:
        com.obric.aikernel.runtime.utils.c r15 = this.f5339w;
        if (r15 == null) goto L16;
        AIInferRuntime.d.c r16 = new AIInferRuntime.d.c(r15);
    L17:
        Context r17 = this.f5317a;
        int r18 = this.f5326j;
        boolean r19 = this.f5327k;
        List<? extends Pair<String, ? extends Object>> r110 = this.f5328l;
        AIInferRuntime.c r111 = this.f5329m;
        Function0<Long> r112 = this.f5330n;
        Function0<Long> r113 = this.f5331o;
        Intrinsics.checkNotNullExpressionValue(r11, "finalRootDir");
        Intrinsics.checkNotNullExpressionValue(r14, "finalResDir");
        PackageResourceManager.PresmConfig.AppConfig r114 = new PackageResourceManager.PresmConfig.AppConfig(this.f5318b, this.f5320d, this.f5321e, this.f5322f, this.f5336t.toString(), this.f5341y, this.f5319c, this.f5323g, this.f5327k, this.f5342z, this.A, this.B, this.C, this.D, this.E, this.F, this.H, this.K, this.L, this.M, this.N, this.f5325i);
        String r115 = this.f5335s;
        String r20 = this.f5338v;
        PackageResourceManager.PresmConfig.d r21 = this.f5340x;
        String r22 = this.G;
        List<Pair<String, String>> r23 = this.I;
        if (r23 == null) goto L27;
        LinkedHashMap r24 = new LinkedHashMap();
        Iterator r25 = r23.iterator();
    L21:
        if (r25.hasNext() == false) goto L26;
        Pair r116 = (Pair) r25.next();
        Iterator r117 = r25;
        Object r26 = r116.getFirst();
        Object r27 = r24.get(r26);
        String r28 = r115;
        if (r27 != null) goto L25;
        LinkedHashSet r118 = new LinkedHashSet();
        r24.put(r26, r118);
        r27 = r118;
    L25:
        ((Set) r27).add(r116.getSecond());
        r25 = r117;
        r115 = r28;
        goto L21
    L26:
        String r29 = r115;
        LinkedHashMap r119 = r24;
    L28:
        LinkedHashMap r120 = r119;
        return new AIInferRuntime.d(r17, r18, r19, r110, r111, r112, r113, new PackageResourceManager.PresmConfig(r17, r11, r14, r114, "3.13.3", r29, r20, r16, r21, r22, r120, this.f5316J, 0, 4096, null), r16, this.P, this.f5334r, this.O, this.Q);
    L27:
        r29 = r115;
        r119 = null;
        goto L28
    L16:
        r16 = null;
    L12:
        r14 = r11;
        goto L13
    L5:
        r10 = "";
        goto L6
    }

    public final Context c() {
        return this.f5317a;
    }

    public final String d() {
        return this.f5337u;
    }

    public final Function0<Integer> e() {
        return this.f5336t;
    }

    public final String f() {
        return this.f5332p;
    }

    public final void g(g1<Pair<Boolean, String>> r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.f5342z = r10;
    }

    public final void h(String r10) {
        this.f5335s = r10;
    }

    public final void i(Function0<Long> r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.B = r10;
    }

    public final void j(Function0<Integer> r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.C = r10;
    }

    public final void k(Function0<Boolean> r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.E = r10;
    }

    public final void l(g1<String> r10) {
        this.A = r10;
    }

    public final void m(Function0<Boolean> r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.F = r10;
    }

    public final void n(String r10) {
        this.f5338v = r10;
    }

    public final void o(boolean r10) {
        this.f5327k = r10;
    }

    public final void p(boolean r10) {
        this.L = r10;
    }

    public final void q(Function0<Integer> r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.f5336t = r10;
    }

    public final void r(Function0<Long> r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.f5330n = r10;
    }

    public final void s(com.obric.aikernel.runtime.utils.c r10) {
        this.f5339w = r10;
    }

    public final void t(Map<String, AIInferRuntime.d.C0119d> r10) {
        this.O = r10;
    }

    public final void u(Function2<? super y, ? super Continuation<? super String>, ? extends Object> r10) {
        this.D = r10;
    }

    public final void v(PackageResourceManager.PresmConfig.d r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.f5340x = r10;
    }

    public final void w(String r10) {
        this.G = r10;
    }

    public final void x(AIInferRuntime.d.a r10) {
        this.f5334r = r10;
    }

    public final void y(List<? extends Pair<String, ? extends Object>> r10) {
        this.f5328l = r10;
    }

    public final void z(String r10) {
        this.f5333q = r10;
    }
}
