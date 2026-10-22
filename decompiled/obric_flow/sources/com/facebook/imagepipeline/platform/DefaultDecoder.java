package com.facebook.imagepipeline.platform;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.ColorSpace;
import android.graphics.Rect;
import android.util.Log;
import androidx.core.util.Pools;
import com.facebook.common.logging.FLogDefaultLoggingDelegate;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.DefaultCloseableReference;
import com.facebook.common.streams.LimitedInputStream;
import com.facebook.common.streams.TailAppendingInputStream;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.bitmaps.SimpleBitmapReleaser;
import com.facebook.imagepipeline.decoder.DefaultImageDecoder;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.BitmapPool;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
@TargetApi(11)
public abstract class DefaultDecoder implements PlatformDecoder {
    public static final byte[] d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BitmapPool f8251a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PreverificationHelper f8252b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Pools.SynchronizedPool f8253c;

    static {
        d = new byte[]{-1, -39};
    }

    public DefaultDecoder(BitmapPool r5, int r10, Pools.SynchronizedPool r11) {
        this.f8252b = new PreverificationHelper();
        this.f8251a = r5;
        this.f8253c = r11;
        int r12 = 0;
    L3:
        if (r12 >= r10) goto L5;
        this.f8253c.release(ByteBuffer.allocate(16384));
        r12 = r12 + 1;
        goto L3
    }

    public abstract int a(int r5, int r10, BitmapFactory.Options r11);

    public final CloseableReference a(EncodedImage r5, Bitmap.Config r10, Rect r11) {
        BitmapFactory.Options r12 = a(r5, r10);
        if (r12.inPreferredConfig == Bitmap.Config.ARGB_8888) goto L5;
        boolean r13 = true;
    L13:
        return a(r5.c(), r12, r11);
    L8:
        e = move-exception;
        if (r13 == true) goto L11;
        throw e;
    L11:
        return a(r5, Bitmap.Config.ARGB_8888, r11);
    L5:
        r13 = false;
        goto L13
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final DefaultCloseableReference a(InputStream r10, BitmapFactory.Options r11, Rect r12) {
        r10.getClass();
        int r5 = r11.outWidth;
        int r13 = r11.outHeight;
        BitmapRegionDecoder r14 = r5;
        if (r12 == null) goto L5;
        int r15 = r12.width() / r11.inSampleSize;
        r13 = r12.height() / r11.inSampleSize;
        r14 = r15;
    L5:
        PreverificationHelper r16 = this.f8252b;
        if (r16 != null) goto L8;
    L10:
        boolean r17 = false;
    L12:
        if (r12 != null) goto L15;
        if (r17 == false) goto L15;
        r11.inMutable = false;
        Bitmap r18 = 0;
    L20:
        r11.inBitmap = r18;
        r11.inPreferredColorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
        ByteBuffer r19 = (ByteBuffer) this.f8253c.acquire();
        if (r19 != null) goto L94;
        r19 = ByteBuffer.allocate(16384);
    L94:
        r11.inTempStorage = r19.array();     // Catch: Throwable -> L30 OutOfMemoryError -> L32 RuntimeException -> L34 IllegalArgumentException -> L36
        if (r12 != null) goto L91;
    L51:
        Bitmap r110 = null;
    L52:
        if (r110 == null) goto L88;
    L58:
        this.f8253c.release(r19);
        if (r18 == 0) goto L65;
        if (r18 == r110) goto L65;
        this.f8251a.release(r18);
        r110.recycle();
        throw new IllegalStateException();
    L65:
        return CloseableReference.a(r110, this.f8251a, CloseableReference.f);
    L88:
        r10.reset();     // Catch: Throwable -> L30 OutOfMemoryError -> L32 RuntimeException -> L34 IllegalArgumentException -> L36 IOException -> L55
    L57:
        r110 = a(r10, r11);     // Catch: Throwable -> L30 OutOfMemoryError -> L32 RuntimeException -> L34 IllegalArgumentException -> L36
    L55:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L30 OutOfMemoryError -> L32 RuntimeException -> L34 IllegalArgumentException -> L36
        goto L57
    L91:
        if (r18 == 0) goto L51;
        r18.reconfigure(r14, r13, r11.inPreferredConfig);     // Catch: Throwable -> L40 IOException -> L42
        BitmapRegionDecoder r20 = BitmapRegionDecoder.newInstance(r10, true);     // Catch: Throwable -> L40 IOException -> L42
        r110 = r20.decodeRegion(r12, r11);     // Catch: Throwable -> L38 IOException -> L87
        r20.recycle();     // Catch: Throwable -> L30 OutOfMemoryError -> L32 RuntimeException -> L34 IllegalArgumentException -> L36
    L44:
        if (FLogDefaultLoggingDelegate.f7658a.a(6) == false) goto L46;
        Log.println(6, FLogDefaultLoggingDelegate.a("DefaultDecoder"), "Could not decode region " + r12 + ", decoding full bitmap instead.");     // Catch: Throwable -> L38
    L46:
        if (r20 == null) goto L51;
        r20.recycle();     // Catch: Throwable -> L30 OutOfMemoryError -> L32 RuntimeException -> L34 IllegalArgumentException -> L36
        goto L51
    L42:
        r20 = null;
    L40:
        th = th;
        r14 = 0;
    L48:
        if (r14 == 0) goto L50;
        r14.recycle();     // Catch: Throwable -> L30 OutOfMemoryError -> L32 RuntimeException -> L34 IllegalArgumentException -> L36
    L50:
        throw th;     // Catch: Throwable -> L30 OutOfMemoryError -> L32 RuntimeException -> L34 IllegalArgumentException -> L36
    L38:
        th = th;
    L30:
        th = move-exception;
        this.f8253c.release(r19);
        throw th;
    L36:
        e = move-exception;
        if (r18 == 0) goto L90;
        this.f8251a.release(r18);     // Catch: Throwable -> L30
    L90:
        r10.reset();     // Catch: Throwable -> L30 IOException -> L82
        BitmapFactory.Options r21 = new BitmapFactory.Options();     // Catch: Throwable -> L30 IOException -> L82
        r21.inMutable = true;     // Catch: Throwable -> L30 IOException -> L82
        r21.inSampleSize = r11.inSampleSize;     // Catch: Throwable -> L30 IOException -> L82
        Bitmap r111 = BitmapFactory.decodeStream(r10, null, r21);     // Catch: Throwable -> L30 IOException -> L82
        if (r111 != null) goto L76;
        throw e;     // Catch: Throwable -> L30 IOException -> L82
    L76:
        if (SimpleBitmapReleaser.f7989a != null) goto L78;
        SimpleBitmapReleaser.f7989a = new SimpleBitmapReleaser();     // Catch: Throwable -> L30 IOException -> L82
    L78:
        DefaultCloseableReference r112 = CloseableReference.a(r111, SimpleBitmapReleaser.f7989a, CloseableReference.f);     // Catch: Throwable -> L30 IOException -> L82
        this.f8253c.release(r19);
        return r112;
    L82:
        throw e;     // Catch: Throwable -> L30
    L32:
        e = move-exception;
        this.f8251a.release(r18);     // Catch: Throwable -> L30
        throw e;     // Catch: Throwable -> L30
    L34:
        e = move-exception;
        if (r18 == 0) goto L70;
        this.f8251a.release(r18);     // Catch: Throwable -> L30
    L70:
        throw e;     // Catch: Throwable -> L30
    L15:
        if (r12 == null) goto L18;
        if (r17 == false) goto L18;
        r11.inPreferredConfig = Bitmap.Config.ARGB_8888;
    L18:
        Bitmap r22 = (Bitmap) this.f8251a.get(a(r14, r13, r11));
        r18 = r22;
        if (r22 != null) goto L20;
        throw new NullPointerException("BitmapPool.get returned null");
    L8:
        if (r16.shouldUseHardwareBitmapConfig(r11.inPreferredConfig) == false) goto L10;
        r17 = true;
        goto L12
    }

    public Bitmap a(InputStream r5, BitmapFactory.Options r10) {
        return BitmapFactory.decodeStream(r5, null, r10);
    }

    public static BitmapFactory.Options a(EncodedImage r5, Bitmap.Config r10) {
        BitmapFactory.Options r11 = new BitmapFactory.Options();
        r11.inSampleSize = r5.g;
        r11.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(r5.c(), null, r11);
        if (r11.outWidth == (-1)) goto L9;
        if (r11.outHeight == (-1)) goto L9;
        r11.inJustDecodeBounds = false;
        r11.inDither = true;
        r11.inPreferredConfig = r10;
        r11.inMutable = true;
        return r11;
    L9:
        throw new IllegalArgumentException(DefaultImageDecoder.a(r5));
    }

    public final CloseableReference a(EncodedImage r10, Bitmap.Config r11, Rect r12, int r13) {
        ImageFormat r5 = r10.f8178b;
        ImageFormat r14 = DefaultImageFormats.f7962a;
        boolean r15 = false;
        if (r5 != r14) goto L5;
    L9:
        r10.f8177a.getClass();
        CloseableReference r16 = r10.f8177a;
        monitor-enter(r16);
        Object r17 = r16.f7671b.d();     // Catch: Throwable -> L44
        monitor-exit(r16);     // Catch: Throwable -> L44
        PooledByteBuffer r18 = (PooledByteBuffer) r17;
        ImageFormat r19 = r10.f8178b;
        if (r19 != r14) goto L21;
        if (r18.a(r13 - 2) == (-1)) goto L18;
    L27:
        boolean r20 = false;
    L29:
        BitmapFactory.Options r21 = a(r10, r11);
        InputStream r22 = r10.c();
        r22.getClass();
        if (r10.d() <= r13) goto L32;
        r22 = new LimitedInputStream(r22, r13);
    L32:
        if (r20 == true) goto L35;
        r22 = new TailAppendingInputStream(r22, d);
    L35:
        if (r21.inPreferredConfig == Bitmap.Config.ARGB_8888) goto L47;
        r15 = true;
    L47:
        return a(r22, r21, r12);
    L39:
        e = move-exception;
        if (r15 == true) goto L42;
        throw e;
    L42:
        return a(r10, Bitmap.Config.ARGB_8888, r12, r13);
    L18:
        if (r18.a(r13 - 1) != (-39)) goto L27;
    L28:
        r20 = true;
        goto L29
    L21:
        if (r19 != DefaultImageFormats.f7967j) goto L28;
        int r23 = r10.f8182j;
        if (r23 == 0) goto L28;
        if (r23 != 3) goto L27;
    L44:
        th = move-exception;
        throw th;
    L5:
        if (r5 == DefaultImageFormats.f7967j) goto L9;
        if (r5 == DefaultImageFormats.f7970m) goto L9;
        goto L9
    }
}
