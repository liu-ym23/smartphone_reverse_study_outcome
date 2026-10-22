package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B)\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0007J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0004HÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0015HÖ\u0001J\b\u0010\u001b\u001a\u00020\u0017H\u0016J\u0012\u0010\u001c\u001a\u00020\u00012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0019H\u0016J\t\u0010\u001e\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0015HÖ\u0001R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000b¨\u0006$"}, d2 = {"Lcom/obric/capabilitykit/common/intent/SystemSkillParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "uniqueId", "", "actionType", "actionArgs", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getActionArgs", "()Ljava/lang/String;", "setActionArgs", "(Ljava/lang/String;)V", "getActionType", "setActionType", "getUniqueId", "setUniqueId", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "isParamsCompleted", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class SystemSkillParams implements IntentParams, Parcelable {
    public static final Parcelable.Creator<SystemSkillParams> CREATOR = null;
    private String actionArgs;
    private String actionType;
    private String uniqueId;

    static {
        CREATOR = new a();
    }

    public SystemSkillParams() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ SystemSkillParams copy$default(SystemSkillParams r0, String r1, String r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.uniqueId;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.actionType;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.actionArgs;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.uniqueId;
    }

    public final String component2() {
        return this.actionType;
    }

    public final String component3() {
        return this.actionArgs;
    }

    public final SystemSkillParams copy(String r2, String r3, String r4) {
        return new SystemSkillParams(r2, r3, r4);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof SystemSkillParams) == true) goto L8;
        return false;
    L8:
        SystemSkillParams r6 = (SystemSkillParams) r5;
        if (Intrinsics.areEqual(this.uniqueId, r6.uniqueId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.actionType, r6.actionType) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.actionArgs, r6.actionArgs) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public String getSubActionValue() {
        return null;
    }

    public int hashCode() {
        String r0 = this.uniqueId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.actionType;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.actionArgs;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return r6 + r1;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "SystemSkillParams(uniqueId=" + this.uniqueId + ", actionType=" + this.actionType + ", actionArgs=" + this.actionArgs + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(0);
        Intrinsics.checkNotNullParameter(r1, "out");
        r1.writeString(this.uniqueId);
        r1.writeString(this.actionType);
        r1.writeString(this.actionArgs);
    }

    public boolean isParamsCompleted() {
        if (this.uniqueId != null) goto L5;
    L9:
        return false;
    L5:
        if (this.actionType == null) goto L9;
        if (this.actionArgs == null) goto L9;
        return true;
    }

    public final String getActionArgs() {
        return this.actionArgs;
    }

    public final String getActionType() {
        return this.actionType;
    }

    public final String getUniqueId() {
        return this.uniqueId;
    }

    public IntentParams mergeParams(Object r4) {
        if ((r4 instanceof SystemSkillParams) == true) goto L5;
        return this;
    L5:
        String r0 = this.uniqueId;
        if (r0 != null) goto L8;
        r0 = ((SystemSkillParams) r4).uniqueId;
    L8:
        String r1 = this.actionType;
        if (r1 != null) goto L11;
        r1 = ((SystemSkillParams) r4).actionType;
    L11:
        String r2 = this.actionArgs;
        if (r2 != null) goto L15;
        r2 = ((SystemSkillParams) r4).actionArgs;
    L15:
        return new SystemSkillParams(r0, r1, r2);
    }

    public final void setActionArgs(String r1) {
        this.actionArgs = r1;
    }

    public final void setActionType(String r1) {
        this.actionType = r1;
    }

    public final void setUniqueId(String r1) {
        this.uniqueId = r1;
    }

    public SystemSkillParams(String r1, String r2, String r3) {
        this.uniqueId = r1;
        this.actionType = r2;
        this.actionArgs = r3;
    }

    public /* synthetic */ SystemSkillParams(String r2, String r3, String r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        this(r2, r3, r4);
    }
}
