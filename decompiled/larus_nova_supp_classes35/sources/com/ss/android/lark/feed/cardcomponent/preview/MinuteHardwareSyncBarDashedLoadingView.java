package com.ss.android.lark.feed.cardcomponent.preview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.view.View;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.ttvideoengine.superresolution.SRStrategy;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0000*\u00011\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u00103\u001a\u000204H\u0002J(\u00105\u001a\u0002042\u0006\u00106\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u00072\u0006\u00108\u001a\u00020\u00072\u0006\u00109\u001a\u00020\u0007H\u0014J\u0018\u0010:\u001a\u0002042\u0006\u0010;\u001a\u00020\u00072\u0006\u0010<\u001a\u00020\u0007H\u0014J\u0018\u0010=\u001a\u0002042\u0006\u0010>\u001a\u00020\u00072\u0006\u0010?\u001a\u00020\u0007H\u0002J\u0010\u0010@\u001a\u0002042\u0006\u0010A\u001a\u00020\u0015H\u0016J\u0010\u0010B\u001a\u0002042\u0006\u0010A\u001a\u00020\u0015H\u0002J\u0006\u0010C\u001a\u000204J\u0006\u0010D\u001a\u000204J\u0006\u0010E\u001a\u000204J\u000e\u0010F\u001a\u0002042\u0006\u0010G\u001a\u00020\u0015J\u0006\u0010H\u001a\u000204J\u0006\u0010I\u001a\u000204J\u0006\u0010J\u001a\u00020\u0015J\b\u0010K\u001a\u000204H\u0014J\b\u0010L\u001a\u000204H\u0014J\u0010\u0010M\u001a\u0002042\u0006\u0010N\u001a\u00020OH\u0014R\u0014\u0010\n\u001a\u00020\u000bX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000bX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u000bX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000bX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0014\u0010\u0014\u001a\u00020\u0015X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u0007X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u0007X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u0012\u0010$\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010%R$\u0010'\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u00078B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b(\u0010\u0019\"\u0004\b)\u0010*R\u000e\u0010+\u001a\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u000201X\u0082\u0004¢\u0006\u0004\n\u0002\u00102¨\u0006P"}, d2 = {"Lcom/ss/android/lark/feed/cardcomponent/preview/MinuteHardwareSyncBarDashedLoadingView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", BuildConfig.FLAVOR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "viewportSize", BuildConfig.FLAVOR, "getViewportSize", "()F", "strokeWidthFactor", "getStrokeWidthFactor", "dashWidthFactor", "getDashWidthFactor", "dashGapFactor", "getDashGapFactor", "isClockwise", BuildConfig.FLAVOR, "()Z", "normalDeltaAngle", "getNormalDeltaAngle", "()I", "fastDeltaAngle", "getFastDeltaAngle", "basePath", "Landroid/graphics/Path;", "drawPath", "matrix", "Landroid/graphics/Matrix;", "paint", "Landroid/graphics/Paint;", "refreshRate", "_deltaAngle", "Ljava/lang/Integer;", "value", "deltaAngle", "getDeltaAngle", "setDeltaAngle", "(I)V", "rotateDelay", BuildConfig.FLAVOR, "currentAngle", "isRunning", "hostVisible", "updateAngle", "com/ss/android/lark/feed/cardcomponent/preview/MinuteHardwareSyncBarDashedLoadingView$updateAngle$1", "Lcom/ss/android/lark/feed/cardcomponent/preview/MinuteHardwareSyncBarDashedLoadingView$updateAngle$1;", "buildBasePath", BuildConfig.FLAVOR, "onSizeChanged", SRStrategy.MEDIAINFO_KEY_WIDTH, "h", "oldw", "oldh", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "updatePathForSize", "width", "height", "setEnabled", "enabled", "updatePaintColor", "startRotateAnim", "pauseRotateAnim", "stopRotateAnim", "setFastRotate", "isFast", "onHostInvisible", "onHostVisible", "isRunningAnim", "onAttachedToWindow", "onDetachedFromWindow", "onDraw", "canvas", "Landroid/graphics/Canvas;", "feed-card-component_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MinuteHardwareSyncBarDashedLoadingView extends View {
    public final float a;
    public final float b;
    public final float c;
    public final float d;
    public final boolean e;
    public final int f;
    public final int g;
    public final Path h;
    public final Path i;
    public final Matrix j;
    public final Paint k;
    public Integer l;
    public final long m;
    public float n;
    public boolean o;
    public final boolean p;
    public final a q;

    public static final class a implements Runnable {
        public final /* synthetic */ MinuteHardwareSyncBarDashedLoadingView a;

        public final void a() {
            MinuteHardwareSyncBarDashedLoadingView r0 = this.a;
            if (r0.o == true) goto L5;
            return;
        L5:
            if (r0.p == false) goto L20;
            float r1 = r0.n;
            if (r0.e == false) goto L10;
            int r2 = MinuteHardwareSyncBarDashedLoadingView.a(r0);
        L11:
            r0.n = r1 + r2;
            MinuteHardwareSyncBarDashedLoadingView r3 = this.a;
            float r4 = r3.n;
            if (r4 < 360.0f) goto L15;
            r3.n = r4 - 360.0f;
        L17:
            r3.invalidate();
            MinuteHardwareSyncBarDashedLoadingView r5 = this.a;
            r5.postDelayed(this, r5.m);
            return;
        L15:
            if (r4 > (-360.0f)) goto L17;
            r3.n = r4 + 360.0f;
            goto L17
        L10:
            r2 = -MinuteHardwareSyncBarDashedLoadingView.a(r0);
            goto L11
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

        public a(MinuteHardwareSyncBarDashedLoadingView r1) {
            this.a = r1;
        }
    }

    public MinuteHardwareSyncBarDashedLoadingView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public MinuteHardwareSyncBarDashedLoadingView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final void b() {
        this.o = false;
        removeCallbacks(this.q);
        this.n = 0.0f;
        setRotation(0.0f);
        setDeltaAngle(this.f);
        if (getLayerType() == 0) goto L6;
        setLayerType(0, null);
        return;
    }

    private final int getDeltaAngle() {
        Integer r0 = this.l;
        if (r0 == null) goto L6;
        return r0.intValue();
    L6:
        return this.f;
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isEnabled() == true) goto L6;
        c(false);
        return;
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b();
    }

    public final float getDashGapFactor() {
        return this.d;
    }

    public final float getDashWidthFactor() {
        return this.c;
    }

    public final int getFastDeltaAngle() {
        return this.g;
    }

    public final int getNormalDeltaAngle() {
        return this.f;
    }

    public final float getStrokeWidthFactor() {
        return this.b;
    }

    public final float getViewportSize() {
        return this.a;
    }

    public static final /* synthetic */ int a(MinuteHardwareSyncBarDashedLoadingView r0) {
        return r0.getDeltaAngle();
    }

    private final void setDeltaAngle(int r1) {
        this.l = Integer.valueOf(r1);
    }

    public final void c(boolean r3) {
        if (r3 == false) goto L4;
        int r4 = 2131108615;
    L5:
        this.k.setColor(UDColorUtils.getColor(getContext(), r4));
        invalidate();
        return;
    L4:
        r4 = 2131102416;
        goto L5
    }

    @Override // android.view.View
    public final void onDraw(Canvas r4) {
        Intrinsics.checkNotNullParameter(r4, "canvas");
        super.onDraw(r4);
        float r0 = getWidth() / 2.0f;
        float r2 = getHeight() / 2.0f;
        r4.save();
        r4.rotate(this.n, r0, r2);
        r4.drawPath(this.i, this.k);
        r4.restore();
    }

    @Override // android.view.View
    public void setEnabled(boolean r1) {
        super.setEnabled(r1);
        c(r1);
    }

    public final void setFastRotate(boolean r1) {
        if (r1 == false) goto L4;
        int r2 = this.g;
    L5:
        setDeltaAngle(r2);
        return;
    L4:
        r2 = this.f;
        goto L5
    }

    @Override // android.view.View
    public final void onMeasure(int r3, int r4) {
        Resources r0 = getResources();
        float r1 = WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density;
        int r2 = RangesKt.coerceAtLeast((int) (this.a * r1), 1);
        setMeasuredDimension(View.resolveSize(r2, r3), View.resolveSize(r2, r4));
    }

    public MinuteHardwareSyncBarDashedLoadingView(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        this.a = 16.0f;
        this.b = 2.0f;
        this.c = 1.2f;
        this.d = 1.5f;
        this.e = true;
        this.f = 4;
        this.g = 4;
        this.h = new Path();
        this.i = new Path();
        this.j = new Matrix();
        Paint r6 = new Paint(1);
        r6.setStyle(Paint.Style.STROKE);
        this.k = r6;
        this.m = 1000 / ((long) 20);
        this.p = true;
        this.q = new a(this);
        c(isEnabled());
    }

    public /* synthetic */ MinuteHardwareSyncBarDashedLoadingView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r5, int r6, int r7, int r8) {
        super.onSizeChanged(r5, r6, r7, r8);
        if (r5 <= 0) goto L11;
        if (r6 <= 0) goto L12;
        this.h.reset();
        float r9 = this.a / 2.0f;
        this.h.addCircle(r9, r9, r9 - (this.b / 2), Path.Direction.CW);
        float r10 = Math.min(r5, r6);
        float r0 = this.a;
        float r11 = r10 / r0;
        float r1 = r0 * r11;
        this.j.reset();
        this.j.postScale(r11, r11);
        this.j.postTranslate((r5 - r1) / 2.0f, (r6 - r1) / 2.0f);
        this.h.transform(this.j, this.i);
        float r12 = this.b * r11;
        float r13 = this.c * r11;
        float r14 = (this.d * r11) + r13;
        float r15 = new PathMeasure(this.i, true).getLength();
        int r2 = RangesKt.coerceAtLeast((int) (r15 / r14), 1);
        if (r2 <= 0) goto L8;
        float r16 = r15 / r2;
    L9:
        float r17 = (r13 / r14) * r16;
        this.k.setStrokeWidth(r12);
        this.k.setPathEffect(new DashPathEffect(new float[]{r17, r16 - r17}, 0.0f));
        return;
    L8:
        r16 = r14;
        goto L9
    L12:
        return;
    }
}
