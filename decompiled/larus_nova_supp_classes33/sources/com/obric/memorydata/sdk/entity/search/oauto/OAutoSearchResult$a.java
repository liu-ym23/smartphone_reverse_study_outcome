package com.obric.memorydata.sdk.entity.search.oauto;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class OAutoSearchResult$a implements Parcelable.Creator<OAutoSearchResult> {
    public OAutoSearchResult$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final OAutoSearchResult createFromParcel(Parcel r2) {
        Intrinsics.checkNotNullParameter(r2, "parcel");
        return new OAutoSearchResult(r2);
    }

    @Override // android.os.Parcelable.Creator
    public final OAutoSearchResult[] newArray(int r1) {
        return new OAutoSearchResult[r1];
    }
}
