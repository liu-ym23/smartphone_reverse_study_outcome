package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/standaloneinterpretation/MmStandaloneAIInterpretationUpdateResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.MmStandaloneAIInterpretationRepo$requestBidirectionalLanguageSwitch$2", f = "MmStandaloneAIInterpretationRepo.kt", i = {0}, l = {413, 413}, m = "invokeSuspend", n = {"enableDeferred"}, s = {"L$0"})
final class MmStandaloneAIInterpretationRepo$requestBidirectionalLanguageSwitch$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Pair<? extends g, ? extends g>>, Object> {
    final /* synthetic */ String $meetingId;
    final /* synthetic */ c $previousTarget;
    final /* synthetic */ c $targetLanguage;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MmStandaloneAIInterpretationRepo this$0;

    public MmStandaloneAIInterpretationRepo$requestBidirectionalLanguageSwitch$2(MmStandaloneAIInterpretationRepo r1, String r2, c r3, c r4, Continuation<? super MmStandaloneAIInterpretationRepo$requestBidirectionalLanguageSwitch$2> r5) {
        this.this$0 = r1;
        this.$meetingId = r2;
        this.$previousTarget = r3;
        this.$targetLanguage = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        MmStandaloneAIInterpretationRepo$requestBidirectionalLanguageSwitch$2 r6 = new MmStandaloneAIInterpretationRepo$requestBidirectionalLanguageSwitch$2(this.this$0, this.$meetingId, this.$previousTarget, this.$targetLanguage, r9);
        r6.L$0 = r8;
        return r6;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Pair<g, g>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        Object r2 = this.L$0;
        ResultKt.throwOnFailure(r13);
    L19:
        return TuplesKt.to(r2, r13);
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        Deferred r3 = (Deferred) this.L$0;
        ResultKt.throwOnFailure(r13);
    L14:
        this.L$0 = r13;
        this.label = 2;
        Object r4 = r3.await(this);
        if (r4 != r0) goto L17;
        return r0;
    L17:
        r2 = r13;
        r13 = r4;
        goto L19
    L10:
        ResultKt.throwOnFailure(r13);
        CoroutineScope r14 = (CoroutineScope) this.L$0;
        Deferred r5 = BuildersKt.async$default(r14, null, null, new MmStandaloneAIInterpretationRepo$requestBidirectionalLanguageSwitch$2$closeDeferred$1(this.this$0, this.$meetingId, this.$previousTarget, null), 3, null);
        Deferred r15 = BuildersKt.async$default(r14, null, null, new MmStandaloneAIInterpretationRepo$requestBidirectionalLanguageSwitch$2$enableDeferred$1(this.this$0, this.$meetingId, this.$targetLanguage, null), 3, null);
        this.L$0 = r15;
        this.label = 1;
        Object r6 = r5.await(this);
        if (r6 != r0) goto L13;
        return r0;
    L13:
        r3 = r15;
        r13 = r6;
        goto L14
    }
}
