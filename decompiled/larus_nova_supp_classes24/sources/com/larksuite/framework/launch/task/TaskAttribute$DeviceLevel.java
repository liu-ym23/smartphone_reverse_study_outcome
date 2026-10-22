package com.larksuite.framework.launch.task;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/larksuite/framework/launch/task/TaskAttribute$DeviceLevel;", "", "title", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;I)V", "getTitle", "()Ljava/lang/String;", "getValue", "()I", "UNKNOWN", "HIGH", "MIDDLE", "LOW", "ULTRALOW", "launch-scheduler_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum TaskAttribute$DeviceLevel extends Enum<TaskAttribute$DeviceLevel> {
    public static final TaskAttribute$DeviceLevel HIGH = null;
    public static final TaskAttribute$DeviceLevel LOW = null;
    public static final TaskAttribute$DeviceLevel MIDDLE = null;
    public static final TaskAttribute$DeviceLevel ULTRALOW = null;
    public static final TaskAttribute$DeviceLevel UNKNOWN = null;
    public static final /* synthetic */ TaskAttribute$DeviceLevel[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String title;
    private final int value;

    public static EnumEntries<TaskAttribute$DeviceLevel> getEntries() {
        return b;
    }

    static {
        TaskAttribute$DeviceLevel r0 = new TaskAttribute$DeviceLevel("UNKNOWN", 0, "unknown", 0);
        UNKNOWN = r0;
        TaskAttribute$DeviceLevel r1 = new TaskAttribute$DeviceLevel("HIGH", 1, "high", 4);
        HIGH = r1;
        TaskAttribute$DeviceLevel r2 = new TaskAttribute$DeviceLevel("MIDDLE", 2, "middle", 3);
        MIDDLE = r2;
        TaskAttribute$DeviceLevel r5 = new TaskAttribute$DeviceLevel("LOW", 3, "low", 2);
        LOW = r5;
        TaskAttribute$DeviceLevel r8 = new TaskAttribute$DeviceLevel("ULTRALOW", 4, "ultralow", 1);
        ULTRALOW = r8;
        TaskAttribute$DeviceLevel[] r10 = {r0, r1, r2, r5, r8};
        a = r10;
        b = EnumEntriesKt.enumEntries(r10);
    }

    public static TaskAttribute$DeviceLevel[] values() {
        return (TaskAttribute$DeviceLevel[]) a.clone();
    }

    public final String getTitle() {
        return this.title;
    }

    public final int getValue() {
        return this.value;
    }

    public static TaskAttribute$DeviceLevel valueOf(String r1) {
        return (TaskAttribute$DeviceLevel) a.a(TaskAttribute$DeviceLevel.class, r1);
    }

    public TaskAttribute$DeviceLevel(String r1, int r2, String r3, int r4) {
        super(r1, r2);
        this.title = r3;
        this.value = r4;
    }
}
