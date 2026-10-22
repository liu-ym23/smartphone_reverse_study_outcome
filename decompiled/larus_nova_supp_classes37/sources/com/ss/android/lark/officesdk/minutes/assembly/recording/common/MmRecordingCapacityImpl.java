package com.ss.android.lark.officesdk.minutes.assembly.recording.common;

import android.app.Activity;
import android.content.Context;
import com.larus.office.minutes.impl.MinutesServiceImpl;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.officesdk.container.OfficeSDKUserScope;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.EndRecordingReason;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmAIInterpretationEventType;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmOfflineRecordingItem;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingCreateMode;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingError;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingTerminateReason;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.officesdk.minutes.api.recording.doubao.applet.route.MmRecordingPageOpenSource;
import com.ss.android.lark.officesdk.minutes.assembly.recording.common.hardware.MmHardwareCallRecordingFloatController$tryShow$1;
import com.ss.android.lark.officesdk.minutes.assembly.recording.common.hardware.MmHardwareCallRecordingStartDelegate;
import com.ss.android.lark.officesdk.minutes.assembly.recording.common.hardware.MmHardwareLiveRecordingCapacityDelegate;
import com.ss.android.lark.officesdk.minutes.assembly.recording.common.router.MmRecordPageRouter;
import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.thread.MMCoroutines;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSession;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSessionManager;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.data.RecordingSessionType;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.data.TerminateReason;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.orchestrator.RecordingPriorityDecisionEngine;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.MmRecordingRepo;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.MmAIInterpretationRepo;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.p;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.MmRecordingEndWindowRepo;
import iub.j;
import iub.k;
import iub.n;
import iub.r;
import iub.s;
import iub.t;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.inject.Inject;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.d1;
import kotlinx.coroutines.flow.g1;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@OfficeSDKUserScope
public final class MmRecordingCapacityImpl implements hub.a, tub.a {
    public static final /* synthetic */ int n = 0;

    @Inject
    public com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a a;
    public final CoroutineScope b;
    public final MutableSharedFlow<iub.b> c;
    public final String d;
    public final ConcurrentHashMap<String, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.g> e;
    public final AtomicBoolean f;
    public final Lazy g;
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;
    public final Lazy k;
    public final Lazy l;
    public final Lazy m;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[MmRecordingCreateMode.values().length];
            r0[MmRecordingCreateMode.DEFAULT_RTC.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L30:
            r0[MmRecordingCreateMode.OFFLINE_LOCAL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L38:
            r0[MmRecordingCreateMode.HARDWARE_LIVE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L8:
            a = r0;
            int[] r1 = new int[MmRecordPageRouter.RecordingPageRouteResult.values().length];
            r1[MmRecordPageRouter.RecordingPageRouteResult.SUCCESS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L20
        L32:
            r1[MmRecordPageRouter.RecordingPageRouteResult.RECORDING_NOT_FOUND.ordinal()] = 2;     // Catch: NoSuchFieldError -> L21
        L40:
            r1[MmRecordPageRouter.RecordingPageRouteResult.SESSION_NOT_ACTIVE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L22
        L26:
            r1[MmRecordPageRouter.RecordingPageRouteResult.NAVIGATOR_ROUTE_FAILED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L23
        L34:
            r1[MmRecordPageRouter.RecordingPageRouteResult.UNSUPPORTED_UI.ordinal()] = 5;     // Catch: NoSuchFieldError -> L24
        L28:
            r1[MmRecordPageRouter.RecordingPageRouteResult.ROUTE_FAILED.ordinal()] = 6;     // Catch: NoSuchFieldError -> L25
        L15:
            b = r1;
        }
    }

    static {
    }

    @Override // hub.a
    public final void V1() {
        lvb.a.e(this.d, "[terminateAllSessions]");
        MmRecordingSessionManager r0 = h();
        lvb.a.e(r0.b, "[terminateAllSessions] sessions=" + r0.e.keySet());
        Iterator<T> r1 = r0.e.values().iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        MmRecordingSession r2 = (MmRecordingSession) r1.next();
        if ((r2.g() instanceof com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.m) == true) goto L4;
        r2.u(new com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.a.n(TerminateReason.OTHERS));
        goto L4
    L8:
        MmRecordingSessionManager.c r3 = r0.j.getAndSet(null);
        r0.i.set(null);
        if (r3 != null) goto L11;
    L13:
        r0.h.set(false);
        return;
    L11:
        if (Intrinsics.areEqual(r0.s.getValue(), r3.c) == false) goto L13;
        r0.s.setValue(r3.b);
        goto L13
    }

    public final void g() {
        if (this.f.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        lvb.a.e(this.d, "[ensureRecordingPriorityInfrastructureRegistered]");
        MmHardwareCallRecordingStartDelegate r0 = new MmHardwareCallRecordingStartDelegate(this, this, i());
        i().L().j(r0);
        i().L().b(r0);
        i().w().f(new MmHardwareLiveRecordingCapacityDelegate(this));
    }

    public final MmRecordingSessionManager h() {
        return (MmRecordingSessionManager) this.g.getValue();
    }

    public final com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a i() {
        com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r0 = this.a;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("userComponentApi");
        return null;
    }

    @Override // hub.a
    public final i1<s> sa() {
        return (i1) this.i.getValue();
    }

    @Inject
    public MmRecordingCapacityImpl() {
        this.b = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        this.c = SharedFlowKt.MutableSharedFlow$default(0, 64, null, 4, null);
        this.d = "MmRecordingCapacityImpl_" + hashCode();
        this.e = new ConcurrentHashMap();
        this.f = new AtomicBoolean(false);
        this.g = LazyKt.lazy(new MmRecordingCapacityImpl$recordingSessionManage$2(this));
        this.h = LazyKt.lazy(new MmRecordingCapacityImpl$recordingPageRouter$2(this));
        this.i = LazyKt.lazy(new MmRecordingCapacityImpl$subtitleDataFlow$2(this));
        this.j = LazyKt.lazy(new MmRecordingCapacityImpl$recordingLanguageData$2(this));
        this.k = LazyKt.lazy(new MmRecordingCapacityImpl$recordingAIInterpretationData$2(this));
        this.l = LazyKt.lazy(new MmRecordingCapacityImpl$aiInterpretationEvents$2(this));
        this.m = LazyKt.lazy(new MmRecordingCapacityImpl$offlineRecordingStorage$2(this));
    }

    @Override // hub.a
    public final MutableSharedFlow A8() {
        return h().H;
    }

    @Override // hub.a
    public final b1 Bc() {
        StateFlowImpl r0 = h().u;
        CoroutineScope r1 = this.b;
        g1.a.getClass();
        return kotlinx.coroutines.flow.e.F(r0, r1, g1.a.c, new t(0));
    }

    @Override // hub.a
    public final StateFlowImpl E2() {
        return h().s;
    }

    @Override // hub.a
    public final MutableSharedFlow S6() {
        return h().z;
    }

    @Override // hub.a
    public final boolean Z0() {
        return h().h.get();
    }

    @Override // hub.a
    public final boolean isRecording() {
        MmRecordingSessionManager r0 = h();
        boolean r2 = false;
        if (r0.h.get() == false) goto L12;
        RecordingSessionType r1 = r0.i.get();
        if (r1 != null) goto L7;
    L9:
        boolean r3 = false;
    L10:
        if (r3 == false) goto L12;
        return true;
    L7:
        if (r1.isRecordingFeatureSession() != true) goto L9;
        r3 = true;
    L12:
        MmRecordingSession r4 = r0.e.get(r0.p);
        if (r4 == null) goto L20;
        RecordingSessionType r5 = r4.a;
        if (r5 == null) goto L20;
        if (r5.isRecordingFeatureSession() != true) goto L20;
        r2 = true;
    L20:
        return r2;
    }

    @Override // hub.a
    public final boolean j() {
        Collection<MmRecordingSession> r0 = h().e.values();
        if (r0.isEmpty() == true) goto L22;
        Iterator<T> r1 = r0.iterator();
    L7:
        if (r1.hasNext() == false) goto L23;
        MmRecordingSession r2 = (MmRecordingSession) r1.next();
        if (r2.a == RecordingSessionType.STANDALONE_AI_INTERPRETATION) goto L11;
    L13:
        boolean r3 = false;
    L14:
        if (r3 == false) goto L7;
        return true;
    L11:
        if (r2.g().a() == false) goto L13;
        r3 = true;
        goto L14
    L23:
        return false;
    L22:
        return false;
    }

    public final boolean k() {
        MmRecordingSessionManager r0 = h();
        if (r0.h.get() == true) goto L30;
        Collection<MmRecordingSession> r1 = r0.e.values();
        if (r1.isEmpty() == true) goto L20;
        Iterator<T> r2 = r1.iterator();
    L9:
        if (r2.hasNext() == false) goto L20;
        MmRecordingSession r3 = (MmRecordingSession) r2.next();
        if (r3.a.isRealTimeRecordingOrInterpretation() == true) goto L13;
    L17:
        boolean r4 = false;
    L18:
        if (r4 == false) goto L9;
        boolean r5 = true;
    L21:
        if (r5 == true) goto L31;
        return false;
    L31:
        return true;
    L13:
        if (Intrinsics.areEqual(r3.g(), com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.n.c) == true) goto L17;
        if ((r3.g() instanceof com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.m) == true) goto L17;
        r4 = true;
    L20:
        r5 = false;
        goto L21
    L30:
        return true;
    }

    @Override // hub.a
    public final i1<r> r5() {
        return h().r;
    }

    @Override // tub.a
    public final tub.c snapshot() {
        RecordingPriorityDecisionEngine r0 = i().v().a;
        monitor-enter(r0);
        tub.c r2 = new tub.c(CollectionsKt.toList(r0.d.values()));     // Catch: Throwable -> L7
        lvb.a.e(r0.c, "[snapshot] active=" + RecordingPriorityDecisionEngine.g(r2.a));     // Catch: Throwable -> L7
        monitor-exit(r0);
        return r2;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // hub.a
    @Deprecated(message = "Use hasActiveRecordingOrInterpretationSession() instead.", replaceWith = @ReplaceWith(expression = "hasActiveRecordingOrInterpretationSession()", imports = {}))
    public final boolean t3() {
        return k();
    }

    @Override // hub.a
    public final String u0() {
        return h().p;
    }

    public static void f(MmRecordingUILaunchMode r4) {
        MmRecordingUILaunchMode r0 = com.ss.android.lark.officesdk.minutes.service.foundation.utils.b.a;
        if (r4.shouldHandleUI() == false) goto L7;
        com.ss.android.lark.officesdk.minutes.ui.style.e.a.getClass();
        com.ss.android.lark.officesdk.minutes.ui.style.contract.h r1 = com.ss.android.lark.officesdk.minutes.ui.style.e.c(r4);
        if (r1 == null) goto L7;
        qub.h r2 = r1.getToast();
    L8:
        MmRecordingCapacityImpl$configureRecordToast$1 r3 = MmRecordingCapacityImpl$configureRecordToast$1.INSTANCE;
        Intrinsics.checkNotNullParameter(r4, "mode");
        Intrinsics.checkNotNullParameter(r3, "toastProviderResolver");
        MmRecordingUILaunchMode r5 = MmRecordingUILaunchMode.PURE_SDK;
        if (r4 != r5) goto L14;
        LarkAppContext.Companion.getClass();
        if (LarkAppContext.access$getInstance$cp().buildConfig().isLarkApp() == false) goto L13;
        MmRecordingUILaunchMode r6 = MmRecordingUILaunchMode.WITH_FEISHU_UI;
    L15:
        com.ss.android.lark.officesdk.minutes.service.foundation.utils.b.a = r6;
        if (r4 != r5) goto L21;
        qub.h r7 = (qub.h) r3.invoke(com.ss.android.lark.officesdk.minutes.service.foundation.utils.b.a);
        if (r7 == null) goto L21;
        r2 = r7;
    L21:
        com.ss.android.lark.officesdk.minutes.service.foundation.utils.b.b = r2;
        return;
    L13:
        r6 = MmRecordingUILaunchMode.WITH_DOUBAO_UI;
        goto L15
    L14:
        r6 = r4;
    L7:
        r2 = null;
        goto L8
    }

    @Override // hub.a
    public final Object x0(Continuation<? super List<MmOfflineRecordingItem>> r4) {
        return BuildersKt.withContext(MMCoroutines.a(), new MmRecordingCapacityImpl$getOfflineRecordingList$2(this, null), r4);
    }

    public static final Activity a(MmRecordingCapacityImpl r0, Activity r1) {
        r0.getClass();
        if (r1 != null) goto L5;
    L12:
        return null;
    L5:
        if (r1.isFinishing() == false) goto L7;
    L9:
        boolean r2 = false;
    L10:
        if (r2 == false) goto L12;
        return r1;
    L7:
        if (r1.isDestroyed() == true) goto L9;
        r2 = true;
        goto L10
    }

    public static final com.ss.android.lark.officesdk.minutes.assembly.recording.common.a c(MmRecordingCapacityImpl r5, String r6) {
        r5.getClass();
        if (StringsKt.isBlank(r6) == false) goto L5;
        lvb.a.h(r5.d, "[findAIInterpretationContext] ignored, recordingId is blank");
        m(r5, MmAIInterpretationEventType.RECORDING_NOT_FOUND, null, null, 14);
        return null;
    L5:
        MmRecordingSessionManager r0 = r5.h();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r6, "sessionId");
        MmRecordingSession r1 = r0.m(r6);
        if (r1 != null) goto L9;
        lvb.a.h(r5.d, "[findAIInterpretationContext] session not found, recordingId=".concat(r6));
        m(r5, MmAIInterpretationEventType.RECORDING_NOT_FOUND, null, null, 14);
        return null;
    L9:
        if (r1.a != RecordingSessionType.HARDWARE_RECORDING) goto L11;
        lvb.a.h(r5.d, "[findAIInterpretationContext] ignored hardware recording, recordingId=".concat(r6));
        m(r5, MmAIInterpretationEventType.ENTRY_UNAVAILABLE, null, null, 14);
        return null;
    L11:
        String r3 = r1.w.a;
        if (StringsKt.isBlank(r3) == false) goto L14;
        lvb.a.h(r5.d, "[findAIInterpretationContext] meetingId is blank, recordingId=".concat(r6));
        m(r5, MmAIInterpretationEventType.START_FAILED, null, "meetingId missing", 10);
        return null;
    L14:
        MmRecordingRepo r2 = r1.f();
        if (r2 == null) goto L19;
        MmAIInterpretationRepo r4 = r2.q();
        if (r4 == null) goto L19;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.a r7 = r4.n();
    L20:
        if (r7 != null) goto L23;
        lvb.a.h(r5.d, "[findAIInterpretationContext] ai repo unavailable, recordingId=".concat(r6));
        m(r5, MmAIInterpretationEventType.ENTRY_UNAVAILABLE, null, null, 14);
        return null;
    L23:
        return new com.ss.android.lark.officesdk.minutes.assembly.recording.common.a(r7, r6, r3);
    L19:
        r7 = null;
        goto L20
    }

    @Override // hub.a
    public final void Ja(String r5, iub.a<j, ? super MmRecordingError> r6) {
        Intrinsics.checkNotNullParameter(r5, "recordingId");
        Intrinsics.checkNotNullParameter(r6, "callback");
        lvb.a.e(this.d, "[pauseRecording]");
        MmRecordingSessionManager r2 = i().A();
        r2.getClass();
        Intrinsics.checkNotNullParameter(r5, "recordingId");
        Intrinsics.checkNotNullParameter(r6, "callback");
        MmRecordingSession r0 = r2.m(r5);
        if (r0 != null) goto L5;
        lvb.a.h(r2.b, "[pauseRecording] session not found, recordingId=" + r5);
        r6.a(MmRecordingError.RecordingNotFound.INSTANCE);
        return;
    L5:
        lvb.a.e(r2.b, "[pauseRecording] recordingId=" + r5);
        if (r0.u(com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.a.h.a) == false) goto L8;
        r6.onSuccess(new j(r5));
        return;
    L8:
        r6.a(MmRecordingError.StateError.INSTANCE);
    }

    @Override // hub.a
    public final Object Zd(String r4, Continuation<? super MmRecordingSource> r5) {
        return BuildersKt.withContext(MMCoroutines.a(), new MmRecordingCapacityImpl$getOfflineRecordingSource$2(this, r4, null), r5);
    }

    @Override // hub.a
    public final Object bf(String r4, Continuation<? super String> r5) {
        return BuildersKt.withContext(MMCoroutines.a(), new MmRecordingCapacityImpl$getOfflineRecordingFilePath$2(this, r4, null), r5);
    }

    @Override // hub.a
    public final void l1(String r5, iub.a<j, ? super MmRecordingError> r6) {
        Intrinsics.checkNotNullParameter(r5, "recordingId");
        Intrinsics.checkNotNullParameter(r6, "callback");
        lvb.a.e(this.d, "[resumeRecording]");
        MmRecordingSessionManager r2 = i().A();
        r2.getClass();
        Intrinsics.checkNotNullParameter(r5, "recordingId");
        Intrinsics.checkNotNullParameter(r6, "callback");
        MmRecordingSession r0 = r2.m(r5);
        if (r0 != null) goto L5;
        lvb.a.h(r2.b, "[resumeRecording] session not found, recordingId=" + r5);
        r2.p = "";
        r6.a(MmRecordingError.RecordingNotFound.INSTANCE);
        return;
    L5:
        lvb.a.e(r2.b, "[resumeRecording] recordingId=" + r5);
        if (r0.u(com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.a.i.a) == false) goto L8;
        r6.onSuccess(new j(r5));
        return;
    L8:
        r6.a(MmRecordingError.StateError.INSTANCE);
    }

    @Override // hub.a
    public final Object s2(String r4, Continuation<? super Unit> r5) {
        Object r6 = BuildersKt.withContext(MMCoroutines.a(), new MmRecordingCapacityImpl$removeOfflineRecording$2(this, r4, null), r5);
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r6;
    L6:
        return Unit.INSTANCE;
    }

    public static final Object b(MmRecordingCapacityImpl r2, com.ss.android.lark.officesdk.minutes.assembly.recording.common.a r3, Continuation r4) {
        r2.getClass();
        if ((!r3.a.m().b.isEmpty()) == true) goto L10;
        lvb.a.e(r2.d, "[ensureAIInterpretationSettingLoaded] meetingId=" + r3.c);
        Object r5 = r3.a.r0(r3.c, "", r4);
        if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L9;
        return r5;
    L9:
        return Unit.INSTANCE;
    L10:
        return Unit.INSTANCE;
    }

    public static final void d(MmRecordingCapacityImpl r15, String r16, MmRecordingUILaunchMode r17) {
        MmRecordingSessionManager r0 = r15.h();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r16, "sessionId");
        MmRecordingSession r2 = r0.m(r16);
        if (r2 != null) goto L5;
        lvb.a.b(r15.d, "[observeEndRecordingEvent] recordingId:" + r16 + ", session not found");
        return;
    L5:
        MmRecordingRepo r1 = r2.f();
        k r4 = r2.f;
        if (r4 == null) goto L8;
        MmRecordingSource r5 = r4.a;
    L9:
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.e r6 = com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.f.a;
        if (r5 != null) goto L12;
        int r7 = -1;
    L14:
        if (r7 != 1) goto L16;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.e r8 = com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.f.b;
    L18:
        if (r8.d == false) goto L22;
        lvb.a.e(r15.d, "[observeEndRecordingEvent] initialize recording repo without page, source=" + r5 + ", recordingId=" + r16);
        if (r1 == null) goto L22;
        r1.p();
    L22:
        if (r1 == null) goto L29;
        MmRecordingEndWindowRepo r3 = r1.u();
        if (r3 == null) goto L29;
        final d1<Object> r9 = r3.e();
        if (r9 == null) goto L29;
        Flow<Object> r10 = new MmRecordingCapacityImpl$observeEndRecordingEvent$$inlined$filterIsInstance$1(r9);
    L31:
        Ref.ObjectRef r11 = new Ref.ObjectRef();
        r11.element = BuildersKt.launch$default(r15.b, null, null, new MmRecordingCapacityImpl$observeEndRecordingEvent$1(r10, r2, r15, r17, r11, r16, null), 3, null);
        return;
    L29:
        if (r2.a != RecordingSessionType.STANDALONE_AI_INTERPRETATION) goto L32;
        final b1 r12 = r2.t;
        r10 = new MmRecordingCapacityImpl$observeEndRecordingEvent$$inlined$mapNotNull$1(r12);
        goto L31
    L32:
        lvb.a.b(r15.d, "[observeEndRecordingEvent] recordingId:" + r16 + ", end event flow is null");
        return;
    L16:
        r8 = com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.f.a;
        goto L18
    L12:
        r7 = com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.f.a.a[r5.ordinal()];
        goto L14
    L8:
        r5 = null;
        goto L9
    }

    @Override // hub.a
    public final void J2(String r4, EndRecordingReason r5, iub.a<j, ? super MmRecordingError> r6) {
        Intrinsics.checkNotNullParameter(r4, "recordingId");
        Intrinsics.checkNotNullParameter(r5, "endReason");
        Intrinsics.checkNotNullParameter(r6, "callback");
        lvb.a.e(this.d, "[endRecording] recordingId=" + r4 + ", endReason=" + r5);
        i().A().x(r4, r5, r6);
    }

    @Override // hub.a
    public final void Me(k r4, iub.a r5, sub.b r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "callback");
        g();
        lvb.a.e(this.d, "[startRecording] entry, mode=" + r4.f);
        f(r4.c);
        MmRecordingSessionManager r0 = i().A();
        int r1 = b.a[r4.f.ordinal()];
        if (r1 != 1) goto L5;
        RecordingSessionType r2 = RecordingSessionType.SOFTWARE_RECORDING;
    L13:
        r0.v(r2, r4, new e(this, r4, r5), r6);
        return;
    L5:
        if (r1 != 2) goto L7;
        r2 = RecordingSessionType.PRE_MEETING_NATIVE_RECORDING;
        goto L13
    L7:
        if (r1 != 3) goto L10;
        r2 = RecordingSessionType.HARDWARE_LIVE_RECORDING;
        goto L13
    L10:
        throw new NoWhenBranchMatchedException();
    }

    @Override // hub.a
    public final void S3(String r8, MmRecordingTerminateReason r9, iub.a<j, ? super MmRecordingError> r10) {
        Intrinsics.checkNotNullParameter(r8, "recordingId");
        Intrinsics.checkNotNullParameter(r9, "reason");
        Intrinsics.checkNotNullParameter(r10, "callback");
        lvb.a.e(this.d, "[terminateRecording] recordingId=" + r8 + ", reason=" + r9);
        MmRecordingSessionManager r3 = i().A();
        int r11 = g.a[r9.ordinal()];
        if (r11 != 1) goto L5;
        TerminateReason r12 = TerminateReason.HARDWARE_STOPPED;
    L13:
        r3.getClass();
        Intrinsics.checkNotNullParameter(r8, "recordingId");
        Intrinsics.checkNotNullParameter(r12, "reason");
        Intrinsics.checkNotNullParameter(r10, "callback");
        MmRecordingSession r0 = r3.m(r8);
        if (r0 != null) goto L16;
        lvb.a.h(r3.b, "[terminateRecording] session not found, recordingId=" + r8);
        r10.a(MmRecordingError.RecordingNotFound.INSTANCE);
        return;
    L16:
        lvb.a.e(r3.b, "[terminateRecording] recordingId=" + r8 + ", reason=" + r12);
        if (r0.u(new com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.a.n(r12)) == false) goto L19;
        r10.onSuccess(new j(r8));
        return;
    L19:
        r10.a(MmRecordingError.StateError.INSTANCE);
        return;
    L5:
        if (r11 != 2) goto L7;
        r12 = TerminateReason.HARDWARE_DISCONNECTED;
        goto L13
    L7:
        if (r11 != 3) goto L10;
        r12 = TerminateReason.PRIORITY_REPLACED;
        goto L13
    L10:
        throw new NoWhenBranchMatchedException();
    }

    @Override // hub.a
    public final void Y0(k r11, MinutesServiceImpl.h r12, sub.b r13) {
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r12, "callback");
        lvb.a.e(this.d, "[startStandaloneAIInterpretation] entry");
        f(r11.c);
        MmRecordingSessionManager r0 = i().A();
        MmRecordingSource r1 = r11.a;
        if (r1.isStandaloneAIInterpretationSource() == true) goto L6;
        r1 = null;
    L6:
        if (r1 != null) goto L8;
        r1 = MmRecordingSource.FEISHU_STANDALONE_AI_INTERPRETATION;
    L8:
        MmRecordingSource r3 = r1;
        MmRecordingCreateMode r8 = MmRecordingCreateMode.DEFAULT_RTC;
        Map<String, Object> r4 = r11.b;
        MmRecordingUILaunchMode r5 = r11.c;
        String r6 = r11.d;
        String r7 = r11.e;
        boolean r9 = r11.g;
        Intrinsics.checkNotNullParameter(r3, "source");
        Intrinsics.checkNotNullParameter(r4, "extra");
        Intrinsics.checkNotNullParameter(r5, "uiLaunchMode");
        Intrinsics.checkNotNullParameter(r6, "spokenLanguage");
        Intrinsics.checkNotNullParameter(r7, "translationLanguage");
        Intrinsics.checkNotNullParameter(r8, "mode");
        k r14 = new k(r3, r4, r5, r6, r7, r8, r9);
        r0.v(RecordingSessionType.STANDALONE_AI_INTERPRETATION, r14, new f(this, r14, r12), r13);
    }

    @Override // hub.a
    public final void ud(String r6, String r7, iub.a<j, ? super MmRecordingError> r8) {
        Intrinsics.checkNotNullParameter(r6, "recordingId");
        Intrinsics.checkNotNullParameter(r8, "callback");
        lvb.a.e(this.d, "[retryCreateRecording] recordingId=" + r6);
        MmRecordingSessionManager r2 = i().A();
        r2.getClass();
        Intrinsics.checkNotNullParameter(r6, "recordingId");
        Intrinsics.checkNotNullParameter(r8, "callback");
        MmRecordingSession r0 = r2.m(r6);
        if (r0 != null) goto L5;
        lvb.a.h(r2.b, "[retryCreateRecording] session not found, recordingId=" + r6);
        r8.a(MmRecordingError.RecordingNotFound.INSTANCE);
        return;
    L5:
        lvb.a.e(r2.b, "[retryCreateRecording] recordingId=" + r6 + ", type=" + r0.a);
        Intrinsics.checkNotNullParameter(r8, "callback");
        ((com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler.f) r0.y.getValue()).b(r7, r8);
    }

    public final void l(MmAIInterpretationEventType r11, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.g r12, String r13, int r14) {
        String r0 = null;
        if (r12 == null) goto L5;
        n r6 = new n(r12.a, r12.b);
    L6:
        iub.b r1 = new iub.b(r11, r6, r13, r14, 4);
        String r2 = this.d;
        StringBuilder r3 = new StringBuilder("[aiInterpretationEvent] type=");
        r3.append(r11);
        r3.append(", language=");
        if (r12 == null) goto L9;
        r0 = r12.a;
    L9:
        r3.append(r0);
        r3.append(", statusCode=");
        r3.append(r14);
        r3.append(", message=");
        r3.append(r13);
        lvb.a.e(r2, r3.toString());
        this.c.tryEmit(r1);
        return;
    L5:
        r6 = null;
        goto L6
    }

    @Override // hub.a
    public final void me(Context r7, String r8, MmRecordingUILaunchMode r9, MmHardwareCallRecordingFloatController$tryShow$1.a r10) {
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r8, "recordingId");
        Intrinsics.checkNotNullParameter(r9, "targetUiLaunchMode");
        Intrinsics.checkNotNullParameter(r10, "callback");
        lvb.a.e(this.d, "[showRecordingFloatWindow] recordingId=" + r8 + ", requestFloatPermission=false, targetUiLaunchMode=" + r9 + ", allowActivityFallback=true, preferSystemWindow=true");
        MmRecordingSessionManager r11 = h();
        r11.getClass();
        Intrinsics.checkNotNullParameter(r8, "sessionId");
        MmRecordingSession r12 = r11.m(r8);
        if (r12 != null) goto L5;
        lvb.a.h(this.d, "[showRecordingFloatWindow] session not found, recordingId=".concat(r8));
        qvb.a r13 = qvb.a.a;
        MmRecordingError.RecordingNotFound r14 = MmRecordingError.RecordingNotFound.INSTANCE;
        qvb.a.e(null, "show_float_window_failed", r14.getErrorMsg(), null, 9);
        r10.a(r14);
        return;
    L5:
        k r15 = r12.f;
        if (r15 == null) goto L9;
        MmRecordingUILaunchMode r16 = r15.c;
        if (r16 == null) goto L9;
    L11:
        if (r9 == MmRecordingUILaunchMode.UNKNOWN) goto L13;
        boolean r3 = true;
    L14:
        if (r3 == true) goto L17;
        r9 = null;
    L17:
        if (r9 != null) goto L19;
        r9 = r16;
    L19:
        com.ss.android.lark.officesdk.minutes.ui.style.e.a.getClass();
        com.ss.android.lark.officesdk.minutes.ui.style.e.b(r9).getCapability().d();
        lvb.a.h(this.d, "[showRecordingFloatWindow] unsupported uiLaunchMode=" + r9 + ", sessionUiLaunchMode=" + r16 + ", recordingId=" + r8);
        qvb.a r17 = qvb.a.a;
        StringBuilder r18 = new StringBuilder("unsupported_ui:");
        r18.append(r9);
        qvb.a.e(null, "show_float_window_failed", r18.toString(), null, 9);
        r10.a(MmRecordingError.StateError.INSTANCE);
        return;
    L13:
        r3 = false;
    L9:
        r16 = MmRecordingUILaunchMode.UNKNOWN;
        goto L11
    }

    @Override // hub.a
    public final void qd(Context r5, String r6, MmRecordingPageOpenSource r7, iub.a<j, ? super MmRecordingError> r8) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "recordingId");
        Intrinsics.checkNotNullParameter(r7, "openSource");
        Intrinsics.checkNotNullParameter(r8, "callback");
        MmRecordingUILaunchMode r0 = MmRecordingUILaunchMode.UNKNOWN;
        MmRecordingSessionManager r1 = h();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r6, "sessionId");
        MmRecordingSession r2 = r1.m(r6);
        if (r2 == null) goto L9;
        k r3 = r2.f;
        if (r3 == null) goto L9;
        MmRecordingUILaunchMode r4 = r3.c;
        if (r4 == null) goto L9;
        r0 = r4;
    L9:
        lvb.a.e(this.d, "[openRecordingPage] recordingId=" + r6 + ", uiLaunchMode=" + r0 + ", sessionUiLaunchMode=" + r0);
        MmRecordPageRouter.RecordingPageRouteResult r9 = ((MmRecordPageRouter) this.h.getValue()).a(r5, r6, r7, r0);
        if (r9.isSuccess() == true) goto L13;
        qvb.a r10 = qvb.a.a;
        qvb.a.e(null, "open_recording_page_failed", r9.name(), null, 9);
    L13:
        switch(b.b[r9.ordinal()]) {
            case 1: goto L20;
            case 2: goto L19;
            case 3: goto L18;
            case 4: goto L17;
            case 5: goto L16;
            case 6: goto L16;
            default: goto L15;
        };
    L16:
        r8.a(MmRecordingError.InternalError.INSTANCE);
        return;
    L17:
        r8.a(MmRecordingError.InternalError.INSTANCE);
        return;
    L18:
        r8.a(MmRecordingError.StateError.INSTANCE);
        return;
    L19:
        r8.a(MmRecordingError.RecordingNotFound.INSTANCE);
        return;
    L20:
        r8.onSuccess(new j(r6));
        return;
    L15:
        throw new NoWhenBranchMatchedException();
    }

    public static final Object e(MmRecordingCapacityImpl r5, com.ss.android.lark.officesdk.minutes.assembly.recording.common.a r6, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.g r7, boolean r8, Continuation r9) {
        r5.getClass();
        if ((r9 instanceof MmRecordingCapacityImpl$startAIInterpretation$3) == false) goto L7;
        MmRecordingCapacityImpl$startAIInterpretation$3 r0 = (MmRecordingCapacityImpl$startAIInterpretation$3) r9;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        String r4 = null;
        boolean r11 = true;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r7 = (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.g) r0.L$1;
        r6 = (com.ss.android.lark.officesdk.minutes.assembly.recording.common.a) r0.L$0;
        ResultKt.throwOnFailure(r10);
    L23:
        p r12 = (p) r10;
        r5.e.remove(r6.b);
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.d r13 = r6.a.m();
        int r14 = 0;
        if (r12 != null) goto L26;
    L28:
        boolean r15 = false;
    L29:
        if (r15 == true) goto L31;
    L38:
        boolean r16 = false;
    L39:
        if (r12 != null) goto L41;
    L43:
        r11 = false;
    L44:
        if (r11 == false) goto L46;
        MmAIInterpretationEventType r17 = MmAIInterpretationEventType.START_WAITING;
    L49:
        String r18 = r13.g;
        if (r18 != null) goto L52;
        r18 = "";
    L52:
        if (r12 == null) goto L54;
        r14 = r12.b;
    L54:
        r5.l(r17, r7, r18, r14);
        return Unit.INSTANCE;
    L46:
        if (r16 == true) goto L48;
        r17 = MmAIInterpretationEventType.START_FAILED;
        goto L49
    L48:
        r17 = MmAIInterpretationEventType.START_SUCCESS;
        goto L49
    L41:
        if (r12.b != 2) goto L43;
    L31:
        if (r13.a == false) goto L38;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.g r19 = r13.d;
        if (r19 == null) goto L36;
        r4 = r19.a;
    L36:
        if (Intrinsics.areEqual(r4, r7.a) == false) goto L38;
        r16 = true;
        goto L39
    L26:
        if (r12.a() != true) goto L28;
        r15 = true;
        goto L29
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r10);
        if (r7 != null) goto L20;
        if (r8 == false) goto L18;
        MmAIInterpretationEventType r20 = MmAIInterpretationEventType.LANGUAGE_LIST_EMPTY;
    L19:
        m(r5, r20, null, null, 14);
        return Unit.INSTANCE;
    L18:
        r20 = MmAIInterpretationEventType.NO_TARGET_LANGUAGE;
        goto L19
    L20:
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.a r21 = r6.a;
        String r22 = r6.c;
        r0.L$0 = r6;
        r0.L$1 = r7;
        r0.label = 1;
        r10 = com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.a.C0039a.a(r21, r22, true, r7, r0);
        if (r10 != r2) goto L23;
        return r2;
    L7:
        r0 = new MmRecordingCapacityImpl$startAIInterpretation$3(r5, r9);
        goto L8
    }

    public static /* synthetic */ void m(MmRecordingCapacityImpl r1, MmAIInterpretationEventType r2, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.g r3, String r4, int r5) {
        if ((r5 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = "";
    L8:
        r1.l(r2, r3, r4, 0);
    }
}
