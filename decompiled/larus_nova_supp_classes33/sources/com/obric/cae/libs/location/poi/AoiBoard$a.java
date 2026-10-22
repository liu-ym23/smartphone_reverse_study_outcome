package com.obric.cae.libs.location.poi;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public class AoiBoard$a implements Parcelable.Creator<AoiBoard> {
    public AoiBoard$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final AoiBoard createFromParcel(Parcel r2) {
        return new AoiBoard(r2);
    }

    @Override // android.os.Parcelable.Creator
    public final AoiBoard[] newArray(int r1) {
        return new AoiBoard[r1];
    }
}
