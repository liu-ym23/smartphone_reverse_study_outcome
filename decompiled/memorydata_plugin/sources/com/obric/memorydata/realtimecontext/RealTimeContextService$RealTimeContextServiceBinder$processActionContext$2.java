package com.obric.memorydata.realtimecontext;

import android.content.ComponentName;
import com.obric.memorydata.sdk.realtime.ActionContext;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.realtimecontext.RealTimeContextService$RealTimeContextServiceBinder$processActionContext$2", f = "RealTimeContextService.kt", i = {}, l = {909}, m = "invokeSuspend", n = {}, s = {})
final class RealTimeContextService$RealTimeContextServiceBinder$processActionContext$2 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ ComponentName $componentName;
    final /* synthetic */ ActionContext $entityActionContext;
    final /* synthetic */ com.obric.memorydata.realtimecontext.session.c $realTimeData;
    final /* synthetic */ a $sceneMatchResult;
    final /* synthetic */ RealTimeContextService.b.a $timing;
    int label;
    final /* synthetic */ RealTimeContextService.b this$0;

    RealTimeContextService$RealTimeContextServiceBinder$processActionContext$2(ActionContext r3, RealTimeContextService.b r4, com.obric.memorydata.realtimecontext.session.c r5, RealTimeContextService.b.a r6, ComponentName r7, a r8, Continuation<? super RealTimeContextService$RealTimeContextServiceBinder$processActionContext$2> r9) {
        Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
        this.$entityActionContext = r3;
        this.this$0 = r4;
        this.$realTimeData = r5;
        this.$timing = r6;
        this.$componentName = r7;
        this.$sceneMatchResult = r8;
        super(2, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new RealTimeContextService$RealTimeContextServiceBinder$processActionContext$2(this.$entityActionContext, this.this$0, this.$realTimeData, this.$timing, this.$componentName, this.$sceneMatchResult, r8), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((RealTimeContextService$RealTimeContextServiceBinder$processActionContext$2) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), RealTimeContextService$RealTimeContextServiceBinder$processActionContext$2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r9);
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r9);
        ActionContext r10 = this.$entityActionContext;
        if (r10 == null) goto L11;
        RealTimeContextService.b.a(this.this$0, this.$realTimeData, r10, this.$timing);
        goto L15
    L11:
        RealTimeContextService.b r11 = this.this$0;
        ComponentName r3 = this.$componentName;
        a r4 = this.$sceneMatchResult;
        com.obric.memorydata.realtimecontext.session.c r5 = this.$realTimeData;
        RealTimeContextService.b.a r6 = this.$timing;
        Continuation r7 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        if (RealTimeContextService.b.a(r11, r3, r4, r5, r6, r7) != r0) goto L15;
        return r0;
    }
}
