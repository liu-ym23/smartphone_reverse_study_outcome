package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0006J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0004HÆ\u0003J!\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0011HÖ\u0001J\u0012\u0010\u0017\u001a\u00020\u00012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0015H\u0016J\t\u0010\u0019\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0011HÖ\u0001R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\n¨\u0006\u001f"}, d2 = {"Lcom/obric/capabilitykit/common/intent/PCGlobalSearchParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "quResult", "", "interactionType", "(Ljava/lang/String;Ljava/lang/String;)V", "getInteractionType", "()Ljava/lang/String;", "setInteractionType", "(Ljava/lang/String;)V", "getQuResult", "setQuResult", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class PCGlobalSearchParams implements IntentParams, Parcelable {
    public static final Parcelable.Creator<PCGlobalSearchParams> CREATOR = null;
    private String interactionType;
    private String quResult;

    static {
        CREATOR = new a();
    }

    public PCGlobalSearchParams() {
        String r0 = null;
        this(r0, r0, 3, r0);
    }

    public static /* synthetic */ PCGlobalSearchParams copy$default(PCGlobalSearchParams r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.quResult;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.interactionType;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.quResult;
    }

    public final String component2() {
        return this.interactionType;
    }

    public final PCGlobalSearchParams copy(String r2, String r3) {
        return new PCGlobalSearchParams(r2, r3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof PCGlobalSearchParams) == true) goto L8;
        return false;
    L8:
        PCGlobalSearchParams r6 = (PCGlobalSearchParams) r5;
        if (Intrinsics.areEqual(this.quResult, r6.quResult) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.interactionType, r6.interactionType) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public String getSubActionValue() {
        return null;
    }

    public int hashCode() {
        String r0 = this.quResult;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.interactionType;
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
        return "PCGlobalSearchParams(quResult=" + this.quResult + ", interactionType=" + this.interactionType + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(0);
        Intrinsics.checkNotNullParameter(r1, "out");
        r1.writeString(this.quResult);
        r1.writeString(this.interactionType);
    }

    public final String getInteractionType() {
        return this.interactionType;
    }

    public final String getQuResult() {
        return this.quResult;
    }

    public IntentParams mergeParams(Object r3) {
        if ((r3 instanceof PCGlobalSearchParams) == true) goto L5;
        return this;
    L5:
        String r0 = this.quResult;
        if (r0 != null) goto L8;
        r0 = ((PCGlobalSearchParams) r3).quResult;
    L8:
        String r1 = this.interactionType;
        if (r1 != null) goto L12;
        r1 = ((PCGlobalSearchParams) r3).interactionType;
    L12:
        return new PCGlobalSearchParams(r0, r1);
    }

    public final void setInteractionType(String r1) {
        this.interactionType = r1;
    }

    public final void setQuResult(String r1) {
        this.quResult = r1;
    }

    public PCGlobalSearchParams(String r1, String r2) {
        this.quResult = r1;
        this.interactionType = r2;
    }

    public /* synthetic */ PCGlobalSearchParams(String r2, String r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }
}
