package com.obric.assistant.view.continuespeech;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.random.Random;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0014\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\"\u0018\u0000 h2\u00020\u0001:\u0001hB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u00106\u001a\u000207J\u000e\u00108\u001a\u0002072\u0006\u00109\u001a\u00020\rJ\u000e\u0010:\u001a\u0002072\u0006\u0010;\u001a\u00020\rJ\u000e\u0010<\u001a\u0002072\u0006\u0010=\u001a\u00020\rJ\u000e\u0010>\u001a\u0002072\u0006\u0010?\u001a\u00020\u0007J\b\u0010@\u001a\u000207H\u0014J\b\u0010A\u001a\u000207H\u0014J\u0018\u0010B\u001a\u0002072\u0006\u0010C\u001a\u00020\u00072\u0006\u0010D\u001a\u00020\u0007H\u0014J\u0010\u0010E\u001a\u0002072\u0006\u0010F\u001a\u00020GH\u0014J\u0010\u0010H\u001a\u0002072\u0006\u0010F\u001a\u00020GH\u0002J\b\u0010I\u001a\u000207H\u0002JC\u0010J\u001a\u00020\r2\u0006\u0010K\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010L\u001a\u00020\r2\f\u0010M\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010N\u001a\u00020\r2\u0006\u0010O\u001a\u00020\rH\u0002¢\u0006\u0002\u0010PJ(\u0010Q\u001a\u00020\r2\u0006\u0010K\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010R\u001a\u00020\r2\u0006\u0010S\u001a\u00020\rH\u0002JP\u0010T\u001a\u00020\r2\u0006\u0010K\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010R\u001a\u00020\r2\u0006\u0010U\u001a\u00020\r2\u0006\u0010V\u001a\u00020\r2\u0006\u0010W\u001a\u00020\r2\u0006\u0010X\u001a\u00020\r2\u0006\u0010N\u001a\u00020\r2\u0006\u0010O\u001a\u00020\rH\u0002J(\u0010Y\u001a\u00020\r2\u0006\u0010K\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010Z\u001a\u00020\r2\u0006\u0010[\u001a\u00020\rH\u0002J \u0010\\\u001a\u00020\r2\u0006\u0010]\u001a\u00020\r2\u0006\u0010^\u001a\u00020\r2\u0006\u0010_\u001a\u00020\rH\u0002J \u0010`\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010a\u001a\u00020\r2\u0006\u0010b\u001a\u00020\rH\u0002J\u0010\u0010c\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0007H\u0002J \u0010d\u001a\u00020\r2\u0006\u0010e\u001a\u00020\r2\u0006\u0010f\u001a\u00020\r2\u0006\u0010g\u001a\u00020\rH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\r@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\u001e\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\r@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR$\u0010!\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\r@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001b\"\u0004\b#\u0010\u001dR$\u0010$\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\r@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001b\"\u0004\b&\u0010\u001dR$\u0010'\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\r@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u001b\"\u0004\b)\u0010\u001dR$\u0010*\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\r@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u001b\"\u0004\b,\u0010\u001dR$\u0010-\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\r@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u001b\"\u0004\b/\u0010\u001dR$\u00101\u001a\u0002002\u0006\u0010\u0018\u001a\u000200@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105¨\u0006i"}, d2 = {"Lcom/obric/assistant/view/continuespeech/AudioSpectrumView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "barPaint", "Landroid/graphics/Paint;", "spectrumTimeSeconds", "", "lastFrameUptimeMs", "", "barPhases", "", "", "[[F", "barCount", "barWidthDp", "barGapDp", "minBarHeightDp", "value", "speakIntensity", "getSpeakIntensity", "()F", "setSpeakIntensity", "(F)V", "pauseIntensity", "getPauseIntensity", "setPauseIntensity", "pauseProgress", "getPauseProgress", "setPauseProgress", "pauseSlope", "getPauseSlope", "setPauseSlope", "waveIntensity", "getWaveIntensity", "setWaveIntensity", "wavePlayProgress", "getWavePlayProgress", "setWavePlayProgress", "spectrumAlpha", "getSpectrumAlpha", "setSpectrumAlpha", "", "animateSpectrum", "getAnimateSpectrum", "()Z", "setAnimateSpectrum", "(Z)V", "resetUi", "", "setMinBarHeightDp", "heightDp", "setBarGapDp", "gapDp", "setBarWidthDp", "widthDp", "setBarCount", "count", "onAttachedToWindow", "onDetachedFromWindow", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onDraw", "canvas", "Landroid/graphics/Canvas;", "drawFrame", "ensureBarPhases", "effectAHeightPx", "index1", "timeSeconds", "phases", "minH", "maxH", "(IIF[[FFF)F", "effectBFactor", "progress", "slope", "effectCHeightPx", "barW", "step", "totalW", "waveWidth", "spatialEnvelope", "centerVal", "edgeVal", "clamp", "v", "lo", "hi", "calculateTotalWidth", "barWidth", "gapWidth", "calculateTotalWidthDp", "lerp", "a", "b", "t", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AudioSpectrumView extends View {
    public static final float[] q = null;
    public static final float[] r = null;
    public final Paint a;
    public float b;
    public long c;
    public float[][] d;
    public int e;
    public float f;
    public float g;
    public float h;
    public float i;
    public float j;
    public float k;
    public float l;
    public float m;
    public float n;
    public float o;
    public boolean p;

    public static final class a {
    }

    public AudioSpectrumView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public AudioSpectrumView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    static {
        q = new float[]{5.5f, 9.8f, 14.2f, 3.7f, 19.5f};
        r = new float[]{1.0f, 0.8f, 0.6f, 0.7f, 0.4f};
    }

    public final void b() {
        float[][] r0 = this.d;
        if (r0.length != 5) goto L16;
        int r1 = r0.length;
        int r4 = 0;
    L5:
        boolean r5 = true;
        if (r4 >= r1) goto L14;
        if (r0[r4].length == this.e) goto L11;
        r5 = false;
    L11:
        if (r5 == false) goto L12;
        r4 = r4 + 1;
        goto L5
    L12:
        r5 = false;
    L14:
        if (r5 == false) goto L16;
        return;
    L16:
        float[][] r2 = new float[5][];
        int r3 = 0;
    L17:
        if (r3 >= 5) goto L19;
        r2[r3] = new float[this.e];
        r3 = r3 + 1;
        goto L17
    L19:
        this.d = r2;
        int r6 = 0;
    L20:
        if (r6 >= 5) goto L25;
        int r7 = this.e;
        int r8 = 0;
    L22:
        if (r8 >= r7) goto L24;
        this.d[r6][r8] = Random.Default.nextFloat() * 6.2831855f;
        r8 = r8 + 1;
        goto L22
    L24:
        r6 = r6 + 1;
        goto L20
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        this.c = 0;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        b();
        this.c = 0;
        if (this.p == false) goto L6;
        postInvalidate();
        return;
    }

    public final boolean getAnimateSpectrum() {
        return this.p;
    }

    public final float getPauseIntensity() {
        return this.j;
    }

    public final float getPauseProgress() {
        return this.k;
    }

    public final float getPauseSlope() {
        return this.l;
    }

    public final float getSpeakIntensity() {
        return this.i;
    }

    public final float getSpectrumAlpha() {
        return this.o;
    }

    public final float getWaveIntensity() {
        return this.m;
    }

    public final float getWavePlayProgress() {
        return this.n;
    }

    public final void a(Canvas r35) {
        float r1 = getWidth();
        float r2 = getHeight();
        if (r1 > 0.0f) goto L5;
        return;
    L5:
        if (r2 <= 0.0f) goto L63;
        float r3 = (r1 - getPaddingLeft()) - getPaddingRight();
        float r4 = (r2 - getPaddingTop()) - getPaddingBottom();
        if (r3 > 0.0f) goto L10;
        return;
    L10:
        if (r4 > 0.0f) goto L13;
        return;
    L13:
        if (this.p == false) goto L18;
        long r5 = SystemClock.uptimeMillis();
        long r6 = this.c;
        if (r6 == 0) goto L17;
        this.b += RangesKt.coerceAtLeast(r5 - r6, 0) / 1000.0f;
    L17:
        this.c = r5;
    L18:
        b();
        Resources r7 = getResources();
        float r8 = WindowDisplayMetricsOverride.apply(r7, r7.getDisplayMetrics()).density;
        float r9 = this.f * r8;
        float r10 = this.g * r8;
        float r11 = this.h * r8;
        float r12 = 24.0f * r8;
        float r13 = r8 * 1.0f;
        float r14 = 60.0f * r8;
        float r15 = r8 * 6.0f;
        int r16 = this.e;
        int r17 = 0;
        float r18 = (r16 * r9) + (RangesKt.coerceAtLeast(r16 - 1, 0) * r10);
        if (r18 > r3) goto L21;
    L23:
        float r19 = Math.min(1.0f, r4 / Math.max(1.0E-4f, r12));
        float r20 = r11 * r19;
        float r21 = r12 * r19;
        float r22 = r15 * r19;
        float r110 = r13 * r19;
        float r111 = r9 + r10;
        int r112 = this.e;
        float r23 = (r112 * r9) + (RangesKt.coerceAtLeast(r112 - 1, 0) * r10);
        float r24 = ((r3 - r23) * 0.5f) + getPaddingLeft();
        float r25 = (r4 * 0.5f) + getPaddingTop();
        this.a.setAlpha(RangesKt.coerceIn(MathKt.roundToInt(this.o * 255.0f), 0, 255));
        float r113 = 0.0f;
        float r26 = RangesKt.coerceIn(this.i, 0.0f, 1.0f);
        float r27 = RangesKt.coerceIn(this.j, 0.0f, 1.0f);
        float r28 = RangesKt.coerceIn(this.k, 0.0f, 1.0f);
        float r29 = RangesKt.coerceIn(this.l, 0.0f, 1.0f);
        float r210 = RangesKt.coerceIn(this.m, 0.0f, 1.0f);
        float r211 = RangesKt.coerceIn(this.n, 0.0f, 1.0f);
        int r114 = this.e;
    L24:
        if (r17 >= r114) goto L65;
        int r212 = r17 + 1;
        if (r26 <= r113) goto L36;
        int r115 = this.e;
        float r30 = this.b;
        float[][] r116 = this.d;
        int r117 = r212 - 1;
        int r31 = 0;
        float r118 = 0.0f;
        float r213 = 0.0f;
    L29:
        if (r31 >= 5) goto L31;
        float r32 = q[r31];
        float r214 = r[r31];
        r213 = r213 + (((float) Math.sin((r32 * r30) + r116[r31][r117])) * r214);
        r118 = r118 + r214;
        r31 = r31 + 1;
        r17 = r17;
        r116 = r116;
        goto L29
    L31:
        int r215 = r17;
        float r33 = (float) Math.pow(((Math.max(-r118, Math.min(r118, 1.7f * r213)) / r118) * 0.5f) + 0.5f, 1.6f);
        if (r115 > 1) goto L34;
        float r34 = 0.5f;
    L35:
        float r36 = (((((r21 - r20) * (r33 * (((-0.5f) * (Math.abs(r34 - 0.5f) * 2.0f)) + 1.0f))) + r20) - r20) * r26) + r20;
    L38:
        if (r27 <= 0.0f) goto L45;
        int r37 = this.e;
        if (r37 > 1) goto L42;
        float r38 = 0.5f;
    L43:
        float r39 = Math.abs(r38 - 0.5f) * 2.0f;
        float r40 = Math.max(r29 * 0.5f, 0.001f);
        float r41 = Math.max(0.0f, Math.min(1.0f, (((((r40 + 1.0f) * r28) - r39) / r40) + 1.0f) * 0.5f));
        r36 = r36 + ((r22 - r36) * (((r41 * r41) * (3.0f - (r41 * 2.0f))) * r27));
        goto L45
    L42:
        r38 = (r212 - 1) / (r37 - 1);
    L45:
        if (r210 <= 0.0f) goto L56;
        int r42 = this.e;
        float r119 = ((r212 - 1) * r111) + (r9 / 2.0f);
        float r120 = r23 / 2.0f;
        float r121 = r14 / 2.0f;
        float r122 = (r120 + r121) * r211;
        float r43 = Math.min(Math.abs(r119 - (r120 - r122)), Math.abs(r119 - (r120 + r122)));
        if (r43 < r121) goto L49;
        float r123 = r20;
    L54:
        r36 = r36 + ((Math.max(r36, r123) - r36) * r210);
        goto L56
    L49:
        float r44 = (((float) Math.cos((r43 / r121) * 3.1415927f)) + 1.0f) / 2.0f;
        if (r42 > 1) goto L52;
        float r124 = 0.5f;
    L53:
        r123 = ((r21 - r20) * (r44 * (((-1.0f) * (Math.abs(r124 - 0.5f) * 2.0f)) + 1.0f))) + r20;
        goto L54
    L52:
        r124 = (r212 - 1) / (r42 - 1);
    L56:
        float r125 = r24 + (r215 * r111);
        float r45 = Math.max(r20, Math.min(r21, r36)) * 0.5f;
        r35.drawRoundRect(r125, r25 - r45, r125 + r9, r25 + r45, r110, r110, this.a);
        r114 = r114;
        r17 = r212;
        r110 = r110;
        r25 = r25;
        r24 = r24;
        r113 = 0.0f;
        goto L24
    L34:
        r34 = (r212 - 1) / (r115 - 1);
        goto L35
    L36:
        r215 = r17;
        r36 = r20;
        goto L38
    L65:
        return;
    L21:
        if (r18 <= 0.0f) goto L23;
        float r126 = r3 / r18;
        r9 = r9 * r126;
        r10 = r10 * r126;
        r13 = r13 * r126;
        r14 = r14 * r126;
        goto L23
    }

    @Override // android.view.View
    public final void onDraw(Canvas r2) {
        Intrinsics.checkNotNullParameter(r2, "canvas");
        a(r2);     // Catch: Throwable -> L8
        if (this.p == false) goto L15;
        postInvalidate();
        return;
    L15:
        return;
    L8:
        th = move-exception;
        if (this.p == false) goto L12;
        postInvalidate();
    L12:
        throw th;
    }

    public final void setAnimateSpectrum(boolean r4) {
        if (this.p != r4) goto L5;
        return;
    L5:
        FLogger.a.i("AudioSpectrumView", "animateSpectrum changed: " + this.p + " -> " + r4);
        this.p = r4;
        this.c = 0;
        postInvalidate();
    }

    public final void setBarCount(int r2) {
        int r3 = RangesKt.coerceAtLeast(r2, 1);
        if (this.e != r3) goto L5;
        return;
    L5:
        this.e = r3;
        this.d = new float[0][];
        requestLayout();
        invalidate();
    }

    public final void setBarGapDp(float r2) {
        float r3 = RangesKt.coerceAtLeast(r2, 0.0f);
        if (this.g != r3) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        this.g = r3;
        requestLayout();
        invalidate();
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void setBarWidthDp(float r2) {
        float r3 = RangesKt.coerceAtLeast(r2, 0.0f);
        if (this.f != r3) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        this.f = r3;
        requestLayout();
        invalidate();
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void setMinBarHeightDp(float r3) {
        float r4 = RangesKt.coerceIn(r3, 0.0f, 24.0f);
        if (this.h != r4) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        this.h = r4;
        invalidate();
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void setPauseIntensity(float r3) {
        this.j = RangesKt.coerceIn(r3, 0.0f, 1.0f);
        invalidate();
    }

    public final void setPauseProgress(float r3) {
        this.k = RangesKt.coerceIn(r3, 0.0f, 1.0f);
        invalidate();
    }

    public final void setPauseSlope(float r3) {
        this.l = RangesKt.coerceIn(r3, 0.0f, 1.0f);
        invalidate();
    }

    public final void setSpeakIntensity(float r3) {
        this.i = RangesKt.coerceIn(r3, 0.0f, 1.0f);
        invalidate();
    }

    public final void setSpectrumAlpha(float r3) {
        this.o = RangesKt.coerceIn(r3, 0.0f, 1.0f);
        invalidate();
    }

    public final void setWaveIntensity(float r3) {
        this.m = RangesKt.coerceIn(r3, 0.0f, 1.0f);
        invalidate();
    }

    public final void setWavePlayProgress(float r3) {
        this.n = RangesKt.coerceIn(r3, 0.0f, 1.0f);
        invalidate();
    }

    @Override // android.view.View
    public final void onMeasure(int r5, int r6) {
        Resources r0 = getResources();
        float r1 = WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density;
        int r2 = this.e;
        setMeasuredDimension(View.resolveSize((int) ((((((r2 * this.f) + (RangesKt.coerceAtLeast(r2 - 1, 0) * this.g)) * r1) + getPaddingLeft()) + getPaddingRight()) + 0.5f), r5), View.resolveSize((int) ((((r1 * 24.0f) + getPaddingTop()) + getPaddingBottom()) + 0.5f), r6));
    }

    public AudioSpectrumView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        Paint r5 = new Paint(1);
        r5.setColor(-1);
        this.a = r5;
        this.d = new float[0][];
        this.e = 24;
        this.f = 2.0f;
        this.g = 3.0f;
        this.h = 4.0f;
        this.l = 0.15f;
        this.o = 1.0f;
        this.p = true;
        Paint r6 = new Paint();
        r6.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        Unit r7 = Unit.INSTANCE;
        setLayerType(2, r6);
    }

    public /* synthetic */ AudioSpectrumView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
