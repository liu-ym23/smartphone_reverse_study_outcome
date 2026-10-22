package com.larus.voicecall.impl.degrade.bean;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class RealtimeCallQuotaData$a implements Parcelable.Creator<RealtimeCallQuotaData> {
    public RealtimeCallQuotaData$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final RealtimeCallQuotaData createFromParcel(Parcel r9) {
        Intrinsics.checkNotNullParameter(r9, "parcel");
        long r2 = r9.readLong();
        QuotaInfo r4 = null;
        if (r9.readInt() != 0) goto L5;
        DurationLimit r1 = null;
    L6:
        DurationLimit r5 = r1;
        if (r9.readInt() != 0) goto L9;
        DurationLimit r3 = null;
    L10:
        DurationLimit r6 = r3;
        if (r9.readInt() != 0) goto L13;
        QuotaInfo r7 = null;
    L14:
        QuotaInfo r8 = r7;
        if (r9.readInt() == 0) goto L19;
        r4 = QuotaInfo.CREATOR.createFromParcel(r9);
    L19:
        return new RealtimeCallQuotaData(r2, r5, r6, r8, r4);
    L13:
        r7 = QuotaInfo.CREATOR.createFromParcel(r9);
        goto L14
    L9:
        r3 = DurationLimit.CREATOR.createFromParcel(r9);
        goto L10
    L5:
        r1 = DurationLimit.CREATOR.createFromParcel(r9);
        goto L6
    }

    @Override // android.os.Parcelable.Creator
    public final RealtimeCallQuotaData[] newArray(int r1) {
        return new RealtimeCallQuotaData[r1];
    }
}
