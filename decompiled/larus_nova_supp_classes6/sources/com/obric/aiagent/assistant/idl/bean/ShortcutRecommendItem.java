package com.obric.aiagent.assistant.idl.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0019\u001a\u00020\tHÆ\u0003J=\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0006\u0010\u001b\u001a\u00020\u001cJ\u0013\u0010\u001d\u001a\u00020\u00072\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u001cHÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001cR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0010R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\r¨\u0006'"}, d2 = {"Lcom/obric/aiagent/assistant/idl/bean/ShortcutRecommendItem;", "Landroid/os/Parcelable;", "taskId", "", "originQuery", "shortQuery", "isShortInstructEnable", "", "createTime", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZJ)V", "getTaskId", "()Ljava/lang/String;", "getOriginQuery", "getShortQuery", "()Z", "getCreateTime", "()J", "displayText", "getDisplayText", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class ShortcutRecommendItem implements Parcelable {
    public static final Parcelable.Creator<ShortcutRecommendItem> CREATOR = null;
    private final long createTime;
    private final boolean isShortInstructEnable;
    private final String originQuery;
    private final String shortQuery;
    private final String taskId;

    static {
        CREATOR = new a();
    }

    public static /* synthetic */ ShortcutRecommendItem copy$default(ShortcutRecommendItem r4, String r5, String r6, String r7, boolean r8, long r9, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.taskId;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.originQuery;
    L8:
        String r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.shortQuery;
    L11:
        String r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.isShortInstructEnable;
    L14:
        boolean r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.createTime;
    L17:
        String r10 = r5;
        return r4.copy(r10, r13, r0, r1, r9);
    }

    public final String component1() {
        return this.taskId;
    }

    public final String component2() {
        return this.originQuery;
    }

    public final String component3() {
        return this.shortQuery;
    }

    public final boolean component4() {
        return this.isShortInstructEnable;
    }

    public final long component5() {
        return this.createTime;
    }

    public final ShortcutRecommendItem copy(String r9, String r10, String r11, boolean r12, long r13) {
        Intrinsics.checkNotNullParameter(r9, "taskId");
        Intrinsics.checkNotNullParameter(r10, "originQuery");
        return new ShortcutRecommendItem(r9, r10, r11, r12, r13);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof ShortcutRecommendItem) == true) goto L8;
        return false;
    L8:
        ShortcutRecommendItem r9 = (ShortcutRecommendItem) r8;
        if (Intrinsics.areEqual(this.taskId, r9.taskId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.originQuery, r9.originQuery) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.shortQuery, r9.shortQuery) == true) goto L18;
        return false;
    L18:
        if (this.isShortInstructEnable == r9.isShortInstructEnable) goto L21;
        return false;
    L21:
        if (this.createTime == r9.createTime) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.taskId.hashCode() * 31) + this.originQuery.hashCode()) * 31;
        String r1 = this.shortQuery;
        if (r1 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = (r0 + r2) * 31;
        if (this.isShortInstructEnable == false) goto L9;
        int r4 = 1231;
    L10:
        int r5 = (r3 + r4) * 31;
        long r6 = this.createTime;
        return r5 + ((int) (r6 ^ (r6 >>> 32)));
    L9:
        r4 = 1237;
        goto L10
    L5:
        r2 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "ShortcutRecommendItem(taskId=" + this.taskId + ", originQuery=" + this.originQuery + ", shortQuery=" + this.shortQuery + ", isShortInstructEnable=" + this.isShortInstructEnable + ", createTime=" + this.createTime + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "dest");
        r3.writeString(this.taskId);
        r3.writeString(this.originQuery);
        r3.writeString(this.shortQuery);
        r3.writeInt(this.isShortInstructEnable ? 1 : 0);
        r3.writeLong(this.createTime);
    }

    public final String getDisplayText() {
        String r0 = this.shortQuery;
        String r1 = null;
        if (r0 != null) goto L5;
    L7:
        r0 = null;
    L8:
        String r2 = this.originQuery;
        if ((!StringsKt.isBlank(r2)) == false) goto L12;
        r1 = r2;
    L12:
        if (this.isShortInstructEnable == false) goto L16;
        if (r0 != null) goto L21;
        if (r1 == null) goto L23;
    L20:
        return r1;
    L23:
        return "";
    L21:
        return r0;
    L16:
        if (r1 != null) goto L20;
        if (r0 == null) goto L23;
        return r0;
    L5:
        if ((!StringsKt.isBlank(r0)) == false) goto L7;
        goto L7
    }

    public final long getCreateTime() {
        return this.createTime;
    }

    public final String getOriginQuery() {
        return this.originQuery;
    }

    public final String getShortQuery() {
        return this.shortQuery;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final boolean isShortInstructEnable() {
        return this.isShortInstructEnable;
    }

    public ShortcutRecommendItem(String r2, String r3, String r4, boolean r5, long r6) {
        Intrinsics.checkNotNullParameter(r2, "taskId");
        Intrinsics.checkNotNullParameter(r3, "originQuery");
        this.taskId = r2;
        this.originQuery = r3;
        this.shortQuery = r4;
        this.isShortInstructEnable = r5;
        this.createTime = r6;
    }
}
