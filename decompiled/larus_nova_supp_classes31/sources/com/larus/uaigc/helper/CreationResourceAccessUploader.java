package com.larus.uaigc.helper;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.bigimg.ImageSave;
import com.larus.bmhome.chat.bean.ProcessFileResultCode;
import com.larus.bmhome.resource.access.ResourceInputType;
import com.larus.bmhome.resource.access.ResourceMediaType;
import com.larus.bmhome.resource.access.x0;
import com.larus.bmhome.resource.access.y0;
import com.larus.platform.model.upload.ResourceUploadError;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class CreationResourceAccessUploader {
    public static final CreationResourceAccessUploader a = null;
    public static final CoroutineScope b = null;
    public static final ConcurrentHashMap<String, a> c = null;
    public static final ConcurrentHashMap<String, a> d = null;
    public static final ConcurrentHashMap<String, com.larus.bmhome.resource.access.f0> e = null;
    public static final ConcurrentHashMap<String, Long> f = null;
    public static final Object g = null;
    public static final ConcurrentHashMap<String, Long> h = null;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/larus/uaigc/helper/CreationResourceAccessUploader$LegacyPrepareException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "error", "Lcom/larus/platform/model/upload/ResourceUploadError;", "<init>", "(Lcom/larus/platform/model/upload/ResourceUploadError;)V", "getError", "()Lcom/larus/platform/model/upload/ResourceUploadError;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public static final class LegacyPrepareException extends RuntimeException {
        private final ResourceUploadError error;

        public final ResourceUploadError getError() {
            return this.error;
        }

        public LegacyPrepareException(ResourceUploadError r2) {
            Intrinsics.checkNotNullParameter(r2, "error");
            super(r2.getMsg());
            this.error = r2;
        }
    }

    public static final class a implements com.larus.bmhome.resource.access.b0 {
        public final String a;
        public final com.larus.bmhome.resource.access.r0 b;
        public final com.larus.bmhome.resource.access.w c;
        public final StateFlowImpl d;
        public final long e;
        public final AtomicReference<Job> f;
        public long g;
        public final StateFlowImpl h;

        public final boolean c() {
            return com.larus.bmhome.resource.access.s.b((com.larus.bmhome.resource.access.a0) this.d.getValue());
        }

        public final com.larus.bmhome.resource.access.z snapshot() {
            return new com.larus.bmhome.resource.access.z(this.a, this.b, (com.larus.bmhome.resource.access.a0) this.d.getValue(), this.c, this.e, this.g, 64);
        }

        public final StateFlowImpl a() {
            return this.h;
        }

        public final StateFlowImpl b() {
            return com.larus.bmhome.resource.access.s.a;
        }

        public final String getTaskId() {
            return this.a;
        }

        public final boolean d(com.larus.bmhome.resource.access.a0 r3) {
            Intrinsics.checkNotNullParameter(r3, "state");
            if (com.larus.bmhome.resource.access.s.b((com.larus.bmhome.resource.access.a0) this.d.getValue()) == false) goto L6;
            return false;
        L6:
            this.g = System.currentTimeMillis();
            this.d.setValue(r3);
            return true;
        }

        public final void update(com.larus.bmhome.resource.access.a0 r3) {
            Intrinsics.checkNotNullParameter(r3, "state");
            this.g = System.currentTimeMillis();
            this.d.setValue(r3);
        }

        public a(String r2, com.larus.bmhome.resource.access.r0 r3, com.larus.bmhome.resource.access.w r4) {
            Intrinsics.checkNotNullParameter(r2, "taskId");
            Intrinsics.checkNotNullParameter(r3, "key");
            Intrinsics.checkNotNullParameter(r4, "request");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            StateFlowImpl r5 = j1.a(com.larus.bmhome.resource.access.a0.b.a);
            this.d = r5;
            long r6 = System.currentTimeMillis();
            this.e = r6;
            this.f = new AtomicReference();
            this.g = r6;
            this.h = r5;
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ResourceMediaType.values().length];
            r0[ResourceMediaType.VIDEO.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[ResourceMediaType.IMAGE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[ResourceMediaType.FILE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public static final class c<T> implements Comparator {
        public c() {
        }

        @Override // java.util.Comparator
        public final int compare(T r1, T r2) {
            return ComparisonsKt.compareValues((Long) ((Map.Entry) r1).getValue(), (Long) ((Map.Entry) r2).getValue());
        }
    }

    public static final class d<T> implements Comparator {
        public d() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r3, T r4) {
            return ComparisonsKt.compareValues(Long.valueOf(((a) r3).g), Long.valueOf(((a) r4).g));
        }
    }

    public CreationResourceAccessUploader() {
    }

    static {
        a = new CreationResourceAccessUploader();
        b = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        c = new ConcurrentHashMap();
        d = new ConcurrentHashMap();
        e = new ConcurrentHashMap();
        f = new ConcurrentHashMap();
        g = new Object();
        h = new ConcurrentHashMap();
    }

    public static void e() {
        ConcurrentHashMap<String, com.larus.bmhome.resource.access.f0> r0 = e;
        if (r0.isEmpty() == false) goto L5;
        return;
    L5:
        long r1 = System.currentTimeMillis();
        Set<String> r2 = r0.keySet();
        ArrayList r3 = new ArrayList();
        Iterator<T> r4 = r2.iterator();
    L7:
        if (r4.hasNext() == false) goto L11;
        Object r5 = r4.next();
        if ((true ^ f.containsKey((String) r5)) == false) goto L7;
        r3.add(r5);
        goto L7
    L11:
        Iterator r6 = r3.iterator();
    L13:
        if (r6.hasNext() == false) goto L15;
        String r7 = (String) r6.next();
        Intrinsics.checkNotNull(r7);
        e.remove(r7);
        f.remove(r7);
        goto L13
    L15:
        List r8 = CollectionsKt.toList(f.entrySet());
        ArrayList r9 = new ArrayList();
        Iterator r10 = r8.iterator();
    L16:
        boolean r11 = false;
        if (r10.hasNext() == false) goto L23;
        Object r12 = r10.next();
        if ((r1 - ((Number) ((Map.Entry) r12).getValue()).longValue()) <= 600000) goto L21;
        r11 = true;
    L21:
        if (r11 == false) goto L16;
        r9.add(r12);
        goto L16
    L23:
        Iterator r13 = r9.iterator();
    L25:
        if (r13.hasNext() == false) goto L27;
        String r14 = (String) ((Map.Entry) r13.next()).getKey();
        e.remove(r14);
        f.remove(r14);
        goto L25
    L27:
        int r15 = RangesKt.coerceAtLeast(e.size() - 256, 0);
        if (r15 <= 0) goto L33;
        Iterator r16 = CollectionsKt.take(CollectionsKt.sortedWith(f.entrySet(), new c()), r15).iterator();
    L31:
        if (r16.hasNext() == false) goto L47;
        String r17 = (String) ((Map.Entry) r16.next()).getKey();
        e.remove(r17);
        f.remove(r17);
        goto L31
    L47:
        return;
    }

    public static void f() {
        ConcurrentHashMap<String, a> r0 = d;
        if (r0.isEmpty() == false) goto L5;
        return;
    L5:
        long r1 = System.currentTimeMillis();
        List r2 = SequencesKt.toList(SequencesKt.filter(CollectionsKt.asSequence(r0.values()), new u()));
        LinkedHashSet r3 = new LinkedHashSet();
        List r4 = r2;
        ArrayList r5 = new ArrayList();
        Iterator r6 = r4.iterator();
    L6:
        boolean r7 = true;
        if (r6.hasNext() == false) goto L14;
        Object r8 = r6.next();
        if ((r1 - ((a) r8).g) > 600000) goto L12;
        r7 = false;
    L12:
        if (r7 == false) goto L6;
        r5.add(r8);
        goto L6
    L14:
        Iterator r9 = r5.iterator();
    L16:
        if (r9.hasNext() == false) goto L18;
        r3.add((a) r9.next());
        goto L16
    L18:
        int r10 = RangesKt.coerceAtLeast(d.size() - 256, 0);
        if (r10 <= 0) goto L24;
        Iterator r11 = CollectionsKt.take(CollectionsKt.sortedWith(r4, new d()), r10).iterator();
    L22:
        if (r11.hasNext() == false) goto L24;
        r3.add((a) r11.next());
    L24:
        Iterator r12 = r3.iterator();
    L26:
        if (r12.hasNext() == false) goto L33;
        a r13 = (a) r12.next();
        d.remove(r13.a, r13);
        String r14 = r13.c.d.a;
        if (r14.length() <= 0) goto L30;
        boolean r15 = true;
    L31:
        if (r15 == false) goto L26;
        c.remove(r14, r13);
        goto L26
    L30:
        r15 = false;
        goto L31
    }

    public static void g(String r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (r1.length() <= 0) goto L6;
        boolean r0 = true;
    L7:
        if (r0 == true) goto L10;
        r1 = null;
    L10:
        if (r1 == null) goto L15;
        h.remove(r1);
        return;
    L15:
        return;
    L6:
        r0 = false;
        goto L7
    }

    public static void h(String r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r3.length() <= 0) goto L6;
        boolean r0 = true;
    L7:
        if (r0 == true) goto L10;
        r3 = null;
    L10:
        if (r3 == null) goto L15;
        h.put(r3, Long.valueOf(System.currentTimeMillis()));
        FLogger.a.i("CreationResourceAccessUploader", "[markSendHandoff] identifier=".concat(r3));
        return;
    L15:
        return;
    L6:
        r0 = false;
        goto L7
    }

    public static com.larus.bmhome.resource.access.b0 l(com.larus.uaigc.service.p0 r29) {
        Intrinsics.checkNotNullParameter(r29, "request");
        String r1 = r29.e;
        if (r1.length() <= 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == true) goto L9;
        r1 = null;
    L9:
        if (r1 != null) goto L11;
        r1 = UUID.randomUUID().toString();
    L11:
        String r7 = r1;
        com.larus.bmhome.resource.access.x r3 = r29.a;
        ResourceMediaType r4 = r29.b;
        com.larus.bmhome.resource.access.j0.b r15 = r29.c;
        String r8 = r29.d;
        String r6 = r29.f;
        if (r6 == null) goto L14;
    L20:
        String r9 = r6;
    L21:
        mr9.h r14 = r29.g;
        Boolean r10 = r29.h;
        if (r10 == null) goto L25;
        boolean r12 = r10.booleanValue();
    L31:
        CountDownLatch r13 = r29.i;
        String r11 = r29.j;
        String r16 = r29.k;
        String r17 = r29.l;
        Function1<mr9.k, Unit> r5 = r29.m;
        Function1<mr9.l, Unit> r18 = r29.n;
        Function1<ResourceUploadError, Unit> r19 = r29.o;
        Boolean r20 = r29.p;
        if (r20 == null) goto L34;
        boolean r21 = r20.booleanValue();
        Function1<mr9.l, Unit> r23 = r18;
    L61:
        Boolean r22 = r29.q;
        if (r22 == null) goto L64;
        boolean r24 = r22.booleanValue();
        Function1<ResourceUploadError, Unit> r25 = r19;
    L68:
        Boolean r26 = r29.r;
        if (r26 == null) goto L71;
        boolean r27 = r26.booleanValue();
        com.larus.bmhome.resource.access.x r28 = r3;
    L75:
        Map<String, String> r30 = r29.s;
        Map<String, String> r31 = r29.t;
        com.larus.bmhome.resource.access.d0 r32 = r29.u;
        boolean r33 = r29.v;
        CoroutineScope r0 = r29.w;
        Object r110 = g;
        monitor-enter(r110);
        e.remove(r7);     // Catch: Throwable -> L143
        f.remove(r7);     // Catch: Throwable -> L143
        Unit r34 = Unit.INSTANCE;     // Catch: Throwable -> L143
        monitor-exit(r110);
        boolean r35 = r15 instanceof com.larus.bmhome.resource.access.j0.b;
        if (r35 == false) goto L83;
        com.larus.bmhome.resource.access.j0.b r111 = r15;
    L84:
        if (r111 == null) goto L86;
        mr9.c r112 = r111.f;
    L87:
        if (r35 == false) goto L89;
        com.larus.bmhome.resource.access.j0.b r36 = r15;
    L90:
        if (r36 == null) goto L92;
        Long r37 = r36.e;
    L93:
        com.larus.bmhome.resource.access.v r113 = new com.larus.bmhome.resource.access.v(r21, r24, r27, 24);
        if (r17 != null) goto L96;
    L106:
        com.larus.bmhome.resource.access.w r38 = new com.larus.bmhome.resource.access.w(r28, r15, r4, new com.larus.bmhome.resource.access.g0(r7, r8, r9, r16, r11, r12, r13, r14, r112, r37, r113, r32, r30, r31));
        f.a.getClass();
        if (f.a() == true) goto L135;
        String r39 = r38.d.a;
        String r40 = UUID.randomUUID().toString();
        com.larus.bmhome.resource.access.x r41 = r38.a;
        String r42 = r38.d.a;
        if (r42.length() <= 0) goto L111;
        boolean r43 = true;
    L112:
        if (r43 == true) goto L115;
        r42 = null;
    L115:
        if (r42 != null) goto L117;
        r42 = r38.b.a();
    L117:
        a r44 = new a(r40, new com.larus.bmhome.resource.access.r0(r41, r42, r38.c, r38.d.c), r38);
        d.put(r44.a, r44);
        if (r39.length() <= 0) goto L120;
        boolean r210 = true;
    L121:
        if (r210 == false) goto L123;
        c.put(r39, r44);
    L123:
        f();
        Job r45 = BuildersKt.launch$default(b, null, null, new CreationResourceAccessUploader$submitLegacyUpload$job$1(r44, r25, r39, r38, r23, r5, null), 3, null);
        Intrinsics.checkNotNullParameter(r45, "job");
        if (r44.c() == false) goto L126;
        Job.DefaultImpls.cancel$default(r45, null, 1, null);
    L134:
        FLogger.a.i("CreationResourceAccessUploader", "[submitLegacyUpload] pipeline disabled, use legacy upload taskId=" + r44.a + ", fileIdentifier=" + r39 + ", mediaType=" + r38.c);
    L142:
        return r44;
    L126:
        Job r46 = r44.f.getAndSet(r45);
        if (r46 == null) goto L130;
        Job.DefaultImpls.cancel$default(r46, null, 1, null);
    L130:
        if (r44.c() == false) goto L134;
        Job r47 = r44.f.getAndSet(null);
        if (r47 == null) goto L134;
        Job.DefaultImpls.cancel$default(r47, null, 1, null);
        goto L134
    L120:
        r210 = false;
        goto L121
    L111:
        r43 = false;
        goto L112
    L135:
        com.larus.bmhome.resource.access.y r48 = com.larus.bmhome.resource.access.y.a;
        r44 = com.larus.bmhome.resource.access.y.a(r38);
        CoroutineScope r49 = b;
        BuildersKt.launch$default(r49, null, null, new CreationResourceAccessUploader$submitPipelineUpload$1(r44, r38, null), 3, null);
        if (r33 == false) goto L141;
        if (r0 != null) goto L139;
        CoroutineScope r114 = r49;
    L140:
        BuildersKt.launch$default(r114, Dispatchers.getIO(), null, new CreationResourceAccessUploader$submitPipelineUpload$2(r44, r38, r23, r25, r5, null), 2, null);
        goto L141
    L139:
        r114 = r0;
    L141:
        FLogger.a.i("CreationResourceAccessUploader", "[submitPipelineUpload] submit taskId=" + ((com.larus.bmhome.resource.access.f) r44).a + ", fileIdentifier=" + r38.d.a + ", mediaType=" + r38.c);
        goto L142
    L96:
        if (r17.length() <= 0) goto L98;
        boolean r50 = true;
    L99:
        if (r50 == true) goto L102;
        r17 = null;
    L102:
        if (r17 == null) goto L106;
        Map<String, String> r51 = MapsKt.plus(r30, TuplesKt.to("preprocess_sub_scene", r17));
        if (r51 == null) goto L106;
        r30 = r51;
        goto L106
    L98:
        r50 = false;
        goto L99
    L92:
        r37 = null;
        goto L93
    L89:
        r36 = null;
        goto L90
    L86:
        r112 = null;
        goto L87
    L83:
        r111 = null;
    L143:
        th = move-exception;
        throw th;
    L71:
        r28 = r3;
        if (r29.b != ResourceMediaType.IMAGE) goto L74;
        r27 = true;
        goto L75
    L74:
        r27 = false;
        goto L75
    L64:
        r25 = r19;
        if (r29.b != ResourceMediaType.IMAGE) goto L67;
        r24 = true;
        goto L68
    L67:
        r24 = false;
        goto L68
    L34:
        r23 = r18;
        if (r29.b == ResourceMediaType.IMAGE) goto L38;
    L59:
        r21 = false;
        goto L61
    L38:
        if (Intrinsics.areEqual(r29.a, com.larus.uaigc.service.f.b) == true) goto L60;
        com.larus.bmhome.resource.access.j0.b r52 = r29.c;
        if ((r52 instanceof com.larus.bmhome.resource.access.j0.b) == false) goto L60;
        com.larus.bmhome.resource.access.j0.b r53 = r52;
        String r54 = r53.c;
        if (r54 != null) goto L45;
    L48:
        boolean r55 = true;
    L49:
        if (r55 == true) goto L51;
    L56:
        boolean r56 = true;
    L57:
        if (r56 == true) goto L59;
    L51:
        if (r53.e != null) goto L56;
        if (r53.f != null) goto L56;
        r56 = false;
        goto L57
    L45:
        if (r54.length() == 0) goto L48;
        r55 = false;
    L60:
        r21 = true;
        goto L61
    L25:
        if (r29.b != ResourceMediaType.VIDEO) goto L27;
    L30:
        r12 = true;
        goto L31
    L27:
        if (Intrinsics.areEqual(r29.a, com.larus.uaigc.service.f.b) == true) goto L30;
        r12 = false;
        goto L31
    L14:
        if (Intrinsics.areEqual(r3, com.larus.uaigc.service.f.b) == false) goto L17;
        r6 = "canvas";
        goto L20
    L17:
        if (Intrinsics.areEqual(r29.a, com.larus.uaigc.service.f.c) == false) goto L19;
        r6 = "creation_video";
        goto L20
    L19:
        r9 = null;
        goto L21
    L5:
        r2 = false;
        goto L6
    }

    public final com.larus.bmhome.resource.access.z query(String r3) {
        f();
        if (r3 != null) goto L5;
        return null;
    L5:
        if (r3.length() <= 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == true) goto L11;
        r3 = null;
    L11:
        if (r3 == null) goto L23;
        com.larus.bmhome.resource.access.z r2 = com.larus.bmhome.resource.access.y.a.query(r3);
        if (r2 != null) goto L19;
        a r4 = d.get(r3);
        if (r4 != null) goto L22;
        return null;
    L22:
        return r4.snapshot();
    L19:
        return r2;
    L23:
        return null;
    L7:
        r1 = false;
        goto L8
    }

    public static final void b(String r3, com.larus.bmhome.resource.access.f0 r4) {
        if (r3.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L18;
        Object r1 = g;
        monitor-enter(r1);
        e();     // Catch: Throwable -> L13
        e.put(r3, r4);     // Catch: Throwable -> L13
        f.put(r3, Long.valueOf(System.currentTimeMillis()));     // Catch: Throwable -> L13
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(r1);
        return;
    L13:
        th = move-exception;
        throw th;
    L18:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public static com.larus.bmhome.resource.access.a0.c m(ResourceUploadError r4, Throwable r5) {
        String r2 = r4.getCode();
        String r3 = r4.getMsg();
        Throwable r6 = r4;
        if (r5 == null) goto L7;
        r6 = r5;
    L7:
        return new com.larus.bmhome.resource.access.a0.c(new com.larus.bmhome.resource.access.r("legacy_upload", r2, r3, r6));
    }

    public static final Object a(CreationResourceAccessUploader r11, com.larus.bmhome.resource.access.w r12, Continuation r13) {
        r11.getClass();
        if ((r13 instanceof CreationResourceAccessUploader$prepareLegacyUploadRequest$1) == false) goto L7;
        CreationResourceAccessUploader$prepareLegacyUploadRequest$1 r0 = (CreationResourceAccessUploader$prepareLegacyUploadRequest$1) r13;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r14 = r0.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        Long r3 = null;
        boolean r4 = true;
        if (r2 == 0) goto L16;
        if (r2 == 1) goto L15;
        if (r2 != 2) goto L14;
        com.larus.bmhome.resource.access.j0 r16 = (com.larus.bmhome.resource.access.j0) r0.L$1;
        com.larus.bmhome.resource.access.w r17 = (com.larus.bmhome.resource.access.w) r0.L$0;
        ResultKt.throwOnFailure(r14);
    L103:
        String r6 = (String) r14;
        if (r6 != null) goto L106;
    L109:
        if (r4 == true) goto L126;
        File r18 = new PolarisFileWrapper(r6);
        String r7 = ((com.larus.bmhome.resource.access.j0.c) r16).b;
        Boolean r8 = Boxing.boxBoolean(false);
        if (r18.exists() == false) goto L113;
        File r19 = r18;
    L114:
        if (r19 == null) goto L116;
        Long r9 = Boxing.boxLong(r19.length());
    L117:
        com.larus.bmhome.resource.access.j0.b r110 = new com.larus.bmhome.resource.access.j0.b(r6, r7, r8, r9, 16);
        com.larus.bmhome.resource.access.g0 r5 = r17.d;
        if (r18.exists() == true) goto L121;
        r18 = null;
    L121:
        if (r18 == null) goto L123;
        Long r111 = Boxing.boxLong(r18.length());
    L135:
        return com.larus.bmhome.resource.access.w.a(r17, r110, com.larus.bmhome.resource.access.g0.a(r5, null, r111, 15871));
    L123:
        r111 = null;
        goto L135
    L116:
        r9 = null;
        goto L117
    L113:
        r19 = null;
        goto L114
    L126:
        throw new LegacyPrepareException(new ResourceUploadError("remote_download_failed", "legacy remote image download failed"));
    L106:
        if (StringsKt.isBlank(r6) == true) goto L109;
        r4 = false;
        goto L109
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        com.larus.bmhome.resource.access.j0 r112 = (com.larus.bmhome.resource.access.j0) r0.L$1;
        com.larus.bmhome.resource.access.w r113 = (com.larus.bmhome.resource.access.w) r0.L$0;
        ResultKt.throwOnFailure(r14);
    L31:
        ic8.n0 r114 = (ic8.n0) r14;
        ic8.m0 r10 = r114.a;
        ProcessFileResultCode r20 = r114.b;
        if (r20 != null) goto L34;
    L36:
        boolean r21 = false;
    L37:
        if (r21 == false) goto L86;
        if (r10 == null) goto L40;
        String r22 = r10.e;
    L41:
        if (r22 != null) goto L43;
    L46:
        boolean r23 = true;
    L47:
        if (r23 == true) goto L86;
        if (r10 == null) goto L50;
        String r115 = r10.e;
    L51:
        if (r115 != null) goto L53;
        r115 = "";
    L53:
        String r24 = r115;
        if (r10 == null) goto L57;
        String r116 = r10.a;
        if (r116 == null) goto L57;
    L58:
        String r25 = r116;
        int r117 = g.a;
        if (r10 == null) goto L61;
        String r118 = r10.a;
    L62:
        Boolean r26 = Boxing.boxBoolean(g.b(r118));
        if (r10 == null) goto L70;
        Long r27 = Boxing.boxLong(r10.c);
        if (r27.longValue() < 0) goto L67;
        boolean r28 = true;
    L68:
        if (r28 == false) goto L70;
        Long r29 = r27;
    L71:
        if (r10 == null) goto L73;
        mr9.c r119 = r10.l;
    L74:
        com.larus.bmhome.resource.access.j0.b r30 = new com.larus.bmhome.resource.access.j0.b(r24, r25, r26, r29, r119);
        com.larus.bmhome.resource.access.g0 r31 = r113.d;
        if (r10 == null) goto L77;
        mr9.c r32 = r10.l;
    L78:
        if (r10 == null) goto L131;
        Long r33 = Boxing.boxLong(r10.c);
        if (r33.longValue() >= 0) goto L83;
        r4 = false;
    L83:
        if (r4 == false) goto L131;
        r3 = r33;
    L131:
        return com.larus.bmhome.resource.access.w.a(r113, r30, com.larus.bmhome.resource.access.g0.a(r31, r32, r3, 15615));
    L77:
        r32 = null;
        goto L78
    L73:
        r119 = null;
        goto L74
    L67:
        r28 = false;
    L70:
        r29 = null;
        goto L71
    L61:
        r118 = null;
    L57:
        r116 = ((com.larus.bmhome.resource.access.j0.a) r112).b;
        goto L58
    L50:
        r115 = null;
        goto L51
    L43:
        if (r22.length() == 0) goto L46;
        r23 = false;
        goto L47
    L40:
        r22 = null;
    L86:
        ProcessFileResultCode r120 = r114.b;
        if (r120 == null) goto L90;
        String r121 = r120.getValue();
        if (r121 == null) goto L90;
    L92:
        throw new LegacyPrepareException(new ResourceUploadError(r121, "legacy preprocess failed"));
    L90:
        r121 = "legacy_preprocess_failed";
        goto L92
    L34:
        if (r20.isSuccess() != true) goto L36;
        r21 = true;
        goto L37
    L16:
        ResultKt.throwOnFailure(r14);
        com.larus.bmhome.resource.access.j0 r122 = r12.b;
        if ((r122 instanceof com.larus.bmhome.resource.access.j0.b) == false) goto L20;
        return r12;
    L20:
        if ((r122 instanceof com.larus.bmhome.resource.access.j0.a) == false) goto L94;
        if (r12.c != ResourceMediaType.IMAGE) goto L138;
        CreationImageUploadPolicy r34 = CreationImageUploadPolicy.a;
        Uri r35 = UriProtector.parse(((com.larus.bmhome.resource.access.j0.a) r122).b);
        com.larus.bmhome.resource.access.g0 r36 = r12.d;
        String r37 = r36.d;
        if (r37 != null) goto L27;
        r37 = "ai_creation";
    L27:
        String r38 = (String) r36.m.get("preprocess_sub_scene");
        r0.L$0 = r12;
        r0.L$1 = r122;
        r0.label = 1;
        Object r39 = r34.a(r35, r37, r38, r0);
        if (r39 == r15) goto L134;
        r113 = r12;
        r112 = r122;
        r14 = r39;
    L134:
        return r15;
    L138:
        return r12;
    L94:
        if ((r122 instanceof com.larus.bmhome.resource.access.j0.c) == false) goto L130;
        if (r12.c != ResourceMediaType.IMAGE) goto L128;
        String r40 = ((com.larus.bmhome.resource.access.j0.c) r122).b;
        r0.L$0 = r12;
        r0.L$1 = r122;
        r0.label = 2;
        kotlinx.coroutines.j r41 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r0), 1);
        r41.C();
        ImageSave r42 = ImageSave.a;
        v r43 = new v(r41);
        r42.getClass();
        ImageSave.m(r40, r43);
        Object r44 = r41.B();
        if (r44 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L100;
        DebugProbesKt.probeCoroutineSuspended(r0);
    L100:
        if (r44 == r15) goto L134;
        r17 = r12;
        r16 = r122;
        r14 = r44;
        goto L103
    L128:
        throw new LegacyPrepareException(new ResourceUploadError("unsupported_resource_input", "legacy remote url upload only supports image"));
    L130:
        if ((r122 instanceof com.larus.bmhome.resource.access.j0.d) == false) goto L133;
        return r12;
    L133:
        throw new NoWhenBranchMatchedException();
    L7:
        r0 = new CreationResourceAccessUploader$prepareLegacyUploadRequest$1(r11, r13);
        goto L8
    }

    public static /* synthetic */ Object d(String r6, com.larus.bmhome.resource.access.x r7, ResourceMediaType r8, Continuation r9) {
        return a.c(r6, r7, r8, null, r9);
    }

    public static com.larus.bmhome.resource.access.b0 i(String r3, com.larus.bmhome.resource.access.x r4, ResourceMediaType r5, String r6) {
        f();
        if (r3 != null) goto L5;
    L17:
        return null;
    L5:
        if (r3.length() <= 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == true) goto L11;
        r3 = null;
    L11:
        if (r3 == null) goto L17;
        com.larus.bmhome.resource.access.y r0 = com.larus.bmhome.resource.access.y.a;
        Intrinsics.checkNotNullParameter(r3, "fileIdentifier");
        x0 r2 = x0.a;
        y0 r7 = new y0(r3, r4, r5, r6);
        Intrinsics.checkNotNullParameter(r7, "query");
        com.larus.bmhome.resource.access.f r8 = x0.c(r7, false);
        if (r8 == null) goto L16;
        return r8;
    L16:
        return c.get(r3);
    L7:
        r1 = false;
        goto L8
    }

    public final Object c(String r15, com.larus.bmhome.resource.access.x r16, ResourceMediaType r17, String r18, Continuation<? super com.larus.bmhome.resource.access.b0> r19) {
        if ((r19 instanceof CreationResourceAccessUploader$awaitTaskRegistration$1) == false) goto L7;
        CreationResourceAccessUploader$awaitTaskRegistration$1 r1 = (CreationResourceAccessUploader$awaitTaskRegistration$1) r19;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        Object r0 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        long r7 = r1.J$0;
        String r5 = (String) r1.L$3;
        String r9 = (String) r1.L$2;
        ResourceMediaType r10 = (ResourceMediaType) r1.L$1;
        com.larus.bmhome.resource.access.x r11 = (com.larus.bmhome.resource.access.x) r1.L$0;
        ResultKt.throwOnFailure(r0);
    L26:
        com.larus.bmhome.resource.access.b0 r6 = i(r5, r11, r10, r9);
        if (r6 != null) goto L28;
        if (System.currentTimeMillis() >= r7) goto L31;
        r1.L$0 = r11;
        r1.L$1 = r10;
        r1.L$2 = r9;
        r1.L$3 = r5;
        r1.J$0 = r7;
        r1.label = 1;
        if (DelayKt.delay(20, r1) != r3) goto L26;
        return r3;
    L31:
        return null;
    L28:
        return r6;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        if (r15 != null) goto L17;
    L35:
        return null;
    L17:
        if (r15.length() <= 0) goto L19;
        boolean r8 = true;
    L20:
        if (r8 == false) goto L22;
        String r12 = r15;
    L23:
        if (r12 == null) goto L35;
        r7 = System.currentTimeMillis() + 1000;
        r11 = r16;
        r10 = r17;
        r9 = r18;
        r5 = r12;
        goto L26
    L22:
        r12 = null;
        goto L23
    L19:
        r8 = false;
    L7:
        r1 = new CreationResourceAccessUploader$awaitTaskRegistration$1(this, r19);
        goto L8
    }

    public static /* synthetic */ void k(String r10, com.larus.bmhome.resource.access.z r11, ResourceMediaType r12, String r13, long r14, boolean r16, String r17, Map r18) {
        j(r10, r11, r12, r13, r14, r16, r17, r18, null);
    }

    public static void j(String r27, com.larus.bmhome.resource.access.z r28, ResourceMediaType r29, String r30, long r31, boolean r33, String r34, Map r35, Long r36) {
        Intrinsics.checkNotNullParameter(r27, "fileIdentifier");
        Intrinsics.checkNotNullParameter(r29, "mediaType");
        Intrinsics.checkNotNullParameter(r30, "result");
        Intrinsics.checkNotNullParameter(r34, "trigger");
        Intrinsics.checkNotNullParameter(r35, "extra");
        long r5 = System.currentTimeMillis() - r31;
        if (r36 != null) goto L16;
        if (r28 == null) goto L15;
        Long r10 = Long.valueOf(r28.e);
        if (r10.longValue() <= 0) goto L9;
        if (r33 == false) goto L9;
        boolean r11 = true;
    L10:
        if (r11 == true) goto L13;
        r10 = null;
    L13:
        if (r10 == null) goto L15;
        Long r24 = Long.valueOf(RangesKt.coerceAtLeast(r5 - r10.longValue(), 0));
    L17:
        if (r28 == null) goto L19;
        com.larus.bmhome.resource.access.w r6 = r28.d;
    L20:
        com.larus.bmhome.resource.access.y r7 = com.larus.bmhome.resource.access.y.a;
        if (r28 == null) goto L23;
        String r8 = r28.a;
    L24:
        if (r8 != null) goto L26;
        r8 = "";
    L26:
        if (r6 == null) goto L31;
        com.larus.bmhome.resource.access.x r0 = r6.a;
        if (r0 == null) goto L31;
    L30:
        com.larus.bmhome.resource.access.x r9 = r0;
        if (r6 == null) goto L47;
        com.larus.bmhome.resource.access.j0 r1 = r6.b;
        if (r1 == null) goto L47;
        ResourceInputType r2 = r1.getType();
        if (r2 == null) goto L47;
    L48:
        if (r6 == null) goto L53;
        ResourceMediaType r12 = r6.c;
        if (r12 == null) goto L53;
        ResourceMediaType r13 = r12;
    L54:
        String r14 = r8;
        ResourceInputType r15 = r2;
        com.larus.bmhome.resource.access.t r16 = new com.larus.bmhome.resource.access.t(r14, r9, r15, r13, r27, "creation_send", "send_wait", r31, r30, null, null, null, null, null, null, null, Boolean.valueOf(r33), Long.valueOf(r31), r24, MapsKt.plus(r35, MapsKt.mapOf(TuplesKt.to("trigger", r34))), 65024);
        Intrinsics.checkNotNullParameter(r16, "event");
        com.larus.bmhome.resource.access.u.a.getClass();
        com.larus.bmhome.resource.access.u.b(r16);
        return;
    L53:
        r13 = r29;
    L47:
        r2 = ResourceInputType.LOCAL_PATH;
    L31:
        int r3 = b.a[r29.ordinal()];
        if (r3 != 1) goto L34;
        r0 = com.larus.uaigc.service.f.c;
        goto L30
    L34:
        if (r3 != 2) goto L36;
        r0 = com.larus.uaigc.service.f.a;
        goto L30
    L36:
        if (r3 != 3) goto L39;
        r0 = com.larus.bmhome.resource.access.x.b;
        goto L30
    L39:
        throw new NoWhenBranchMatchedException();
    L23:
        r8 = null;
        goto L24
    L19:
        r6 = null;
    L9:
        r11 = false;
    L15:
        r24 = null;
        goto L17
    L16:
        r24 = r36;
        goto L17
    }
}
