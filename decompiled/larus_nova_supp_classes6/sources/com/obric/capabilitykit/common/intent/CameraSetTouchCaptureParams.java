package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0002\u0010\fJ\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u000eHÖ\u0001J\u0012\u0010\u0013\u001a\u00020\u00012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0011H\u0016J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u000eHÖ\u0001R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u001c"}, d2 = {"Lcom/obric/capabilitykit/common/intent/CameraSetTouchCaptureParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "touchMode", "", "(Ljava/lang/Boolean;)V", "getTouchMode", "()Ljava/lang/Boolean;", "setTouchMode", "Ljava/lang/Boolean;", "component1", "copy", "(Ljava/lang/Boolean;)Lcom/obric/capabilitykit/common/intent/CameraSetTouchCaptureParams;", "describeContents", "", "equals", "other", "", "hashCode", "mergeParams", "params", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class CameraSetTouchCaptureParams implements IntentParams, Parcelable {
    public static final Parcelable.Creator<CameraSetTouchCaptureParams> CREATOR = null;
    private Boolean touchMode;

    static {
        CREATOR = new a();
    }

    public CameraSetTouchCaptureParams() {
        Boolean r0 = null;
        this(r0, 1, r0);
    }

    public static /* synthetic */ CameraSetTouchCaptureParams copy$default(CameraSetTouchCaptureParams r0, Boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.touchMode;
    L6:
        return r0.copy(r1);
    }

    public final Boolean component1() {
        return this.touchMode;
    }

    public final CameraSetTouchCaptureParams copy(Boolean r2) {
        return new CameraSetTouchCaptureParams(r2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof CameraSetTouchCaptureParams) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.touchMode, ((CameraSetTouchCaptureParams) r4).touchMode) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public String getSubActionValue() {
        return null;
    }

    public int hashCode() {
        Boolean r0 = this.touchMode;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public boolean isParamsCompleted() {
        return true;
    }

    public String toString() {
        return "CameraSetTouchCaptureParams(touchMode=" + this.touchMode + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [android.os.Parcel, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v4, types: [int] */
    /* JADX WARN: Type inference failed for: r3v5 */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        ?? r4 = 0;
        r2.writeInt(0);
        Intrinsics.checkNotNullParameter(r2, "out");
        Boolean r0 = this.touchMode;
        if (r0 != null) goto L5;
    L4:
        r2.writeInt(r4);
        return;
    L5:
        r2.writeInt(1);
        r4 = r0.booleanValue();
        goto L4
    }

    public final Boolean getTouchMode() {
        return this.touchMode;
    }

    public CameraSetTouchCaptureParams(Boolean r1) {
        this.touchMode = r1;
    }

    public IntentParams mergeParams(Object r2) {
        if ((r2 instanceof CameraSetTouchCaptureParams) == true) goto L5;
        return this;
    L5:
        Boolean r0 = this.touchMode;
        if (r0 != null) goto L9;
        r0 = ((CameraSetTouchCaptureParams) r2).touchMode;
    L9:
        return new CameraSetTouchCaptureParams(r0);
    }

    public final void setTouchMode(Boolean r1) {
        this.touchMode = r1;
    }

    public /* synthetic */ CameraSetTouchCaptureParams(Boolean r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        this(r1);
    }
}
