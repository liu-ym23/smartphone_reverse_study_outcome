package com.obric.aikernel.phx.core.api;

import com.obric.aikernel.sdk.response.Response;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.j;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\u0010\u0000\u001a\u00020\u0001*\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/obric/aikernel/sdk/response/Response;", ""}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.obric.aikernel.phx.core.api.ScriptBizApi$inferenceAsFlow$binder$1", f = "ScriptBizApi.kt", i = {}, l = {63}, m = "invokeSuspend", n = {}, s = {})
final class ScriptBizApi$inferenceAsFlow$binder$1 extends SuspendLambda implements Function2<j<? super Response<Object>>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    ScriptBizApi$inferenceAsFlow$binder$1(Continuation<? super ScriptBizApi$inferenceAsFlow$binder$1> r3) {
        super(2, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        ScriptBizApi$inferenceAsFlow$binder$1 r4 = new ScriptBizApi$inferenceAsFlow$binder$1((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
        r4.L$0 = r2;
        return (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(j<? super Response<Object>> r3, Continuation<? super Unit> r4) {
        return invoke2((j) ZeusTransformUtils.preCheckCast(r3, j.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(j<? super Response<Object>> r3, Continuation<? super Unit> r4) {
        return ((ScriptBizApi$inferenceAsFlow$binder$1) ZeusTransformUtils.preCheckCast(create((j) ZeusTransformUtils.wrapperContextForParams(r3, j.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), ScriptBizApi$inferenceAsFlow$binder$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r15) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r15);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r15);
        j r16 = (j) ZeusTransformUtils.preCheckCast(this.L$0, j.class, "com.obric.memorydata.plugin");
        Response r2 = new Response(102, null, null, false, false, null, null, WebSocketProtocol.PAYLOAD_SHORT, null);
        Continuation<? super Unit> r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        if (r16.emit(r2, r3) != r0) goto L12;
        return r0;
    }
}
