package q8a;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.widget.LinearLayout;
import com.lynx.tasm.behavior.ui.IDrawChildHook;
import com.lynx.xelement.scroll.coordinator.childitem.ScrollCoordinatorNestedScrollView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c extends LinearLayout {
    public final /* synthetic */ ScrollCoordinatorNestedScrollView a;

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r2) {
        IDrawChildHook r0 = this.a.l;
        if (r0 == null) goto L5;
        r0.beforeDispatchDraw(r2);
    L5:
        super.dispatchDraw(r2);
        IDrawChildHook r1 = this.a.l;
        if (r1 == null) goto L9;
        r1.afterDispatchDraw(r2);
        return;
    }

    public c(ScrollCoordinatorNestedScrollView r1, Context r2) {
        this.a = r1;
        super(r2);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r1, int r2) {
        ScrollCoordinatorNestedScrollView r3 = this.a;
        setMeasuredDimension(r3.g, r3.h);
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas r3, View r4, long r5) {
        IDrawChildHook r0 = this.a.l;
        if (r0 == null) goto L5;
        r0.beforeDrawChild(r3, r4, r5);
    L5:
        boolean r1 = super.drawChild(r3, r4, r5);
        IDrawChildHook r2 = this.a.l;
        if (r2 == null) goto L8;
        r2.afterDrawChild(r3, r4, r5);
    L8:
        return r1;
    }
}
