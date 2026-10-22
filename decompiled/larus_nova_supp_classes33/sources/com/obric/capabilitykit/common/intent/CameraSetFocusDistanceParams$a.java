package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import joa.a;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class CameraSetFocusDistanceParams$a implements Parcelable.Creator<CameraSetFocusDistanceParams> {
    public CameraSetFocusDistanceParams$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final CameraSetFocusDistanceParams createFromParcel(Parcel r6) {
        int r0 = r6.readInt();
        Intrinsics.checkNotNullParameter(r6, "parcel");
        if (r6.readInt() != 0) goto L5;
        Integer r2 = null;
    L6:
        CameraSetFocusDistanceParams r1 = new CameraSetFocusDistanceParams(r2, r6.readString());
        int r3 = Math.min(r0, 0);
        ClassLoader r4 = CameraSetFocusDistanceParams$a.class.getClassLoader();
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
        r2 = Integer.valueOf(r6.readInt());
        goto L6
    }

    @Override // android.os.Parcelable.Creator
    public final CameraSetFocusDistanceParams[] newArray(int r1) {
        return new CameraSetFocusDistanceParams[r1];
    }
}
