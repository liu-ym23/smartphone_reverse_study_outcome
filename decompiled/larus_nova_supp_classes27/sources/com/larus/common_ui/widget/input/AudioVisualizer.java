package com.larus.common_ui.widget.input;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000 92\u00020\u00012\u00020\u0002:\u00019B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0005\u0010\tB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\fJ\u001a\u0010 \u001a\u00020!2\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J\u0010\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020$H\u0014J\u0010\u0010%\u001a\u00020\u001b2\u0006\u0010&\u001a\u00020\u001bH\u0002J\u000e\u0010'\u001a\u00020!2\u0006\u0010(\u001a\u00020)J\u0010\u0010'\u001a\u00020!2\u0006\u0010&\u001a\u00020\u001bH\u0002J\u0010\u0010*\u001a\u00020!2\u0006\u0010+\u001a\u00020)H\u0002J\u0016\u0010,\u001a\u00020!2\u0006\u0010-\u001a\u00020)H\u0096@¢\u0006\u0002\u0010.J\b\u0010/\u001a\u00020!H\u0016J\b\u00100\u001a\u00020!H\u0016J\b\u00101\u001a\u000202H\u0016J\u0010\u00103\u001a\u00020!2\u0006\u00104\u001a\u000205H\u0016J\u0012\u00106\u001a\u00020!2\b\u00107\u001a\u0004\u0018\u000108H\u0016R\u000e\u0010\r\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u001b0\u001dj\b\u0012\u0004\u0012\u00020\u001b`\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\u001b0\u001dj\b\u0012\u0004\u0012\u00020\u001b`\u001eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lcom/larus/common_ui/widget/input/AudioVisualizer;", "Landroid/view/View;", "Lcom/larus/common_ui/widget/input/audiowave/IAudioWaveView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "density", "visualizerWidth", "", "visualizerHeight", "barWidth", "minBarHeight", "maxBarHeight", "barColor", "paint", "Landroid/graphics/Paint;", "invalidateTime", "drawTime", "", "maxSampleData", "", "sampleData", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "finalData", "init", "", "onDraw", "canvas", "Landroid/graphics/Canvas;", "optSample", "sample", "setAudioData", "data", "", "handle16bit", "bytes", "updateAudioData", "audioData", "([BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startWaveAnim", "stopWaveAnim", "isAnimating", "", "setWaveTintList", "tint", "Landroid/content/res/ColorStateList;", "setWaveTintMode", "mode", "Landroid/graphics/PorterDuff$Mode;", "Companion", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class AudioVisualizer extends View {
    public final int a;
    public final float b;
    public final float c;
    public float d;
    public final float e;
    public final float f;
    public final int g;
    public Paint h;
    public final double i;
    public final ArrayList<Double> j;

    public static final class a {
    }

    static {
    }

    public final void a() {
        Paint r0 = new Paint();
        r0.setAntiAlias(true);
        r0.setFilterBitmap(true);
        r0.setStrokeCap(Paint.Cap.ROUND);
        this.h = r0;
        int r1 = this.a;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        this.j.add(Double.valueOf(0.0d));
        r2 = r2 + 1;
        goto L3
    L5:
        postInvalidate();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r20) {
        Intrinsics.checkNotNullParameter(r20, "canvas");
        FLogger r1 = FLogger.a;
        String r9 = "AudioVisualizer";
        r1.d("AudioVisualizer", "onDraw: called");
        if ((!this.j.isEmpty()) == true) goto L5;
        return;
    L5:
        if (r1.isDebug() == false) goto L14;
        r1.d("AudioVisualizer", "onDraw: called, maxSampleData = " + this.i);
        Iterator<T> r2 = this.j.iterator();
        String r3 = "onDraw: called, finalDatas = ";
        int r4 = 0;
    L8:
        if (r2.hasNext() == false) goto L13;
        Object r5 = r2.next();
        int r6 = r4 + 1;
        if (r4 >= 0) goto L12;
        CollectionsKt.throwIndexOverflow();
    L12:
        r3 = r3 + ' ' + ((Number) r5).doubleValue() + ',';
        r4 = r6;
        goto L8
    L13:
        FLogger.a.d("AudioVisualizer", r3);
    L14:
        float r7 = getWidth();
        float r8 = this.b;
        if (r7 > r8) goto L18;
        r8 = getWidth();
    L18:
        float r10 = getHeight();
        float r11 = this.c;
        if (r10 > r11) goto L22;
        r11 = getHeight();
    L22:
        int r12 = this.a;
        float r13 = (1.0f * r8) / r12;
        if (this.d <= r13) goto L25;
        this.d = r13;
    L25:
        float r14 = (r8 - (this.d * r12)) / (r12 - 1);
        float r15 = this.f;
        if (r11 <= r15) goto L28;
        float r16 = r15;
    L29:
        float r17 = this.e;
        if (r11 <= r17) goto L35;
        if (r15 <= r17) goto L37;
        float r18 = r17;
    L38:
        Paint r21 = this.h;
        Intrinsics.checkNotNull(r21);
        r21.setStrokeWidth(this.d);
        float r110 = 2;
        float r111 = (getWidth() - this.b) / r110;
        float r112 = (getHeight() - this.c) / r110;
        int r113 = this.j.size();
        int r22 = 0;
    L39:
        if (r22 >= r113) goto L55;
        double r23 = Math.abs(((Number) ListProtector.get(this.j, r22)).doubleValue());
        if (r23 >= 0.01d) goto L43;
        double r24 = 0.0d;
    L46:
        float r114 = r112;
        int r115 = r113;
        float r25 = r16 / r110;
        float r26 = ((float) (((double) r18) + ((r24 * ((double) (r16 - r18))) / this.i))) / r110;
        float r27 = r25 + r26;
        float r28 = r25 - r26;
        float r30 = this.d;
        float r31 = (r22 * (r30 + r14)) + (r30 / r110);
        FLogger.a.d(r9, "onDraw: called, top = " + r27 + ", bottom = " + r28);
        if (r22 >= 10) goto L50;
        String r116 = r9;
        double r32 = r22;
    L49:
        int r33 = (int) ((r32 * 0.1d) * ((double) 255));
    L54:
        Paint r34 = this.h;
        Intrinsics.checkNotNull(r34);
        int r35 = this.g;
        r34.setColor(Color.argb(r33, (r35 >> 16) & 255, (r35 >> 8) & 255, r35 & 255));
        float r36 = r31 + r111;
        Paint r37 = this.h;
        Intrinsics.checkNotNull(r37);
        r20.drawLine(r36, r27 + r114, r36, r28 + r114, r37);
        r22 = r22 + 1;
        r112 = r114;
        r113 = r115;
        r9 = r116;
        goto L39
    L50:
        r116 = r9;
        int r38 = this.j.size() - r22;
        if (r38 >= 10) goto L53;
        r32 = r38;
        goto L49
    L53:
        r33 = 255;
        goto L54
    L43:
        r24 = r23 * 1.5d;
        if (r24 <= 1.0d) goto L46;
        r24 = 1.0d;
        goto L46
    L55:
        super.onDraw(r20);
        return;
    L37:
        r18 = r15;
        goto L38
    L35:
        if (r15 <= r11) goto L37;
        r18 = r11;
        goto L38
    L28:
        r16 = r11;
        goto L29
    }

    public AudioVisualizer(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.a = 26;
        this.b = ((Number) i5.V0.getValue()).intValue();
        this.c = i5.J();
        this.d = i5.N();
        this.e = i5.j0();
        this.f = i5.J();
        this.g = -1;
        this.i = 0.1d;
        new ArrayList();
        this.j = new ArrayList();
        a();
    }

    public AudioVisualizer(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = 26;
        this.b = ((Number) i5.V0.getValue()).intValue();
        this.c = i5.J();
        this.d = i5.N();
        this.e = i5.j0();
        this.f = i5.J();
        this.g = -1;
        this.i = 0.1d;
        new ArrayList();
        this.j = new ArrayList();
        a();
    }
}
