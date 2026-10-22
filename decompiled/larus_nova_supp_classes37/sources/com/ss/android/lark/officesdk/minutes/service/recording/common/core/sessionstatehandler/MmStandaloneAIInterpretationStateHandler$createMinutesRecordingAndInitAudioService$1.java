package com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler;

import com.bytedance.lark.pb.basic.v1.Command;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.api.recording.doubao.DoubaoBizInfo;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSession;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.data.RecordingSessionType;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.data.TerminateReason;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync.MmRecordingStatesSyncService;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.MmStandaloneAIInterpretationRootRepo;
import com.ss.android.lark.pb.minutes.v1.MinutesRecordingStartRequest;
import com.ss.android.lark.pb.minutes.v1.MinutesRecordingStartResponse;
import com.ss.android.lark.picker.base.view.ItemViewType;
import iub.k;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler.MmStandaloneAIInterpretationStateHandler$createMinutesRecordingAndInitAudioService$1", f = "MmStandaloneAIInterpretationStateHandler.kt", i = {0, 0, 0, 1, 1, 1, 1, 3}, l = {270, 285, 315, 324}, m = "invokeSuspend", n = {"source", "doubaoBizInfo", "extraType", "doubaoBizInfo", "response", "meetingId", "recordingId", "errorCode"}, s = {"L$0", "L$1", "L$2", "L$0", "L$3", "L$4", "L$5", "L$2"})
final class MmStandaloneAIInterpretationStateHandler$createMinutesRecordingAndInitAudioService$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    final /* synthetic */ MmStandaloneAIInterpretationStateHandler this$0;

    public MmStandaloneAIInterpretationStateHandler$createMinutesRecordingAndInitAudioService$1(MmStandaloneAIInterpretationStateHandler r1, Continuation<? super MmStandaloneAIInterpretationStateHandler$createMinutesRecordingAndInitAudioService$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new MmStandaloneAIInterpretationStateHandler$createMinutesRecordingAndInitAudioService$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r19) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L15;
        if (r2 == 1) goto L14;
        if (r2 == 2) goto L12;
        if (r2 == 3) goto L11;
        if (r2 != 4) goto L10;
        ErrorResult r3 = (Integer) this.L$2;
        MmStandaloneAIInterpretationStateHandler r4 = (MmStandaloneAIInterpretationStateHandler) this.L$1;
        ResultKt.throwOnFailure(r19);
        String r5 = null;
    L107:
        if (r3 == null) goto L109;
        String r7 = r3.toString();
    L111:
        if (Intrinsics.areEqual(r7, "220205") == false) goto L113;
        TerminateReason r6 = TerminateReason.ALREADY_RECORDING;
    L114:
        r4.a.u(new com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.a.n(r6));
    L116:
        return Unit.INSTANCE;
    L113:
        r6 = TerminateReason.MEETING_CREATED_FAILED;
        goto L114
    L109:
        r7 = r5;
        goto L111
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        MmStandaloneAIInterpretationStateHandler r8 = (MmStandaloneAIInterpretationStateHandler) this.L$1;
        Object r9 = this.L$0;
        ResultKt.throwOnFailure(r19);
        Object r10 = r19;
        r5 = null;
    L89:
        if (((Boolean) r10).booleanValue() == false) goto L92;
        r8.a.u(com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.a.e.a);
    L92:
        Object r11 = r9;
    L94:
        r4 = this.this$0;
        Throwable r12 = Result.exceptionOrNull-impl(r11);
        if (r12 == null) goto L116;
        lvb.a.b(r4.b, "[createMinutesRecording] failed " + r12);
        if ((r12 instanceof ErrorResult) == false) goto L99;
        ErrorResult r13 = (ErrorResult) r12;
    L100:
        if (r13 == null) goto L102;
        ErrorResult r14 = Boxing.boxInt(r13.getCode());
    L103:
        MmRecordingSession.l(r4.a, r13);
        MmRecordingMeetingCreateFailureHandler r15 = (MmRecordingMeetingCreateFailureHandler) r4.h.getValue();
        RecordingSessionType r16 = r4.a.a;
        this.L$0 = r11;
        this.L$1 = r4;
        this.L$2 = r14;
        this.label = 4;
        if (r15.a(r12, r16, this) != r1) goto L106;
        return r1;
    L106:
        r3 = r14;
        goto L107
    L102:
        r14 = r5;
        goto L103
    L99:
        r13 = r5;
        goto L100
    L12:
        String r17 = (String) this.L$5;
        String r18 = (String) this.L$4;
        MinutesRecordingStartResponse r20 = (MinutesRecordingStartResponse) this.L$3;
        MmStandaloneAIInterpretationStateHandler r21 = (MmStandaloneAIInterpretationStateHandler) this.L$2;
        r11 = this.L$1;
        DoubaoBizInfo r110 = (DoubaoBizInfo) this.L$0;
        ResultKt.throwOnFailure(r19);
        String r111 = r17;
        r8 = r21;
    L13:
        r9 = r11;
        MmStandaloneAIInterpretationStateHandler.a r22 = MmStandaloneAIInterpretationStateHandler.l;
        r8.j(null);
        MmStandaloneAIInterpretationRootRepo r23 = r8.a.h();
        if (r23 == null) goto L77;
        Intrinsics.checkNotNull(r18);
        r23.c(r18);
    L77:
        MmRecordingStatesSyncService r24 = r8.e;
        Intrinsics.checkNotNull(r18);
        r24.B(r18, r8.a.c);
        MmRecordingStatesSyncService r25 = r8.e;
        Intrinsics.checkNotNull(r111);
        r25.B(r111, r8.a.c);
        r8.e.D(r18, r111);
        if (r110 == null) goto L80;
        r8.e.y(r18, r110);
    L80:
        k r26 = r8.a.f;
        if (r26 == null) goto L85;
        MmRecordingSource r27 = r26.a;
        if (r27 == null) goto L85;
        r8.e.A(r18, r27);
        r8.e.A(r111, r27);
    L85:
        this.L$0 = r9;
        this.L$1 = r8;
        r5 = null;
        this.L$2 = null;
        this.L$3 = null;
        this.L$4 = null;
        this.L$5 = null;
        this.label = 3;
        r10 = MmStandaloneAIInterpretationStateHandler.c(r8, r20, this);
        if (r10 != r1) goto L89;
        return r1;
    L14:
        MinutesRecordingStartRequest.ExtraType r28 = (MinutesRecordingStartRequest.ExtraType) this.L$2;
        DoubaoBizInfo r29 = (DoubaoBizInfo) this.L$1;
        MmRecordingSource r30 = (MmRecordingSource) this.L$0;
        ResultKt.throwOnFailure(r19);
        r11 = ((Result) r19).unbox-impl();
        r110 = r29;
    L53:
        MmStandaloneAIInterpretationStateHandler r31 = this.this$0;
        if (Result.isSuccess-impl(r11) == false) goto L93;
        MinutesRecordingStartResponse r112 = (MinutesRecordingStartResponse) r11;
        String r113 = r112.session_id;
        String r114 = r112.recording_id;
        if (StringsKt.isBlank(r114) == false) goto L62;
        if (r110 == null) goto L59;
        r114 = r110.getRecordingId();
    L60:
        if (r114 != null) goto L62;
        r114 = "";
        goto L62
    L59:
        r114 = null;
    L62:
        String r115 = r114;
        long r116 = System.currentTimeMillis();
        String r117 = r31.b;
        StringBuilder r118 = new StringBuilder("[createMinutesRecording] success,recordingId = ");
        r118.append(r115);
        r118.append(" meetingId=");
        r118.append(r113);
        r118.append(", source=");
        r118.append(r30);
        r118.append(", extraType=");
        r118.append(r28);
        r118.append(", spoken=");
        k r32 = r31.a.f;
        if (r32 == null) goto L65;
        String r33 = r32.d;
    L66:
        r118.append(r33);
        r118.append(", target=");
        k r34 = r31.a.f;
        if (r34 == null) goto L69;
        String r35 = r34.e;
    L70:
        r118.append(r35);
        lvb.a.e(r117, r118.toString());
        MmRecordingSession r36 = r31.a;
        MmStandaloneAIInterpretationStateHandler$createMinutesRecordingAndInitAudioService$1$1$1 r37 = new MmStandaloneAIInterpretationStateHandler$createMinutesRecordingAndInitAudioService$1$1$1(r113, r115, r31, r116, null);
        this.L$0 = r110;
        this.L$1 = r11;
        this.L$2 = r31;
        this.L$3 = r112;
        this.L$4 = r113;
        r111 = r115;
        this.L$5 = r111;
        this.label = 2;
        if (r36.s(r37, this) != r1) goto L73;
        return r1;
    L73:
        r18 = r113;
        r8 = r31;
        r20 = r112;
        goto L13
    L69:
        r35 = null;
        goto L70
    L65:
        r33 = null;
        goto L66
    L93:
        r5 = null;
        goto L94
    L15:
        ResultKt.throwOnFailure(r19);
        MmRecordingSession r38 = this.this$0.a;
        k r39 = r38.f;
        if (r39 == null) goto L18;
        r30 = r39.a;
    L19:
        DoubaoBizInfo r40 = r38.c();
        MinutesRecordingStartRequest.ExtraType r41 = com.ss.android.lark.officesdk.minutes.service.recording.common.core.c.a(r30);
        boolean r119 = false;
        if (r30 != null) goto L22;
    L24:
        boolean r120 = false;
    L25:
        if (r120 == false) goto L27;
        MinutesRecordingStartRequest.ContentType r121 = MinutesRecordingStartRequest.ContentType.INTERPRETATION;
    L28:
        MmRecordingSource r122 = MmRecordingSource.DOUBAO_STANDALONE_AI_INTERPRETATION;
        if (r30 != r122) goto L42;
        if (r40 == null) goto L32;
        String r123 = r40.getRecordingId();
    L33:
        if (r123 != null) goto L35;
    L38:
        boolean r124 = true;
    L39:
        if (r124 == false) goto L42;
        lvb.a.b(this.this$0.b, "[createMinutesRecording] missing Doubao RecordingIDV2");
        this.this$0.a.u(new com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.a.n(TerminateReason.MEETING_CREATED_FAILED));
        return Unit.INSTANCE;
    L35:
        if (StringsKt.isBlank(r123) == true) goto L38;
        r124 = false;
        goto L39
    L32:
        r123 = null;
    L42:
        MinutesRecordingStartRequest.Builder r125 = new MinutesRecordingStartRequest.Builder().extra_type(r41);
        if (r30 == r122) goto L45;
        r119 = true;
    L45:
        MinutesRecordingStartRequest.Builder r126 = r125.apply_recording_id(Boxing.boxBoolean(r119)).content_type(r121);
        MmStandaloneAIInterpretationStateHandler r127 = this.this$0;
        if (r30 != r122) goto L49;
        if (r40 == null) goto L49;
        MmStandaloneAIInterpretationStateHandler.a r128 = MmStandaloneAIInterpretationStateHandler.l;
        r127.getClass();
        r126.doubao_biz_info(new MinutesRecordingStartRequest.DoubaoBizInfo.Builder().user_id(r40.getUserId()).conversation_id(r40.getConversationId()).message_id(r40.getMessageId()).reply_message_id(r40.getReplyMessageId()).biz_id(r40.getBizId()).app_id(r40.getAppId()).tenant_id(r40.getTenantId()).device_id(r40.getDeviceId()).recording_id(r40.getRecordingId()).m1876build());
    L49:
        MinutesRecordingStartRequest r129 = r126.m1874build();
        MmStandaloneAIInterpretationStateHandler r130 = this.this$0;
        MmStandaloneAIInterpretationStateHandler.a r131 = MmStandaloneAIInterpretationStateHandler.l;
        com.ss.android.lark.officesdk.minutes.service.foundation.network.b r132 = (com.ss.android.lark.officesdk.minutes.service.foundation.network.b) r130.f.getValue();
        Command r133 = Command.MINUTES_RECORDING_START;
        Intrinsics.checkNotNull(r129);
        this.L$0 = r30;
        this.L$1 = r40;
        this.L$2 = r41;
        this.label = 1;
        Object r42 = r132.b(r133, MinutesRecordingStartResponse.class, r129, this);
        if (r42 != r1) goto L52;
        return r1;
    L52:
        r110 = r40;
        r28 = r41;
        r11 = r42;
        goto L53
    L27:
        r121 = MinutesRecordingStartRequest.ContentType.COMMONRECORDING;
        goto L28
    L22:
        if (r30.isStandaloneAIInterpretationSource() != true) goto L24;
        r120 = true;
        goto L25
    L18:
        r30 = null;
        goto L19
    }
}
