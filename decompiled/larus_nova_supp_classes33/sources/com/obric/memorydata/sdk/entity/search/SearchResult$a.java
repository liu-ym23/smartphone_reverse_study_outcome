package com.obric.memorydata.sdk.entity.search;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class SearchResult$a implements Parcelable.Creator<SearchResult> {
    public SearchResult$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final SearchResult createFromParcel(Parcel r2) {
        Intrinsics.checkNotNullParameter(r2, "parcel");
        return new SearchResult(r2);
    }

    @Override // android.os.Parcelable.Creator
    public final SearchResult[] newArray(int r1) {
        return new SearchResult[r1];
    }
}
