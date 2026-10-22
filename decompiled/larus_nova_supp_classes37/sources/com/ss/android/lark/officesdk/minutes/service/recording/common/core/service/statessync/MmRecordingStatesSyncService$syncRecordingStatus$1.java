package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync;

import com.ss.android.lark.officesdk.minutes.service.foundation.network.request.http.MmRecordingUpdateStatus;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSession;
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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync.MmRecordingStatesSyncService$syncRecordingStatus$1", f = "MmRecordingStatesSyncService.kt", i = {}, l = {352, 357, 362, 367}, m = "invokeSuspend", n = {}, s = {})
public final class MmRecordingStatesSyncService$syncRecordingStatus$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c $sessionState;
    int label;
    final /* synthetic */ MmRecordingStatesSyncService this$0;

    public MmRecordingStatesSyncService$syncRecordingStatus$1(MmRecordingStatesSyncService r1, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c r2, Continuation<? super MmRecordingStatesSyncService$syncRecordingStatus$1> r3) {
        this.this$0 = r1;
        this.$sessionState = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new MmRecordingStatesSyncService$syncRecordingStatus$1(this.this$0, this.$sessionState, r4);
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
        if (r1 == 0) goto L14;
        if (r1 == 1) goto L13;
        if (r1 == 2) goto L12;
        if (r1 == 3) goto L11;
        if (r1 != 4) goto L10;
        ResultKt.throwOnFailure(r7);
        Object r8 = ((Result) r7).unbox-impl();
    L34:
        Result.box-impl(r8);
    L42:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        ResultKt.throwOnFailure(r7);
        Object r9 = ((Result) r7).unbox-impl();
    L28:
        Result.box-impl(r9);
        goto L42
    L12:
        ResultKt.throwOnFailure(r7);
        Object r10 = ((Result) r7).unbox-impl();
    L22:
        Result.box-impl(r10);
        goto L42
    L13:
        ResultKt.throwOnFailure(r7);
    L17:
        String r11 = ((ovb.b) r7).a;
        com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c r2 = this.$sessionState;
        if (Intrinsics.areEqual(r2, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.k.c) == false) goto L24;
        MmRecordingStatesSyncService r3 = this.this$0;
        MmRecordingStatesSyncService.Companion r4 = MmRecordingStatesSyncService.q;
        r3.l().z(r11, this.$sessionState);
        MmRecordingStatesSyncService r12 = this.this$0;
        MmRecordingUpdateStatus r5 = MmRecordingUpdateStatus.RECORD_RESUME;
        this.label = 2;
        r10 = MmRecordingStatesSyncService.H(r12, r5, this);
        if (r10 != r0) goto L22;
        return r0;
    L24:
        if (Intrinsics.areEqual(r2, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.h.c) == false) goto L30;
        MmRecordingStatesSyncService r6 = this.this$0;
        MmRecordingStatesSyncService.Companion r13 = MmRecordingStatesSyncService.q;
        r6.l().z(r11, this.$sessionState);
        MmRecordingStatesSyncService r14 = this.this$0;
        MmRecordingUpdateStatus r15 = MmRecordingUpdateStatus.RECORD_PAUSE;
        this.label = 3;
        r9 = MmRecordingStatesSyncService.H(r14, r15, this);
        if (r9 != r0) goto L28;
        return r0;
    L30:
        if ((r2 instanceof com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.b) == false) goto L36;
        MmRecordingStatesSyncService r16 = this.this$0;
        MmRecordingStatesSyncService.Companion r17 = MmRecordingStatesSyncService.q;
        r16.l().z(r11, this.$sessionState);
        MmRecordingStatesSyncService r18 = this.this$0;
        this.label = 4;
        r8 = MmRecordingStatesSyncService.c(r18, "EndRecording", this);
        if (r8 != r0) goto L34;
        return r0;
    L36:
        if (Intrinsics.areEqual(r2, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.i.c) == false) goto L39;
        MmRecordingStatesSyncService r19 = this.this$0;
        MmRecordingStatesSyncService.Companion r20 = MmRecordingStatesSyncService.q;
        r19.l().z(r11, this.$sessionState);
        goto L42
    L39:
        if (Intrinsics.areEqual(r2, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.n.c) == false) goto L42;
        MmRecordingStatesSyncService r21 = this.this$0;
        MmRecordingStatesSyncService.Companion r22 = MmRecordingStatesSyncService.q;
        r21.l().z(r11, this.$sessionState);
        goto L42
    L14:
        ResultKt.throwOnFailure(r7);
        MmRecordingSession r23 = this.this$0.a;
        this.label = 1;
        r7 = r23.r(this);
        if (r7 != r0) goto L17;
        return r0;
    }
}
