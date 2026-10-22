package com.larus.bmhome.auth;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class LandingConfig$a implements Parcelable.Creator<LandingConfig> {
    public LandingConfig$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final LandingConfig createFromParcel(Parcel r2) {
        Intrinsics.checkNotNullParameter(r2, "parcel");
        return new LandingConfig(r2.readString());
    }

    @Override // android.os.Parcelable.Creator
    public final LandingConfig[] newArray(int r1) {
        return new LandingConfig[r1];
    }
}
