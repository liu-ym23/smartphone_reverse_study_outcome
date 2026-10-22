package com.larus.agents.impl.network;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.network.FlowHttpConnection;
import com.larus.network.bean.BizResponse;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/HttpDataResult;", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.agents.impl.network.AgentsMdApi$Companion$safeCall$2", f = "AgentsMdApi.kt", i = {}, l = {33}, m = "invokeSuspend", n = {}, s = {})
final class AgentsMdApi$Companion$safeCall$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super dm9.a<Object>>, Object> {
    final /* synthetic */ Function2<AgentsMdApi, Continuation<? super BizResponse<Object>>, Object> $call;
    final /* synthetic */ String $path;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public AgentsMdApi$Companion$safeCall$2(Function2<? super AgentsMdApi, ? super Continuation<? super BizResponse<Object>>, ? extends Object> r1, String r2, Continuation<? super AgentsMdApi$Companion$safeCall$2> r3) {
        this.$call = r1;
        this.$path = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new AgentsMdApi$Companion$safeCall$2(this.$call, this.$path, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super dm9.a<Object>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r13);
    L11:
        return r13;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r13);
        FlowHttpConnection r14 = FlowHttpConnection.a;
        Function2<AgentsMdApi, Continuation<? super BizResponse<Object>>, Object> r5 = this.$call;
        String r7 = this.$path;
        this.label = 1;
        r13 = FlowHttpConnection.g("Basic", AgentsMdApi.class, r5, true, r7, null, null, this, 224);
        if (r13 != r0) goto L11;
        return r0;
    }
}
