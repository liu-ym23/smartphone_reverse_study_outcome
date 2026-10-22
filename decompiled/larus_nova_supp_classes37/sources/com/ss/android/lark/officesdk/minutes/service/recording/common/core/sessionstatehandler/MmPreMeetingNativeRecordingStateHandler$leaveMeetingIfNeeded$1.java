package com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler;

import com.bytedance.lark.pb.basic.v1.Command;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSession;
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
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler.MmPreMeetingNativeRecordingStateHandler$leaveMeetingIfNeeded$1", f = "MmPreMeetingNativeRecordingStateHandler.kt", i = {}, l = {1042, 1050}, m = "invokeSuspend", n = {}, s = {})
final class MmPreMeetingNativeRecordingStateHandler$leaveMeetingIfNeeded$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MmPreMeetingNativeRecordingStateHandler this$0;

    public MmPreMeetingNativeRecordingStateHandler$leaveMeetingIfNeeded$1(MmPreMeetingNativeRecordingStateHandler r1, Continuation<? super MmPreMeetingNativeRecordingStateHandler$leaveMeetingIfNeeded$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new MmPreMeetingNativeRecordingStateHandler$leaveMeetingIfNeeded$1(this.this$0, r3);
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
        Object r8 = ((Result) r7).unbox-impl();
    L24:
        MmPreMeetingNativeRecordingStateHandler r2 = this.this$0;
        if (Result.isSuccess-impl(r8) == false) goto L27;
        lvb.a.e(r2.c, "[leaveMeeting] success " + ((MinutesRecordingStopResponse) r8));
    L27:
        MmPreMeetingNativeRecordingStateHandler r4 = this.this$0;
        Throwable r9 = Result.exceptionOrNull-impl(r8);
        if (r9 == null) goto L31;
        lvb.a.b(r4.c, "[leaveMeeting] failed " + r9);
    L31:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r7);
    L13:
        ovb.b r10 = (ovb.b) r7;
        if (r10.h == true) goto L16;
    L32:
        lvb.a.e(this.this$0.c, "[leaveMeetingIfNeeded] meetingId not bound, skip leaveMeeting");
        return Unit.INSTANCE;
    L16:
        if (r10.a.length() == 0) goto L19;
        r3 = false;
    L19:
        if (r3 == true) goto L32;
        String r11 = r10.a;
        lvb.a.e(this.this$0.c, "[leaveMeeting] meetingId " + r11);
        com.ss.android.lark.officesdk.minutes.service.foundation.network.b r5 = (com.ss.android.lark.officesdk.minutes.service.foundation.network.b) this.this$0.h.getValue();
        Command r6 = Command.MINUTES_RECORDING_STOP;
        MinutesRecordingStopRequest r12 = new MinutesRecordingStopRequest.Builder().session_id(r11).m1886build();
        this.label = 2;
        r8 = r5.b(r6, MinutesRecordingStopResponse.class, r12, this);
        if (r8 != r0) goto L24;
        return r0;
    L10:
        ResultKt.throwOnFailure(r7);
        MmRecordingSession r13 = this.this$0.a;
        this.label = 1;
        r7 = r13.r(this);
        if (r7 != r0) goto L13;
        return r0;
    }
}
