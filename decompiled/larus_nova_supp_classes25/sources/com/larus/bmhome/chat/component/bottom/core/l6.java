package com.larus.bmhome.chat.component.bottom.core;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class l6 implements View.OnTouchListener {
    public final /* synthetic */ View.OnTouchListener a;
    public final /* synthetic */ CoreInputComponent b;

    public /* synthetic */ l6(View.OnTouchListener r1, CoreInputComponent r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r6, MotionEvent r7) {
        View.OnTouchListener r0 = this.a;
        final CoreInputComponent r1 = this.b;
        int r2 = CoreInputComponent.d3;
        if (r0 != null) goto L5;
    L7:
        boolean r4 = false;
    L9:
        if (r7.getActionMasked() != 1) goto L13;
        if (r0 != null) goto L12;
        r1.i4(false);
        goto L13
    L12:
        r6.post(new f3(r1));
    L13:
        if (r4 == true) goto L18;
        if (r0 == null) goto L19;
        return false;
    L19:
        return true;
    L18:
        return true;
    L5:
        if (r0.onTouch(r6, r7) != true) goto L7;
        r4 = true;
        goto L9
    }
}
