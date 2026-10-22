package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import joa.a;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class FinanceSearchStockParams$a implements Parcelable.Creator<FinanceSearchStockParams> {
    public FinanceSearchStockParams$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final FinanceSearchStockParams createFromParcel(Parcel r9) {
        int r0 = r9.readInt();
        Intrinsics.checkNotNullParameter(r9, "parcel");
        FinanceSearchStockParams r1 = new FinanceSearchStockParams(r9.readString(), r9.readString(), r9.readString(), r9.readString(), r9.readString());
        int r2 = Math.min(r0, 0);
        ClassLoader r3 = FinanceSearchStockParams$a.class.getClassLoader();
        int r4 = 1;
    L3:
        if (r4 > r2) goto L5;
        r4 = r4 + 1;
    L5:
        if (r4 > r0) goto L7;
        a.d(r9, r3);
        r4 = r4 + 1;
        goto L5
    L7:
        return r1;
    }

    @Override // android.os.Parcelable.Creator
    public final FinanceSearchStockParams[] newArray(int r1) {
        return new FinanceSearchStockParams[r1];
    }
}
