package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import joa.a;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class ClockCreateAlarmParams$a implements Parcelable.Creator<ClockCreateAlarmParams> {
    public ClockCreateAlarmParams$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final ClockCreateAlarmParams createFromParcel(Parcel r14) {
        int r0 = r14.readInt();
        Intrinsics.checkNotNullParameter(r14, "parcel");
        String r3 = r14.readString();
        String r4 = r14.readString();
        boolean r2 = false;
        if (r14.readInt() != 0) goto L5;
        Integer[] r6 = null;
    L9:
        if (r14.readInt() != 0) goto L12;
        Boolean r1 = null;
    L15:
        ClockCreateAlarmParams r12 = new ClockCreateAlarmParams(r3, r4, r6, r1, r14.readString(), null, 32, null);
        int r5 = Math.min(r0, 1);
        ClassLoader r7 = ClockCreateAlarmParams$a.class.getClassLoader();
        int r8 = 1;
    L16:
        if (r8 > r5) goto L22;
        if (r8 != 1) goto L21;
        Object r9 = a.c(r14, r7);
        if (r9 == null) goto L21;
        r12.repeatType = (Integer) r9;
    L21:
        r8 = r8 + 1;
    L22:
        if (r8 > r0) goto L24;
        a.d(r14, r7);
        r8 = r8 + 1;
        goto L22
    L24:
        return r12;
    L12:
        if (r14.readInt() == 0) goto L14;
        r2 = true;
    L14:
        r1 = Boolean.valueOf(r2);
        goto L15
    L5:
        int r10 = r14.readInt();
        r6 = new Integer[r10];
        int r11 = 0;
    L6:
        if (r11 == r10) goto L9;
        r6[r11] = Integer.valueOf(r14.readInt());
        r11 = r11 + 1;
        goto L6
    }

    @Override // android.os.Parcelable.Creator
    public final ClockCreateAlarmParams[] newArray(int r1) {
        return new ClockCreateAlarmParams[r1];
    }
}
