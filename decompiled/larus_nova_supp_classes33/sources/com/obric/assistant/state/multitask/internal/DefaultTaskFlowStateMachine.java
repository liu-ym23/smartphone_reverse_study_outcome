package com.obric.assistant.state.multitask.internal;

import com.obric.assistant.state.multitask.b;
import com.obric.assistant.state.multitask.b$a;
import jha.i;
import jha.o;
import jha.q;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.a1;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.flow.g1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class DefaultTaskFlowStateMachine<S extends o> implements i<S> {
    public volatile boolean a;
    public volatile q<S> b;
    public final CoroutineScope c;
    public final MutableSharedFlow<q<S>> d;
    public final a1 e;

    @Override // jha.i
    public final void destroy() {
        this.a = true;
        CoroutineScopeKt.cancel$default(this.c, "State machine destroyed, all subscriptions terminated", null, 2, null);
    }

    @Override // jha.i
    public final q<S> a() {
        return this.b;
    }

    @Override // jha.i
    public final a1 getEvents() {
        return this.e;
    }

    public DefaultTaskFlowStateMachine(q<S> r7) {
        Intrinsics.checkNotNullParameter(r7, "initialStateEvent");
        this.b = r7;
        CoroutineScope r1 = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getDefault()));
        this.c = r1;
        MutableSharedFlow<q<S>> r0 = SharedFlowKt.MutableSharedFlow$default(0, 8, BufferOverflow.DROP_OLDEST, 1, null);
        this.d = r0;
        this.e = e.D(new FlowKt__EmittersKt$onStart$.inlined.unsafeFlow.1(new DefaultTaskFlowStateMachine$events$1(this, null), r0), r1, g1.a.a(g1.a, 0, 3), 0);
    }

    @Override // jha.i
    public final Object b(final q<S> r7, final Long r8, Continuation<? super Boolean> r9) {
        if ((r9 instanceof DefaultTaskFlowStateMachine$transitionTo$1) == false) goto L7;
        DefaultTaskFlowStateMachine$transitionTo$1 r0 = (DefaultTaskFlowStateMachine$transitionTo$1) r9;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r10);
    L42:
        return Boxing.boxBoolean(true);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r10);
        if (this.a == true) goto L17;
        final q<S> r11 = this.b;
        b$a r4 = b.a;
        Function0 r5 = new a(r11, r7, r8);
        r4.getClass();
        b$a.a(r5);
        if (r7.a().c == true) goto L22;
        this.d.tryEmit(r7);
        return Boxing.boxBoolean(true);
    L22:
        q<S> r12 = this.b;
        if ((r7 instanceof q.c) == false) goto L26;
    L34:
        boolean r13 = false;
    L35:
        if (r13 == true) goto L37;
        this.b = r7;
        MutableSharedFlow<q<S>> r14 = this.d;
        r0.label = 1;
        if (r14.emit(r7, r0) != r2) goto L42;
        return r2;
    L37:
        return Boxing.boxBoolean(false);
    L26:
        if (r12.getClass() != r7.getClass()) goto L34;
        if (Intrinsics.areEqual(r12.a().a, r7.a().a) == false) goto L34;
        if (r12.a().c != r7.a().c) goto L34;
        if (r12.a().b.getClass() != r7.a().b.getClass()) goto L34;
        r13 = true;
        goto L35
    L17:
        return Boxing.boxBoolean(false);
    L7:
        r0 = new DefaultTaskFlowStateMachine$transitionTo$1(this, r9);
        goto L8
    }
}
