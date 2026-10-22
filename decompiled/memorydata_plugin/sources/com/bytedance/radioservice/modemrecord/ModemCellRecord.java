package com.bytedance.radioservice.modemrecord;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public class ModemCellRecord implements Parcelable {
    public static final Parcelable.Creator<ModemCellRecord> CREATOR = null;
    public long leaveTimestampMs;
    public float rsrp;
    public String specificCellId;
    public int stepCount;

    public class a implements Parcelable.Creator<ModemCellRecord> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ModemCellRecord createFromParcel(Parcel r1) {
            return new ModemCellRecord(r1);
        }

        @Override // android.os.Parcelable.Creator
        public final ModemCellRecord[] newArray(int r1) {
            return new ModemCellRecord[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public ModemCellRecord(long r1, String r3, int r4, float r5) {
        this.leaveTimestampMs = r1;
        this.specificCellId = r3;
        this.stepCount = r4;
        this.rsrp = r5;
    }

    public ModemCellRecord(Parcel r3) {
        this.leaveTimestampMs = r3.readLong();
        this.specificCellId = r3.readString();
        this.stepCount = r3.readInt();
        this.rsrp = r3.readFloat();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "ModemCellRecord{leaveTimestampMs=" + this.leaveTimestampMs + ", specificCellId='" + this.specificCellId + "', stepCount=" + this.stepCount + ", rsrp=" + this.rsrp + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        r3.writeLong(this.leaveTimestampMs);
        r3.writeString(this.specificCellId);
        r3.writeInt(this.stepCount);
        r3.writeFloat(this.rsrp);
    }
}
