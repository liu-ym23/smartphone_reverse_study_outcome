package com.larus.bmhome.resource.access;

import com.larus.utils.logger.FLogger;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class ResourceAccessPipeline {
    public static final ResourceAccessPipeline a = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ResourcePipelineRoute.values().length];
            r0[ResourcePipelineRoute.LOCAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[ResourcePipelineRoute.REMOTE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
        a = new ResourceAccessPipeline();
    }

    public ResourceAccessPipeline() {
    }

    public final Object a(f r11, Continuation<? super Unit> r12) {
        if ((r12 instanceof ResourceAccessPipeline$execute$1) == false) goto L7;
        ResourceAccessPipeline$execute$1 r0 = (ResourceAccessPipeline$execute$1) r12;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r13 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L18;
        if (r3 == 1) goto L17;
        if (r3 == 2) goto L16;
        if (r3 != 3) goto L15;
        ResultKt.throwOnFailure(r13);
    L41:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        h0 r14 = (h0) r0.L$1;
        f r4 = (f) r0.L$0;
        ResultKt.throwOnFailure(r13);
    L29:
        h r15 = (h) r13;
    L37:
        r0.L$0 = null;
        r0.L$1 = null;
        r0.label = 3;
        if (b(r4, r14, r15, r0) != r2) goto L41;
        return r2;
    L17:
        r14 = (h0) r0.L$1;
        r4 = (f) r0.L$0;
        ResultKt.throwOnFailure(r13);
    L36:
        r15 = (h) r13;
        goto L37
    L18:
        ResultKt.throwOnFailure(r13);
        h0 r16 = new h0(r11.c, r11);
        Set<ResourceTraceResult> r5 = e0.a;
        e0.b(r11, r16, ResourceTraceStage.TASK_LIFECYCLE, ResourceTraceResult.START, null);
        int r6 = k0.a;
        ResourceInputType r7 = r16.c.getType();
        Intrinsics.checkNotNullParameter(r7, "resourceInputType");
        if (s.a(r7) == false) goto L21;
        ResourcePipelineRoute r8 = ResourcePipelineRoute.REMOTE;
    L22:
        int r9 = a.a[r8.ordinal()];
        if (r9 == 1) goto L32;
        if (r9 != 2) goto L31;
        b r10 = q.a;
        r0.L$0 = r11;
        r0.L$1 = r16;
        r0.label = 2;
        int r17 = p0.a;
        Object r18 = p0.a(r11, r16, CollectionsKt.listOf(new l0[]{new d1(), new p(), new o(), new l(), new k(), new m(), new n(), new i(CollectionsKt.listOf("remote_fallback")), new com.larus.bmhome.resource.access.a()}), q.a, r0);
        if (r18 != r2) goto L28;
        return r2;
    L28:
        r4 = r11;
        r14 = r16;
        r13 = r18;
        goto L29
    L31:
        throw new NoWhenBranchMatchedException();
    L32:
        b r19 = e.a;
        r0.L$0 = r11;
        r0.L$1 = r16;
        r0.label = 1;
        Object r20 = e.a(r11, r16, r0);
        if (r20 != r2) goto L35;
        return r2;
    L35:
        r4 = r11;
        r14 = r16;
        r13 = r20;
        goto L36
    L21:
        r8 = ResourcePipelineRoute.LOCAL;
    L7:
        r0 = new ResourceAccessPipeline$execute$1(this, r12);
        goto L8
    }

    public final Object b(f r7, h0 r8, h r9, Continuation<? super Unit> r10) {
        if ((r10 instanceof ResourceAccessPipeline$handleResult$1) == false) goto L7;
        ResourceAccessPipeline$handleResult$1 r0 = (ResourceAccessPipeline$handleResult$1) r10;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        ResultKt.throwOnFailure(r11);
    L56:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r8 = (h0) r0.L$2;
        r7 = (f) r0.L$1;
        ResourceAccessPipeline r12 = (ResourceAccessPipeline) r0.L$0;
        ResultKt.throwOnFailure(r11);
    L52:
        r0.L$0 = null;
        r0.L$1 = null;
        r0.L$2 = null;
        r0.label = 2;
        if (r12.b(r7, r8, (h) r11, r0) != r2) goto L56;
        return r2;
    L16:
        ResultKt.throwOnFailure(r11);
        if (Intrinsics.areEqual(r9, h.a.a) == false) goto L30;
        if (r7.c() == true) goto L65;
        f0 r13 = r8.h;
        if (r13 != null) goto L24;
        r r14 = new r("pipeline", "empty_artifact", "pipeline finished without artifact", null);
        if (r7.e(new a0.c(r14)) == false) goto L65;
        Set<ResourceTraceResult> r15 = e0.a;
        e0.b(r7, r8, ResourceTraceStage.TASK_LIFECYCLE, ResourceTraceResult.FAILED, r14.b);
        goto L65
    L24:
        if (r7.e(new a0.d(f0.a(r13, MapsKt.plus(r13.f, r8.b())))) == false) goto L65;
        Set<ResourceTraceResult> r16 = e0.a;
        e0.b(r7, r8, ResourceTraceStage.TASK_LIFECYCLE, ResourceTraceResult.READY, null);
    L65:
        return Unit.INSTANCE;
    L30:
        if ((r9 instanceof h.b) == false) goto L35;
        h.b r17 = (h.b) r9;
        if (r7.e(new a0.c(r17.a)) == false) goto L65;
        Set<ResourceTraceResult> r18 = e0.a;
        e0.b(r7, r8, ResourceTraceStage.TASK_LIFECYCLE, ResourceTraceResult.FAILED, r17.a.b);
        goto L65
    L35:
        if ((r9 instanceof h.c) == false) goto L67;
        if (r7.c() == true) goto L39;
        ResourceInputType r19 = r8.c.getType();
        StateFlowImpl r4 = s.a;
        Intrinsics.checkNotNullParameter(r19, "<this>");
        if (r19 != ResourceInputType.LOCAL_PATH) goto L43;
    L46:
        boolean r110 = true;
    L47:
        if (r110 == false) goto L58;
        Set<ResourceTraceResult> r111 = e0.a;
        e0.b(r7, r8, ResourceTraceStage.REMOTE_FALLBACK, ResourceTraceResult.FALLBACK_TO_LOCAL, ((h.c) r9).a.b);
        FLogger.a.i("ResourceAccessPipeline", "[handleResult] remote fallback to local, taskId=" + r7.a + ", resourceInput=" + r8.c.getType());
        b r20 = e.a;
        r0.L$0 = this;
        r0.L$1 = r7;
        r0.L$2 = r8;
        r0.label = 1;
        r11 = e.a(r7, r8, r0);
        if (r11 != r2) goto L51;
        return r2;
    L51:
        r12 = this;
        goto L52
    L58:
        if (r7.c() == true) goto L60;
        h.c r21 = (h.c) r9;
        if (r7.e(new a0.c(r21.a)) == false) goto L65;
        Set<ResourceTraceResult> r112 = e0.a;
        e0.b(r7, r8, ResourceTraceStage.TASK_LIFECYCLE, ResourceTraceResult.FAILED, r21.a.b);
        goto L65
    L60:
        return Unit.INSTANCE;
    L43:
        if (r19 == ResourceInputType.CONTENT_URI) goto L46;
        r110 = false;
        goto L47
    L39:
        return Unit.INSTANCE;
    L67:
        throw new NoWhenBranchMatchedException();
    L7:
        r0 = new ResourceAccessPipeline$handleResult$1(this, r10);
        goto L8
    }
}
