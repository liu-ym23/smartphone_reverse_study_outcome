package com.larus.dora.impl.device.settings.lab.headdown;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0014R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0010@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u001a"}, d2 = {"Lcom/larus/dora/impl/device/settings/lab/headdown/HeadDownCircularProgressView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "strokeWidth", "", "arcBounds", "Landroid/graphics/RectF;", "trackPaint", "Landroid/graphics/Paint;", "progressPaint", "value", "", "progress", "getProgress", "()I", "setProgress", "(I)V", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HeadDownCircularProgressView extends View {
    public final float a;
    public final RectF b;
    public final Paint c;
    public final Paint d;
    public int e;

    public final int getProgress() {
        return this.e;
    }

    public HeadDownCircularProgressView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r11) {
        Intrinsics.checkNotNullParameter(r11, "canvas");
        super.onDraw(r11);
        float r0 = this.a / 2.0f;
        this.b.set(r0, r0, getWidth() - r0, getHeight() - r0);
        r11.drawArc(this.b, -90.0f, 360.0f, false, this.c);
        int r1 = this.e;
        if (r1 <= 0) goto L6;
        r11.drawArc(this.b, -90.0f, (r1 * 360.0f) / 100.0f, false, this.d);
        return;
    }

    public final void setProgress(int r3) {
        int r4 = RangesKt.coerceIn(r3, 0, 100);
        if (this.e != r4) goto L5;
        return;
    L5:
        this.e = r4;
        invalidate();
    }

    public HeadDownCircularProgressView(Context r5, AttributeSet r6) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r6);
        float r7 = getResources().getDimension(2131166648);
        this.a = r7;
        this.b = new RectF();
        Paint r0 = new Paint(1);
        r0.setStyle(Paint.Style.STROKE);
        r0.setStrokeCap(Paint.Cap.ROUND);
        r0.setStrokeWidth(r7);
        r0.setColor(v19.c.a(2130972080, r5, 2131103140));
        this.c = r0;
        Paint r1 = new Paint(1);
        r1.setStyle(Paint.Style.STROKE);
        r1.setStrokeCap(Paint.Cap.ROUND);
        r1.setStrokeWidth(r7);
        r1.setColor(v19.c.a(2130972123, r5, 2131103203));
        this.d = r1;
    }
}
