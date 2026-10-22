package com.bytedance.android.live.openplatform.impl.base.view;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.animation.LinearInterpolator;
import androidx.appcompat.graphics.drawable.DrawableWrapper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/base/view/RotatingDrawable;", "Landroidx/appcompat/graphics/drawable/DrawableWrapper;", "Landroid/graphics/drawable/Animatable;", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class RotatingDrawable extends DrawableWrapper implements Animatable {
    public float a;
    public final ValueAnimator b;
    public boolean c;

    public static final class a implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ RotatingDrawable a;

        public a(RotatingDrawable r1) {
            this.a = r1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r2) {
            Intrinsics.checkNotNullParameter(r2, "it");
            RotatingDrawable r0 = this.a;
            Object r3 = r2.getAnimatedValue();
            if (r3 == null) goto L7;
            r0.a = ((Integer) r3).intValue();
            this.a.invalidateSelf();
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
    }

    @Override // android.graphics.drawable.Animatable
    public final void stop() {
        this.c = false;
        ValueAnimator r0 = this.b;
        r0.removeAllUpdateListeners();
        r0.cancel();
    }

    @Override // android.graphics.drawable.Animatable
    public final void start() {
        ValueAnimator r0 = this.b;
        r0.setInterpolator(new LinearInterpolator());
        r0.setDuration(1000);
        r0.setRepeatMode(1);
        r0.setRepeatCount(-1);
        r0.addUpdateListener(new a(this));
        this.b.start();
        this.c = true;
    }

    @Override // android.graphics.drawable.Animatable
    public final boolean isRunning() {
        return this.c;
    }

    public RotatingDrawable(Drawable r1) {
        super(r1);
        this.b = ValueAnimator.ofInt(new int[]{0, 360});
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void draw(Canvas r6) {
        Intrinsics.checkNotNullParameter(r6, "canvas");
        if (getWrappedDrawable() != null) goto L5;
        return;
    L5:
        r6.save();
        r6.rotate(this.a, (getBounds().left + getBounds().right) / 2.0f, (getBounds().top + getBounds().bottom) / 2.0f);
        getWrappedDrawable().draw(r6);
        r6.restore();
    }

    public final void onBoundsChange(Rect r3) {
        Intrinsics.checkNotNullParameter(r3, "bounds");
        super.onBoundsChange(r3);
        if (r3.width() >= r3.height()) goto L5;
        r3.width();
        getWrappedDrawable().getIntrinsicWidth();
        return;
    L5:
        r3.height();
        getWrappedDrawable().getIntrinsicHeight();
    }
}
