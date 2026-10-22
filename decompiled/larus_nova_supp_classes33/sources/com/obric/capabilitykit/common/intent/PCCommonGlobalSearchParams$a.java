package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import joa.a;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class PCCommonGlobalSearchParams$a implements Parcelable.Creator<PCCommonGlobalSearchParams> {
    public PCCommonGlobalSearchParams$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final PCCommonGlobalSearchParams createFromParcel(Parcel r10) {
        int r0 = r10.readInt();
        Intrinsics.checkNotNullParameter(r10, "parcel");
        PCCommonGlobalSearchParams r1 = new PCCommonGlobalSearchParams(r10.readString(), r10.readString(), r10.readString(), null, 8, null);
        int r3 = Math.min(r0, 1);
        ClassLoader r4 = PCCommonGlobalSearchParams$a.class.getClassLoader();
        int r5 = 1;
    L3:
        if (r5 > r3) goto L9;
        if (r5 != 1) goto L8;
        Object r6 = a.c(r10, r4);
        if (r6 == null) goto L8;
        r1.memoryScene = (String) r6;
    L8:
        r5 = r5 + 1;
    L9:
        if (r5 > r0) goto L11;
        a.d(r10, r4);
        r5 = r5 + 1;
        goto L9
    L11:
        return r1;
    }

    @Override // android.os.Parcelable.Creator
    public final PCCommonGlobalSearchParams[] newArray(int r1) {
        return new PCCommonGlobalSearchParams[r1];
    }
}
