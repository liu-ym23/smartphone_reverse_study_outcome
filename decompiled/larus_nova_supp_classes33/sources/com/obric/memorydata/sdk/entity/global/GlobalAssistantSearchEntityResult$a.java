package com.obric.memorydata.sdk.entity.global;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class GlobalAssistantSearchEntityResult$a implements Parcelable.Creator<GlobalAssistantSearchEntityResult> {
    public GlobalAssistantSearchEntityResult$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final GlobalAssistantSearchEntityResult createFromParcel(Parcel r2) {
        Intrinsics.checkNotNullParameter(r2, "parcel");
        return new GlobalAssistantSearchEntityResult(r2);
    }

    @Override // android.os.Parcelable.Creator
    public final GlobalAssistantSearchEntityResult[] newArray(int r1) {
        return new GlobalAssistantSearchEntityResult[r1];
    }
}
