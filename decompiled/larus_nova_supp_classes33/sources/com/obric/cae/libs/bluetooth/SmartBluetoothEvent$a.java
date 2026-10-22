package com.obric.cae.libs.bluetooth;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public class SmartBluetoothEvent$a implements Parcelable.Creator<SmartBluetoothEvent> {
    public SmartBluetoothEvent$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final SmartBluetoothEvent createFromParcel(Parcel r2) {
        return new SmartBluetoothEvent(r2);
    }

    @Override // android.os.Parcelable.Creator
    public final SmartBluetoothEvent[] newArray(int r1) {
        return new SmartBluetoothEvent[r1];
    }
}
