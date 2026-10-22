package com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler;

import com.google.gson.Gson;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingCreateMode;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingError;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.api.recording.doubao.DoubaoBizInfo;
import com.ss.android.lark.officesdk.minutes.service.fileupload.MmMinutesFileUploadSessionManager;
import com.ss.android.lark.officesdk.minutes.service.foundation.utils.cache.file.MmRecordFileHelper;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSession;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.data.MmRecordingAudioCaptureMode;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.data.RecordingSessionType;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.data.TerminateReason;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.MmExternalAudioCapturePipeline;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.MmRecordingAudioService;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync.MmRecordingStatesSyncService;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.upload.MmRecordingUploadService;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.upload.MmRecordingUploadTask;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.MmRecordingRepo;
import com.ss.android.lark.pb.minutes.v1.MinutesRecordingStartResponse;
import com.ss.android.lark.utils.e0;
import com.ss.android.lark.vfs.VFSFile;
import iub.j;
import iub.k;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MmPreMeetingNativeRecordingStateHandler extends f {
    public final boolean b;
    public final String c;
    public final com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a d;
    public final MmRecordingAudioService e;
    public final MmRecordingUploadService f;
    public final MmRecordingStatesSyncService g;
    public final Lazy h;
    public final Lazy i;
    public Job j;
    public Job k;
    public boolean l;
    public iub.a<j, ? super MmRecordingError> m;
    public boolean n;
    public boolean o;
    public boolean p;
    public boolean q;
    public boolean r;
    public DoubaoBizInfo s;
    public MinutesRecordingStartResponse t;
    public boolean u;
    public boolean v;

    public final void j() {
        if (this.l == false) goto L6;
        lvb.a.e(this.c, "[createMeetingAsync] ignored, already creating");
        return;
    L6:
        this.q = true;
        this.l = true;
        BuildersKt.launch$default(this.a.v, null, null, new MmPreMeetingNativeRecordingStateHandler$createMeetingAsync$1(this, null), 3, null);
    }

    public final void l() {
        Job r0 = this.k;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        if (r1 == false) goto L10;
        lvb.a.e(this.c, "[registerTerminatedPushIfNeeded] already registered");
        return;
    L10:
        this.k = BuildersKt.launch$default(this.a.v, null, null, new MmPreMeetingNativeRecordingStateHandler$registerTerminatedPushIfNeeded$1(this, null), 3, null);
        return;
    L5:
        if (r0.isActive() != true) goto L7;
        r1 = true;
        goto L7
    }

    public final void n() {
        ovb.b r0 = this.a.w;
        String r1 = r0.g;
        if (StringsKt.isBlank(r1) == false) goto L6;
        lvb.a.h(this.c, "[offlineIndex] skip, sessionKey is blank");
        return;
    L6:
        Long r2 = Long.valueOf(r0.b);
        if (r2.longValue() <= 0) goto L9;
        boolean r3 = true;
    L10:
        String r4 = null;
        if (r3 == true) goto L14;
        r2 = null;
    L14:
        if (r2 == null) goto L16;
        long r5 = r2.longValue();
    L17:
        k r6 = this.a.f;
        if (r6 == null) goto L28;
        Map<String, Object> r7 = r6.b;
        if (r7 == null) goto L28;
        Object r8 = r7.get("hardware_device_id");
        if (r8 == null) goto L28;
        String r9 = r8.toString();
        if (r9 == null) goto L28;
        if ((!StringsKt.isBlank(r9)) == false) goto L28;
        r4 = r9;
    L28:
        if (r4 != null) goto L30;
        r4 = "";
    L30:
        this.g.w(r1, r5, r4);
        k r10 = this.a.f;
        if (r10 == null) goto L36;
        MmRecordingSource r11 = r10.a;
        if (r11 == null) goto L37;
        this.g.A(r1, r11);
        return;
    L37:
        return;
    L36:
        return;
    L16:
        r5 = System.currentTimeMillis();
        goto L17
    L9:
        r3 = false;
        goto L10
    }

    public MmPreMeetingNativeRecordingStateHandler(MmRecordingSession r5) {
        Intrinsics.checkNotNullParameter(r5, "recordingSession");
        super(r5);
        this.b = true;
        this.c = "MmPreMeetingNativeHandler";
        this.d = r5.b;
        this.e = r5.a();
        this.f = r5.k();
        this.g = r5.i();
        this.h = LazyKt.lazy(new MmPreMeetingNativeRecordingStateHandler$networkService$2(this));
        this.i = LazyKt.lazy(new MmPreMeetingNativeRecordingStateHandler$onlinePreChecker$2(this));
        k r6 = r5.f;
        DoubaoBizInfo r2 = null;
        if (r6 == null) goto L5;
        MmRecordingCreateMode r7 = r6.f;
    L7:
        if (r7 != MmRecordingCreateMode.OFFLINE_LOCAL) goto L9;
        boolean r8 = true;
    L10:
        this.u = r8;
        if (r8 == true) goto L16;
        if (com.ss.android.lark.officesdk.minutes.service.foundation.utils.net.c.a() == false) goto L16;
        this.u = true;
        lvb.a.h("MmPreMeetingNativeHandler", "[offlineMode] enabled_by_fallback reason=no_network_at_init");
    L19:
        if (this.u == true) goto L21;
        l();
    L21:
        k r9 = this.a.f;
        if (r9 == null) goto L25;
        Map<String, Object> r10 = r9.b;
        if (r10 == null) goto L25;
    L26:
        Object r11 = r10.get("doubao_biz_info");
        if ((r11 instanceof String) == false) goto L29;
        String r12 = (String) r11;
    L30:
        if (r12 != null) goto L32;
        lvb.a.b("MmPreMeetingNativeHandler", "buildDoubaoBizInfo, doubaoBizInfoJson is null");
    L33:
        this.s = r2;
        return;
    L32:
        Gson r0 = e0.a;
        r2 = (DoubaoBizInfo) e0.a(r12, DoubaoBizInfo.class);
        lvb.a.e("MmPreMeetingNativeHandler", "buildDoubaoBizInfo, " + r2);
        goto L33
    L29:
        r12 = null;
    L25:
        r10 = MapsKt.emptyMap();
    L16:
        if (this.u == false) goto L19;
        lvb.a.e("MmPreMeetingNativeHandler", "[offlineMode] enabled_by_context");
        goto L19
    L9:
        r8 = false;
        goto L10
    L5:
        r7 = null;
        goto L7
    }

    public final Object i(Continuation<? super Unit> r9) {
        if ((r9 instanceof MmPreMeetingNativeRecordingStateHandler$cleanupUnboundOfflineLocalPartsIfNeeded$1) == false) goto L7;
        MmPreMeetingNativeRecordingStateHandler$cleanupUnboundOfflineLocalPartsIfNeeded$1 r0 = (MmPreMeetingNativeRecordingStateHandler$cleanupUnboundOfflineLocalPartsIfNeeded$1) r9;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r4 = true;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        boolean r5 = r0.Z$0;
        String r6 = (String) r0.L$0;
        ResultKt.throwOnFailure(r10);
    L38:
        boolean r11 = ((Boolean) r10).booleanValue();
        lvb.a.e(this.c, "[cleanupUnboundOfflineLocalPartsIfNeeded] sessionKey=" + r6 + ", isD1204=" + r5 + ", deleted=" + r11);
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r10);
    L19:
        ovb.b r12 = (ovb.b) r10;
        String r7 = r12.g;
        String r13 = r12.a;
        if (StringsKt.isBlank(r7) == false) goto L22;
    L40:
        lvb.a.e(this.c, "[cleanupUnboundOfflineLocalPartsIfNeeded] skip, sessionKey=" + r7 + ", meetingId=" + r13);
        return Unit.INSTANCE;
    L22:
        if ((!StringsKt.isBlank(r13)) == true) goto L40;
        MmRecordFileHelper.a.getClass();
        Intrinsics.checkNotNullParameter(r7, "recordingId");
        boolean r14 = StringsKt.startsWith$default(r7, "native_local_", false, 2, null);
        k r8 = this.a.f;
        if (r8 != null) goto L27;
    L29:
        r4 = false;
    L30:
        if (r14 == true) goto L34;
        if (r4 == true) goto L34;
        lvb.a.e(this.c, "[cleanupUnboundOfflineLocalPartsIfNeeded] skip unsupported sessionKey=".concat(r7));
        return Unit.INSTANCE;
    L34:
        String r15 = this.d.getCurrentUserId();
        r0.L$0 = r7;
        r0.Z$0 = r4;
        r0.label = 2;
        r10 = MmRecordFileHelper.c(r15, r7, r0);
        if (r10 != r2) goto L37;
        return r2;
    L37:
        r6 = r7;
        r5 = r4;
        goto L38
    L27:
        if (r8.a != MmRecordingSource.FEISHU_HARDWARE_D1204) goto L29;
    L16:
        ResultKt.throwOnFailure(r10);
        MmRecordingSession r16 = this.a;
        r0.label = 1;
        r10 = r16.r(r0);
        if (r10 != r2) goto L19;
        return r2;
    L7:
        r0 = new MmPreMeetingNativeRecordingStateHandler$cleanupUnboundOfflineLocalPartsIfNeeded$1(this, r9);
        goto L8
    }

    public final MmRecordingAudioService k(String r4) {
        MmRecordingAudioService r0 = this.e;
        if (r0 != null) goto L9;
        lvb.a.b(this.c, "audioService is null, terminate session. from=" + r4);
        if (this.n == true) goto L7;
        this.n = true;
        this.a.m(MmRecordingError.InternalError.INSTANCE);
        this.a.u(new com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.a.n(TerminateReason.OTHERS));
    L7:
        return null;
    L9:
        return r0;
    }

    public static final void c(MmPreMeetingNativeRecordingStateHandler r3, MmRecordingError r4) {
        lvb.a.b(r3.c, "[consumeRetryError] error=" + r4 + ", pendingRetryCallback=" + r3.m);
        iub.a<j, ? super MmRecordingError> r0 = r3.m;
        if (r0 == null) goto L5;
        r0.a(r4);
    L5:
        r3.m = null;
        r3.p = false;
    }

    public static final Object d(MmPreMeetingNativeRecordingStateHandler r8, Continuation r9) {
        r8.getClass();
        if ((r9 instanceof MmPreMeetingNativeRecordingStateHandler$copyRecordingDirToMeetingIdIfNeeded$1) == false) goto L7;
        MmPreMeetingNativeRecordingStateHandler$copyRecordingDirToMeetingIdIfNeeded$1 r0 = (MmPreMeetingNativeRecordingStateHandler$copyRecordingDirToMeetingIdIfNeeded$1) r9;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        String r4 = (String) r0.L$1;
        String r5 = (String) r0.L$0;
        ResultKt.throwOnFailure(r10);
    L34:
        if (((Boolean) r10).booleanValue() == false) goto L41;
        lvb.a.e(r8.c, "[copyRecordingDirToMeetingIdIfNeeded] success, save source session mapping, meetingId=" + r4 + ", sessionKey=" + r5);
        r8.g.C(r4, r5);
        r8.g.z(r5, r4);
        k r11 = r8.a.f;
        if (r11 == null) goto L40;
        MmRecordingSource r12 = r11.a;
        if (r12 == null) goto L40;
        r8.g.A(r4, r12);
        r8.g.A(r5, r12);
    L40:
        r8.g.B(r4, r8.a.c);
    L46:
        return Unit.INSTANCE;
    L41:
        lvb.a.b(r8.c, "[copyRecordingDirToMeetingIdIfNeeded] failed, sessionKey=" + r5 + ", meetingId=" + r4);
        goto L46
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r10);
    L19:
        ovb.b r13 = (ovb.b) r10;
        String r6 = r13.g;
        String r14 = r13.a;
        if (StringsKt.isBlank(r6) == false) goto L22;
    L43:
        lvb.a.e(r8.c, "[copyRecordingDirToMeetingIdIfNeeded] skip, sessionKey=" + r6 + ", meetingId=" + r14);
        return Unit.INSTANCE;
    L22:
        if (StringsKt.isBlank(r14) == true) goto L43;
        if (Intrinsics.areEqual(r6, r14) == true) goto L43;
        if (r8.o == false) goto L29;
        lvb.a.e(r8.c, "[copyRecordingDirToMeetingIdIfNeeded] skip, part dir already switched, sessionKey=" + r6 + ", meetingId=" + r14);
        return Unit.INSTANCE;
    L29:
        lvb.a.e(r8.c, "[copyRecordingDirToMeetingIdIfNeeded] start, sessionKey=" + r6 + ", meetingId=" + r14);
        MmRecordFileHelper r7 = MmRecordFileHelper.a;
        String r15 = r8.d.getCurrentUserId();
        r0.L$0 = r6;
        r0.L$1 = r14;
        r0.label = 2;
        r7.getClass();
        Object r16 = MmRecordFileHelper.a(r15, r6, r14, r0);
        if (r16 == r2) goto L48;
        r4 = r14;
        r10 = r16;
        r5 = r6;
        goto L34
    L48:
        return r2;
    L16:
        ResultKt.throwOnFailure(r10);
        MmRecordingSession r17 = r8.a;
        r0.label = 1;
        r10 = r17.r(r0);
        if (r10 != r2) goto L19;
        return r2;
    L7:
        r0 = new MmPreMeetingNativeRecordingStateHandler$copyRecordingDirToMeetingIdIfNeeded$1(r8, r9);
        goto L8
    }

    public static final void h(MmPreMeetingNativeRecordingStateHandler r8, String r9) {
        Job r0 = r8.j;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        r8.j = BuildersKt.launch$default(r8.a.u, null, null, new MmPreMeetingNativeRecordingStateHandler$startUpload$1(r8, r9, null), 3, null);
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler.f
    public final void a(com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c r11, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c r12) {
        Intrinsics.checkNotNullParameter(r11, "oldState");
        Intrinsics.checkNotNullParameter(r12, "newState");
        lvb.a.e(this.c, "onStateChanged: " + r11 + " -> " + r12 + ", isOfflineMode=" + this.u);
        StringBuilder r0 = new StringBuilder("onStateChanged:");
        r0.append(r12);
        MmRecordingAudioService r1 = k(r0.toString());
        if (r1 != null) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(r12, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.C0037c.c) == false) goto L9;
        BuildersKt.launch$default(this.a.v, null, null, new MmPreMeetingNativeRecordingStateHandler$generateSessionKeyAndInit$1(this, null), 3, null);
        return;
    L9:
        if (Intrinsics.areEqual(r12, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.j.c) == false) goto L11;
        BuildersKt.launch$default(this.a.v, null, null, new MmPreMeetingNativeRecordingStateHandler$initLocalRecordingEnvironment$1(this, null), 3, null);
        return;
    L11:
        com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.e r2 = com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.e.c;
        if (Intrinsics.areEqual(r12, r2) == false) goto L20;
        BuildersKt.launch$default(this.a.v, null, null, new MmPreMeetingNativeRecordingStateHandler$startLocalRecording$1(this, null), 3, null);
        if (this.u == false) goto L16;
        n();
    L16:
        this.a.u(com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.a.j.a);
        if (this.u == true) goto L117;
        j();
        return;
    L117:
        return;
    L20:
        if (Intrinsics.areEqual(r12, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.f.c) == false) goto L25;
        if (this.u == true) goto L119;
        j();
        return;
    L119:
        return;
    L25:
        if (Intrinsics.areEqual(r12, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.k.c) == false) goto L40;
        if (Intrinsics.areEqual(r11, r2) == false) goto L29;
        return;
    L29:
        if (Intrinsics.areEqual(r11, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.d.c) == false) goto L32;
        BuildersKt.launch$default(this.a.v, null, null, new MmPreMeetingNativeRecordingStateHandler$onStateChanged$1(r1, this, null), 3, null);
        return;
    L32:
        if (o(r1, "Recording:" + r11) == true) goto L35;
        return;
    L35:
        if (this.u == false) goto L37;
        return;
    L37:
        if (Intrinsics.areEqual(r11, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.h.c) == false) goto L124;
        this.g.F(r12);
        return;
    L124:
        return;
    L40:
        if (Intrinsics.areEqual(r12, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.h.c) == false) goto L44;
        r1.m();
        if (this.u == true) goto L126;
        this.g.F(r12);
        return;
    L126:
        return;
    L44:
        boolean r3 = false;
        if (Intrinsics.areEqual(r12, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.d.c) == false) goto L58;
        lvb.a.e(r1.e, "[interruptRtcTransmission]");
        MmExternalAudioCapturePipeline r13 = r1.F;
        if (r13 == null) goto L56;
        lvb.a.e("MmExternalAudioCapturePipeline", "detachRtcInput");
        r13.h();
        Object r14 = r13.m;
        monitor-enter(r14);
        r13.l = null;     // Catch: Throwable -> L53
        r13.r = new byte[0];     // Catch: Throwable -> L53
        r13.s.clear();     // Catch: Throwable -> L53
        r13.t = 0;     // Catch: Throwable -> L53
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L53
        monitor-exit(r14);
    L53:
        th = move-exception;
        throw th;
    L56:
        r1.x.h();
        r1.x.d();
        r1.z = false;
        r1.y = null;
        return;
    L58:
        if ((r12 instanceof com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.b) == false) goto L88;
        MmRecordingRepo r16 = this.a.f();
        if (r16 == null) goto L62;
        r16.f();
    L62:
        ovb.b r17 = this.a.w;
        if (r17.h == true) goto L65;
    L67:
        boolean r18 = false;
    L68:
        if (r18 == false) goto L70;
    L78:
        r1.h();
    L79:
        if (r18 == false) goto L81;
        BuildersKt.launch$default(this.a.u, null, null, new MmPreMeetingNativeRecordingStateHandler$leaveMeetingIfNeeded$1(this, null), 3, null);
    L81:
        CoroutineScopeKt.cancel$default(this.a.v, null, 1, null);
        if (r18 == false) goto L84;
        this.g.F(r12);
    L84:
        if (r18 == true) goto L86;
        BuildersKt.launch$default(this.a.u, null, null, new MmPreMeetingNativeRecordingStateHandler$onStateChanged$2(r1, this, null), 3, null);
        return;
    L86:
        BuildersKt.launch$default(this.a.u, null, null, new MmPreMeetingNativeRecordingStateHandler$onStateChanged$3(r1, this, null), 3, null);
        return;
    L70:
        if (this.q == true) goto L78;
        if (r1.c == MmRecordingAudioCaptureMode.EXTERNAL_AUDIO_SOURCE) goto L74;
        lvb.a.h(r1.e, "[stopExternalAudioSourceCaptureForEnd] skip, not external audio source mode");
        goto L79
    L74:
        MmExternalAudioCapturePipeline r4 = r1.F;
        if (r4 == null) goto L77;
        r4.g();
    L77:
        r1.F = null;
        r1.k.setValue(0);
        lvb.a.e(r1.e, "[stopExternalAudioSourceCaptureForEnd] pure offline external audio source mode");
        goto L79
    L65:
        if ((!StringsKt.isBlank(r17.a)) == false) goto L67;
        r18 = true;
        goto L68
    L88:
        if (Intrinsics.areEqual(r12, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.i.c) == false) goto L108;
        if (this.u == true) goto L131;
        ovb.b r19 = this.a.w;
        if (r19.a.length() != 0) goto L94;
        boolean r110 = true;
    L95:
        if (r110 == false) goto L99;
        lvb.a.h(this.c, "[postProcessing] skip upload identity recovery because meetingId is empty");
        return;
    L99:
        if (this.a.v() == false) goto L102;
        r3 = this.g.t();
    L104:
        if (r3 == false) goto L106;
        this.f.d();
        return;
    L106:
        lvb.a.h(this.c, "[postProcessing] upload identity not ready, recover record object, meetingId=" + r19.a);
        this.g.h(r19.a, this.s);
        return;
    L102:
        if (r19.d.length() <= 0) goto L104;
        r3 = true;
        goto L104
    L94:
        r110 = false;
        goto L95
    L131:
        return;
    L108:
        if (Intrinsics.areEqual(r12, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.n.c) == true) goto L110;
        return;
    L110:
        if (this.u == true) goto L135;
        this.f.k();
        BuildersKt.launch$default(this.a.u, null, null, new MmPreMeetingNativeRecordingStateHandler$onStateChanged$4(this, null), 3, null);
        return;
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler.f
    public final void b(String r12, iub.a<j, ? super MmRecordingError> r13) {
        Intrinsics.checkNotNullParameter(r13, "callback");
        MmRecordingSession r0 = this.a;
        ovb.b r1 = r0.w;
        if (r0.a == RecordingSessionType.PRE_MEETING_NATIVE_RECORDING) goto L6;
        r13.a(MmRecordingError.TypeDisMatch.INSTANCE);
        return;
    L6:
        boolean r2 = false;
        if (r12 != null) goto L9;
    L12:
        boolean r3 = true;
    L14:
        if (r3 == true) goto L31;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L17
        Gson r5 = e0.a;     // Catch: Throwable -> L17
        Object r14 = Result.constructor-impl((DoubaoBizInfo) e0.a(r12, DoubaoBizInfo.class));     // Catch: Throwable -> L17
    L19:
        Throwable r6 = Result.exceptionOrNull-impl(r14);
        if (r6 == null) goto L23;
        lvb.a.h(this.c, "[retryCreateRecording] parse doubaoBizInfo json failed, err=" + r6.getMessage());
    L23:
        if (Result.isFailure-impl(r14) == false) goto L25;
        r14 = null;
    L25:
        DoubaoBizInfo r15 = (DoubaoBizInfo) r14;
        if (r15 == null) goto L31;
        DoubaoBizInfo r16 = r15.withHostAppVersion();
        if (r16 == null) goto L31;
        this.s = r16;
        lvb.a.e(this.c, "[retryCreateRecording] rebuild doubaoBizInfo from json");
    L17:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
    L31:
        if (r1.h == false) goto L33;
    L62:
        BuildersKt.launch$default(this.a.v, null, null, new MmPreMeetingNativeRecordingStateHandler$retryCreateRecording$4(this, r1, r13, null), 3, null);
        return;
    L33:
        if (r1.a.length() <= 0) goto L35;
        boolean r17 = true;
    L36:
        if (r17 == true) goto L62;
        com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c r18 = this.a.g();
        if ((r18 instanceof com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.b) == false) goto L41;
    L60:
        lvb.a.h(this.c, "[retryCreateRecording] invalid state=" + r18);
        r13.a(MmRecordingError.StateError.INSTANCE);
        return;
    L41:
        if ((r18 instanceof com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.m) == true) goto L60;
        if (Intrinsics.areEqual(r18, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.n.c) == true) goto L60;
        if (this.l == false) goto L50;
        lvb.a.h(this.c, "[retryCreateRecording] ignored, already creating meeting");
        r13.a(MmRecordingError.StateError.INSTANCE);
        return;
    L50:
        if (this.u == true) goto L52;
        r2 = true;
    L56:
        if (r2 == true) goto L58;
        return;
    L58:
        this.m = r13;
        this.p = true;
        j();
        return;
    L52:
        pvb.a r19 = (pvb.a) this.i.getValue();
        k r8 = this.a.f;
        if (r8 == null) goto L56;
        r2 = r19.a(r8, r13);
        goto L56
    L35:
        r17 = false;
        goto L36
    L9:
        if (r12.length() == 0) goto L12;
        r3 = false;
        goto L14
    }

    public final boolean o(MmRecordingAudioService r3, String r4) {
        if (r3.l() == false) goto L6;
        return true;
    L6:
        lvb.a.b(this.c, "[startAudioCaptureOrTerminate] failed, from=" + r4);
        this.a.m(MmRecordingError.InternalError.INSTANCE);
        this.a.u(new com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.a.n(TerminateReason.OTHERS));
        return false;
    }

    public final Object p(MmRecordingAudioService r30, Continuation<? super Boolean> r31) {
        if ((r31 instanceof MmPreMeetingNativeRecordingStateHandler$submitD1204OfflineLocalUpload$1) == false) goto L7;
        MmPreMeetingNativeRecordingStateHandler$submitD1204OfflineLocalUpload$1 r2 = (MmPreMeetingNativeRecordingStateHandler$submitD1204OfflineLocalUpload$1) r31;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r1 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(r2.label) {
            case 0: goto L18;
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            default: goto L11;
        };
    L12:
        long r5 = r2.J$0;
        VFSFile r6 = (VFSFile) r2.L$2;
        String r7 = (String) r2.L$1;
        String r8 = (String) r2.L$0;
        ResultKt.throwOnFailure(r1);
    L89:
        this.g.x(r8);
        lvb.a.e(this.c, "[offlineUpload] submitted, sessionKey=" + r8 + ", taskId=" + ((String) r1) + ", path=" + r7 + ", size=" + r6.length() + ", durationMs=" + r5);
        return Boxing.boxBoolean(true);
    L13:
        long r9 = r2.J$2;
        long r10 = r2.J$1;
        long r12 = r2.J$0;
        VFSFile r11 = (VFSFile) r2.L$2;
        String r14 = (String) r2.L$1;
        String r15 = (String) r2.L$0;
        ResultKt.throwOnFailure(r1);
    L84:
        String r13 = (String) r1;
    L85:
        long r23 = r10;
        r7 = r14;
        int r16 = com.ss.android.lark.officesdk.minutes.service.recording.common.core.a.a;
        String r17 = r15;
        eub.f r18 = com.ss.android.lark.officesdk.minutes.service.recording.common.core.a.a(r17, r13, r7, r11.length(), r12, r23);
        MmMinutesFileUploadSessionManager r19 = this.d.F();
        r2.L$0 = r15;
        r2.L$1 = r7;
        r2.L$2 = r11;
        r2.J$0 = r9;
        r2.label = 6;
        r1 = r19.H(r18, r2);
        if (r1 != r4) goto L88;
        return r4;
    L88:
        r5 = r9;
        r6 = r11;
        r8 = r15;
        goto L89
    L14:
        long r110 = r2.J$2;
        long r111 = r2.J$1;
        long r20 = r2.J$0;
        String r21 = (String) r2.L$1;
        String r22 = (String) r2.L$0;
        ResultKt.throwOnFailure(r1);
        String r24 = r21;
    L63:
        boolean r25 = ((Boolean) r1).booleanValue();
        VFSFile r26 = com.ss.android.lark.officesdk.minutes.service.foundation.utils.cache.file.a.c(r24);
        lvb.a.e(this.c, "[offlineUpload] assemble full audio, sessionKey=" + r22 + ", assembled=" + r25 + ", exists=" + r26.exists() + ", size=" + r26.length());
        r9 = r110;
        r10 = r111;
        r12 = r20;
        r15 = r22;
        r14 = r24;
        r11 = r26;
    L65:
        if (r11.exists() == true) goto L67;
    L91:
        lvb.a.h(this.c, "[offlineUpload] skip, audio file unavailable, sessionKey=" + r15 + ", path=" + r14);
        return Boxing.boxBoolean(false);
    L67:
        if (r11.length() <= 0) goto L91;
        k r27 = this.a.f;
        if (r27 == null) goto L76;
        Map<String, Object> r28 = r27.b;
        if (r28 == null) goto L76;
        Object r29 = r28.get("hardware_device_id");
        if (r29 == null) goto L76;
        r13 = r29.toString();
    L77:
        if (r13 != null) goto L80;
        r13 = "";
    L80:
        if (StringsKt.isBlank(r13) == false) goto L85;
        MmRecordingStatesSyncService r32 = this.g;
        r2.L$0 = r15;
        r2.L$1 = r14;
        r2.L$2 = r11;
        r2.J$0 = r12;
        r2.J$1 = r10;
        r2.J$2 = r9;
        r2.label = 5;
        r1 = r32.n(r15, r2);
        if (r1 != r4) goto L84;
        return r4;
    L76:
        r13 = null;
        goto L77
    L15:
        long r33 = r2.J$2;
        long r34 = r2.J$1;
        long r112 = r2.J$0;
        String r113 = (String) r2.L$1;
        MmRecordingAudioService r114 = (MmRecordingAudioService) r2.L$0;
        ResultKt.throwOnFailure(r1);
        Object r35 = r1;
        MmRecordingAudioService r36 = r114;
        r22 = r113;
        r111 = r34;
        r20 = r112;
        r110 = r33;
    L50:
        r24 = (String) r35;
        if (StringsKt.isBlank(r24) == false) goto L54;
        lvb.a.h(this.c, "[offlineUpload] skip, audioPath is blank, sessionKey=" + r22);
        return Boxing.boxBoolean(false);
    L54:
        VFSFile r115 = com.ss.android.lark.officesdk.minutes.service.foundation.utils.cache.file.a.c(r24);
        if (r115.exists() == true) goto L57;
    L60:
        r2.L$0 = r22;
        r2.L$1 = r24;
        r2.J$0 = r20;
        r2.J$1 = r111;
        r2.J$2 = r110;
        r2.label = 4;
        r1 = r36.d().b(r36.b.getCurrentUserId(), r22, r24, r2);
        if (r1 != r4) goto L63;
        return r4;
    L57:
        if (r115.length() <= 0) goto L60;
        long r210 = r111;
        r15 = r22;
        r14 = r24;
        r11 = r115;
        r10 = r210;
        r9 = r110;
        r12 = r20;
        goto L65
    L16:
        String r37 = (String) r2.L$1;
        MmRecordingAudioService r38 = (MmRecordingAudioService) r2.L$0;
        ResultKt.throwOnFailure(r1);
    L41:
        Long r39 = (Long) ((Map) r1).get(r37);
        if (r39 == null) goto L44;
        long r40 = r39.longValue();
    L45:
        MmRecordingAudioService r116 = r38;
        String r41 = r37;
    L46:
        long r117 = System.currentTimeMillis();
        String r118 = r41;
        long r42 = RangesKt.coerceAtLeast(r117 - r40, 1000);
        r2.L$0 = r116;
        r2.L$1 = r118;
        r2.J$0 = r40;
        r2.J$1 = r117;
        r2.J$2 = r42;
        r2.label = 3;
        r35 = m(r116, r118, r2);
        if (r35 != r4) goto L49;
        return r4;
    L49:
        r22 = r118;
        r36 = r116;
        r111 = r117;
        r110 = r42;
        r20 = r40;
        goto L50
    L44:
        r40 = System.currentTimeMillis();
        goto L45
    L17:
        MmRecordingAudioService r43 = (MmRecordingAudioService) r2.L$0;
        ResultKt.throwOnFailure(r1);
    L21:
        ovb.b r44 = (ovb.b) r1;
        r41 = r44.g;
        if (StringsKt.isBlank(r41) == false) goto L25;
        r41 = this.a.e();
    L25:
        if (StringsKt.isBlank(r41) == false) goto L28;
        lvb.a.h(this.c, "[offlineUpload] skip, sessionKey is blank");
        return Boxing.boxBoolean(false);
    L28:
        Long r45 = Boxing.boxLong(r44.b);
        if (r45.longValue() <= 0) goto L31;
        boolean r46 = true;
    L32:
        if (r46 == true) goto L35;
        r45 = null;
    L35:
        if (r45 == null) goto L37;
        r40 = r45.longValue();
        r116 = r43;
        goto L46
    L37:
        MmRecordingStatesSyncService r47 = this.g;
        r2.L$0 = r43;
        r2.L$1 = r41;
        r2.label = 2;
        r1 = r47.o(r2);
        if (r1 != r4) goto L40;
        return r4;
    L40:
        String r211 = r41;
        r38 = r43;
        r37 = r211;
        goto L41
    L31:
        r46 = false;
        goto L32
    L18:
        ResultKt.throwOnFailure(r1);
        MmRecordingSession r48 = this.a;
        r43 = r30;
        r2.L$0 = r43;
        r2.label = 1;
        r1 = r48.r(r2);
        if (r1 != r4) goto L21;
        return r4;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L7:
        r2 = new MmPreMeetingNativeRecordingStateHandler$submitD1204OfflineLocalUpload$1(this, r31);
        goto L8
    }

    public static final Object f(MmPreMeetingNativeRecordingStateHandler r8, MmRecordingAudioService r9, Continuation r10) {
        r8.getClass();
        if ((r10 instanceof MmPreMeetingNativeRecordingStateHandler$handleOfflineLocalRecordingEnd$1) == false) goto L7;
        MmPreMeetingNativeRecordingStateHandler$handleOfflineLocalRecordingEnd$1 r0 = (MmPreMeetingNativeRecordingStateHandler$handleOfflineLocalRecordingEnd$1) r10;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L18;
        if (r3 == 1) goto L17;
        if (r3 == 2) goto L16;
        if (r3 != 3) goto L15;
        ResultKt.throwOnFailure(r11);
    L46:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r11);
    L40:
        if (((Boolean) r11).booleanValue() == false) goto L44;
        r0.label = 3;
        if (r8.i(r0) != r2) goto L46;
        return r2;
    L44:
        lvb.a.h(r8.c, "[offlineUpload] keep offline files, submit failed, recordingId=" + r8.a.e());
        goto L46
    L17:
        ResultKt.throwOnFailure(r11);
    L47:
        return Unit.INSTANCE;
    L18:
        ResultKt.throwOnFailure(r11);
        k r12 = r8.a.f;
        boolean r4 = false;
        if (r12 != null) goto L21;
    L23:
        boolean r6 = false;
    L24:
        if (r6 == true) goto L36;
        if (r12 == null) goto L31;
        MmRecordingSource r13 = r12.a;
        if (r13 == null) goto L31;
        if (r13.shouldRetainOfflineRecordingParts() != true) goto L31;
        r4 = true;
    L31:
        if (r4 == true) goto L47;
        r0.label = 1;
        if (r8.i(r0) != r2) goto L47;
        return r2;
    L36:
        r0.label = 2;
        r11 = r8.p(r9, r0);
        if (r11 != r2) goto L40;
        return r2;
    L21:
        if (r12.a != MmRecordingSource.FEISHU_HARDWARE_D1204) goto L23;
        r6 = true;
    L7:
        r0 = new MmPreMeetingNativeRecordingStateHandler$handleOfflineLocalRecordingEnd$1(r8, r10);
        goto L8
    }

    public static final Object g(MmPreMeetingNativeRecordingStateHandler r4, MinutesRecordingStartResponse r5, Continuation r6) {
        r4.getClass();
        if ((r6 instanceof MmPreMeetingNativeRecordingStateHandler$initRtcWithMeeting$1) == false) goto L7;
        MmPreMeetingNativeRecordingStateHandler$initRtcWithMeeting$1 r0 = (MmPreMeetingNativeRecordingStateHandler$initRtcWithMeeting$1) r6;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r7);
        Object r8 = ((Result) r7).unbox-impl();
    L21:
        if (Result.isSuccess-impl(r8) == false) goto L23;
        ((Boolean) r8).booleanValue();
        lvb.a.e(r4.c, "audioService update RTC config and switch to RTC mode success");
    L23:
        Throwable r9 = Result.exceptionOrNull-impl(r8);
        if (r9 == null) goto L27;
        lvb.a.b(r4.c, "audioService update RTC config failed: " + r9);
    L27:
        return Boxing.boxBoolean(Result.isSuccess-impl(r8));
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        MmRecordingAudioService r10 = r4.k("initRtcWithMeeting");
        if (r10 == null) goto L28;
        r0.label = 1;
        r8 = r10.r(r5, r0);
        if (r8 != r2) goto L21;
        return r2;
    L28:
        return Boxing.boxBoolean(false);
    L7:
        r0 = new MmPreMeetingNativeRecordingStateHandler$initRtcWithMeeting$1(r4, r6);
        goto L8
    }

    public final Object m(MmRecordingAudioService r5, String r6, Continuation<? super String> r7) {
        if ((r7 instanceof MmPreMeetingNativeRecordingStateHandler$resolveOfflineLocalAudioPath$1) == false) goto L7;
        MmPreMeetingNativeRecordingStateHandler$resolveOfflineLocalAudioPath$1 r0 = (MmPreMeetingNativeRecordingStateHandler$resolveOfflineLocalAudioPath$1) r7;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r5 = (MmRecordingAudioService) r0.L$0;
        ResultKt.throwOnFailure(r8);
    L17:
        CharSequence r9 = (CharSequence) r8;
        if (StringsKt.isBlank(r9) == false) goto L24;
        String r10 = r5.e();
        if (r10 != null) goto L23;
        r10 = "";
    L23:
        return r10;
    L24:
        return r9;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        MmRecordingStatesSyncService r11 = this.g;
        r0.L$0 = r5;
        r0.label = 1;
        r8 = r11.m(r6, r0);
        if (r8 != r2) goto L17;
        return r2;
    L7:
        r0 = new MmPreMeetingNativeRecordingStateHandler$resolveOfflineLocalAudioPath$1(this, r7);
        goto L8
    }

    public static final void e(MmPreMeetingNativeRecordingStateHandler r4, MmRecordingUploadTask r5, Set r6, String r7) {
        r4.getClass();
        if (r6.add(r5.a) == true) goto L5;
        lvb.a.e(r4.c, "[startUpload] skip duplicated segment, source:" + r7 + ", segIndex:" + r5.b + ", path:" + r5.a);
        return;
    L5:
        lvb.a.e(r4.c, "[startUpload] enqueue segment, source:" + r7 + ", segIndex:" + r5.b + ", path:" + r5.a);
        r4.a.k().c(r5);
    }
}
