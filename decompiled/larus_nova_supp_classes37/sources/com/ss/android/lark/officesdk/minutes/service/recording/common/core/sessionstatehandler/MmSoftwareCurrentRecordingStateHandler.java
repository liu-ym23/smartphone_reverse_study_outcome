package com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler;

import com.bytedance.lark.pb.basic.v1.Command;
import com.google.gson.Gson;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.EndRecordingReason;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.api.recording.common.depend.feature.MmOfficeSdkFeature;
import com.ss.android.lark.officesdk.minutes.api.recording.doubao.DoubaoBizInfo;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSession;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.data.TerminateReason;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.MinutesForegroundService;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.MmRecordingAudioService;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync.MmRecordingStatesSyncService;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.upload.MmRecordingUploadService;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.MmRecordingRepo;
import com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.MmRecordingCommonParam;
import com.ss.android.lark.pb.minutes.v1.MinutesRecordingPushTerminated;
import com.ss.android.lark.pb.minutes.v1.MinutesRecordingStartResponse;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.e0;
import iub.k;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.d1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MmSoftwareCurrentRecordingStateHandler extends f {
    public static final Companion o = null;
    public final String b;
    public final com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a c;
    public final MmRecordingAudioService d;
    public final MmRecordingUploadService e;
    public final MmRecordingStatesSyncService f;
    public final Lazy g;
    public final Lazy h;
    public Job i;
    public volatile MinutesRecordingStartResponse j;
    public boolean k;
    public final DoubaoBizInfo l;
    public final boolean m;
    public final a n;

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler.MmSoftwareCurrentRecordingStateHandler$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler.MmSoftwareCurrentRecordingStateHandler$1", f = "MmSoftwareCurrentRecordingStateHandler.kt", i = {}, l = {110}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ MmRecordingSession $recordingSession;
        int label;
        final /* synthetic */ MmSoftwareCurrentRecordingStateHandler this$0;

        /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler.MmSoftwareCurrentRecordingStateHandler$1$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ MmSoftwareCurrentRecordingStateHandler a;
            public final /* synthetic */ MmRecordingSession b;

            public a(MmSoftwareCurrentRecordingStateHandler r1, MmRecordingSession r2) {
                this.a = r1;
                this.b = r2;
            }

            public final Object emit(Object r3, Continuation r4) {
                MinutesRecordingPushTerminated r5 = (MinutesRecordingPushTerminated) r3;
                lvb.a.e(this.a.b, "pushTerminated, push meetingId: " + r5.session_id + ", current: " + this.b.w.a);
                if (Intrinsics.areEqual(r5.session_id, this.b.w.a) == false) goto L6;
                this.b.u(new com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.a.k(EndRecordingReason.MEETING_PUSH_TERMINATED));
            L6:
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass1(MmSoftwareCurrentRecordingStateHandler r1, MmRecordingSession r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$recordingSession = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.this$0, this.$recordingSession, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            ResultKt.throwOnFailure(r6);
        L12:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            d1 r7 = this.this$0.c.Q().b(Command.MINUTES_RECORDING_PUSH_TERMINATED, MinutesRecordingPushTerminated.class);
            a r2 = new a(this.this$0, this.$recordingSession);
            this.label = 1;
            if (r7.collect(r2, this) != r0) goto L12;
            return r0;
        }
    }

    public static final class Companion {
        public Companion() {
        }

        public final Object a(Function1<? super Continuation<? super String>, ? extends Object> r5, Function1<? super Throwable, Unit> r6, Continuation<? super String> r7) {
            if ((r7 instanceof MmSoftwareCurrentRecordingStateHandler$Companion$awaitRecordingIdForUpload$1) == false) goto L7;
            MmSoftwareCurrentRecordingStateHandler$Companion$awaitRecordingIdForUpload$1 r0 = (MmSoftwareCurrentRecordingStateHandler$Companion$awaitRecordingIdForUpload$1) r7;
            int r1 = r0.label;
            if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
            r0.label = r1 - Integer.MIN_VALUE;
        L8:
            Object r8 = r0.result;
            Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r3 = r0.label;
            if (r3 == 0) goto L16;
            if (r3 != 1) goto L15;
            r6 = (Function1) r0.L$0;
            ResultKt.throwOnFailure(r8);     // Catch: Throwable -> L22
        L20:
            return (String) r8;
        L15:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L16:
            ResultKt.throwOnFailure(r8);
            r0.L$0 = r6;     // Catch: Throwable -> L22
            r0.label = 1;     // Catch: Throwable -> L22
            r8 = r5.invoke(r0);     // Catch: Throwable -> L22
            if (r8 != r2) goto L20;
            return r2;
        L22:
            th = move-exception;
            if ((th instanceof CancellationException) == true) goto L27;
            r6.invoke(th);
            return null;
        L27:
            throw th;
        L7:
            r0 = new MmSoftwareCurrentRecordingStateHandler$Companion$awaitRecordingIdForUpload$1(this, r7);
            goto L8
        }
    }

    static {
        o = new Companion();
    }

    public static String f() {
        LarkAppContext.Companion.getClass();
        if (LarkAppContext.access$getInstance$cp().buildConfig().isLarkApp() == false) goto L5;
        String r0 = UIHelper.getString(2131892471);
        Intrinsics.checkNotNull(r0);
        return r0;
    L5:
        String r1 = UIHelper.getString(2131889394);
        Intrinsics.checkNotNull(r1);
        return r1;
    }

    public MmSoftwareCurrentRecordingStateHandler(final MmRecordingSession r11) {
        Intrinsics.checkNotNullParameter(r11, "recordingSession");
        super(r11);
        this.b = "MmCurrentRecordingHandler";
        com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r1 = r11.b;
        this.c = r1;
        MmRecordingAudioService r2 = r11.a();
        if (r2 == null) goto L39;
        this.d = r2;
        this.e = r11.k();
        this.f = r11.i();
        this.g = LazyKt.lazy(new MmSoftwareCurrentRecordingStateHandler$networkService$2(this));
        this.h = LazyKt.lazy(new MmSoftwareCurrentRecordingStateHandler$meetingCreateFailureHandler$2(this));
        int r3 = com.ss.android.lark.officesdk.minutes.service.foundation.feature.b.a;
        com.ss.android.lark.officesdk.minutes.service.foundation.feature.a r4 = r1.getFeatureService();
        k r5 = r11.f;
        DoubaoBizInfo r6 = null;
        if (r5 == null) goto L7;
        MmRecordingSource r7 = r5.a;
    L8:
        Intrinsics.checkNotNullParameter(r4, "featureService");
        if (r7 != null) goto L11;
        int r8 = -1;
    L12:
        boolean r9 = false;
        if (r8 != 1) goto L15;
    L19:
        boolean r10 = true;
    L20:
        if (r10 == true) goto L22;
    L24:
        this.m = r9;
        this.n = new a(new MmSoftwareCurrentRecordingStateHandler$phoneStateHelper$1(this, r11));
        BuildersKt.launch$default(r11.v, null, null, new AnonymousClass1(this, r11, null), 3, null);
        k r12 = this.a.f;
        if (r12 == null) goto L28;
        Map<String, Object> r13 = r12.b;
        if (r13 == null) goto L28;
    L29:
        Object r14 = r13.get("doubao_biz_info");
        if ((r14 instanceof String) == false) goto L32;
        String r15 = (String) r14;
    L33:
        if (r15 != null) goto L35;
        lvb.a.b("MmCurrentRecordingHandler", "buildDoubaoBizInfo, doubaoBizInfoJson is null");
    L36:
        this.l = r6;
        return;
    L35:
        Gson r16 = e0.a;
        r6 = (DoubaoBizInfo) e0.a(r15, DoubaoBizInfo.class);
        lvb.a.e("MmCurrentRecordingHandler", "buildDoubaoBizInfo, " + r6);
        goto L36
    L32:
        r15 = null;
    L28:
        r13 = MapsKt.emptyMap();
        goto L29
    L22:
        if (r4.h(MmOfficeSdkFeature.RecordingStartForegroundService) == false) goto L24;
        r9 = true;
        goto L24
    L15:
        if (r8 == 2) goto L19;
        if (r8 == 3) goto L19;
        r10 = false;
        goto L20
    L11:
        r8 = com.ss.android.lark.officesdk.minutes.service.foundation.feature.b.a.a[r7.ordinal()];
        goto L12
    L7:
        r7 = null;
        goto L8
    L39:
        throw new IllegalStateException("audioService required for software recording session");
    }

    public static final void d(MmSoftwareCurrentRecordingStateHandler r8, String r9) {
        Job r0 = r8.i;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        r8.i = BuildersKt.launch$default(r8.a.u, null, null, new MmSoftwareCurrentRecordingStateHandler$startUpload$1(r8, r9, null), 3, null);
    }

    public static final Object e(MmSoftwareCurrentRecordingStateHandler r4, Continuation r5) {
        r4.getClass();
        if ((r5 instanceof MmSoftwareCurrentRecordingStateHandler$trackRecordUploadMinutesCreateStatus$1) == false) goto L7;
        MmSoftwareCurrentRecordingStateHandler$trackRecordUploadMinutesCreateStatus$1 r0 = (MmSoftwareCurrentRecordingStateHandler$trackRecordUploadMinutesCreateStatus$1) r5;
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
        int r10 = com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.c.n;
        r7.getClass();
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.c.j(r9, r8, "record");
    L22:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r6);
        int r11 = com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.c.n;
        MmRecordingSession r12 = r4.a;
        String r13 = com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.c.a.a(r12.a, r12.f);
        if (r13 == null) goto L22;
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.c r14 = r4.c.N();
        MmRecordingSession r15 = r4.a;
        r0.L$0 = r13;
        r0.L$1 = r14;
        r0.label = 1;
        Object r16 = r15.r(r0);
        if (r16 == r2) goto L23;
        r8 = r13;
        r6 = r16;
        r7 = r14;
        goto L20
    L23:
        return r2;
    L7:
        r0 = new MmSoftwareCurrentRecordingStateHandler$trackRecordUploadMinutesCreateStatus$1(r4, r5);
        goto L8
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler.f
    public final void a(com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c r14, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c r15) {
        Intrinsics.checkNotNullParameter(r14, "oldState");
        Intrinsics.checkNotNullParameter(r15, "newState");
        lvb.a.e(this.b, "onStateChanged: " + r14 + " -> " + r15);
        com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.C0037c r0 = com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.C0037c.c;
        MmRecordingSource r5 = null;
        if (Intrinsics.areEqual(r15, r0) == false) goto L9;
        if (this.m == false) goto L7;
        String r9 = f();
        String r10 = UIHelper.getString(2131893511);
        MinutesForegroundService.ForegroundServiceType r16 = MinutesForegroundService.ForegroundServiceType.RECORDING;
        Intrinsics.checkNotNullParameter(r9, "title");
        Intrinsics.checkNotNullParameter(r10, "content");
        Intrinsics.checkNotNullParameter(r16, "foregroundServiceType");
        MinutesForegroundService.Companion r17 = MinutesForegroundService.h;
        MinutesForegroundService.Companion.h(LarkContext.getApplication(), this.c.A(), null, r9, r10, true, 76);
    L7:
        this.d.k();
        BuildersKt.launch$default(this.a.v, null, null, new MmSoftwareCurrentRecordingStateHandler$createMinutesRecordingAndInitAudioService$1(this, null), 3, null);
        return;
    L9:
        if (Intrinsics.areEqual(r15, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.l.c) == false) goto L11;
        BuildersKt.launch$default(this.a.v, null, null, new MmSoftwareCurrentRecordingStateHandler$onStateChanged$1(this, null), 3, null);
        return;
    L11:
        boolean r6 = true;
        boolean r7 = false;
        if (Intrinsics.areEqual(r15, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.k.c) == false) goto L26;
        this.d.l();
        k r1 = this.a.f;
        if (r1 == null) goto L17;
        r5 = r1.a;
    L17:
        if (r5 == MmRecordingSource.FEISHU) goto L20;
        r6 = false;
    L20:
        if (r6 == false) goto L22;
        this.n.b();
    L22:
        String r8 = f();
        String r11 = UIHelper.getString(2131892869);
        MinutesForegroundService.ForegroundServiceType r2 = MinutesForegroundService.ForegroundServiceType.RECORDING;
        Intrinsics.checkNotNullParameter(r8, "title");
        Intrinsics.checkNotNullParameter(r11, "content");
        Intrinsics.checkNotNullParameter(r2, "foregroundServiceType");
        MinutesForegroundService.Companion r3 = MinutesForegroundService.h;
        MinutesForegroundService.Companion.k(LarkContext.getApplication(), r8, r11, this.c.A(), null, 112);
        if (Intrinsics.areEqual(r14, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.h.c) == false) goto L70;
        this.f.F(r15);
        return;
    L70:
        return;
    L26:
        if (Intrinsics.areEqual(r15, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.h.c) == false) goto L29;
        this.d.m();
        String r12 = f();
        String r13 = UIHelper.getString(2131892872);
        MinutesForegroundService.ForegroundServiceType r18 = MinutesForegroundService.ForegroundServiceType.RECORDING;
        Intrinsics.checkNotNullParameter(r12, "title");
        Intrinsics.checkNotNullParameter(r13, "content");
        Intrinsics.checkNotNullParameter(r18, "foregroundServiceType");
        MinutesForegroundService.Companion r19 = MinutesForegroundService.h;
        MinutesForegroundService.Companion.k(LarkContext.getApplication(), r12, r13, this.c.A(), null, 112);
        this.f.F(r15);
        return;
    L29:
        if ((r15 instanceof com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.b) == false) goto L44;
        k r110 = this.a.f;
        if (r110 == null) goto L33;
        MmRecordingSource r111 = r110.a;
    L35:
        if (r111 != MmRecordingSource.FEISHU) goto L37;
        r7 = true;
    L37:
        if (r7 == false) goto L39;
        this.n.c();
    L39:
        MmRecordingRepo r112 = this.a.f();
        if (r112 == null) goto L42;
        r112.f();
    L42:
        this.d.h();
        BuildersKt.launch$default(this.a.u, null, null, new MmSoftwareCurrentRecordingStateHandler$leaveMeeting$1(this, null), 3, null);
        CoroutineScopeKt.cancel$default(this.a.v, null, 1, null);
        this.f.F(r15);
        BuildersKt.launch$default(this.a.u, null, null, new MmSoftwareCurrentRecordingStateHandler$onStateChanged$2(this, null), 3, null);
        return;
    L33:
        r111 = null;
        goto L35
    L44:
        if (Intrinsics.areEqual(r15, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.i.c) == false) goto L58;
        MmRecordingSession r113 = this.a;
        final ovb.b r114 = r113.w;
        if (r113.v() == false) goto L49;
        r6 = this.f.t();
    L52:
        MmSoftwareCurrentRecordingStateHandler$onStateChanged$3 r115 = new MmSoftwareCurrentRecordingStateHandler$onStateChanged$3(this.e);
        Function0<Unit> r4 = new MmSoftwareCurrentRecordingStateHandler$onStateChanged$4(this, r114);
        Intrinsics.checkNotNullParameter(r115, "onReady");
        Intrinsics.checkNotNullParameter(r4, "onRecover");
        if (r6 == false) goto L55;
        r115.invoke();
    L56:
        String r20 = UIHelper.getString(2131889394);
        String r21 = UIHelper.getString(2131892843);
        MinutesForegroundService.ForegroundServiceType r116 = MinutesForegroundService.ForegroundServiceType.RECORDING;
        Intrinsics.checkNotNullParameter(r20, "title");
        Intrinsics.checkNotNullParameter(r21, "content");
        Intrinsics.checkNotNullParameter(r116, "foregroundServiceType");
        MinutesForegroundService.Companion r117 = MinutesForegroundService.h;
        MinutesForegroundService.Companion.k(LarkContext.getApplication(), r20, r21, this.c.A(), null, 112);
        return;
    L55:
        r4.invoke();
        goto L56
    L49:
        if (r114.d.length() > 0) goto L52;
        r6 = false;
        goto L52
    L58:
        if (Intrinsics.areEqual(r15, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.n.c) == false) goto L61;
        this.e.k();
        BuildersKt.launch$default(this.a.u, null, null, new MmSoftwareCurrentRecordingStateHandler$onStateChanged$5(this, null), 3, null);
        return;
    L61:
        if ((r15 instanceof com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.m) == true) goto L63;
        return;
    L63:
        if (this.m == true) goto L65;
        return;
    L65:
        if (Intrinsics.areEqual(r14, r0) == false) goto L78;
        lvb.a.e(this.b, "recording start failed, stop starting foreground service");
        this.c.A().g();
        return;
    }

    public static final Object c(MmSoftwareCurrentRecordingStateHandler r5, MinutesRecordingStartResponse r6, Continuation r7) {
        r5.getClass();
        if ((r7 instanceof MmSoftwareCurrentRecordingStateHandler$initRtcAndJoinRoom$1) == false) goto L7;
        MmSoftwareCurrentRecordingStateHandler$initRtcAndJoinRoom$1 r0 = (MmSoftwareCurrentRecordingStateHandler$initRtcAndJoinRoom$1) r7;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L15;
        if (r3 != 1) goto L14;
        ResultKt.throwOnFailure(r8);     // Catch: Throwable -> L21
        Object r9 = ((Result) r8).unbox-impl();     // Catch: Throwable -> L21
    L34:
    L23:
        Throwable r10 = Result.exceptionOrNull-impl(r9);
        if (r10 == null) goto L26;
        lvb.a.b(r5.b, "audioService init failed: " + r10);
        r5.a.u(new com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.a.n(TerminateReason.RTC_INIT_FAILED));
        return Boxing.boxBoolean(false);
    L26:
        if (((Boolean) r9).booleanValue() == true) goto L28;
        lvb.a.b(r5.b, "audioService init failed: result is false");
        r5.a.u(new com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.a.n(TerminateReason.RTC_INIT_FAILED));
        return Boxing.boxBoolean(false);
    L28:
        lvb.a.e(r5.b, "audioService init success");
        com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c r11 = r5.a.g();
        if (Intrinsics.areEqual(r11, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.l.c) == true) goto L31;
        lvb.a.e(r5.b, "skip join room, current state=" + r11);
        return Boxing.boxBoolean(false);
    L31:
        MmRecordingAudioService r12 = r5.d;
        lvb.a.e(r12.e, "[joinChannel] start");
        r12.x.g(r12.t);
        return Boxing.boxBoolean(true);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r8);
        if (r6 != null) goto L18;
        lvb.a.b(r5.b, "audioService init failed: recording start response is null");
        r5.a.u(new com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.a.n(TerminateReason.RTC_INIT_FAILED));
        return Boxing.boxBoolean(false);
    L18:
        MmRecordingAudioService r13 = r5.d;     // Catch: Throwable -> L21
        r0.label = 1;     // Catch: Throwable -> L21
        r9 = r13.f(r6, r0);     // Catch: Throwable -> L21
        if (r9 != r2) goto L34;
        return r2;
    L21:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r0 = new MmSoftwareCurrentRecordingStateHandler$initRtcAndJoinRoom$1(r5, r7);
        goto L8
    }
}
