package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation;

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
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.MmAIInterpretationRepo$opt$2$1$switchLanguage$3$1", f = "MmAIInterpretationRepo.kt", i = {}, l = {166}, m = "invokeSuspend", n = {}, s = {})
public final class MmAIInterpretationRepo$opt$2$1$switchLanguage$3$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MmAIInterpretationRepo this$0;
    final /* synthetic */ MmAIInterpretationRepo$opt$2.AnonymousClass1 this$1;

    public MmAIInterpretationRepo$opt$2$1$switchLanguage$3$1(MmAIInterpretationRepo r1, MmAIInterpretationRepo$opt$2.AnonymousClass1 r2, Continuation<? super MmAIInterpretationRepo$opt$2$1$switchLanguage$3$1> r3) {
        this.this$0 = r1;
        this.this$1 = r2;
        super(1, r3);
    }

    public final Continuation<Unit> create(Continuation<?> r4) {
        return new MmAIInterpretationRepo$opt$2$1$switchLanguage$3$1(this.this$0, this.this$1, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super Unit> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r13);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r13);
        MmAIInterpretationRepo r14 = this.this$0;
        d r2 = d.a((d) this.this$1.m(), false, null, null, null, false, false, "update_failed", 47);
        this.label = 1;
        if (r14.b(r2, this) != r0) goto L12;
        return r0;
    }
}
