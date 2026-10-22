package android.support.v4.media;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.os.ResultReceiver;
import androidx.media.MediaBrowserServiceCompat;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
class MediaBrowserCompat$SearchResultReceiver extends ResultReceiver {
    @Override // android.support.v4.os.ResultReceiver
    public final void c(int r5, Bundle r10) {
        android.support.v4.media.session.f.a(r10);
        if (r5 != 0) goto L13;
        if (r10 != null) goto L6;
        throw null;
    L6:
        if (r10.containsKey(MediaBrowserServiceCompat.KEY_SEARCH_RESULTS) == false) goto L17;
        Parcelable[] r11 = r10.getParcelableArray(MediaBrowserServiceCompat.KEY_SEARCH_RESULTS);
        if (r11 == null) goto L12;
        ArrayList r12 = new ArrayList();
        int r13 = r11.length;
        int r14 = 0;
    L10:
        if (r14 >= r13) goto L15;
        r12.add((MediaBrowserCompat$MediaItem) r11[r14]);
        r14 = r14 + 1;
        goto L10
    L15:
        throw null;
    L12:
        throw null;
    L17:
        throw null;
    L13:
        throw null;
    }
}
