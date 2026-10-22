package com.google.android.material.dialog;

import android.R;
import android.app.Dialog;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class InsetDialogOnTouchListener implements View.OnTouchListener {

    @NonNull
    private final Dialog dialog;
    private final int leftInset;
    private final int prePieSlop;
    private final int topInset;

    public InsetDialogOnTouchListener(@NonNull Dialog r5, @NonNull Rect r10) {
        this.dialog = r5;
        this.leftInset = r10.left;
        this.topInset = r10.top;
        this.prePieSlop = ViewConfiguration.get(r5.getContext()).getScaledWindowTouchSlop();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(@NonNull View r10, @NonNull MotionEvent r11) {
        View r5 = r10.findViewById(R.id.content);
        int r12 = r5.getLeft() + this.leftInset;
        int r13 = r5.getWidth() + r12;
        int r14 = r5.getTop() + this.topInset;
        if (new RectF(r12, r14, r13, r5.getHeight() + r14).contains(r11.getX(), r11.getY()) == false) goto L6;
        return false;
    L6:
        MotionEvent r15 = MotionEvent.obtain(r11);
        if (r11.getAction() != 1) goto L9;
        r15.setAction(4);
    L9:
        r10.performClick();
        return this.dialog.onTouchEvent(r15);
    }
}
