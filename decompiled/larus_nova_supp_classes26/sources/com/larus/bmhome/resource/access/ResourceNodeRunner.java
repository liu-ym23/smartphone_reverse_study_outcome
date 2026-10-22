package com.larus.bmhome.resource.access;

import com.larus.utils.logger.FLogger;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class ResourceNodeRunner {
    public static final ResourceNodeRunner a = null;

    static {
        a = new ResourceNodeRunner();
    }

    public ResourceNodeRunner() {
    }

    public static q0 b(ResourceNodeRunner r8, l0 r9, ResourceNodeStatus r10) {
        Map r7 = MapsKt.emptyMap();
        r8.getClass();
        return new q0(r9.getKey(), r9.d(), r10, 0, null, r7);
    }

    public final Object a(f r24, h0 r25, l0 r26, boolean r27, boolean r28, Continuation<? super m0> r29) {
        f r2 = r24;
        h0 r3 = r25;
        l0 r10 = r26;
        boolean r4 = r28;
        if ((r29 instanceof ResourceNodeRunner$executeNode$1) == false) goto L7;
        ResourceNodeRunner$executeNode$1 r5 = (ResourceNodeRunner$executeNode$1) r29;
        int r6 = r5.label;
        if ((r6 & Integer.MIN_VALUE) == 0) goto L7;
        r5.label = r6 - Integer.MIN_VALUE;
    L8:
        Object r0 = r5.result;
        Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r8 = r5.label;
        if (r8 == 0) goto L18;
        if (r8 != 1) goto L17;
        long r9 = r5.J$0;
        r4 = r5.Z$0;
        l0 r11 = (l0) r5.L$2;
        h0 r12 = (h0) r5.L$1;
        f r13 = (f) r5.L$0;
        ResultKt.throwOnFailure(r0);     // Catch: Throwable -> L14 CancellationException -> L120
        long r14 = r9;
        r2 = r13;
        r10 = r11;
        r3 = r12;
    L36:
        g r1 = (g) r0;     // Catch: Throwable -> L38 CancellationException -> L117
    L117:
        r13 = r2;
        r11 = r10;
    L38:
        Throwable th = th;
        r13 = r2;
        r12 = r3;
        r11 = r10;
        r9 = r14;
    L40:
        FLogger.a.e("ResourceAccessPipeline", "[execute] node=" + r11.getKey() + " exception", th);
        String r15 = r11.getKey();
        String r16 = th.getMessage();
        if (r16 != null) goto L43;
        r16 = "";
    L43:
        g.b r17 = new g.b(new r(r15, "node_exception", r16, th));
        r14 = r9;
        r2 = r13;
        r10 = r11;
        r3 = r12;
        r1 = r17;
    L45:
        if (r2.c() == false) goto L49;
        if (r4 == true) goto L49;
        FLogger.a.i("ResourceAccessPipeline", "[execute] ignore node=" + r10.getKey() + " result after terminal, taskId=" + r2.a);
        return new m0(r10, g.e.a);
    L49:
        long r18 = System.currentTimeMillis() - r14;
        FLogger.a.i("ResourceAccessPipeline", "[execute] finish node=" + r10.getKey() + ", taskId=" + r2.a + ", cost=" + r18);
        boolean r19 = r1 instanceof g.b;
        String r20 = null;
        if (r19 == false) goto L52;
        g.b r21 = (g.b) r1;
    L53:
        if (r21 == null) goto L59;
        r r22 = r21.a;
        if (r22 == null) goto L59;
        String r23 = r22.b;
        if (r23 == null) goto L59;
    L67:
        boolean r30 = r1 instanceof g.a;
        if (r30 == false) goto L71;
        Map<String, String> r31 = ((g.a) r1).a.g;
    L82:
        if (r30 == false) goto L86;
        ResourceNodeStatus r110 = ResourceNodeStatus.CONTINUED;
    L96:
        r2.f(new q0(r10.getKey(), r10.d(), r110, r18, r23, r31));
        Set<ResourceTraceResult> r111 = e0.a;
        if (r30 == false) goto L101;
        ResourceTraceResult r32 = ResourceTraceResult.CONTINUE;
    L111:
        e0.c(r2, r3, r10, r18, r32, r23, r31);
        return new m0(r10, r1);
    L101:
        if (Intrinsics.areEqual(r1, g.e.a) == false) goto L103;
        r32 = ResourceTraceResult.SKIP;
        goto L111
    L103:
        if (r19 == false) goto L106;
        r32 = ResourceTraceResult.FAILED;
        goto L111
    L106:
        if ((r1 instanceof g.c) == false) goto L109;
        r32 = ResourceTraceResult.FALLBACK;
        goto L111
    L109:
        if ((r1 instanceof g.d) == false) goto L114;
        r32 = ResourceTraceResult.READY;
        goto L111
    L114:
        throw new NoWhenBranchMatchedException();
    L86:
        if (Intrinsics.areEqual(r1, g.e.a) == false) goto L88;
        r110 = ResourceNodeStatus.SKIPPED;
        goto L96
    L88:
        if (r19 == false) goto L91;
        r110 = ResourceNodeStatus.FAILED;
        goto L96
    L91:
        if ((r1 instanceof g.c) == false) goto L94;
        r110 = ResourceNodeStatus.FALLBACK;
        goto L96
    L94:
        if ((r1 instanceof g.d) == false) goto L116;
        r110 = ResourceNodeStatus.READY;
        goto L96
    L116:
        throw new NoWhenBranchMatchedException();
    L71:
        if ((r1 instanceof g.d) == false) goto L74;
        r31 = ((g.d) r1).a.f;
        goto L82
    L74:
        if (Intrinsics.areEqual(r1, g.e.a) == true) goto L81;
        if (r19 == true) goto L81;
        if ((r1 instanceof g.c) == true) goto L81;
        throw new NoWhenBranchMatchedException();
    L81:
        r31 = MapsKt.emptyMap();
    L59:
        if ((r1 instanceof g.c) == false) goto L61;
        g.c r33 = (g.c) r1;
    L62:
        if (r33 == null) goto L66;
        r r34 = r33.a;
        if (r34 == null) goto L66;
        r20 = r34.b;
    L66:
        r23 = r20;
        goto L67
    L61:
        r33 = null;
        goto L62
    L52:
        r21 = null;
        goto L53
    L14:
        th = th;
    L118:
        FLogger.a.i("ResourceAccessPipeline", "[execute] node=" + r11.getKey() + " cancelled, taskId=" + r13.a);
        r13.f(b(this, r11, ResourceNodeStatus.CANCELLED));
        return new m0(r11, g.e.a);
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r0);
        if (r24.c() == false) goto L24;
        if (r4 == true) goto L24;
        return new m0(r10, g.e.a);
    L24:
        if (r10.e(r3) == true) goto L27;
        FLogger.a.i("ResourceAccessPipeline", "[execute] skip node=" + r26.getKey() + ", taskId=" + r2.a);
        r2.f(b(this, r10, ResourceNodeStatus.SKIPPED));
        Set<ResourceTraceResult> r35 = e0.a;
        e0.c(r24, r25, r26, 0, ResourceTraceResult.SKIP, null, MapsKt.emptyMap());
        return new m0(r10, g.e.a);
    L27:
        if (r27 == true) goto L29;
    L32:
        r2.f(b(this, r10, ResourceNodeStatus.RUNNING));
        FLogger.a.i("ResourceAccessPipeline", "[execute] start node=" + r26.getKey() + ", phase=" + r26.d() + ", taskId=" + r2.a);
        r14 = System.currentTimeMillis();
        r5.L$0 = r2;     // Catch: Throwable -> L38 CancellationException -> L117
        r5.L$1 = r3;     // Catch: Throwable -> L38 CancellationException -> L117
        r5.L$2 = r10;     // Catch: Throwable -> L38 CancellationException -> L117
        r5.Z$0 = r4;     // Catch: Throwable -> L38 CancellationException -> L117
        r5.J$0 = r14;     // Catch: Throwable -> L38 CancellationException -> L117
        r5.label = 1;     // Catch: Throwable -> L38 CancellationException -> L117
        r0 = r10.c(r3, r5);     // Catch: Throwable -> L38 CancellationException -> L117
        if (r0 != r7) goto L36;
        return r7;
    L29:
        if (r2.e(new a0.e(r26.d(), r26.getKey(), r3.c, r25.b())) == true) goto L32;
        return new m0(r10, g.e.a);
    L7:
        r5 = new ResourceNodeRunner$executeNode$1(this, r29);
        goto L8
    }
}
