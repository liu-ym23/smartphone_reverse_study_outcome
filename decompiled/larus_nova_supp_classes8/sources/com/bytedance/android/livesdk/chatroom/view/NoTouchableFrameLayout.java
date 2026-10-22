package com.bytedance.android.livesdk.chatroom.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class NoTouchableFrameLayout extends FrameLayout {
    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r1) {
        return false;
    }

    public NoTouchableFrameLayout(Context r1) {
        super(r1);
    }

    public NoTouchableFrameLayout(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    public NoTouchableFrameLayout(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }
}
