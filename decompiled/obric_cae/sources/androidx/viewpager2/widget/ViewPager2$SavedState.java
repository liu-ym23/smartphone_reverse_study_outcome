package androidx.viewpager2.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class ViewPager2$SavedState extends View.BaseSavedState {
    public static final Parcelable.Creator<ViewPager2$SavedState> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2771a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2772b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Parcelable f2773m;

    public static class a implements Parcelable.ClassLoaderCreator<ViewPager2$SavedState> {
        @Override // android.os.Parcelable.Creator
        public final Object createFromParcel(Parcel r8) {
            return new ViewPager2$SavedState(r8, null);
        }

        @Override // android.os.Parcelable.Creator
        public final Object[] newArray(int r8) {
            return new ViewPager2$SavedState[r8];
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        public final ViewPager2$SavedState createFromParcel(Parcel r8, ClassLoader r10) {
            return new ViewPager2$SavedState(r8, r10);
        }
    }

    static {
        CREATOR = new a();
    }

    public ViewPager2$SavedState() {
        throw null;
    }

    public ViewPager2$SavedState(Parcel r8, ClassLoader r10) {
        super(r8, r10);
        this.f2771a = r8.readInt();
        this.f2772b = r8.readInt();
        this.f2773m = r8.readParcelable(r10);
    }

    @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel r8, int r10) {
        super.writeToParcel(r8, r10);
        r8.writeInt(this.f2771a);
        r8.writeInt(this.f2772b);
        r8.writeParcelable(this.f2773m, r10);
    }
}
