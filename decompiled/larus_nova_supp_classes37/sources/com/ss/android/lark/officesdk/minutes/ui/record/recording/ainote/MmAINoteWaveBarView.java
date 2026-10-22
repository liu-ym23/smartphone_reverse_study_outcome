package com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import androidx.core.content.ContextCompat;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 )2\u00020\u0001:\u0001)B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u001c\u001a\u00020\u001dJ\u0006\u0010\u001e\u001a\u00020\u001dJ\b\u0010\u001f\u001a\u00020\u001dH\u0014J\b\u0010 \u001a\u00020\u001dH\u0014J\u0018\u0010!\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u00012\u0006\u0010#\u001a\u00020\u0007H\u0014J\u0010\u0010$\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020&H\u0014J \u0010'\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010(\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0011H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00110\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00110\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00110\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0019\u001a\n \u001b*\u0004\u0018\u00010\u001a0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/ainote/MmAINoteWaveBarView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isLowDevice", "", "animationDurationMs", "", "paint", "Landroid/graphics/Paint;", "baseSizePx", "", "baseStrokeWidthPx", "startBarHeightsPx", "", "endBarHeightsPx", "barCentersPx", "progress", "isAnimating", "animator", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "start", "", "stop", "onAttachedToWindow", "onDetachedFromWindow", "onVisibilityChanged", "changedView", "visibility", "onDraw", "canvas", "Landroid/graphics/Canvas;", "lerp", "end", "Companion", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class MmAINoteWaveBarView extends View {
    public static final float[] k = null;
    public static final float[] l = null;
    public static final float[] m = null;
    public final long a;
    public final Paint b;
    public final float c;
    public final float d;
    public final List<Float> e;
    public final List<Float> f;
    public final List<Float> g;
    public float h;
    public boolean i;
    public final ValueAnimator j;

    public static final class a {
    }

    public static final class b implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ MmAINoteWaveBarView a;

        public b(MmAINoteWaveBarView r1) {
            this.a = r1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r3) {
            Intrinsics.checkNotNullParameter(r3, "it");
            MmAINoteWaveBarView r0 = this.a;
            Object r4 = r3.getAnimatedValue();
            Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type kotlin.Float");
            r0.h = ((Float) r4).floatValue();
            this.a.invalidate();
        }
    }

    public MmAINoteWaveBarView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public MmAINoteWaveBarView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final void a() {
        this.i = false;
        if (this.j.isRunning() == false) goto L5;
        this.j.cancel();
    L5:
        this.h = 0.0f;
        invalidate();
    }

    static {
        k = new float[]{7.0f, 13.0f, 17.0f, 9.0f};
        l = new float[]{8.0f, 4.0f, 6.0f, 12.0f};
        m = new float[]{4.0f, 9.0f, 14.0f, 19.0f};
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        this.j.cancel();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.i == true) goto L5;
        return;
    L5:
        if (this.j.isRunning() == false) goto L7;
        return;
    L7:
        if (getVisibility() == 0) goto L9;
        return;
    L9:
        if (isShown() == false) goto L15;
        this.j.start();
        return;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r13) {
        Intrinsics.checkNotNullParameter(r13, "canvas");
        super.onDraw(r13);
        if (this.c <= 0.0f) goto L5;
        float r0 = getWidth() / this.c;
    L7:
        if (this.c <= 0.0f) goto L9;
        float r7 = getHeight() / this.c;
    L10:
        this.b.setStrokeWidth(this.d * Math.min(r0, r7));
        float r9 = getHeight() / 2.0f;
        int r10 = this.e.size();
        int r11 = 0;
    L11:
        if (r11 >= r10) goto L13;
        float r1 = ((Number) ListProtector.get(this.e, r11)).floatValue();
        float r2 = ((r1 + ((((Number) ListProtector.get(this.f, r11)).floatValue() - r1) * this.h)) * r7) / 2.0f;
        float r4 = RangesKt.coerceIn(((Number) ListProtector.get(this.g, r11)).floatValue() * r0, this.b.getStrokeWidth() / 2.0f, getWidth() - (this.b.getStrokeWidth() / 2.0f));
        r13.drawLine(r4, r9 - r2, r4, r9 + r2, this.b);
        r11 = r11 + 1;
        goto L11
    L13:
        return;
    L9:
        r7 = 1.0f;
        goto L10
    L5:
        r0 = 1.0f;
        goto L7
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "changedView");
        super.onVisibilityChanged(r2, r3);
        if (this.i == true) goto L5;
        return;
    L5:
        if (r3 != 0) goto L12;
        if (isShown() == false) goto L12;
        if (this.j.isRunning() == true) goto L15;
        this.j.start();
        return;
    L15:
        return;
    L12:
        if (this.j.isRunning() == false) goto L17;
        this.j.cancel();
        return;
    }

    public MmAINoteWaveBarView(Context r5, AttributeSet r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r6, r7);
        this.a = 300;
        Paint r8 = new Paint(1);
        r8.setColor(ContextCompat.getColor(r5, 2131102043));
        r8.setStrokeCap(Paint.Cap.ROUND);
        this.b = r8;
        this.c = UIUtils.dp2px(r5, 24.0f);
        this.d = UIUtils.dp2px(r5, 2.0f);
        float[] r9 = k;
        ArrayList r10 = new ArrayList(4);
        int r1 = 0;
        int r2 = 0;
    L3:
        if (r2 >= 4) goto L5;
        r10.add(Float.valueOf(UIUtils.dp2px(r5, r9[r2])));
        r2 = r2 + 1;
        goto L3
    L5:
        this.e = r10;
        float[] r11 = l;
        ArrayList r12 = new ArrayList(4);
        int r3 = 0;
    L6:
        if (r3 >= 4) goto L8;
        r12.add(Float.valueOf(UIUtils.dp2px(r5, r11[r3])));
        r3 = r3 + 1;
        goto L6
    L8:
        this.f = r12;
        float[] r13 = m;
        ArrayList r14 = new ArrayList(4);
    L9:
        if (r1 >= 4) goto L11;
        r14.add(Float.valueOf(UIUtils.dp2px(r5, r13[r1])));
        r1 = r1 + 1;
        goto L9
    L11:
        this.g = r14;
        ValueAnimator r15 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r15.setDuration(this.a);
        r15.setInterpolator(new LinearInterpolator());
        r15.setRepeatCount(-1);
        r15.setRepeatMode(2);
        r15.addUpdateListener(new b(this));
        this.j = r15;
    }

    public /* synthetic */ MmAINoteWaveBarView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
