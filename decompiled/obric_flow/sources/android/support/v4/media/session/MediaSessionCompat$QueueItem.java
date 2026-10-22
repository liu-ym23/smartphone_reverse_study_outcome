package android.support.v4.media.session;

import ai.j0;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.MediaDescriptionCompat;

/* JADX INFO: loaded from: classes.dex */
public final class MediaSessionCompat$QueueItem implements Parcelable {
    public static final Parcelable.Creator<MediaSessionCompat$QueueItem> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MediaDescriptionCompat f376a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f377b;

    static {
        CREATOR = new a5.b(5);
    }

    public MediaSessionCompat$QueueItem(Parcel r5) {
        this.f376a = MediaDescriptionCompat.CREATOR.createFromParcel(r5);
        this.f377b = r5.readLong();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("MediaSession.QueueItem {Description=");
        r5.append(this.f376a);
        r5.append(", Id=");
        return j0.o(r5, this.f377b, " }");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r5, int r10) {
        this.f376a.writeToParcel(r5, r10);
        r5.writeLong(this.f377b);
    }
}
