package com.obric.aikernel.res.metadata.data;

import android.net.Uri;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.google.gson.k;
import com.obric.aikernel.res.PackageResourceManager;
import com.obric.aikernel.res.PrmContext;
import com.obric.aikernel.res.metadata.config.DistConfig;
import com.obric.aikernel.res.metadata.config.LoraConfig;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public class Lora extends b {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final Companion f5072s = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final Lazy f5073m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Lazy f5074n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Lazy f5075o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Lazy f5076p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private List<? extends AIModel> f5077q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final File f5078r;

    public static final class Companion {

        @SourceDebugExtension({"SMAP\nComparisons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Comparisons.kt\nkotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1\n*L\n1#1,328:1\n*E\n"})
        public static final class a<T> implements Comparator {
            public a() {
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T r10, T r11) {
                String r12 = (String) r11;
                AIPackage.a r13 = AIPackage.f5062u;
                Intrinsics.checkNotNullExpressionValue(r12, "it");
                Integer r14 = Integer.valueOf(r13.b(r12));
                String r15 = (String) r10;
                Intrinsics.checkNotNullExpressionValue(r15, "it");
                return ComparisonsKt.compareValues(r14, Integer.valueOf(r13.b(r15)));
            }
        }

        @SourceDebugExtension({"SMAP\nComparisons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Comparisons.kt\nkotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1\n*L\n1#1,328:1\n*E\n"})
        public static final class b<T> implements Comparator {
            public b() {
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T r10, T r11) {
                AIPackage.a r12 = AIPackage.f5062u;
                return ComparisonsKt.compareValues(Integer.valueOf(r12.b(((com.obric.aikernel.res.metadata.data.b) r11).D())), Integer.valueOf(r12.b(((com.obric.aikernel.res.metadata.data.b) r10).D())));
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }

        private final List<String> b(AIPackage r10) {
            List<com.obric.aikernel.res.metadata.data.b> r11 = r10.k0();
            ArrayList r12 = new ArrayList();
            Iterator<T> r13 = r11.iterator();
        L4:
            if (r13.hasNext() == false) goto L11;
            com.obric.aikernel.res.metadata.data.b r14 = (com.obric.aikernel.res.metadata.data.b) r13.next();
            if ((r14 instanceof AIModel) == false) goto L8;
            String r15 = r14.w() + '@' + r14.D();
        L9:
            if (r15 == null) goto L4;
            r12.add(r15);
            goto L4
        L8:
            r15 = null;
            goto L9
        L11:
            return r12;
        }

        private final boolean d(Lora r18, AIPackage r19, List<String> r20) {
            if (r19 != null) goto L5;
            com.obric.aikernel.runtime.utils.d r10 = com.obric.aikernel.runtime.utils.d.f5417a;
            StringBuilder r11 = new StringBuilder();
            r11.append("getLora: ");
            r11.append(r18);
            r11.append(" try match ");
            r11.append(r19);
            String r12 = " failed, type is illegal!";
        L28:
            r11.append(r12);
            String r13 = r11.toString();
        L29:
            r10.l(PackageResourceManager.TAG, r13);
        L30:
            return false;
        L5:
            if (r19.H() == true) goto L7;
            r10 = com.obric.aikernel.runtime.utils.d.f5417a;
            r11 = new StringBuilder();
            r11.append("getLora: ");
            r11.append(r18);
            r11.append(" try match ");
            r11.append(r19);
            r11.append(" failed, pkg is not avail, res ");
            Iterator<T> r14 = r19.k0().iterator();
        L21:
            if (r14.hasNext() == false) goto L25;
            Object r15 = r14.next();
            if (((com.obric.aikernel.res.metadata.data.b) r15).H() == false) goto L21;
        L26:
            r11.append(r15);
            r12 = " is not avail.";
            goto L28
        L25:
            r15 = null;
            goto L26
        L7:
            if (r20.contains(r18.g0()) == true) goto L9;
            r10 = com.obric.aikernel.runtime.utils.d.f5417a;
            r11 = new StringBuilder();
            r11.append("getLora: ");
            r11.append(r18);
            r11.append(" try match ");
            r11.append(r19);
            r11.append(" failed, ");
            r11.append(r18.g0());
            r11.append(" not in current valid list: ");
            r12 = CollectionsKt.joinToString$default(r20, null, null, null, 0, null, null, 63, null);
            goto L28
        L9:
            if (Intrinsics.areEqual(r19.w(), r18.j0()) == false) goto L17;
            AIPackage.a r16 = AIPackage.f5062u;
            if (r16.b(r19.D()) >= r18.i0()) goto L13;
            r10 = com.obric.aikernel.runtime.utils.d.f5417a;
            r13 = "getLora: " + r18 + " try match " + r19 + " failed, version:" + r16.b(r19.D()) + " < " + r18.i0();
            goto L29
        L13:
            if (b(r19).contains(r18.g0()) == false) goto L15;
            com.obric.aikernel.runtime.utils.d.f5417a.g(PackageResourceManager.TAG, "getLora: " + r18 + " match " + r19 + " success.");
            return true;
        L15:
            com.obric.aikernel.runtime.utils.d.f5417a.l(PackageResourceManager.TAG, "getLora: " + r18 + " try match " + r19 + " failed, baseModel: " + r18.g0() + " not in " + CollectionsKt.joinToString$default(b(r19), null, null, null, 0, null, null, 63, null));
            goto L30
        L17:
            r10 = com.obric.aikernel.runtime.utils.d.f5417a;
            r11 = new StringBuilder();
            r11.append("getLora: ");
            r11.append(r18);
            r11.append(" try match ");
            r11.append(r19);
            r11.append(" failed, name: ");
            r11.append(r19.w());
            r11.append(" : ");
            r12 = r18.j0();
            goto L28
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public final Pair<Lora, AIPackage> a(String r25, String r26, PrmContext r27) {
            Intrinsics.checkNotNullParameter(r25, "pkgName");
            Intrinsics.checkNotNullParameter(r26, "loraType");
            Intrinsics.checkNotNullParameter(r27, "context");
            String r10 = new Lora(r26, "", r27.getConfig()).o();
            String[] r11 = new File(r10).list();
            if (r11 == null) goto L11;
            Intrinsics.checkNotNullExpressionValue(r11, "it");
            if (r11.length != 0) goto L7;
            boolean r12 = true;
        L9:
            if ((!r12) != true) goto L11;
            boolean r13 = true;
        L13:
            if (r13 == true) goto L16;
            com.obric.aikernel.runtime.utils.d.f5417a.l(PackageResourceManager.TAG, "getLora: " + r25 + ',' + r26 + " get empty loras from " + r10);
        L16:
            if (r11 == null) goto L86;
            List r14 = ArraysKt.sortedWith(r11, new a());
            if (r14 == null) goto L86;
            Iterator r15 = r14.iterator();
        L21:
            if (r15.hasNext() == false) goto L86;
            String r16 = (String) r15.next();
            com.obric.aikernel.runtime.utils.d r17 = com.obric.aikernel.runtime.utils.d.f5417a;
            r17.c(PackageResourceManager.TAG, "getLora: " + r25 + ',' + r26 + " trying version " + r16);
            Intrinsics.checkNotNullExpressionValue(r16, "version");
            Lora r18 = new Lora(r26, r16, r27.getConfig());
            if (r18.s() == null) goto L24;
            if (r25.length() <= 0) goto L29;
            boolean r19 = true;
        L30:
            if (r19 == false) goto L35;
            if (Intrinsics.areEqual(r18.j0(), r25) == true) goto L35;
            String r20 = PackageResourceManager.TAG;
            StringBuilder r110 = new StringBuilder();
            r110.append("getLora: ");
            r110.append(r18);
            r110.append(" of pkg ");
            r110.append(r18.j0());
            r110.append(" not match ");
            r110.append(r25);
        L25:
            r17.g(r20, r110.toString());
        L35:
            if (r18.H() == true) goto L36;
            r17.g(PackageResourceManager.TAG, "getLora: " + r18 + " is not avail. " + CollectionsKt.joinToString$default(r18.k0(), null, null, null, 0, null, Lora$Companion$getLora$3$3.INSTANCE, 31, null));
            goto L21
        L36:
            AIPackage r21 = com.obric.aikernel.res.metadata.d.f5055a.a();
            if (r21 != null) goto L39;
            Unit r22 = null;
        L52:
            if (r22 != null) goto L21;
            Companion r23 = Lora.f5072s;
            r17.c(PackageResourceManager.TAG, "getLora: " + r18 + " match from VlmLocalVersionConstrict failed.");
            AIPackage r111 = r27.getMetadataCtrl$resource_manager_release().q(r18.j0());
            if (r111 == null) goto L57;
            List<String> r112 = r23.b(r111);
            if (r112 == null) goto L57;
        L58:
            boolean r113 = r23.d(r18, r111, r112);
            com.obric.aikernel.res.metadata.data.b r114 = r111;
            if (r113 == true) goto L79;
            r17.l(PackageResourceManager.TAG, "getLora: " + r18 + " match from current failed. " + r111);
            Map<String, com.obric.aikernel.res.metadata.data.b> r115 = r27.getMetadataCtrl$resource_manager_release().p().b("package", r18.j0());
            monitor-enter(r115);
            List r116 = CollectionsKt.sortedWith(CollectionsKt.toList(r115.values()), new b());     // Catch: Throwable -> L82
            if (r116.isEmpty() == false) goto L66;
            r17.l(PackageResourceManager.TAG, "getLora: " + r18 + " get empty pkgList of " + r18.j0());     // Catch: Throwable -> L82
        L66:
            monitor-exit(r115);
            Iterator r24 = r116.iterator();
        L69:
            if (r24.hasNext() == false) goto L77;
            Object r28 = r24.next();
            com.obric.aikernel.res.metadata.data.b r117 = (com.obric.aikernel.res.metadata.data.b) r28;
            if ((r117 instanceof AIPackage) == false) goto L73;
            AIPackage r118 = (AIPackage) r117;
        L75:
            if (r23.d(r18, r118, r112) == false) goto L69;
        L78:
            r114 = (com.obric.aikernel.res.metadata.data.b) r28;
            goto L79
        L73:
            r118 = null;
            goto L75
        L77:
            r28 = null;
        L82:
            th = move-exception;
            throw th;
        L79:
            if (r114 == null) goto L21;
            return new Pair(r18, (AIPackage) r114);
        L57:
            r17.l(PackageResourceManager.TAG, "getLora: get empty modelTags form " + r111);
            r112 = CollectionsKt.emptyList();
            goto L58
        L39:
            if (Intrinsics.areEqual(r21.w(), r18.j0()) == false) goto L49;
            AIPackage.a r119 = AIPackage.f5062u;
            if (r119.b(r21.D()) < r18.i0()) goto L47;
            Companion r120 = Lora.f5072s;
            if (r120.b(r21).contains(r18.g0()) == true) goto L44;
            String r121 = PackageResourceManager.TAG;
            StringBuilder r122 = new StringBuilder();
            r122.append("getLora: ");
            r122.append(r18);
            r122.append(" match VlmLocalVersionConstrict ");
            r122.append(r21);
            r122.append(" failed, baseModel: ");
            r122.append(r18.g0());
            r122.append(" not in ");
            r122.append(CollectionsKt.joinToString$default(r120.b(r21), null, null, null, 0, null, null, 63, null));
        L48:
            r17.l(r121, r122.toString());
        L50:
            r22 = Unit.INSTANCE;
            goto L52
        L44:
            r17.g(PackageResourceManager.TAG, "getLora: " + r18 + " match VlmLocalVersionConstrict " + r21 + " success.");
            return new Pair(r18, r21);
        L47:
            r121 = PackageResourceManager.TAG;
            r122 = new StringBuilder();
            r122.append("getLora: ");
            r122.append(r18);
            r122.append(" match VlmLocalVersionConstrict ");
            r122.append(r21);
            r122.append(" failed, version:");
            r122.append(r119.b(r21.D()));
            r122.append(" < ");
            r122.append(r18.i0());
            goto L48
        L49:
            r17.l(PackageResourceManager.TAG, "getLora: " + r18 + " match VlmLocalVersionConstrict " + r21 + " failed, name: " + r21.w() + " : " + r18.j0());
            goto L50
        L29:
            r19 = false;
            goto L30
        L24:
            r20 = PackageResourceManager.TAG;
            r110 = new StringBuilder();
            r110.append("getLora: ");
            r110.append(r18);
            r110.append(" config is null!");
        L86:
            return null;
        L7:
            r12 = false;
        L11:
            r13 = false;
            goto L13
        }

        public final boolean c(String r10, String r11, PackageResourceManager.PresmConfig r12, boolean r13) {
            Intrinsics.checkNotNullParameter(r10, "loraType");
            Intrinsics.checkNotNullParameter(r11, "version");
            Intrinsics.checkNotNullParameter(r12, "config");
            Lora r14 = new Lora(r10, r11, r12);
            if (r14.H() == true) goto L5;
        L8:
            return true;
        L5:
            if (r14.e0(r13) == true) goto L8;
            return false;
        }
    }

    static {
        f5072s = new Companion(null);
    }

    public Lora(final String r13, String r14, PackageResourceManager.PresmConfig r15) {
        Intrinsics.checkNotNullParameter(r13, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r14, "version");
        Intrinsics.checkNotNullParameter(r15, "config");
        super(r13, r14, r15);
        this.f5073m = LazyKt.lazy(new Lora$loraConfig$2(r13, this));
        this.f5074n = LazyKt.lazy(new Lora$baseModelTag$2(this));
        this.f5075o = LazyKt.lazy(new Lora$packageMinVersion$2(this));
        this.f5076p = LazyKt.lazy(new Lora$packageName$2(this));
        this.f5077q = CollectionsKt.emptyList();
        File r16 = new File(o(), "depends");
        this.f5078r = r16;
        ArrayList r17 = new ArrayList();
        String[] r18 = r16.list();
        if (r18 == null) goto L25;
        int r10 = r18.length;
        int r11 = 0;
        boolean r12 = false;
    L6:
        if (r11 >= r10) goto L17;
        String r19 = r18[r11];
        Intrinsics.checkNotNullExpressionValue(r19, "it");
        List r20 = StringsKt.split$default(r19, new char[]{'@'}, false, 0, 6, null);
        if (r20.size() == 2) goto L10;
    L15:
        com.obric.aikernel.runtime.utils.d.f5417a.l(PackageResourceManager.TAG, this + " path is illegal: " + this.f5078r + '/' + r13);
        r12 = true;
    L16:
        r11 = r11 + 1;
        goto L6
    L10:
        if (StringsKt.isBlank((CharSequence) r20.get(0)) == true) goto L15;
        if (StringsKt.isBlank((CharSequence) r20.get(1)) == true) goto L15;
        r17.add(new AIModel((String) r20.get(0), (String) r20.get(1), q()));
        goto L16
    L17:
        Unit r110 = Unit.INSTANCE;
        if (r12 == false) goto L20;
        com.obric.aikernel.runtime.utils.d.f5417a.l(PackageResourceManager.TAG, this + " has empty depend name! ignore loaded dep res.");
        return;
    L20:
        this.f5077q = r17;
        return;
    }

    @Override // com.obric.aikernel.res.metadata.data.b
    public String A() {
        return "lora";
    }

    @Override // com.obric.aikernel.res.metadata.data.b
    public String B() {
        return "loras";
    }

    @Override // com.obric.aikernel.res.metadata.data.b
    protected void G(PrmContext r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super.G(r10);
        String r11 = w();
        DistConfig r12 = s();
        Intrinsics.checkNotNull(r12);
        LoraConfig r13 = new LoraConfig(r11, r12.f());
        if (this.f5078r.exists() == true) goto L5;
        this.f5078r.mkdirs();
    L5:
        ArrayList r14 = new ArrayList();
        Iterator<T> r15 = r13.l().iterator();
    L7:
        if (r15.hasNext() == false) goto L18;
        DistConfig r16 = (DistConfig) r15.next();
        if (StringsKt.isBlank(r16.g()) == true) goto L16;
        if (StringsKt.isBlank(r16.i()) == true) goto L16;
        File r17 = new File(this.f5078r, r16.g() + '@' + r16.i());
        if (r17.exists() == true) goto L15;
        r17.createNewFile();
    L15:
        r14.add(new AIModel(r16.g(), r16.i(), q()));
    L16:
        p().delete();
        k();
        FilesKt.deleteRecursively(this.f5078r);
        Q();
        throw new IllegalStateException(this + " config is broken, dep tag is empty. Src: " + r13.f());
    L18:
        this.f5077q = r14;
        if (r14.isEmpty() == false) goto L21;
        com.obric.aikernel.runtime.utils.d.f5417a.l(PackageResourceManager.TAG, this + " installed but res isEmpty. Src: " + r13.f());
    L21:
        List<? extends AIModel> r18 = this.f5077q;
        ArrayList r19 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r18, 10));
        Iterator<T> r20 = r18.iterator();
    L23:
        if (r20.hasNext() == false) goto L25;
        AIModel r21 = (AIModel) r20.next();
        r19.add(r21.w() + '@' + r21.D());
        goto L23
    L25:
        String[] r22 = this.f5078r.list();
        if (r22 == null) goto L37;
        ArrayList r23 = new ArrayList();
        int r24 = 0;
        int r25 = r22.length;
    L28:
        if (r24 >= r25) goto L33;
        String r26 = r22[r24];
        if ((!r19.contains(r26)) == false) goto L32;
        r23.add(r26);
    L32:
        r24 = r24 + 1;
        goto L28
    L33:
        Iterator r27 = r23.iterator();
    L35:
        if (r27.hasNext() == false) goto L48;
        new File(this.f5078r, (String) r27.next()).delete();
        goto L35
    L48:
        return;
    }

    @Override // com.obric.aikernel.res.metadata.data.b
    public boolean H() {
        if (Z() == false) goto L13;
        if ((!this.f5077q.isEmpty()) == false) goto L13;
        Iterator<T> r10 = this.f5077q.iterator();
    L8:
        if (r10.hasNext() == false) goto L17;
        if (((AIModel) r10.next()).H() == true) goto L8;
        return false;
    L17:
        return true;
    L13:
        return false;
    }

    @Override // com.obric.aikernel.res.metadata.data.b
    public boolean a0() {
        if (s() != null) goto L5;
    L9:
        return false;
    L5:
        if (z().exists() == false) goto L9;
        if ((!this.f5077q.isEmpty()) == false) goto L9;
        return true;
    }

    @Override // com.obric.aikernel.res.metadata.data.b
    public boolean b(boolean r10) {
        if (s() == null) goto L7;
        return true;
    L7:
        throw new IllegalStateException(this + " missing config file!");
    }

    @Override // com.obric.aikernel.res.metadata.data.b
    public boolean g(boolean r10) {
        Iterator<T> r11 = this.f5077q.iterator();
    L4:
        if (r11.hasNext() == false) goto L10;
        if (((AIModel) r11.next()).g(r10) == false) goto L4;
        return true;
    L10:
        return super.g(r10);
    }

    public final String g0() {
        return (String) this.f5074n.getValue();
    }

    public final LoraConfig h0() {
        return (LoraConfig) this.f5073m.getValue();
    }

    public final int i0() {
        return ((Number) this.f5075o.getValue()).intValue();
    }

    public final String j0() {
        return (String) this.f5076p.getValue();
    }

    public final List<AIModel> k0() {
        return this.f5077q;
    }

    @Override // com.obric.aikernel.res.metadata.data.b
    public k r() {
        return new k();
    }

    @Override // com.obric.aikernel.res.metadata.data.b
    public Uri v() {
        return null;
    }
}
