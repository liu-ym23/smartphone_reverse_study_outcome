package com.larksuite.framework.launch.task;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/larksuite/framework/launch/task/TaskAttribute$BoostStage;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "FIRST_DATA_LOADED", "FIRST_FRAME_SHOWED", "FIRST_CONTENT_SHOWED_LOGIN", "FIRST_CONTENT_SHOWED_UN_LOGIN", "FIRST_CONTENT_SHOWED_BACKGROUND_LOGIN", "FIRST_CONTENT_SHOWED_BACKGROUND_UN_LOGIN", "launch-scheduler_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum TaskAttribute$BoostStage extends Enum<TaskAttribute$BoostStage> {
    public static final TaskAttribute$BoostStage FIRST_CONTENT_SHOWED_BACKGROUND_LOGIN = null;
    public static final TaskAttribute$BoostStage FIRST_CONTENT_SHOWED_BACKGROUND_UN_LOGIN = null;
    public static final TaskAttribute$BoostStage FIRST_CONTENT_SHOWED_LOGIN = null;
    public static final TaskAttribute$BoostStage FIRST_CONTENT_SHOWED_UN_LOGIN = null;
    public static final TaskAttribute$BoostStage FIRST_DATA_LOADED = null;
    public static final TaskAttribute$BoostStage FIRST_FRAME_SHOWED = null;
    public static final TaskAttribute$BoostStage UNKNOWN = null;
    public static final /* synthetic */ TaskAttribute$BoostStage[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static EnumEntries<TaskAttribute$BoostStage> getEntries() {
        return b;
    }

    static {
        TaskAttribute$BoostStage r0 = new TaskAttribute$BoostStage("UNKNOWN", 0, 0);
        UNKNOWN = r0;
        TaskAttribute$BoostStage r1 = new TaskAttribute$BoostStage("FIRST_DATA_LOADED", 1, 1);
        FIRST_DATA_LOADED = r1;
        TaskAttribute$BoostStage r3 = new TaskAttribute$BoostStage("FIRST_FRAME_SHOWED", 2, 2);
        FIRST_FRAME_SHOWED = r3;
        TaskAttribute$BoostStage r5 = new TaskAttribute$BoostStage("FIRST_CONTENT_SHOWED_LOGIN", 3, 3);
        FIRST_CONTENT_SHOWED_LOGIN = r5;
        TaskAttribute$BoostStage r7 = new TaskAttribute$BoostStage("FIRST_CONTENT_SHOWED_UN_LOGIN", 4, 4);
        FIRST_CONTENT_SHOWED_UN_LOGIN = r7;
        TaskAttribute$BoostStage r9 = new TaskAttribute$BoostStage("FIRST_CONTENT_SHOWED_BACKGROUND_LOGIN", 5, 5);
        FIRST_CONTENT_SHOWED_BACKGROUND_LOGIN = r9;
        TaskAttribute$BoostStage r11 = new TaskAttribute$BoostStage("FIRST_CONTENT_SHOWED_BACKGROUND_UN_LOGIN", 6, 6);
        FIRST_CONTENT_SHOWED_BACKGROUND_UN_LOGIN = r11;
        TaskAttribute$BoostStage[] r13 = {r0, r1, r3, r5, r7, r9, r11};
        a = r13;
        b = EnumEntriesKt.enumEntries(r13);
    }

    public static TaskAttribute$BoostStage[] values() {
        return (TaskAttribute$BoostStage[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static TaskAttribute$BoostStage valueOf(String r1) {
        return (TaskAttribute$BoostStage) a.a(TaskAttribute$BoostStage.class, r1);
    }

    public TaskAttribute$BoostStage(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
