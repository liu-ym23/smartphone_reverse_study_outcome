package com.ss.android.lark.officesdk.minutes.service.recording.common.core;

import com.google.gson.Gson;
import com.larksuite.framework.utils.k0;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.EndRecordingReason;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingError;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingState;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.officesdk.minutes.api.recording.doubao.DoubaoBizInfo;
import com.ss.android.lark.officesdk.minutes.service.fileupload.MmMinutesFileUploadSessionManager;
import com.ss.android.lark.officesdk.minutes.service.foundation.userscope.MinutesUCCImpl;
import com.ss.android.lark.officesdk.minutes.service.foundation.utils.cache.file.MmRecordFileHelper;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.data.MmRecordingRoute;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.data.RecordingSessionType;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.MinutesForegroundService;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.MmRecordingAudioPersistent;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync.e;
import com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.MmRecordingCommonParam;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.e0;
import com.ss.android.lark.vfs.VFSFile;
import eub.f;
import eub.g;
import iub.i;
import iub.j;
import iub.k;
import iub.l;
import iub.o;
import iub.p;
import iub.q;
import iub.r;
import iub.t;
import iub.u;
import iub.v;
import iub.w;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MmRecordingSessionManager {
    public static final /* synthetic */ int I = 0;
    public final MutableSharedFlow<p> A;
    public final MutableSharedFlow B;
    public final MutableSharedFlow<u> C;
    public final MutableSharedFlow D;
    public final MutableSharedFlow<v> E;
    public final MutableSharedFlow F;
    public final MutableSharedFlow<l> G;
    public final MutableSharedFlow H;
    public final com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a a;
    public final String b;
    public final CoroutineScope c;
    public CoroutineScope d;
    public final ConcurrentHashMap<String, MmRecordingSession> e;
    public final ConcurrentHashMap<String, String> f;
    public final ConcurrentHashMap<String, String> g;
    public final AtomicBoolean h;
    public final AtomicReference<RecordingSessionType> i;
    public final AtomicReference<c> j;
    public final ConcurrentHashMap<String, Job> k;
    public final ConcurrentHashMap<String, Job> l;
    public final ConcurrentHashMap<String, b> m;
    public final Set<String> n;
    public final AtomicBoolean o;
    public volatile String p;
    public final Lazy q;
    public final StateFlowImpl r;
    public final StateFlowImpl s;
    public final StateFlowImpl t;
    public final StateFlowImpl u;
    public final StateFlowImpl v;
    public final MutableSharedFlow<i> w;
    public final MutableSharedFlow x;
    public final MutableSharedFlow<o> y;
    public final MutableSharedFlow z;

    public static final class a {
    }

    public static final class b {
        public long a;

        public b() {
        }
    }

    public static final class c {
        public final RecordingSessionType a;
        public final q b;
        public final q c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
        }

        public final String toString() {
            return "StartingRecordingSnapshot(sessionType=" + this.a + ", previousSessionInfo=" + this.b + ", startingSessionInfo=" + this.c + ')';
        }

        public c(RecordingSessionType r2, q r3, q r4) {
            Intrinsics.checkNotNullParameter(r2, "sessionType");
            Intrinsics.checkNotNullParameter(r3, "previousSessionInfo");
            Intrinsics.checkNotNullParameter(r4, "startingSessionInfo");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public /* synthetic */ class d {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[MmRecordingSource.values().length];
            r0[MmRecordingSource.FEISHU_STANDALONE_AI_INTERPRETATION.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L12:
            r0[MmRecordingSource.DOUBAO_STANDALONE_AI_INTERPRETATION.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L5:
            a = r0;
            int[] r1 = new int[RecordingSessionType.values().length];
            r1[RecordingSessionType.HISTORY_RECORDING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L7:
            b = r1;
        }
    }

    static {
    }

    public final void g() {
        boolean r0 = n(MinutesForegroundService.ForegroundServiceOwner.RECORDING);
        boolean r1 = n(MinutesForegroundService.ForegroundServiceOwner.HARDWARE_LIVE_RECORDING);
        String r2 = this.b;
        StringBuilder r3 = new StringBuilder("[checkAndStopForegroundService], hasRecordingSession=");
        r3.append(r0);
        r3.append(", hasHardwareLiveSession=");
        r3.append(r1);
        r3.append(", sessions: ");
        ConcurrentHashMap<String, MmRecordingSession> r4 = this.e;
        ArrayList r5 = new ArrayList(r4.size());
        Iterator<Map.Entry<String, MmRecordingSession>> r6 = r4.entrySet().iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        Map.Entry<String, MmRecordingSession> r7 = r6.next();
        r5.add("id: " + r7.getKey() + ", state: " + r7.getValue().g());
        goto L4
    L6:
        r3.append(r5);
        lvb.a.e(r2, r3.toString());
        if (r0 == true) goto L9;
        w(MinutesForegroundService.ForegroundServiceOwner.RECORDING);
    L9:
        if (r1 == true) goto L13;
        w(MinutesForegroundService.ForegroundServiceOwner.HARDWARE_LIVE_RECORDING);
        return;
    }

    public final boolean p() {
        if (this.e.isEmpty() == false) goto L5;
        return false;
    L5:
        Collection<MmRecordingSession> r0 = this.e.values();
        if (r0.isEmpty() == false) goto L8;
    L7:
        return true;
    L8:
        Iterator<T> r1 = r0.iterator();
    L10:
        if (r1.hasNext() == false) goto L7;
        com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c r2 = ((MmRecordingSession) r1.next()).g();
        if (Intrinsics.areEqual(r2, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.n.c) == false) goto L14;
    L17:
        boolean r3 = true;
    L18:
        if (r3 == true) goto L10;
        return false;
    L14:
        if ((r2 instanceof com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.m) == true) goto L17;
        r3 = false;
        goto L18
    }

    public final void t() {
        if (this.o.compareAndSet(false, true) == true) goto L6;
        lvb.a.e(this.b, "[resumeHistoryRecording] skip, recovery is already running");
        return;
    L6:
        BuildersKt.launch$default(this.c, Dispatchers.getIO(), null, new MmRecordingSessionManager$resumeHistoryRecording$1(this, null), 2, null);
    }

    public MmRecordingSessionManager(MinutesUCCImpl r10) {
        Intrinsics.checkNotNullParameter(r10, "userComponentContext");
        this.a = r10;
        String r11 = "MmRecordingSessionManager_" + hashCode();
        this.b = r11;
        this.c = CoroutineScopeKt.MainScope();
        this.e = new ConcurrentHashMap();
        this.f = new ConcurrentHashMap();
        this.g = new ConcurrentHashMap();
        this.h = new AtomicBoolean(false);
        this.i = new AtomicReference();
        this.j = new AtomicReference();
        this.k = new ConcurrentHashMap();
        this.l = new ConcurrentHashMap();
        this.m = new ConcurrentHashMap();
        this.n = Collections.newSetFromMap(new ConcurrentHashMap());
        this.o = new AtomicBoolean(false);
        this.p = "";
        this.q = LazyKt.lazy(new MmRecordingSessionManager$preChecker$2(this));
        lvb.a.e(r11, "MmRecordingSessionManager init, " + hashCode());
        MmRecordingState r6 = MmRecordingState.IDLE;
        this.r = j1.a(new r(null, r6, r6, false, 25));
        this.s = j1.a(new q(null, false, 511));
        this.t = j1.a(TuplesKt.to("", new com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.d(0)));
        this.u = j1.a(new t(0));
        this.v = j1.a(new w(0));
        BufferOverflow r12 = BufferOverflow.DROP_OLDEST;
        MutableSharedFlow<i> r4 = SharedFlowKt.MutableSharedFlow(1, 16, r12);
        this.w = r4;
        this.x = r4;
        MutableSharedFlow<o> r5 = SharedFlowKt.MutableSharedFlow(1, 16, r12);
        this.y = r5;
        this.z = r5;
        MutableSharedFlow<p> r7 = SharedFlowKt.MutableSharedFlow(1, 16, r12);
        this.A = r7;
        this.B = r7;
        MutableSharedFlow<u> r8 = SharedFlowKt.MutableSharedFlow(1, 16, r12);
        this.C = r8;
        this.D = r8;
        MutableSharedFlow<v> r13 = SharedFlowKt.MutableSharedFlow(1, 16, r12);
        this.E = r13;
        this.F = r13;
        MutableSharedFlow<l> r14 = SharedFlowKt.MutableSharedFlow$default(0, 16, null, 5, null);
        this.G = r14;
        this.H = r14;
    }

    public final void i(CoroutineScope r3) {
        if (r3 == null) goto L6;
        CoroutineScopeKt.cancel$default(r3, null, 1, null);
    L6:
        if (this.d != r3) goto L9;
        this.d = null;
        return;
    }

    public final String j(MmRecordingSession r6) {
        ovb.b r0 = r6.w;
        Iterator<T> r1 = this.e.entrySet().iterator();
    L3:
        String r3 = null;
        if (r1.hasNext() == false) goto L11;
        Object r2 = r1.next();
        if (((Map.Entry) r2).getValue() != r6) goto L8;
        boolean r4 = true;
    L9:
        if (r4 == false) goto L3;
    L12:
        Map.Entry r5 = (Map.Entry) r2;
        if (r5 == null) goto L15;
        r3 = (String) r5.getKey();
    L15:
        if (r3 != null) goto L18;
        r3 = "";
    L18:
        return "mapKey=" + r3 + ", sessionType=" + r6.a + ", traceId=" + r6.c + ", recordingId=" + r0.c + ", meetingId=" + r0.a + ", resolvedRecordingId=" + r6.e();
    L8:
        r4 = false;
        goto L9
    L11:
        r2 = null;
        goto L12
    }

    public final MmRecordingSession m(String r6) {
        Object r1 = null;
        if (StringsKt.isBlank(r6) == false) goto L5;
        return null;
    L5:
        MmRecordingSession r0 = this.e.get(r6);
        if (r0 == null) goto L8;
        return r0;
    L8:
        Iterator<T> r2 = this.e.values().iterator();
    L10:
        if (r2.hasNext() == false) goto L25;
        Object r3 = r2.next();
        MmRecordingSession r4 = (MmRecordingSession) r3;
        ovb.b r5 = r4.w;
        if (Intrinsics.areEqual(r4.e(), r6) == false) goto L14;
    L21:
        boolean r7 = true;
    L22:
        if (r7 == false) goto L10;
        r1 = r3;
        goto L25
    L14:
        if (Intrinsics.areEqual(r5.c, r6) == true) goto L21;
        if (Intrinsics.areEqual(r5.a, r6) == true) goto L21;
        if (Intrinsics.areEqual(r5.d, r6) == true) goto L21;
        r7 = false;
    L25:
        return (MmRecordingSession) r1;
    }

    public final boolean n(MinutesForegroundService.ForegroundServiceOwner r7) {
        Collection<MmRecordingSession> r0 = this.e.values();
        if (r0.isEmpty() == true) goto L35;
        Iterator<T> r1 = r0.iterator();
    L7:
        if (r1.hasNext() == false) goto L36;
        MmRecordingSession r2 = (MmRecordingSession) r1.next();
        if (r2.a != RecordingSessionType.HARDWARE_LIVE_RECORDING) goto L11;
        MinutesForegroundService.ForegroundServiceOwner r3 = MinutesForegroundService.ForegroundServiceOwner.HARDWARE_LIVE_RECORDING;
    L13:
        if (r3 == r7) goto L15;
    L14:
        boolean r4 = false;
    L27:
        if (r4 == false) goto L7;
        return true;
    L15:
        com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c r5 = r2.g();
        RecordingSessionType r6 = r2.a;
        if (d.b[r6.ordinal()] != 1) goto L23;
        if ((r5 instanceof com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.b) == false) goto L20;
    L21:
        r4 = true;
        goto L27
    L20:
        if (Intrinsics.areEqual(r5, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.i.c) == false) goto L14;
    L23:
        if (Intrinsics.areEqual(r5, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.n.c) == true) goto L14;
        if ((r5 instanceof com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.m) == true) goto L14;
    L11:
        r3 = MinutesForegroundService.ForegroundServiceOwner.RECORDING;
        goto L13
    L36:
        return false;
    L35:
        return false;
    }

    public final boolean o(MmRecordingSession r6) {
        Collection<MmRecordingSession> r0 = this.e.values();
        if (r0.isEmpty() == true) goto L24;
        Iterator<T> r1 = r0.iterator();
    L7:
        if (r1.hasNext() == false) goto L25;
        MmRecordingSession r2 = (MmRecordingSession) r1.next();
        if (r2 != r6) goto L11;
    L15:
        boolean r3 = false;
    L16:
        if (r3 == false) goto L7;
        return true;
    L11:
        if (r2.a.isRealTimeRecordingOrInterpretation() == false) goto L15;
        if (r2.g().a() == false) goto L15;
        r3 = true;
        goto L16
    L25:
        return false;
    L24:
        return false;
    }

    public final Job q(MmRecordingSession r8) {
        if (r8.a.isRealTimeRecordingOrInterpretation() == false) goto L5;
        CoroutineScope r0 = r8.v;
    L7:
        return BuildersKt.launch$default(r0, null, null, new MmRecordingSessionManager$listenSessionTitle$1(r8, this, null), 3, null);
    L5:
        r0 = r8.u;
        goto L7
    }

    public final void r(MmRecordingSession r5) {
        String r0 = r5.e();
        lvb.a.e(this.b, "[removeSession] sessionId=" + r0);
        this.a.N().f(r0);
        this.e.remove(r0);
        if (r5.a != RecordingSessionType.HISTORY_RECORDING) goto L5;
        this.n.remove(r0);
    L5:
        this.m.remove(r0);
        r5.q();
        Job r1 = this.k.remove(r0);
        if (r1 == null) goto L8;
        Job.DefaultImpls.cancel$default(r1, null, 1, null);
    L8:
        Job r2 = this.l.remove(r0);
        if (r2 == null) goto L12;
        Job.DefaultImpls.cancel$default(r2, null, 1, null);
    L12:
        if (r5.a.isRealTimeRecordingOrInterpretation() == true) goto L14;
    L16:
        boolean r6 = false;
    L17:
        if (r6 == false) goto L23;
        this.p = "";
        CoroutineScope r7 = this.d;
        if (r7 == null) goto L21;
        CoroutineScopeKt.cancel$default(r7, null, 1, null);
    L21:
        this.d = null;
        return;
    L23:
        return;
    L14:
        if (Intrinsics.areEqual(r0, this.p) == false) goto L16;
        r6 = true;
        goto L17
    }

    public final void w(MinutesForegroundService.ForegroundServiceOwner r4) {
        lvb.a.e(this.b, "stopForegroundService owner=" + r4);
        MinutesForegroundService.Companion r0 = MinutesForegroundService.h;
        MinutesForegroundService.Companion.j(LarkContext.getApplication(), r4);
    }

    public static MmRecordingSource s(e r3, String r4) {
        MmRecordingSource r0 = r3.r(r4);
        if (r0 == null) goto L5;
        return r0;
    L5:
        String r1 = r3.i(r4);
        if ((!StringsKt.isBlank(r1)) == true) goto L9;
        r1 = null;
    L9:
        if (r1 == null) goto L13;
        MmRecordingSource r2 = r3.r(r1);
        if (r2 == null) goto L13;
        return r2;
    L13:
        String r5 = r3.t(r4);
        if ((!StringsKt.isBlank(r5)) == true) goto L17;
        r5 = null;
    L17:
        if (r5 != null) goto L19;
        return null;
    L19:
        return r3.r(r5);
    }

    public final void A(String r8, String r9) {
        Intrinsics.checkNotNullParameter(r8, "recordingId");
        if (StringsKt.isBlank(r8) == true) goto L14;
        if (r9 != null) goto L6;
    L9:
        boolean r0 = true;
    L10:
        if (r0 == true) goto L15;
        new e(this.a).C(r8, r9);
        i r1 = new i(r8, r9);
        BuildersKt.launch$default(this.c, null, null, new MmRecordingSessionManager$updateRecordingAudioFilePath$1(this, r1, null), 3, null);
        return;
    L15:
        return;
    L6:
        if (StringsKt.isBlank(r9) == true) goto L9;
        r0 = false;
        goto L10
    }

    public final void B(String r8, String r9) {
        Intrinsics.checkNotNullParameter(r8, "recordingId");
        if (StringsKt.isBlank(r8) == false) goto L5;
        return;
    L5:
        if (r9 != null) goto L8;
        r9 = "";
    L8:
        if (StringsKt.isBlank(r9) == false) goto L10;
        return;
    L10:
        BuildersKt.launch$default(this.c, null, null, new MmRecordingSessionManager$updateRecordingMeetingData$1(this, r8, r9, null), 3, null);
    }

    public static final void c(MmRecordingSessionManager r13, MmRecordingSession r14, Pair r15) {
        r13.getClass();
        com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c r2 = (com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c) r15.getFirst();
        com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c r6 = (com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c) r15.getSecond();
        r13.z(r14, r2, r6);
        if ((r6 instanceof com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.l) == false) goto L9;
        if (r14.a == RecordingSessionType.STANDALONE_AI_INTERPRETATION) goto L55;
        BuildersKt.launch$default(r13.c, null, null, new MmRecordingSessionManager$processRealtimeRecordingStateChange$1(r13, r14, r6, null), 3, null);
        return;
    L55:
        return;
    L9:
        if ((r6 instanceof com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.k) == false) goto L23;
        if (Intrinsics.areEqual(r2, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.h.c) == false) goto L14;
        MmRecordingState r16 = MmRecordingState.PAUSED;
    L18:
        MmRecordingState r7 = r16;
    L20:
        if (r7 == null) goto L49;
        BuildersKt.launch$default(r13.c, null, null, new MmRecordingSessionManager$processRealtimeRecordingStateChange$2(r13, r14, r6, r7, null), 3, null);
        return;
    L49:
        return;
    L14:
        if (r14.a == RecordingSessionType.STANDALONE_AI_INTERPRETATION) goto L16;
    L19:
        r7 = null;
        goto L20
    L16:
        if (Intrinsics.areEqual(r2, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.l.c) == false) goto L19;
        r16 = MmRecordingState.IDLE;
        goto L18
    L23:
        if ((r6 instanceof com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.h) == false) goto L26;
        BuildersKt.launch$default(r13.c, null, null, new MmRecordingSessionManager$processRealtimeRecordingStateChange$3(r13, r14, r6, null), 3, null);
        return;
    L26:
        if ((r6 instanceof com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.b) == false) goto L32;
        r13.p = "";
        Job r1 = r13.l.remove(r14.e());
        if (r1 == null) goto L30;
        Job.DefaultImpls.cancel$default(r1, null, 1, null);
    L30:
        r13.i(r13.d);
        r13.t.setValue(TuplesKt.to("", new com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.d(0)));
        BuildersKt.launch$default(r13.c, null, null, new MmRecordingSessionManager$processRealtimeRecordingStateChange$4(r2, r13, r14, r6, null), 3, null);
        return;
    L32:
        if ((r6 instanceof com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.n) == false) goto L35;
        BuildersKt.launch$default(r13.c, null, null, new MmRecordingSessionManager$processRealtimeRecordingStateChange$5(r13, r14, r6, null), 3, null);
        r13.g();
        return;
    L35:
        if ((r6 instanceof com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.m) == false) goto L54;
        String r8 = r14.e();
        Intrinsics.checkNotNullParameter(r8, "recordingId");
        Intrinsics.checkNotNullParameter(r2, "lastState");
        if (r2.a() == true) goto L39;
        r r9 = null;
    L44:
        if (r9 == null) goto L46;
        BuildersKt.launch$default(r13.c, null, null, new MmRecordingSessionManager$processRealtimeRecordingStateChange$6$1(r13, r14, r6, r9, null), 3, null);
    L46:
        lvb.a.e(r13.b, "[sessionStateChange] meetingId=" + r14.e() + " Terminated");
        r13.r(r14);
        r13.g();
        return;
    L39:
        MmRecordingState r10 = MmRecordingState.IDLE;
        if (Intrinsics.areEqual(r2, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.h.c) == false) goto L42;
        MmRecordingState r0 = MmRecordingState.PAUSED;
    L43:
        r9 = new r(r8, r10, r0, false, 24);
        goto L44
    L42:
        r0 = MmRecordingState.RECORDING;
        goto L43
    }

    public static final void f(MmRecordingSessionManager r5, c r6, boolean r7) {
        AtomicReference<c> r0 = r5.j;
    L4:
        if (r0.compareAndSet(r6, null) == true) goto L5;
        if (r0.get() == r6) goto L4;
        boolean r1 = false;
    L9:
        if (r1 == false) goto L29;
        AtomicReference<RecordingSessionType> r2 = r5.i;
        RecordingSessionType r4 = r6.a;
    L13:
        if (r2.compareAndSet(r4, null) == true) goto L17;
        if (r2.get() == r4) goto L13;
    L17:
        if (r7 == true) goto L19;
    L21:
        r5.h.set(false);
        return;
    L19:
        if (Intrinsics.areEqual(r5.s.getValue(), r6.c) == false) goto L21;
        r5.s.setValue(r6.b);
        goto L21
    L29:
        return;
    L5:
        r1 = true;
        goto L9
    }

    public final void C(String r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r11, "recordingId");
        Intrinsics.checkNotNullParameter(r12, "meetingId");
        Intrinsics.checkNotNullParameter(r13, "minutesToken");
        if (StringsKt.isBlank(r11) == false) goto L5;
        return;
    L5:
        if (StringsKt.isBlank(r13) == true) goto L10;
        BuildersKt.launch$default(this.c, null, null, new MmRecordingSessionManager$updateRecordingMinutesTokenData$1(this, r11, r12, r13, null), 3, null);
        return;
    }

    public final void D(String r11, String r12, float r13) {
        Intrinsics.checkNotNullParameter(r11, "recordingId");
        Intrinsics.checkNotNullParameter(r12, "minutesToken");
        if (StringsKt.isBlank(r11) == false) goto L5;
    L9:
        lvb.a.h(this.b, "[updateRecordingUploadState] ignored, recordingId=" + r11 + ", minutesTokenEmpty=" + StringsKt.isBlank(r12) + ", progress=" + r13);
        return;
    L5:
        if (StringsKt.isBlank(r12) == true) goto L9;
        BuildersKt.launch$default(this.c, null, null, new MmRecordingSessionManager$updateRecordingUploadState$1(this, r11, r13, r12, null), 3, null);
    }

    public final void x(String r5, EndRecordingReason r6, iub.a<j, ? super MmRecordingError> r7) {
        Intrinsics.checkNotNullParameter(r5, "recordingId");
        Intrinsics.checkNotNullParameter(r6, "reason");
        Intrinsics.checkNotNullParameter(r7, "callback");
        MmRecordingSession r0 = m(r5);
        if (r0 != null) goto L6;
        lvb.a.h(this.b, "[stopRecording] session not found, recordingId=" + r5);
        r7.a(MmRecordingError.RecordingNotFound.INSTANCE);
        return;
    L6:
        lvb.a.e(this.b, "[stopRecording] recordingId=" + r5);
        if (r0.u(new com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.a.k(r6)) == false) goto L9;
        r7.onSuccess(new j(r5));
        return;
    L9:
        r7.a(MmRecordingError.StateError.INSTANCE);
    }

    public final void z(MmRecordingSession r7, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c r8, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c r9) {
        if (r7.a.isRealTimeRecordingOrInterpretation() == true) goto L5;
        return;
    L5:
        ConcurrentHashMap<String, b> r0 = this.m;
        String r10 = r7.e();
        b r1 = r0.get(r10);
        if (r1 != null) goto L11;
        r1 = new b();
        b r11 = r0.putIfAbsent(r10, r1);
        if (r11 == null) goto L11;
        r1 = r11;
    L11:
        b r2 = r1;
        com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.h r12 = com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.h.c;
        if (Intrinsics.areEqual(r9, r12) == false) goto L17;
        if (r2.a != 0) goto L37;
        r2.a = System.currentTimeMillis();
        return;
    L37:
        return;
    L17:
        if (Intrinsics.areEqual(r9, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.k.c) == false) goto L25;
        if (Intrinsics.areEqual(r8, r12) == true) goto L21;
        return;
    L21:
        if (r2.a == 0) goto L43;
        RangesKt.coerceAtLeast(System.currentTimeMillis() - r2.a, 0);
        r2.a = 0;
        return;
    L43:
        return;
    L25:
        if ((r9 instanceof com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.b) == true) goto L31;
        if (Intrinsics.areEqual(r9, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.n.c) == true) goto L31;
        if ((r9 instanceof com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.m) == true) goto L31;
        return;
    L31:
        if (Intrinsics.areEqual(r8, r12) == true) goto L33;
        return;
    L33:
        if (r2.a == 0) goto L44;
        RangesKt.coerceAtLeast(System.currentTimeMillis() - r2.a, 0);
        r2.a = 0;
        return;
    }

    public static final Object b(MmRecordingSessionManager r18, MmRecordingSession r19, Pair r20, Continuation r21) {
        MmRecordingSession r1 = r19;
        r18.getClass();
        if ((r21 instanceof MmRecordingSessionManager$processHardwareLiveRecordingStateChange$1) == false) goto L7;
        MmRecordingSessionManager$processHardwareLiveRecordingStateChange$1 r3 = (MmRecordingSessionManager$processHardwareLiveRecordingStateChange$1) r21;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        Object r2 = r3.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r3.label;
        if (r6 == 0) goto L20;
        if (r6 == 1) goto L19;
        if (r6 == 2) goto L19;
        if (r6 == 3) goto L19;
        if (r6 == 4) goto L18;
        if (r6 != 5) goto L17;
        r1 = (MmRecordingSession) r3.L$0;
        ResultKt.throwOnFailure(r2);
    L54:
        if (Intrinsics.areEqual(r2, Boxing.boxBoolean(true)) == false) goto L56;
        lvb.a.e(r18.b, "[sessionStateChange] hardware live end window event sent");
    L57:
        r18.r(r1);
        r18.g();
    L59:
        return Unit.INSTANCE;
    L56:
        lvb.a.h(r18.b, "[sessionStateChange] hardware live end window event wait timeout, timeoutMs=4000");
        goto L57
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        r1 = (MmRecordingSession) r3.L$0;
        ResultKt.throwOnFailure(r2);
    L50:
        MmRecordingSessionManager$processHardwareLiveRecordingStateChange$endWindowEventSent$1 r7 = new MmRecordingSessionManager$processHardwareLiveRecordingStateChange$endWindowEventSent$1(r1, null);
        r3.L$0 = r1;
        r3.label = 5;
        r2 = TimeoutKt.c(4000, r7, r3);
        if (r2 != r5) goto L54;
        return r5;
    L19:
        ResultKt.throwOnFailure(r2);
        goto L59
    L20:
        ResultKt.throwOnFailure(r2);
        com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c r8 = (com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c) r20.getFirst();
        com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c r9 = (com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c) r20.getSecond();
        r18.z(r1, r8, r9);
        if ((r9 instanceof com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.l) == false) goto L26;
        r r10 = new r(r19.e(), MmRecordingState.RECORDING, MmRecordingState.IDLE, false, 24);
        r3.label = 1;
        if (r18.l(r1, r9, r10, r3) != r5) goto L59;
        return r5;
    L26:
        if ((r9 instanceof com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.k) == false) goto L33;
        if (Intrinsics.areEqual(r8, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.h.c) == false) goto L59;
        r r11 = new r(r19.e(), MmRecordingState.RECORDING, MmRecordingState.PAUSED, false, 24);
        r3.label = 2;
        if (r18.l(r1, r9, r11, r3) != r5) goto L59;
        return r5;
    L33:
        if ((r9 instanceof com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.h) == false) goto L38;
        r r12 = new r(r19.e(), MmRecordingState.PAUSED, MmRecordingState.RECORDING, false, 24);
        r3.label = 3;
        if (r18.l(r1, r9, r12, r3) != r5) goto L59;
        return r5;
    L38:
        if ((r9 instanceof com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.m) == false) goto L59;
        lvb.a.e(r18.b, "[sessionStateChange] hardware live meetingId=" + r19.e() + " Terminated");
        if (Intrinsics.areEqual(r8, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.C0037c.c) == false) goto L44;
        MmRecordingState r13 = MmRecordingState.IDLE;
    L47:
        r r14 = new r(r19.e(), MmRecordingState.IDLE, r13, r18.p(), 8);
        r3.L$0 = r1;
        r3.label = 4;
        if (r18.l(r1, r9, r14, r3) != r5) goto L50;
        return r5;
    L44:
        if (Intrinsics.areEqual(r8, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.h.c) == false) goto L46;
        r13 = MmRecordingState.PAUSED;
        goto L47
    L46:
        r13 = MmRecordingState.RECORDING;
    L7:
        r3 = new MmRecordingSessionManager$processHardwareLiveRecordingStateChange$1(r18, r21);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:87:0x02dd -> B:89:0x02e0). Please report as a decompilation issue!!! */
    public static final Object e(MmRecordingSessionManager r18, String r19, e r20, Continuation r21) {
        String r1 = r19;
        r18.getClass();
        if ((r21 instanceof MmRecordingSessionManager$recoverNativeLocalRecordings$1) == false) goto L7;
        MmRecordingSessionManager$recoverNativeLocalRecordings$1 r3 = (MmRecordingSessionManager$recoverNativeLocalRecordings$1) r21;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        Object r2 = r3.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r3.label;
        int r9 = 2;
        boolean r11 = true;
        if (r6 == 0) goto L22;
        if (r6 == 1) goto L21;
        if (r6 == 2) goto L20;
        if (r6 == 3) goto L19;
        if (r6 == 4) goto L18;
        if (r6 != 5) goto L17;
        String r7 = (String) r3.L$5;
        String r8 = (String) r3.L$4;
        Iterator r14 = (Iterator) r3.L$3;
        MmRecordingAudioPersistent r15 = (MmRecordingAudioPersistent) r3.L$2;
        e r10 = (e) r3.L$1;
        String r12 = (String) r3.L$0;
        ResultKt.throwOnFailure(r2);
        Iterator r13 = r14;
        String r16 = r12;
        String r17 = r8;
        Object r22 = r2;
    L89:
        lvb.a.b(r18.b, "[recoverNativeLocalRecordings] failed to assemble full audio, keep parts, sessionKey=" + r17 + ", audioFilePath=" + r7 + ", partFiles=" + ((List) r22));
        Iterator r23 = r13;
        MmRecordingAudioPersistent r24 = r15;
    L90:
        r9 = 2;
        r11 = true;
    L30:
        if (r23.hasNext() == false) goto L92;
        String r25 = (String) r23.next();
        String r26 = r10.i(r25);
        if ((StringsKt.isBlank(r26) ^ r11) == false) goto L41;
        lvb.a.e(r18.b, "[recoverNativeLocalRecordings] native_local bound, ensure meeting dir, sessionKey=" + r25 + ", meetingId=" + r26);
        MmRecordFileHelper r27 = MmRecordFileHelper.a;
        r3.L$0 = r16;
        r3.L$1 = r10;
        r3.L$2 = r24;
        r3.L$3 = r23;
        r3.L$4 = r25;
        r3.L$5 = r26;
        r3.label = r9;
        r27.getClass();
        r2 = MmRecordFileHelper.a(r16, r25, r26, r3);
        if (r2 != r5) goto L37;
        return r5;
    L37:
        if (((Boolean) r2).booleanValue() == false) goto L39;
        r10.E(r26, r25);
        lvb.a.e(r18.b, "[recoverNativeLocalRecordings] skip unbound local restore, history upload will handle, sessionKey=" + r25 + ", meetingId=" + r26);
        goto L90
    L39:
        lvb.a.b(r18.b, "[recoverNativeLocalRecordings] ensure meeting dir failed, keep native_local, sessionKey=" + r25 + ", meetingId=" + r26);
        goto L90
    L41:
        MmRecordingSource r28 = r10.r(r25);
        if (r28 != null) goto L44;
    L46:
        boolean r29 = false;
    L47:
        if (r29 == true) goto L49;
    L51:
        String r30 = r10.o(r25);
        if (StringsKt.isBlank(r30) == true) goto L54;
        r7 = r30;
    L62:
        if (StringsKt.isBlank(r7) == false) goto L65;
        lvb.a.h(r18.b, "[recoverNativeLocalRecordings] skip unbound native_local, no full audio path, sessionKey=".concat(r25));
        goto L90
    L65:
        if (StringsKt.isBlank(r30) == false) goto L67;
        r10.C(r25, r7);
    L67:
        r3.L$0 = r16;
        r3.L$1 = r10;
        r3.L$2 = r24;
        r3.L$3 = r23;
        r3.L$4 = r25;
        r3.L$5 = r30;
        r3.L$6 = r7;
        r3.label = 3;
        Object r110 = r24.b(r16, r25, r7, r3);
        if (r110 == r5) goto L97;
        String r31 = r30;
        r2 = r110;
        r15 = r24;
        r13 = r23;
        r17 = r25;
    L71:
        boolean r32 = ((Boolean) r2).booleanValue();
        boolean r33 = com.ss.android.lark.officesdk.minutes.service.foundation.utils.cache.file.a.c(r7).exists();
        if (r32 == false) goto L74;
    L78:
        boolean r34 = true;
    L79:
        if (r34 == false) goto L86;
        lvb.a.e(r18.b, "[recoverNativeLocalRecordings] emit local full audio path, sessionKey=" + r17 + ", assembled=" + r32 + ", fileExists=" + r33 + ", audioFilePath=" + r7);
        r18.A(r17, r7);
        MmRecordFileHelper r35 = MmRecordFileHelper.a;
        r3.L$0 = r16;
        r3.L$1 = r10;
        r3.L$2 = r15;
        r3.L$3 = r13;
        r3.L$4 = r17;
        r3.L$5 = null;
        r3.L$6 = null;
        r3.label = 4;
        r35.getClass();
        Object r36 = MmRecordFileHelper.c(r16, r17, r3);
        if (r36 == r5) goto L98;
        Object r37 = r5;
        MmRecordingSessionManager$recoverNativeLocalRecordings$1 r38 = r3;
        Object r39 = r36;
        String r40 = r17;
        MmRecordingAudioPersistent r41 = r15;
    L84:
        boolean r42 = ((Boolean) r39).booleanValue();
        lvb.a.e(r18.b, "[recoverNativeLocalRecordings] cleanup restored native_local parts, sessionKey=" + r40 + ", deletedParts=" + r42);
        r3 = r38;
        r5 = r37;
        Iterator r111 = r13;
        r24 = r41;
        r23 = r111;
        goto L90
    L98:
        return r5;
    L86:
        MmRecordFileHelper r43 = MmRecordFileHelper.a;
        r3.L$0 = r16;
        r3.L$1 = r10;
        r3.L$2 = r15;
        r3.L$3 = r13;
        r3.L$4 = r17;
        r3.L$5 = r7;
        r3.L$6 = null;
        r3.label = 5;
        r43.getClass();
        r22 = MmRecordFileHelper.h(r16, r17, r3);
        if (r22 != r5) goto L89;
        return r5;
    L74:
        if ((StringsKt.isBlank(r31) ^ r11) == false) goto L77;
        if (r33 == true) goto L78;
    L77:
        r34 = false;
        goto L79
    L97:
        return r5;
    L54:
        if (r28 != MmRecordingSource.FEISHU_HARDWARE_D1204) goto L56;
        boolean r44 = true;
    L57:
        r7 = r24.c(r16, r25, r28, r44);
        if (r7 != null) goto L62;
        r7 = "";
        goto L62
    L56:
        r44 = false;
        goto L57
    L49:
        if (r10.m().containsKey(r25) == false) goto L51;
        lvb.a.e(r18.b, "[recoverNativeLocalRecordings] skip offline pending-upload recording, keep parts, sessionKey=".concat(r25));
        goto L90
    L44:
        if (r28.shouldRetainOfflineRecordingParts() != r11) goto L46;
        r29 = true;
        goto L47
    L92:
        return Unit.INSTANCE;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        r40 = (String) r3.L$4;
        Iterator r45 = (Iterator) r3.L$3;
        r41 = (MmRecordingAudioPersistent) r3.L$2;
        r10 = (e) r3.L$1;
        r16 = (String) r3.L$0;
        ResultKt.throwOnFailure(r2);
        r13 = r45;
        r37 = r5;
        r38 = r3;
        r39 = r2;
        goto L84
    L19:
        r7 = (String) r3.L$6;
        r31 = (String) r3.L$5;
        r17 = (String) r3.L$4;
        Iterator r112 = (Iterator) r3.L$3;
        MmRecordingAudioPersistent r113 = (MmRecordingAudioPersistent) r3.L$2;
        e r114 = (e) r3.L$1;
        String r46 = (String) r3.L$0;
        ResultKt.throwOnFailure(r2);
        r16 = r46;
        r13 = r112;
        r10 = r114;
        r15 = r113;
        goto L71
    L20:
        r26 = (String) r3.L$5;
        r25 = (String) r3.L$4;
        r23 = (Iterator) r3.L$3;
        r24 = (MmRecordingAudioPersistent) r3.L$2;
        r10 = (e) r3.L$1;
        r16 = (String) r3.L$0;
        ResultKt.throwOnFailure(r2);
        goto L37
    L21:
        e r47 = (e) r3.L$1;
        String r48 = (String) r3.L$0;
        ResultKt.throwOnFailure(r2);
        e r49 = r47;
        r1 = r48;
    L25:
        List r50 = (List) r2;
        if (r50.isEmpty() == false) goto L28;
        lvb.a.e(r18.b, "[recoverNativeLocalRecordings] no native_local dirs");
        return Unit.INSTANCE;
    L28:
        r16 = r1;
        r10 = r49;
        r24 = new MmRecordingAudioPersistent(r18.a);
        r23 = r50.iterator();
        goto L30
    L22:
        ResultKt.throwOnFailure(r2);
        MmRecordFileHelper r51 = MmRecordFileHelper.a;
        r3.L$0 = r1;
        r49 = r20;
        r3.L$1 = r49;
        r3.label = 1;
        r51.getClass();
        r2 = MmRecordFileHelper.e(r1, r3);
        if (r2 != r5) goto L25;
        return r5;
    L7:
        r3 = new MmRecordingSessionManager$recoverNativeLocalRecordings$1(r18, r21);
        goto L8
    }

    public final Object l(MmRecordingSession r20, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c r21, r r22, Continuation<? super Unit> r23) {
        r r1 = r22;
        if ((r23 instanceof MmRecordingSessionManager$emitRecordingStatus$1) == false) goto L7;
        MmRecordingSessionManager$emitRecordingStatus$1 r3 = (MmRecordingSessionManager$emitRecordingStatus$1) r23;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        Object r2 = r3.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r3.label;
        if (r6 == 0) goto L16;
        if (r6 == 1) goto L15;
        if (r6 != 2) goto L14;
        ResultKt.throwOnFailure(r2);
    L33:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r1 = (r) r3.L$2;
        com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c r7 = (com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c) r3.L$1;
        MmRecordingSession r8 = (MmRecordingSession) r3.L$0;
        ResultKt.throwOnFailure(r2);
        com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c r9 = r7;
        MmRecordingSession r10 = r8;
    L25:
        StateFlowImpl r11 = this.s;
        String r12 = r1.a;
        String r13 = r10.w.d;
        MmRecordingState r14 = r1.b;
        MmRecordingState r15 = r1.c;
        k r16 = r10.f;
        if (r16 == null) goto L28;
        MmRecordingSource r17 = r16.a;
    L29:
        q r18 = new q(r12, r13, r14, r15, r17, r10.a.isRealTimeRecording(), r9.a(), r1.d, r1.e);
        r3.L$0 = null;
        r3.L$1 = null;
        r3.L$2 = null;
        r3.label = 2;
        r11.setValue(r18);
        if (Unit.INSTANCE != r5) goto L33;
        return r5;
    L28:
        r17 = null;
        goto L29
    L16:
        ResultKt.throwOnFailure(r2);
        if (r21.a() == false) goto L19;
    L22:
        StateFlowImpl r19 = this.r;
        r10 = r20;
        r3.L$0 = r10;
        r9 = r21;
        r3.L$1 = r9;
        r3.L$2 = r1;
        r3.label = 1;
        r19.setValue(r1);
        if (Unit.INSTANCE != r5) goto L25;
        return r5;
    L19:
        if (o(r20) == false) goto L22;
        lvb.a.e(this.b, "[emitRecordingStatus] skip stale state from recordingId=" + r20.e() + ", another active realtime session exists");
        return Unit.INSTANCE;
    L7:
        r3 = new MmRecordingSessionManager$emitRecordingStatus$1(this, r23);
        goto L8
    }

    public final Object u(String r9, String r10, e r11, Continuation<? super Boolean> r12) {
        if ((r12 instanceof MmRecordingSessionManager$shouldResumeHistoryRecording$1) == false) goto L7;
        MmRecordingSessionManager$shouldResumeHistoryRecording$1 r0 = (MmRecordingSessionManager$shouldResumeHistoryRecording$1) r12;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        MmRecordingSessionManager$shouldResumeHistoryRecording$1 r6 = r0;
        Object r13 = r6.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r6.label;
        boolean r7 = true;
        if (r3 == 0) goto L17;
        if (r3 == 1) goto L16;
        if (r3 == 2) goto L16;
        if (r3 != 3) goto L15;
        ResultKt.throwOnFailure(r13);
    L43:
        return Boxing.boxBoolean(r7);
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r13);
    L41:
        r7 = false;
        goto L43
    L17:
        ResultKt.throwOnFailure(r13);
        MmRecordingSource r14 = s(r11, r10);
        if (r14 != null) goto L20;
        int r15 = -1;
    L21:
        if (r15 == 1) goto L35;
        if (r15 != 2) goto L43;
        String r4 = r11.u(r10);
        if (r11.w(r4) == true) goto L43;
        if (StringsKt.isBlank(r4) == false) goto L32;
        r6.label = 2;
        if (h(r9, r10, r4, r11, r6) != r2) goto L41;
        return r2;
    L32:
        r6.label = 3;
        if (k(r9, r10, r4, r11, r6) != r2) goto L43;
        return r2;
    L35:
        String r5 = r11.u(r10);
        if (r11.w(r5) == true) goto L43;
        r6.label = 1;
        if (h(r9, r10, r5, r11, r6) != r2) goto L41;
        return r2;
    L20:
        r15 = d.a[r14.ordinal()];
    L7:
        r0 = new MmRecordingSessionManager$shouldResumeHistoryRecording$1(this, r12);
        goto L8
    }

    public final void v(RecordingSessionType r27, k r28, iub.a<j, ? super MmRecordingError> r29, sub.b r30) {
        Intrinsics.checkNotNullParameter(r27, "sessionType");
        Intrinsics.checkNotNullParameter(r28, "context");
        Intrinsics.checkNotNullParameter(r29, "callback");
        String r1 = null;
        if (this.h.compareAndSet(false, true) == true) goto L6;
        lvb.a.h(this.b, "[startRealtimeRecording] debounced, start already in progress");
        qvb.a r0 = qvb.a.a;
        MmRecordingError.RecordingStarting r2 = MmRecordingError.RecordingStarting.INSTANCE;
        qvb.a.e(Integer.valueOf(r2.getErrorCode()), "recording_start_debounced", r2.getErrorMsg(), null, 8);
        r29.a(r2);
        return;
    L6:
        MmRecordingSource r3 = r28.a;
        q r5 = (q) this.s.getValue();
        Intrinsics.checkNotNullParameter(r3, "source");
        c r9 = new c(r27, r5, new q(r3, true, 463));
        this.j.set(r9);
        this.s.setValue(r9.c);
        this.i.set(r27);
        String r8 = k0.a(16);
        MmRecordingSource r4 = r28.a;
        if (r4 != MmRecordingSource.DOUBAO_PERSONAL) goto L9;
    L13:
        Object r6 = r28.b.get("doubao_biz_info");
        if (r6 == null) goto L26;
        String r7 = r6.toString();
        if (r7 == null) goto L26;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L20
        Gson r11 = e0.a;     // Catch: Throwable -> L20
        Object r12 = Result.constructor-impl((DoubaoBizInfo) e0.a(r7, DoubaoBizInfo.class));     // Catch: Throwable -> L20
    L23:
        if (Result.isFailure-impl(r12) == false) goto L25;
        r12 = null;
    L25:
        DoubaoBizInfo r13 = (DoubaoBizInfo) r12;
    L27:
        boolean r15 = r27.isHardwareRecording();
        String r16 = r28.a.name();
        String r18 = this.a.getCurrentUserId();
        Intrinsics.checkNotNull(r8);
        MmRecordingSource r14 = r28.a;
        String r21 = this.a.getTenantId();
        if (r13 == null) goto L30;
        String r17 = r13.getRecordingId();
    L32:
        if (r17 != null) goto L34;
        String r22 = "";
    L35:
        MmRecordingCommonParam r19 = new MmRecordingCommonParam(null, null, r15, r16, null, r18, r8, r14, r21, r22, r27.name(), 19, null);
        qvb.a r20 = qvb.a.a;
        qvb.a.a("", r19, r13, r27);
        com.ss.android.lark.officesdk.minutes.service.recording.common.perf.appreciable.b r23 = com.ss.android.lark.officesdk.minutes.service.recording.common.perf.appreciable.a.a;
        r23.getClass();
        Intrinsics.checkNotNullParameter(r19, "commonParam");
        com.ss.android.lark.officesdk.minutes.service.recording.common.perf.appreciable.b.C0038b r24 = new com.ss.android.lark.officesdk.minutes.service.recording.common.perf.appreciable.b.C0038b(r19, System.currentTimeMillis());
        r23.a.set(r24);
        lvb.a.e("MmRecordingCreateMetrics", "[trackRealtimeRecordingStart] traceId=" + r19.getRecordingTraceId() + ", source=" + r19.getSource());
        MmRecordingCommonParam r25 = r24.a;
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.d r26 = new com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.d();
        MmRecordingSource r110 = r19.getSource();
        if (r110 == null) goto L38;
        r1 = r110.getValue();
    L38:
        if (r1 != null) goto L40;
        String r111 = "";
    L41:
        r26.e("source", r111);
        com.ss.android.lark.officesdk.minutes.service.recording.common.perf.appreciable.a.a("minutes_recording_start", r25, r26.a());
        BuildersKt.launch$default(this.c, null, null, new MmRecordingSessionManager$startRealtimeRecording$1(this, r27, r28, r19, r29, r8, r30, r9, null), 3, null);
        return;
    L40:
        r111 = r1;
        goto L41
    L34:
        r22 = r17;
        goto L35
    L30:
        r17 = null;
    L20:
        th = move-exception;
        Result.Companion r31 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
    L26:
        r13 = null;
        goto L27
    L9:
        if (r4 == MmRecordingSource.DOUBAO_ENTERPRISE) goto L13;
        if (r4 == MmRecordingSource.DOUBAO_STANDALONE_AI_INTERPRETATION) goto L13;
        goto L13
    }

    public final Object y(String r29, String r30, e r31, Continuation<? super Unit> r32) {
        String r1 = r29;
        String r2 = r30;
        e r3 = r31;
        if ((r32 instanceof MmRecordingSessionManager$submitRecoveredD1204OfflineLocalUpload$1) == false) goto L7;
        MmRecordingSessionManager$submitRecoveredD1204OfflineLocalUpload$1 r5 = (MmRecordingSessionManager$submitRecoveredD1204OfflineLocalUpload$1) r32;
        int r6 = r5.label;
        if ((r6 & Integer.MIN_VALUE) == 0) goto L7;
        r5.label = r6 - Integer.MIN_VALUE;
    L8:
        Object r4 = r5.result;
        Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r8 = r5.label;
        if (r8 == 0) goto L18;
        if (r8 == 1) goto L17;
        if (r8 == 2) goto L16;
        if (r8 != 3) goto L15;
        String r9 = (String) r5.L$2;
        f r10 = (f) r5.L$1;
        String r11 = (String) r5.L$0;
        ResultKt.throwOnFailure(r4);
    L79:
        boolean r12 = ((Boolean) r4).booleanValue();
        String r13 = this.b;
        StringBuilder r14 = new StringBuilder("[d1204OfflineUploadRecovery] submitted, sessionKey=");
        r14.append(r11);
        r14.append(", taskId=");
        if (r9 != null) goto L82;
        r9 = r10.a;
    L82:
        r14.append(r9);
        r14.append(", deletedParts=");
        r14.append(r12);
        lvb.a.e(r13, r14.toString());
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        MmMinutesFileUploadSessionManager r15 = (MmMinutesFileUploadSessionManager) r5.L$4;
        r10 = (f) r5.L$3;
        r3 = (e) r5.L$2;
        String r16 = (String) r5.L$1;
        String r17 = (String) r5.L$0;
        ResultKt.throwOnFailure(r4);
    L62:
        String r18 = (String) r4;
        if (r18 != null) goto L71;
        String r19 = r10.a;
        r15.getClass();
        Intrinsics.checkNotNullParameter(r19, "taskId");
        MmMinutesFileUploadSessionManager.e r20 = r15.p.get(r19);
        if (r20 == null) goto L67;
        z0<g> r21 = r20.b;
    L68:
        if (r21 != null) goto L71;
        boolean r22 = false;
    L72:
        if (r22 == true) goto L75;
        lvb.a.h(this.b, "[d1204OfflineUploadRecovery] submit failed, sessionKey=" + r16);
        return Unit.INSTANCE;
    L75:
        r3.B(r16);
        MmRecordFileHelper r23 = MmRecordFileHelper.a;
        r5.L$0 = r16;
        r5.L$1 = r10;
        r5.L$2 = r18;
        r5.L$3 = null;
        r5.L$4 = null;
        r5.label = 3;
        r23.getClass();
        Object r24 = MmRecordFileHelper.c(r17, r16, r5);
        if (r24 != r7) goto L78;
        return r7;
    L78:
        r11 = r16;
        r4 = r24;
        r9 = r18;
        goto L79
    L67:
        r21 = null;
    L71:
        r22 = true;
        goto L72
    L17:
        String r25 = (String) r5.L$3;
        e r26 = (e) r5.L$2;
        String r27 = (String) r5.L$1;
        String r28 = (String) r5.L$0;
        ResultKt.throwOnFailure(r4);
        String r110 = r25;
        r1 = r28;
        r3 = r26;
        r2 = r27;
    L38:
        boolean r33 = ((Boolean) r4).booleanValue();
        VFSFile r34 = com.ss.android.lark.officesdk.minutes.service.foundation.utils.cache.file.a.c(r110);
        lvb.a.e(this.b, "[d1204OfflineUploadRecovery] assemble, sessionKey=" + r2 + ", assembled=" + r33 + ", exists=" + r34.exists() + ", size=" + r34.length());
    L39:
        String r210 = r110;
        if (r34.exists() == true) goto L42;
    L84:
        lvb.a.h(this.b, "[d1204OfflineUploadRecovery] skip, audio unavailable, sessionKey=" + r2);
        return Unit.INSTANCE;
    L42:
        if (r34.length() <= 0) goto L84;
        Long r35 = r3.m().get(r2);
        if (r35 != null) goto L55;
        r35 = Boxing.boxLong(r34.lastModified());
        if (r35.longValue() <= 0) goto L50;
        boolean r36 = true;
    L51:
        if (r36 == true) goto L54;
        r35 = null;
    L54:
        if (r35 != null) goto L55;
        long r37 = System.currentTimeMillis();
    L56:
        long r211 = r37;
        long r212 = Math.max(r34.lastModified(), r211 + 1000);
        int r38 = com.ss.android.lark.officesdk.minutes.service.recording.common.core.a.a;
        f r39 = com.ss.android.lark.officesdk.minutes.service.recording.common.core.a.a(r2, r3.l(r2), r210, r34.length(), r211, r212);
        MmMinutesFileUploadSessionManager r40 = this.a.F();
        r5.L$0 = r1;
        r5.L$1 = r2;
        r5.L$2 = r3;
        r5.L$3 = r39;
        r5.L$4 = r40;
        r5.label = 2;
        r4 = r40.H(r39, r5);
        if (r4 != r7) goto L61;
        return r7;
    L61:
        r17 = r1;
        r15 = r40;
        r16 = r2;
        r10 = r39;
        goto L62
    L50:
        r36 = false;
    L55:
        r37 = r35.longValue();
        goto L56
    L18:
        ResultKt.throwOnFailure(r4);
        MmRecordingAudioPersistent r41 = new MmRecordingAudioPersistent(this.a);
        String r42 = r3.o(r2);
        if (StringsKt.isBlank(r42) == false) goto L23;
        r110 = r41.c(r1, r2, MmRecordingSource.FEISHU_HARDWARE_D1204, true);
        if (r110 != null) goto L25;
        r110 = "";
    L25:
        if (StringsKt.isBlank(r110) == false) goto L29;
        lvb.a.h(this.b, "[d1204OfflineUploadRecovery] skip, no audio path, sessionKey=".concat(r2));
        return Unit.INSTANCE;
    L29:
        if (StringsKt.isBlank(r42) == false) goto L31;
        r3.C(r2, r110);
    L31:
        r34 = com.ss.android.lark.officesdk.minutes.service.foundation.utils.cache.file.a.c(r110);
        if (r34.exists() == true) goto L34;
    L35:
        r5.L$0 = r1;
        r5.L$1 = r2;
        r5.L$2 = r3;
        r5.L$3 = r110;
        r5.label = 1;
        r4 = r41.b(r1, r2, r110, r5);
        if (r4 != r7) goto L38;
        return r7;
    L34:
        if (r34.length() > 0) goto L39;
    L23:
        r110 = r42;
    L7:
        r5 = new MmRecordingSessionManager$submitRecoveredD1204OfflineLocalUpload$1(this, r32);
        goto L8
    }

    public static final Object a(MmRecordingSessionManager r23, String r24, String r25, e r26, Continuation r27) {
        String r0 = r24;
        String r2 = r25;
        e r3 = r26;
        r23.getClass();
        if ((r27 instanceof MmRecordingSessionManager$createHistoryRecordingSessionIfNeeded$1) == false) goto L7;
        MmRecordingSessionManager$createHistoryRecordingSessionIfNeeded$1 r6 = (MmRecordingSessionManager$createHistoryRecordingSessionIfNeeded$1) r27;
        int r7 = r6.label;
        if ((r7 & Integer.MIN_VALUE) == 0) goto L7;
        r6.label = r7 - Integer.MIN_VALUE;
    L8:
        Object r4 = r6.result;
        Object r8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r9 = r6.label;
        boolean r10 = true;
        if (r9 == 0) goto L14;
        if (r9 != 1) goto L13;
        e r1 = (e) r6.L$2;
        r2 = (String) r6.L$1;
        String r5 = (String) r6.L$0;
        ResultKt.throwOnFailure(r4);
        r3 = r1;
        r0 = r5;
    L24:
        if (((Boolean) r4).booleanValue() == true) goto L27;
        lvb.a.e(r23.b, "[resumeHistoryRecording] skip discarded standalone AI interpretation, meetingId=" + r2);
        return Unit.INSTANCE;
    L27:
        if (r23.n.add(r2) == true) goto L29;
        lvb.a.e(r23.b, "[resumeHistoryRecording] skip duplicate meetingId=" + r2);
        return Unit.INSTANCE;
    L29:
        MmRecordingSession r11 = r23.m(r2);
        if (r11 == null) goto L57;
        r23.n.remove(r2);
        lvb.a.e(r23.b, "[resumeHistoryRecording] skip existing session, phase=afterRecoveryReservation, meetingId=" + r2 + ", " + r23.j(r11));
        return Unit.INSTANCE;
    L57:
        MmRecordingSource r12 = s(r3, r2);     // Catch: Throwable -> L35
        if (r12 == null) goto L37;
        k r17 = new k(r12, null, MmRecordingUILaunchMode.PURE_SDK, null, null, 122);     // Catch: Throwable -> L35
    L38:
        MmRecordingRoute.a r13 = MmRecordingRoute.Companion;     // Catch: Throwable -> L35
        MmRecordingRoute r14 = r3.q(r2);     // Catch: Throwable -> L35
        r13.getClass();     // Catch: Throwable -> L35
        if (r14 == null) goto L42;
        MmRecordingRoute r18 = r14;
    L52:
        String r15 = com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync.g.a(r0, r2, r3);     // Catch: Throwable -> L35
        MmRecordingSession r16 = new MmRecordingSession(RecordingSessionType.HISTORY_RECORDING, r23.a, r15, null, r2, r17, r18, null, null, 392);     // Catch: Throwable -> L35
        String r19 = r16.e();     // Catch: Throwable -> L35
        r23.e.put(r19, r16);     // Catch: Throwable -> L35
        r23.k.put(r19, BuildersKt.launch$default(r23.c, null, null, new MmRecordingSessionManager$listenSessionStateChange$1(r16, r23, null), 3, null));     // Catch: Throwable -> L35
        r23.l.put(r19, r23.q(r16));     // Catch: Throwable -> L35
        lvb.a.e(r23.b, "[resumeHistoryRecording] create history session, meetingId=" + r2 + ", traceId=" + r15);     // Catch: Throwable -> L35
    L56:
        return Unit.INSTANCE;
    L42:
        if (r12 == MmRecordingSource.FEISHU) goto L50;
        if (r12 != null) goto L45;
    L47:
        r10 = false;
    L48:
        if (r10 == false) goto L50;
        MmRecordingRoute r20 = MmRecordingRoute.RECORDING_API;     // Catch: Throwable -> L35
    L51:
        r18 = r20;
        goto L52
    L45:
        if (r12.usesRecordingApiByDefault() != true) goto L47;
    L50:
        r20 = MmRecordingRoute.LEGACY;     // Catch: Throwable -> L35
        goto L51
    L37:
        r17 = null;
    L35:
        th = move-exception;
        r23.n.remove(r2);
        r23.e.remove(r2);
        lvb.a.b(r23.b, "[resumeHistoryRecording] create history session failed, meetingId=" + r2 + ", error=" + th);
        goto L56
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r4);
        if (StringsKt.isBlank(r25) == true) goto L59;
        MmRecordingSession r21 = r23.m(r2);
        if (r21 == null) goto L20;
        lvb.a.e(r23.b, "[resumeHistoryRecording] skip existing session, phase=beforeRecoveryGuard, meetingId=" + r2 + ", " + r23.j(r21));
        return Unit.INSTANCE;
    L20:
        r6.L$0 = r0;
        r6.L$1 = r2;
        r6.L$2 = r3;
        r6.label = 1;
        r4 = r23.u(r0, r2, r3, r6);
        if (r4 != r8) goto L24;
        return r8;
    L59:
        return Unit.INSTANCE;
    L7:
        r6 = new MmRecordingSessionManager$createHistoryRecordingSessionIfNeeded$1(r23, r27);
        goto L8
    }

    public static final Object d(MmRecordingSessionManager r9, String r10, Set r11, e r12, Continuation r13) {
        r9.getClass();
        if ((r13 instanceof MmRecordingSessionManager$recoverD1204OfflineLocalUploads$1) == false) goto L7;
        MmRecordingSessionManager$recoverD1204OfflineLocalUploads$1 r0 = (MmRecordingSessionManager$recoverD1204OfflineLocalUploads$1) r13;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r14 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        Iterator r15 = (Iterator) r0.L$3;
        Collection r16 = (Collection) r0.L$2;
        r12 = (e) r0.L$1;
        String r4 = (String) r0.L$0;
        ResultKt.throwOnFailure(r14);
    L28:
        if (r15.hasNext() == false) goto L33;
        String r17 = (String) r15.next();
        r0.L$0 = r4;
        r0.L$1 = r12;
        r0.L$2 = r16;
        r0.L$3 = r15;
        r0.label = 1;
        if (r9.y(r4, r17, r12, r0) != r2) goto L28;
        return r2;
    L33:
        return r16;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r14);
        LinkedHashSet r18 = new LinkedHashSet();
        Iterator r19 = r11.iterator();
    L16:
        if (r19.hasNext() == false) goto L26;
        Object r5 = r19.next();
        String r6 = (String) r5;
        boolean r7 = false;
        if (StringsKt.startsWith$default(r6, "anker_d1204_", false, 2, null) == true) goto L20;
    L24:
        if (r7 == false) goto L16;
        r18.add(r5);
        goto L16
    L20:
        if (r12.r(r6) != MmRecordingSource.FEISHU_HARDWARE_D1204) goto L24;
        if (StringsKt.isBlank(r12.i(r6)) == false) goto L24;
        r7 = true;
        goto L24
    L26:
        r4 = r10;
        r15 = r18.iterator();
        r16 = r18;
    L7:
        r0 = new MmRecordingSessionManager$recoverD1204OfflineLocalUploads$1(r9, r13);
        goto L8
    }

    public final Object h(String r9, String r10, String r11, e r12, Continuation<? super Unit> r13) {
        if ((r13 instanceof MmRecordingSessionManager$cleanupDiscardedStandaloneAIInterpretationHistory$1) == false) goto L7;
        MmRecordingSessionManager$cleanupDiscardedStandaloneAIInterpretationHistory$1 r0 = (MmRecordingSessionManager$cleanupDiscardedStandaloneAIInterpretationHistory$1) r13;
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
        e r15 = (e) r0.L$2;
        String r16 = (String) r0.L$1;
        String r17 = (String) r0.L$0;
        ResultKt.throwOnFailure(r14);
    L27:
        r15.c(r16);
        r15.d(r16);
        r15.e(r16);
        r15.g(r16);
        com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync.d.a(r17, r15);
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        String r18 = (String) r0.L$3;
        r12 = (e) r0.L$2;
        r11 = (String) r0.L$1;
        r10 = (String) r0.L$0;
        ResultKt.throwOnFailure(r14);
    L23:
        MmRecordFileHelper r19 = MmRecordFileHelper.a;
        r0.L$0 = r10;
        r0.L$1 = r11;
        r0.L$2 = r12;
        r0.L$3 = null;
        r0.label = 2;
        r19.getClass();
        if (MmRecordFileHelper.b(r18, r0) != r2) goto L26;
        return r2;
    L26:
        r15 = r12;
        String r7 = r11;
        r17 = r10;
        r16 = r7;
        goto L27
    L16:
        ResultKt.throwOnFailure(r14);
        String r110 = r12.o(r11);
        if (StringsKt.isBlank(r110) == false) goto L19;
        r110 = r12.o(r10);
    L19:
        lvb.a.e(this.b, "[resumeHistoryRecording] cleanup discarded standalone AI interpretation, meetingId=" + r10 + ", recordingId=" + r11 + ", audioFilePath=" + r110);
        MmRecordFileHelper.a.getClass();
        String r20 = MmRecordFileHelper.f(r9, r10).getAbsolutePath();
        r0.L$0 = r10;
        r0.L$1 = r11;
        r0.L$2 = r12;
        r0.L$3 = r110;
        r0.label = 1;
        if (MmRecordFileHelper.b(r20, r0) != r2) goto L22;
        return r2;
    L22:
        r18 = r110;
    L7:
        r0 = new MmRecordingSessionManager$cleanupDiscardedStandaloneAIInterpretationHistory$1(this, r13);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x009f -> B:23:0x00a2). Please report as a decompilation issue!!! */
    public final Object k(String r10, String r11, String r12, e r13, Continuation<? super Unit> r14) {
        if ((r14 instanceof MmRecordingSessionManager$discardStandaloneAIInterpretationHistoryAudio$1) == false) goto L7;
        MmRecordingSessionManager$discardStandaloneAIInterpretationHistoryAudio$1 r0 = (MmRecordingSessionManager$discardStandaloneAIInterpretationHistoryAudio$1) r14;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r15 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        e r16 = (e) r0.L$2;
        String r17 = (String) r0.L$1;
        String r18 = (String) r0.L$0;
        ResultKt.throwOnFailure(r15);
        MmRecordingSessionManager r5 = this;
    L33:
        r16.c(r17);
        r16.c(r18);
        lvb.a.e(r5.b, "[resumeHistoryRecording] discard standalone AI interpretation audio and retain recovery context, meetingId=" + r18 + ", recordingId=" + r17);
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        int r19 = r0.I$1;
        int r110 = r0.I$0;
        VFSFile[] r111 = (VFSFile[]) r0.L$3;
        e r112 = (e) r0.L$2;
        String r4 = (String) r0.L$1;
        String r6 = (String) r0.L$0;
        ResultKt.throwOnFailure(r15);
        VFSFile[] r113 = r111;
        String r114 = r6;
        r5 = this;
        MmRecordingSessionManager$discardStandaloneAIInterpretationHistoryAudio$1 r8 = r0;
        e r7 = r112;
        String r115 = r4;
        Object r9 = r2;
        MmRecordingSessionManager$discardStandaloneAIInterpretationHistoryAudio$1 r20 = r8;
    L23:
        r110 = r110 + 1;
    L19:
        if (r110 >= r19) goto L24;
        VFSFile r21 = r113[r110];
        MmRecordFileHelper r22 = MmRecordFileHelper.a;
        String r23 = r21.getAbsolutePath();
        r20.L$0 = r114;
        r20.L$1 = r115;
        r20.L$2 = r7;
        r20.L$3 = r113;
        r20.I$0 = r110;
        r20.I$1 = r19;
        r20.label = 1;
        r22.getClass();
        if (MmRecordFileHelper.b(r23, r20) != r9) goto L23;
        return r9;
    L24:
        r11 = r114;
        r12 = r115;
        r13 = r7;
        r0 = r20;
        r2 = r9;
    L26:
        String r116 = r13.o(r12);
        if (StringsKt.isBlank(r116) == false) goto L29;
        r116 = r13.o(r11);
    L29:
        MmRecordFileHelper r117 = MmRecordFileHelper.a;
        r0.L$0 = r11;
        r0.L$1 = r12;
        r0.L$2 = r13;
        r0.L$3 = null;
        r0.label = 2;
        r117.getClass();
        if (MmRecordFileHelper.b(r116, r0) != r2) goto L32;
        return r2;
    L32:
        r16 = r13;
        String r24 = r12;
        r18 = r11;
        r17 = r24;
        goto L33
    L16:
        ResultKt.throwOnFailure(r15);
        MmRecordFileHelper.a.getClass();
        VFSFile[] r118 = MmRecordFileHelper.f(r10, r11).listFiles();
        if (r118 == null) goto L25;
        r5 = this;
        r9 = r2;
        r20 = r0;
        r7 = r13;
        r115 = r12;
        r114 = r11;
        r110 = 0;
        r113 = r118;
        r19 = r118.length;
        goto L19
    L25:
        r5 = this;
    L7:
        r0 = new MmRecordingSessionManager$discardStandaloneAIInterpretationHistoryAudio$1(this, r14);
        goto L8
    }
}
