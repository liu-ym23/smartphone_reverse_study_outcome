package com.bytedance.ies.uikit.tabhost;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel r5) {
        FragmentTabHost.SavedState r10 = new FragmentTabHost.SavedState(r5);
        r10.f6259a = r5.readString();
        return r10;
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int r5) {
        return new FragmentTabHost.SavedState[r5];
    }
}
