package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import joa.a;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class SystemHeartBeatParams$a implements Parcelable.Creator<SystemHeartBeatParams> {
    public SystemHeartBeatParams$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final SystemHeartBeatParams createFromParcel(Parcel r8) {
        int r0 = r8.readInt();
        Intrinsics.checkNotNullParameter(r8, "parcel");
        String r2 = r8.readString();
        Long r4 = null;
        if (r8.readInt() != 0) goto L5;
        Long r3 = null;
    L7:
        if (r8.readInt() == 0) goto L10;
        r4 = Long.valueOf(r8.readLong());
    L10:
        SystemHeartBeatParams r1 = new SystemHeartBeatParams(r2, r3, r4, r8.readString());
        int r5 = Math.min(r0, 0);
        ClassLoader r6 = SystemHeartBeatParams$a.class.getClassLoader();
        int r7 = 1;
    L11:
        if (r7 > r5) goto L13;
        r7 = r7 + 1;
    L13:
        if (r7 > r0) goto L15;
        a.d(r8, r6);
        r7 = r7 + 1;
        goto L13
    L15:
        return r1;
    L5:
        r3 = Long.valueOf(r8.readLong());
        goto L7
    }

    @Override // android.os.Parcelable.Creator
    public final SystemHeartBeatParams[] newArray(int r1) {
        return new SystemHeartBeatParams[r1];
    }
}
