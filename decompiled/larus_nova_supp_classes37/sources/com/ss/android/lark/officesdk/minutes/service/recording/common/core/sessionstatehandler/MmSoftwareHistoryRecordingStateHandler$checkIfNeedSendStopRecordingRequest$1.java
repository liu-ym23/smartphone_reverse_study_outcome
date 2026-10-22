package com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler;

import com.bytedance.lark.pb.basic.v1.Command;
import com.ss.android.lark.pb.minutes.v1.MinutesRecordingStopRequest;
import com.ss.android.lark.pb.minutes.v1.MinutesRecordingStopResponse;
import com.ss.android.lark.picker.base.view.ItemViewType;
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
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler.MmSoftwareHistoryRecordingStateHandler$checkIfNeedSendStopRecordingRequest$1", f = "MmSoftwareHistoryRecordingStateHandler.kt", i = {}, l = {238}, m = "invokeSuspend", n = {}, s = {})
final class MmSoftwareHistoryRecordingStateHandler$checkIfNeedSendStopRecordingRequest$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $meetingId;
    int label;
    final /* synthetic */ MmSoftwareHistoryRecordingStateHandler this$0;

    public MmSoftwareHistoryRecordingStateHandler$checkIfNeedSendStopRecordingRequest$1(MmSoftwareHistoryRecordingStateHandler r1, String r2, Continuation<? super MmSoftwareHistoryRecordingStateHandler$checkIfNeedSendStopRecordingRequest$1> r3) {
        this.this$0 = r1;
        this.$meetingId = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new MmSoftwareHistoryRecordingStateHandler$checkIfNeedSendStopRecordingRequest$1(this.this$0, this.$meetingId, r4);
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
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
        Object r8 = ((Result) r7).unbox-impl();
    L11:
        MmSoftwareHistoryRecordingStateHandler r2 = this.this$0;
        String r3 = this.$meetingId;
        if (Result.isSuccess-impl(r8) == false) goto L14;
        lvb.a.e(r2.b, "[stopRecordingRequest] success " + ((MinutesRecordingStopResponse) r8) + ", meetingId: " + r3);
    L14:
        MmSoftwareHistoryRecordingStateHandler r4 = this.this$0;
        String r5 = this.$meetingId;
        Throwable r9 = Result.exceptionOrNull-impl(r8);
        if (r9 == null) goto L18;
        lvb.a.b(r4.b, "[stopRecordingRequest] failed " + r9 + ", meetingId: " + r5);
    L18:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        lvb.a.e(this.this$0.b, "[stopRecordingRequest] start, meetingId: " + this.$meetingId);
        com.ss.android.lark.officesdk.minutes.service.foundation.network.b r10 = (com.ss.android.lark.officesdk.minutes.service.foundation.network.b) this.this$0.d.getValue();
        Command r6 = Command.MINUTES_RECORDING_STOP;
        MinutesRecordingStopRequest r11 = new MinutesRecordingStopRequest.Builder().session_id(this.$meetingId).m1886build();
        this.label = 1;
        r8 = r10.b(r6, MinutesRecordingStopResponse.class, r11, this);
        if (r8 != r0) goto L11;
        return r0;
    }
}
