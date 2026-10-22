package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import joa.a;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class ClockShowAlarmParams$a implements Parcelable.Creator<ClockShowAlarmParams> {
    public ClockShowAlarmParams$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final ClockShowAlarmParams createFromParcel(Parcel r6) {
        int r0 = r6.readInt();
        Intrinsics.checkNotNullParameter(r6, "parcel");
        ClockShowAlarmParams r1 = new ClockShowAlarmParams(r6.readParcelable(ClockShowAlarmParams.class.getClassLoader()));
        int r2 = Math.min(r0, 0);
        ClassLoader r3 = ClockShowAlarmParams$a.class.getClassLoader();
        int r4 = 1;
    L3:
        if (r4 > r2) goto L5;
        r4 = r4 + 1;
    L5:
        if (r4 > r0) goto L7;
        a.d(r6, r3);
        r4 = r4 + 1;
        goto L5
    L7:
        return r1;
    }

    @Override // android.os.Parcelable.Creator
    public final ClockShowAlarmParams[] newArray(int r1) {
        return new ClockShowAlarmParams[r1];
    }
}
