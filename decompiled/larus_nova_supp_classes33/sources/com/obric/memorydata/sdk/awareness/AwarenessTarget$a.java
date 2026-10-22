package com.obric.memorydata.sdk.awareness;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class AwarenessTarget$a implements Parcelable.Creator<AwarenessTarget> {
    public AwarenessTarget$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final AwarenessTarget createFromParcel(Parcel r3) {
        Intrinsics.checkNotNullParameter(r3, "parcel");
        return new AwarenessTarget(r3.readString(), r3.readString());
    }

    @Override // android.os.Parcelable.Creator
    public final AwarenessTarget[] newArray(int r1) {
        return new AwarenessTarget[r1];
    }
}
