package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import joa.a;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class PhoneCallParams$a implements Parcelable.Creator<PhoneCallParams> {
    public PhoneCallParams$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final PhoneCallParams createFromParcel(Parcel r9) {
        int r0 = r9.readInt();
        Intrinsics.checkNotNullParameter(r9, "parcel");
        if (r9.readInt() != 0) goto L5;
        Object r2 = null;
    L6:
        PhoneCallParams r1 = new PhoneCallParams((ContactTarget) r2, r9.readString(), null, 4, null);
        int r3 = Math.min(r0, 1);
        ClassLoader r4 = PhoneCallParams$a.class.getClassLoader();
        int r5 = 1;
    L7:
        if (r5 > r3) goto L13;
        if (r5 != 1) goto L12;
        Object r6 = a.c(r9, r4);
        if (r6 == null) goto L12;
        r1.simSlot = (String) r6;
    L12:
        r5 = r5 + 1;
    L13:
        if (r5 > r0) goto L15;
        a.d(r9, r4);
        r5 = r5 + 1;
        goto L13
    L15:
        return r1;
    L5:
        r2 = ContactTarget.CREATOR.createFromParcel(r9);
        goto L6
    }

    @Override // android.os.Parcelable.Creator
    public final PhoneCallParams[] newArray(int r1) {
        return new PhoneCallParams[r1];
    }
}
