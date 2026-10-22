package com.larus.bmhome.auth;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class SubConvFirstMet$a implements Parcelable.Creator<SubConvFirstMet> {
    public SubConvFirstMet$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final SubConvFirstMet createFromParcel(Parcel r8) {
        Intrinsics.checkNotNullParameter(r8, "parcel");
        int r0 = r8.readInt();
        String r1 = r8.readString();
        ArrayList r3 = null;
        if (r8.readInt() == 0) goto L14;
        int r2 = r8.readInt();
        ArrayList r4 = new ArrayList(r2);
        int r5 = 0;
    L6:
        if (r5 == r2) goto L12;
        if (r8.readInt() != 0) goto L10;
        Object r6 = null;
    L11:
        r4.add(r6);
        r5 = r5 + 1;
        goto L6
    L10:
        r6 = OnboardingActionCardItemData.CREATOR.createFromParcel(r8);
        goto L11
    L12:
        r3 = r4;
    L14:
        return new SubConvFirstMet(r0, r1, r3);
    }

    @Override // android.os.Parcelable.Creator
    public final SubConvFirstMet[] newArray(int r1) {
        return new SubConvFirstMet[r1];
    }
}
