package com.larus.voicecall.impl.degrade.bean;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class Extra$a implements Parcelable.Creator<Extra> {
    public Extra$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final Extra createFromParcel(Parcel r4) {
        Intrinsics.checkNotNullParameter(r4, "parcel");
        return new Extra(r4.readString(), r4.readString(), r4.readString());
    }

    @Override // android.os.Parcelable.Creator
    public final Extra[] newArray(int r1) {
        return new Extra[r1];
    }
}
