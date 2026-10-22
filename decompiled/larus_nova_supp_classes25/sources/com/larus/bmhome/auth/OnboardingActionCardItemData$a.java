package com.larus.bmhome.auth;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class OnboardingActionCardItemData$a implements Parcelable.Creator<OnboardingActionCardItemData> {
    public OnboardingActionCardItemData$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final OnboardingActionCardItemData createFromParcel(Parcel r17) {
        Intrinsics.checkNotNullParameter(r17, "parcel");
        if (r17.readInt() != 0) goto L5;
        Integer r2 = null;
    L7:
        if (r17.readInt() != 0) goto L9;
        Long r4 = null;
    L10:
        String r5 = r17.readString();
        String r6 = r17.readString();
        String r7 = r17.readString();
        String r8 = r17.readString();
        String r9 = r17.readString();
        String r10 = r17.readString();
        String r11 = r17.readString();
        String r12 = r17.readString();
        String r13 = r17.readString();
        if (r17.readInt() != 0) goto L13;
        Integer r14 = null;
    L15:
        if (r17.readInt() != 0) goto L17;
        Integer r15 = null;
    L19:
        return new OnboardingActionCardItemData(r2, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15);
    L17:
        r15 = Integer.valueOf(r17.readInt());
        goto L19
    L13:
        r14 = Integer.valueOf(r17.readInt());
        goto L15
    L9:
        r4 = Long.valueOf(r17.readLong());
        goto L10
    L5:
        r2 = Integer.valueOf(r17.readInt());
        goto L7
    }

    @Override // android.os.Parcelable.Creator
    public final OnboardingActionCardItemData[] newArray(int r1) {
        return new OnboardingActionCardItemData[r1];
    }
}
