package com.larus.common_ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 [2\u00020\u00012\u00020\u0002:\u0001[B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0005\u0010\tB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\fJ\b\u0010:\u001a\u00020;H\u0002J\u0010\u0010<\u001a\u00020;2\u0006\u0010=\u001a\u00020\u000bH\u0016J\u0010\u0010>\u001a\u00020;2\u0006\u0010?\u001a\u00020\u000bH\u0016J\u0010\u0010@\u001a\u00020;2\u0006\u0010A\u001a\u00020\u000bH\u0016J\u0010\u0010B\u001a\u00020;2\u0006\u0010C\u001a\u00020-H\u0016J\u000e\u0010D\u001a\u00020;2\u0006\u0010)\u001a\u00020*J\u0018\u0010E\u001a\u00020;2\u0006\u0010+\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020-H\u0016J(\u0010F\u001a\u00020;2\u0006\u0010G\u001a\u00020\u000b2\u0006\u0010H\u001a\u00020\u000b2\u0006\u0010I\u001a\u00020\u000b2\u0006\u0010J\u001a\u00020\u000bH\u0014J\u0010\u0010K\u001a\u00020;2\u0006\u0010L\u001a\u00020MH\u0014J\b\u0010N\u001a\u00020;H\u0002J0\u0010O\u001a\u0012\u0012\u0004\u0012\u00020*0/j\b\u0012\u0004\u0012\u00020*`02\u0016\u0010P\u001a\u0012\u0012\u0004\u0012\u00020*0/j\b\u0012\u0004\u0012\u00020*`0H\u0002J\u0010\u0010Q\u001a\u00020*2\u0006\u0010R\u001a\u00020*H\u0002J\u0010\u0010S\u001a\u00020;2\u0006\u0010T\u001a\u00020UH\u0016J \u0010V\u001a\u0012\u0012\u0004\u0012\u00020W0/j\b\u0012\u0004\u0012\u00020W`02\u0006\u0010X\u001a\u00020UH\u0002J0\u0010Y\u001a\u0012\u0012\u0004\u0012\u00020*0/j\b\u0012\u0004\u0012\u00020*`02\u0016\u0010Z\u001a\u0012\u0012\u0004\u0012\u00020W0/j\b\u0012\u0004\u0012\u00020W`0H\u0002R\u000e\u0010\r\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082D¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0010X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u00020\u0010X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0013\"\u0004\b\u001a\u0010\u0015R\u001a\u0010\u001b\u001a\u00020\u0010X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0013\"\u0004\b\u001d\u0010\u0015R\u001a\u0010\u001e\u001a\u00020\u0010X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0013\"\u0004\b \u0010\u0015R\u001a\u0010!\u001a\u00020\u0010X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0013\"\u0004\b#\u0010\u0015R\u000e\u0010$\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010.\u001a\u0012\u0012\u0004\u0012\u00020*0/j\b\u0012\u0004\u0012\u00020*`0X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u00101\u001a\u0012\u0012\u0004\u0012\u00020*0/j\b\u0012\u0004\u0012\u00020*`0X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u00102\u001a\u0012\u0012\u0004\u0012\u00020*0/j\b\u0012\u0004\u0012\u00020*`0X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u00103\u001a\u0012\u0012\u0004\u0012\u00020*0/j\b\u0012\u0004\u0012\u00020*`0X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000206X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u000206X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020-X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\\"}, d2 = {"Lcom/larus/common_ui/view/CustomBarCountAudioVisualizer;", "Landroid/view/View;", "Lcom/larus/common_ui/view/IAudioVisualizer;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "duration", "density", "visualizerWidth", "", "visualizerHeight", "getVisualizerHeight", "()F", "setVisualizerHeight", "(F)V", "_visualizerWidth", "_visualizerHeight", "barWidth", "getBarWidth", "setBarWidth", "gapWidth", "getGapWidth", "setGapWidth", "minBarHeight", "getMinBarHeight", "setMinBarHeight", "maxBarHeight", "getMaxBarHeight", "setMaxBarHeight", "_minBarHeight", "_maxBarHeight", "barColor", "paint", "Landroid/graphics/Paint;", "maxSampleData", "", "multipleFactor", "needOpt", "", "prepareData", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "lastData", "currentData", "nextData", "times", "frameTime", "", "maxTimes", "drawDelayMS", "enablePostInvalidateDelayed", "init", "", "changeVisibility", "visibility", "setColor", "color", "setFps", "fps", "switchPostInvalidateDelayed", "enable", "setMaxSampleData", "setMultipleFactor", "onSizeChanged", "w", "h", "oldw", "oldh", "onDraw", "canvas", "Landroid/graphics/Canvas;", "handleData", "copy", "target", "optSample", "sample", "setAudioData", "data", "", "handle16bit", "Ljava/math/BigDecimal;", "bytes", "calcPrepareData", "sampleData", "Companion", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class CustomBarCountAudioVisualizer extends View implements u {
    public static final /* synthetic */ int x = 0;
    public final int a;
    public float b;
    public float c;
    public float d;
    public float e;
    public float f;
    public float g;
    public float h;
    public float i;
    public float j;
    public int k;
    public Paint l;
    public double m;
    public int n;
    public boolean o;
    public ArrayList<Double> p;
    public ArrayList<Double> q;
    public ArrayList<Double> r;
    public ArrayList<Double> s;
    public int t;
    public final int u;
    public long v;
    public boolean w;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.common_ui.view.u
    public final void b() {
        this.n = 20;
        this.o = false;
    }

    public final void e() {
        Paint r0 = new Paint();
        r0.setAntiAlias(true);
        r0.setFilterBitmap(true);
        r0.setStrokeCap(Paint.Cap.ROUND);
        r0.setColor(this.k);
        this.l = r0;
        int r1 = this.a;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        this.p.add(Double.valueOf(0.0d));
        r2 = r2 + 1;
        goto L3
    L5:
        this.q = d(this.p);
        this.s = d(this.p);
        this.r = d(this.p);
        postInvalidate();
    }

    public final float getBarWidth() {
        return this.e;
    }

    public final float getGapWidth() {
        return this.f;
    }

    public final float getMaxBarHeight() {
        return this.h;
    }

    public final float getMinBarHeight() {
        return this.g;
    }

    public final float getVisualizerHeight() {
        return this.b;
    }

    public CustomBarCountAudioVisualizer(Context r6) {
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6);
        this.a = 3;
        float r0 = i5.Q();
        this.b = r0;
        this.c = 0.0f;
        this.d = r0;
        this.e = i5.h();
        this.f = i5.Y();
        float r1 = i5.v();
        this.h = r1;
        this.i = this.g;
        this.j = r1;
        this.k = -1;
        this.m = 0.2d;
        this.n = 5;
        this.o = true;
        this.p = new ArrayList(3);
        this.q = new ArrayList(3);
        this.r = new ArrayList(3);
        this.s = new ArrayList(3);
        this.u = (int) (((long) 40) / 10);
        this.v = 10;
        this.w = true;
        e();
    }

    public static ArrayList d(ArrayList r1) {
        ArrayList r0 = new ArrayList();
        r0.addAll(r1);
        return r0;
    }

    @Override // com.larus.common_ui.view.u
    public final void a(int r1) {
        setVisibility(r1);
    }

    @Override // com.larus.common_ui.view.u
    public final void c(boolean r4) {
        this.w = r4;
        FLogger.a.i("CustomBarCountAudioVisualizer", "enablePostInvalidateDelayed: " + r4);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r16) {
        Intrinsics.checkNotNullParameter(r16, "canvas");
        super.onDraw(r16);
        if (this.t != this.u) goto L5;
        this.r = d(this.s);
        this.q = d(this.s);
        this.s = d(this.p);
        this.t = 0;
    L18:
        if ((!this.r.isEmpty()) == false) goto L34;
        Paint r1 = this.l;
        if (r1 == null) goto L22;
        r1.setStrokeWidth(this.e);
    L22:
        Paint r2 = this.l;
        if (r2 == null) goto L25;
        r2.setAntiAlias(true);
    L25:
        float r8 = 2;
        float r9 = (getWidth() - this.c) / r8;
        float r10 = (getHeight() - this.d) / r8;
        int r11 = this.r.size();
        int r12 = 0;
    L26:
        if (r12 >= r11) goto L34;
        float r3 = this.e;
        float r4 = (r12 * (this.f + r3)) + (r3 / r8);
        double r5 = ((Number) ListProtector.get(this.r, r12)).doubleValue();
        float r6 = this.i;
        float r7 = (float) (((double) r6) + ((r5 * ((double) (this.j - r6))) / this.m));
        float r13 = this.d / r8;
        float r14 = r7 / r8;
        float r15 = r13 + r14;
        float r17 = r13 - r14;
        Paint r18 = this.l;
        if (r18 == null) goto L32;
        r18.setColor(this.k);
        if (r16 == null) goto L32;
        float r20 = r4 + r9;
        r16.drawLine(r20, r15 + r10, r20, r17 + r10, r18);
    L32:
        r12 = r12 + 1;
    L34:
        if (this.w == false) goto L44;
        postInvalidateDelayed(this.v);
        return;
    L44:
        return;
    L5:
        int r21 = this.a;
        int r22 = 0;
    L6:
        if (r22 >= r21) goto L16;
        if (this.q.size() <= r22) goto L10;
        Double r23 = (Double) ListProtector.get(this.q, r22);
    L11:
        Intrinsics.checkNotNull(r23);
        double r24 = r23.doubleValue();
        if (this.s.size() <= r22) goto L14;
        Double r25 = (Double) ListProtector.get(this.s, r22);
    L15:
        Intrinsics.checkNotNull(r25);
        ListProtector.set(this.r, r22, Double.valueOf(r24 + ((((double) this.t) * (r25.doubleValue() - r24)) / ((double) this.u))));
        r22 = r22 + 1;
        goto L6
    L14:
        r25 = Double.valueOf(0.0d);
        goto L15
    L10:
        r23 = Double.valueOf(0.0d);
        goto L11
    L16:
        this.t++;
        goto L18
    }

    @Override // com.larus.common_ui.view.u
    public void setAudioData(final byte[] r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        t0.a(new n(this, r2));
    }

    public final void setBarWidth(float r1) {
        this.e = r1;
    }

    @Override // com.larus.common_ui.view.u
    public void setColor(int r4) {
        FLogger.a.i("CustomBarCountAudioVisualizer", "setColor");
        this.k = r4;
        postInvalidate();
    }

    @Override // com.larus.common_ui.view.u
    public void setFps(int r4) {
        if (r4 > 0) goto L4;
        return;
    L4:
        this.v = 1000 / r4;
        FLogger.a.i("CustomBarCountAudioVisualizer", "drawDelayMS: " + this.v);
    }

    public final void setGapWidth(float r1) {
        this.f = r1;
    }

    public final void setMaxBarHeight(float r1) {
        this.h = r1;
    }

    public final void setMaxSampleData(double r1) {
        this.m = r1;
    }

    public final void setMinBarHeight(float r1) {
        this.g = r1;
    }

    public final void setVisualizerHeight(float r1) {
        this.b = r1;
    }

    public CustomBarCountAudioVisualizer(Context r5, AttributeSet r6) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r6);
        this.a = 3;
        float r7 = i5.Q();
        this.b = r7;
        this.c = 0.0f;
        this.d = r7;
        this.e = i5.h();
        this.f = i5.Y();
        float r8 = i5.v();
        this.h = r8;
        this.i = this.g;
        this.j = r8;
        this.k = -1;
        this.m = 0.2d;
        this.n = 5;
        this.o = true;
        this.p = new ArrayList(3);
        this.q = new ArrayList(3);
        this.r = new ArrayList(3);
        this.s = new ArrayList(3);
        this.u = (int) (((long) 40) / 10);
        this.v = 10;
        this.w = true;
        e();
    }

    public CustomBarCountAudioVisualizer(Context r5, AttributeSet r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r6, r7);
        this.a = 3;
        float r8 = i5.Q();
        this.b = r8;
        this.c = 0.0f;
        this.d = r8;
        this.e = i5.h();
        this.f = i5.Y();
        float r9 = i5.v();
        this.h = r9;
        this.i = this.g;
        this.j = r9;
        this.k = -1;
        this.m = 0.2d;
        this.n = 5;
        this.o = true;
        this.p = new ArrayList(3);
        this.q = new ArrayList(3);
        this.r = new ArrayList(3);
        this.s = new ArrayList(3);
        this.u = (int) (((long) 40) / 10);
        this.v = 10;
        this.w = true;
        e();
    }

    @Override // android.view.View
    public final void onSizeChanged(int r3, int r4, int r5, int r6) {
        super.onSizeChanged(r3, r4, r5, r6);
        float r7 = this.e;
        int r8 = this.a;
        float r9 = (r7 * r8) + (this.f * (r8 - 1));
        if (getWidth() >= r9) goto L6;
        r9 = getWidth();
    L6:
        this.c = r9;
        float r10 = getHeight();
        float r11 = this.b;
        if (r10 >= r11) goto L10;
        r11 = getHeight();
    L10:
        this.d = r11;
        float r12 = this.c;
        int r13 = this.a;
        float r14 = (1.0f * r12) / r13;
        float r0 = this.e;
        if (r0 > r14) goto L14;
        r14 = r0;
    L14:
        this.e = r14;
        this.f = (r12 - (r14 * r13)) / (r13 - 1);
        float r15 = this.h;
        if (r11 <= r15) goto L17;
        float r16 = r15;
    L18:
        this.j = r16;
        float r17 = this.g;
        if (r11 <= r17) goto L24;
        if (r15 <= r17) goto L26;
        r11 = r17;
    L27:
        this.i = r11;
        return;
    L26:
        r11 = r15;
        goto L27
    L24:
        if (r15 <= r11) goto L26;
    L17:
        r16 = r11;
        goto L18
    }
}
