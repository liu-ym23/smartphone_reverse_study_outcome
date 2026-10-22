package com.obric.aiproactive.ui.entry;

import android.content.Context;
import android.widget.Toast;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.aiproactive.api.ProactiveRecommendationDto;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiproactive.ui.entry.BaseProactiveFeedPageFragment$onViewCreated$adapter$1$onSummaryActionClick$2", f = "BaseProactiveFeedPageFragment.kt", i = {}, l = {291}, m = "invokeSuspend", n = {}, s = {})
final class BaseProactiveFeedPageFragment$onViewCreated$adapter$1$onSummaryActionClick$2 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.obric.aiproactive.api.b $action;
    final /* synthetic */ com.obric.aiproactive.ui.model.j.f $item;
    int label;
    final /* synthetic */ BaseProactiveFeedPageFragment this$0;

    BaseProactiveFeedPageFragment$onViewCreated$adapter$1$onSummaryActionClick$2(com.obric.aiproactive.api.b r3, BaseProactiveFeedPageFragment r4, com.obric.aiproactive.ui.model.j.f r5, Continuation<? super BaseProactiveFeedPageFragment$onViewCreated$adapter$1$onSummaryActionClick$2> r6) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        this.$action = r3;
        this.this$0 = r4;
        this.$item = r5;
        super(2, r7);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new BaseProactiveFeedPageFragment$onViewCreated$adapter$1$onSummaryActionClick$2(this.$action, this.this$0, this.$item, r6), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((BaseProactiveFeedPageFragment$onViewCreated$adapter$1$onSummaryActionClick$2) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), BaseProactiveFeedPageFragment$onViewCreated$adapter$1$onSummaryActionClick$2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r11);
    L14:
        boolean r12 = ((Boolean) ZeusTransformUtils.preCheckCast(r11, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), this.this$0.getLogTag(), "[Fragment] executeSummaryAction id=" + this.$item.b().getRecommendId() + " ok=" + r12, false, 4, null);
        if (r12 == false) goto L17;
        this.this$0.onRecommendationAdopted(this.$item);
        BaseProactiveFeedViewModel.optimisticallyUpdateRecommendStatus$default(this.this$0.getBaseViewModel(), this.$item.b().getInspirationId(), 2, false, 4, null);
        BaseProactiveFeedPageFragment.access$updateRecommendStatusToAdopted(this.this$0, this.$item.b());
    L19:
        return Unit.INSTANCE;
    L17:
        Toast.makeText((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.this$0.requireContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(this.this$0.getString(ZeusTransformUtils.mapRes(R.string.proactive_execute_failed, TypedValues.Custom.S_STRING, "proactive_execute_failed")), CharSequence.class, "com.obric.memorydata.plugin"), 0).show();
        goto L19
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        CharSequence r13 = (CharSequence) ZeusTransformUtils.preCheckCast(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(this.$action.b(), CharSequence.class, "com.obric.memorydata.plugin")).toString(), CharSequence.class, "com.obric.memorydata.plugin");
        com.obric.aiproactive.api.b r2 = this.$action;
        if (StringsKt.isBlank(r13) == false) goto L11;
        r13 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r2.a(), CharSequence.class, "com.obric.memorydata.plugin")).toString();
    L11:
        String r14 = (String) ZeusTransformUtils.preCheckCast(r13, String.class, "com.obric.memorydata.plugin");
        com.obric.aiproactive.ui.task.a r3 = BaseProactiveFeedPageFragment.access$getExecutor$p(this.this$0);
        Context r4 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.this$0.requireContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r4, "requireContext(...)");
        ProactiveRecommendationDto r5 = this.$item.b();
        Continuation<? super Boolean> r6 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        r11 = r3.a(r4, r5, r14, r6);
        if (r11 != r0) goto L14;
        return r0;
    }
}
