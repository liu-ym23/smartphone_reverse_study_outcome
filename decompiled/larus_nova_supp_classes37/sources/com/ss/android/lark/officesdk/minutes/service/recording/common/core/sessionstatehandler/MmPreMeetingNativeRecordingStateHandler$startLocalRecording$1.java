package com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler;

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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler.MmPreMeetingNativeRecordingStateHandler$startLocalRecording$1", f = "MmPreMeetingNativeRecordingStateHandler.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MmPreMeetingNativeRecordingStateHandler$startLocalRecording$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MmPreMeetingNativeRecordingStateHandler this$0;

    public MmPreMeetingNativeRecordingStateHandler$startLocalRecording$1(MmPreMeetingNativeRecordingStateHandler r1, Continuation<? super MmPreMeetingNativeRecordingStateHandler$startLocalRecording$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new MmPreMeetingNativeRecordingStateHandler$startLocalRecording$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L24;
        ResultKt.throwOnFailure(r4);
        MmRecordingAudioService r5 = this.this$0.k("startLocalRecording");
        if (r5 == null) goto L7;
        lvb.a.e(this.this$0.c, "startLocalRecording: starting local audio capture");
        if (this.this$0.o(r5, "startLocalRecording") == false) goto L11;
        final MmPreMeetingNativeRecordingStateHandler r6 = this.this$0;
        if (r6.u == true) goto L15;
    L18:
        this.this$0.a.u(com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.a.j.a);
        MmPreMeetingNativeRecordingStateHandler r7 = this.this$0;
        if (r7.u == true) goto L22;
        r7.j();
    L22:
        return Unit.INSTANCE;
    L15:
        if (r6.v == true) goto L18;
        r6.v = true;
        com.ss.android.lark.officesdk.minutes.service.recording.common.perf.appreciable.a.d.b(new MmPreMeetingNativeRecordingStateHandler$trackOfflineLocalStartSuccessIfNeeded$1(r6));
        goto L18
    L11:
        return Unit.INSTANCE;
    L7:
        return Unit.INSTANCE;
    L24:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
