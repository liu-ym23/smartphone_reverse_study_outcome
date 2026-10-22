package com.larus.bmhome.auth;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class FeedItemConfig$a implements Parcelable.Creator<FeedItemConfig> {
    public FeedItemConfig$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final FeedItemConfig createFromParcel(Parcel r4) {
        Intrinsics.checkNotNullParameter(r4, "parcel");
        return new FeedItemConfig(r4.readInt(), r4.readInt(), r4.readInt());
    }

    @Override // android.os.Parcelable.Creator
    public final FeedItemConfig[] newArray(int r1) {
        return new FeedItemConfig[r1];
    }
}
