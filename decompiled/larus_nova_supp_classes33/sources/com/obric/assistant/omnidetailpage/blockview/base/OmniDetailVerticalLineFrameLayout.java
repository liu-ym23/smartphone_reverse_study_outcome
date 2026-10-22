package com.obric.assistant.omnidetailpage.blockview.base;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.c;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\rJ\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/obric/assistant/omnidetailpage/blockview/base/OmniDetailVerticalLineFrameLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "linePaint", "Landroid/graphics/Paint;", "showLine", "", "setShowLine", "", "show", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class OmniDetailVerticalLineFrameLayout extends FrameLayout {
    public final Paint a;
    public boolean b;

    public OmniDetailVerticalLineFrameLayout(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public OmniDetailVerticalLineFrameLayout(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r6) {
        Intrinsics.checkNotNullParameter(r6, "canvas");
        super.dispatchDraw(r6);
        if (this.b == false) goto L6;
        float r0 = i5.J();
        RectF r2 = new RectF(r0, 0.0f, i5.b() + r0, getHeight());
        float r1 = i5.b() / 2.0f;
        r6.drawRoundRect(r2, r1, r1, this.a);
        return;
    }

    public final void setShowLine(boolean r2) {
        if (this.b == r2) goto L6;
        this.b = r2;
        invalidate();
        return;
    }

    public OmniDetailVerticalLineFrameLayout(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        Paint r6 = new Paint(1);
        r6.setColor(ContextCompat.getColor(r3, c.b(2130972087, r3, 2131103162)));
        r6.setStyle(Paint.Style.FILL);
        this.a = r6;
        this.b = true;
    }

    public /* synthetic */ OmniDetailVerticalLineFrameLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
