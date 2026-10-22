package com.larus.bmhome.auth;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class TrendsAbConfig$a implements Parcelable.Creator<TrendsAbConfig> {
    public TrendsAbConfig$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final TrendsAbConfig createFromParcel(Parcel r13) {
        Intrinsics.checkNotNullParameter(r13, "parcel");
        int r2 = 0;
        if (r13.readInt() == 0) goto L5;
        boolean r4 = true;
    L7:
        if (r13.readInt() == 0) goto L9;
        boolean r5 = true;
    L10:
        String r6 = r13.readString();
        if (r13.readInt() == 0) goto L13;
        boolean r7 = true;
    L15:
        if (r13.readInt() == 0) goto L17;
        boolean r8 = true;
    L18:
        int r9 = r13.readInt();
        int r10 = r13.readInt();
        if (r13.readInt() != 0) goto L21;
        ArrayList r11 = null;
    L26:
        return new TrendsAbConfig(r4, r5, r6, r7, r8, r9, r10, r11);
    L21:
        int r0 = r13.readInt();
        ArrayList r1 = new ArrayList(r0);
    L22:
        if (r2 == r0) goto L24;
        r1.add(Integer.valueOf(r13.readInt()));
        r2 = r2 + 1;
        goto L22
    L24:
        r11 = r1;
        goto L26
    L17:
        r8 = false;
        goto L18
    L13:
        r7 = false;
        goto L15
    L9:
        r5 = false;
        goto L10
    L5:
        r4 = false;
        goto L7
    }

    @Override // android.os.Parcelable.Creator
    public final TrendsAbConfig[] newArray(int r1) {
        return new TrendsAbConfig[r1];
    }
}
