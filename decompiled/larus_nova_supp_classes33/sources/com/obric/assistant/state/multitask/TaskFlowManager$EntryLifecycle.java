package com.obric.assistant.state.multitask;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/assistant/state/multitask/TaskFlowManager$EntryLifecycle;", "", "<init>", "(Ljava/lang/String;I)V", "OPEN", "CLOSING", "CLOSED", "multitask_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TaskFlowManager$EntryLifecycle extends Enum<TaskFlowManager$EntryLifecycle> {
    public static final TaskFlowManager$EntryLifecycle CLOSED = null;
    public static final TaskFlowManager$EntryLifecycle CLOSING = null;
    public static final TaskFlowManager$EntryLifecycle OPEN = null;
    public static final /* synthetic */ TaskFlowManager$EntryLifecycle[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<TaskFlowManager$EntryLifecycle> getEntries() {
        return b;
    }

    static {
        TaskFlowManager$EntryLifecycle r0 = new TaskFlowManager$EntryLifecycle("OPEN", 0);
        OPEN = r0;
        TaskFlowManager$EntryLifecycle r1 = new TaskFlowManager$EntryLifecycle("CLOSING", 1);
        CLOSING = r1;
        TaskFlowManager$EntryLifecycle r3 = new TaskFlowManager$EntryLifecycle("CLOSED", 2);
        CLOSED = r3;
        TaskFlowManager$EntryLifecycle[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static TaskFlowManager$EntryLifecycle[] values() {
        return (TaskFlowManager$EntryLifecycle[]) a.clone();
    }

    public static TaskFlowManager$EntryLifecycle valueOf(String r1) {
        return (TaskFlowManager$EntryLifecycle) r27.a.a(TaskFlowManager$EntryLifecycle.class, r1);
    }

    public TaskFlowManager$EntryLifecycle(String r1, int r2) {
        super(r1, r2);
    }
}
