package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.EndRecordingReason;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.data.TerminateReason;
import com.ss.android.lark.picker.base.view.ItemViewType;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/core/statemachine/MmRecordingSessionState;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync.MmRecordingStatesSyncService$getLocalSessionState$2", f = "MmRecordingStatesSyncService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MmRecordingStatesSyncService$getLocalSessionState$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c>, Object> {
    final /* synthetic */ String $meetingId;
    int label;
    final /* synthetic */ MmRecordingStatesSyncService this$0;

    public MmRecordingStatesSyncService$getLocalSessionState$2(MmRecordingStatesSyncService r1, String r2, Continuation<? super MmRecordingStatesSyncService$getLocalSessionState$2> r3) {
        this.this$0 = r1;
        this.$meetingId = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new MmRecordingStatesSyncService$getLocalSessionState$2(this.this$0, this.$meetingId, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L22;
        ResultKt.throwOnFailure(r4);
        MmRecordingStatesSyncService r5 = this.this$0;
        MmRecordingStatesSyncService.Companion r0 = MmRecordingStatesSyncService.q;
        e r6 = r5.l();
        String r1 = this.$meetingId;
        r6.getClass();
        Intrinsics.checkNotNullParameter(r1, "meetingId");
        int r7 = r6.a.H().getInt("minutes_recording_v2_local_state_" + r1, 0);
        int r2 = com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.b;
        switch(r7) {
            case 0: goto L20;
            case 1: goto L35;
            case 2: goto L34;
            case 3: goto L33;
            case 4: goto L32;
            case 5: goto L31;
            case 6: goto L30;
            case 7: goto L29;
            case 8: goto L28;
            case 9: goto L27;
            case 10: goto L26;
            case 11: goto L25;
            case 12: goto L24;
            default: goto L23;
        };
    L23:
        return com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.C0037c.c;
    L24:
        return com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.d.c;
    L25:
        return new com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.m(TerminateReason.OTHERS);
    L26:
        return com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.n.c;
    L27:
        return com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.i.c;
    L28:
        return new com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.b(EndRecordingReason.OTHERS);
    L29:
        return com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.h.c;
    L30:
        return com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.k.c;
    L31:
        return com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.l.c;
    L32:
        return com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.g.c;
    L33:
        return com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.f.c;
    L34:
        return com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.e.c;
    L35:
        return com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.j.c;
    L20:
        return com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.C0037c.c;
    L22:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
