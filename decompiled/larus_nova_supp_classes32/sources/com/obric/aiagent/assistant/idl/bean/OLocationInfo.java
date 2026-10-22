package com.obric.aiagent.assistant.idl.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\r\u001a\u00020\u000eJ\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u000eHÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u001b"}, d2 = {"Lcom/obric/aiagent/assistant/idl/bean/OLocationInfo;", "Landroid/os/Parcelable;", "longitude", NameKeys.UnloadStrategy_No_Strategy, "latitude", "<init>", "(DD)V", "getLongitude", "()D", "getLatitude", "component1", "component2", "copy", "describeContents", NameKeys.UnloadStrategy_No_Strategy, "equals", NameKeys.UnloadStrategy_No_Strategy, "other", NameKeys.UnloadStrategy_No_Strategy, "hashCode", "toString", NameKeys.UnloadStrategy_No_Strategy, "writeToParcel", NameKeys.UnloadStrategy_No_Strategy, "dest", "Landroid/os/Parcel;", "flags", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OLocationInfo implements Parcelable {
    public static final Parcelable.Creator<OLocationInfo> CREATOR = null;
    private final double latitude;
    private final double longitude;

    public static final class a implements Parcelable.Creator<OLocationInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final OLocationInfo createFromParcel(Parcel r6) {
            Intrinsics.checkNotNullParameter(r6, "parcel");
            return new OLocationInfo(r6.readDouble(), r6.readDouble());
        }

        @Override // android.os.Parcelable.Creator
        public final OLocationInfo[] newArray(int r1) {
            return new OLocationInfo[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public static /* synthetic */ OLocationInfo copy$default(OLocationInfo r0, double r1, double r3, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.longitude;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = r0.latitude;
    L9:
        return r0.copy(r1, r3);
    }

    public final double component1() {
        return this.longitude;
    }

    public final double component2() {
        return this.latitude;
    }

    public final OLocationInfo copy(double r2, double r4) {
        return new OLocationInfo(r2, r4);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof OLocationInfo) == true) goto L8;
        return false;
    L8:
        OLocationInfo r9 = (OLocationInfo) r8;
        if (Double.compare(this.longitude, r9.longitude) == 0) goto L12;
        return false;
    L12:
        if (Double.compare(this.latitude, r9.latitude) == 0) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        long r0 = Double.doubleToLongBits(this.longitude);
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r3 = Double.doubleToLongBits(this.latitude);
        return r1 + ((int) (r3 ^ (r3 >>> 32)));
    }

    public String toString() {
        return "OLocationInfo(longitude=" + this.longitude + ", latitude=" + this.latitude + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "dest");
        r3.writeDouble(this.longitude);
        r3.writeDouble(this.latitude);
    }

    public final double getLatitude() {
        return this.latitude;
    }

    public final double getLongitude() {
        return this.longitude;
    }

    public OLocationInfo(double r1, double r3) {
        this.longitude = r1;
        this.latitude = r3;
    }
}
