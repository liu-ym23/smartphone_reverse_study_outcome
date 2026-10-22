package com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler;

import com.bytedance.lark.pb.basic.v1.Command;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingError;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.api.recording.doubao.DoubaoBizInfo;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSession;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.data.TerminateReason;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync.MmRecordingStatesSyncService;
import com.ss.android.lark.pb.minutes.v1.MinutesRecordingStartRequest;
import com.ss.android.lark.pb.minutes.v1.MinutesRecordingStartResponse;
import com.ss.android.lark.picker.base.view.ItemViewType;
import iub.j;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler.MmPreMeetingNativeRecordingStateHandler$createMeetingAsync$1", f = "MmPreMeetingNativeRecordingStateHandler.kt", i = {1, 1}, l = {680, 702, 728}, m = "invokeSuspend", n = {"response", "meetingId"}, s = {"L$2", "L$3"})
public final class MmPreMeetingNativeRecordingStateHandler$createMeetingAsync$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ MmPreMeetingNativeRecordingStateHandler this$0;

    public MmPreMeetingNativeRecordingStateHandler$createMeetingAsync$1(MmPreMeetingNativeRecordingStateHandler r1, Continuation<? super MmPreMeetingNativeRecordingStateHandler$createMeetingAsync$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new MmPreMeetingNativeRecordingStateHandler$createMeetingAsync$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r20) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        boolean r7 = true;
        Integer r8 = null;
        if (r2 == 0) goto L12;
        if (r2 == 1) goto L11;
        if (r2 == 2) goto L10;
        if (r2 != 3) goto L9;
        MmPreMeetingNativeRecordingStateHandler r3 = (MmPreMeetingNativeRecordingStateHandler) this.L$1;
        Object r4 = this.L$0;
        ResultKt.throwOnFailure(r20);
        Object r9 = r4;
        Object r5 = r20;
    L120:
        boolean r6 = ((Boolean) r5).booleanValue();
        BuildersKt.launch$default(r3.a.v, null, null, new MmPreMeetingNativeRecordingStateHandler$onMeetingBound$1(r3, null), 3, null);
        if (r6 == false) goto L126;
        iub.a<j, ? super MmRecordingError> r10 = r3.m;
        if (r10 == null) goto L125;
        r10.onSuccess(new j(r3.a.e()));
    L125:
        r3.m = null;
    L127:
        Object r11 = r9;
    L128:
        MmPreMeetingNativeRecordingStateHandler r12 = this.this$0;
        ErrorResult r13 = Result.exceptionOrNull-impl(r11);
        if (r13 == null) goto L164;
        lvb.a.b(r12.c, "[createMeetingAsync] failed " + r13);
        if ((r13 instanceof ErrorResult) == false) goto L133;
        ErrorResult r14 = r13;
    L134:
        if (r14 == null) goto L137;
        r8 = Boxing.boxInt(r14.getCode());
    L137:
        if (r8 != null) goto L140;
    L142:
        if (r8 != null) goto L145;
    L147:
        if (r8 != null) goto L150;
    L152:
        boolean r15 = r12.u;
        if (r15 == false) goto L155;
    L163:
        MmPreMeetingNativeRecordingStateHandler.c(r12, MmRecordingError.CreateRecordingRequestFailed.INSTANCE);
        goto L164
    L155:
        if (r12.b == false) goto L159;
        if (r15 == true) goto L159;
        r12.u = true;
        r12.n();
        lvb.a.h(r12.c, "[offlineMode] switch_to_offline reason=create_meeting_failed, error=" + r13);
    L160:
        if (r7 == true) goto L163;
        MmPreMeetingNativeRecordingStateHandler.c(r12, MmRecordingError.CreateRecordingRequestFailed.INSTANCE);
        r12.a.u(new com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.a.d(TerminateReason.MEETING_CREATED_FAILED));
    L159:
        r7 = false;
        goto L160
    L150:
        if (r8.intValue() != 220207) goto L152;
        lvb.a.b(r12.c, "[createMinutesRecording] failed, errorCode: " + r8);
        MmRecordingSession r16 = r12.a;
        MmRecordingError.TooManyUnfinishedRecording r17 = MmRecordingError.TooManyUnfinishedRecording.INSTANCE;
        r16.m(r17);
        MmPreMeetingNativeRecordingStateHandler.c(r12, r17);
        goto L164
    L145:
        if (r8.intValue() != 220202) goto L147;
        lvb.a.b(r12.c, "[createMinutesRecording] failed, errorCode: " + r8);
        MmRecordingSession r18 = r12.a;
        MmRecordingError.NoQuota r19 = MmRecordingError.NoQuota.INSTANCE;
        r18.m(r19);
        MmPreMeetingNativeRecordingStateHandler.c(r12, r19);
        goto L164
    L140:
        if (r8.intValue() != 220206) goto L142;
        lvb.a.b(r12.c, "[createMinutesRecording] failed, errorCode: " + r8);
        MmRecordingSession r21 = r12.a;
        MmRecordingError.BusyTooManyUsers r22 = MmRecordingError.BusyTooManyUsers.INSTANCE;
        r21.m(r22);
        MmPreMeetingNativeRecordingStateHandler.c(r12, r22);
        goto L164
    L133:
        r14 = null;
    L164:
        this.this$0.l = false;
        return Unit.INSTANCE;
    L126:
        MmPreMeetingNativeRecordingStateHandler.c(r3, MmRecordingError.CreateRecordingRequestFailed.INSTANCE);
        goto L127
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        String r23 = (String) this.L$3;
        MinutesRecordingStartResponse r24 = (MinutesRecordingStartResponse) this.L$2;
        MmPreMeetingNativeRecordingStateHandler r25 = (MmPreMeetingNativeRecordingStateHandler) this.L$1;
        r9 = this.L$0;
        ResultKt.throwOnFailure(r20);
    L113:
        DoubaoBizInfo r110 = r25.s;
        if (r110 == null) goto L116;
        MmRecordingStatesSyncService r111 = r25.g;
        Intrinsics.checkNotNull(r23);
        r111.y(r23, r110);
    L116:
        r25.t = r24;
        this.L$0 = r9;
        this.L$1 = r25;
        this.L$2 = null;
        this.L$3 = null;
        this.label = 3;
        r5 = MmPreMeetingNativeRecordingStateHandler.g(r25, r24, this);
        if (r5 != r1) goto L119;
        return r1;
    L119:
        r3 = r25;
        goto L120
    L11:
        ResultKt.throwOnFailure(r20);
        r11 = ((Result) r20).unbox-impl();
    L87:
        MmPreMeetingNativeRecordingStateHandler r26 = this.this$0;
        if (Result.isSuccess-impl(r11) == false) goto L128;
        MinutesRecordingStartResponse r112 = (MinutesRecordingStartResponse) r11;
        lvb.a.e(r26.c, "[createMeetingAsync] success " + r112);
        if (r26.u == false) goto L92;
        r26.u = false;
        r26.l();
        r26.r = true;
        lvb.a.e(r26.c, "[offlineMode] switch_to_online reason=create_meeting_success");
    L92:
        String r113 = r112.session_id;
        Long r114 = Boxing.boxLong(r26.a.w.b);
        if (r114.longValue() <= 0) goto L95;
        boolean r115 = true;
    L96:
        if (r115 == true) goto L99;
        r114 = null;
    L99:
        if (r114 == null) goto L101;
        long r116 = r114.longValue();
    L102:
        long r117 = r116;
        MmRecordingStatesSyncService r118 = r26.g;
        Intrinsics.checkNotNull(r113);
        r118.B(r113, r26.a.c);
        DoubaoBizInfo r119 = r26.s;
        if (r119 == null) goto L105;
        String r120 = r119.getRecordingId();
    L106:
        if (r120 != null) goto L108;
        String r121 = "";
    L109:
        MmRecordingSession r27 = r26.a;
        MmPreMeetingNativeRecordingStateHandler$createMeetingAsync$1$1$1 r122 = new MmPreMeetingNativeRecordingStateHandler$createMeetingAsync$1$1$1(r113, r121, r117, null);
        this.L$0 = r11;
        this.L$1 = r26;
        this.L$2 = r112;
        this.L$3 = r113;
        this.label = 2;
        if (r27.s(r122, this) != r1) goto L112;
        return r1;
    L112:
        r25 = r26;
        r24 = r112;
        r9 = r11;
        r23 = r113;
        goto L113
    L108:
        r121 = r120;
        goto L109
    L105:
        r120 = null;
        goto L106
    L101:
        r116 = System.currentTimeMillis();
        goto L102
    L95:
        r115 = false;
        goto L96
    L12:
        ResultKt.throwOnFailure(r20);
        MmPreMeetingNativeRecordingStateHandler r28 = this.this$0;
        r28.getClass();
        MinutesRecordingStartRequest.DoubaoBizInfo.Builder r29 = new MinutesRecordingStartRequest.DoubaoBizInfo.Builder();
        DoubaoBizInfo r123 = r28.s;
        if (r123 == null) goto L16;
        String r124 = r123.getUserId();
        if (r124 == null) goto L16;
    L17:
        MinutesRecordingStartRequest.DoubaoBizInfo.Builder r30 = r29.user_id(r124);
        DoubaoBizInfo r125 = r28.s;
        if (r125 == null) goto L21;
        String r126 = r125.getConversationId();
        if (r126 == null) goto L21;
    L22:
        MinutesRecordingStartRequest.DoubaoBizInfo.Builder r31 = r30.conversation_id(r126);
        DoubaoBizInfo r127 = r28.s;
        if (r127 == null) goto L26;
        String r128 = r127.getMessageId();
        if (r128 == null) goto L26;
    L27:
        MinutesRecordingStartRequest.DoubaoBizInfo.Builder r32 = r31.message_id(r128);
        DoubaoBizInfo r129 = r28.s;
        if (r129 == null) goto L31;
        String r130 = r129.getReplyMessageId();
        if (r130 == null) goto L31;
    L32:
        MinutesRecordingStartRequest.DoubaoBizInfo.Builder r33 = r32.reply_message_id(r130);
        DoubaoBizInfo r131 = r28.s;
        if (r131 == null) goto L36;
        String r132 = r131.getBizId();
        if (r132 == null) goto L36;
    L37:
        MinutesRecordingStartRequest.DoubaoBizInfo.Builder r34 = r33.biz_id(r132);
        DoubaoBizInfo r133 = r28.s;
        if (r133 == null) goto L41;
        String r134 = r133.getAppId();
        if (r134 == null) goto L41;
    L42:
        MinutesRecordingStartRequest.DoubaoBizInfo.Builder r35 = r34.app_id(r134);
        DoubaoBizInfo r135 = r28.s;
        if (r135 == null) goto L46;
        String r136 = r135.getTenantId();
        if (r136 == null) goto L46;
    L47:
        MinutesRecordingStartRequest.DoubaoBizInfo.Builder r36 = r35.tenant_id(r136);
        DoubaoBizInfo r37 = r28.s;
        if (r37 == null) goto L51;
        String r38 = r37.getDeviceId();
        if (r38 == null) goto L51;
    L52:
        MinutesRecordingStartRequest.DoubaoBizInfo r39 = r36.device_id(r38).m1876build();
        MmPreMeetingNativeRecordingStateHandler r40 = this.this$0;
        k r137 = r40.a.f;
        if (r137 == null) goto L55;
        MmRecordingSource r138 = r137.a;
    L57:
        if (r138 != MmRecordingSource.FEISHU_HARDWARE_D1204) goto L75;
        Object r139 = r137.b.get("hardware_local_recording_id");
        if (r139 == null) goto L69;
        String r140 = r139.toString();
        if (r140 == null) goto L69;
        if ((!StringsKt.isBlank(r140)) == true) goto L67;
        r140 = null;
    L67:
        if (r140 == null) goto L69;
    L76:
        lvb.a.e(r40.c, "[buildHardwareInfoForPb] hardwareUniqueKey=" + r140 + ", hardwareSubtype=LIBERTY");
        MinutesRecordingStartRequest.HardwareInfo r41 = new MinutesRecordingStartRequest.HardwareInfo.Builder().hardware_unique_key(r140).hardware_subtype(MinutesRecordingStartRequest.HardwareInfo.HardwareSubType.LIBERTY).m1879build();
    L77:
        k r141 = this.this$0.a.f;
        if (r141 == null) goto L80;
        MmRecordingSource r142 = r141.a;
    L81:
        MinutesRecordingStartRequest.ExtraType r143 = com.ss.android.lark.officesdk.minutes.service.recording.common.core.c.a(r142);
        MinutesRecordingStartRequest.Builder r144 = new MinutesRecordingStartRequest.Builder();
        r144.doubao_biz_info(r39);
        r144.extra_type(r143);
        if (r41 == null) goto L84;
        r144.hardware_info(r41);
    L84:
        MinutesRecordingStartRequest r145 = r144.m1874build();
        String r146 = this.this$0.c;
        StringBuilder r147 = new StringBuilder("[createMeetingAsync] request, command=");
        Command r148 = Command.MINUTES_RECORDING_START;
        r147.append(r148);
        r147.append(", respType=MinutesRecordingStartResponse, doubaoBizInfo=");
        r147.append(r39);
        r147.append(", extraType=");
        r147.append(r143);
        r147.append(", hardwareInfo=");
        r147.append(r41);
        r147.append(", request=");
        r147.append(r145);
        lvb.a.a(r146, r147.toString());
        com.ss.android.lark.officesdk.minutes.service.foundation.network.b r42 = (com.ss.android.lark.officesdk.minutes.service.foundation.network.b) this.this$0.h.getValue();
        Intrinsics.checkNotNull(r145);
        this.label = 1;
        r11 = r42.b(r148, MinutesRecordingStartResponse.class, r145, this);
        if (r11 != r1) goto L87;
        return r1;
    L80:
        r142 = null;
    L69:
        r140 = r40.a.w.g;
        if ((!StringsKt.isBlank(r140)) == true) goto L73;
        r140 = null;
    L73:
        if (r140 != null) goto L76;
        lvb.a.h(r40.c, "[buildHardwareInfoForPb] skip, hardwareUniqueKey is empty");
    L75:
        r41 = null;
        goto L77
    L55:
        r138 = null;
    L51:
        r38 = "";
    L46:
        r136 = "";
    L41:
        r134 = "";
    L36:
        r132 = "";
    L31:
        r130 = "";
    L26:
        r128 = "";
    L21:
        r126 = "";
    L16:
        r124 = "";
        goto L17
    }
}
