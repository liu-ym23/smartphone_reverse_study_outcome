package com.ss.android.common.view;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
class PagerSlidingTabStrip$SavedState extends View.BaseSavedState {
    public static final Parcelable.Creator<PagerSlidingTabStrip$SavedState> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6717a;

    public static class a implements Parcelable.Creator<PagerSlidingTabStrip$SavedState> {
        @Override // android.os.Parcelable.Creator
        public final PagerSlidingTabStrip$SavedState createFromParcel(Parcel r8) {
            return new PagerSlidingTabStrip$SavedState(r8);
        }

        @Override // android.os.Parcelable.Creator
        public final PagerSlidingTabStrip$SavedState[] newArray(int r8) {
            return new PagerSlidingTabStrip$SavedState[r8];
        }
    }

    static {
        CREATOR = new a();
    }

    public PagerSlidingTabStrip$SavedState(Parcel r8) {
        super(r8);
        this.f6717a = r8.readInt();
    }

    @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel r8, int r10) {
        super.writeToParcel(r8, r10);
        r8.writeInt(this.f6717a);
    }
}
