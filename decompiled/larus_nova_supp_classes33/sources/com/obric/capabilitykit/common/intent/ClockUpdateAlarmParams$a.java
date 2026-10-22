package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.capabilitykit.entity.app.AlarmEntity;
import joa.a;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class ClockUpdateAlarmParams$a implements Parcelable.Creator<ClockUpdateAlarmParams> {
    public ClockUpdateAlarmParams$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final ClockUpdateAlarmParams createFromParcel(Parcel r15) {
        int r0 = r15.readInt();
        Intrinsics.checkNotNullParameter(r15, "parcel");
        AlarmEntity r3 = r15.readParcelable(ClockUpdateAlarmParams.class.getClassLoader());
        String r4 = r15.readString();
        String r5 = r15.readString();
        boolean r2 = false;
        if (r15.readInt() != 0) goto L5;
        Integer[] r7 = null;
    L9:
        if (r15.readInt() != 0) goto L12;
        Boolean r1 = null;
    L15:
        ClockUpdateAlarmParams r13 = new ClockUpdateAlarmParams(r3, r4, r5, r7, r1, r15.readString(), null, 64, null);
        int r6 = Math.min(r0, 1);
        ClassLoader r8 = ClockUpdateAlarmParams$a.class.getClassLoader();
        int r9 = 1;
    L16:
        if (r9 > r6) goto L22;
        if (r9 != 1) goto L21;
        Object r10 = a.c(r15, r8);
        if (r10 == null) goto L21;
        r13.repeatType = (Integer) r10;
    L21:
        r9 = r9 + 1;
    L22:
        if (r9 > r0) goto L24;
        a.d(r15, r8);
        r9 = r9 + 1;
        goto L22
    L24:
        return r13;
    L12:
        if (r15.readInt() == 0) goto L14;
        r2 = true;
    L14:
        r1 = Boolean.valueOf(r2);
        goto L15
    L5:
        int r11 = r15.readInt();
        r7 = new Integer[r11];
        int r12 = 0;
    L6:
        if (r12 == r11) goto L9;
        r7[r12] = Integer.valueOf(r15.readInt());
        r12 = r12 + 1;
        goto L6
    }

    @Override // android.os.Parcelable.Creator
    public final ClockUpdateAlarmParams[] newArray(int r1) {
        return new ClockUpdateAlarmParams[r1];
    }
}
