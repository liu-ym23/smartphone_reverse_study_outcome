package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes.dex */
public final class f {
    public static ColorStateList a(ImageView r8) {
        return r8.getImageTintList();
    }

    public static PorterDuff.Mode b(ImageView r8) {
        return r8.getImageTintMode();
    }

    public static void c(ImageView r8, ColorStateList r10) {
        r8.setImageTintList(r10);
    }

    public static void d(ImageView r8, PorterDuff.Mode r10) {
        r8.setImageTintMode(r10);
    }
}
