package com.facebook.imageutils;

import android.media.ExifInterface;
import com.facebook.common.internal.DoNotStrip;
import com.facebook.common.logging.FLogDefaultLoggingDelegate;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public abstract class DngExifUtil {

    @DoNotStrip
    public static class DngExifUtilAndroidN {
        private DngExifUtilAndroidN() {
        }

        public static int a(InputStream r5) {
            return new ExifInterface(r5).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1);
        L4:
            e = move-exception;
            if (FLogDefaultLoggingDelegate.f7658a.a(3) == false) goto L12;
            FLogDefaultLoggingDelegate.a(3, "DngExifUtil", "Failed reading Dng Exif orientation -> ignoring", e);
            return 0;
        L12:
            return 0;
        }
    }

    public static int a(InputStream r5) {
        return DngExifUtilAndroidN.a(r5);
    }
}
