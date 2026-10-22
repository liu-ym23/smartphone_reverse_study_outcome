package com.ss.android.lark.keyboard.plugin.tool.voice.audio2.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.animation.AccelerateInterpolator;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0014J\u000e\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0011J\u0016\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u0011R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/voice/audio2/widget/AudioPopupBackground;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mRippleRadiusDiff", "", "mRippleRadius", "mRipplePaint", "Landroid/graphics/Paint;", "valueAnimator", "Landroid/animation/ValueAnimator;", "lastVolume", "mMainBtnRadius", "", "mMainBtnBottomMargin", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "setVolume", "volume", "setMainBtnRadiusAndBottomMargin", "radius", "bottomMargin", "keyboard-biz-voice_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class AudioPopupBackground extends ConstraintLayout {
    public final float a;
    public float b;
    public final Paint c;
    public ValueAnimator d;
    public float e;
    public int f;
    public int g;

    public static final class a implements Runnable {
        public final /* synthetic */ AudioPopupBackground a;
        public final /* synthetic */ int b;

        /* JADX INFO: renamed from: com.ss.android.lark.keyboard.plugin.tool.voice.audio2.widget.AudioPopupBackground$a$a, reason: collision with other inner class name */
        public static final class C0159a implements ValueAnimator.AnimatorUpdateListener {
            public final /* synthetic */ AudioPopupBackground a;

            public C0159a(AudioPopupBackground r1) {
                this.a = r1;
            }

            /* JADX WARN: Type inference failed for: r1v3, types: [android.view.ViewGroup, com.ss.android.lark.keyboard.plugin.tool.voice.audio2.widget.AudioPopupBackground] */
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator r5) {
                Intrinsics.checkNotNullParameter(r5, "animation");
                AudioPopupBackground r0 = this.a;
                Object r6 = r5.getAnimatedValue();
                Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type kotlin.Float");
                r0.e = ((Float) r6).floatValue();
                AudioPopupBackground r7 = this.a;
                int r1 = c.a;
                float r2 = c.o(Float.valueOf(r7.e), 1, 0);
                ?? r3 = this.a;
                r7.b = (r2 * r3.a) + (r3.f * 0.9f);
                r3.invalidate();
            }
        }

        public a(AudioPopupBackground r1, int r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            AudioPopupBackground r0 = this.a;
            ValueAnimator r1 = r0.d;
            if (r1 == null) goto L5;
            int r5 = this.b;
            r1.cancel();
            r1.setFloatValues(new float[]{r0.e, r5});
            r1.start();
            return;
        L5:
            ValueAnimator r2 = ValueAnimator.ofFloat(new float[]{r0.e, this.b});
            r2.setInterpolator(new AccelerateInterpolator());
            r2.setDuration(100).addUpdateListener(new C0159a(r0));
            r2.start();
            r0.d = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDraw(Canvas r5) {
        Intrinsics.checkNotNullParameter(r5, "canvas");
        r5.drawCircle(getMeasuredWidth() / 2, (getMeasuredHeight() - this.f) - this.g, this.b, this.c);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setVolume(int r2) {
        post(new a(this, r2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AudioPopupBackground(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        int r4 = c.a;
        this.a = c.n(this, 30);
        Paint r5 = new Paint(1);
        r5.setColor(c.c(this, 2131102124));
        r5.setAlpha(25);
        this.c = r5;
    }
}
