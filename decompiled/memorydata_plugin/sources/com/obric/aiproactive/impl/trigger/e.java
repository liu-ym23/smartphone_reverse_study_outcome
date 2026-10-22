package com.obric.aiproactive.impl.trigger;

import com.obric.aiproactive.api.ToggleUserSubscriptionRequest;
import com.obric.capabilitykit.common.Ext;
import com.obric.memorydata.constants.AppInfo;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.task.impl.TaskRequest;
import com.obric.memorydata.task.impl.TaskResult;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.i;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0000¢\u0006\u0002\b\u000bJ\u000e\u0010\f\u001a\u00020\rH\u0086@¢\u0006\u0002\u0010\u000eJ\u000e\u0010\u000f\u001a\u00020\u0010H\u0086@¢\u0006\u0002\u0010\u000eJ\u0016\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0013H\u0086@¢\u0006\u0002\u0010\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/obric/aiproactive/impl/trigger/TriggerEngineTaskLauncher;", "", "<init>", "()V", "TAG", "", "TASK_NAME", "buildForegroundMaxPriorityRequest", "Lcom/obric/memorydata/task/impl/TaskRequest;", "inputParam", "Lorg/json/JSONObject;", "buildForegroundMaxPriorityRequest$ai_proactive_impl_obricRelease", "initDefaults", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "refreshNowInspirationCandidates", "Lcom/obric/memorydata/task/impl/TaskResult;", "toggleSubscription", Ext.KEY_REQUEST, "Lcom/obric/aiproactive/api/ToggleUserSubscriptionRequest;", "(Lcom/obric/aiproactive/api/ToggleUserSubscriptionRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f6532a = null;

    static {
        f6532a = new e();
    }

    private e() {
    }

    public final TaskRequest a(JSONObject r3) {
        Intrinsics.checkNotNullParameter(r3, "inputParam");
        RunLog.INSTANCE.debug("TriggerEngineTaskLauncher", "buildForegroundMaxPriorityRequest: task=trigger_engine, runType=" + r3.optString("runType") + ", foregroundPkg=" + AppInfo.OAssistant.getPackageName() + ", executeImmediately=true, priority=10");
        return (TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(new TaskRequest.Builder("trigger_engine").setForegroundCallerPkg(AppInfo.OAssistant.getPackageName()), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setExecuteImmediately(true), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setInputParam(r3), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setPriority(10), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin");
    }

    public final Object a(ToggleUserSubscriptionRequest r4, Continuation<? super Unit> r5) {
        Continuation r3 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        Object r6 = i.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.a(), CoroutineContext.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new TriggerEngineTaskLauncher$toggleSubscription$2(r4, null), Function2.class, "com.obric.memorydata.plugin"), r3);
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r6;
    L6:
        return Unit.INSTANCE;
    }

    public final Object a(Continuation<? super Unit> r4) {
        Continuation r3 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        Object r5 = i.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.a(), CoroutineContext.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new TriggerEngineTaskLauncher$initDefaults$2(null), Function2.class, "com.obric.memorydata.plugin"), r3);
        if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r5;
    L6:
        return Unit.INSTANCE;
    }

    public final Object b(Continuation<? super TaskResult> r4) {
        Continuation r3 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        return i.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.a(), CoroutineContext.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new TriggerEngineTaskLauncher$refreshNowInspirationCandidates$2(null), Function2.class, "com.obric.memorydata.plugin"), r3);
    }
}
