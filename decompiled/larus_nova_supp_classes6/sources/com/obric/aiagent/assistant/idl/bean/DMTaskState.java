package com.obric.aiagent.assistant.idl.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\u0017\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\tHÆ\u0003JA\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\tHÆ\u0001J\u0006\u0010\u0019\u001a\u00020\u0007J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\u0016\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001f\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006%"}, d2 = {"Lcom/obric/aiagent/assistant/idl/bean/DMTaskState;", "Landroid/os/Parcelable;", "taskId", "", "taskInfo", "Lcom/obric/aiagent/assistant/idl/bean/DMTaskInfo;", "state", "", "extra", "", "<init>", "(Ljava/lang/String;Lcom/obric/aiagent/assistant/idl/bean/DMTaskInfo;ILjava/util/Map;)V", "getTaskId", "()Ljava/lang/String;", "getTaskInfo", "()Lcom/obric/aiagent/assistant/idl/bean/DMTaskInfo;", "getState", "()I", "getExtra", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class DMTaskState implements Parcelable {
    public static final Parcelable.Creator<DMTaskState> CREATOR = null;
    private final Map<String, String> extra;
    private final int state;
    private final String taskId;
    private final DMTaskInfo taskInfo;

    static {
        CREATOR = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DMTaskState copy$default(DMTaskState r0, String r1, DMTaskInfo r2, int r3, Map r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.taskId;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.taskInfo;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.state;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.extra;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.taskId;
    }

    public final DMTaskInfo component2() {
        return this.taskInfo;
    }

    public final int component3() {
        return this.state;
    }

    public final Map<String, String> component4() {
        return this.extra;
    }

    public final DMTaskState copy(String r2, DMTaskInfo r3, int r4, Map<String, String> r5) {
        Intrinsics.checkNotNullParameter(r2, "taskId");
        Intrinsics.checkNotNullParameter(r5, "extra");
        return new DMTaskState(r2, r3, r4, r5);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof DMTaskState) == true) goto L8;
        return false;
    L8:
        DMTaskState r6 = (DMTaskState) r5;
        if (Intrinsics.areEqual(this.taskId, r6.taskId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.taskInfo, r6.taskInfo) == true) goto L15;
        return false;
    L15:
        if (this.state == r6.state) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.extra, r6.extra) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r0 = this.taskId.hashCode() * 31;
        DMTaskInfo r1 = this.taskInfo;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((((r0 + r2) * 31) + this.state) * 31) + this.extra.hashCode();
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "DMTaskState(taskId=" + this.taskId + ", taskInfo=" + this.taskInfo + ", state=" + this.state + ", extra=" + this.extra + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "dest");
        r3.writeString(this.taskId);
        DMTaskInfo r0 = this.taskInfo;
        if (r0 != null) goto L5;
        r3.writeInt(0);
    L6:
        r3.writeInt(this.state);
        Map<String, String> r5 = this.extra;
        r3.writeInt(r5.size());
        Iterator<Map.Entry<String, String>> r6 = r5.entrySet().iterator();
    L8:
        if (r6.hasNext() == false) goto L10;
        Map.Entry<String, String> r1 = r6.next();
        r3.writeString(r1.getKey());
        r3.writeString(r1.getValue());
        goto L8
    L10:
        return;
    L5:
        r3.writeInt(1);
        r0.writeToParcel(r3, r4);
        goto L6
    }

    public final Map<String, String> getExtra() {
        return this.extra;
    }

    public final int getState() {
        return this.state;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final DMTaskInfo getTaskInfo() {
        return this.taskInfo;
    }

    public DMTaskState(String r2, DMTaskInfo r3, int r4, Map<String, String> r5) {
        Intrinsics.checkNotNullParameter(r2, "taskId");
        Intrinsics.checkNotNullParameter(r5, "extra");
        this.taskId = r2;
        this.taskInfo = r3;
        this.state = r4;
        this.extra = r5;
    }

    public /* synthetic */ DMTaskState(String r1, DMTaskInfo r2, int r3, Map r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 8) == 0) goto L8;
        r4 = MapsKt.emptyMap();
    L8:
        this(r1, r2, r3, r4);
    }
}
