package androidx.core.widget;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class l {
    public static Drawable[] a(TextView r8) {
        return r8.getCompoundDrawablesRelative();
    }

    public static int b(View r8) {
        return r8.getLayoutDirection();
    }

    public static int c(View r8) {
        return r8.getTextDirection();
    }

    public static Locale d(TextView r8) {
        return r8.getTextLocale();
    }

    public static void e(TextView r8, Drawable r10, Drawable r11, Drawable r12, Drawable r13) {
        r8.setCompoundDrawablesRelative(r10, r11, r12, r13);
    }

    public static void f(TextView r8, int r10, int r11, int r12, int r13) {
        r8.setCompoundDrawablesRelativeWithIntrinsicBounds(r10, r11, r12, r13);
    }

    public static void g(TextView r8, Drawable r10, Drawable r11, Drawable r12, Drawable r13) {
        r8.setCompoundDrawablesRelativeWithIntrinsicBounds(r10, r11, r12, r13);
    }

    public static void h(View r8, int r10) {
        r8.setTextDirection(r10);
    }
}
