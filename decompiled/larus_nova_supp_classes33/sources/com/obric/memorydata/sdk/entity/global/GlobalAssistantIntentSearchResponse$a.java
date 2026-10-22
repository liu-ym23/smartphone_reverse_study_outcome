package com.obric.memorydata.sdk.entity.global;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class GlobalAssistantIntentSearchResponse$a implements Parcelable.Creator<GlobalAssistantIntentSearchResponse> {
    public GlobalAssistantIntentSearchResponse$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final GlobalAssistantIntentSearchResponse createFromParcel(Parcel r2) {
        Intrinsics.checkNotNullParameter(r2, "parcel");
        return new GlobalAssistantIntentSearchResponse(r2);
    }

    @Override // android.os.Parcelable.Creator
    public final GlobalAssistantIntentSearchResponse[] newArray(int r1) {
        return new GlobalAssistantIntentSearchResponse[r1];
    }
}
