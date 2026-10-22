package com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.EndRecordingReason;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.api.recording.doubao.DoubaoBizInfo;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.response.http.MmCreateAudioResponse;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSession;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.data.TerminateReason;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync.MmRecordingStatesSyncService;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.upload.MmRecordingHistoryUploadResumeTracker;
import com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.MmRecordingCommonParam;
import com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.l;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.utils.y;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.b1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler.MmSoftwareHistoryRecordingStateHandler$onStateChanged$1", f = "MmSoftwareHistoryRecordingStateHandler.kt", i = {0, 1, 2, 2, 2, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4}, l = {90, 91, 97, 110, 118, 139}, m = "invokeSuspend", n = {"meetingId", "meetingId", "meetingId", "cachedDoubaoBizInfo", "recordingSource", "meetingId", "cachedDoubaoBizInfo", "recordingSource", "refreshedRecordingSource", "isRecordingIdBased", "meetingId", "cachedDoubaoBizInfo", "recordingSource", "refreshedRecordingSource", "isRecordingIdBased"}, s = {"L$0", "L$0", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "Z$0", "L$0", "L$1", "L$2", "L$3", "Z$0"})
public final class MmSoftwareHistoryRecordingStateHandler$onStateChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    boolean Z$0;
    int label;
    final /* synthetic */ MmSoftwareHistoryRecordingStateHandler this$0;

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler.MmSoftwareHistoryRecordingStateHandler$onStateChanged$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/core/data/MmRecordingData;", "it"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler.MmSoftwareHistoryRecordingStateHandler$onStateChanged$1$1", f = "MmSoftwareHistoryRecordingStateHandler.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<ovb.b, Continuation<? super ovb.b>, Object> {
        final /* synthetic */ String $meetingId;
        /* synthetic */ Object L$0;
        int label;

        public AnonymousClass1(String r1, Continuation<? super AnonymousClass1> r2) {
            this.$meetingId = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            AnonymousClass1 r0 = new AnonymousClass1(this.$meetingId, r4);
            r0.L$0 = r3;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((ovb.b) r1, (Continuation) r2);
        }

        public final Object invoke(ovb.b r1, Continuation<? super ovb.b> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r11) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r11);
            return ovb.b.a((ovb.b) this.L$0, this.$meetingId, 0, null, null, null, null, false, 254);
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler.MmSoftwareHistoryRecordingStateHandler$onStateChanged$1$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/core/data/MmRecordingData;", "it"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler.MmSoftwareHistoryRecordingStateHandler$onStateChanged$1$2", f = "MmSoftwareHistoryRecordingStateHandler.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<ovb.b, Continuation<? super ovb.b>, Object> {
        final /* synthetic */ String $persistedRecordingId;
        /* synthetic */ Object L$0;
        int label;

        public AnonymousClass2(String r1, Continuation<? super AnonymousClass2> r2) {
            this.$persistedRecordingId = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            AnonymousClass2 r0 = new AnonymousClass2(this.$persistedRecordingId, r4);
            r0.L$0 = r3;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((ovb.b) r1, (Continuation) r2);
        }

        public final Object invoke(ovb.b r1, Continuation<? super ovb.b> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r11) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L10;
            ResultKt.throwOnFailure(r11);
            ovb.b r0 = (ovb.b) this.L$0;
            String r12 = this.$persistedRecordingId;
            if (StringsKt.isBlank(r12) == false) goto L8;
            r12 = r0.c;
        L8:
            return ovb.b.a(r0, null, 0, r12, null, null, null, false, 251);
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler.MmSoftwareHistoryRecordingStateHandler$onStateChanged$1$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/core/data/MmRecordingData;", "it"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler.MmSoftwareHistoryRecordingStateHandler$onStateChanged$1$3", f = "MmSoftwareHistoryRecordingStateHandler.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<ovb.b, Continuation<? super ovb.b>, Object> {
        final /* synthetic */ DoubaoBizInfo $cachedDoubaoBizInfo;
        final /* synthetic */ boolean $isRecordingIdBased;
        final /* synthetic */ String $meetingId;
        final /* synthetic */ MmRecordingSource $recordingSource;
        final /* synthetic */ MmRecordingSource $refreshedRecordingSource;
        final /* synthetic */ String $uploadIdentity;
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ MmSoftwareHistoryRecordingStateHandler this$0;

        public AnonymousClass3(boolean r1, String r2, String r3, MmSoftwareHistoryRecordingStateHandler r4, MmRecordingSource r5, MmRecordingSource r6, DoubaoBizInfo r7, Continuation<? super AnonymousClass3> r8) {
            this.$isRecordingIdBased = r1;
            this.$uploadIdentity = r2;
            this.$meetingId = r3;
            this.this$0 = r4;
            this.$refreshedRecordingSource = r5;
            this.$recordingSource = r6;
            this.$cachedDoubaoBizInfo = r7;
            super(2, r8);
        }

        public final Continuation<Unit> create(Object r11, Continuation<?> r12) {
            AnonymousClass3 r9 = new AnonymousClass3(this.$isRecordingIdBased, this.$uploadIdentity, this.$meetingId, this.this$0, this.$refreshedRecordingSource, this.$recordingSource, this.$cachedDoubaoBizInfo, r12);
            r9.L$0 = r11;
            return r9;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((ovb.b) r1, (Continuation) r2);
        }

        public final Object invoke(ovb.b r1, Continuation<? super ovb.b> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r22) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L36;
            ResultKt.throwOnFailure(r22);
            ovb.b r2 = (ovb.b) this.L$0;
            boolean r1 = this.$isRecordingIdBased;
            if (r1 == false) goto L7;
            String r3 = r2.d;
        L8:
            String r7 = r3;
            if (r1 == false) goto L11;
            String r4 = this.$uploadIdentity;
        L12:
            String r6 = r4;
            if (r1 == false) goto L15;
            String r9 = "";
        L16:
            Intrinsics.checkNotNull(r9);
            if (this.$isRecordingIdBased == false) goto L19;
            String r5 = this.$uploadIdentity;
        L20:
            String r10 = r5;
            String r13 = this.$meetingId;
            String r14 = this.this$0.c.getCurrentUserId();
            MmSoftwareHistoryRecordingStateHandler r8 = this.this$0;
            String r15 = r8.a.c;
            MmRecordingSource r11 = this.$refreshedRecordingSource;
            if (r11 != null) goto L23;
            r11 = this.$recordingSource;
        L23:
            MmRecordingSource r16 = r11;
            String r17 = r8.c.getTenantId();
            if (this.$isRecordingIdBased == false) goto L26;
            String r12 = this.$uploadIdentity;
        L32:
            String r18 = r12;
        L34:
            return ovb.b.a(r2, null, 0, r6, r7, new MmRecordingCommonParam(r9, r10, false, "historyUpload", r13, r14, r15, r16, r17, r18, this.this$0.a.a.name()), null, false, 211);
        L26:
            DoubaoBizInfo r19 = this.$cachedDoubaoBizInfo;
            if (r19 == null) goto L29;
            r12 = r19.getRecordingId();
        L30:
            if (r12 != null) goto L32;
            r18 = "";
            goto L34
        L29:
            r12 = null;
            goto L30
        L19:
            r5 = this.$meetingId;
            goto L20
        L15:
            r9 = y.b(this.$uploadIdentity);
            goto L16
        L11:
            r4 = r2.c;
            goto L12
        L7:
            r3 = this.$uploadIdentity;
            goto L8
        L36:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public MmSoftwareHistoryRecordingStateHandler$onStateChanged$1(MmSoftwareHistoryRecordingStateHandler r1, Continuation<? super MmSoftwareHistoryRecordingStateHandler$onStateChanged$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new MmSoftwareHistoryRecordingStateHandler$onStateChanged$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r21) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        boolean r3 = false;
        String r4 = "";
        switch(this.label) {
            case 0: goto L12;
            case 1: goto L11;
            case 2: goto L10;
            case 3: goto L9;
            case 4: goto L8;
            case 5: goto L7;
            case 6: goto L6;
            default: goto L5;
        };
    L6:
        ResultKt.throwOnFailure(r21);
    L68:
        com.ss.android.lark.officesdk.minutes.service.recording.common.perf.appreciable.d.a(com.ss.android.lark.officesdk.minutes.service.recording.common.perf.appreciable.a.c, this.this$0.a.e(), this.this$0.a.j());
        this.this$0.a.u(new com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.a.k(EndRecordingReason.HISTORY_RECORDING));
        return Unit.INSTANCE;
    L7:
        boolean r2 = this.Z$0;
        MmRecordingSource r7 = (MmRecordingSource) this.L$3;
        MmRecordingSource r8 = (MmRecordingSource) this.L$2;
        DoubaoBizInfo r9 = (DoubaoBizInfo) this.L$1;
        String r10 = (String) this.L$0;
        ResultKt.throwOnFailure(r21);
        Object r11 = r21;
    L47:
        Result r12 = (Result) r11;
        if (r12 == null) goto L55;
        Object r13 = r12.unbox-impl();
        if (Result.isFailure-impl(r13) == false) goto L52;
        r13 = null;
    L52:
        MmCreateAudioResponse r14 = (MmCreateAudioResponse) r13;
        if (r14 == null) goto L55;
        String r15 = r14.getObjectToken();
    L56:
        if (r15 != null) goto L58;
    L57:
        boolean r16 = r2;
        String r17 = r4;
        MmRecordingSource r18 = r7;
        MmRecordingSource r19 = r8;
        DoubaoBizInfo r110 = r9;
        String r111 = r10;
    L60:
        if (r17.length() != 0) goto L62;
        r3 = true;
    L62:
        if (r3 == false) goto L65;
        lvb.a.b(this.this$0.b, "[startUpload] failed, uploadIdentity is empty");
        l.i(this.this$0.a.b(), "upload", Boxing.boxInt(-10003), "minutes_token_empty", null, null, null, null, null, 4080);
        this.this$0.a.u(new com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.a.n(TerminateReason.MINUTES_TOKEN_EMPTY));
        return Unit.INSTANCE;
    L65:
        MmSoftwareHistoryRecordingStateHandler r112 = this.this$0;
        MmRecordingSession r5 = r112.a;
        AnonymousClass3 r6 = new AnonymousClass3(r16, r17, r111, r112, r18, r19, r110, null);
        this.L$0 = null;
        this.L$1 = null;
        this.L$2 = null;
        this.L$3 = null;
        this.label = 6;
        if (r5.s(r6, this) != r1) goto L68;
        return r1;
    L58:
        r16 = r2;
        r18 = r7;
        r19 = r8;
        r110 = r9;
        r111 = r10;
        r17 = r15;
    L55:
        r15 = null;
        goto L56
    L8:
        r2 = this.Z$0;
        MmRecordingSource r20 = (MmRecordingSource) this.L$3;
        MmRecordingSource r22 = (MmRecordingSource) this.L$2;
        DoubaoBizInfo r23 = (DoubaoBizInfo) this.L$1;
        String r24 = (String) this.L$0;
        ResultKt.throwOnFailure(r21);
        r10 = r24;
        r9 = r23;
        r8 = r22;
        r7 = r20;
        Object r25 = r21;
    L40:
        r4 = (String) r25;
        if (r4 != null) goto L57;
        return Unit.INSTANCE;
    L9:
        MmRecordingSource r26 = (MmRecordingSource) this.L$2;
        DoubaoBizInfo r27 = (DoubaoBizInfo) this.L$1;
        String r28 = (String) this.L$0;
        ResultKt.throwOnFailure(r21);
        r9 = r27;
        r10 = r28;
        r8 = r26;
    L35:
        MmSoftwareHistoryRecordingStateHandler r29 = this.this$0;
        MmSoftwareHistoryRecordingStateHandler.Companion r30 = MmSoftwareHistoryRecordingStateHandler.h;
        r29.d().h(r10, r9);
        r2 = this.this$0.a.v();
        r7 = this.this$0.d().q(r10);
        if (r2 == false) goto L44;
        MmSoftwareHistoryRecordingStateHandler.Companion r31 = MmSoftwareHistoryRecordingStateHandler.h;
        MmSoftwareHistoryRecordingStateHandler$onStateChanged$1$uploadIdentity$1 r113 = new MmSoftwareHistoryRecordingStateHandler$onStateChanged$1$uploadIdentity$1(this.this$0.d());
        final MmSoftwareHistoryRecordingStateHandler r114 = this.this$0;
        Function1<Throwable, Unit> r115 = new MmSoftwareHistoryRecordingStateHandler$onStateChanged$1$uploadIdentity$2(r114);
        this.L$0 = r10;
        this.L$1 = r9;
        this.L$2 = r8;
        this.L$3 = r7;
        this.Z$0 = r2;
        this.label = 4;
        r25 = r31.a(r113, r115, this);
        if (r25 != r1) goto L40;
        return r1;
    L44:
        b1 r116 = this.this$0.d().o;
        MmSoftwareHistoryRecordingStateHandler$onStateChanged$1$uploadIdentity$3 r117 = new MmSoftwareHistoryRecordingStateHandler$onStateChanged$1$uploadIdentity$3(null);
        this.L$0 = r10;
        this.L$1 = r9;
        this.L$2 = r8;
        this.L$3 = r7;
        this.Z$0 = r2;
        this.label = 5;
        r11 = kotlinx.coroutines.flow.e.t(r116, r117, this);
        if (r11 != r1) goto L47;
        return r1;
    L10:
        String r32 = (String) this.L$0;
        ResultKt.throwOnFailure(r21);
    L28:
        MmSoftwareHistoryRecordingStateHandler r33 = this.this$0;
        MmSoftwareHistoryRecordingStateHandler.Companion r34 = MmSoftwareHistoryRecordingStateHandler.h;
        MmRecordingStatesSyncService r35 = r33.d();
        r35.getClass();
        Intrinsics.checkNotNullParameter(r32, "meetingId");
        DoubaoBizInfo r36 = r35.l().h(r32);
        MmRecordingSource r37 = this.this$0.d().q(r32);
        MmRecordingStatesSyncService r118 = this.this$0.d();
        r118.getClass();
        Intrinsics.checkNotNullParameter(r32, "meetingId");
        com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync.e r119 = r118.l();
        r119.getClass();
        Intrinsics.checkNotNullParameter(r32, "meetingId");
        String r38 = r119.a.H().getString("minutes_recording_v2_recording_id_prefix".concat(r32), null);
        if (r38 != null) goto L31;
        r38 = "";
    L31:
        MmRecordingSession r120 = this.this$0.a;
        AnonymousClass2 r121 = new AnonymousClass2(r38, null);
        this.L$0 = r32;
        this.L$1 = r36;
        this.L$2 = r37;
        this.label = 3;
        if (r120.s(r121, this) != r1) goto L34;
        return r1;
    L34:
        r10 = r32;
        r8 = r37;
        r9 = r36;
        goto L35
    L11:
        r32 = (String) this.L$0;
        ResultKt.throwOnFailure(r21);
    L25:
        MmRecordingHistoryUploadResumeTracker r39 = (MmRecordingHistoryUploadResumeTracker) this.this$0.g.getValue();
        this.L$0 = r32;
        this.label = 2;
        if (r39.b(r32, this) != r1) goto L28;
        return r1;
    L12:
        ResultKt.throwOnFailure(r21);
        r32 = this.this$0.a.e;
        if (r32 != null) goto L15;
    L18:
        boolean r40 = true;
    L19:
        if (r40 == false) goto L22;
        lvb.a.b(this.this$0.b, "meetingId is empty");
        this.this$0.a.u(new com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.a.n(TerminateReason.MEETING_ID_EMPTY));
        return Unit.INSTANCE;
    L22:
        MmSoftwareHistoryRecordingStateHandler r41 = this.this$0;
        MmSoftwareHistoryRecordingStateHandler.Companion r42 = MmSoftwareHistoryRecordingStateHandler.h;
        BuildersKt.launch$default(r41.a.u, null, null, new MmSoftwareHistoryRecordingStateHandler$checkIfNeedSendStopRecordingRequest$1(r41, r32, null), 3, null);
        MmRecordingSession r43 = this.this$0.a;
        AnonymousClass1 r44 = new AnonymousClass1(r32, null);
        this.L$0 = r32;
        this.label = 1;
        if (r43.s(r44, this) != r1) goto L25;
        return r1;
    L15:
        if (r32.length() == 0) goto L18;
        r40 = false;
        goto L19
    L5:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
