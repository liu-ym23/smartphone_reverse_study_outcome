package androidx.drawerlayout.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.customview.view.AbsSavedState;

/* JADX INFO: loaded from: classes.dex */
public class DrawerLayout$SavedState extends AbsSavedState {
    public static final Parcelable.Creator<DrawerLayout$SavedState> CREATOR = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f1732m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f1733n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f1734o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f1735p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f1736q;

    public class a implements Parcelable.ClassLoaderCreator<DrawerLayout$SavedState> {
        @Override // android.os.Parcelable.Creator
        public final Object createFromParcel(Parcel r8) {
            return new DrawerLayout$SavedState(r8, null);
        }

        @Override // android.os.Parcelable.Creator
        public final Object[] newArray(int r8) {
            return new DrawerLayout$SavedState[r8];
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        public final DrawerLayout$SavedState createFromParcel(Parcel r8, ClassLoader r10) {
            return new DrawerLayout$SavedState(r8, r10);
        }
    }

    static {
        CREATOR = new a();
    }

    public DrawerLayout$SavedState(Parcel r8, ClassLoader r10) {
        super(r8, r10);
        this.f1732m = 0;
        this.f1732m = r8.readInt();
        this.f1733n = r8.readInt();
        this.f1734o = r8.readInt();
        this.f1735p = r8.readInt();
        this.f1736q = r8.readInt();
    }

    @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel r8, int r10) {
        r8.writeParcelable(this.f1731a, r10);
        r8.writeInt(this.f1732m);
        r8.writeInt(this.f1733n);
        r8.writeInt(this.f1734o);
        r8.writeInt(this.f1735p);
        r8.writeInt(this.f1736q);
    }
}
