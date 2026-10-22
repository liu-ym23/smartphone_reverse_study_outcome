package com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler;

import com.bytedance.lark.pb.basic.v1.Command;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.response.http.MmCreateAudioResponse;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSession;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.data.TerminateReason;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.MinutesForegroundService;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.MmRecordingAudioService;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync.MmRecordingStatesSyncService;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.MmStandaloneAIInterpretationRepo;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.MmStandaloneAIInterpretationRootRepo;
import com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.MmRecordingCommonParam;
import com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.q;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.pb.minutes.v1.MinutesRecordingStartResponse;
import com.ss.android.lark.pb.minutes.v1.MinutesRecordingStopRequest;
import com.ss.android.lark.pb.minutes.v1.MinutesRecordingStopResponse;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.UIHelper;
import iub.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.b1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MmStandaloneAIInterpretationStateHandler extends f {
    public static final a l = null;
    public final String b;
    public final com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a c;
    public final MmRecordingAudioService d;
    public final MmRecordingStatesSyncService e;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;
    public Job i;
    public boolean j;
    public final com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler.a k;

    public static final class a {
        public a() {
        }

        public final Object a(final b1 r6, Continuation r7) {
            if ((r7 instanceof MmStandaloneAIInterpretationStateHandler$Companion$awaitRecordingIdForUpload$1) == false) goto L7;
            MmStandaloneAIInterpretationStateHandler$Companion$awaitRecordingIdForUpload$1 r0 = (MmStandaloneAIInterpretationStateHandler$Companion$awaitRecordingIdForUpload$1) r7;
            int r1 = r0.label;
            if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
            r0.label = r1 - Integer.MIN_VALUE;
        L8:
            Object r8 = r0.result;
            Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r3 = r0.label;
            String r4 = null;
            if (r3 == 0) goto L14;
            if (r3 != 1) goto L13;
            ResultKt.throwOnFailure(r8);
        L17:
            MmCreateAudioResponse r9 = (MmCreateAudioResponse) r8;
            if (r9 == null) goto L20;
            r4 = r9.getRecordingId();
        L20:
            if (r4 != null) goto L23;
            return "";
        L23:
            return r4;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r8);
            Flow<MmCreateAudioResponse> r10 = new MmStandaloneAIInterpretationStateHandler$Companion$awaitRecordingIdForUpload$$inlined$map$1(r6);
            MmStandaloneAIInterpretationStateHandler$Companion$awaitRecordingIdForUpload$3 r11 = new MmStandaloneAIInterpretationStateHandler$Companion$awaitRecordingIdForUpload$3(null);
            r0.label = 1;
            r8 = kotlinx.coroutines.flow.e.t(r10, r11, r0);
            if (r8 != r2) goto L17;
            return r2;
        L7:
            r0 = new MmStandaloneAIInterpretationStateHandler$Companion$awaitRecordingIdForUpload$1(this, r7);
            goto L8
        }
    }

    static {
        l = new a();
    }

    public final com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c h() {
        MmStandaloneAIInterpretationRootRepo r0 = this.a.h();
        String r1 = null;
        if (r0 == null) goto L15;
        MmStandaloneAIInterpretationRepo r2 = r0.a();
        if (r2 == null) goto L15;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.a r3 = r2.t();
        if (r3 == null) goto L15;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.b r4 = r3.m();
        if (r4 == null) goto L15;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r5 = r4.i;
        if (r5 == null) goto L15;
        if ((!StringsKt.isBlank(r5.a)) == false) goto L15;
    L16:
        if (r5 == null) goto L18;
        return r5;
    L18:
        k r6 = this.a.f;
        if (r6 == null) goto L28;
        String r7 = r6.e;
        if (r7 == null) goto L28;
        if ((!StringsKt.isBlank(r7)) == true) goto L26;
        r7 = null;
    L26:
        if (r7 == null) goto L28;
    L37:
        r1 = r7;
    L39:
        return new com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c(r1, r1);
    L28:
        k r8 = this.a.f;
        if (r8 == null) goto L35;
        String r9 = r8.d;
        if (r9 == null) goto L35;
        if ((!StringsKt.isBlank(r9)) == false) goto L35;
        r1 = r9;
    L35:
        if (r1 != null) goto L39;
        r7 = "en_us";
    L15:
        r5 = null;
        goto L16
    }

    public MmStandaloneAIInterpretationStateHandler(MmRecordingSession r2) {
        Intrinsics.checkNotNullParameter(r2, "recordingSession");
        super(r2);
        this.b = "MmStandaloneAIInterpretationHandler";
        this.c = r2.b;
        MmRecordingAudioService r0 = r2.a();
        if (r0 == null) goto L7;
        this.d = r0;
        this.e = r2.i();
        this.f = LazyKt.lazy(new MmStandaloneAIInterpretationStateHandler$networkService$2(this));
        this.g = LazyKt.lazy(new MmStandaloneAIInterpretationStateHandler$standaloneTracker$2(this));
        this.h = LazyKt.lazy(new MmStandaloneAIInterpretationStateHandler$meetingCreateFailureHandler$2(this));
        this.k = new com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler.a(new MmStandaloneAIInterpretationStateHandler$phoneStateHelper$1(this));
        return;
    L7:
        throw new IllegalStateException("audioService required for standalone AI interpretation session");
    }

    public final Object g(Continuation<? super Unit> r8) {
        if ((r8 instanceof MmStandaloneAIInterpretationStateHandler$leaveMeetingSync$1) == false) goto L7;
        MmStandaloneAIInterpretationStateHandler$leaveMeetingSync$1 r0 = (MmStandaloneAIInterpretationStateHandler$leaveMeetingSync$1) r8;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        ResultKt.throwOnFailure(r9);
        Object r10 = ((Result) r9).unbox-impl();
    L23:
        if (Result.isSuccess-impl(r10) == false) goto L25;
        lvb.a.e(this.b, "[leaveMeeting] success " + ((MinutesRecordingStopResponse) r10));
    L25:
        Throwable r11 = Result.exceptionOrNull-impl(r10);
        if (r11 == null) goto L29;
        lvb.a.b(this.b, "[leaveMeeting] failed " + r11);
    L29:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r9);
    L19:
        String r12 = ((ovb.b) r9).a;
        com.ss.android.lark.officesdk.minutes.service.foundation.network.b r4 = (com.ss.android.lark.officesdk.minutes.service.foundation.network.b) this.f.getValue();
        Command r5 = Command.MINUTES_RECORDING_STOP;
        MinutesRecordingStopRequest r13 = new MinutesRecordingStopRequest.Builder().session_id(r12).m1886build();
        r0.label = 2;
        r10 = r4.b(r5, MinutesRecordingStopResponse.class, r13, r0);
        if (r10 != r2) goto L23;
        return r2;
    L16:
        ResultKt.throwOnFailure(r9);
        MmRecordingSession r14 = this.a;
        r0.label = 1;
        r9 = r14.r(r0);
        if (r9 != r2) goto L19;
        return r2;
    L7:
        r0 = new MmStandaloneAIInterpretationStateHandler$leaveMeetingSync$1(this, r8);
        goto L8
    }

    public final void j(String r5) {
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.c r0 = this.c.N();
        String r1 = this.a.e();
        MmRecordingSession r2 = this.a;
        int r3 = com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.c.n;
        r0.k(r2, r2.w.f);
        r0.e(r1);
        if (r5 != null) goto L5;
    L8:
        boolean r4 = true;
    L9:
        if (r4 == false) goto L11;
        return;
    L11:
        if (Intrinsics.areEqual(r5, r1) == true) goto L15;
        r0.f(r5);
        return;
    L15:
        return;
    L5:
        if (StringsKt.isBlank(r5) == true) goto L8;
        r4 = false;
        goto L9
    }

    public static final Object e(MmStandaloneAIInterpretationStateHandler r4, Continuation r5) {
        r4.getClass();
        if ((r5 instanceof MmStandaloneAIInterpretationStateHandler$trackRecordUploadMinutesCreateStatus$1) == false) goto L7;
        MmStandaloneAIInterpretationStateHandler$trackRecordUploadMinutesCreateStatus$1 r0 = (MmStandaloneAIInterpretationStateHandler$trackRecordUploadMinutesCreateStatus$1) r5;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r6 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.c r7 = (com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.c) r0.L$1;
        String r8 = (String) r0.L$0;
        ResultKt.throwOnFailure(r6);
    L20:
        MmRecordingCommonParam r9 = ((ovb.b) r6).f;
        r7.getClass();
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.c.j(r9, r8, "independent_si");
    L22:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r6);
        int r10 = com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.c.n;
        MmRecordingSession r11 = r4.a;
        String r12 = com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.c.a.a(r11.a, r11.f);
        if (r12 == null) goto L22;
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.c r13 = r4.c.N();
        MmRecordingSession r14 = r4.a;
        r0.L$0 = r12;
        r0.L$1 = r13;
        r0.label = 1;
        Object r15 = r14.r(r0);
        if (r15 == r2) goto L23;
        r8 = r12;
        r6 = r15;
        r7 = r13;
        goto L20
    L23:
        return r2;
    L7:
        r0 = new MmStandaloneAIInterpretationStateHandler$trackRecordUploadMinutesCreateStatus$1(r4, r5);
        goto L8
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler.f
    public final void a(com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c r14, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c r15) {
        Intrinsics.checkNotNullParameter(r14, "oldState");
        Intrinsics.checkNotNullParameter(r15, "newState");
        String r0 = this.b;
        StringBuilder r1 = new StringBuilder("onStateChanged: ");
        r1.append(r14);
        r1.append(" -> ");
        r1.append(r15);
        r1.append(", recordingId=");
        r1.append(lvb.a.d(this.a.e()));
        r1.append(", source=");
        k r2 = this.a.f;
        MmRecordingSource r3 = null;
        if (r2 == null) goto L5;
        MmRecordingSource r4 = r2.a;
    L6:
        r1.append(r4);
        lvb.a.e(r0, r1.toString());
        if (Intrinsics.areEqual(r15, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.C0037c.c) == false) goto L9;
        this.d.k();
        BuildersKt.launch$default(this.a.v, null, null, new MmStandaloneAIInterpretationStateHandler$createMinutesRecordingAndInitAudioService$1(this, null), 3, null);
        return;
    L9:
        com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.l r5 = com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.l.c;
        if (Intrinsics.areEqual(r15, r5) == false) goto L12;
        BuildersKt.launch$default(this.a.v, null, null, new MmStandaloneAIInterpretationStateHandler$onStateChanged$1(this, null), 3, null);
        return;
    L12:
        boolean r6 = true;
        if (Intrinsics.areEqual(r15, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.k.c) == false) goto L31;
        this.d.l();
        this.k.b();
        if (Intrinsics.areEqual(r14, r5) == false) goto L27;
        q r7 = (q) this.g.getValue();
        MmRecordingSession r8 = this.a;
        r7.getClass();
        Intrinsics.checkNotNullParameter(r8, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        k r9 = r8.f;
        if (r9 == null) goto L20;
        MmRecordingSource r10 = r9.a;
        if (r10 == null) goto L20;
    L22:
        if (r10 == MmRecordingSource.DOUBAO_STANDALONE_AI_INTERPRETATION) goto L25;
        r6 = false;
    L25:
        if (r6 == false) goto L27;
        r7.b(r8, "start_record");
    L20:
        r10 = r8.j().getSource();
    L27:
        String r11 = UIHelper.getString(2131892839);
        MinutesForegroundService.ForegroundServiceType r12 = MinutesForegroundService.ForegroundServiceType.RECORDING;
        Intrinsics.checkNotNullParameter(r11, "title");
        Intrinsics.checkNotNullParameter("", "content");
        Intrinsics.checkNotNullParameter(r12, "foregroundServiceType");
        MinutesForegroundService.Companion r13 = MinutesForegroundService.h;
        MinutesForegroundService.Companion.k(LarkContext.getApplication(), r11, "", this.c.A(), r12, 96);
        if (Intrinsics.areEqual(r14, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.h.c) == false) goto L55;
        this.e.F(r15);
        return;
    L55:
        return;
    L31:
        if (Intrinsics.areEqual(r15, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.h.c) == false) goto L34;
        this.d.m();
        this.e.F(r15);
        return;
    L34:
        if ((r15 instanceof com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.b) == false) goto L37;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r16 = h();
        BuildersKt.launch$default(this.a.u, null, null, new MmStandaloneAIInterpretationStateHandler$onStateChanged$2(this, null), 3, null);
        this.k.c();
        BuildersKt.launch$default(this.a.u, null, null, new MmStandaloneAIInterpretationStateHandler$stopIndependentAIInterpretation$1(this, r16, null), 3, null);
        this.d.h();
        BuildersKt.launch$default(this.a.u, null, null, new MmStandaloneAIInterpretationStateHandler$leaveMeeting$1(this, null), 3, null);
        CoroutineScopeKt.cancel$default(this.a.v, null, 1, null);
        this.e.F(r15);
        BuildersKt.launch$default(this.a.u, null, null, new MmStandaloneAIInterpretationStateHandler$onStateChanged$3(this, null), 3, null);
        return;
    L37:
        if (Intrinsics.areEqual(r15, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.i.c) == false) goto L50;
        k r17 = this.a.f;
        if (r17 == null) goto L42;
        r3 = r17.a;
    L42:
        if (r3 != MmRecordingSource.DOUBAO_STANDALONE_AI_INTERPRETATION) goto L44;
        int r18 = 2131890207;
    L45:
        String r19 = UIHelper.getString(r18);
        MinutesForegroundService.ForegroundServiceType r110 = MinutesForegroundService.ForegroundServiceType.DATA_SYNC;
        Intrinsics.checkNotNullParameter(r19, "title");
        Intrinsics.checkNotNullParameter("", "content");
        Intrinsics.checkNotNullParameter(r110, "foregroundServiceType");
        MinutesForegroundService.Companion r111 = MinutesForegroundService.h;
        MinutesForegroundService.Companion.k(LarkContext.getApplication(), r19, "", this.c.A(), r110, 96);
        boolean r112 = this.e.t();
        MmStandaloneAIInterpretationStateHandler$onStateChanged$4 r113 = new MmStandaloneAIInterpretationStateHandler$onStateChanged$4(this.a.k());
        Function0<Unit> r20 = new MmStandaloneAIInterpretationStateHandler$onStateChanged$5(this);
        Intrinsics.checkNotNullParameter(r113, "onReady");
        Intrinsics.checkNotNullParameter(r20, "onRecover");
        if (r112 == false) goto L48;
        r113.invoke();
        return;
    L48:
        r20.invoke();
        return;
    L44:
        r18 = 2131892840;
        goto L45
    L50:
        if (Intrinsics.areEqual(r15, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.n.c) == false) goto L61;
        this.a.k().k();
        BuildersKt.launch$default(this.a.u, null, null, new MmStandaloneAIInterpretationStateHandler$onStateChanged$6(this, null), 3, null);
        return;
    L61:
        return;
    L5:
        r4 = null;
        goto L6
    }

    public final Object i(com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r9, Continuation<? super Unit> r10) {
        if ((r10 instanceof MmStandaloneAIInterpretationStateHandler$stopIndependentAIInterpretationSync$1) == false) goto L7;
        MmStandaloneAIInterpretationStateHandler$stopIndependentAIInterpretationSync$1 r0 = (MmStandaloneAIInterpretationStateHandler$stopIndependentAIInterpretationSync$1) r10;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        String r6 = null;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        r9 = (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c) r0.L$0;
        ResultKt.throwOnFailure(r11);
    L32:
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.g r12 = (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.g) r11;
    L34:
        String r4 = this.b;
        StringBuilder r5 = new StringBuilder("[stopIndependentAIInterpretation] result, status=");
        if (r12 == null) goto L37;
        Integer r7 = Boxing.boxInt(r12.b);
    L38:
        r5.append(r7);
        r5.append(", accepted=");
        if (r12 == null) goto L41;
        Boolean r8 = Boxing.boxBoolean(r12.a());
    L42:
        r5.append(r8);
        r5.append(", channel=");
        if (r12 == null) goto L45;
        r6 = r12.a;
    L45:
        r5.append(r6);
        r5.append(", target=");
        r5.append(r9.a);
        lvb.a.e(r4, r5.toString());
        return Unit.INSTANCE;
    L41:
        r8 = null;
        goto L42
    L37:
        r7 = null;
        goto L38
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r9 = (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c) r0.L$0;
        ResultKt.throwOnFailure(r11);
    L19:
        String r13 = ((ovb.b) r11).a;
        if (StringsKt.isBlank(r13) == false) goto L23;
        lvb.a.h(this.b, "[stopIndependentAIInterpretation] skip, meetingId is blank");
        return Unit.INSTANCE;
    L23:
        lvb.a.e(this.b, "[stopIndependentAIInterpretation] start, meetingId=" + lvb.a.d(r13) + ", target=" + r9.a);
        MmStandaloneAIInterpretationRootRepo r14 = this.a.h();
        if (r14 == null) goto L33;
        MmStandaloneAIInterpretationRepo r15 = r14.a();
        if (r15 == null) goto L33;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.a r16 = r15.t();
        if (r16 == null) goto L33;
        r0.L$0 = r9;
        r0.label = 2;
        r11 = r16.f0(r13, r9, r0);
        if (r11 != r2) goto L32;
        return r2;
    L33:
        r12 = null;
        goto L34
    L16:
        ResultKt.throwOnFailure(r11);
        MmRecordingSession r17 = this.a;
        r0.L$0 = r9;
        r0.label = 1;
        r11 = r17.r(r0);
        if (r11 != r2) goto L19;
        return r2;
    L7:
        r0 = new MmStandaloneAIInterpretationStateHandler$stopIndependentAIInterpretationSync$1(this, r10);
        goto L8
    }

    public static final Object c(MmStandaloneAIInterpretationStateHandler r7, MinutesRecordingStartResponse r8, Continuation r9) {
        r7.getClass();
        if ((r9 instanceof MmStandaloneAIInterpretationStateHandler$initRtcAndStartJoinRoom$1) == false) goto L7;
        MmStandaloneAIInterpretationStateHandler$initRtcAndStartJoinRoom$1 r0 = (MmStandaloneAIInterpretationStateHandler$initRtcAndStartJoinRoom$1) r9;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L18;
        if (r3 == 1) goto L17;
        if (r3 == 2) goto L16;
        if (r3 != 3) goto L15;
        ResultKt.throwOnFailure(r10);
    L46:
        return Boxing.boxBoolean(false);
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r10);
    L45:
        return Boxing.boxBoolean(false);
    L17:
        ResultKt.throwOnFailure(r10);
        Object r11 = ((Result) r10).unbox-impl();
    L21:
        Throwable r12 = Result.exceptionOrNull-impl(r11);
        if (r12 == null) goto L28;
        lvb.a.b(r7.b, "audioService init failed: " + r12);
        TerminateReason r13 = TerminateReason.RTC_INIT_FAILED;
        r0.label = 2;
        if (r7.f(r13, true, r0) != r2) goto L45;
        return r2;
    L28:
        if (Result.isFailure-impl(r11) == false) goto L31;
        r11 = null;
    L31:
        if (Intrinsics.areEqual(r11, Boxing.boxBoolean(true)) == true) goto L36;
        lvb.a.b(r7.b, "[initRtcAndStartJoinRoom] audioService init returned false");
        TerminateReason r14 = TerminateReason.RTC_INIT_FAILED;
        r0.label = 3;
        if (r7.f(r14, true, r0) != r2) goto L46;
        return r2;
    L36:
        MmStandaloneAIInterpretationRootRepo r15 = r7.a.h();
        if (r15 == null) goto L43;
        MmStandaloneAIInterpretationRepo r16 = r15.a();
        if (r16 == null) goto L43;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.a r17 = r16.t();
        if (r17 == null) goto L43;
        r17.J0();
    L43:
        MmRecordingAudioService r18 = r7.d;
        lvb.a.e(r18.e, "[joinChannel] start");
        r18.x.g(r18.t);
        return Boxing.boxBoolean(true);
    L18:
        ResultKt.throwOnFailure(r10);
        MmRecordingAudioService r19 = r7.d;
        r0.label = 1;
        r11 = r19.f(r8, r0);
        if (r11 != r2) goto L21;
        return r2;
    L7:
        r0 = new MmStandaloneAIInterpretationStateHandler$initRtcAndStartJoinRoom$1(r7, r9);
        goto L8
    }

    public static final Object d(MmStandaloneAIInterpretationStateHandler r6, String r7, Continuation r8) {
        r6.getClass();
        if ((r8 instanceof MmStandaloneAIInterpretationStateHandler$startIndependentAIInterpretation$1) == false) goto L7;
        MmStandaloneAIInterpretationStateHandler$startIndependentAIInterpretation$1 r0 = (MmStandaloneAIInterpretationStateHandler$startIndependentAIInterpretation$1) r8;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r4 = true;
        String r5 = null;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r9);
    L23:
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.g r10 = (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.g) r9;
    L25:
        String r11 = r6.b;
        StringBuilder r12 = new StringBuilder("[startIndependentAIInterpretation] result, status=");
        if (r10 == null) goto L28;
        Integer r13 = Boxing.boxInt(r10.b);
    L29:
        r12.append(r13);
        r12.append(", accepted=");
        if (r10 == null) goto L32;
        Boolean r14 = Boxing.boxBoolean(r10.a());
    L33:
        r12.append(r14);
        r12.append(", channel=");
        if (r10 == null) goto L36;
        String r15 = r10.a;
    L37:
        r12.append(r15);
        r12.append(", target=");
        if (r10 == null) goto L42;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r16 = r10.h;
        if (r16 == null) goto L42;
        r5 = r16.a;
    L42:
        r12.append(r5);
        lvb.a.e(r11, r12.toString());
        if (r10 != null) goto L45;
    L47:
        boolean r17 = false;
    L48:
        if (r17 == true) goto L58;
        if (r10 != null) goto L51;
    L53:
        boolean r18 = false;
    L54:
        if (r18 == true) goto L58;
        r4 = false;
        goto L58
    L51:
        if (r10.b != 2) goto L53;
        r18 = true;
    L58:
        return Boxing.boxBoolean(r4);
    L45:
        if (r10.b != 1) goto L47;
        r17 = true;
        goto L48
    L36:
        r15 = null;
        goto L37
    L32:
        r14 = null;
        goto L33
    L28:
        r13 = null;
        goto L29
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r9);
        lvb.a.e(r6.b, "[startIndependentAIInterpretation] start, meetingId=" + lvb.a.d(r7));
        MmStandaloneAIInterpretationRootRepo r19 = r6.a.h();
        if (r19 == null) goto L24;
        MmStandaloneAIInterpretationRepo r20 = r19.a();
        if (r20 == null) goto L24;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.a r21 = r20.t();
        if (r21 == null) goto L24;
        r0.label = 1;
        r9 = r21.c0(r7, null, r0);
        if (r9 != r2) goto L23;
        return r2;
    L24:
        r10 = null;
    L7:
        r0 = new MmStandaloneAIInterpretationStateHandler$startIndependentAIInterpretation$1(r6, r8);
        goto L8
    }

    public final Object f(TerminateReason r6, boolean r7, Continuation<? super Unit> r8) {
        if ((r8 instanceof MmStandaloneAIInterpretationStateHandler$cleanupCreatedSessionAndTerminate$1) == false) goto L7;
        MmStandaloneAIInterpretationStateHandler$cleanupCreatedSessionAndTerminate$1 r0 = (MmStandaloneAIInterpretationStateHandler$cleanupCreatedSessionAndTerminate$1) r8;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        r6 = (TerminateReason) r0.L$0;
        ResultKt.throwOnFailure(r9);
    L24:
        this.a.u(new com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.a.n(r6));
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r6 = (TerminateReason) r0.L$0;
        ResultKt.throwOnFailure(r9);
    L21:
        this.d.h();
        r0.L$0 = r6;
        r0.label = 2;
        if (g(r0) != r2) goto L24;
        return r2;
    L16:
        ResultKt.throwOnFailure(r9);
        if (r7 == false) goto L21;
        r0.L$0 = r6;
        r0.label = 1;
        if (i(h(), r0) != r2) goto L21;
        return r2;
    L7:
        r0 = new MmStandaloneAIInterpretationStateHandler$cleanupCreatedSessionAndTerminate$1(this, r8);
        goto L8
    }
}
