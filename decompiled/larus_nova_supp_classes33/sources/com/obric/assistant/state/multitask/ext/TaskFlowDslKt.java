package com.obric.assistant.state.multitask.ext;

import aha.s;
import com.obric.assistant.state.multitask.TaskFlowManager;
import jha.i;
import jha.k;
import jha.l;
import jha.m;
import jha.n;
import jha.o;
import jha.p;
import jha.q;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$;
import kotlinx.coroutines.flow.a1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class TaskFlowDslKt {
    /* JADX WARN: Type inference failed for: r1v2, types: [com.obric.assistant.state.multitask.ext.TaskFlowDslKt$observeAllStates$$inlined$filter$1] */
    public static final TaskFlowDslKt$observeAllStates$$inlined$map$1 a() {
        s r0 = s.a;
        Intrinsics.checkNotNullParameter(r0, "<this>");
        a1 r1 = TaskFlowManager.h;
        final FlowKt__EmittersKt$onStart$.inlined.unsafeFlow.1 r2 = new FlowKt__EmittersKt$onStart$.inlined.unsafeFlow.1(new TaskFlowDslKt$observeAllStates$1(r0, null), r1);
        return new TaskFlowDslKt$observeAllStates$$inlined$map$1(new TaskFlowDslKt$observeAllStates$$inlined$filter$1(r2));
    }

    public static final <S extends o> jha.g<S> b(k<S> r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "id");
        return new jha.g(r2, r1);
    }

    public static void c(l r4, o r5) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, "finalState");
        TaskFlowManager r0 = TaskFlowManager.a;
        TaskFlowManager.g(r4, new q.a(new p(r4.a, r5, true)));
    }

    public static void f(l r4, o r5) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, "newState");
        TaskFlowManager r0 = TaskFlowManager.a;
        TaskFlowManager.g(r4, new q.c(new p(r4.a, r5, true)));
    }

    public static Object e(jha.g r6, o r7, jha.c r8, Continuation r9) {
        return d(r6, r7, true, r8, null, r9);
    }

    public static final <S extends o> Object d(jha.g<S> r4, S r5, boolean r6, jha.c r7, i<S> r8, Continuation<? super m<S>> r9) {
        if ((r9 instanceof TaskFlowDslKt$tryStart$1) == false) goto L7;
        TaskFlowDslKt$tryStart$1 r0 = (TaskFlowDslKt$tryStart$1) r9;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        p r11 = (p) r0.L$3;
        r8 = (i) r0.L$2;
        r7 = (jha.c) r0.L$1;
        jha.g<S> r12 = (jha.g) r0.L$0;
        ResultKt.throwOnFailure(r10);
    L15:
        TaskFlowManager r13 = TaskFlowManager.a;
        n r14 = TaskFlowManager.h(r12, new q.b(r11), r7, r8);
        if ((r14 instanceof n.d) == true) goto L18;
        if ((r14 instanceof n.b) == true) goto L22;
        if ((r14 instanceof n.a) == false) goto L29;
        Deferred<Unit> r15 = ((n.a) r14).a;
        r0.L$0 = r12;
        r0.L$1 = r7;
        r0.L$2 = r8;
        r0.L$3 = r11;
        r0.label = 1;
        if (r15.await(r0) != r2) goto L15;
        return r2;
    L29:
        if ((r14 instanceof n.c) == false) goto L33;
        return null;
    L33:
        throw new NoWhenBranchMatchedException();
    L22:
        return new m(((n.b) r14).a, false);
    L18:
        return new m(((n.d) r14).a, true);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r10);
        p r16 = new p(r4, r5, r6);
        r12 = r4;
        r11 = r16;
    L7:
        r0 = new TaskFlowDslKt$tryStart$1(r9);
        goto L8
    }
}
