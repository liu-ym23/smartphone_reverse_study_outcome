package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import joa.a;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class PhoneProxyCallParams$a implements Parcelable.Creator<PhoneProxyCallParams> {
    public PhoneProxyCallParams$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final PhoneProxyCallParams createFromParcel(Parcel r13) {
        int r0 = r13.readInt();
        Intrinsics.checkNotNullParameter(r13, "parcel");
        int r11 = 1;
        if (r13.readInt() != 0) goto L7;
        Boolean r2 = null;
    L5:
        Boolean r3 = r2;
        PhoneProxyCallParams r1 = new PhoneProxyCallParams(r3, r13.createStringArray(), r13.readString(), r13.readString(), r13.readString(), r13.readString(), r13.readString());
        int r4 = Math.min(r0, 0);
        ClassLoader r5 = PhoneProxyCallParams$a.class.getClassLoader();
    L12:
        if (r11 > r4) goto L14;
        r11 = r11 + 1;
    L14:
        if (r11 > r0) goto L16;
        a.d(r13, r5);
        r11 = r11 + 1;
        goto L14
    L16:
        return r1;
    L7:
        if (r13.readInt() == 0) goto L9;
        boolean r6 = true;
    L10:
        r2 = Boolean.valueOf(r6);
        goto L5
    L9:
        r6 = false;
        goto L10
    }

    @Override // android.os.Parcelable.Creator
    public final PhoneProxyCallParams[] newArray(int r1) {
        return new PhoneProxyCallParams[r1];
    }
}
