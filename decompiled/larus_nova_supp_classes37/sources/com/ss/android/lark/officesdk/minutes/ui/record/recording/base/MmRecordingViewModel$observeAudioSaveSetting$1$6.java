package com.ss.android.lark.officesdk.minutes.ui.record.recording.base;

import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.audiosave.MmRecordingAutoSaveDecisionScene;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
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
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "decision", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/audiosave/MmRecordingAutoSaveDecision;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel$observeAudioSaveSetting$1$6", f = "MmRecordingViewModel.kt", i = {}, l = {928}, m = "invokeSuspend", n = {}, s = {})
public final class MmRecordingViewModel$observeAudioSaveSetting$1$6 extends SuspendLambda implements Function2<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.audiosave.g, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.ss.android.lark.officesdk.minutes.service.recording.common.repo.audiosave.b $audioSaveRepo;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MmRecordingViewModel this$0;

    public MmRecordingViewModel$observeAudioSaveSetting$1$6(MmRecordingViewModel r1, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.audiosave.b r2, Continuation<? super MmRecordingViewModel$observeAudioSaveSetting$1$6> r3) {
        this.this$0 = r1;
        this.$audioSaveRepo = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        MmRecordingViewModel$observeAudioSaveSetting$1$6 r0 = new MmRecordingViewModel$observeAudioSaveSetting$1$6(this.this$0, this.$audioSaveRepo, r5);
        r0.L$0 = r4;
        return r0;
    }

    public final Object invoke(com.ss.android.lark.officesdk.minutes.service.recording.common.repo.audiosave.g r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.audiosave.g) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r8);
    L28:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.audiosave.g r9 = (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.audiosave.g) this.L$0;
        if (MmRecordingViewModel.access$isAudioRetentionEnabled(this.this$0) == true) goto L13;
        int r2 = bwb.b.a;
        bwb.b.f(MmUiLogScene.RECORDING, "observeAudioSaveSetting", "skip auto save dialog, scene=" + r9.a, MmRecordingViewModel.access$getLogDetail(this.this$0));
        return Unit.INSTANCE;
    L13:
        if (r9.a != MmRecordingAutoSaveDecisionScene.RECORD_FINISH) goto L17;
        int r10 = bwb.b.a;
        bwb.b.f(MmUiLogScene.RECORDING, "observeAudioSaveSetting", "skip finish dialog, pending check will handle it", MmRecordingViewModel.access$getLogDetail(this.this$0));
        return Unit.INSTANCE;
    L17:
        if (r9.f == false) goto L20;
        int r3 = bwb.b.a;
        bwb.b.f(MmUiLogScene.RECORDING, "observeAudioSaveSetting", "skip shown auto save dialog, scene=" + r9.a, MmRecordingViewModel.access$getLogDetail(this.this$0));
        return Unit.INSTANCE;
    L20:
        int r4 = bwb.b.a;
        MmUiLogScene r5 = MmUiLogScene.RECORDING;
        bwb.b.a(r5, "observeAudioSaveSetting", "auto save decision=" + r9, MmRecordingViewModel.access$getLogDetail(this.this$0));
        b r6 = MmRecordingViewModel.access$getAutoSaveDialogLimiter$p(this.this$0).a(r9);
        if (r6 == null) goto L23;
        bwb.b.f(r5, "observeAudioSaveSetting", "show auto save dialog, scene=" + r9.a + ", reason=" + r6.b, MmRecordingViewModel.access$getLogDetail(this.this$0));
        this.$audioSaveRepo.D0();
        MmRecordingViewModel r11 = this.this$0;
        h.d r7 = new h.d(r6);
        this.label = 1;
        if (r11.sendVMEvent(r7, this) != r0) goto L28;
        return r0;
    L23:
        return Unit.INSTANCE;
    }
}
