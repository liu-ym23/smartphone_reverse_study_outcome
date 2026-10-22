package com.obric.memorydata.personalcontext.realcontext;

import android.os.SystemClock;
import com.obric.capability.schedulekit.JobResultWrapper;
import com.obric.capabilitykit.common.execution.IntentExecutionRecord;
import com.obric.capabilitykit.common.execution.JobResult;
import com.obric.capabilitykit.common.intent.BasePhoneGetSimIntent;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.SimCardEntity;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000eJO\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000e2\u0006\u0010\u0011\u001a\u00020\u00072*\u0010\u0012\u001a&\b\u0001\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0007\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0013H\u0000¢\u0006\u0004\b\u0016\u0010\u0017J$\u0010\u0018\u001a\u00020\u00192\u0012\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000e2\u0006\u0010\u001b\u001a\u00020\u0007H\u0002J#\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0015H\u0000¢\u0006\u0002\b\u001eJ\u0014\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000eH\u0002J\u0014\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000eH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/obric/memorydata/personalcontext/realcontext/SimCardIntentClient;", "", "<init>", "()V", "TAG", "", "DISPATCH_TIMEOUT_MS", "", "MAX_ENTITIES", "", "phoneGetSimIntentName", "dispatchExecutor", "Ljava/util/concurrent/ThreadPoolExecutor;", "querySimCards", "Lcom/obric/capabilitykit/common/intent/IntentResult;", "", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "timeoutMillis", "dispatch", "Lkotlin/Function3;", "Lkotlin/coroutines/Continuation;", "Lcom/obric/capability/schedulekit/JobResultWrapper;", "querySimCards$personal_context_obricRelease", "(JLkotlin/jvm/functions/Function3;)Lcom/obric/capabilitykit/common/intent/IntentResult;", "logResult", "", "intentResult", "elapsedMillis", "mapJobResult", "jobResultWrapper", "mapJobResult$personal_context_obricRelease", "unavailableError", "generalError", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f12264a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f12265b = null;
    private static final ThreadPoolExecutor c = null;

    static {
        f12264a = new d();
        f12265b = new BasePhoneGetSimIntent().getName();
        c = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, (BlockingQueue) ZeusTransformUtils.preCheckCast(new SynchronousQueue(), BlockingQueue.class, "com.obric.memorydata.plugin"), $$Lambda$d$KvzhTRQ_Egn8QyvC9mB6vy6n5Oo.INSTANCE, (RejectedExecutionHandler) ZeusTransformUtils.preCheckCast(new ThreadPoolExecutor.AbortPolicy(), RejectedExecutionHandler.class, "com.obric.memorydata.plugin"));
    }

    private d() {
    }

    private static final Thread a(Runnable r2) {
        Thread r0 = new Thread((Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.memorydata.plugin"), "sim-card-intent-dispatch");
        r0.setDaemon(true);
        return r0;
    }

    private final void a(IntentResult<AppEntity[]> r10, long r11) {
        int r9 = r10.getRet();
        if (r9 != 0) goto L5;
        String r12 = "success";
    L9:
        IRunLog r3 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r13 = new StringBuilder().append("outcome=").append(r12).append(",count=");
        AppEntity[] r14 = (AppEntity[]) ZeusTransformUtils.preCheckCast(r10.getEntity(), AppEntity[].class, "com.obric.memorydata.plugin");
        if (r14 == null) goto L12;
        int r15 = r14.length;
    L13:
        IRunLog.a.a(r3, "SimCardIntentClient", r13.append(r15).append(",elapsedMs=").append(r11).toString(), false, 4, null);
        return;
    L12:
        r15 = 0;
        goto L13
    L5:
        if (r9 == 100) goto L7;
        r12 = "general_error";
        goto L9
    L7:
        r12 = "unavailable";
        goto L9
    }

    public static final /* synthetic */ String b() {
        return f12265b;
    }

    private final IntentResult<AppEntity[]> c() {
        return new IntentResult(100, null, null, null, false, false, 256, null, null, null, 958, null);
    }

    private final IntentResult<AppEntity[]> d() {
        return new IntentResult(1, null, null, null, false, false, 256, null, null, null, 958, null);
    }

    public static /* synthetic */ Thread lambda$KvzhTRQ_Egn8QyvC9mB6vy6n5Oo(Runnable r0) {
        return a(r0);
    }

    public final IntentResult<AppEntity[]> a() {
        long r0 = SystemClock.elapsedRealtime();
        IntentResult<AppEntity[]> r5 = a(5000, (Function3) ZeusTransformUtils.preCheckCast(new SimCardIntentClient$querySimCards$1(null), Function3.class, "com.obric.memorydata.plugin"));
        f12264a.a(r5, SystemClock.elapsedRealtime() - r0);
        return r5;
    }

    public final IntentResult<AppEntity[]> a(long r5, Function3<? super String, ? super Long, ? super Continuation<? super JobResultWrapper>, ? extends Object> r7) {
        Function3 r8 = (Function3) ZeusTransformUtils.wrapperContextForParams(r7, Function3.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "dispatch");
        return a(new e(r5, (Function1) ZeusTransformUtils.preCheckCast(new SimCardIntentClient$querySimCards$result$1(r8, r5, null), Function1.class, "com.obric.memorydata.plugin"), c).a());
    }

    public final IntentResult<AppEntity[]> a(JobResultWrapper r21) {
        if (r21 == null) goto L53;
        JobResult r0 = r21.getJobResult();
        if (r0 == null) goto L53;
        List<IntentExecutionRecord> r1 = r0.getExecRecords();
        if (r1 == null) goto L53;
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L9:
        if (r2.hasNext() == false) goto L13;
        Object r3 = r2.next();
        if (Intrinsics.areEqual(((IntentExecutionRecord) ZeusTransformUtils.preCheckCast(r3, IntentExecutionRecord.class, "com.obric.memorydata.plugin")).getIntentName(), f12265b) == false) goto L9;
    L14:
        IntentExecutionRecord r4 = (IntentExecutionRecord) ZeusTransformUtils.preCheckCast(r3, IntentExecutionRecord.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L53;
        IntentResult<?> r5 = r4.getResult();
        if (r5 == null) goto L53;
        if (r5.getRet() == (-2005)) goto L51;
        if (r5.getRet() == 100) goto L51;
        if (r5.getRet() != 0) goto L26;
        Object r6 = r5.getEntity();
        if ((r6 instanceof Object[]) == false) goto L30;
        Object[] r7 = (Object[]) ZeusTransformUtils.preCheckCast(r6, Object[].class, "com.obric.memorydata.plugin");
    L31:
        if (r7 != null) goto L35;
        return d();
    L35:
        if (r7.length > 8) goto L37;
        ArrayList r8 = new ArrayList(r7.length);
        int r9 = r7.length;
        int r10 = 0;
    L39:
        if (r10 >= r9) goto L49;
        Object r11 = r7[r10];
        if (ZeusTransformUtils.instanceOf(r11, SimCardEntity.class) == false) goto L43;
        SimCardEntity r12 = (SimCardEntity) ZeusTransformUtils.preCheckCast(r11, SimCardEntity.class, "com.obric.memorydata.plugin");
    L44:
        if (r12 == null) goto L46;
        r8.add(r12);
        r10 = r10 + 1;
        goto L39
    L46:
        return d();
    L43:
        r12 = null;
        goto L44
    L49:
        return new IntentResult(0, ((Collection) ZeusTransformUtils.preCheckCast(r8, Collection.class, "com.obric.memorydata.plugin")).toArray(new AppEntity[0]), null, null, false, false, 256, null, null, null, 956, null);
    L37:
        return d();
    L30:
        r7 = null;
        goto L31
    L26:
        return d();
    L51:
        return c();
    L13:
        r3 = null;
    L53:
        return d();
    }
}
