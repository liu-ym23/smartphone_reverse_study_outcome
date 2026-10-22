package com.larus.voicecall.impl.degrade.bean;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class Entrance$a implements Parcelable.Creator<Entrance> {
    public Entrance$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final Entrance createFromParcel(Parcel r4) {
        Intrinsics.checkNotNullParameter(r4, "parcel");
        String r1 = r4.readString();
        if (r4.readInt() != 0) goto L5;
        Object r2 = null;
    L7:
        return new Entrance(r1, (Strategy) r2, r4.createStringArrayList());
    L5:
        r2 = Strategy.CREATOR.createFromParcel(r4);
        goto L7
    }

    @Override // android.os.Parcelable.Creator
    public final Entrance[] newArray(int r1) {
        return new Entrance[r1];
    }
}
