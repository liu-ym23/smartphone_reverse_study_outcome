package com.ss.android.lark.feed.cardcomponent.preview;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.chameleon.basewebview.BizScene;
import com.ss.android.lark.log.Log;
import com.ss.ttvideoengine.utils.ScreenUtils;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 02\u00020\u0001:\u00010B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001cJ\b\u0010 \u001a\u00020\u001eH\u0002J\u0010\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#H\u0014J0\u0010$\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u0007H\u0014J\b\u0010*\u001a\u00020\u001eH\u0014J\u0010\u0010+\u001a\u00020\u001e2\u0006\u0010,\u001a\u00020\u001cH\u0016J\u0006\u0010-\u001a\u00020\u001eJ\u0006\u0010.\u001a\u00020\u001eJ\b\u0010/\u001a\u00020\rH\u0002R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/ss/android/lark/feed/cardcomponent/preview/RecordingDotView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", BuildConfig.FLAVOR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "dotBaseColor", "circleColor", "maxDotRadius", BuildConfig.FLAVOR, "dotRadius", "pausedDotRadius", "outerStrokeWidth", "animFps", "animationDuration", BuildConfig.FLAVOR, "outerRadius", "currentFillOpacity", "outerStrokePaint", "Landroid/graphics/Paint;", "innerFillPaint", "animator", "Landroid/animation/ValueAnimator;", "breathingEnabled", BuildConfig.FLAVOR, "setBreathingEnabled", BuildConfig.FLAVOR, "enabled", "updatePaintColors", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onLayout", "changed", "left", "top", "right", "bottom", "onDetachedFromWindow", "onVisibilityAggregated", "isVisible", "startBreathing", "stopBreathing", "getPausedDotRadius", "Companion", "feed-card-component_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RecordingDotView extends View {
    public final int a;
    public float b;
    public float c;
    public final float d;
    public final float e;
    public final int f;
    public final long g;
    public float h;
    public float i;
    public final Paint j;
    public final Paint k;
    public ValueAnimator l;
    public boolean m;

    public static final class a {
    }

    static {
    }

    public RecordingDotView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public RecordingDotView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    private final float getPausedDotRadius() {
        return Math.min(this.b, this.d);
    }

    public final void a() {
        ValueAnimator r0 = this.l;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        if (r1 == true) goto L18;
        Log.d("RecordingDotView", "startBreathing");
        ValueAnimator r2 = this.l;
        if (r2 == null) goto L12;
        r2.cancel();
    L12:
        if (this.l != null) goto L14;
        ValueAnimator r3 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r3.setDuration(this.g);
        r3.setRepeatCount(-1);
        r3.setRepeatMode(2);
        r3.setInterpolator(new LinearInterpolator());
        int r4 = this.f;
        Function1<ValueAnimator, Unit> r5 = new RecordingDotView$startBreathing$2(this);
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r5, BizScene.BLOCK);
        long r6 = 1000 / ((long) RangesKt.coerceIn(r4, new IntRange(1, 60)));
        Ref.LongRef r7 = new Ref.LongRef();
        r3.removeAllUpdateListeners();
        r3.addUpdateListener(new f(r7, r6, r5));
        this.l = r3;
    L14:
        ValueAnimator r8 = this.l;
        if (r8 == null) goto L19;
        r8.start();
        return;
    L19:
        return;
    L18:
        return;
    L5:
        if (r0.isRunning() != true) goto L7;
        r1 = true;
        goto L7
    }

    public final void b() {
        Log.d("RecordingDotView", "stopBreathing");
        ValueAnimator r0 = this.l;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        this.l = null;
        this.i = 1.0f;
        if (this.m == false) goto L8;
        float r1 = this.b;
    L9:
        this.c = r1;
        c();
        invalidate();
        return;
    L8:
        r1 = getPausedDotRadius();
        goto L9
    }

    public final void c() {
        int r0 = RangesKt.coerceIn((int) (this.i * 255.0f), 0, ScreenUtils.MAX_SYSTEM_BRIGHTNESS);
        int r1 = this.a & 16777215;
        this.k.setColor((r0 << 24) | r1);
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r7) {
        Intrinsics.checkNotNullParameter(r7, "canvas");
        super.onDraw(r7);
        float r0 = getWidth() / 2.0f;
        float r2 = getHeight() / 2.0f;
        float r1 = Math.max(0.0f, this.c);
        float r4 = this.h;
        if (r4 <= 0.0f) goto L6;
        r7.drawCircle(r0, r2, r4, this.j);
    L6:
        if (r1 <= 0.0f) goto L9;
        r7.drawCircle(r0, r2, r1, this.k);
        return;
    }

    @Override // android.view.View
    public final void onVisibilityAggregated(boolean r2) {
        if (r2 == true) goto L4;
    L6:
        b();
    L7:
        super.onVisibilityAggregated(r2);
        return;
    L4:
        if (this.m == false) goto L6;
        a();
        goto L7
    }

    public final void setBreathingEnabled(boolean r2) {
        if (this.m != r2) goto L5;
        return;
    L5:
        this.m = r2;
        if (r2 == true) goto L8;
    L10:
        b();
        return;
    L8:
        if (isShown() == false) goto L10;
        a();
    }

    public RecordingDotView(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        this.a = UIUtils.getColor(r3, 2131102093);
        int r6 = UIUtils.getColor(r3, 2131102094);
        float r0 = UIUtils.dp2px(r3, 3.0f);
        this.b = r0;
        this.c = r0;
        this.d = UIUtils.dp2px(r3, 3.0f);
        float r7 = UIUtils.dp2px(r3, 1.0f);
        this.e = r7;
        this.f = 20;
        this.g = 700;
        this.i = 1.0f;
        Paint r8 = new Paint(1);
        r8.setStyle(Paint.Style.STROKE);
        r8.setStrokeWidth(r7);
        r8.setColor(r6);
        this.j = r8;
        Paint r9 = new Paint(1);
        r9.setStyle(Paint.Style.FILL);
        this.k = r9;
        this.m = true;
        c();
    }

    public /* synthetic */ RecordingDotView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    @Override // android.view.View
    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        float r6 = Math.max(0.0f, (Math.min((getWidth() - getPaddingLeft()) - getPaddingRight(), (getHeight() - getPaddingTop()) - getPaddingBottom()) / 2.0f) - (this.e / 2.0f));
        this.h = r6;
        float r7 = Math.max(0.0f, r6 - this.e);
        this.b = r7;
        if (this.m == true) goto L6;
        r7 = getPausedDotRadius();
    L6:
        this.c = r7;
    }
}
