package android.support.v4.media;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.os.ResultReceiver;

/* JADX INFO: loaded from: classes.dex */
class MediaBrowserCompat$ItemReceiver extends ResultReceiver {
    @Override // android.support.v4.os.ResultReceiver
    public final void t(int r8, Bundle r10) {
        MediaSessionCompat.a(r10);
        if (r8 != 0) goto L15;
        if (r10 != null) goto L6;
        throw null;
    L6:
        if (r10.containsKey("media_item") == false) goto L17;
        Parcelable r11 = r10.getParcelable("media_item");
        if (r11 != null) goto L10;
    L13:
        MediaBrowserCompat$MediaItem r12 = (MediaBrowserCompat$MediaItem) r11;
        throw null;
    L10:
        if ((r11 instanceof MediaBrowserCompat$MediaItem) == true) goto L13;
        throw null;
    L17:
        throw null;
    L15:
        throw null;
    }
}
