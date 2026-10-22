package com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingError;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.MmRecordingAudioService;
import com.ss.android.lark.pb.minutes.v1.MinutesRecordingStartResponse;
import com.ss.android.lark.picker.base.view.ItemViewType;
import iub.j;
import kotlin.Metadata;
import kotlin.Result;
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
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler.MmPreMeetingNativeRecordingStateHandler$retryCreateRecording$4", f = "MmPreMeetingNativeRecordingStateHandler.kt", i = {}, l = {814, 815}, m = "invokeSuspend", n = {}, s = {})
public final class MmPreMeetingNativeRecordingStateHandler$retryCreateRecording$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ iub.a<j, MmRecordingError> $callback;
    final /* synthetic */ ovb.b $recordingData;
    int label;
    final /* synthetic */ MmPreMeetingNativeRecordingStateHandler this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public MmPreMeetingNativeRecordingStateHandler$retryCreateRecording$4(MmPreMeetingNativeRecordingStateHandler r1, ovb.b r2, iub.a<j, ? super MmRecordingError> r3, Continuation<? super MmPreMeetingNativeRecordingStateHandler$retryCreateRecording$4> r4) {
        this.this$0 = r1;
        this.$recordingData = r2;
        this.$callback = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new MmPreMeetingNativeRecordingStateHandler$retryCreateRecording$4(this.this$0, this.$recordingData, this.$callback, r5);
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
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r6);
        Object r7 = ((Result) r6).unbox-impl();
    L23:
        boolean r8 = Result.isSuccess-impl(r7);
    L24:
        if (r8 == false) goto L26;
        lvb.a.e(this.this$0.c, "[retryCreateRecording] RTC reconnected, meetingId=" + this.$recordingData.a);
        this.$callback.onSuccess(new j(this.this$0.a.e()));
    L28:
        return Unit.INSTANCE;
    L26:
        lvb.a.h(this.this$0.c, "[retryCreateRecording] RTC reconnect failed, meetingId=" + this.$recordingData.a);
        this.$callback.a(MmRecordingError.CreateRecordingRequestFailed.INSTANCE);
        goto L28
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r6);
    L19:
        r8 = ((Boolean) r6).booleanValue();
        goto L24
    L10:
        ResultKt.throwOnFailure(r6);
        MmRecordingAudioService r9 = this.this$0.k("retryCreateRecording");
        if (r9 == null) goto L13;
        MmPreMeetingNativeRecordingStateHandler r2 = this.this$0;
        MinutesRecordingStartResponse r4 = r2.t;
        if (r4 == null) goto L20;
        this.label = 1;
        r6 = MmPreMeetingNativeRecordingStateHandler.g(r2, r4, this);
        if (r6 != r0) goto L19;
        return r0;
    L20:
        this.label = 2;
        r7 = r9.j(this);
        if (r7 != r0) goto L23;
        return r0;
    L13:
        return Unit.INSTANCE;
    }
}
