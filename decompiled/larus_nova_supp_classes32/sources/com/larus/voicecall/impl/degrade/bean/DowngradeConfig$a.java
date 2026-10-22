package com.larus.voicecall.impl.degrade.bean;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class DowngradeConfig$a implements Parcelable.Creator<DowngradeConfig> {
    public DowngradeConfig$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final DowngradeConfig createFromParcel(Parcel r10) {
        Intrinsics.checkNotNullParameter(r10, "parcel");
        String r2 = r10.readString();
        ArrayList<String> r3 = r10.createStringArrayList();
        LinkedHashMap r1 = null;
        if (r10.readInt() != 0) goto L5;
        Object r0 = null;
    L6:
        TimeConfig r4 = (TimeConfig) r0;
        int r5 = 0;
        if (r10.readInt() != 0) goto L9;
        ArrayList r6 = null;
    L13:
        if (r10.readInt() == 0) goto L19;
        int r7 = r10.readInt();
        r1 = new LinkedHashMap(r7);
    L16:
        if (r5 == r7) goto L19;
        r1.put(r10.readString(), r10.readString());
        r5 = r5 + 1;
    L19:
        return new DowngradeConfig(r2, r3, r4, r6, r1);
    L9:
        int r8 = r10.readInt();
        r6 = new ArrayList(r8);
        int r9 = 0;
    L10:
        if (r9 == r8) goto L13;
        r6.add(Entrance.CREATOR.createFromParcel(r10));
        r9 = r9 + 1;
        goto L10
    L5:
        r0 = TimeConfig.CREATOR.createFromParcel(r10);
        goto L6
    }

    @Override // android.os.Parcelable.Creator
    public final DowngradeConfig[] newArray(int r1) {
        return new DowngradeConfig[r1];
    }
}
