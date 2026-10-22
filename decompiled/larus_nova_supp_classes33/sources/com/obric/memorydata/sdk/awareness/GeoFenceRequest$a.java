package com.obric.memorydata.sdk.awareness;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class GeoFenceRequest$a implements Parcelable.Creator<GeoFenceRequest> {
    public GeoFenceRequest$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final GeoFenceRequest createFromParcel(Parcel r9) {
        Intrinsics.checkNotNullParameter(r9, "parcel");
        return new GeoFenceRequest(r9.readString(), r9.readDouble(), r9.readDouble(), r9.readInt());
    }

    @Override // android.os.Parcelable.Creator
    public final GeoFenceRequest[] newArray(int r1) {
        return new GeoFenceRequest[r1];
    }
}
