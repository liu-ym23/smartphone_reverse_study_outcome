package com.obric.cae.libs.useraware;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public class HarLevel2DataReq$a implements Parcelable.Creator<HarLevel2DataReq> {
    public HarLevel2DataReq$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final HarLevel2DataReq createFromParcel(Parcel r2) {
        return new HarLevel2DataReq(r2);
    }

    @Override // android.os.Parcelable.Creator
    public final HarLevel2DataReq[] newArray(int r1) {
        return new HarLevel2DataReq[r1];
    }
}
