package com.obric.aiproactive.impl.recording;

import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.memorydata.constants.AppInfo;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.task.impl.TaskRequest;
import com.obric.memorydata.task.impl.TaskResult;
import com.obric.memorydata.task.impl.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.i;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0000¢\u0006\u0002\b\u0011J\u000e\u0010\u0012\u001a\u00020\u0013H\u0086@¢\u0006\u0002\u0010\u0014J\u001a\u0010\u0015\u001a\u00020\u00132\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0005H\u0086@¢\u0006\u0002\u0010\u0017J\u0019\u0010\u0018\u001a\u00020\u000b2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0002\b\u0019R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/obric/aiproactive/impl/recording/AiProactiveDbTaskLauncher;", "", "<init>", "()V", "TAG", "", "TASK_NAME_EVENT_RECORDING", "TASK_NAME_AGENT_LOOP", "AGENT_TRIGGER_REASON_PARAM", "AVATAR_FIVE_TAP_AGENT_TRIGGER_REASON", "buildForegroundMaxPriorityRequest", "Lcom/obric/memorydata/task/impl/TaskRequest;", "taskName", "inputParam", "Lorg/json/JSONObject;", LocationMonitorConst.TIMEOUT, "Lcom/obric/memorydata/task/impl/TaskTimeUnit;", "buildForegroundMaxPriorityRequest$ai_proactive_impl_obricRelease", "ensureReady", "Lcom/obric/memorydata/task/impl/TaskResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "triggerAgentLoop", "triggerReason", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "buildAgentLoopRequest", "buildAgentLoopRequest$ai_proactive_impl_obricRelease", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f6506a = null;

    static {
        f6506a = new b();
    }

    private b() {
    }

    public static /* synthetic */ TaskRequest a(b r0, String r1, JSONObject r2, g r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r3 = null;
    L6:
        return r0.a(r1, r2, r3);
    }

    public final TaskRequest a(String r7) {
        JSONObject r2 = new JSONObject();
        if (r7 == null) goto L11;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L8;
        r7 = null;
    L8:
        if (r7 == null) goto L11;
        r2.put(InfoRequestQPSOptTraceLogger.REASON, r7);
    L11:
        return a(this, "ai_proactive_agent", r2, null, 4, null);
    }

    public final TaskRequest a(String r3, JSONObject r4, g r5) {
        Intrinsics.checkNotNullParameter(r3, "taskName");
        Intrinsics.checkNotNullParameter(r4, "inputParam");
        RunLog.INSTANCE.debug("AiProactiveDbLauncher", "buildForegroundMaxPriorityRequest: task=" + r3 + ", foregroundPkg=" + AppInfo.OAssistant.getPackageName() + ", executeImmediately=true, priority=10");
        TaskRequest.Builder r2 = (TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(new TaskRequest.Builder(r3).setForegroundCallerPkg(AppInfo.OAssistant.getPackageName()), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setExecuteImmediately(true), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setInputParam(r4), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setPriority(10), TaskRequest.Builder.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L6;
        TaskRequest.Builder r6 = (TaskRequest.Builder) ZeusTransformUtils.preCheckCast(r2.setTimeout(r5), TaskRequest.Builder.class, "com.obric.memorydata.plugin");
    L6:
        return (TaskRequest) ZeusTransformUtils.preCheckCast(r2.build(), TaskRequest.class, "com.obric.memorydata.plugin");
    }

    public final Object a(String r4, Continuation<? super TaskResult> r5) {
        Continuation r3 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        return i.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.a(), CoroutineContext.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new AiProactiveDbTaskLauncher$triggerAgentLoop$2(r4, null), Function2.class, "com.obric.memorydata.plugin"), r3);
    }

    public final Object a(Continuation<? super TaskResult> r4) {
        Continuation r3 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        return i.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.a(), CoroutineContext.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new AiProactiveDbTaskLauncher$ensureReady$2(null), Function2.class, "com.obric.memorydata.plugin"), r3);
    }
}
