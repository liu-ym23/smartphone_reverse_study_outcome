package com.obric.aiagent.assistant.idl.bean;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class ObricMemoryDataCollectConfig$a implements Parcelable.Creator<ObricMemoryDataCollectConfig> {
    public ObricMemoryDataCollectConfig$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final ObricMemoryDataCollectConfig createFromParcel(Parcel r3) {
        Intrinsics.checkNotNullParameter(r3, "parcel");
        if (r3.readInt() != 0) goto L6;
        Boolean r4 = null;
    L11:
        return new ObricMemoryDataCollectConfig(r4);
    L6:
        if (r3.readInt() == 0) goto L8;
        boolean r5 = true;
    L9:
        r4 = Boolean.valueOf(r5);
        goto L11
    L8:
        r5 = false;
        goto L9
    }

    @Override // android.os.Parcelable.Creator
    public final ObricMemoryDataCollectConfig[] newArray(int r1) {
        return new ObricMemoryDataCollectConfig[r1];
    }
}
