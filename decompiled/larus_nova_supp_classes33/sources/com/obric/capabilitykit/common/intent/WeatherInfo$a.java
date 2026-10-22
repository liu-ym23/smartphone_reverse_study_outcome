package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import joa.a;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class WeatherInfo$a implements Parcelable.Creator<WeatherInfo> {
    public WeatherInfo$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final WeatherInfo createFromParcel(Parcel r22) {
        int r1 = r22.readInt();
        Intrinsics.checkNotNullParameter(r22, "parcel");
        String r4 = r22.readString();
        String r5 = r22.readString();
        if (r22.readInt() != 0) goto L5;
        Double r6 = null;
    L7:
        if (r22.readInt() != 0) goto L9;
        Integer r7 = null;
    L10:
        String r8 = r22.readString();
        if (r22.readInt() != 0) goto L13;
        Integer r9 = null;
    L15:
        if (r22.readInt() != 0) goto L17;
        Integer r10 = null;
    L19:
        if (r22.readInt() != 0) goto L21;
        Integer r11 = null;
    L23:
        if (r22.readInt() != 0) goto L25;
        Integer r12 = null;
    L27:
        if (r22.readInt() != 0) goto L29;
        Integer r13 = null;
    L31:
        if (r22.readInt() != 0) goto L33;
        Integer r14 = null;
    L34:
        String r15 = r22.readString();
        if (r22.readInt() != 0) goto L37;
        ArrayList r2 = null;
    L42:
        if (r22.readInt() != 0) goto L44;
        ArrayList r17 = null;
    L48:
        WeatherInfo r3 = new WeatherInfo(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r2, r17, r22.readString(), r22.readString());
        int r16 = Math.min(r1, 0);
        ClassLoader r18 = WeatherInfo$a.class.getClassLoader();
        int r19 = 1;
    L49:
        if (r19 > r16) goto L51;
        r19 = r19 + 1;
    L51:
        if (r19 > r1) goto L53;
        a.d(r22, r18);
        r19 = r19 + 1;
        goto L51
    L53:
        return r3;
    L44:
        int r20 = r22.readInt();
        ArrayList r21 = new ArrayList(r20);
        int r23 = 0;
    L45:
        if (r23 == r20) goto L47;
        int r110 = r20;
        r21.add(DayWeatherInfo.CREATOR.createFromParcel(r22));
        r23 = r23 + 1;
        r20 = r110;
        goto L45
    L47:
        r17 = r21;
        goto L48
    L37:
        int r24 = r22.readInt();
        ArrayList r25 = new ArrayList(r24);
        int r26 = 0;
    L38:
        if (r26 == r24) goto L40;
        int r111 = r24;
        r25.add(HourWeatherInfo.CREATOR.createFromParcel(r22));
        r26 = r26 + 1;
        r24 = r111;
        goto L38
    L40:
        r2 = r25;
        goto L42
    L33:
        r14 = Integer.valueOf(r22.readInt());
        goto L34
    L29:
        r13 = Integer.valueOf(r22.readInt());
        goto L31
    L25:
        r12 = Integer.valueOf(r22.readInt());
        goto L27
    L21:
        r11 = Integer.valueOf(r22.readInt());
        goto L23
    L17:
        r10 = Integer.valueOf(r22.readInt());
        goto L19
    L13:
        r9 = Integer.valueOf(r22.readInt());
        goto L15
    L9:
        r7 = Integer.valueOf(r22.readInt());
        goto L10
    L5:
        r6 = Double.valueOf(r22.readDouble());
        goto L7
    }

    @Override // android.os.Parcelable.Creator
    public final WeatherInfo[] newArray(int r1) {
        return new WeatherInfo[r1];
    }
}
