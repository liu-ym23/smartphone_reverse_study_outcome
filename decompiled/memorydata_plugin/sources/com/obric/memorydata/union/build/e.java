package com.obric.memorydata.union.build;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.memorydata.middleware.api.logging.u;
import com.obric.memorydata.task.AbsTaskRequest;
import com.obric.memorydata.task.impl.TaskResult;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.da;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Jn\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u00072\b\b\u0002\u0010*\u001a\u00020\u00052\u0016\b\u0002\u0010+\u001a\u0010\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020.\u0018\u00010,2\n\b\u0002\u0010/\u001a\u0004\u0018\u0001002\u0016\b\u0002\u00101\u001a\u0010\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020.\u0018\u00010,2\b\b\u0002\u00103\u001a\u000204H\u0086@¢\u0006\u0002\u00105R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u001d\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00160!¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u000e\u0010$\u001a\u00020%X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/obric/memorydata/union/build/MemoryBuildExecutor;", "", "<init>", "()V", "DEFAULT_TIMEOUT_MS", "", "MEM_PACKAGE_NAME", "", "CONTEXT_KEY_QUERY", "CONTEXT_KEY_TEXT", "CONTEXT_KEY_APP_NAME", "CONTEXT_KEY_CHAT_HISTORY", "CONTEXT_KEY_IMAGE_PATH", "CONTEXT_KEY_IMAGE_URL", "CONTEXT_KEY_IMAGE_TOS_KEY", "CONTEXT_KEY_SESSION_ID", "CONTEXT_KEY_LOG_ID", "CONTEXT_KEY_ENABLE_STREAM", "CONTEXT_KEY_CURRENT_TIME_MILLIS", "CONTEXT_KEY_SCREENSHOT_TYPE", "CONTEXT_KEY_MEMORY_PRODUCT_TYPE", "CONTEXT_VALUE_SCREENSHOT_TYPE_NORMAL", "", "CONTEXT_VALUE_SCREENSHOT_TYPE_LONG", "KEY_ENABLE_MEMORY_TRACE_REPORT", "BUSINESS_TYPE_SCREEN_OBSERVATION", "BUSINESS_TYPE_OAUTO", "BUSINESS_TYPE_PROACTIVE", "BUSINESS_TYPE_AUTO_MEMORY_PRO", "BUSINESS_TYPE_GLASSES", "BUSINESS_TYPE_AUDITORY", "BUSINESS_TYPE_SEMANTIC_MEMORY_UPDATE", "BUSINESS_TYPE_MAP", "", "getBUSINESS_TYPE_MAP", "()Ljava/util/Map;", "semaphore", "Lkotlinx/coroutines/sync/Semaphore;", "executeMobileMemBuild", "Lcom/obric/memorydata/task/impl/TaskResult;", "contextJson", "productType", "timeoutMs", "progressCallback", "Lkotlin/Function1;", "Lorg/json/JSONObject;", "", "taskInfoCallback", "Lcom/obric/memorydata/task/scheduler/OnTaskInfoCallBack;", "taskCreatedCallback", "Lcom/obric/memorydata/task/AbsTaskRequest;", "logContext", "Lcom/obric/memorydata/middleware/api/logging/LogContext;", "(Ljava/lang/String;Ljava/lang/String;JLkotlin/jvm/functions/Function1;Lcom/obric/memorydata/task/scheduler/OnTaskInfoCallBack;Lkotlin/jvm/functions/Function1;Lcom/obric/memorydata/middleware/api/logging/LogContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "memory_build_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f13072a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<String, Integer> f13073b = null;
    private static final kotlinx.coroutines.sync.d c = null;

    static {
        f13072a = new e();
        f13073b = MapsKt.mapOf(new Pair[]{TuplesKt.to("screenObservation", 1001), TuplesKt.to("oauto", 1002), TuplesKt.to("proactive", 1003), TuplesKt.to("autoMemory", 1004), TuplesKt.to("glasses", 1005), TuplesKt.to("auditory", 1006)});
        c = kotlinx.coroutines.sync.f.a(3, 0, 2, null);
    }

    private e() {
    }

    public static /* synthetic */ Object a(e r14, String r15, String r16, long r17, Function1 r19, com.obric.memorydata.task.scheduler.c r20, Function1 r21, com.obric.memorydata.middleware.api.logging.e r22, Continuation r23, int r24, Object r25) {
        Function1<? super JSONObject, Unit> r0 = (Function1) ZeusTransformUtils.wrapperContextForParams(r19, Function1.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.task.scheduler.c r2 = (com.obric.memorydata.task.scheduler.c) ZeusTransformUtils.wrapperContextForParams(r20, com.obric.memorydata.task.scheduler.c.class, "com.obric.memorydata.plugin");
        Function1<? super AbsTaskRequest, Unit> r3 = (Function1) ZeusTransformUtils.wrapperContextForParams(r21, Function1.class, "com.obric.memorydata.plugin");
        Continuation<? super TaskResult> r13 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r23, Continuation.class, "com.obric.memorydata.plugin");
        if ((r24 & 4) == 0) goto L5;
        long r7 = 180000;
    L7:
        if ((r24 & 8) == 0) goto L9;
        Function1<? super JSONObject, Unit> r9 = null;
    L11:
        if ((r24 & 16) == 0) goto L13;
        com.obric.memorydata.task.scheduler.c r10 = null;
    L15:
        if ((r24 & 32) == 0) goto L17;
        Function1<? super AbsTaskRequest, Unit> r11 = null;
    L19:
        if ((r24 & 64) == 0) goto L21;
        com.obric.memorydata.middleware.api.logging.e r12 = new com.obric.memorydata.middleware.api.logging.e(null, null, null, 7, null);
    L23:
        return r14.a(r15, r16, r7, r9, r10, r11, r12, r13);
    L21:
        r12 = r22;
        goto L23
    L17:
        r11 = r3;
        goto L19
    L13:
        r10 = r2;
        goto L15
    L9:
        r9 = r0;
        goto L11
    L5:
        r7 = r17;
        goto L7
    }

    public static final /* synthetic */ kotlinx.coroutines.sync.d b() {
        return c;
    }

    public final Object a(String r19, String r20, long r21, Function1<? super JSONObject, Unit> r23, com.obric.memorydata.task.scheduler.c r24, Function1<? super AbsTaskRequest, Unit> r25, com.obric.memorydata.middleware.api.logging.e r26, Continuation<? super TaskResult> r27) {
        long r11 = r21;
        Function1 r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r23, Function1.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.task.scheduler.c r8 = (com.obric.memorydata.task.scheduler.c) ZeusTransformUtils.wrapperContextForParams(r24, com.obric.memorydata.task.scheduler.c.class, "com.obric.memorydata.plugin");
        Function1 r9 = (Function1) ZeusTransformUtils.wrapperContextForParams(r25, Function1.class, "com.obric.memorydata.plugin");
        Continuation r0 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r27, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r0, MemoryBuildExecutor$executeMobileMemBuild$1.class) == false) goto L7;
        MemoryBuildExecutor$executeMobileMemBuild$1 r1 = (MemoryBuildExecutor$executeMobileMemBuild$1) ZeusTransformUtils.preCheckCast(r0, MemoryBuildExecutor$executeMobileMemBuild$1.class, "com.obric.memorydata.plugin");
        if ((r1.label & Integer.MIN_VALUE) == 0) goto L7;
        r1.label -= Integer.MIN_VALUE;
    L8:
        MemoryBuildExecutor$executeMobileMemBuild$1 r2 = r1;
        Object r3 = r2.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r2.label;
        if (r4 == 0) goto L20;
        if (r4 != 1) goto L19;
        long r5 = r2.J$0;
        com.obric.memorydata.middleware.api.logging.e r6 = (com.obric.memorydata.middleware.api.logging.e) ZeusTransformUtils.preCheckCast(r2.L$0, com.obric.memorydata.middleware.api.logging.e.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r3);     // Catch: Exception -> L14 TimeoutCancellationException -> L16
        r11 = r5;
        com.obric.memorydata.middleware.api.logging.e r10 = r6;
        String r18 = CommonConsts.LOG_REPORT_TYPE_EXCEPTION;
    L28:
    L32:
        e = e;
    L38:
        String r12 = r18;
    L49:
        com.obric.memorydata.middleware.api.logging.o r13 = (com.obric.memorydata.middleware.api.logging.o) ZeusTransformUtils.preCheckCast(u.f11636a, com.obric.memorydata.middleware.api.logging.o.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.middleware.api.logging.g r15 = new com.obric.memorydata.middleware.api.logging.g();
        r15.a("timeout_ms", Boxing.boxLong(r11));
        r15.a(r12, e.getClass().getSimpleName());
        r13.a("task_timeout", "mobile_mem_build 任务执行超时", r10, r15.a());
        TaskResult r16 = new TaskResult(3, null, null, null, 14, null);
        r16.setMsg("Task execution timed out after " + r11 + " ms");
        return r16;
    L30:
        e = e;
    L42:
        com.obric.memorydata.middleware.api.logging.o r17 = (com.obric.memorydata.middleware.api.logging.o) ZeusTransformUtils.preCheckCast(u.f11636a, com.obric.memorydata.middleware.api.logging.o.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.middleware.api.logging.g r22 = new com.obric.memorydata.middleware.api.logging.g();
        r22.a(r18, e.getClass().getSimpleName());
        r17.a("task_execute_failed", "mobile_mem_build 任务执行异常，交由业务层处理", r10, r22.a());
        TaskResult r28 = new TaskResult(1, null, null, null, 14, null);
        String r29 = e.getMessage();
        if (r29 != null) goto L45;
        r29 = "Unknown error";
    L45:
        r28.setMsg(r29);
        return r28;
    L60:
        return (TaskResult) ZeusTransformUtils.preCheckCast(r3, TaskResult.class, "com.obric.memorydata.plugin");
    L16:
        e = e;
        r11 = r5;
        r10 = r6;
    L48:
        r12 = CommonConsts.LOG_REPORT_TYPE_EXCEPTION;
    L14:
        e = e;
        r10 = r6;
    L41:
        r18 = CommonConsts.LOG_REPORT_TYPE_EXCEPTION;
        goto L42
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        ResultKt.throwOnFailure(r3);
        r18 = CommonConsts.LOG_REPORT_TYPE_EXCEPTION;
        Function2 r30 = (Function2) ZeusTransformUtils.preCheckCast(new MemoryBuildExecutor$executeMobileMemBuild$2(r26, r19, r20, r21, r7, r8, r9, null), Function2.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L34 TimeoutCancellationException -> L36
        r10 = r26;
        r2.L$0 = r10;     // Catch: Exception -> L30 TimeoutCancellationException -> L32
        r2.J$0 = r11;     // Catch: Exception -> L30 TimeoutCancellationException -> L32
        r2.label = 1;     // Catch: Exception -> L30 TimeoutCancellationException -> L32
        r3 = da.a(r11, r30, r2);     // Catch: Exception -> L30 TimeoutCancellationException -> L32
        if (r3 != r14) goto L28;
        return r14;
    L36:
        e = e;
        r10 = r26;
    L34:
        e = e;
        r10 = r26;
        goto L42
    L46:
        e = e;
        r10 = r26;
    L39:
        e = e;
        r10 = r26;
    L7:
        r1 = new MemoryBuildExecutor$executeMobileMemBuild$1(this, r0);
        goto L8
    }

    public final Map<String, Integer> a() {
        return f13073b;
    }
}
