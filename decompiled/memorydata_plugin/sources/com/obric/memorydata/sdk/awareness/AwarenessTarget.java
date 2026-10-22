package com.obric.memorydata.sdk.awareness;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\r\u001a\u00020\u000eJ\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u000eHÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u001a"}, d2 = {"Lcom/obric/memorydata/sdk/awareness/AwarenessTarget;", "Landroid/os/Parcelable;", "targetType", "", "targetName", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getTargetType", "()Ljava/lang/String;", "getTargetName", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AwarenessTarget implements Parcelable {
    public static final Parcelable.Creator<AwarenessTarget> CREATOR = null;
    private final String targetName;
    private final String targetType;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class a implements Parcelable.Creator<AwarenessTarget> {
        public a() {
        }

        public final AwarenessTarget a(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            return new AwarenessTarget(r2.readString(), r2.readString());
        }

        public final AwarenessTarget[] a(int r1) {
            return new AwarenessTarget[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ AwarenessTarget createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ AwarenessTarget[] newArray(int r1) {
            return a(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new a(), Parcelable.Creator.class, "com.obric.memorydata.plugin");
    }

    public AwarenessTarget(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "targetType");
        Intrinsics.checkNotNullParameter(r3, "targetName");
        this.targetType = r2;
        this.targetName = r3;
    }

    public static /* synthetic */ AwarenessTarget copy$default(AwarenessTarget r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.targetType;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.targetName;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.targetType;
    }

    public final String component2() {
        return this.targetName;
    }

    public final AwarenessTarget copy(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "targetType");
        Intrinsics.checkNotNullParameter(r2, "targetName");
        return new AwarenessTarget(r1, r2);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, AwarenessTarget.class) == true) goto L8;
        return false;
    L8:
        AwarenessTarget r6 = (AwarenessTarget) ZeusTransformUtils.preCheckCast(r5, AwarenessTarget.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.targetType, r6.targetType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.targetName, r6.targetName) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final String getTargetName() {
        return this.targetName;
    }

    public final String getTargetType() {
        return this.targetType;
    }

    public int hashCode() {
        return (this.targetType.hashCode() * 31) + this.targetName.hashCode();
    }

    public String toString() {
        return "AwarenessTarget(targetType=" + this.targetType + ", targetName=" + this.targetName + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "dest");
        r1.writeString(this.targetType);
        r1.writeString(this.targetName);
    }
}
