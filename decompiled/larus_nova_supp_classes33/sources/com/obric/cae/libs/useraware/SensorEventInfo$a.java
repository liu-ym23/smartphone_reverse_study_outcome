package com.obric.cae.libs.useraware;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public class SensorEventInfo$a implements Parcelable.Creator<SensorEventInfo> {
    public SensorEventInfo$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final SensorEventInfo createFromParcel(Parcel r2) {
        return new SensorEventInfo(r2);
    }

    @Override // android.os.Parcelable.Creator
    public final SensorEventInfo[] newArray(int r1) {
        return new SensorEventInfo[r1];
    }
}
