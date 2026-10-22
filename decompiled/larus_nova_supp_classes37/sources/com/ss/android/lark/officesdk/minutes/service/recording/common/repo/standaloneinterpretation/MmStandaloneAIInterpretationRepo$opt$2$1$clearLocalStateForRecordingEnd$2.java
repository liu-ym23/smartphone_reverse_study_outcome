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
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.MmStandaloneAIInterpretationRepo$opt$2$1$clearLocalStateForRecordingEnd$2", f = "MmStandaloneAIInterpretationRepo.kt", i = {}, l = {321}, m = "invokeSuspend", n = {}, s = {})
public final class MmStandaloneAIInterpretationRepo$opt$2$1$clearLocalStateForRecordingEnd$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MmStandaloneAIInterpretationRepo this$0;
    final /* synthetic */ MmStandaloneAIInterpretationRepo$opt$2.AnonymousClass1 this$1;

    public MmStandaloneAIInterpretationRepo$opt$2$1$clearLocalStateForRecordingEnd$2(MmStandaloneAIInterpretationRepo r1, MmStandaloneAIInterpretationRepo$opt$2.AnonymousClass1 r2, Continuation<? super MmStandaloneAIInterpretationRepo$opt$2$1$clearLocalStateForRecordingEnd$2> r3) {
        this.this$0 = r1;
        this.this$1 = r2;
        super(1, r3);
    }

    public final Continuation<Unit> create(Continuation<?> r4) {
        return new MmStandaloneAIInterpretationRepo$opt$2$1$clearLocalStateForRecordingEnd$2(this.this$0, this.this$1, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super Unit> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L20:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        MmStandaloneAIInterpretationRepo.l(this.this$0, "standalone_clear_local_state");
        b r7 = (b) this.this$1.m();
        if (r7.a == false) goto L11;
    L16:
        MmStandaloneAIInterpretationRepo r2 = this.this$0;
        b r8 = b.b(r7, null, null, 254);
        this.label = 1;
        if (r2.b(r8, this) != r0) goto L20;
        return r0;
    L11:
        if (r7.i != null) goto L16;
        if (r7.j != null) goto L16;
        lvb.a.e(this.this$0.l, "[clearLocalStateForRecordingEnd] skip, already cleared");
        return Unit.INSTANCE;
    }
}
