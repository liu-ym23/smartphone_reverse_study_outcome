package com.ss.android.lark.officesdk.minutes.assembly.recording.common;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.assembly.recording.common.MmRecordingCapacityImpl$startAIInterpretation$1", f = "MmRecordingCapacityImpl.kt", i = {0}, l = {625, 631}, m = "invokeSuspend", n = {"context"}, s = {"L$0"})
final class MmRecordingCapacityImpl$startAIInterpretation$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $recordingId;
    Object L$0;
    int label;
    final /* synthetic */ MmRecordingCapacityImpl this$0;

    public MmRecordingCapacityImpl$startAIInterpretation$1(MmRecordingCapacityImpl r1, String r2, Continuation<? super MmRecordingCapacityImpl$startAIInterpretation$1> r3) {
        this.this$0 = r1;
        this.$recordingId = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new MmRecordingCapacityImpl$startAIInterpretation$1(this.this$0, this.$recordingId, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r3 = true;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r7);
    L34:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        a r2 = (a) this.L$0;
        ResultKt.throwOnFailure(r7);
    L17:
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.d r8 = r2.a.m();
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.g r4 = this.this$0.e.get(this.$recordingId);
        if (r4 != null) goto L24;
        r4 = r8.c;
        if (r4 != null) goto L24;
        r4 = r8.d;
        if (r4 != null) goto L24;
        r4 = (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.g) CollectionsKt.firstOrNull(r8.b);
    L24:
        MmRecordingCapacityImpl r5 = this.this$0;
        if (r4 == null) goto L27;
    L29:
        r3 = false;
    L30:
        this.L$0 = null;
        this.label = 2;
        if (MmRecordingCapacityImpl.e(r5, r2, r4, r3, this) != r0) goto L34;
        return r0;
    L27:
        if (r8.b.isEmpty() == false) goto L29;
    L10:
        ResultKt.throwOnFailure(r7);
        r2 = MmRecordingCapacityImpl.c(this.this$0, this.$recordingId);
        if (r2 == null) goto L13;
        MmRecordingCapacityImpl r9 = this.this$0;
        this.L$0 = r2;
        this.label = 1;
        if (MmRecordingCapacityImpl.b(r9, r2, this) != r0) goto L17;
        return r0;
    L13:
        return Unit.INSTANCE;
    }
}
