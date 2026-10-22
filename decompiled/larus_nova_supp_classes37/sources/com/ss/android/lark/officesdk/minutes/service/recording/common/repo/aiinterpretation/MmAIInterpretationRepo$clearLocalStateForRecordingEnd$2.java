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
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.MmAIInterpretationRepo$clearLocalStateForRecordingEnd$2", f = "MmAIInterpretationRepo.kt", i = {}, l = {355}, m = "invokeSuspend", n = {}, s = {})
public final class MmAIInterpretationRepo$clearLocalStateForRecordingEnd$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MmAIInterpretationRepo this$0;

    public MmAIInterpretationRepo$clearLocalStateForRecordingEnd$2(MmAIInterpretationRepo r1, Continuation<? super MmAIInterpretationRepo$clearLocalStateForRecordingEnd$2> r2) {
        this.this$0 = r1;
        super(1, r2);
    }

    public final Continuation<Unit> create(Continuation<?> r3) {
        return new MmAIInterpretationRepo$clearLocalStateForRecordingEnd$2(this.this$0, r3);
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
    L22:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r13);
        MmAIInterpretationRepo r14 = this.this$0;
        r14.p = null;
        d r3 = r14.h();
        if (r3.a == false) goto L11;
    L18:
        MmAIInterpretationRepo r15 = this.this$0;
        d r2 = d.a(r3, false, null, null, null, false, false, null, 38);
        this.label = 1;
        if (r15.b(r2, this) != r0) goto L22;
        return r0;
    L11:
        if (r3.e == true) goto L18;
        if (r3.d != null) goto L18;
        if (r3.g != null) goto L18;
        lvb.a.e(this.this$0.n, "[clearLocalStateForRecordingEnd] skip, already cleared");
        return Unit.INSTANCE;
    }
}
