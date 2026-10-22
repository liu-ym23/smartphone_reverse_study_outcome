package com.obric.oui.panel.pad;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.obric.oui.panel.BottomSheetBehavior;
import he.i;

/* JADX INFO: loaded from: classes2.dex */
public final class PadBottomSheetBehavior<V extends View> extends BottomSheetBehavior<V> {
    public PadBottomSheetBehavior(Context r8, AttributeSet r10) {
        i.f(r8, "context");
        i.f(r10, "attributes");
        super(r8, r10);
    }

    @Override // com.obric.oui.panel.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final boolean g(CoordinatorLayout r8, V r10, MotionEvent r11) {
        i.f(r8, "parent");
        i.f(r11, "event");
        return false;
    }

    @Override // com.obric.oui.panel.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final boolean u(CoordinatorLayout r8, V r10, View r11, View r12, int r13, int r14) {
        i.f(r8, "coordinatorLayout");
        i.f(r11, "directTargetChild");
        i.f(r12, "target");
        return false;
    }

    @Override // com.obric.oui.panel.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final boolean x(CoordinatorLayout r8, V r10, MotionEvent r11) {
        i.f(r8, "parent");
        i.f(r10, "child");
        i.f(r11, "event");
        return false;
    }

    @Override // com.obric.oui.panel.BottomSheetBehavior
    public final void z() {
        if (this.f6367a == false) goto L7;
        int r8 = this.f6386t - this.f6373g;
        int r10 = this.f6374h;
        if (r8 >= r10) goto L8;
        r8 = r10;
    L8:
        this.f6376j = r8;
        this.f6376j = r8 / 2;
        return;
    L7:
        r8 = this.f6386t - this.f6373g;
        goto L8
    }
}
