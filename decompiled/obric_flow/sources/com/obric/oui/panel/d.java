package com.obric.oui.panel;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements Parcelable.ClassLoaderCreator {
    @Override // android.os.Parcelable.ClassLoaderCreator
    public final Object createFromParcel(Parcel r5, ClassLoader r10) {
        return new BottomSheetBehavior.SavedState(r5, r10);
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int r5) {
        return new BottomSheetBehavior.SavedState[r5];
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel r5) {
        return new BottomSheetBehavior.SavedState(r5, null);
    }
}
