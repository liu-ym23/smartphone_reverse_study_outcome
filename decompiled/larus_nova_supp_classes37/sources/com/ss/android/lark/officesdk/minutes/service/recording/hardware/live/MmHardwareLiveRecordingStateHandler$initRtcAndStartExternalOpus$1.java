package com.ss.android.lark.officesdk.minutes.service.recording.hardware.live;

import com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSession;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.MmRecordingAudioService;
import com.ss.android.lark.pb.minutes.v1.MinutesRecordingStartResponse;
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
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.hardware.live.MmHardwareLiveRecordingStateHandler$initRtcAndStartExternalOpus$1", f = "MmHardwareLiveRecordingStateHandler.kt", i = {0, 0, 1, 1}, l = {204, 206}, m = "invokeSuspend", n = {"response", "currentAudioService", "meetingId", "externalAudioInput"}, s = {"L$0", "L$1", "L$0", "L$1"})
final class MmHardwareLiveRecordingStateHandler$initRtcAndStartExternalOpus$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ MmHardwareLiveRecordingStateHandler this$0;

    public MmHardwareLiveRecordingStateHandler$initRtcAndStartExternalOpus$1(MmHardwareLiveRecordingStateHandler r1, Continuation<? super MmHardwareLiveRecordingStateHandler$initRtcAndStartExternalOpus$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new MmHardwareLiveRecordingStateHandler$initRtcAndStartExternalOpus$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r3 = true;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        nub.a r2 = (nub.a) this.L$1;
        String r4 = (String) this.L$0;
        ResultKt.throwOnFailure(r8);
        Object r9 = ((Result) r8).unbox-impl();
    L25:
        MmHardwareLiveRecordingStateHandler r5 = this.this$0;
        Throwable r6 = Result.exceptionOrNull-impl(r9);
        if (r6 == null) goto L28;
        lvb.a.b(r5.d, "[initRtcAndStartExternalOpus] updateRtcConfig failed " + r6);
        r5.d();
        return Unit.INSTANCE;
    L28:
        if (((Boolean) r9).booleanValue() == true) goto L31;
        lvb.a.b(this.this$0.d, "[initRtcAndStartExternalOpus] updateRtcConfig returned false");
        this.this$0.d();
        return Unit.INSTANCE;
    L31:
        String r10 = this.this$0.d;
        StringBuilder r7 = new StringBuilder("[initRtcAndStartExternalOpus] success, meetingId=");
        r7.append(r4);
        r7.append(", externalAudioInput=");
        if (r2 != null) goto L35;
        r3 = false;
    L35:
        r7.append(r3);
        lvb.a.e(r10, r7.toString());
        this.this$0.b.u(com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.a.j.a);
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        MmRecordingAudioService r11 = (MmRecordingAudioService) this.L$1;
        MinutesRecordingStartResponse r12 = (MinutesRecordingStartResponse) this.L$0;
        ResultKt.throwOnFailure(r8);
    L21:
        String r13 = ((ovb.b) r8).a;
        nub.a r14 = this.this$0.e.t(r13);
        this.L$0 = r13;
        this.L$1 = r14;
        this.label = 2;
        Object r15 = r11.r(r12, this);
        if (r15 != r0) goto L24;
        return r0;
    L24:
        r2 = r14;
        r4 = r13;
        r9 = r15;
        goto L25
    L10:
        ResultKt.throwOnFailure(r8);
        r12 = this.this$0.j;
        if (r12 != null) goto L14;
        lvb.a.b(this.this$0.d, "[initRtcAndStartExternalOpus] response is null");
        this.this$0.d();
        return Unit.INSTANCE;
    L14:
        MmHardwareLiveRecordingStateHandler r16 = this.this$0;
        r11 = r16.g;
        if (r11 != null) goto L18;
        lvb.a.b(r16.d, "[initRtcAndStartExternalOpus] audioService is null");
        this.this$0.d();
        return Unit.INSTANCE;
    L18:
        MmRecordingSession r17 = r16.b;
        this.L$0 = r12;
        this.L$1 = r11;
        this.label = 1;
        r8 = r17.r(this);
        if (r8 != r0) goto L21;
        return r0;
    }
}
