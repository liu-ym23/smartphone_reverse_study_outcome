package com.larus.bmhome.chat.markdown.imagegroup.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;
import v19.i5;
import we8.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B)\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0013\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0014J\u000e\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u0007J\u0010\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001aH\u0014J\u0010\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001aH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/larus/bmhome/chat/markdown/imagegroup/view/CustomCaptionRelativeLayout;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "path", "Landroid/graphics/Path;", "rectF", "Landroid/graphics/RectF;", "radii", "", "captionRectF", "captionHeight", "captionRadii", "enableCaptionClip", "", "", "enable", "setCaptionHeight", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "handleCustomClip", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class CustomCaptionRelativeLayout extends RelativeLayout {
    public final Path a;
    public final RectF b;
    public final float[] c;

    public CustomCaptionRelativeLayout(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public CustomCaptionRelativeLayout(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void setCaptionHeight(int r1) {
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r5) {
        Intrinsics.checkNotNullParameter(r5, "canvas");
        this.a.reset();
        this.b.set(0.0f, 0.0f, getWidth(), getHeight());
        this.a.addRoundRect(this.b, this.c, Path.Direction.CW);
        r5.clipPath(this.a);
        super.dispatchDraw(r5);
    }

    public CustomCaptionRelativeLayout(Context r3, AttributeSet r4, int r5) {
        super(r3, r4, r5);
        this.a = new Path();
        this.b = new RectF();
        this.c = new float[]{c7.c(8), c7.c(8), c7.c(8), c7.c(8), c7.c(8), c7.c(8), c7.c(8), c7.c(8)};
        new RectF();
        a.a(i5.C(), false);
        i5.r0();
    }

    public /* synthetic */ CustomCaptionRelativeLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
