package com.obric.memorydata.sdk.entity.global;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class GlobalAssistantSearchMemoryResult$a implements Parcelable.Creator<GlobalAssistantSearchMemoryResult> {
    public GlobalAssistantSearchMemoryResult$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final GlobalAssistantSearchMemoryResult createFromParcel(Parcel r2) {
        Intrinsics.checkNotNullParameter(r2, "parcel");
        return new GlobalAssistantSearchMemoryResult(r2);
    }

    @Override // android.os.Parcelable.Creator
    public final GlobalAssistantSearchMemoryResult[] newArray(int r1) {
        return new GlobalAssistantSearchMemoryResult[r1];
    }
}
