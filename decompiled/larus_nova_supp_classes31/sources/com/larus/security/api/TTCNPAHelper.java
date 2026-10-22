package com.larus.security.api;

import com.bytedance.ttcnpa.TTCNPA;
import com.bytedance.ttcnpa.TtCnpaManifest;
import com.larus.common.apphost.AppHost;
import com.larus.platform.service.k3;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class TTCNPAHelper {
    public static final TTCNPAHelper a = null;
    public static boolean b;
    public static boolean c;
    public static final List<kotlinx.coroutines.i<Unit>> d = null;

    public TTCNPAHelper() {
    }

    static {
        a = new TTCNPAHelper();
        d = new ArrayList();
    }

    public static final String a(TTCNPAHelper r1, l r2) {
        r1.getClass();
        if (r2 != null) goto L6;
        return "null";
    L6:
        return "{label=" + r2.a + ", contentProducer=" + r2.b + ", produceId=" + r2.c + ", reservedCode1=" + r2.d + ", contentPropagator=" + r2.e + ", propagateId=" + r2.f + ", reservedCode2=" + r2.g + "}";
    }

    public static final l b(TTCNPAHelper r8, TtCnpaManifest r9) {
        r8.getClass();
        return new l(r9.getLabel(), r9.getContentProducer(), r9.getProduceId(), r9.getReservedCode1(), r9.getContentPropagator(), r9.getPropagateId(), r9.getReservedCode2());
    }

    public final Object d(m r13, Continuation<? super n> r14) {
        if ((r14 instanceof TTCNPAHelper$writeMetadataManually$1) == false) goto L7;
        TTCNPAHelper$writeMetadataManually$1 r0 = (TTCNPAHelper$writeMetadataManually$1) r14;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r15 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L18;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        ResultKt.throwOnFailure(r15);
    L43:
        return r15;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r13 = (m) r0.L$0;
        ResultKt.throwOnFailure(r15);     // Catch: Throwable -> L31
    L29:
        Object r16 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L31
    L33:
        Throwable r17 = Result.exceptionOrNull-impl(r16);
        if (r17 == null) goto L40;
        FLogger.a.e("TTCNPAHelper", "writeMetadataManually init failed", r17);
        String r18 = r17.getMessage();
        if (r18 != null) goto L39;
        r18 = "";
    L39:
        return new n(false, -3, r18, null, null);
    L40:
        CoroutineDispatcher r19 = Dispatchers.getIO();
        TTCNPAHelper$writeMetadataManually$4 r4 = new TTCNPAHelper$writeMetadataManually$4(r13, null);
        r0.L$0 = null;
        r0.label = 2;
        r15 = BuildersKt.withContext(r19, r4, r0);
        if (r15 != r2) goto L43;
        return r2;
    L18:
        ResultKt.throwOnFailure(r15);
        AppHost.Companion r110 = AppHost.a;
        if (r110.isOversea() == false) goto L23;
        return new n(true, 0, "", null, null);
    L23:
        if (StringsKt.isBlank(r13.e) == true) goto L25;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L31
        r110.getApplication();     // Catch: Throwable -> L31
        String r111 = r13.d;     // Catch: Throwable -> L31
        String r6 = r13.g;     // Catch: Throwable -> L31
        r0.L$0 = r13;     // Catch: Throwable -> L31
        r0.label = 1;     // Catch: Throwable -> L31
        if (c(r111, r6, r0) != r2) goto L29;
        return r2;
    L25:
        return new n(false, -1, "empty produceId", null, null);
    L31:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r0 = new TTCNPAHelper$writeMetadataManually$1(this, r14);
        goto L8
    }

    public static Object c(String r8, String r9, Continuation r10) {
        boolean r2 = true;
        kotlinx.coroutines.j r0 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r10), 1);
        r0.C();
        if (AppHost.a.isOversea() == false) goto L5;
        Result.Companion r11 = Result.Companion;
        r0.resumeWith(Result.constructor-impl(Unit.INSTANCE));
    L34:
        Object r12 = r0.B();
        if (r12 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L38;
        DebugProbesKt.probeCoroutineSuspended(r10);
    L38:
        if (r12 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L41;
        return r12;
    L41:
        return Unit.INSTANCE;
    L5:
        final TTCNPAHelper r1 = a;
        monitor-enter(r1);
        boolean r4 = false;
        if (c == true) goto L16;
        TTCNPA.a.getClass();     // Catch: Throwable -> L42
        if (TTCNPA.b == true) goto L16;
        ((ArrayList) d).add(r0);     // Catch: Throwable -> L42
        if (b == true) goto L15;
        b = true;     // Catch: Throwable -> L42
        r2 = false;
        r4 = true;
    L17:
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L42
        monitor-exit(r1);
        if (r2 == false) goto L21;
        Result.Companion r13 = Result.Companion;
        r0.resumeWith(Result.constructor-impl(Unit.INSTANCE));
        goto L34
    L21:
        r0.i(new k(r0));
        if (r4 == false) goto L34;
        final TTCNPAHelper$initIfNeeded$2$3 r5 = new TTCNPAHelper$initIfNeeded$2$3(r1);
        TTCNPAHelper$initIfNeeded$2$4 r6 = new TTCNPAHelper$initIfNeeded$2$4(r1);
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L29
        k3 r14 = k3.a;     // Catch: Throwable -> L29
        if (r14.isInitialized() == false) goto L27;
        FLogger.a.i("TTCNPAHelper", "ttcnpa already initialized");     // Catch: Throwable -> L29
        r5.invoke();     // Catch: Throwable -> L29
        goto L34
    L27:
        r14.a(r8, r9, new i(r1), new j(r5));     // Catch: Throwable -> L29
        FLogger.a.i("TTCNPAHelper", "ttcnpa init started contentProducer=" + r8 + " contentPropagator=" + r9);     // Catch: Throwable -> L29
        Object r15 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L29
    L31:
        Throwable r16 = Result.exceptionOrNull-impl(r15);
        if (r16 == null) goto L34;
        FLogger.a.e("TTCNPAHelper", "ttcnpa init failed", r16);
        r6.invoke(r16);
    L29:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L31
    L15:
        r2 = false;
    L16:
        c = true;     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        throw th;
    }
}
