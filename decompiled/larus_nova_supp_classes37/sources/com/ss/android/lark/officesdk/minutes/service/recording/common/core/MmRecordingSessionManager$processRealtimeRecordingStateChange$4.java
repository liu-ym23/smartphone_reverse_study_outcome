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
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSessionManager$processRealtimeRecordingStateChange$4", f = "MmRecordingSessionManager.kt", i = {}, l = {1912}, m = "invokeSuspend", n = {}, s = {})
final class MmRecordingSessionManager$processRealtimeRecordingStateChange$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c $currentState;
    final /* synthetic */ com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c $lastState;
    final /* synthetic */ MmRecordingSession $session;
    int label;
    final /* synthetic */ MmRecordingSessionManager this$0;

    public MmRecordingSessionManager$processRealtimeRecordingStateChange$4(com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c r1, MmRecordingSessionManager r2, MmRecordingSession r3, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c r4, Continuation<? super MmRecordingSessionManager$processRealtimeRecordingStateChange$4> r5) {
        this.$lastState = r1;
        this.this$0 = r2;
        this.$session = r3;
        this.$currentState = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new MmRecordingSessionManager$processRealtimeRecordingStateChange$4(this.$lastState, this.this$0, this.$session, this.$currentState, r8);
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
        if (Intrinsics.areEqual(this.$lastState, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.h.c) == false) goto L11;
        MmRecordingState r13 = MmRecordingState.PAUSED;
    L12:
        MmRecordingState r6 = r13;
        MmRecordingSessionManager r14 = this.this$0;
        MmRecordingSession r2 = this.$session;
        com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c r9 = this.$currentState;
        r r10 = new r(r2.e(), MmRecordingState.IDLE, r6, false, 24);
        this.label = 1;
        int r3 = MmRecordingSessionManager.I;
        if (r14.l(r2, r9, r10, this) != r0) goto L16;
        return r0;
    L11:
        r13 = MmRecordingState.RECORDING;
        goto L12
    }
}
