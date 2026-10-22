package android.support.v4.media;

import android.media.MediaMetadata;
import android.os.Parcel;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
class e {
    public static Object a(Parcel r10) {
        return MediaMetadata.CREATOR.createFromParcel(r10);
    }

    public static void b(Object r10, Parcel r11, int r12) {
        ((MediaMetadata) r10).writeToParcel(r11, r12);
    }
}
