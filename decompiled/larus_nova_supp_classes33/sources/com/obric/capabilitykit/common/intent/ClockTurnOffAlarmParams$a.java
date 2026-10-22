package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.capabilitykit.entity.app.AlarmEntity;
import joa.a;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class ClockTurnOffAlarmParams$a implements Parcelable.Creator<ClockTurnOffAlarmParams> {
    public ClockTurnOffAlarmParams$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final ClockTurnOffAlarmParams createFromParcel(Parcel r8) {
        int r0 = r8.readInt();
        Intrinsics.checkNotNullParameter(r8, "parcel");
        Boolean r3 = null;
        if (r8.readInt() != 0) goto L5;
        AlarmEntity[] r4 = null;
    L8:
        int r5 = 1;
        if (r8.readInt() != 0) goto L12;
        Boolean r1 = null;
    L17:
        if (r8.readInt() != 0) goto L20;
    L24:
        ClockTurnOffAlarmParams r6 = new ClockTurnOffAlarmParams(r4, r1, r3);
        int r2 = Math.min(r0, 0);
        ClassLoader r7 = ClockTurnOffAlarmParams$a.class.getClassLoader();
    L25:
        if (r5 > r2) goto L27;
        r5 = r5 + 1;
    L27:
        if (r5 > r0) goto L29;
        a.d(r8, r7);
        r5 = r5 + 1;
        goto L27
    L29:
        return r6;
    L20:
        if (r8.readInt() == 0) goto L22;
        boolean r9 = true;
    L23:
        r3 = Boolean.valueOf(r9);
        goto L24
    L22:
        r9 = false;
        goto L23
    L12:
        if (r8.readInt() == 0) goto L14;
        boolean r10 = true;
    L15:
        r1 = Boolean.valueOf(r10);
        goto L17
    L14:
        r10 = false;
        goto L15
    L5:
        int r11 = r8.readInt();
        r4 = new AlarmEntity[r11];
        int r12 = 0;
    L6:
        if (r12 == r11) goto L8;
        r4[r12] = (AlarmEntity) r8.readParcelable(ClockTurnOffAlarmParams.class.getClassLoader());
        r12 = r12 + 1;
        goto L6
    }

    @Override // android.os.Parcelable.Creator
    public final ClockTurnOffAlarmParams[] newArray(int r1) {
        return new ClockTurnOffAlarmParams[r1];
    }
}
