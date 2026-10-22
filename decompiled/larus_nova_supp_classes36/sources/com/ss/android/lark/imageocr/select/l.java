package com.ss.android.lark.imageocr.select;

import android.view.ViewTreeObserver;
import android.widget.PopupWindow;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class l implements ViewTreeObserver.OnScrollChangedListener {
    public final /* synthetic */ e a;

    public l(e r1) {
        this.a = r1;
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        e r0 = this.a;
        if (r0.p == false) goto L5;
        return;
    L5:
        if (r0.q == true) goto L17;
        r0.p = true;
        e.d r1 = r0.c;
        if (r1 == null) goto L9;
        PopupWindow r2 = r1.a;
        PopupWindowLancet.handleDismissBeforeOrigin(r2);
        r2.dismiss();
    L9:
        e.c r3 = this.a.a;
        if (r3 == null) goto L12;
        PopupWindow r4 = r3.b;
        PopupWindowLancet.handleDismissBeforeOrigin(r4);
        r4.dismiss();
    L12:
        e.c r5 = this.a.b;
        if (r5 == null) goto L18;
        PopupWindow r6 = r5.b;
        PopupWindowLancet.handleDismissBeforeOrigin(r6);
        r6.dismiss();
        return;
    L18:
        return;
    }
}
