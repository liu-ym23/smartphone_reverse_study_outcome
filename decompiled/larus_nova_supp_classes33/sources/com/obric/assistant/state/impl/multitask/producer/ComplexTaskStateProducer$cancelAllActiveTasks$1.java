package com.obric.assistant.state.impl.multitask.producer;

import com.obric.aiagent.assistant.idl.bean.DMConstData;
import com.obric.aiagent.assistant.idl.bean.DMTaskInfo;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import com.obric.assistant.state.multitask.ext.TaskFlowDslKt;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
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
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.state.impl.multitask.producer.ComplexTaskStateProducer$cancelAllActiveTasks$1", f = "ComplexTaskStateProducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ComplexTaskStateProducer$cancelAllActiveTasks$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ComplexTaskStateProducer this$0;

    public ComplexTaskStateProducer$cancelAllActiveTasks$1(ComplexTaskStateProducer r1, Continuation<? super ComplexTaskStateProducer$cancelAllActiveTasks$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ComplexTaskStateProducer$cancelAllActiveTasks$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L17;
        ResultKt.throwOnFailure(r10);
        Iterator r11 = this.this$0.b.values().iterator();
    L6:
        if (r11.hasNext() == false) goto L14;
        ComplexTaskStateProducer$a r0 = (ComplexTaskStateProducer$a) r11.next();
        aha.d r1 = r0.b;
        jha.l<aha.d> r2 = r0.a;
        String r3 = r1.d();
        String r4 = r1.f();
        Integer r5 = Boxing.boxInt(DMConstData.DMComplexTaskState.Terminated.ordinal());
        DMTaskInfo r6 = r1.g();
        Map<String, String> r7 = r1.e();
        if (r7 == null) goto L12;
        Map r8 = MapsKt.toMutableMap(r7);
        if (r8 == null) goto L12;
        r8.put(WindowEvent.Params.REASON, "binder_disconnected");
        Unit r9 = Unit.INSTANCE;
    L13:
        TaskFlowDslKt.c(r2, new aha.d.c(r3, r4, r5, r6, r8, r1.b()));
    L12:
        r8 = MapsKt.mapOf(TuplesKt.to(WindowEvent.Params.REASON, "binder_disconnected"));
        goto L13
    L14:
        this.this$0.b.clear();
        return Unit.INSTANCE;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
