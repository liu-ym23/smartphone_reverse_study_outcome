package com.obric.oui.progress;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel r5) {
        OProgressView.SavedState r10 = new OProgressView.SavedState(r5);
        r10.f14218a = r5.readInt();
        r10.f14219b = r5.readInt();
        r10.f14220c = r5.readInt();
        r10.d = r5.readInt();
        r10.e = r5.readInt();
        return r10;
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int r5) {
        return new OProgressView.SavedState[r5];
    }
}
