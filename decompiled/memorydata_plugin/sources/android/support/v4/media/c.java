package android.support.v4.media;

import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
class c {

    static class a {
        public static Object a() {
            return new MediaDescription.Builder();
        }

        public static Object a(Object r2) {
            return ((MediaDescription.Builder) ZeusTransformUtils.preCheckCast(r2, MediaDescription.Builder.class, "com.obric.memorydata.plugin")).build();
        }

        public static void a(Object r2, Bitmap r3) {
            ((MediaDescription.Builder) ZeusTransformUtils.preCheckCast(r2, MediaDescription.Builder.class, "com.obric.memorydata.plugin")).setIconBitmap(r3);
        }

        public static void a(Object r2, Uri r3) {
            ((MediaDescription.Builder) ZeusTransformUtils.preCheckCast(r2, MediaDescription.Builder.class, "com.obric.memorydata.plugin")).setIconUri(r3);
        }

        public static void a(Object r2, Bundle r3) {
            ((MediaDescription.Builder) ZeusTransformUtils.preCheckCast(r2, MediaDescription.Builder.class, "com.obric.memorydata.plugin")).setExtras(r3);
        }

        public static void a(Object r2, CharSequence r3) {
            CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
            ((MediaDescription.Builder) ZeusTransformUtils.preCheckCast(r2, MediaDescription.Builder.class, "com.obric.memorydata.plugin")).setTitle(r4);
        }

        public static void a(Object r2, String r3) {
            ((MediaDescription.Builder) ZeusTransformUtils.preCheckCast(r2, MediaDescription.Builder.class, "com.obric.memorydata.plugin")).setMediaId(r3);
        }

        public static void b(Object r2, CharSequence r3) {
            CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
            ((MediaDescription.Builder) ZeusTransformUtils.preCheckCast(r2, MediaDescription.Builder.class, "com.obric.memorydata.plugin")).setSubtitle(r4);
        }

        public static void c(Object r2, CharSequence r3) {
            CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
            ((MediaDescription.Builder) ZeusTransformUtils.preCheckCast(r2, MediaDescription.Builder.class, "com.obric.memorydata.plugin")).setDescription(r4);
        }
    }

    public static Object a(Parcel r1) {
        return MediaDescription.CREATOR.createFromParcel(r1);
    }

    public static String a(Object r2) {
        return ((MediaDescription) ZeusTransformUtils.preCheckCast(r2, MediaDescription.class, "com.obric.memorydata.plugin")).getMediaId();
    }

    public static void a(Object r2, Parcel r3, int r4) {
        ((MediaDescription) ZeusTransformUtils.preCheckCast(r2, MediaDescription.class, "com.obric.memorydata.plugin")).writeToParcel(r3, r4);
    }

    public static CharSequence b(Object r2) {
        return ((MediaDescription) ZeusTransformUtils.preCheckCast(r2, MediaDescription.class, "com.obric.memorydata.plugin")).getTitle();
    }

    public static CharSequence c(Object r2) {
        return ((MediaDescription) ZeusTransformUtils.preCheckCast(r2, MediaDescription.class, "com.obric.memorydata.plugin")).getSubtitle();
    }

    public static CharSequence d(Object r2) {
        return ((MediaDescription) ZeusTransformUtils.preCheckCast(r2, MediaDescription.class, "com.obric.memorydata.plugin")).getDescription();
    }

    public static Bitmap e(Object r2) {
        return ((MediaDescription) ZeusTransformUtils.preCheckCast(r2, MediaDescription.class, "com.obric.memorydata.plugin")).getIconBitmap();
    }

    public static Uri f(Object r2) {
        return ((MediaDescription) ZeusTransformUtils.preCheckCast(r2, MediaDescription.class, "com.obric.memorydata.plugin")).getIconUri();
    }

    public static Bundle g(Object r2) {
        return ((MediaDescription) ZeusTransformUtils.preCheckCast(r2, MediaDescription.class, "com.obric.memorydata.plugin")).getExtras();
    }
}
