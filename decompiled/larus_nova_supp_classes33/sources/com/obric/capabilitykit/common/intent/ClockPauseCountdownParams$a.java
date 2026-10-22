package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.capabilitykit.entity.app.CountdownEntity;
import joa.a;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class ClockPauseCountdownParams$a implements Parcelable.Creator<ClockPauseCountdownParams> {
    public ClockPauseCountdownParams$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final ClockPauseCountdownParams createFromParcel(Parcel r8) {
        int r0 = r8.readInt();
        Intrinsics.checkNotNullParameter(r8, "parcel");
        Boolean r3 = null;
        if (r8.readInt() != 0) goto L5;
        CountdownEntity[] r4 = null;
    L8:
        int r5 = 1;
        if (r8.readInt() != 0) goto L12;
    L16:
        ClockPauseCountdownParams r1 = new ClockPauseCountdownParams(r4, r3);
        int r2 = Math.min(r0, 0);
        ClassLoader r6 = ClockPauseCountdownParams$a.class.getClassLoader();
    L17:
        if (r5 > r2) goto L19;
        r5 = r5 + 1;
    L19:
        if (r5 > r0) goto L21;
        a.d(r8, r6);
        r5 = r5 + 1;
        goto L19
    L21:
        return r1;
    L12:
        if (r8.readInt() == 0) goto L14;
        boolean r7 = true;
    L15:
        r3 = Boolean.valueOf(r7);
        goto L16
    L14:
        r7 = false;
        goto L15
    L5:
        int r9 = r8.readInt();
        r4 = new CountdownEntity[r9];
        int r10 = 0;
    L6:
        if (r10 == r9) goto L8;
        r4[r10] = (CountdownEntity) r8.readParcelable(ClockPauseCountdownParams.class.getClassLoader());
        r10 = r10 + 1;
        goto L6
    }

    @Override // android.os.Parcelable.Creator
    public final ClockPauseCountdownParams[] newArray(int r1) {
        return new ClockPauseCountdownParams[r1];
    }
}
