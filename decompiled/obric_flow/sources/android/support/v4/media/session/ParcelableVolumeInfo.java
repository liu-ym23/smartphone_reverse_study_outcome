package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class ParcelableVolumeInfo implements Parcelable {
    public static final Parcelable.Creator<ParcelableVolumeInfo> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f381a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f382b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f383c;
    public int d;
    public int e;

    static {
        CREATOR = new a5.b(8);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r5, int r10) {
        r5.writeInt(this.f381a);
        r5.writeInt(this.f383c);
        r5.writeInt(this.d);
        r5.writeInt(this.e);
        r5.writeInt(this.f382b);
    }
}
