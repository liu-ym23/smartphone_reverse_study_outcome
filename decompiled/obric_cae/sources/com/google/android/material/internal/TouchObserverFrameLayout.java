package com.google.android.material.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes.dex */
public class TouchObserverFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View.OnTouchListener f4822a;

    public TouchObserverFrameLayout(Context r8, AttributeSet r10) {
        super(r8, r10);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r8) {
        View.OnTouchListener r10 = this.f4822a;
        if (r10 == null) goto L6;
        r10.onTouch(this, r8);
    L6:
        return super.onInterceptTouchEvent(r8);
    }

    @Override // android.view.View
    public void setOnTouchListener(View.OnTouchListener r8) {
        this.f4822a = r8;
    }
}
