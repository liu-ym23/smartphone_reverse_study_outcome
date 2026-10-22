package com.obric.oui.constraintlayout.motion.widget;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
public final class e0 implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12756a;

    public /* synthetic */ e0(int r5) {
        this.f12756a = r5;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r5, MotionEvent r10) {
        switch(this.f12756a) {
            case 0: goto L19;
            case 1: goto L17;
            case 2: goto L15;
            default: goto L4;
        };
    L4:
        int r11 = r10.getAction();
        if (r11 != 0) goto L7;
        r5.setAlpha(0.5f);
        return false;
    L7:
        if (r11 != 1) goto L9;
    L11:
        r5.setAlpha(1.0f);
        return false;
    L9:
        if (r11 == 3) goto L11;
        return false;
    L15:
        return true;
    L17:
        return true;
    L19:
        return false;
    }
}
