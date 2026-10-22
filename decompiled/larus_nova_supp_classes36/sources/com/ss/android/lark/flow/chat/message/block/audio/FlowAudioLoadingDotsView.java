package com.ss.android.lark.flow.chat.message.block.audio;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 %2\u00020\u0001:\u0001%B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0014\u001a\u00020\u00152\b\b\u0001\u0010\u0016\u001a\u00020\u0007J\u0006\u0010\u0017\u001a\u00020\u0015J\u0006\u0010\u0018\u001a\u00020\u0015J\u0006\u0010\u0019\u001a\u00020\u0015J\b\u0010\u001a\u001a\u00020\u0015H\u0014J\u0018\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0007H\u0014J\u0010\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020 H\u0014J\u0010\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u000eH\u0002J\u0010\u0010#\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020\u000eH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/ss/android/lark/flow/chat/message/block/audio/FlowAudioLoadingDotsView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "paint", "Landroid/graphics/Paint;", "dotColor", "dotSizePx", "", "dotGapPx", "dotAlphas", "", "animator", "Landroid/animation/ValueAnimator;", "setDotColor", "", "color", "start", "showStaticDots", "stop", "onDetachedFromWindow", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onDraw", "canvas", "Landroid/graphics/Canvas;", "updateAlphas", "progress", "dpToPx", "dp", "Companion", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class FlowAudioLoadingDotsView extends View {
    public static final float[][] g = null;
    public final Paint a;
    public int b;
    public final float c;
    public final float d;
    public final float[] e;
    public ValueAnimator f;

    public static final class a {
    }

    public static final class b implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ FlowAudioLoadingDotsView a;

        public b(FlowAudioLoadingDotsView r1) {
            this.a = r1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r9) {
            Intrinsics.checkNotNullParameter(r9, "valueAnimator");
            Object r10 = r9.getAnimatedValue();
            Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type kotlin.Float");
            float r11 = ((Float) r10).floatValue();
            FlowAudioLoadingDotsView r0 = this.a;
            float[][] r1 = FlowAudioLoadingDotsView.g;
            r0.getClass();
            float r12 = RangesKt.coerceIn(r11, 0.0f, 1.0f) * 3.0f;
            int r5 = 0;
            int r3 = RangesKt.coerceIn((int) r12, 0, 2);
            float r13 = RangesKt.coerceIn(r12 - r3, 0.0f, 1.0f);
            int r2 = (r3 + 1) % 3;
            float[][] r4 = FlowAudioLoadingDotsView.g;
            float[] r6 = r4[r3];
            float[] r7 = r4[r2];
        L3:
            if (r5 >= 3) goto L5;
            float[] r8 = r0.e;
            float r14 = r6[r5];
            r8[r5] = r14 + ((r7[r5] - r14) * r13);
            r5 = r5 + 1;
            goto L3
        L5:
            this.a.invalidate();
        }
    }

    public FlowAudioLoadingDotsView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public FlowAudioLoadingDotsView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    static {
        g = new float[][]{new float[]{1.0f, 0.5f, 0.3f}, new float[]{0.3f, 1.0f, 0.5f}, new float[]{0.5f, 0.3f, 1.0f}};
    }

    public final void a() {
        ValueAnimator r0 = this.f;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        if (r1 == false) goto L9;
        return;
    L9:
        ValueAnimator r2 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r2.setDuration(900);
        r2.setRepeatCount(-1);
        r2.setRepeatMode(1);
        r2.setInterpolator(new LinearInterpolator());
        r2.addUpdateListener(new b(this));
        r2.start();
        this.f = r2;
        return;
    L5:
        if (r0.isStarted() != true) goto L7;
        r1 = true;
        goto L7
    }

    public final void b() {
        ValueAnimator r0 = this.f;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        this.f = null;
        float[] r1 = this.e;
        r1[0] = 0.0f;
        r1[1] = 0.0f;
        r1[2] = 0.0f;
        invalidate();
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r11) {
        Intrinsics.checkNotNullParameter(r11, "canvas");
        super.onDraw(r11);
        float r0 = this.c;
        float r2 = r0 / 2.0f;
        float r4 = ((getWidth() - ((r0 * 3) + (this.d * 2))) / 2.0f) + r2;
        float r1 = getHeight() / 2.0f;
        int r5 = 0;
    L3:
        if (r5 >= 3) goto L5;
        float r6 = (r5 * (this.c + this.d)) + r4;
        this.a.setAlpha(RangesKt.coerceIn((int) (Math.max(0.0f, this.e[r5]) * 255), 0, 255));
        r11.drawCircle(r6, r1, r2, this.a);
        r5 = r5 + 1;
        goto L3
    L5:
        this.a.setColor(this.b);
    }

    public final void setDotColor(int r2) {
        this.b = r2;
        this.a.setColor(r2);
        invalidate();
    }

    @Override // android.view.View
    public final void onMeasure(int r5, int r6) {
        float r0 = this.c;
        setMeasuredDimension(View.resolveSize((int) ((3 * r0) + (this.d * 2)), r5), View.resolveSize((int) r0, r6));
    }

    public FlowAudioLoadingDotsView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        Paint r5 = new Paint(1);
        r5.setColor(-1);
        this.a = r5;
        this.b = r5.getColor();
        Resources r6 = getResources();
        this.c = 8.0f * WindowDisplayMetricsOverride.apply(r6, r6.getDisplayMetrics()).density;
        Resources r7 = getResources();
        this.d = 4.0f * WindowDisplayMetricsOverride.apply(r7, r7.getDisplayMetrics()).density;
        this.e = new float[]{0.0f, 0.0f, 0.0f};
    }

    public /* synthetic */ FlowAudioLoadingDotsView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
