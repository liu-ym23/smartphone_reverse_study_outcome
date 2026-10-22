package com.obric.memorydata.sdk.awareness;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class PersistentAwarenessRegisterRequest$a implements Parcelable.Creator<PersistentAwarenessRegisterRequest> {
    public PersistentAwarenessRegisterRequest$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final PersistentAwarenessRegisterRequest createFromParcel(Parcel r5) {
        Intrinsics.checkNotNullParameter(r5, "parcel");
        return new PersistentAwarenessRegisterRequest(r5.readString(), (AwarenessTarget) AwarenessTarget.CREATOR.createFromParcel(r5), (AwarenessConditionConfig) AwarenessConditionConfig.CREATOR.createFromParcel(r5));
    }

    @Override // android.os.Parcelable.Creator
    public final PersistentAwarenessRegisterRequest[] newArray(int r1) {
        return new PersistentAwarenessRegisterRequest[r1];
    }
}
