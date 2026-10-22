package en;

import android.view.View;
import android.widget.FrameLayout;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.ui.list.ListStickyManager;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ListStickyManager f16842a;

    public g(ListStickyManager r5, LynxContext r10) {
        this.f16842a = r5;
        super(r10);
    }

    @Override // android.view.ViewGroup
    public final void measureChildWithMargins(View r5, int r10, int r11, int r12, int r13) {
        if ((r5 instanceof com.lynx.tasm.behavior.ui.view.c) == false) goto L6;
        r5.measure(r5.getMeasuredWidth(), r5.getMeasuredHeight());
        return;
    L6:
        super.measureChildWithMargins(r5, r10, r11, r12, r13);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r5, int r10, int r11, int r12, int r13) {
        super.onLayout(r5, r10, r11, r12, r13);     // Catch: NullPointerException -> L4
    L6:
        ListStickyManager r14 = this.f16842a;
        r14.f10508c.getClass();
        r14.d.getClass();
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
        goto L6
    }
}
