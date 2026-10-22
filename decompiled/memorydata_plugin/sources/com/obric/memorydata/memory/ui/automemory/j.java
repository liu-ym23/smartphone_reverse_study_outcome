package com.obric.memorydata.memory.ui.automemory;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Xfermode;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.ViewCompat;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0016B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eJ \u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00072\b\b\u0001\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eJ*\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0001\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eJ$\u0010\u0014\u001a\u00020\u000b2\b\b\u0001\u0010\f\u001a\u00020\u000b2\b\b\u0001\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0005H\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/obric/memorydata/memory/ui/automemory/AutoMemoryGradientTintDrawable;", "", "<init>", "()V", "OVERLAY_ALPHA_RATIO", "", "create", "Landroid/graphics/drawable/Drawable;", "context", "Landroid/content/Context;", "drawableRes", "", "mainColor", "isDarkMode", "", "drawable", "applyTo", "", "imageView", "Landroid/widget/ImageView;", "overlayColor", "alphaRatio", "GradientMaskDrawable", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f10678a = null;

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\b\u0002\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0004H\u0016J\u0012\u0010\u0019\u001a\u00020\u00142\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0004H\u0017J\b\u0010\u001d\u001a\u00020\u0004H\u0016J\b\u0010\u001e\u001a\u00020\u0004H\u0016J\u0010\u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\u0011H\u0014J,\u0010!\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u00042\b\b\u0001\u0010$\u001a\u00020\u00042\b\b\u0001\u0010%\u001a\u00020\u0004H\u0002J\u0018\u0010&\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u0004H\u0002R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/obric/memorydata/memory/ui/automemory/AutoMemoryGradientTintDrawable$GradientMaskDrawable;", "Landroid/graphics/drawable/Drawable;", AILabCheckPermissionTask.KEY_SOURCE, "mainColor", "", "isDarkMode", "", "<init>", "(Landroid/graphics/drawable/Drawable;IZ)V", "gradientPaint", "Landroid/graphics/Paint;", "outputPaint", "maskPaint", "maskBitmap", "Landroid/graphics/Bitmap;", "renderedBitmap", "maskBounds", "Landroid/graphics/Rect;", "drawableAlpha", "draw", "", "canvas", "Landroid/graphics/Canvas;", "setAlpha", "alpha", "setColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "getOpacity", "getIntrinsicWidth", "getIntrinsicHeight", "onBoundsChange", "bounds", "getRenderedBitmap", "width", "height", "topColor", "bottomColor", "getMaskBitmap", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a extends Drawable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Drawable f10679a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f10680b;
        private final boolean c;
        private final Paint d;
        private final Paint e;
        private final Paint f;
        private Bitmap g;
        private Bitmap h;
        private final Rect i;
        private int j;

        public a(Drawable r2, int r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r2, AILabCheckPermissionTask.KEY_SOURCE);
            this.f10679a = r2;
            this.f10680b = r3;
            this.c = r4;
            this.d = new Paint(1);
            this.e = new Paint(3);
            Paint r5 = new Paint(1);
            r5.setXfermode((Xfermode) ZeusTransformUtils.preCheckCast(new PorterDuffXfermode(PorterDuff.Mode.DST_IN), Xfermode.class, "com.obric.memorydata.plugin"));
            this.f = r5;
            this.i = new Rect();
            this.j = 255;
        }

        private final Bitmap a(int r5, int r6) {
            Bitmap r0 = this.g;
            if (r0 != null) goto L5;
        L9:
            int r1 = 1;
            Bitmap r7 = Bitmap.createBitmap(RangesKt.coerceAtLeast(r5, 1), RangesKt.coerceAtLeast(r6, 1), Bitmap.Config.ARGB_8888);
            Intrinsics.checkNotNullExpressionValue(r7, "createBitmap(...)");
            Canvas r8 = new Canvas(r7);
            if (r7.getWidth() > 2) goto L12;
        L14:
            r1 = 0;
        L15:
            this.f10679a.setBounds(r1, r1, r7.getWidth() - r1, r7.getHeight() - r1);
            this.f10679a.setAlpha(255);
            this.f10679a.setColorFilter((ColorFilter) ZeusTransformUtils.preCheckCast(new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_IN), ColorFilter.class, "com.obric.memorydata.plugin"));
            this.f10679a.draw(r8);
            this.g = r7;
            return r7;
        L12:
            if (r7.getHeight() <= 2) goto L14;
        L5:
            if (r0.getWidth() != r5) goto L9;
            if (r0.getHeight() != r6) goto L9;
            return r0;
        }

        private final Bitmap a(int r17, int r18, int r19, int r20) {
            int r2 = RangesKt.coerceAtLeast(r17, 1);
            int r1 = RangesKt.coerceAtLeast(r18, 1);
            Bitmap r3 = this.h;
            if (r3 != null) goto L5;
        L9:
            Bitmap r4 = Bitmap.createBitmap(r2, r1, Bitmap.Config.ARGB_8888);
            Intrinsics.checkNotNullExpressionValue(r4, "createBitmap(...)");
            Canvas r5 = new Canvas(r4);
            float r15 = r1;
            this.d.setShader((Shader) ZeusTransformUtils.preCheckCast(new LinearGradient(0.0f, 0.0f, 0.0f, r15, r19, r20, Shader.TileMode.CLAMP), Shader.class, "com.obric.memorydata.plugin"));
            this.d.setAlpha(255);
            r5.drawRect(0.0f, 0.0f, r2, r15, this.d);
            r5.drawBitmap(a(r2, r1), 0.0f, 0.0f, this.f);
            this.h = r4;
            return r4;
        L5:
            if (r3.getWidth() != r2) goto L9;
            if (r3.getHeight() != r1) goto L9;
            return r3;
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas r7) {
            Intrinsics.checkNotNullParameter(r7, "canvas");
            Rect r0 = getBounds();
            Intrinsics.checkNotNullExpressionValue(r0, "getBounds(...)");
            if (r0.isEmpty() == false) goto L6;
            return;
        L6:
            if (this.c == false) goto L8;
            int r1 = this.f10680b;
            int r2 = j.a(j.f10678a, this.f10680b, ViewCompat.MEASURED_STATE_MASK, 0.16f);
        L9:
            Bitmap r3 = a(r0.width(), r0.height(), r1, r2);
            this.e.setAlpha(this.j);
            r7.drawBitmap(r3, r0.left, r0.top, this.e);
            return;
        L8:
            r1 = j.a(j.f10678a, this.f10680b, -1, 0.16f);
            r2 = this.f10680b;
            goto L9
        }

        @Override // android.graphics.drawable.Drawable
        public int getIntrinsicHeight() {
            return this.f10679a.getIntrinsicHeight();
        }

        @Override // android.graphics.drawable.Drawable
        public int getIntrinsicWidth() {
            return this.f10679a.getIntrinsicWidth();
        }

        @Override // android.graphics.drawable.Drawable
        @Deprecated(message = "Deprecated in Java")
        public int getOpacity() {
            return -3;
        }

        @Override // android.graphics.drawable.Drawable
        public void onBoundsChange(Rect r3) {
            Intrinsics.checkNotNullParameter(r3, "bounds");
            super.onBoundsChange(r3);
            if (this.i.width() == r3.width()) goto L5;
        L6:
            this.g = null;
            this.h = null;
        L7:
            this.i.set(r3);
            return;
        L5:
            if (this.i.height() == r3.height()) goto L7;
            goto L6
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int r2) {
            if (this.j != r2) goto L5;
            return;
        L5:
            this.j = r2;
            invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter r2) {
            this.e.setColorFilter(r2);
            invalidateSelf();
        }
    }

    static {
        f10678a = new j();
    }

    private j() {
    }

    private final int a(int r1, int r2, float r3) {
        return ColorUtils.compositeColors(ColorUtils.setAlphaComponent(r2, MathKt.roundToInt(Color.alpha(r2) * r3)), r1);
    }

    public static final /* synthetic */ int a(j r0, int r1, int r2, float r3) {
        return r0.a(r1, r2, r3);
    }

    public final Drawable a(Context r2, int r3, int r4, boolean r5) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        Drawable r6 = ContextCompat.getDrawable(r1, r3);
        if (r6 != null) goto L7;
        return null;
    L7:
        return f10678a.a(r6, r4, r5);
    }

    public final Drawable a(Drawable r2, int r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "drawable");
        Drawable r5 = r2.mutate();
        Intrinsics.checkNotNullExpressionValue(r5, "mutate(...)");
        return (Drawable) ZeusTransformUtils.preCheckCast(new a(r5, r3, r4), Drawable.class, "com.obric.memorydata.plugin");
    }
}
