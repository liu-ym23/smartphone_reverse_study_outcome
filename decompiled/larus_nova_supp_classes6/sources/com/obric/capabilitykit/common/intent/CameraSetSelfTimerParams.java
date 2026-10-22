package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0002\u0010\fJ\t\u0010\r\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0004HÖ\u0001J\u0012\u0010\u0013\u001a\u00020\u00012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0011H\u0016J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0004HÖ\u0001R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u001c"}, d2 = {"Lcom/obric/capabilitykit/common/intent/CameraSetSelfTimerParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "timer", "", "(Ljava/lang/Integer;)V", "getTimer", "()Ljava/lang/Integer;", "setTimer", "Ljava/lang/Integer;", "component1", "copy", "(Ljava/lang/Integer;)Lcom/obric/capabilitykit/common/intent/CameraSetSelfTimerParams;", "describeContents", "equals", "", "other", "", "hashCode", "mergeParams", "params", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class CameraSetSelfTimerParams implements IntentParams, Parcelable {
    public static final Parcelable.Creator<CameraSetSelfTimerParams> CREATOR = null;
    private Integer timer;

    static {
        CREATOR = new a();
    }

    public CameraSetSelfTimerParams() {
        Integer r0 = null;
        this(r0, 1, r0);
    }

    public static /* synthetic */ CameraSetSelfTimerParams copy$default(CameraSetSelfTimerParams r0, Integer r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.timer;
    L6:
        return r0.copy(r1);
    }

    public final Integer component1() {
        return this.timer;
    }

    public final CameraSetSelfTimerParams copy(Integer r2) {
        return new CameraSetSelfTimerParams(r2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof CameraSetSelfTimerParams) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.timer, ((CameraSetSelfTimerParams) r4).timer) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public String getSubActionValue() {
        return null;
    }

    public int hashCode() {
        Integer r0 = this.timer;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public boolean isParamsCompleted() {
        return true;
    }

    public String toString() {
        return "CameraSetSelfTimerParams(timer=" + this.timer + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        int r4 = 0;
        r2.writeInt(0);
        Intrinsics.checkNotNullParameter(r2, "out");
        Integer r0 = this.timer;
        if (r0 == null) goto L6;
        r2.writeInt(1);
        r4 = r0.intValue();
    L6:
        r2.writeInt(r4);
    }

    public final Integer getTimer() {
        return this.timer;
    }

    public CameraSetSelfTimerParams(Integer r1) {
        this.timer = r1;
    }

    public IntentParams mergeParams(Object r2) {
        if ((r2 instanceof CameraSetSelfTimerParams) == true) goto L5;
        return this;
    L5:
        Integer r0 = this.timer;
        if (r0 != null) goto L9;
        r0 = ((CameraSetSelfTimerParams) r2).timer;
    L9:
        return new CameraSetSelfTimerParams(r0);
    }

    public final void setTimer(Integer r1) {
        this.timer = r1;
    }

    public /* synthetic */ CameraSetSelfTimerParams(Integer r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        this(r1);
    }
}
