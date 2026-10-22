package com.obric.assistant.state.impl.multitask.producer;

import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.bean.DMConstData;
import com.obric.aiagent.assistant.idl.bean.DMTaskInfo;
import com.obric.aiagent.assistant.idl.bean.IMMessage;
import com.obric.assistant.state.multitask.ext.TaskFlowDslKt;
import java.util.LinkedHashMap;
import java.util.Map;
import jha.g;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.state.impl.multitask.producer.ComplexTaskStateProducer$emitComplexTaskEnd$1", f = "ComplexTaskStateProducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ComplexTaskStateProducer$emitComplexTaskEnd$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DMTaskInfo $taskInfo;
    int label;
    final /* synthetic */ ComplexTaskStateProducer this$0;

    public ComplexTaskStateProducer$emitComplexTaskEnd$1(DMTaskInfo r1, ComplexTaskStateProducer r2, Continuation<? super ComplexTaskStateProducer$emitComplexTaskEnd$1> r3) {
        this.$taskInfo = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ComplexTaskStateProducer$emitComplexTaskEnd$1(this.$taskInfo, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L28;
        ResultKt.throwOnFailure(r13);
        IMMessage r14 = this.$taskInfo.getMessage();
        if (r14 == null) goto L7;
        String r15 = r14.getConversationId();
    L8:
        String r1 = r15;
        g<aha.d> r16 = aha.e.a(r1, this.$taskInfo.getTaskId());
        ComplexTaskStateProducer$a r0 = (ComplexTaskStateProducer$a) this.this$0.b.remove(r16);
        if (r0 != null) goto L12;
        FLogger.a.i("ComplexTaskStateProducer", "emitComplexTaskEnd: task " + r16 + " not active, skip");
        return Unit.INSTANCE;
    L12:
        aha.d r2 = r0.b;
        IMMessage r3 = this.$taskInfo.getMessage();
        if (r3 == null) goto L16;
        String r4 = com.larus.bmhome.chat.bean.d.H(com.obric.assistant.state.impl.v2.utils.d.a(r3));
        if (r4 == null) goto L16;
    L17:
        Map<String, String> r5 = r2.e();
        if (r5 == null) goto L21;
        Map r6 = MapsKt.toMutableMap(r5);
        if (r6 == null) goto L21;
    L22:
        Map r7 = r6;
        r7.put("origin_query", r4);
        Map r8 = this.$taskInfo.getExt();
        if (r8 == null) goto L25;
        r7.putAll(r8);
    L25:
        TaskFlowDslKt.c(r0.a, new aha.d.c(r1, this.$taskInfo.getTaskId(), Boxing.boxInt(DMConstData.DMComplexTaskState.Terminated.ordinal()), r2.g(), r7, r2.b()));
        FLogger.a.i("ComplexTaskStateProducer", "emitComplexTaskEnd: task " + r16 + " ended");
        return Unit.INSTANCE;
    L21:
        r6 = new LinkedHashMap();
    L16:
        r4 = "";
        goto L17
    L7:
        r15 = null;
        goto L8
    L28:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
