package com.obric.oui.common.widget;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes5.dex */
public class a implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f13514a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f13515b;

    public a(float r1, float r2) {
        this.f13514a = r1;
        this.f13515b = r2;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View r2, MotionEvent r3) {
        int r4 = r3.getAction();
        if (r4 != 0) goto L5;
        float r1 = this.f13514a;
    L11:
        r2.setAlpha(r1);
        return false;
    L5:
        if (r4 != 1) goto L7;
    L9:
        r1 = this.f13515b;
        goto L11
    L7:
        if (r4 == 3) goto L9;
        return false;
    }
}
