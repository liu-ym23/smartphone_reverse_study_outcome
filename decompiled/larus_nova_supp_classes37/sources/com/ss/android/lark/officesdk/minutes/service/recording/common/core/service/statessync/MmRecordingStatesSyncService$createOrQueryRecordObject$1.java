package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.api.recording.doubao.DoubaoBizInfo;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.response.http.MmCreateAudioResponse;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.response.http.MmGetObjectTokenByMeetingIdResponse;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.utils.e0;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync.MmRecordingStatesSyncService$createOrQueryRecordObject$1", f = "MmRecordingStatesSyncService.kt", i = {3}, l = {255, 274, 286, 294, 304}, m = "invokeSuspend", n = {"localTopic"}, s = {"L$0"})
public final class MmRecordingStatesSyncService$createOrQueryRecordObject$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ DoubaoBizInfo $doubaoBizInfo;
    final /* synthetic */ String $meetingId;
    Object L$0;
    int label;
    final /* synthetic */ MmRecordingStatesSyncService this$0;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[MmRecordingSource.values().length];
            r0[MmRecordingSource.FEISHU_STANDALONE_AI_INTERPRETATION.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[MmRecordingSource.DOUBAO_STANDALONE_AI_INTERPRETATION.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public MmRecordingStatesSyncService$createOrQueryRecordObject$1(MmRecordingStatesSyncService r1, String r2, DoubaoBizInfo r3, Continuation<? super MmRecordingStatesSyncService$createOrQueryRecordObject$1> r4) {
        this.this$0 = r1;
        this.$meetingId = r2;
        this.$doubaoBizInfo = r3;
        super(1, r4);
    }

    public final Continuation<Unit> create(Continuation<?> r5) {
        return new MmRecordingStatesSyncService$createOrQueryRecordObject$1(this.this$0, this.$meetingId, this.$doubaoBizInfo, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super Unit> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r34) {
        Object r9 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        boolean r1 = false;
        if (r0 == 0) goto L15;
        if (r0 == 1) goto L14;
        if (r0 == 2) goto L14;
        if (r0 == 3) goto L14;
        if (r0 == 4) goto L12;
        if (r0 == 5) goto L14;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        String r2 = (String) this.L$0;
        ResultKt.throwOnFailure(r34);
        Object r3 = ((Result) r34).unbox-impl();
    L13:
        String r14 = r2;
        if (Result.isFailure-impl(r3) == false) goto L59;
        r3 = null;
    L59:
        MmGetObjectTokenByMeetingIdResponse r4 = (MmGetObjectTokenByMeetingIdResponse) r3;
        if (r4 == null) goto L67;
        HashMap<String, String> r5 = r4.getBizIdToTokenMap();
        if (r5 == null) goto L67;
        String r6 = r5.get(this.$meetingId);
        if (r6 == null) goto L67;
        String r12 = r6;
    L68:
        lvb.a.e(this.this$0.c, "[createOrQueryMinutesToken], queryMinutesToken: ".concat(r12));
        if (r12.length() <= 0) goto L71;
        r1 = true;
    L71:
        if (r1 == false) goto L74;
        this.this$0.n.setValue(Result.box-impl(Result.constructor-impl(new MmCreateAudioResponse(r12, this.$meetingId, r14, 0, 0, 0, false, 0, false, null, null, null, null, null, 16376, null))));
        return Unit.INSTANCE;
    L74:
        int r7 = this.this$0.b.getSettingsService().h.getMinutesTokenRetryMaxTimes();
        lvb.a.e(this.this$0.c, "[createOrQueryMinutesToken], createMinutesToken, bizInfo is:" + this.$doubaoBizInfo);
        MmRecordingStatesSyncService r8 = this.this$0;
        String r10 = this.$meetingId;
        AnonymousClass2 r11 = AnonymousClass2.INSTANCE;
        DoubaoBizInfo r13 = this.$doubaoBizInfo;
        this.L$0 = null;
        this.label = 5;
        if (r8.k(r10, r7, r11, r13, "", this) != r9) goto L92;
        return r9;
    L92:
        return Unit.INSTANCE;
    L67:
        r12 = "";
    L14:
        ResultKt.throwOnFailure(r34);
        goto L92
    L15:
        ResultKt.throwOnFailure(r34);
        MmRecordingStatesSyncService r15 = this.this$0;
        MmRecordingStatesSyncService.Companion r16 = MmRecordingStatesSyncService.q;
        MmRecordingSource r17 = r15.p();
        if (r17 != null) goto L18;
        int r18 = -1;
    L20:
        if (r18 == 1) goto L85;
        if (r18 == 2) goto L78;
        if (this.this$0.a.v() == true) goto L25;
        e r19 = this.this$0.l();
        String r20 = this.$meetingId;
        r19.getClass();
        Intrinsics.checkNotNullParameter(r20, "meetingId");
        Result.Companion r110 = Result.Companion;     // Catch: Throwable -> L41
        if (r19.c != null) goto L35;
        r19.c = (Map) e0.b(r19.a.H().getString("minutes_recording_v2_meeting_map_prefix", null), new f().getType());     // Catch: Throwable -> L41
    L35:
        lvb.a.e(r19.b, "getMinutesTokenByMeetingId  meetingId: " + r20 + ", meetingId2TokenMap:" + r19.c);     // Catch: Throwable -> L41
        Map<String, String> r21 = r19.c;     // Catch: Throwable -> L41
        if (r21 == null) goto L39;
        String r22 = r21.get(r20);     // Catch: Throwable -> L41
        if (r22 == null) goto L39;
    L40:
        String r111 = r22;
    L43:
        e r23 = this.this$0.l();
        String r24 = this.$meetingId;
        r23.getClass();
        Intrinsics.checkNotNullParameter(r24, "meetingId");
        r2 = r23.a.H().getString("minutes_recording_v2_local_topic_prefix" + r24, null);
        if (r2 != null) goto L47;
        r2 = "";
    L47:
        if (r111.length() <= 0) goto L49;
        boolean r25 = true;
    L50:
        if (r25 == false) goto L53;
        this.this$0.n.setValue(Result.box-impl(Result.constructor-impl(new MmCreateAudioResponse(r111, this.$meetingId, r2, 0, 0, 0, false, 0, false, null, null, null, null, null, 16376, null))));
        return Unit.INSTANCE;
    L53:
        com.ss.android.lark.officesdk.minutes.service.foundation.network.b r26 = (com.ss.android.lark.officesdk.minutes.service.foundation.network.b) this.this$0.f.getValue();
        jvb.c r112 = new jvb.c(this.$meetingId, r17);
        this.L$0 = r2;
        this.label = 4;
        r3 = r26.c(MmGetObjectTokenByMeetingIdResponse.class, r112, this);
        if (r3 != r9) goto L13;
        return r9;
    L49:
        r25 = false;
    L39:
        r22 = "";
    L41:
        th = move-exception;
        Result.Companion r27 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        r111 = "";
        goto L43
    L25:
        if (this.this$0.t() == false) goto L28;
        lvb.a.e(this.this$0.c, "[createOrQueryRecordObject] recording already ready, meetingId=" + this.$meetingId);
        return Unit.INSTANCE;
    L28:
        MmRecordingStatesSyncService r28 = this.this$0;
        String r29 = this.$meetingId;
        DoubaoBizInfo r30 = this.$doubaoBizInfo;
        this.label = 3;
        if (r28.g(r29, r30, "", this) != r9) goto L92;
        return r9;
    L78:
        if (this.this$0.t() == false) goto L81;
        lvb.a.e(this.this$0.c, "[createOrQueryRecordObject] recording already ready, meetingId=" + this.$meetingId);
        return Unit.INSTANCE;
    L81:
        String r31 = this.this$0.s(this.$meetingId);
        lvb.a.e(this.this$0.c, "[createOrQueryRecordObject] doubao standalone AI interpretation, lookup before create, meetingId=" + this.$meetingId + ", recordingId=" + r31);
        MmRecordingStatesSyncService r32 = this.this$0;
        String r33 = this.$meetingId;
        DoubaoBizInfo r35 = this.$doubaoBizInfo;
        this.label = 2;
        if (r32.g(r33, r35, r31, this) != r9) goto L92;
        return r9;
    L85:
        if (this.this$0.t() == false) goto L88;
        lvb.a.e(this.this$0.c, "[createOrQueryRecordObject] recording already ready, meetingId=" + this.$meetingId);
        return Unit.INSTANCE;
    L88:
        String r36 = this.this$0.s(this.$meetingId);
        lvb.a.e(this.this$0.c, "[createOrQueryRecordObject] standalone AI interpretation, meetingId=" + this.$meetingId + ", recordingId=" + r36);
        MmRecordingStatesSyncService r37 = this.this$0;
        String r38 = this.$meetingId;
        int r39 = r37.b.getSettingsService().h.getMinutesTokenRetryMaxTimes();
        AnonymousClass1 r40 = AnonymousClass1.INSTANCE;
        DoubaoBizInfo r41 = this.$doubaoBizInfo;
        this.label = 1;
        if (r37.k(r38, r39, r40, r41, r36, this) != r9) goto L92;
        return r9;
    L18:
        r18 = a.a[r17.ordinal()];
        goto L20
    }
}
