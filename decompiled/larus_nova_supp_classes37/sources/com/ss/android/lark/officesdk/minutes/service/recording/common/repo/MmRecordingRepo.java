package com.ss.android.lark.officesdk.minutes.service.recording.common.repo;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.EndRecordingReason;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.api.recording.common.depend.feature.MmOfficeSdkFeature;
import com.ss.android.lark.officesdk.minutes.api.recording.doubao.DoubaoStatisticInfo;
import com.ss.android.lark.officesdk.minutes.service.foundation.utils.net.c;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSession;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.data.RecordingSessionType;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.data.TerminateReason;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.MmAIInterpretationRepo;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.MmRecordingAINoteRepo;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.audiosave.MmRecordingAudioSaveRepo;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.MmRecordingQuotaCtaRepo;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.MmRecordingEndWindowRepo;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.e;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.g;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location.MmRecordingLocationRepo;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.meta.MmRecordingMetaRepo;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.notification.MmRecordingNotificationRepo;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker.MmRecordingSpeakerRepo;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.MmRecordingSubtitleRepo;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.MmRecordingAutoTranslationCoordinator;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.MmRecordingLanguageRepo;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.f;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.MmRecordingSummaryRepo;
import com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.MmRecordingCommonParam;
import com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.m;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.rustinfrabridge.netstate.impl.LarkNetworkLevelManager;
import iub.k;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.TimeoutKt;
import svb.b;
import yub.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MmRecordingRepo implements com.ss.android.lark.officesdk.minutes.service.recording.common.repo.a {
    public static final /* synthetic */ int F = 0;
    public TerminateReason A;
    public volatile boolean B;
    public final CompletableDeferred<Unit> C;
    public volatile boolean D;
    public volatile boolean E;
    public final MmRecordingSession a;
    public final com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a b;
    public final String c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;
    public final Lazy k;
    public final Lazy l;
    public final Lazy m;
    public final Lazy n;
    public final Lazy o;
    public final Lazy<MmRecordingAutoTranslationCoordinator> p;
    public final Lazy q;
    public final Lazy r;
    public final Lazy s;
    public volatile MmRecordingCommonParam t;
    public String u;
    public volatile String v;
    public volatile String w;
    public volatile boolean x;
    public volatile boolean y;
    public EndRecordingReason z;

    public static final class a {
    }

    static {
    }

    public final void B() {
        if (this.x == false) goto L5;
        return;
    L5:
        this.x = true;
        if (this.p.isInitialized() == false) goto L9;
        t().f.set(true);
    L9:
        if (this.y == true) goto L12;
        lvb.a.e(this.c, "release: not initialized, skip cleanup");
        return;
    L12:
        lvb.a.e(this.c, "release: cleanup initialized resources");
        l().l().onDestroy();
        h().l().onDestroy();
        x().l().onDestroy();
        y().l().onDestroy();
        ((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.a) u().m.getValue()).onDestroy();
        MmRecordingLocationRepo r0 = v();
        if (r0 == null) goto L17;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location.a r1 = r0.m();
        if (r1 == null) goto L17;
        r1.onDestroy();
    L17:
        w().l().onDestroy();
        s().m().onDestroy();
        i().l().onDestroy();
        ((MmRecordingNotificationRepo) this.r.getValue()).j.onDestroy();
        if (z() == false) goto L21;
        r().x().onDestroy();
    L21:
        if (this.a.a == RecordingSessionType.HARDWARE_RECORDING) goto L23;
        q().n().onDestroy();
    L23:
        ((b) this.o.getValue()).j.onDestroy();
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.helper.a r2 = n();
        lvb.a.e(r2.a, "stop");
        Object r3 = LarkNetworkLevelManager.d;
        LarkNetworkLevelManager.a.a().x0(r2.d);
    }

    public final void f() {
        MmRecordingSession r0 = this.a;
        if (r0.a != RecordingSessionType.HARDWARE_RECORDING) goto L5;
        return;
    L5:
        BuildersKt.launch$default(r0.u, null, null, new MmRecordingRepo$clearAIInterpretationLocalStateForRecordingEnd$1(this, null), 3, null);
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.recording.common.repo.a
    public final MmRecordingSpeakerRepo h() {
        return (MmRecordingSpeakerRepo) this.f.getValue();
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.recording.common.repo.a
    public final MmRecordingQuotaCtaRepo i() {
        return (MmRecordingQuotaCtaRepo) this.m.getValue();
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.recording.common.repo.a
    public final MmRecordingLanguageRepo l() {
        return (MmRecordingLanguageRepo) this.e.getValue();
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.recording.common.repo.a
    public final com.ss.android.lark.officesdk.minutes.service.recording.common.repo.helper.a n() {
        return (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.helper.a) this.s.getValue();
    }

    public final void p() {
        if (this.y == false) goto L5;
        return;
    L5:
        if (this.x == true) goto L20;
        this.y = true;
        lvb.a.e(this.c, "initialize");
        n().a();
        BuildersKt.launch$default(this.a.u, null, null, new MmRecordingRepo$subscribeSessionState$1(this, null), 3, null);
        BuildersKt.launch$default(this.a.u, null, null, new MmRecordingRepo$subscribeTokenState$1(this, null), 3, null);
        BuildersKt.launch$default(this.a.u, null, null, new MmRecordingRepo$subscribeRecordingIdState$1(this, null), 3, null);
        RecordingSessionType r2 = this.a.a;
        if (r2 == RecordingSessionType.HARDWARE_RECORDING) goto L14;
        if (r2 == RecordingSessionType.STANDALONE_AI_INTERPRETATION) goto L14;
        com.ss.android.lark.officesdk.minutes.service.foundation.mvi.ext.a.a(s().m().b(), this.a.u, MmRecordingRepo$subscribeAudioSaveForAIInterpretation$1.INSTANCE, null, new MmRecordingRepo$subscribeAudioSaveForAIInterpretation$2(this, null), 12);
    L14:
        if (this.D == true) goto L17;
        this.D = true;
        BuildersKt.launch$default(this.a.u, null, null, new MmRecordingRepo$subscribeLanguageRepoEvent$1(this, null), 3, null);
    L17:
        x().l().s();
        return;
    }

    public final MmAIInterpretationRepo q() {
        return (MmAIInterpretationRepo) this.n.getValue();
    }

    public final MmRecordingAINoteRepo r() {
        return (MmRecordingAINoteRepo) this.q.getValue();
    }

    public final MmRecordingAudioSaveRepo s() {
        return (MmRecordingAudioSaveRepo) this.l.getValue();
    }

    public final MmRecordingAutoTranslationCoordinator t() {
        return (MmRecordingAutoTranslationCoordinator) this.p.getValue();
    }

    public final MmRecordingEndWindowRepo u() {
        return (MmRecordingEndWindowRepo) this.i.getValue();
    }

    public final MmRecordingLocationRepo v() {
        return (MmRecordingLocationRepo) this.j.getValue();
    }

    public final MmRecordingMetaRepo w() {
        return (MmRecordingMetaRepo) this.k.getValue();
    }

    public final MmRecordingSubtitleRepo x() {
        return (MmRecordingSubtitleRepo) this.g.getValue();
    }

    public final MmRecordingSummaryRepo y() {
        return (MmRecordingSummaryRepo) this.h.getValue();
    }

    public final boolean z() {
        return ((Boolean) this.d.getValue()).booleanValue();
    }

    public final boolean e() {
        if (c.a() == false) goto L6;
        lvb.a.e(this.c, "[canBuildEndWindow] skip, network unavailable");
        return false;
    L6:
        int r0 = com.ss.android.lark.officesdk.minutes.service.foundation.feature.b.a;
        com.ss.android.lark.officesdk.minutes.service.foundation.feature.a r1 = this.b.getFeatureService();
        Intrinsics.checkNotNullParameter(r1, "featureService");
        if (r1.h(MmOfficeSdkFeature.RecordingEndWindow) == true) goto L10;
        lvb.a.e(this.c, "[canBuildEndWindow] skip, end window disabled");
        return false;
    L10:
        com.ss.android.lark.officesdk.minutes.service.foundation.feature.a r2 = this.b.getFeatureService();
        Intrinsics.checkNotNullParameter(r2, "featureService");
        if (r2.h(MmOfficeSdkFeature.RecordingNoAiNotes) == false) goto L14;
        lvb.a.e(this.c, "[canBuildEndWindow] skip, ai notes disabled");
        return false;
    L14:
        return true;
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.recording.common.repo.a
    public final String o() {
        return ((f) l().l().b().getValue()).d.a;
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.recording.common.repo.a
    public final String k() {
        return this.v;
    }

    public final Object b(Continuation<? super com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.c> r27) {
        if ((r27 instanceof MmRecordingRepo$assembleEndWindowEntity$1) == false) goto L7;
        MmRecordingRepo$assembleEndWindowEntity$1 r2 = (MmRecordingRepo$assembleEndWindowEntity$1) r27;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r1 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        boolean r6 = true;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        ResultKt.throwOnFailure(r1);
    L17:
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.c r7 = (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.c) r1;
        com.ss.android.lark.officesdk.minutes.service.recording.common.perf.appreciable.c r8 = com.ss.android.lark.officesdk.minutes.service.recording.common.perf.appreciable.a.b;
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.c r9 = this.b.N();
        r8.getClass();
        Intrinsics.checkNotNullParameter(r7, "entity");
        Intrinsics.checkNotNullParameter(r9, "businessTracker");
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.a r10 = r9.c(r7.a);
        if (r10 == null) goto L21;
        MmRecordingCommonParam r11 = r10.b;
        if (r11 == null) goto L21;
    L22:
        String r12 = r11.getTrackerRecordId();
        if (r12.length() == 0) goto L27;
        r6 = false;
    L27:
        if (r6 == false) goto L29;
        lvb.a.h("MmRecordingEndWindowMetrics", "[trackEndWindowStart] skip, recordingId is empty");
    L34:
        return r7;
    L29:
        String r22 = r7.h.getSource();
        if (r10 == null) goto L32;
        DoubaoStatisticInfo r13 = r10.c;
    L33:
        r8.a.put(r12, new com.ss.android.lark.officesdk.minutes.service.recording.common.perf.appreciable.c.b(r11, r22, r13, System.currentTimeMillis()));
        lvb.a.e("MmRecordingEndWindowMetrics", "[trackEndWindowStart] recordingId=" + r12 + ", traceId=" + r11.getRecordingTraceId());
        goto L34
    L32:
        r13 = null;
    L21:
        r11 = new MmRecordingCommonParam(null, null, false, null, r7.d.getMeetingId(), null, null, null, null, null, null, 2031, null);
        goto L22
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r1);
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.a r14 = (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.a) u().m.getValue();
        r2.label = 1;
        r1 = r14.H(r2);
        if (r1 != r4) goto L17;
        return r4;
    L7:
        r2 = new MmRecordingRepo$assembleEndWindowEntity$1(this, r27);
        goto L8
    }

    public final Object c(Continuation<? super com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.c> r6) {
        if ((r6 instanceof MmRecordingRepo$buildHardwareLiveEndWindowWithTimeout$1) == false) goto L7;
        MmRecordingRepo$buildHardwareLiveEndWindowWithTimeout$1 r0 = (MmRecordingRepo$buildHardwareLiveEndWindowWithTimeout$1) r6;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L19;
        if (r3 != 1) goto L18;
        ResultKt.throwOnFailure(r7);     // Catch: Throwable -> L13 CancellationException -> L15
    L23:
        Pair r8 = (Pair) r7;     // Catch: Throwable -> L13 CancellationException -> L15
        if (r8 != null) goto L33;
        lvb.a.h(this.c, "[buildHardwareLiveEndWindowWithTimeout] timeout, timeoutMs=3000");     // Catch: Throwable -> L13 CancellationException -> L15
        return null;
    L33:
        return (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.c) r8.getSecond();
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        ResultKt.throwOnFailure(r7);
        MmRecordingRepo$buildHardwareLiveEndWindowWithTimeout$result$1 r9 = new MmRecordingRepo$buildHardwareLiveEndWindowWithTimeout$result$1(this, null);     // Catch: Throwable -> L13 CancellationException -> L15
        r0.label = 1;     // Catch: Throwable -> L13 CancellationException -> L15
        r7 = TimeoutKt.c(3000, r9, r0);     // Catch: Throwable -> L13 CancellationException -> L15
        if (r7 != r2) goto L23;
        return r2;
    L15:
        e = move-exception;
        throw e;
    L13:
        th = move-exception;
        lvb.a.b(this.c, "[buildHardwareLiveEndWindowWithTimeout] failed, error=" + th.getMessage());
        return null;
    L7:
        r0 = new MmRecordingRepo$buildHardwareLiveEndWindowWithTimeout$1(this, r6);
        goto L8
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.recording.common.repo.a
    public final void g(String r3) {
        if (this.a.a != RecordingSessionType.HARDWARE_RECORDING) goto L5;
        return;
    L5:
        q().n().g(r3);
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.recording.common.repo.a
    public final void m(String r4) {
        com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c r0 = this.a.s.f.b.get();
        if (r0.a() == true) goto L6;
        lvb.a.e(this.c, "[notifyAutoTranslationSuggested] ignore inactive session, state=" + r0);
        return;
    L6:
        t().j(r4);
    }

    public MmRecordingRepo(MmRecordingSession r18, com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r19) {
        Intrinsics.checkNotNullParameter(r18, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r19, "mmUccApi");
        this.a = r18;
        this.b = r19;
        String r1 = "RecordUX_D_Repo_" + hashCode();
        this.c = r1;
        this.d = LazyKt.lazy(new MmRecordingRepo$isPersonalAINoteEnable$2(this));
        this.e = LazyKt.lazy(new MmRecordingRepo$languageRepo$2(this));
        this.f = LazyKt.lazy(new MmRecordingRepo$speakerRepo$2(this));
        this.g = LazyKt.lazy(new MmRecordingRepo$subtitleRepo$2(this));
        this.h = LazyKt.lazy(new MmRecordingRepo$summaryRepo$2(this));
        this.i = LazyKt.lazy(new MmRecordingRepo$endWindowRepo$2(this));
        this.j = LazyKt.lazy(new MmRecordingRepo$locationRepo$2(this));
        this.k = LazyKt.lazy(new MmRecordingRepo$metaRepo$2(this));
        this.l = LazyKt.lazy(new MmRecordingRepo$audioSaveRepo$2(this));
        this.m = LazyKt.lazy(new MmRecordingRepo$quotaCtaRepo$2(this));
        this.n = LazyKt.lazy(new MmRecordingRepo$aiInterpretationRepo$2(this));
        this.o = LazyKt.lazy(MmRecordingRepo$toastRepo$2.INSTANCE);
        this.p = LazyKt.lazy(new MmRecordingRepo$autoTranslationCoordinatorLazy$1(this));
        this.q = LazyKt.lazy(new MmRecordingRepo$aiNoteRepo$2(this));
        this.r = LazyKt.lazy(MmRecordingRepo$notificationRepo$2.INSTANCE);
        this.s = LazyKt.lazy(MmRecordingRepo$networkMonitor$2.INSTANCE);
        this.t = new MmRecordingCommonParam(null, null, false, null, null, null, null, null, null, null, null, 2047, null);
        this.u = "";
        this.v = "";
        this.w = "";
        this.C = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        lvb.a.e(r1, "init");
    }

    public static final Object a(MmRecordingRepo r8, Continuation r9) {
        r8.getClass();
        if ((r9 instanceof MmRecordingRepo$sendEndWindowEventOnce$1) == false) goto L7;
        MmRecordingRepo$sendEndWindowEventOnce$1 r1 = (MmRecordingRepo$sendEndWindowEventOnce$1) r9;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        Object r10 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        if (r4 == 0) goto L24;
        if (r4 == 1) goto L20;
        if (r4 == 2) goto L19;
        if (r4 == 3) goto L18;
        if (r4 != 4) goto L17;
        ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L22
    L52:
        CompletableDeferred<Unit> r11 = r8.C;
        Unit r5 = Unit.INSTANCE;
        r11.complete(r5);
        return r5;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L22
    L46:
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.c r12 = (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.c) r10;     // Catch: Throwable -> L22
    L47:
        if (r12 != null) goto L49;
        r8.b.N().e(r8.a.e());     // Catch: Throwable -> L22
    L49:
        MmRecordingEndWindowRepo r0 = r8.u();     // Catch: Throwable -> L22
        g r6 = new g(r12);     // Catch: Throwable -> L22
        r1.label = 4;     // Catch: Throwable -> L22
        if (r0.k(r6, r1) != r3) goto L52;
        return r3;
    L19:
        ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L22
    L42:
        r12 = (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.c) r10;     // Catch: Throwable -> L22
        goto L47
    L20:
        ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L22
    L36:
        r12 = (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.c) r10;     // Catch: Throwable -> L22
        goto L47
    L24:
        ResultKt.throwOnFailure(r10);
        if (r8.B == false) goto L27;
        lvb.a.e(r8.c, "[sendEndWindowEventOnce] already sent, skip");
        return Unit.INSTANCE;
    L27:
        r8.B = true;
        lvb.a.e(r8.c, "[sendEndWindowEventOnce] endReason=" + r8.z + ", terminateReason=" + r8.A);     // Catch: Throwable -> L22
        EndRecordingReason r13 = r8.z;     // Catch: Throwable -> L22
        k r7 = r8.a.f;     // Catch: Throwable -> L22
        if (r7 == null) goto L31;
        MmRecordingSource r14 = r7.a;     // Catch: Throwable -> L22
    L32:
        if (r13 == null) goto L38;
        r1.label = 1;     // Catch: Throwable -> L22
        r10 = r8.d(r13, r1);     // Catch: Throwable -> L22
        if (r10 != r3) goto L36;
        return r3;
    L38:
        if (r14 != MmRecordingSource.FEISHU_HARDWARE_D1204_CASE) goto L43;
        r1.label = 2;     // Catch: Throwable -> L22
        r10 = r8.c(r1);     // Catch: Throwable -> L22
        if (r10 != r3) goto L42;
        return r3;
    L43:
        EndRecordingReason r15 = EndRecordingReason.OTHERS;     // Catch: Throwable -> L22
        r1.label = 3;     // Catch: Throwable -> L22
        r10 = r8.d(r15, r1);     // Catch: Throwable -> L22
        if (r10 != r3) goto L46;
        return r3;
    L31:
        r14 = null;
    L22:
        th = move-exception;
        r8.C.complete(Unit.INSTANCE);
        throw th;
    L7:
        r1 = new MmRecordingRepo$sendEndWindowEventOnce$1(r8, r9);
        goto L8
    }

    public final Object d(EndRecordingReason r9, Continuation<? super com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.c> r10) {
        if (e() == true) goto L5;
        return null;
    L5:
        k r0 = this.a.f;
        if (r0 == null) goto L8;
        MmRecordingSource r1 = r0.a;
    L9:
        e r2 = com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.f.a;
        if (r1 != null) goto L12;
        int r3 = -1;
    L13:
        boolean r4 = true;
        if (r3 != 1) goto L16;
        e r5 = com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.f.b;
    L18:
        if (r5.c == false) goto L20;
        d r6 = d.a;
        Boolean r7 = Boxing.boxBoolean(com.ss.android.lark.appcontext.applifecycle2.api.a.b());
    L21:
        Intrinsics.checkNotNullParameter(r9, "endReason");
        int r8 = e.a.a[r5.a.ordinal()];
        if (r8 != 1) goto L24;
        boolean r11 = r9.canShowEndWindow();
    L32:
        if (r11 == true) goto L34;
    L38:
        r4 = false;
    L40:
        if (r4 == true) goto L43;
        lvb.a.e(this.c, "[shouldShowEndWindow] skip, source=" + r1 + ", endReason=" + r9 + ", requireAppForeground=" + r5.c + ", isAppForeground=" + r7);
        return null;
    L43:
        lvb.a.e(this.c, "[shouldShowEndWindow] show, source=" + r1 + ", endReason=" + r9);
        return b(r10);
    L34:
        if (r5.c == false) goto L40;
        if (Intrinsics.areEqual(r7, Boxing.boxBoolean(true)) == false) goto L38;
    L24:
        if (r8 != 2) goto L30;
        if (r5.b.contains(r9) == true) goto L28;
        r11 = true;
        goto L32
    L28:
        r11 = false;
        goto L32
    L30:
        throw new NoWhenBranchMatchedException();
    L20:
        r7 = null;
        goto L21
    L16:
        r5 = com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.f.a;
        goto L18
    L12:
        r3 = com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.f.a.a[r1.ordinal()];
        goto L13
    L8:
        r1 = null;
        goto L9
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.recording.common.repo.a
    public final Object j(com.ss.android.lark.officesdk.minutes.service.recording.common.repo.notification.b r2, Continuation<? super Unit> r3) {
        Object r4 = ((MmRecordingNotificationRepo) this.r.getValue()).j.T0(r2, r3);
        if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r4;
    L6:
        return Unit.INSTANCE;
    }

    public final void A(String r25, long r26, String r28) {
        Intrinsics.checkNotNullParameter(r25, "meetingId");
        Intrinsics.checkNotNullParameter(r28, "source");
        if (r25.length() != 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L10;
        lvb.a.h(this.c, "[notifyMeetingInfoReadyIfNeeded] skip empty meetingId, source=" + r28);
        return;
    L10:
        if (Intrinsics.areEqual(r25, this.v) == false) goto L13;
        lvb.a.e(this.c, "[notifyMeetingInfoReadyIfNeeded] skip same meetingId=" + r25 + ", source=" + r28);
        return;
    L13:
        lvb.a.e(this.c, "[notifyMeetingInfoReadyIfNeeded] source=" + r28 + ", meetingId=" + r25);
        Intrinsics.checkNotNullParameter(r25, "<set-?>");
        this.v = r25;
        MmRecordingSession r1 = this.a;
        k r3 = r1.f;
        if (r3 == null) goto L19;
        String r4 = r3.d;
        if (r4 == null) goto L19;
        String r11 = r4;
    L20:
        if (r3 == null) goto L25;
        String r5 = r3.e;
        if (r5 == null) goto L25;
        String r10 = r5;
    L26:
        MmRecordingCommonParam r6 = r1.j();
        if (this.a.a.isHardwareRecording() == false) goto L29;
        String r7 = r6.getRecordId();
    L30:
        boolean r8 = this.a.a.isHardwareRecording();
        if (r3 == null) goto L36;
        MmRecordingSource r9 = r3.a;
        if (r9 == null) goto L36;
        String r12 = r9.name();
        if (r12 == null) goto L36;
    L37:
        String r13 = this.b.getCurrentUserId();
        String r14 = this.a.c;
        if (r3 == null) goto L40;
        MmRecordingSource r16 = r3.a;
    L41:
        String r22 = r10;
        String r23 = r11;
        this.t = MmRecordingCommonParam.copy$default(r6, null, r7, r8, r12, r25, r13, r14, r16, this.b.getTenantId(), null, this.a.a.name(), 513, null);
        this.b.N().k(this.a, this.t);
        m r15 = (m) this.b.N().i.getValue();
        String r17 = this.a.e();
        r15.getClass();
        Intrinsics.checkNotNullParameter(r17, "sessionId");
        Intrinsics.checkNotNullParameter(r22, "translationLanguage");
        r15.a(r17, r22, "subtitle_default_trans");
        lvb.a.e(this.c, "[onMeetingInfoReady] meetingId=" + r25 + ", meetingStartTime=" + r26 + ", spokenLanguage=" + r23 + ", translationLanguage=" + r22);
        com.ss.android.lark.officesdk.minutes.service.foundation.mvi.ext.a.a(l().l().b(), this.a.u, MmRecordingRepo$subscribeLanguageState$1.INSTANCE, null, new MmRecordingRepo$subscribeLanguageState$2(this, null), 12);
        com.ss.android.lark.officesdk.minutes.service.foundation.mvi.ext.a.a(l().l().b(), this.a.u, MmRecordingRepo$subscribeLanguageState$3.INSTANCE, null, new MmRecordingRepo$subscribeLanguageState$4(this, null), 12);
        if (this.E == true) goto L45;
        this.E = true;
        BuildersKt.launch$default(this.a.u, null, null, new MmRecordingRepo$subscribeAutoTranslationInputs$1(this, null), 3, null);
        BuildersKt.launch$default(this.a.u, null, null, new MmRecordingRepo$subscribeAutoTranslationInputs$2(this, null), 3, null);
    L45:
        l().l().u(r25, r23, r22);
        h().l().a(r25);
        x().l().c(r25, r26);
        y().l().a(r25);
        ((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.a) u().m.getValue()).a(r25);
        MmRecordingLocationRepo r18 = v();
        if (r18 == null) goto L50;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location.a r19 = r18.m();
        if (r19 == null) goto L50;
        r19.a(r25);
    L50:
        w().l().c(r25, r26);
        MmRecordingSession r20 = this.a;
        if (r20.a == RecordingSessionType.HARDWARE_RECORDING) goto L54;
        BuildersKt.launch$default(r20.u, null, null, new MmRecordingRepo$onMeetingInfoReady$1(this, r25, null), 3, null);
        return;
    L54:
        return;
    L40:
        r16 = null;
    L36:
        r12 = "";
        goto L37
    L29:
        r7 = r25;
    L25:
        r10 = "";
    L19:
        r11 = "";
        goto L20
    L5:
        r2 = false;
        goto L6
    }
}
