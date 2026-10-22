package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import joa.a;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class SystemUserRemindParams$a implements Parcelable.Creator<SystemUserRemindParams> {
    public SystemUserRemindParams$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final SystemUserRemindParams createFromParcel(Parcel r8) {
        int r0 = r8.readInt();
        Intrinsics.checkNotNullParameter(r8, "parcel");
        if (r8.readInt() != 0) goto L5;
        Options[] r1 = null;
    L9:
        SystemUserRemindParams r6 = new SystemUserRemindParams(r1, r8.readString(), r8.readString(), r8.createStringArray());
        int r2 = Math.min(r0, 0);
        ClassLoader r3 = SystemUserRemindParams$a.class.getClassLoader();
        int r4 = 1;
    L10:
        if (r4 > r2) goto L12;
        r4 = r4 + 1;
    L12:
        if (r4 > r0) goto L14;
        a.d(r8, r3);
        r4 = r4 + 1;
        goto L12
    L14:
        return r6;
    L5:
        int r5 = r8.readInt();
        Options[] r7 = new Options[r5];
        int r9 = 0;
    L6:
        if (r9 == r5) goto L8;
        r7[r9] = Options.CREATOR.createFromParcel(r8);
        r9 = r9 + 1;
        goto L6
    L8:
        r1 = r7;
        goto L9
    }

    @Override // android.os.Parcelable.Creator
    public final SystemUserRemindParams[] newArray(int r1) {
        return new SystemUserRemindParams[r1];
    }
}
