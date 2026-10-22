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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSessionManager$processPreMeetingNativeRecordingStateChange$3", f = "MmRecordingSessionManager.kt", i = {}, l = {1734}, m = "invokeSuspend", n = {}, s = {})
final class MmRecordingSessionManager$processPreMeetingNativeRecordingStateChange$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c $currentState;
    final /* synthetic */ com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c $lastState;
    final /* synthetic */ MmRecordingSession $session;
    int label;
    final /* synthetic */ MmRecordingSessionManager this$0;

    public MmRecordingSessionManager$processPreMeetingNativeRecordingStateChange$3(MmRecordingSessionManager r1, MmRecordingSession r2, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c r3, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c r4, Continuation<? super MmRecordingSessionManager$processPreMeetingNativeRecordingStateChange$3> r5) {
        this.this$0 = r1;
        this.$session = r2;
        this.$currentState = r3;
        this.$lastState = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new MmRecordingSessionManager$processPreMeetingNativeRecordingStateChange$3(this.this$0, this.$session, this.$currentState, this.$lastState, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r12);
    L16:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r12);
        MmRecordingSessionManager r13 = this.this$0;
        MmRecordingSession r2 = this.$session;
        com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c r3 = this.$currentState;
        String r5 = r2.e();
        MmRecordingState r6 = MmRecordingState.RECORDING;
        if (Intrinsics.areEqual(this.$lastState, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.h.c) == false) goto L11;
        MmRecordingState r4 = MmRecordingState.PAUSED;
    L12:
        r r10 = new r(r5, r6, r4, false, 24);
        this.label = 1;
        int r7 = MmRecordingSessionManager.I;
        if (r13.l(r2, r3, r10, this) != r0) goto L16;
        return r0;
    L11:
        r4 = MmRecordingState.IDLE;
        goto L12
    }
}
