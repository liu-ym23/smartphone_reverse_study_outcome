package com.ss.android.lark.officesdk.minutes.service.recording.common.core;

import com.google.gson.Gson;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.utils.k0;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingError;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.api.recording.doubao.DoubaoBizInfo;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.data.MmRecordingRoute;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.data.RecordingSessionType;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.MmExternalAudioCapturePipeline;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.MmRecordingAudioProcessor;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.MmRecordingAudioService;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.MmRecordingEncodedAudioProcessor;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync.MmRecordingCreateService;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync.MmRecordingStatesSyncService;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.upload.MmRecordingUploadService;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.MmRecordingSessionStateMachine;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.MmRecordingRepo;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.MmStandaloneAIInterpretationRootRepo;
import com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.MmRecordingCommonParam;
import com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.l;
import com.ss.android.lark.rustinfrabridge.netstate.impl.LarkNetworkLevelManager;
import com.ss.android.lark.utils.e0;
import iub.j;
import iub.k;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.a1;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MmRecordingSession {
    public final RecordingSessionType a;
    public final com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a b;
    public final String c;
    public iub.a<Pair<MmRecordingSession, j>, ? super MmRecordingError> d;
    public final String e;
    public final k f;
    public final sub.b g;
    public final String h;
    public a i;
    public final Lazy j;
    public final Lazy k;
    public final Lazy l;
    public final Lazy m;
    public final Lazy n;
    public final Flow<Integer> o;
    public final b1 p;
    public final com.ss.android.lark.officesdk.minutes.service.recording.common.core.b q;
    public final a1 r;
    public final MmRecordingSessionStateMachine s;
    public final b1 t;
    public final CoroutineScope u;
    public final CoroutineScope v;
    public ovb.b w;
    public volatile MmRecordingRoute x;
    public final Lazy y;
    public final Lazy z;

    public static final class a {
        public final MmRecordingError a;
        public final ErrorResult b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            ErrorResult r1 = this.b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public final String toString() {
            return "CreateRecordingFailureInfo(error=" + this.a + ", errorResult=" + this.b + ')';
        }

        public a(MmRecordingError r2, ErrorResult r3) {
            Intrinsics.checkNotNullParameter(r2, "error");
            this.a = r2;
            this.b = r3;
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[RecordingSessionType.values().length];
            r0[RecordingSessionType.SOFTWARE_RECORDING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r0[RecordingSessionType.HARDWARE_RECORDING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r0[RecordingSessionType.HARDWARE_LIVE_RECORDING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r0[RecordingSessionType.STANDALONE_AI_INTERPRETATION.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[RecordingSessionType.HISTORY_RECORDING.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r0[RecordingSessionType.PRE_MEETING_NATIVE_RECORDING.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            a = r0;
        }
    }

    public MmRecordingSession() {
        throw null;
    }

    public final MmRecordingAudioService a() {
        return (MmRecordingAudioService) this.j.getValue();
    }

    public final l b() {
        return (l) this.z.getValue();
    }

    public final DoubaoBizInfo c() {
        k r0 = this.f;
        Object r1 = null;
        if (r0 == null) goto L23;
        Map<String, Object> r2 = r0.b;
        if (r2 == null) goto L24;
        Object r3 = r2.get("doubao_biz_info");
        if (r3 == null) goto L25;
        String r4 = r3.toString();
        if (r4 == null) goto L26;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L13
        Gson r6 = e0.a;     // Catch: Throwable -> L13
        Object r7 = Result.constructor-impl((DoubaoBizInfo) e0.a(r4, DoubaoBizInfo.class));     // Catch: Throwable -> L13
    L16:
        if (Result.isFailure-impl(r7) == true) goto L20;
        r1 = r7;
    L20:
        return (DoubaoBizInfo) r1;
    L13:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L16
    L26:
        return null;
    L25:
        return null;
    L24:
        return null;
    L23:
        return null;
    }

    public final String d() {
        RecordingSessionType r0 = this.a;
        int r1 = b.a[r0.ordinal()];
        if (r1 == 2) goto L19;
        if (r1 != 3) goto L21;
        k r2 = this.f;
        if (r2 == null) goto L14;
        Map<String, Object> r3 = r2.b;
        if (r3 == null) goto L14;
        Object r4 = r3.get("hardware_live_record_id");
        if (r4 == null) goto L14;
        String r5 = r4.toString();
    L15:
        if (r5 != null) goto L20;
        return "";
    L20:
        return r5;
    L14:
        r5 = null;
        goto L15
    L21:
        return "";
    L19:
        return this.w.g;
    }

    public final String e() {
        RecordingSessionType r0 = this.a;
        boolean r1 = true;
        switch(b.a[r0.ordinal()]) {
            case 1: goto L16;
            case 2: goto L16;
            case 3: goto L16;
            case 4: goto L10;
            case 5: goto L7;
            case 6: goto L23;
            default: goto L5;
        };
    L7:
        String r2 = this.e;
        if (r2 != null) goto L24;
        return "";
    L24:
        return r2;
    L10:
        String r3 = this.w.c;
        if (r3.length() == 0) goto L14;
        r1 = false;
    L14:
        if (r1 == true) goto L27;
        return r3;
    L27:
        return this.w.a;
    L16:
        String r4 = this.w.c;
        if (r4.length() == 0) goto L20;
        r1 = false;
    L20:
        if (r1 == true) goto L22;
        return r4;
    L22:
        return this.w.a;
    L5:
        throw new NoWhenBranchMatchedException();
    L23:
        return this.w.g;
    }

    public final MmRecordingRepo f() {
        return (MmRecordingRepo) this.m.getValue();
    }

    public final com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c g() {
        return (com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c) ((Pair) this.t.getValue()).getSecond();
    }

    public final MmStandaloneAIInterpretationRootRepo h() {
        return (MmStandaloneAIInterpretationRootRepo) this.n.getValue();
    }

    public final MmRecordingStatesSyncService i() {
        return (MmRecordingStatesSyncService) this.l.getValue();
    }

    public final MmRecordingCommonParam j() {
        MmRecordingCommonParam r0 = this.b.N().b(e());
        if (r0 == null) goto L5;
        return r0;
    L5:
        return this.w.f;
    }

    public final MmRecordingUploadService k() {
        return (MmRecordingUploadService) this.k.getValue();
    }

    public final void q() {
        lvb.a.e(this.h, "[releaseSession] recordingId=" + e());
        this.d = null;
        qvb.a r2 = qvb.a.a;
        String r3 = e();
        Intrinsics.checkNotNullParameter(r3, "recordingId");
        AtomicReference<qvb.a.C0181a> r4 = qvb.a.b;
        qvb.a.C0181a r5 = r4.get();
        boolean r6 = false;
        if (r5 != null) goto L6;
    L21:
        Set<String> r7 = qvb.b.a;
        String r8 = e();
        Intrinsics.checkNotNullParameter(r8, "recordingId");
        if (r8.length() != 0) goto L25;
        r6 = true;
    L25:
        if (r6 == false) goto L27;
    L30:
        qvb.b.b = "";
        qvb.b.c = new MmRecordingCommonParam(null, null, false, null, null, null, null, null, null, null, null, 2047, null);
        qvb.b.d = "";
        qvb.b.e = "";
        lvb.a.e("MmRecordingPerfTracker", "[clearPerfContext] cleared, recordingId=".concat(r8));
    L31:
        MmRecordingAudioService r9 = a();
        if (r9 == null) goto L37;
        lvb.a.e(r9.e, "[releaseAudioService]");
        r9.x.j();
        MmExternalAudioCapturePipeline r10 = r9.F;
        if (r10 == null) goto L36;
        r10.g();
        r10.l = null;
        CoroutineScopeKt.cancel$default(r10.h, null, 1, null);
    L36:
        r9.F = null;
        CoroutineScopeKt.cancel$default(r9.h, null, 1, null);
        MmRecordingAudioProcessor r11 = (MmRecordingAudioProcessor) r9.v.getValue();
        lvb.a.e(r11.e, "release");
        SendChannel.a.a(r11.m);
        CoroutineScopeKt.cancel$default((CoroutineScope) r11.f.getValue(), null, 1, null);
        CoroutineScopeKt.cancel$default((CoroutineScope) r11.h.getValue(), null, 1, null);
        MmRecordingEncodedAudioProcessor r12 = (MmRecordingEncodedAudioProcessor) r9.w.getValue();
        SendChannel.a.a(r12.f);
        CoroutineScopeKt.cancel$default((CoroutineScope) r12.e.getValue(), null, 1, null);
        CoroutineScopeKt.cancel$default(r9.g, null, 1, null);
    L37:
        MmRecordingUploadService r13 = k();
        lvb.a.e(r13.c, "[releaseUploadService]");
        r13.f().b("release");
        r13.d.shutdownNow();
        r13.f.clear();
        Object r14 = r13.g;
        monitor-enter(r14);
        r13.h.clear();     // Catch: Throwable -> L73
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L73
        monitor-exit(r14);
        CoroutineScopeKt.cancel$default(r13.i, null, 1, null);
        MmRecordingStatesSyncService r16 = i();
        lvb.a.e(r16.c, "[releaseStatesSyncService]");
        MmRecordingCreateService r17 = (MmRecordingCreateService) r16.e.getValue();
        lvb.a.e(r17.d, "[releaseCreateService]");
        Deferred r18 = r17.h;
        if (r18 == null) goto L44;
        Job.DefaultImpls.cancel$default(r18, null, 1, null);
    L44:
        r17.h = null;
        r17.g = null;
        Job r19 = r17.f;
        if (r19 == null) goto L47;
        Job.DefaultImpls.cancel$default(r19, null, 1, null);
    L47:
        lvb.a.e(r17.d, "Network state listener unregistered");
        CoroutineScopeKt.cancel$default(r17.e, null, 1, null);
        Job r20 = r16.i;
        if (r20 == null) goto L50;
        Job.DefaultImpls.cancel$default(r20, null, 1, null);
    L50:
        kotlinx.coroutines.channels.a r21 = r16.j.d.b;
        if (r21 == null) goto L53;
        SendChannel.a.a(r21);
    L53:
        CoroutineScopeKt.cancel$default(r16.g, null, 1, null);
        CoroutineScopeKt.cancel$default(r16.h, null, 1, null);
        MmRecordingRepo r22 = f();
        if (r22 == null) goto L56;
        r22.B();
    L56:
        MmStandaloneAIInterpretationRootRepo r23 = h();
        if (r23 != null) goto L59;
    L71:
        CoroutineScopeKt.cancel$default(this.v, null, 1, null);
        CoroutineScopeKt.cancel$default(this.u, null, 1, null);
        MmRecordingSessionStateMachine r24 = this.s;
        lvb.a.e(r24.b, "[releaseStateMachine] currentState=" + r24.f.b.get());
        CoroutineScopeKt.cancel$default(r24.c, null, 1, null);
        return;
    L59:
        if (r23.f.isInitialized() == false) goto L62;
        r23.a().t().onDestroy();
    L62:
        if (r23.g.isInitialized() == false) goto L65;
        r23.l().l().onDestroy();
    L65:
        if (r23.h.isInitialized() == false) goto L68;
        r23.h().l().onDestroy();
    L68:
        if (r23.i.isInitialized() == false) goto L70;
        r23.b().l().onDestroy();
    L70:
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.helper.a r25 = r23.n();
        lvb.a.e(r25.a, "stop");
        Object r26 = LarkNetworkLevelManager.d;
        LarkNetworkLevelManager.a.a().x0(r25.d);
    L73:
        th = move-exception;
        throw th;
    L27:
        if (Intrinsics.areEqual(qvb.b.b, r8) == true) goto L30;
        lvb.a.h("MmRecordingPerfTracker", "[clearPerfContext] skipped, inputRecordingId=" + r8 + ", currentRecordingId=" + qvb.b.b);
        goto L31
    L6:
        if (r3.length() != 0) goto L8;
        boolean r27 = true;
    L10:
        if (r27 == true) goto L16;
        if (Intrinsics.areEqual(r5.a, r3) == true) goto L16;
        lvb.a.h("MmRecordingErrorTracker", "[clearAlertContext] skipped, inputRecordingId=" + r3 + ", currentRecordingId=" + r5.a + ", traceId=" + r5.b.getRecordingTraceId());
    L16:
        if (r4.compareAndSet(r5, null) == true) goto L20;
        if (r4.get() == r5) goto L16;
    L20:
        lvb.a.e("MmRecordingErrorTracker", "[clearAlertContext] cleared, recordingId=" + r3 + ", traceId=" + r5.b.getRecordingTraceId());
        goto L21
    L8:
        r27 = false;
        goto L10
    }

    public final boolean v() {
        return this.x.getUsesRecordingApi();
    }

    public final void m(MmRecordingError r2) {
        Intrinsics.checkNotNullParameter(r2, "error");
        iub.a<Pair<MmRecordingSession, j>, ? super MmRecordingError> r0 = this.d;
        if (r0 == null) goto L6;
        r0.a(r2);
        return;
    }

    public final void n(MmRecordingError r3) {
        Intrinsics.checkNotNullParameter(r3, "error");
        iub.a<Pair<MmRecordingSession, j>, ? super MmRecordingError> r0 = this.d;
        this.d = null;
        q();
        if (r0 == null) goto L6;
        r0.a(r3);
        return;
    }

    public final void o(j r4) {
        Intrinsics.checkNotNullParameter(r4, "result");
        iub.a<Pair<MmRecordingSession, j>, ? super MmRecordingError> r0 = this.d;
        if (this.a == RecordingSessionType.PRE_MEETING_NATIVE_RECORDING) goto L5;
        this.d = null;
    L5:
        if (r0 == null) goto L8;
        r0.onSuccess(TuplesKt.to(this, r4));
        return;
    }

    public final void p(MmRecordingCommonParam r18) {
        DoubaoBizInfo r1 = c();
        String r9 = this.c;
        MmRecordingSource r2 = r18.getSource();
        String r16 = null;
        if (r2 != null) goto L8;
        k r3 = this.f;
        if (r3 == null) goto L7;
        r2 = r3.a;
        goto L8
    L7:
        MmRecordingSource r10 = null;
    L9:
        MmRecordingCommonParam r4 = MmRecordingCommonParam.copy$default(r18, null, null, false, null, null, null, r9, r10, null, null, null, 1855, null);
        qvb.a r5 = qvb.a.a;
        qvb.a.a(e(), r4, r1, this.a);
        Set<String> r6 = qvb.b.a;
        String r7 = e();
        Intrinsics.checkNotNullParameter(r7, "sessionId");
        Intrinsics.checkNotNullParameter(r4, "commonParam");
        qvb.b.b = r7;
        qvb.b.c = r4;
        if (r1 == null) goto L12;
        String r8 = r1.getConversationId();
    L13:
        String r11 = "";
        if (r8 != null) goto L16;
        r8 = "";
    L16:
        qvb.b.d = r8;
        if (r1 == null) goto L19;
        r16 = r1.getMessageId();
    L19:
        if (r16 == null) goto L22;
        r11 = r16;
    L22:
        qvb.b.e = r11;
        return;
    L12:
        r8 = null;
    L8:
        r10 = r2;
        goto L9
    }

    public final Object r(Continuation<? super ovb.b> r4) {
        return BuildersKt.withContext(this.u.getCoroutineContext(), new MmRecordingSession$safeGetRecordingDate$2(this, null), r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*  JADX ERROR: JadxRuntimeException in pass: FinishTypeInference
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r7v29 boolean
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.dex.visitors.typeinference.FinishTypeInference.lambda$visit$0(FinishTypeInference.java:27)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at jadx.core.dex.visitors.typeinference.FinishTypeInference.visit(FinishTypeInference.java:22)
        */
    public final boolean u(com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.a r37) {
        /*  JADX ERROR: Simple mode code generation failed
            jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r7v29 boolean
            	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:341)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            Method dump skipped, instruction units count: 1126
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSession.u(com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.a):boolean");
    }

    public static void l(MmRecordingSession r2, ErrorResult r3) {
        MmRecordingError.CreateRecordingRequestFailed r0 = MmRecordingError.CreateRecordingRequestFailed.INSTANCE;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r0, "error");
        r2.i = new a(r0, r3);
    }

    public final Object s(Function2<? super ovb.b, ? super Continuation<? super ovb.b>, ? extends Object> r4, Continuation<? super Unit> r5) {
        Object r6 = BuildersKt.withContext(this.u.getCoroutineContext(), new MmRecordingSession$safeUpdateRecordingData$2(this, r4, null), r5);
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r6;
    L6:
        return Unit.INSTANCE;
    }

    public final Object t(com.ss.android.lark.officesdk.minutes.service.recording.common.repo.notification.b r2, Continuation<? super Unit> r3) {
        MmRecordingRepo r0 = f();
        if (r0 == null) goto L10;
        Object r4 = r0.j(r2, r3);
        if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L8;
        return r4;
    L8:
        return Unit.INSTANCE;
    L10:
        return Unit.INSTANCE;
    }

    public MmRecordingSession(RecordingSessionType r28, com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r29, String r30, MmRecordingSessionManager$startRealtimeRecording$1.a r31, String r32, k r33, MmRecordingRoute r34, sub.b r35, MmRecordingCommonParam r36, int r37) {
        if ((r37 & 4) == 0) goto L5;
        String r12 = k0.a(16);
    L7:
        if ((r37 & 8) == 0) goto L9;
        MmRecordingSessionManager$startRealtimeRecording$1.a r4 = null;
    L11:
        if ((r37 & 16) == 0) goto L13;
        String r5 = null;
    L15:
        if ((r37 & 32) == 0) goto L17;
        k r6 = null;
    L19:
        if ((r37 & 64) == 0) goto L25;
        MmRecordingRoute.a r7 = MmRecordingRoute.Companion;
        if (r6 == null) goto L23;
        MmRecordingSource r9 = r6.a;
    L24:
        r7.getClass();
        MmRecordingRoute r15 = MmRecordingRoute.a.a(r9, false);
    L27:
        if ((r37 & 128) == 0) goto L29;
        sub.b r8 = null;
    L31:
        if ((r37 & 256) == 0) goto L33;
        MmRecordingCommonParam r3 = null;
    L34:
        Intrinsics.checkNotNullParameter(r28, "sessionType");
        Intrinsics.checkNotNullParameter(r29, "userComponentContext");
        Intrinsics.checkNotNullParameter(r12, "recordingTraceId");
        Intrinsics.checkNotNullParameter(r15, "initialRecordingRoute");
        this.a = r28;
        this.b = r29;
        this.c = r12;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r8;
        String r10 = "MmRecordingSession_" + hashCode();
        this.h = r10;
        new AtomicBoolean(false);
        this.j = LazyKt.lazy(new MmRecordingSession$audioService$2(this));
        this.k = LazyKt.lazy(new MmRecordingSession$uploadService$2(this));
        this.l = LazyKt.lazy(new MmRecordingSession$statesSyncService$2(this));
        this.m = LazyKt.lazy(new MmRecordingSession$recordingRepo$2(this));
        this.n = LazyKt.lazy(new MmRecordingSession$standaloneAIInterpretationRootRepo$2(this));
        Flow<Integer> r11 = j1.a(0);
        MmRecordingAudioService r13 = a();
        if (r13 == null) goto L39;
        Flow<Integer> r14 = r13.l;
        if (r14 == null) goto L39;
        r11 = r14;
    L39:
        this.o = r11;
        StateFlowImpl r16 = j1.a(0L);
        MmRecordingAudioService r17 = a();
        if (r17 == null) goto L43;
        b1 r18 = r17.n;
        if (r18 == null) goto L43;
    L44:
        this.p = r18;
        com.ss.android.lark.officesdk.minutes.service.recording.common.core.b r19 = new com.ss.android.lark.officesdk.minutes.service.recording.common.core.b();
        this.q = r19;
        this.r = r19.b;
        MmRecordingSessionStateMachine r20 = new MmRecordingSessionStateMachine(r28);
        this.s = r20;
        this.t = r20.e;
        CoroutineScope r110 = CoroutineScopeKt.MainScope();
        this.u = r110;
        this.v = CoroutineScopeKt.MainScope();
        if (r3 != null) goto L67;
        if (r5 != null) goto L49;
        String r21 = "";
    L50:
        boolean r111 = r28.isHardwareRecording();
        if (r6 == null) goto L55;
        MmRecordingSource r112 = r6.a;
        if (r112 == null) goto L55;
        String r113 = r112.name();
    L56:
        if (r113 != null) goto L58;
        r113 = "";
    L58:
        if (r5 != null) goto L60;
        String r114 = "";
    L61:
        String r115 = r29.getCurrentUserId();
        if (r6 == null) goto L64;
        MmRecordingSource r22 = r6.a;
    L65:
        r3 = new MmRecordingCommonParam(null, r21, r111, r113, r114, r115, r12, r22, r29.getTenantId(), null, r28.name(), 513, null);
        goto L67
    L64:
        r22 = null;
        goto L65
    L60:
        r114 = r5;
    L55:
        r113 = null;
        goto L56
    L49:
        r21 = r5;
    L67:
        this.w = new ovb.b(r3, 223);
        this.x = r15;
        this.y = LazyKt.lazy(new MmRecordingSession$stateHandler$2(this));
        this.z = LazyKt.lazy(new MmRecordingSession$diagnosisReporter$2(this));
        lvb.a.e(r10, "[init] type=" + r28 + ", userContext=" + r29);
        p(j());
        BuildersKt.launch$default(r110, null, null, new MmRecordingSession$processStateChange$1(this, null), 3, null);
        MmRecordingRepo r1 = f();
        if (r1 == null) goto L71;
        r1.p();
        return;
    L71:
        return;
    L43:
        r18 = e.b(r16);
        goto L44
    L33:
        r3 = r36;
        goto L34
    L29:
        r8 = r35;
        goto L31
    L23:
        r9 = null;
        goto L24
    L25:
        r15 = r34;
        goto L27
    L17:
        r6 = r33;
        goto L19
    L13:
        r5 = r32;
        goto L15
    L9:
        r4 = r31;
        goto L11
    L5:
        r12 = r30;
        goto L7
    }
}
