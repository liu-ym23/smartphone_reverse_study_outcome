package com.google.android.material.timepicker;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import com.obric.cae.R;

/* JADX INFO: loaded from: classes.dex */
public final class b extends j0.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ClockFaceView f5155d;

    public b(ClockFaceView r8) {
        this.f5155d = r8;
    }

    @Override // j0.a
    public final void d(View r8, k0.f r10) {
        View.AccessibilityDelegate r11 = this.f8370a;
        AccessibilityNodeInfo r12 = r10.f8890a;
        r11.onInitializeAccessibilityNodeInfo(r8, r12);
        int r13 = ((Integer) r8.getTag(R.id.material_value_index)).intValue();
        if (r13 <= 0) goto L5;
        r12.setTraversalAfter(this.f5155d.H.get(r13 - 1));
    L5:
        r10.h(k0.f.c.a(0, 1, r13, 1, r8.isSelected()));
        r12.setClickable(true);
        r10.b(k0.f.a.f8893e);
    }

    @Override // j0.a
    public final boolean g(View r11, int r12, Bundle r13) {
        if (r12 != 16) goto L7;
        long r14 = SystemClock.uptimeMillis();
        ClockFaceView r10 = this.f5155d;
        r11.getHitRect(r10.E);
        float r15 = r10.E.centerX();
        float r8 = r10.E.centerY();
        r10.D.onTouchEvent(MotionEvent.obtain(r14, r14, 0, r15, r8, 0));
        r10.D.onTouchEvent(MotionEvent.obtain(r14, r14, 1, r15, r8, 0));
        return true;
    L7:
        return super.g(r11, r12, r13);
    }
}
