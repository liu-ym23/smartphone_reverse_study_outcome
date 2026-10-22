package com.lynx.tasm.ui.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.graphics.Shader;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.nativecode.NativeBlurFilter;
import com.facebook.imagepipeline.request.BasePostprocessor;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public final class k extends BasePostprocessor {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f11065c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f11066h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f11067i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f11068j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f11069k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f11070l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f11071m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ScalingUtils.ScaleType f11072n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final WeakReference f11073o;

    public k(int r5, int r10, int r11, int r12, int r13, int r14, ScalingUtils.ScaleType r15, int r16, int r17, int r18, int r19, int r110, Context r111) {
        this.f11065c = r5;
        this.d = r10;
        this.e = r11;
        this.f11066h = r12;
        this.f = r13;
        this.g = r14;
        this.f11072n = r15;
        this.f11067i = r16;
        this.f11068j = r17;
        this.f11069k = r18;
        this.f11070l = r19;
        this.f11071m = r110;
        this.f11073o = new WeakReference(kk.a.i(r111));
    }

    @Override // com.facebook.imagepipeline.request.Postprocessor
    public final CloseableReference a(Bitmap r10, PlatformBitmapFactory r11) {
        Bitmap.Config r5 = r10.getConfig();
        int r12 = this.f11065c;
        int r13 = this.d;
        if (r5 != null) goto L6;
        r5 = BasePostprocessor.f8412a;
    L6:
        CloseableReference r14 = r11.a(r12, r13, r5);
        CloseableReference r15 = null;
    L18:
        th = move-exception;
        if (r14 == null) goto L50;
        r14.close();
    L50:
        throw th;
    L42:
        com.lynx.tasm.utils.j.a().post(new h(this, 1));     // Catch: Throwable -> L18
        if (r14 == null) goto L45;
        r15 = r14.b();     // Catch: Throwable -> L18
    L45:
        if (r14 == null) goto L47;
        r14.close();
    L47:
        return r15;
    L8:
        if (this.f11065c != 0) goto L10;
    L39:
        BasePostprocessor.a((Bitmap) r14.c(), r10);     // Catch: Throwable -> L18 UnsatisfiedLinkError -> L42
        CloseableReference r16 = r14.b();     // Catch: Throwable -> L18 UnsatisfiedLinkError -> L42
        r14.close();
        return r16;
    L10:
        if (this.d == 0) goto L39;
        if (this.f11070l == 0) goto L14;
    L20:
        Bitmap r17 = b(r10, r11);     // Catch: Throwable -> L18 UnsatisfiedLinkError -> L42
        monitor-enter(r14);     // Catch: Throwable -> L18 UnsatisfiedLinkError -> L42
        Object r18 = r14.f7671b.d();     // Catch: Throwable -> L36
        monitor-exit(r14);     // Catch: Throwable -> L36
        Canvas r19 = new Canvas((Bitmap) r18);     // Catch: Throwable -> L18 UnsatisfiedLinkError -> L42
        if (this.f11069k == 0) goto L28;
        Paint r20 = new Paint();     // Catch: Throwable -> L18 UnsatisfiedLinkError -> L42
        r20.setFlags(3);     // Catch: Throwable -> L18 UnsatisfiedLinkError -> L42
        r20.setColorFilter(new PorterDuffColorFilter(this.f11069k, PorterDuff.Mode.SRC_IN));     // Catch: Throwable -> L18 UnsatisfiedLinkError -> L42
        r19.drawBitmap(r17, this.f11067i, this.f11068j, r20);     // Catch: Throwable -> L18 UnsatisfiedLinkError -> L42
    L28:
        if (this.f11070l == 0) goto L30;
        NativeBlurFilter.iterativeBoxBlur((Bitmap) r14.c(), 3, this.f11070l);     // Catch: Throwable -> L18 UnsatisfiedLinkError -> L42
    L30:
        r19.drawBitmap(r17, 0.0f, 0.0f, null);     // Catch: Throwable -> L18 UnsatisfiedLinkError -> L42
        if (this.f11071m == 0) goto L33;
        NativeBlurFilter.iterativeBoxBlur((Bitmap) r14.c(), 3, this.f11071m);     // Catch: Throwable -> L18 UnsatisfiedLinkError -> L42
    L33:
        CloseableReference r21 = r14.b();     // Catch: Throwable -> L18 UnsatisfiedLinkError -> L42
        r14.close();
        return r21;
    L36:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18 UnsatisfiedLinkError -> L42
    L14:
        if (this.f11069k != 0) goto L20;
        if (this.f11071m != 0) goto L20;
        goto L20
    }

    public final Bitmap b(Bitmap r13, PlatformBitmapFactory r14) {
        int r5 = this.f11065c;
        if (r5 == 0) goto L34;
        int r10 = this.d;
        if (r10 == 0) goto L34;
        CloseableReference r15 = r14.a(r5, r10, r13.getConfig());
        monitor-enter(r15);
        Object r11 = r15.f7671b.d();     // Catch: Throwable -> L31
        monitor-exit(r15);     // Catch: Throwable -> L31
        Bitmap r12 = (Bitmap) r11;
        Matrix r16 = new Matrix();
        Canvas r17 = new Canvas(r12);
        r17.translate(this.e, this.f11066h);
        r17.clipRect(0, 0, r5 - this.f, r10 - this.g);
        r17.drawARGB(0, 0, 0, 0);
        Paint r18 = new Paint(1);
        float r19 = (r5 - this.e) - this.f;
        float r20 = (r10 - this.f11066h) - this.g;
        Shader.TileMode r21 = Shader.TileMode.CLAMP;
        BitmapShader r22 = new BitmapShader(r13, r21, r21);
        float r23 = r13.getWidth();
        float r110 = r13.getHeight();
        ScalingUtils.ScaleType r111 = this.f11072n;
        if (r111 != ScalingUtils.ScaleType.f7893a) goto L15;
        r16.setScale(r19 / r23, r20 / r110);
        r16.postTranslate(0.0f, 0.0f);
        RectF r112 = new RectF(0.0f, 0.0f, r19 + 0.0f, r20 + 0.0f);
    L29:
        r22.setLocalMatrix(r16);
        r18.setShader(r22);
        r18.setFilterBitmap(true);
        r17.drawRect(r112, r18);
        return r12;
    L15:
        if (r111 != ScalingUtils.ScaleType.f7895c) goto L23;
        float r113 = r19 / r23;
        float r24 = r20 / r110;
        if (r113 <= r24) goto L20;
        float r25 = r23 * r24;
        float r114 = androidx.constraintlayout.motion.widget.a.a(r19, r25, 2.0f, 0.0f);
        RectF r115 = new RectF(r114, 0.0f, r25 + r114, r20 + 0.0f);
        r16.setScale(r24, r24);
        r16.postTranslate(r114, 0.0f);
    L19:
        r112 = r115;
        goto L29
    L20:
        float r116 = r110 * r113;
        float r26 = androidx.constraintlayout.motion.widget.a.a(r20, r116, 2.0f, 0.0f);
        RectF r27 = new RectF(0.0f, r26, r19 + 0.0f, r116 + r26);
        r16.setScale(r113, r113);
        r16.postTranslate(0.0f, r26);
    L21:
        r112 = r27;
        goto L29
    L23:
        if (r111 != ScalingUtils.ScaleType.g) goto L28;
        float r117 = r19 / r23;
        float r28 = r20 / r110;
        if (r117 <= r28) goto L27;
        r27 = new RectF(0.0f, 0.0f, r19 + 0.0f, r20 + 0.0f);
        r16.setScale(r117, r117);
        r16.postTranslate(0.0f, ((r20 - (r110 * r117)) / 2.0f) + 0.0f);
        goto L21
    L27:
        r115 = new RectF(0.0f, 0.0f, r19 + 0.0f, r20 + 0.0f);
        r16.setScale(r28, r28);
        r16.postTranslate(((r19 - (r23 * r28)) / 2.0f) + 0.0f, 0.0f);
        goto L19
    L28:
        r112 = new RectF(0.0f, 0.0f, r19, r20);
        r16.setTranslate(Math.round((r19 - r23) * 0.5f), Math.round((r20 - r110) * 0.5f));
    L31:
        th = move-exception;
        throw th;
    L34:
        return r13;
    }

    @Override // com.facebook.imagepipeline.request.BasePostprocessor, com.facebook.imagepipeline.request.Postprocessor
    public final String getName() {
        return "ShadowPostProcessor";
    }

    @Override // com.facebook.imagepipeline.request.Postprocessor
    public final CacheKey a() {
        StringBuilder r5 = new StringBuilder();
        r5.append(this.f11065c);
        r5.append(this.d);
        r5.append(this.g);
        r5.append(this.f11066h);
        r5.append(this.e);
        r5.append(this.f);
        r5.append(this.f11072n);
        r5.append(this.f11067i);
        r5.append(this.f11068j);
        r5.append(this.f11069k);
        r5.append(this.f11070l);
        r5.append(this.f11071m);
        return new SimpleCacheKey(r5.toString());
    }
}
