package com.obric.oui.orecyclerview.widget;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes3.dex */
@SuppressLint({"BanParcelableUsage"})
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class LinearLayoutManager$SavedState implements Parcelable {
    public static final Parcelable.Creator<LinearLayoutManager$SavedState> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f13720a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f13721b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f13722c;

    static {
        CREATOR = new z0(2);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r5, int r10) {
        r5.writeInt(this.f13720a);
        r5.writeInt(this.f13721b);
        r5.writeInt(this.f13722c ? 1 : 0);
    }
}
