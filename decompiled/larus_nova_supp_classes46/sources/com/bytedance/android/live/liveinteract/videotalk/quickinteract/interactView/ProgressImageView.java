package com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.utils.r2;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\nB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/liveinteract/videotalk/quickinteract/interactView/ProgressImageView;", "Landroid/view/View;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ProgressImageView extends View {
    public float a;
    public ValueAnimator b;
    public float c;
    public final Bitmap d;
    public final float e;
    public final Matrix f;
    public final Paint g;

    public static final class a {
    }

    public static final class b implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ ProgressImageView a;

        public b(ProgressImageView r1) {
            this.a = r1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r2) {
            Intrinsics.checkNotNullParameter(r2, "it");
            ProgressImageView r0 = this.a;
            Object r3 = r2.getAnimatedValue();
            if (r3 == null) goto L7;
            r0.a = ((Float) r3).floatValue();
            this.a.invalidate();
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    public static final class c implements Animator.AnimatorListener {
        public final /* synthetic */ ProgressImageView a;
        public final /* synthetic */ String b;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r3) {
            Intrinsics.checkNotNullParameter(r3, "animation");
            gj0.i.a("ProgressImageView", "onAnimationEnd curProgress : " + this.a.a + "  targetProgress : " + this.a.c);
            ProgressImageView r4 = this.a;
            if (r4.a == 1.0f) goto L5;
        L9:
            this.a.setVisibility(0);
        L10:
            ProgressImageView r5 = this.a;
            if (r5.a == r5.c) goto L14;
            r5.a(this.b);
            return;
        L14:
            return;
        L5:
            if (r4.c != 1.0f) goto L9;
            if (r2.a(this.b) == false) goto L9;
            this.a.setVisibility(8);
            goto L10
        }

        public c(ProgressImageView r1, String r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
    }

    public ProgressImageView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ProgressImageView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void a(String r5) {
        Ref.LongRef r0 = new Ref.LongRef();
        r0.element = (long) (Math.abs(this.a - this.c) / this.e);
        gj0.i.a("ProgressImageView", "startAnimation curProgress : " + this.a + "  targetProgress : " + this.c + "  d :" + r0.element);
        ValueAnimator r1 = ValueAnimator.ofFloat(new float[]{this.a, this.c});
        r1.setDuration(r0.element);
        r1.addUpdateListener(new b(this));
        r1.addListener(new c(this, r5));
        Unit r6 = Unit.INSTANCE;
        this.b = r1;
        r1.start();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r4) {
        Intrinsics.checkNotNullParameter(r4, "canvas");
        super.onDraw(r4);
        r4.clipRect(0, 0, (int) (getWidth() * this.a), getHeight());
        r4.drawBitmap(this.d, this.f, this.g);
    }

    public ProgressImageView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        Bitmap r5 = s1.g(2131248289);
        this.d = r5;
        this.e = 0.001f;
        this.f = new Matrix();
        Paint r6 = new Paint();
        r6.setAntiAlias(true);
        Unit r7 = Unit.INSTANCE;
        this.g = r6;
        Matrix r8 = new Matrix();
        r8.postScale(s1.f(50.0f) / r5.getWidth(), s1.f(14.0f) / r5.getHeight());
        this.f = r8;
    }

    public final void b(float r5, String r6, boolean r7) {
        if (r5 <= 0) goto L8;
        if (r5 > 1.0f) goto L8;
    L11:
        this.c = r5;
        gj0.i.a("ProgressImageView", "updateProgress curProgress : " + this.a + "  targetProgress : " + this.c + " updateWithAnim=" + r7);
        if (this.c == this.a) goto L26;
        ValueAnimator r8 = this.b;
        if (r8 != null) goto L16;
    L17:
        if (r7 == false) goto L19;
        a(r6);
        return;
    L19:
        float r9 = this.c;
        this.a = r9;
        if (r9 == 1.0f) goto L22;
    L24:
        setVisibility(0);
    L25:
        invalidate();
        return;
    L22:
        if (r2.a(r6) == false) goto L24;
        setVisibility(8);
        goto L25
    L16:
        if (r8.isRunning() != true) goto L17;
    L26:
        float r10 = this.c;
        float r11 = this.a;
        if (r10 == r11) goto L29;
        return;
    L29:
        if (r11 == 1.0f) goto L31;
        return;
    L31:
        if (getVisibility() != 0) goto L39;
        if (r6 == null) goto L40;
        setVisibility(8);
        return;
    L40:
        return;
    L39:
        return;
    L8:
        if (r5 <= 1.0f) goto L10;
        r5 = 1.0f;
        goto L11
    L10:
        r5 = 0.0f;
        goto L11
    }

    public /* synthetic */ ProgressImageView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
