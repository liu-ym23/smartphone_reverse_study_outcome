package ag;

import android.graphics.Movie;
import com.facebook.common.memory.PooledByteBufferInputStream;
import com.facebook.imagepipeline.animated.base.AnimatedImageResult;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.image.CloseableAnimatedImage;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.image.QualityInfo;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements ImageDecoder {
    @Override // com.facebook.imagepipeline.decoder.ImageDecoder
    public final CloseableImage a(EncodedImage r10, int r11, QualityInfo r12, ImageDecodeOptions r13) {
        InputStream r5 = r10.c();
        Movie r14 = Movie.decodeStream(r5);     // Catch: Throwable -> L6 IOException -> L8
        new m.b(r14);     // Catch: Throwable -> L6 IOException -> L8
        PooledByteBufferInputStream r15 = (PooledByteBufferInputStream) r5;     // Catch: Throwable -> L6 IOException -> L8
        r15.f7667b = r15.f7668c;     // Catch: Throwable -> L6 IOException -> L8
        b r16 = new b(r14);     // Catch: Throwable -> L6 IOException -> L8
        ArrayList r17 = r16.f163b;     // Catch: Throwable -> L6 IOException -> L8
        r16.a();     // Catch: Throwable -> L6 IOException -> L8
        int r18 = r17.size();     // Catch: Throwable -> L6 IOException -> L8
        e[] r19 = new e[r18];     // Catch: Throwable -> L6 IOException -> L8
        int r20 = 0;
    L4:
        if (r20 >= r18) goto L10;
        int r21 = ((Integer) r17.get(r20)).intValue();     // Catch: Throwable -> L6 IOException -> L8
        r14.width();     // Catch: Throwable -> L6 IOException -> L8
        r14.height();     // Catch: Throwable -> L6 IOException -> L8
        b.b();     // Catch: Throwable -> L6 IOException -> L8
        r19[r20] = new e(r21);     // Catch: Throwable -> L6 IOException -> L8
        r20 = r20 + 1;     // Catch: Throwable -> L6 IOException -> L8
        goto L4
    L10:
        r10.d();     // Catch: Throwable -> L6 IOException -> L8
        r14.duration();     // Catch: Throwable -> L6 IOException -> L8
        AnimatedImageResult r22 = AnimatedImageResult.forAnimatedImage(new d(r19));     // Catch: Throwable -> L6 IOException -> L8
        r10.g();     // Catch: Throwable -> L6 IOException -> L8
        CloseableAnimatedImage r23 = new CloseableAnimatedImage(r22, r13, r10.f8178b);     // Catch: Throwable -> L6 IOException -> L8
    L21:
        r5.close();     // Catch: IOException -> L17
    L12:
        return r23;
    L6:
        th = move-exception;
        r5.close();     // Catch: IOException -> L18
    L16:
        throw th;
    L8:
        e = move-exception;
        throw new RuntimeException("Error while decoding gif", e);     // Catch: Throwable -> L6
    }
}
