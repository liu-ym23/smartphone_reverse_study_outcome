package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import joa.a;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class MapTakeTaxiParams$a implements Parcelable.Creator<MapTakeTaxiParams> {
    public MapTakeTaxiParams$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final MapTakeTaxiParams createFromParcel(Parcel r12) {
        int r0 = r12.readInt();
        Intrinsics.checkNotNullParameter(r12, "parcel");
        String r3 = r12.readString();
        String r4 = r12.readString();
        if (r12.readInt() != 0) goto L5;
        Double r6 = null;
    L7:
        if (r12.readInt() != 0) goto L9;
        Double r7 = null;
    L11:
        if (r12.readInt() != 0) goto L13;
        Double r8 = null;
    L15:
        if (r12.readInt() != 0) goto L17;
        Double r9 = null;
    L18:
        MapTakeTaxiParams r1 = new MapTakeTaxiParams(r3, r4, r6, r7, r8, r9);
        int r2 = Math.min(r0, 0);
        ClassLoader r5 = MapTakeTaxiParams$a.class.getClassLoader();
        int r10 = 1;
    L19:
        if (r10 > r2) goto L21;
        r10 = r10 + 1;
    L21:
        if (r10 > r0) goto L23;
        a.d(r12, r5);
        r10 = r10 + 1;
        goto L21
    L23:
        return r1;
    L17:
        r9 = Double.valueOf(r12.readDouble());
        goto L18
    L13:
        r8 = Double.valueOf(r12.readDouble());
        goto L15
    L9:
        r7 = Double.valueOf(r12.readDouble());
        goto L11
    L5:
        r6 = Double.valueOf(r12.readDouble());
        goto L7
    }

    @Override // android.os.Parcelable.Creator
    public final MapTakeTaxiParams[] newArray(int r1) {
        return new MapTakeTaxiParams[r1];
    }
}
