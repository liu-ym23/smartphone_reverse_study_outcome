package android.support.v4.media;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.collection.ArrayMap;

/* JADX INFO: loaded from: classes.dex */
public final class MediaMetadataCompat implements Parcelable {
    public static final Parcelable.Creator<MediaMetadataCompat> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bundle f361a;

    static {
        ArrayMap r5 = new ArrayMap();
        r5.put("android.media.metadata.TITLE", 1);
        r5.put("android.media.metadata.ARTIST", 1);
        r5.put("android.media.metadata.DURATION", 0);
        r5.put("android.media.metadata.ALBUM", 1);
        r5.put("android.media.metadata.AUTHOR", 1);
        r5.put("android.media.metadata.WRITER", 1);
        r5.put("android.media.metadata.COMPOSER", 1);
        r5.put("android.media.metadata.COMPILATION", 1);
        r5.put("android.media.metadata.DATE", 1);
        r5.put("android.media.metadata.YEAR", 0);
        r5.put("android.media.metadata.GENRE", 1);
        r5.put("android.media.metadata.TRACK_NUMBER", 0);
        r5.put("android.media.metadata.NUM_TRACKS", 0);
        r5.put("android.media.metadata.DISC_NUMBER", 0);
        r5.put("android.media.metadata.ALBUM_ARTIST", 1);
        r5.put("android.media.metadata.ART", 2);
        r5.put("android.media.metadata.ART_URI", 1);
        r5.put("android.media.metadata.ALBUM_ART", 2);
        r5.put("android.media.metadata.ALBUM_ART_URI", 1);
        r5.put("android.media.metadata.USER_RATING", 3);
        r5.put("android.media.metadata.RATING", 3);
        r5.put("android.media.metadata.DISPLAY_TITLE", 1);
        r5.put("android.media.metadata.DISPLAY_SUBTITLE", 1);
        r5.put("android.media.metadata.DISPLAY_DESCRIPTION", 1);
        r5.put("android.media.metadata.DISPLAY_ICON", 2);
        r5.put("android.media.metadata.DISPLAY_ICON_URI", 1);
        r5.put("android.media.metadata.MEDIA_ID", 1);
        r5.put("android.media.metadata.BT_FOLDER_TYPE", 0);
        r5.put("android.media.metadata.MEDIA_URI", 1);
        r5.put("android.media.metadata.ADVERTISEMENT", 0);
        r5.put("android.media.metadata.DOWNLOAD_STATUS", 0);
        CREATOR = new a5.b(3);
    }

    public MediaMetadataCompat(Parcel r5) {
        this.f361a = r5.readBundle(android.support.v4.media.session.f.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r5, int r10) {
        r5.writeBundle(this.f361a);
    }
}
