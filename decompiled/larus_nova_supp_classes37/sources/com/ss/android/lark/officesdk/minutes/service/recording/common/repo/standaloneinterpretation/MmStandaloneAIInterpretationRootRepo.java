package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation;

import com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSession;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.MmRecordingQuotaCtaRepo;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker.MmRecordingSpeakerRepo;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.MmRecordingSubtitleRepo;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.MmRecordingLanguageRepo;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MmStandaloneAIInterpretationRootRepo implements com.ss.android.lark.officesdk.minutes.service.recording.common.repo.a {
    public final MmRecordingSession a;
    public final com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a b;
    public final String c;
    public volatile String d;
    public volatile boolean e;
    public final Lazy<MmStandaloneAIInterpretationRepo> f;
    public final Lazy<MmRecordingLanguageRepo> g;
    public final Lazy<MmRecordingSpeakerRepo> h;
    public final Lazy<MmRecordingSubtitleRepo> i;
    public final Lazy j;

    @Override // com.ss.android.lark.officesdk.minutes.service.recording.common.repo.a
    public final void g(String r1) {
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.recording.common.repo.a
    public final MmRecordingQuotaCtaRepo i() {
        return null;
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.recording.common.repo.a
    public final void m(String r1) {
    }

    public final MmStandaloneAIInterpretationRepo a() {
        return (MmStandaloneAIInterpretationRepo) this.f.getValue();
    }

    public final MmRecordingSubtitleRepo b() {
        return (MmRecordingSubtitleRepo) this.i.getValue();
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.recording.common.repo.a
    public final MmRecordingSpeakerRepo h() {
        return (MmRecordingSpeakerRepo) this.h.getValue();
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.recording.common.repo.a
    public final MmRecordingLanguageRepo l() {
        return (MmRecordingLanguageRepo) this.g.getValue();
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.recording.common.repo.a
    public final com.ss.android.lark.officesdk.minutes.service.recording.common.repo.helper.a n() {
        return (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.helper.a) this.j.getValue();
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.recording.common.repo.a
    public final String o() {
        String r1 = null;
        if (this.f.isInitialized() == false) goto L5;
        b r0 = (b) a().t().b().getValue();
    L6:
        if (r0 == null) goto L16;
        c r2 = r0.i;
        if (r2 == null) goto L16;
        String r3 = r2.a;
        if (r3 == null) goto L16;
        if ((!StringsKt.isBlank(r3)) == true) goto L15;
        r3 = null;
    L15:
        if (r3 == null) goto L16;
        return r3;
    L16:
        if (r0 == null) goto L24;
        c r4 = r0.g;
        if (r4 == null) goto L24;
        String r5 = r4.a;
        if (r5 == null) goto L24;
        if ((!StringsKt.isBlank(r5)) == false) goto L24;
        r1 = r5;
    L24:
        if (r1 != null) goto L27;
        return ((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.f) l().l().b().getValue()).d.a;
    L27:
        return r1;
    L5:
        r0 = null;
        goto L6
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.recording.common.repo.a
    public final String k() {
        return this.d;
    }

    public final void c(String r9) {
        Intrinsics.checkNotNullParameter(r9, "meetingId");
        if (StringsKt.isBlank(r9) == false) goto L7;
        lvb.a.h(this.c, "[onMeetingInfoReady] skip empty meetingId");
        return;
    L7:
        if (Intrinsics.areEqual(r9, this.d) == false) goto L10;
        lvb.a.e(this.c, "[onMeetingInfoReady] skip same meetingId=" + r9);
        return;
    L10:
        this.d = r9;
        if (this.e == true) goto L14;
        this.e = true;
        com.ss.android.lark.officesdk.minutes.service.foundation.mvi.ext.a.a(a().t().b(), this.a.v, MmStandaloneAIInterpretationRootRepo$subscribeLanguageState$1.INSTANCE, null, new MmStandaloneAIInterpretationRootRepo$subscribeLanguageState$2(this, null), 12);
        com.ss.android.lark.officesdk.minutes.service.foundation.mvi.ext.a.a(l().l().b(), this.a.v, MmStandaloneAIInterpretationRootRepo$subscribeLanguageState$3.INSTANCE, null, new MmStandaloneAIInterpretationRootRepo$subscribeLanguageState$4(this, null), 12);
    L14:
        lvb.a.e(this.c, "[onMeetingInfoReady] meetingId=" + r9);
        l().l().K(r9);
        h().l().a(r9);
        b().l().c(r9, this.a.w.b);
    }

    public MmStandaloneAIInterpretationRootRepo(MmRecordingSession r2, com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r3) {
        Intrinsics.checkNotNullParameter(r2, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r3, "mmUccApi");
        this.a = r2;
        this.b = r3;
        this.c = "MmStandaloneAIInterpretationRootRepo";
        this.d = "";
        this.f = LazyKt.lazy(new MmStandaloneAIInterpretationRootRepo$standaloneAIInterpretationRepoLazy$1(this));
        this.g = LazyKt.lazy(new MmStandaloneAIInterpretationRootRepo$languageRepoLazy$1(this));
        this.h = LazyKt.lazy(new MmStandaloneAIInterpretationRootRepo$speakerRepoLazy$1(this));
        this.i = LazyKt.lazy(new MmStandaloneAIInterpretationRootRepo$subtitleRepoLazy$1(this));
        this.j = LazyKt.lazy(MmStandaloneAIInterpretationRootRepo$networkMonitor$2.INSTANCE);
        n().a();
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.recording.common.repo.a
    public final Object j(com.ss.android.lark.officesdk.minutes.service.recording.common.repo.notification.b r1, Continuation<? super Unit> r2) {
        return Unit.INSTANCE;
    }
}
