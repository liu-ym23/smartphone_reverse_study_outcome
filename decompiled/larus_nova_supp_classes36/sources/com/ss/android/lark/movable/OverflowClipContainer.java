package com.ss.android.lark.movable;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0014J \u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0014R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/movable/OverflowClipContainer;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "childClipRect", "Landroid/graphics/Rect;", "shouldOverflow", "", "child", "Landroid/view/View;", "drawChild", "canvas", "Landroid/graphics/Canvas;", "drawingTime", "", "movable_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public class OverflowClipContainer extends FrameLayout {
    public final Rect a;

    public boolean a(View r2) {
        Intrinsics.checkNotNullParameter(r2, "child");
        return false;
    }

    public OverflowClipContainer(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public OverflowClipContainer(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.a = new Rect();
        setClipChildren(false);
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas r3, View r4, long r5) {
        Intrinsics.checkNotNullParameter(r3, "canvas");
        Intrinsics.checkNotNullParameter(r4, "child");
        if (a(r4) == true) goto L5;
        int r0 = r3.save();
        r4.getHitRect(this.a);
        r3.clipRect(this.a);
        boolean r6 = super.drawChild(r3, r4, r5);     // Catch: Throwable -> L10
        r3.restoreToCount(r0);
        return r6;
    L10:
        th = move-exception;
        r3.restoreToCount(r0);
        throw th;
    L5:
        return super.drawChild(r3, r4, r5);
    }
}
