package com.ss.android.lark.officesdk.minutes.service.recording.hardware.live;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSession;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.data.TerminateReason;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.MmRecordingAudioService;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler.f;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c;
import com.ss.android.lark.pb.minutes.v1.MinutesRecordingStartResponse;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MmHardwareLiveRecordingStateHandler extends f {
    public final MmRecordingSession b;
    public final String c;
    public final String d;
    public final com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a e;
    public final Lazy f;
    public final MmRecordingAudioService g;
    public final Lazy h;
    public Job i;
    public volatile MinutesRecordingStartResponse j;

    public final void d() {
        this.b.u(new com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.a.n(TerminateReason.RTC_INIT_FAILED));
    }

    public final void c(ErrorResult r3) {
        if (r3 == null) goto L4;
        String r4 = Integer.valueOf(r3.getCode()).toString();
    L6:
        if (Intrinsics.areEqual(r4, "220205") == false) goto L8;
        TerminateReason r5 = TerminateReason.ALREADY_RECORDING;
    L9:
        this.b.u(new com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.a.n(r5));
        return;
    L8:
        r5 = TerminateReason.MEETING_CREATED_FAILED;
        goto L9
    L4:
        r4 = null;
        goto L6
    }

    public MmHardwareLiveRecordingStateHandler(MmRecordingSession r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "recordingSession");
        Intrinsics.checkNotNullParameter(r3, "hardwareRecordId");
        super(r2);
        this.b = r2;
        this.c = r3;
        this.d = "MmHardwareLiveRecordingStateHandler_" + hashCode();
        this.e = r2.b;
        this.f = LazyKt.lazy(new MmHardwareLiveRecordingStateHandler$networkService$2(this));
        this.g = r2.a();
        this.h = LazyKt.lazy(new MmHardwareLiveRecordingStateHandler$meetingCreateFailureHandler$2(this));
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler.f
    public final void a(c r10, c r11) {
        Intrinsics.checkNotNullParameter(r10, "oldState");
        Intrinsics.checkNotNullParameter(r11, "newState");
        lvb.a.e(this.d, "[onStateChanged] " + r10 + " -> " + r11 + ", recordingId=" + this.b.e());
        boolean r0 = false;
        if (Intrinsics.areEqual(r11, c.C0037c.c) == false) goto L13;
        Job r12 = this.i;
        if (r12 != null) goto L7;
    L9:
        if (r0 == false) goto L11;
        lvb.a.e(this.d, "[createMeetingOnlyIfNeeded] skip active job");
        return;
    L11:
        this.i = BuildersKt.launch$default(this.b.v, null, null, new MmHardwareLiveRecordingStateHandler$createMeetingOnlyIfNeeded$1(this, null), 3, null);
        return;
    L7:
        if (r12.isActive() != true) goto L9;
        r0 = true;
        goto L9
    L13:
        if (Intrinsics.areEqual(r11, c.l.c) == false) goto L16;
        BuildersKt.launch$default(this.b.v, null, null, new MmHardwareLiveRecordingStateHandler$initRtcAndStartExternalOpus$1(this, null), 3, null);
        return;
    L16:
        if (Intrinsics.areEqual(r11, c.k.c) == false) goto L27;
        MmRecordingAudioService r13 = this.g;
        if (r13 != null) goto L21;
        lvb.a.b(this.d, "[startExternalAudioCapture] audioService is null");
        d();
    L24:
        if (r0 == false) goto L45;
        this.e.w().e(this.c, this.b.e());
        return;
    L45:
        return;
    L21:
        if (r13.l() == true) goto L23;
        lvb.a.b(this.d, "[startExternalAudioCapture] start external capture failed");
        d();
        goto L24
    L23:
        r0 = true;
        goto L24
    L27:
        if (Intrinsics.areEqual(r11, c.h.c) == false) goto L32;
        MmRecordingAudioService r14 = this.g;
        if (r14 == null) goto L47;
        r14.m();
        return;
    L47:
        return;
    L32:
        if ((r11 instanceof c.m) == false) goto L40;
        Job r15 = this.i;
        if (r15 == null) goto L36;
        Job.DefaultImpls.cancel$default(r15, null, 1, null);
    L36:
        this.i = null;
        MmRecordingAudioService r16 = this.g;
        if (r16 == null) goto L39;
        r16.h();
    L39:
        this.e.w().d(this.c, this.b.e());
        return;
    L40:
        lvb.a.h(this.d, "[onStateChanged] unexpected state=" + r11);
    }
}
