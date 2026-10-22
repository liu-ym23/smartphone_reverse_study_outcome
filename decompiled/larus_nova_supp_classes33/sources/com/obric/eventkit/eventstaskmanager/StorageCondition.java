package com.obric.eventkit.eventstaskmanager;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\t\u0010\b\u001a\u00020\u0004HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0019\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000bHÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0018"}, d2 = {"Lcom/obric/eventkit/eventstaskmanager/StorageCondition;", "Lcom/obric/eventkit/eventstaskmanager/Condition;", "Landroid/os/Parcelable;", "percent", "", "(F)V", "getPercent", "()F", "component1", "copy", "describeContents", "", "equals", "", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class StorageCondition implements Condition, Parcelable {
    public static final Parcelable.Creator<StorageCondition> CREATOR = null;
    private final float percent;

    public static final class a implements Parcelable.Creator<StorageCondition> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final StorageCondition createFromParcel(Parcel r6) {
            int r0 = r6.readInt();
            Intrinsics.checkNotNullParameter(r6, "parcel");
            StorageCondition r1 = new StorageCondition(r6.readFloat());
            int r2 = Math.min(r0, 0);
            ClassLoader r3 = a.class.getClassLoader();
            int r4 = 1;
        L3:
            if (r4 > r2) goto L5;
            r4 = r4 + 1;
        L5:
            if (r4 > r0) goto L7;
            joa.a.d(r6, r3);
            r4 = r4 + 1;
            goto L5
        L7:
            return r1;
        }

        @Override // android.os.Parcelable.Creator
        public final StorageCondition[] newArray(int r1) {
            return new StorageCondition[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public StorageCondition(float r1) {
        this.percent = r1;
    }

    public static /* synthetic */ StorageCondition copy$default(StorageCondition r0, float r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.percent;
    L6:
        return r0.copy(r1);
    }

    public final float component1() {
        return this.percent;
    }

    public final StorageCondition copy(float r2) {
        return new StorageCondition(r2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof StorageCondition) == true) goto L9;
        return false;
    L9:
        if (Float.compare(this.percent, ((StorageCondition) r4).percent) == 0) goto L11;
        return false;
    L11:
        return true;
    }

    public final float getPercent() {
        return this.percent;
    }

    public int hashCode() {
        return Float.floatToIntBits(this.percent);
    }

    public String toString() {
        return "StorageCondition(percent=" + this.percent + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(0);
        Intrinsics.checkNotNullParameter(r1, "out");
        r1.writeFloat(this.percent);
    }
}
