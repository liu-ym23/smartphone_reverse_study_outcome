package com.facebook.imageutils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorSpace;
import androidx.core.util.Pools;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BitmapUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pools.SynchronizedPool f8451a = null;

    /* JADX INFO: renamed from: com.facebook.imageutils.BitmapUtil$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f8452a = null;

        static {
            int[] r5 = new int[Bitmap.Config.values().length];
            f8452a = r5;
            r5[Bitmap.Config.ARGB_8888.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            f8452a[Bitmap.Config.ALPHA_8.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            f8452a[Bitmap.Config.ARGB_4444.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            f8452a[Bitmap.Config.RGB_565.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            f8452a[Bitmap.Config.RGBA_F16.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    static {
        f8451a = new Pools.SynchronizedPool(12);
    }

    public static int a(Bitmap r5) {
        if (r5 != null) goto L9;
        return 0;
    L9:
        return r5.getAllocationByteCount();
    L8:
        return r5.getByteCount();
    }

    public static int a(Bitmap.Config r5) {
        int r10 = AnonymousClass1.f8452a[r5.ordinal()];
        if (r10 != 1) goto L5;
        return 4;
    L5:
        if (r10 != 2) goto L7;
        return 1;
    L7:
        if (r10 == 3) goto L15;
        if (r10 == 4) goto L15;
        if (r10 != 5) goto L14;
        return 8;
    L14:
        throw new UnsupportedOperationException("The provided Bitmap.Config is not supported");
    L15:
        return 2;
    }

    public static ImageMetaData a(InputStream r5) {
        r5.getClass();
        Pools.SynchronizedPool r10 = f8451a;
        ByteBuffer r11 = (ByteBuffer) r10.acquire();
        if (r11 != null) goto L5;
        r11 = ByteBuffer.allocate(16384);
    L5:
        BitmapFactory.Options r12 = new BitmapFactory.Options();
        r12.inJustDecodeBounds = true;
        r12.inTempStorage = r11.array();     // Catch: Throwable -> L9
        BitmapFactory.decodeStream(r5, null, r12);     // Catch: Throwable -> L9
        ColorSpace r13 = r12.outColorSpace;     // Catch: Throwable -> L9
        ImageMetaData r14 = new ImageMetaData(r12.outWidth, r12.outHeight, r13);     // Catch: Throwable -> L9
        r10.release(r11);
        return r14;
    L9:
        th = move-exception;
        f8451a.release(r11);
        throw th;
    }
}
