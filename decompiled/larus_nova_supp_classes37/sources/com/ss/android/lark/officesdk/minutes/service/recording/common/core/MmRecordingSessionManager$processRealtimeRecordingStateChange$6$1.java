package com.ss.android.lark.officesdk.minutes.service.recording.common.core;

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
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSessionManager$processRealtimeRecordingStateChange$6$1", f = "MmRecordingSessionManager.kt", i = {}, l = {1946}, m = "invokeSuspend", n = {}, s = {})
final class MmRecordingSessionManager$processRealtimeRecordingStateChange$6$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c $currentState;
    final /* synthetic */ MmRecordingSession $session;
    final /* synthetic */ r $stateData;
    int label;
    final /* synthetic */ MmRecordingSessionManager this$0;

    public MmRecordingSessionManager$processRealtimeRecordingStateChange$6$1(MmRecordingSessionManager r1, MmRecordingSession r2, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c r3, r r4, Continuation<? super MmRecordingSessionManager$processRealtimeRecordingStateChange$6$1> r5) {
        this.this$0 = r1;
        this.$session = r2;
        this.$currentState = r3;
        this.$stateData = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new MmRecordingSessionManager$processRealtimeRecordingStateChange$6$1(this.this$0, this.$session, this.$currentState, this.$stateData, r8);
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
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        MmRecordingSessionManager r7 = this.this$0;
        MmRecordingSession r2 = this.$session;
        com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c r3 = this.$currentState;
        r r4 = this.$stateData;
        this.label = 1;
        int r5 = MmRecordingSessionManager.I;
        if (r7.l(r2, r3, r4, this) != r0) goto L12;
        return r0;
    }
}
