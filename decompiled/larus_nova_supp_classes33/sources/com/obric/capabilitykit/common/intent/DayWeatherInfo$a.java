package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import joa.a;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class DayWeatherInfo$a implements Parcelable.Creator<DayWeatherInfo> {
    public DayWeatherInfo$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final DayWeatherInfo createFromParcel(Parcel r11) {
        int r0 = r11.readInt();
        Intrinsics.checkNotNullParameter(r11, "parcel");
        String r3 = r11.readString();
        if (r11.readInt() != 0) goto L5;
        Integer r5 = null;
    L7:
        if (r11.readInt() != 0) goto L9;
        Integer r6 = null;
    L10:
        DayWeatherInfo r1 = new DayWeatherInfo(r3, r5, r6, r11.readString(), r11.readString(), r11.readString());
        int r2 = Math.min(r0, 0);
        ClassLoader r4 = DayWeatherInfo$a.class.getClassLoader();
        int r7 = 1;
    L11:
        if (r7 > r2) goto L13;
        r7 = r7 + 1;
    L13:
        if (r7 > r0) goto L15;
        a.d(r11, r4);
        r7 = r7 + 1;
        goto L13
    L15:
        return r1;
    L9:
        r6 = Integer.valueOf(r11.readInt());
        goto L10
    L5:
        r5 = Integer.valueOf(r11.readInt());
        goto L7
    }

    @Override // android.os.Parcelable.Creator
    public final DayWeatherInfo[] newArray(int r1) {
        return new DayWeatherInfo[r1];
    }
}
