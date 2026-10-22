package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/standaloneinterpretation/MmStandaloneAIInterpretationPlaybackMuteResult;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.MmStandaloneAIInterpretationRepo$rollbackLanguageSwitch$2", f = "MmStandaloneAIInterpretationRepo.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MmStandaloneAIInterpretationRepo$rollbackLanguageSwitch$2 extends SuspendLambda implements Function1<Continuation<? super d>, Object> {
    final /* synthetic */ g $targetResult;
    int label;
    final /* synthetic */ MmStandaloneAIInterpretationRepo this$0;

    public MmStandaloneAIInterpretationRepo$rollbackLanguageSwitch$2(MmStandaloneAIInterpretationRepo r1, g r2, Continuation<? super MmStandaloneAIInterpretationRepo$rollbackLanguageSwitch$2> r3) {
        this.this$0 = r1;
        this.$targetResult = r2;
        super(1, r3);
    }

    public final Continuation<Unit> create(Continuation<?> r4) {
        return new MmStandaloneAIInterpretationRepo$rollbackLanguageSwitch$2(this.this$0, this.$targetResult, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super d> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r3);
        return MmStandaloneAIInterpretationRepo.m(this.this$0, this.$targetResult.a, "standalone_language_rollback");
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
