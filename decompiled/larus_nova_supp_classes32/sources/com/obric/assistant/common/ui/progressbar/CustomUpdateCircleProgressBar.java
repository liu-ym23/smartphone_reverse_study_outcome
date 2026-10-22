package com.obric.assistant.common.ui.progressbar;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.larus.common.apphost.AppHost;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 42\u00020\u0001:\u00014B)\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u001e\u001a\u00020\u001fH\u0002J\u0016\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020\u000eJ\u0018\u0010#\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0007H\u0014J\u0010\u0010&\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020(H\u0014J\u000e\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u0007J\u000e\u0010+\u001a\u00020\u001f2\u0006\u0010,\u001a\u00020\u0015J\b\u0010-\u001a\u00020\u001fH\u0002J\b\u0010.\u001a\u00020\u001fH\u0002J(\u0010/\u001a\u00020\u001f2\u0006\u00100\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u0007H\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/obric/assistant/common/ui/progressbar/CustomUpdateCircleProgressBar;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mBackPaint", "Landroid/graphics/Paint;", "mFrontPaint", "mStrokeWidth", NameKeys.UnloadStrategy_No_Strategy, "mRadius", "isStableRadius", NameKeys.UnloadStrategy_No_Strategy, "mRect", "Landroid/graphics/RectF;", "mProgress", NameKeys.UnloadStrategy_No_Strategy, "mMax", "mWidth", "mHeight", "centerDrawable", "Landroid/graphics/drawable/Drawable;", "centerDrawableSize", "centerDrawableRect", "Landroid/graphics/Rect;", "init", NameKeys.UnloadStrategy_No_Strategy, "setProp", "radiusDp", "strokeDp", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onDraw", "canvas", "Landroid/graphics/Canvas;", "getRealSize", "measureSpec", "setProgress", "progress", "initRect", "updateDrawableBounds", "onSizeChanged", "w", "h", "oldw", "oldh", "Companion", "utils_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CustomUpdateCircleProgressBar extends View {
    public Paint a;
    public Paint b;
    public final float c;
    public final float d;
    public final boolean e;
    public final RectF f;
    public long g;
    public final int h;
    public int i;
    public int j;
    public Drawable k;
    public int l;
    public final Rect m;

    public static final class a {
        public static float a(Context r1, float r2) {
            Intrinsics.checkNotNullParameter(r1, "context");
            Resources r3 = r1.getResources();
            return (r2 * WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics()).density) + 0.5f;
        }
    }

    static {
    }

    public CustomUpdateCircleProgressBar(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public CustomUpdateCircleProgressBar(Context r3, AttributeSet r4) {
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
        Drawable r8 = this.k;
        if (r8 == null) goto L14;
        r8.setBounds(this.m);
        r8.draw(r10);
        return;
    L14:
        return;
    L9:
        r7 = this.d - (this.c / 2);
        goto L10
    L5:
        float r9 = 2;
        r0 = (this.d - (this.c / r9)) * r9;
        goto L6
    }

    public final void setProgress(long r1) {
        this.g = r1;
        postInvalidate();
    }

    @Override // android.view.View
    public final void onMeasure(int r5, int r6) {
        super.onMeasure(r5, r6);
        int r0 = View.MeasureSpec.getMode(r5);
        int r7 = View.MeasureSpec.getSize(r5);
        if (r0 == Integer.MIN_VALUE) goto L6;
        if (r0 == 0) goto L6;
    L7:
        this.i = r7;
        int r8 = View.MeasureSpec.getMode(r6);
        int r9 = View.MeasureSpec.getSize(r6);
        if (r8 == Integer.MIN_VALUE) goto L11;
        if (r8 == 0) goto L11;
    L12:
        this.j = r9;
        setMeasuredDimension(this.i, r9);
        int r10 = this.i / 2;
        int r11 = this.j / 2;
        int r1 = this.l / 2;
        this.m.set(r10 - r1, r11 - r1, r10 + r1, r11 + r1);
        return;
    L11:
        r9 = (int) ((this.d * 2) + this.c);
    L6:
        r7 = (int) ((this.d * 2) + this.c);
        goto L7
    }

    public CustomUpdateCircleProgressBar(Context r5, AttributeSet r6, int r7) {
        super(r5, r6, r7);
        this.a = new Paint();
        this.b = new Paint();
        float r8 = a.a(getContext(), 4.0f);
        this.c = r8;
        this.d = a.a(getContext(), 15.0f);
        this.e = true;
        this.f = new RectF();
        this.h = 100;
        this.m = new Rect();
        Paint r9 = new Paint();
        this.a = r9;
        Context r0 = getContext();
        if (r0 != null) goto L5;
        r0 = AppHost.a.getApplication();
    L5:
        r9.setColor(ContextCompat.getColor(r0, c.b(2130972086, getContext(), 2131103159)));
        this.a.setAntiAlias(true);
        this.a.setStyle(Paint.Style.STROKE);
        this.a.setStrokeWidth(r8);
        Paint r10 = new Paint();
        this.b = r10;
        Context r1 = getContext();
        if (r1 != null) goto L8;
        r1 = AppHost.a.getApplication();
    L8:
        r10.setColor(ContextCompat.getColor(r1, c.b(2130972123, getContext(), 2131103203)));
        this.b.setAntiAlias(true);
        this.b.setStyle(Paint.Style.STROKE);
        this.b.setStrokeWidth(r8);
        Context r11 = getContext();
        if (r11 != null) goto L11;
        r11 = AppHost.a.getApplication();
    L11:
        this.k = ContextCompat.getDrawable(r11, 2131236097);
        this.l = (int) a.a(getContext(), 8.0f);
    }

    public /* synthetic */ CustomUpdateCircleProgressBar(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r3, int r4, int r5, int r6) {
        super.onSizeChanged(r3, r4, r5, r6);
        int r7 = this.i / 2;
        int r8 = this.j / 2;
        int r9 = this.l / 2;
        this.m.set(r7 - r9, r8 - r9, r7 + r9, r8 + r9);
    }
}
