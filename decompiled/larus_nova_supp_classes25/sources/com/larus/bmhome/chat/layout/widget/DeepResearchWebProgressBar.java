package com.larus.bmhome.chat.layout.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0018H\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/larus/bmhome/chat/layout/widget/DeepResearchWebProgressBar;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "paint", "Landroid/graphics/Paint;", "rectF", "Landroid/graphics/RectF;", "progress", "", "maxProgress", "strokeWidth", "progressColor", "backgroundColor", "setProgress", "", "onDraw", "canvas", "Landroid/graphics/Canvas;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class DeepResearchWebProgressBar extends View {
    public final Paint a;
    public final RectF b;
    public float c;
    public final float d;
    public final float e;
    public final int f;
    public final int g;

    public DeepResearchWebProgressBar(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public DeepResearchWebProgressBar(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r9) {
        Intrinsics.checkNotNullParameter(r9, "canvas");
        super.onDraw(r9);
        float r0 = getWidth() / 2.0f;
        float r2 = getHeight() / 2.0f;
        float r3 = (RangesKt.coerceAtMost(getWidth(), getHeight()) - this.e) / 2.0f;
        RectF r1 = this.b;
        r1.left = r0 - r3;
        r1.top = r2 - r3;
        r1.right = r0 + r3;
        r1.bottom = r2 + r3;
        this.a.setColor(ContextCompat.getColor(getContext(), this.g));
        this.a.setStrokeWidth(this.e);
        r9.drawArc(this.b, 0.0f, 360.0f, false, this.a);
        this.a.setColor(ContextCompat.getColor(getContext(), this.f));
        r9.drawArc(this.b, 270.0f, (this.c / this.d) * 360.0f, false, this.a);
    }

    public final void setProgress(float r2) {
        this.c = this.d * r2;
        invalidate();
    }

    public DeepResearchWebProgressBar(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        Paint r5 = new Paint(1);
        this.a = r5;
        this.b = new RectF();
        this.c = 75.0f;
        this.d = 100.0f;
        this.e = c7.b(2);
        this.f = v19.c.b(2130972081, null, 2131103143);
        this.g = v19.c.b(2130972086, null, 2131103159);
        r5.setStyle(Paint.Style.STROKE);
        r5.setStrokeCap(Paint.Cap.ROUND);
    }

    public /* synthetic */ DeepResearchWebProgressBar(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
