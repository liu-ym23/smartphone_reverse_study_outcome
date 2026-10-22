package x4a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Path;
import android.view.View;
import android.widget.FrameLayout;
import com.lynx.animax.UIAnimaX;
import com.lynx.animax.a0;
import com.lynx.animax.setter.UIAnimaXPropsPrioritySetter;
import com.lynx.animax.ui.AnimaXImageView;
import com.lynx.animax.ui.AnimaXView;
import com.lynx.tasm.behavior.ui.utils.BackgroundDrawable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a extends FrameLayout {
    public InterfaceC0122a a;
    public AnimaXView b;
    public AnimaXImageView c;

    /* JADX INFO: renamed from: x4a.a$a, reason: collision with other inner class name */
    public interface InterfaceC0122a {
    }

    public AnimaXImageView getAnimaXImageView() {
        return this.c;
    }

    public AnimaXView getAnimaXView() {
        return this.b;
    }

    public a(Context r1) {
        super(r1);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r5) {
        InterfaceC0122a r0 = this.a;
        if (r0 == null) goto L18;
        UIAnimaX r1 = ((a0) r0).a;
        UIAnimaXPropsPrioritySetter.ExecutionPriority r2 = UIAnimaX.p;
        if (r1.getLynxBackground() == null) goto L7;
        BackgroundDrawable r3 = (BackgroundDrawable) r1.getLynxBackground().b;
    L8:
        if (r3 == null) goto L18;
        Path r4 = r3.l();
        if (r4 == null) goto L14;
        r5.clipPath(r4);
        goto L18
    L14:
        if (r1.getSkewX() == 0.0f) goto L16;
    L17:
        r5.clipRect(r1.getClipBounds());
        goto L18
    L16:
        if (r1.getSkewY() == 0.0f) goto L18;
    L7:
        r3 = null;
    L18:
        super.dispatchDraw(r5);
        if (r5.isHardwareAccelerated() == true) goto L25;
        InterfaceC0122a r6 = this.a;
        if (r6 == null) goto L25;
        if (((a0) r6).a.m == false) goto L25;
        boolean r7 = true;
    L26:
        if (r7 == false) goto L37;
        AnimaXView r8 = this.b;
        if (r8 == null) goto L30;
        Bitmap r9 = r8.getBitmap();
    L34:
        if (r9 == null) goto L38;
        r5.drawBitmap(r9, getPaddingLeft(), getPaddingTop(), null);
        return;
    L38:
        return;
    L30:
        AnimaXImageView r10 = this.c;
        if (r10 == null) goto L33;
        r9 = r10.getCurrentBitmap();
        goto L34
    L33:
        r9 = null;
        goto L34
    L37:
        return;
    L25:
        r7 = false;
        goto L26
    }

    public final void a(View r3, a0 r4) {
        if ((r3 instanceof AnimaXView) == false) goto L6;
        this.b = (AnimaXView) r3;
    L8:
        r3.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(r3);
        this.a = r4;
        return;
    L6:
        if ((r3 instanceof AnimaXImageView) == false) goto L10;
        this.c = (AnimaXImageView) r3;
        goto L8
    }
}
