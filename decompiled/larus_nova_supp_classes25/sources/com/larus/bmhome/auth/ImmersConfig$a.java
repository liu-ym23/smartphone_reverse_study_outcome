package com.larus.bmhome.auth;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class ImmersConfig$a implements Parcelable.Creator<ImmersConfig> {
    public ImmersConfig$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final ImmersConfig createFromParcel(Parcel r7) {
        Intrinsics.checkNotNullParameter(r7, "parcel");
        String r1 = r7.readString();
        boolean r3 = false;
        if (r7.readInt() == 0) goto L5;
        boolean r2 = true;
    L7:
        if (r7.readInt() == 0) goto L9;
        boolean r5 = true;
    L11:
        if (r7.readInt() == 0) goto L14;
        r3 = true;
    L14:
        return new ImmersConfig(r1, r2, r5, r3);
    L9:
        r5 = false;
        goto L11
    L5:
        r2 = false;
        goto L7
    }

    @Override // android.os.Parcelable.Creator
    public final ImmersConfig[] newArray(int r1) {
        return new ImmersConfig[r1];
    }
}
