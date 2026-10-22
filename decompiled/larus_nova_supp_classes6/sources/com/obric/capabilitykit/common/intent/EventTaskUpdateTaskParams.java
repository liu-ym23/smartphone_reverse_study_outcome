package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0015\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\fHÖ\u0001J\u0012\u0010\u0012\u001a\u00020\u00012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0010H\u0016J\t\u0010\u0014\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\fHÖ\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u001a"}, d2 = {"Lcom/obric/capabilitykit/common/intent/EventTaskUpdateTaskParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "taskParams", "", "(Ljava/lang/String;)V", "getTaskParams", "()Ljava/lang/String;", "setTaskParams", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class EventTaskUpdateTaskParams implements IntentParams, Parcelable {
    public static final Parcelable.Creator<EventTaskUpdateTaskParams> CREATOR = null;
    private String taskParams;

    static {
        CREATOR = new a();
    }

    public EventTaskUpdateTaskParams() {
        String r0 = null;
        this(r0, 1, r0);
    }

    public static /* synthetic */ EventTaskUpdateTaskParams copy$default(EventTaskUpdateTaskParams r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.taskParams;
    L6:
        return r0.copy(r1);
    }

    public final String component1() {
        return this.taskParams;
    }

    public final EventTaskUpdateTaskParams copy(String r2) {
        return new EventTaskUpdateTaskParams(r2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof EventTaskUpdateTaskParams) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.taskParams, ((EventTaskUpdateTaskParams) r4).taskParams) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public String getSubActionValue() {
        return null;
    }

    public int hashCode() {
        String r0 = this.taskParams;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public boolean isParamsCompleted() {
        return true;
    }

    public String toString() {
        return "EventTaskUpdateTaskParams(taskParams=" + this.taskParams + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(0);
        Intrinsics.checkNotNullParameter(r1, "out");
        r1.writeString(this.taskParams);
    }

    public final String getTaskParams() {
        return this.taskParams;
    }

    public EventTaskUpdateTaskParams(String r1) {
        this.taskParams = r1;
    }

    public IntentParams mergeParams(Object r2) {
        if ((r2 instanceof EventTaskUpdateTaskParams) == true) goto L5;
        return this;
    L5:
        String r0 = this.taskParams;
        if (r0 != null) goto L9;
        r0 = ((EventTaskUpdateTaskParams) r2).taskParams;
    L9:
        return new EventTaskUpdateTaskParams(r0);
    }

    public final void setTaskParams(String r1) {
        this.taskParams = r1;
    }

    public /* synthetic */ EventTaskUpdateTaskParams(String r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        this(r1);
    }
}
