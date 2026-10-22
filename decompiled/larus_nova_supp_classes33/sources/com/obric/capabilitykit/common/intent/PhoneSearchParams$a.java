package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import joa.a;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class PhoneSearchParams$a implements Parcelable.Creator<PhoneSearchParams> {
    public PhoneSearchParams$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final PhoneSearchParams createFromParcel(Parcel r14) {
        int r0 = r14.readInt();
        Intrinsics.checkNotNullParameter(r14, "parcel");
        String r3 = r14.readString();
        String r4 = r14.readString();
        String r5 = r14.readString();
        if (r14.readInt() != 0) goto L5;
        Long r7 = null;
    L7:
        if (r14.readInt() != 0) goto L9;
        Long r8 = null;
    L10:
        String r9 = r14.readString();
        String r10 = r14.readString();
        String r11 = r14.readString();
        if (r14.readInt() != 0) goto L13;
        Integer r12 = null;
    L14:
        PhoneSearchParams r1 = new PhoneSearchParams(r3, r4, r5, r7, r8, r9, r10, r11, r12);
        int r2 = Math.min(r0, 0);
        ClassLoader r6 = PhoneSearchParams$a.class.getClassLoader();
        int r13 = 1;
    L15:
        if (r13 > r2) goto L17;
        r13 = r13 + 1;
    L17:
        if (r13 > r0) goto L19;
        a.d(r14, r6);
        r13 = r13 + 1;
        goto L17
    L19:
        return r1;
    L13:
        r12 = Integer.valueOf(r14.readInt());
        goto L14
    L9:
        r8 = Long.valueOf(r14.readLong());
        goto L10
    L5:
        r7 = Long.valueOf(r14.readLong());
        goto L7
    }

    @Override // android.os.Parcelable.Creator
    public final PhoneSearchParams[] newArray(int r1) {
        return new PhoneSearchParams[r1];
    }
}
