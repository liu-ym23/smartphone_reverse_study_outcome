package im.quar.autolayout.utils;

import android.view.View;
import android.view.ViewGroup;
import im.quar.autolayout.config.AutoLayoutConfig;

/* JADX INFO: loaded from: classes2.dex */
public class AutoUtils {
    public AutoUtils() {
    }

    public static void auto(View r8) {
        autoSize(r8);
        autoPadding(r8);
        autoMargin(r8);
    }

    public static void autoMargin(View r8) {
        if ((r8.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        return;
    L5:
        ViewGroup.MarginLayoutParams r10 = (ViewGroup.MarginLayoutParams) r8.getLayoutParams();
        if (r10 != null) goto L8;
        return;
    L8:
        r10.leftMargin = scaleValue(r10.leftMargin);
        r10.topMargin = scaleValue(r10.topMargin);
        r10.rightMargin = scaleValue(r10.rightMargin);
        r10.bottomMargin = scaleValue(r10.bottomMargin);
    }

    public static void autoPadding(View r8) {
        int r10 = r8.getPaddingLeft();
        int r11 = r8.getPaddingTop();
        int r12 = r8.getPaddingRight();
        int r13 = r8.getPaddingBottom();
        r8.setPadding(scaleValue(r10), scaleValue(r11), scaleValue(r12), scaleValue(r13));
    }

    public static void autoSize(View r8) {
        ViewGroup.LayoutParams r10 = r8.getLayoutParams();
        if (r10 != null) goto L5;
        return;
    L5:
        int r11 = r10.width;
        if (r11 <= 0) goto L8;
        r10.width = scaleValue(r11);
    L8:
        int r12 = r10.height;
        if (r12 <= 0) goto L12;
        r10.height = scaleValue(r12);
        return;
    }

    public static int scaleValue(int r8) {
        return (int) (AutoLayoutConfig.getInstance().getScale() * r8);
    }
}
