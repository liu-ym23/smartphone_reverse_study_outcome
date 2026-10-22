package com.obric.cae.libs.useraware;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public class CellAwareInfo$a implements Parcelable.Creator<CellAwareInfo> {
    public CellAwareInfo$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final CellAwareInfo createFromParcel(Parcel r2) {
        return new CellAwareInfo(r2);
    }

    @Override // android.os.Parcelable.Creator
    public final CellAwareInfo[] newArray(int r1) {
        return new CellAwareInfo[r1];
    }
}
