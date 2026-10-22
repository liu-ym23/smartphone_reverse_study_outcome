package com.ss.android.lark.officesdk.minutes.service.recording.common.repo;

import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.audiosave.MmAudioSaveType;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "audioSaveType", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/audiosave/MmAudioSaveType;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.MmRecordingRepo$subscribeAudioSaveForAIInterpretation$2", f = "MmRecordingRepo.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MmRecordingRepo$subscribeAudioSaveForAIInterpretation$2 extends SuspendLambda implements Function2<MmAudioSaveType, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MmRecordingRepo this$0;

    public MmRecordingRepo$subscribeAudioSaveForAIInterpretation$2(MmRecordingRepo r1, Continuation<? super MmRecordingRepo$subscribeAudioSaveForAIInterpretation$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        MmRecordingRepo$subscribeAudioSaveForAIInterpretation$2 r0 = new MmRecordingRepo$subscribeAudioSaveForAIInterpretation$2(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(MmAudioSaveType r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((MmAudioSaveType) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r2);
        MmAudioSaveType r3 = (MmAudioSaveType) this.L$0;
        this.this$0.q().n().W(r3);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
