package oo;

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
import com.facebook.binaryresource.FileBinaryResource;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.cache.disk.DiskStorageCache;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.AbstractDataSource;
import com.facebook.datasource.DataSources;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.imagepipeline.cache.BitmapMemoryCacheKey;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.lynx.base.log.LynxLog;
import com.lynx.tasm.ui.image.d0;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes2.dex */
public final class e {
    public static final int f = 0;
    public static final int g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f20799a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d f20800b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Handler f20801c;
    public int d;
    public boolean e;

    static {
        f = Math.min(3379, 3379);
        g = Math.min(3379, 3379);
    }

    public e(c r5, int r10) {
        this.e = false;
        this.f20799a = r5;
        this.f20801c = new Handler(Looper.getMainLooper());
        this.d = r10;
    }

    public static int a(Point r5, float r10, float r11, float r12, float r13) {
        if (r13 != 0.0f) goto L5;
    L25:
        return 32;
    L5:
        if (r12 == 0.0f) goto L25;
        float r14 = Math.min(Math.min(r10 / r12, r11 / r13), Math.min(r5.x / r12, r5.y / r13));
        int r15 = (int) (r12 * r14);
        int r16 = (int) (r14 * r13);
        if (r15 == 0) goto L25;
        if (r16 == 0) goto L25;
        float r17 = r16;
        int r18 = 1;
        if (r13 <= r17) goto L14;
    L17:
        int r19 = Math.round(r13 / r17);
        int r20 = Math.round(r12 / r15);
        if (r19 < r20) goto L21;
        r19 = r20;
    L21:
        int r21 = r18 * 2;
        if (r21 > r19) goto L24;
        r18 = r21;
        goto L21
    L24:
        return r18;
    L14:
        if (r12 > r15) goto L17;
        r19 = 1;
        goto L21
    }

    public static Point b(Canvas r5) {
        return new Point(Math.min(r5.getMaximumBitmapWidth(), f), Math.min(r5.getMaximumBitmapHeight(), g));
    }

    public static d d(e r5, Context r10, b r11) {
        r5.getClass();
        InputStream r12 = r10.getAssets().open(r11.f.substring(9));     // Catch: Throwable -> L6
        BitmapRegionDecoder r13 = BitmapRegionDecoder.newInstance(r12, false);     // Catch: Throwable -> L6
        BitmapFactory.Options r14 = new BitmapFactory.Options();     // Catch: Throwable -> L6
        d r15 = r5.c(r11, r13.getWidth(), r13.getHeight());     // Catch: Throwable -> L6
        if (r15 == null) goto L8;
        r14.inSampleSize = r15.f20796a;     // Catch: Throwable -> L6
        r14.inPreferredConfig = Bitmap.Config.ARGB_8888;     // Catch: Throwable -> L6
        r15.d = r13.decodeRegion(r15.f20797b, r14);     // Catch: Throwable -> L6
        r15.e = false;     // Catch: Throwable -> L6
    L8:
        r13.recycle();     // Catch: Throwable -> L6
        r12.close();     // Catch: Throwable -> L6
        return r15;
    L6:
        th = move-exception;
        LynxLog.b(4, "LynxImageHelper", "loadBitmapFromAssetSync error: " + th.getMessage());
        return null;
    }

    public static d e(e r10, b r11) {
        r10.getClass();
        String r5 = r11.f;
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return null;
    L5:
        FileBinaryResource r12 = (FileBinaryResource) ((DiskStorageCache) Fresco.a().g()).a(new SimpleCacheKey(r5));
        if (r12 == null) goto L9;
        String r13 = null;
    L15:
        if (r13 == null) goto L26;
    L19:
        BitmapRegionDecoder r14 = BitmapRegionDecoder.newInstance(r13, false);     // Catch: Throwable -> L17
        BitmapFactory.Options r15 = new BitmapFactory.Options();     // Catch: Throwable -> L17
        d r16 = r10.c(r11, r14.getWidth(), r14.getHeight());     // Catch: Throwable -> L17
        if (r16 == null) goto L22;
        r15.inSampleSize = r16.f20796a;     // Catch: Throwable -> L17
        r15.inPreferredConfig = Bitmap.Config.ARGB_8888;     // Catch: Throwable -> L17
        r16.d = r14.decodeRegion(r16.f20797b, r15);     // Catch: Throwable -> L17
        r16.e = false;     // Catch: Throwable -> L17
    L22:
        r14.recycle();     // Catch: Throwable -> L17
        return r16;
    L17:
        th = move-exception;
        th.printStackTrace();
    L25:
        return null;
    L26:
        r13 = r12.f7574a.getPath();     // Catch: Throwable -> L17
        goto L19
    L9:
        if (r10.e == false) goto L25;
        int r17 = r5.indexOf("://");
        if (r17 <= 0) goto L13;
        int r18 = r17 + 3;
    L14:
        r13 = r5.substring(r18);
        goto L15
    L13:
        r18 = 0;
        goto L14
    }

    public static void k(e r10, Context r11, b r12) {
        r10.getClass();
        String r5 = r12.f;
        if (TextUtils.isEmpty(r5) == true) goto L19;
        LynxLog.b(1, "LynxImageHelper", "loadBitmapFromRemote");
        Uri r13 = Uri.parse(r5);
        ImagePipeline r14 = Fresco.a().e();
        ImageRequestBuilder r15 = ImageRequestBuilder.a(r13);
        Method r16 = g.f20803a;
        g.b(r15, Bitmap.Config.ARGB_8888, false);
        ImageRequest r17 = r15.a();
        r14.getClass();
        r17.f8415b.getClass();
        Producer r18 = r14.f8063a.d(r17);     // Catch: Exception -> L10
        if (r17.g == null) goto L9;
        ImageRequestBuilder r19 = ImageRequestBuilder.a(r17);     // Catch: Exception -> L10
        r19.f8436c = null;     // Catch: Exception -> L10
        r17 = r19.a();     // Catch: Exception -> L10
    L9:
        ImageRequest r20 = r17;
        AbstractDataSource r110 = r14.a(r18, r20, ImageRequest.RequestLevel.f8431b, r11, null, r20.f8418i);     // Catch: Exception -> L10
    L15:
        r110.a(new a(r10, r12), Executors.newSingleThreadExecutor());
        return;
    L10:
        e = move-exception;
        r110 = DataSources.a(e);
        goto L15
    }

    public final d c(b r10, float r11, float r12) {
        if (r11 != 0.0f) goto L5;
        return null;
    L5:
        if (r12 == 0.0f) goto L43;
        float r5 = r10.f20792b;
        if (r5 == 0.0f) goto L44;
        float r13 = r10.f20793c;
        if (r13 == 0.0f) goto L45;
        d r14 = new d(r10);
        ScalingUtils.ScaleType r15 = ScalingUtils.ScaleType.e;
        Point r16 = r10.g;
        ScalingUtils.ScaleType r17 = r10.e;
        if (r17 != r15) goto L23;
        r14.f20797b = new Rect();
        Rect r18 = new Rect();
        r14.f20798c = r18;
        if (r11 > r5) goto L16;
        Rect r19 = r14.f20797b;
        r19.left = 0;
        r19.right = (int) r11;
        r18.left = (int) ((r5 - r11) / 2.0f);
        r18.right = (int) ((r5 + r11) / 2.0f);
    L18:
        if (r12 > r13) goto L20;
        Rect r110 = r14.f20797b;
        r110.top = 0;
        r110.bottom = (int) r12;
        r18.top = (int) ((r13 - r12) / 2.0f);
        r18.bottom = (int) ((r13 + r12) / 2.0f);
    L21:
        Rect r111 = r14.f20797b;
        float r112 = r111.right - r111.left;
        float r113 = r111.bottom - r111.top;
        r14.f20796a = a(r16, r112, r113, r112, r113);
    L38:
        if (this.e == false) goto L40;
        r14.f20796a = 1;
    L40:
        return r14;
    L20:
        Rect r20 = r14.f20797b;
        float r114 = (r12 - r13) / 2.0f;
        r20.top = (int) r114;
        r20.bottom = (int) (r12 - r114);
        r18.top = 0;
        r18.bottom = (int) r13;
        goto L21
    L16:
        Rect r21 = r14.f20797b;
        float r22 = (r11 - r5) / 2.0f;
        r21.left = (int) r22;
        r21.right = (int) (r11 - r22);
        r18.left = 0;
        r18.right = (int) r5;
        goto L18
    L23:
        if (r17 != ScalingUtils.ScaleType.f7895c) goto L30;
        float r115 = r5 / r11;
        float r23 = r13 / r12;
        Rect r24 = new Rect();
        r14.f20797b = r24;
        r24.top = 0;
        r24.bottom = (int) r12;
        r24.left = 0;
        r24.right = (int) r11;
        Rect r25 = new Rect();
        r14.f20798c = r25;
        if (r115 > r23) goto L27;
        float r116 = r115 * r12;
        r25.left = 0;
        r25.right = (int) r5;
        r25.top = (int) ((r13 - r116) / 2.0f);
        r25.bottom = (int) ((r13 + r116) / 2.0f);
    L28:
        r14.f20796a = a(r16, r25.right - r25.left, r25.bottom - r25.top, r11, r12);
        goto L38
    L27:
        float r26 = r23 * r11;
        r25.top = 0;
        r25.bottom = (int) r13;
        r25.left = (int) ((r5 - r26) / 2.0f);
        r25.right = (int) ((r5 + r26) / 2.0f);
        goto L28
    L30:
        if (r17 != ScalingUtils.ScaleType.g) goto L36;
        float r117 = r5 / r11;
        float r27 = r13 / r12;
        Rect r28 = new Rect();
        r14.f20798c = r28;
        r28.top = 0;
        r28.bottom = (int) r13;
        r28.left = 0;
        r28.right = (int) r5;
        Rect r29 = new Rect();
        r14.f20797b = r29;
        if (r117 < r27) goto L34;
        float r118 = r13 / r117;
        r29.left = 0;
        r29.right = (int) r11;
        r29.top = (int) ((r12 - r118) / 2.0f);
        r29.bottom = (int) ((r12 + r118) / 2.0f);
    L35:
        r14.f20796a = a(r16, r5, r13, r29.right - r29.left, r29.bottom - r29.top);
        goto L38
    L34:
        float r119 = r5 / r27;
        r29.left = (int) ((r11 - r119) / 2.0f);
        r29.right = (int) ((r11 + r119) / 2.0f);
        r29.top = 0;
        r29.bottom = (int) r12;
        goto L35
    L36:
        r14.f20797b = new Rect(0, 0, (int) r11, (int) r12);
        r14.f20798c = new Rect(0, 0, (int) r5, (int) r13);
        r14.f20796a = a(r16, r5, r13, r11, r12);
        goto L38
    L45:
        return null;
    L44:
        return null;
    L43:
        return null;
    }

    public final void f() {
        d r5 = this.f20800b;
        if (r5 == null) goto L14;
        Bitmap r10 = r5.d;
        if (r10 != null) goto L7;
    L11:
        CloseableReference r11 = r5.g;
        if (r11 == null) goto L14;
        r11.close();
        goto L14
    L7:
        if (r10.isRecycled() == true) goto L11;
        if (r5.e == true) goto L11;
        r5.d.recycle();
        r5.d = null;
    L14:
        this.f20800b = null;
    }

    public final void g(Context r22, ImageRequest r23, b r24) {
        if (TextUtils.isEmpty(r24.f) == false) goto L6;
    L19:
        if (r23 == null) goto L48;
        BitmapMemoryCacheKey r5 = Fresco.a().e().f.a(r23, null);     // Catch: Throwable -> L34
        if (Fresco.a().e().e.a(r5) == null) goto L44;
        CloseableReference r10 = Fresco.a().e().e.a(r5).clone();     // Catch: Throwable -> L34
        monitor-enter(r10);     // Catch: Throwable -> L34
        Object r11 = r10.f7671b.d();     // Catch: Throwable -> L36
        monitor-exit(r10);     // Catch: Throwable -> L36
        if (r11 != null) goto L29;
        return;
    L29:
        if ((r10.c() instanceof CloseableStaticBitmap) == false) goto L46;
        Bitmap r12 = ((CloseableStaticBitmap) r10.c()).g;     // Catch: Throwable -> L34
        d r13 = c(r24, r12.getWidth(), r12.getHeight());     // Catch: Throwable -> L34
        if (r13 == null) goto L47;
        r13.g = r10;     // Catch: Throwable -> L34
        r13.d = r12;     // Catch: Throwable -> L34
        i(r13);     // Catch: Throwable -> L34
        return;
    L47:
        return;
    L46:
        return;
    L36:
        th = move-exception;
        throw th;     // Catch: Throwable -> L34
    L44:
        return;
    L34:
        th = move-exception;
        LynxLog.b(4, "BigImageDrawingHelper", "loadBitmapFromMemory failed: " + th.toString());
        return;
    L48:
        return;
    L6:
        if (TextUtils.isEmpty(r24.f) == true) goto L8;
        String r17 = String.copyValueOf(r24.f.toCharArray());
    L9:
        b r14 = new b(r24.f20791a, r24.f20792b, r24.f20793c, r24.d, r24.e, r17, r24.g, r24.f20794h, r24.f20795i);
        d0 r15 = d0.a();
        com.bytedance.apm.e r16 = new com.bytedance.apm.e(this, r14, r22, r24, 14, false);
        r15.getClass();
        if (Looper.getMainLooper() != Looper.myLooper()) goto L19;
        Handler r18 = r15.d;
        if (r18 == null) goto L15;
        r18.post(r16);
        goto L19
    L15:
        if (r15.f11037b != null) goto L17;
        r15.f11037b = new LinkedList();
    L17:
        r15.f11037b.add(r16);
        goto L19
    L8:
        r17 = null;
        goto L9
    }

    public final void h(Canvas r10, d r11) {
        if (r11 == null) goto L20;
        Bitmap r5 = r11.d;
        if (r5 != null) goto L6;
        return;
    L6:
        if (r5.isRecycled() == true) goto L22;
        Paint r12 = new Paint();
        r12.setAntiAlias(true);
        r12.setFilterBitmap(true);
        b r13 = r11.f;
        if (r13.e == ScalingUtils.ScaleType.f7895c) goto L11;
    L14:
        Matrix r14 = new Matrix();
        Rect r15 = this.f20800b.f20798c;
        r14.preTranslate(r15.left, r15.top);
        d r16 = this.f20800b;
        if (r16.e == false) goto L18;
        Rect r17 = r16.f20798c;
        float r18 = (r17.right - r17.left) * 1.0f;
        Rect r19 = r16.f20797b;
        r14.postScale(r18 / (r19.right - r19.left), ((r17.bottom - r17.top) * 1.0f) / (r19.bottom - r19.top));
        r10.drawBitmap(this.f20800b.d, r14, r12);
        return;
    L18:
        Rect r20 = r16.f20798c;
        float r21 = ((r20.right - r20.left) * 1.0f) / r16.d.getWidth();
        d r22 = this.f20800b;
        Rect r23 = r22.f20798c;
        r14.postScale(r21, ((r23.bottom - r23.top) * 1.0f) / r22.d.getHeight());
        r10.drawBitmap(this.f20800b.d, r14, r12);
        return;
    L11:
        if (r13.d == false) goto L14;
        Bitmap r24 = this.f20800b.d;
        Shader.TileMode r25 = Shader.TileMode.REPEAT;
        BitmapShader r26 = new BitmapShader(r24, r25, r25);
        Matrix r27 = new Matrix();
        float r28 = Math.min((r10.getWidth() * 1.0f) / this.f20800b.d.getWidth(), (r10.getHeight() * 1.0f) / this.f20800b.d.getHeight());
        r27.postScale(r28, r28);
        r26.setLocalMatrix(r27);
        r12.setShader(r26);
        r10.drawRect(new Rect(0, 0, r10.getWidth(), r10.getHeight()), r12);
        return;
    L22:
        return;
    }

    public final void i(d r5) {
        Bitmap r10 = r5.d;
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.isRecycled() == false) goto L8;
        return;
    L8:
        if (r5.f.f20791a == this.d) goto L20;
        Bitmap r11 = r5.d;
        if (r11 != null) goto L12;
    L16:
        CloseableReference r12 = r5.g;
        if (r12 == null) goto L31;
        r12.close();
        return;
    L31:
        return;
    L12:
        if (r11.isRecycled() == true) goto L16;
        if (r5.e == true) goto L16;
        r5.d.recycle();
        r5.d = null;
        goto L16
    L20:
        d r13 = this.f20800b;
        if (r13 == null) goto L28;
        Bitmap r14 = r13.d;
        if (r14 == null) goto L28;
        if (r14.getWidth() < r5.d.getWidth()) goto L27;
        return;
    L27:
        if (this.f20800b.d.getHeight() < r5.d.getHeight()) goto L28;
        return;
    L28:
        f();
        this.f20800b = r5;
        this.f20799a.a();
    }

    public final boolean j(Context r11, Canvas r12, ImageRequest r13, b r14) {
        this.e = true;
        d r5 = this.f20800b;
        if (r5 != null) goto L5;
    L8:
        f();
        g(r11, r13, r14);
    L9:
        d r15 = this.f20800b;
        if (r15 == null) goto L16;
        Bitmap r16 = r15.d;
        if (r16 == null) goto L18;
        int r10 = (int) r14.f20792b;
        int r17 = (int) r14.f20793c;
        int r18 = r16.getWidth();
        int r19 = this.f20800b.d.getHeight();
        Bitmap r20 = this.f20800b.d;
        String r21 = r14.f20794h;
        String r22 = r14.f20795i;
        no.a.b(r10, r17, r18, r19, r14.e, r21, r22, r12, r20);
        return true;
    L18:
        return false;
    L16:
        return false;
    L5:
        if (r5.d == null) goto L8;
        if (r5.f.f20791a == r14.f20791a) goto L9;
        goto L8
    }
}
