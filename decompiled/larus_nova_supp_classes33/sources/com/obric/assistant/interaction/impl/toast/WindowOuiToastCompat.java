package com.obric.assistant.interaction.impl.toast;

import android.view.View;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.toast.ToastBackgroundView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
final class WindowOuiToastCompat {
    private WindowOuiToastCompat() {
    }

    public static void setupBackground(View r1) {
        if ((r1 instanceof ToastBackgroundView) == true) goto L5;
        return;
    L5:
        r1.measure(0, 0);
        ((ToastBackgroundView) r1).setupBackground(r1.getMeasuredHeight());
    }

    public static int getCornerRadius(View r1, int r2) {
        if ((r1 instanceof ToastBackgroundView) == true) goto L5;
        return r2;
    L5:
        return ((ToastBackgroundView) r1).getCornerRadius();
    }

    public static void setShadowCornerRadius(View r1, int r2) {
        if ((r1 instanceof OUIFrameLayout) == false) goto L6;
        ((OUIFrameLayout) r1).setShadowCornerRadius(r2);
        return;
    }
}
