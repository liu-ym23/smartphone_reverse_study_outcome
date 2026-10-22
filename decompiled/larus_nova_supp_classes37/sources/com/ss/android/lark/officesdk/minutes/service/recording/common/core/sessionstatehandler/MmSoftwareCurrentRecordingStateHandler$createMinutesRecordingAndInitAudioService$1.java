package com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler;

import com.bytedance.lark.pb.basic.v1.Command;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.api.recording.doubao.DoubaoBizInfo;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSession;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.data.MmRecordingRoute;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.data.RecordingSessionType;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.data.TerminateReason;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync.MmRecordingStatesSyncService;
import com.ss.android.lark.officesdk.minutes.service.recording.common.perf.appreciable.MmRecordingSubtitleAppreciable;
import com.ss.android.lark.pb.minutes.v1.MinutesRecordingStartRequest;
import com.ss.android.lark.pb.minutes.v1.MinutesRecordingStartResponse;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.profile.v2.entity.UserInfo;
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
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler.MmSoftwareCurrentRecordingStateHandler$createMinutesRecordingAndInitAudioService$1", f = "MmSoftwareCurrentRecordingStateHandler.kt", i = {0, 1, 1, 1, 1, 2}, l = {302, 326, 366}, m = "invokeSuspend", n = {"requestRecordingId", "response", "meetingId", "finalRoute", "recordingId", "errorCode"}, s = {"Z$0", "L$2", "L$3", "L$4", "L$5", "L$2"})
final class MmSoftwareCurrentRecordingStateHandler$createMinutesRecordingAndInitAudioService$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    boolean Z$0;
    int label;
    final /* synthetic */ MmSoftwareCurrentRecordingStateHandler this$0;

    public MmSoftwareCurrentRecordingStateHandler$createMinutesRecordingAndInitAudioService$1(MmSoftwareCurrentRecordingStateHandler r1, Continuation<? super MmSoftwareCurrentRecordingStateHandler$createMinutesRecordingAndInitAudioService$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new MmSoftwareCurrentRecordingStateHandler$createMinutesRecordingAndInitAudioService$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r23) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        String r7 = "";
        if (r2 == 0) goto L13;
        if (r2 == 1) goto L11;
        if (r2 == 2) goto L10;
        if (r2 != 3) goto L9;
        Integer r3 = (Integer) this.L$2;
        MmSoftwareCurrentRecordingStateHandler r4 = (MmSoftwareCurrentRecordingStateHandler) this.L$1;
        ResultKt.throwOnFailure(r23);
        String r8 = null;
    L172:
        if (r3 == null) goto L174;
        String r10 = r3.toString();
    L176:
        if (Intrinsics.areEqual(r10, "220205") == false) goto L178;
        r4.a.u(new com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.a.n(TerminateReason.ALREADY_RECORDING));
    L179:
        com.ss.android.lark.officesdk.minutes.service.recording.common.perf.appreciable.a.d.a();
    L181:
        return Unit.INSTANCE;
    L178:
        r4.a.u(new com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.a.n(TerminateReason.MEETING_CREATED_FAILED));
        goto L179
    L174:
        r10 = r8;
        goto L176
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        String r5 = (String) this.L$5;
        MmRecordingRoute r9 = (MmRecordingRoute) this.L$4;
        String r11 = (String) this.L$3;
        MinutesRecordingStartResponse r12 = (MinutesRecordingStartResponse) this.L$2;
        final MmSoftwareCurrentRecordingStateHandler r13 = (MmSoftwareCurrentRecordingStateHandler) this.L$1;
        Object r14 = this.L$0;
        ResultKt.throwOnFailure(r23);
    L131:
        MmRecordingStatesSyncService r6 = r13.f;
        Intrinsics.checkNotNull(r11);
        r6.getClass();
        Intrinsics.checkNotNullParameter(r11, "meetingId");
        Intrinsics.checkNotNullParameter(r9, "route");
        if (r11.length() != 0) goto L134;
        boolean r15 = true;
    L135:
        if (r15 == true) goto L141;
        com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync.e r16 = r6.l();
        r16.getClass();
        Intrinsics.checkNotNullParameter(r11, "meetingId");
        Intrinsics.checkNotNullParameter(r9, "route");
        if (StringsKt.isBlank(r11) == true) goto L141;
        lvb.a.e(r16.b, "[recordingRoute] save, meetingId:" + r11 + ", route:" + r9);
        r16.a.H().putString("minutes_recording_v2_route_prefix".concat(r11), r9.getStorageValue());
    L141:
        MmRecordingStatesSyncService r17 = r13.f;
        r17.getClass();
        Intrinsics.checkNotNullParameter(r11, "meetingId");
        Intrinsics.checkNotNullParameter(r5, "recordingId");
        if (r11.length() != 0) goto L144;
        boolean r21 = true;
    L145:
        if (r21 == true) goto L155;
        com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync.e r18 = r17.l();
        r18.getClass();
        Intrinsics.checkNotNullParameter(r11, "meetingId");
        Intrinsics.checkNotNullParameter(r5, "recordingId");
        if (StringsKt.isBlank(r11) == true) goto L155;
        if (StringsKt.isBlank(r5) == true) goto L155;
        if (Intrinsics.areEqual(r5, UserInfo.NONE_NAME_CARD_ID) == true) goto L155;
        lvb.a.e(r18.b, "[recordingId] save, meetingId:" + r11 + ", recordingId:" + r5);
        r18.a.H().putString("minutes_recording_v2_recording_id_prefix".concat(r11), r5);
    L155:
        r13.f.B(r11, r13.a.c);
        com.ss.android.lark.officesdk.minutes.service.recording.common.perf.appreciable.a.d.b(new MmSoftwareCurrentRecordingStateHandler$createMinutesRecordingAndInitAudioService$1$2$2(r13));
        DoubaoBizInfo r19 = r13.l;
        if (r19 == null) goto L158;
        r13.f.y(r11, r19);
    L158:
        r13.j = r12;
        r13.a.u(com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.a.e.a);
    L159:
        r4 = this.this$0;
        Throwable r20 = Result.exceptionOrNull-impl(r14);
        if (r20 == null) goto L181;
        lvb.a.b(r4.b, "[createMinutesRecording] failed " + r20);
        if ((r20 instanceof ErrorResult) == false) goto L164;
        ErrorResult r22 = (ErrorResult) r20;
    L165:
        if (r22 == null) goto L167;
        Integer r24 = Boxing.boxInt(r22.getCode());
    L168:
        MmRecordingSession.l(r4.a, r22);
        MmRecordingMeetingCreateFailureHandler r25 = (MmRecordingMeetingCreateFailureHandler) r4.h.getValue();
        RecordingSessionType r26 = r4.a.a;
        this.L$0 = r14;
        this.L$1 = r4;
        this.L$2 = r24;
        r8 = null;
        this.L$3 = null;
        this.L$4 = null;
        this.L$5 = null;
        this.label = 3;
        if (r25.a(r20, r26, this) != r1) goto L171;
        return r1;
    L171:
        r3 = r24;
        goto L172
    L167:
        r24 = null;
        goto L168
    L164:
        r22 = null;
        goto L165
    L144:
        r21 = false;
        goto L145
    L134:
        r15 = false;
        goto L135
    L11:
        boolean r27 = this.Z$0;
        ResultKt.throwOnFailure(r23);
        Object r110 = ((Result) r23).unbox-impl();
    L12:
        r14 = r110;
        r13 = this.this$0;
        if (Result.isSuccess-impl(r14) == false) goto L159;
        r12 = (MinutesRecordingStartResponse) r14;
        lvb.a.e(r13.b, "[createMinutesRecording] success " + r12);
        String r28 = r12.session_id;
        MmRecordingSession r111 = r13.a;
        String r112 = r12.recording_id;
        MmRecordingRoute r29 = r111.x;
        k r30 = r111.f;
        if (r30 == null) goto L87;
        MmRecordingSource r31 = r30.a;
    L88:
        r111.x = r29.resolvedAfterJoin(r31, r112);
        String r32 = r111.h;
        StringBuilder r113 = new StringBuilder("[recordingRoute] source=");
        k r114 = r111.f;
        if (r114 == null) goto L91;
        MmRecordingSource r115 = r114.a;
    L92:
        r113.append(r115);
        r113.append(", initial=");
        r113.append(r29);
        r113.append(", final=");
        r113.append(r111.x);
        r113.append(", fallback=");
        if (r29 == r111.x) goto L95;
        boolean r33 = true;
    L96:
        r113.append(r33);
        lvb.a.e(r32, r113.toString());
        MmRecordingRoute r34 = r111.x;
        String r35 = r12.recording_id;
        if (r27 == false) goto L112;
        MmRecordingRoute.Companion.getClass();
        if (r35 != null) goto L101;
    L104:
        boolean r36 = true;
    L105:
        if (r36 == false) goto L107;
    L109:
        boolean r37 = false;
    L110:
        if (r37 == false) goto L112;
        boolean r38 = true;
    L113:
        if (r38 == true) goto L117;
        r35 = null;
    L117:
        if (r34.getUsesRecordingApi() == false) goto L127;
        if (r35 != null) goto L126;
        DoubaoBizInfo r39 = r13.l;
        if (r39 == null) goto L122;
        String r40 = r39.getRecordingId();
    L123:
        if (r40 == null) goto L127;
        r7 = r40;
        goto L127
    L122:
        r40 = null;
        goto L123
    L126:
        r7 = r35;
    L127:
        long r116 = System.currentTimeMillis();
        MmRecordingSession r41 = r13.a;
        MmSoftwareCurrentRecordingStateHandler$createMinutesRecordingAndInitAudioService$1$2$1 r42 = new MmSoftwareCurrentRecordingStateHandler$createMinutesRecordingAndInitAudioService$1$2$1(r28, r7, r13, r116, null);
        this.L$0 = r14;
        this.L$1 = r13;
        this.L$2 = r12;
        this.L$3 = r28;
        this.L$4 = r34;
        this.L$5 = r7;
        this.label = 2;
        if (r41.s(r42, this) != r1) goto L130;
        return r1;
    L130:
        r11 = r28;
        r5 = r7;
        r9 = r34;
        goto L131
    L107:
        if (Intrinsics.areEqual(r35, UserInfo.NONE_NAME_CARD_ID) == true) goto L109;
        r37 = true;
        goto L110
    L101:
        if (StringsKt.isBlank(r35) == true) goto L104;
        r36 = false;
    L112:
        r38 = false;
        goto L113
    L95:
        r33 = false;
        goto L96
    L91:
        r115 = null;
        goto L92
    L87:
        r31 = null;
        goto L88
    L13:
        ResultKt.throwOnFailure(r23);
        MmRecordingSession r43 = this.this$0.a;
        k r117 = r43.f;
        if (r117 == null) goto L16;
        MmRecordingSource r118 = r117.a;
    L17:
        MmRecordingRoute r44 = r43.x;
        Intrinsics.checkNotNullParameter(r44, "route");
        if (r44.getUsesRecordingApi() == true) goto L20;
    L22:
        r27 = false;
    L24:
        if (r118 != MmRecordingSource.FEISHU) goto L26;
        MinutesRecordingStartRequest.DoubaoBizInfo r119 = null;
    L72:
        MmRecordingSubtitleAppreciable r120 = com.ss.android.lark.officesdk.minutes.service.recording.common.perf.appreciable.a.d;
        MmSoftwareCurrentRecordingStateHandler r121 = this.this$0;
        r120.c(r121.a.c, r118, r121.l);
        com.ss.android.lark.officesdk.minutes.service.foundation.network.b r122 = (com.ss.android.lark.officesdk.minutes.service.foundation.network.b) this.this$0.g.getValue();
        Command r123 = Command.MINUTES_RECORDING_START;
        MinutesRecordingStartRequest.Builder r124 = new MinutesRecordingStartRequest.Builder();
        if (r119 == null) goto L75;
        r124.doubao_biz_info(r119);
    L75:
        Unit r125 = Unit.INSTANCE;
        MinutesRecordingStartRequest.Builder r126 = r124.apply_recording_id(Boxing.boxBoolean(r27));
        k r127 = this.this$0.a.f;
        if (r127 == null) goto L78;
        MmRecordingSource r128 = r127.a;
    L79:
        MinutesRecordingStartRequest r129 = r126.extra_type(com.ss.android.lark.officesdk.minutes.service.recording.common.core.c.a(r128)).m1874build();
        this.Z$0 = r27;
        this.label = 1;
        r110 = r122.b(r123, MinutesRecordingStartResponse.class, r129, this);
        if (r110 != r1) goto L12;
        return r1;
    L78:
        r128 = null;
        goto L79
    L26:
        MmSoftwareCurrentRecordingStateHandler r130 = this.this$0;
        MmSoftwareCurrentRecordingStateHandler.Companion r131 = MmSoftwareCurrentRecordingStateHandler.o;
        r130.getClass();
        MinutesRecordingStartRequest.DoubaoBizInfo.Builder r132 = new MinutesRecordingStartRequest.DoubaoBizInfo.Builder();
        DoubaoBizInfo r133 = r130.l;
        if (r133 == null) goto L30;
        String r134 = r133.getUserId();
        if (r134 == null) goto L30;
    L31:
        MinutesRecordingStartRequest.DoubaoBizInfo.Builder r135 = r132.user_id(r134);
        DoubaoBizInfo r136 = r130.l;
        if (r136 == null) goto L35;
        String r137 = r136.getConversationId();
        if (r137 == null) goto L35;
    L36:
        MinutesRecordingStartRequest.DoubaoBizInfo.Builder r138 = r135.conversation_id(r137);
        DoubaoBizInfo r139 = r130.l;
        if (r139 == null) goto L40;
        String r140 = r139.getMessageId();
        if (r140 == null) goto L40;
    L41:
        MinutesRecordingStartRequest.DoubaoBizInfo.Builder r141 = r138.message_id(r140);
        DoubaoBizInfo r142 = r130.l;
        if (r142 == null) goto L45;
        String r143 = r142.getReplyMessageId();
        if (r143 == null) goto L45;
    L46:
        MinutesRecordingStartRequest.DoubaoBizInfo.Builder r144 = r141.reply_message_id(r143);
        DoubaoBizInfo r145 = r130.l;
        if (r145 == null) goto L50;
        String r146 = r145.getBizId();
        if (r146 == null) goto L50;
    L51:
        MinutesRecordingStartRequest.DoubaoBizInfo.Builder r147 = r144.biz_id(r146);
        DoubaoBizInfo r148 = r130.l;
        if (r148 == null) goto L55;
        String r149 = r148.getAppId();
        if (r149 == null) goto L55;
    L56:
        MinutesRecordingStartRequest.DoubaoBizInfo.Builder r150 = r147.app_id(r149);
        DoubaoBizInfo r151 = r130.l;
        if (r151 == null) goto L60;
        String r152 = r151.getTenantId();
        if (r152 == null) goto L60;
    L61:
        MinutesRecordingStartRequest.DoubaoBizInfo.Builder r153 = r150.tenant_id(r152);
        DoubaoBizInfo r154 = r130.l;
        if (r154 == null) goto L65;
        String r155 = r154.getDeviceId();
        if (r155 == null) goto L65;
    L66:
        MinutesRecordingStartRequest.DoubaoBizInfo.Builder r156 = r153.device_id(r155);
        DoubaoBizInfo r157 = r130.l;
        if (r157 == null) goto L70;
        String r158 = r157.getRecordingId();
        if (r158 == null) goto L70;
    L71:
        r119 = r156.recording_id(r158).m1876build();
    L70:
        r158 = "";
    L65:
        r155 = "";
    L60:
        r152 = "";
    L55:
        r149 = "";
    L50:
        r146 = "";
    L45:
        r143 = "";
    L40:
        r140 = "";
    L35:
        r137 = "";
    L30:
        r134 = "";
        goto L31
    L20:
        if (r118 != MmRecordingSource.FEISHU) goto L22;
        r27 = true;
        goto L24
    L16:
        r118 = null;
        goto L17
    }
}
