package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import joa.a;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class SystemUserAuthorizeParams$a implements Parcelable.Creator<SystemUserAuthorizeParams> {
    public SystemUserAuthorizeParams$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final SystemUserAuthorizeParams createFromParcel(Parcel r8) {
        int r0 = r8.readInt();
        Intrinsics.checkNotNullParameter(r8, "parcel");
        SystemUserAuthorizeParams r1 = new SystemUserAuthorizeParams(null, 1, null);
        int r2 = Math.min(r0, 1);
        ClassLoader r4 = SystemUserAuthorizeParams$a.class.getClassLoader();
        int r5 = 1;
    L3:
        if (r5 > r2) goto L9;
        if (r5 != 1) goto L8;
        Object r6 = a.c(r8, r4);
        if (r6 == null) goto L8;
        r1.scene = (String) r6;
    L8:
        r5 = r5 + 1;
    L9:
        if (r5 > r0) goto L11;
        a.d(r8, r4);
        r5 = r5 + 1;
        goto L9
    L11:
        return r1;
    }

    @Override // android.os.Parcelable.Creator
    public final SystemUserAuthorizeParams[] newArray(int r1) {
        return new SystemUserAuthorizeParams[r1];
    }
}
