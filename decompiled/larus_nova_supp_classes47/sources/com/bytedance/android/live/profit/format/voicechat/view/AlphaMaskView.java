package com.bytedance.android.live.profit.format.voicechat.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.PathInterpolator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u001b\u0010\u000b\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/profit/format/voicechat/view/AlphaMaskView;", "Landroid/view/View;", "", "resId", "", "setResource", "Landroid/graphics/Bitmap;", "g", "Lkotlin/Lazy;", "getGradientBitmap", "()Landroid/graphics/Bitmap;", "gradientBitmap", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AlphaMaskView extends View {
    public final float a;
    public float b;
    public Bitmap c;
    public final Paint d;
    public final Paint e;
    public final Paint f;
    public final Lazy g;
    public final Matrix h;
    public final Matrix i;
    public final RectF j;
    public boolean k;

    public static final class a implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ AlphaMaskView a;

        public a(AlphaMaskView r1) {
            this.a = r1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r2) {
            Intrinsics.checkNotNullParameter(r2, "it");
            AlphaMaskView r0 = this.a;
            Object r3 = r2.getAnimatedValue();
            if (r3 == null) goto L7;
            r0.b = ((Float) r3).floatValue();
            this.a.invalidate();
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    public AlphaMaskView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public AlphaMaskView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final Bitmap getGradientBitmap() {
        return (Bitmap) this.g.getValue();
    }

    public final void b() {
        Bitmap r0 = this.c;
        if (r0 != null) goto L5;
        return;
    L5:
        float r1 = getWidth();
        float r2 = getHeight();
        float r3 = r0.getWidth();
        float r4 = r0.getHeight();
        float r5 = Math.max(r1 / r3, r2 / r4);
        this.i.reset();
        this.i.postScale(r5, r5);
        float r6 = r1 - (r3 * r5);
        float r7 = 2;
        this.i.postTranslate(r6 / r7, (r2 - (r4 * r5)) / r7);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r10) {
        Intrinsics.checkNotNullParameter(r10, "canvas");
        Bitmap r0 = this.c;
        if (r0 != null) goto L5;
    L8:
        float r1 = getHeight() * this.a;
        float r2 = getHeight() - ((getHeight() + r1) * this.b);
        this.j.set(0.0f, r2, getWidth(), r2 + r1);
        this.h.reset();
        this.h.setScale(getWidth(), (getHeight() * this.a) / getGradientBitmap().getHeight());
        this.h.postTranslate(0.0f, getHeight() - ((getHeight() + r1) * this.b));
        r10.drawBitmap(getGradientBitmap(), this.h, this.e);
        r10.drawRect(0.0f, this.j.bottom - 1.0f, getWidth(), getHeight(), this.f);
        return;
    L5:
        if (this.k == true) goto L7;
        this.d.setAlpha(255 - ((int) (this.b * 255)));
    L7:
        r10.drawBitmap(r0, this.i, this.d);
        goto L8
    }

    public final void setResource(int r2) {
        this.c = BitmapFactory.decodeResource(getResources(), r2);
        if (getWidth() > 0) goto L5;
    L7:
        invalidate();
        return;
    L5:
        if (getHeight() <= 0) goto L7;
        b();
        goto L7
    }

    public final Animator a(boolean r4, long r5) {
        this.k = r4;
        if (r4 == false) goto L5;
        ValueAnimator r6 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
    L6:
        r6.setDuration(r5);
        r6.setInterpolator(new PathInterpolator(0.33f, 0.0f, 0.25f, 1.0f));
        r6.addUpdateListener(new a(this));
        return r6;
    L5:
        r6 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        goto L6
    }

    public AlphaMaskView(Context r4, AttributeSet r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5, r6);
        this.a = 0.4f;
        this.d = new Paint(1);
        Paint r7 = new Paint(1);
        r7.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        Unit r1 = Unit.INSTANCE;
        this.e = r7;
        Paint r8 = new Paint(1);
        r8.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.f = r8;
        this.g = LazyKt.lazy(AlphaMaskView$gradientBitmap$2.INSTANCE);
        this.h = new Matrix();
        this.i = new Matrix();
        this.j = new RectF();
        this.k = true;
        Bitmap r2 = null;
        setLayerType(2, null);
        TypedArray r9 = r4.obtainStyledAttributes(r5, new int[]{2130972683}, 0, 0);
        Drawable r10 = r9.getDrawable(0);
        if ((r10 instanceof BitmapDrawable) == true) goto L5;
        r10 = null;
    L5:
        BitmapDrawable r12 = (BitmapDrawable) r10;
        if (r12 == null) goto L8;
        r2 = r12.getBitmap();
    L8:
        this.c = r2;
        r9.recycle();
    }

    public /* synthetic */ AlphaMaskView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        if (r1 <= 0) goto L8;
        if (r2 <= 0) goto L8;
        if (this.c == null) goto L8;
        b();
    L8:
        this.h.reset();
        this.h.postScale(getWidth(), (getHeight() * this.a) / getGradientBitmap().getHeight());
    }
}
