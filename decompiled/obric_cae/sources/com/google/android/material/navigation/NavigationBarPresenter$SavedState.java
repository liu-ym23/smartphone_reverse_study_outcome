package com.google.android.material.navigation;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.material.internal.ParcelableSparseArray;

/* JADX INFO: loaded from: classes.dex */
class NavigationBarPresenter$SavedState implements Parcelable {
    public static final Parcelable.Creator<NavigationBarPresenter$SavedState> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f4897a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ParcelableSparseArray f4898b;

    public class a implements Parcelable.Creator<NavigationBarPresenter$SavedState> {
        @Override // android.os.Parcelable.Creator
        public final NavigationBarPresenter$SavedState createFromParcel(Parcel r8) {
            return new NavigationBarPresenter$SavedState(r8);
        }

        @Override // android.os.Parcelable.Creator
        public final NavigationBarPresenter$SavedState[] newArray(int r8) {
            return new NavigationBarPresenter$SavedState[r8];
        }
    }

    static {
        CREATOR = new a();
    }

    public NavigationBarPresenter$SavedState() {
    }

    public NavigationBarPresenter$SavedState(Parcel r8) {
        this.f4897a = r8.readInt();
        this.f4898b = (ParcelableSparseArray) r8.readParcelable(getClass().getClassLoader());
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r8, int r10) {
        r8.writeInt(this.f4897a);
        r8.writeParcelable(this.f4898b, 0);
    }
}
