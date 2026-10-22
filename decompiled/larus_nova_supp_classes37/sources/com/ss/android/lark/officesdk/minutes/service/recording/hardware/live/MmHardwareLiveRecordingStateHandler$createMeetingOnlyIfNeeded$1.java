package com.ss.android.lark.officesdk.minutes.service.recording.hardware.live;

import com.bytedance.lark.pb.basic.v1.Command;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSession;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.c;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.data.RecordingSessionType;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler.MmRecordingMeetingCreateFailureHandler;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.MmRecordingRepo;
import com.ss.android.lark.pb.minutes.v1.MinutesRecordingStartRequest;
import com.ss.android.lark.pb.minutes.v1.MinutesRecordingStartResponse;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.profile.v2.entity.BaseField;
import iub.k;
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
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.hardware.live.MmHardwareLiveRecordingStateHandler$createMeetingOnlyIfNeeded$1", f = "MmHardwareLiveRecordingStateHandler.kt", i = {0, 1, 1, 1, 2}, l = {BaseField.FIELD_TYPE_ALIAS_AND_MEMO, 116, 151}, m = "invokeSuspend", n = {"source", "response", "meetingId", "meetingStartTime", "errorResult"}, s = {"L$0", "L$2", "L$3", "J$0", "L$2"})
final class MmHardwareLiveRecordingStateHandler$createMeetingOnlyIfNeeded$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ MmHardwareLiveRecordingStateHandler this$0;

    public MmHardwareLiveRecordingStateHandler$createMeetingOnlyIfNeeded$1(MmHardwareLiveRecordingStateHandler r1, Continuation<? super MmHardwareLiveRecordingStateHandler$createMeetingOnlyIfNeeded$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new MmHardwareLiveRecordingStateHandler$createMeetingOnlyIfNeeded$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r22) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L12;
        if (r2 == 1) goto L11;
        if (r2 == 2) goto L10;
        if (r2 != 3) goto L9;
        ErrorResult r3 = (ErrorResult) this.L$2;
        MmHardwareLiveRecordingStateHandler r4 = (MmHardwareLiveRecordingStateHandler) this.L$1;
        ResultKt.throwOnFailure(r22);
    L50:
        r4.c(r3);
        com.ss.android.lark.officesdk.minutes.service.recording.common.perf.appreciable.a.d.a();
    L52:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        long r5 = this.J$0;
        String r6 = (String) this.L$3;
        MinutesRecordingStartResponse r7 = (MinutesRecordingStartResponse) this.L$2;
        final MmHardwareLiveRecordingStateHandler r8 = (MmHardwareLiveRecordingStateHandler) this.L$1;
        Object r9 = this.L$0;
        ResultKt.throwOnFailure(r22);
    L36:
        MmRecordingRepo r10 = r8.b.f();
        if (r10 == null) goto L39;
        Intrinsics.checkNotNull(r6);
        r10.A(r6, r5, "hardware_live_meeting_created");
    L39:
        r8.j = r7;
        com.ss.android.lark.officesdk.minutes.service.recording.common.perf.appreciable.a.d.b(new MmHardwareLiveRecordingStateHandler$createMeetingOnlyIfNeeded$1$1$2(r8));
        r8.b.u(com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.a.e.a);
        Object r11 = r9;
    L40:
        MmHardwareLiveRecordingStateHandler r12 = this.this$0;
        Throwable r13 = Result.exceptionOrNull-impl(r11);
        if (r13 == null) goto L52;
        lvb.a.b(r12.d, "[createMeetingOnly] failed " + r13);
        if ((r13 instanceof ErrorResult) == false) goto L45;
        ErrorResult r14 = (ErrorResult) r13;
    L46:
        MmRecordingSession.l(r12.b, r14);
        MmRecordingMeetingCreateFailureHandler r15 = (MmRecordingMeetingCreateFailureHandler) r12.h.getValue();
        RecordingSessionType r16 = r12.b.a;
        this.L$0 = r11;
        this.L$1 = r12;
        this.L$2 = r14;
        this.L$3 = null;
        this.label = 3;
        if (r15.a(r13, r16, this) != r1) goto L49;
        return r1;
    L49:
        r4 = r12;
        r3 = r14;
        goto L50
    L45:
        r14 = null;
        goto L46
    L11:
        MmRecordingSource r17 = (MmRecordingSource) this.L$0;
        ResultKt.throwOnFailure(r22);
        MmRecordingSource r18 = r17;
        r11 = ((Result) r22).unbox-impl();
    L27:
        MmHardwareLiveRecordingStateHandler r19 = this.this$0;
        if (Result.isSuccess-impl(r11) == false) goto L40;
        r7 = (MinutesRecordingStartResponse) r11;
        String r110 = r7.session_id;
        Intrinsics.checkNotNull(r110);
        if (StringsKt.isBlank(r110) == false) goto L32;
        lvb.a.b(r19.d, "[createMeetingOnly] failed, meetingId is blank");
        r19.c(null);
        goto L40
    L32:
        long r111 = System.currentTimeMillis();
        MmRecordingSession r112 = r19.b;
        MmHardwareLiveRecordingStateHandler$createMeetingOnlyIfNeeded$1$1$1 r113 = new MmHardwareLiveRecordingStateHandler$createMeetingOnlyIfNeeded$1$1$1(r110, r19, r18, r111, null);
        this.L$0 = r11;
        this.L$1 = r19;
        this.L$2 = r7;
        this.L$3 = r110;
        this.J$0 = r111;
        this.label = 2;
        if (r112.s(r113, this) != r1) goto L35;
        return r1;
    L35:
        r9 = r11;
        r8 = r19;
        r5 = r111;
        r6 = r110;
        goto L36
    L12:
        ResultKt.throwOnFailure(r22);
        MmRecordingSession r20 = this.this$0.b;
        k r21 = r20.f;
        if (r21 == null) goto L15;
        MmRecordingSource r23 = r21.a;
    L16:
        com.ss.android.lark.officesdk.minutes.service.recording.common.perf.appreciable.a.d.c(r20.c, r23, null);
        com.ss.android.lark.officesdk.minutes.service.foundation.network.b r24 = (com.ss.android.lark.officesdk.minutes.service.foundation.network.b) this.this$0.f.getValue();
        Command r25 = Command.MINUTES_RECORDING_START;
        MmHardwareLiveRecordingStateHandler r114 = this.this$0;
        r114.getClass();
        if (r23 == MmRecordingSource.FEISHU_HARDWARE_D1204_CASE) goto L19;
        MinutesRecordingStartRequest.HardwareInfo r115 = null;
    L20:
        MinutesRecordingStartRequest.Builder r116 = new MinutesRecordingStartRequest.Builder();
        r116.extra_type(c.a(r23));
        if (r115 == null) goto L23;
        r116.hardware_info(r115);
    L23:
        MinutesRecordingStartRequest r117 = r116.m1874build();
        this.L$0 = r23;
        this.label = 1;
        r11 = r24.b(r25, MinutesRecordingStartResponse.class, r117, this);
        if (r11 != r1) goto L26;
        return r1;
    L26:
        r18 = r23;
        goto L27
    L19:
        lvb.a.e(r114.d, "[buildHardwareInfoForPb] hardwareUniqueKey=" + r114.c + ", hardwareSubtype=LIBERTY");
        r115 = new MinutesRecordingStartRequest.HardwareInfo.Builder().hardware_unique_key(r114.c).hardware_subtype(MinutesRecordingStartRequest.HardwareInfo.HardwareSubType.LIBERTY).m1879build();
        goto L20
    L15:
        r23 = null;
        goto L16
    }
}
