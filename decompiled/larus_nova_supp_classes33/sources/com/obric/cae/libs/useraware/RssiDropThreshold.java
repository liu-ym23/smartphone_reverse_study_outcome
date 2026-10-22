package com.obric.cae.libs.useraware;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public class RssiDropThreshold implements Parcelable {
    public static final Parcelable.Creator<RssiDropThreshold> CREATOR = null;
    public int dropDb;
    public int durationSec;

    public class a implements Parcelable.Creator<RssiDropThreshold> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final RssiDropThreshold createFromParcel(Parcel r2) {
            return new RssiDropThreshold(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final RssiDropThreshold[] newArray(int r1) {
            return new RssiDropThreshold[r1];
        }
    }

    public RssiDropThreshold() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public RssiDropThreshold(Parcel r2) {
        this.durationSec = r2.readInt();
        this.dropDb = r2.readInt();
    }

    public RssiDropThreshold(int r1, int r2) {
        this.durationSec = r1;
        this.dropDb = r2;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(this.durationSec);
        r1.writeInt(this.dropDb);
    }
}
