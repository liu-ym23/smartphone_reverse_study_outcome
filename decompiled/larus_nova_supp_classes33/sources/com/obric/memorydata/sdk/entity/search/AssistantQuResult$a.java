package com.obric.memorydata.sdk.entity.search;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class AssistantQuResult$a implements Parcelable.Creator<AssistantQuResult> {
    public AssistantQuResult$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final AssistantQuResult createFromParcel(Parcel r2) {
        Intrinsics.checkNotNullParameter(r2, "parcel");
        return new AssistantQuResult(r2);
    }

    @Override // android.os.Parcelable.Creator
    public final AssistantQuResult[] newArray(int r1) {
        return new AssistantQuResult[r1];
    }
}
