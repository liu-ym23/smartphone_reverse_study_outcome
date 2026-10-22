package com.larus.business.arc.api;

import com.flow.kmp.common.platform.PlatformLoggerLevel;
import java.util.concurrent.CancellationException;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import ouc.d0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class u {
    public static final u a = null;

    static {
        a = new u();
    }

    public u() {
    }

    public static void d(String r2) {
        wt7.c r0 = wt7.a.a;     // Catch: Throwable -> L4
        wt7.b.a(PlatformLoggerLevel.WARN, "ArcObservability", r2);     // Catch: Throwable -> L4
        return;
    }

    public final Object b(c r6, Continuation r7) {
        if ((r7 instanceof ArcRuntime$dispatchWithoutObservation$1) == false) goto L7;
        ArcRuntime$dispatchWithoutObservation$1 r0 = (ArcRuntime$dispatchWithoutObservation$1) r7;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        String r4 = null;
        if (r3 == 0) goto L20;
        if (r3 != 1) goto L19;
        r6 = (c) r0.L$1;
        String r5 = (String) r0.L$0;
        ResultKt.throwOnFailure(r8);     // Catch: Throwable -> L14 CancellationException -> L16
    L36:
        m r9 = (m) r8;     // Catch: Throwable -> L14 CancellationException -> L16
    L38:
        if ((r9 instanceof m.b) == false) goto L41;
        ((m.b) r9).getClass();
        return v.d(null, r6);
    L41:
        if (Intrinsics.areEqual(r9, m.a.a) == false) goto L45;
        return v.d(v.c(r5, "ARC_RUNTIME_EMPTY_RESULT", "Arc runtime service returned an empty result."), r6);
    L45:
        throw new NoWhenBranchMatchedException();
    L14:
        th = th;
        r4 = r5;
    L47:
        StringBuilder r10 = new StringBuilder("Arc runtime dispatch failed: ");
        String r11 = th.getMessage();
        if (r11 != null) goto L50;
        r11 = th.toString();
    L50:
        r10.append(r11);
        return v.d(v.c(r4, "ARC_RUNTIME_DISPATCH_FAILED", r10.toString()), r6);
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        ResultKt.throwOnFailure(r8);
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L23
        pd6.b r13 = pd6.c.a;     // Catch: Throwable -> L23
        Object r14 = Result.constructor-impl((b0) pd6.c.a(Reflection.getOrCreateKotlinClass(b0.class)));     // Catch: Throwable -> L23
    L26:
        if (Result.isFailure-impl(r14) == false) goto L28;
        r14 = null;
    L28:
        b0 r15 = (b0) r14;
        if (r15 == null) goto L31;
        r0.L$0 = null;     // Catch: CancellationException -> L16 Throwable -> L46
        r0.L$1 = r6;     // Catch: CancellationException -> L16 Throwable -> L46
        r0.label = 1;     // Catch: CancellationException -> L16 Throwable -> L46
        r8 = r15.q0();     // Catch: CancellationException -> L16 Throwable -> L46
        if (r8 != r2) goto L35;
        return r2;
    L35:
        r5 = null;
    L46:
        th = th;
        goto L47
    L31:
        return v.d(v.c(null, "ARC_RUNTIME_SERVICE_UNAVAILABLE", "Arc runtime service is unavailable."), r6);
    L23:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
    L16:
        e = move-exception;
        throw e;
    L7:
        r0 = new ArcRuntime$dispatchWithoutObservation$1(this, r7);
        goto L8
    }

    public static String c(t r2, c r3, ArcCallLifecycle r4) {
        r4.getClass();     // Catch: Throwable -> L4
        r4.a(ArcStage.FINALIZE);     // Catch: Throwable -> L4
    L37:
        d0 r5 = v.e(r2, r3);     // Catch: Throwable -> L7
    L11:
        if (r5 != null) goto L45;
        String r6 = "{\"ok\":false,\"version\":1,\"command\":\"unknown\",\"code\":\"ARC_RUNTIME_SERIALIZATION_FAILED\",\"error\":\"Arc runtime could not serialize the result.\"}";
    L39:
        r4.getClass();     // Catch: Throwable -> L35
        ArcStage r7 = ArcStage.FINALIZE;     // Catch: Throwable -> L35
        Object r0 = r4.b;     // Catch: Throwable -> L35
        monitor-enter(r0);     // Catch: Throwable -> L35
    L32:
        th = move-exception;
        throw th;     // Catch: Throwable -> L35
    L27:
        if (r4.l() == true) goto L30;
        r4.j(r7);     // Catch: Throwable -> L32
    L30:
        monitor-exit(r0);     // Catch: Throwable -> L35
    L36:
        return r6;
    L35:
        r4.k();
        goto L36
    L45:
        wt7.c r8 = wt7.a.a;     // Catch: Throwable -> L20
        juc.d r1 = d0.Companion.serializer();     // Catch: Throwable -> L20
        r8.getClass();     // Catch: Throwable -> L20
        r6 = wt7.c.b(r5, r1);     // Catch: Throwable -> L20
        if (r6 != null) goto L39;
        r4.m(ArcFrameworkFailure.FINALIZE_SERIALIZATION_FAILED);     // Catch: Throwable -> L17
    L18:
        r6 = "{\"ok\":false,\"version\":1,\"command\":\"unknown\",\"code\":\"ARC_RUNTIME_SERIALIZATION_FAILED\",\"error\":\"Arc runtime could not serialize the result.\"}";
        goto L39
    L17:
        r4.k();     // Catch: Throwable -> L20
    L22:
        r4.k();
    L23:
        r6 = "{\"ok\":false,\"version\":1,\"command\":\"unknown\",\"code\":\"ARC_RUNTIME_SERIALIZATION_FAILED\",\"error\":\"Arc runtime could not serialize the result.\"}";
    L20:
        r4.m(ArcFrameworkFailure.FINALIZE_SERIALIZATION_FAILED);     // Catch: Throwable -> L22
    L7:
        r4.m(ArcFrameworkFailure.FINALIZE_INTERNAL_ERROR);     // Catch: Throwable -> L9
    L10:
        r5 = null;
    L9:
        r4.k();
    L4:
        r4.k();
        goto L37
    }

    public final Object a(c r6, ArcCallLifecycle r7, Continuation r8) {
        if ((r8 instanceof ArcRuntime$dispatchObserved$1) == false) goto L7;
        ArcRuntime$dispatchObserved$1 r0 = (ArcRuntime$dispatchObserved$1) r8;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        String r4 = null;
        if (r3 == 0) goto L20;
        if (r3 != 1) goto L19;
        r7 = (ArcCallLifecycle) r0.L$2;
        r6 = (c) r0.L$1;
        String r5 = (String) r0.L$0;
        ResultKt.throwOnFailure(r9);     // Catch: Throwable -> L14 CancellationException -> L16
    L39:
        m r10 = (m) r9;     // Catch: Throwable -> L14 CancellationException -> L16
    L41:
        if ((r10 instanceof m.b) == false) goto L44;
        ((m.b) r10).getClass();
        return c(null, r6, r7);
    L44:
        if (Intrinsics.areEqual(r10, m.a.a) == false) goto L51;
        r7.f();     // Catch: Throwable -> L47
    L49:
        return c(v.c(r5, "ARC_RUNTIME_EMPTY_RESULT", "Arc runtime service returned an empty result."), r6, r7);
    L47:
        r7.k();
        goto L49
    L51:
        throw new NoWhenBranchMatchedException();
    L14:
        th = th;
        r4 = r5;
    L62:
        r7.e();     // Catch: Throwable -> L55
    L56:
        StringBuilder r11 = new StringBuilder("Arc runtime dispatch failed: ");
        String r12 = th.getMessage();
        if (r12 != null) goto L59;
        r12 = th.toString();
    L59:
        r11.append(r12);
        return c(v.c(r4, "ARC_RUNTIME_DISPATCH_FAILED", r11.toString()), r6, r7);
    L55:
        r7.k();
        goto L56
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        ResultKt.throwOnFailure(r9);
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L23
        pd6.b r14 = pd6.c.a;     // Catch: Throwable -> L23
        Object r15 = Result.constructor-impl((b0) pd6.c.a(Reflection.getOrCreateKotlinClass(b0.class)));     // Catch: Throwable -> L23
    L26:
        if (Result.isFailure-impl(r15) == false) goto L28;
        r15 = null;
    L28:
        b0 r16 = (b0) r15;
        if (r16 != null) goto L71;
        r7.g(ArcFrameworkFailure.PREPARE_RUNTIME_UNAVAILABLE);     // Catch: Throwable -> L32
    L34:
        return c(v.c(null, "ARC_RUNTIME_SERVICE_UNAVAILABLE", "Arc runtime service is unavailable."), r6, r7);
    L32:
        r7.k();
        goto L34
    L71:
        r0.L$0 = null;     // Catch: CancellationException -> L16 Throwable -> L52
        r0.L$1 = r6;     // Catch: CancellationException -> L16 Throwable -> L52
        r0.L$2 = r7;     // Catch: CancellationException -> L16 Throwable -> L52
        r0.label = 1;     // Catch: CancellationException -> L16 Throwable -> L52
        r9 = r16.q0();     // Catch: CancellationException -> L16 Throwable -> L52
        if (r9 != r2) goto L38;
        return r2;
    L38:
        r5 = null;
    L52:
        th = th;
    L23:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
    L16:
        e = move-exception;
        throw e;
    L7:
        r0 = new ArcRuntime$dispatchObserved$1(this, r8);
        goto L8
    }
}
