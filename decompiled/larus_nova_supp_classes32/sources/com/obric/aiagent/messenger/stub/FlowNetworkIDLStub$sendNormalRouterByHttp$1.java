package com.obric.aiagent.messenger.stub;

import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.IFlowNetworkResultCallbackIDL;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.network.api.IObricNetworkService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiagent.messenger.stub.FlowNetworkIDLStub$sendNormalRouterByHttp$1", f = "FlowNetworkIDLStub.kt", i = {}, l = {221}, m = "invokeSuspend", n = {}, s = {})
public final class FlowNetworkIDLStub$sendNormalRouterByHttp$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IFlowNetworkResultCallbackIDL $callback;
    final /* synthetic */ String $passThrough;
    final /* synthetic */ String $scene;
    int label;
    final /* synthetic */ FlowNetworkIDLStub this$0;

    public FlowNetworkIDLStub$sendNormalRouterByHttp$1(FlowNetworkIDLStub r1, String r2, String r3, IFlowNetworkResultCallbackIDL r4, Continuation<? super FlowNetworkIDLStub$sendNormalRouterByHttp$1> r5) {
        this.this$0 = r1;
        this.$passThrough = r2;
        this.$scene = r3;
        this.$callback = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new FlowNetworkIDLStub$sendNormalRouterByHttp$1(this.this$0, this.$passThrough, this.$scene, this.$callback, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L11:
        String r7 = (String) r6;
        FLogger.a.i(FlowNetworkIDLStub.access$getTAG$p(this.this$0), "sendNormalRouterByHttp, execute: " + ServiceManager.get().getService(IObricNetworkService.class));
        IObricNetworkService r2 = (IObricNetworkService) ServiceManager.get().getService(IObricNetworkService.class);
        if (r2 == null) goto L15;
        r2.d(this.$scene, r7, this.$callback);
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        FlowNetworkIDLStub r8 = this.this$0;
        String r3 = this.$passThrough;
        this.label = 1;
        r6 = FlowNetworkIDLStub.access$injectScreenshotIntoPassThroughIfNeeded(r8, r3, this);
        if (r6 != r0) goto L11;
        return r0;
    }
}
