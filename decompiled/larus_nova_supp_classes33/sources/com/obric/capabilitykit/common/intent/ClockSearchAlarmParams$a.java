package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import joa.a;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class ClockSearchAlarmParams$a implements Parcelable.Creator<ClockSearchAlarmParams> {
    public ClockSearchAlarmParams$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final ClockSearchAlarmParams createFromParcel(Parcel r12) {
        int r0 = r12.readInt();
        Intrinsics.checkNotNullParameter(r12, "parcel");
        String r3 = r12.readString();
        if (r12.readInt() != 0) goto L5;
        Long r5 = null;
    L7:
        if (r12.readInt() != 0) goto L9;
        Long r6 = null;
    L10:
        String r7 = r12.readString();
        String r8 = r12.readString();
        String r9 = r12.readString();
        if (r12.readInt() != 0) goto L13;
        Integer r10 = null;
    L14:
        ClockSearchAlarmParams r1 = new ClockSearchAlarmParams(r3, r5, r6, r7, r8, r9, r10);
        int r2 = Math.min(r0, 0);
        ClassLoader r4 = ClockSearchAlarmParams$a.class.getClassLoader();
        int r11 = 1;
    L15:
        if (r11 > r2) goto L17;
        r11 = r11 + 1;
    L17:
        if (r11 > r0) goto L19;
        a.d(r12, r4);
        r11 = r11 + 1;
        goto L17
    L19:
        return r1;
    L13:
        r10 = Integer.valueOf(r12.readInt());
        goto L14
    L9:
        r6 = Long.valueOf(r12.readLong());
        goto L10
    L5:
        r5 = Long.valueOf(r12.readLong());
        goto L7
    }

    @Override // android.os.Parcelable.Creator
    public final ClockSearchAlarmParams[] newArray(int r1) {
        return new ClockSearchAlarmParams[r1];
    }
}
