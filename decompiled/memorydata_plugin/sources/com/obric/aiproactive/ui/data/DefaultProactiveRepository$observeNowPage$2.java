package com.obric.aiproactive.ui.data;

import com.bytedance.apm6.consumer.slardar.Constants;
import com.obric.aiproactive.api.PageType;
import com.obric.aiproactive.api.ProactiveRecommendationDto;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n"}, d2 = {"<anonymous>", "", Constants.KEY_LIST, "", "Lcom/obric/aiproactive/api/ProactiveRecommendationDto;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiproactive.ui.data.DefaultProactiveRepository$observeNowPage$2", f = "ProactiveRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DefaultProactiveRepository$observeNowPage$2 extends SuspendLambda implements Function2<List<? extends ProactiveRecommendationDto>, Continuation<? super Unit>, Object> {
    final /* synthetic */ PageType $pageType;
    /* synthetic */ Object L$0;
    int label;

    DefaultProactiveRepository$observeNowPage$2(PageType r3, Continuation<? super DefaultProactiveRepository$observeNowPage$2> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.$pageType = r3;
        super(2, r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        DefaultProactiveRepository$observeNowPage$2 r0 = new DefaultProactiveRepository$observeNowPage$2(this.$pageType, r5);
        r0.L$0 = r3;
        return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(List<? extends ProactiveRecommendationDto> r3, Continuation<? super Unit> r4) {
        return invoke2((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(List<ProactiveRecommendationDto> r3, Continuation<? super Unit> r4) {
        return ((DefaultProactiveRepository$observeNowPage$2) ZeusTransformUtils.preCheckCast(create((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), DefaultProactiveRepository$observeNowPage$2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r8) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r8);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ProactiveUI", "[Repo] observeNowPage onChanged listenerType=" + this.$pageType.getListenerType() + " pageSize=" + ((List) ZeusTransformUtils.preCheckCast(this.L$0, List.class, "com.obric.memorydata.plugin")).size(), false, 4, null);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
