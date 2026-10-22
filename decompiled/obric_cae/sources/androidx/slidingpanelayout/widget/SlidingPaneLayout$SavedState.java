package androidx.slidingpanelayout.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.customview.view.AbsSavedState;

/* JADX INFO: loaded from: classes.dex */
class SlidingPaneLayout$SavedState extends AbsSavedState {
    public static final Parcelable.Creator<SlidingPaneLayout$SavedState> CREATOR = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f2727m;

    public static class a implements Parcelable.ClassLoaderCreator<SlidingPaneLayout$SavedState> {
        @Override // android.os.Parcelable.Creator
        public final Object createFromParcel(Parcel r8) {
            return new SlidingPaneLayout$SavedState(r8);
        }

        @Override // android.os.Parcelable.Creator
        public final Object[] newArray(int r8) {
            return new SlidingPaneLayout$SavedState[r8];
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        public final SlidingPaneLayout$SavedState createFromParcel(Parcel r8, ClassLoader r10) {
            return new SlidingPaneLayout$SavedState(r8);
        }
    }

    static {
        CREATOR = new a();
    }

    public SlidingPaneLayout$SavedState(Parcel r8) {
        super(r8, null);
        if (r8.readInt() == 0) goto L5;
        boolean r10 = true;
    L6:
        this.f2727m = r10;
        return;
    L5:
        r10 = false;
        goto L6
    }

    @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel r8, int r10) {
        r8.writeParcelable(this.f1731a, r10);
        r8.writeInt(this.f2727m ? 1 : 0);
    }
}
