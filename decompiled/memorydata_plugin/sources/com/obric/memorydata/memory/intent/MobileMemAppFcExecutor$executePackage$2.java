package com.obric.memorydata.memory.intent;

import com.obric.memorydata.constants.AppInfo;
import com.obric.memorydata.dc.b;
import com.obric.memorydata.memory.review.trace.g;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.task.impl.TaskRequest;
import com.obric.memorydata.task.impl.TaskResult;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/obric/memorydata/task/impl/TaskResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.memory.intent.MobileMemAppFcExecutor$executePackage$2", f = "MobileMemAppFcExecutor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MobileMemAppFcExecutor$executePackage$2 extends SuspendLambda implements Function2<al, Continuation<? super TaskResult>, Object> {
    final /* synthetic */ String $extras;
    final /* synthetic */ String $sources;
    final /* synthetic */ String $toolName;
    final /* synthetic */ String $toolParams;
    int label;

    MobileMemAppFcExecutor$executePackage$2(String r3, String r4, String r5, String r6, Continuation<? super MobileMemAppFcExecutor$executePackage$2> r7) {
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        this.$toolName = r3;
        this.$toolParams = r4;
        this.$sources = r5;
        this.$extras = r6;
        super(2, r8);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new MobileMemAppFcExecutor$executePackage$2(this.$toolName, this.$toolParams, this.$sources, this.$extras, r6), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super TaskResult> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super TaskResult> r4) {
        return ((MobileMemAppFcExecutor$executePackage$2) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), MobileMemAppFcExecutor$executePackage$2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L14;
        ResultKt.throwOnFailure(r10);
        JSONObject r11 = new JSONObject();
        String r0 = this.$toolName;
        String r1 = this.$toolParams;
        String r2 = this.$sources;
        String r3 = this.$extras;
        r11.put("toolName", r0);
        r11.put("enableSourceLink", b.f9848a.a());
        r11.put("enableMemoryTraceReport", g.f10488a.a());
        if (r1 == null) goto L7;
        r11.put("toolParams", r1);
    L7:
        if (r2 == null) goto L9;
        r11.put("sources", r2);
    L9:
        if (r3 == null) goto L11;
        r11.put("extras", r3);
    L11:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MobileMemAppFcExecutor", "executePackage, toolName=" + this.$toolName, false, 4, null);
        return ((TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(new TaskRequest.Builder("mobile_mem_appfc").setForegroundCallerPkg(AppInfo.OAssistant.getPackageName()), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setExecuteImmediately(true), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setInputParam(r11), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setPriority(10), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setTimeout(new com.obric.memorydata.task.impl.g(20000, TimeUnit.MILLISECONDS)), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin")).execute();
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
