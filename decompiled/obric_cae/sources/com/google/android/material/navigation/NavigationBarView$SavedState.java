package com.google.android.material.navigation;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.customview.view.AbsSavedState;

/* JADX INFO: loaded from: classes.dex */
class NavigationBarView$SavedState extends AbsSavedState {
    public static final Parcelable.Creator<NavigationBarView$SavedState> CREATOR = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Bundle f4899m;

    public class a implements Parcelable.ClassLoaderCreator<NavigationBarView$SavedState> {
        @Override // android.os.Parcelable.Creator
        public final Object createFromParcel(Parcel r8) {
            return new NavigationBarView$SavedState(r8, null);
        }

        @Override // android.os.Parcelable.Creator
        public final Object[] newArray(int r8) {
            return new NavigationBarView$SavedState[r8];
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        public final NavigationBarView$SavedState createFromParcel(Parcel r8, ClassLoader r10) {
            return new NavigationBarView$SavedState(r8, r10);
        }
    }

    static {
        CREATOR = new a();
    }

    public NavigationBarView$SavedState(Parcel r8, ClassLoader r10) {
        super(r8, r10);
        if (r10 != null) goto L5;
        r10 = getClass().getClassLoader();
    L5:
        this.f4899m = r8.readBundle(r10);
    }

    @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel r8, int r10) {
        r8.writeParcelable(this.f1731a, r10);
        r8.writeBundle(this.f4899m);
    }
}
