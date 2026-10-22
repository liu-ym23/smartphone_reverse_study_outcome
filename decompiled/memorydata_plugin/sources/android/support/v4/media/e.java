package android.support.v4.media;

import android.media.MediaMetadata;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
class e {
    public static Object a(Parcel r1) {
        return MediaMetadata.CREATOR.createFromParcel(r1);
    }

    public static void a(Object r2, Parcel r3, int r4) {
        ((MediaMetadata) ZeusTransformUtils.preCheckCast(r2, MediaMetadata.class, "com.obric.memorydata.plugin")).writeToParcel(r3, r4);
    }
}
