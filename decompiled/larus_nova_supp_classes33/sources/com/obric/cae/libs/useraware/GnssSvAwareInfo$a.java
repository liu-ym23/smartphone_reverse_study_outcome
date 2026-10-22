package com.obric.cae.libs.useraware;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public class GnssSvAwareInfo$a implements Parcelable.Creator<GnssSvAwareInfo> {
    public GnssSvAwareInfo$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final GnssSvAwareInfo createFromParcel(Parcel r2) {
        return new GnssSvAwareInfo(r2);
    }

    @Override // android.os.Parcelable.Creator
    public final GnssSvAwareInfo[] newArray(int r1) {
        return new GnssSvAwareInfo[r1];
    }
}
