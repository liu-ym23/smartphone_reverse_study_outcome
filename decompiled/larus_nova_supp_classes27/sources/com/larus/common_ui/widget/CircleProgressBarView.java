package com.larus.common_ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.larus.common.apphost.AppHost;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 )2\u00020\u0001:\u0001)B)\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0019\u001a\u00020\u001aH\u0002J\u0016\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u000eJ\u0018\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u0007H\u0014J\u0010\u0010!\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020#H\u0014J\u000e\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0007J\u000e\u0010&\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020\u0015J\b\u0010(\u001a\u00020\u001aH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/larus/common_ui/widget/CircleProgressBarView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mBackPaint", "Landroid/graphics/Paint;", "mFrontPaint", "mStrokeWidth", "", "mRadius", "isStableRadius", "", "mRect", "Landroid/graphics/RectF;", "mProgress", "", "mMax", "mWidth", "mHeight", "init", "", "setProp", "radiusDp", "strokeDp", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onDraw", "canvas", "Landroid/graphics/Canvas;", "getRealSize", "measureSpec", "setProgress", "progress", "initRect", "Companion", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CircleProgressBarView extends View {
    public static final /* synthetic */ int k = 0;
    public Paint a;
    public Paint b;
    public float c;
    public float d;
    public boolean e;
    public final RectF f;
    public long g;
    public final int h;
    public int i;
    public int j;

    public static final class a {
        public static float a(Context r1, float r2) {
            Intrinsics.checkNotNullParameter(r1, "context");
            Resources r3 = r1.getResources();
            return (r2 * WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics()).density) + 0.5f;
        }
    }

    static {
    }

    public CircleProgressBarView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public CircleProgressBarView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r10) {
        Intrinsics.checkNotNullParameter(r10, "canvas");
        if (this.e == false) goto L5;
        float r0 = this.d * 2;
    L6:
        int r1 = (int) r0;
        int r2 = (this.i - r1) / 2;
        int r3 = (this.j - r1) / 2;
        this.f.set(r2, r3, r2 + r1, r1 + r3);
        float r6 = (this.g / this.h) * 360;
        float r4 = this.i / 2;
        float r5 = this.j / 2;
        if (this.e == false) goto L9;
        float r7 = this.d;
    L10:
        r10.drawCircle(r4, r5, r7, this.a);
        r10.drawArc(this.f, -90.0f, r6, false, this.b);
        return;
    L9:
        r7 = this.d - (this.c / 2);
        goto L10
    L5:
        float r8 = 2;
        r0 = (this.d - (this.c / r8)) * r8;
        goto L6
    }

    public final void setProgress(long r1) {
        this.g = r1;
        postInvalidate();
    }

    public final void a(float r2, float r3) {
        this.e = false;
        this.d = a.a(getContext(), r2);
        this.c = a.a(getContext(), r3);
        this.a.setStrokeWidth(a.a(getContext(), r3));
        this.b.setStrokeWidth(a.a(getContext(), r3));
    }

    @Override // android.view.View
    public final void onMeasure(int r4, int r5) {
        super.onMeasure(r4, r5);
        int r0 = View.MeasureSpec.getMode(r4);
        int r6 = View.MeasureSpec.getSize(r4);
        if (r0 == Integer.MIN_VALUE) goto L6;
        if (r0 == 0) goto L6;
    L7:
        this.i = r6;
        int r7 = View.MeasureSpec.getMode(r5);
        int r8 = View.MeasureSpec.getSize(r5);
        if (r7 == Integer.MIN_VALUE) goto L11;
        if (r7 == 0) goto L11;
    L12:
        this.j = r8;
        setMeasuredDimension(this.i, r8);
        return;
    L11:
        r8 = (int) ((this.d * 2) + this.c);
    L6:
        r6 = (int) ((this.d * 2) + this.c);
        goto L7
    }

    public CircleProgressBarView(Context r3, AttributeSet r4, int r5) {
        super(r3, r4, r5);
        this.a = new Paint();
        this.b = new Paint();
        this.c = a.a(getContext(), 4.0f);
        this.d = a.a(getContext(), 15.0f);
        this.e = true;
        this.f = new RectF();
        this.h = 100;
        Paint r6 = new Paint();
        this.a = r6;
        AppHost.Companion r7 = AppHost.a;
        r6.setColor(ContextCompat.getColor(r7.getApplication(), 2131103298));
        this.a.setAlpha(153);
        this.a.setAntiAlias(true);
        this.a.setStyle(Paint.Style.STROKE);
        this.a.setStrokeWidth(this.c);
        Paint r8 = new Paint();
        this.b = r8;
        r8.setColor(ContextCompat.getColor(r7.getApplication(), 2131103298));
        this.b.setAntiAlias(true);
        this.b.setStyle(Paint.Style.STROKE);
        this.b.setStrokeWidth(this.c);
    }

    public /* synthetic */ CircleProgressBarView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
