package com.larus.voicecall.impl.degrade.bean;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class TimeConfig$a implements Parcelable.Creator<TimeConfig> {
    public TimeConfig$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final TimeConfig createFromParcel(Parcel r9) {
        Intrinsics.checkNotNullParameter(r9, "parcel");
        return new TimeConfig(r9.readLong(), r9.readString(), r9.readLong(), r9.readString());
    }

    @Override // android.os.Parcelable.Creator
    public final TimeConfig[] newArray(int r1) {
        return new TimeConfig[r1];
    }
}
