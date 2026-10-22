package com.obric.memorydata.sdk.entity.global;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class GlobalAssistantSearchResponse$a implements Parcelable.Creator<GlobalAssistantSearchResponse> {
    public GlobalAssistantSearchResponse$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final GlobalAssistantSearchResponse createFromParcel(Parcel r2) {
        Intrinsics.checkNotNullParameter(r2, "parcel");
        return new GlobalAssistantSearchResponse(r2);
    }

    @Override // android.os.Parcelable.Creator
    public final GlobalAssistantSearchResponse[] newArray(int r1) {
        return new GlobalAssistantSearchResponse[r1];
    }
}
