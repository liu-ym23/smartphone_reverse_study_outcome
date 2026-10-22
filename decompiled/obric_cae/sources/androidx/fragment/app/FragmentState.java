package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
final class FragmentState implements Parcelable {
    public static final Parcelable.Creator<FragmentState> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1909a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1910b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f1911m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f1912n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f1913o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f1914p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final boolean f1915q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final boolean f1916r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final boolean f1917s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Bundle f1918t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final boolean f1919u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f1920v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Bundle f1921w;

    public class a implements Parcelable.Creator<FragmentState> {
        @Override // android.os.Parcelable.Creator
        public final FragmentState createFromParcel(Parcel r8) {
            return new FragmentState(r8);
        }

        @Override // android.os.Parcelable.Creator
        public final FragmentState[] newArray(int r8) {
            return new FragmentState[r8];
        }
    }

    static {
        CREATOR = new a();
    }

    public FragmentState(Parcel r8) {
        this.f1909a = r8.readString();
        this.f1910b = r8.readString();
        boolean r10 = true;
        if (r8.readInt() == 0) goto L5;
        boolean r11 = true;
    L6:
        this.f1911m = r11;
        this.f1912n = r8.readInt();
        this.f1913o = r8.readInt();
        this.f1914p = r8.readString();
        if (r8.readInt() == 0) goto L9;
        boolean r12 = true;
    L10:
        this.f1915q = r12;
        if (r8.readInt() == 0) goto L13;
        boolean r13 = true;
    L14:
        this.f1916r = r13;
        if (r8.readInt() == 0) goto L17;
        boolean r14 = true;
    L18:
        this.f1917s = r14;
        this.f1918t = r8.readBundle();
        if (r8.readInt() != 0) goto L22;
        r10 = false;
    L22:
        this.f1919u = r10;
        this.f1921w = r8.readBundle();
        this.f1920v = r8.readInt();
        return;
    L17:
        r14 = false;
        goto L18
    L13:
        r13 = false;
        goto L14
    L9:
        r12 = false;
        goto L10
    L5:
        r11 = false;
        goto L6
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        StringBuilder r8 = new StringBuilder(128);
        r8.append("FragmentState{");
        r8.append(this.f1909a);
        r8.append(" (");
        r8.append(this.f1910b);
        r8.append(")}:");
        if (this.f1911m == false) goto L5;
        r8.append(" fromLayout");
    L5:
        int r10 = this.f1913o;
        if (r10 == 0) goto L8;
        r8.append(" id=0x");
        r8.append(Integer.toHexString(r10));
    L8:
        String r11 = this.f1914p;
        if (r11 == null) goto L14;
        if (r11.isEmpty() == true) goto L14;
        r8.append(" tag=");
        r8.append(r11);
    L14:
        if (this.f1915q == false) goto L17;
        r8.append(" retainInstance");
    L17:
        if (this.f1916r == false) goto L20;
        r8.append(" removing");
    L20:
        if (this.f1917s == false) goto L23;
        r8.append(" detached");
    L23:
        if (this.f1919u == false) goto L26;
        r8.append(" hidden");
    L26:
        return r8.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r8, int r10) {
        r8.writeString(this.f1909a);
        r8.writeString(this.f1910b);
        r8.writeInt(this.f1911m ? 1 : 0);
        r8.writeInt(this.f1912n);
        r8.writeInt(this.f1913o);
        r8.writeString(this.f1914p);
        r8.writeInt(this.f1915q ? 1 : 0);
        r8.writeInt(this.f1916r ? 1 : 0);
        r8.writeInt(this.f1917s ? 1 : 0);
        r8.writeBundle(this.f1918t);
        r8.writeInt(this.f1919u ? 1 : 0);
        r8.writeBundle(this.f1921w);
        r8.writeInt(this.f1920v);
    }

    public FragmentState(Fragment r8) {
        this.f1909a = r8.getClass().getName();
        this.f1910b = r8.mWho;
        this.f1911m = r8.mFromLayout;
        this.f1912n = r8.mFragmentId;
        this.f1913o = r8.mContainerId;
        this.f1914p = r8.mTag;
        this.f1915q = r8.mRetainInstance;
        this.f1916r = r8.mRemoving;
        this.f1917s = r8.mDetached;
        this.f1918t = r8.mArguments;
        this.f1919u = r8.mHidden;
        this.f1920v = r8.mMaxState.ordinal();
    }
}
