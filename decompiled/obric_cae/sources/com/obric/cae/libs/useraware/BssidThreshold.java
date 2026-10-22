package com.obric.cae.libs.useraware;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class BssidThreshold implements Parcelable {
    public static final Parcelable.Creator<BssidThreshold> CREATOR = null;
    public String bssid;
    public int threshold;

    public class a implements Parcelable.Creator<BssidThreshold> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final BssidThreshold createFromParcel(Parcel r8) {
            return new BssidThreshold(r8);
        }

        @Override // android.os.Parcelable.Creator
        public final BssidThreshold[] newArray(int r8) {
            return new BssidThreshold[r8];
        }
    }

    static {
        CREATOR = new a();
    }

    public BssidThreshold() {
    }

    public BssidThreshold(Parcel r8) {
        this.bssid = r8.readString();
        this.threshold = r8.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r8, int r10) {
        r8.writeString(this.bssid);
        r8.writeInt(this.threshold);
    }

    public BssidThreshold(String r8, int r10) {
        this.bssid = r8;
        this.threshold = r10;
    }
}
