package com.obric.memorydata.sdk.entity.search;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class SearchResponse$a implements Parcelable.Creator<SearchResponse> {
    public SearchResponse$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final SearchResponse createFromParcel(Parcel r2) {
        Intrinsics.checkNotNullParameter(r2, "parcel");
        return new SearchResponse(r2);
    }

    @Override // android.os.Parcelable.Creator
    public final SearchResponse[] newArray(int r1) {
        return new SearchResponse[r1];
    }
}
