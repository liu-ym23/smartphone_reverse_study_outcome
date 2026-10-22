package com.obric.capabilitykit.common;

import com.obric.eventkit.eventstaskmanager.ITaskManager;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/obric/capabilitykit/common/TaskState;", "", "(Ljava/lang/String;I)V", "Clarify", "CallUser", "UserOperationBegin", "UserOperationEnd", "Stop", "Addition", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final enum TaskState extends Enum<TaskState> {
    private static final /* synthetic */ TaskState[] $VALUES = null;
    public static final TaskState Addition = null;
    public static final TaskState CallUser = null;
    public static final TaskState Clarify = null;
    public static final TaskState Stop = null;
    public static final TaskState UserOperationBegin = null;
    public static final TaskState UserOperationEnd = null;

    private static final /* synthetic */ TaskState[] $values() {
        return new TaskState[]{Clarify, CallUser, UserOperationBegin, UserOperationEnd, Stop, Addition};
    }

    static {
        Clarify = new TaskState("Clarify", 0);
        CallUser = new TaskState("CallUser", 1);
        UserOperationBegin = new TaskState("UserOperationBegin", 2);
        UserOperationEnd = new TaskState("UserOperationEnd", 3);
        Stop = new TaskState("Stop", 4);
        Addition = new TaskState("Addition", 5);
        $VALUES = $values();
    }

    private TaskState(String r1, int r2) {
        super(r1, r2);
    }

    public static TaskState valueOf(String r1) {
        return (TaskState) a.a(TaskState.class, r1);
    }

    public static TaskState[] values() {
        return (TaskState[]) $VALUES.clone();
    }
}
