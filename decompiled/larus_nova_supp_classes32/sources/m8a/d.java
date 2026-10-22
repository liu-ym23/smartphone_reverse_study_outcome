package m8a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Shader;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.binaryresource.FileBinaryResource;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.common.memory.PooledByteBufferInputStream;
import com.facebook.common.references.CloseableReference;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.ui.image.n;
import com.lynx.tasm.utils.DisplayMetricsHolder;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class d {
    public static final int f = 0;
    public static final int g = 0;
    public final b a;
    public c b;
    public final Handler c;
    public int d;
    public boolean e;

    public static class a {
        public final int a;
        public final float b;
        public final float c;
        public final boolean d;
        public final ScalingUtils.ScaleType e;
        public final String f;
        public final Point g;
        public final String h;
        public final String i;

        public a(int r1, float r2, float r3, boolean r4, ScalingUtils.ScaleType r5, String r6, Point r7, String r8, String r9) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = new Point(r7.x, r7.y);
            this.h = r8;
            this.i = r9;
        }
    }

    public interface b {
        void onImageLoadFailed(String r1);

        void onImageLoadSuccess(c r1);
    }

    public static class c {
        public int a;
        public Rect b;
        public Rect c;
        public Bitmap d;
        public boolean e;
        public final a f;
        public CloseableReference<CloseableImage> g;

        public final void a() {
            Bitmap r0 = this.d;
            if (r0 != null) goto L5;
        L9:
            CloseableReference<CloseableImage> r1 = this.g;
            if (r1 == null) goto L13;
            r1.close();
            return;
        L13:
            return;
        L5:
            if (r0.isRecycled() == true) goto L9;
            if (this.e == true) goto L9;
            this.d.recycle();
            this.d = null;
            goto L9
        }

        public c(a r3) {
            this.a = 1;
            this.b = null;
            this.c = null;
            this.d = null;
            this.e = true;
            this.g = null;
            this.f = r3;
        }
    }

    static {
        f = Math.min(3379, 3379);
        g = Math.min(3379, 3379);
    }

    public final void f() {
        c r0 = this.b;
        if (r0 == null) goto L5;
        r0.a();
    L5:
        this.b = null;
    }

    public static void d(PooledByteBufferInputStream r0) {
        if (r0 == null) goto L10;
        r0.close();     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public static Point l(Canvas r3) {
        return new Point(Math.min(r3.getMaximumBitmapWidth(), f), Math.min(r3.getMaximumBitmapHeight(), g));
    }

    public final void o(c r3) {
        if (r3 == null) goto L24;
        Bitmap r0 = r3.d;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.isRecycled() == false) goto L9;
        return;
    L9:
        if (r3.f.a == this.d) goto L12;
        r3.a();
        return;
    L12:
        c r1 = this.b;
        if (r1 == null) goto L20;
        Bitmap r2 = r1.d;
        if (r2 == null) goto L20;
        if (r2.getWidth() < r3.d.getWidth()) goto L19;
        return;
    L19:
        if (this.b.d.getHeight() < r3.d.getHeight()) goto L20;
        return;
    L20:
        f();
        this.b = r3;
        b r4 = this.a;
        if (r4 == null) goto L28;
        r4.onImageLoadSuccess(r3);
        return;
    L28:
        return;
    }

    public d(b r2, int r3) {
        this.e = false;
        this.a = r2;
        this.c = new Handler(Looper.getMainLooper());
        this.d = r3;
    }

    public static c b(d r6, a r7) {
        r6.getClass();
        if (r7 != null) goto L5;
        return null;
    L5:
        if (TextUtils.isEmpty(r7.f) == true) goto L35;
        FileBinaryResource r1 = Fresco.getImagePipelineFactory().getMainFileCache().getResource(new SimpleCacheKey(r7.f));
        if (r1 == null) goto L14;
        if (r1.getFile() == null) goto L14;
        String r3 = null;
    L20:
        if (r3 == null) goto L30;
    L22:
        BitmapRegionDecoder r2 = BitmapRegionDecoder.newInstance(r3, false);     // Catch: Throwable -> L27
        BitmapFactory.Options r4 = new BitmapFactory.Options();     // Catch: Throwable -> L27
        c r8 = r6.m(r7, r2.getWidth(), r2.getHeight());     // Catch: Throwable -> L27
        if (r8 == null) goto L25;
        r4.inSampleSize = r8.a;     // Catch: Throwable -> L27
        r4.inPreferredConfig = Bitmap.Config.ARGB_8888;     // Catch: Throwable -> L27
        r8.d = r2.decodeRegion(r8.b, r4);     // Catch: Throwable -> L27
        r8.e = false;     // Catch: Throwable -> L27
    L25:
        r2.recycle();     // Catch: Throwable -> L27
        return r8;
    L27:
        th = move-exception;
        th.printStackTrace();
        return null;
    L30:
        r3 = r1.getFile().getPath();     // Catch: Throwable -> L27
    L14:
        if (r6.e == false) goto L33;
        int r5 = r7.f.indexOf("://");
        String r9 = r7.f;
        if (r5 <= 0) goto L18;
        int r10 = r5 + 3;
    L19:
        r3 = r9.substring(r10);
        goto L20
    L18:
        r10 = 0;
        goto L19
    L33:
        return null;
    L35:
        return null;
    }

    public final void k(Canvas r8, c r9) {
        if (r9 == null) goto L18;
        Bitmap r0 = r9.d;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.isRecycled() == true) goto L22;
        Paint r1 = new Paint();
        r1.setAntiAlias(true);
        r1.setFilterBitmap(true);
        a r10 = r9.f;
        if (r10.e == ScalingUtils.ScaleType.FIT_CENTER) goto L11;
    L13:
        Matrix r11 = new Matrix();
        Rect r2 = this.b.c;
        r11.preTranslate(r2.left, r2.top);
        c r3 = this.b;
        if (r3.e == false) goto L16;
        Rect r4 = r3.c;
        float r5 = (r4.right - r4.left) * 1.0f;
        Rect r6 = r3.b;
        r11.postScale(r5 / (r6.right - r6.left), ((r4.bottom - r4.top) * 1.0f) / (r6.bottom - r6.top));
        r8.drawBitmap(this.b.d, r11, r1);
        return;
    L16:
        Rect r7 = r3.c;
        float r12 = ((r7.right - r7.left) * 1.0f) / r3.d.getWidth();
        c r13 = this.b;
        Rect r14 = r13.c;
        r11.postScale(r12, ((r14.bottom - r14.top) * 1.0f) / r13.d.getHeight());
        r8.drawBitmap(this.b.d, r11, r1);
        return;
    L11:
        if (r10.d == false) goto L13;
        Bitmap r15 = this.b.d;
        Shader.TileMode r16 = Shader.TileMode.REPEAT;
        BitmapShader r17 = new BitmapShader(r15, r16, r16);
        Matrix r18 = new Matrix();
        float r19 = Math.min((r8.getWidth() * 1.0f) / this.b.d.getWidth(), (r8.getHeight() * 1.0f) / this.b.d.getHeight());
        r18.postScale(r19, r19);
        r17.setLocalMatrix(r18);
        r1.setShader(r17);
        r8.drawRect(new Rect(0, 0, r8.getWidth(), r8.getHeight()), r1);
        return;
    L22:
        return;
    }

    public static c a(d r5, Context r6, a r7) {
        r5.getClass();
        InputStream r8 = r6.getAssets().open(r7.f.substring(9));     // Catch: Throwable -> L8
        BitmapRegionDecoder r1 = BitmapRegionDecoder.newInstance(r8, false);     // Catch: Throwable -> L8
        BitmapFactory.Options r2 = new BitmapFactory.Options();     // Catch: Throwable -> L8
        c r9 = r5.m(r7, r1.getWidth(), r1.getHeight());     // Catch: Throwable -> L8
        if (r9 == null) goto L6;
        r2.inSampleSize = r9.a;     // Catch: Throwable -> L8
        r2.inPreferredConfig = Bitmap.Config.ARGB_8888;     // Catch: Throwable -> L8
        r9.d = r1.decodeRegion(r9.b, r2);     // Catch: Throwable -> L8
        r9.e = false;     // Catch: Throwable -> L8
    L6:
        r1.recycle();     // Catch: Throwable -> L8
        r8.close();     // Catch: Throwable -> L8
        return r9;
    L8:
        th = move-exception;
        LLog.e("LynxImageHelper", "loadBitmapFromAssetSync error: " + th.getMessage());
        return null;
    }

    public static void c(d r2, Context r3, a r4) {
        r2.getClass();
        if (r4 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r4.f) == true) goto L10;
        LLog.d("LynxImageHelper", "loadBitmapFromRemote");
        Uri r0 = UriProtector.parse(r4.f);
        ImagePipeline r1 = Fresco.getImagePipeline();
        ImageRequestBuilder r5 = ImageRequestBuilder.newBuilderWithSource(r0);
        e.a(r5);
        r1.fetchEncodedImage(r5.build(), r3).subscribe(new m8a.c(r2, r4), PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("BigImageDrawingHelper")));
        return;
    }

    public final c m(a r9, float r10, float r11) {
        if (r10 != 0.0f) goto L5;
        return null;
    L5:
        if (r11 == 0.0f) goto L43;
        float r1 = r9.b;
        if (r1 == 0.0f) goto L44;
        float r2 = r9.c;
        if (r2 == 0.0f) goto L45;
        c r0 = new c(r9);
        ScalingUtils.ScaleType r3 = r9.e;
        if (r3 != ScalingUtils.ScaleType.CENTER) goto L23;
        r0.b = new Rect();
        Rect r4 = new Rect();
        r0.c = r4;
        float r5 = r9.b;
        if (r10 > r5) goto L16;
        Rect r6 = r0.b;
        r6.left = 0;
        r6.right = (int) r10;
        r4.left = (int) ((r5 - r10) / 2.0f);
        r4.right = (int) ((r5 + r10) / 2.0f);
    L17:
        float r12 = r9.c;
        if (r11 > r12) goto L20;
        Rect r7 = r0.b;
        r7.top = 0;
        r7.bottom = (int) r11;
        r4.top = (int) ((r12 - r11) / 2.0f);
        r4.bottom = (int) ((r12 + r11) / 2.0f);
    L21:
        Rect r13 = r0.b;
        float r14 = r13.right - r13.left;
        float r15 = r13.bottom - r13.top;
        r0.a = e(r9.g, r14, r15, r14, r15);
    L38:
        if (this.e == false) goto L40;
        r0.a = 1;
    L40:
        return r0;
    L20:
        Rect r8 = r0.b;
        float r16 = (r11 - r12) / 2.0f;
        r8.top = (int) r16;
        r8.bottom = (int) (r11 - r16);
        r4.top = 0;
        r4.bottom = (int) r12;
        goto L21
    L16:
        Rect r17 = r0.b;
        float r18 = (r10 - r5) / 2.0f;
        r17.left = (int) r18;
        r17.right = (int) (r10 - r18);
        r4.left = 0;
        r4.right = (int) r5;
        goto L17
    L23:
        if (r3 != ScalingUtils.ScaleType.FIT_CENTER) goto L30;
        float r19 = r1 / r10;
        float r20 = r2 / r11;
        Rect r21 = new Rect();
        r0.b = r21;
        r21.top = 0;
        r21.bottom = (int) r11;
        r21.left = 0;
        r21.right = (int) r10;
        Rect r22 = new Rect();
        r0.c = r22;
        if (r19 > r20) goto L27;
        float r23 = r19 * r11;
        r22.left = 0;
        r22.right = (int) r9.b;
        float r24 = r9.c;
        r22.top = (int) ((r24 - r23) / 2.0f);
        r22.bottom = (int) ((r24 + r23) / 2.0f);
    L28:
        r0.a = e(r9.g, r22.right - r22.left, r22.bottom - r22.top, r10, r11);
        goto L38
    L27:
        float r25 = r20 * r10;
        r22.top = 0;
        r22.bottom = (int) r9.c;
        float r26 = r9.b;
        r22.left = (int) ((r26 - r25) / 2.0f);
        r22.right = (int) ((r26 + r25) / 2.0f);
        goto L28
    L30:
        if (r3 != ScalingUtils.ScaleType.CENTER_CROP) goto L36;
        float r27 = r1 / r10;
        float r28 = r2 / r11;
        Rect r29 = new Rect();
        r0.c = r29;
        r29.top = 0;
        r29.bottom = (int) r9.c;
        r29.left = 0;
        r29.right = (int) r9.b;
        Rect r30 = new Rect();
        r0.b = r30;
        if (r27 < r28) goto L34;
        float r31 = r9.c / r27;
        r30.left = 0;
        r30.right = (int) r10;
        r30.top = (int) ((r11 - r31) / 2.0f);
        r30.bottom = (int) ((r11 + r31) / 2.0f);
    L35:
        r0.a = e(r9.g, r9.b, r9.c, r30.right - r30.left, r30.bottom - r30.top);
        goto L38
    L34:
        float r32 = r9.b / r28;
        r30.left = (int) ((r10 - r32) / 2.0f);
        r30.right = (int) ((r32 + r10) / 2.0f);
        r30.top = 0;
        r30.bottom = (int) r11;
        goto L35
    L36:
        r0.b = new Rect(0, 0, (int) r10, (int) r11);
        r0.c = new Rect(0, 0, (int) r9.b, (int) r9.c);
        r0.a = e(r9.g, r9.b, r9.c, r10, r11);
        goto L38
    L45:
        return null;
    L44:
        return null;
    L43:
        return null;
    }

    public final void n(Context r21, ImageRequest r22, a r23) {
        if (r23 != null) goto L5;
    L33:
        if (r22 == null) goto L59;
        CacheKey r0 = Fresco.getImagePipeline().getCacheKeyFactory().getBitmapCacheKey(r22, null);     // Catch: Throwable -> L47
        if (Fresco.getImagePipeline().getBitmapMemoryCache().get(r0) == null) goto L54;
        CloseableReference<CloseableImage> r1 = Fresco.getImagePipeline().getBitmapMemoryCache().get(r0).clone();     // Catch: Throwable -> L47
        if (r1 != null) goto L40;
        return;
    L40:
        if (r1.get() != null) goto L42;
        return;
    L42:
        if ((r1.get() instanceof CloseableStaticBitmap) == false) goto L57;
        Bitmap r2 = ((CloseableStaticBitmap) r1.get()).getUnderlyingBitmap();     // Catch: Throwable -> L47
        c r3 = m(r23, r2.getWidth(), r2.getHeight());     // Catch: Throwable -> L47
        if (r3 == null) goto L58;
        r3.g = r1;     // Catch: Throwable -> L47
        r3.d = r2;     // Catch: Throwable -> L47
        o(r3);     // Catch: Throwable -> L47
        return;
    L58:
        return;
    L57:
        return;
    L54:
        return;
    L47:
        th = move-exception;
        LLog.e("BigImageDrawingHelper", "loadBitmapFromMemory failed: " + th.toString());
        return;
    L59:
        return;
    L5:
        if (TextUtils.isEmpty(r23.f) == true) goto L33;
        if (TextUtils.isEmpty(r23.f) == true) goto L10;
        String r16 = String.copyValueOf(r23.f.toCharArray());
    L11:
        a r4 = new a(r23.a, r23.b, r23.c, r23.d, r23.e, r16, r23.g, r23.h, r23.i);
        if (n.g == null) goto L14;
    L23:
        n r10 = n.g;
        m8a.b r11 = new m8a.b(this, r4, r21, r22, r23);
        r10.getClass();
        if (Looper.getMainLooper() != Looper.myLooper()) goto L33;
        Handler r5 = r10.f;
        if (r5 == null) goto L29;
        r5.post(r11);
        goto L33
    L29:
        if (r10.d != null) goto L31;
        r10.d = new LinkedList();
    L31:
        ((LinkedList) r10.d).add(r11);
        goto L33
    L14:
        monitor-enter(n.class);
    L20:
        th = move-exception;
        throw th;
    L16:
        if (n.g != null) goto L18;
        n.g = new n();     // Catch: Throwable -> L20
    L18:
        monitor-exit(n.class);     // Catch: Throwable -> L20
        goto L23
    L10:
        r16 = null;
        goto L11
    }

    public final boolean g(Context r7, Canvas r8, ImageRequest r9, a r10) {
        return h(r7, r8, r9, r10, DisplayMetricsHolder.getRealScreenDisplayMetrics(r7));
    }

    public final boolean i(Context r11, Canvas r12, ImageRequest r13, a r14) {
        this.e = true;
        c r1 = this.b;
        if (r1 != null) goto L5;
    L8:
        f();
        n(r11, r13, r14);
    L9:
        c r15 = this.b;
        if (r15 == null) goto L16;
        Bitmap r16 = r15.d;
        if (r16 == null) goto L18;
        l8a.a.customDraw((int) r14.b, (int) r14.c, r16.getWidth(), this.b.d.getHeight(), r14.e, r14.h, r14.i, r12, this.b.d);
        return true;
    L18:
        return false;
    L16:
        return false;
    L5:
        if (r1.d == null) goto L8;
        if (r1.f.a == r14.a) goto L9;
        goto L8
    }

    public final void j(Context r4, Canvas r5, ImageRequest r6, a r7) {
        this.e = true;
        c r0 = this.b;
        if (r0 != null) goto L5;
    L10:
        f();
        n(r4, r6, r7);
        k(r5, this.b);
        return;
    L5:
        if (r0.d == null) goto L10;
        if (r0.f.a != r7.a) goto L10;
        k(r5, r0);
    }

    public static int e(Point r2, float r3, float r4, float r5, float r6) {
        if (r6 != 0.0f) goto L5;
        return 32;
    L5:
        if (r5 == 0.0f) goto L30;
        float r7 = Math.min(Math.min(r3 / r5, r4 / r6), Math.min(r2.x / r5, r2.y / r6));
        int r8 = (int) (r5 * r7);
        int r9 = (int) (r7 * r6);
        if (r8 == 0) goto L29;
        if (r9 == 0) goto L31;
        float r10 = r9;
        int r11 = 1;
        if (r6 <= r10) goto L14;
    L17:
        int r12 = Math.round(r6 / r10);
        int r13 = Math.round(r5 / r8);
        if (r12 < r13) goto L21;
        r12 = r13;
    L21:
        int r14 = r11 * 2;
        if (r14 > r12) goto L24;
        r11 = r14;
        goto L21
    L24:
        return r11;
    L14:
        if (r5 > r8) goto L17;
        r12 = 1;
        goto L21
    L31:
        return 32;
    L29:
        return 32;
    L30:
        return 32;
    }

    public final boolean h(Context r4, Canvas r5, ImageRequest r6, a r7, DisplayMetrics r8) {
        if (r8 == null) goto L23;
        if (r7 == null) goto L23;
        if (r7.b <= (r8.widthPixels * 3)) goto L8;
    L12:
        this.e = false;
        LLog.d("LynxImageHelper", "drawBigImage: w:" + r7.b + ", h:" + r7.c);
        c r9 = this.b;
        if (r9 != null) goto L15;
    L20:
        f();
        n(r4, r6, r7);
        k(r5, this.b);
        return true;
    L15:
        if (r9.d == null) goto L20;
        if (r9.f.a != r7.a) goto L20;
        k(r5, r9);
        return true;
    L8:
        if (r7.c > r8.heightPixels) goto L12;
        if (r7.d == true) goto L12;
    L23:
        return false;
    }
}
