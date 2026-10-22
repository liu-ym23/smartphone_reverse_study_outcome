package com.obric.memorydata.sdk.entity.global;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class GlobalAssistantSearchDomainResult$a implements Parcelable.Creator<GlobalAssistantSearchDomainResult> {
    public GlobalAssistantSearchDomainResult$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final GlobalAssistantSearchDomainResult createFromParcel(Parcel r2) {
        Intrinsics.checkNotNullParameter(r2, "parcel");
        return new GlobalAssistantSearchDomainResult(r2);
    }

    @Override // android.os.Parcelable.Creator
    public final GlobalAssistantSearchDomainResult[] newArray(int r1) {
        return new GlobalAssistantSearchDomainResult[r1];
    }
}
