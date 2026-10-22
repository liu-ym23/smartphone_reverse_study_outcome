package com.obric.memorydata.middleware.impl.playground;

import com.obric.capabilitykit.common.Ext;
import com.obric.capabilitykit.common.execution.JobResult;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J4\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000bJ(\u0010\u0011\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u000bH\u0002J$\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019J6\u0010\u001a\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\u0017\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0010\u0010\u001e\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u001fJ8\u0010 \u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00052\f\u0010\u0017\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0010\u0010\u001e\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u001fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/obric/memorydata/middleware/impl/playground/ResultRouter;", "", "<init>", "()V", "TAG", "", "registry", "Lcom/obric/memorydata/middleware/impl/playground/ResultPendingRegistry;", "dispatch", "Lcom/obric/memorydata/middleware/impl/playground/DispatchIntentResult;", "questionId", "", "payload", "messageId", "resultMode", "Lcom/obric/memorydata/middleware/impl/playground/AppIntentResultMode;", "timeoutMillis", "awaitResult", "pending", "Lcom/obric/memorydata/middleware/impl/playground/PendingRequest;", "onJobResultRecv", "", Ext.KEY_REQUEST, "result", "jobResult", "Lcom/obric/capabilitykit/common/execution/JobResult;", "onUpdateIntentResult", "Lcom/obric/capabilitykit/common/intent/IntentResult;", "isStatusChange", "", "ext", "", "onUpdateIntentResultWithRequest", "DISPATCH_TIMEOUT_MILLIS", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f11838a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final j f11839b = null;

    static {
        f11838a = new m();
        f11839b = new j("ResultRouter");
    }

    private m() {
    }

    private final b a(long r25, long r27, g r29, long r30) {
        RunLog.INSTANCE.debug("ResultRouter", "dispatch awaiting result messageId=" + r25 + " questionId=" + r27);
        b r0 = r29.a(r30);
        if (r0 == null) goto L6;
        RunLog.INSTANCE.debug("ResultRouter", "dispatch completed questionId=" + r27 + " ret=" + r0.b());
        return r0;
    L6:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ResultRouter", "[code=playground_dispatch_timeout] dispatch timed out questionId=" + r27, null, 4, null);
        return new b(r27, -1, null, null, "intent dispatch timed out", null, 0, 0, null, null, false, null, null, 0, null, true, r29.b(), 32736, null);
    }

    public static /* synthetic */ b a(m r10, long r11, String r13, long r14, AppIntentResultMode r16, long r17, int r19, Object r20) {
        if ((r19 & 4) == 0) goto L5;
        long r5 = r11;
    L7:
        if ((r19 & 8) == 0) goto L9;
        AppIntentResultMode r7 = AppIntentResultMode.JOB_RESULT;
    L11:
        if ((r19 & 16) == 0) goto L13;
        long r8 = 600000;
    L15:
        return r10.a(r11, r13, r5, r7, r8);
    L13:
        r8 = r17;
        goto L15
    L9:
        r7 = r16;
        goto L11
    L5:
        r5 = r14;
        goto L7
    }

    public final b a(long r28, String r30, long r31, AppIntentResultMode r33, long r34) {
        long r11 = r31;
        Intrinsics.checkNotNullParameter(r30, "payload");
        Intrinsics.checkNotNullParameter(r33, "resultMode");
        RunLog.INSTANCE.debug("ResultRouter", "dispatch started messageId=" + r11 + " questionId=" + r28 + " resultMode=" + r33 + " timeoutMillis=" + r34);
        j r10 = f11839b;
        g r13 = r10.a(r31, r28, r33);
        if (r13 == null) goto L5;
        com.obric.capability.schedulekit.a.f7373a.a(r30, false);     // Catch: Throwable -> L8 RuntimeException -> L10 InterruptedException -> L16
        b r0 = a(r31, r28, r13, r34);     // Catch: Throwable -> L8 RuntimeException -> L10 InterruptedException -> L16
        r10.a(r11, r13);
    L28:
    L21:
        return r0;
    L10:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ResultRouter", "[code=playground_dispatch_failed] dispatch failed questionId=" + r28, null, 4, null);     // Catch: Throwable -> L8
        r11 = 0;
        r13 = null;
        r0 = new b(r28, -3, null, null, "intent dispatch failed", null, 0, 0, null, null, false, null, null, 0, null, true, r33, 32736, null);     // Catch: Throwable -> L14
        f11839b.a(r31, r13);
    L14:
        th = th;
        long r2 = r31;
        g r4 = r13;
    L26:
        f11839b.a(r2, r4);
        throw th;
    L35:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ResultRouter", "[code=playground_dispatch_interrupted] dispatch interrupted questionId=" + r28, null, 4, null);     // Catch: Throwable -> L24
        Thread.currentThread().interrupt();     // Catch: Throwable -> L24
        r0 = new b(r28, -6, null, null, "intent dispatch was interrupted", null, 0, 0, null, null, false, null, null, 0, null, true, r33, 32736, null);     // Catch: Throwable -> L22
        f11839b.a(r31, r13);
    L22:
        th = th;
        r2 = r31;
        r4 = r13;
    L24:
        th = th;
        r4 = r13;
        r2 = r11;
        goto L26
    L5:
        return new b(r28, -5, null, null, "question_id is already pending", null, 0, 0, null, null, false, null, null, 0, null, true, r33, 32736, null);
    L8:
        th = th;
        r2 = r11;
        r4 = r13;
        goto L26
    }

    public final void a(long r7, IntentResult<?> r9, boolean r10, Map<?, ?> r11) {
        Map<?, ?> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.memorydata.plugin");
        f11839b.a(r7, r9, r10, r5);
    }

    public final void a(String r2, IntentResult<?> r3, boolean r4, Map<?, ?> r5) {
        Map<?, ?> r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        f11839b.a(r2, r3, r4, r1);
    }

    public final void a(String r1, String r2, JobResult r3) {
        f11839b.a(r1, r2, r3);
    }
}
