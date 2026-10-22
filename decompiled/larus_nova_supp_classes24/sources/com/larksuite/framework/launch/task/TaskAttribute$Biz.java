package com.larksuite.framework.launch.task;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, d2 = {"Lcom/larksuite/framework/launch/task/TaskAttribute$Biz;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "Unknown", "Messenger", "Search", "Calendar", "Docs", "Driver", "Mail", "OpenPlatform", "UserGrowth", "VideoConference", "Moments", "Core", "Todo", "launch-scheduler_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum TaskAttribute$Biz extends Enum<TaskAttribute$Biz> {
    public static final TaskAttribute$Biz Calendar = null;
    public static final TaskAttribute$Biz Core = null;
    public static final TaskAttribute$Biz Docs = null;
    public static final TaskAttribute$Biz Driver = null;
    public static final TaskAttribute$Biz Mail = null;
    public static final TaskAttribute$Biz Messenger = null;
    public static final TaskAttribute$Biz Moments = null;
    public static final TaskAttribute$Biz OpenPlatform = null;
    public static final TaskAttribute$Biz Search = null;
    public static final TaskAttribute$Biz Todo = null;
    public static final TaskAttribute$Biz Unknown = null;
    public static final TaskAttribute$Biz UserGrowth = null;
    public static final TaskAttribute$Biz VideoConference = null;
    public static final /* synthetic */ TaskAttribute$Biz[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static EnumEntries<TaskAttribute$Biz> getEntries() {
        return b;
    }

    static {
        TaskAttribute$Biz r0 = new TaskAttribute$Biz("Unknown", 0, 0);
        Unknown = r0;
        TaskAttribute$Biz r1 = new TaskAttribute$Biz("Messenger", 1, 1);
        Messenger = r1;
        TaskAttribute$Biz r3 = new TaskAttribute$Biz("Search", 2, 2);
        Search = r3;
        TaskAttribute$Biz r5 = new TaskAttribute$Biz("Calendar", 3, 3);
        Calendar = r5;
        TaskAttribute$Biz r7 = new TaskAttribute$Biz("Docs", 4, 4);
        Docs = r7;
        TaskAttribute$Biz r9 = new TaskAttribute$Biz("Driver", 5, 5);
        Driver = r9;
        TaskAttribute$Biz r11 = new TaskAttribute$Biz("Mail", 6, 6);
        Mail = r11;
        TaskAttribute$Biz r13 = new TaskAttribute$Biz("OpenPlatform", 7, 7);
        OpenPlatform = r13;
        TaskAttribute$Biz r15 = new TaskAttribute$Biz("UserGrowth", 8, 8);
        UserGrowth = r15;
        TaskAttribute$Biz r14 = new TaskAttribute$Biz("VideoConference", 9, 9);
        VideoConference = r14;
        TaskAttribute$Biz r12 = new TaskAttribute$Biz("Moments", 10, 10);
        Moments = r12;
        TaskAttribute$Biz r10 = new TaskAttribute$Biz("Core", 11, 11);
        Core = r10;
        TaskAttribute$Biz r8 = new TaskAttribute$Biz("Todo", 12, 12);
        Todo = r8;
        TaskAttribute$Biz[] r6 = {r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8};
        a = r6;
        b = EnumEntriesKt.enumEntries(r6);
    }

    public static TaskAttribute$Biz[] values() {
        return (TaskAttribute$Biz[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static TaskAttribute$Biz valueOf(String r1) {
        return (TaskAttribute$Biz) a.a(TaskAttribute$Biz.class, r1);
    }

    public TaskAttribute$Biz(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
