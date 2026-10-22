package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004¢\u0006\u0002\u0010\u0006J\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\bJ \u0010\f\u001a\u00020\u00002\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0001¢\u0006\u0002\u0010\rJ\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u000fHÖ\u0001J\u0012\u0010\u0015\u001a\u00020\u00012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0013H\u0016J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\u0019\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u000fHÖ\u0001R$\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006¨\u0006\u001e"}, d2 = {"Lcom/obric/capabilitykit/common/intent/SystemUpdatePermissionsParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "permissions", "", "Lcom/obric/capabilitykit/common/intent/Permission;", "([Lcom/obric/capabilitykit/common/intent/Permission;)V", "getPermissions", "()[Lcom/obric/capabilitykit/common/intent/Permission;", "setPermissions", "[Lcom/obric/capabilitykit/common/intent/Permission;", "component1", "copy", "([Lcom/obric/capabilitykit/common/intent/Permission;)Lcom/obric/capabilitykit/common/intent/SystemUpdatePermissionsParams;", "describeContents", "", "equals", "", "other", "", "hashCode", "mergeParams", "params", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class SystemUpdatePermissionsParams implements IntentParams, Parcelable {
    public static final Parcelable.Creator<SystemUpdatePermissionsParams> CREATOR = null;
    private Permission[] permissions;

    static {
        CREATOR = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SystemUpdatePermissionsParams() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ SystemUpdatePermissionsParams copy$default(SystemUpdatePermissionsParams r0, Permission[] r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.permissions;
    L6:
        return r0.copy(r1);
    }

    public final Permission[] component1() {
        return this.permissions;
    }

    public final SystemUpdatePermissionsParams copy(Permission[] r2) {
        return new SystemUpdatePermissionsParams(r2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof SystemUpdatePermissionsParams) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.permissions, ((SystemUpdatePermissionsParams) r4).permissions) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public String getSubActionValue() {
        return null;
    }

    public int hashCode() {
        Permission[] r0 = this.permissions;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return Arrays.hashCode(r0);
    }

    public boolean isParamsCompleted() {
        return true;
    }

    public String toString() {
        return "SystemUpdatePermissionsParams(permissions=" + Arrays.toString(this.permissions) + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r5, int r6) {
        int r0 = 0;
        r5.writeInt(0);
        Intrinsics.checkNotNullParameter(r5, "out");
        Permission[] r1 = this.permissions;
        if (r1 != null) goto L5;
        r5.writeInt(0);
        return;
    L5:
        r5.writeInt(1);
        int r2 = r1.length;
        r5.writeInt(r2);
    L6:
        if (r0 == r2) goto L10;
        r1[r0].writeToParcel(r5, r6);
        r0 = r0 + 1;
        goto L6
    }

    public final Permission[] getPermissions() {
        return this.permissions;
    }

    public SystemUpdatePermissionsParams(Permission[] r1) {
        this.permissions = r1;
    }

    public IntentParams mergeParams(Object r2) {
        if ((r2 instanceof SystemUpdatePermissionsParams) == true) goto L5;
        return this;
    L5:
        Permission[] r0 = this.permissions;
        if (r0 != null) goto L9;
        r0 = ((SystemUpdatePermissionsParams) r2).permissions;
    L9:
        return new SystemUpdatePermissionsParams(r0);
    }

    public final void setPermissions(Permission[] r1) {
        this.permissions = r1;
    }

    public /* synthetic */ SystemUpdatePermissionsParams(Permission[] r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        this(r1);
    }
}
