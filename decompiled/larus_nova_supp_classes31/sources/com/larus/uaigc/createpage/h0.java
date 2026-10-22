package com.larus.uaigc.createpage;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class h0 extends FrameLayout {
    public View a;
    public Function0<Unit> b;
    public boolean c;

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r6) {
        Intrinsics.checkNotNullParameter(r6, "event");
        View r0 = this.a;
        boolean r1 = false;
        if (r0 != null) goto L6;
        return false;
    L6:
        if (r0.isShown() == true) goto L8;
        return false;
    L8:
        Rect r2 = new Rect();
        if (r0.getGlobalVisibleRect(r2) == true) goto L11;
    L12:
        r1 = true;
    L13:
        if (r1 == true) goto L17;
        super.dispatchTouchEvent(r6);
        return true;
    L17:
        if (r6.getActionMasked() == 0) goto L19;
    L21:
        return true;
    L19:
        if (this.c == true) goto L21;
        this.c = true;
        post(new g0(this));
        goto L21
    L11:
        if (r2.contains((int) r6.getRawX(), (int) r6.getRawY()) == true) goto L13;
        goto L12
    }
}
