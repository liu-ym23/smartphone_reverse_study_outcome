package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/standaloneinterpretation/MmStandaloneAIInterpretationUpdateResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.MmStandaloneAIInterpretationRepo$opt$2$1$switchTargetLanguage$2$1$closeDeferred$1", f = "MmStandaloneAIInterpretationRepo.kt", i = {}, l = {127}, m = "invokeSuspend", n = {}, s = {})
public final class MmStandaloneAIInterpretationRepo$opt$2$1$switchTargetLanguage$2$1$closeDeferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super g>, Object> {
    final /* synthetic */ c $activeLanguage;
    final /* synthetic */ String $meetingId;
    int label;
    final /* synthetic */ MmStandaloneAIInterpretationRepo this$0;

    public MmStandaloneAIInterpretationRepo$opt$2$1$switchTargetLanguage$2$1$closeDeferred$1(MmStandaloneAIInterpretationRepo r1, String r2, c r3, Continuation<? super MmStandaloneAIInterpretationRepo$opt$2$1$switchTargetLanguage$2$1$closeDeferred$1> r4) {
        this.this$0 = r1;
        this.$meetingId = r2;
        this.$activeLanguage = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new MmStandaloneAIInterpretationRepo$opt$2$1$switchTargetLanguage$2$1$closeDeferred$1(this.this$0, this.$meetingId, this.$activeLanguage, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super g> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L11:
        return r5;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        MmStandaloneAIInterpretationRepo r6 = this.this$0;
        String r2 = this.$meetingId;
        c r3 = this.$activeLanguage;
        this.label = 1;
        MmStandaloneAIInterpretationRepo.Companion r4 = MmStandaloneAIInterpretationRepo.t;
        r5 = r6.v(r2, false, r3, this);
        if (r5 != r0) goto L11;
        return r0;
    }
}
