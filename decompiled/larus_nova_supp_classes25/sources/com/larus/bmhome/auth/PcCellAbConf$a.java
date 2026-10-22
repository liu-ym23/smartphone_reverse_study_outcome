package com.larus.bmhome.auth;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class PcCellAbConf$a implements Parcelable.Creator<PcCellAbConf> {
    public PcCellAbConf$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final PcCellAbConf createFromParcel(Parcel r2) {
        Intrinsics.checkNotNullParameter(r2, "parcel");
        return new PcCellAbConf(r2.readString());
    }

    @Override // android.os.Parcelable.Creator
    public final PcCellAbConf[] newArray(int r1) {
        return new PcCellAbConf[r1];
    }
}
