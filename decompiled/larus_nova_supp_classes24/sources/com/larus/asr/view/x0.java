package com.larus.asr.view;

import android.view.MotionEvent;
import android.view.View;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class x0 implements View.OnTouchListener {
    public final /* synthetic */ h1 a;
    public final /* synthetic */ Function1 b;

    public /* synthetic */ x0(h1 r1, Function1 r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r2, MotionEvent r3) {
        h1 r4 = this.a;
        Function1 r0 = this.b;
        int r5 = r3.getActionMasked();
        if (r5 == 0) goto L11;
        if (r5 != 1) goto L7;
    L9:
        r0.invoke(Boolean.FALSE);
        return false;
    L7:
        if (r5 == 3) goto L9;
        return false;
    L11:
        if (r4.a == true) goto L13;
        return false;
    L13:
        if (r4.b == false) goto L15;
    L16:
        r0.invoke(Boolean.TRUE);
        return false;
    L15:
        if (r4.c == true) goto L16;
        return false;
    }
}
