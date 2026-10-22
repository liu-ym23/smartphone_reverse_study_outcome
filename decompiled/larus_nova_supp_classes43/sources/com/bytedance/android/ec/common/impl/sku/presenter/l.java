package com.bytedance.android.ec.common.impl.sku.presenter;

import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class l implements View.OnTouchListener {
    public final /* synthetic */ ButtonOptimizePresenter a;

    public l(ButtonOptimizePresenter r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r10, MotionEvent r11) {
        if (((LinearLayout) this.a.Z().b(2131378867).f()).hasOnClickListeners() == false) goto L19;
        if (r11 == null) goto L6;
        Integer r12 = Integer.valueOf(r11.getAction());
    L8:
        if (r12 != null) goto L11;
    L13:
        if (r12 != null) goto L16;
    L18:
        this.a.Z().b(2131386836).f().setVisibility(8);
        goto L19
    L16:
        if (r12.intValue() != 2) goto L18;
    L17:
        this.a.Z().b(2131386836).f().setVisibility(0);
        goto L19
    L11:
        if (r12.intValue() != 0) goto L13;
    L6:
        r12 = null;
    L19:
        return false;
    }
}
