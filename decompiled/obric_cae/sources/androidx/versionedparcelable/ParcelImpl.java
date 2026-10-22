package androidx.versionedparcelable;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import h1.b;
import h1.c;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
public class ParcelImpl implements Parcelable {
    public static final Parcelable.Creator<ParcelImpl> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f2728a;

    public static class a implements Parcelable.Creator<ParcelImpl> {
        @Override // android.os.Parcelable.Creator
        public final ParcelImpl createFromParcel(Parcel r8) {
            return new ParcelImpl(r8);
        }

        @Override // android.os.Parcelable.Creator
        public final ParcelImpl[] newArray(int r8) {
            return new ParcelImpl[r8];
        }
    }

    static {
        CREATOR = new a();
    }

    public ParcelImpl(Parcel r8) {
        this.f2728a = new b(r8).m();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r8, int r10) {
        new b(r8).v(this.f2728a);
    }
}
