package com.larus.bot.impl.common.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.util.AttributeSet;
import b6a.k;
import com.lynx.lottieadapter.LottieAdapterView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J(\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\rH\u0014J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0014R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/larus/bot/impl/common/view/CircularLottieView;", "Lcom/lynx/lottieadapter/LottieAdapterView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "circlePath", "Landroid/graphics/Path;", "onSizeChanged", "", "w", "", "h", "oldw", "oldh", "onDraw", "canvas", "Landroid/graphics/Canvas;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CircularLottieView extends LottieAdapterView {
    public final Path b;

    public /* bridge */ /* synthetic */ void setOption(k r1) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDraw(Canvas r2) {
        Intrinsics.checkNotNullParameter(r2, "canvas");
        r2.clipPath(this.b);
        super/*android.widget.FrameLayout*/.onDraw(r2);
    }

    public CircularLottieView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.b = new Path();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onSizeChanged(int r7, int r8, int r9, int r10) {
        super/*android.widget.FrameLayout*/.onSizeChanged(r7, r8, r9, r10);
        this.b.addOval(0.0f, 0.0f, r7, r8, Path.Direction.CW);
    }
}
