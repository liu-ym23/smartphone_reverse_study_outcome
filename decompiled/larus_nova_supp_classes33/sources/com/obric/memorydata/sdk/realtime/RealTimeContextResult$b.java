package com.obric.memorydata.sdk.realtime;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class RealTimeContextResult$b implements Parcelable.Creator<RealTimeContextResult> {
    public RealTimeContextResult$b() {
    }

    @Override // android.os.Parcelable.Creator
    public final RealTimeContextResult createFromParcel(Parcel r5) {
        Intrinsics.checkNotNullParameter(r5, "parcel");
        int r1 = r5.readInt();
        String r2 = r5.readString();
        if (r5.readInt() != 0) goto L5;
        Object r6 = null;
    L7:
        return new RealTimeContextResult(r1, r2, (RealTimeContext) r6);
    L5:
        r6 = RealTimeContext.CREATOR.createFromParcel(r5);
        goto L7
    }

    @Override // android.os.Parcelable.Creator
    public final RealTimeContextResult[] newArray(int r1) {
        return new RealTimeContextResult[r1];
    }
}
