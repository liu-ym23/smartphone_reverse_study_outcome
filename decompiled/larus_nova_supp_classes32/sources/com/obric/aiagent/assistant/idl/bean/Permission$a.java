package com.obric.aiagent.assistant.idl.bean;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class Permission$a implements Parcelable.Creator<Permission> {
    public Permission$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final Permission createFromParcel(Parcel r7) {
        Intrinsics.checkNotNullParameter(r7, "parcel");
        String r1 = r7.readString();
        Integer r3 = null;
        if (r7.readInt() != 0) goto L6;
        Boolean r2 = null;
    L10:
        String r4 = r7.readString();
        if (r7.readInt() == 0) goto L15;
        r3 = Integer.valueOf(r7.readInt());
    L15:
        return new Permission(r1, r2, r4, r3);
    L6:
        if (r7.readInt() == 0) goto L8;
        boolean r5 = true;
    L9:
        r2 = Boolean.valueOf(r5);
        goto L10
    L8:
        r5 = false;
        goto L9
    }

    @Override // android.os.Parcelable.Creator
    public final Permission[] newArray(int r1) {
        return new Permission[r1];
    }
}
