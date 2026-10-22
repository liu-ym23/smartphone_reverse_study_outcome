package com.obric.aikernel.res.metadata.data;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.google.gson.f;
import com.google.gson.i;
import com.google.gson.k;
import com.obric.aikernel.res.PackageResourceManager;
import com.obric.aikernel.res.PrmContext;
import com.obric.aikernel.res.metadata.NativeLibVersionPolicy;
import com.obric.aikernel.res.metadata.config.DistConfig;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public class AIPackage extends b {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final a f5062u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final Lazy<Regex> f5063v = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final Lazy f5064m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final File f5065n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final File f5066o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Lazy f5067p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private List<? extends b> f5068q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private List<? extends c8.d> f5069r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f5070s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final AtomicLong f5071t;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final Regex a() {
            return (Regex) AIPackage.g0().getValue();
        }

        public final int b(String r10) {
            Intrinsics.checkNotNullParameter(r10, "<this>");
            Integer r11 = StringsKt.toIntOrNull(r10);
            if (r11 != null) goto L7;
            return Integer.MAX_VALUE;
        L7:
            return r11.intValue();
        }
    }

    static {
        f5062u = new a(null);
        f5063v = LazyKt.lazy(AIPackage$Companion$TEMPLATE_PATTER$2.INSTANCE);
    }

    public AIPackage(final String r10, final String r11, PackageResourceManager.PresmConfig r12) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r11, "version");
        Intrinsics.checkNotNullParameter(r12, "config");
        super(r10, r11, r12);
        this.f5064m = LazyKt.lazy(new AIPackage$debugVersion$2(r11, this));
        this.f5065n = new File(o(), "depends");
        this.f5066o = new File(z(), "allAvail");
        this.f5067p = LazyKt.lazy(new AIPackage$isTemplatePackage$2(r10));
        this.f5068q = CollectionsKt.emptyList();
        this.f5069r = CollectionsKt.emptyList();
        this.f5071t = new AtomicLong(0);
        n0();
    }

    public static final /* synthetic */ Lazy g0() {
        return f5063v;
    }

    private final void h0() {
        if (l0() == false) goto L5;
        U(CollectionsKt.listOf(this.f5066o));
        return;
    L5:
        R(CollectionsKt.listOf(this.f5066o));
    }

    private final boolean l0() {
        List<? extends b> r10 = this.f5068q;
        ArrayList r11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
        Iterator<T> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L14;
        b r13 = (b) r12.next();
        boolean r14 = r13.H();
        if (r14 == true) goto L12;
        if ((r13 instanceof e) == false) goto L12;
        e r15 = (e) r13;
        if (r15.h0() == false) goto L12;
        NativeLibVersionPolicy.INSTANCE.refreshNativeLibVersionPolicy$resource_manager_release(r15);
    L12:
        r11.add(Boolean.valueOf(r14));
        goto L4
    L14:
        if (com.obric.aikernel.res.metadata.data.a.b(Z(), this.f5070s, r11) == true) goto L29;
        Iterator r16 = CollectionsKt.zip(this.f5068q, r11).iterator();
    L17:
        if (r16.hasNext() == false) goto L21;
        Object r17 = r16.next();
        if ((!((Boolean) ((Pair) r17).getSecond()).booleanValue()) == false) goto L17;
    L22:
        Pair r18 = (Pair) r17;
        if (r18 == null) goto L38;
        b r19 = (b) r18.getFirst();
        if (r19 == null) goto L39;
        com.obric.aikernel.runtime.utils.c.a.a(com.obric.aikernel.runtime.utils.d.f5417a, "AIPackage", w() + '@' + D() + " subRes " + r19.w() + '@' + r19.D() + " is not avail, ready:" + r19.a0() + ", avail: " + r19.Z(), 0, 4, null);
        return false;
    L39:
        return false;
    L38:
        return false;
    L21:
        r17 = null;
        goto L22
    L29:
        return true;
    }

    private final void n0() {
        ArrayList r10 = new ArrayList();
        ArrayList r11 = new ArrayList();
        String[] r12 = this.f5065n.list();
        if (r12 == null) goto L67;
        int r13 = r12.length;
        int r14 = 0;
        boolean r15 = false;
    L6:
        if (r14 >= r13) goto L50;
        String r16 = r12[r14];
        Intrinsics.checkNotNullExpressionValue(r16, ActivityLifecycle.NAME);
        List r17 = StringsKt.split$default(r16, new char[]{'@'}, false, 0, 6, null);
        if (r17.size() == 3) goto L10;
    L48:
        com.obric.aikernel.runtime.utils.d.f5417a.l(PackageResourceManager.TAG, this + " path is illegal: " + this.f5065n + '/' + r16);
        r15 = true;
    L49:
        r14 = r14 + 1;
        goto L6
    L10:
        if (StringsKt.isBlank((CharSequence) r17.get(0)) == true) goto L48;
        if (StringsKt.isBlank((CharSequence) r17.get(1)) == true) goto L48;
        if (StringsKt.isBlank((CharSequence) r17.get(2)) == true) goto L48;
        String r18 = (String) r17.get(0);
        String r19 = (String) r17.get(1);
        String r110 = (String) r17.get(2);
        switch(r18.hashCode()) {
            case 107141: goto L38;
            case 104069929: goto L32;
            case 1164183140: goto L26;
            case 1729824090: goto L20;
            default: goto L42;
        };
    L42:
        Object r20 = null;
    L44:
        if ((r20 instanceof c8.d) == false) goto L46;
        r11.add(r20);
        goto L49
    L46:
        if (r20 == null) goto L49;
        r10.add(r20);
        goto L49
    L20:
        if (r18.equals("aikernel-lora") == false) goto L42;
        if (q().getUseAIKernelModel() == false) goto L42;
        Object r21 = new c8.a(r19, q());
    L41:
        r20 = r21;
        goto L44
    L26:
        if (r18.equals("aikernel-pkg") == false) goto L42;
        if (q().getUseAIKernelModel() == false) goto L42;
        r21 = new c8.b(r19, q());
        goto L41
    L32:
        if (r18.equals("model") == false) goto L42;
        if (q().getUseAIKernelModel() == false) goto L36;
        r21 = new c8.b(r19, q());
        goto L41
    L36:
        r21 = new AIModel(r19, r110, q());
        goto L41
    L38:
        if (r18.equals("lib") == false) goto L42;
        r21 = new e(r19, r110, q());
        goto L41
    L50:
        Unit r22 = Unit.INSTANCE;
        if (r15 == false) goto L53;
        com.obric.aikernel.runtime.utils.d.f5417a.l(PackageResourceManager.TAG, this + " has empty depend name! ignore loaded dep res.");
    L55:
        if ((!r11.isEmpty()) == true) goto L58;
        r11 = null;
    L58:
        if (r11 == null) goto L60;
        this.f5069r = r11;
    L60:
        this.f5070s = r15;
        return;
    L53:
        this.f5068q = r10;
        goto L55
    }

    @Override // com.obric.aikernel.res.metadata.data.b
    public String A() {
        return "package";
    }

    @Override // com.obric.aikernel.res.metadata.data.b
    public String B() {
        return "pkgs";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r11v6, types: [int] */
    /* JADX WARN: Type inference failed for: r11v9 */
    @Override // com.obric.aikernel.res.metadata.data.b
    protected final void G(PrmContext r24) {
        Intrinsics.checkNotNullParameter(r24, "ctx");
        super.G(r24);
        ArrayList r13 = new ArrayList();
        ArrayList r14 = new ArrayList();
        DistConfig r10 = s();
        Intrinsics.checkNotNull(r10);
        k r15 = r10.f();
        k r11 = r15.u("dependency");
        boolean r12 = false;
        boolean r16 = true;
        if (r11 == null) goto L29;
        k r17 = r11.u("bridge");
        if (r17 == null) goto L11;
        i r18 = r17.s("version");
        if (r18 == null) goto L11;
        String r19 = r18.h();
        if (r19 == null) goto L11;
        Intrinsics.checkNotNullExpressionValue(r19, "asString");
        r13.add(new e("bridge", r19, q()));
    L11:
        k r20 = r11.u("libs");
        if (r20 == null) goto L19;
        Map<String, i> r21 = r20.q();
        if (r21 == null) goto L19;
        Intrinsics.checkNotNullExpressionValue(r21, "asMap()");
        Iterator<Map.Entry<String, i>> r22 = r21.entrySet().iterator();
    L17:
        if (r22.hasNext() == false) goto L19;
        Map.Entry<String, i> r23 = r22.next();
        String r25 = r23.getKey();
        i r26 = r23.getValue();
        Intrinsics.checkNotNullExpressionValue(r25, ActivityLifecycle.NAME);
        String r27 = r26.e().s("version").h();
        Intrinsics.checkNotNullExpressionValue(r27, "configs.asJsonObject.get(\"version\").asString");
        r13.add(new e(r25, r27, q()));
    L19:
        f r28 = r11.t("model_center_name");
        if (r28 == null) goto L29;
        Intrinsics.checkNotNullExpressionValue(r28, "getAsJsonArray(\"model_center_name\")");
        Iterator<i> r29 = r28.iterator();
    L23:
        if (r29.hasNext() == false) goto L29;
        String r30 = r29.next().h();
        Intrinsics.checkNotNullExpressionValue(r30, "it.asString");
        List r31 = StringsKt.split$default(r30, new String[]{"@"}, false, 0, 6, null);
        String r32 = (String) r31.get(0);
        String r33 = (String) r31.get(1);
        if (q().getUseAIKernelModel() == true) goto L26;
        r13.add(new AIModel(r32, r33, q()));
        goto L23
    L26:
        r14.add(new c8.b(r32 + '_' + r33, q()));
    L29:
        if (r15.w(WsConstants.KEY_EXTRA) == false) goto L53;
        if (q().getUseAIKernelModel() == false) goto L53;
        f r34 = r15.u(WsConstants.KEY_EXTRA).t("dependent_model_packages");
        if (r34 == null) goto L42;
        Iterator<i> r35 = r34.iterator();
    L36:
        if (r35.hasNext() == false) goto L42;
        String r36 = r35.next().h();
        Intrinsics.checkNotNullExpressionValue(r36, "it.asString");
        c8.b r37 = new c8.b(r36, q());
        if (r37.H() == false) goto L41;
        r14.add(r37);
        goto L36
    L41:
        throw new IllegalStateException("check dependent aikernel model " + r37 + " not avail!");
    L42:
        f r38 = r15.u(WsConstants.KEY_EXTRA).t("dependent_lora_packages");
        if (r38 == null) goto L53;
        Iterator<i> r39 = r38.iterator();
    L46:
        if (r39.hasNext() == false) goto L53;
        String r40 = r39.next().h();
        Intrinsics.checkNotNullExpressionValue(r40, "it.asString");
        c8.a r41 = new c8.a(r40, q());
        if (r41.H() == false) goto L51;
        r14.add(r41);
        goto L46
    L51:
        throw new IllegalStateException("check dependent aikernel model " + r41 + " not avail!");
    L53:
        if (this.f5065n.exists() == true) goto L55;
        this.f5065n.mkdirs();
    L55:
        ArrayList r42 = new ArrayList();
        Iterator r110 = r13.iterator();
    L56:
        Boolean r111 = null;
        if (r110.hasNext() == false) goto L83;
        final b r43 = (b) r110.next();
        String r44 = r43.A();
        if (Intrinsics.areEqual(r44, "package") == true) goto L82;
        Result.Companion r45 = Result.Companion;     // Catch: Throwable -> L66
        b r210 = r43;
        ArrayList r211 = r42;
        boolean r212 = r16;
        boolean r112 = r12;
        Object r46 = Result.m32constructorimpl(Boolean.valueOf(PrmContext.install$default(r24, r44, r43.w(), r43.D(), null, false, false, new AIPackage$install$4$1$1$1(r43), 56, null)));     // Catch: Throwable -> L64
    L70:
        if (Result.m38isFailureimpl(r46) == false) goto L72;
        r46 = null;
    L72:
        Boolean r47 = (Boolean) r46;
        if (r47 != null) goto L75;
    L79:
        b r48 = r210;
    L80:
        ArrayList r49 = r211;
        r49.add(r48);
        r42 = r49;
        r12 = r112;
        r16 = r212;
        goto L56
    L75:
        if ((!r47.booleanValue()) == false) goto L77;
        r111 = r47;
    L77:
        if (r111 == null) goto L79;
        r111.booleanValue();
        com.obric.aikernel.runtime.utils.d r50 = com.obric.aikernel.runtime.utils.d.f5417a;
        StringBuilder r51 = new StringBuilder();
        r51.append("install ");
        r51.append(this);
        r51.append(" check dependence ");
        r48 = r210;
        r51.append(r48);
        r51.append(" is not valid!");
        r50.l("AIPackage", r51.toString());
    L64:
        th = th;
    L68:
        Result.Companion r52 = Result.Companion;
        r46 = Result.m32constructorimpl(ResultKt.createFailure(th));
    L66:
        th = th;
        r210 = r43;
        r211 = r42;
        r212 = r16;
        r112 = r12;
        goto L68
    L82:
        throw new IllegalStateException("Not allow pkg as dependence!");
    L83:
        ArrayList r53 = r42;
        boolean r213 = r16;
        boolean r113 = r12;
        r53.addAll(r13);
        r53.addAll(r14);
        Iterator r54 = r53.iterator();
    L85:
        if (r54.hasNext() == false) goto L95;
        b r55 = (b) r54.next();
        if (StringsKt.isBlank(r55.w()) == true) goto L93;
        if (StringsKt.isBlank(r55.D()) == true) goto L93;
        File r56 = new File(this.f5065n, r55.A() + '@' + r55.w() + '@' + r55.D());
        if (r56.exists() == true) goto L85;
        r56.createNewFile();
    L93:
        this.f5066o.delete();
        p().delete();
        k();
        FilesKt.deleteRecursively(this.f5065n);
        Q();
        throw new IllegalStateException(this + " config is broken, dep tag is empty. Src: " + r15);
    L95:
        this.f5068q = r13;
        this.f5069r = r14;
        this.f5070s = r113;
        LinkedHashSet r57 = new LinkedHashSet();
        List<? extends b> r58 = this.f5068q;
        ArrayList r59 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r58, 10));
        Iterator r60 = r58.iterator();
    L97:
        if (r60.hasNext() == false) goto L99;
        b r61 = (b) r60.next();
        r59.add(r61.A() + '@' + r61.w() + '@' + r61.D());
        goto L97
    L99:
        r57.addAll(r59);
        ArrayList r62 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10));
        Iterator r63 = r14.iterator();
    L101:
        if (r63.hasNext() == false) goto L103;
        c8.d r64 = (c8.d) r63.next();
        r62.add(r64.A() + '@' + r64.w() + '@' + r64.D());
        goto L101
    L103:
        r57.addAll(r62);
        String[] r65 = this.f5065n.list();
        if (r65 == null) goto L115;
        ArrayList r66 = new ArrayList();
        int r67 = r65.length;
        ?? r114 = r113;
    L106:
        if (r114 >= r67) goto L111;
        String r68 = r65[r114];
        if ((!r57.contains(r68)) == false) goto L110;
        r66.add(r68);
    L110:
        r114 = r114 + 1;
        goto L106
    L111:
        Iterator r69 = r66.iterator();
    L113:
        if (r69.hasNext() == false) goto L115;
        new File(this.f5065n, (String) r69.next()).delete();
    L115:
        Map<String, Set<String>> r70 = q().getPresetLibraries();
        if (r70 != null) goto L118;
        return;
    L118:
        if ((!r70.isEmpty()) == true) goto L121;
        r70 = null;
    L121:
        if (r70 == null) goto L173;
        Iterator r71 = this.f5068q.iterator();
    L124:
        if (r71.hasNext() == false) goto L174;
        b r72 = (b) r71.next();
        Set<String> r73 = r70.get(r72.w());
        if (r73 != null) goto L128;
    L130:
        boolean r115 = r113;
    L131:
        if (r115 == false) goto L124;
        f0();
        throw new IllegalStateException("uninstall " + this + " depends on preset lib " + r72 + " not in preset list. " + q().getPresetLibraries());
    L128:
        if (r73.contains(r72.D()) == true) goto L130;
        r115 = r213;
        goto L131
    L174:
        return;
    }

    @Override // com.obric.aikernel.res.metadata.data.b
    public boolean H() {
        return this.f5066o.exists();
    }

    @Override // com.obric.aikernel.res.metadata.data.b
    public void L(long r10) {
        long r11 = this.f5071t.getAndSet(0);
        if (r11 == 0) goto L8;
        super.L(r11);
        Iterator<T> r12 = this.f5068q.iterator();
    L6:
        if (r12.hasNext() == false) goto L10;
        ((b) r12.next()).L(r11);
        goto L6
    L10:
        return;
    }

    @Override // com.obric.aikernel.res.metadata.data.b
    protected void T() {
        super.T();
        h0();
        DistConfig r10 = s();
        if (r10 == null) goto L10;
        k r11 = r10.f();
        if (r11 == null) goto L11;
        String r12 = com.obric.aikernel.res.metadata.config.a.c(r11, "dep_version");
        if (r12 == null) goto L12;
        d0(r12);
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // com.obric.aikernel.res.metadata.data.b
    public boolean a0() {
        return com.obric.aikernel.res.metadata.data.a.a(super.a0(), this.f5065n.exists(), this.f5070s);
    }

    @Override // com.obric.aikernel.res.metadata.data.b
    public boolean f0() {
        boolean r10 = super.f0();
        h0();
        return r10;
    }

    @Override // com.obric.aikernel.res.metadata.data.b
    public boolean g(boolean r10) {
        Iterator<T> r11 = this.f5068q.iterator();
    L4:
        if (r11.hasNext() == false) goto L10;
        if (((b) r11.next()).g(r10) == false) goto L4;
        return true;
    L10:
        return super.g(r10);
    }

    public final String i0() {
        return (String) this.f5064m.getValue();
    }

    public final List<c8.d> j0() {
        return this.f5069r;
    }

    public final List<b> k0() {
        return this.f5068q;
    }

    @Override // com.obric.aikernel.res.metadata.data.b
    public boolean l() {
        if (m0() == true) goto L5;
    L8:
        boolean r10 = super.l();
        h0();
        return r10;
    L5:
        if (N() == true) goto L8;
        return false;
    }

    @Override // com.obric.aikernel.res.metadata.data.b
    public boolean m() {
        boolean r10 = super.m();
        h0();
        return r10;
    }

    public final boolean m0() {
        return ((Boolean) this.f5067p.getValue()).booleanValue();
    }

    public final boolean o0() {
        List<? extends b> r10 = this.f5068q;
        ArrayList r11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
        Iterator<T> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L7;
        r11.add(Boolean.valueOf(((b) r12.next()).H()));
        goto L4
    L7:
        if (com.obric.aikernel.res.metadata.data.a.b(com.obric.aikernel.res.metadata.data.a.a(super.a0(), this.f5065n.exists(), this.f5070s), this.f5070s, r11) == true) goto L22;
        Iterator r13 = CollectionsKt.zip(this.f5068q, r11).iterator();
    L10:
        if (r13.hasNext() == false) goto L14;
        Object r14 = r13.next();
        if ((!((Boolean) ((Pair) r14).getSecond()).booleanValue()) == false) goto L10;
    L15:
        Pair r15 = (Pair) r14;
        if (r15 == null) goto L27;
        b r16 = (b) r15.getFirst();
        if (r16 == null) goto L28;
        com.obric.aikernel.runtime.utils.d.f5417a.d("AIPackage", w() + '@' + D() + " subRes " + r16.w() + '@' + r16.D() + " is not avail, ready:" + r16.a0() + ", avail: " + r16.Z());
        return false;
    L28:
        return false;
    L27:
        return false;
    L14:
        r14 = null;
        goto L15
    L22:
        return true;
    }

    public final void p0(long r10) {
        this.f5071t.set(r10);
    }

    public final void q0(List<? extends b> r10) {
        Intrinsics.checkNotNullParameter(r10, "subs");
        this.f5068q = r10;
    }

    public final boolean r0(k r13) {
        Intrinsics.checkNotNullParameter(r13, "config");
        DistConfig r10 = s();
        String r11 = "";
        if (r10 == null) goto L8;
        k r12 = r10.f();
        if (r12 == null) goto L8;
        String r14 = com.obric.aikernel.res.metadata.config.a.d(r12, "dep_version");
        if (r14 == null) goto L8;
    L9:
        String r15 = com.obric.aikernel.res.metadata.config.a.d(r13, "dep_version");
        if (r15 != null) goto L13;
        r15 = "";
    L13:
        if (r10 == null) goto L18;
        k r16 = r10.f();
        if (r16 == null) goto L18;
        String r17 = com.obric.aikernel.res.metadata.config.a.d(r16, "preset_base_origin_version");
        if (r17 == null) goto L18;
    L19:
        String r18 = com.obric.aikernel.res.metadata.config.a.d(r13, "preset_base_origin_version");
        if (r18 != null) goto L23;
        r18 = "";
    L23:
        if (r10 == null) goto L28;
        k r19 = r10.f();
        if (r19 == null) goto L28;
        String r20 = com.obric.aikernel.res.metadata.config.a.d(r19, "preset_base_dist_from");
        if (r20 == null) goto L28;
    L29:
        String r110 = com.obric.aikernel.res.metadata.config.a.d(r13, "preset_base_dist_from");
        if (r110 == null) goto L33;
        r11 = r110;
    L33:
        a r111 = f5062u;
        if (r111.b(r15) <= r111.b(r14)) goto L39;
        com.obric.aikernel.runtime.utils.d r112 = com.obric.aikernel.runtime.utils.d.f5417a;
        StringBuilder r21 = new StringBuilder();
        r21.append("shouldUpdate ");
        r21.append(this);
        r21.append(" by depVersion:(");
        r21.append(r14);
        r21.append("->");
        r21.append(r15);
    L36:
        r21.append(')');
        String r113 = r21.toString();
    L37:
        r112.g("AIPackage", r113);
        return true;
    L39:
        if (Intrinsics.areEqual(r20, r11) == true) goto L42;
        r112 = com.obric.aikernel.runtime.utils.d.f5417a;
        r113 = "shouldUpdate " + this + " by distSrc:(" + r20 + "->" + r11 + ')';
        goto L37
    L42:
        if (Intrinsics.areEqual(r17, r18) == true) goto L44;
        r112 = com.obric.aikernel.runtime.utils.d.f5417a;
        r21 = new StringBuilder();
        r21.append("shouldUpdate ");
        r21.append(this);
        r21.append(" by originVersion:(");
        r21.append(r17);
        r21.append("->");
        r21.append(r18);
        goto L36
    L44:
        return false;
    L28:
        r20 = "";
    L18:
        r17 = "";
    L8:
        r14 = "";
        goto L9
    }
}
