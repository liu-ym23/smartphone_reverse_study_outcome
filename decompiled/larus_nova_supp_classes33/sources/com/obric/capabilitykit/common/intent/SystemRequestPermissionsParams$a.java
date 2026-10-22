package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import joa.a;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class SystemRequestPermissionsParams$a implements Parcelable.Creator<SystemRequestPermissionsParams> {
    public SystemRequestPermissionsParams$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final SystemRequestPermissionsParams createFromParcel(Parcel r10) {
        int r0 = r10.readInt();
        Intrinsics.checkNotNullParameter(r10, "parcel");
        String r1 = r10.readString();
        String r2 = r10.readString();
        Permission[] r5 = null;
        if (r10.readInt() != 0) goto L5;
        Options[] r6 = null;
    L9:
        if (r10.readInt() == 0) goto L14;
        int r3 = r10.readInt();
        r5 = new Permission[r3];
        int r7 = 0;
    L12:
        if (r7 == r3) goto L14;
        r5[r7] = Permission.CREATOR.createFromParcel(r10);
        r7 = r7 + 1;
    L14:
        SystemRequestPermissionsParams r4 = new SystemRequestPermissionsParams(r1, r2, r6, r5);
        int r8 = Math.min(r0, 0);
        ClassLoader r9 = SystemRequestPermissionsParams$a.class.getClassLoader();
        int r11 = 1;
    L15:
        if (r11 > r8) goto L17;
        r11 = r11 + 1;
    L17:
        if (r11 > r0) goto L19;
        a.d(r10, r9);
        r11 = r11 + 1;
        goto L17
    L19:
        return r4;
    L5:
        int r12 = r10.readInt();
        r6 = new Options[r12];
        int r13 = 0;
    L6:
        if (r13 == r12) goto L9;
        r6[r13] = Options.CREATOR.createFromParcel(r10);
        r13 = r13 + 1;
        goto L6
    }

    @Override // android.os.Parcelable.Creator
    public final SystemRequestPermissionsParams[] newArray(int r1) {
        return new SystemRequestPermissionsParams[r1];
    }
}
