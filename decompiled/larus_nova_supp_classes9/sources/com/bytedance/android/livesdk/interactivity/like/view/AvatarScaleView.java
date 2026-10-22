package com.bytedance.android.livesdk.interactivity.like.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import com.bytedance.android.livesdkapi.util.InfraKotlinExtsKt;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class AvatarScaleView extends View {
    public static final /* synthetic */ int i = 0;
    public float a;
    public int b;
    public Bitmap c;
    public final RectF d;
    public final Lazy e;
    public boolean f;
    public final Lazy g;
    public final Lazy h;

    public static final class a {
    }

    static {
    }

    private final ValueAnimator getAlphaAnimator() {
        return (ValueAnimator) this.h.getValue();
    }

    private final Paint getPaint() {
        return (Paint) this.e.getValue();
    }

    private final ValueAnimator getScaleAnimator() {
        return (ValueAnimator) this.g.getValue();
    }

    public final boolean getRunning() {
        return this.f;
    }

    public AvatarScaleView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.a = 1.0f;
        this.b = 255;
        this.d = new RectF();
        this.e = InfraKotlinExtsKt.mainThreadLazy(AvatarScaleView$paint$2.INSTANCE);
        this.g = InfraKotlinExtsKt.mainThreadLazy(new AvatarScaleView$scaleAnimator$2(this));
        this.h = InfraKotlinExtsKt.mainThreadLazy(new AvatarScaleView$alphaAnimator$2(this));
    }

    @Override // android.view.View
    public final void onDraw(Canvas r7) {
        Intrinsics.checkNotNullParameter(r7, "canvas");
        Bitmap r0 = this.c;
        if (r0 == null) goto L6;
        getPaint().setAlpha(this.b);
        RectF r1 = this.d;
        float r3 = 1;
        float r4 = 2;
        r1.left = (getWidth() * (r3 - this.a)) / r4;
        r1.top = (getHeight() * (r3 - this.a)) / r4;
        r1.right = r1.left + (getWidth() * this.a);
        r1.bottom = r1.top + (getHeight() * this.a);
        Unit r2 = Unit.INSTANCE;
        r7.drawBitmap(r0, null, r1, getPaint());
        return;
    }
}
