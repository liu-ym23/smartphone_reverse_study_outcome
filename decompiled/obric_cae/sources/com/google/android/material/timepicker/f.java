package com.google.android.material.timepicker;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Checkable;

/* JADX INFO: loaded from: classes.dex */
public final class f implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GestureDetector f5158a;

    public f(GestureDetector r8) {
        this.f5158a = r8;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r8, MotionEvent r10) {
        if (((Checkable) r8).isChecked() == true) goto L5;
        return false;
    L5:
        return this.f5158a.onTouchEvent(r10);
    }
}
