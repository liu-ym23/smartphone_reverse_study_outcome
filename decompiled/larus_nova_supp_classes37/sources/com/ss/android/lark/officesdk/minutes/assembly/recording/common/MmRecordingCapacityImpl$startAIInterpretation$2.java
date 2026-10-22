package com.ss.android.lark.officesdk.minutes.assembly.recording.common;

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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.assembly.recording.common.MmRecordingCapacityImpl$startAIInterpretation$2", f = "MmRecordingCapacityImpl.kt", i = {0, 1}, l = {647, 648, 649}, m = "invokeSuspend", n = {"context", "context"}, s = {"L$0", "L$0"})
final class MmRecordingCapacityImpl$startAIInterpretation$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $recordingId;
    final /* synthetic */ com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.g $target;
    Object L$0;
    int label;
    final /* synthetic */ MmRecordingCapacityImpl this$0;

    public MmRecordingCapacityImpl$startAIInterpretation$2(MmRecordingCapacityImpl r1, String r2, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.g r3, Continuation<? super MmRecordingCapacityImpl$startAIInterpretation$2> r4) {
        this.this$0 = r1;
        this.$recordingId = r2;
        this.$target = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new MmRecordingCapacityImpl$startAIInterpretation$2(this.this$0, this.$recordingId, this.$target, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L10;
        if (r1 != 3) goto L9;
        ResultKt.throwOnFailure(r6);
    L27:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        a r2 = (a) this.L$0;
        ResultKt.throwOnFailure(r6);
    L23:
        MmRecordingCapacityImpl r7 = this.this$0;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.g r3 = this.$target;
        this.L$0 = null;
        this.label = 3;
        if (MmRecordingCapacityImpl.e(r7, r2, r3, false, this) != r0) goto L27;
        return r0;
    L11:
        r2 = (a) this.L$0;
        ResultKt.throwOnFailure(r6);
    L20:
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.a r8 = r2.a;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.g r4 = this.$target;
        this.L$0 = r2;
        this.label = 2;
        if (r8.I(r4, this) != r0) goto L23;
        return r0;
    L12:
        ResultKt.throwOnFailure(r6);
        a r9 = MmRecordingCapacityImpl.c(this.this$0, this.$recordingId);
        if (r9 == null) goto L15;
        MmRecordingCapacityImpl r5 = this.this$0;
        this.L$0 = r9;
        this.label = 1;
        if (MmRecordingCapacityImpl.b(r5, r9, this) != r0) goto L19;
        return r0;
    L19:
        r2 = r9;
        goto L20
    L15:
        return Unit.INSTANCE;
    }
}
