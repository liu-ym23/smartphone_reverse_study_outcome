package com.bytedance.android.livesdk.chatroom.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class AlwaysConsumeEventFrameLayout extends FrameLayout {
    public float a;
    public float b;
    public boolean c;

    public AlwaysConsumeEventFrameLayout(Context r1) {
        super(r1);
        this.c = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r4) {
        if (this.c == true) goto L7;
        return super.dispatchTouchEvent(r4);
    L7:
        if (com.bytedance.android.livesdk.config.l3.a.getValue().booleanValue() == false) goto L26;
        this.a = r4.getY();
        if (r4.getAction() != 0) goto L15;
        ViewParent r0 = getParent();
        if (r0 == null) goto L13;
        r0.requestDisallowInterceptTouchEvent(true);
    L13:
        this.b = r4.getY();
    L25:
        return super.dispatchTouchEvent(r4);
    L15:
        if (r4.getAction() != 2) goto L25;
        if (Math.abs(this.a - this.b) <= 10.0f) goto L21;
        ViewParent r1 = getParent();
        if (r1 == null) goto L25;
        r1.requestDisallowInterceptTouchEvent(false);
        goto L25
    L21:
        ViewParent r2 = getParent();
        if (r2 == null) goto L25;
        r2.requestDisallowInterceptTouchEvent(true);
        goto L25
    L26:
        requestDisallowInterceptTouchEvent(true);
        super.dispatchTouchEvent(r4);
        return true;
    }

    public void setAlwaysConsume(boolean r1) {
        this.c = r1;
    }

    public AlwaysConsumeEventFrameLayout(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.c = true;
    }

    public AlwaysConsumeEventFrameLayout(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.c = true;
    }
}
