package android.support.v4.media;

import android.media.MediaDescription;
import android.net.Uri;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(23)
class d {

    static class a {
        public static void a(Object r10, Uri r11) {
            ((MediaDescription.Builder) r10).setMediaUri(r11);
        }
    }

    public static Uri a(Object r10) {
        return ((MediaDescription) r10).getMediaUri();
    }
}
