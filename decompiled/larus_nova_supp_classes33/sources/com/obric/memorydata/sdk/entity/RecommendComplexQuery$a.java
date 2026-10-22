package com.obric.memorydata.sdk.entity;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class RecommendComplexQuery$a implements Parcelable.Creator<RecommendComplexQuery> {
    public RecommendComplexQuery$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final RecommendComplexQuery createFromParcel(Parcel r2) {
        Intrinsics.checkNotNullParameter(r2, "parcel");
        return new RecommendComplexQuery(r2);
    }

    @Override // android.os.Parcelable.Creator
    public final RecommendComplexQuery[] newArray(int r1) {
        return new RecommendComplexQuery[r1];
    }
}
