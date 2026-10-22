package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\tJ&\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0014J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0013\u0010\u0017\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0016HÖ\u0001J\u0012\u0010\u001b\u001a\u00020\u00012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0019H\u0016J\t\u0010\u001d\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0016HÖ\u0001R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006#"}, d2 = {"Lcom/obric/capabilitykit/common/intent/SystemSwitchNotificationParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "targetAppName", "", "enable", "", "(Ljava/lang/String;Ljava/lang/Boolean;)V", "getEnable", "()Ljava/lang/Boolean;", "setEnable", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getTargetAppName", "()Ljava/lang/String;", "setTargetAppName", "(Ljava/lang/String;)V", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;)Lcom/obric/capabilitykit/common/intent/SystemSwitchNotificationParams;", "describeContents", "", "equals", "other", "", "hashCode", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class SystemSwitchNotificationParams implements IntentParams, Parcelable {
    public static final Parcelable.Creator<SystemSwitchNotificationParams> CREATOR = null;
    private Boolean enable;
    private String targetAppName;

    static {
        CREATOR = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SystemSwitchNotificationParams() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ SystemSwitchNotificationParams copy$default(SystemSwitchNotificationParams r0, String r1, Boolean r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.targetAppName;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.enable;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.targetAppName;
    }

    public final Boolean component2() {
        return this.enable;
    }

    public final SystemSwitchNotificationParams copy(String r2, Boolean r3) {
        return new SystemSwitchNotificationParams(r2, r3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof SystemSwitchNotificationParams) == true) goto L8;
        return false;
    L8:
        SystemSwitchNotificationParams r6 = (SystemSwitchNotificationParams) r5;
        if (Intrinsics.areEqual(this.targetAppName, r6.targetAppName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.enable, r6.enable) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public String getSubActionValue() {
        return null;
    }

    public int hashCode() {
        String r0 = this.targetAppName;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Boolean r4 = this.enable;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public boolean isParamsCompleted() {
        return true;
    }

    public String toString() {
        return "SystemSwitchNotificationParams(targetAppName=" + this.targetAppName + ", enable=" + this.enable + ')';
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
        r2.writeString(this.targetAppName);
        Boolean r0 = this.enable;
        if (r0 != null) goto L5;
    L4:
        r2.writeInt(r4);
        return;
    L5:
        r2.writeInt(1);
        r4 = r0.booleanValue();
        goto L4
    }

    public final Boolean getEnable() {
        return this.enable;
    }

    public final String getTargetAppName() {
        return this.targetAppName;
    }

    public IntentParams mergeParams(Object r3) {
        if ((r3 instanceof SystemSwitchNotificationParams) == true) goto L5;
        return this;
    L5:
        String r0 = this.targetAppName;
        if (r0 != null) goto L8;
        r0 = ((SystemSwitchNotificationParams) r3).targetAppName;
    L8:
        Boolean r1 = this.enable;
        if (r1 != null) goto L12;
        r1 = ((SystemSwitchNotificationParams) r3).enable;
    L12:
        return new SystemSwitchNotificationParams(r0, r1);
    }

    public final void setEnable(Boolean r1) {
        this.enable = r1;
    }

    public final void setTargetAppName(String r1) {
        this.targetAppName = r1;
    }

    public SystemSwitchNotificationParams(String r1, Boolean r2) {
        this.targetAppName = r1;
        this.enable = r2;
    }

    public /* synthetic */ SystemSwitchNotificationParams(String r2, Boolean r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }
}
