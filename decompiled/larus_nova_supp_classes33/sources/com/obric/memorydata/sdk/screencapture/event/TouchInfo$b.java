package com.obric.memorydata.sdk.screencapture.event;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class TouchInfo$b implements Parcelable.Creator<TouchInfo> {
    public TouchInfo$b() {
    }

    @Override // android.os.Parcelable.Creator
    public final TouchInfo createFromParcel(Parcel r3) {
        Intrinsics.checkNotNullParameter(r3, "parcel");
        return new TouchInfo(r3.readFloat(), r3.readFloat());
    }

    @Override // android.os.Parcelable.Creator
    public final TouchInfo[] newArray(int r1) {
        return new TouchInfo[r1];
    }
}
