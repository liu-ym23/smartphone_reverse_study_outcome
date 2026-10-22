package g7a;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import android.widget.LinearLayout;
import com.lynx.tasm.behavior.ui.IDrawChildHook;
import com.lynx.tasm.behavior.ui.scroll.AndroidScrollView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a extends LinearLayout {
    public final /* synthetic */ AndroidScrollView a;

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
    }

    @Override // android.view.View
    public final boolean canScrollHorizontally(int r3) {
        if (this.a.o.isEnableNewGesture() == true) goto L5;
        AndroidScrollView r0 = this.a;
        if (r0.N == false) goto L11;
        if (r0.u == false) goto L11;
    L12:
        return true;
    L11:
        if (super.canScrollHorizontally(r3) == true) goto L12;
        return false;
    L5:
        return super.canScrollHorizontally(r3);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r2) {
        IDrawChildHook r0 = this.a.z;
        if (r0 == null) goto L5;
        r0.beforeDispatchDraw(r2);
    L5:
        super.dispatchDraw(r2);
        IDrawChildHook r1 = this.a.z;
        if (r1 == null) goto L9;
        r1.afterDispatchDraw(r2);
        return;
    }

    public a(AndroidScrollView r1, Context r2) {
        this.a = r1;
        super(r2);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r1, int r2) {
        AndroidScrollView r3 = this.a;
        setMeasuredDimension(r3.w, r3.x);
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas r3, View r4, long r5) {
        IDrawChildHook r0 = this.a.z;
        if (r0 == null) goto L5;
        Rect r1 = r0.beforeDrawChild(r3, r4, r5);
    L6:
        if (r1 == null) goto L8;
        r3.save();
        r3.clipRect(r1);
        boolean r2 = super.drawChild(r3, r4, r5);
        r3.restore();
    L9:
        IDrawChildHook r6 = this.a.z;
        if (r6 == null) goto L12;
        r6.afterDrawChild(r3, r4, r5);
    L12:
        return r2;
    L8:
        r2 = super.drawChild(r3, r4, r5);
        goto L9
    L5:
        r1 = null;
        goto L6
    }
}
