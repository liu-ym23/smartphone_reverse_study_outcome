package com.google.android.material.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class TouchObserverFrameLayout extends FrameLayout {

    @Nullable
    private View.OnTouchListener onTouchListener;

    public TouchObserverFrameLayout(@NonNull Context r5) {
        super(r5);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r5) {
        View.OnTouchListener r10 = this.onTouchListener;
        if (r10 == null) goto L6;
        r10.onTouch(this, r5);
    L6:
        return super.onInterceptTouchEvent(r5);
    }

    @Override // android.view.View
    public void setOnTouchListener(@Nullable View.OnTouchListener r5) {
        this.onTouchListener = r5;
    }

    public TouchObserverFrameLayout(@NonNull Context r5, @Nullable AttributeSet r10) {
        super(r5, r10);
    }

    public TouchObserverFrameLayout(@NonNull Context r5, @Nullable AttributeSet r10, int r11) {
        super(r5, r10, r11);
    }
}
