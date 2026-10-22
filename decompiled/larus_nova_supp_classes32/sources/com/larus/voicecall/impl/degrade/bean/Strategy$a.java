package com.larus.voicecall.impl.degrade.bean;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class Strategy$a implements Parcelable.Creator<Strategy> {
    public Strategy$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final Strategy createFromParcel(Parcel r4) {
        Intrinsics.checkNotNullParameter(r4, "parcel");
        int r1 = r4.readInt();
        if (r4.readInt() != 0) goto L5;
        Object r5 = null;
    L7:
        return new Strategy(r1, (Extra) r5);
    L5:
        r5 = Extra.CREATOR.createFromParcel(r4);
        goto L7
    }

    @Override // android.os.Parcelable.Creator
    public final Strategy[] newArray(int r1) {
        return new Strategy[r1];
    }
}
