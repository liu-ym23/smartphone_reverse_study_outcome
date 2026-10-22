package com.larus.commercecredit.impl.entity;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/commercecredit/impl/entity/TaskType;", "", "type", "", "<init>", "(Ljava/lang/String;II)V", "getType", "()I", "TASK_TYPE_MOBILE_ACTIVITY", "TASK_TYPE_PC_ACTIVITY", "TASK_TYPE_FISSION_CAMPAIGN", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TaskType extends Enum<TaskType> {
    public static final TaskType TASK_TYPE_FISSION_CAMPAIGN = null;
    public static final TaskType TASK_TYPE_MOBILE_ACTIVITY = null;
    public static final TaskType TASK_TYPE_PC_ACTIVITY = null;
    public static final /* synthetic */ TaskType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int type;

    public static EnumEntries<TaskType> getEntries() {
        return b;
    }

    static {
        TaskType r0 = new TaskType("TASK_TYPE_MOBILE_ACTIVITY", 0, 1);
        TASK_TYPE_MOBILE_ACTIVITY = r0;
        TaskType r1 = new TaskType("TASK_TYPE_PC_ACTIVITY", 1, 2);
        TASK_TYPE_PC_ACTIVITY = r1;
        TaskType r4 = new TaskType("TASK_TYPE_FISSION_CAMPAIGN", 2, 3);
        TASK_TYPE_FISSION_CAMPAIGN = r4;
        TaskType[] r6 = {r0, r1, r4};
        a = r6;
        b = EnumEntriesKt.enumEntries(r6);
    }

    public static TaskType[] values() {
        return (TaskType[]) a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public static TaskType valueOf(String r1) {
        return (TaskType) a.a(TaskType.class, r1);
    }

    public TaskType(String r1, int r2, int r3) {
        super(r1, r2);
        this.type = r3;
    }
}
