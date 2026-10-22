package com.bytedance.radioservice.modemrecord;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class ModemCellRecord implements Parcelable {
    public static final Parcelable.Creator<ModemCellRecord> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f4040a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f4041b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f4042m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final float f4043n;

    public class a implements Parcelable.Creator<ModemCellRecord> {
        @Override // android.os.Parcelable.Creator
        public final ModemCellRecord createFromParcel(Parcel r8) {
            return new ModemCellRecord(r8);
        }

        @Override // android.os.Parcelable.Creator
        public final ModemCellRecord[] newArray(int r8) {
            return new ModemCellRecord[r8];
        }
    }

    static {
        CREATOR = new a();
    }

    public ModemCellRecord(Parcel r8) {
        this.f4040a = r8.readLong();
        this.f4041b = r8.readString();
        this.f4042m = r8.readInt();
        this.f4043n = r8.readFloat();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return "ModemCellRecord{leaveTimestampMs=" + this.f4040a + ", specificCellId='" + this.f4041b + "', stepCount=" + this.f4042m + ", rsrp=" + this.f4043n + '}';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r8, int r10) {
        r8.writeLong(this.f4040a);
        r8.writeString(this.f4041b);
        r8.writeInt(this.f4042m);
        r8.writeFloat(this.f4043n);
    }
}
