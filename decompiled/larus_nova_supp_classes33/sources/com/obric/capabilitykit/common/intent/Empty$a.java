package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class Empty$a implements Parcelable.Creator<Empty> {
    public Empty$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final Empty createFromParcel(Parcel r2) {
        Intrinsics.checkNotNullParameter(r2, "parcel");
        r2.readInt();
        return new Empty();
    }

    @Override // android.os.Parcelable.Creator
    public final Empty[] newArray(int r1) {
        return new Empty[r1];
    }
}
