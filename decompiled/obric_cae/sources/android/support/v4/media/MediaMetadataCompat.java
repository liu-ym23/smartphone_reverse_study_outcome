package android.support.v4.media;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.session.MediaSessionCompat;
import n.b;

/* JADX INFO: loaded from: classes.dex */
public final class MediaMetadataCompat implements Parcelable {
    public static final Parcelable.Creator<MediaMetadataCompat> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bundle f401a;

    public static class a implements Parcelable.Creator<MediaMetadataCompat> {
        @Override // android.os.Parcelable.Creator
        public final MediaMetadataCompat createFromParcel(Parcel r8) {
            return new MediaMetadataCompat(r8);
        }

        @Override // android.os.Parcelable.Creator
        public final MediaMetadataCompat[] newArray(int r8) {
            return new MediaMetadataCompat[r8];
        }
    }

    static {
        b r8 = new b();
        r8.put("android.media.metadata.TITLE", 1);
        r8.put("android.media.metadata.ARTIST", 1);
        r8.put("android.media.metadata.DURATION", 0);
        r8.put("android.media.metadata.ALBUM", 1);
        r8.put("android.media.metadata.AUTHOR", 1);
        r8.put("android.media.metadata.WRITER", 1);
        r8.put("android.media.metadata.COMPOSER", 1);
        r8.put("android.media.metadata.COMPILATION", 1);
        r8.put("android.media.metadata.DATE", 1);
        r8.put("android.media.metadata.YEAR", 0);
        r8.put("android.media.metadata.GENRE", 1);
        r8.put("android.media.metadata.TRACK_NUMBER", 0);
        r8.put("android.media.metadata.NUM_TRACKS", 0);
        r8.put("android.media.metadata.DISC_NUMBER", 0);
        r8.put("android.media.metadata.ALBUM_ARTIST", 1);
        r8.put("android.media.metadata.ART", 2);
        r8.put("android.media.metadata.ART_URI", 1);
        r8.put("android.media.metadata.ALBUM_ART", 2);
        r8.put("android.media.metadata.ALBUM_ART_URI", 1);
        r8.put("android.media.metadata.USER_RATING", 3);
        r8.put("android.media.metadata.RATING", 3);
        r8.put("android.media.metadata.DISPLAY_TITLE", 1);
        r8.put("android.media.metadata.DISPLAY_SUBTITLE", 1);
        r8.put("android.media.metadata.DISPLAY_DESCRIPTION", 1);
        r8.put("android.media.metadata.DISPLAY_ICON", 2);
        r8.put("android.media.metadata.DISPLAY_ICON_URI", 1);
        r8.put("android.media.metadata.MEDIA_ID", 1);
        r8.put("android.media.metadata.BT_FOLDER_TYPE", 0);
        r8.put("android.media.metadata.MEDIA_URI", 1);
        r8.put("android.media.metadata.ADVERTISEMENT", 0);
        r8.put("android.media.metadata.DOWNLOAD_STATUS", 0);
        CREATOR = new a();
    }

    public MediaMetadataCompat(Parcel r8) {
        this.f401a = r8.readBundle(MediaSessionCompat.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r8, int r10) {
        r8.writeBundle(this.f401a);
    }
}
