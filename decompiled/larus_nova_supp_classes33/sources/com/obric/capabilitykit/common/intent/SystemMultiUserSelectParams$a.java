package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import joa.a;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class SystemMultiUserSelectParams$a implements Parcelable.Creator<SystemMultiUserSelectParams> {
    public SystemMultiUserSelectParams$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final SystemMultiUserSelectParams createFromParcel(Parcel r6) {
        int r0 = r6.readInt();
        Intrinsics.checkNotNullParameter(r6, "parcel");
        SystemMultiUserSelectParams r1 = new SystemMultiUserSelectParams(r6.createStringArray(), r6.readString());
        int r2 = Math.min(r0, 0);
        ClassLoader r3 = SystemMultiUserSelectParams$a.class.getClassLoader();
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
    public final SystemMultiUserSelectParams[] newArray(int r1) {
        return new SystemMultiUserSelectParams[r1];
    }
}
