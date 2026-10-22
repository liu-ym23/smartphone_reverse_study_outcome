package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import joa.a;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class RecorderOperateParams$a implements Parcelable.Creator<RecorderOperateParams> {
    public RecorderOperateParams$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final RecorderOperateParams createFromParcel(Parcel r9) {
        int r0 = r9.readInt();
        Intrinsics.checkNotNullParameter(r9, "parcel");
        RecorderOperateParams r1 = new RecorderOperateParams(r9.readString(), null, null, 6, null);
        int r3 = Math.min(r0, 2);
        ClassLoader r4 = RecorderOperateParams$a.class.getClassLoader();
        int r6 = 1;
    L3:
        if (r6 > r3) goto L13;
        if (r6 != 1) goto L8;
        Object r7 = a.c(r9, r4);
        if (r7 == null) goto L12;
        r1.doraBluetoothId = (String) r7;
    L12:
        r6 = r6 + 1;
        goto L3
    L8:
        if (r6 != 2) goto L12;
        Object r8 = a.c(r9, r4);
        if (r8 == null) goto L12;
        r1.doraProductId = (String) r8;
    L13:
        if (r6 > r0) goto L15;
        a.d(r9, r4);
        r6 = r6 + 1;
        goto L13
    L15:
        return r1;
    }

    @Override // android.os.Parcelable.Creator
    public final RecorderOperateParams[] newArray(int r1) {
        return new RecorderOperateParams[r1];
    }
}
