package android.support.v4.media;

import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
class c {

    static class a {
        public static Object a(Object r10) {
            return ((MediaDescription.Builder) r10).build();
        }

        public static Object b() {
            return new MediaDescription.Builder();
        }

        public static void c(Object r10, CharSequence r11) {
            ((MediaDescription.Builder) r10).setDescription(r11);
        }

        public static void d(Object r10, Bundle r11) {
            ((MediaDescription.Builder) r10).setExtras(r11);
        }

        public static void e(Object r10, Bitmap r11) {
            ((MediaDescription.Builder) r10).setIconBitmap(r11);
        }

        public static void f(Object r10, Uri r11) {
            ((MediaDescription.Builder) r10).setIconUri(r11);
        }

        public static void g(Object r10, String r11) {
            ((MediaDescription.Builder) r10).setMediaId(r11);
        }

        public static void h(Object r10, CharSequence r11) {
            ((MediaDescription.Builder) r10).setSubtitle(r11);
        }

        public static void i(Object r10, CharSequence r11) {
            ((MediaDescription.Builder) r10).setTitle(r11);
        }
    }

    public static Object a(Parcel r10) {
        return MediaDescription.CREATOR.createFromParcel(r10);
    }

    public static CharSequence b(Object r10) {
        return ((MediaDescription) r10).getDescription();
    }

    public static Bundle c(Object r10) {
        return ((MediaDescription) r10).getExtras();
    }

    public static Bitmap d(Object r10) {
        return ((MediaDescription) r10).getIconBitmap();
    }

    public static Uri e(Object r10) {
        return ((MediaDescription) r10).getIconUri();
    }

    public static String f(Object r10) {
        return ((MediaDescription) r10).getMediaId();
    }

    public static CharSequence g(Object r10) {
        return ((MediaDescription) r10).getSubtitle();
    }

    public static CharSequence h(Object r10) {
        return ((MediaDescription) r10).getTitle();
    }

    public static void i(Object r10, Parcel r11, int r12) {
        ((MediaDescription) r10).writeToParcel(r11, r12);
    }
}
