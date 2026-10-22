package com.lynx.tasm.ui.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.nativecode.NativeBlurFilter;
import com.facebook.imagepipeline.request.BasePostprocessor;
import com.facebook.imagepipeline.request.Postprocessor;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.utils.BorderRadius;
import com.lynx.tasm.utils.UIThreadUtils;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class FrescoFilterImageView extends FrescoImageView {
    private int mBlurRadius;
    private int mShadowColor;
    private int mShadowOffsetX;
    private int mShadowOffsetY;
    private int mShadowRadius;

    public static class a extends BasePostprocessor {
        public final int a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;
        public final int g;
        public final int h;
        public final int i;
        public final int j;
        public final int k;
        public final ScalingUtils.ScaleType l;
        public final WeakReference<LynxContext> m;

        /* JADX INFO: renamed from: com.lynx.tasm.ui.image.FrescoFilterImageView$a$a, reason: collision with other inner class name */
        public class RunnableC0065a implements Runnable {
            public final /* synthetic */ a a;

            @Override // java.lang.Runnable
            public final void run() {
                WeakReference<LynxContext> r0 = this.a.m;     // Catch: Throwable -> L8
                if (r0 != null) goto L5;
                return;
            L5:
                if (r0.get() == null) goto L15;
                LynxError r1 = new LynxError(220301, "blur-radius/drop-shadow is not supported in this app and it will crash in lower versions", "Please remove blur-radius/drop-shadow props in image/filter-image.", "error", -3);     // Catch: Throwable -> L8
                this.a.m.get().handleLynxError(r1);     // Catch: Throwable -> L8
                return;
            L15:
                return;
            L8:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L16;
                throw th;
            }

            public RunnableC0065a(a r1) {
                this.a = r1;
            }
        }

        public final String getName() {
            return "ShadowPostProcessor";
        }

        public final CacheKey getPostprocessorCacheKey() {
            StringBuilder r0 = new StringBuilder();
            r0.append(this.a);
            r0.append(this.b);
            r0.append(this.e);
            r0.append(this.f);
            r0.append(this.c);
            r0.append(this.d);
            r0.append(this.l);
            r0.append(this.g);
            r0.append(this.h);
            r0.append(this.i);
            r0.append(this.j);
            r0.append(this.k);
            return new SimpleCacheKey(r0.toString());
        }

        public final Bitmap a(Bitmap r14, PlatformBitmapFactory r15) {
            int r0 = this.a;
            if (r0 == 0) goto L26;
            int r1 = this.b;
            if (r1 == 0) goto L26;
            Bitmap r16 = (Bitmap) r15.createBitmapInternal(r0, r1, r14.getConfig()).get();
            Matrix r2 = new Matrix();
            Canvas r3 = new Canvas(r16);
            r3.translate(this.c, this.f);
            r3.clipRect(0, 0, r0 - this.d, r1 - this.e);
            r3.drawARGB(0, 0, 0, 0);
            Paint r4 = new Paint(1);
            float r5 = (r0 - this.c) - this.d;
            float r6 = (r1 - this.f) - this.e;
            Shader.TileMode r7 = Shader.TileMode.CLAMP;
            BitmapShader r8 = new BitmapShader(r14, r7, r7);
            float r9 = r14.getWidth();
            float r17 = r14.getHeight();
            ScalingUtils.ScaleType r10 = this.l;
            if (r10 != ScalingUtils.ScaleType.FIT_XY) goto L11;
            r2.setScale(r5 / r9, r6 / r17);
            r2.postTranslate(0.0f, 0.0f);
            RectF r18 = new RectF(0.0f, 0.0f, r5 + 0.0f, r6 + 0.0f);
        L24:
            r8.setLocalMatrix(r2);
            r4.setShader(r8);
            r4.setFilterBitmap(true);
            r3.drawRect(r18, r4);
            return r16;
        L11:
            if (r10 != ScalingUtils.ScaleType.FIT_CENTER) goto L18;
            float r11 = r5 / r9;
            float r12 = r6 / r17;
            if (r11 <= r12) goto L15;
            float r13 = r9 * r12;
            float r19 = ((r5 - r13) / 2.0f) + 0.0f;
            r18 = new RectF(r19, 0.0f, r13 + r19, r6 + 0.0f);
            r2.setScale(r12, r12);
            r2.postTranslate(r19, 0.0f);
            goto L24
        L15:
            float r110 = r17 * r11;
            float r20 = ((r6 - r110) / 2.0f) + 0.0f;
            RectF r21 = new RectF(0.0f, r20, r5 + 0.0f, r110 + r20);
            r2.setScale(r11, r11);
            r2.postTranslate(0.0f, r20);
        L16:
            r18 = r21;
            goto L24
        L18:
            if (r10 != ScalingUtils.ScaleType.CENTER_CROP) goto L23;
            float r22 = r5 / r9;
            float r23 = r6 / r17;
            if (r22 <= r23) goto L22;
            r21 = new RectF(0.0f, 0.0f, r5 + 0.0f, r6 + 0.0f);
            r2.setScale(r22, r22);
            r2.postTranslate(0.0f, ((r6 - (r17 * r22)) / 2.0f) + 0.0f);
            goto L16
        L22:
            float r111 = ((r5 - (r9 * r23)) / 2.0f) + 0.0f;
            r21 = new RectF(0.0f, 0.0f, r5 + 0.0f, r6 + 0.0f);
            r2.setScale(r23, r23);
            r2.postTranslate(r111, 0.0f);
            goto L16
        L23:
            RectF r24 = new RectF(0.0f, 0.0f, r5, r6);
            r2.setTranslate(Math.round((r5 - r9) * 0.5f), Math.round((r6 - r17) * 0.5f));
            r18 = r24;
        L26:
            return r14;
        }

        public final CloseableReference<Bitmap> process(Bitmap r7, PlatformBitmapFactory r8) {
            Bitmap.Config r0 = r7.getConfig();
            int r1 = this.a;
            int r2 = this.b;
            if (r0 != null) goto L6;
            r0 = BasePostprocessor.FALLBACK_BITMAP_CONFIGURATION;
        L6:
            CloseableReference r3 = r8.createBitmapInternal(r1, r2, r0);
        L33:
            th = move-exception;
            CloseableReference.closeSafely(r3);
            throw th;
        L35:
            UIThreadUtils.runOnUiThread(new RunnableC0065a(this));     // Catch: Throwable -> L33
            CloseableReference<Bitmap> r9 = CloseableReference.cloneOrNull(r3);     // Catch: Throwable -> L33
            CloseableReference.closeSafely(r3);
            return r9;
        L8:
            if (this.a != 0) goto L10;
        L30:
            process((Bitmap) r3.get(), r7);     // Catch: Throwable -> L33 UnsatisfiedLinkError -> L35
            CloseableReference<Bitmap> r10 = CloseableReference.cloneOrNull(r3);     // Catch: Throwable -> L33 UnsatisfiedLinkError -> L35
            CloseableReference.closeSafely(r3);
            return r10;
        L10:
            if (this.b == 0) goto L30;
            if (this.j == 0) goto L14;
        L18:
            Bitmap r11 = a(r7, r8);     // Catch: Throwable -> L33 UnsatisfiedLinkError -> L35
            Canvas r12 = new Canvas((Bitmap) r3.get());     // Catch: Throwable -> L33 UnsatisfiedLinkError -> L35
            if (this.i == 0) goto L22;
            Paint r4 = new Paint();     // Catch: Throwable -> L33 UnsatisfiedLinkError -> L35
            r4.setFlags(3);     // Catch: Throwable -> L33 UnsatisfiedLinkError -> L35
            r4.setColorFilter(new PorterDuffColorFilter(this.i, PorterDuff.Mode.SRC_IN));     // Catch: Throwable -> L33 UnsatisfiedLinkError -> L35
            r12.drawBitmap(r11, this.g, this.h, r4);     // Catch: Throwable -> L33 UnsatisfiedLinkError -> L35
        L22:
            if (this.j == 0) goto L24;
            NativeBlurFilter.iterativeBoxBlur((Bitmap) r3.get(), 3, this.j);     // Catch: Throwable -> L33 UnsatisfiedLinkError -> L35
        L24:
            r12.drawBitmap(r11, 0.0f, 0.0f, null);     // Catch: Throwable -> L33 UnsatisfiedLinkError -> L35
            if (this.k == 0) goto L27;
            NativeBlurFilter.iterativeBoxBlur((Bitmap) r3.get(), 3, this.k);     // Catch: Throwable -> L33 UnsatisfiedLinkError -> L35
        L27:
            CloseableReference<Bitmap> r13 = CloseableReference.cloneOrNull(r3);     // Catch: Throwable -> L33 UnsatisfiedLinkError -> L35
            CloseableReference.closeSafely(r3);
            return r13;
        L14:
            if (this.i != 0) goto L18;
            if (this.k != 0) goto L18;
            goto L18
        }

        public a(int r1, int r2, int r3, int r4, int r5, int r6, ScalingUtils.ScaleType r7, int r8, int r9, int r10, int r11, int r12, Context r13) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.f = r4;
            this.d = r5;
            this.e = r6;
            this.l = r7;
            this.g = r8;
            this.h = r9;
            this.i = r10;
            this.j = r11;
            this.k = r12;
            this.m = new WeakReference(com.lynx.tasm.utils.a.a(r13));
        }
    }

    @Override // com.lynx.tasm.ui.image.FrescoImageView, x6a.e
    public /* bridge */ /* synthetic */ void applyRendererClipBounds(boolean r1, Rect r2) {
        x6a.d.a(this, r1, r2);
    }

    @Override // com.lynx.tasm.ui.image.FrescoImageView, x6a.e
    public /* bridge */ /* synthetic */ void applyRendererOpacity(float r1) {
        x6a.d.b(this, r1);
    }

    @Override // com.lynx.tasm.ui.image.FrescoImageView, x6a.e
    public /* bridge */ /* synthetic */ void applyRendererTransform(float[] r1) {
        x6a.d.c(this, r1);
    }

    @Override // com.lynx.tasm.ui.image.FrescoImageView, x6a.e
    public /* bridge */ /* synthetic */ PointF convertPointInRendererHostToScreen(PointF r1) {
        return x6a.d.d(this, r1);
    }

    @Override // com.lynx.tasm.ui.image.FrescoImageView, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostHeight() {
        return x6a.d.e(this);
    }

    @Override // com.lynx.tasm.ui.image.FrescoImageView, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostScrollX() {
        return x6a.d.f(this);
    }

    @Override // com.lynx.tasm.ui.image.FrescoImageView, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostScrollY() {
        return x6a.d.g(this);
    }

    @Override // com.lynx.tasm.ui.image.FrescoImageView, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostWidth() {
        return x6a.d.h(this);
    }

    @Override // com.lynx.tasm.ui.image.FrescoImageView, x6a.e
    public /* bridge */ /* synthetic */ void invalidateForRenderer() {
        x6a.d.i(this);
    }

    @Override // com.lynx.tasm.ui.image.FrescoImageView, x6a.e
    public /* bridge */ /* synthetic */ boolean invokeUIMethod(String r1, ReadableMap r2, Callback r3) {
        return false;
    }

    public void markShadowDirty() {
        this.mIsDirty = true;
    }

    @Override // com.lynx.tasm.ui.image.FrescoImageView, x6a.e
    public /* bridge */ /* synthetic */ void requestLayoutForRenderer() {
        x6a.d.j(this);
    }

    @Override // com.lynx.tasm.ui.image.FrescoImageView, x6a.e
    public /* bridge */ /* synthetic */ void setClipChildrenForRenderer(boolean r1) {
        x6a.d.k(this, r1);
    }

    @Override // com.lynx.tasm.ui.image.FrescoImageView, x6a.e
    public /* bridge */ /* synthetic */ void setWillNotDrawForRenderer(boolean r1) {
        x6a.d.l(this, r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void configureBounds() {
        if (getTopLevelDrawable() != null) goto L5;
        return;
    L5:
        if (isUseShadowProcessor() == false) goto L9;
        getTopLevelDrawable().setBounds(new Rect(0, 0, getWidth(), getHeight()));
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean isUseShadowProcessor() {
        if (getWidth() != 0) goto L5;
    L13:
        return false;
    L5:
        if (getHeight() == 0) goto L13;
        if (this.mShadowRadius == 0) goto L9;
    L12:
        return true;
    L9:
        if (this.mShadowColor != 0) goto L12;
        if (this.mBlurRadius == 0) goto L13;
        goto L12
    }

    @Override // com.lynx.tasm.ui.image.FrescoImageView
    public void maybeUpdateView() {
        super.maybeUpdateView();
    }

    @Override // com.lynx.tasm.ui.image.FrescoImageView
    public void onImageRequestLoaded() {
        configureBounds();
    }

    @Override // com.lynx.tasm.ui.image.FrescoImageView
    public void onDraw(Canvas r2) {
        if (getTopLevelDrawable() != null) goto L5;
    L7:
        super.onDraw(r2);
        return;
    L5:
        if (isUseShadowProcessor() == false) goto L7;
        prepareRendererForDraw(r2);
        getTopLevelDrawable().draw(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.ui.image.FrescoImageView
    public void onPostprocessorPreparing(List<Postprocessor> r17) {
        if (isUseShadowProcessor() == false) goto L6;
        r17.add(new a(getWidth(), getHeight(), getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom(), getFrescoScaleType(), this.mShadowOffsetX, this.mShadowOffsetY, this.mShadowColor, this.mShadowRadius, this.mBlurRadius, getContext()));
        return;
    }

    @Override // com.lynx.tasm.ui.image.FrescoImageView
    public void setBlurRadius(int r2) {
        if (this.mBlurRadius == r2) goto L6;
        this.mBlurRadius = r2;
        markShadowDirty();
        return;
    }

    @Override // com.lynx.tasm.ui.image.FrescoImageView
    public void setBorderRadius(BorderRadius r1) {
        super.setBorderRadius(r1);
    }

    public void setShadowColor(int r2) {
        if (this.mShadowColor == r2) goto L6;
        this.mShadowColor = r2;
        markShadowDirty();
        return;
    }

    public void setShadowOffsetX(int r2) {
        if (this.mShadowOffsetX == r2) goto L6;
        this.mShadowOffsetX = r2;
        markShadowDirty();
        return;
    }

    public void setShadowOffsetY(int r2) {
        if (this.mShadowOffsetY == r2) goto L6;
        this.mShadowOffsetY = r2;
        markShadowDirty();
        return;
    }

    public void setShadowRadius(int r2) {
        if (this.mShadowRadius == r2) goto L6;
        this.mShadowRadius = r2;
        markShadowDirty();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean setFrame(int r1, int r2, int r3, int r4) {
        boolean r5 = super/*android.widget.ImageView*/.setFrame(r1, r2, r3, r4);
        configureBounds();
        return r5;
    }

    public FrescoFilterImageView(Context r1, AbstractDraweeControllerBuilder r2, e r3, Object r4, LynxBaseUI r5) {
        super(r1, r2, r3, r4, r5);
    }
}
