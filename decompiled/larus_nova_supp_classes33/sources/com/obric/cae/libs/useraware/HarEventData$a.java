package com.obric.cae.libs.useraware;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public class HarEventData$a implements Parcelable.Creator<HarEventData> {
    public HarEventData$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final HarEventData createFromParcel(Parcel r2) {
        return new HarEventData(r2);
    }

    @Override // android.os.Parcelable.Creator
    public final HarEventData[] newArray(int r1) {
        return new HarEventData[r1];
    }
}
