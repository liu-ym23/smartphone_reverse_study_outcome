package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import joa.a;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class PCSearchAppEntityParams$a implements Parcelable.Creator<PCSearchAppEntityParams> {
    public PCSearchAppEntityParams$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final PCSearchAppEntityParams createFromParcel(Parcel r9) {
        int r0 = r9.readInt();
        Intrinsics.checkNotNullParameter(r9, "parcel");
        PCSearchAppEntityParams r1 = new PCSearchAppEntityParams(r9.readString(), r9.readString(), null, 4, null);
        int r3 = Math.min(r0, 1);
        ClassLoader r4 = PCSearchAppEntityParams$a.class.getClassLoader();
        int r5 = 1;
    L3:
        if (r5 > r3) goto L9;
        if (r5 != 1) goto L8;
        Object r6 = a.c(r9, r4);
        if (r6 == null) goto L8;
        r1.domains = (String[]) r6;
    L8:
        r5 = r5 + 1;
    L9:
        if (r5 > r0) goto L11;
        a.d(r9, r4);
        r5 = r5 + 1;
        goto L9
    L11:
        return r1;
    }

    @Override // android.os.Parcelable.Creator
    public final PCSearchAppEntityParams[] newArray(int r1) {
        return new PCSearchAppEntityParams[r1];
    }
}
