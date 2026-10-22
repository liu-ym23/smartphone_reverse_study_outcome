package com.obric.aikernel.res.update;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import androidx.annotation.GuardedBy;
import androidx.work.WorkRequest;
import com.obric.aikernel.res.PackageResourceManager;
import com.obric.aikernel.res.PrmContext;
import com.obric.aikernel.res.downloader.DownloadTask;
import com.obric.aikernel.res.metadata.config.DistConfig;
import com.obric.aikernel.res.metadata.config.LoraConfig;
import com.obric.aikernel.res.metadata.config.UpdateTaskConfig;
import com.obric.aikernel.res.metadata.controller.MetadataController;
import com.obric.aikernel.res.metadata.data.Lora;
import com.obric.aikernel.res.task.NamedTaskScheduler;
import com.obric.aikernel.runtime.utils.NetworkUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.ExceptionsKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.r0;
import kotlinx.coroutines.v1;

/* JADX INFO: loaded from: classes2.dex */
public final class UpdateTask {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final a f5132m = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f5133a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final l0 f5134b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final PrmContext f5135c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final File f5136d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final j f5137e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private UpdateResult f5138f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f5139g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final File f5140h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final File f5141i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private r0<UpdateResult> f5142j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @GuardedBy("this")
    private final Set<CoroutineContext> f5143k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @GuardedBy("this")
    private boolean f5144l;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        private final UpdateTaskConfig b(PrmContext r10, String r11) {
            com.obric.aikernel.res.metadata.data.b.a r12 = com.obric.aikernel.res.metadata.data.b.f5079l;
            UpdateTaskConfig r13 = r12.b("package", r11, r10.getConfig());
            if (r13 == null) goto L5;
            return r13;
        L5:
            UpdateTaskConfig r14 = r12.b("lora", r11, r10.getConfig());
            if (r14 == null) goto L8;
            return r14;
        L8:
            return null;
        }

        public final UpdateTaskConfig a(String r10, File r11, PrmContext r12) {
            Intrinsics.checkNotNullParameter(r10, "biz");
            Intrinsics.checkNotNullParameter(r11, "parentDir");
            Intrinsics.checkNotNullParameter(r12, "context");
            UpdateTaskConfig r13 = c(r11, r10, r12.getConfig());
            if (r13 == null) goto L5;
            return r13;
        L5:
            return b(r12, r10);
        }

        public final UpdateTaskConfig c(File r10, String r11, PackageResourceManager.PresmConfig r12) {
            Intrinsics.checkNotNullParameter(r10, "parentDir");
            Intrinsics.checkNotNullParameter(r11, "biz");
            Intrinsics.checkNotNullParameter(r12, "config");
            File r13 = new File(new File(r10 + "/packages", r11), "configuration.json");
            if (r13.exists() == false) goto L15;
            com.google.gson.k r14 = (com.google.gson.k) com.obric.aikernel.res.utils.a.f5222a.h(r13, com.google.gson.k.class);
            if (r14 != null) goto L8;
            return null;
        L8:
            if (com.obric.aikernel.res.metadata.config.e.f5040i.a(r14) == false) goto L11;
            return new com.obric.aikernel.res.metadata.config.e(r11, r14, r12);
        L11:
            if (LoraConfig.f5018l.a(r14) == true) goto L17;
            com.obric.aikernel.runtime.utils.d.f5417a.f("PackageUpdater", "getPendingUpdateConfig unknown config: " + r14);
            return null;
        L17:
            return new LoraConfig(r11, r14);
        L15:
            return null;
        }
    }

    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f5145a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f5146b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f5147c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f5148d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final String f5149e;

        public b(boolean r10, boolean r11, boolean r12, boolean r13, String r14) {
            Intrinsics.checkNotNullParameter(r14, "activeNetwork");
            this.f5145a = r10;
            this.f5146b = r11;
            this.f5147c = r12;
            this.f5148d = r13;
            this.f5149e = r14;
        }

        public final boolean a() {
            return this.f5146b;
        }

        public final boolean b() {
            return this.f5147c;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof b) == true) goto L8;
            return false;
        L8:
            b r11 = (b) r10;
            if (this.f5145a == r11.f5145a) goto L12;
            return false;
        L12:
            if (this.f5146b == r11.f5146b) goto L15;
            return false;
        L15:
            if (this.f5147c == r11.f5147c) goto L18;
            return false;
        L18:
            if (this.f5148d == r11.f5148d) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f5149e, r11.f5149e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v10 */
        /* JADX WARN: Type inference failed for: r0v11 */
        /* JADX WARN: Type inference failed for: r0v3, types: [int] */
        /* JADX WARN: Type inference failed for: r0v5, types: [int] */
        /* JADX WARN: Type inference failed for: r0v7, types: [int] */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r2v1, types: [int] */
        /* JADX WARN: Type inference failed for: r2v3, types: [int] */
        /* JADX WARN: Type inference failed for: r2v5 */
        /* JADX WARN: Type inference failed for: r2v6 */
        /* JADX WARN: Type inference failed for: r2v7 */
        /* JADX WARN: Type inference failed for: r2v8 */
        public int hashCode() {
            boolean r10 = this.f5145a;
            ?? r11 = 1;
            ?? r12 = r10;
            if (r10 == false) goto L5;
            r12 = 1;
        L5:
            int r13 = r12 * 31;
            boolean r14 = this.f5146b;
            ?? r15 = r14;
            if (r14 == false) goto L8;
            r15 = 1;
        L8:
            int r16 = (r13 + r15) * 31;
            boolean r17 = this.f5147c;
            ?? r18 = r17;
            if (r17 == false) goto L11;
            r18 = 1;
        L11:
            int r19 = (r16 + r18) * 31;
            boolean r20 = this.f5148d;
            if (r20 == true) goto L16;
            r11 = r20;
        L16:
            return ((r19 + r11) * 31) + this.f5149e.hashCode();
        }

        public String toString() {
            return "ConnectivitySnapshot(hasInternet=" + this.f5145a + ", hasValidatedInternet=" + this.f5146b + ", isUnmetered=" + this.f5147c + ", isWifi=" + this.f5148d + ", activeNetwork=" + this.f5149e + ')';
        }
    }

    static {
        f5132m = new a(null);
    }

    public UpdateTask(String r21, l0 r22, PrmContext r23, File r24, j r25) {
        Intrinsics.checkNotNullParameter(r21, "biz");
        Intrinsics.checkNotNullParameter(r22, "scope");
        Intrinsics.checkNotNullParameter(r23, "context");
        Intrinsics.checkNotNullParameter(r24, "parentDir");
        this.f5133a = r21;
        this.f5134b = r22;
        this.f5135c = r23;
        this.f5136d = r24;
        this.f5137e = r25;
        this.f5138f = new UpdateResult(r21, false, 0, null, false, 0, 0, null, 0, false, 1022, null);
        this.f5139g = "update-" + r21;
        this.f5140h = new File(r24, "downloads");
        this.f5141i = new File(r24 + "/packages", r21);
        this.f5143k = new LinkedHashSet();
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:77:0x0423 -> B:187:0x042a). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:84:0x043b -> B:193:0x0445). Please report as a decompilation issue!!! */
    private final Object A(Continuation<? super Boolean> r36) {
        if ((r36 instanceof UpdateTask$doDownload$1) == false) goto L7;
        UpdateTask$doDownload$1 r10 = (UpdateTask$doDownload$1) r36;
        int r11 = r10.label;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r10.label = r11 - Integer.MIN_VALUE;
    L8:
        Object r12 = r10.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = r10.label;
        String r15 = "doDownload: ";
        String r16 = " state=";
        String r17 = " downloadTask=";
        String r18 = " background=";
        String r19 = " lora=";
        if (r14 == 0) goto L18;
        if (r14 != 1) goto L17;
        Collection r20 = (Collection) r10.L$8;
        DownloadTask r110 = (DownloadTask) r10.L$7;
        DistConfig r111 = (DistConfig) r10.L$6;
        Iterator r112 = (Iterator) r10.L$5;
        Collection r113 = (Collection) r10.L$4;
        List r21 = (List) r10.L$3;
        Map<String, Set<DownloadTask>> r22 = (Map) r10.L$2;
        UpdateTaskConfig r23 = (UpdateTaskConfig) r10.L$1;
        UpdateTask r24 = (UpdateTask) r10.L$0;
        ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L14
        String r25 = " state=";
        String r114 = " downloadTask=";
        String r26 = " background=";
        final DownloadTask r115 = r110;
        DistConfig r27 = r111;
        Collection r28 = r113;
        List r116 = r21;
        UpdateTask r29 = r24;
        String r210 = "doDownload: ";
        String r211 = " lora=";
        Iterator r30 = r112;
    L187:
        Object r31 = Result.m32constructorimpl((Pair) r12);     // Catch: Throwable -> L80
        UpdateTask r32 = r29;
    L193:
        UpdateTaskConfig r33 = r23;
        Throwable r117 = Result.m35exceptionOrNullimpl(r31);     // Catch: Throwable -> L114
        if (r117 == null) goto L93;
        com.obric.aikernel.runtime.utils.d r118 = com.obric.aikernel.runtime.utils.d.f5417a;     // Catch: Throwable -> L114
        UpdateTask$doDownload$1 r35 = r10;
        StringBuilder r34 = new StringBuilder();     // Catch: Throwable -> L114
        Object r212 = r13;
        r34.append("doDownload await failed biz=");     // Catch: Throwable -> L114
        r34.append(r32.f5133a);     // Catch: Throwable -> L114
        r34.append(" dist=");     // Catch: Throwable -> L114
        r34.append(r27.g());     // Catch: Throwable -> L114
        r34.append(r114);     // Catch: Throwable -> L114
        r34.append(r115.v());     // Catch: Throwable -> L114
        String r37 = r25;
        r34.append(r37);     // Catch: Throwable -> L114
        Iterator r213 = r30;
        r34.append(r115.y());     // Catch: Throwable -> L114
        r34.append(' ');     // Catch: Throwable -> L114
        r34.append(ExceptionsKt.stackTraceToString(r117));     // Catch: Throwable -> L114
        r118.f("PackageUpdater", r34.toString());     // Catch: Throwable -> L114
        if ((r117 instanceof CancellationException) == false) goto L95;
        Iterator r38 = r116.iterator();     // Catch: Throwable -> L114
    L91:
        if (r38.hasNext() == false) goto L95;
        ((DownloadTask) ((Pair) r38.next()).getSecond()).H(r32.f5139g, new UpdateTask$doDownload$awaitResults$1$ret$2$1$1(r115));     // Catch: Throwable -> L114
    L95:
        if (Result.m38isFailureimpl(r31) == false) goto L97;
        r31 = null;
    L97:
        Pair r39 = (Pair) r31;     // Catch: Throwable -> L114
        if (r39 != null) goto L102;
        r39 = new Pair(new Pair(Boxing.boxBoolean(false), Boxing.boxInt(r115.y())), CollectionsKt.emptyList());     // Catch: Throwable -> L114
    L102:
        r115.G();
        Pair r40 = (Pair) r39.getFirst();
        com.obric.aikernel.runtime.utils.d r41 = com.obric.aikernel.runtime.utils.d.f5417a;
        r41.i("PackageUpdater", "doDownload await end biz=" + r32.f5133a + " dist=" + r27.g() + r114 + r115.v() + " success=" + ((Boolean) r40.getFirst()).booleanValue() + r37 + ((Number) r40.getSecond()).intValue() + " files=" + CollectionsKt.joinToString$default((Iterable) r39.getSecond(), null, null, null, 8, null, UpdateTask$doDownload$awaitResults$1$1.INSTANCE, 23, null));
        StringBuilder r119 = new StringBuilder();
        String r120 = r210;
        r119.append(r120);
        String r214 = r37;
        r119.append(r32.f5133a);
        r119.append(' ');
        r119.append(r27.g());
        r119.append(" downloadTask ");
        r119.append(r115.v());
        r119.append(' ');
        r119.append(r39);
        r41.d("PackageUpdater", r119.toString());
        StringBuilder r42 = new StringBuilder();
        r42.append(r39.getFirst());
        Iterable r43 = (Iterable) r39.getSecond();
        UpdateTask r215 = r32;
        ArrayList r44 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r43, 10));
        Iterator r45 = r43.iterator();
    L104:
        if (r45.hasNext() == false) goto L106;
        DownloadTask.b r46 = (DownloadTask.b) r45.next();
        StringBuilder r121 = new StringBuilder();
        r121.append(r46.c());
        r121.append('-');
        r121.append(r46.h());
        r44.add(r121.toString());
        r45 = r45;
        goto L104
    L106:
        Iterator r47 = r44.iterator();
        if (r47.hasNext() == true) goto L109;
        Object r48 = null;
    L113:
        r42.append((String) r48);
        r20.add(new com.obric.aikernel.res.update.b(r27, r115, r40, r42.toString()));
        r10 = r35;
        r20 = r28;
        Map<String, Set<DownloadTask>> r49 = r22;
        r13 = r212;
        r30 = r213;
        r32 = r215;
        String r216 = r114;
        r25 = r214;
        r210 = r120;
        r19 = r211;
    L72:
        if (r30.hasNext() == false) goto L117;
        Pair r50 = (Pair) r30.next();
        r27 = (DistConfig) r50.component1();
        r115 = (DownloadTask) r50.component2();
        r32.O(r115);
        com.obric.aikernel.runtime.utils.d r51 = com.obric.aikernel.runtime.utils.d.f5417a;
        StringBuilder r122 = new StringBuilder();
        r122.append("doDownload await start biz=");
        r122.append(r32.f5133a);
        r122.append(" dist=");
        r122.append(r27.g());
        r114 = r216;
        r122.append(r114);
        r211 = r19;
        r122.append(r115.v());
        r122.append(r25);
        r122.append(r115.y());
        r122.append(" prior=");
        r122.append(r115.w());
        r122.append(r26);
        r122.append(r115.q());
        r51.i("PackageUpdater", r122.toString());
        Result.Companion r52 = Result.Companion;     // Catch: Throwable -> L82
        r10.L$0 = r32;     // Catch: Throwable -> L82
        r10.L$1 = r33;     // Catch: Throwable -> L82
        r10.L$2 = r49;     // Catch: Throwable -> L82
        r10.L$3 = r116;     // Catch: Throwable -> L82
        r10.L$4 = r20;     // Catch: Throwable -> L82
        r10.L$5 = r30;     // Catch: Throwable -> L82
        r10.L$6 = r27;     // Catch: Throwable -> L82
        r10.L$7 = r115;     // Catch: Throwable -> L82
        r10.L$8 = r20;     // Catch: Throwable -> L82
        r10.label = 1;     // Catch: Throwable -> L82
        Object r53 = r115.k(r10);     // Catch: Throwable -> L82
        if (r53 != r13) goto L77;
        return r13;
    L77:
        r22 = r49;
        r23 = r33;
        r29 = r32;
        r28 = r20;
        r12 = r53;
    L82:
        Throwable th = th;
        r22 = r49;
        r23 = r33;
        r28 = r20;
    L84:
        Result.Companion r54 = Result.Companion;     // Catch: Throwable -> L114
        r31 = Result.m32constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L114
        goto L193
    L117:
        String r217 = r19;
        String r123 = r210;
        List r55 = (List) r20;
        LinkedHashMap r56 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r55, 10)), 16));
        Iterator r57 = r55.iterator();
    L119:
        if (r57.hasNext() == false) goto L121;
        com.obric.aikernel.res.update.b r58 = (com.obric.aikernel.res.update.b) r57.next();
        Pair r59 = TuplesKt.to(r58.c(), r58.a().getFirst());
        r56.put(r59.getFirst(), r59.getSecond());
        goto L119
    L121:
        Iterator<Map.Entry<String, Set<DownloadTask>>> r60 = r49.entrySet().iterator();
    L123:
        if (r60.hasNext() == false) goto L148;
        Map.Entry<String, Set<DownloadTask>> r61 = r60.next();
        String r62 = r61.getKey();
        Set<DownloadTask> r63 = r61.getValue();
        ArrayList r64 = new ArrayList();
        Iterator<T> r65 = r63.iterator();
    L126:
        if (r65.hasNext() == false) goto L131;
        Object r66 = r65.next();
        if ((!Intrinsics.areEqual(r56.get((DownloadTask) r66), Boxing.boxBoolean(true))) == false) goto L126;
        r64.add(r66);
        goto L126
    L131:
        if (r64.isEmpty() == true) goto L132;
        ArrayList r67 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r64, 10));
        Iterator r68 = r64.iterator();
    L138:
        if (r68.hasNext() == false) goto L141;
        r67.add(Boxing.boxInt(((DownloadTask) r68.next()).y()));
        goto L138
    L141:
        if (p.h(r67) == true) goto L142;
        j r69 = r32.f5137e;
        if (r69 == null) goto L123;
        r69.i(r62);
    L135:
        Unit r70 = Unit.INSTANCE;
        goto L123
    L142:
        j r71 = r32.f5137e;
        if (r71 == null) goto L123;
        r71.e(r62, 4);
        goto L135
    L132:
        j r72 = r32.f5137e;
        if (r72 == null) goto L123;
        r72.m(r62);
        goto L135
    L148:
        ArrayList r73 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r55, 10));
        Iterator r74 = r55.iterator();
    L150:
        if (r74.hasNext() == false) goto L152;
        com.obric.aikernel.res.update.b r75 = (com.obric.aikernel.res.update.b) r74.next();
        r73.add(TuplesKt.to(r75.a(), r75.b()));
        goto L150
    L152:
        Iterator r76 = r73.iterator();
        if (r76.hasNext() == true) goto L155;
        Object r77 = null;
    L169:
        Pair r78 = (Pair) r77;
        if (r78 != null) goto L172;
        com.obric.aikernel.runtime.utils.d r79 = com.obric.aikernel.runtime.utils.d.f5417a;
        StringBuilder r80 = new StringBuilder();
        r80.append(r123);
        r80.append(r32.f5133a);
        r80.append(' ');
        UpdateTaskConfig r81 = r32.f5138f.getCfg();
        if (r81 == null) goto L181;
        String r124 = r81.i();
    L182:
        r80.append(r124);
        r80.append(" do nothing");
        r79.i("PackageUpdater", r80.toString());
        if ((r33 instanceof LoraConfig) == false) goto L186;
        r79.d("PackageUpdater", "doDownload lora no-op biz=" + r32.f5133a + r217 + r33.g() + '@' + r33.i() + " all resources ready or installer hit");
    L186:
        return Boxing.boxBoolean(true);
    L181:
        r124 = null;
        goto L182
    L172:
        if (((Boolean) ((Pair) r78.getFirst()).getFirst()).booleanValue() == true) goto L177;
        r32.f5138f.setStage(((Number) ((Pair) r78.getFirst()).getSecond()).intValue() + 200);
        r32.f5138f.fail((String) r78.getSecond());
        if ((r33 instanceof LoraConfig) == false) goto L177;
        com.obric.aikernel.runtime.utils.d.f5417a.d("PackageUpdater", "doDownload lora failed biz=" + r32.f5133a + r217 + r33.g() + '@' + r33.i() + " stage=" + r32.f5138f.getStage() + " msg=" + ((String) r78.getSecond()));
    L177:
        return ((Pair) r78.getFirst()).getFirst();
    L155:
        r77 = r76.next();
    L157:
        if (r76.hasNext() == false) goto L169;
        Pair r82 = (Pair) r76.next();
        Pair r83 = (Pair) r77;
        if (((Boolean) ((Pair) r83.getFirst()).getFirst()).booleanValue() == true) goto L161;
    L163:
        boolean r125 = false;
    L164:
        Boolean r84 = Boxing.boxBoolean(r125);
        if (((Number) ((Pair) r82.getFirst()).getSecond()).intValue() == 0) goto L167;
        Object r85 = r82.getFirst();
    L168:
        r77 = new Pair(new Pair(r84, Boxing.boxInt(((Number) ((Pair) r85).getSecond()).intValue())), ((String) r83.getSecond()) + ' ' + ((String) r82.getSecond()));
        goto L157
    L167:
        r85 = r83.getFirst();
        goto L168
    L161:
        if (((Boolean) ((Pair) r82.getFirst()).getFirst()).booleanValue() == false) goto L163;
        r125 = true;
        goto L164
    L109:
        r48 = r47.next();
    L111:
        if (r47.hasNext() == false) goto L113;
        r48 = ((String) r48) + ' ' + ((String) r47.next());
        goto L111
    L93:
        r35 = r10;
        r212 = r13;
        r37 = r25;
        r213 = r30;
    L114:
        th = move-exception;
        r115.G();
        throw th;
    L80:
        th = th;
        r32 = r29;
    L14:
        th = th;
        r25 = " state=";
        r114 = " downloadTask=";
        r26 = " background=";
        r115 = r110;
        r27 = r111;
        r28 = r113;
        r116 = r21;
        r32 = r24;
        r210 = "doDownload: ";
        r211 = " lora=";
        r30 = r112;
        goto L84
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r12);
        com.obric.aikernel.runtime.utils.d r86 = com.obric.aikernel.runtime.utils.d.f5417a;
        r86.i("PackageUpdater", "doDownload start biz=" + this.f5133a + " cfg=" + z(this.f5138f.getCfg()) + " background=" + this.f5138f.getBackground());
        this.f5138f.setStage(200);
        UpdateTaskConfig r87 = this.f5138f.getCfg();
        Intrinsics.checkNotNull(r87);
        if ((r87 instanceof LoraConfig) == false) goto L21;
        r86.d("PackageUpdater", "doDownload lora start biz=" + this.f5133a + " lora=" + r87.g() + '@' + r87.i() + " models=" + ((LoraConfig) r87).o() + " background=" + this.f5138f.getBackground());
    L21:
        LinkedHashMap r88 = new LinkedHashMap();
        List<DistConfig> r89 = r87.l();
        r116 = new ArrayList();
        Iterator r90 = r89.iterator();
    L23:
        if (r90.hasNext() == false) goto L70;
        DistConfig r126 = (DistConfig) r90.next();
        if ((r126 instanceof com.obric.aikernel.res.metadata.config.f) == false) goto L27;
        String r127 = r87.i();
    L28:
        UpdateTask$doDownload$1 r218 = r10;
        boolean r91 = r126.j(this.f5135c);
        Object r219 = r13;
        if (r91 == false) goto L34;
        Iterator r220 = r90;
        if (Intrinsics.areEqual(r126.e(), "debug") == true) goto L35;
        r15 = r15;
        boolean r92 = this.f5135c.tryInstallFromInstaller(r126.h(), r126.g(), r127);
    L36:
        boolean r93 = r87 instanceof LoraConfig;
        if (r93 == false) goto L42;
        if ((r126 instanceof com.obric.aikernel.res.metadata.config.d) == false) goto L42;
        com.obric.aikernel.runtime.utils.d.f5417a.d("PackageUpdater", "doDownload lora model biz=" + this.f5133a + " lora=" + r87.g() + '@' + r87.i() + " model=" + r126.g() + '@' + r126.i() + " needDownload=" + r91 + " installFromInstaller=" + r92 + " from=" + r126.e() + " downloadables=" + x(r126));
    L42:
        if (r91 == true) goto L44;
    L60:
        if (r93 == true) goto L62;
    L68:
        Collection r94 = CollectionsKt.emptyList();
    L69:
        CollectionsKt.addAll(r116, r94);
        r10 = r218;
        r13 = r219;
        r90 = r220;
        r15 = r15;
        r18 = r18;
        r16 = r16;
        r17 = r17;
        goto L23
    L62:
        if ((r126 instanceof com.obric.aikernel.res.metadata.config.d) == false) goto L68;
        com.obric.aikernel.runtime.utils.d r95 = com.obric.aikernel.runtime.utils.d.f5417a;
        StringBuilder r96 = new StringBuilder();
        r96.append("doDownload lora model skip biz=");
        r96.append(this.f5133a);
        r96.append(" lora=");
        r96.append(r87.g());
        r96.append('@');
        r96.append(r87.i());
        r96.append(" model=");
        r96.append(r126.g());
        r96.append('@');
        r96.append(r126.i());
        r96.append(" reason=");
        if (r91 == true) goto L66;
        String r97 = "needDownload=false";
    L67:
        r96.append(r97);
        r95.d("PackageUpdater", r96.toString());
        goto L68
    L66:
        r97 = "installer_hit";
        goto L67
    L44:
        if (Intrinsics.areEqual(r126.e(), "debug") == true) goto L46;
        if (r92 == true) goto L60;
    L46:
        List<com.obric.aikernel.res.metadata.config.b> r98 = r126.d();
        r94 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r98, 10));
        Iterator<T> r99 = r98.iterator();
    L48:
        if (r99.hasNext() == false) goto L69;
        com.obric.aikernel.res.metadata.config.b r100 = (com.obric.aikernel.res.metadata.config.b) r99.next();
        String r101 = r100.m();
        String r102 = this.f5140h + '/' + r101;
        boolean r103 = r100.v(this.f5135c.getConfig().getDecryptFeature());
        if (new File(r102, r100.o()).exists() == false) goto L52;
        r103 = false;
    L52:
        StringBuilder r128 = new StringBuilder();
        r128.append(r102);
        if (r103 == false) goto L55;
        String r104 = "/encrypt";
    L56:
        r128.append(r104);
        String r105 = r128.toString();
        DownloadTask r106 = this.f5135c.getDownloadCtrl$resource_manager_release().s(this.f5135c.getConfig(), this.f5139g, r101, DistConfig.c(r100, r105, r105 + "/tmp", 0, 4, null));
        com.obric.aikernel.runtime.utils.d.f5417a.d("PackageUpdater", "task " + r106 + " prepare to download " + r105);
        if ((r126 instanceof com.obric.aikernel.res.metadata.config.d) == false) goto L59;
        p(r87, (com.obric.aikernel.res.metadata.config.d) r126, r106, r88);
    L59:
        O(r106);
        r94.add(new Pair(r126, r106));
        goto L48
    L55:
        r104 = "";
    L35:
        r92 = false;
        goto L36
    L34:
        r220 = r90;
        goto L35
    L27:
        r127 = r126.i();
        goto L28
    L70:
        UpdateTask$doDownload$1 r221 = r10;
        r210 = r15;
        r25 = r16;
        r216 = r17;
        r26 = r18;
        M();
        ArrayList r107 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r116, 10));
        r49 = r88;
        r30 = r116.iterator();
        r33 = r87;
        r13 = r13;
        r32 = this;
        r20 = r107;
        r10 = r221;
    L7:
        r10 = new UpdateTask$doDownload$1(this, r36);
        goto L8
    }

    private final boolean B() {
        com.obric.aikernel.runtime.utils.d.f5417a.i("PackageUpdater", "doInstall start biz=" + this.f5133a + " cfg=" + z(this.f5138f.getCfg()));
        this.f5138f.setStage(400);
        UpdateTaskConfig r10 = this.f5138f.getCfg();
        Intrinsics.checkNotNull(r10);
        List<DistConfig> r11 = r10.l();
        ArrayList r12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10));
        Iterator<T> r13 = r11.iterator();
        String r14 = null;
        DistConfig r15 = null;
    L4:
        if (r13.hasNext() == false) goto L17;
        DistConfig r16 = (DistConfig) r13.next();
        UpdateResult r17 = this.f5138f;
        r17.setStage(r17.getStage() + 1);
        if ((r16 instanceof com.obric.aikernel.res.metadata.config.f) == false) goto L9;
        Pair<Boolean, String> r18 = new Pair(Boolean.TRUE, "");
    L16:
        r12.add(r18);
        r15 = r16;
        goto L4
    L9:
        if ((r16 instanceof com.obric.aikernel.res.metadata.config.c) == false) goto L13;
        String r19 = "lib";
    L11:
        Pair<Boolean, String> r20 = I(r19, r16);
        r16 = r15;
        r18 = r20;
        goto L16
    L13:
        if ((r16 instanceof com.obric.aikernel.res.metadata.config.d) == false) goto L15;
        r19 = "model";
        goto L11
    L15:
        Pair<Boolean, String> r21 = new Pair(Boolean.FALSE, "not support type " + r16.getClass());
        r16 = r15;
        r18 = r21;
        goto L16
    L17:
        Iterator r22 = r12.iterator();
        if (r22.hasNext() == false) goto L64;
        Object r23 = r22.next();
    L20:
        boolean r24 = false;
        if (r22.hasNext() == false) goto L28;
        Pair r25 = (Pair) r22.next();
        Pair r26 = (Pair) r23;
        if (((Boolean) r26.getFirst()).booleanValue() == false) goto L27;
        if (((Boolean) r25.getFirst()).booleanValue() == false) goto L27;
        r24 = true;
    L27:
        r23 = new Pair(Boolean.valueOf(r24), ((String) r26.getSecond()) + ' ' + ((String) r25.getSecond()));
        goto L20
    L28:
        Pair r27 = (Pair) r23;
        if (((Boolean) r27.getFirst()).booleanValue() == true) goto L33;
        this.f5138f.fail((String) r27.getSecond());
        return false;
    L33:
        if ((this.f5138f.getCfg() instanceof com.obric.aikernel.res.metadata.config.e) == false) goto L39;
        if (r15 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("handlerConfig");
        com.obric.aikernel.res.metadata.config.f r28 = null;
    L37:
        r24 = K(r28);
    L41:
        UpdateTaskConfig r29 = this.f5138f.getCfg();
        if (r29 == null) goto L44;
        String r30 = r29.h();
    L45:
        UpdateTaskConfig r31 = this.f5138f.getCfg();
        if (r31 == null) goto L48;
        r14 = r31.i();
    L48:
        com.obric.aikernel.runtime.utils.d.f5417a.i("PackageUpdater", "install " + r30 + ' ' + this.f5133a + '@' + r14 + ' ' + r24);
        if (r24 == true) goto L51;
    L62:
        return r24;
    L51:
        if (this.f5141i.exists() == false) goto L62;
        Result.Companion r32 = Result.Companion;     // Catch: Throwable -> L54
        Object r33 = Result.m32constructorimpl(Boolean.valueOf(FilesKt.deleteRecursively(this.f5141i)));     // Catch: Throwable -> L54
    L57:
        if (Result.m39isSuccessimpl(r33) == false) goto L59;
        boolean r34 = ((Boolean) r33).booleanValue();
        com.obric.aikernel.runtime.utils.d.f5417a.i("PackageUpdater", "doInstall delete pending config dir biz=" + this.f5133a + " cfg=" + z(this.f5138f.getCfg()) + " path=" + this.f5141i.getPath() + " deleted=" + r34 + " exists=" + this.f5141i.exists());
    L59:
        Throwable r35 = Result.m35exceptionOrNullimpl(r33);
        if (r35 == null) goto L62;
        com.obric.aikernel.runtime.utils.d.f5417a.l("PackageUpdater", "doInstall delete " + this.f5141i + " failed " + r35);
    L54:
        th = move-exception;
        Result.Companion r36 = Result.Companion;
        r33 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L57
    L44:
        r30 = null;
        goto L45
    L36:
        r28 = (com.obric.aikernel.res.metadata.config.f) r15;
        goto L37
    L39:
        if ((this.f5138f.getCfg() instanceof LoraConfig) == false) goto L41;
        r24 = J();
        goto L41
    L64:
        throw new UnsupportedOperationException("Empty collection can't be reduced.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v5, types: [T, kotlin.Pair] */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v11, types: [T, kotlin.Pair] */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v7, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r7v8, types: [T, kotlin.Pair] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x00fa -> B:48:0x02fb). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x02e8 -> B:46:0x02eb). Please report as a decompilation issue!!! */
    private final Object C(Continuation<? super Boolean> r29) {
        UpdateTask r10 = this;
        if ((r29 instanceof UpdateTask$doProcessFiles$1) == false) goto L7;
        UpdateTask$doProcessFiles$1 r11 = (UpdateTask$doProcessFiles$1) r29;
        int r12 = r11.label;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r11.label = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r11.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r11.label;
        String r16 = "_temp";
        ?? r17 = 1;
        if (r15 == 0) goto L16;
        if (r15 == 1) goto L15;
        if (r15 != 2) goto L14;
        Collection r18 = (Collection) r11.L$5;
        Iterator r19 = (Iterator) r11.L$4;
        Ref.ObjectRef r20 = (Ref.ObjectRef) r11.L$3;
        Iterator r21 = (Iterator) r11.L$2;
        Collection r110 = (Collection) r11.L$1;
        UpdateTask r111 = (UpdateTask) r11.L$0;
        ResultKt.throwOnFailure(r13);
        String r112 = "_temp";
        Ref.ObjectRef r22 = r20;
        Iterator r113 = r21;
        Collection r114 = r110;
        UpdateTask r115 = r111;
    L46:
        String r116 = r112;
    L42:
        if (r19.hasNext() == false) goto L47;
        com.obric.aikernel.res.metadata.config.b r23 = (com.obric.aikernel.res.metadata.config.b) r19.next();
        File r117 = new File(r115.f5140h, r23.m());
        File r24 = new File(r117, r23.o());
        StringBuilder r25 = new StringBuilder();
        r25.append(r24.getPath());
        String r118 = r116;
        r25.append(r118);
        File r26 = new File(r25.toString());
        File r27 = new File(r117, r23.o() + ".zip");
        NamedTaskScheduler r28 = NamedTaskScheduler.f5100a;
        String r119 = r23.m();
        r112 = r118;
        UpdateTask$doProcessFiles$2$2$1 r30 = new UpdateTask$doProcessFiles$2$2$1(r24, r27, r26, r22, r117, null);
        r11.L$0 = r115;
        r11.L$1 = r114;
        r11.L$2 = r113;
        r11.L$3 = r22;
        r11.L$4 = r19;
        r11.L$5 = r18;
        r11.L$6 = null;
        r11.L$7 = null;
        r11.label = 2;
        if (r28.a(r119, r30, r11) != r14) goto L46;
        return r14;
    L47:
        String r120 = r116;
        Pair r31 = (Pair) r22.element;
        Collection r32 = r18;
        Iterator r33 = r113;
        r10 = r115;
    L48:
        r32.add(r31);
        r32 = r114;
        r16 = r120;
        r17 = 1;
    L18:
        if (r33.hasNext() == false) goto L49;
        DistConfig r34 = (DistConfig) r33.next();
        UpdateResult r35 = r10.f5138f;
        r35.setStage(r35.getStage() + r17);
        if (r34.j(r10.f5135c) == true) goto L23;
        r31 = new Pair(Boxing.boxBoolean(r17), "");
        r114 = r32;
        r120 = r16;
        goto L48
    L23:
        if ((r34 instanceof com.obric.aikernel.res.metadata.config.d) == false) goto L34;
        String r36 = r10.f5135c.getConfig().getResRootDir() + "/models/" + r34.g() + '/' + r34.i() + '/' + r34.g();
        Ref.ObjectRef r121 = new Ref.ObjectRef();
        r121.element = new Pair(Boxing.boxBoolean(r17), "");
        Iterator r122 = r33;
        Collection r123 = r32;
        DistConfig r124 = r34;
        String r125 = r36;
        Ref.ObjectRef r37 = r121;
        UpdateTask r126 = r10;
        Collection r38 = r123;
        Iterator r39 = r34.d().iterator();
    L26:
        if (r39.hasNext() == false) goto L32;
        com.obric.aikernel.res.metadata.config.b r127 = (com.obric.aikernel.res.metadata.config.b) r39.next();
        File r40 = new File(r126.f5140h, r127.m());
        File r41 = new File(r40, r127.o());
        StringBuilder r42 = new StringBuilder();
        UpdateTask r128 = r126;
        r42.append(r41.getPath());
        r42.append(r16);
        File r43 = new File(r42.toString());
        File r44 = new File(r40, "encrypt");
        File r129 = new File(r44, r127.o());
        NamedTaskScheduler r45 = NamedTaskScheduler.f5100a;
        String r130 = r16;
        String r46 = r127.m();
        Object r210 = r14;
        Collection r47 = r123;
        Iterator r48 = r122;
        Collection r211 = r38;
        DistConfig r49 = r124;
        Iterator r212 = r39;
        String r50 = r125;
        UpdateTask$doProcessFiles$2$1$1 r51 = new UpdateTask$doProcessFiles$2$1$1(r129, r127, r128, r37, r124, r125, r43, r44, r41, null);
        r11.L$0 = r128;
        r11.L$1 = r47;
        r11.L$2 = r48;
        r11.L$3 = r49;
        r11.L$4 = r50;
        r11.L$5 = r37;
        r11.L$6 = r212;
        r11.L$7 = r211;
        r11.label = 1;
        if (r45.a(r46, r51, r11) == r210) goto L29;
        r124 = r49;
        r123 = r47;
        r125 = r50;
        r122 = r48;
        r126 = r128;
        r38 = r211;
        r14 = r210;
        r39 = r212;
        r16 = r130;
        goto L26
    L29:
        return r210;
    L32:
        Collection r52 = r38;
        String r131 = r16;
        r31 = (Pair) r37.element;
        r114 = r123;
        r33 = r122;
        r10 = r126;
        r32 = r52;
        r14 = r14;
        r120 = r131;
        goto L48
    L34:
        r116 = r16;
        if ((r34 instanceof com.obric.aikernel.res.metadata.config.f) == true) goto L40;
        Ref.ObjectRef r53 = new Ref.ObjectRef();
        r53.element = new Pair(Boxing.boxBoolean(true), "");
        r115 = r10;
        r113 = r33;
        r18 = r32;
        r114 = r18;
        r22 = r53;
        r19 = r34.d().iterator();
        goto L42
    L37:
        if ((r34 instanceof com.obric.aikernel.res.metadata.config.c) == true) goto L40;
        r31 = new Pair(Boxing.boxBoolean(true), "");
        r114 = r32;
        r120 = r116;
        goto L48
    L40:
        Ref.ObjectRef r54 = new Ref.ObjectRef();
        r54.element = new Pair(Boxing.boxBoolean(true), "");
        r115 = r10;
        r113 = r33;
        r18 = r32;
        r114 = r18;
        r22 = r54;
        r19 = r34.d().iterator();
        goto L42
    L49:
        Iterator r55 = ((List) r32).iterator();
        if (r55.hasNext() == false) goto L67;
        Object r56 = r55.next();
    L53:
        if (r55.hasNext() == false) goto L61;
        Pair r57 = (Pair) r55.next();
        Pair r58 = (Pair) r56;
        if (((Boolean) r58.getFirst()).booleanValue() == true) goto L57;
    L59:
        boolean r59 = false;
    L60:
        r56 = new Pair(Boxing.boxBoolean(r59), ((String) r58.getSecond()) + ' ' + ((String) r57.getSecond()));
        goto L53
    L57:
        if (((Boolean) r57.getFirst()).booleanValue() == false) goto L59;
        r59 = true;
        goto L60
    L61:
        Pair r60 = (Pair) r56;
        if (((Boolean) r60.getFirst()).booleanValue() == true) goto L65;
        r10.f5138f.fail((String) r60.getSecond());
    L65:
        return r60.getFirst();
    L67:
        throw new UnsupportedOperationException("Empty collection can't be reduced.");
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r38 = (Collection) r11.L$7;
        r39 = (Iterator) r11.L$6;
        Ref.ObjectRef r61 = (Ref.ObjectRef) r11.L$5;
        String r62 = (String) r11.L$4;
        DistConfig r132 = (DistConfig) r11.L$3;
        Iterator r133 = (Iterator) r11.L$2;
        r123 = (Collection) r11.L$1;
        UpdateTask r134 = (UpdateTask) r11.L$0;
        ResultKt.throwOnFailure(r13);
        r37 = r61;
        r125 = r62;
        r124 = r132;
        r122 = r133;
        r126 = r134;
        r16 = "_temp";
        goto L26
    L16:
        ResultKt.throwOnFailure(r13);
        com.obric.aikernel.runtime.utils.d.f5417a.i("PackageUpdater", "doProcessFiles start biz=" + r10.f5133a + " cfg=" + r10.z(r10.f5138f.getCfg()));
        r10.f5138f.setStage(300);
        UpdateTaskConfig r63 = r10.f5138f.getCfg();
        Intrinsics.checkNotNull(r63);
        List<DistConfig> r64 = r63.l();
        r32 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r64, 10));
        r33 = r64.iterator();
    L7:
        r11 = new UpdateTask$doProcessFiles$1(r10, r29);
        goto L8
    }

    private final Integer E() {
        if (this.f5138f.getFinished() == true) goto L5;
        return null;
    L5:
        if (this.f5138f.getStage() < 200) goto L13;
        Integer r10 = Integer.valueOf(this.f5138f.getStage() - 200);
        if (com.obric.aikernel.res.downloader.b.b(r10.intValue()) == true) goto L10;
        return null;
    L10:
        return r10;
    L13:
        return null;
    }

    private final Pair<Boolean, String> I(final String r13, final DistConfig r14) {
        final String r10 = r14.g();
        final String r11 = r14.i();
        final Function1<com.obric.aikernel.res.metadata.data.b, Unit> r12 = new UpdateTask$install$prepareFiles$1(r14, this, r10, r13);
        boolean r15 = false;
        if (Intrinsics.areEqual(r14.e(), "debug") == false) goto L13;
        String r16 = com.obric.aikernel.res.metadata.config.a.d(r14.f(), "md5");
        DistConfig r17 = new com.obric.aikernel.res.metadata.data.e(r10, r11, this.f5135c.getConfig()).s();
        if (r17 == null) goto L9;
        com.google.gson.k r18 = r17.f();
        if (r18 == null) goto L9;
        String r19 = com.obric.aikernel.res.metadata.config.a.d(r18, "md5");
    L11:
        if (Intrinsics.areEqual(r16, r19) == true) goto L13;
        r15 = true;
    L9:
        r19 = null;
    L13:
        boolean r110 = r15;
        boolean r111 = MetadataController.v(this.f5135c.getMetadataCtrl$resource_manager_release(), r13, r10, r11, r110, false, new UpdateTask$install$ret$1(r13, this, r10, r11, r12), 16, null);
        com.obric.aikernel.runtime.utils.d.f5417a.i("PackageUpdater", "install " + r13 + ' ' + r10 + '@' + r11 + ' ' + r111 + " force:" + r110);
        return new Pair(Boolean.valueOf(r111), "");
    }

    private final boolean J() {
        UpdateTaskConfig r10 = this.f5138f.getCfg();
        Intrinsics.checkNotNull(r10);
        final String r11 = r10.i();
        return MetadataController.v(this.f5135c.getMetadataCtrl$resource_manager_release(), "lora", this.f5133a, r11, false, false, new UpdateTask$installLora$1(this, r11), 24, null);
    }

    private final boolean K(final com.obric.aikernel.res.metadata.config.f r11) {
        UpdateTaskConfig r10 = this.f5138f.getCfg();
        Intrinsics.checkNotNull(r10);
        final String r12 = r10.i();
        MetadataController r13 = this.f5135c.getMetadataCtrl$resource_manager_release();
        String r14 = this.f5133a;
        UpdateTaskConfig r15 = this.f5138f.getCfg();
        Intrinsics.checkNotNull(r15);
        return MetadataController.x(r13, r14, r12, r15.f(), Intrinsics.areEqual(r12, "debug"), false, new UpdateTask$installPackage$1(this, r12, r11), 16, null);
    }

    private final void M() {
        this.f5135c.getDownloadCtrl$resource_manager_release().G(this.f5139g, this.f5138f.getPrior(), this.f5138f.getBackground());
    }

    private final void O(DownloadTask r10) {
        Pair<Integer, Boolean> r11 = w();
        int r12 = r11.component1().intValue();
        boolean r13 = r11.component2().booleanValue();
        this.f5135c.getDownloadCtrl$resource_manager_release().E(r10, r12, r13);
    }

    public static /* synthetic */ boolean a(File r10) {
        return s(r10);
    }

    public static final /* synthetic */ void b(UpdateTask r10, File r11) {
        r10.q(r11);
    }

    public static final /* synthetic */ void c(UpdateTask r10, File r11) {
        r10.r(r11);
    }

    public static final /* synthetic */ Object d(UpdateTask r10, Continuation r11) {
        return r10.A(r11);
    }

    public static final /* synthetic */ Object e(UpdateTask r10, Continuation r11) {
        return r10.C(r11);
    }

    public static final /* synthetic */ String f(UpdateTask r10) {
        return r10.f5133a;
    }

    public static final /* synthetic */ Set g(UpdateTask r10) {
        return r10.f5143k;
    }

    public static final /* synthetic */ PrmContext h(UpdateTask r10) {
        return r10.f5135c;
    }

    public static final /* synthetic */ File i(UpdateTask r10) {
        return r10.f5140h;
    }

    public static final /* synthetic */ String j(UpdateTask r10) {
        return r10.f5139g;
    }

    public static final /* synthetic */ void k(UpdateTask r10, boolean r11) {
        r10.f5144l = r11;
    }

    private final void l(PackageUpdater.b r10) {
        monitor-enter(this);
        boolean r11 = p.a(this.f5138f, r10);     // Catch: Throwable -> L8
        monitor-exit(this);
        if (r11 == false) goto L13;
        M();
        return;
    L13:
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private final void m(DistConfig r10) {
        File r11 = new File(this.f5141i, "configuration.json");
        File r12 = r11.getParentFile();
        boolean r13 = false;
        if (r12 != null) goto L5;
    L7:
        if (r13 == false) goto L11;
        File r14 = r11.getParentFile();
        if (r14 == null) goto L11;
        r14.mkdirs();
    L11:
        com.obric.aikernel.res.utils.a r15 = com.obric.aikernel.res.utils.a.f5222a;
        String r16 = r10.f().toString();
        Intrinsics.checkNotNullExpressionValue(r16, "cfg.json.toString()");
        r15.k(r11, r16);
        return;
    L5:
        if (r12.exists() == true) goto L7;
        r13 = true;
        goto L7
    }

    private final void p(UpdateTaskConfig r10, com.obric.aikernel.res.metadata.config.d r11, DownloadTask r12, Map<String, Set<DownloadTask>> r13) {
        final j r14 = this.f5137e;
        if (r14 != null) goto L5;
        return;
    L5:
        g r15 = i.a(r10, r11);
        String r16 = r15.b();
        r14.k(r15, !this.f5138f.getBackground());
        r12.i(SetsKt.setOf(r16), new UpdateTask$bindModelDownloadTelemetry$1(r14));
        Set<DownloadTask> r17 = r13.get(r16);
        if (r17 != null) goto L8;
        r17 = new LinkedHashSet();
        r13.put(r16, r17);
    L8:
        r17.add(r12);
    }

    private final void q(File r10) {
        if (r10.exists() == false) goto L14;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L6
        Object r12 = Result.m32constructorimpl(Boolean.valueOf(FilesKt.deleteRecursively(r10)));     // Catch: Throwable -> L6
    L8:
        Throwable r13 = Result.m35exceptionOrNullimpl(r12);
        if (r13 == null) goto L15;
        com.obric.aikernel.runtime.utils.d.f5417a.l("PackageUpdater", "cleanDownloadDir " + r10 + " failed " + r13);
        return;
    L15:
        return;
    L6:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r12 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    private final void r(File r10) {
        if (r10.exists() == false) goto L22;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L13
        File[] r12 = r10.listFiles(o.f5218a);     // Catch: Throwable -> L13
        if (r12 == null) goto L10;
        Intrinsics.checkNotNullExpressionValue(r12, "listFiles { f -> f.name.contains(\"_temp\") }");     // Catch: Throwable -> L13
        int r13 = 0;
        int r14 = r12.length;     // Catch: Throwable -> L13
    L7:
        if (r13 >= r14) goto L9;
        File r15 = r12[r13];     // Catch: Throwable -> L13
        Intrinsics.checkNotNullExpressionValue(r15, "it");     // Catch: Throwable -> L13
        FilesKt.deleteRecursively(r15);     // Catch: Throwable -> L13
        r13 = r13 + 1;     // Catch: Throwable -> L13
        goto L7
    L9:
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L13
    L11:
        Object r17 = Result.m32constructorimpl(r16);     // Catch: Throwable -> L13
    L15:
        Throwable r18 = Result.m35exceptionOrNullimpl(r17);
        if (r18 == null) goto L23;
        com.obric.aikernel.runtime.utils.d.f5417a.l("PackageUpdater", "cleanDownloadTmp " + r10 + " failed " + r18);
        return;
    L23:
        return;
    L10:
        r16 = null;
    L13:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r17 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L15
    }

    private static final boolean s(File r10) {
        String r11 = r10.getName();
        Intrinsics.checkNotNullExpressionValue(r11, "f.name");
        return StringsKt.contains$default(r11, "_temp", false, 2, null);
    }

    private final b t(Context r10) {
        Object r11 = r10.getSystemService("connectivity");
        NetworkCapabilities r12 = null;
        if ((r11 instanceof ConnectivityManager) == false) goto L5;
        ConnectivityManager r13 = (ConnectivityManager) r11;
    L6:
        if (r13 == null) goto L8;
        Network r14 = r13.getActiveNetwork();
    L9:
        if (r14 == null) goto L12;
        r12 = r13.getNetworkCapabilities(r14);
    L12:
        if (r12 != null) goto L14;
    L16:
        boolean r15 = false;
    L17:
        if (r12 != null) goto L19;
    L21:
        boolean r16 = false;
    L22:
        if (r12 != null) goto L24;
    L26:
        boolean r17 = false;
    L27:
        if (r12 != null) goto L29;
    L31:
        boolean r18 = false;
    L32:
        if (r14 == null) goto L35;
        String r19 = r14.toString();
        if (r19 == null) goto L35;
    L37:
        return new b(r15, r16, r17, r18, r19);
    L35:
        r19 = "null";
        goto L37
    L29:
        if (r12.hasTransport(1) != true) goto L31;
        r18 = true;
        goto L32
    L24:
        if (r12.hasCapability(11) != true) goto L26;
        r17 = true;
        goto L27
    L19:
        if (r12.hasCapability(16) != true) goto L21;
        r16 = true;
        goto L22
    L14:
        if (r12.hasCapability(12) != true) goto L16;
        r15 = true;
        goto L17
    L8:
        r14 = null;
        goto L9
    L5:
        r13 = null;
        goto L6
    }

    private final com.obric.aikernel.res.downloader.a u(UpdateTaskConfig r18) {
        if (r18 != null) goto L7;
        UpdateTaskConfig r10 = this.f5138f.getCfg();
        if (r10 != null) goto L8;
        r10 = f5132m.a(this.f5133a, this.f5136d, this.f5135c);
    L8:
        if (r10 == null) goto L15;
        List<DistConfig> r11 = r10.l();
        if (r11 == null) goto L15;
        List r12 = new ArrayList();
        Iterator<T> r13 = r11.iterator();
    L13:
        if (r13.hasNext() == false) goto L16;
        CollectionsKt.addAll(r12, ((DistConfig) r13.next()).d());
    L16:
        if (r12 != null) goto L18;
        r12 = CollectionsKt.emptyList();
    L18:
        ArrayList r14 = new ArrayList();
        Iterator r15 = r12.iterator();
    L20:
        if (r15.hasNext() == false) goto L24;
        Object r16 = r15.next();
        com.obric.aikernel.res.metadata.config.b r17 = (com.obric.aikernel.res.metadata.config.b) r16;
        File r19 = new File(this.f5140h, r17.m());
        if (p.g(new File(r19, r17.o()).exists(), new File(new File(r19, "encrypt"), r17.o()).exists()) == false) goto L20;
        r14.add(r16);
        goto L20
    L24:
        b r20 = t(this.f5135c.getConfig().getContext());
        boolean r21 = NetworkUtil.f5399a.e(this.f5135c.getConfig().getContext());
        ArrayList r22 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10));
        Iterator r23 = r14.iterator();
    L26:
        if (r23.hasNext() == false) goto L28;
        r22.add(TuplesKt.to(Boolean.valueOf(((com.obric.aikernel.res.metadata.config.b) r23.next()).u()), Boolean.TRUE));
        goto L26
    L28:
        boolean r24 = p.d(r22);
        NetworkUtil r25 = NetworkUtil.f5399a;
        boolean r26 = false;
        if (r25.f(this.f5135c.getConfig().getContext()) == false) goto L31;
    L34:
        boolean r110 = true;
    L35:
        boolean r27 = this.f5135c.getConfig().getAppConfig().getAllowNetworkRequest().invoke().booleanValue();
        if (r14.isEmpty() == true) goto L44;
        Iterator r28 = r14.iterator();
    L40:
        if (r28.hasNext() == false) goto L44;
        if (((com.obric.aikernel.res.metadata.config.b) r28.next()).l() == false) goto L40;
        r26 = true;
    L44:
        boolean r111 = r110;
        com.obric.aikernel.res.downloader.a r112 = com.obric.aikernel.res.downloader.b.a(new com.obric.aikernel.res.downloader.c(r27, true, r26, this.f5138f.getBackground(), this.f5135c.getConfig().getAppConfig().getAllowBackgroundUpdate().getValue().getFirst().booleanValue(), this.f5135c.getConfig().getAppConfig().getAllowBackgroundUpdate().getValue().getSecond(), r21, r24, r110));
        if (r112.a() == false) goto L47;
    L52:
        boolean r29 = r111;
    L53:
        com.obric.aikernel.runtime.utils.d.f5417a.d("PackageUpdater", "currentDownloadConstraintGate biz=" + this.f5133a + " cfg=" + z(r10) + " stage=" + this.f5138f.getStage() + " connectivitySnapshot=" + r20 + " directValidated=" + r21 + " directUnmetered=" + r29 + " allowBg=" + this.f5135c.getConfig().getAppConfig().getAllowBackgroundUpdate().getValue() + " requireUnmetered=" + r24 + " pendingDownloads=" + CollectionsKt.joinToString$default(r14, null, "[", "]", 0, null, UpdateTask$currentDownloadConstraintGate$1$1.INSTANCE, 25, null) + " gate=" + r112.c() + ':' + r112.b());
    L54:
        return r112;
    L47:
        if (r20.a() != r21) goto L52;
        if (r24 == false) goto L54;
        r29 = r111;
        if (r20.b() == r29) goto L54;
    L31:
        if (r25.d(this.f5135c.getConfig().getContext()) == true) goto L34;
        r110 = false;
    L15:
        r12 = null;
        goto L16
    L7:
        r10 = r18;
        goto L8
    }

    static /* synthetic */ com.obric.aikernel.res.downloader.a v(UpdateTask r10, UpdateTaskConfig r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r11 = null;
    L6:
        return r10.u(r11);
    }

    private final Pair<Integer, Boolean> w() {
        monitor-enter(this);
        Pair<Integer, Boolean> r10 = TuplesKt.to(Integer.valueOf(this.f5138f.getPrior()), Boolean.valueOf(this.f5138f.getBackground()));     // Catch: Throwable -> L6
        monitor-exit(this);
        return r10;
    L6:
        th = move-exception;
        throw th;
    }

    private final String x(DistConfig r10) {
        return CollectionsKt.joinToString$default(r10.d(), null, "[", "]", 0, null, UpdateTask$describeDownloadsForLog$1.INSTANCE, 25, null);
    }

    private final String y(LoraConfig r10) {
        if (r10 == null) goto L5;
        String r11 = r10.o();
        if (r11 == null) goto L5;
        return r11;
    L5:
        return "[]";
    }

    private final String z(UpdateTaskConfig r10) {
        if (r10 != null) goto L5;
        return "unknown";
    L5:
        if ((r10 instanceof LoraConfig) == false) goto L10;
        StringBuilder r11 = new StringBuilder();
        String r12 = "lora:";
    L7:
        r11.append(r12);
    L8:
        r11.append(r10.g());
        r11.append('@');
        r11.append(r10.i());
        return r11.toString();
    L10:
        if ((r10 instanceof com.obric.aikernel.res.metadata.config.e) == false) goto L12;
        r11 = new StringBuilder();
        r12 = "package:";
        goto L7
    L12:
        r11 = new StringBuilder();
        r11.append(r10.h());
        r11.append(':');
        goto L8
    }

    public final Object D(Continuation<? super Boolean> r14) {
        if ((r14 instanceof UpdateTask$doUpdate$1) == false) goto L7;
        UpdateTask$doUpdate$1 r10 = (UpdateTask$doUpdate$1) r14;
        int r11 = r10.label;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r10.label = r11 - Integer.MIN_VALUE;
    L8:
        Object r15 = r10.result;
        Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r13 = r10.label;
        if (r13 == 0) goto L16;
        if (r13 == 1) goto L15;
        if (r13 != 2) goto L14;
        UpdateTask this = (UpdateTask) r10.L$0;
        ResultKt.throwOnFailure(r15);
    L27:
        boolean r16 = ((Boolean) r15).booleanValue();
        com.obric.aikernel.runtime.utils.d r17 = com.obric.aikernel.runtime.utils.d.f5417a;
        r17.i("PackageUpdater", "doUpdate after process biz=" + this.f5133a + " success=" + r16 + " stage=" + this.f5138f.getStage() + " finished=" + this.f5138f.getFinished() + " msg=" + StringsKt.take(this.f5138f.getMsg(), 160));
        if (r16 == true) goto L30;
        UpdateResult r18 = this.f5138f;
        String r19 = "process";
        String r20 = "doProcessFiles returned false";
    L22:
        p.c(r18, r19, r20);
        return Boxing.boxBoolean(false);
    L30:
        boolean r110 = this.B();
        r17.i("PackageUpdater", "doUpdate after install biz=" + this.f5133a + " success=" + r110 + " stage=" + this.f5138f.getStage() + " finished=" + this.f5138f.getFinished() + " msg=" + StringsKt.take(this.f5138f.getMsg(), 160));
        if (r110 == true) goto L34;
        p.c(this.f5138f, "install", "doInstall returned false");
    L34:
        return Boxing.boxBoolean(r110);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        this = (UpdateTask) r10.L$0;
        ResultKt.throwOnFailure(r15);
    L19:
        boolean r111 = ((Boolean) r15).booleanValue();
        com.obric.aikernel.runtime.utils.d.f5417a.i("PackageUpdater", "doUpdate after download biz=" + this.f5133a + " success=" + r111 + " stage=" + this.f5138f.getStage() + " finished=" + this.f5138f.getFinished() + " msg=" + StringsKt.take(this.f5138f.getMsg(), 160));
        if (r111 == true) goto L24;
        r18 = this.f5138f;
        r19 = "download";
        r20 = "doDownload returned false";
        goto L22
    L24:
        r10.L$0 = this;
        r10.label = 2;
        r15 = this.C(r10);
        if (r15 != r12) goto L27;
        return r12;
    L16:
        ResultKt.throwOnFailure(r15);
        com.obric.aikernel.runtime.utils.d.f5417a.i("PackageUpdater", "doUpdate start biz=" + this.f5133a + " cfg=" + z(this.f5138f.getCfg()) + " caller=" + this.f5138f.getCaller() + " background=" + this.f5138f.getBackground());
        r10.L$0 = this;
        r10.label = 1;
        r15 = A(r10);
        if (r15 != r12) goto L19;
        return r12;
    L7:
        r10 = new UpdateTask$doUpdate$1(this, r14);
        goto L8
    }

    public final r0<UpdateResult> F() {
        return this.f5142j;
    }

    public final float G() {
        if (this.f5138f.getSuccess() == false) goto L6;
        return 100.0f;
    L6:
        if (this.f5138f.getFinished() == true) goto L14;
        float r10 = this.f5138f.getStage();
        float r11 = 0.0f;
        if (this.f5138f.getStage() != 200) goto L11;
        r11 = this.f5135c.getDownloadCtrl$resource_manager_release().q(this.f5139g);
    L11:
        float r12 = 100;
        float r13 = r10 + (r11 * r12);
        float r14 = r12 * (r13 / 500);
        com.obric.aikernel.runtime.utils.d.f5417a.d("PackageUpdater", "getUpdateProgress: " + r14 + '(' + r13 + '-' + r11 + ") from " + this.f5138f);
        return r14;
    L14:
        return -this.f5138f.getStage();
    }

    public final UpdateResult H() {
        return this.f5138f;
    }

    public final boolean L(long r10) {
        if (this.f5138f.getFinished() == true) goto L6;
    L17:
        return false;
    L6:
        if (this.f5138f.getFinishTimestamp() == 0) goto L17;
        if (this.f5138f.getSuccess() == false) goto L14;
        if (r10 <= (this.f5138f.getFinishTimestamp() + 300000)) goto L14;
        return true;
    L14:
        if (this.f5138f.getSuccess() == true) goto L17;
        if (r10 <= (this.f5138f.getFinishTimestamp() + WorkRequest.MIN_BACKOFF_MILLIS)) goto L17;
        return true;
    }

    public final void N(UpdateTaskConfig r15) {
        Intrinsics.checkNotNullParameter(r15, "cfg");
        boolean r10 = p.k(this.f5138f.getCaller());
        if ((r15 instanceof com.obric.aikernel.res.metadata.config.e) == false) goto L6;
        boolean r11 = this.f5135c.getMetadataCtrl$resource_manager_release().y(r15.g(), r15.i(), r15.f(), r10);
    L10:
        if ((r15 instanceof LoraConfig) == false) goto L24;
        Lora r12 = new Lora(r15.g(), r15.i(), this.f5135c.getConfig());
        DistConfig r13 = r12.s();
        if (r13 == null) goto L14;
        LoraConfig r14 = new LoraConfig(r15.g(), r13.f());
    L15:
        String r16 = ((LoraConfig) r15).o();
        String r17 = y(r14);
        com.obric.aikernel.runtime.utils.d r18 = com.obric.aikernel.runtime.utils.d.f5417a;
        StringBuilder r19 = new StringBuilder();
        r19.append("onNewConfig lora decision biz=");
        r19.append(this.f5133a);
        r19.append(" remote=");
        r19.append(r15.g());
        r19.append('@');
        r19.append(r15.i());
        r19.append(" localConfig=");
        if (r14 == null) goto L18;
        boolean r20 = true;
    L19:
        r19.append(r20);
        r19.append(" localReady=");
        r19.append(r12.a0());
        r19.append(" localAvailable=");
        r19.append(r12.H());
        r19.append(" fastCheck=");
        r19.append(r10);
        r19.append(" needUpdate=");
        r19.append(r11);
        r19.append(" remoteModels=");
        r19.append(r16);
        r19.append(" localModels=");
        r19.append(r17);
        r18.d("PackageUpdater", r19.toString());
        if (r11 == false) goto L22;
    L25:
        monitor-enter(this);
        if (r11 == false) goto L44;
        r0<UpdateResult> r21 = this.f5142j;     // Catch: Throwable -> L48
        if (r21 != null) goto L30;
    L32:
        boolean r22 = false;
    L34:
        if (p.j(r22, this.f5144l) == true) goto L38;
        com.obric.aikernel.runtime.utils.d.f5417a.i("PackageUpdater", "onNewConfig updateTask Running ignore this request");     // Catch: Throwable -> L48
        monitor-exit(this);
        return;
    L38:
        this.f5144l = true;     // Catch: Throwable -> L48
        this.f5138f.start(r15);     // Catch: Throwable -> L48
        m(r15);     // Catch: Throwable -> L48
        r0<UpdateResult> r110 = kotlinx.coroutines.h.b(this.f5134b, null, null, new UpdateTask$onNewConfig$1$1(this, null), 3, null);     // Catch: Throwable -> L41
        r110.A(new UpdateTask$onNewConfig$1$2$1(this));     // Catch: Throwable -> L41
        this.f5142j = r110;     // Catch: Throwable -> L48
    L45:
        Unit r111 = Unit.INSTANCE;     // Catch: Throwable -> L48
        monitor-exit(this);
        return;
    L41:
        th = move-exception;
        this.f5144l = false;     // Catch: Throwable -> L48
        throw th;     // Catch: Throwable -> L48
    L30:
        if (r21.isActive() != true) goto L32;
        r22 = true;
        goto L34
    L44:
        com.obric.aikernel.runtime.utils.d.f5417a.i("PackageUpdater", "onNewConfig no need update biz=" + this.f5133a + " cfg=" + z(r15) + " stageBefore=" + this.f5138f.getStage() + " stageLabel=" + PackageUpdaterKt.g(this.f5138f.getStage()));     // Catch: Throwable -> L48
        this.f5138f.success("no need to update");     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        throw th;
    L22:
        if (Intrinsics.areEqual(r16, r17) == true) goto L25;
        r18.d("PackageUpdater", "onNewConfig lora skipped update with model drift biz=" + this.f5133a + " remote=" + r15.g() + '@' + r15.i() + " remoteModels=" + r16 + " localModels=" + r17);
        goto L25
    L18:
        r20 = false;
        goto L19
    L14:
        r14 = null;
        goto L15
    L24:
        com.obric.aikernel.runtime.utils.d.f5417a.i("PackageUpdater", "onNewConfig: " + this.f5133a + ' ' + r15.g() + '@' + r15.i() + " fastCheck:" + r10 + " needUpdate:" + r11);
        goto L25
    L6:
        if ((r15 instanceof LoraConfig) == false) goto L8;
        r11 = Lora.f5072s.c(r15.g(), r15.i(), this.f5135c.getConfig(), r10);
        goto L10
    L8:
        r11 = false;
        goto L10
    }

    public final void P(PackageUpdater.b r10) {
        Intrinsics.checkNotNullParameter(r10, "constriction");
        if (this.f5135c.getConfig().getPackageActionInjector().a(1, this.f5133a, r10.b()) == true) goto L6;
        com.obric.aikernel.runtime.utils.d.f5417a.i("PackageUpdater", "tryResume disallowed by packageActionInjector biz=" + this.f5133a + " caller=" + r10.b());
        return;
    L6:
        l(r10);
        UpdateTaskConfig r11 = this.f5138f.getCfg();
        if (r11 != null) goto L10;
        r11 = f5132m.a(this.f5133a, this.f5136d, this.f5135c);
    L10:
        if (r11 != null) goto L13;
        com.obric.aikernel.runtime.utils.d.f5417a.d("PackageUpdater", "tryResume no config biz=" + this.f5133a + " caller=" + r10.b() + " stage=" + this.f5138f.getStage() + " stageLabel=" + PackageUpdaterKt.g(this.f5138f.getStage()) + " finished=" + this.f5138f.getFinished());
        return;
    L13:
        com.obric.aikernel.runtime.utils.d.f5417a.d("PackageUpdater", "tryResume with config biz=" + this.f5133a + " cfg=" + z(r11) + " caller=" + r10.b() + " stage=" + this.f5138f.getStage() + " stageLabel=" + PackageUpdaterKt.g(this.f5138f.getStage()) + " finished=" + this.f5138f.getFinished());
        N(r11);
    }

    public final boolean Q(PackageUpdater.b r12, String r13) {
        Intrinsics.checkNotNullParameter(r12, "constriction");
        Intrinsics.checkNotNullParameter(r13, "trigger");
        Integer r10 = E();
        if (r10 == null) goto L13;
        int r11 = r10.intValue();
        UpdateTaskConfig r14 = this.f5138f.getCfg();
        if (r14 != null) goto L7;
        r14 = f5132m.a(this.f5133a, this.f5136d, this.f5135c);
    L7:
        com.obric.aikernel.res.downloader.a r15 = v(this, null, 1, null);
        if (r15.a() == false) goto L11;
        com.obric.aikernel.runtime.utils.d.f5417a.d("PackageUpdater", "tryResumeIfDownloadConstraintReady keep waiting biz=" + this.f5133a + " cfg=" + z(r14) + " trigger=" + r13 + " stage=" + this.f5138f.getStage() + " blockedState=" + r11 + " currentGate=" + r15.c() + ':' + r15.b());
        return true;
    L11:
        com.obric.aikernel.runtime.utils.d.f5417a.d("PackageUpdater", "tryResumeIfDownloadConstraintReady resume biz=" + this.f5133a + " cfg=" + z(r14) + " trigger=" + r13 + " stage=" + this.f5138f.getStage() + " blockedState=" + r11);
        P(r12);
        return true;
    L13:
        return false;
    }

    public final boolean R(PackageUpdater.b r10, String r11, long r12) {
        Intrinsics.checkNotNullParameter(r10, "constriction");
        Intrinsics.checkNotNullParameter(r11, "trigger");
        UpdateTaskConfig r13 = f5132m.c(this.f5136d, this.f5133a, this.f5135c.getConfig());
        if (r13 != null) goto L5;
        return false;
    L5:
        UpdateResult r14 = this.f5138f;
        r0<UpdateResult> r15 = this.f5142j;
        if (r15 != null) goto L8;
    L10:
        boolean r16 = false;
    L12:
        if (PackageUpdaterKt.q(true, r14, r16, r12) == true) goto L14;
        return false;
    L14:
        com.obric.aikernel.res.downloader.a r17 = u(r13);
        if (r17.a() == false) goto L18;
        com.obric.aikernel.runtime.utils.d.f5417a.d("PackageUpdater", "tryResumePendingPackageIfDownloadReady keep waiting biz=" + this.f5133a + " pendingCfg=" + z(r13) + " trigger=" + r11 + " stage=" + this.f5138f.getStage() + " currentGate=" + r17.c() + ':' + r17.b());
        return true;
    L18:
        com.obric.aikernel.runtime.utils.d.f5417a.d("PackageUpdater", "tryResumePendingPackageIfDownloadReady resume biz=" + this.f5133a + " pendingCfg=" + z(r13) + " trigger=" + r11 + " stage=" + this.f5138f.getStage());
        P(r10);
        return true;
    L8:
        if (r15.isActive() != true) goto L10;
        r16 = true;
        goto L12
    }

    public final void n(CoroutineContext r10, PackageUpdater.b r11) {
        Intrinsics.checkNotNullParameter(r10, "coroutineContext");
        Intrinsics.checkNotNullParameter(r11, "constriction");
        monitor-enter(this);
        com.obric.aikernel.runtime.utils.d r12 = com.obric.aikernel.runtime.utils.d.f5417a;     // Catch: Throwable -> L14
        StringBuilder r13 = new StringBuilder();     // Catch: Throwable -> L14
        r13.append("attachContext: try attach ");     // Catch: Throwable -> L14
        v1.b r14 = v1.f10723e;     // Catch: Throwable -> L14
        r13.append(r10.get(r14));     // Catch: Throwable -> L14
        r13.append(" to ");     // Catch: Throwable -> L14
        r13.append(this.f5139g);     // Catch: Throwable -> L14
        r13.append('-');     // Catch: Throwable -> L14
        r13.append(this);     // Catch: Throwable -> L14
        r12.i("PackageUpdater", r13.toString());     // Catch: Throwable -> L14
        final v1 r15 = (v1) r10.get(r14);     // Catch: Throwable -> L14
        if (r15 != null) goto L7;
    L9:
        boolean r16 = p.a(this.f5138f, r11);     // Catch: Throwable -> L14
        monitor-exit(this);
        if (r16 == false) goto L19;
        M();
        return;
    L19:
        return;
    L7:
        if (this.f5143k.add(r15) == false) goto L9;
        r15.A(new UpdateTask$attachContext$1$1$1(this, r15));     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    public final Object o(Continuation<? super UpdateResult> r10) {
        if ((r10 instanceof UpdateTask$await$1) == false) goto L7;
        UpdateTask$await$1 r11 = (UpdateTask$await$1) r10;
        int r12 = r11.label;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r11.label = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r11.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r11.label;
        if (r15 == 0) goto L14;
        if (r15 != 1) goto L13;
        UpdateTask this = (UpdateTask) r11.L$0;
        ResultKt.throwOnFailure(r13);
    L19:
        UpdateResult r16 = (UpdateResult) r13;
        if (r16 == null) goto L22;
        return r16;
    L22:
        return this.f5138f;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        r0<UpdateResult> r17 = this.f5142j;
        if (r17 == null) goto L22;
        r11.L$0 = this;
        r11.label = 1;
        r13 = r17.r(r11);
        if (r13 != r14) goto L19;
        return r14;
    L7:
        r11 = new UpdateTask$await$1(this, r10);
        goto L8
    }
}
