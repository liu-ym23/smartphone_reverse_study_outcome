package com.obric.eventkit.eventstaskmanager;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/eventkit/eventstaskmanager/TimerTaskTableEnum;", "", "()V", "CONDITION_TASK", "", "CONDITION_TASK_RECORD", "SHORTCUT_TASK", "SHORTCUT_TASK_RECORD", "TASK_EXECUTION_DETAIL_RECORD", "TASK_EXECUTION_RECORD", "TIMER_TASK", "TIMER_TASK_RECORD", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TimerTaskTableEnum {
    public static final int CONDITION_TASK = 3;
    public static final int CONDITION_TASK_RECORD = 4;
    public static final TimerTaskTableEnum INSTANCE = null;
    public static final int SHORTCUT_TASK = 5;
    public static final int SHORTCUT_TASK_RECORD = 6;
    public static final int TASK_EXECUTION_DETAIL_RECORD = 8;
    public static final int TASK_EXECUTION_RECORD = 7;
    public static final int TIMER_TASK = 1;
    public static final int TIMER_TASK_RECORD = 2;

    static {
        INSTANCE = new TimerTaskTableEnum();
    }

    private TimerTaskTableEnum() {
    }
}
