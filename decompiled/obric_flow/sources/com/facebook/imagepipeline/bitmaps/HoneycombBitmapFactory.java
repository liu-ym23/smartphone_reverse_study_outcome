package com.facebook.imagepipeline.bitmaps;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.util.Log;
import com.facebook.common.logging.FLogDefaultLoggingDelegate;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.DefaultCloseableReference;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imagepipeline.core.CloseableReferenceFactory;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.MemoryPooledByteBufferFactory;
import com.facebook.imagepipeline.memory.MemoryPooledByteBufferOutputStream;
import com.facebook.imagepipeline.platform.DefaultDecoder;
import com.facebook.imagepipeline.platform.PlatformDecoder;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
@TargetApi(11)
public class HoneycombBitmapFactory extends PlatformBitmapFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EmptyJpegGenerator f7986a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PlatformDecoder f7987b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CloseableReferenceFactory f7988c;
    public boolean d;

    public HoneycombBitmapFactory(EmptyJpegGenerator r5, PlatformDecoder r10, CloseableReferenceFactory r11) {
        this.f7986a = r5;
        this.f7987b = r10;
        this.f7988c = r11;
    }

    @Override // com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory
    public final CloseableReference a(int r11, int r12, Bitmap.Config r13) {
        if (this.d == false) goto L9;
        CloseableReferenceFactory r10 = this.f7988c;
        Bitmap r14 = Bitmap.createBitmap(r11, r12, r13);
        if (SimpleBitmapReleaser.f7989a != null) goto L8;
        SimpleBitmapReleaser.f7989a = new SimpleBitmapReleaser();
    L8:
        return CloseableReference.a(r14, SimpleBitmapReleaser.f7989a, r10.f8057a);
    L9:
        short r5 = (short) r11;
        short r15 = (short) r12;
        MemoryPooledByteBufferOutputStream r16 = null;
        PooledByteBufferFactory r17 = this.f7986a.f7985a;     // Catch: Throwable -> L50 IOException -> L52
        byte[] r18 = EmptyJpegGenerator.f7983b;     // Catch: Throwable -> L50 IOException -> L52
        byte[] r19 = EmptyJpegGenerator.f7984c;     // Catch: Throwable -> L50 IOException -> L52
        MemoryPooledByteBufferFactory r20 = (MemoryPooledByteBufferFactory) r17;     // Catch: Throwable -> L50 IOException -> L52
        r20.getClass();     // Catch: Throwable -> L50 IOException -> L52
        MemoryPooledByteBufferOutputStream r21 = new MemoryPooledByteBufferOutputStream(r20.f8231b, 543);     // Catch: Throwable -> L50 IOException -> L52
        r21.write(r18);     // Catch: IOException -> L45 Throwable -> L47
        r21.write(new byte[]{(byte) (r15 >> 8)});     // Catch: IOException -> L45 Throwable -> L47
        r21.write(new byte[]{(byte) (r15 & 255)});     // Catch: IOException -> L45 Throwable -> L47
        r21.write(new byte[]{(byte) (r5 >> 8)});     // Catch: IOException -> L45 Throwable -> L47
        r21.write(new byte[]{(byte) (r5 & 255)});     // Catch: IOException -> L45 Throwable -> L47
        r21.write(r19);     // Catch: IOException -> L45 Throwable -> L47
        DefaultCloseableReference r22 = CloseableReference.a(r21.b(), CloseableReference.e, CloseableReference.f);     // Catch: IOException -> L45 Throwable -> L47
        r21.close();
        EncodedImage r23 = new EncodedImage(r22);     // Catch: Throwable -> L32
        r23.f8178b = DefaultImageFormats.f7962a;     // Catch: Throwable -> L32
        PlatformDecoder r24 = this.f7987b;     // Catch: Throwable -> L23
        monitor-enter(r22);     // Catch: Throwable -> L23
        Object r25 = r22.f7671b.d();     // Catch: Throwable -> L38
        monitor-exit(r22);     // Catch: Throwable -> L38
        CloseableReference r26 = ((DefaultDecoder) r24).a(r23, r13, null, ((PooledByteBuffer) r25).size());     // Catch: Throwable -> L23
        if (((Bitmap) r26.c()).isMutable() == true) goto L34;
        r26.close();     // Catch: Throwable -> L23
        this.d = true;     // Catch: Throwable -> L23
        if (FLogDefaultLoggingDelegate.f7658a.a(6) == false) goto L25;
        Log.println(6, FLogDefaultLoggingDelegate.a("HoneycombBitmapFactory"), "Immutable bitmap returned by decoder");     // Catch: Throwable -> L23
    L25:
        CloseableReferenceFactory r110 = this.f7988c;     // Catch: Throwable -> L23
        Bitmap r111 = Bitmap.createBitmap(r11, r12, r13);     // Catch: Throwable -> L23
        if (SimpleBitmapReleaser.f7989a != null) goto L28;
        SimpleBitmapReleaser.f7989a = new SimpleBitmapReleaser();     // Catch: Throwable -> L23
    L28:
        DefaultCloseableReference r112 = CloseableReference.a(r111, SimpleBitmapReleaser.f7989a, r110.f8057a);     // Catch: Throwable -> L23
        r23.close();     // Catch: Throwable -> L32
        r22.close();
        return r112;
    L34:
        ((Bitmap) r26.c()).setHasAlpha(true);     // Catch: Throwable -> L23
        ((Bitmap) r26.c()).eraseColor(0);     // Catch: Throwable -> L23
        r23.close();     // Catch: Throwable -> L32
        r22.close();
        return r26;
    L38:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        r23.close();     // Catch: Throwable -> L32
        throw th;     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        r22.close();
        throw th;
    L45:
        e = e;
        r16 = r21;
    L54:
        throw new RuntimeException(e);     // Catch: Throwable -> L50
    L47:
        th = th;
    L56:
        if (r21 == null) goto L58;
        r21.close();
    L58:
        throw th;
    L52:
        e = e;
    L50:
        th = th;
        r21 = r16;
        goto L56
    }
}
