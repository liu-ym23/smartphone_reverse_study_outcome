package com.facebook.imagepipeline.decoder;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.facebook.common.internal.Closeables;
import com.facebook.common.internal.Throwables;
import com.facebook.common.logging.FLogDefaultLoggingDelegate;
import com.facebook.common.memory.PooledByteBufferInputStream;
import com.facebook.common.references.CloseableReference;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imageformat.ImageFormatChecker;
import com.facebook.imagepipeline.common.ImageDecodeBitmapConfigStrategy;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.ImageDecodeOptionsBuilder;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import com.facebook.imagepipeline.image.QualityInfo;
import com.facebook.imagepipeline.platform.DefaultDecoder;
import com.facebook.imagepipeline.platform.PlatformDecoder;
import com.facebook.imageutils.HeifFormatUtil;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public class DefaultImageDecoder implements ImageDecoder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PlatformDecoder f8160a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageDecoder f8161b;

    /* JADX INFO: renamed from: com.facebook.imagepipeline.decoder.DefaultImageDecoder$1, reason: invalid class name */
    public class AnonymousClass1 implements ImageDecoder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DefaultImageDecoder f8162a;

        public AnonymousClass1(DefaultImageDecoder r5) {
            this.f8162a = r5;
        }

        @Override // com.facebook.imagepipeline.decoder.ImageDecoder
        public final CloseableImage a(EncodedImage r10, int r11, QualityInfo r12, ImageDecodeOptions r13) {
            ImageDecodeOptions r14 = DefaultImageDecoder.a(r13, r10);
            r10.g();
            ImageFormat r5 = r10.f8178b;
            if (r5 != DefaultImageFormats.f7962a) goto L12;
            DefaultImageDecoder r15 = this.f8162a;
            r15.getClass();
            CloseableReference r16 = ((DefaultDecoder) r15.f8160a).a(r10, r14.f8043b, null, r11);
            r10.g();     // Catch: Throwable -> L8
            int r17 = r10.f8179c;     // Catch: Throwable -> L8
            r10.g();     // Catch: Throwable -> L8
            int r18 = r10.d;     // Catch: Throwable -> L8
            Rect r19 = r10.f8183k;     // Catch: Throwable -> L8
            int r20 = r10.g;     // Catch: Throwable -> L8
            r10.g();     // Catch: Throwable -> L8
            CloseableStaticBitmap r110 = new CloseableStaticBitmap(r16, r12, r17, r18, null, r19, r20, r10.f8178b);     // Catch: Throwable -> L8
            r16.close();
            return r110;
        L8:
            th = move-exception;
            r16.close();
            throw th;
        L12:
            if (r5 != DefaultImageFormats.f7964c) goto L22;
            DefaultImageDecoder r21 = this.f8162a;
            r21.getClass();
            r10.g();
            if (r10.e == (-1)) goto L20;
            r10.g();
            if (r10.f == (-1)) goto L20;
            return r21.a(r10, r14);
        L20:
            throw new DecodeException("image width or height is incorrect", r10);
        L22:
            if (r5 != DefaultImageFormats.f7967j) goto L24;
            this.f8162a.getClass();
            throw null;
        L24:
            if (r5 != HeifFormatUtil.a()) goto L26;
            this.f8162a.getClass();
            throw null;
        L26:
            if (r5 == ImageFormat.f7971c) goto L30;
            return this.f8162a.a(r10, r14);
        L30:
            throw new DecodeException("unknown image format" + DefaultImageDecoder.a(r10), r10);
        }
    }

    public DefaultImageDecoder(PlatformDecoder r5) {
        this.f8161b = new AnonymousClass1(this);
        this.f8160a = r5;
    }

    @Override // com.facebook.imagepipeline.decoder.ImageDecoder
    public final CloseableImage a(EncodedImage r5, int r10, QualityInfo r11, ImageDecodeOptions r12) {
        ImageDecoder r13 = r12.f8044c;
        if (r13 != null) goto L5;
        r5.g();
        ImageFormat r14 = r5.f8178b;
        if (r14 == null) goto L18;
        if (r14 == ImageFormat.f7971c) goto L18;
    L14:
        return ((AnonymousClass1) this.f8161b).a(r5, r10, r11, r12);
    L18:
        r5.f8178b = ImageFormatChecker.a(r5.c());
    L15:
        e = move-exception;
        Throwables.a(e, Error.class);
        Throwables.a(e, RuntimeException.class);
        throw new RuntimeException(e);
    L5:
        return r13.a(r5, r10, r11, r12);
    }

    public static ImageDecodeOptions a(ImageDecodeOptions r5, EncodedImage r10) {
        ImageDecodeOptionsBuilder r11 = new ImageDecodeOptionsBuilder();
        r5.getClass();
        r11.f8045a = r5.f8042a;
        r11.f8046b = r5.f8043b;
        r11.f8047c = r5.f8044c;
        r11.d = r5.d;
        boolean r12 = r10.f8181i;
        r10.g();
        if (r5.d == false) goto L5;
        Bitmap.Config r13 = r5.f8043b;
    L6:
        r11.f8046b = r13;
        r11.d = true;
        return new ImageDecodeOptions(r11);
    L5:
        r13 = ImageDecodeBitmapConfigStrategy.f8041a.a();
        goto L6
    }

    public static String a(EncodedImage r10) {
        InputStream r5 = r10.c();
        byte[] r11 = new byte[64];
        PooledByteBufferInputStream r12 = (PooledByteBufferInputStream) r5;     // Catch: Throwable -> L6 IOException -> L8
        r12.getClass();     // Catch: Throwable -> L6 IOException -> L8
        r12.read(r11, 0, 64);     // Catch: Throwable -> L6 IOException -> L8
        Closeables.a(r5);     // Catch: IOException -> L17
    L24:
        goto L13
    L8:
        e = move-exception;
        if (FLogDefaultLoggingDelegate.f7658a.a(5) == false) goto L12;
        FLogDefaultLoggingDelegate.a(5, "DefaultImageDecoder", "read encode Image 64 byte", e);     // Catch: Throwable -> L6
    L12:
        Closeables.a(r5);     // Catch: IOException -> L17
    L6:
        th = move-exception;
        Closeables.a(r5);     // Catch: IOException -> L18
    L16:
        throw th;
    L13:
        StringBuilder r13 = new StringBuilder("ImageFormat:");
        r10.g();
        r13.append(r10.f8178b.f7973b);
        r13.append(":");
        r13.append(Arrays.toString(r11));
        return r13.toString();
    }

    public final CloseableStaticBitmap a(EncodedImage r10, ImageDecodeOptions r11) {
        Rect r5 = r10.f8183k;
        PlatformDecoder r12 = this.f8160a;
        DefaultDecoder r13 = (DefaultDecoder) r12;
        CloseableReference r14 = r13.a(r10, r11.f8043b, null);
        ImmutableQualityInfo r15 = ImmutableQualityInfo.d;     // Catch: Throwable -> L6
        r10.g();     // Catch: Throwable -> L6
        int r16 = r10.f8179c;     // Catch: Throwable -> L6
        r10.g();     // Catch: Throwable -> L6
        int r17 = r10.d;     // Catch: Throwable -> L6
        Rect r18 = r10.f8183k;     // Catch: Throwable -> L6
        int r19 = r10.g;     // Catch: Throwable -> L6
        r10.g();     // Catch: Throwable -> L6
        CloseableStaticBitmap r110 = new CloseableStaticBitmap(r14, r15, r16, r17, null, r18, r19, r10.f8178b);     // Catch: Throwable -> L6
        r14.close();
        return r110;
    L6:
        th = move-exception;
        r14.close();
        throw th;
    }
}
