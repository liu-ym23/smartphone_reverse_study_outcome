package androidx.versionedparcelable;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class ParcelImpl implements Parcelable {
    public static final Parcelable.Creator<ParcelImpl> CREATOR = null;
    private final VersionedParcelable mParcel;

    static {
        CREATOR = new AnonymousClass1();
    }

    public ParcelImpl(VersionedParcelable r5) {
        this.mParcel = r5;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public <T extends VersionedParcelable> T getVersionedParcel() {
        return (T) this.mParcel;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r5, int r10) {
        new VersionedParcelParcel(r5).writeVersionedParcelable(this.mParcel);
    }

    public ParcelImpl(Parcel r5) {
        this.mParcel = new VersionedParcelParcel(r5).readVersionedParcelable();
    }
}
