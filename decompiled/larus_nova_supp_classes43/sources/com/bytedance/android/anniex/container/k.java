package com.bytedance.android.anniex.container;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class k implements View.OnClickListener {
    public final /* synthetic */ d a;

    public k(d r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r10) {
        ab.a r11 = this.a.j;
        boolean r0 = false;
        if (r11 != null) goto L5;
    L7:
        if (r0 == true) goto L9;
    L11:
        this.a.close();
        return;
    L9:
        if (this.a.p == 3) goto L11;
        return;
    L5:
        if (r11.w() != true) goto L7;
        r0 = true;
        goto L7
    }
}
