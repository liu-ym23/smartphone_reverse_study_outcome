package pt8;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.widget.FrameLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a extends FrameLayout {
    public final float a;
    public final Path b;
    public final RectF c;

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r5) {
        Intrinsics.checkNotNullParameter(r5, "canvas");
        this.c.set(0.0f, 0.0f, getWidth(), getHeight());
        this.b.reset();
        Path r0 = this.b;
        RectF r1 = this.c;
        float r2 = this.a;
        r0.addRoundRect(r1, r2, r2, Path.Direction.CW);
        r5.save();
        r5.clipPath(this.b);
        super.dispatchDraw(r5);
        r5.restore();
    }

    public a(Context r3, float r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, null, 0);
        this.a = r4;
        this.b = new Path();
        this.c = new RectF();
    }
}
