package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class ParcelImpl implements Parcelable {
    public static final Parcelable.Creator<ParcelImpl> CREATOR = null;
    private final VersionedParcelable mParcel;

    static {
        CREATOR = new AnonymousClass1();
    }

    public ParcelImpl(Parcel r2) {
        this.mParcel = new VersionedParcelParcel(r2).readVersionedParcelable();
    }

    public ParcelImpl(VersionedParcelable r3) {
        this.mParcel = (VersionedParcelable) ZeusTransformUtils.wrapperContextForParams(r3, VersionedParcelable.class, "com.obric.memorydata.plugin");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public <T extends VersionedParcelable> T getVersionedParcel() {
        return (T) this.mParcel;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        new VersionedParcelParcel(r1).writeVersionedParcelable(this.mParcel);
    }
}
