package com.obric.memorydata.sdk.awareness.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class BluetoothDeviceInfo$a implements Parcelable.Creator<BluetoothDeviceInfo> {
    public BluetoothDeviceInfo$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final BluetoothDeviceInfo createFromParcel(Parcel r8) {
        Intrinsics.checkNotNullParameter(r8, "parcel");
        String r2 = r8.readString();
        String r3 = r8.readString();
        if (r8.readInt() != 0) goto L5;
        Integer r1 = null;
    L7:
        return new BluetoothDeviceInfo(r2, r3, r1, r8.readInt(), r8.readInt());
    L5:
        r1 = Integer.valueOf(r8.readInt());
        goto L7
    }

    @Override // android.os.Parcelable.Creator
    public final BluetoothDeviceInfo[] newArray(int r1) {
        return new BluetoothDeviceInfo[r1];
    }
}
