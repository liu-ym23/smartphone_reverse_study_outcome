package com.obric.assistant.state.impl.multitask.producer;

import aha.u;
import com.obric.aiagent.assistant.idl.bean.DMConstData;
import com.obric.aiagent.assistant.idl.bean.DMTaskInfo;
import com.obric.aiagent.assistant.idl.bean.DMTaskState;
import com.obric.aiagent.assistant.idl.bean.IMMessage;
import com.obric.assistant.state.api.multitask.state.ObricInteractionType;
import com.obric.assistant.state.multitask.core.TaskFlowDispatchStrategy;
import com.obric.assistant.state.multitask.ext.TaskFlowDslKt;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import jha.c;
import jha.f;
import jha.g;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.state.impl.multitask.producer.ComplexTaskStateProducer$emitComplexTaskState$1", f = "ComplexTaskStateProducer.kt", i = {0, 0}, l = {269}, m = "invokeSuspend", n = {"taskFlowId", "activeState"}, s = {"L$0", "L$1"})
final class ComplexTaskStateProducer$emitComplexTaskState$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DMTaskState $newState;
    final /* synthetic */ DMTaskState $previousState;
    final /* synthetic */ DMTaskInfo $taskInfo;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ ComplexTaskStateProducer this$0;

    public ComplexTaskStateProducer$emitComplexTaskState$1(DMTaskInfo r1, DMTaskState r2, DMTaskState r3, ComplexTaskStateProducer r4, Continuation<? super ComplexTaskStateProducer$emitComplexTaskState$1> r5) {
        this.$taskInfo = r1;
        this.$newState = r2;
        this.$previousState = r3;
        this.this$0 = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new ComplexTaskStateProducer$emitComplexTaskState$1(this.$taskInfo, this.$newState, this.$previousState, this.this$0, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r2 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        aha.d.a r3 = (aha.d.a) this.L$1;
        g<aha.d> r4 = (g) this.L$0;
        ResultKt.throwOnFailure(r13);
    L65:
        jha.m r14 = (jha.m) r13;
        if (r14 == null) goto L68;
        this.this$0.b.put(r4, new ComplexTaskStateProducer$a(r14.a, r3));
        if (r14.b == true) goto L73;
        TaskFlowDslKt.f(r14.a, r3);
    L73:
        return Unit.INSTANCE;
    L68:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r13);
        IMMessage r15 = this.$taskInfo.getMessage();
        if (r15 == null) goto L11;
        String r5 = r15.getConversationId();
    L12:
        g<aha.d> r16 = aha.e.a(r5, this.$taskInfo.getTaskId());
        DMTaskInfo r6 = this.$newState.getTaskInfo();
        if (r6 == null) goto L18;
        IMMessage r7 = r6.getMessage();
        if (r7 == null) goto L18;
        String r8 = com.larus.bmhome.chat.bean.d.H(com.obric.assistant.state.impl.v2.utils.d.a(r7));
        if (r8 == null) goto L18;
    L19:
        Map r9 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("origin_query", r8)});
        Map r10 = this.$newState.getExtra();
        if (r10 == null) goto L22;
        r9.putAll(r10);
    L22:
        int r11 = this.$newState.getState();
        DMConstData.DMComplexTaskState r12 = DMConstData.DMComplexTaskState.Idle;
        if (r11 != r12.ordinal()) goto L39;
        DMTaskState r17 = this.$previousState;
        if (r17 != null) goto L27;
    L29:
        r2 = false;
    L30:
        if (r2 == true) goto L73;
        ComplexTaskStateProducer$a r18 = (ComplexTaskStateProducer$a) this.this$0.b.remove(r16);
        if (r18 == null) goto L73;
        jha.l<aha.d> r19 = r18.a;
        if (r19 == null) goto L73;
        String r20 = this.$taskInfo.getTaskId();
        Integer r21 = Boxing.boxInt(r12.ordinal());
        DMTaskInfo r110 = this.$newState.getTaskInfo();
        u r111 = r18.b.b();
        if (r111 != null) goto L38;
        int r112 = m.a;
        r111 = m.d(r5, null, ObricInteractionType.TextMode, 10);
    L38:
        TaskFlowDslKt.c(r19, new aha.d.c(r5, r20, r21, r110, r9, r111));
        goto L73
    L27:
        if (r17.getState() != r12.ordinal()) goto L29;
    L39:
        DMConstData.DMComplexTaskState r22 = DMConstData.DMComplexTaskState.Terminated;
        if (r11 != r22.ordinal()) goto L49;
        ComplexTaskStateProducer$a r113 = (ComplexTaskStateProducer$a) this.this$0.b.remove(r16);
        if (r113 == null) goto L73;
        jha.l<aha.d> r23 = r113.a;
        if (r23 == null) goto L73;
        String r24 = this.$taskInfo.getTaskId();
        Integer r25 = Boxing.boxInt(r22.ordinal());
        DMTaskInfo r114 = this.$newState.getTaskInfo();
        u r115 = r113.b.b();
        if (r115 != null) goto L48;
        int r116 = m.a;
        r115 = m.d(r5, null, ObricInteractionType.TextMode, 10);
    L48:
        TaskFlowDslKt.c(r23, new aha.d.c(r5, r24, r25, r114, r9, r115));
        goto L73
    L49:
        String r26 = this.$taskInfo.getTaskId();
        Integer r27 = Boxing.boxInt(this.$newState.getState());
        DMTaskInfo r28 = this.$newState.getTaskInfo();
        ComplexTaskStateProducer$a r29 = (ComplexTaskStateProducer$a) this.this$0.b.get(r16);
        if (r29 == null) goto L57;
        aha.d r30 = r29.b;
        if (r30 == null) goto L57;
        u r31 = r30.b();
        if (r31 == null) goto L57;
        u r32 = r31;
    L58:
        aha.d.a r117 = new aha.d.a(r5, r26, r27, r28, r9, r32);
        ComplexTaskStateProducer$a r33 = (ComplexTaskStateProducer$a) this.this$0.b.get(r16);
        if (r33 == null) goto L61;
        ConcurrentHashMap r34 = this.this$0.b;
        jha.l<aha.d> r35 = r33.a;
        Intrinsics.checkNotNullParameter(r35, "handle");
        Intrinsics.checkNotNullParameter(r117, "state");
        r34.put(r16, new ComplexTaskStateProducer$a(r35, r117));
        TaskFlowDslKt.f(r33.a, r117);
        goto L73
    L61:
        this.this$0.getClass();
        ExecutorCoroutineDispatcher r36 = f.a;
        Intrinsics.checkNotNullParameter("ComplexTaskStateProducer", "orderingDomain");
        c r37 = new c(TaskFlowDispatchStrategy.PRODUCER_SERIALIZED, "ComplexTaskStateProducer");
        this.L$0 = r16;
        this.L$1 = r117;
        this.label = 1;
        Object r38 = TaskFlowDslKt.e(r16, r117, r37, this);
        if (r38 != r0) goto L64;
        return r0;
    L64:
        r3 = r117;
        r4 = r16;
        r13 = r38;
    L57:
        int r39 = m.a;
        r32 = m.d(r5, null, ObricInteractionType.TextMode, 10);
    L18:
        r8 = "";
        goto L19
    L11:
        r5 = null;
        goto L12
    }
}
