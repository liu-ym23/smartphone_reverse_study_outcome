package com.obric.assistant.task;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/assistant/task/TaskStatus;", "", "<init>", "(Ljava/lang/String;I)V", "QUEUEING", "PROGRESS", "COMPLETED", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TaskStatus extends Enum<TaskStatus> {
    public static final TaskStatus COMPLETED = null;
    public static final TaskStatus PROGRESS = null;
    public static final TaskStatus QUEUEING = null;
    public static final /* synthetic */ TaskStatus[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<TaskStatus> getEntries() {
        return b;
    }

    static {
        TaskStatus r0 = new TaskStatus("QUEUEING", 0);
        QUEUEING = r0;
        TaskStatus r1 = new TaskStatus("PROGRESS", 1);
        PROGRESS = r1;
        TaskStatus r3 = new TaskStatus("COMPLETED", 2);
        COMPLETED = r3;
        TaskStatus[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static TaskStatus[] values() {
        return (TaskStatus[]) a.clone();
    }

    public static TaskStatus valueOf(String r1) {
        return (TaskStatus) a.a(TaskStatus.class, r1);
    }

    public TaskStatus(String r1, int r2) {
        super(r1, r2);
    }
}
