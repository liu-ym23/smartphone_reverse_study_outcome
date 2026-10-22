package com.obric.cae.libs.useraware;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public class LocationAwareInfo$a implements Parcelable.Creator<LocationAwareInfo> {
    public LocationAwareInfo$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final LocationAwareInfo createFromParcel(Parcel r2) {
        return new LocationAwareInfo(r2);
    }

    @Override // android.os.Parcelable.Creator
    public final LocationAwareInfo[] newArray(int r1) {
        return new LocationAwareInfo[r1];
    }
}
