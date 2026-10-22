package com.larus.commercecredit.impl.page;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class v implements View.OnTouchListener {
    public float a;
    public boolean b;
    public final int c;
    public final /* synthetic */ CommerceCreditWebFragment d;

    public v(View r1, CommerceCreditWebFragment r2) {
        this.d = r2;
        this.c = ViewConfiguration.get(r1.getContext()).getScaledTouchSlop();
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r5, MotionEvent r6) {
        Intrinsics.checkNotNullParameter(r5, "v");
        Intrinsics.checkNotNullParameter(r6, "event");
        int r0 = r6.getAction();
        if (r0 == 0) goto L23;
        if (r0 != 1) goto L6;
    L21:
        r5.getParent().requestDisallowInterceptTouchEvent(false);
        return false;
    L6:
        if (r0 != 2) goto L8;
        float r7 = r6.getY() - this.a;
        if (Math.abs(r7) <= this.c) goto L16;
        if (this.b == true) goto L16;
        this.b = true;
    L16:
        if (this.b == true) goto L18;
    L24:
        return false;
    L18:
        if (r7 <= 0.0f) goto L24;
        CommerceCreditWebFragment r8 = this.d;
        int r9 = CommerceCreditWebFragment.h;
        r8.X90();
        return true;
    L8:
        if (r0 == 3) goto L21;
    L23:
        this.a = r6.getY();
        this.b = false;
        r5.getParent().requestDisallowInterceptTouchEvent(true);
        goto L24
    }
}
