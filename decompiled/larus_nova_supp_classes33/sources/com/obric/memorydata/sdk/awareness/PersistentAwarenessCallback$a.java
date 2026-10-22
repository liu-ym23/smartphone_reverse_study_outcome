package com.obric.memorydata.sdk.awareness;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class PersistentAwarenessCallback$a implements Parcelable.Creator<PersistentAwarenessCallback> {
    public PersistentAwarenessCallback$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final PersistentAwarenessCallback createFromParcel(Parcel r5) {
        Intrinsics.checkNotNullParameter(r5, "parcel");
        return new PersistentAwarenessCallback(r5.readString(), (AwarenessTarget) AwarenessTarget.CREATOR.createFromParcel(r5), r5.readBundle(PersistentAwarenessCallback.class.getClassLoader()));
    }

    @Override // android.os.Parcelable.Creator
    public final PersistentAwarenessCallback[] newArray(int r1) {
        return new PersistentAwarenessCallback[r1];
    }
}
