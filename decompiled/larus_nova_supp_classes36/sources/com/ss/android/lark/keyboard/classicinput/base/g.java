package com.ss.android.lark.keyboard.classicinput.base;

import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.widget.slidingup.SlidingUpPanelLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class g implements Runnable {
    public final /* synthetic */ SlidingUpPanelLayout a;

    public g(SlidingUpPanelLayout r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
    L16:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L27;
        throw th;
    L27:
        return;
    L3:
        if (this.a.isEnabled() == true) goto L5;
        return;
    L5:
        if (this.a.getVisibility() == 8) goto L23;
        View r0 = this.a.getDragView();     // Catch: Throwable -> L16
        if (r0 != null) goto L11;
        return;
    L11:
        if (r0.getVisibility() == 0) goto L13;
        return;
    L13:
        if (r0.getY() >= (this.a.getHeight() - r0.getHeight())) goto L26;
        this.a.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);     // Catch: Throwable -> L16
        return;
    L26:
        return;
    }
}
