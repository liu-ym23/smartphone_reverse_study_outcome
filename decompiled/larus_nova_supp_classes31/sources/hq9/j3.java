package hq9;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003JE\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/larus/platform/model/MultiTaskEntranceConfig;", "", "newChatNavEntry", "", "taskCenterSidebarEntry", "hideOngoingTasks", "taskSidebarPinEnabled", "sortWithPinTime", "creationDefaultPinEnabled", "<init>", "(ZZZZZZ)V", "getNewChatNavEntry", "()Z", "getTaskCenterSidebarEntry", "getHideOngoingTasks", "getTaskSidebarPinEnabled", "getSortWithPinTime", "getCreationDefaultPinEnabled", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class j3 {

    @SerializedName("creation_default_pin_enabled")
    private final boolean creationDefaultPinEnabled;

    @SerializedName("hide_ongoing_tasks")
    private final boolean hideOngoingTasks;

    @SerializedName("new_chat_nav_entry")
    private final boolean newChatNavEntry;

    @SerializedName("sort_with_pin_time")
    private final boolean sortWithPinTime;

    @SerializedName("task_center_sidebar_entry")
    private final boolean taskCenterSidebarEntry;

    @SerializedName("task_sidebar_pin_enabled")
    private final boolean taskSidebarPinEnabled;

    public j3() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof j3) == true) goto L8;
        return false;
    L8:
        j3 r6 = (j3) r5;
        if (this.newChatNavEntry == r6.newChatNavEntry) goto L12;
        return false;
    L12:
        if (this.taskCenterSidebarEntry == r6.taskCenterSidebarEntry) goto L15;
        return false;
    L15:
        if (this.hideOngoingTasks == r6.hideOngoingTasks) goto L18;
        return false;
    L18:
        if (this.taskSidebarPinEnabled == r6.taskSidebarPinEnabled) goto L21;
        return false;
    L21:
        if (this.sortWithPinTime == r6.sortWithPinTime) goto L24;
        return false;
    L24:
        if (this.creationDefaultPinEnabled == r6.creationDefaultPinEnabled) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.newChatNavEntry == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        if (this.taskCenterSidebarEntry == false) goto L9;
        int r3 = 1231;
    L10:
        int r4 = (r2 + r3) * 31;
        if (this.hideOngoingTasks == false) goto L13;
        int r5 = 1231;
    L14:
        int r6 = (r4 + r5) * 31;
        if (this.taskSidebarPinEnabled == false) goto L17;
        int r7 = 1231;
    L18:
        int r8 = (r6 + r7) * 31;
        if (this.sortWithPinTime == false) goto L21;
        int r9 = 1231;
    L22:
        int r10 = (r8 + r9) * 31;
        if (this.creationDefaultPinEnabled == true) goto L27;
        r1 = 1237;
    L27:
        return r10 + r1;
    L21:
        r9 = 1237;
        goto L22
    L17:
        r7 = 1237;
        goto L18
    L13:
        r5 = 1237;
        goto L14
    L9:
        r3 = 1237;
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "MultiTaskEntranceConfig(newChatNavEntry=" + this.newChatNavEntry + ", taskCenterSidebarEntry=" + this.taskCenterSidebarEntry + ", hideOngoingTasks=" + this.hideOngoingTasks + ", taskSidebarPinEnabled=" + this.taskSidebarPinEnabled + ", sortWithPinTime=" + this.sortWithPinTime + ", creationDefaultPinEnabled=" + this.creationDefaultPinEnabled + ')';
    }

    public final boolean a() {
        return this.hideOngoingTasks;
    }

    public final boolean b() {
        return this.newChatNavEntry;
    }

    public final boolean c() {
        return this.sortWithPinTime;
    }

    public final boolean d() {
        return this.taskCenterSidebarEntry;
    }

    public final boolean e() {
        return this.taskSidebarPinEnabled;
    }

    public /* synthetic */ j3(int r8) {
        this(false, false, false, false, false, false);
    }

    public j3(boolean r1, boolean r2, boolean r3, boolean r4, boolean r5, boolean r6) {
        this.newChatNavEntry = r1;
        this.taskCenterSidebarEntry = r2;
        this.hideOngoingTasks = r3;
        this.taskSidebarPinEnabled = r4;
        this.sortWithPinTime = r5;
        this.creationDefaultPinEnabled = r6;
    }
}
