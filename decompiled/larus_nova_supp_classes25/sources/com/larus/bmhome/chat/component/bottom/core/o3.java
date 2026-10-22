package com.larus.bmhome.chat.component.bottom.core;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class o3 implements View.OnTouchListener {
    public final /* synthetic */ CoreInputComponent a;

    public /* synthetic */ o3(CoreInputComponent r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r2, MotionEvent r3) {
        CoreInputComponent r4 = this.a;
        int r0 = CoreInputComponent.d3;
        if (r3.getActionMasked() != 0) goto L7;
        r4.k4().p0();
        return false;
    L7:
        return false;
    }
}
