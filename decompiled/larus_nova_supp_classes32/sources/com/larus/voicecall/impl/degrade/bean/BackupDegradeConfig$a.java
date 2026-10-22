package com.larus.voicecall.impl.degrade.bean;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class BackupDegradeConfig$a implements Parcelable.Creator<BackupDegradeConfig> {
    public BackupDegradeConfig$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final BackupDegradeConfig createFromParcel(Parcel r11) {
        Intrinsics.checkNotNullParameter(r11, "parcel");
        if (r11.readInt() != 0) goto L5;
        ArrayList r5 = null;
    L14:
        return new BackupDegradeConfig(r5, r11.readLong(), r11.readLong());
    L5:
        int r0 = r11.readInt();
        ArrayList r2 = new ArrayList(r0);
        int r3 = 0;
    L6:
        if (r3 == r0) goto L12;
        if (r11.readInt() != 0) goto L10;
        Object r4 = null;
    L11:
        r2.add(r4);
        r3 = r3 + 1;
        goto L6
    L10:
        r4 = DowngradeConfig.CREATOR.createFromParcel(r11);
        goto L11
    L12:
        r5 = r2;
        goto L14
    }

    @Override // android.os.Parcelable.Creator
    public final BackupDegradeConfig[] newArray(int r1) {
        return new BackupDegradeConfig[r1];
    }
}
