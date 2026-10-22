package j0;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.view.MenuItem;

/* JADX INFO: loaded from: classes.dex */
public final class j {
    public static int a(MenuItem r8) {
        return r8.getAlphabeticModifiers();
    }

    public static CharSequence b(MenuItem r8) {
        return r8.getContentDescription();
    }

    public static ColorStateList c(MenuItem r8) {
        return r8.getIconTintList();
    }

    public static PorterDuff.Mode d(MenuItem r8) {
        return r8.getIconTintMode();
    }

    public static int e(MenuItem r8) {
        return r8.getNumericModifiers();
    }

    public static CharSequence f(MenuItem r8) {
        return r8.getTooltipText();
    }

    public static MenuItem g(MenuItem r8, char r10, int r11) {
        return r8.setAlphabeticShortcut(r10, r11);
    }

    public static MenuItem h(MenuItem r8, CharSequence r10) {
        return r8.setContentDescription(r10);
    }

    public static MenuItem i(MenuItem r8, ColorStateList r10) {
        return r8.setIconTintList(r10);
    }

    public static MenuItem j(MenuItem r8, PorterDuff.Mode r10) {
        return r8.setIconTintMode(r10);
    }

    public static MenuItem k(MenuItem r8, char r10, int r11) {
        return r8.setNumericShortcut(r10, r11);
    }

    public static MenuItem l(MenuItem r8, char r10, char r11, int r12, int r13) {
        return r8.setShortcut(r10, r11, r12, r13);
    }

    public static MenuItem m(MenuItem r8, CharSequence r10) {
        return r8.setTooltipText(r10);
    }
}
