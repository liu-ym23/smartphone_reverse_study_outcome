package com.obric.assistant.state.impl.multitask.producer;

import aha.n;
import com.obric.assistant.state.api.multitask.state.ObricInteractionStateType;
import com.obric.assistant.state.multitask.core.TaskFlowDispatchStrategy;
import com.obric.assistant.state.multitask.ext.TaskFlowDslKt;
import java.util.LinkedHashMap;
import jha.c;
import jha.f;
import jha.g;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.sync.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.state.impl.multitask.producer.ObricInteractionStateProducer$activateInteraction$1", f = "ObricInteractionStateProducer.kt", i = {0, 1}, l = {124, 56}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$0"})
public final class ObricInteractionStateProducer$activateInteraction$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ObricInteractionStateType $interactionType;
    final /* synthetic */ String $ownerId;
    final /* synthetic */ n.a $state;
    final /* synthetic */ g<n> $taskId;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    final /* synthetic */ ObricInteractionStateProducer this$0;

    public ObricInteractionStateProducer$activateInteraction$1(ObricInteractionStateProducer r1, g<n> r2, n.a r3, String r4, ObricInteractionStateType r5, Continuation<? super ObricInteractionStateProducer$activateInteraction$1> r6) {
        this.this$0 = r1;
        this.$taskId = r2;
        this.$state = r3;
        this.$ownerId = r4;
        this.$interactionType = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new ObricInteractionStateProducer$activateInteraction$1(this.this$0, this.$taskId, this.$state, this.$ownerId, this.$interactionType, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L14;
        if (r1 == 1) goto L13;
        if (r1 != 2) goto L12;
        ObricInteractionStateType r2 = (ObricInteractionStateType) this.L$4;
        String r3 = (String) this.L$3;
        g<n> r4 = (g) this.L$2;
        ObricInteractionStateProducer r5 = (ObricInteractionStateProducer) this.L$1;
        a r6 = (a) this.L$0;
        ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L9
    L25:
        jha.m r13 = (jha.m) r12;     // Catch: Throwable -> L9
        if (r13 != null) goto L29;
    L32:
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L9
        r6.unlock(null);
        return Unit.INSTANCE;
    L29:
        if (r13.b == false) goto L32;
        r5.b.put(r4, new ObricInteractionStateProducer.a(r3, r2, r13.a));     // Catch: Throwable -> L9
    L9:
        th = th;
        a r8 = r6;
    L37:
        r8.unlock(null);
        throw th;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L13:
        ObricInteractionStateType r7 = (ObricInteractionStateType) this.L$5;
        String r9 = (String) this.L$4;
        n.a r10 = (n.a) this.L$3;
        g<n> r11 = (g) this.L$2;
        ObricInteractionStateProducer r15 = (ObricInteractionStateProducer) this.L$1;
        r8 = (a) this.L$0;
        ResultKt.throwOnFailure(r12);
        ObricInteractionStateProducer r16 = r15;
    L39:
    L36:
        th = th;
        goto L37
    L19:
        if (((ObricInteractionStateProducer.a) ((LinkedHashMap) r16.b).get(r11)) == null) goto L21;
        r6 = r8;
        goto L32
    L21:
        ExecutorCoroutineDispatcher r17 = f.a;     // Catch: Throwable -> L36
        String r18 = ObricInteractionStateProducer.class.getName();     // Catch: Throwable -> L36
        Intrinsics.checkNotNullParameter(r18, "orderingDomain");     // Catch: Throwable -> L36
        c r19 = new c(TaskFlowDispatchStrategy.CALLER_CONTEXT, r18);     // Catch: Throwable -> L36
        this.L$0 = r8;     // Catch: Throwable -> L36
        this.L$1 = r16;     // Catch: Throwable -> L36
        this.L$2 = r11;     // Catch: Throwable -> L36
        this.L$3 = r9;     // Catch: Throwable -> L36
        this.L$4 = r7;     // Catch: Throwable -> L36
        this.L$5 = null;     // Catch: Throwable -> L36
        this.label = 2;     // Catch: Throwable -> L36
        Object r20 = TaskFlowDslKt.e(r11, r10, r19, this);     // Catch: Throwable -> L36
        if (r20 != r0) goto L24;
        return r0;
    L24:
        r2 = r7;
        r3 = r9;
        r6 = r8;
        r5 = r16;
        r12 = r20;
        r4 = r11;
        goto L25
    L14:
        ResultKt.throwOnFailure(r12);
        r16 = this.this$0;
        r8 = r16.c;
        g<n> r21 = this.$taskId;
        r10 = this.$state;
        String r22 = this.$ownerId;
        ObricInteractionStateType r23 = this.$interactionType;
        this.L$0 = r8;
        this.L$1 = r16;
        this.L$2 = r21;
        this.L$3 = r10;
        this.L$4 = r22;
        this.L$5 = r23;
        this.label = 1;
        if (r8.a(null, this) != r0) goto L17;
        return r0;
    L17:
        r9 = r22;
        r11 = r21;
        r7 = r23;
        goto L39
    }
}
