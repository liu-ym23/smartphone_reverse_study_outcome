package com.larus.common_ui.view;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.larus.bmhome.view.BottomMenuGridLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class f implements View.OnTouchListener {
    public final /* synthetic */ BottomOverlayViewAdapterPad a;
    public final /* synthetic */ Rect b;
    public final /* synthetic */ CoordinatorLayout c;
    public final /* synthetic */ Rect d;
    public final /* synthetic */ View e;
    public final /* synthetic */ Rect f;
    public final /* synthetic */ View g;
    public final /* synthetic */ Rect h;

    public /* synthetic */ f(BottomOverlayViewAdapterPad r1, Rect r2, CoordinatorLayout r3, Rect r4, BottomMenuGridLayout r5, Rect r6, View r7, Rect r8) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r20, MotionEvent r21) {
        BottomOverlayViewAdapterPad r10 = this.a;
        Rect r11 = this.b;
        CoordinatorLayout r12 = this.c;
        Rect r13 = this.d;
        CoordinatorLayout r14 = this.e;
        Rect r15 = this.f;
        View r9 = this.g;
        Rect r8 = this.h;
        int r1 = BottomOverlayViewAdapterPad.m;
        int r2 = r21.getActionMasked();
        if (r2 == 0) goto L53;
        if (r2 == 1) goto L27;
        if (r2 == 2) goto L11;
        if (r2 == 3) goto L27;
        return false;
    L11:
        if (r10.d == true) goto L24;
        float r3 = r21.getRawX() - r10.a;
        float r4 = r21.getRawY() - r10.b;
        if (Math.abs(r4) <= Math.abs(r3)) goto L24;
        if (Math.abs(r4) <= 50.0f) goto L24;
        r10.d = true;
        if (r4 <= 0.0f) goto L19;
        r10.e = true;
    L19:
        MotionEvent r7 = r10.c;
        if (r7 == null) goto L24;
        BottomOverlayViewAdapterPad.c(r10, r11, r15, r12, r14, r13, r9, r8, r7);
    L24:
        if (r10.d == false) goto L57;
        Intrinsics.checkNotNull(r21);
        BottomOverlayViewAdapterPad.c(r10, r11, r15, r12, r14, r13, r9, r8, r21);
    L57:
        return true;
    L27:
        if (r10.d == false) goto L29;
        Intrinsics.checkNotNull(r21);
        BottomOverlayViewAdapterPad.c(r10, r11, r15, r12, r14, r13, r9, r8, r21);
        MotionEvent r5 = null;
        boolean r6 = false;
    L49:
        r10.d = r6;
        r10.e = r6;
        MotionEvent r16 = r10.c;
        if (r16 == null) goto L52;
        r16.recycle();
    L52:
        r10.c = r5;
        goto L57
    L29:
        r5 = null;
        r6 = false;
        r14.getGlobalVisibleRect(r13);
        r9.getGlobalVisibleRect(r11);
        r12.getGlobalVisibleRect(r15);
        r10.e(r13, r11, r8);
        int r17 = (int) r21.getRawX();
        int r18 = (int) r21.getRawY();
        if (r10.i == false) goto L37;
        if (r10.j == false) goto L37;
        if (r11.contains(r17, r18) == false) goto L37;
    L45:
        if (r12 == null) goto L49;
        MotionEvent r22 = r10.c;
        if (r22 == null) goto L49;
        Intrinsics.checkNotNull(r22);
        BottomOverlayViewAdapterPad.b(r12, r22);
        Intrinsics.checkNotNull(r21);
        BottomOverlayViewAdapterPad.b(r12, r21);
    L37:
        if (r13.contains(r17, r18) == false) goto L40;
        r12 = r14;
        goto L45
    L40:
        if (r10.i == true) goto L42;
    L44:
        r12 = null;
        goto L45
    L42:
        if (r11.contains(r17, r18) == false) goto L44;
    L53:
        r10.a = r21.getRawX();
        r10.b = r21.getRawY();
        r10.d = false;
        r10.e = false;
        MotionEvent r23 = r10.c;
        if (r23 == null) goto L56;
        r23.recycle();
    L56:
        r10.c = MotionEvent.obtain(r21);
        goto L57
    }
}
