package com.larus.bmhome.auth;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class AlertConfig$a implements Parcelable.Creator<AlertConfig> {
    public AlertConfig$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final AlertConfig createFromParcel(Parcel r5) {
        Intrinsics.checkNotNullParameter(r5, "parcel");
        return new AlertConfig(r5.readString(), r5.readString(), r5.readString(), r5.readString());
    }

    @Override // android.os.Parcelable.Creator
    public final AlertConfig[] newArray(int r1) {
        return new AlertConfig[r1];
    }
}
