package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import joa.a;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class CameraSetAuxiliaryLineParams$a implements Parcelable.Creator<CameraSetAuxiliaryLineParams> {
    public CameraSetAuxiliaryLineParams$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final CameraSetAuxiliaryLineParams createFromParcel(Parcel r7) {
        int r0 = r7.readInt();
        Intrinsics.checkNotNullParameter(r7, "parcel");
        int r4 = 1;
        if (r7.readInt() != 0) goto L6;
        Boolean r2 = null;
    L10:
        CameraSetAuxiliaryLineParams r1 = new CameraSetAuxiliaryLineParams(r2, r7.readString());
        int r3 = Math.min(r0, 0);
        ClassLoader r5 = CameraSetAuxiliaryLineParams$a.class.getClassLoader();
    L11:
        if (r4 > r3) goto L13;
        r4 = r4 + 1;
    L13:
        if (r4 > r0) goto L15;
        a.d(r7, r5);
        r4 = r4 + 1;
        goto L13
    L15:
        return r1;
    L6:
        if (r7.readInt() == 0) goto L8;
        boolean r6 = true;
    L9:
        r2 = Boolean.valueOf(r6);
        goto L10
    L8:
        r6 = false;
        goto L9
    }

    @Override // android.os.Parcelable.Creator
    public final CameraSetAuxiliaryLineParams[] newArray(int r1) {
        return new CameraSetAuxiliaryLineParams[r1];
    }
}
