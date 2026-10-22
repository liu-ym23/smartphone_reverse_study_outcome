package vob;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d {
    public static int b(View r0) {
        if (r0 != null) goto L6;
        return 0;
    L6:
        return MarginLayoutParamsCompat.getMarginEnd((ViewGroup.MarginLayoutParams) r0.getLayoutParams());
    }

    public static int c(View r0) {
        if (r0 != null) goto L6;
        return 0;
    L6:
        return MarginLayoutParamsCompat.getMarginStart((ViewGroup.MarginLayoutParams) r0.getLayoutParams());
    }

    public static int e(View r0) {
        if (r0 != null) goto L5;
        return 0;
    L5:
        return r0.getWidth();
    }

    public static int a(View r3, boolean r4) {
        boolean r0 = false;
        if (r3 != null) goto L6;
        return 0;
    L6:
        if (ViewCompat.getLayoutDirection(r3) != 1) goto L8;
        r0 = true;
    L8:
        if (r0 == false) goto L13;
        if (r4 == false) goto L12;
        return r3.getLeft() + ViewCompat.getPaddingEnd(r3);
    L12:
        return r3.getLeft();
    L13:
        if (r4 == false) goto L16;
        return r3.getRight() - ViewCompat.getPaddingEnd(r3);
    L16:
        return r3.getRight();
    }

    public static int d(View r3, boolean r4) {
        boolean r0 = false;
        if (r3 != null) goto L6;
        return 0;
    L6:
        if (ViewCompat.getLayoutDirection(r3) != 1) goto L8;
        r0 = true;
    L8:
        if (r0 == false) goto L13;
        if (r4 == false) goto L12;
        return r3.getRight() - ViewCompat.getPaddingStart(r3);
    L12:
        return r3.getRight();
    L13:
        if (r4 == false) goto L16;
        return r3.getLeft() + ViewCompat.getPaddingStart(r3);
    L16:
        return r3.getLeft();
    }
}
