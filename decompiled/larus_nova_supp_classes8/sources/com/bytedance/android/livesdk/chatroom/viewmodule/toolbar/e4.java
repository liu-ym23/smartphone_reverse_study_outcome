package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e4 extends TouchDelegate {
    public final int a;
    public final int b;
    public final Rect c;
    public final r0 d;
    public final View e;

    @Override // android.view.TouchDelegate
    public final boolean onTouchEvent(MotionEvent r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        if (this.c.contains((int) r5.getX(), (int) r5.getY()) == false) goto L6;
        return this.d.b(r5.getAction(), r5.getRawX() - this.a, r5.getRawY() - this.b, "3");
    L6:
        return super.onTouchEvent(r5);
    }

    public e4(Rect r2, r0 r3, View r4) {
        Intrinsics.checkNotNullParameter(r2, "bounds");
        Intrinsics.checkNotNullParameter(r3, "expand");
        Intrinsics.checkNotNullParameter(r4, "delegateView");
        super(r2, r4);
        this.c = r2;
        this.d = r3;
        this.e = r4;
        int[] r5 = new int[2];
        r4.getLocationOnScreen(r5);
        this.a = r5[0];
        this.b = r5[1];
    }
}
