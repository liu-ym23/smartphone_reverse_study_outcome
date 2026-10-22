package com.ss.android.lark.location.dto;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class LocationClientConfig implements Parcelable {
    public static final Parcelable.Creator<LocationClientConfig> CREATOR = null;
    public final boolean a;

    public class a implements Parcelable.Creator<LocationClientConfig> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final LocationClientConfig createFromParcel(Parcel r2) {
            return new LocationClientConfig(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final LocationClientConfig[] newArray(int r1) {
            return new LocationClientConfig[r1];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public LocationClientConfig() {
    }

    public LocationClientConfig(Parcel r1) {
        if (r1.readInt() == 0) goto L5;
        boolean r2 = true;
    L6:
        this.a = r2;
        return;
    L5:
        r2 = false;
        goto L6
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(this.a ? 1 : 0);
    }
}
