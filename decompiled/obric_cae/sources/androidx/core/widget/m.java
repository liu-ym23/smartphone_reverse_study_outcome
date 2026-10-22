package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
public final class m {
    public static int a(TextView r8) {
        return r8.getBreakStrategy();
    }

    public static ColorStateList b(TextView r8) {
        return r8.getCompoundDrawableTintList();
    }

    public static PorterDuff.Mode c(TextView r8) {
        return r8.getCompoundDrawableTintMode();
    }

    public static int d(TextView r8) {
        return r8.getHyphenationFrequency();
    }

    public static void e(TextView r8, int r10) {
        r8.setBreakStrategy(r10);
    }

    public static void f(TextView r8, ColorStateList r10) {
        r8.setCompoundDrawableTintList(r10);
    }

    public static void g(TextView r8, PorterDuff.Mode r10) {
        r8.setCompoundDrawableTintMode(r10);
    }

    public static void h(TextView r8, int r10) {
        r8.setHyphenationFrequency(r10);
    }
}
