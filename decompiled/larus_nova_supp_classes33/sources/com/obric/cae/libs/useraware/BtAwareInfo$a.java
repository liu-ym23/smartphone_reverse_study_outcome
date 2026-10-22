package com.obric.cae.libs.useraware;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public class BtAwareInfo$a implements Parcelable.Creator<BtAwareInfo> {
    public BtAwareInfo$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final BtAwareInfo createFromParcel(Parcel r2) {
        return new BtAwareInfo(r2);
    }

    @Override // android.os.Parcelable.Creator
    public final BtAwareInfo[] newArray(int r1) {
        return new BtAwareInfo[r1];
    }
}
