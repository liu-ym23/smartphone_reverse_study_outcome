package com.bytedance.android.livesdk.chatroom.widget.landscape;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001,B'\b\u0007\u0012\u0006\u0010%\u001a\u00020$\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010&\u0012\b\b\u0002\u0010)\u001a\u00020(¢\u0006\u0004\b*\u0010+R\u001b\u0010\u0007\u001a\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\n\u001a\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u001b\u0010\r\u001a\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R#\u0010\u0013\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0018\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u001d\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010 \u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0004\u001a\u0004\b\u001f\u0010\u001cR\u001b\u0010#\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u0004\u001a\u0004\b\"\u0010\u001c¨\u0006-"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/widget/landscape/LandscapeBatteryView;", "Landroid/view/View;", "Landroid/graphics/Paint;", "d", "Lkotlin/Lazy;", "getBorderPaint", "()Landroid/graphics/Paint;", "borderPaint", "e", "getCapPaint", "capPaint", "f", "getContentPaint", "contentPaint", "Landroid/graphics/Bitmap;", "kotlin.jvm.PlatformType", "g", "getChargingBitmap", "()Landroid/graphics/Bitmap;", "chargingBitmap", "Landroid/graphics/Matrix;", "h", "getChargingMatrix", "()Landroid/graphics/Matrix;", "chargingMatrix", "Landroid/graphics/RectF;", "i", "getBorderRectF", "()Landroid/graphics/RectF;", "borderRectF", "l", "getCapRectF", "capRectF", "n", "getContentRectF", "contentRectF", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LandscapeBatteryView extends View {
    public static final float q = 0.0f;
    public float a;
    public float b;
    public boolean c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;
    public final Lazy i;
    public float j;
    public float k;
    public final Lazy l;
    public float m;
    public final Lazy n;
    public float o;
    public float p;

    public static final class a {
    }

    public LandscapeBatteryView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public LandscapeBatteryView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final Paint getBorderPaint() {
        return (Paint) this.d.getValue();
    }

    private final RectF getBorderRectF() {
        return (RectF) this.i.getValue();
    }

    private final Paint getCapPaint() {
        return (Paint) this.e.getValue();
    }

    private final RectF getCapRectF() {
        return (RectF) this.l.getValue();
    }

    private final Bitmap getChargingBitmap() {
        return (Bitmap) this.g.getValue();
    }

    private final Matrix getChargingMatrix() {
        return (Matrix) this.h.getValue();
    }

    private final Paint getContentPaint() {
        return (Paint) this.f.getValue();
    }

    private final RectF getContentRectF() {
        return (RectF) this.n.getValue();
    }

    static {
        q = (float) Math.sqrt(2.0f);
    }

    public final void e() {
        getBorderPaint().setStrokeWidth(c(1.0f) * this.a);
        Paint r0 = getContentPaint();
        if (this.c == false) goto L5;
        int r2 = -16711936;
    L6:
        r0.setColor(r2);
        r0.setAlpha(255);
        Matrix r1 = getChargingMatrix();
        float r3 = (c(12.0f) * this.a) - (c(2.0f) * this.a);
        int r5 = getChargingBitmap().getHeight();
        float r8 = 2;
        r1.setTranslate(((c(20.0f) * this.a) / r8) - (c(3.0f) * this.a), c(1.0f) * this.a);
        float r4 = r3 / r5;
        r1.preScale(r4, r4);
        float r6 = (c(12.0f) * this.a) - (c(2.0f) * this.a);
        float r7 = (c(20.0f) * this.a) - (c(3.0f) * this.a);
        float r9 = c(0.77f) * this.a;
        float r10 = c(1.0f) * this.a;
        float r11 = r9 + r7;
        getBorderRectF().set((getBorderPaint().getStrokeWidth() / r8) + r9, (getBorderPaint().getStrokeWidth() / r8) + r10, r11 - (getBorderPaint().getStrokeWidth() / r8), (r10 + r6) - (getBorderPaint().getStrokeWidth() / r8));
        float r12 = c(2.5f) * this.a;
        float r13 = q;
        this.j = r12 / r13;
        this.k = (c(2.5f) * this.a) / r13;
        float r14 = (c(0.5f) * this.a) + r11;
        float r15 = c(0.96f) * this.a;
        float r16 = c(2.89f) * this.a;
        float r17 = (c(12.0f) * this.a) / r8;
        float r18 = r16 / r8;
        float r19 = r17 - r18;
        this.m = (((float) Math.atan((r18 / c(0.5f)) / this.a)) * 180) / ((float) 3.141592653589793d);
        getCapRectF().set((r11 - (c(0.5f) * this.a)) - r15, r19, r14 + r15, r16 + r19);
        float r20 = c(2.5f) * this.a;
        float r21 = c(2.27f) * this.a;
        getContentRectF().set(r21, r20, (((c(17.0f) * this.a) - (c(3.0f) * this.a)) * this.b) + r21, (r6 - (c(3.0f) * this.a)) + r20);
        this.o = (c(1.0f) * this.a) / r13;
        this.p = (c(1.0f) * this.a) / r13;
        return;
    L5:
        r2 = -1;
        goto L6
    }

    public static final /* synthetic */ Paint a(LandscapeBatteryView r0) {
        return r0.getBorderPaint();
    }

    public static final /* synthetic */ Paint b(LandscapeBatteryView r0) {
        return r0.getCapPaint();
    }

    public static float c(float r2) {
        Resources r0 = Resources.getSystem();
        return r2 * WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density;
    }

    public static int d(int r2) {
        Resources r0 = Resources.getSystem();
        return (int) ((r2 * WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density) + 0.5f);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r11) {
        Intrinsics.checkNotNullParameter(r11, "canvas");
        super.onDraw(r11);
        r11.drawRoundRect(getBorderRectF(), this.j, this.k, getBorderPaint());
        RectF r5 = getCapRectF();
        float r0 = this.m;
        r11.drawArc(r5, -r0, r0 * 2, false, getCapPaint());
        r11.drawRoundRect(getContentRectF(), this.o, this.p, getContentPaint());
        if (this.c == false) goto L6;
        r11.drawBitmap(getChargingBitmap(), getChargingMatrix(), null);
        return;
    }

    @Override // android.view.View
    public final void onMeasure(int r7, int r8) {
        super.onMeasure(r7, r8);
        int r0 = d(25);
        int r1 = View.MeasureSpec.getMode(r7);
        int r9 = View.MeasureSpec.getSize(r7);
        if (r1 == Integer.MIN_VALUE) goto L7;
        if (r1 != 1073741824) goto L8;
        r0 = r9;
    L8:
        int r2 = d(12);
        int r4 = View.MeasureSpec.getMode(r8);
        int r10 = View.MeasureSpec.getSize(r8);
        if (r4 == Integer.MIN_VALUE) goto L13;
        if (r4 != 1073741824) goto L14;
        r2 = r10;
    L14:
        float r11 = r0;
        float r5 = r2;
        if ((r11 / 20.0f) >= (r5 / 12)) goto L17;
        this.a = r11 / c(20.0f);
        setMeasuredDimension(r0, MathKt.roundToInt(d(12) * this.a));
    L18:
        e();
        return;
    L17:
        this.a = r5 / c(12.0f);
        setMeasuredDimension(MathKt.roundToInt(d(20) * this.a), r2);
        goto L18
    L13:
        r2 = Math.min(r10, r2);
        goto L14
    L7:
        r0 = Math.min(r9, r0);
        goto L8
    }

    public LandscapeBatteryView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = 1.0f;
        this.b = 1.0f;
        this.d = LazyKt.lazy(LandscapeBatteryView$borderPaint$2.INSTANCE);
        this.e = LazyKt.lazy(new LandscapeBatteryView$capPaint$2(this));
        this.f = LazyKt.lazy(new LandscapeBatteryView$contentPaint$2(this));
        this.g = LazyKt.lazy(new LandscapeBatteryView$chargingBitmap$2(this));
        this.h = LazyKt.lazy(LandscapeBatteryView$chargingMatrix$2.INSTANCE);
        this.i = LazyKt.lazy(LandscapeBatteryView$borderRectF$2.INSTANCE);
        this.l = LazyKt.lazy(LandscapeBatteryView$capRectF$2.INSTANCE);
        this.n = LazyKt.lazy(LandscapeBatteryView$contentRectF$2.INSTANCE);
    }

    public /* synthetic */ LandscapeBatteryView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
