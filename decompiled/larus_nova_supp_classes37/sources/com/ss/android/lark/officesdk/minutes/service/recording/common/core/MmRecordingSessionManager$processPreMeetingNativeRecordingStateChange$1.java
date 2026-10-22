package com.ss.android.lark.officesdk.minutes.service.recording.common.core;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingState;
import com.ss.android.lark.picker.base.view.ItemViewType;
import iub.r;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSessionManager$processPreMeetingNativeRecordingStateChange$1", f = "MmRecordingSessionManager.kt", i = {}, l = {1697}, m = "invokeSuspend", n = {}, s = {})
final class MmRecordingSessionManager$processPreMeetingNativeRecordingStateChange$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c $lastState;
    final /* synthetic */ MmRecordingSession $session;
    int label;
    final /* synthetic */ MmRecordingSessionManager this$0;

    public MmRecordingSessionManager$processPreMeetingNativeRecordingStateChange$1(MmRecordingSessionManager r1, MmRecordingSession r2, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c r3, Continuation<? super MmRecordingSessionManager$processPreMeetingNativeRecordingStateChange$1> r4) {
        this.this$0 = r1;
        this.$session = r2;
        this.$lastState = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new MmRecordingSessionManager$processPreMeetingNativeRecordingStateChange$1(this.this$0, this.$session, this.$lastState, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L31:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        MmRecordingSessionManager r11 = this.this$0;
        MmRecordingSession r2 = this.$session;
        int r3 = MmRecordingSessionManager.I;
        if (r11.o(r2) == false) goto L12;
        lvb.a.e(this.this$0.b, "[processPreMeetingNativeRecordingStateChange] skip stale state from recordingId=" + this.$session.e() + ", another active realtime session exists");
        return Unit.INSTANCE;
    L12:
        StateFlowImpl r12 = this.this$0.r;
        String r4 = this.$session.e();
        MmRecordingState r5 = MmRecordingState.IDLE;
        MmRecordingSessionManager r6 = this.this$0;
        com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c r7 = this.$lastState;
        r6.getClass();
        if (Intrinsics.areEqual(r7, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.h.c) == false) goto L16;
        MmRecordingState r8 = MmRecordingState.PAUSED;
    L25:
        MmRecordingState r9 = r8;
    L27:
        r r13 = new r(r4, r5, r9, false, 24);
        this.label = 1;
        r12.setValue(r13);
        if (Unit.INSTANCE != r0) goto L31;
        return r0;
    L16:
        if ((r7 instanceof com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.b) == false) goto L18;
    L26:
        r9 = r5;
        goto L27
    L18:
        if (Intrinsics.areEqual(r7, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.i.c) == true) goto L26;
        if (Intrinsics.areEqual(r7, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.n.c) == true) goto L26;
        if ((r7 instanceof com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.m) == true) goto L26;
        r8 = MmRecordingState.RECORDING;
        goto L25
    }
}
