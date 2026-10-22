package com.obric.cae.libs.useraware;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class RssiDropThreshold implements Parcelable {
    public static final Parcelable.Creator<RssiDropThreshold> CREATOR = null;
    public int dropDb;
    public int durationSec;

    public class a implements Parcelable.Creator<RssiDropThreshold> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final RssiDropThreshold createFromParcel(Parcel r8) {
            return new RssiDropThreshold(r8);
        }

        @Override // android.os.Parcelable.Creator
        public final RssiDropThreshold[] newArray(int r8) {
            return new RssiDropThreshold[r8];
        }
    }

    static {
        CREATOR = new a();
    }

    public RssiDropThreshold() {
    }

    public RssiDropThreshold(int r8, int r10) {
        this.durationSec = r8;
        this.dropDb = r10;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r8, int r10) {
        r8.writeInt(this.durationSec);
        r8.writeInt(this.dropDb);
    }

    public RssiDropThreshold(Parcel r8) {
        this.durationSec = r8.readInt();
        this.dropDb = r8.readInt();
    }
}
