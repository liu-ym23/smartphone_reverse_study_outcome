package com.obric.assistant.state.impl.multitask.producer;

import aha.d;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.IAgentDMStateManagerIDL;
import com.obric.assistant.state.multitask.core.TaskFlowAutoInitProducer;
import java.util.concurrent.ConcurrentHashMap;
import jha.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000I\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0011\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0002\u001b\u001cB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J$\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0006\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0004\u0012\u00020\n0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcom/obric/assistant/state/impl/multitask/producer/ComplexTaskStateProducer;", "Lcom/obric/assistant/state/multitask/core/TaskFlowAutoInitProducer;", "<init>", "()V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "activeTasks", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/obric/assistant/state/multitask/core/TaskFlowId;", "Lcom/obric/assistant/state/api/multitask/state/ComplexTaskState;", "Lcom/obric/assistant/state/impl/multitask/producer/ComplexTaskStateProducer$ActiveTask;", "dispatchPolicy", "Lcom/obric/assistant/state/multitask/core/TaskFlowDispatchPolicy;", "initProducer", "", "cancelAllActiveTasks", "complexTaskStateListener", "com/obric/assistant/state/impl/multitask/producer/ComplexTaskStateProducer$complexTaskStateListener$1", "Lcom/obric/assistant/state/impl/multitask/producer/ComplexTaskStateProducer$complexTaskStateListener$1;", "emitComplexTaskEnd", "taskInfo", "Lcom/obric/aiagent/assistant/idl/bean/DMTaskInfo;", "emitComplexTaskInit", "emitComplexTaskState", "previousState", "Lcom/obric/aiagent/assistant/idl/bean/DMTaskState;", "newState", "Companion", "ActiveTask", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ComplexTaskStateProducer implements TaskFlowAutoInitProducer {
    public static final /* synthetic */ int d = 0;
    public final CoroutineScope a;
    public final ConcurrentHashMap<g<d>, a> b;
    public final ComplexTaskStateProducer$complexTaskStateListener$1 c;

    static {
    }

    @Override // com.obric.assistant.state.multitask.core.TaskFlowAutoInitProducer
    public final void f() {
        FLogger.a.i("ComplexTaskStateProducer", "init complex task listener for task flow");
        com.obric.aiagent.assistant.idl.f.b(Reflection.getOrCreateKotlinClass(IAgentDMStateManagerIDL.class), new a(this));
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.obric.assistant.state.impl.multitask.producer.ComplexTaskStateProducer$complexTaskStateListener$1] */
    public ComplexTaskStateProducer() {
        ExecutorCoroutineDispatcher r0 = jha.f.a;
        Intrinsics.checkNotNullParameter("ComplexTaskStateProducer", "orderingDomain");
        this.a = jha.f.b("ComplexTaskStateProducer").b;
        this.b = new ConcurrentHashMap();
        this.c = new ComplexTaskStateProducer$complexTaskStateListener$1(this);
    }
}
