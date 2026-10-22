package com.larus.bmhome.auth;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class DouyinFeedEntrance$a implements Parcelable.Creator<DouyinFeedEntrance> {
    public DouyinFeedEntrance$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final DouyinFeedEntrance createFromParcel(Parcel r5) {
        Intrinsics.checkNotNullParameter(r5, "parcel");
        int r1 = r5.readInt();
        String r2 = r5.readString();
        if (r5.readInt() != 0) goto L5;
        Object r6 = null;
    L7:
        return new DouyinFeedEntrance(r1, r2, (QuotaConfig) r6);
    L5:
        r6 = QuotaConfig.CREATOR.createFromParcel(r5);
        goto L7
    }

    @Override // android.os.Parcelable.Creator
    public final DouyinFeedEntrance[] newArray(int r1) {
        return new DouyinFeedEntrance[r1];
    }
}
