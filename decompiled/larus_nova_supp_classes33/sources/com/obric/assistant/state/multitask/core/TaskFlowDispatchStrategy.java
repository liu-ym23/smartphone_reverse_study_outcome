package com.obric.assistant.state.multitask.core;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/assistant/state/multitask/core/TaskFlowDispatchStrategy;", "", "<init>", "(Ljava/lang/String;I)V", "SHARED_SERIALIZED", "PRODUCER_SERIALIZED", "CALLER_CONTEXT", "multitask_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TaskFlowDispatchStrategy extends Enum<TaskFlowDispatchStrategy> {
    public static final TaskFlowDispatchStrategy CALLER_CONTEXT = null;
    public static final TaskFlowDispatchStrategy PRODUCER_SERIALIZED = null;
    public static final TaskFlowDispatchStrategy SHARED_SERIALIZED = null;
    public static final /* synthetic */ TaskFlowDispatchStrategy[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<TaskFlowDispatchStrategy> getEntries() {
        return b;
    }

    static {
        TaskFlowDispatchStrategy r0 = new TaskFlowDispatchStrategy("SHARED_SERIALIZED", 0);
        SHARED_SERIALIZED = r0;
        TaskFlowDispatchStrategy r1 = new TaskFlowDispatchStrategy("PRODUCER_SERIALIZED", 1);
        PRODUCER_SERIALIZED = r1;
        TaskFlowDispatchStrategy r3 = new TaskFlowDispatchStrategy("CALLER_CONTEXT", 2);
        CALLER_CONTEXT = r3;
        TaskFlowDispatchStrategy[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static TaskFlowDispatchStrategy[] values() {
        return (TaskFlowDispatchStrategy[]) a.clone();
    }

    public static TaskFlowDispatchStrategy valueOf(String r1) {
        return (TaskFlowDispatchStrategy) a.a(TaskFlowDispatchStrategy.class, r1);
    }

    public TaskFlowDispatchStrategy(String r1, int r2) {
        super(r1, r2);
    }
}
