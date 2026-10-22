package com.obric.memorydata.memory.review;

import com.obric.memorydata.memory.review.provider.aq;
import com.obric.memorydata.memory.review.provider.bb;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005J\u0016\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005J\u0016\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u0005J\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/obric/memorydata/memory/review/MemoryTraceReportManager;", "", "<init>", "()V", "TAG", "", "periodicReportTaskEnqueued", "Ljava/util/concurrent/atomic/AtomicBoolean;", "insertTraceReport", "", "logId", "reportData", "insertAndTriggerDebounced", "upsertAndTriggerDebounced", "triggerTraceReport", "", "enqueuePeriodicReportTaskIfEnabled", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f10376a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final AtomicBoolean f10377b = null;

    static {
        f10376a = new b();
        f10377b = new AtomicBoolean(false);
    }

    private b() {
    }

    public final long a(String r21, String r22) {
        Intrinsics.checkNotNullParameter(r21, "logId");
        Intrinsics.checkNotNullParameter(r22, "reportData");
        if (com.obric.memorydata.database.c.b.f8850a.a() == true) goto L7;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryTraceReportManager", "upsertAndTriggerDebounced skipped, entry disabled, logId=" + r21, false, 4, null);
        return 0;
    L7:
        return new aq(null, null, null, null, 0, 0, 0, 0, 0, 0, null, 2047, null).a(r21, r22);
    }

    public final boolean a() {
        if (com.obric.memorydata.database.c.b.f8850a.a() == true) goto L8;
        IRunLog r3 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        boolean r6 = false;
        int r7 = 4;
        Object r8 = null;
        String r4 = "MemoryTraceReportManager";
        String r5 = "periodic trace report task skipped, entry disabled";
    L5:
        IRunLog.a.a(r3, r4, r5, r6, r7, r8);
        return false;
    L8:
        if (f10377b.compareAndSet(false, true) == true) goto L22;
        r3 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r6 = false;
        r7 = 4;
        r8 = null;
        r4 = "MemoryTraceReportManager";
        r5 = "periodic trace report task skipped, already enqueued";
        goto L5
    L22:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L12
        b r9 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
        bb.f10440a.b();     // Catch: Throwable -> L12
        Object r10 = Result.m1421constructorimpl(true);     // Catch: Throwable -> L12
    L14:
        Throwable r1 = Result.m1424exceptionOrNullimpl(r10);
        if (r1 == null) goto L18;
        f10377b.set(false);
        RunLog.INSTANCE.error("MemoryTraceReportManager", "periodic trace report task enqueue failed", r1);
    L18:
        if (Result.m1427isFailureimpl(r10) == false) goto L21;
        r10 = false;
    L21:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r10, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L12:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r10 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L14
    }
}
