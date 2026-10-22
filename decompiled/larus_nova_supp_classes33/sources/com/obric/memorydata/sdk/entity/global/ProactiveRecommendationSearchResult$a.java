package com.obric.memorydata.sdk.entity.global;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class ProactiveRecommendationSearchResult$a implements Parcelable.Creator<ProactiveRecommendationSearchResult> {
    public ProactiveRecommendationSearchResult$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final ProactiveRecommendationSearchResult createFromParcel(Parcel r2) {
        Intrinsics.checkNotNullParameter(r2, "parcel");
        return new ProactiveRecommendationSearchResult(r2);
    }

    @Override // android.os.Parcelable.Creator
    public final ProactiveRecommendationSearchResult[] newArray(int r1) {
        return new ProactiveRecommendationSearchResult[r1];
    }
}
