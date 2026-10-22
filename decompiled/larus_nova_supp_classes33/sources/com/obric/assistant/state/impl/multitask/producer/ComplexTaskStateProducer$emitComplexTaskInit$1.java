package com.obric.assistant.state.impl.multitask.producer;

import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.bean.DMTaskInfo;
import com.obric.aiagent.assistant.idl.bean.IMMessage;
import com.obric.assistant.state.api.multitask.state.ObricInteractionType;
import com.obric.assistant.state.multitask.TaskFlowManager;
import com.obric.assistant.state.multitask.core.TaskFlowDispatchStrategy;
import com.obric.assistant.state.multitask.ext.TaskFlowDslKt;
import com.obric.cae.libs.wifi.basicInfo.ChannelsEnvironment;
import java.util.Map;
import jha.c;
import jha.f;
import jha.g;
import jha.p;
import jha.q;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.state.impl.multitask.producer.ComplexTaskStateProducer$emitComplexTaskInit$1", f = "ComplexTaskStateProducer.kt", i = {0, 0}, l = {ChannelsEnvironment.BAND_5_GHZ_LAST_CH_NUM}, m = "invokeSuspend", n = {"taskFlowId", "initState"}, s = {"L$0", "L$1"})
final class ComplexTaskStateProducer$emitComplexTaskInit$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DMTaskInfo $taskInfo;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ ComplexTaskStateProducer this$0;

    public ComplexTaskStateProducer$emitComplexTaskInit$1(DMTaskInfo r1, ComplexTaskStateProducer r2, Continuation<? super ComplexTaskStateProducer$emitComplexTaskInit$1> r3) {
        this.$taskInfo = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ComplexTaskStateProducer$emitComplexTaskInit$1(this.$taskInfo, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        aha.d r2 = (aha.d.b) this.L$1;
        g<aha.d> r3 = (g) this.L$0;
        ResultKt.throwOnFailure(r14);
    L28:
        jha.m r15 = (jha.m) r14;
        if (r15 != null) goto L33;
        FLogger.a.e("ComplexTaskStateProducer", "emitComplexTaskInit: failed to acquire task " + r3);
        return Unit.INSTANCE;
    L33:
        if (r15.b == true) goto L43;
        TaskFlowManager r4 = TaskFlowManager.a;
        q r5 = TaskFlowManager.d(r3);
        if (r5 == null) goto L43;
        p r6 = r5.a();
        if (r6 == null) goto L43;
        aha.d r7 = (aha.d) r6.b;
        if (r7 == null) goto L43;
        r2 = r7;
    L43:
        this.this$0.b.put(r3, new ComplexTaskStateProducer$a(r15.a, r2));
        FLogger.a.i("ComplexTaskStateProducer", "emitComplexTaskInit: task " + r3 + " initialized");
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r14);
        IMMessage r16 = this.$taskInfo.getMessage();
        if (r16 == null) goto L11;
        String r8 = r16.getConversationId();
    L12:
        g<aha.d> r17 = aha.e.a(r8, this.$taskInfo.getTaskId());
        if (this.this$0.b.containsKey(r17) == false) goto L16;
        FLogger.a.i("ComplexTaskStateProducer", "emitComplexTaskInit: task " + r17 + " already active, skip Init");
        return Unit.INSTANCE;
    L16:
        IMMessage r9 = this.$taskInfo.getMessage();
        if (r9 == null) goto L20;
        String r10 = com.larus.bmhome.chat.bean.d.H(com.obric.assistant.state.impl.v2.utils.d.a(r9));
        if (r10 == null) goto L20;
    L21:
        Map r11 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("origin_query", r10)});
        Map r12 = this.$taskInfo.getExt();
        if (r12 == null) goto L24;
        r11.putAll(r12);
    L24:
        String r13 = this.$taskInfo.getTaskId();
        DMTaskInfo r18 = this.$taskInfo;
        int r19 = m.a;
        aha.d.b r110 = new aha.d.b(r8, r13, r18, r11, m.d(r8, null, ObricInteractionType.TextMode, 10));
        this.this$0.getClass();
        ExecutorCoroutineDispatcher r20 = f.a;
        Intrinsics.checkNotNullParameter("ComplexTaskStateProducer", "orderingDomain");
        c r21 = new c(TaskFlowDispatchStrategy.PRODUCER_SERIALIZED, "ComplexTaskStateProducer");
        this.L$0 = r17;
        this.L$1 = r110;
        this.label = 1;
        Object r22 = TaskFlowDslKt.e(r17, r110, r21, this);
        if (r22 != r0) goto L27;
        return r0;
    L27:
        r2 = r110;
        r3 = r17;
        r14 = r22;
    L20:
        r10 = "";
        goto L21
    L11:
        r8 = null;
        goto L12
    }
}
