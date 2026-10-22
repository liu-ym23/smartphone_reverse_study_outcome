package com.bytedance.android.annie.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class ForceInterceptConstraintLayout extends ConstraintLayout {
    public boolean a;
    public Function1<KeyEvent, Boolean> b;

    public ForceInterceptConstraintLayout(Context r1) {
        super(r1);
        this.a = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean dispatchKeyEvent(KeyEvent r10) {
        Function1<KeyEvent, Boolean> r0 = this.b;
        if (r0 == null) goto L9;
        if (((Boolean) r0.invoke(r10)).booleanValue() == false) goto L9;
        return true;
    L9:
        return super/*android.view.ViewGroup*/.dispatchKeyEvent(r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean onInterceptTouchEvent(MotionEvent r10) {
        if (this.a == false) goto L9;
        if (r10.getAction() == 0) goto L9;
        return true;
    L9:
        return super/*android.view.ViewGroup*/.onInterceptTouchEvent(r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean onTouchEvent(MotionEvent r10) {
        if (r10.getAction() != 1) goto L5;
    L6:
        setForceInterceptTouchEvent(false);
    L8:
        return super/*android.view.ViewGroup*/.onTouchEvent(r10);
    L5:
        if (r10.getAction() != 3) goto L8;
        goto L6
    }

    public void setForceInterceptTouchEvent(boolean r1) {
        this.a = r1;
    }

    public void setOnDispatchKeyEvent(Function1<KeyEvent, Boolean> r1) {
        this.b = r1;
    }

    public ForceInterceptConstraintLayout(Context r1, AttributeSet r10) {
        super(r1, r10);
        this.a = false;
    }

    public ForceInterceptConstraintLayout(Context r1, AttributeSet r10, int r11) {
        super(r1, r10, r11);
        this.a = false;
    }
}
