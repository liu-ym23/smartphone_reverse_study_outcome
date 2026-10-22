package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class ParcelableVolumeInfo implements Parcelable {
    public static final Parcelable.Creator<ParcelableVolumeInfo> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f412a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f413b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f414m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f415n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f416o;

    public static class a implements Parcelable.Creator<ParcelableVolumeInfo> {
        @Override // android.os.Parcelable.Creator
        public final ParcelableVolumeInfo createFromParcel(Parcel r8) {
            return new ParcelableVolumeInfo(r8);
        }

        @Override // android.os.Parcelable.Creator
        public final ParcelableVolumeInfo[] newArray(int r8) {
            return new ParcelableVolumeInfo[r8];
        }
    }

    static {
        CREATOR = new a();
    }

    public ParcelableVolumeInfo() {
        throw null;
    }

    public ParcelableVolumeInfo(Parcel r8) {
        this.f412a = r8.readInt();
        this.f414m = r8.readInt();
        this.f415n = r8.readInt();
        this.f416o = r8.readInt();
        this.f413b = r8.readInt();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r8, int r10) {
        r8.writeInt(this.f412a);
        r8.writeInt(this.f414m);
        r8.writeInt(this.f415n);
        r8.writeInt(this.f416o);
        r8.writeInt(this.f413b);
    }
}
