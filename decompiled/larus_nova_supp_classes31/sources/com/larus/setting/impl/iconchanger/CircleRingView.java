package com.larus.setting.impl.iconchanger;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000bJ\u000e\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011J\u0010\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0014H\u0014R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/larus/setting/impl/iconchanger/CircleRingView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "customPaint", "Landroid/graphics/Paint;", "strokeWidth", "", "setStrokeWidth", "", "width", "setColor", "colorInt", "", "onDraw", "canvas", "Landroid/graphics/Canvas;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class CircleRingView extends View {
    public final Paint a;
    public float b;

    @Override // android.view.View
    public final void onDraw(Canvas r7) {
        Intrinsics.checkNotNullParameter(r7, "canvas");
        super.onDraw(r7);
        int r0 = getWidth();
        int r1 = getHeight();
        r7.drawCircle(r0 / 2, r1 / 2, (Math.min(r0, r1) / 2) - (this.b / 2), this.a);
    }

    public final void setColor(int r3) {
        this.a.setColor(ve8.d.a(r3, getContext()));
        invalidate();
    }

    public final void setStrokeWidth(float r2) {
        this.b = r2;
        this.a.setStrokeWidth(r2);
        invalidate();
    }

    public CircleRingView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        Paint r4 = new Paint();
        this.a = r4;
        this.b = 10.0f;
        r4.setColor(-256);
        r4.setStrokeWidth(10.0f);
        r4.setStyle(Paint.Style.STROKE);
        r4.setAntiAlias(true);
    }
}
