package com.obric.oui.progress;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel r5) {
        ODownloadProgressView.SavedState r10 = new ODownloadProgressView.SavedState(r5);
        r10.f14210a = r5.readInt();
        r10.f14211b = r5.readInt();
        return r10;
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int r5) {
        return new ODownloadProgressView.SavedState[r5];
    }
}
