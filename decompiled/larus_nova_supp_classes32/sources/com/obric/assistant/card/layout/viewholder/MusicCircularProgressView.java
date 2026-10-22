package com.obric.assistant.card.layout.viewholder;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u0007J\u0016\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0007J\u0010\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0019H\u0014J\b\u0010\u001a\u001a\u00020\u0013H\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/obric/assistant/card/layout/viewholder/MusicCircularProgressView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "strokeWidth", NameKeys.UnloadStrategy_No_Strategy, "arcBounds", "Landroid/graphics/RectF;", "trackPaint", "Landroid/graphics/Paint;", "progressPaint", "progress", "setProgress", NameKeys.UnloadStrategy_No_Strategy, "setColors", "progressColor", "trackColor", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onDetachedFromWindow", "Companion", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MusicCircularProgressView extends View {
    public final float a;
    public final RectF b;
    public final Paint c;
    public final Paint d;
    public int e;

    public static final class a {
    }

    static {
    }

    public MusicCircularProgressView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public MusicCircularProgressView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r9) {
        Intrinsics.checkNotNullParameter(r9, "canvas");
        super.onDraw(r9);
        float r0 = this.a / 2.0f;
        this.b.set(r0, r0, getWidth() - r0, getHeight() - r0);
        r9.drawOval(this.b, this.c);
        r9.drawArc(this.b, -90.0f, (this.e * 360.0f) / 100.0f, false, this.d);
    }

    public final void setProgress(int r3) {
        this.e = RangesKt.coerceIn(r3, 0, 100);
        invalidate();
    }

    public final void a(int r3, int r4) {
        boolean r1 = true;
        if (this.d.getColor() == r3) goto L5;
        this.d.setColor(r3);
        boolean r5 = true;
    L7:
        if (this.c.getColor() == r4) goto L9;
        this.c.setColor(r4);
    L10:
        if (r1 == false) goto L13;
        invalidate();
        return;
    L13:
        return;
    L9:
        r1 = r5;
        goto L10
    L5:
        r5 = false;
        goto L7
    }

    public MusicCircularProgressView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        Resources r5 = getResources();
        float r6 = WindowDisplayMetricsOverride.apply(r5, r5.getDisplayMetrics()).density * 2.0f;
        this.a = r6;
        this.b = new RectF();
        Paint r7 = new Paint(1);
        r7.setStyle(Paint.Style.STROKE);
        r7.setStrokeCap(Paint.Cap.ROUND);
        r7.setStrokeWidth(r6);
        r7.setColor(ColorProtector.parseColor("#1A000000"));
        this.c = r7;
        Paint r8 = new Paint(1);
        r8.setStyle(Paint.Style.STROKE);
        r8.setStrokeCap(Paint.Cap.ROUND);
        r8.setStrokeWidth(r6);
        r8.setColor(ColorProtector.parseColor("#FF000000"));
        this.d = r8;
    }

    public /* synthetic */ MusicCircularProgressView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
