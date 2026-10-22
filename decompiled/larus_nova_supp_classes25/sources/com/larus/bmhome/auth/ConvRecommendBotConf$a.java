package com.larus.bmhome.auth;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class ConvRecommendBotConf$a implements Parcelable.Creator<ConvRecommendBotConf> {
    public ConvRecommendBotConf$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final ConvRecommendBotConf createFromParcel(Parcel r4) {
        Intrinsics.checkNotNullParameter(r4, "parcel");
        if (r4.readInt() == 0) goto L5;
        boolean r1 = true;
    L7:
        return new ConvRecommendBotConf(r1, r4.readInt(), r4.readInt());
    L5:
        r1 = false;
        goto L7
    }

    @Override // android.os.Parcelable.Creator
    public final ConvRecommendBotConf[] newArray(int r1) {
        return new ConvRecommendBotConf[r1];
    }
}
