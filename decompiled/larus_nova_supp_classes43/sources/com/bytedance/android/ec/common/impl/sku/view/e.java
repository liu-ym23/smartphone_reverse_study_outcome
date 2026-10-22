package com.bytedance.android.ec.common.impl.sku.view;

import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e implements View.OnTouchListener {
    public final /* synthetic */ TextView a;

    public e(TextView r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r1, MotionEvent r10) {
        int r11 = r10.getAction();
        if (r11 != 0) goto L5;
        this.a.setAlpha(0.75f);
        return false;
    L5:
        if (r11 != 1) goto L7;
    L9:
        this.a.setAlpha(1.0f);
        return false;
    L7:
        if (r11 == 3) goto L9;
        return false;
    }
}
