package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import joa.a;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class SystemScreenRecordParams$a implements Parcelable.Creator<SystemScreenRecordParams> {
    public SystemScreenRecordParams$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final SystemScreenRecordParams createFromParcel(Parcel r6) {
        int r0 = r6.readInt();
        Intrinsics.checkNotNullParameter(r6, "parcel");
        int r4 = 1;
        if (r6.readInt() != 0) goto L6;
        Boolean r2 = null;
    L10:
        SystemScreenRecordParams r1 = new SystemScreenRecordParams(r2);
        int r3 = Math.min(r0, 0);
        ClassLoader r5 = SystemScreenRecordParams$a.class.getClassLoader();
    L11:
        if (r4 > r3) goto L13;
        r4 = r4 + 1;
    L13:
        if (r4 > r0) goto L15;
        a.d(r6, r5);
        r4 = r4 + 1;
        goto L13
    L15:
        return r1;
    L6:
        if (r6.readInt() == 0) goto L8;
        boolean r7 = true;
    L9:
        r2 = Boolean.valueOf(r7);
        goto L10
    L8:
        r7 = false;
        goto L9
    }

    @Override // android.os.Parcelable.Creator
    public final SystemScreenRecordParams[] newArray(int r1) {
        return new SystemScreenRecordParams[r1];
    }
}
