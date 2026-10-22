package wr0;

import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d {
    public static View a(View r6, MotionEvent r7) {
        if (r6 == null) goto L22;
        if (r7 == null) goto L22;
        int r2 = 0;
        boolean r3 = false;
        if ((r6 instanceof ViewGroup) == false) goto L9;
        ViewGroup r8 = (ViewGroup) r6;
        int r1 = r8.getChildCount();
    L17:
        if (r2 >= r1) goto L22;
        View r4 = a(r8.getChildAt(r2), r7);
        if (r4 != null) goto L20;
        r2 = r2 + 1;
        goto L17
    L20:
        return r4;
    L9:
        if (r6.getVisibility() != 0) goto L12;
        float r5 = r7.getRawX();
        float r9 = r7.getRawY();
        RectF r10 = new RectF();
        int[] r11 = new int[2];
        r6.getLocationOnScreen(r11);
        float r12 = r11[0];
        float r13 = r11[1];
        r10.left = r12;
        r10.right = r12 + r6.getWidth();
        r10.top = r13;
        r10.bottom = r13 + r6.getHeight();
        r3 = r10.contains(r5, r9);
    L12:
        if (r3 == false) goto L15;
        return r6;
    L15:
        return null;
    L22:
        return null;
    }
}
