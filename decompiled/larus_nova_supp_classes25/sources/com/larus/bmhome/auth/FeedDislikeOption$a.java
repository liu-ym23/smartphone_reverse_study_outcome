package com.larus.bmhome.auth;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class FeedDislikeOption$a implements Parcelable.Creator<FeedDislikeOption> {
    public FeedDislikeOption$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final FeedDislikeOption createFromParcel(Parcel r5) {
        Intrinsics.checkNotNullParameter(r5, "parcel");
        String r1 = r5.readString();
        String r2 = r5.readString();
        if (r5.readInt() != 0) goto L5;
        Object r6 = null;
    L7:
        return new FeedDislikeOption(r1, r2, (AlertConfig) r6);
    L5:
        r6 = AlertConfig.CREATOR.createFromParcel(r5);
        goto L7
    }

    @Override // android.os.Parcelable.Creator
    public final FeedDislikeOption[] newArray(int r1) {
        return new FeedDislikeOption[r1];
    }
}
