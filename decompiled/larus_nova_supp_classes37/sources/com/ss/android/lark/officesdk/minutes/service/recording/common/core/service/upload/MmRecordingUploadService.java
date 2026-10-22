package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.upload;

import com.larksuite.framework.thread.CoreThreadPool;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.officesdk.api.plugin.OfficeSDKPluginErrorCode;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.EndRecordingReason;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.service.foundation.utils.cache.file.MmRecordFileHelper;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSession;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.data.TerminateReason;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync.MmRecordingStatesSyncService;
import com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.n;
import com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.o;
import com.ss.android.lark.passport.signinsdk_api.base.log.UniContext;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MmRecordingUploadService {
    public static final /* synthetic */ int q = 0;
    public final MmRecordingSession a;
    public final com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a b;
    public final String c;
    public final ExecutorService d;
    public final ExecutorService e;
    public final LinkedBlockingQueue<MmRecordingUploadTask> f;
    public final Object g;
    public final Set<MmRecordingUploadTask> h;
    public final CoroutineScope i;
    public final Lazy j;
    public final Lazy k;
    public final AtomicInteger l;
    public final AtomicInteger m;
    public final AtomicInteger n;
    public final AtomicInteger o;
    public final AtomicBoolean p;

    public static final class a {
    }

    public static final class b {
        public final int a;
        public final int b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a * 31) + this.b;
        }

        public final String toString() {
            return "UploadProgressState(uploadedCount=" + this.a + ", totalCount=" + this.b + ')';
        }

        public b(int r1, int r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[MmRecordingUploadResponse.values().length];
            r0[MmRecordingUploadResponse.REACH_MAX_DURATION.ordinal()] = 1;     // Catch: NoSuchFieldError -> L20
        L53:
            r0[MmRecordingUploadResponse.OBJECT_DELETED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L21
        L63:
            r0[MmRecordingUploadResponse.UPLOAD_COMPLETED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L22
        L39:
            r0[MmRecordingUploadResponse.NOT_LOGGED_IN.ordinal()] = 4;     // Catch: NoSuchFieldError -> L23
        L41:
            r0[MmRecordingUploadResponse.UNAUTHORIZED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L24
        L49:
            r0[MmRecordingUploadResponse.SUCCESS.ordinal()] = 6;     // Catch: NoSuchFieldError -> L25
        L59:
            r0[MmRecordingUploadResponse.INTERRUPTED.ordinal()] = 7;     // Catch: NoSuchFieldError -> L26
        L45:
            r0[MmRecordingUploadResponse.NON_RECORDING_TYPE.ordinal()] = 8;     // Catch: NoSuchFieldError -> L27
        L55:
            r0[MmRecordingUploadResponse.TENANT_KEY_DELETED.ordinal()] = 9;     // Catch: NoSuchFieldError -> L28
        L57:
            r0[MmRecordingUploadResponse.ENCRYPTION_FAILED.ordinal()] = 10;     // Catch: NoSuchFieldError -> L29
        L37:
            r0[MmRecordingUploadResponse.GET_TENANT_KEY_FAILED.ordinal()] = 11;     // Catch: NoSuchFieldError -> L30
        L51:
            r0[MmRecordingUploadResponse.TOS_UPLOAD_FAILED.ordinal()] = 12;     // Catch: NoSuchFieldError -> L31
        L61:
            r0[MmRecordingUploadResponse.ABASE_FAILED.ordinal()] = 13;     // Catch: NoSuchFieldError -> L32
        L35:
            r0[MmRecordingUploadResponse.TRANSCODING_FAILED.ordinal()] = 14;     // Catch: NoSuchFieldError -> L33
        L43:
            r0[MmRecordingUploadResponse.SERVER_DOWN.ordinal()] = 15;     // Catch: NoSuchFieldError -> L34
        L18:
            a = r0;
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ MmRecordingUploadService a;
        public final /* synthetic */ MmRecordingUploadTask b;

        public d(MmRecordingUploadService r1, MmRecordingUploadTask r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            LinkedBlockingQueue<MmRecordingUploadTask> r0 = this.a.f;
            MmRecordingUploadTask r1 = this.b;
            boolean r3 = false;
            if ((r0 instanceof Collection) == true) goto L5;
        L7:
            Iterator<MmRecordingUploadTask> r2 = r0.iterator();
        L9:
            if (r2.hasNext() == false) goto L16;
            if (r2.next().b != r1.b) goto L13;
            boolean r4 = true;
        L14:
            if (r4 == false) goto L9;
            boolean r5 = true;
        L17:
            if (r5 == true) goto L41;
            MmRecordingUploadService r6 = this.a;
            Object r7 = r6.g;
            MmRecordingUploadTask r8 = this.b;
            monitor-enter(r7);
            Set<MmRecordingUploadTask> r9 = r6.h;     // Catch: Throwable -> L38
            if ((r9 instanceof Collection) == true) goto L23;
        L25:
            Iterator<T> r10 = r9.iterator();     // Catch: Throwable -> L38
        L26:
            if (r10.hasNext() == false) goto L34;
            if (((MmRecordingUploadTask) r10.next()).b != r8.b) goto L31;
            boolean r11 = true;
        L32:
            if (r11 == false) goto L26;
            boolean r12 = true;
        L35:
            monitor-exit(r7);
            if (r12 == true) goto L41;
        L42:
            if (r3 == false) goto L45;
            lvb.a.h(this.a.c, "[addTask] duplicate segIndex: " + this.b.b + ", skip");
            return;
        L45:
            lvb.a.e(this.a.c, "[addTask] task:" + this.b.c + ", segIndex: " + this.b.b + ", Uploader:" + this.a.hashCode());
            com.ss.android.lark.officesdk.minutes.service.recording.common.perf.appreciable.d r13 = com.ss.android.lark.officesdk.minutes.service.recording.common.perf.appreciable.a.c;
            String r14 = this.a.a.e();
            MmRecordingUploadTask r15 = this.b;
            r13.getClass();
            Intrinsics.checkNotNullParameter(r14, "recordingId");
            Intrinsics.checkNotNullParameter(r15, "task");
            com.ss.android.lark.officesdk.minutes.service.recording.common.perf.appreciable.d.b r16 = r13.a.get(r14);
            if (r16 != null) goto L48;
            lvb.a.h("MmRecordingUploadMetrics", "[onUploadTaskAdded] missing upload context, recordingId=" + r14 + ", segIndex=" + r15.b);
        L55:
            MmRecordingUploadService r17 = this.a;
            MmRecordingUploadTask r18 = this.b;
            Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L58
            r17.f.put(r18);     // Catch: Throwable -> L58
            Object r20 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L58
        L60:
            MmRecordingUploadService r21 = this.a;
            MmRecordingUploadTask r22 = this.b;
            if (Result.isSuccess-impl(r20) == false) goto L63;
            Unit r23 = (Unit) r20;
            r21.l.incrementAndGet();
            r21.f().e(r22, r21.l(null));
            r21.g(r22.c, null);
        L63:
            MmRecordingUploadService r24 = this.a;
            BuildersKt.launch$default(r24.i, null, null, new MmRecordingUploadService$processTasks$1(r24, null), 3, null);
            return;
        L58:
            th = move-exception;
            Result.Companion r25 = Result.Companion;
            r20 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L60
        L48:
            r16.d.incrementAndGet();
            AtomicLong r26 = r16.f;
            long r27 = ((long) r15.b) * ((long) r15.e);
            long r28 = r26.get();
        L50:
            if (r27 <= r28) goto L55;
            if (r26.compareAndSet(r28, r27) == true) goto L55;
            r28 = r26.get();
            goto L50
        L31:
            r11 = false;
        L34:
            r12 = false;
            goto L35
        L23:
            if (r9.isEmpty() == false) goto L25;
        L38:
            th = move-exception;
            throw th;
        L41:
            r3 = true;
            goto L42
        L13:
            r4 = false;
        L16:
            r5 = false;
            goto L17
        L5:
            if (r0.isEmpty() == false) goto L7;
            goto L7
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public final void d() {
        if (Intrinsics.areEqual(this.a.g(), com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.i.c) == true) goto L5;
        return;
    L5:
        if (this.f.isEmpty() == true) goto L7;
        return;
    L7:
        if (i() != 0) goto L18;
        lvb.a.e(this.c, "postProcessing & taskQueue is empty, sync upload completed");
        String r0 = this.a.w.d;
        if (r0.length() <= 0) goto L11;
        boolean r1 = true;
    L12:
        if (r1 == false) goto L14;
        g(r0, Float.valueOf(1.0f));
    L14:
        this.a.i().J();
        return;
    L11:
        r1 = false;
        goto L12
    }

    public final n f() {
        return (n) this.k.getValue();
    }

    public final b h() {
        int r0 = this.n.get();
        int r1 = this.l.get();
        int r2 = Math.max(this.o.get(), r1 + r0);
        return new b(RangesKt.coerceAtMost(r0 + this.m.get(), r2), r2);
    }

    public final int i() {
        Object r0 = this.g;
        monitor-enter(r0);
        int r1 = this.h.size();     // Catch: Throwable -> L7
        monitor-exit(r0);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public final void k() {
        boolean r1 = false;
        if (this.p.compareAndSet(false, true) == true) goto L6;
        lvb.a.e(this.c, "[trackUploadCompleted] skip duplicate");
        return;
    L6:
        com.ss.android.lark.officesdk.minutes.service.recording.common.perf.appreciable.d r0 = com.ss.android.lark.officesdk.minutes.service.recording.common.perf.appreciable.a.c;
        String r3 = this.a.e();
        Long r4 = (Long) this.a.p.getValue();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r3, "recordingId");
        com.ss.android.lark.officesdk.minutes.service.recording.common.perf.appreciable.d.b r2 = r0.a.remove(r3);
        if (r2 != null) goto L9;
        lvb.a.h("MmRecordingUploadMetrics", "[trackUploadSuccess] missing upload context, recordingId=" + r3);
    L26:
        n r5 = f();
        o r6 = l(Float.valueOf(1.0f));
        r5.getClass();
        Intrinsics.checkNotNullParameter(r6, "snapshot");
        r5.b("completed");
        r5.m("completed", r6, "", "");
        return;
    L9:
        int r7 = r2.d.get();
        int r8 = r2.e.get();
        if (r4 == null) goto L12;
        long r9 = r4.longValue();
    L13:
        long r10 = Math.max(r9, r2.f.get());
        if (r8 >= r7) goto L16;
        r1 = true;
    L16:
        lvb.a.e("MmRecordingUploadMetrics", "[trackUploadSuccess] traceId=" + r2.a.getRecordingTraceId() + ", recordingId=" + r2.b + ",totalCount=" + r7 + ", successCount=" + r8 + ", durationMs=" + r10 + ", uploadType=" + r2.c + ", isIncomplete=" + r1);
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.d r11 = new com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.d();
        MmRecordingSource r12 = r2.a.getSource();
        if (r12 == null) goto L19;
        String r13 = r12.getValue();
    L20:
        if (r13 != null) goto L22;
        r13 = "";
    L22:
        r11.e("source", r13);
        r11.e("success", "1");
        r11.c("duration", r10);
        r11.b("total_count", r7);
        r11.b("success_count", r8);
        if (r1 == false) goto L25;
        r11.b(UniContext.KEY_OF_ERROR_CODE, OfficeSDKPluginErrorCode.PLUGIN_UNSUPPORTED);
    L25:
        com.ss.android.lark.officesdk.minutes.service.recording.common.perf.appreciable.a.a("minutes_recording_upload_finished", r2.a, r11.a());
        goto L26
    L19:
        r13 = null;
        goto L20
    L12:
        r9 = 0;
        goto L13
    }

    public final void c(MmRecordingUploadTask r3) {
        Intrinsics.checkNotNullParameter(r3, "task");
        this.d.execute(new d(this, r3));
    }

    public final void e(String r8) {
        lvb.a.e(this.c, "deleteSegment: " + r8);
        BuildersKt.launch$default(this.a.u, null, null, new MmRecordingUploadService$deleteSegment$1(r8, null), 3, null);
    }

    public final o l(Float r8) {
        b r0 = h();
        if (r8 == null) goto L5;
        float r9 = r8.floatValue();
    L13:
        return new o(r0.b, r0.a, this.f.size(), i(), r9);
    L5:
        int r10 = r0.b;
        if (r10 > 0) goto L8;
        r9 = 0.0f;
        goto L13
    L8:
        float r1 = r0.a / r10;
        if (r1 < 1.0f) goto L11;
        r1 = 0.99f;
    L11:
        r9 = r1;
        goto L13
    }

    public MmRecordingUploadService(MmRecordingSession r2, com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r3) {
        Intrinsics.checkNotNullParameter(r2, "recordingSession");
        Intrinsics.checkNotNullParameter(r3, "userComponentContext");
        this.a = r2;
        this.b = r3;
        this.c = "MmRecordingUploadService" + hashCode();
        this.d = CoreThreadPool.getDefault().newSerialIODensityThreadPool("mm_recording_queue");
        ExecutorService r4 = CoreThreadPool.getDefault().newSerialIODensityThreadPool("mm_recording_upload");
        this.e = r4;
        this.f = new LinkedBlockingQueue(24);
        this.g = new Object();
        this.h = new LinkedHashSet();
        this.i = CoroutineScopeKt.CoroutineScope(ExecutorsKt.from(r4).plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        this.j = LazyKt.lazy(new MmRecordingUploadService$retryPolicy$2(this));
        this.k = LazyKt.lazy(new MmRecordingUploadService$uploadDiagnosisReporter$2(this));
        this.l = new AtomicInteger(0);
        this.m = new AtomicInteger(0);
        this.n = new AtomicInteger(0);
        this.o = new AtomicInteger(0);
        this.p = new AtomicBoolean(false);
    }

    public final void g(String r7, Float r8) {
        b r0 = h();
        if (r8 == null) goto L5;
        float r1 = r8.floatValue();
    L12:
        boolean r2 = this.a.v();
        String r3 = this.a.w.d;
        Intrinsics.checkNotNullParameter(r7, "uploadIdentity");
        Intrinsics.checkNotNullParameter(r3, "objectToken");
        if (r2 == true) goto L16;
        r3 = r7;
    L16:
        lvb.a.e(this.c, "[notifyUploadState] recordingId=" + this.a.e() + ", uploadIdentity=" + r7 + ", progress=" + r1 + ", uploaded=" + r0.a + ", total=" + r0.b + ", currentUploaded=" + this.m.get() + ", currentEnqueued=" + this.l.get() + ", restoredUploaded=" + this.n.get() + ", restoredTotal=" + this.o.get() + ", override=" + r8);
        this.b.A().D(this.a.e(), r3, r1);
        return;
    L5:
        int r4 = r0.b;
        if (r4 > 0) goto L8;
        r1 = 0.0f;
        goto L12
    L8:
        float r5 = r0.a / r4;
        if (r5 < 1.0f) goto L11;
        r5 = 0.99f;
    L11:
        r1 = r5;
        goto L12
    }

    public final void m(MmRecordingUploadTask r11, MmRecordingUploadResponse r12) {
        com.ss.android.lark.officesdk.minutes.service.recording.common.perf.appreciable.d r0 = com.ss.android.lark.officesdk.minutes.service.recording.common.perf.appreciable.a.c;
        String r1 = this.a.e();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "recordingId");
        Intrinsics.checkNotNullParameter(r11, "task");
        com.ss.android.lark.officesdk.minutes.service.recording.common.perf.appreciable.d.b r2 = r0.a.get(r1);
        if (r2 != null) goto L5;
        lvb.a.h("MmRecordingUploadMetrics", "[onUploadTaskSuccess] missing upload context, recordingId=" + r1 + ", segIndex=" + r11.b);
    L6:
        e(r11.a);
        Object r3 = this.g;
        monitor-enter(r3);
        this.h.remove(r11);     // Catch: Throwable -> L12
        monitor-exit(r3);
        this.m.incrementAndGet();
        n r4 = f();
        o r5 = l(null);
        r4.getClass();
        Intrinsics.checkNotNullParameter(r11, "task");
        Intrinsics.checkNotNullParameter(r12, "response");
        Intrinsics.checkNotNullParameter(r5, "snapshot");
        n.h(r4, "success", r11, r4.a(r11), r5, r12, null, null, 96);
        g(r11.c, null);
        BuildersKt.launch$default(this.i, null, null, new MmRecordingUploadService$processTasks$1(this, null), 3, null);
        return;
    L12:
        th = move-exception;
        throw th;
    L5:
        r2.e.incrementAndGet();
        goto L6
    }

    public static final Object a(MmRecordingUploadService r8, String r9, Continuation r10) {
        r8.getClass();
        if ((r10 instanceof MmRecordingUploadService$cleanupLocalUploadArtifacts$1) == false) goto L7;
        MmRecordingUploadService$cleanupLocalUploadArtifacts$1 r0 = (MmRecordingUploadService$cleanupLocalUploadArtifacts$1) r10;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r5 = true;
        if (r3 == 0) goto L18;
        if (r3 == 1) goto L17;
        if (r3 == 2) goto L16;
        if (r3 != 3) goto L15;
        ResultKt.throwOnFailure(r11);
    L34:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        String r12 = (String) r0.L$0;
        ResultKt.throwOnFailure(r11);
    L30:
        MmRecordingStatesSyncService r13 = r8.a.i();
        r0.L$0 = null;
        r0.label = 3;
        if (r13.e(r12, r0) != r2) goto L34;
        return r2;
    L17:
        r9 = (String) r0.L$0;
        ResultKt.throwOnFailure(r11);
    L21:
        String r14 = ((ovb.b) r11).a;
        lvb.a.e(r8.c, "cleanupLocalUploadArtifacts: " + r9 + ", meetingId: " + r14);
        if (r14.length() > 0) goto L25;
        r5 = false;
    L25:
        if (r5 == false) goto L34;
        MmRecordFileHelper r15 = MmRecordFileHelper.a;
        String r4 = r8.b.getCurrentUserId();
        r15.getClass();
        String r16 = MmRecordFileHelper.f(r4, r14).getAbsolutePath();
        Intrinsics.checkNotNull(r16);
        r0.L$0 = r14;
        r0.label = 2;
        if (MmRecordFileHelper.b(r16, r0) == r2) goto L36;
        r12 = r14;
        goto L30
    L36:
        return r2;
    L18:
        ResultKt.throwOnFailure(r11);
        MmRecordingSession r17 = r8.a;
        r0.L$0 = r9;
        r0.label = 1;
        r11 = r17.r(r0);
        if (r11 != r2) goto L21;
        return r2;
    L7:
        r0 = new MmRecordingUploadService$cleanupLocalUploadArtifacts$1(r8, r10);
        goto L8
    }

    public static final void b(MmRecordingUploadService r9, MmRecordingUploadTask r10, MmRecordingUploadResponse r11) {
        lvb.a.e(r9.c, "[handleResponse], response:" + r11);
        int[] r0 = c.a;
        switch(r0[r11.ordinal()]) {
            case 1: goto L25;
            case 2: goto L25;
            case 3: goto L25;
            case 4: goto L17;
            case 5: goto L17;
            case 6: goto L16;
            case 7: goto L15;
            case 8: goto L14;
            case 9: goto L13;
            case 10: goto L5;
            case 11: goto L5;
            case 12: goto L5;
            case 13: goto L5;
            case 14: goto L5;
            case 15: goto L5;
            default: goto L48;
        };
    L5:
        r9.f().d(r10, r11, r9.l(null));
        r9.e(r10.a);
        Object r12 = r9.g;
        monitor-enter(r12);
        r9.h.remove(r10);     // Catch: Throwable -> L10
        monitor-exit(r12);
        r9.g(r10.c, null);
        BuildersKt.launch$default(r9.i, null, null, new MmRecordingUploadService$processTasks$1(r9, null), 3, null);
        return;
    L10:
        th = move-exception;
        throw th;
    L13:
        r9.j(r10, r11, TerminateReason.TENANT_KEY_DELETED);
        return;
    L14:
        n r1 = r9.f();
        TerminateReason r2 = TerminateReason.NON_RECORDING_TYPE;
        r1.g(r10, r11, r2, r9.l(null));
        r9.a.u(new com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.a.n(r2));
        return;
    L15:
        r9.m(r10, r11);
        r9.a.u(new com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.a.k(EndRecordingReason.INTERRUPT_RECORD));
        return;
    L16:
        r9.m(r10, r11);
        return;
    L17:
        int r3 = r0[r11.ordinal()];
        if (r3 != 4) goto L20;
        TerminateReason r4 = TerminateReason.NOT_LOGGED_IN;
    L24:
        r9.f().g(r10, r11, r4, r9.l(null));
        r9.a.u(new com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.a.n(r4));
        return;
    L20:
        if (r3 == 5) goto L22;
        r4 = TerminateReason.OTHERS;
        goto L24
    L22:
        r4 = TerminateReason.UNAUTHORIZED;
        goto L24
    L25:
        int r5 = r0[r11.ordinal()];
        if (r5 != 1) goto L28;
        TerminateReason r6 = TerminateReason.REACH_MAX_DURATION;
    L35:
        r9.j(r10, r11, r6);
        if (r11 != MmRecordingUploadResponse.REACH_MAX_DURATION) goto L47;
        lvb.a.e(r9.c, "reach_max_duration, sync status");
        return;
    L47:
        return;
    L28:
        if (r5 != 2) goto L30;
        r6 = TerminateReason.OBJECT_DELETED;
        goto L35
    L30:
        if (r5 == 3) goto L32;
        r6 = TerminateReason.OTHERS;
        goto L35
    L32:
        r6 = TerminateReason.UPLOAD_COMPLETED;
        goto L35
    }

    public final void j(MmRecordingUploadTask r9, MmRecordingUploadResponse r10, TerminateReason r11) {
        f().g(r9, r10, r11, l(null));
        BuildersKt.launch$default(this.a.u, null, null, new MmRecordingUploadService$terminateAndCleanupLocalUpload$1(this, r9, r11, null), 3, null);
    }
}
