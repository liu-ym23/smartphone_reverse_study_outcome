package com.ss.android.lark.officesdk.minutes.service.recording.common.core.orchestrator;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingError;
import com.ss.android.lark.officesdk.minutes.api.recording.common.orchestrator.RecordingPriorityScene;
import com.ss.android.lark.officesdk.minutes.api.recording.common.orchestrator.RecordingRejectReason;
import com.ss.android.lark.officesdk.minutes.service.foundation.userscope.MinutesUCCImpl;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.JobKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b {
    public final RecordingPriorityDecisionEngine a;
    public final MmRecordingPriorityActionExecutor b;
    public final String c;

    public b(MinutesUCCImpl r4) {
        RecordingPriorityDecisionEngine r0 = new RecordingPriorityDecisionEngine(0);
        MmRecordingPriorityActionExecutor r1 = new MmRecordingPriorityActionExecutor(r4);
        Intrinsics.checkNotNullParameter(r4, "userContext");
        Intrinsics.checkNotNullParameter(r0, "decisionEngine");
        Intrinsics.checkNotNullParameter(r1, "actionExecutor");
        this.a = r0;
        this.b = r1;
        this.c = "RecordingPriorityAdmissionCoordinator_" + hashCode();
    }

    public final Object a(List r10, Continuation r11) {
        if ((r11 instanceof RecordingPriorityAdmissionCoordinator$executeInterruptActions$1) == false) goto L7;
        RecordingPriorityAdmissionCoordinator$executeInterruptActions$1 r0 = (RecordingPriorityAdmissionCoordinator$executeInterruptActions$1) r11;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        MmRecordingError r4 = null;
        if (r3 == 0) goto L20;
        if (r3 != 1) goto L19;
        tub.d r13 = (tub.d) r0.L$2;
        Iterator r5 = (Iterator) r0.L$1;
        RecordingPriorityScene r6 = (RecordingPriorityScene) r0.L$0;
        ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L14 CancellationException -> L16
        Object r7 = ((Result) r12).unbox-impl();     // Catch: Throwable -> L14 CancellationException -> L16
        b r14 = this;
    L34:
        Throwable r8 = Result.exceptionOrNull-impl(r7);
        if (r8 != null) goto L37;
        b r15 = r14;
    L26:
        if (r5.hasNext() == false) goto L56;
        tub.d r16 = (tub.d) r5.next();
        MmRecordingPriorityActionExecutor r9 = r15.b;     // Catch: CancellationException -> L16 Throwable -> L31
        r0.L$0 = r6;     // Catch: CancellationException -> L16 Throwable -> L31
        r0.L$1 = r5;     // Catch: CancellationException -> L16 Throwable -> L31
        r0.L$2 = r16;     // Catch: CancellationException -> L16 Throwable -> L31
        r0.label = 1;     // Catch: CancellationException -> L16 Throwable -> L31
        r7 = r9.b(r6, r16, r0);     // Catch: CancellationException -> L16 Throwable -> L31
        if (r7 != r2) goto L33;
        return r2;
    L33:
        r14 = r15;
        r13 = r16;
        goto L34
    L31:
        Throwable th = th;
    L32:
        Result.Companion r17 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        tub.d r18 = r16;
        r14 = r15;
        r13 = r18;
        goto L34
    L56:
        Result.Companion r19 = Result.Companion;
        return Result.constructor-impl(Unit.INSTANCE);
    L37:
        if ((r8 instanceof CancellationException) == false) goto L39;
        throw r8;
    L39:
        if ((r8 instanceof MmRecordingError.PriorityActionFailed) == false) goto L42;
        MmRecordingError.PriorityActionFailed r20 = (MmRecordingError.PriorityActionFailed) r8;
    L51:
        lvb.a.b(r14.c, "[executeInterruptActions] failed, instance=" + r13 + ", error=" + r20);
        return Result.constructor-impl(ResultKt.createFailure(r20));
    L42:
        if ((r8 instanceof MmRecordingError) == false) goto L44;
        r4 = (MmRecordingError) r8;
    L44:
        if (r4 != null) goto L47;
        r4 = MmRecordingError.InternalError.INSTANCE;
    L47:
        int r21 = r4.getErrorCode();
        String r22 = r8.getMessage();
        if (r22 != null) goto L50;
        r22 = "priority interrupt failed, scene=" + r13.a;
    L50:
        r20 = new MmRecordingError.PriorityActionFailed(r21, r22);
    L16:
        e = move-exception;
        throw e;
    L14:
        th = move-exception;
        th = th;
        r16 = r13;
        r15 = this;
        goto L32
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        ResultKt.throwOnFailure(r12);
        if (r10.isEmpty() == false) goto L24;
        Result.Companion r110 = Result.Companion;
        return Result.constructor-impl(Unit.INSTANCE);
    L24:
        r5 = r10.iterator();
        r6 = null;
        r15 = this;
    L7:
        r0 = new RecordingPriorityAdmissionCoordinator$executeInterruptActions$1(this, r11);
        goto L8
    }

    public final Object b(String r12, tub.b r13, Continuation r14) {
        if ((r14 instanceof RecordingPriorityAdmissionCoordinator$resolveStart$1) == false) goto L7;
        RecordingPriorityAdmissionCoordinator$resolveStart$1 r1 = (RecordingPriorityAdmissionCoordinator$resolveStart$1) r14;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        Object r15 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        if (r4 == 0) goto L18;
        if (r4 != 1) goto L17;
        int r16 = r1.I$0;
        tub.e r17 = (tub.e) r1.L$1;
        RecordingPriorityScene r0 = (RecordingPriorityScene) r1.L$0;
        ResultKt.throwOnFailure(r15);     // Catch: CancellationException -> L14
        Object r18 = ((Result) r15).unbox-impl();     // Catch: CancellationException -> L14
    L45:
        if (Result.isFailure-impl(r18) == false) goto L50;
        if (r16 == 0) goto L61;
        this.a.b(r0, ((tub.e.a) r17).a);     // Catch: CancellationException -> L14
    L61:
        return Result.constructor-impl(new tub.e.b(((tub.e.a) r17).a, RecordingRejectReason.BLOCKED_BY_ACTIVE_SCENE, ((tub.e.a) r17).c, this.a.d(r0, ((tub.e.a) r17).c)));
    L50:
        return Result.constructor-impl(r17);
    L14:
        e = move-exception;
        RecordingPriorityScene r5 = r0;
        int r19 = r16;
        e = e;
    L53:
        if (r19 == 0) goto L55;
        this.a.b(r5, ((tub.e.a) r17).a);
    L55:
        throw e;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r15);
        if (RecordingPriorityScene.OTA != null) goto L21;
    L24:
        r19 = 1;
    L25:
        r5 = null;
        if (r19 == 0) goto L35;
        RecordingPriorityDecisionEngine r6 = this.a;
        monitor-enter(r6);
        Intrinsics.checkNotNullParameter(null, "scene");     // Catch: Throwable -> L32
        Intrinsics.checkNotNullParameter(r13, "priorityContext");     // Catch: Throwable -> L32
        tub.e r110 = r6.f(r12, r13);     // Catch: Throwable -> L32
        r6.d.put(((tub.e.a) r110).a, new tub.d(((tub.e.a) r110).a, r13));     // Catch: Throwable -> L32
        lvb.a.e(r6.c, "[reserveStart] scene=null, sceneInstanceId=" + ((tub.e.a) r110).a + ", active=" + RecordingPriorityDecisionEngine.g(r6.d.values()));     // Catch: Throwable -> L32
        monitor-exit(r6);
    L36:
        r17 = r110;
        if ((r17 instanceof tub.e.a) == false) goto L39;
        JobKt.ensureActive(r1.getContext());     // Catch: CancellationException -> L52
        List<tub.d> r111 = ((tub.e.a) r17).c;     // Catch: CancellationException -> L52
        r1.L$0 = null;     // Catch: CancellationException -> L52
        r1.L$1 = r17;     // Catch: CancellationException -> L52
        r1.I$0 = r19;     // Catch: CancellationException -> L52
        r1.label = 1;     // Catch: CancellationException -> L52
        Object r112 = a(r111, r1);     // Catch: CancellationException -> L52
        if (r112 != r3) goto L43;
        return r3;
    L43:
        r0 = null;
        int r10 = r19;
        r18 = r112;
        r16 = r10;
    L52:
        e = e;
        goto L53
    L39:
        return Result.constructor-impl(r17);
    L32:
        th = move-exception;
        throw th;
    L35:
        r110 = this.a.f(r12, r13);
        goto L36
    L21:
        if (RecordingPriorityScene.D1204_UPLOAD_WALLPAPER == null) goto L24;
        r19 = 0;
    L7:
        r1 = new RecordingPriorityAdmissionCoordinator$resolveStart$1(this, r14);
        goto L8
    }
}
