package com.ss.android.common.ui.view;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
class FragmentTabHost$SavedState extends View.BaseSavedState {
    public static final Parcelable.Creator<FragmentTabHost$SavedState> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6716a;

    public static class a implements Parcelable.Creator<FragmentTabHost$SavedState> {
        @Override // android.os.Parcelable.Creator
        public final FragmentTabHost$SavedState createFromParcel(Parcel r8) {
            return new FragmentTabHost$SavedState(r8);
        }

        @Override // android.os.Parcelable.Creator
        public final FragmentTabHost$SavedState[] newArray(int r8) {
            return new FragmentTabHost$SavedState[r8];
        }
    }

    static {
        CREATOR = new a();
    }

    public FragmentTabHost$SavedState(Parcel r8) {
        super(r8);
        this.f6716a = r8.readString();
    }

    public final String toString() {
        StringBuilder r8 = new StringBuilder("FragmentTabHost.SavedState{");
        r8.append(Integer.toHexString(System.identityHashCode(this)));
        r8.append(" curTab=");
        return android.aimedia.a.i(r8, this.f6716a, "}");
    }

    @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel r8, int r10) {
        super.writeToParcel(r8, r10);
        r8.writeString(this.f6716a);
    }
}
