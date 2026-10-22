package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.widget.CompoundButton;

/* JADX INFO: loaded from: classes.dex */
public final class b {
    public static ColorStateList a(CompoundButton r8) {
        return r8.getButtonTintList();
    }

    public static PorterDuff.Mode b(CompoundButton r8) {
        return r8.getButtonTintMode();
    }

    public static void c(CompoundButton r8, ColorStateList r10) {
        r8.setButtonTintList(r10);
    }

    public static void d(CompoundButton r8, PorterDuff.Mode r10) {
        r8.setButtonTintMode(r10);
    }
}
