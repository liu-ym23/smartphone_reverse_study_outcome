package x9;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import androidx.appcompat.widget.v0;

/* JADX INFO: loaded from: classes.dex */
public final class c {
    public static ColorStateList a(Context r8, TypedArray r10, int r11) {
        if (r10.hasValue(r11) == false) goto L10;
        int r12 = r10.getResourceId(r11, 0);
        if (r12 == 0) goto L10;
        ColorStateList r13 = androidx.core.content.a.b(r8, r12);
        if (r13 == null) goto L10;
        return r13;
    L10:
        return r10.getColorStateList(r11);
    }

    public static ColorStateList b(Context r8, v0 r10, int r11) {
        if (r10.l(r11) == false) goto L10;
        int r12 = r10.i(r11, 0);
        if (r12 == 0) goto L10;
        ColorStateList r13 = androidx.core.content.a.b(r8, r12);
        if (r13 == null) goto L10;
        return r13;
    L10:
        return r10.b(r11);
    }

    public static Drawable c(Context r8, TypedArray r10, int r11) {
        if (r10.hasValue(r11) == false) goto L10;
        int r12 = r10.getResourceId(r11, 0);
        if (r12 == 0) goto L10;
        Drawable r13 = d.a.a(r8, r12);
        if (r13 == null) goto L10;
        return r13;
    L10:
        return r10.getDrawable(r11);
    }

    public static boolean d(Context r8) {
        if (r8.getResources().getConfiguration().fontScale < 1.3f) goto L5;
        return true;
    L5:
        return false;
    }
}
