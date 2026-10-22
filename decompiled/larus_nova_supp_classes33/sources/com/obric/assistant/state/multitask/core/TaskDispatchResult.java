package com.obric.assistant.state.multitask.core;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u000b\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\rj\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000e"}, d2 = {"Lcom/obric/assistant/state/multitask/core/TaskDispatchResult;", "", "<init>", "(Ljava/lang/String;I)V", "ACCEPTED", "CONSUMED", "INTERCEPTED", "DROPPED", "STALE", "CLOSED", "FAILED", "isSuccess", "", "()Z", "multitask_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TaskDispatchResult extends Enum<TaskDispatchResult> {
    public static final TaskDispatchResult ACCEPTED = null;
    public static final TaskDispatchResult CLOSED = null;
    public static final TaskDispatchResult CONSUMED = null;
    public static final TaskDispatchResult DROPPED = null;
    public static final TaskDispatchResult FAILED = null;
    public static final TaskDispatchResult INTERCEPTED = null;
    public static final TaskDispatchResult STALE = null;
    public static final /* synthetic */ TaskDispatchResult[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<TaskDispatchResult> getEntries() {
        return b;
    }

    static {
        TaskDispatchResult r0 = new TaskDispatchResult("ACCEPTED", 0);
        ACCEPTED = r0;
        TaskDispatchResult r1 = new TaskDispatchResult("CONSUMED", 1);
        CONSUMED = r1;
        TaskDispatchResult r3 = new TaskDispatchResult("INTERCEPTED", 2);
        INTERCEPTED = r3;
        TaskDispatchResult r5 = new TaskDispatchResult("DROPPED", 3);
        DROPPED = r5;
        TaskDispatchResult r7 = new TaskDispatchResult("STALE", 4);
        STALE = r7;
        TaskDispatchResult r9 = new TaskDispatchResult("CLOSED", 5);
        CLOSED = r9;
        TaskDispatchResult r11 = new TaskDispatchResult("FAILED", 6);
        FAILED = r11;
        TaskDispatchResult[] r13 = {r0, r1, r3, r5, r7, r9, r11};
        a = r13;
        b = EnumEntriesKt.enumEntries(r13);
    }

    public static TaskDispatchResult[] values() {
        return (TaskDispatchResult[]) a.clone();
    }

    public final boolean isSuccess() {
        if (this != ACCEPTED) goto L5;
    L8:
        return true;
    L5:
        if (this == CONSUMED) goto L8;
        return false;
    }

    public static TaskDispatchResult valueOf(String r1) {
        return (TaskDispatchResult) a.a(TaskDispatchResult.class, r1);
    }

    public TaskDispatchResult(String r1, int r2) {
        super(r1, r2);
    }
}
