package com.obric.memorydata.sdk.accessibility;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ&\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u000eJ\u0006\u0010\u000f\u001a\u00020\u0003J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0003R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\n\u0010\b¨\u0006\u001c"}, d2 = {"Lcom/obric/memorydata/sdk/accessibility/VisibleNodeCountCondition;", "Landroid/os/Parcelable;", "min", "", "max", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "getMin", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMax", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/obric/memorydata/sdk/accessibility/VisibleNodeCountCondition;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class VisibleNodeCountCondition implements Parcelable {
    public static final Parcelable.Creator<VisibleNodeCountCondition> CREATOR = null;
    public final Integer a;
    public final Integer b;

    public static final class a implements Parcelable.Creator<VisibleNodeCountCondition> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final VisibleNodeCountCondition createFromParcel(Parcel r5) {
            Intrinsics.checkNotNullParameter(r5, "parcel");
            Integer r2 = null;
            if (r5.readInt() != 0) goto L5;
            Integer r1 = null;
        L7:
            if (r5.readInt() == 0) goto L11;
            r2 = Integer.valueOf(r5.readInt());
        L11:
            return new VisibleNodeCountCondition(r1, r2);
        L5:
            r1 = Integer.valueOf(r5.readInt());
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final VisibleNodeCountCondition[] newArray(int r1) {
            return new VisibleNodeCountCondition[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public VisibleNodeCountCondition() {
        this(null, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof VisibleNodeCountCondition) == true) goto L8;
        return false;
    L8:
        VisibleNodeCountCondition r6 = (VisibleNodeCountCondition) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        Integer r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.b;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "VisibleNodeCountCondition(min=" + this.a + ", max=" + this.b + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "dest");
        Integer r5 = this.a;
        if (r5 != null) goto L5;
        r3.writeInt(0);
    L6:
        Integer r6 = this.b;
        if (r6 != null) goto L9;
        r3.writeInt(0);
        return;
    L9:
        r3.writeInt(1);
        r3.writeInt(r6.intValue());
        return;
    L5:
        r3.writeInt(1);
        r3.writeInt(r5.intValue());
        goto L6
    }

    public VisibleNodeCountCondition(Integer r1, Integer r2) {
        this.a = r1;
        this.b = r2;
    }
}
