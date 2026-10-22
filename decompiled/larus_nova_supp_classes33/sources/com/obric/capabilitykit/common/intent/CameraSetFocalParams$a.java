package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import joa.a;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class CameraSetFocalParams$a implements Parcelable.Creator<CameraSetFocalParams> {
    public CameraSetFocalParams$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final CameraSetFocalParams createFromParcel(Parcel r6) {
        int r0 = r6.readInt();
        Intrinsics.checkNotNullParameter(r6, "parcel");
        if (r6.readInt() != 0) goto L5;
        Double r2 = null;
    L6:
        CameraSetFocalParams r1 = new CameraSetFocalParams(r2, r6.readString());
        int r3 = Math.min(r0, 0);
        ClassLoader r4 = CameraSetFocalParams$a.class.getClassLoader();
        int r5 = 1;
    L7:
        if (r5 > r3) goto L9;
        r5 = r5 + 1;
    L9:
        if (r5 > r0) goto L11;
        a.d(r6, r4);
        r5 = r5 + 1;
        goto L9
    L11:
        return r1;
    L5:
        r2 = Double.valueOf(r6.readDouble());
        goto L6
    }

    @Override // android.os.Parcelable.Creator
    public final CameraSetFocalParams[] newArray(int r1) {
        return new CameraSetFocalParams[r1];
    }
}
