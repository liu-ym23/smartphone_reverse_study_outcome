package com.bytedance.android.anniex.scene.handler.idle;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/anniex/scene/handler/idle/TaskType;", "", "NEXT_THRESHOLD_PREDICT", "HOT_USAGE_PRE_DECODE", "CLEAR_NOT_HOT_USAGE_CACHE", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum TaskType extends Enum<TaskType> {
    public static final TaskType CLEAR_NOT_HOT_USAGE_CACHE = null;
    public static final TaskType HOT_USAGE_PRE_DECODE = null;
    public static final TaskType NEXT_THRESHOLD_PREDICT = null;
    public static final /* synthetic */ TaskType[] a = null;

    public static TaskType valueOf(String r1) {
        return (TaskType) r27.a.a(TaskType.class, r1);
    }

    public static TaskType[] values() {
        return (TaskType[]) a.clone();
    }

    static {
        TaskType r0 = new TaskType("NEXT_THRESHOLD_PREDICT", 0);
        NEXT_THRESHOLD_PREDICT = r0;
        TaskType r1 = new TaskType("HOT_USAGE_PRE_DECODE", 1);
        HOT_USAGE_PRE_DECODE = r1;
        TaskType r10 = new TaskType("CLEAR_NOT_HOT_USAGE_CACHE", 2);
        CLEAR_NOT_HOT_USAGE_CACHE = r10;
        a = new TaskType[]{r0, r1, r10};
    }

    public TaskType(String r1, int r10) {
        super(r1, r10);
    }
}
