package com.larus.photopicker.v2.impl;

import android.content.Context;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.larus.common_ui.view.BottomOverlayViewAdapterPad;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class b0 extends FrameLayout {
    public View a;
    public BottomOverlayViewAdapterPad b;
    public boolean c;
    public boolean d;
    public final View e;

    public b0(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.c = true;
        View r0 = new View(r2);
        r0.setBackgroundColor(0);
        r0.setAlpha(0.0f);
        r0.setImportantForAccessibility(2);
        this.e = r0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r6) {
        Intrinsics.checkNotNullParameter(r6, "event");
        if (super.dispatchTouchEvent(r6) == false) goto L5;
        return true;
    L5:
        View r0 = this.a;
        if (r0 != null) goto L8;
        return false;
    L8:
        Rect r3 = new Rect();
        r0.getGlobalVisibleRect(r3);
        if ((!r3.contains((int) r6.getRawX(), (int) r6.getRawY())) == true) goto L12;
        return true;
    L12:
        if (this.c == false) goto L28;
        BottomOverlayViewAdapterPad r1 = this.b;
        if (r1 != null) goto L17;
    L24:
        boolean r7 = false;
    L25:
        if (r7 == true) goto L29;
        return false;
    L29:
        return true;
    L17:
        if (r1.isShown() == false) goto L24;
        Rect r4 = new Rect();
        if (r1.getGlobalVisibleRect(r4) == false) goto L24;
        if (r4.contains((int) r6.getRawX(), (int) r6.getRawY()) == false) goto L24;
        r7 = true;
        goto L25
    L28:
        return true;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r4) {
        Intrinsics.checkNotNullParameter(r4, "event");
        if (this.d == false) goto L14;
        if (r4.getActionMasked() != 0) goto L14;
        View r0 = this.a;
        if (r0 == null) goto L14;
        Rect r1 = new Rect();
        r0.getGlobalVisibleRect(r1);
        if (r1.contains((int) r4.getRawX(), (int) r4.getRawY()) == false) goto L14;
        ViewParent r2 = getParent();
        if (r2 == null) goto L14;
        r2.requestDisallowInterceptTouchEvent(true);
    L14:
        return super.onInterceptTouchEvent(r4);
    }
}
