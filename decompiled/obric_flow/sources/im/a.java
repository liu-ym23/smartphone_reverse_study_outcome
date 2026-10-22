package im;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Path;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.lynx.animax.UIAnimaX;
import com.lynx.tasm.behavior.ui.utils.BackgroundDrawable;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public bd.d f17576a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e f17577b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d f17578c;

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r5) {
        bd.d r10 = this.f17576a;
        if (r10 == null) goto L18;
        int r11 = UIAnimaX.f9557p;
        UIAnimaX r12 = (UIAnimaX) r10.f905a;
        if (r12.getLynxBackground() == null) goto L7;
        BackgroundDrawable r13 = (BackgroundDrawable) r12.getLynxBackground().f10750b;
    L8:
        if (r13 == null) goto L18;
        Path r14 = r13.p();
        if (r14 == null) goto L14;
        r5.clipPath(r14);
        goto L18
    L14:
        if (r12.getSkewX() == 0.0f) goto L16;
    L17:
        r5.clipRect(r12.getClipBounds());
        goto L18
    L16:
        if (r12.getSkewY() == 0.0f) goto L18;
    L7:
        r13 = null;
    L18:
        super.dispatchDraw(r5);
        if (r5.isHardwareAccelerated() == true) goto L34;
        bd.d r15 = this.f17576a;
        if (r15 != null) goto L23;
        return;
    L23:
        if (((UIAnimaX) r15.f905a).f9566m == false) goto L36;
        e r16 = this.f17577b;
        if (r16 == null) goto L27;
        Bitmap r17 = r16.getBitmap();
    L31:
        if (r17 == null) goto L37;
        r5.drawBitmap(r17, getPaddingLeft(), getPaddingTop(), null);
        return;
    L37:
        return;
    L27:
        d r18 = this.f17578c;
        if (r18 == null) goto L30;
        r17 = r18.getCurrentBitmap();
        goto L31
    L30:
        r17 = null;
        goto L31
    L36:
        return;
    }

    @Nullable
    public d getAnimaXImageView() {
        return this.f17578c;
    }

    @Nullable
    public e getAnimaXView() {
        return this.f17577b;
    }
}
