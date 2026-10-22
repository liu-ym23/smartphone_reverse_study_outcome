package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0006J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0004HÆ\u0003J!\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0011HÖ\u0001J\b\u0010\u0017\u001a\u00020\u0013H\u0016J\u0012\u0010\u0018\u001a\u00020\u00012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0015H\u0016J\t\u0010\u001a\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0011HÖ\u0001R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\n¨\u0006 "}, d2 = {"Lcom/obric/capabilitykit/common/intent/MemorySearchParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "toolParams", "", "extras", "(Ljava/lang/String;Ljava/lang/String;)V", "getExtras", "()Ljava/lang/String;", "setExtras", "(Ljava/lang/String;)V", "getToolParams", "setToolParams", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "isParamsCompleted", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class MemorySearchParams implements IntentParams, Parcelable {
    public static final Parcelable.Creator<MemorySearchParams> CREATOR = null;
    private String extras;
    private String toolParams;

    static {
        CREATOR = new a();
    }

    public MemorySearchParams() {
        String r0 = null;
        this(r0, r0, 3, r0);
    }

    public static /* synthetic */ MemorySearchParams copy$default(MemorySearchParams r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.toolParams;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.extras;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.toolParams;
    }

    public final String component2() {
        return this.extras;
    }

    public final MemorySearchParams copy(String r2, String r3) {
        return new MemorySearchParams(r2, r3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MemorySearchParams) == true) goto L8;
        return false;
    L8:
        MemorySearchParams r6 = (MemorySearchParams) r5;
        if (Intrinsics.areEqual(this.toolParams, r6.toolParams) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.extras, r6.extras) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public String getSubActionValue() {
        return null;
    }

    public int hashCode() {
        String r0 = this.toolParams;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.extras;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "MemorySearchParams(toolParams=" + this.toolParams + ", extras=" + this.extras + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(0);
        Intrinsics.checkNotNullParameter(r1, "out");
        r1.writeString(this.toolParams);
        r1.writeString(this.extras);
    }

    public boolean isParamsCompleted() {
        if (this.toolParams == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final String getExtras() {
        return this.extras;
    }

    public final String getToolParams() {
        return this.toolParams;
    }

    public IntentParams mergeParams(Object r3) {
        if ((r3 instanceof MemorySearchParams) == true) goto L5;
        return this;
    L5:
        String r0 = this.toolParams;
        if (r0 != null) goto L8;
        r0 = ((MemorySearchParams) r3).toolParams;
    L8:
        String r1 = this.extras;
        if (r1 != null) goto L12;
        r1 = ((MemorySearchParams) r3).extras;
    L12:
        return new MemorySearchParams(r0, r1);
    }

    public final void setExtras(String r1) {
        this.extras = r1;
    }

    public final void setToolParams(String r1) {
        this.toolParams = r1;
    }

    public MemorySearchParams(String r1, String r2) {
        this.toolParams = r1;
        this.extras = r2;
    }

    public /* synthetic */ MemorySearchParams(String r2, String r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }
}
