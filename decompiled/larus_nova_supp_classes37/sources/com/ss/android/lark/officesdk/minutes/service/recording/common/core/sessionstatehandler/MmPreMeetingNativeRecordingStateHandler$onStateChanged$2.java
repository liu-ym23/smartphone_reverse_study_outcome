package com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler;

import com.ss.android.lark.officesdk.minutes.service.recording.common.core.data.TerminateReason;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.MmRecordingAudioService;
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
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler.MmPreMeetingNativeRecordingStateHandler$onStateChanged$2", f = "MmPreMeetingNativeRecordingStateHandler.kt", i = {}, l = {311, 312, 315}, m = "invokeSuspend", n = {}, s = {})
public final class MmPreMeetingNativeRecordingStateHandler$onStateChanged$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MmRecordingAudioService $audioService;
    int label;
    final /* synthetic */ MmPreMeetingNativeRecordingStateHandler this$0;

    public MmPreMeetingNativeRecordingStateHandler$onStateChanged$2(MmRecordingAudioService r1, MmPreMeetingNativeRecordingStateHandler r2, Continuation<? super MmPreMeetingNativeRecordingStateHandler$onStateChanged$2> r3) {
        this.$audioService = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new MmPreMeetingNativeRecordingStateHandler$onStateChanged$2(this.$audioService, this.this$0, r4);
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
    L21:
        this.this$0.a.u(new com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.a.n(TerminateReason.UPLOAD_COMPLETED));
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r6);
    L18:
        this.label = 3;
        if (DelayKt.delay(100, this) != r0) goto L21;
        return r0;
    L11:
        ResultKt.throwOnFailure(r6);
    L15:
        MmPreMeetingNativeRecordingStateHandler r7 = this.this$0;
        MmRecordingAudioService r2 = this.$audioService;
        this.label = 2;
        if (MmPreMeetingNativeRecordingStateHandler.f(r7, r2, this) != r0) goto L18;
        return r0;
    L12:
        ResultKt.throwOnFailure(r6);
        MmRecordingAudioService r8 = this.$audioService;
        this.label = 1;
        if (r8.c(this) != r0) goto L15;
        return r0;
    }
}
