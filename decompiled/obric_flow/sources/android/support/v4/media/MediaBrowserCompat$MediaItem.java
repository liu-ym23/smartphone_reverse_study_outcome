package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class MediaBrowserCompat$MediaItem implements Parcelable {
    public static final Parcelable.Creator<MediaBrowserCompat$MediaItem> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f354a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MediaDescriptionCompat f355b;

    static {
        CREATOR = new a5.b(1);
    }

    public MediaBrowserCompat$MediaItem(Parcel r5) {
        this.f354a = r5.readInt();
        this.f355b = MediaDescriptionCompat.CREATOR.createFromParcel(r5);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return "MediaItem{mFlags=" + this.f354a + ", mDescription=" + this.f355b + '}';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r5, int r10) {
        r5.writeInt(this.f354a);
        this.f355b.writeToParcel(r5, r10);
    }
}
