package com.airbnb.lottie;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class g implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel r5) {
        LottieAnimationView.SavedState r10 = new LottieAnimationView.SavedState(r5);
        r10.f1243a = r5.readString();
        r10.f1245c = r5.readFloat();
        boolean r11 = true;
        if (r5.readInt() == 1) goto L6;
        r11 = false;
    L6:
        r10.d = r11;
        r10.e = r5.readString();
        r10.f = r5.readInt();
        r10.g = r5.readInt();
        return r10;
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int r5) {
        return new LottieAnimationView.SavedState[r5];
    }
}
