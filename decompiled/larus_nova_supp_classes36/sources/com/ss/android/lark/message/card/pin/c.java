package com.ss.android.lark.message.card.pin;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c implements View.OnTouchListener {
    public final /* synthetic */ View.OnClickListener a;

    public c(View.OnClickListener r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r2, MotionEvent r3) {
        if (r3.getAction() != 1) goto L7;
        View.OnClickListener r4 = this.a;
        if (r4 == null) goto L7;
        r4.onClick(r2);
    L7:
        return true;
    }
}
