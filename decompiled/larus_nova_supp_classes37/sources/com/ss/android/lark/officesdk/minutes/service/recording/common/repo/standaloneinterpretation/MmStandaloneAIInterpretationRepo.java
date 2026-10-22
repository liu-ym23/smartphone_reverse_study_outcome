package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.api.recording.doubao.DoubaoBizInfo;
import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.MviRepository;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.mock.MmMockAwareRequestService;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.request.http.MmRecordingUpdateStatus;
import com.ss.android.lark.officesdk.minutes.service.foundation.utils.net.MmRecordingNetHelper;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSession;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.MmRecordingAudioService;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.MmAIInterpretationAecPolicy;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.j;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.l;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.MmRecordingLanguageRepo;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.pb.improto.Command;
import com.ss.android.lark.pb.videochat.GetLiveRecordingSettingResponse;
import com.ss.android.lark.pb.videochat.SIBizScene;
import com.ss.android.lark.pb.videochat.UpdateLiveRecordingSettingResponse;
import com.ss.android.lark.pb.videochat.UpdateSISettingRequest;
import com.ss.android.lark.pb.videochat.UpdateSISettingResponse;
import iub.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jvb.h;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.Deferred;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MmStandaloneAIInterpretationRepo extends MviRepository {
    public static final Companion t = null;
    public final MmRecordingSession j;
    public final com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a k;
    public final String l;
    public Deferred<g> m;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public Long q;
    public final Lazy r;
    public final Lazy s;

    public static final class Companion {
        public Companion() {
        }

        public final Object a(com.ss.android.lark.officesdk.minutes.service.foundation.network.b r14, String r15, MmRecordingSource r16, boolean r17, Continuation<? super Result<String>> r18) {
            if ((r18 instanceof MmStandaloneAIInterpretationRepo$Companion$sendSaveArtifactStatusRequest$1) == false) goto L7;
            MmStandaloneAIInterpretationRepo$Companion$sendSaveArtifactStatusRequest$1 r1 = (MmStandaloneAIInterpretationRepo$Companion$sendSaveArtifactStatusRequest$1) r18;
            int r2 = r1.label;
            if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
            r1.label = r2 - Integer.MIN_VALUE;
        L8:
            Object r0 = r1.result;
            Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r4 = r1.label;
            if (r4 == 0) goto L14;
            if (r4 != 1) goto L13;
            ResultKt.throwOnFailure(r0);
            return ((Result) r0).unbox-impl();
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r0);
            MmRecordingUpdateStatus r8 = MmRecordingUpdateStatus.SET_SIMULTANEOUS_SAVE_ARTIFACT;
            Boolean r10 = Boxing.boxBoolean(r17);
            if (r16 != null) goto L17;
        L19:
            boolean r12 = false;
        L20:
            h r5 = new h(r15, r8, r16, r10, null, r12);
            r1.label = 1;
            Object r6 = r14.c(String.class, r5, r1);
            if (r6 != r3) goto L24;
            return r3;
        L24:
            return r6;
        L17:
            if (r16.usesRecordingApiByDefault() != true) goto L19;
            r12 = true;
        L7:
            r1 = new MmStandaloneAIInterpretationRepo$Companion$sendSaveArtifactStatusRequest$1(this, r18);
            goto L8
        }
    }

    static {
        t = new Companion();
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.MviRepository
    public final Object a() {
        return new b(0);
    }

    public final com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync.e s() {
        return (com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync.e) this.n.getValue();
    }

    public final a t() {
        return (a) this.s.getValue();
    }

    public final e u() {
        return (e) this.r.getValue();
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.MviRepository
    public final String c() {
        return this.l;
    }

    public static c x(UpdateSISettingResponse.SILanguage r5) {
        if (r5 == null) goto L5;
        String r1 = r5.mlanguage;
    L6:
        if (r5 == null) goto L8;
        String r6 = r5.mdescription_i18n;
    L9:
        boolean r2 = true;
        if (r1 != null) goto L12;
    L15:
        boolean r4 = true;
    L16:
        if (r4 == true) goto L26;
        if (r6 != null) goto L19;
    L22:
        if (r2 == false) goto L25;
        return null;
    L25:
        return new c(r1, r6);
    L19:
        if (StringsKt.isBlank(r6) == true) goto L22;
        r2 = false;
        goto L22
    L26:
        return null;
    L12:
        if (StringsKt.isBlank(r1) == true) goto L15;
        r4 = false;
        goto L16
    L8:
        r6 = null;
        goto L9
    L5:
        r1 = null;
        goto L6
    }

    public static String y(c r4) {
        String r5 = r4.a;
        String r1 = null;
        if ((!StringsKt.isBlank(r5)) == true) goto L6;
        r5 = null;
    L6:
        if (r5 != null) goto L8;
    L12:
        if (r1 != null) goto L15;
        return "";
    L15:
        return r1;
    L8:
        if (StringsKt.startsWith$default(r5, "ai_", false, 2, null) == true) goto L11;
        r5 = "ai_".concat(r5);
    L11:
        r1 = r5;
        goto L12
    }

    public MmStandaloneAIInterpretationRepo(MmRecordingSession r2, com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r3) {
        Intrinsics.checkNotNullParameter(r2, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r3, "mmUccApi");
        this.j = r2;
        this.k = r3;
        this.l = "MmStandaloneAIInterpretationRepo";
        this.n = LazyKt.lazy(new MmStandaloneAIInterpretationRepo$localStorage$2(this));
        this.o = LazyKt.lazy(new MmStandaloneAIInterpretationRepo$rtcActionApplier$2(this));
        this.p = LazyKt.lazy(new MmStandaloneAIInterpretationRepo$quotaDialogHandler$2(this));
        this.r = LazyKt.lazy(new MmStandaloneAIInterpretationRepo$rtcApplyCoordinator$2(this));
        this.s = LazyKt.lazy(new MmStandaloneAIInterpretationRepo$opt$2(this));
    }

    public static final void l(MmStandaloneAIInterpretationRepo r6, String r7) {
        r6.q = null;
        e r1 = r6.u();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r7, "source");
        r1.g = null;
        r1.h = null;
        boolean r0 = false;
        r1.i = false;
        r1.k = true;
        int r3 = l.a;
        j r4 = new j(false, CollectionsKt.listOf("main"), true, MmAIInterpretationAecPolicy.RESTORE);
        r1.b.invoke(Boolean.valueOf(r4.c));
        if (r1.f == false) goto L5;
        boolean r5 = ((Boolean) r1.e.invoke(r4, r7)).booleanValue();
    L7:
        if (r1.f == true) goto L9;
        boolean r2 = false;
    L10:
        if (r5 == true) goto L12;
        if (r2 == true) goto L12;
    L13:
        lvb.a.e(r6.l, "[applyStandaloneAIInterpretationDisabledRtcPolicy] source=" + r7 + ", rtcInitialized=" + r6.u().f + ", applied=" + r0);
        return;
    L12:
        r0 = true;
        goto L13
    L9:
        int r8 = com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.h.a;
        r2 = r1.c(100);
        goto L10
    L5:
        r5 = false;
        goto L7
    }

    public static final d m(MmStandaloneAIInterpretationRepo r5, String r6, String r7) {
        Boolean r0 = null;
        if (r6 == null) goto L7;
        r5.getClass();
        if ((!StringsKt.isBlank(r6)) == false) goto L7;
    L8:
        if (r6 != null) goto L10;
        lvb.a.b(r5.l, "[applyStandaloneAIInterpretationEnabledRtcPolicy] skip empty targetChannel, source=".concat(r7));
        return r5.u().d(null, r7);
    L10:
        d r1 = r5.u().d(r6, r7);
        String r2 = r5.l;
        StringBuilder r3 = new StringBuilder("[applyStandaloneAIInterpretationEnabledRtcPolicy] source=");
        r3.append(r7);
        r3.append(", channel=");
        r3.append(r6);
        r3.append(", actualMuted=");
        r3.append(r1.a);
        r3.append(", changeToOrigin=");
        r3.append(r1.c);
        r3.append(", playbackMuted=");
        MmRecordingAudioService r8 = r5.j.a();
        if (r8 == null) goto L13;
        r0 = Boolean.valueOf(r8.s);
    L13:
        r3.append(r0);
        r3.append(", rtcInitialized=");
        r3.append(r5.u().f);
        r3.append(", applied=");
        r3.append(r1.b);
        lvb.a.e(r2, r3.toString());
        return r1;
    L7:
        r6 = null;
        goto L8
    }

    public static final Object n(MmStandaloneAIInterpretationRepo r5, Function1 r6, Continuation r7) {
        r5.getClass();
        if ((r7 instanceof MmStandaloneAIInterpretationRepo$enqueueLanguageSwitch$1) == false) goto L7;
        MmStandaloneAIInterpretationRepo$enqueueLanguageSwitch$1 r0 = (MmStandaloneAIInterpretationRepo$enqueueLanguageSwitch$1) r7;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        ResultKt.throwOnFailure(r8);
    L23:
        return r8;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r8);
    L19:
        r0.label = 2;
        r8 = ((Deferred) r8).await(r0);
        if (r8 != r2) goto L23;
        return r2;
    L16:
        ResultKt.throwOnFailure(r8);
        MmStandaloneAIInterpretationRepo$enqueueLanguageSwitch$task$1 r9 = new MmStandaloneAIInterpretationRepo$enqueueLanguageSwitch$task$1(r5, r6, null);
        r0.label = 1;
        r8 = r5.e.b(r9, r0);
        if (r8 != r2) goto L19;
        return r2;
    L7:
        r0 = new MmStandaloneAIInterpretationRepo$enqueueLanguageSwitch$1(r5, r7);
        goto L8
    }

    public static final Object o(MmStandaloneAIInterpretationRepo r5, String r6, b r7, Continuation r8) {
        r5.getClass();
        if ((r8 instanceof MmStandaloneAIInterpretationRepo$resolveSpokenLanguageBeforeSwitch$1) == false) goto L7;
        MmStandaloneAIInterpretationRepo$resolveSpokenLanguageBeforeSwitch$1 r0 = (MmStandaloneAIInterpretationRepo$resolveSpokenLanguageBeforeSwitch$1) r8;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r9);
        Object r10 = ((Result) r9).unbox-impl();
    L41:
        Throwable r11 = Result.exceptionOrNull-impl(r10);
        if (r11 == null) goto L45;
        lvb.a.b(r5.l, "[resolveSpokenLanguageBeforeSwitch] failed: " + r11);
    L45:
        if (Result.isFailure-impl(r10) == false) goto L47;
        r10 = null;
    L47:
        GetLiveRecordingSettingResponse r12 = (GetLiveRecordingSettingResponse) r10;
        if (r12 == null) goto L65;
        GetLiveRecordingSettingResponse.SubtitleLanguage r13 = r12.mspoken_language;
        if (r13 == null) goto L65;
        String r14 = r13.mlanguage;
        if (r14 != null) goto L54;
    L57:
        boolean r15 = true;
    L59:
        if ((!r15) == true) goto L62;
        r13 = null;
    L62:
        if (r13 == null) goto L65;
        return new com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.h(r13.mlanguage, r13.mdescription_i18n);
    L54:
        if (StringsKt.isBlank(r14) == true) goto L57;
        r15 = false;
    L65:
        return null;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r9);
        MmStandaloneAIInterpretationRootRepo r16 = r5.j.h();
        if (r16 == null) goto L30;
        MmRecordingLanguageRepo r17 = r16.l();
        if (r17 == null) goto L30;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.a r18 = r17.l();
        if (r18 == null) goto L30;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.f r19 = r18.m();
        if (r19 == null) goto L30;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.h r20 = r19.c;
        if (r20 == null) goto L30;
        if ((!StringsKt.isBlank(r20.a)) == true) goto L28;
        r20 = null;
    L28:
        if (r20 == null) goto L30;
        return r20;
    L30:
        c r21 = r7.f;
        if (r21 != null) goto L33;
    L38:
        MmRecordingNetHelper r22 = r5.k.G();
        r0.label = 1;
        r10 = r22.f(r6, r0);
        if (r10 != r2) goto L41;
        return r2;
    L33:
        if ((!StringsKt.isBlank(r21.a)) == true) goto L36;
        r21 = null;
    L36:
        if (r21 == null) goto L38;
        return new com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.h(r21.a, r21.b);
    L7:
        r0 = new MmStandaloneAIInterpretationRepo$resolveSpokenLanguageBeforeSwitch$1(r5, r8);
        goto L8
    }

    public static final Object q(MmStandaloneAIInterpretationRepo r7, String r8, boolean r9, Continuation r10) {
        r7.getClass();
        if ((r10 instanceof MmStandaloneAIInterpretationRepo$sendSaveArtifactStatusRequest$1) == false) goto L7;
        MmStandaloneAIInterpretationRepo$sendSaveArtifactStatusRequest$1 r0 = (MmStandaloneAIInterpretationRepo$sendSaveArtifactStatusRequest$1) r10;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        MmStandaloneAIInterpretationRepo$sendSaveArtifactStatusRequest$1 r6 = r0;
        Object r11 = r6.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r6.label;
        if (r3 == 0) goto L15;
        if (r3 != 1) goto L14;
        ResultKt.throwOnFailure(r11);
        Object r12 = ((Result) r11).unbox-impl();
    L27:
        return r12;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r11);
        if (StringsKt.isBlank(r8) == false) goto L18;
        lvb.a.b(r7.l, "[sendSaveArtifactStatusRequest] skip, recordingId is blank");
        Result.Companion r13 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(new IllegalArgumentException("recordingId is blank")));
    L18:
        MmRecordingSession r14 = r7.j;
        ovb.b r4 = r14.w;
        k r15 = r14.f;
        if (r15 == null) goto L22;
        MmRecordingSource r16 = r15.a;
        if (r16 == null) goto L22;
    L25:
        MmRecordingSource r5 = r16;
        lvb.a.e(r7.l, "[sendSaveArtifactStatusRequest] request, recordingId=" + r8 + ", saveArtifactType=" + r9 + ", source=" + r5);
        Companion r17 = t;
        MmMockAwareRequestService r18 = r7.k.M();
        r6.label = 1;
        r12 = r17.a(r18, r8, r5, r9, r6);
        if (r12 != r2) goto L27;
        return r2;
    L22:
        r16 = r7.s().r(r8);
        if (r16 != null) goto L25;
        r16 = r7.s().r(r4.a);
    L7:
        r0 = new MmStandaloneAIInterpretationRepo$sendSaveArtifactStatusRequest$1(r7, r10);
        goto L8
    }

    public final Object v(String r7, boolean r8, c r9, Continuation<? super g> r10) {
        if ((r10 instanceof MmStandaloneAIInterpretationRepo$sendSwitchTargetLanguageRequest$1) == false) goto L7;
        MmStandaloneAIInterpretationRepo$sendSwitchTargetLanguageRequest$1 r0 = (MmStandaloneAIInterpretationRepo$sendSwitchTargetLanguageRequest$1) r10;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r8 = r0.Z$0;
        r9 = (c) r0.L$0;
        ResultKt.throwOnFailure(r11);
        Object r12 = ((Result) r11).unbox-impl();
    L17:
        Throwable r13 = Result.exceptionOrNull-impl(r12);
        if (r13 != null) goto L20;
        g r14 = (g) r12;
        lvb.a.e(this.l, "[sendSwitchTargetLanguageRequest] result, enabled=" + r8 + ", status=" + r14.b + ", accepted=" + r14.a() + ", channel=" + r14.a + ", language=" + r9.a);
        return r14;
    L20:
        lvb.a.b(this.l, "[sendSwitchTargetLanguageRequest] failed, enabled=" + r8 + ": " + r13);
        return null;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r11);
        lvb.a.e(this.l, "[sendSwitchTargetLanguageRequest] meetingId=" + r7 + ", enabled=" + r8 + ", language=" + r9.a);
        r0.L$0 = r9;
        r0.Z$0 = r8;
        r0.label = 1;
        r12 = w(r7, r8, r9, r0);
        if (r12 != r2) goto L17;
        return r2;
    L7:
        r0 = new MmStandaloneAIInterpretationRepo$sendSwitchTargetLanguageRequest$1(this, r10);
        goto L8
    }

    public final Object w(String r22, boolean r23, c r24, Continuation<? super Result<g>> r25) {
        if ((r25 instanceof MmStandaloneAIInterpretationRepo$sendUpdateSettingRequest$1) == false) goto L7;
        MmStandaloneAIInterpretationRepo$sendUpdateSettingRequest$1 r5 = (MmStandaloneAIInterpretationRepo$sendUpdateSettingRequest$1) r25;
        int r6 = r5.label;
        if ((r6 & Integer.MIN_VALUE) == 0) goto L7;
        r5.label = r6 - Integer.MIN_VALUE;
    L8:
        Object r4 = r5.result;
        Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r8 = r5.label;
        boolean r9 = true;
        String r10 = null;
        if (r8 == 0) goto L14;
        if (r8 != 1) goto L13;
        boolean r1 = r5.Z$0;
        c r2 = (c) r5.L$0;
        ResultKt.throwOnFailure(r4);
        Object r3 = ((Result) r4).unbox-impl();
    L66:
        boolean r11 = Result.isSuccess-impl(r3);
        Object r12 = r3;
        if (r11 == false) goto L112;
        UpdateSISettingResponse r13 = (UpdateSISettingResponse) r3;
        String r14 = r13.mchannel;
        if (r14 != null) goto L71;
        r14 = "";
    L71:
        String r15 = r14;
        int r16 = r13.mstatus.getValue();
        List<UpdateSISettingResponse.SILanguage> r17 = r13.msupport_spoken_lans;
        ArrayList r18 = new ArrayList();
        Iterator<T> r19 = r17.iterator();
    L73:
        if (r19.hasNext() == false) goto L77;
        c r20 = x((UpdateSISettingResponse.SILanguage) r19.next());
        if (r20 == null) goto L73;
        r18.add(r20);
        goto L73
    L77:
        List<UpdateSISettingResponse.SILanguage> r21 = r13.msupport_lans;
        ArrayList r110 = new ArrayList();
        Iterator<T> r26 = r21.iterator();
    L79:
        if (r26.hasNext() == false) goto L83;
        c r27 = x((UpdateSISettingResponse.SILanguage) r26.next());
        if (r27 == null) goto L79;
        r110.add(r27);
        goto L79
    L83:
        Map<String, UpdateSISettingResponse.StringList> r28 = r13.msupport_spoken_translate_map_lans;
        LinkedHashMap r29 = new LinkedHashMap(MapsKt.mapCapacity(r28.size()));
        Iterator<T> r30 = r28.entrySet().iterator();
    L85:
        if (r30.hasNext() == false) goto L87;
        Map.Entry r31 = (Map.Entry) r30.next();
        r29.put(r31.getKey(), ((UpdateSISettingResponse.StringList) r31.getValue()).mvalues);
        goto L85
    L87:
        Map<String, UpdateSISettingResponse.StringList> r32 = r13.msupport_translate_spoken_map_lans;
        LinkedHashMap r33 = new LinkedHashMap(MapsKt.mapCapacity(r32.size()));
        Iterator<T> r34 = r32.entrySet().iterator();
    L89:
        if (r34.hasNext() == false) goto L91;
        Map.Entry r35 = (Map.Entry) r34.next();
        r33.put(r35.getKey(), ((UpdateSISettingResponse.StringList) r35.getValue()).mvalues);
        goto L89
    L91:
        UpdateSISettingResponse.SILanguage r36 = r13.mhighlight_spoken_lang;
        if (r36 == null) goto L94;
        c r111 = x(r36);
    L95:
        UpdateSISettingResponse.SILanguage r37 = r13.mhighlight_lang;
        if (r37 == null) goto L98;
        c r112 = x(r37);
    L99:
        g r38 = new g(r15, r16, r18, r110, r29, r33, r111, r112);
        String r39 = this.l;
        StringBuilder r40 = new StringBuilder("[sendUpdateSettingRequest] status=");
        r40.append(r38.b);
        r40.append(", channel=");
        r40.append(r38.a);
        r40.append(", enabled=");
        r40.append(r1);
        r40.append(", language=");
        if (r2 == null) goto L102;
        String r41 = r2.a;
    L103:
        r40.append(r41);
        r40.append(", highlightSpoken=");
        c r42 = r38.g;
        if (r42 == null) goto L106;
        String r43 = r42.a;
    L107:
        r40.append(r43);
        r40.append(", highlight=");
        c r44 = r38.h;
        if (r44 == null) goto L110;
        r10 = r44.a;
    L110:
        r40.append(r10);
        r40.append(", spokenSize=");
        r40.append(r38.c.size());
        r40.append(", targetSize=");
        r40.append(r38.d.size());
        r40.append(", spokenToTargetKeys=");
        r40.append(r38.e.size());
        r40.append(", targetToSpokenKeys=");
        r40.append(r38.f.size());
        lvb.a.e(r39, r40.toString());
        r12 = r38;
        goto L112
    L106:
        r43 = null;
        goto L107
    L102:
        r41 = null;
        goto L103
    L98:
        r112 = null;
        goto L99
    L94:
        r111 = null;
    L112:
        return Result.constructor-impl(r12);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r4);
        String r45 = this.l;
        StringBuilder r46 = new StringBuilder("[sendUpdateSettingRequest] request, meetingId=");
        r46.append(r22);
        r46.append(", enabled=");
        r46.append(r23);
        r46.append(", targetLang=");
        if (r24 == null) goto L17;
        String r113 = r24.a;
    L18:
        r46.append(r113);
        lvb.a.e(r45, r46.toString());
        UpdateSISettingRequest.Builder r47 = new UpdateSISettingRequest.Builder().meeting_id(r22).turn_on(Boxing.boxBoolean(r23)).biz_scene(SIBizScene.INDEPENDENT);
        if (r23 == false) goto L55;
        String r48 = this.j.w.c;
        if (StringsKt.isBlank(r48) == false) goto L23;
        r48 = s().u(r22);
    L23:
        k r114 = this.j.f;
        if (r114 == null) goto L28;
        MmRecordingSource r115 = r114.a;
        if (r115 == null) goto L28;
    L37:
        if (r115 != MmRecordingSource.DOUBAO_STANDALONE_AI_INTERPRETATION) goto L55;
        String r49 = this.j.w.c;
        if (StringsKt.isBlank(r49) == false) goto L41;
        r49 = s().u(r22);
    L41:
        DoubaoBizInfo r116 = this.j.c();
        if (r116 != null) goto L45;
        r116 = s().h(r22);
    L45:
        if (StringsKt.isBlank(r49) == true) goto L49;
        if (r116 == null) goto L49;
        r47.record_id(r49).doubao_bizinfo(new com.ss.android.lark.pb.videochat.DoubaoBizInfo.Builder().user_id(r116.getUserId()).conversation_id(r116.getConversationId()).message_id(r116.getMessageId()).reply_message_id(r116.getReplyMessageId()).biz_id(r116.getBizId()).app_id(r116.getAppId()).tenant_id(r116.getTenantId()).device_id(r116.getDeviceId()).recording_id(r116.getRecordingId()).m3107build());
    L49:
        String r50 = this.l;
        StringBuilder r51 = new StringBuilder("[sendUpdateSettingRequest] skip incomplete doubao request, hasRecordingId=");
        r51.append(!StringsKt.isBlank(r49));
        r51.append(", hasDoubaoBizInfo=");
        if (r116 != null) goto L53;
        r9 = false;
    L53:
        r51.append(r9);
        lvb.a.b(r50, r51.toString());
        Result.Companion r52 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(new IllegalStateException("incomplete doubao standalone interpretation context")));
    L28:
        if ((!StringsKt.isBlank(r48)) == true) goto L31;
        r48 = null;
    L31:
        if (r48 == null) goto L33;
        r115 = s().r(r48);
    L34:
        if (r115 != null) goto L37;
        r115 = s().r(r22);
        goto L37
    L33:
        r115 = null;
    L55:
        if (r24 == null) goto L62;
        String r53 = y(r24);
        if ((!StringsKt.isBlank(r53)) == true) goto L60;
        r53 = null;
    L60:
        if (r53 == null) goto L62;
        r47.target_lang(r53);
    L62:
        UpdateSISettingRequest r54 = r47.m3203build();
        MmMockAwareRequestService r55 = this.k.M();
        Command r56 = Command.UPDATE_MEETING_SI_SETTING;
        Intrinsics.checkNotNull(r54);
        r5.L$0 = r24;
        r5.Z$0 = r23;
        r5.label = 1;
        Object r57 = r55.a(r56, UpdateSISettingResponse.class, r54, r5);
        if (r57 != r7) goto L65;
        return r7;
    L65:
        r3 = r57;
        r1 = r23;
        r2 = r24;
        goto L66
    L17:
        r113 = null;
    L7:
        r5 = new MmStandaloneAIInterpretationRepo$sendUpdateSettingRequest$1(this, r25);
        goto L8
    }

    public static final Object r(MmStandaloneAIInterpretationRepo r16, String r17, boolean r18, c r19, Continuation r20) {
        r16.getClass();
        if ((r20 instanceof MmStandaloneAIInterpretationRepo$updateSetting$1) == false) goto L7;
        MmStandaloneAIInterpretationRepo$updateSetting$1 r4 = (MmStandaloneAIInterpretationRepo$updateSetting$1) r20;
        int r5 = r4.label;
        if ((r5 & Integer.MIN_VALUE) == 0) goto L7;
        r4.label = r5 - Integer.MIN_VALUE;
    L8:
        MmStandaloneAIInterpretationRepo$updateSetting$1 r7 = r4;
        Object r3 = r7.result;
        Object r8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r7.label;
        String r9 = null;
        if (r6 == 0) goto L19;
        if (r6 == 1) goto L18;
        if (r6 == 2) goto L17;
        if (r6 == 3) goto L17;
        if (r6 != 4) goto L16;
        ResultKt.throwOnFailure(r3);
    L64:
        return null;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        g r0 = (g) r7.L$0;
        ResultKt.throwOnFailure(r3);
        return r0;
    L18:
        boolean r1 = r7.Z$0;
        c r2 = (c) r7.L$0;
        ResultKt.throwOnFailure(r3);
        Object r10 = ((Result) r3).unbox-impl();
        boolean r11 = r1;
    L35:
        Throwable r12 = Result.exceptionOrNull-impl(r10);
        if (r12 != null) goto L60;
        g r13 = (g) r10;
        if (r13.a() == false) goto L52;
        c r14 = r13.h;
        if (r14 != null) goto L42;
        c r15 = r2;
    L43:
        String r21 = r16.l;
        StringBuilder r22 = new StringBuilder("[updateSetting] accepted, enabled=");
        r22.append(r11);
        r22.append(", status=");
        r22.append(r13.b);
        r22.append(", channel=");
        r22.append(r13.a);
        r22.append(", language=");
        if (r15 == null) goto L46;
        r9 = r15.a;
    L46:
        r22.append(r9);
        r22.append(", spokenSize=");
        r22.append(r13.c.size());
        r22.append(", targetSize=");
        r22.append(r13.d.size());
        r22.append(", spokenToTargetKeys=");
        r22.append(r13.e.size());
        r22.append(", targetToSpokenKeys=");
        r22.append(r13.f.size());
        lvb.a.e(r21, r22.toString());
        r7.L$0 = r13;
        r7.label = 2;
        Object r23 = r16.e.b(new MmStandaloneAIInterpretationRepo$dispatchAcceptedEntity$2(r16, r11, r13, r15, null), r7);
        if (r23 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L50;
        r23 = Unit.INSTANCE;
    L50:
        if (r23 != r8) goto L66;
        return r8;
    L66:
        return r13;
    L42:
        r15 = r14;
        goto L43
    L52:
        String r24 = r16.l;
        StringBuilder r25 = new StringBuilder("[updateSetting] business failed, status=");
        r25.append(r13.b);
        r25.append(", channel=");
        r25.append(r13.a);
        r25.append(", language=");
        if (r2 == null) goto L55;
        String r26 = r2.a;
    L56:
        r25.append(r26);
        lvb.a.b(r24, r25.toString());
        b r27 = b.b((b) r16.h(), null, "update_failed", 511);
        r7.L$0 = r13;
        r7.label = 3;
        if (r16.b(r27, r7) != r8) goto L66;
        return r8;
    L55:
        r26 = null;
        goto L56
    L60:
        lvb.a.b(r16.l, "[updateSetting] failed: " + r12);
        b r28 = b.b((b) r16.h(), null, "update_failed", 511);
        r7.L$0 = null;
        r7.label = 4;
        if (r16.b(r28, r7) != r8) goto L64;
        return r8;
    L19:
        ResultKt.throwOnFailure(r3);
        String r29 = r16.l;
        StringBuilder r30 = new StringBuilder("[updateSetting] start, enabled=");
        r30.append(r18);
        r30.append(", meetingId=");
        r30.append(r17);
        r30.append(", language=");
        if (r19 == null) goto L22;
        String r110 = r19.a;
    L23:
        r30.append(r110);
        lvb.a.e(r29, r30.toString());
        b r31 = (b) r16.h();
        String r32 = r16.l;
        StringBuilder r111 = new StringBuilder("[updateSetting] local before request, enabled=");
        r111.append(r31.a);
        r111.append(", active=");
        c r112 = r31.i;
        if (r112 == null) goto L26;
        String r113 = r112.a;
    L27:
        r111.append(r113);
        r111.append(", selected=");
        c r33 = r31.g;
        if (r33 == null) goto L30;
        String r34 = r33.a;
    L31:
        r111.append(r34);
        lvb.a.e(r32, r111.toString());
        r7.L$0 = r19;
        r7.Z$0 = r18;
        r7.label = 1;
        Object r35 = r16.w(r17, r18, r19, r7);
        if (r35 == r8) goto L67;
        r11 = r18;
        r2 = r19;
        r10 = r35;
        goto L35
    L67:
        return r8;
    L30:
        r34 = null;
        goto L31
    L26:
        r113 = null;
        goto L27
    L22:
        r110 = null;
    L7:
        r4 = new MmStandaloneAIInterpretationRepo$updateSetting$1(r16, r20);
        goto L8
    }

    public static final Object p(MmStandaloneAIInterpretationRepo r17, String r18, c r19, c r20, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.h r21, Continuation r22) {
        r17.getClass();
        if ((r22 instanceof MmStandaloneAIInterpretationRepo$rollbackLanguageSwitch$1) == false) goto L7;
        MmStandaloneAIInterpretationRepo$rollbackLanguageSwitch$1 r3 = (MmStandaloneAIInterpretationRepo$rollbackLanguageSwitch$1) r22;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        Object r2 = r3.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r3.label;
        boolean r7 = false;
        if (r6 == 0) goto L20;
        if (r6 == 1) goto L19;
        if (r6 == 2) goto L18;
        if (r6 == 3) goto L17;
        if (r6 != 4) goto L16;
        int r1 = r3.I$2;
        int r8 = r3.I$1;
        int r9 = r3.I$0;
        ResultKt.throwOnFailure(r2);
    L71:
        int r10 = r1;
        int r11 = r9;
        int r12 = r8;
    L72:
        String r0 = r17.l;
        StringBuilder r13 = new StringBuilder("[rollbackLanguageSwitch] closeAccepted=");
        if (r11 == 0) goto L75;
        boolean r14 = true;
    L76:
        r13.append(r14);
        r13.append(", sourceAccepted=");
        if (r12 == 0) goto L79;
        boolean r15 = true;
    L80:
        r13.append(r15);
        r13.append(", targetAccepted=");
        if (r10 == 0) goto L83;
        boolean r16 = true;
    L84:
        r13.append(r16);
        lvb.a.e(r0, r13.toString());
        if (r11 == 0) goto L90;
        if (r12 == 0) goto L90;
        if (r10 == 0) goto L90;
        r7 = true;
    L90:
        return Boxing.boxBoolean(r7);
    L83:
        r16 = false;
        goto L84
    L79:
        r15 = false;
        goto L80
    L75:
        r14 = false;
        goto L76
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        int r23 = r3.I$1;
        int r24 = r3.I$0;
        ResultKt.throwOnFailure(r2);
        r12 = r23;
        r11 = r24;
    L55:
        g r25 = (g) r2;
        if (r25 != null) goto L58;
    L60:
        r10 = 0;
    L61:
        if (r25 != null) goto L63;
    L65:
        boolean r110 = false;
    L66:
        if (r110 == false) goto L72;
        MmStandaloneAIInterpretationRepo$rollbackLanguageSwitch$2 r111 = new MmStandaloneAIInterpretationRepo$rollbackLanguageSwitch$2(r17, r25, null);
        r3.I$0 = r11;
        r3.I$1 = r12;
        r3.I$2 = r10;
        r3.label = 4;
        if (r17.e.b(r111, r3) == r5) goto L95;
        r9 = r11;
        r8 = r12;
        r1 = r10;
        goto L71
    L95:
        return r5;
    L63:
        if (r25.a() != true) goto L65;
        r110 = true;
        goto L66
    L58:
        if (r25.a() != true) goto L60;
        r10 = 1;
        goto L61
    L18:
        r11 = r3.I$0;
        c r26 = (c) r3.L$1;
        String r112 = (String) r3.L$0;
        ResultKt.throwOnFailure(r2);
        Object r27 = ((Result) r2).unbox-impl();
    L34:
        Throwable r113 = Result.exceptionOrNull-impl(r27);
        if (r113 == null) goto L38;
        lvb.a.b(r17.l, "[rollbackLanguageSwitch] source failed: " + r113);
    L38:
        if (Result.isFailure-impl(r27) == false) goto L40;
        r27 = null;
    L40:
        UpdateLiveRecordingSettingResponse r28 = (UpdateLiveRecordingSettingResponse) r27;
        if (r28 == null) goto L43;
        UpdateLiveRecordingSettingResponse.Status r29 = r28.mstatus;
    L45:
        if (r29 != UpdateLiveRecordingSettingResponse.Status.SUCCESS) goto L47;
        int r30 = 1;
    L49:
        if (r17.j.g().a() == true) goto L51;
        lvb.a.e(r17.l, "[rollbackLanguageSwitch] skip enabling old language, session ended");
        return Boxing.boxBoolean(false);
    L51:
        r3.L$0 = null;
        r3.L$1 = null;
        r3.I$0 = r11;
        r3.I$1 = r30;
        r3.label = 3;
        Object r31 = r17.v(r112, true, r26, r3);
        if (r31 == r5) goto L94;
        r12 = r30;
        r2 = r31;
        goto L55
    L94:
        return r5;
    L47:
        r30 = 0;
        goto L49
    L43:
        r29 = null;
        goto L45
    L19:
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.h r32 = (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.h) r3.L$2;
        c r33 = (c) r3.L$1;
        String r114 = (String) r3.L$0;
        ResultKt.throwOnFailure(r2);
        Object r34 = r2;
        c r35 = r33;
    L24:
        g r36 = (g) r34;
        if (r36 != null) goto L27;
    L29:
        int r37 = 0;
    L30:
        MmRecordingNetHelper r115 = r17.k.G();
        r3.L$0 = r114;
        r3.L$1 = r35;
        r3.L$2 = null;
        r3.I$0 = r37;
        r3.label = 2;
        Object r38 = r115.e(r114, r32, r3);
        if (r38 == r5) goto L93;
        r112 = r114;
        c r116 = r35;
        r27 = r38;
        r11 = r37;
        r26 = r116;
        goto L34
    L93:
        return r5;
    L27:
        if (r36.a() != true) goto L29;
        r37 = 1;
        goto L30
    L20:
        ResultKt.throwOnFailure(r2);
        r3.L$0 = r18;
        r35 = r20;
        r3.L$1 = r35;
        r3.L$2 = r21;
        r3.label = 1;
        Object r117 = r17.v(r18, false, r19, r3);
        if (r117 == r5) goto L92;
        r114 = r18;
        r32 = r21;
        r34 = r117;
        goto L24
    L92:
        return r5;
    L7:
        r3 = new MmStandaloneAIInterpretationRepo$rollbackLanguageSwitch$1(r17, r22);
        goto L8
    }
}
