package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
final class FragmentManagerState implements Parcelable {
    public static final Parcelable.Creator<FragmentManagerState> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList<FragmentState> f1901a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ArrayList<String> f1902b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public BackStackState[] f1903m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f1904n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f1905o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final ArrayList<String> f1906p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final ArrayList<Bundle> f1907q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ArrayList<FragmentManager.LaunchedFragmentInfo> f1908r;

    public class a implements Parcelable.Creator<FragmentManagerState> {
        @Override // android.os.Parcelable.Creator
        public final FragmentManagerState createFromParcel(Parcel r8) {
            return new FragmentManagerState(r8);
        }

        @Override // android.os.Parcelable.Creator
        public final FragmentManagerState[] newArray(int r8) {
            return new FragmentManagerState[r8];
        }
    }

    static {
        CREATOR = new a();
    }

    public FragmentManagerState() {
        this.f1905o = null;
        this.f1906p = new ArrayList();
        this.f1907q = new ArrayList();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r8, int r10) {
        r8.writeTypedList(this.f1901a);
        r8.writeStringList(this.f1902b);
        r8.writeTypedArray(this.f1903m, r10);
        r8.writeInt(this.f1904n);
        r8.writeString(this.f1905o);
        r8.writeStringList(this.f1906p);
        r8.writeTypedList(this.f1907q);
        r8.writeTypedList(this.f1908r);
    }

    public FragmentManagerState(Parcel r8) {
        this.f1905o = null;
        this.f1906p = new ArrayList();
        this.f1907q = new ArrayList();
        this.f1901a = r8.createTypedArrayList(FragmentState.CREATOR);
        this.f1902b = r8.createStringArrayList();
        this.f1903m = (BackStackState[]) r8.createTypedArray(BackStackState.CREATOR);
        this.f1904n = r8.readInt();
        this.f1905o = r8.readString();
        this.f1906p = r8.createStringArrayList();
        this.f1907q = r8.createTypedArrayList(Bundle.CREATOR);
        this.f1908r = r8.createTypedArrayList(FragmentManager.LaunchedFragmentInfo.CREATOR);
    }
}
