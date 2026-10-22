package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class MediaBrowserCompat$MediaItem implements Parcelable {
    public static final Parcelable.Creator<MediaBrowserCompat$MediaItem> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f382a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MediaDescriptionCompat f383b;

    public static class a implements Parcelable.Creator<MediaBrowserCompat$MediaItem> {
        @Override // android.os.Parcelable.Creator
        public final MediaBrowserCompat$MediaItem createFromParcel(Parcel r8) {
            return new MediaBrowserCompat$MediaItem(r8);
        }

        @Override // android.os.Parcelable.Creator
        public final MediaBrowserCompat$MediaItem[] newArray(int r8) {
            return new MediaBrowserCompat$MediaItem[r8];
        }
    }

    static {
        CREATOR = new a();
    }

    public MediaBrowserCompat$MediaItem(Parcel r8) {
        this.f382a = r8.readInt();
        this.f383b = MediaDescriptionCompat.CREATOR.createFromParcel(r8);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return "MediaItem{mFlags=" + this.f382a + ", mDescription=" + this.f383b + '}';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r8, int r10) {
        r8.writeInt(this.f382a);
        this.f383b.writeToParcel(r8, r10);
    }
}
