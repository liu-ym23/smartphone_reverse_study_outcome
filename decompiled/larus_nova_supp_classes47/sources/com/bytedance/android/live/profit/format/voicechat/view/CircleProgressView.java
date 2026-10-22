package com.bytedance.android.live.profit.format.voicechat.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/profit/format/voicechat/view/CircleProgressView;", "Landroid/view/View;", "", "progress", "", "setProgress", "Landroid/graphics/Path$Direction;", "direction", "setProgressDirection", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CircleProgressView extends View {
    public float a;
    public final float b;
    public Path.Direction c;
    public final Paint d;
    public final RectF e;
    public float f;
    public float g;

    public CircleProgressView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public CircleProgressView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r8) {
        Intrinsics.checkNotNullParameter(r8, "canvas");
        this.d.setStrokeWidth(this.b / getScaleX());
        int r0 = b.a[this.c.ordinal()];
        if (r0 != 1) goto L5;
        float r1 = 360;
        float r2 = this.a;
    L10:
        r8.drawArc(this.e, -90.0f, r1 * r2, false, this.d);
        return;
    L5:
        if (r0 != 2) goto L8;
        r1 = -360;
        r2 = this.a;
        goto L10
    L8:
        throw new NoWhenBranchMatchedException();
    }

    public final void setProgress(float r3) {
        if (r3 == this.a) goto L6;
        this.a = RangesKt.coerceIn(r3, 0.0f, 1.0f);
        invalidate();
        return;
    }

    public final void setProgressDirection(Path.Direction r2) {
        Intrinsics.checkNotNullParameter(r2, "direction");
        if (this.c == r2) goto L6;
        this.c = r2;
        invalidate();
        return;
    }

    public CircleProgressView(Context r6, AttributeSet r7, int r8) {
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6, r7, r8);
        this.c = Path.Direction.CW;
        Paint r9 = new Paint(1);
        r9.setStyle(Paint.Style.STROKE);
        r9.setStrokeCap(Paint.Cap.ROUND);
        r9.setColor(-1);
        r9.setShadowLayer(10.0f, 0.0f, 0.0f, ColorProtector.parseColor("#99FFFFFF"));
        Unit r2 = Unit.INSTANCE;
        this.d = r9;
        this.e = new RectF();
        TypedArray r10 = r6.obtainStyledAttributes(r7, new int[]{2130969690, 2130973622, 2130973623, 2130973624}, 0, 0);
        this.a = r10.getFloat(0, 0.0f);
        this.b = r10.getDimension(3, 0.0f);
        r9.setColor(r10.getColor(1, -1));
        if (r10.getInt(2, 0) != 0) goto L5;
        Path.Direction r12 = Path.Direction.CW;
    L6:
        this.c = r12;
        r10.recycle();
        return;
    L5:
        r12 = Path.Direction.CCW;
        goto L6
    }

    public /* synthetic */ CircleProgressView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r3, int r4, int r5, int r6) {
        super.onSizeChanged(r3, r4, r5, r6);
        this.f = getWidth() / 2.0f;
        this.g = getHeight() / 2.0f;
        float r7 = (Math.min(getWidth(), getHeight()) / 2.0f) - (this.b / 2);
        RectF r8 = this.e;
        float r9 = this.f;
        float r0 = this.g;
        r8.set(r9 - r7, r0 - r7, r9 + r7, r0 + r7);
    }
}
