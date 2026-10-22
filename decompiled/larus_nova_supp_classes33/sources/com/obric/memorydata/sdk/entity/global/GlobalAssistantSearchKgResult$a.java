package com.obric.memorydata.sdk.entity.global;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class GlobalAssistantSearchKgResult$a implements Parcelable.Creator<GlobalAssistantSearchKgResult> {
    public GlobalAssistantSearchKgResult$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final GlobalAssistantSearchKgResult createFromParcel(Parcel r2) {
        Intrinsics.checkNotNullParameter(r2, "parcel");
        return new GlobalAssistantSearchKgResult(r2);
    }

    @Override // android.os.Parcelable.Creator
    public final GlobalAssistantSearchKgResult[] newArray(int r1) {
        return new GlobalAssistantSearchKgResult[r1];
    }
}
