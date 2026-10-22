package com.obric.aiproactive.ui.data;

import com.obric.aiproactive.api.PageType;
import com.obric.aiproactive.api.ProactiveNowPageSnapshot;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "snapshot", "Lcom/obric/aiproactive/api/ProactiveNowPageSnapshot;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiproactive.ui.data.DefaultProactiveRepository$observeNowPageSnapshot$2", f = "ProactiveRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DefaultProactiveRepository$observeNowPageSnapshot$2 extends SuspendLambda implements Function2<ProactiveNowPageSnapshot, Continuation<? super Unit>, Object> {
    final /* synthetic */ PageType $pageType;
    /* synthetic */ Object L$0;
    int label;

    DefaultProactiveRepository$observeNowPageSnapshot$2(PageType r3, Continuation<? super DefaultProactiveRepository$observeNowPageSnapshot$2> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.$pageType = r3;
        super(2, r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        DefaultProactiveRepository$observeNowPageSnapshot$2 r0 = new DefaultProactiveRepository$observeNowPageSnapshot$2(this.$pageType, r5);
        r0.L$0 = r3;
        return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(ProactiveNowPageSnapshot r3, Continuation<? super Unit> r4) {
        return ((DefaultProactiveRepository$observeNowPageSnapshot$2) ZeusTransformUtils.preCheckCast(create(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), DefaultProactiveRepository$observeNowPageSnapshot$2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(ProactiveNowPageSnapshot r3, Continuation<? super Unit> r4) {
        return invoke2((ProactiveNowPageSnapshot) ZeusTransformUtils.preCheckCast(r3, ProactiveNowPageSnapshot.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r8) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r8);
        ProactiveNowPageSnapshot r9 = (ProactiveNowPageSnapshot) ZeusTransformUtils.preCheckCast(this.L$0, ProactiveNowPageSnapshot.class, "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ProactiveUI", "[Repo] observeNowPageSnapshot onChanged listenerType=" + this.$pageType.getListenerType() + " batchId=" + r9.getBatchId() + " pageSize=" + r9.getList().size() + " hasNext=" + r9.getHasNext(), false, 4, null);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
