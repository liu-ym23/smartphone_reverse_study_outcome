package com.obric.cae.libs.useraware;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public class HarMonitorParams$a implements Parcelable.Creator<HarMonitorParams> {
    public HarMonitorParams$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final HarMonitorParams createFromParcel(Parcel r2) {
        return new HarMonitorParams(r2);
    }

    @Override // android.os.Parcelable.Creator
    public final HarMonitorParams[] newArray(int r1) {
        return new HarMonitorParams[r1];
    }
}
