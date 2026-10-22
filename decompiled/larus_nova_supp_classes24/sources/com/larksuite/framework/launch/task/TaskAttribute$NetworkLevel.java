package com.larksuite.framework.launch.task;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/larksuite/framework/launch/task/TaskAttribute$NetworkLevel;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "EXCELLENT", "EVALUATING", "WEAK", "NET_UNAVAILABLE", "SERVICE_UNAVAILABLE", "launch-scheduler_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum TaskAttribute$NetworkLevel extends Enum<TaskAttribute$NetworkLevel> {
    public static final TaskAttribute$NetworkLevel EVALUATING = null;
    public static final TaskAttribute$NetworkLevel EXCELLENT = null;
    public static final TaskAttribute$NetworkLevel NET_UNAVAILABLE = null;
    public static final TaskAttribute$NetworkLevel SERVICE_UNAVAILABLE = null;
    public static final TaskAttribute$NetworkLevel WEAK = null;
    public static final /* synthetic */ TaskAttribute$NetworkLevel[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static EnumEntries<TaskAttribute$NetworkLevel> getEntries() {
        return b;
    }

    static {
        TaskAttribute$NetworkLevel r0 = new TaskAttribute$NetworkLevel("EXCELLENT", 0, 1);
        EXCELLENT = r0;
        TaskAttribute$NetworkLevel r1 = new TaskAttribute$NetworkLevel("EVALUATING", 1, 2);
        EVALUATING = r1;
        TaskAttribute$NetworkLevel r4 = new TaskAttribute$NetworkLevel("WEAK", 2, 3);
        WEAK = r4;
        TaskAttribute$NetworkLevel r6 = new TaskAttribute$NetworkLevel("NET_UNAVAILABLE", 3, 4);
        NET_UNAVAILABLE = r6;
        TaskAttribute$NetworkLevel r8 = new TaskAttribute$NetworkLevel("SERVICE_UNAVAILABLE", 4, 5);
        SERVICE_UNAVAILABLE = r8;
        TaskAttribute$NetworkLevel[] r10 = {r0, r1, r4, r6, r8};
        a = r10;
        b = EnumEntriesKt.enumEntries(r10);
    }

    public static TaskAttribute$NetworkLevel[] values() {
        return (TaskAttribute$NetworkLevel[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static TaskAttribute$NetworkLevel valueOf(String r1) {
        return (TaskAttribute$NetworkLevel) a.a(TaskAttribute$NetworkLevel.class, r1);
    }

    public TaskAttribute$NetworkLevel(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
