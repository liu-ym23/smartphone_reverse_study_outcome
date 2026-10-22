package com.obric.aikernel.res.update;

import android.os.Process;
import android.os.SystemClock;
import androidx.annotation.GuardedBy;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.aikernel.res.PackageResourceManager;
import com.obric.aikernel.res.PrmContext;
import com.obric.aikernel.res.metadata.config.DistConfig;
import com.obric.aikernel.res.metadata.config.LoraConfig;
import com.obric.aikernel.res.metadata.config.UpdateTaskConfig;
import com.obric.aikernel.res.metadata.data.AIPackage;
import com.obric.aikernel.res.metadata.data.Lora;
import com.obric.aikernel.res.task.StorageCleanerDaemon;
import com.obric.aikernel.res.task.UpdateDaemon;
import com.obric.aikernel.runtime.utils.NetworkUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import kotlin.ExceptionsKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.q2;
import kotlinx.coroutines.r0;
import kotlinx.coroutines.z0;

/* JADX INFO: loaded from: classes2.dex */
public final class PackageUpdater {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PrmContext f5117a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final l0 f5118b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final b8.a f5119c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final File f5120d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final j f5121e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final UpdateDaemon f5122f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @GuardedBy("this")
    private final Map<String, UpdateTask> f5123g;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f5124a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f5125b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f5126c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f5127d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final boolean f5128e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final boolean f5129f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final boolean f5130g;

        public b(String r10, int r11, boolean r12, boolean r13, boolean r14, boolean r15, boolean r16) {
            Intrinsics.checkNotNullParameter(r10, "caller");
            this.f5124a = r10;
            this.f5125b = r11;
            this.f5126c = r12;
            this.f5127d = r13;
            this.f5128e = r14;
            this.f5129f = r15;
            this.f5130g = r16;
        }

        public /* synthetic */ b(String r10, int r11, boolean r12, boolean r13, boolean r14, boolean r15, boolean r16, int r17, DefaultConstructorMarker r18) {
            boolean r19 = false;
            if ((r17 & 2) == 0) goto L5;
            int r20 = 0;
        L7:
            if ((r17 & 4) == 0) goto L9;
            boolean r21 = false;
        L11:
            if ((r17 & 8) == 0) goto L13;
            boolean r22 = false;
        L15:
            if ((r17 & 16) == 0) goto L17;
            boolean r23 = false;
        L19:
            if ((r17 & 32) != 0) goto L23;
            r19 = r15;
        L23:
            if ((r17 & 64) == 0) goto L25;
            boolean r24 = true;
        L26:
            this(r10, r20, r21, r22, r23, r19, r24);
            return;
        L25:
            r24 = r16;
            goto L26
        L17:
            r23 = r14;
            goto L19
        L13:
            r22 = r13;
            goto L15
        L9:
            r21 = r12;
            goto L11
        L5:
            r20 = r11;
            goto L7
        }

        public final boolean a() {
            return this.f5130g;
        }

        public final String b() {
            return this.f5124a;
        }

        public final boolean c() {
            return this.f5127d;
        }

        public final boolean d() {
            return this.f5128e;
        }

        public final boolean e() {
            return this.f5129f;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof b) == true) goto L8;
            return false;
        L8:
            b r11 = (b) r10;
            if (Intrinsics.areEqual(this.f5124a, r11.f5124a) == true) goto L12;
            return false;
        L12:
            if (this.f5125b == r11.f5125b) goto L15;
            return false;
        L15:
            if (this.f5126c == r11.f5126c) goto L18;
            return false;
        L18:
            if (this.f5127d == r11.f5127d) goto L21;
            return false;
        L21:
            if (this.f5128e == r11.f5128e) goto L24;
            return false;
        L24:
            if (this.f5129f == r11.f5129f) goto L27;
            return false;
        L27:
            if (this.f5130g == r11.f5130g) goto L29;
            return false;
        L29:
            return true;
        }

        public final int f() {
            return this.f5125b;
        }

        public final boolean g() {
            return this.f5126c;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v11, types: [int] */
        /* JADX WARN: Type inference failed for: r0v13, types: [int] */
        /* JADX WARN: Type inference failed for: r0v5, types: [int] */
        /* JADX WARN: Type inference failed for: r0v7, types: [int] */
        /* JADX WARN: Type inference failed for: r0v9, types: [int] */
        /* JADX WARN: Type inference failed for: r1v10 */
        /* JADX WARN: Type inference failed for: r1v11 */
        /* JADX WARN: Type inference failed for: r1v12 */
        /* JADX WARN: Type inference failed for: r1v13 */
        /* JADX WARN: Type inference failed for: r1v14 */
        /* JADX WARN: Type inference failed for: r1v15 */
        /* JADX WARN: Type inference failed for: r1v16 */
        /* JADX WARN: Type inference failed for: r1v17 */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v5, types: [int] */
        /* JADX WARN: Type inference failed for: r1v7, types: [int] */
        /* JADX WARN: Type inference failed for: r1v9, types: [int] */
        /* JADX WARN: Type inference failed for: r2v0 */
        /* JADX WARN: Type inference failed for: r2v1, types: [int] */
        /* JADX WARN: Type inference failed for: r2v2 */
        public int hashCode() {
            int r10 = ((this.f5124a.hashCode() * 31) + Integer.hashCode(this.f5125b)) * 31;
            boolean r11 = this.f5126c;
            ?? r12 = 1;
            ?? r13 = r11;
            if (r11 == false) goto L5;
            r13 = 1;
        L5:
            int r14 = (r10 + r13) * 31;
            boolean r15 = this.f5127d;
            ?? r16 = r15;
            if (r15 == false) goto L8;
            r16 = 1;
        L8:
            int r17 = (r14 + r16) * 31;
            boolean r18 = this.f5128e;
            ?? r19 = r18;
            if (r18 == false) goto L11;
            r19 = 1;
        L11:
            int r20 = (r17 + r19) * 31;
            boolean r21 = this.f5129f;
            ?? r22 = r21;
            if (r21 == false) goto L14;
            r22 = 1;
        L14:
            int r23 = (r20 + r22) * 31;
            boolean r24 = this.f5130g;
            if (r24 == true) goto L19;
            r12 = r24;
        L19:
            return r23 + r12;
        }

        public String toString() {
            return "Constriction(caller=" + this.f5124a + ", prior=" + this.f5125b + ", updateAll=" + this.f5126c + ", force=" + this.f5127d + ", onlyDownload=" + this.f5128e + ", onlyFetchConfig=" + this.f5129f + ", background=" + this.f5130g + ')';
        }
    }

    @SourceDebugExtension({"SMAP\nComparisons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Comparisons.kt\nkotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2\n*L\n1#1,328:1\n*E\n"})
    public static final class c<T> implements Comparator {
        public c() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r10, T r11) {
            return ComparisonsKt.compareValues(((com.obric.aikernel.res.metadata.data.b) r10).D(), ((com.obric.aikernel.res.metadata.data.b) r11).D());
        }
    }

    @SourceDebugExtension({"SMAP\nCoroutineExceptionHandler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoroutineExceptionHandler.kt\nkotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1\n*L\n1#1,110:1\n*E\n"})
    public static final class d extends AbstractCoroutineContextElement implements h0 {
        public d(h0.a r10) {
            super(r10);
        }

        @Override // kotlinx.coroutines.h0
        public void V(CoroutineContext r10, Throwable r11) {
            com.obric.aikernel.runtime.utils.d.f5417a.f("PackageUpdater", r10 + " crashed " + ExceptionsKt.stackTraceToString(r11));
        }
    }

    static {
        new a(null);
    }

    public PackageUpdater(PrmContext r10) {
        Intrinsics.checkNotNullParameter(r10, "ctx");
        this.f5117a = r10;
        l0 r11 = m0.a(z0.b().plus(new k0("PackageUpdater")).plus(q2.b(null, 1, null)).plus(new d(h0.f10523d)));
        this.f5118b = r11;
        this.f5119c = new b8.a(r10.getConfig().getContext());
        File r12 = new File(r10.getConfig().getRootDir(), "update");
        this.f5120d = r12;
        this.f5121e = new j(r12, new PackageUpdater$modelDownloadTelemetry$1(this), null, 4, null);
        this.f5122f = new UpdateDaemon(r10, r11, this);
        if (r12.exists() == true) goto L5;
        r12.mkdirs();
    L5:
        this.f5123g = new LinkedHashMap();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object B(PackageUpdater r10, List r11, b r12, String r13, Continuation r14, int r15, Object r16) {
        if ((r15 & 1) == 0) goto L6;
        r11 = CollectionsKt.emptyList();
    L6:
        if ((r15 & 4) == 0) goto L9;
        r13 = "";
    L9:
        return r10.A(r11, r12, r13, r14);
    }

    public static /* synthetic */ boolean a(File r10, String r11) {
        return k(r10, r11);
    }

    public static final /* synthetic */ PrmContext b(PackageUpdater r10) {
        return r10.f5117a;
    }

    public static final /* synthetic */ File c(PackageUpdater r10) {
        return r10.f5120d;
    }

    public static final /* synthetic */ l0 d(PackageUpdater r10) {
        return r10.f5118b;
    }

    public static final /* synthetic */ UpdateTask e(PackageUpdater r10, String r11) {
        return r10.p(r11);
    }

    public static final /* synthetic */ boolean f(PackageUpdater r10) {
        return r10.s();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r12v7 */
    /* JADX WARN: Type inference failed for: r12v8 */
    /* JADX WARN: Type inference failed for: r12v9 */
    /* JADX WARN: Type inference failed for: r13v13 */
    /* JADX WARN: Type inference failed for: r13v14 */
    /* JADX WARN: Type inference failed for: r13v20 */
    /* JADX WARN: Type inference failed for: r13v21 */
    /* JADX WARN: Type inference failed for: r13v22 */
    /* JADX WARN: Type inference failed for: r13v4 */
    /* JADX WARN: Type inference failed for: r13v5 */
    /* JADX WARN: Type inference failed for: r13v8 */
    /* JADX WARN: Type inference failed for: r13v9 */
    private final Map<String, MetadataRequest.b> g(List<String> r17, String r18, b r19, long r20, CoroutineContext r22, StringBuilder r23) {
        ArrayList r10 = new ArrayList();
        Iterator r11 = r17.iterator();
    L4:
        if (r11.hasNext() == false) goto L73;
        String r12 = (String) r11.next();
        r23.append(r12);
        List r13 = CollectionsKt.sortedWith(this.f5117a.getMetadataCtrl$resource_manager_release().s(r12).values(), new c());
        ListIterator r14 = r13.listIterator(r13.size());
    L6:
        boolean r15 = true;
        Pair r16 = null;
        ?? r110 = 0;
        ?? r111 = 0;
        ?? r112 = 0;
        if (r14.hasPrevious() == false) goto L14;
        Object r21 = r14.previous();
        if (StringsKt.toIntOrNull(((com.obric.aikernel.res.metadata.data.b) r21).D()) == null) goto L11;
        ?? r113 = true;
    L12:
        if (r113 == false) goto L6;
    L16:
        if ((r21 instanceof AIPackage) == false) goto L18;
        AIPackage r24 = (AIPackage) r21;
    L19:
        if (r24 != null) goto L21;
    L25:
        Pair r25 = new Pair(r12, new MetadataRequest.c(r112 == true ? 1 : 0, r111 == true ? 1 : 0, 3, r110 == true ? 1 : 0));
    L27:
        if (r19.c() == false) goto L29;
    L62:
        String r26 = " update by force, ";
    L63:
        r23.append(r26);
    L64:
        if (r25 == null) goto L70;
        UpdateTask r27 = n(r12, r20);
        r27.n(r22, r19);
        if (r27.H().getStage() >= 100) goto L68;
        r27.H().setStage(100);
    L68:
        r16 = r25;
    L70:
        if (r16 == null) goto L4;
        r10.add(r16);
        goto L4
    L29:
        if (r19.g() == true) goto L62;
        if (r18.length() <= 0) goto L34;
        ?? r114 = true;
    L35:
        if (r114 == false) goto L50;
        Pair<Lora, AIPackage> r115 = Lora.f5072s.a(r12, r18, this.f5117a);
        if (r115 != null) goto L39;
    L46:
        r15 = false;
    L47:
        if (r15 == true) goto L50;
        r26 = " update lora " + r18 + ", ";
        goto L63
    L39:
        if (r115.getFirst().H() == true) goto L41;
    L43:
        ?? r116 = false;
    L44:
        if (r116 != true) goto L46;
    L41:
        if (r115.getSecond().H() == false) goto L43;
        r116 = true;
    L50:
        if (u(r12, r20) == true) goto L53;
        String r28 = " merge to current request, ";
    L52:
        r23.append(r28);
        r25 = null;
        goto L64
    L53:
        if (r24 != null) goto L56;
        r26 = " update by notExist, ";
        goto L63
    L56:
        if (r24.H() == true) goto L58;
    L61:
        r26 = " update by notAvail, ";
        goto L63
    L58:
        if (r24.g(p.k(r19.b())) == true) goto L61;
        r28 = " don't need update, ";
        goto L52
    L34:
        r114 = false;
        goto L35
    L21:
        if (r24.H() == false) goto L23;
        r25 = new Pair(r12, new MetadataRequest.d(r24.D(), r24.t()));
    L24:
        if (r25 != null) goto L27;
    L23:
        r25 = null;
        goto L24
    L18:
        r24 = null;
        goto L19
    L11:
        r113 = false;
        goto L12
    L14:
        r21 = null;
        goto L16
    L73:
        return MapsKt.toMap(r10);
    }

    private final void h() {
        kotlinx.coroutines.h.d(this.f5118b, null, null, new PackageUpdater$checkToResumeUpdateTask$1(this, null), 3, null);
        kotlinx.coroutines.h.d(this.f5118b, null, null, new PackageUpdater$checkToResumeUpdateTask$2(this, null), 3, null);
    }

    public static /* synthetic */ void j(PackageUpdater r10, boolean r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L5;
        r11 = true;
    L5:
        r10.i(r11);
    }

    private static final boolean k(File r10, String r11) {
        return r10.isDirectory();
    }

    private final void l(boolean r18, File r19) {
        File r10 = new File(this.f5120d, "packages");
        boolean r11 = s();
        Integer r12 = null;
        String r13 = PackageUpdaterKt.f(r10, 0, 2, null);
        if (PackageUpdaterKt.n(r10, r11, r18) == true) goto L29;
        com.obric.aikernel.runtime.utils.d r14 = com.obric.aikernel.runtime.utils.d.f5417a;
        StringBuilder r15 = new StringBuilder();
        r15.append("skip clean update downloads: onlyDownload=");
        r15.append(r18);
        r15.append(" hasActiveUpdateJob=");
        r15.append(r11);
        r15.append(" packagesExists=");
        r15.append(r10.exists());
        r15.append(" packagesCount=");
        String[] r16 = r10.list();
        if (r16 == null) goto L7;
        r12 = Integer.valueOf(r16.length);
    L7:
        r15.append(r12);
        r15.append(" packages=");
        r15.append(r13);
        r15.append(" reason=");
        if (r18 == false) goto L10;
        String r17 = "only_download_request";
    L27:
        r15.append(r17);
        r14.i("PackageUpdater", r15.toString());
        return;
    L10:
        if (r11 == false) goto L13;
        r17 = "active_download_job";
        goto L27
    L13:
        if (r10.exists() == false) goto L26;
        String[] r20 = r10.list();
        if (r20 != null) goto L17;
    L23:
        boolean r110 = false;
    L24:
        if (r110 == false) goto L26;
        r17 = "pending_package_dirs_exist";
        goto L27
    L17:
        if (r20.length != 0) goto L19;
        boolean r21 = true;
    L21:
        if ((!r21) != true) goto L23;
        r110 = true;
        goto L24
    L19:
        r21 = false;
    L26:
        r17 = "not_idle";
        goto L27
    L29:
        File r22 = new File(this.f5120d, "downloads");
        Result.Companion r23 = Result.Companion;     // Catch: Throwable -> L43
        boolean r24 = PackageUpdaterKt.c(r22);     // Catch: Throwable -> L43
        if (r24 == false) goto L33;
        this.f5121e.g(2);     // Catch: Throwable -> L43
    L33:
        com.obric.aikernel.runtime.utils.d r111 = com.obric.aikernel.runtime.utils.d.f5417a;     // Catch: Throwable -> L43
        StringBuilder r112 = new StringBuilder();     // Catch: Throwable -> L43
        r112.append("clean update downloads: ");     // Catch: Throwable -> L43
        r112.append(r22.getPath());     // Catch: Throwable -> L43
        r112.append(" deleted=");     // Catch: Throwable -> L43
        r112.append(r24);     // Catch: Throwable -> L43
        r112.append(" exists=");     // Catch: Throwable -> L43
        r112.append(r22.exists());     // Catch: Throwable -> L43
        r112.append(" count=");     // Catch: Throwable -> L43
        String[] r25 = r22.list();     // Catch: Throwable -> L43
        if (r25 == null) goto L36;
        Integer r26 = Integer.valueOf(r25.length);     // Catch: Throwable -> L43
    L37:
        r112.append(r26);     // Catch: Throwable -> L43
        r112.append(" packagesExists=");     // Catch: Throwable -> L43
        r112.append(r10.exists());     // Catch: Throwable -> L43
        r112.append(" packagesCount=");     // Catch: Throwable -> L43
        String[] r27 = r10.list();     // Catch: Throwable -> L43
        if (r27 == null) goto L40;
        Integer r28 = Integer.valueOf(r27.length);     // Catch: Throwable -> L43
    L41:
        r112.append(r28);     // Catch: Throwable -> L43
        r112.append(" packages=");     // Catch: Throwable -> L43
        r112.append(r13);     // Catch: Throwable -> L43
        r112.append(" reason=idle_no_pending_package_dirs");     // Catch: Throwable -> L43
        r111.i("PackageUpdater", r112.toString());     // Catch: Throwable -> L43
        Object r29 = Result.m32constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L43
    L45:
        Throwable r30 = Result.m35exceptionOrNullimpl(r29);
        if (r30 == null) goto L48;
        com.obric.aikernel.runtime.utils.d.f5417a.l("PackageUpdater", "clean downloads file failed " + r30);
    L48:
        if (r19 == null) goto L70;
        File r31 = PackageUpdaterKt.l(r19, new File(this.f5117a.getConfig().getRootDir()), r22);
        Result.Companion r32 = Result.Companion;     // Catch: Throwable -> L59
        boolean r33 = PackageUpdaterKt.c(r31);     // Catch: Throwable -> L59
        if (r33 == false) goto L53;
        this.f5121e.g(2);     // Catch: Throwable -> L59
    L53:
        com.obric.aikernel.runtime.utils.d r34 = com.obric.aikernel.runtime.utils.d.f5417a;     // Catch: Throwable -> L59
        StringBuilder r35 = new StringBuilder();     // Catch: Throwable -> L59
        r35.append("clean external update downloads: ");     // Catch: Throwable -> L59
        r35.append(r31.getPath());     // Catch: Throwable -> L59
        r35.append(" deleted=");     // Catch: Throwable -> L59
        r35.append(r33);     // Catch: Throwable -> L59
        r35.append(" exists=");     // Catch: Throwable -> L59
        r35.append(r31.exists());     // Catch: Throwable -> L59
        r35.append(" count=");     // Catch: Throwable -> L59
        String[] r36 = r31.list();     // Catch: Throwable -> L59
        if (r36 == null) goto L56;
        Integer r113 = Integer.valueOf(r36.length);     // Catch: Throwable -> L59
    L57:
        r35.append(r113);     // Catch: Throwable -> L59
        r34.i("PackageUpdater", r35.toString());     // Catch: Throwable -> L59
        Object r37 = Result.m32constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L59
    L61:
        Throwable r38 = Result.m35exceptionOrNullimpl(r37);
        if (r38 == null) goto L64;
        com.obric.aikernel.runtime.utils.d.f5417a.l("PackageUpdater", "clean " + r31 + " failed " + r38);
    L64:
        Result.m31boximpl(r37);
        return;
    L56:
        r113 = null;
    L59:
        th = move-exception;
        Result.Companion r39 = Result.Companion;
        r37 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L61
    L70:
        return;
    L40:
        r28 = null;
        goto L41
    L36:
        r26 = null;
    L43:
        th = move-exception;
        Result.Companion r40 = Result.Companion;
        r29 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L45
    }

    private final UpdateTask n(String r10, long r11) {
        monitor-enter(this);
        UpdateTask r12 = this.f5123g.get(r10);     // Catch: Throwable -> L11
        if (r12 != null) goto L6;
    L7:
        UpdateTask r13 = new UpdateTask(r10, this.f5118b, this.f5117a, this.f5120d, this.f5121e);     // Catch: Throwable -> L11
        this.f5123g.put(r10, r13);     // Catch: Throwable -> L11
        r12 = r13;
    L9:
        monitor-exit(this);
        return r12;
    L6:
        if (u(r10, r11) == false) goto L9;
    L11:
        th = move-exception;
        throw th;
    }

    private final UpdateTask p(String r10) {
        monitor-enter(this);
        UpdateTask r11 = this.f5123g.get(r10);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r11;
    L6:
        th = move-exception;
        throw th;
    }

    private final boolean s() {
        monitor-enter(this);
        Collection<UpdateTask> r10 = this.f5123g.values();     // Catch: Throwable -> L21
        boolean r11 = true;
        if ((r10 instanceof Collection) == true) goto L6;
    L8:
        Iterator<T> r12 = r10.iterator();     // Catch: Throwable -> L21
    L9:
        if (r12.hasNext() == false) goto L7;
        UpdateTask r13 = (UpdateTask) r12.next();     // Catch: Throwable -> L21
        UpdateResult r14 = r13.H();     // Catch: Throwable -> L21
        r0<UpdateResult> r15 = r13.F();     // Catch: Throwable -> L21
        if (r15 != null) goto L14;
    L16:
        boolean r16 = false;
    L18:
        if (PackageUpdaterKt.j(r14, r16) == false) goto L9;
    L19:
        monitor-exit(this);
        return r11;
    L14:
        if (r15.isActive() != true) goto L16;
        r16 = true;
    L7:
        r11 = false;
        goto L19
    L6:
        if (r10.isEmpty() == false) goto L8;
    L21:
        th = move-exception;
        throw th;
    }

    private final boolean u(String r10, long r11) {
        UpdateTask r12 = p(r10);
        boolean r13 = false;
        if (r12 == null) goto L8;
        if (r12.L(r11) == true) goto L8;
        r13 = true;
    L8:
        return !r13;
    }

    private final String x(Map<String, UpdateResult> r12) {
        Collection<UpdateResult> r11 = r12.values();
        int r10 = 0;
        if ((r11 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r13 = r11.iterator();
    L9:
        if (r13.hasNext() == false) goto L15;
        if (((UpdateResult) r13.next()).getSuccess() == false) goto L9;
        r10 = r10 + 1;
        if (r10 >= 0) goto L9;
        CollectionsKt.throwCountOverflow();
    L15:
        Collection<UpdateResult> r14 = r12.values();
        ArrayList r15 = new ArrayList();
        Iterator<T> r16 = r14.iterator();
    L17:
        if (r16.hasNext() == false) goto L22;
        Object r17 = r16.next();
        if (((UpdateResult) r17).getSuccess() == true) goto L17;
        r15.add(r17);
        goto L17
    L22:
        return "resultCount=" + r12.size() + " success=" + r10 + " failed=" + (r12.size() - r10) + " failureSummary=[" + CollectionsKt.joinToString$default(r15, null, null, null, 5, null, PackageUpdater$summarizeUpdateResults$failureSummary$2.INSTANCE, 23, null) + ']';
    L5:
        if (r11.isEmpty() == false) goto L7;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object z(PackageUpdater r10, List r11, b r12, String r13, Continuation r14, int r15, Object r16) {
        if ((r15 & 1) == 0) goto L6;
        r11 = CollectionsKt.emptyList();
    L6:
        if ((r15 & 4) == 0) goto L9;
        r13 = "";
    L9:
        return r10.y(r11, r12, r13, r14);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:226:0x07eb -> B:227:0x07f1). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:238:0x081a -> B:239:0x081b). Please report as a decompilation issue!!! */
    public final Object A(List<String> r46, b r47, String r48, Continuation<? super m> r49) {
        final PackageUpdater r10 = this;
        final b r11 = r47;
        String r12 = r48;
        if ((r49 instanceof PackageUpdater$updateWithExecutionResult$1) == false) goto L7;
        PackageUpdater$updateWithExecutionResult$1 r13 = (PackageUpdater$updateWithExecutionResult$1) r49;
        int r14 = r13.label;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L7;
        r13.label = r14 - Integer.MIN_VALUE;
    L8:
        PackageUpdater$updateWithExecutionResult$1 r15 = r13;
        Object r16 = r15.result;
        Object r17 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r18 = r15.label;
        String r19 = " updateAll=";
        if (r18 != 0) goto L11;
        ResultKt.throwOnFailure(r16);
        com.obric.aikernel.runtime.utils.d r20 = com.obric.aikernel.runtime.utils.d.f5417a;
        r20.i("PackageUpdater", "updateWithExecutionResult start caller=" + r47.b() + " updateAll=" + r47.g() + " background=" + r47.a() + " onlyDownload=" + r47.d() + " onlyFetchConfig=" + r47.e() + " force=" + r47.c() + " bizCount=" + r46.size() + " loraType=" + r12);
        StringBuilder r21 = new StringBuilder();
        if (r47.g() == false) goto L22;
        String r22 = "all";
    L23:
        String r23 = r22;
        final CoroutineContext r24 = r15.getContext();
        long r25 = SystemClock.elapsedRealtime();
        Object r110 = r17;
        PackageUpdater$updateWithExecutionResult$1 r111 = r15;
        Map<String, MetadataRequest.b> r26 = g(r46, r48, r47, r25, r24, r21);
        if (r48.length() <= 0) goto L26;
        boolean r27 = true;
    L27:
        if (r27 == false) goto L29;
        String r28 = r12;
    L30:
        r21.append("loraType:" + r28);
        PackageResourceManager.PresmConfig.e r29 = r10.f5117a.getConfig().getUpdateListener();
        if (r29 == null) goto L33;
        kotlinx.coroutines.h.d(r10.f5118b, null, null, new PackageUpdater$updateWithExecutionResult$4$1(r29, r47, r21, r23, null), 3, null);
    L33:
        Function2<UpdateTask, UpdateTaskConfig, Unit> r30 = new PackageUpdater$updateWithExecutionResult$addNewTaskConfig$1(r10, r11, r24);
        LinkedHashSet r31 = new LinkedHashSet();
        List<String> r112 = r46;
        r31.addAll(r112);
        Ref.ObjectRef r32 = new Ref.ObjectRef();
        if (r47.d() == true) goto L187;
        StringBuilder r33 = new StringBuilder();
        r33.append("updateWithExecutionResult metadata request start caller=");
        r33.append(r47.b());
        r33.append(" updateType=");
        r33.append(r23);
        r33.append(" requestBiz=");
        String r41 = " onlyDownload=";
        r33.append(CollectionsKt.joinToString$default(r46, null, null, null, 10, null, null, 55, null));
        r33.append(" loraType=");
        r33.append(r12);
        r20.i("PackageUpdater", r33.toString());
        MetadataRequest r34 = new MetadataRequest(r10.f5117a);
        boolean r35 = r47.g();
        b8.a r36 = r10.f5119c;
        r111 = r111;
        r111.L$0 = r10;
        r111.L$1 = r112;
        r111.L$2 = r11;
        r111.L$3 = r12;
        r111.L$4 = r24;
        Function2<UpdateTask, UpdateTaskConfig, Unit> r37 = r30;
        r111.L$5 = r37;
        Set r38 = r31;
        r111.L$6 = r38;
        Ref.ObjectRef r39 = r32;
        r111.L$7 = r39;
        r111.L$8 = r39;
        long r113 = r25;
        r111.J$0 = r113;
        r111.I$0 = 0;
        r111.label = 1;
        Object r40 = r34.t(r35, r26, r36, r111);
        r110 = r110;
        if (r40 != r110) goto L38;
        return r110;
    L38:
        CoroutineContext r42 = r24;
        Ref.ObjectRef r43 = r39;
        int r44 = 0;
        PackageUpdater r45 = r10;
        T r50 = r40;
    L39:
        r39.element = r50;
        Map<String, List<UpdateTaskConfig>> r51 = ((com.obric.aikernel.res.update.d) r43.element).a();
        com.obric.aikernel.runtime.utils.d r52 = com.obric.aikernel.runtime.utils.d.f5417a;
        int r410 = r44;
        StringBuilder r53 = new StringBuilder();
        CoroutineContext r411 = r42;
        r53.append("updateWithExecutionResult metadata request end caller=");
        r53.append(r11.b());
        r53.append(" success=");
        r53.append(((com.obric.aikernel.res.update.d) r43.element).d());
        r53.append(" packageConfigCount=");
        List<UpdateTaskConfig> r114 = r51.get("package");
        if (r114 == null) goto L42;
        int r54 = r114.size();
    L43:
        r53.append(r54);
        r53.append(" loraConfigCount=");
        List<UpdateTaskConfig> r115 = r51.get("lora");
        if (r115 == null) goto L46;
        int r55 = r115.size();
    L47:
        r53.append(r55);
        r52.i("PackageUpdater", r53.toString());
        if (r11.e() == true) goto L50;
        List<UpdateTaskConfig> r56 = r51.get("package");
        String r57 = " error: ";
        if (r56 == null) goto L90;
        Iterator r58 = r56.iterator();
    L62:
        if (r58.hasNext() == false) goto L89;
        Ref.ObjectRef r116 = r43;
        UpdateTaskConfig r59 = (UpdateTaskConfig) r58.next();
        Result.Companion r60 = Result.Companion;     // Catch: Throwable -> L81
        if (r11.g() == false) goto L67;
    L70:
        UpdateTask r61 = r45.n(r59.g(), r113);     // Catch: Throwable -> L81
        com.obric.aikernel.runtime.utils.d r210 = com.obric.aikernel.runtime.utils.d.f5417a;     // Catch: Throwable -> L81
        Iterator r412 = r58;
        StringBuilder r62 = new StringBuilder();     // Catch: Throwable -> L79
        r62.append("update package config: ");     // Catch: Throwable -> L77
        r62.append(r59);     // Catch: Throwable -> L77
        r62.append(" task:");     // Catch: Throwable -> L77
        r62.append(r61);     // Catch: Throwable -> L77
        com.obric.aikernel.runtime.utils.c.a.a(r210, "PackageUpdater", r62.toString(), 0, 4, null);     // Catch: Throwable -> L77
        r37.invoke(r61, r59);     // Catch: Throwable -> L77
        r38.add(r59.g());     // Catch: Throwable -> L77
    L259:
        Object r63 = Result.m32constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L77
    L85:
        Throwable r64 = Result.m35exceptionOrNullimpl(r63);
        if (r64 == null) goto L88;
        com.obric.aikernel.runtime.utils.d.f5417a.e("PackageUpdater", "process config " + r59 + " error: " + r64);
    L88:
        r58 = r412;
        r43 = r116;
        r112 = r112;
    L77:
        th = th;
    L84:
        Result.Companion r65 = Result.Companion;
        r63 = Result.m32constructorimpl(ResultKt.createFailure(th));
    L79:
        th = th;
    L83:
        r112 = r112;
        goto L84
    L67:
        if (r112.contains(r59.g()) == true) goto L70;
        r412 = r58;
    L81:
        th = th;
        r412 = r58;
        goto L83
    L89:
        Ref.ObjectRef r117 = r43;
        Unit r66 = Unit.INSTANCE;
    L91:
        List<UpdateTaskConfig> r67 = r51.get("lora");
        if (r67 == null) goto L186;
        Iterator r68 = r67.iterator();
    L95:
        if (r68.hasNext() == false) goto L184;
        UpdateTaskConfig r69 = (UpdateTaskConfig) r68.next();
        Result.Companion r70 = Result.Companion;     // Catch: Throwable -> L174
        Intrinsics.checkNotNull(r69, "null cannot be cast to non-null type com.obric.aikernel.res.metadata.config.LoraConfig");     // Catch: Throwable -> L174
        LoraConfig r71 = (LoraConfig) r69;     // Catch: Throwable -> L174
        Pair<Lora, AIPackage> r72 = Lora.f5072s.a(((LoraConfig) r69).t(), r69.g(), r45.f5117a);     // Catch: Throwable -> L174
        if (r11.g() == false) goto L101;
        if (r72 == null) goto L101;
        boolean r73 = true;
    L102:
        boolean r74 = Intrinsics.areEqual(r12, r69.g());     // Catch: Throwable -> L174
        if (r73 == true) goto L109;
        if (r74 == true) goto L109;
        if (((LoraConfig) r69).p() == true) goto L109;
        boolean r75 = false;
    L110:
        com.obric.aikernel.runtime.utils.d r118 = com.obric.aikernel.runtime.utils.d.f5417a;     // Catch: Throwable -> L174
        Iterator r413 = r68;
        StringBuilder r76 = new StringBuilder();     // Catch: Throwable -> L172
        String r414 = r57;
        r76.append("update lora decision ");     // Catch: Throwable -> L170
        r76.append(r69.g());     // Catch: Throwable -> L170
        r76.append('@');     // Catch: Throwable -> L170
        r76.append(r69.i());     // Catch: Throwable -> L170
        String r77 = r19;
        r76.append(r77);     // Catch: Throwable -> L168
        r19 = r77;
        r76.append(r11.g());     // Catch: Throwable -> L170
        r76.append(" matchedCurrentLora=");     // Catch: Throwable -> L170
        if (r72 == null) goto L121;
        boolean r78 = true;
    L122:
        r76.append(r78);     // Catch: Throwable -> L170
        r76.append(" matchedParent=");     // Catch: Throwable -> L170
        if (r72 == null) goto L127;
        AIPackage r79 = r72.getSecond();     // Catch: Throwable -> L170
        if (r79 == null) goto L127;
        String r80 = r79.w();     // Catch: Throwable -> L170
    L128:
        r76.append(r80);     // Catch: Throwable -> L170
        r76.append('@');     // Catch: Throwable -> L170
        if (r72 == null) goto L133;
        AIPackage r81 = r72.getSecond();     // Catch: Throwable -> L170
        if (r81 == null) goto L133;
        String r82 = r81.D();     // Catch: Throwable -> L170
    L134:
        r76.append(r82);     // Catch: Throwable -> L170
        r76.append(" matchedLora=");     // Catch: Throwable -> L170
        if (r72 == null) goto L139;
        Lora r83 = r72.getFirst();     // Catch: Throwable -> L170
        if (r83 == null) goto L139;
        String r84 = r83.w();     // Catch: Throwable -> L170
    L140:
        r76.append(r84);     // Catch: Throwable -> L170
        r76.append('@');     // Catch: Throwable -> L170
        if (r72 == null) goto L145;
        Lora r85 = r72.getFirst();     // Catch: Throwable -> L170
        if (r85 == null) goto L145;
        String r86 = r85.D();     // Catch: Throwable -> L170
    L146:
        r76.append(r86);     // Catch: Throwable -> L170
        r76.append(" loraTypeMatch=");     // Catch: Throwable -> L170
        if (r74 == false) goto L149;
        boolean r87 = true;
    L150:
        r76.append(r87);     // Catch: Throwable -> L170
        r76.append(" requestLoraType=");     // Catch: Throwable -> L170
        r76.append(r12);     // Catch: Throwable -> L170
        r76.append(" autoDownload=");     // Catch: Throwable -> L170
        r76.append(((LoraConfig) r69).p());     // Catch: Throwable -> L170
        r76.append(" action=");     // Catch: Throwable -> L170
        if (r75 == false) goto L153;
        String r88 = "enqueue_task";
    L154:
        r76.append(r88);     // Catch: Throwable -> L170
        r76.append(' ');     // Catch: Throwable -> L166
        r76.append(((LoraConfig) r69).n());     // Catch: Throwable -> L166
        r118.d("PackageUpdater", r76.toString());     // Catch: Throwable -> L166
        if (r75 == false) goto L159;
        UpdateTask r89 = r45.n(r69.g(), r113);     // Catch: Throwable -> L166
        r118.d("PackageUpdater", "update lora config enqueue " + r69.g() + '@' + r69.i() + " task=" + r89);     // Catch: Throwable -> L166
        r37.invoke(r89, r69);     // Catch: Throwable -> L166
        Object r90 = Boxing.boxBoolean(r38.add(r69.g()));     // Catch: Throwable -> L166
    L255:
        Object r91 = Result.m32constructorimpl(r90);     // Catch: Throwable -> L164
    L179:
        Throwable r92 = Result.m35exceptionOrNullimpl(r91);
        if (r92 == null) goto L182;
        com.obric.aikernel.runtime.utils.d r93 = com.obric.aikernel.runtime.utils.d.f5417a;
        StringBuilder r94 = new StringBuilder();
        r94.append("process config ");
        r94.append(r69);
        String r95 = r414;
        r94.append(r95);
        r94.append(r92);
        r93.e("PackageUpdater", r94.toString());
    L183:
        r68 = r413;
        r57 = r95;
        goto L95
    L182:
        r95 = r414;
    L164:
        th = th;
    L178:
        Result.Companion r96 = Result.Companion;
        r91 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L179
    L159:
        r118.d("PackageUpdater", "update lora config saveConfigOnly " + r69.g() + '@' + r69.i());     // Catch: Throwable -> L166
        new Lora(r69.g(), r69.i(), r45.f5117a.getConfig()).b0(r69, true);     // Catch: Throwable -> L164
        r90 = Unit.INSTANCE;     // Catch: Throwable -> L164
    L166:
        th = th;
        goto L178
    L153:
        r88 = "save_config_only";
        goto L154
    L149:
        r87 = false;
    L145:
        r86 = null;
    L139:
        r84 = null;
    L133:
        r82 = null;
    L127:
        r80 = null;
        goto L128
    L121:
        r78 = false;
    L168:
        th = th;
        r19 = r77;
    L170:
        th = th;
    L172:
        th = th;
    L176:
        r414 = r57;
    L109:
        r75 = true;
    L101:
        r73 = false;
    L174:
        th = th;
        r413 = r68;
        goto L176
    L184:
        Unit r97 = Unit.INSTANCE;
    L186:
        CoroutineContext r98 = r411;
        r10 = r45;
        Set r99 = r38;
        Ref.ObjectRef r100 = r117;
        int r101 = r410;
    L188:
        com.obric.aikernel.runtime.utils.d r102 = com.obric.aikernel.runtime.utils.d.f5417a;
        r102.i("PackageUpdater", "updateWithExecutionResult prepared targets caller=" + r11.b() + " targetCount=" + r99.size() + " targets=" + CollectionsKt.joinToString$default(r99, null, null, null, 15, null, null, 55, null));
        StringBuilder r103 = new StringBuilder();
        r103.append("updateWithExecutionResult awaitAll start caller=");
        r103.append(r11.b());
        r103.append(" targetCount=");
        r103.append(r99.size());
        r102.i("PackageUpdater", r103.toString());
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r99, 10));
        Iterator r105 = r99.iterator();
    L190:
        if (r105.hasNext() == false) goto L192;
        r104.add(kotlinx.coroutines.h.b(r10.f5118b, null, null, new PackageUpdater$updateWithExecutionResult$result$1$1(r10, (String) r105.next(), r11, r98, null), 3, null));
        goto L190
    L192:
        PackageUpdater$updateWithExecutionResult$1 r106 = r111;
        r106.L$0 = r10;
        r106.L$1 = r11;
        r106.L$2 = r100;
        Continuation r107 = null;
        r106.L$3 = null;
        r106.L$4 = null;
        r106.L$5 = null;
        r106.L$6 = null;
        r106.L$7 = null;
        r106.L$8 = null;
        r106.I$0 = r101;
        r106.label = 2;
        Object r108 = AwaitKt.a(r104, r106);
        Object r109 = r110;
        if (r108 != r109) goto L195;
        return r109;
    L195:
        PackageUpdater r119 = r10;
        int r120 = r101;
        r16 = r108;
        b r121 = r11;
    L196:
        Iterable r122 = (Iterable) r16;
        Map r123 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r122, 10)), 16));
        Iterator r124 = r122.iterator();
        b r125 = r121;
        r17 = r109;
        r15 = r106;
        PackageUpdater r126 = r119;
    L198:
        if (r124.hasNext() == false) goto L243;
        Object r127 = r124.next();
        UpdateResult r128 = (UpdateResult) r127;
        if (PackageUpdaterKt.p(r128, r125.a()) == false) goto L228;
        UpdateTask r129 = r126.p(r128.getBiz());
        com.obric.aikernel.runtime.utils.d r130 = com.obric.aikernel.runtime.utils.d.f5417a;
        StringBuilder r131 = new StringBuilder();
        r131.append("updateWithExecutionResult foreground retry start caller=");
        r131.append(r125.b());
        r131.append(" result=");
        r131.append(PackageUpdaterKt.s(r128));
        r131.append(" taskActive=");
        if (r129 == null) goto L206;
        r0<UpdateResult> r132 = r129.F();
        if (r132 == null) goto L206;
        Object r133 = Boxing.boxBoolean(r132.isActive());
    L207:
        r131.append(r133);
        r131.append(" taskResult=");
        if (r129 == null) goto L212;
        UpdateResult r134 = r129.H();
        if (r134 == null) goto L212;
        String r135 = PackageUpdaterKt.s(r134);
    L213:
        r131.append(r135);
        r130.i("PackageUpdater", r131.toString());
        if (r129 == null) goto L216;
        r129.P(r125);
        Unit r136 = Unit.INSTANCE;
    L216:
        String r137 = r128.getBiz();
        if (r129 == null) goto L222;
        UpdateResult r138 = r129.H();
        if (r138 == null) goto L222;
        UpdateResult r139 = r138;
    L223:
        PackageUpdater$updateWithExecutionResult$result$2$2 r140 = new PackageUpdater$updateWithExecutionResult$result$2$2(r129, r128, r125, r107);
        r15.L$0 = r126;
        r15.L$1 = r125;
        r15.L$2 = r100;
        r15.L$3 = r123;
        r15.L$4 = r124;
        r15.L$5 = r127;
        r15.L$6 = r123;
        r15.I$0 = r120;
        r15.label = 3;
        Object r141 = PackageUpdaterKt.a(r137, r125, r139, "foreground_retry", r140, r15);
        if (r141 != r17) goto L226;
        return r17;
    L226:
        Map r142 = r123;
        Iterator r143 = r124;
        r16 = r141;
        PackageUpdater r144 = r126;
    L227:
        Map r415 = r142;
        r128 = (UpdateResult) r16;
        r124 = r143;
        Map r145 = r415;
        PackageUpdater r146 = r144;
    L239:
        com.obric.aikernel.runtime.utils.d.f5417a.i("PackageUpdater", "updateWithExecutionResult target final caller=" + r125.b() + ' ' + PackageUpdaterKt.s(r128));
        PackageResourceManager.PresmConfig.e r147 = r146.f5117a.getConfig().getUpdateListener();
        if (r147 == null) goto L242;
        kotlinx.coroutines.h.d(r146.f5118b, null, null, new PackageUpdater$updateWithExecutionResult$result$2$5$1$1(r147, r128, r107), 3, null);
        Unit r148 = Unit.INSTANCE;
    L242:
        r123.put(r128.getBiz(), r127);
        r123 = r145;
        r126 = r146;
    L222:
        r139 = r128;
    L212:
        r135 = r107;
    L206:
        r133 = r107;
        goto L207
    L228:
        com.obric.aikernel.res.update.d r149 = (com.obric.aikernel.res.update.d) r100.element;
        if (r149 == null) goto L238;
        MetadataRequestException r150 = r149.b();
        if (r150 == null) goto L238;
        MetadataRequestException r151 = r150;
        if (PackageUpdaterKt.o(r128, (com.obric.aikernel.res.update.d) r100.element) == true) goto L236;
        r151 = r107;
    L236:
        if (r151 == 0) goto L238;
        PackageUpdaterKt.k(r128, r151);
        Unit r152 = Unit.INSTANCE;
    L238:
        r145 = r123;
        r146 = r126;
        goto L239
    L243:
        com.obric.aikernel.runtime.utils.d r153 = com.obric.aikernel.runtime.utils.d.f5417a;
        r153.i("PackageUpdater", "updateWithExecutionResult awaitAll end caller=" + r125.b() + ' ' + r126.x(r123));
        boolean r154 = r125.d();
        if (r126.f5117a.getConfig().getUseObricDownloader() == false) goto L246;
        File r155 = new File("/data/download_server");
    L247:
        r126.l(r154, r155);
        r153.i("PackageUpdater", "updateWithExecutionResult clean done caller=" + r125.b() + r41 + r125.d());
        return new m(r123, (com.obric.aikernel.res.update.d) r100.element, r120);
    L246:
        r155 = r107;
        goto L247
    L90:
        r117 = r43;
        goto L91
    L50:
        if (((com.obric.aikernel.res.update.d) r43.element).d() == false) goto L55;
        File r156 = new File(r45.f5120d, "packages");
        List<UpdateTaskConfig> r157 = r51.get("package");
        if (r157 != null) goto L54;
        r157 = CollectionsKt.emptyList();
    L54:
        int r158 = PackageUpdaterKt.b(r156, r157);
    L56:
        r52.i("PackageUpdater", "updateWithExecutionResult onlyFetchConfig return caller=" + r11.b() + " cachedPackageCount=" + r158);
        return new m(MapsKt.emptyMap(), (com.obric.aikernel.res.update.d) r43.element, r158);
    L55:
        r158 = r410;
        goto L56
    L46:
        r55 = 0;
        goto L47
    L42:
        r54 = 0;
        goto L43
    L187:
        r100 = r32;
        r41 = " onlyDownload=";
        r98 = r24;
        r99 = r31;
        r101 = 0;
        goto L188
    L29:
        r28 = null;
        goto L30
    L26:
        r27 = false;
        goto L27
    L22:
        r22 = "specific";
        goto L23
    L11:
        if (r18 == 1) goto L18;
        if (r18 == 2) goto L17;
        if (r18 != 3) goto L16;
        r120 = r15.I$0;
        Map r159 = (Map) r15.L$6;
        r127 = r15.L$5;
        r143 = (Iterator) r15.L$4;
        r142 = (Map) r15.L$3;
        r100 = (Ref.ObjectRef) r15.L$2;
        r125 = (b) r15.L$1;
        PackageUpdater r160 = (PackageUpdater) r15.L$0;
        ResultKt.throwOnFailure(r16);
        r41 = " onlyDownload=";
        r123 = r159;
        r107 = null;
        r144 = r160;
        goto L227
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        r120 = r15.I$0;
        Ref.ObjectRef r161 = (Ref.ObjectRef) r15.L$2;
        r121 = (b) r15.L$1;
        PackageUpdater r162 = (PackageUpdater) r15.L$0;
        ResultKt.throwOnFailure(r16);
        r100 = r161;
        r119 = r162;
        r41 = " onlyDownload=";
        r106 = r15;
        r109 = r17;
        r107 = null;
        goto L196
    L18:
        int r163 = r15.I$0;
        long r164 = r15.J$0;
        Ref.ObjectRef r165 = (Ref.ObjectRef) r15.L$8;
        r43 = (Ref.ObjectRef) r15.L$7;
        Set r166 = (Set) r15.L$6;
        Function2<UpdateTask, UpdateTaskConfig, Unit> r167 = (Function2) r15.L$5;
        CoroutineContext r168 = (CoroutineContext) r15.L$4;
        String r169 = (String) r15.L$3;
        b r170 = (b) r15.L$2;
        List<String> r171 = (List) r15.L$1;
        PackageUpdater r172 = (PackageUpdater) r15.L$0;
        ResultKt.throwOnFailure(r16);
        r41 = " onlyDownload=";
        r39 = r165;
        r42 = r168;
        r110 = r17;
        r37 = r167;
        r44 = r163;
        r112 = r171;
        r45 = r172;
        r50 = r16;
        r38 = r166;
        r111 = r15;
        r113 = r164;
        r12 = r169;
        r11 = r170;
    L7:
        r13 = new PackageUpdater$updateWithExecutionResult$1(r10, r49);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void i(boolean r24) {
        PackageUpdater r10 = this;
        if (r10.f5117a.getConfig().getUseObricDownloader() == false) goto L5;
        File r11 = new File("/data/download_server");
    L6:
        File r12 = new File(r10.f5120d, "packages");
        com.obric.aikernel.runtime.utils.d r13 = com.obric.aikernel.runtime.utils.d.f5417a;
        StringBuilder r14 = new StringBuilder();
        r14.append("clean start all=");
        r14.append(r24);
        r14.append(" packagesExists=");
        r14.append(r12.exists());
        r14.append(" packages=");
        int r15 = 0;
        r14.append(PackageUpdaterKt.f(r12, 0, 2, null));
        r14.append(" activeDownloadJob=");
        r14.append(s());
        String r16 = "PackageUpdater";
        r13.i("PackageUpdater", r14.toString());
        File[] r17 = r12.listFiles();
        int r18 = 1;
        if (r17 == null) goto L71;
        Intrinsics.checkNotNullExpressionValue(r17, "listFiles()");
        int r19 = r17.length;
        int r110 = 0;
        PackageUpdater r20 = r10;
    L9:
        if (r110 >= r19) goto L71;
        File r111 = r17[r110];
        String r112 = r111.getName();
        UpdateTask.a r21 = UpdateTask.f5132m;
        File r113 = r20.f5120d;
        Intrinsics.checkNotNullExpressionValue(r112, ActivityLifecycle.NAME);
        UpdateTaskConfig r114 = r21.c(r113, r112, r20.f5117a.getConfig());
        com.obric.aikernel.res.metadata.data.b.a r22 = com.obric.aikernel.res.metadata.data.b.f5079l;
        Intrinsics.checkNotNullExpressionValue(r111, "pkgRoot");
        DistConfig r115 = r22.a("package", r112, r111);
        if (r115 == null) goto L15;
        String r23 = r115.i();
        if (r23 == null) goto L15;
        int r25 = AIPackage.f5062u.b(r23);
    L16:
        AIPackage r116 = r20.f5117a.getMetadataCtrl$resource_manager_release().q(r112);
        if (r116 == null) goto L21;
        String r26 = r116.D();
        if (r26 == null) goto L21;
        int r27 = AIPackage.f5062u.b(r26);
    L22:
        if (r116 != null) goto L24;
    L26:
        int r28 = r15;
    L27:
        File[] r117 = r17;
        int r118 = r19;
        File r119 = r11;
        int r29 = r110;
        if (r28 == 0) goto L57;
        if (r27 >= r25) goto L93;
        com.obric.aikernel.runtime.utils.d r30 = com.obric.aikernel.runtime.utils.d.f5417a;
        StringBuilder r31 = new StringBuilder();
        r31.append("clean pending package dir keep biz=");
        r31.append(r112);
        r31.append(" path=");
        r31.append(r111.getPath());
        r31.append(" pendingCfg=");
        r31.append(PackageUpdaterKt.d(r114));
        r31.append(" packageCfg=");
        r31.append(PackageUpdaterKt.d(r115));
        r31.append(" current=");
        r31.append(r116.D());
        r31.append('@');
        r31.append(r116.t());
        r31.append(" currentVersionCode=");
        r31.append(r27);
        r31.append(" targetVersionCode=");
        r31.append(r25);
        String r32 = " reason=current_version_lt_pending";
    L56:
        r31.append(r32);
        r30.d(r16, r31.toString());
    L70:
        r110 = r29 + 1;
        r17 = r117;
        r19 = r118;
        r11 = r119;
        r18 = 1;
        r15 = 0;
        r20 = this;
        goto L9
    L93:
        Result.Companion r33 = Result.Companion;     // Catch: Throwable -> L32
        Object r34 = Result.m32constructorimpl(Boolean.valueOf(FilesKt.deleteRecursively(r111)));     // Catch: Throwable -> L32
    L35:
        if (Result.m39isSuccessimpl(r34) == false) goto L52;
        boolean r35 = ((Boolean) r34).booleanValue();
        if (r35 == false) goto L49;
        j r36 = r20.f5121e;
        if (r114 == null) goto L45;
        String r210 = r114.h();
        if (r210 == null) goto L45;
    L43:
        String r37 = r210;
    L48:
        r36.f(r37, r112, 1);
    L50:
        r16 = r16;
        com.obric.aikernel.runtime.utils.d.f5417a.i(r16, "clean pending package dir delete biz=" + r112 + " path=" + r111.getPath() + " deleted=" + r35 + " exists=" + r111.exists() + " pendingCfg=" + PackageUpdaterKt.d(r114) + " packageCfg=" + PackageUpdaterKt.d(r115) + " current=" + r116.D() + '@' + r116.t() + " currentVersionCode=" + r27 + " targetVersionCode=" + r25 + " reason=current_version_ge_pending");
    L45:
        if (r115 == null) goto L47;
        r210 = r115.h();
        goto L43
    L47:
        r37 = null;
        goto L48
    L49:
        r16 = r16;
    L52:
        Throwable r38 = Result.m35exceptionOrNullimpl(r34);
        if (r38 == null) goto L70;
        com.obric.aikernel.runtime.utils.d.f5417a.l(r16, "clean pending package dir delete failed biz=" + r112 + " path=" + r111.getPath() + " pendingCfg=" + PackageUpdaterKt.d(r114) + " packageCfg=" + PackageUpdaterKt.d(r115) + " current=" + r116.D() + '@' + r116.t() + " currentVersionCode=" + r27 + " targetVersionCode=" + r25 + ' ' + r38);
    L32:
        th = move-exception;
        Result.Companion r39 = Result.Companion;
        r34 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L35
    L57:
        r30 = com.obric.aikernel.runtime.utils.d.f5417a;
        r31 = new StringBuilder();
        r31.append("clean pending package dir keep biz=");
        r31.append(r112);
        r31.append(" path=");
        r31.append(r111.getPath());
        r31.append(" pendingCfg=");
        r31.append(PackageUpdaterKt.d(r114));
        r31.append(" packageCfg=");
        r31.append(PackageUpdaterKt.d(r115));
        r31.append(" current=");
        if (r116 == null) goto L60;
        String r40 = r116.D();
    L61:
        r31.append(r40);
        r31.append('@');
        if (r116 == null) goto L64;
        String r41 = r116.t();
    L65:
        r31.append(r41);
        r31.append(" currentAvailable=");
        if (r116 == null) goto L68;
        Boolean r42 = Boolean.valueOf(r116.H());
    L69:
        r31.append(r42);
        r31.append(" currentVersionCode=");
        r31.append(r27);
        r31.append(" targetVersionCode=");
        r31.append(r25);
        r32 = " reason=current_unavailable";
        goto L56
    L68:
        r42 = null;
        goto L69
    L64:
        r41 = null;
        goto L65
    L60:
        r40 = null;
        goto L61
    L24:
        if (r116.H() != r18) goto L26;
        r28 = r18;
    L21:
        r27 = r15;
    L15:
        r25 = r15;
    L71:
        File r43 = r11;
        boolean r44 = r15;
        l(r44, r43);
        if (r24 == true) goto L74;
        return;
    L74:
        File[] r45 = new File[2];
        r45[r44 ? 1 : 0] = this.f5120d;
        r45[1] = r43;
        Iterator r46 = CollectionsKt.listOf(r45).iterator();
    L76:
        if (r46.hasNext() == false) goto L92;
        File r47 = (File) r46.next();
        if (r47 == null) goto L76;
        String[] r48 = r47.list(k.f5213a);
        if (r48 == null) goto L76;
        int r49 = r48.length;
        int r50 = r44 ? 1 : 0;
    L82:
        if (r50 >= r49) goto L76;
        File r51 = new File(this.f5120d, r48[r50]);
        String[] r52 = r51.list();
        if (r52 == null) goto L91;
        Intrinsics.checkNotNullExpressionValue(r52, "list()");
        int r53 = r52.length;
        int r54 = r44 ? 1 : 0;
    L86:
        if (r54 >= r53) goto L91;
        File r120 = new File(r51, r52[r54]);
        StorageCleanerDaemon.a r121 = StorageCleanerDaemon.f5102e;
        PackageResourceManager.PresmConfig r122 = this.f5117a.getConfig();
        String r123 = r120.getPath();
        Intrinsics.checkNotNullExpressionValue(r123, "file.path");
        if (r121.c(r122, r123) == false) goto L90;
        FilesKt.deleteRecursively(r120);
    L90:
        r54 = r54 + 1;
    L91:
        r50 = r50 + 1;
        goto L82
    L92:
        return;
    L5:
        r11 = null;
        goto L6
    }

    public final List<com.obric.aikernel.res.metadata.config.e> m() {
        LinkedHashSet r10 = new LinkedHashSet();
        r10.addAll(this.f5117a.getMetadataCtrl$resource_manager_release().o());
        String[] r11 = new File(this.f5120d, "packages").list();
        if (r11 == null) goto L5;
        CollectionsKt.addAll(r10, r11);
    L5:
        ArrayList r12 = new ArrayList();
        Iterator r13 = r10.iterator();
    L7:
        if (r13.hasNext() == false) goto L14;
        String r14 = (String) r13.next();
        UpdateTaskConfig r15 = UpdateTask.f5132m.a(r14, this.f5120d, this.f5117a);
        if ((r15 instanceof com.obric.aikernel.res.metadata.config.e) == false) goto L11;
        com.obric.aikernel.res.metadata.config.e r16 = (com.obric.aikernel.res.metadata.config.e) r15;
    L12:
        if (r16 == null) goto L7;
        r12.add(r16);
        goto L7
    L11:
        r16 = null;
        goto L12
    L14:
        return r12;
    }

    public final com.obric.aikernel.res.metadata.config.e o(String r10) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        UpdateTaskConfig r11 = UpdateTask.f5132m.a(r10, this.f5120d, this.f5117a);
        if ((r11 instanceof com.obric.aikernel.res.metadata.config.e) == true) goto L7;
        return null;
    L7:
        return (com.obric.aikernel.res.metadata.config.e) r11;
    }

    public final UpdateResult q(String r18) {
        Intrinsics.checkNotNullParameter(r18, "biz");
        UpdateTask r10 = p(r18);
        if (r10 == null) goto L6;
        UpdateResult r11 = r10.H();
        if (r11 == null) goto L6;
        return r11;
    L6:
        UpdateTaskConfig r15 = UpdateTask.f5132m.a(r18, this.f5120d, this.f5117a);
        if (r15 == null) goto L9;
        UpdateResult r14 = new UpdateResult(r18, false, 0, null, false, 0, 0, null, 0, false, 1022, null);
        r14.setCfg(r15);
        return r14;
    L9:
        return null;
    }

    public final float r(String r10) {
        Intrinsics.checkNotNullParameter(r10, "biz");
        UpdateTask r11 = p(r10);
        if (r11 != null) goto L7;
        return 0.0f;
    L7:
        return r11.G();
    }

    public final void t() {
        com.obric.aikernel.runtime.utils.d r10 = com.obric.aikernel.runtime.utils.d.f5417a;
        r10.i("PackageUpdater", "init start rootDir=" + this.f5120d);
        this.f5122f.f();
        h();
        r10.i("PackageUpdater", "init end rootDir=" + this.f5120d);
    }

    /* JADX WARN: Type inference failed for: r12v0, types: [T, java.util.ArrayList] */
    public final Object v(com.google.gson.k r30, Continuation<? super Unit> r31) {
        PackageUpdater r10 = this;
        if ((r31 instanceof PackageUpdater$pushDebugDistribute$1) == false) goto L7;
        PackageUpdater$pushDebugDistribute$1 r11 = (PackageUpdater$pushDebugDistribute$1) r31;
        int r12 = r11.label;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r11.label = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r11.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r11.label;
        int r16 = 2;
        com.obric.aikernel.res.metadata.config.c r17 = null;
        if (r15 == 0) goto L20;
        if (r15 == 1) goto L19;
        if (r15 == 2) goto L18;
        if (r15 == 3) goto L17;
        if (r15 != 4) goto L16;
        Function0<Unit> r18 = (Function0) r11.L$1;
        PackageUpdater r19 = (PackageUpdater) r11.L$0;
        ResultKt.throwOnFailure(r13);
    L110:
        Process.sendSignal(Process.myPid(), 15);
        Function0<Unit> r20 = r18;
        r10 = r19;
    L111:
        a8.a.f122a.a(r10.f5117a.getConfig().getContext());
        r20.invoke();
    L113:
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r13);
    L89:
        Process.sendSignal(Process.myPid(), 15);
        goto L113
    L18:
        Ref.ObjectRef r21 = (Ref.ObjectRef) r11.L$2;
        Ref.BooleanRef r22 = (Ref.BooleanRef) r11.L$1;
        PackageUpdater r23 = (PackageUpdater) r11.L$0;
        ResultKt.throwOnFailure(r13);
    L75:
        final List r24 = (List) r13;
        Ref.ObjectRef r110 = r21;
        r10 = r23;
    L77:
        r20 = new PackageUpdater$pushDebugDistribute$loggerPushFinished$1(r24);
        if (r22.element == false) goto L90;
        PackageResourceManager.PresmConfig.c r25 = r10.f5117a.getConfig().getNativeLibLifeCycle();
        if (r25 == null) goto L86;
        Iterable r26 = (Iterable) r110.element;
        ArrayList r27 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r26, 10));
        Iterator r28 = r26.iterator();
    L83:
        if (r28.hasNext() == false) goto L85;
        r27.add(((com.obric.aikernel.res.metadata.config.e) r28.next()).g());
        goto L83
    L85:
        r25.b(r27);
    L86:
        r20.invoke();
        r11.L$0 = null;
        r11.L$1 = null;
        r11.L$2 = null;
        r11.label = 3;
        if (DelayKt.b(1000, r11) != r14) goto L89;
        return r14;
    L90:
        Iterator r29 = ((Iterable) r110.element).iterator();
    L92:
        if (r29.hasNext() == false) goto L96;
        Object r32 = r29.next();
        if (Intrinsics.areEqual(((com.obric.aikernel.res.metadata.config.e) r32).g(), "vlm_local") == false) goto L92;
    L98:
        if (((com.obric.aikernel.res.metadata.config.e) r32) == null) goto L111;
        PackageResourceManager.PresmConfig.c r33 = r10.f5117a.getConfig().getNativeLibLifeCycle();
        if (r33 == null) goto L106;
        Iterable r34 = (Iterable) r110.element;
        ArrayList r35 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r34, 10));
        Iterator r36 = r34.iterator();
    L103:
        if (r36.hasNext() == false) goto L105;
        r35.add(((com.obric.aikernel.res.metadata.config.e) r36.next()).g());
        goto L103
    L105:
        r33.b(r35);
    L106:
        r20.invoke();
        r11.L$0 = r10;
        r11.L$1 = r20;
        r11.L$2 = null;
        r11.label = 4;
        if (DelayKt.b(1000, r11) != r14) goto L109;
        return r14;
    L109:
        r19 = r10;
        r18 = r20;
        goto L110
    L96:
        r32 = null;
        goto L98
    L19:
        r10 = (PackageUpdater) r11.L$0;
        ResultKt.throwOnFailure(r13);
    L23:
        r22 = new Ref.BooleanRef();
        r110 = new Ref.ObjectRef();
        r110.element = new ArrayList();
        List r37 = (List) ((Map) r13).get("package");
        if (r37 == null) goto L76;
        ArrayList r111 = new ArrayList();
        Iterator r38 = r37.iterator();
    L27:
        if (r38.hasNext() == false) goto L71;
        DistConfig r112 = (DistConfig) r38.next();
        Intrinsics.checkNotNull(r112, "null cannot be cast to non-null type com.obric.aikernel.res.metadata.config.PackageConfig");
        com.obric.aikernel.res.metadata.config.e r113 = (com.obric.aikernel.res.metadata.config.e) r112;
        ((List) r110.element).add(r113);
        boolean r114 = r22.element;
        Iterator r115 = r113.l().iterator();
    L30:
        if (r115.hasNext() == false) goto L63;
        Object r116 = r115.next();
        DistConfig r39 = (DistConfig) r116;
        if ((r39 instanceof com.obric.aikernel.res.metadata.config.c) == false) goto L34;
        com.obric.aikernel.res.metadata.config.c r40 = (com.obric.aikernel.res.metadata.config.c) r39;
    L35:
        Iterator r210 = r38;
        if (r40 == null) goto L58;
        Iterator r310 = r115;
        if (StringsKt.startsWith$default(r40.g(), "native_", false, r16, r17) == false) goto L57;
        com.obric.aikernel.res.metadata.data.e r41 = new com.obric.aikernel.res.metadata.data.e(r40.g(), r40.i(), r10.f5117a.getConfig());
        DistConfig r42 = r41.s();
        if (r42 == null) goto L42;
        String r43 = new com.obric.aikernel.res.metadata.config.b(r42.g(), r42.f(), 0, false, 12, null).p();
    L43:
        com.obric.aikernel.res.metadata.config.b r44 = (com.obric.aikernel.res.metadata.config.b) CollectionsKt.firstOrNull(r39.d());
        if (r44 == null) goto L46;
        String r45 = r44.p();
    L47:
        if (r43 != null) goto L49;
    L51:
        boolean r117 = false;
    L52:
        com.obric.aikernel.runtime.utils.d r118 = com.obric.aikernel.runtime.utils.d.f5417a;
        StringBuilder r46 = new StringBuilder();
        Object r119 = r14;
        r46.append(r40.g());
        r46.append('@');
        r46.append(r40.i());
        r46.append(" md5 Changed:");
        r46.append(r117);
        r46.append(" installedMd5:");
        r46.append(r43);
        r46.append(" targetMd5:");
        r46.append(r45);
        r118.d("PackageUpdater", r46.toString());
        if (r117 == false) goto L55;
    L56:
        boolean r47 = true;
    L60:
        if (r47 == true) goto L64;
        r38 = r210;
        r115 = r310;
        r14 = r119;
        r16 = 2;
        r17 = null;
    L64:
        if (r116 == null) goto L66;
        boolean r48 = true;
    L67:
        r22.element = r114 | r48;
        com.obric.aikernel.runtime.utils.d.f5417a.h("PackageUpdater", r113.g(), r113.i(), "pushDebugDistribute 【推送开始】" + r113 + ", " + com.obric.aikernel.res.metadata.config.a.d(r113.f(), "version_debug") + ", nativeLibChanged: " + r22.element);
        UpdateTask r49 = new UpdateTask(r113.g(), r10.f5118b, r10.f5117a, r10.f5120d, r10.f5121e);
        r49.n(r11.getContext(), new b("push_debug", 200, false, true, false, false, false, 52, null));
        r49.N(r113);
        r0<UpdateResult> r50 = r49.F();
        if (r50 == null) goto L70;
        r111.add(r50);
    L70:
        r38 = r210;
        r14 = r119;
        r16 = 2;
        r17 = null;
        goto L27
    L66:
        r48 = false;
        goto L67
    L55:
        if (r41.g0() == false) goto L56;
    L59:
        r47 = false;
        goto L60
    L49:
        if (Intrinsics.areEqual(r43, r45) == true) goto L51;
        r117 = true;
        goto L52
    L46:
        r45 = null;
        goto L47
    L42:
        r43 = null;
        goto L43
    L57:
        r119 = r14;
        goto L59
    L58:
        r119 = r14;
        r310 = r115;
        goto L59
    L34:
        r40 = r17;
        goto L35
    L63:
        r210 = r38;
        r119 = r14;
        r116 = null;
        goto L64
    L71:
        r11.L$0 = r10;
        r11.L$1 = r22;
        r11.L$2 = r110;
        r11.label = 2;
        r13 = AwaitKt.a(r111, r11);
        if (r13 != r14) goto L74;
        return r14;
    L74:
        r23 = r10;
        r21 = r110;
        goto L75
    L76:
        r24 = null;
        goto L77
    L20:
        ResultKt.throwOnFailure(r13);
        MetadataRequest r51 = new MetadataRequest(r10.f5117a);
        r11.L$0 = r10;
        r11.label = 1;
        r13 = r51.q(r30, r11);
        if (r13 != r14) goto L23;
        return r14;
    L7:
        r11 = new PackageUpdater$pushDebugDistribute$1(r10, r31);
        goto L8
    }

    public final void w(final String r22) {
        Intrinsics.checkNotNullParameter(r22, "trigger");
        final long r10 = SystemClock.elapsedRealtime();
        boolean r11 = s();
        File r12 = new File(this.f5120d, "packages");
        NetworkUtil r13 = NetworkUtil.f5399a;
        boolean r14 = r13.e(this.f5117a.getConfig().getContext());
        if (r13.f(this.f5117a.getConfig().getContext()) == false) goto L5;
    L8:
        boolean r15 = true;
    L9:
        monitor-enter(this);
        Map r16 = MapsKt.toMutableMap(this.f5123g);     // Catch: Throwable -> L38
        List<String> r17 = PackageUpdaterKt.i(r12);     // Catch: Throwable -> L38
        String r18 = CollectionsKt.joinToString$default(r17, null, null, null, 0, null, new PackageUpdater$resumeBlockedUpdateTasksIfNeed$1$pendingConfigs$1(this), 31, null);     // Catch: Throwable -> L38
        com.obric.aikernel.runtime.utils.d r19 = com.obric.aikernel.runtime.utils.d.f5417a;     // Catch: Throwable -> L38
        StringBuilder r110 = new StringBuilder();     // Catch: Throwable -> L38
        r110.append("resumeBlockedUpdateTasksIfNeed trigger=");     // Catch: Throwable -> L38
        r110.append(r22);     // Catch: Throwable -> L38
        r110.append(" pendingCount=");     // Catch: Throwable -> L38
        r110.append(r17.size());     // Catch: Throwable -> L38
        r110.append(" pending=");     // Catch: Throwable -> L38
        if (r18.length() != 0) goto L13;
        boolean r111 = true;
    L14:
        if (r111 == false) goto L16;
        r18 = "[]";
    L16:
        r110.append(r18);     // Catch: Throwable -> L38
        r110.append(" taskCount=");     // Catch: Throwable -> L38
        r110.append(r16.size());     // Catch: Throwable -> L38
        r110.append(" activeDownloadJob=");     // Catch: Throwable -> L38
        r110.append(r11);     // Catch: Throwable -> L38
        r110.append(" validatedNetwork=");     // Catch: Throwable -> L38
        r110.append(r14);     // Catch: Throwable -> L38
        r110.append(" unmeteredNetwork=");     // Catch: Throwable -> L38
        r110.append(r15);     // Catch: Throwable -> L38
        r110.append(" packages=");     // Catch: Throwable -> L38
        r110.append(PackageUpdaterKt.f(r12, 0, 2, null));     // Catch: Throwable -> L38
        r19.d("PackageUpdater", r110.toString());     // Catch: Throwable -> L38
        Iterator<T> r20 = r17.iterator();     // Catch: Throwable -> L38
    L18:
        if (r20.hasNext() == false) goto L22;
        String r21 = (String) r20.next();     // Catch: Throwable -> L38
        if (r16.containsKey(r21) == true) goto L18;
        r16.put(r21, n(r21, r10));     // Catch: Throwable -> L38
        goto L18
    L22:
        List r23 = CollectionsKt.toList(r16.values());     // Catch: Throwable -> L38
        monitor-exit(this);
        Iterator r112 = r23.iterator();
    L26:
        if (r112.hasNext() == false) goto L37;
        final UpdateTask r24 = (UpdateTask) r112.next();
        r0<UpdateResult> r25 = r24.F();
        if (r25 == null) goto L33;
        if (r25.isActive() != true) goto L33;
        boolean r26 = true;
    L34:
        if (r26 == false) goto L35;
        com.obric.aikernel.runtime.utils.d.f5417a.d("PackageUpdater", "resumeBlockedUpdateTasksIfNeed skip active biz=" + r24.H().getBiz() + " trigger=" + r22 + " stage=" + r24.H().getStage() + " stageLabel=" + PackageUpdaterKt.g(r24.H().getStage()) + " result=" + PackageUpdaterKt.s(r24.H()));
        goto L26
    L35:
        PackageUpdaterKt.m(r22, r24.H().getBiz(), new PackageUpdater$resumeBlockedUpdateTasksIfNeed$2$1(this, r24, r22, r10));
    L33:
        r26 = false;
        goto L34
    L37:
        return;
    L13:
        r111 = false;
    L38:
        th = move-exception;
        throw th;
    L5:
        if (r13.d(this.f5117a.getConfig().getContext()) == true) goto L8;
        r15 = false;
        goto L9
    }

    public final Object y(List<String> r10, b r11, String r12, Continuation<? super Map<String, UpdateResult>> r13) {
        if ((r13 instanceof PackageUpdater$update$1) == false) goto L7;
        PackageUpdater$update$1 r14 = (PackageUpdater$update$1) r13;
        int r15 = r14.label;
        if ((r15 & Integer.MIN_VALUE) == 0) goto L7;
        r14.label = r15 - Integer.MIN_VALUE;
    L8:
        Object r16 = r14.result;
        Object r17 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r18 = r14.label;
        if (r18 == 0) goto L16;
        if (r18 != 1) goto L15;
        PackageUpdater this = (PackageUpdater) r14.L$1;
        r11 = (b) r14.L$0;
        ResultKt.throwOnFailure(r16);     // Catch: Throwable -> L22
    L20:
        Map<String, UpdateResult> r19 = ((m) r16).c();     // Catch: Throwable -> L22
        com.obric.aikernel.runtime.utils.d.f5417a.i("PackageUpdater", "update end caller=" + r11.b() + ' ' + this.x(r19));     // Catch: Throwable -> L22
        Object r20 = Result.m32constructorimpl(r19);     // Catch: Throwable -> L22
    L24:
        Throwable r110 = Result.m35exceptionOrNullimpl(r20);
        if (r110 == null) goto L27;
        com.obric.aikernel.runtime.utils.d.f5417a.f("PackageUpdater", "update failed caller=" + r11.b() + " updateAll=" + r11.g() + " background=" + r11.a() + ' ' + ExceptionsKt.stackTraceToString(r110));
    L27:
        ResultKt.throwOnFailure(r20);
        return r20;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r16);
        com.obric.aikernel.runtime.utils.d.f5417a.i("PackageUpdater", "update start caller=" + r11.b() + " updateAll=" + r11.g() + " background=" + r11.a() + " onlyDownload=" + r11.d() + " onlyFetchConfig=" + r11.e() + " bizCount=" + r10.size() + " loraType=" + r12);
        Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L22
        r14.L$0 = r11;     // Catch: Throwable -> L22
        r14.L$1 = this;     // Catch: Throwable -> L22
        r14.label = 1;     // Catch: Throwable -> L22
        r16 = A(r10, r11, r12, r14);     // Catch: Throwable -> L22
        if (r16 != r17) goto L20;
        return r17;
    L22:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r20 = Result.m32constructorimpl(ResultKt.createFailure(th));
    L7:
        r14 = new PackageUpdater$update$1(this, r13);
        goto L8
    }
}
