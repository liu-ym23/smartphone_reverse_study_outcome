package com.ss.android.lark.reaction.widget.detailwindow.scroller;

import android.view.GestureDetector;
import android.view.MotionEvent;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public abstract class f implements GestureDetector.OnGestureListener {
    public f() {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onDown(MotionEvent r1) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent r1, MotionEvent r2, float r3, float r4) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final void onLongPress(MotionEvent r1) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent r1, MotionEvent r2, float r3, float r4) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final void onShowPress(MotionEvent r1) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onSingleTapUp(MotionEvent r1) {
        return false;
    }
}
