package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.api.recording.doubao.DoubaoBizInfo;
import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.thread.MMCoroutines;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.core.error.MmCustomExceptionKt;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.mock.MmMockAwareRequestService;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.request.http.MmCreateAudioRequest;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.request.http.MmRecordingUpdateStatus;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.response.http.MmCreateAudioResponse;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.response.http.MmLookupRecordingByBizIdsResponse;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.response.http.MmUpdateAudioStatusResponse;
import com.ss.android.lark.officesdk.minutes.service.foundation.utils.net.MmNetworkUtils;
import com.ss.android.lark.officesdk.minutes.service.foundation.utils.settings.configs.MmUpdateStatusRetryConfig;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSession;
import com.ss.android.lark.utils.e0;
import iub.k;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import jvb.h;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MmRecordingStatesSyncService {
    public static final Companion q = null;
    public final MmRecordingSession a;
    public final com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a b;
    public final String c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final CoroutineScope g;
    public final CoroutineScope h;
    public final Job i;
    public final MmRecordingObjectReadyCoordinator j;
    public MmRecordingUpdateStatus k;
    public CompletableDeferred<Result<MmUpdateAudioStatusResponse>> l;
    public CompletableDeferred<Result<MmUpdateAudioStatusResponse>> m;
    public final StateFlowImpl n;
    public final b1 o;
    public final b1 p;

    public static final class Companion {
        public Companion() {
        }

        public final Object a(com.ss.android.lark.officesdk.minutes.service.foundation.network.b r6, String r7, MmRecordingSource r8, boolean r9, Continuation<? super Result<String>> r10) {
            if ((r10 instanceof MmRecordingStatesSyncService$Companion$lookupRecordingIdByMeetingId$1) == false) goto L7;
            MmRecordingStatesSyncService$Companion$lookupRecordingIdByMeetingId$1 r0 = (MmRecordingStatesSyncService$Companion$lookupRecordingIdByMeetingId$1) r10;
            int r1 = r0.label;
            if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
            r0.label = r1 - Integer.MIN_VALUE;
        L8:
            Object r11 = r0.result;
            Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r3 = r0.label;
            if (r3 == 0) goto L14;
            if (r3 != 1) goto L13;
            r7 = (String) r0.L$0;
            ResultKt.throwOnFailure(r11);
            Object r12 = ((Result) r11).unbox-impl();
        L22:
            if (Result.isSuccess-impl(r12) == false) goto L37;
            Iterator<T> r13 = ((MmLookupRecordingByBizIdsResponse) r12).getEntries().iterator();
        L24:
            String r14 = null;
            if (r13.hasNext() == false) goto L29;
            Object r15 = r13.next();
            if (Intrinsics.areEqual(((MmLookupRecordingByBizIdsResponse.Entry) r15).getBizId(), r7) == false) goto L24;
        L30:
            MmLookupRecordingByBizIdsResponse.Entry r16 = (MmLookupRecordingByBizIdsResponse.Entry) r15;
            if (r16 == null) goto L33;
            r14 = r16.getRecordingId();
        L33:
            if (r14 != null) goto L41;
            r14 = "";
        L41:
            return Result.constructor-impl(r14);
        L29:
            r15 = null;
            goto L30
        L37:
            return Result.constructor-impl(r12);
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r11);
            if (StringsKt.isBlank(r7) == false) goto L18;
            Result.Companion r17 = Result.Companion;
            return Result.constructor-impl(ResultKt.createFailure(new IllegalArgumentException("meetingId is blank")));
        L18:
            jvb.g r4 = new jvb.g(CollectionsKt.listOf(r7), r8, r9);
            r0.L$0 = r7;
            r0.label = 1;
            r12 = r6.c(MmLookupRecordingByBizIdsResponse.class, r4, r0);
            if (r12 != r2) goto L22;
            return r2;
        L7:
            r0 = new MmRecordingStatesSyncService$Companion$lookupRecordingIdByMeetingId$1(this, r10);
            goto L8
        }

        public final Object b(MmRecordingObjectReadyCoordinator r33, String r34, Function1<? super Continuation<? super Result<String>>, ? extends Object> r35, Function1<? super Result<String>, Unit> r36, Function1<? super Continuation<? super Unit>, ? extends Object> r37, Continuation<? super Result<String>> r38) {
            if ((r38 instanceof MmRecordingStatesSyncService$Companion$recoverDoubaoRecordingObject$1) == false) goto L7;
            MmRecordingStatesSyncService$Companion$recoverDoubaoRecordingObject$1 r1 = (MmRecordingStatesSyncService$Companion$recoverDoubaoRecordingObject$1) r38;
            int r2 = r1.label;
            if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
            r1.label = r2 - Integer.MIN_VALUE;
        L8:
            Object r0 = r1.result;
            Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r4 = r1.label;
            if (r4 == 0) goto L16;
            if (r4 == 1) goto L15;
            if (r4 != 2) goto L14;
            Object r5 = r1.L$0;
            ResultKt.throwOnFailure(r0);
            return r5;
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L15:
            Function1<? super Continuation<? super Unit>, ? extends Object> r6 = (Function1) r1.L$3;
            Function1<? super Result<String>, Unit> r7 = (Function1) r1.L$2;
            String r8 = (String) r1.L$1;
            MmRecordingObjectReadyCoordinator r9 = (MmRecordingObjectReadyCoordinator) r1.L$0;
            ResultKt.throwOnFailure(r0);
            String r12 = r8;
        L20:
            Object r10 = ((Result) r0).unbox-impl();
            if (r9.c() == false) goto L24;
            return r10;
        L24:
            if (Result.isFailure-impl(r10) == false) goto L26;
            Object r11 = null;
        L27:
            String r13 = (String) r11;
            if (r13 != null) goto L30;
            r13 = "";
        L30:
            Intrinsics.checkNotNullParameter(r13, "recordingId");
            Intrinsics.checkNotNullParameter(r12, "meetingId");
            if (MmRecordingObjectReadyCoordinator.b(r13) == true) goto L33;
            boolean r14 = false;
        L34:
            if (r14 == false) goto L36;
            return r10;
        L36:
            r7.invoke(Result.box-impl(r10));
            r1.L$0 = r10;
            r1.L$1 = r14;
            r1.L$2 = r14;
            r1.L$3 = 0;
            r1.label = 2;
            if (r6.invoke(r1) != r3) goto L40;
            return r3;
        L40:
            return r10;
        L33:
            r9.b.setValue(Result.box-impl(Result.constructor-impl(new MmCreateAudioResponse(null, r12, null, 0, 0, 0, false, 0, false, null, null, null, r13, null, 12285, null))));
            r14 = true;
            goto L34
        L26:
            r11 = r10;
            goto L27
        L16:
            ResultKt.throwOnFailure(r0);
            r1.L$0 = r33;
            r1.L$1 = r34;
            r7 = r36;
            r1.L$2 = r7;
            r1.L$3 = r37;
            r1.label = 1;
            Object r15 = r35.invoke(r1);
            if (r15 != r3) goto L19;
            return r3;
        L19:
            r12 = r34;
            r6 = r37;
            r9 = r33;
            r0 = r15;
        L7:
            r1 = new MmRecordingStatesSyncService$Companion$recoverDoubaoRecordingObject$1(this, r38);
            goto L8
        }

        public final Object c(com.ss.android.lark.officesdk.minutes.service.foundation.network.b r14, String r15, MmRecordingUpdateStatus r16, MmRecordingSource r17, Boolean r18, Long r19, boolean r20, Continuation<? super Result<MmUpdateAudioStatusResponse>> r21) {
            if ((r21 instanceof MmRecordingStatesSyncService$Companion$sendRecordingStatusRequest$1) == false) goto L7;
            MmRecordingStatesSyncService$Companion$sendRecordingStatusRequest$1 r1 = (MmRecordingStatesSyncService$Companion$sendRecordingStatusRequest$1) r21;
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
            h r5 = new h(r15, r16, r17, r18, r19, r20);
            r1.label = 1;
            Object r6 = r14.c(MmUpdateAudioStatusResponse.class, r5, r1);
            if (r6 != r3) goto L18;
            return r3;
        L18:
            return r6;
        L7:
            r1 = new MmRecordingStatesSyncService$Companion$sendRecordingStatusRequest$1(this, r21);
            goto L8
        }
    }

    public static final class a implements MmRecordingCreateService.a {
        public final /* synthetic */ MmRecordingStatesSyncService a;

        public a(MmRecordingStatesSyncService r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync.MmRecordingCreateService.a
        public final void a(Object r7) {
            lvb.a.e(this.a.c, "onMinutesTokenCreated: " + Result.toString-impl(r7));
            MmRecordingStatesSyncService r0 = this.a;
            if (Result.isSuccess-impl(r7) == false) goto L5;
            MmCreateAudioResponse r1 = (MmCreateAudioResponse) r7;
            r0.l().A(MapsKt.hashMapOf(new Pair[]{TuplesKt.to(r0.a.w.a, r1.getObjectToken())}));
            r0.n.setValue(Result.box-impl(Result.constructor-impl(r1)));
        L5:
            MmRecordingStatesSyncService r2 = this.a;
            Throwable r8 = Result.exceptionOrNull-impl(r7);
            if (r8 == null) goto L9;
            r2.n.setValue(Result.box-impl(Result.constructor-impl(ResultKt.createFailure(r8))));
            return;
        }

        @Override // com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync.MmRecordingCreateService.a
        public final void b(Object r6) {
            lvb.a.e(this.a.c, "onRecordingIdCreated: " + Result.toString-impl(r6));
            StateFlowImpl r0 = this.a.j.b;
            Throwable r1 = Result.exceptionOrNull-impl(r6);
            if (r1 != null) goto L9;
            MmCreateAudioResponse r2 = (MmCreateAudioResponse) r6;
            if (MmRecordingObjectReadyCoordinator.b(r2.getRecordingId()) == false) goto L7;
            Object r3 = Result.constructor-impl(r2);
        L8:
            Result r4 = Result.box-impl(r3);
        L10:
            r0.setValue(r4);
            MmRecordingStatesSyncService r5 = this.a;
            if (Result.isSuccess-impl(r6) == false) goto L16;
            MmCreateAudioResponse r7 = (MmCreateAudioResponse) r6;
            if ((!StringsKt.isBlank(r7.getObjectToken())) == false) goto L17;
            r5.l().A(MapsKt.hashMapOf(new Pair[]{TuplesKt.to(r5.a.w.a, r7.getObjectToken())}));
            r5.n.setValue(Result.box-impl(Result.constructor-impl(r7)));
            return;
        L17:
            return;
        L16:
            return;
        L7:
            r3 = Result.constructor-impl(ResultKt.createFailure(new IllegalStateException("create succeeded without recording id")));
            goto L8
        L9:
            r4 = Result.box-impl(Result.constructor-impl(ResultKt.createFailure(r1)));
            goto L10
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[MmRecordingUpdateStatus.values().length];
            r0[MmRecordingUpdateStatus.RECORD_RESUME.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[MmRecordingUpdateStatus.RECORD_PAUSE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[MmRecordingUpdateStatus.RECORD_FINISH.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[MmRecordingUpdateStatus.UPLOAD_COMPLETED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    static {
        q = new Companion();
    }

    public final Deferred<Result<MmUpdateAudioStatusResponse>> E() {
        return BuildersKt.async$default(this.h, null, null, new MmRecordingStatesSyncService$syncRecordFinishStatusForAutoSaveCheck$1(this, null), 3, null);
    }

    public final void J() {
        Intrinsics.checkNotNullParameter("uploadQueueEmpty", "trigger");
        BuildersKt.launch$default(this.h, null, null, new MmRecordingStatesSyncService$syncUploadCompletedStatusIfNeeded$1(this, "uploadQueueEmpty", null), 3, null);
    }

    public final e l() {
        return (e) this.d.getValue();
    }

    public final MmRecordingSource p() {
        MmRecordingSession r0 = this.a;
        k r1 = r0.f;
        if (r1 == null) goto L7;
        MmRecordingSource r2 = r1.a;
        if (r2 == null) goto L7;
        return r2;
    L7:
        String r3 = r0.w.a;
        if ((!StringsKt.isBlank(r3)) == true) goto L11;
        r3 = null;
    L11:
        if (r3 == null) goto L15;
        MmRecordingSource r4 = r(r3);
        if (r4 == null) goto L15;
        return r4;
    L15:
        String r5 = this.a.e;
        if (r5 != null) goto L18;
    L25:
        return null;
    L18:
        if ((!StringsKt.isBlank(r5)) == true) goto L21;
        r5 = null;
    L21:
        if (r5 == null) goto L25;
        MmRecordingSource r6 = r(r5);
        if (r6 == null) goto L25;
        return r6;
    }

    public final boolean t() {
        return this.j.c();
    }

    public final void F(com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c r8) {
        Intrinsics.checkNotNullParameter(r8, "sessionState");
        BuildersKt.launch$default(this.h, null, null, new MmRecordingStatesSyncService$syncRecordingStatus$1(this, r8, null), 3, null);
    }

    public final Object d(Continuation<? super String> r5) {
        MmRecordingObjectReadyCoordinator r0 = this.j;
        final b1 r1 = r0.c;
        return kotlinx.coroutines.flow.e.t(new MmRecordingObjectReadyCoordinator$awaitRecordingId$$inlined$map$1(r1), new MmRecordingObjectReadyCoordinator$awaitRecordingId$3(r0, null), r5);
    }

    public final Object o(Continuation<? super Map<String, Long>> r4) {
        return BuildersKt.withContext(MMCoroutines.a(), new MmRecordingStatesSyncService$getOfflineRecordingIndex$2(this, null), r4);
    }

    public final MmRecordingSource q(String r5) {
        Intrinsics.checkNotNullParameter(r5, "meetingId");
        MmRecordingSource r0 = r(r5);
        lvb.a.e(this.c, "[recordingSource] get result, meetingId:" + r5 + ", source:" + r0);
        return r0;
    }

    public final MmRecordingSource r(String r4) {
        MmRecordingSource r0 = l().r(r4);
        if (r0 == null) goto L5;
        return r0;
    L5:
        String r1 = l().i(r4);
        if ((!StringsKt.isBlank(r1)) == true) goto L9;
        r1 = null;
    L9:
        if (r1 == null) goto L13;
        MmRecordingSource r2 = l().r(r1);
        if (r2 == null) goto L13;
        return r2;
    L13:
        String r5 = l().t(r4);
        if ((!StringsKt.isBlank(r5)) == true) goto L17;
        r5 = null;
    L17:
        if (r5 != null) goto L19;
        return null;
    L19:
        return l().r(r5);
    }

    public final String s(String r5) {
        Intrinsics.checkNotNullParameter(r5, "meetingId");
        String r0 = l().u(r5);
        lvb.a.e(this.c, "[standaloneAIInterpretationRecordingId] get result, meetingId:" + r5 + ", recordingId:" + r0);
        return r0;
    }

    public final void x(String r8) {
        Intrinsics.checkNotNullParameter(r8, "sessionKey");
        BuildersKt.launch$default(this.g, null, null, new MmRecordingStatesSyncService$removeOfflineRecordingIndex$1(this, r8, null), 3, null);
    }

    public MmRecordingStatesSyncService(MmRecordingSession r5, com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r6) {
        Intrinsics.checkNotNullParameter(r5, "recordingSession");
        Intrinsics.checkNotNullParameter(r6, "userComponentContext");
        this.a = r5;
        this.b = r6;
        this.c = "MmRecordingStatesSyncService_" + hashCode();
        this.d = LazyKt.lazy(new MmRecordingStatesSyncService$localStorage$2(this));
        Lazy r7 = LazyKt.lazy(new MmRecordingStatesSyncService$createAudioService$2(this));
        this.e = r7;
        this.f = LazyKt.lazy(new MmRecordingStatesSyncService$networkService$2(this));
        CoroutineScope r8 = CoroutineScopeKt.CoroutineScope(MMCoroutines.a().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        this.g = r8;
        this.h = CoroutineScopeKt.CoroutineScope(MMCoroutines.b("mm_recording_sync_status"));
        MmRecordingObjectReadyCoordinator r1 = new MmRecordingObjectReadyCoordinator(r8);
        this.j = r1;
        StateFlowImpl r0 = j1.a(null);
        this.n = r0;
        this.o = kotlinx.coroutines.flow.e.b(r0);
        this.p = r1.c;
        Object r2 = MmNetworkUtils.a;
        this.i = MmNetworkUtils.c("syncStatus", r8, 500, new AnonymousClass1(this));
        ((MmRecordingCreateService) r7.getValue()).c = new a(this);
    }

    public static final Object b(MmRecordingStatesSyncService r7, Continuation r8) {
        r7.getClass();
        if ((r8 instanceof MmRecordingStatesSyncService$retryPendingStatusSync$1) == false) goto L7;
        MmRecordingStatesSyncService$retryPendingStatusSync$1 r0 = (MmRecordingStatesSyncService$retryPendingStatusSync$1) r8;
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
        ((Result) r9).unbox-impl();
    L29:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r9);
        ((Result) r9).unbox-impl();
    L31:
        return Unit.INSTANCE;
    L16:
        ResultKt.throwOnFailure(r9);
        MmRecordingUpdateStatus r10 = r7.k;
        if (r10 == null) goto L30;
        lvb.a.e(r7.c, "retrySyncStatus， statusAction:" + r10);
        if (r10 != MmRecordingUpdateStatus.UPLOAD_COMPLETED) goto L25;
        r0.label = 1;
        if (r7.K("networkRetry", r0) != r2) goto L31;
        return r2;
    L25:
        r0.label = 2;
        if (r7.G(r10, null, true, r0) != r2) goto L29;
        return r2;
    L30:
        return Unit.INSTANCE;
    L7:
        r0 = new MmRecordingStatesSyncService$retryPendingStatusSync$1(r7, r8);
        goto L8
    }

    public final void A(String r6, MmRecordingSource r7) {
        Intrinsics.checkNotNullParameter(r6, "meetingId");
        Intrinsics.checkNotNullParameter(r7, "source");
        if (r6.length() != 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L8;
        return;
    L8:
        lvb.a.e(this.c, "[recordingSource] save request, meetingId:" + r6 + ", source:" + r7);
        e r3 = l();
        r3.getClass();
        Intrinsics.checkNotNullParameter(r6, "meetingId");
        Intrinsics.checkNotNullParameter(r7, "source");
        lvb.a.e(r3.b, "[recordingSource] save, meetingId:" + r6 + ", source:" + r7);
        r3.a.H().putString("minutes_recording_v2_source_prefix".concat(r6), r7.name());
        return;
    L5:
        r2 = false;
        goto L6
    }

    public final void B(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "recordingId");
        Intrinsics.checkNotNullParameter(r5, "traceId");
        lvb.a.e(this.c, "[recordingTraceId] save request, recordingId:" + r4 + ", traceId:" + r5);
        l().D(r4, r5);
    }

    public final void C(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "meetingId");
        Intrinsics.checkNotNullParameter(r5, "sessionKey");
        lvb.a.e(this.c, "[sourceSessionKey] save request, meetingId:" + r4 + ", sessionKey:" + r5);
        l().E(r4, r5);
    }

    public final void D(String r7, String r8) {
        Intrinsics.checkNotNullParameter(r7, "meetingId");
        Intrinsics.checkNotNullParameter(r8, "recordingId");
        lvb.a.e(this.c, "[standaloneAIInterpretationRecordingId] save request, meetingId:" + r7 + ", recordingId:" + r8);
        e r2 = l();
        r2.getClass();
        Intrinsics.checkNotNullParameter(r7, "meetingId");
        Intrinsics.checkNotNullParameter(r8, "recordingId");
        if (StringsKt.isBlank(r7) == false) goto L5;
        return;
    L5:
        if (StringsKt.isBlank(r8) == true) goto L19;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L9
        Map<String, String> r1 = MapsKt.toMutableMap(r2.v());     // Catch: Throwable -> L9
        r1.put(r7, r8);     // Catch: Throwable -> L9
        r2.g = r1;     // Catch: Throwable -> L9
        lvb.a.e(r2.b, "[standaloneAIInterpretationRecordingId] save, meetingId:" + r7 + ", recordingId:" + r8);     // Catch: Throwable -> L9
        r2.a.H().putString("minutes_recording_v2_standalone_ai_interpretation_recording_id_map_prefix", e0.c(r1));     // Catch: Throwable -> L9
        Object r3 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L9
    L11:
        Throwable r4 = Result.exceptionOrNull-impl(r3);
        if (r4 == null) goto L18;
        lvb.a.b(r2.b, "[standaloneAIInterpretationRecordingId] save failed, meetingId:" + r7 + ", recordingId:" + r8 + ", error:" + r4);
        return;
    L18:
        return;
    L9:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }

    public final Object I(String r12, Continuation<? super Result<MmUpdateAudioStatusResponse>> r13) {
        if ((r13 instanceof MmRecordingStatesSyncService$syncStandaloneDiscardUploadCompletedStatusIfNeeded$1) == false) goto L7;
        MmRecordingStatesSyncService$syncStandaloneDiscardUploadCompletedStatusIfNeeded$1 r0 = (MmRecordingStatesSyncService$syncStandaloneDiscardUploadCompletedStatusIfNeeded$1) r13;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r14 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        String r15 = (String) r0.L$1;
        String r4 = (String) r0.L$0;
        ResultKt.throwOnFailure(r14);
        Object r16 = ((Result) r14).unbox-impl();
    L36:
        if (Result.isSuccess-impl(r16) == false) goto L38;
        lvb.a.e(this.c, "[syncStandaloneDiscardUploadCompletedStatusIfNeeded] success, trigger:" + r4 + ", recordingId:" + r15);
    L45:
        return r16;
    L38:
        lvb.a.b(this.c, "[syncStandaloneDiscardUploadCompletedStatusIfNeeded] failed, trigger:" + r4 + ", recordingId:" + r15 + ", error:" + Result.exceptionOrNull-impl(r16));
        qvb.a r17 = qvb.a.a;
        Throwable r18 = Result.exceptionOrNull-impl(r16);
        if (r18 == null) goto L41;
        String r19 = r18.getMessage();
    L42:
        if (r19 != null) goto L44;
        r19 = "";
    L44:
        qvb.a.g("standalone_discard_upload_completed_sync_failed:".concat(r19), r4, null, 9);
        goto L45
    L41:
        r19 = null;
        goto L42
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r12 = (String) r0.L$0;
        ResultKt.throwOnFailure(r14);
    L19:
        String r110 = (String) r14;
        if (StringsKt.isBlank(r110) == false) goto L23;
        lvb.a.b(this.c, "[syncStandaloneDiscardUploadCompletedStatusIfNeeded] skip, recordingId is blank, trigger:" + r12);
        qvb.a.g("standalone_discard_upload_completed_recording_id_empty", r12, null, 9);
        Result.Companion r111 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(new Throwable("recording id empty")));
    L23:
        MmRecordingSource r5 = p();
        if (r5 != null) goto L31;
        k r6 = this.a.f;
        if (r6 == null) goto L28;
        r5 = r6.a;
    L29:
        if (r5 != null) goto L31;
        r5 = MmRecordingSource.FEISHU_STANDALONE_AI_INTERPRETATION;
        goto L31
    L28:
        r5 = null;
    L31:
        lvb.a.e(this.c, "[syncStandaloneDiscardUploadCompletedStatusIfNeeded] start, trigger:" + r12 + ", recordingId:" + r110 + ", source:" + r5);
        MmRecordingStatesSyncService$syncStandaloneDiscardUploadCompletedStatusIfNeeded$2 r7 = new MmRecordingStatesSyncService$syncStandaloneDiscardUploadCompletedStatusIfNeeded$2(this, r110, r5, null);
        r0.L$0 = r12;
        r0.L$1 = r110;
        r0.label = 2;
        Object r8 = MmCustomExceptionKt.a(3, r7, r0);
        if (r8 != r2) goto L34;
        return r2;
    L34:
        r4 = r12;
        r15 = r110;
        r16 = r8;
        goto L36
    L16:
        ResultKt.throwOnFailure(r14);
        r0.L$0 = r12;
        r0.label = 1;
        r14 = d(r0);
        if (r14 != r2) goto L19;
        return r2;
    L7:
        r0 = new MmRecordingStatesSyncService$syncStandaloneDiscardUploadCompletedStatusIfNeeded$1(this, r13);
        goto L8
    }

    public final Object K(String r14, Continuation<? super Result<MmUpdateAudioStatusResponse>> r15) {
        if ((r15 instanceof MmRecordingStatesSyncService$syncUploadCompletedStatusIfNeededInternal$1) == false) goto L7;
        MmRecordingStatesSyncService$syncUploadCompletedStatusIfNeededInternal$1 r0 = (MmRecordingStatesSyncService$syncUploadCompletedStatusIfNeededInternal$1) r15;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r16 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L22;
        if (r3 == 1) goto L21;
        if (r3 == 2) goto L20;
        if (r3 != 3) goto L19;
        String r17 = (String) r0.L$2;
        CompletableDeferred<Result<MmUpdateAudioStatusResponse>> r4 = (CompletableDeferred) r0.L$1;
        String r5 = (String) r0.L$0;
        ResultKt.throwOnFailure(r16);     // Catch: Throwable -> L16
        Object r18 = ((Result) r16).unbox-impl();     // Catch: Throwable -> L16
    L49:
        if (Result.isFailure-impl(r18) == false) goto L51;
        this.m = null;     // Catch: Throwable -> L16
    L57:
        r4.complete(Result.box-impl(r18));     // Catch: Throwable -> L16
        return r18;
    L51:
        l().b(r17);     // Catch: Throwable -> L16
        String r6 = l().t(r17);     // Catch: Throwable -> L16
        if ((!StringsKt.isBlank(r6)) == false) goto L54;
        l().b(r6);     // Catch: Throwable -> L16
    L54:
        String r19 = l().i(r17);     // Catch: Throwable -> L16
        if ((!StringsKt.isBlank(r19)) == false) goto L57;
        l().b(r19);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        th = th;
        r14 = r5;
        CompletableDeferred<Result<MmUpdateAudioStatusResponse>> r7 = r4;
    L61:
        lvb.a.b(this.c, "[syncUploadCompletedStatusIfNeeded] failed, trigger:" + r14 + ", error:" + th);
        this.m = null;
        qvb.a r8 = qvb.a.a;
        String r9 = th.getMessage();
        if (r9 != null) goto L64;
        r9 = "";
    L64:
        qvb.a.g("upload_completed_sync_failed:".concat(r9), r14, null, 9);
        Result.Companion r110 = Result.Companion;
        Object r111 = Result.constructor-impl(ResultKt.createFailure(th));
        r7.complete(Result.box-impl(r111));
        return r111;
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        CompletableDeferred<Result<MmUpdateAudioStatusResponse>> r112 = (CompletableDeferred) r0.L$1;
        String r10 = (String) r0.L$0;
        ResultKt.throwOnFailure(r16);
        r7 = r112;
        r14 = r10;
    L33:
        String r113 = ((ovb.b) r16).a;
        l().z(r113, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.i.c);
        e r11 = l();
        r11.getClass();
        Intrinsics.checkNotNullParameter(r113, "meetingId");
        if (StringsKt.isBlank(r113) == false) goto L66;
    L43:
        lvb.a.e(this.c, "[syncUploadCompletedStatusIfNeeded] start, trigger:" + r14 + ", meetingId:" + r113);
        MmRecordingUpdateStatus r12 = MmRecordingUpdateStatus.UPLOAD_COMPLETED;     // Catch: Throwable -> L60
        r0.L$0 = r14;     // Catch: Throwable -> L60
        r0.L$1 = r7;     // Catch: Throwable -> L60
        r0.L$2 = r113;     // Catch: Throwable -> L60
        r0.label = 3;     // Catch: Throwable -> L60
        Object r13 = G(r12, null, true, r0);     // Catch: Throwable -> L60
        if (r13 != r2) goto L47;
        return r2;
    L47:
        r4 = r7;
        r5 = r14;
        r17 = r113;
        r18 = r13;
    L60:
        th = th;
        goto L61
    L66:
        Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L38
        Set<String> r21 = CollectionsKt.toMutableSet(r11.n());     // Catch: Throwable -> L38
        r21.add(r113);     // Catch: Throwable -> L38
        r11.f = r21;     // Catch: Throwable -> L38
        lvb.a.e(r11.b, "[pendingUploadCompletedSync] save, meetingId:" + r113 + ", meetingIds:" + r21);     // Catch: Throwable -> L38
        r11.a.H().putString("minutes_recording_v2_pending_upload_completed_sync_prefix", e0.c(r21));     // Catch: Throwable -> L38
        Object r22 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L38
    L40:
        Throwable r23 = Result.exceptionOrNull-impl(r22);
        if (r23 == null) goto L43;
        lvb.a.b(r11.b, "[pendingUploadCompletedSync] save failed, meetingId:" + r113 + ", error:" + r23);
    L38:
        th = move-exception;
        Result.Companion r24 = Result.Companion;
        r22 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L40
    L21:
        ResultKt.throwOnFailure(r16);
    L28:
        return ((Result) r16).unbox-impl();
    L22:
        ResultKt.throwOnFailure(r16);
        CompletableDeferred<Result<MmUpdateAudioStatusResponse>> r114 = this.m;
        if (r114 == null) goto L29;
        lvb.a.e(this.c, "[syncUploadCompletedStatusIfNeeded] skip duplicate, trigger:" + r14 + ", isCompleted:" + r114.isCompleted());
        r0.label = 1;
        r16 = r114.await(r0);
        if (r16 != r2) goto L28;
        return r2;
    L29:
        CompletableDeferred<Result<MmUpdateAudioStatusResponse>> r115 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        this.m = r115;
        MmRecordingSession r25 = this.a;
        r0.L$0 = r14;
        r0.L$1 = r115;
        r0.label = 2;
        Object r26 = r25.r(r0);
        if (r26 != r2) goto L32;
        return r2;
    L32:
        r7 = r115;
        r16 = r26;
    L7:
        r0 = new MmRecordingStatesSyncService$syncUploadCompletedStatusIfNeededInternal$1(this, r15);
        goto L8
    }

    public final Object e(String r4, Continuation<? super Unit> r5) {
        Object r6 = BuildersKt.withContext(MMCoroutines.a(), new MmRecordingStatesSyncService$clearKVCacheAndAwait$2(this, r4, null), r5);
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r6;
    L6:
        return Unit.INSTANCE;
    }

    public final void h(String r3, DoubaoBizInfo r4) {
        Intrinsics.checkNotNullParameter(r3, "meetingId");
        u("createOrQuery", new MmRecordingStatesSyncService$createOrQueryRecordObject$1(this, r3, r4, null));
    }

    public final Object m(String r4, Continuation<? super String> r5) {
        return BuildersKt.withContext(MMCoroutines.a(), new MmRecordingStatesSyncService$getOfflineRecordingAudioPath$2(this, r4, null), r5);
    }

    public final Object n(String r4, Continuation<? super String> r5) {
        return BuildersKt.withContext(MMCoroutines.a(), new MmRecordingStatesSyncService$getOfflineRecordingHardwareDeviceId$2(this, r4, null), r5);
    }

    public final void u(String r4, Function1<? super Continuation<? super Unit>, ? extends Object> r5) {
        MmRecordingObjectReadyCoordinator r0 = this.j;
        MmRecordingStatesSyncService$launchRecordingObjectReadyTask$1 r1 = new MmRecordingStatesSyncService$launchRecordingObjectReadyTask$1(this, r4, r5, null);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "block");
        CompletableDeferred r6 = CompletableDeferredKt.CompletableDeferred(r0.a.getCoroutineContext().get(Job.Key));
        r0.d.c(new MmRecordingObjectReadyCoordinator$launchTask$1(r6, r1, null));
    }

    public final void v(String r8, String r9) {
        Intrinsics.checkNotNullParameter(r8, "sessionKey");
        BuildersKt.launch$default(this.g, null, null, new MmRecordingStatesSyncService$putOfflineRecordingAudioPath$1(this, r8, r9, null), 3, null);
    }

    public final void y(String r8, DoubaoBizInfo r9) {
        Intrinsics.checkNotNullParameter(r8, "meetingId");
        Intrinsics.checkNotNullParameter(r9, "doubaoBizInfo");
        BuildersKt.launch$default(this.g, null, null, new MmRecordingStatesSyncService$saveDoubaoBizInfo$1(this, r8, r9, null), 3, null);
    }

    public final void z(String r7, String r8) {
        Intrinsics.checkNotNullParameter(r7, "sessionKey");
        Intrinsics.checkNotNullParameter(r8, "meetingId");
        lvb.a.e(this.c, "[nativeLocalBoundMeeting] save request, sessionKey:" + r7 + ", meetingId:" + r8);
        e r2 = l();
        r2.getClass();
        Intrinsics.checkNotNullParameter(r7, "sessionKey");
        Intrinsics.checkNotNullParameter(r8, "meetingId");
        if (StringsKt.isBlank(r7) == false) goto L5;
        return;
    L5:
        if (StringsKt.isBlank(r8) == true) goto L19;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L9
        Map<String, String> r1 = MapsKt.toMutableMap(r2.j());     // Catch: Throwable -> L9
        r1.put(r7, r8);     // Catch: Throwable -> L9
        r2.e = r1;     // Catch: Throwable -> L9
        lvb.a.e(r2.b, "[nativeLocalBoundMeeting] save, sessionKey:" + r7 + ", meetingId:" + r8);     // Catch: Throwable -> L9
        r2.a.H().putString("minutes_recording_v2_native_local_bound_map_prefix", e0.c(r1));     // Catch: Throwable -> L9
        Object r3 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L9
    L11:
        Throwable r4 = Result.exceptionOrNull-impl(r3);
        if (r4 == null) goto L18;
        lvb.a.b(r2.b, "[nativeLocalBoundMeeting] save failed, sessionKey:" + r7 + ", meetingId:" + r8 + ", error:" + r4);
        return;
    L18:
        return;
    L9:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }

    public static /* synthetic */ Object H(MmRecordingStatesSyncService r2, MmRecordingUpdateStatus r3, Continuation r4) {
        return r2.G(r3, null, true, r4);
    }

    public static void L(MmRecordingUpdateStatus r1, String r2, boolean r3) {
        qvb.a r0 = qvb.a.a;
        String r4 = r1.name() + ':' + r2;
        if (r3 == false) goto L5;
        String r5 = "warn";
    L6:
        qvb.a.g("status_sync_failed", r4, r5, 1);
        return;
    L5:
        r5 = "error";
        goto L6
    }

    public static final Object a(MmRecordingStatesSyncService r7, String r8, Continuation r9) {
        r7.getClass();
        if ((r9 instanceof MmRecordingStatesSyncService$lookupRecordingIdByMeetingId$1) == false) goto L7;
        MmRecordingStatesSyncService$lookupRecordingIdByMeetingId$1 r0 = (MmRecordingStatesSyncService$lookupRecordingIdByMeetingId$1) r9;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        MmRecordingStatesSyncService$lookupRecordingIdByMeetingId$1 r6 = r0;
        Object r10 = r6.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r6.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r10);
        Object r11 = ((Result) r10).unbox-impl();
    L18:
        return r11;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r10);
        Companion r4 = q;
        com.ss.android.lark.officesdk.minutes.service.foundation.network.b r12 = (com.ss.android.lark.officesdk.minutes.service.foundation.network.b) r7.f.getValue();
        MmRecordingSource r5 = r7.p();
        boolean r13 = r7.a.v();
        r6.label = 1;
        r11 = r4.a(r12, r8, r5, r13, r6);
        if (r11 != r2) goto L18;
        return r2;
    L7:
        r0 = new MmRecordingStatesSyncService$lookupRecordingIdByMeetingId$1(r7, r9);
        goto L8
    }

    public static final Object c(MmRecordingStatesSyncService r9, String r10, Continuation r11) {
        r9.getClass();
        if ((r11 instanceof MmRecordingStatesSyncService$syncRecordFinishStatusIfNeeded$1) == false) goto L7;
        MmRecordingStatesSyncService$syncRecordFinishStatusIfNeeded$1 r0 = (MmRecordingStatesSyncService$syncRecordFinishStatusIfNeeded$1) r11;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L20;
        if (r3 == 1) goto L19;
        if (r3 != 2) goto L18;
        CompletableDeferred<Result<MmUpdateAudioStatusResponse>> r13 = (CompletableDeferred) r0.L$1;
        String r4 = (String) r0.L$0;
        ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L15
        Object r5 = ((Result) r12).unbox-impl();     // Catch: Throwable -> L15
    L31:
        r13.complete(Result.box-impl(r5));     // Catch: Throwable -> L15
        return r5;
    L15:
        Throwable th = th;
        String r8 = r4;
        CompletableDeferred<Result<MmUpdateAudioStatusResponse>> r6 = r13;
        r10 = r8;
    L36:
        lvb.a.b(r9.c, "[syncRecordFinishStatusIfNeeded] failed, trigger:" + r10 + ", error:" + th);
        qvb.a r14 = qvb.a.a;
        String r15 = th.getMessage();
        if (r15 != null) goto L39;
        r15 = "";
    L39:
        qvb.a.g("record_finish_sync_failed:".concat(r15), r10, null, 9);
        Result.Companion r16 = Result.Companion;
        Object r7 = Result.constructor-impl(ResultKt.createFailure(th));
        r6.complete(Result.box-impl(r7));
        return r7;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        ResultKt.throwOnFailure(r12);
    L45:
        return ((Result) r12).unbox-impl();
    L20:
        ResultKt.throwOnFailure(r12);
        CompletableDeferred<Result<MmUpdateAudioStatusResponse>> r17 = r9.l;
        if (r17 == null) goto L26;
        lvb.a.e(r9.c, "[syncRecordFinishStatusIfNeeded] skip duplicate, trigger:" + r10 + ", isCompleted:" + r17.isCompleted());
        r0.label = 1;
        r12 = r17.await(r0);
        if (r12 != r2) goto L45;
        return r2;
    L26:
        CompletableDeferred<Result<MmUpdateAudioStatusResponse>> r18 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        r9.l = r18;
        lvb.a.e(r9.c, "[syncRecordFinishStatusIfNeeded] start, trigger:" + r10);
        MmRecordingUpdateStatus r19 = MmRecordingUpdateStatus.RECORD_FINISH;     // Catch: Throwable -> L34
        r0.L$0 = r10;     // Catch: Throwable -> L34
        r0.L$1 = r18;     // Catch: Throwable -> L34
        r0.label = 2;     // Catch: Throwable -> L34
        Object r20 = r9.G(r19, null, true, r0);     // Catch: Throwable -> L34
        if (r20 == r2) goto L47;
        r5 = r20;
        r4 = r10;
        r13 = r18;
        goto L31
    L47:
        return r2;
    L34:
        th = move-exception;
        r6 = r18;
        th = th;
    L7:
        r0 = new MmRecordingStatesSyncService$syncRecordFinishStatusIfNeeded$1(r9, r11);
        goto L8
    }

    public final Object f(String r4, String r5, Continuation<? super Unit> r6) {
        Object r7 = BuildersKt.withContext(MMCoroutines.a(), new MmRecordingStatesSyncService$clearStandaloneAIInterpretationLocalArtifacts$2(r5, this, r4, null), r6);
        if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r7;
    L6:
        return Unit.INSTANCE;
    }

    public final void w(String r12, long r13, String r15) {
        Intrinsics.checkNotNullParameter(r12, "sessionKey");
        Intrinsics.checkNotNullParameter(r15, "hardwareDeviceId");
        BuildersKt.launch$default(this.g, null, null, new MmRecordingStatesSyncService$putOfflineRecordingIndex$1(this, r12, r13, r15, null), 3, null);
    }

    public static /* synthetic */ void j(MmRecordingStatesSyncService r6, String r7, Function0 r8, DoubaoBizInfo r9) {
        r6.i(r7, 3, r8, r9, "");
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:95:0x0342 -> B:96:0x0356). Please report as a decompilation issue!!! */
    public final Object G(MmRecordingUpdateStatus r27, Boolean r28, boolean r29, Continuation<? super Result<MmUpdateAudioStatusResponse>> r30) {
        MmRecordingUpdateStatus r1 = r27;
        Boolean r2 = r28;
        boolean r3 = r29;
        if ((r30 instanceof MmRecordingStatesSyncService$syncRecordingStatus$2) == false) goto L7;
        MmRecordingStatesSyncService$syncRecordingStatus$2 r5 = (MmRecordingStatesSyncService$syncRecordingStatus$2) r30;
        int r6 = r5.label;
        if ((r6 & Integer.MIN_VALUE) == 0) goto L7;
        r5.label = r6 - Integer.MIN_VALUE;
    L8:
        Object r4 = r5.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r7 = r5.label;
        Companion r16 = q;
        String r8 = "[syncRecordingStatus] id: ";
        if (r7 == 0) goto L22;
        if (r7 == 1) goto L21;
        if (r7 == 2) goto L20;
        if (r7 == 3) goto L19;
        if (r7 == 4) goto L18;
        if (r7 != 5) goto L17;
        int r9 = r5.I$0;
        boolean r10 = r5.Z$1;
        boolean r11 = r5.Z$0;
        MmUpdateStatusRetryConfig r12 = (MmUpdateStatusRetryConfig) r5.L$5;
        Long r13 = (Long) r5.L$4;
        String r14 = (String) r5.L$3;
        MmRecordingSource r17 = (MmRecordingSource) r5.L$2;
        Boolean r18 = (Boolean) r5.L$1;
        MmRecordingUpdateStatus r19 = (MmRecordingUpdateStatus) r5.L$0;
        ResultKt.throwOnFailure(r4);
        Object r20 = ((Result) r4).unbox-impl();
        Boolean r21 = r18;
        String r110 = ", statusAction:";
        MmRecordingStatesSyncService r111 = this;
        int r0 = r9;
        boolean r22 = r10;
        String r23 = "[syncRecordingStatus] id: ";
        MmUpdateStatusRetryConfig r24 = r12;
        String r25 = r14;
        MmRecordingUpdateStatus r112 = r19;
        Long r113 = r13;
        MmRecordingSource r26 = r17;
    L96:
        String r114 = r111.c;
        boolean r210 = r22;
        StringBuilder r31 = new StringBuilder(r23);
        r31.append(r25);
        r31.append(r110);
        r31.append(r112);
        r31.append(", success:");
        r31.append(Result.isSuccess-impl(r20));
        lvb.a.e(r114, r31.toString());
        int r115 = r0 - 1;
        boolean r32 = r210;
        r8 = r23;
    L61:
        if (Result.isFailure-impl(r20) == false) goto L98;
        if (r115 <= 0) goto L98;
        int r33 = r111.a.g().a;
        int r34 = b.a[r112.ordinal()];
        if (r34 == 1) goto L81;
        if (r34 == 2) goto L81;
        if (r34 == 3) goto L76;
        if (r34 == 4) goto L73;
    L85:
        boolean r35 = false;
    L86:
        MmRecordingStatesSyncService r116 = r111;
        Object r117 = r15;
        lvb.a.e(r111.c, "checkStatesActionValid result:" + r35 + ",  currentStateValue:" + r33 + r110 + r112);
        if (r35 == false) goto L100;
        String r36 = r110;
        boolean r37 = r32;
        long r118 = ((long) r24.getIntervalInSecs()) + Random.Default.nextLong(0, 2000);
        r5.L$0 = r112;
        r5.L$1 = r21;
        r5.L$2 = r26;
        r5.L$3 = r25;
        r5.L$4 = r113;
        r5.L$5 = r24;
        r5.Z$0 = r11;
        r5.Z$1 = r37;
        r0 = r115;
        r5.I$0 = r0;
        r5.label = 4;
        if (DelayKt.delay(r118, r5) != r117) goto L91;
        return r117;
    L91:
        boolean r119 = r37;
        MmUpdateStatusRetryConfig r120 = r24;
        MmRecordingUpdateStatus r38 = r112;
        Long r121 = r113;
        Object r39 = r117;
        String r122 = r8;
        boolean r123 = r11;
        MmRecordingStatesSyncService$syncRecordingStatus$2 r124 = r5;
        MmRecordingSource r40 = r26;
        String r41 = r36;
        Boolean r42 = r21;
        String r43 = r25;
        MmRecordingStatesSyncService r44 = r116;
    L92:
        String r45 = r44.c;
        StringBuilder r46 = new StringBuilder(r122);
        r46.append(r43);
        r46.append(r41);
        r46.append(r38);
        String r125 = r41;
        r46.append(", retry: ");
        r46.append(r0);
        lvb.a.e(r45, r46.toString());
        MmMockAwareRequestService r47 = r44.b.M();
        r124.L$0 = r38;
        r124.L$1 = r42;
        r124.L$2 = r40;
        r124.L$3 = r43;
        r124.L$4 = r121;
        r124.L$5 = r120;
        r124.Z$0 = r123;
        r124.Z$1 = r119;
        r124.I$0 = r0;
        r124.label = 5;
        Object r48 = r39;
        MmRecordingSource r126 = r40;
        MmRecordingStatesSyncService r127 = r44;
        MmRecordingUpdateStatus r211 = r38;
        String r212 = r43;
        Boolean r213 = r42;
        Long r214 = r121;
        r20 = r16.c(r47, r43, r38, r126, r42, r121, r119, r124);
        if (r20 != r48) goto L95;
        return r48;
    L95:
        r11 = r123;
        r5 = r124;
        r24 = r120;
        r23 = r122;
        r26 = r126;
        r111 = r127;
        r112 = r211;
        r25 = r212;
        r21 = r213;
        r113 = r214;
        r15 = r48;
        r22 = r119;
        r110 = r125;
    L100:
        if (Result.isFailure-impl(r20) == false) goto L112;
        if (r11 == false) goto L112;
        if (r112 != MmRecordingUpdateStatus.UPLOAD_COMPLETED) goto L105;
    L108:
        boolean r49 = true;
    L109:
        if (r49 == false) goto L111;
        MmRecordingStatesSyncService r128 = r116;
        r128.k = r112;
        lvb.a.h(r128.c, "[syncRecordingStatus] recordingStatusIdentity: " + r25 + r110 + r112 + " failed, will retry when network is available");
        L(r112, r25, true);
    L127:
        return r20;
    L111:
        lvb.a.b(r116.c, "[syncRecordingStatus] recordingStatusIdentity: " + r25 + r110 + r112 + " failed");
        L(r112, r25, false);
        goto L127
    L105:
        if (r112 == MmRecordingUpdateStatus.RECORD_FINISH) goto L108;
        r49 = false;
    L112:
        MmRecordingStatesSyncService r129 = r116;
        String r130 = r110;
        if (Result.isSuccess-impl(r20) == false) goto L127;
        lvb.a.e(r129.c, "[syncRecordingStatus] recordingStatusIdentity: " + r25 + r130 + r112 + ", success:true");
        MmRecordingUpdateStatus r50 = MmRecordingUpdateStatus.UPLOAD_COMPLETED;
        if (r112 != r50) goto L117;
    L120:
        boolean r51 = true;
    L121:
        if (r51 == true) goto L123;
    L125:
        if (r112 != r50) goto L127;
        r129.a.u(com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.a.o.a);
        goto L127
    L123:
        if (r129.k != r112) goto L125;
        r129.k = null;
        goto L125
    L117:
        if (r112 == MmRecordingUpdateStatus.RECORD_FINISH) goto L120;
        r51 = false;
        goto L121
    L73:
        if (r33 < 8) goto L85;
    L84:
        r35 = true;
        goto L86
    L76:
        if (r33 < 8) goto L85;
        if (r33 >= com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.n.c.a) goto L85;
    L81:
        if (r33 < com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.l.c.a) goto L85;
        if (r33 >= 8) goto L85;
    L98:
        r116 = r111;
        goto L100
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        int r52 = r5.I$0;
        boolean r53 = r5.Z$1;
        boolean r54 = r5.Z$0;
        MmUpdateStatusRetryConfig r55 = (MmUpdateStatusRetryConfig) r5.L$5;
        Long r56 = (Long) r5.L$4;
        String r131 = (String) r5.L$3;
        MmRecordingSource r132 = (MmRecordingSource) r5.L$2;
        Boolean r133 = (Boolean) r5.L$1;
        MmRecordingUpdateStatus r134 = (MmRecordingUpdateStatus) r5.L$0;
        ResultKt.throwOnFailure(r4);
        r119 = r53;
        r43 = r131;
        r39 = r15;
        r122 = "[syncRecordingStatus] id: ";
        r121 = r56;
        r42 = r133;
        r38 = r134;
        r124 = r5;
        r120 = r55;
        r40 = r132;
        r44 = this;
        r0 = r52;
        r123 = r54;
        r41 = ", statusAction:";
        goto L92
    L19:
        r32 = r5.Z$1;
        boolean r57 = r5.Z$0;
        Long r58 = (Long) r5.L$4;
        r25 = (String) r5.L$3;
        r26 = (MmRecordingSource) r5.L$2;
        Boolean r135 = (Boolean) r5.L$1;
        r112 = (MmRecordingUpdateStatus) r5.L$0;
        ResultKt.throwOnFailure(r4);
        r20 = ((Result) r4).unbox-impl();
        Long r215 = r58;
        r11 = r57;
    L59:
        r24 = this.b.getSettingsService().d;
        r111 = this;
        r21 = r135;
        r110 = ", statusAction:";
        r113 = r215;
        r115 = 3;
        goto L61
    L20:
        boolean r59 = r5.Z$1;
        boolean r60 = r5.Z$0;
        MmRecordingSource r61 = (MmRecordingSource) r5.L$2;
        Boolean r62 = (Boolean) r5.L$1;
        MmRecordingUpdateStatus r63 = (MmRecordingUpdateStatus) r5.L$0;
        ResultKt.throwOnFailure(r4);
        boolean r64 = r59;
        r1 = r63;
        Object r65 = r4;
        MmRecordingSource r66 = r61;
        r3 = r60;
        r2 = r62;
    L31:
        MmCreateAudioResponse r67 = (MmCreateAudioResponse) r65;
        if (r67 == null) goto L36;
        String r68 = r67.getObjectToken();
        if (r68 == null) goto L36;
    L37:
        MmRecordingUpdateStatus r136 = r1;
        Boolean r137 = r2;
        boolean r69 = r3;
        r32 = r64;
        String r70 = r68;
    L39:
        if (r70.length() != 0) goto L41;
        boolean r71 = true;
    L42:
        if (r71 == false) goto L46;
        lvb.a.e(this.c, "[syncRecordingStatus] id empty, return");
        qvb.a r72 = qvb.a.a;
        qvb.a.g("recording_identity_empty", r136.name(), null, 9);
        Result.Companion r73 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(new Throwable("recording id empty")));
    L46:
        if (r136 != MmRecordingUpdateStatus.RECORD_FINISH) goto L54;
        if (r66 != null) goto L49;
    L51:
        boolean r74 = false;
    L52:
        if (r74 == false) goto L54;
        Long r138 = (Long) this.a.p.getValue();
    L55:
        lvb.a.e(this.c, "[syncRecordingStatus] id: " + r70 + ", start statusAction:" + r136 + ", durationMs:" + r138);
        MmMockAwareRequestService r75 = this.b.M();
        r5.L$0 = r136;
        r5.L$1 = r137;
        r5.L$2 = r66;
        r5.L$3 = r70;
        r5.L$4 = r138;
        r5.Z$0 = r69;
        r5.Z$1 = r32;
        r5.label = 3;
        boolean r216 = r69;
        r215 = r138;
        MmRecordingUpdateStatus r139 = r136;
        Boolean r140 = r137;
        Object r76 = r16.c(r75, r70, r136, r66, r137, r215, r32, r5);
        if (r76 != r15) goto L58;
        return r15;
    L58:
        r26 = r66;
        r20 = r76;
        r112 = r139;
        r135 = r140;
        r25 = r70;
        r11 = r216;
        goto L59
    L49:
        if (r66.isStandaloneAIInterpretationSource() != true) goto L51;
        r74 = true;
    L54:
        r138 = null;
        goto L55
    L41:
        r71 = false;
    L36:
        r68 = "";
        goto L37
    L21:
        boolean r77 = r5.Z$1;
        boolean r78 = r5.Z$0;
        MmRecordingSource r79 = (MmRecordingSource) r5.L$2;
        Boolean r80 = (Boolean) r5.L$1;
        MmRecordingUpdateStatus r81 = (MmRecordingUpdateStatus) r5.L$0;
        ResultKt.throwOnFailure(r4);
        r64 = r77;
        r1 = r81;
        Object r82 = r4;
        r66 = r79;
        r3 = r78;
        r2 = r80;
    L27:
        r136 = r1;
        r137 = r2;
        r69 = r3;
        r32 = r64;
        r70 = (String) r82;
        goto L39
    L22:
        ResultKt.throwOnFailure(r4);
        r66 = p();
        r64 = this.a.v();
        if (r64 == false) goto L28;
        r5.L$0 = r1;
        r5.L$1 = r2;
        r5.L$2 = r66;
        r5.Z$0 = r3;
        r5.Z$1 = r64;
        r5.label = 1;
        r82 = d(r5);
        if (r82 != r15) goto L27;
        return r15;
    L28:
        final b1 r83 = this.o;
        Flow<MmCreateAudioResponse> r141 = new MmRecordingStatesSyncService$syncRecordingStatusBWLJW6A$$inlined$map$1(r83);
        MmRecordingStatesSyncService$syncRecordingStatus$idForStatus$2 r84 = new MmRecordingStatesSyncService$syncRecordingStatus$idForStatus$2(null);
        r5.L$0 = r1;
        r5.L$1 = r2;
        r5.L$2 = r66;
        r5.Z$0 = r3;
        r5.Z$1 = r64;
        r5.label = 2;
        r65 = kotlinx.coroutines.flow.e.t(r141, r84, r5);
        if (r65 != r15) goto L31;
        return r15;
    L7:
        r5 = new MmRecordingStatesSyncService$syncRecordingStatus$2(this, r30);
        goto L8
    }

    public final Object g(final String r17, DoubaoBizInfo r18, String r19, Continuation<? super Unit> r20) {
        if ((r20 instanceof MmRecordingStatesSyncService$createOrLookupRecordingId$1) == false) goto L7;
        MmRecordingStatesSyncService$createOrLookupRecordingId$1 r1 = (MmRecordingStatesSyncService$createOrLookupRecordingId$1) r20;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        MmRecordingStatesSyncService$createOrLookupRecordingId$1 r13 = r1;
        Object r0 = r13.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r13.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r0);
        ((Result) r0).unbox-impl();
    L18:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        Companion r8 = q;
        MmRecordingObjectReadyCoordinator r10 = this.j;
        MmRecordingStatesSyncService$createOrLookupRecordingId$2 r11 = new MmRecordingStatesSyncService$createOrLookupRecordingId$2(this, r17, null);
        Function1<Result<? extends String>, Unit> r12 = new MmRecordingStatesSyncService$createOrLookupRecordingId$3(this, r17);
        MmRecordingStatesSyncService$createOrLookupRecordingId$4 r15 = new MmRecordingStatesSyncService$createOrLookupRecordingId$4(this, r17, r18, r19, null);
        r13.label = 1;
        if (r8.b(r10, r17, r11, r12, r15, r13) != r14) goto L18;
        return r14;
    L7:
        r1 = new MmRecordingStatesSyncService$createOrLookupRecordingId$1(this, r20);
        goto L8
    }

    public final void i(String r10, int r11, Function0<? extends MmCreateAudioRequest.CreateMinutesStatus> r12, DoubaoBizInfo r13, String r14) {
        Intrinsics.checkNotNullParameter(r10, "meetingId");
        Intrinsics.checkNotNullParameter(r14, "recordingId");
        u("create", new MmRecordingStatesSyncService$createRecordingObject$1(this, r10, r11, r12, r13, r14, null));
    }

    public final Object k(String r10, int r11, Function0<? extends MmCreateAudioRequest.CreateMinutesStatus> r12, DoubaoBizInfo r13, String r14, Continuation<? super Unit> r15) {
        MmRecordingSource r5 = p();
        if (r5 == null) goto L5;
        A(r10, r5);
    L5:
        MmRecordingCreateService r0 = (MmRecordingCreateService) this.e.getValue();
        if (r13 == null) goto L8;
        DoubaoBizInfo r16 = r13.withHostAppVersion();
    L9:
        DoubaoBizInfo r4 = r16;
        if (StringsKt.isBlank(r14) == false) goto L12;
        r14 = this.a.w.c;
    L12:
        Object r17 = r0.c(r10, r11, r12, r4, r5, r14, this.a.v(), r15);
        if (r17 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L16;
        return r17;
    L16:
        return Unit.INSTANCE;
    L8:
        r16 = null;
        goto L9
    }
}
