package com.ss.android.lark.passportc.task;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/passportc/task/TaskType;", "", "<init>", "(Ljava/lang/String;I)V", "OFFLINE", "ONLINE", "passport-container-manager_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum TaskType extends Enum<TaskType> {
    public static final TaskType OFFLINE = null;
    public static final TaskType ONLINE = null;
    public static final /* synthetic */ TaskType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<TaskType> getEntries() {
        return b;
    }

    static {
        TaskType r0 = new TaskType("OFFLINE", 0);
        OFFLINE = r0;
        TaskType r1 = new TaskType("ONLINE", 1);
        ONLINE = r1;
        TaskType[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static TaskType[] values() {
        return (TaskType[]) a.clone();
    }

    public static TaskType valueOf(String r1) {
        return (TaskType) r27.a.a(TaskType.class, r1);
    }

    public TaskType(String r1, int r2) {
        super(r1, r2);
    }
}
