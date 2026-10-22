package com.obric.cae.libs.useraware;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public class UnifiedDataPacket$a implements Parcelable.Creator<UnifiedDataPacket> {
    public UnifiedDataPacket$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final UnifiedDataPacket createFromParcel(Parcel r2) {
        return new UnifiedDataPacket(r2);
    }

    @Override // android.os.Parcelable.Creator
    public final UnifiedDataPacket[] newArray(int r1) {
        return new UnifiedDataPacket[r1];
    }
}
