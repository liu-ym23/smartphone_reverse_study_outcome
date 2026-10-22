package com.obric.cae.libs.useraware;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public class BssidThreshold implements Parcelable {
    public static final Parcelable.Creator<BssidThreshold> CREATOR = null;
    public String bssid;
    public int threshold;

    public class a implements Parcelable.Creator<BssidThreshold> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final BssidThreshold createFromParcel(Parcel r2) {
            return new BssidThreshold(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final BssidThreshold[] newArray(int r1) {
            return new BssidThreshold[r1];
        }
    }

    public BssidThreshold() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public BssidThreshold(Parcel r2) {
        this.bssid = r2.readString();
        this.threshold = r2.readInt();
    }

    public BssidThreshold(String r1, int r2) {
        this.bssid = r1;
        this.threshold = r2;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeString(this.bssid);
        r1.writeInt(this.threshold);
    }
}
