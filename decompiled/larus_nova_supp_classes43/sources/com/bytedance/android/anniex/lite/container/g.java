package com.bytedance.android.anniex.lite.container;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class g implements View.OnClickListener {
    public final /* synthetic */ AnnieXFlowPopupContainer a;

    public g(AnnieXFlowPopupContainer r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r10) {
        ab.a r11 = this.a.r();
        boolean r0 = false;
        if (r11 != null) goto L5;
    L7:
        if (r0 == true) goto L9;
    L11:
        this.a.close();
        return;
    L9:
        if (this.a.q == 3) goto L11;
        return;
    L5:
        if (r11.w() != true) goto L7;
        r0 = true;
        goto L7
    }
}
