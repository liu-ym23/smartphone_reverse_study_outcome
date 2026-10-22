package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003J&\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0014J\t\u0010\u0015\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0004HÖ\u0001J\b\u0010\u001b\u001a\u00020\u0017H\u0016J\u0012\u0010\u001c\u001a\u00020\u00012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0019H\u0016J\t\u0010\u001e\u001a\u00020\u0006HÖ\u0001J\u0019\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0004HÖ\u0001R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006$"}, d2 = {"Lcom/obric/capabilitykit/common/intent/PCEntityPoisonLabelParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "labelVersion", "", "operateList", "", "(Ljava/lang/Integer;Ljava/lang/String;)V", "getLabelVersion", "()Ljava/lang/Integer;", "setLabelVersion", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getOperateList", "()Ljava/lang/String;", "setOperateList", "(Ljava/lang/String;)V", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/String;)Lcom/obric/capabilitykit/common/intent/PCEntityPoisonLabelParams;", "describeContents", "equals", "", "other", "", "hashCode", "isParamsCompleted", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class PCEntityPoisonLabelParams implements IntentParams, Parcelable {
    public static final Parcelable.Creator<PCEntityPoisonLabelParams> CREATOR = null;
    private Integer labelVersion;
    private String operateList;

    static {
        CREATOR = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PCEntityPoisonLabelParams() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ PCEntityPoisonLabelParams copy$default(PCEntityPoisonLabelParams r0, Integer r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.labelVersion;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.operateList;
    L9:
        return r0.copy(r1, r2);
    }

    public final Integer component1() {
        return this.labelVersion;
    }

    public final String component2() {
        return this.operateList;
    }

    public final PCEntityPoisonLabelParams copy(Integer r2, String r3) {
        return new PCEntityPoisonLabelParams(r2, r3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof PCEntityPoisonLabelParams) == true) goto L8;
        return false;
    L8:
        PCEntityPoisonLabelParams r6 = (PCEntityPoisonLabelParams) r5;
        if (Intrinsics.areEqual(this.labelVersion, r6.labelVersion) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.operateList, r6.operateList) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public String getSubActionValue() {
        return null;
    }

    public int hashCode() {
        Integer r0 = this.labelVersion;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.operateList;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "PCEntityPoisonLabelParams(labelVersion=" + this.labelVersion + ", operateList=" + this.operateList + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        int r4 = 0;
        r2.writeInt(0);
        Intrinsics.checkNotNullParameter(r2, "out");
        Integer r0 = this.labelVersion;
        if (r0 == null) goto L6;
        r2.writeInt(1);
        r4 = r0.intValue();
    L6:
        r2.writeInt(r4);
        r2.writeString(this.operateList);
    }

    public boolean isParamsCompleted() {
        if (this.operateList == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final Integer getLabelVersion() {
        return this.labelVersion;
    }

    public final String getOperateList() {
        return this.operateList;
    }

    public IntentParams mergeParams(Object r3) {
        if ((r3 instanceof PCEntityPoisonLabelParams) == true) goto L5;
        return this;
    L5:
        Integer r0 = this.labelVersion;
        if (r0 != null) goto L8;
        r0 = ((PCEntityPoisonLabelParams) r3).labelVersion;
    L8:
        String r1 = this.operateList;
        if (r1 != null) goto L12;
        r1 = ((PCEntityPoisonLabelParams) r3).operateList;
    L12:
        return new PCEntityPoisonLabelParams(r0, r1);
    }

    public final void setLabelVersion(Integer r1) {
        this.labelVersion = r1;
    }

    public final void setOperateList(String r1) {
        this.operateList = r1;
    }

    public PCEntityPoisonLabelParams(Integer r1, String r2) {
        this.labelVersion = r1;
        this.operateList = r2;
    }

    public /* synthetic */ PCEntityPoisonLabelParams(Integer r2, String r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }
}
