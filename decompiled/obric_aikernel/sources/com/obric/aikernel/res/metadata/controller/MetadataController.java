package com.obric.aikernel.res.metadata.controller;

import androidx.annotation.GuardedBy;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.google.gson.k;
import com.obric.aikernel.res.PrmContext;
import com.obric.aikernel.res.installer.internal.ApkDataScanner;
import com.obric.aikernel.res.metadata.NativeLibVersionPolicy;
import com.obric.aikernel.res.metadata.PackagesListener;
import com.obric.aikernel.res.metadata.config.DistConfig;
import com.obric.aikernel.res.metadata.data.AIModel;
import com.obric.aikernel.res.metadata.data.AIPackage;
import com.obric.aikernel.res.metadata.data.Lora;
import com.obric.aikernel.res.task.StorageCleanerDaemon;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.ExceptionsKt;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.h;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.q2;
import kotlinx.coroutines.r0;
import kotlinx.coroutines.z0;

/* JADX INFO: loaded from: classes2.dex */
public final class MetadataController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PrmContext f5043a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final PackagesListener f5044b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final l0 f5045c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @GuardedBy("versionMap")
    private final Map<String, AIPackage> f5046d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final b f5047e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final StorageCleanerDaemon f5048f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private r0<Unit> f5049g;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Map<String, c> f5050a;

        public b(Map<String, c> r10) {
            Intrinsics.checkNotNullParameter(r10, "typeMap");
            this.f5050a = r10;
        }

        public /* synthetic */ b(Map r10, int r11, DefaultConstructorMarker r12) {
            if ((r11 & 1) == 0) goto L5;
            r10 = new ConcurrentHashMap();
        L5:
            this(r10);
        }

        public final Map<String, c> a() {
            return this.f5050a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final Map<String, com.obric.aikernel.res.metadata.data.b> b(String r10, String r11) {
            Intrinsics.checkNotNullParameter(r10, WsConstants.KEY_CONNECTION_TYPE);
            Intrinsics.checkNotNullParameter(r11, ActivityLifecycle.NAME);
            monitor-enter(this);
            Map<String, c> r12 = this.f5050a;     // Catch: Throwable -> L11
            c r13 = r12.get(r10);     // Catch: Throwable -> L11
            if (r13 != null) goto L7;
            Map r14 = null;
            r13 = new c(r14, 1, 0 == true ? 1 : 0);     // Catch: Throwable -> L11
            r12.put(r10, r13);     // Catch: Throwable -> L11
        L7:
            c r15 = r13;     // Catch: Throwable -> L11
            monitor-exit(this);
            return r15.b(r11);
        L11:
            th = move-exception;
            throw th;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Map<String, Map<String, com.obric.aikernel.res.metadata.data.b>> f5051a;

        /* JADX WARN: Multi-variable type inference failed */
        public c() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public c(Map<String, Map<String, com.obric.aikernel.res.metadata.data.b>> r10) {
            Intrinsics.checkNotNullParameter(r10, "versionMap");
            this.f5051a = r10;
        }

        public /* synthetic */ c(Map r10, int r11, DefaultConstructorMarker r12) {
            if ((r11 & 1) == 0) goto L5;
            r10 = new ConcurrentHashMap();
        L5:
            this(r10);
        }

        public final Map<String, Map<String, com.obric.aikernel.res.metadata.data.b>> a() {
            return this.f5051a;
        }

        public final Map<String, com.obric.aikernel.res.metadata.data.b> b(String r10) {
            Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
            monitor-enter(this);
            Map<String, Map<String, com.obric.aikernel.res.metadata.data.b>> r11 = this.f5051a;     // Catch: Throwable -> L10
            Map<String, com.obric.aikernel.res.metadata.data.b> r12 = r11.get(r10);     // Catch: Throwable -> L10
            if (r12 != null) goto L7;
            r12 = new ConcurrentHashMap();     // Catch: Throwable -> L10
            r11.put(r10, r12);     // Catch: Throwable -> L10
        L7:
            Map<String, com.obric.aikernel.res.metadata.data.b> r13 = r12;     // Catch: Throwable -> L10
            monitor-exit(this);
            return r13;
        L10:
            th = move-exception;
            throw th;
        }
    }

    @SourceDebugExtension({"SMAP\nComparisons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Comparisons.kt\nkotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1\n*L\n1#1,328:1\n*E\n"})
    public static final class d<T> implements Comparator {
        public d() {
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

    @SourceDebugExtension({"SMAP\nComparisons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Comparisons.kt\nkotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2\n*L\n1#1,328:1\n*E\n"})
    public static final class e<T> implements Comparator {
        public e() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r10, T r11) {
            AIPackage.a r12 = AIPackage.f5062u;
            return ComparisonsKt.compareValues(Integer.valueOf(r12.b(((com.obric.aikernel.res.metadata.data.b) r10).D())), Integer.valueOf(r12.b(((com.obric.aikernel.res.metadata.data.b) r11).D())));
        }
    }

    @SourceDebugExtension({"SMAP\nComparisons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Comparisons.kt\nkotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1\n*L\n1#1,328:1\n*E\n"})
    public static final class f<T> implements Comparator {
        public f() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r10, T r11) {
            AIPackage.a r12 = AIPackage.f5062u;
            return ComparisonsKt.compareValues(Integer.valueOf(r12.b(((com.obric.aikernel.res.metadata.data.b) r11).D())), Integer.valueOf(r12.b(((com.obric.aikernel.res.metadata.data.b) r10).D())));
        }
    }

    @SourceDebugExtension({"SMAP\nCoroutineExceptionHandler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoroutineExceptionHandler.kt\nkotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1\n*L\n1#1,110:1\n*E\n"})
    public static final class g extends AbstractCoroutineContextElement implements h0 {
        public g(h0.a r10) {
            super(r10);
        }

        @Override // kotlinx.coroutines.h0
        public void V(CoroutineContext r10, Throwable r11) {
            com.obric.aikernel.runtime.utils.d.f5417a.f("PResM-MetaDataController", r10 + " crashed " + ExceptionsKt.stackTraceToString(r11));
        }
    }

    static {
        new a(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MetadataController(PrmContext r10, PackagesListener r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "packagesListener");
        this.f5043a = r10;
        this.f5044b = r11;
        CoroutineContext r12 = new k0("PResM-MetaDataController").plus(z0.b());
        l0 r13 = m0.a(r12.plus(q2.b(null, 1, null)).plus(new g(h0.f10523d)));
        this.f5045c = r13;
        this.f5046d = new ConcurrentHashMap();
        this.f5047e = new b(null, 1, 0 == true ? 1 : 0);
        this.f5048f = new StorageCleanerDaemon(r10, r13);
    }

    private final void A(com.obric.aikernel.res.metadata.data.b r10) {
        if (r10.n() == false) goto L5;
        this.f5043a.tryInstallFromInstaller(r10.A(), r10.w(), r10.D());
    L5:
        r10.Q();
        if ((r10 instanceof AIPackage) == false) goto L9;
        ((AIPackage) r10).k0();
        return;
    L9:
        if ((r10 instanceof Lora) == false) goto L11;
        List<AIModel> r11 = ((Lora) r10).k0();
    L12:
        if (r11 == null) goto L25;
        Iterator<T> r12 = r11.iterator();
    L15:
        if (r12.hasNext() == false) goto L26;
        AIModel r13 = (AIModel) r12.next();
        if (r13.n() == false) goto L15;
        r13.Q();
        this.f5043a.tryInstallFromInstaller(r13.A(), r13.w(), r13.D());
        goto L15
    L26:
        return;
    L25:
        return;
    L11:
        r11 = null;
        goto L12
    }

    public static /* synthetic */ boolean a(File r10, String r11) {
        return g(r10, r11);
    }

    public static /* synthetic */ boolean b(File r10, String r11) {
        return f(r10, r11);
    }

    private final void d(final Set<String> r10) {
        Function1<com.obric.aikernel.res.metadata.data.b, Unit> r11 = new MetadataController$cleanDepends$cleanAction$1(r10);
        e(this.f5043a, "lib", r11);
        e(this.f5043a, "model", r11);
        d8.a.f8512a.a(this.f5043a);
    }

    private final void e(PrmContext r17, String r18, Function1<? super com.obric.aikernel.res.metadata.data.b, Unit> r19) {
        if (Intrinsics.areEqual(r18, "lib") == false) goto L6;
        File r10 = new File(new com.obric.aikernel.res.metadata.data.e("", "", r17.getConfig()).o());
    L9:
        if (r10 == null) goto L30;
        String[] r11 = r10.list(com.obric.aikernel.res.metadata.controller.b.f5053a);
        if (r11 == null) goto L36;
        int r12 = r11.length;
        int r13 = 0;
    L13:
        if (r13 >= r12) goto L37;
        String r14 = r11[r13];
        String[] r15 = new File(r10, r14).list(com.obric.aikernel.res.metadata.controller.a.f5052a);
        if (r15 == null) goto L29;
        Intrinsics.checkNotNullExpressionValue(r15, "list { f, _ -> f.isDirectory }");
        int r16 = r15.length;
        int r110 = 0;
    L17:
        if (r110 >= r16) goto L29;
        String r111 = r15[r110];
        if (Intrinsics.areEqual(r18, "lib") == false) goto L22;
        Intrinsics.checkNotNullExpressionValue(r14, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullExpressionValue(r111, "version");
        com.obric.aikernel.res.metadata.data.b r112 = new com.obric.aikernel.res.metadata.data.e(r14, r111, r17.getConfig());
    L26:
        if (r112 == null) goto L28;
        r19.invoke(r112);
    L28:
        r110 = r110 + 1;
        goto L17
    L22:
        if (Intrinsics.areEqual(r18, "model") == false) goto L24;
        Intrinsics.checkNotNullExpressionValue(r14, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullExpressionValue(r111, "version");
        r112 = new AIModel(r14, r111, r17.getConfig());
        goto L26
    L24:
        r112 = null;
    L29:
        r13 = r13 + 1;
        goto L13
    L37:
        return;
    L36:
        return;
    L30:
        return;
    L6:
        if (Intrinsics.areEqual(r18, "model") == false) goto L8;
        r10 = new File(new AIModel("", "", r17.getConfig()).o());
        goto L9
    L8:
        r10 = null;
        goto L9
    }

    private static final boolean f(File r10, String r11) {
        return r10.isDirectory();
    }

    private static final boolean g(File r10, String r11) {
        return r10.isDirectory();
    }

    public static /* synthetic */ void k(MetadataController r10, String r11, String r12, boolean r13, int r14, Object r15) {
        if ((r14 & 4) == 0) goto L5;
        r13 = false;
    L5:
        r10.j(r11, r12, r13);
    }

    private final void m(String r10, Map<String, com.obric.aikernel.res.metadata.data.b> r11) {
        monitor-enter(r11);
        AIPackage r12 = this.f5046d.get(r10);     // Catch: Throwable -> L37
        Iterator r13 = CollectionsKt.sortedWith(r11.values(), new e()).iterator();     // Catch: Throwable -> L37
        AIPackage r14 = null;
    L4:
        boolean r15 = false;
        if (r13.hasNext() == false) goto L15;
        com.obric.aikernel.res.metadata.data.b r16 = (com.obric.aikernel.res.metadata.data.b) r13.next();     // Catch: Throwable -> L37
        Intrinsics.checkNotNull(r16, "null cannot be cast to non-null type com.obric.aikernel.res.metadata.data.AIPackage");     // Catch: Throwable -> L37
        AIPackage r17 = (AIPackage) r16;     // Catch: Throwable -> L37
        if (r14 != null) goto L9;
    L11:
        if (r15 == false) goto L14;
        if (r17.H() == false) goto L4;
    L14:
        r14 = r17;
        goto L4
    L9:
        if (r14.H() != true) goto L11;
        r15 = true;
        goto L11
    L15:
        if (r14 == null) goto L24;
        String r18 = r14.D();     // Catch: Throwable -> L37
        if (r12 == null) goto L19;
        String r19 = r12.D();     // Catch: Throwable -> L37
    L21:
        if (Intrinsics.areEqual(r18, r19) == true) goto L24;
        r11.put(r14.D(), r14);     // Catch: Throwable -> L37
        this.f5046d.put(r10, r14);     // Catch: Throwable -> L37
        Unit r20 = Unit.INSTANCE;     // Catch: Throwable -> L37
    L26:
        monitor-exit(r11);
        if (r12 == null) goto L29;
        this.f5044b.b(r12, true);
    L29:
        if (r14 != null) goto L31;
        return;
    L31:
        if ((!r14.k0().isEmpty()) == true) goto L34;
        r14 = null;
    L34:
        if (r14 == null) goto L48;
        PackagesListener.c(this.f5044b, r14, false, 2, null);
        return;
    L48:
        return;
    L19:
        r19 = null;
    L24:
        Unit r21 = Unit.INSTANCE;     // Catch: Throwable -> L37
        r14 = r12;
        r12 = null;
    L37:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ boolean v(MetadataController r10, String r11, String r12, String r13, boolean r14, boolean r15, Function1 r16, int r17, Object r18) {
        if ((r17 & 8) == 0) goto L5;
        r14 = false;
    L5:
        boolean r19 = r14;
        if ((r17 & 16) == 0) goto L9;
        r15 = true;
    L9:
        return r10.u(r11, r12, r13, r19, r15, r16);
    }

    public static /* synthetic */ boolean x(MetadataController r10, String r11, String r12, k r13, boolean r14, boolean r15, Function1 r16, int r17, Object r18) {
        if ((r17 & 4) == 0) goto L5;
        r13 = null;
    L5:
        k r19 = r13;
        if ((r17 & 8) == 0) goto L8;
        r14 = false;
    L8:
        boolean r20 = r14;
        if ((r17 & 16) == 0) goto L12;
        r15 = true;
    L12:
        return r10.w(r11, r12, r19, r20, r15, r16);
    }

    public final synchronized r0<Unit> B() {
        monitor-enter(this);
        r0<Unit> r10 = this.f5049g;     // Catch: Throwable -> L16
        if (r10 == null) goto L12;
        boolean r11 = true;
        if (r10 != null) goto L8;
    L10:
        r11 = false;
    L11:
        if (r11 == false) goto L12;
    L13:
        r0<Unit> r12 = this.f5049g;     // Catch: Throwable -> L16
        monitor-exit(this);
        return r12;
    L8:
        if (r10.isActive() != true) goto L10;
    L12:
        this.f5049g = h.b(this.f5045c, null, null, new MetadataController$refreshPackageAvail$2(this, null), 3, null);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    }

    public final void C(String r13) {
        Intrinsics.checkNotNullParameter(r13, ActivityLifecycle.NAME);
        c r10 = this.f5047e.a().get("package");
        if (r10 == null) goto L19;
        Map<String, Map<String, com.obric.aikernel.res.metadata.data.b>> r11 = r10.a();
        if (r11 == null) goto L23;
        Map<String, com.obric.aikernel.res.metadata.data.b> r14 = r11.get(r13);
        if (r14 == null) goto L24;
        monitor-enter(r14);
        Iterator r12 = CollectionsKt.sortedWith(r14.values(), new f()).iterator();     // Catch: Throwable -> L16
    L11:
        if (r12.hasNext() == false) goto L13;
        final com.obric.aikernel.res.metadata.data.b r15 = (com.obric.aikernel.res.metadata.data.b) r12.next();     // Catch: Throwable -> L16
        Intrinsics.checkNotNull(r15, "null cannot be cast to non-null type com.obric.aikernel.res.metadata.data.AIPackage");     // Catch: Throwable -> L16
        AIPackage r16 = (AIPackage) r15;     // Catch: Throwable -> L16
        x(this, r15.w(), r15.D(), null, false, false, new MetadataController$refreshPackageAvail$1$1$2$1(r15), 28, null);     // Catch: Throwable -> L16
        goto L11
    L13:
        Unit r17 = Unit.INSTANCE;     // Catch: Throwable -> L16
        monitor-exit(r14);
        return;
    L16:
        th = move-exception;
        throw th;
    L24:
        return;
    L23:
        return;
    }

    public final void D(String r10, String r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r11, "version");
        Map<String, com.obric.aikernel.res.metadata.data.b> r13 = this.f5047e.b("package", r10);
        monitor-enter(r13);
        Iterator<Map.Entry<String, com.obric.aikernel.res.metadata.data.b>> r14 = r13.entrySet().iterator();     // Catch: Throwable -> L20
    L6:
        if (r14.hasNext() == false) goto L16;
        Map.Entry<String, com.obric.aikernel.res.metadata.data.b> r15 = r14.next();     // Catch: Throwable -> L20
        if (Intrinsics.areEqual(r15.getValue().D(), "debug") == true) goto L6;
        AIPackage.a r16 = AIPackage.f5062u;     // Catch: Throwable -> L20
        if (r16.b(r11) >= r16.b(r15.getValue().D())) goto L6;
        com.obric.aikernel.res.metadata.data.b r17 = r13.remove(r15.getKey());     // Catch: Throwable -> L20
        if (r17 == null) goto L6;
        if (r12 == true) goto L14;
        r17.l();     // Catch: Throwable -> L20
        goto L6
    L14:
        r17.f0();     // Catch: Throwable -> L20
        goto L6
    L16:
        Unit r18 = Unit.INSTANCE;     // Catch: Throwable -> L20
        monitor-exit(r13);
        m(r10, r13);
        return;
    L20:
        th = move-exception;
        throw th;
    }

    public final void E(com.obric.aikernel.res.metadata.data.b r10) {
        Intrinsics.checkNotNullParameter(r10, "metadata");
        Map<String, com.obric.aikernel.res.metadata.data.b> r11 = this.f5047e.b(r10.A(), r10.w());
        monitor-enter(r11);
        com.obric.aikernel.res.metadata.data.b r12 = r11.get(r10.D());     // Catch: Throwable -> L12
        if (r12 == null) goto L8;
        r10 = r12;
    L8:
        r10.f0();     // Catch: Throwable -> L12
        monitor-exit(r11);
        B();
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public final void F(String r10, String r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r11, "version");
        Map<String, com.obric.aikernel.res.metadata.data.b> r13 = this.f5047e.b("package", r10);
        monitor-enter(r13);
        com.obric.aikernel.res.metadata.data.b r14 = r13.remove(r11);     // Catch: Throwable -> L12
        if (r14 == null) goto L9;
        if (r12 == false) goto L8;
        A((AIPackage) r14);     // Catch: Throwable -> L12
    L8:
        r14.f0();     // Catch: Throwable -> L12
    L9:
        monitor-exit(r13);
        m(r10, r13);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public final void c() {
        File[] r10 = new File(new AIPackage("", "", this.f5043a.getConfig()).o()).listFiles();
        int r11 = 0;
        if (r10 == null) goto L17;
        int r12 = r10.length;
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L17;
        File r14 = r10[r13];
        b r15 = this.f5047e;
        String r16 = r14.getName();
        Intrinsics.checkNotNullExpressionValue(r16, "it.name");
        Map<String, com.obric.aikernel.res.metadata.data.b> r17 = r15.b("package", r16);
        monitor-enter(r17);
        com.obric.aikernel.res.metadata.data.b r18 = r17.remove("debug");     // Catch: Throwable -> L14
        if (r18 == null) goto L11;
        r18.f0();     // Catch: Throwable -> L14
    L11:
        Unit r19 = Unit.INSTANCE;     // Catch: Throwable -> L14
        monitor-exit(r17);
        r13 = r13 + 1;
    L14:
        th = move-exception;
        throw th;
    L17:
        File[] r20 = new File(new com.obric.aikernel.res.metadata.data.e("", "", this.f5043a.getConfig()).o()).listFiles();
        if (r20 == null) goto L22;
        int r21 = r20.length;
    L20:
        if (r11 >= r21) goto L27;
        String r22 = r20[r11].getName();
        Intrinsics.checkNotNullExpressionValue(r22, "it.name");
        new com.obric.aikernel.res.metadata.data.e(r22, "debug", this.f5043a.getConfig()).f0();
        r11 = r11 + 1;
        goto L20
    L27:
        return;
    }

    public final void h() {
        LinkedHashSet r10 = new LinkedHashSet();
        r10.addAll(this.f5043a.getCurrentRunningVersions());
        Iterator<T> r11 = NativeLibVersionPolicy.INSTANCE.getValidVersionMaps().iterator();
    L4:
        if (r11.hasNext() == false) goto L10;
        Map r12 = (Map) r11.next();
        ArrayList r13 = new ArrayList(r12.size());
        Iterator r14 = r12.entrySet().iterator();
    L7:
        if (r14.hasNext() == false) goto L9;
        Map.Entry r15 = (Map.Entry) r14.next();
        r13.add("lib@" + ((String) r15.getKey()) + '@' + ((String) r15.getValue()));
        goto L7
    L9:
        r10.addAll(r13);
        goto L4
    L10:
        com.obric.aikernel.runtime.utils.d.f5417a.c("PResM-MetaDataController", "cleanGarbage running deps is " + CollectionsKt.joinToString$default(r10, null, null, null, 0, null, null, 63, null));
        Collection<AIPackage> r16 = this.f5046d.values();
        ArrayList r17 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10));
        Iterator<T> r18 = r16.iterator();
    L12:
        if (r18.hasNext() == false) goto L14;
        AIPackage r19 = (AIPackage) r18.next();
        r17.add(r19.A() + '@' + r19.w() + '@' + r19.D());
        goto L12
    L14:
        com.obric.aikernel.runtime.utils.d.f5417a.c("PResM-MetaDataController", "cleanGarbage current pkgMap is " + CollectionsKt.joinToString$default(r10, null, null, null, 0, null, null, 63, null));
        r10.addAll(r17);
        Set<String> r20 = i(r10);
        LinkedHashSet r21 = new LinkedHashSet();
        c r22 = this.f5047e.a().get("package");
        if (r22 == null) goto L66;
        Map<String, Map<String, com.obric.aikernel.res.metadata.data.b>> r23 = r22.a();
        if (r23 == null) goto L66;
        Iterator<Map.Entry<String, Map<String, com.obric.aikernel.res.metadata.data.b>>> r24 = r23.entrySet().iterator();
    L20:
        if (r24.hasNext() == false) goto L66;
        Map.Entry<String, Map<String, com.obric.aikernel.res.metadata.data.b>> r25 = r24.next();
        String r26 = r25.getKey();
        Map<String, com.obric.aikernel.res.metadata.data.b> r27 = r25.getValue();
        monitor-enter(r27);
        AIPackage r28 = this.f5046d.get(r26);     // Catch: Throwable -> L63
        if (r28 != null) goto L26;
        String r29 = null;
    L33:
        Iterator<Map.Entry<String, com.obric.aikernel.res.metadata.data.b>> r30 = r27.entrySet().iterator();     // Catch: Throwable -> L63
    L35:
        if (r30.hasNext() == false) goto L60;
        Map.Entry<String, com.obric.aikernel.res.metadata.data.b> r31 = r30.next();     // Catch: Throwable -> L63
        String r110 = r31.getKey();     // Catch: Throwable -> L63
        com.obric.aikernel.res.metadata.data.b r32 = r31.getValue();     // Catch: Throwable -> L63
        String r111 = "package@" + r26 + '@' + r110;     // Catch: Throwable -> L63
        boolean r112 = false;
        if (r10.contains(r111) == false) goto L40;
    L45:
        if (r112 == true) goto L46;
        if ((r32 instanceof AIPackage) == false) goto L52;
        AIPackage r33 = (AIPackage) r32;     // Catch: Throwable -> L63
    L53:
        if (r33 == null) goto L35;
        List<com.obric.aikernel.res.metadata.data.b> r34 = r33.k0();     // Catch: Throwable -> L63
        if (r34 == null) goto L35;
        Iterator<T> r35 = r34.iterator();     // Catch: Throwable -> L63
    L58:
        if (r35.hasNext() == false) goto L35;
        com.obric.aikernel.res.metadata.data.b r113 = (com.obric.aikernel.res.metadata.data.b) r35.next();     // Catch: Throwable -> L63
        r21.add(r113.A() + '@' + r113.w() + '@' + r113.D());     // Catch: Throwable -> L63
        goto L58
    L52:
        r33 = null;
        goto L53
    L46:
        com.obric.aikernel.runtime.utils.d.f5417a.i("PResM-MetaDataController", "cleanGarbage " + r26 + '@' + r110);     // Catch: Throwable -> L63
        com.obric.aikernel.res.metadata.data.b r36 = r27.remove(r110);     // Catch: Throwable -> L63
        if (r36 == null) goto L35;
        r36.f0();     // Catch: Throwable -> L63
        goto L35
    L40:
        if (r20.contains(r111) == true) goto L45;
        if (Intrinsics.areEqual(r29, r32.D()) == true) goto L45;
        r112 = r32.N();     // Catch: Throwable -> L63
        goto L45
    L60:
        Unit r37 = Unit.INSTANCE;     // Catch: Throwable -> L63
        monitor-exit(r27);
        goto L20
    L26:
        if (r28.H() == false) goto L31;
        Iterator<T> r38 = r28.k0().iterator();     // Catch: Throwable -> L63
    L29:
        if (r38.hasNext() == false) goto L31;
        com.obric.aikernel.res.metadata.data.b r39 = (com.obric.aikernel.res.metadata.data.b) r38.next();     // Catch: Throwable -> L63
        r21.add(r39.A() + '@' + r39.w() + '@' + r39.D());     // Catch: Throwable -> L63
    L31:
        r29 = r28.D();     // Catch: Throwable -> L63
    L63:
        th = move-exception;
        throw th;
    L66:
        r21.addAll(r10);
        r21.addAll(r20);
        d(r21);
    }

    public final Set<String> i(Set<String> r19) {
        Set<String> r10 = r19;
        Intrinsics.checkNotNullParameter(r10, "valid");
        LinkedHashSet r11 = new LinkedHashSet();
        File r12 = new File(new Lora("", "", this.f5043a.getConfig()).o());
        String[] r13 = r12.list();
        if (r13 == null) goto L42;
        int r14 = r13.length;
        int r15 = 0;
    L5:
        if (r15 >= r14) goto L42;
        String r16 = r13[r15];
        String[] r17 = new File(r12, r16).list();
        if (r17 == null) goto L41;
        Intrinsics.checkNotNullExpressionValue(r17, "list()");
        List r18 = ArraysKt.sortedWith(r17, new d());
        if (r18 == null) goto L41;
        Iterator r20 = r18.iterator();
        int r110 = 0;
    L12:
        if (r20.hasNext() == false) goto L41;
        Object r111 = r20.next();
        int r112 = r110 + 1;
        if (r110 >= 0) goto L16;
        CollectionsKt.throwIndexOverflow();
    L16:
        String r113 = (String) r111;
        String r114 = "lora@" + r16 + '@' + r113;
        if (r10.contains(r114) == false) goto L19;
        com.obric.aikernel.runtime.utils.d.f5417a.g("PResM-MetaDataController", "cleanLoras " + r114 + " ignore in valid.");
        File r115 = r12;
        String[] r116 = r13;
    L40:
        r10 = r19;
        r110 = r112;
        r12 = r115;
        r13 = r116;
        goto L12
    L19:
        Intrinsics.checkNotNullExpressionValue(r16, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullExpressionValue(r113, "version");
        Lora r117 = new Lora(r16, r113, this.f5043a.getConfig());
        r115 = r12;
        r116 = r13;
        Pair<Lora, AIPackage> r21 = Lora.f5072s.a(r117.j0(), r16, this.f5043a);
        if (r21 != null) goto L22;
        com.obric.aikernel.runtime.utils.d.f5417a.g("PResM-MetaDataController", "cleanLoras " + r114 + " no lora info.");
        if (r110 == 0) goto L40;
    L28:
        r117.f0();
        goto L40
    L22:
        if (r21.getFirst().H() == true) goto L24;
    L34:
        com.obric.aikernel.runtime.utils.d.f5417a.g("PResM-MetaDataController", "cleanLoras " + r114 + " no avail lora.");
        if (r110 == 0) goto L40;
    L24:
        if (r21.getSecond().H() == false) goto L34;
        AIPackage.a r22 = AIPackage.f5062u;
        if (r22.b(r113) >= r22.b(r21.getFirst().D())) goto L29;
        com.obric.aikernel.runtime.utils.d.f5417a.g("PResM-MetaDataController", "cleanLoras " + r114 + " low version code.");
        goto L28
    L29:
        r11.add("package@" + r21.getSecond().w() + '@' + r21.getSecond().D());
        List<AIModel> r23 = r117.k0();
        ArrayList r24 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r23, 10));
        Iterator<T> r25 = r23.iterator();
    L31:
        if (r25.hasNext() == false) goto L33;
        AIModel r26 = (AIModel) r25.next();
        r24.add(r26.A() + '@' + r26.w() + '@' + r26.D());
        goto L31
    L33:
        r11.addAll(r24);
    L41:
        r15 = r15 + 1;
        r10 = r19;
        r12 = r12;
        r13 = r13;
    L42:
        return r11;
    }

    public final void j(String r10, String r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r11, "version");
        Map<String, com.obric.aikernel.res.metadata.data.b> r13 = this.f5047e.b("package", r10);
        monitor-enter(r13);
        com.obric.aikernel.res.metadata.data.b r14 = r13.get(r11);     // Catch: Throwable -> L12
        if (r14 == null) goto L9;
        if (r12 == false) goto L8;
        A((AIPackage) r14);     // Catch: Throwable -> L12
    L8:
        r14.l();     // Catch: Throwable -> L12
    L9:
        monitor-exit(r13);
        m(r10, r13);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public final void l(String r11, String r12) {
        Intrinsics.checkNotNullParameter(r11, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r12, "version");
        Map<String, com.obric.aikernel.res.metadata.data.b> r10 = this.f5047e.b("package", r11);
        monitor-enter(r10);
        final com.obric.aikernel.res.metadata.data.b r13 = r10.get(r12);     // Catch: Throwable -> L14
        if (r13 == null) goto L11;
        String r14 = r13.w();     // Catch: Throwable -> L14
        String r15 = r13.D();     // Catch: Throwable -> L14
        DistConfig r16 = r13.s();     // Catch: Throwable -> L14
        if (r16 == null) goto L9;
        k r17 = r16.f();     // Catch: Throwable -> L14
    L10:
        x(this, r14, r15, r17, false, false, new MetadataController$enablePackage$1$1$1(r13), 24, null);     // Catch: Throwable -> L14
        goto L11
    L9:
        r17 = null;
    L11:
        monitor-exit(r10);
        m(r11, r10);
        return;
    L14:
        th = move-exception;
        throw th;
    }

    public final void n() {
        h.d(this.f5045c, null, null, new MetadataController$flushPackageUsage$1(this, null), 3, null);
    }

    public final List<String> o() {
        return CollectionsKt.toList(this.f5046d.keySet());
    }

    public final b p() {
        return this.f5047e;
    }

    public final AIPackage q(String r10) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        return this.f5046d.get(r10);
    }

    public final Map<String, AIPackage> r() {
        return this.f5046d;
    }

    public final Map<String, com.obric.aikernel.res.metadata.data.b> s(String r10) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        return this.f5047e.b("package", r10);
    }

    public final void t() {
        long r10 = System.currentTimeMillis();
        this.f5043a.runInstaller(new ApkDataScanner());
        long r11 = System.currentTimeMillis() - r10;
        com.obric.aikernel.runtime.utils.c.a.a(com.obric.aikernel.runtime.utils.d.f5417a, "PResM-MetaDataController", "scanDataDir in " + r11 + " ms", 0, 4, null);
        this.f5048f.e();
    }

    public final boolean u(String r10, String r11, String r12, boolean r13, boolean r14, Function1<? super String, ? extends com.obric.aikernel.res.metadata.data.b> r15) {
        Intrinsics.checkNotNullParameter(r10, WsConstants.KEY_CONNECTION_TYPE);
        Intrinsics.checkNotNullParameter(r11, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r12, "version");
        Intrinsics.checkNotNullParameter(r15, "builder");
        if (r13 == false) goto L5;
    L8:
        boolean r16 = true;
    L9:
        Map<String, com.obric.aikernel.res.metadata.data.b> r17 = this.f5047e.b(r10, r11);
        monitor-enter(r17);
        com.obric.aikernel.res.metadata.data.b r18 = r17.get(r12);     // Catch: Throwable -> L38
        if (r16 == true) goto L23;
        if (r18 != null) goto L15;
    L17:
        boolean r19 = false;
    L18:
        if (r19 == false) goto L23;
        Unit r20 = Unit.INSTANCE;     // Catch: Throwable -> L38
        monitor-exit(r17);
        return true;
    L15:
        if (r18.H() != true) goto L17;
        r19 = true;
    L23:
        com.obric.aikernel.res.metadata.data.b r21 = r15.invoke(this.f5043a.getConfig().getRootDir());     // Catch: Throwable -> L38
        if (r16 == true) goto L32;
        if (r21.H() == false) goto L32;
        r17.put(r12, r21);     // Catch: Throwable -> L38
        monitor-exit(r17);
        return true;
    L32:
        if (r21.W(this.f5043a, r13, r14) == false) goto L36;
        r17.put(r12, r21);     // Catch: Throwable -> L38
        B();     // Catch: Throwable -> L38
        monitor-exit(r17);
        return true;
    L36:
        monitor-exit(r17);
        return false;
    L38:
        th = move-exception;
        throw th;
    L5:
        if (Intrinsics.areEqual(r12, "debug") == true) goto L8;
        r16 = false;
        goto L9
    }

    public final boolean w(String r16, String r17, k r18, boolean r19, boolean r20, Function1<? super String, ? extends com.obric.aikernel.res.metadata.data.b> r21) {
        Intrinsics.checkNotNullParameter(r16, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r17, "version");
        Intrinsics.checkNotNullParameter(r21, "builder");
        boolean r10 = true;
        if (y(r16, r17, r18, r20) == false) goto L62;
        Map<String, com.obric.aikernel.res.metadata.data.b> r11 = this.f5047e.b("package", r16);
        monitor-enter(r11);
    L59:
        th = move-exception;
        throw th;
    L7:
        if (y(r16, r17, r18, r20) == false) goto L47;
        com.obric.aikernel.res.metadata.data.b r12 = r21.invoke(this.f5043a.getConfig().getRootDir());     // Catch: Throwable -> L59
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type com.obric.aikernel.res.metadata.data.AIPackage");     // Catch: Throwable -> L59
        AIPackage r13 = (AIPackage) r12;     // Catch: Throwable -> L59
        if (r13.s() != null) goto L14;
        if (r18 != null) goto L14;
        com.obric.aikernel.runtime.utils.d.f5417a.f("PResM-MetaDataController", "install package err invalid config.");     // Catch: Throwable -> L59
        monitor-exit(r11);
        return false;
    L14:
        if (r19 == true) goto L23;
        if (r18 != null) goto L17;
    L19:
        boolean r14 = false;
    L20:
        if (r14 == true) goto L23;
        boolean r15 = false;
    L25:
        if (r13.W(this.f5043a, r15, r20) == false) goto L45;
        AIPackage r22 = this.f5046d.get(r16);     // Catch: Throwable -> L59
        if (r22 != null) goto L29;
    L31:
        boolean r23 = false;
    L32:
        if (r23 == true) goto L34;
        boolean r24 = true;
    L35:
        boolean r25 = r13.H();     // Catch: Throwable -> L59
        com.obric.aikernel.runtime.utils.d r110 = com.obric.aikernel.runtime.utils.d.f5417a;     // Catch: Throwable -> L59
        StringBuilder r111 = new StringBuilder();     // Catch: Throwable -> L59
        r111.append(r16);     // Catch: Throwable -> L59
        r111.append(" oldVersion:");     // Catch: Throwable -> L59
        if (r22 == null) goto L38;
        String r26 = r22.D();     // Catch: Throwable -> L59
    L39:
        r111.append(r26);     // Catch: Throwable -> L59
        r111.append(" oldIsNotAvail:");     // Catch: Throwable -> L59
        r111.append(r24);     // Catch: Throwable -> L59
        r111.append(" newVersion:");     // Catch: Throwable -> L59
        r111.append(r13.D());     // Catch: Throwable -> L59
        r111.append(" newIsAvail:");     // Catch: Throwable -> L59
        r111.append(r25);     // Catch: Throwable -> L59
        r110.i("PResM-MetaDataController", r111.toString());     // Catch: Throwable -> L59
        if (r24 == true) goto L44;
        if (r25 == true) goto L44;
        r11.putIfAbsent(r17, r13);     // Catch: Throwable -> L59
    L54:
        r13 = null;
    L55:
        monitor-exit(r11);
        if (r13 == null) goto L58;
        com.obric.aikernel.runtime.utils.c.a.a(com.obric.aikernel.runtime.utils.d.f5417a, "PResM-MetaDataController", "installPackage " + r16 + '@' + r17 + " avail:" + r13.H(), 0, 4, null);
        PackagesListener.c(this.f5044b, r13, false, 2, null);
    L58:
        return r10;
    L44:
        r11.put(r17, r13);     // Catch: Throwable -> L59
        this.f5046d.put(r16, r13);     // Catch: Throwable -> L59
        goto L55
    L38:
        r26 = null;
        goto L39
    L34:
        r24 = false;
        goto L35
    L29:
        if (r22.H() != true) goto L31;
        r23 = true;
        goto L32
    L45:
        r11.putIfAbsent(r17, r13);     // Catch: Throwable -> L59
        r10 = false;
        goto L54
    L17:
        if (r13.r0(r18) != true) goto L19;
        r14 = true;
    L23:
        r15 = true;
        goto L25
    L47:
        if (r11.containsKey(r17) == true) goto L54;
        com.obric.aikernel.res.metadata.data.b r27 = r21.invoke(this.f5043a.getConfig().getRootDir());     // Catch: Throwable -> L59
        if ((r27 instanceof AIPackage) == false) goto L51;
        AIPackage r28 = (AIPackage) r27;     // Catch: Throwable -> L59
    L52:
        if (r28 == null) goto L54;
        r11.put(r17, r28);     // Catch: Throwable -> L59
        goto L54
    L51:
        r28 = null;
        goto L52
    L62:
        return true;
    }

    public final boolean y(String r10, String r11, k r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r11, "version");
        AIPackage r14 = this.f5046d.get(r10);
        boolean r15 = false;
        boolean r16 = true;
        if (r14 != null) goto L5;
    L43:
        r15 = r16;
    L44:
        com.obric.aikernel.runtime.utils.d r17 = com.obric.aikernel.runtime.utils.d.f5417a;
        StringBuilder r18 = new StringBuilder();
        r18.append(r10);
        r18.append(' ');
        r18.append(r11);
        r18.append(" isPackageNeedUpdate ");
        r18.append(r15);
        r18.append(" current:");
        if (r14 == null) goto L47;
        String r19 = r14.D();
    L48:
        r18.append(r19);
        r17.d("PResM-MetaDataController", r18.toString());
        return r15;
    L47:
        r19 = null;
        goto L48
    L5:
        if (r14.H() == false) goto L43;
        if (r14.e0(r13) == true) goto L43;
        if (Intrinsics.areEqual(r11, "debug") == true) goto L43;
        if (Intrinsics.areEqual(r14.D(), "debug") == false) goto L38;
        Map<String, com.obric.aikernel.res.metadata.data.b> r20 = this.f5047e.b("package", r10);
        monitor-enter(r20);
        Collection<com.obric.aikernel.res.metadata.data.b> r110 = r20.values();     // Catch: Throwable -> L35
        ArrayList r111 = new ArrayList();     // Catch: Throwable -> L35
        Iterator<T> r112 = r110.iterator();     // Catch: Throwable -> L35
    L18:
        if (r112.hasNext() == false) goto L27;
        Object r21 = r112.next();     // Catch: Throwable -> L35
        com.obric.aikernel.res.metadata.data.b r22 = (com.obric.aikernel.res.metadata.data.b) r21;     // Catch: Throwable -> L35
        if (Intrinsics.areEqual(r22.D(), "debug") == true) goto L24;
        AIPackage.a r23 = AIPackage.f5062u;     // Catch: Throwable -> L35
        if (r23.b(r22.D()) < r23.b(r11)) goto L24;
        boolean r24 = true;
    L25:
        if (r24 == false) goto L18;
        r111.add(r21);     // Catch: Throwable -> L35
    L24:
        r24 = false;
        goto L25
    L27:
        Iterator r113 = r111.iterator();     // Catch: Throwable -> L35
    L28:
        if (r113.hasNext() == false) goto L33;
        if (((com.obric.aikernel.res.metadata.data.b) r113.next()).H() == false) goto L28;
        r16 = false;
        goto L28
    L33:
        monitor-exit(r20);
    L35:
        th = move-exception;
        throw th;
    L38:
        AIPackage.a r25 = AIPackage.f5062u;
        if (r25.b(r11) > r25.b(r14.D())) goto L43;
        if (r12 == null) goto L44;
        r15 = r14.r0(r12);
        goto L44
    }

    public final void z(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r11, "version");
        com.obric.aikernel.res.metadata.data.b r12 = this.f5047e.b("package", r10).get(r11);
        if (r12 == null) goto L5;
        A(r12);
    L5:
        com.obric.aikernel.res.metadata.data.b r13 = this.f5047e.b("lora", r10).get(r11);
        if (r13 == null) goto L9;
        A(r13);
        return;
    }
}
