package com.obric.aiagent.assistant.idl.bean;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class Authentication$a implements Parcelable.Creator<Authentication> {
    public Authentication$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final Authentication createFromParcel(Parcel r4) {
        Intrinsics.checkNotNullParameter(r4, "parcel");
        if (r4.readInt() == 0) goto L5;
        boolean r1 = true;
    L7:
        if (r4.readInt() != 0) goto L9;
        Integer r5 = null;
    L11:
        return new Authentication(r1, r5);
    L9:
        r5 = Integer.valueOf(r4.readInt());
        goto L11
    L5:
        r1 = false;
        goto L7
    }

    @Override // android.os.Parcelable.Creator
    public final Authentication[] newArray(int r1) {
        return new Authentication[r1];
    }
}
