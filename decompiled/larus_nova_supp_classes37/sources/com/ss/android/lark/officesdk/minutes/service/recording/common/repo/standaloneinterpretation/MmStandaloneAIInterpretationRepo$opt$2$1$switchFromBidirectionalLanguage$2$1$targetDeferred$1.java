package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/standaloneinterpretation/MmStandaloneAIInterpretationUpdateResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.MmStandaloneAIInterpretationRepo$opt$2$1$switchFromBidirectionalLanguage$2$1$targetDeferred$1", f = "MmStandaloneAIInterpretationRepo.kt", i = {}, l = {176}, m = "invokeSuspend", n = {}, s = {})
public final class MmStandaloneAIInterpretationRepo$opt$2$1$switchFromBidirectionalLanguage$2$1$targetDeferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Pair<? extends g, ? extends g>>, Object> {
    final /* synthetic */ String $meetingId;
    final /* synthetic */ c $previousTarget;
    final /* synthetic */ c $targetLanguage;
    int label;
    final /* synthetic */ MmStandaloneAIInterpretationRepo this$0;

    public MmStandaloneAIInterpretationRepo$opt$2$1$switchFromBidirectionalLanguage$2$1$targetDeferred$1(MmStandaloneAIInterpretationRepo r1, String r2, c r3, c r4, Continuation<? super MmStandaloneAIInterpretationRepo$opt$2$1$switchFromBidirectionalLanguage$2$1$targetDeferred$1> r5) {
        this.this$0 = r1;
        this.$meetingId = r2;
        this.$previousTarget = r3;
        this.$targetLanguage = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new MmStandaloneAIInterpretationRepo$opt$2$1$switchFromBidirectionalLanguage$2$1$targetDeferred$1(this.this$0, this.$meetingId, this.$previousTarget, this.$targetLanguage, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Pair<g, g>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r9);
    L11:
        return r9;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r9);
        MmStandaloneAIInterpretationRepo r10 = this.this$0;
        String r3 = this.$meetingId;
        c r4 = this.$previousTarget;
        c r5 = this.$targetLanguage;
        this.label = 1;
        MmStandaloneAIInterpretationRepo.Companion r2 = MmStandaloneAIInterpretationRepo.t;
        r10.getClass();
        r9 = CoroutineScopeKt.coroutineScope(new MmStandaloneAIInterpretationRepo$requestBidirectionalLanguageSwitch$2(r10, r3, r4, r5, null), this);
        if (r9 != r0) goto L11;
        return r0;
    }
}
