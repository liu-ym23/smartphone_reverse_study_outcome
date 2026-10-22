package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import joa.a;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class SystemScreenshotParams$a implements Parcelable.Creator<SystemScreenshotParams> {
    public SystemScreenshotParams$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final SystemScreenshotParams createFromParcel(Parcel r6) {
        int r0 = r6.readInt();
        Intrinsics.checkNotNullParameter(r6, "parcel");
        String r2 = r6.readString();
        if (r6.readInt() != 0) goto L5;
        Integer r3 = null;
    L6:
        SystemScreenshotParams r1 = new SystemScreenshotParams(r2, r3);
        int r4 = Math.min(r0, 0);
        ClassLoader r5 = SystemScreenshotParams$a.class.getClassLoader();
        int r7 = 1;
    L7:
        if (r7 > r4) goto L9;
        r7 = r7 + 1;
    L9:
        if (r7 > r0) goto L11;
        a.d(r6, r5);
        r7 = r7 + 1;
        goto L9
    L11:
        return r1;
    L5:
        r3 = Integer.valueOf(r6.readInt());
        goto L6
    }

    @Override // android.os.Parcelable.Creator
    public final SystemScreenshotParams[] newArray(int r1) {
        return new SystemScreenshotParams[r1];
    }
}
