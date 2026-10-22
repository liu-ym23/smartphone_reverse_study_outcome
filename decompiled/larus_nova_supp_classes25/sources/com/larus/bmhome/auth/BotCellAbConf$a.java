package com.larus.bmhome.auth;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class BotCellAbConf$a implements Parcelable.Creator<BotCellAbConf> {
    public BotCellAbConf$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final BotCellAbConf createFromParcel(Parcel r2) {
        Intrinsics.checkNotNullParameter(r2, "parcel");
        if (r2.readInt() == 0) goto L5;
        boolean r3 = true;
    L7:
        return new BotCellAbConf(r3);
    L5:
        r3 = false;
        goto L7
    }

    @Override // android.os.Parcelable.Creator
    public final BotCellAbConf[] newArray(int r1) {
        return new BotCellAbConf[r1];
    }
}
