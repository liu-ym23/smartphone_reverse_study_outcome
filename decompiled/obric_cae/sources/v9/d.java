package v9;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.TypedValue;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes.dex */
public final class d {
    public static float a(int r8, String[] r10) {
        float r11 = Float.parseFloat(r10[r8]);
        if (r11 < 0.0f) goto L8;
        if (r11 > 1.0f) goto L8;
        return r11;
    L8:
        throw new IllegalArgumentException("Motion easing control point value must be between 0 and 1; instead got: " + r11);
    }

    public static boolean b(String r8, String r10) {
        if (r8.startsWith(r10.concat("(")) == true) goto L5;
    L7:
        return false;
    L5:
        if (r8.endsWith(")") == false) goto L7;
        return true;
    }

    public static int c(Context r8, int r10, int r11) {
        TypedValue r12 = x9.b.a(r8, r10);
        if (r12 != null) goto L5;
        return r11;
    L5:
        if (r12.type == 16) goto L7;
        return r11;
    L7:
        return r12.data;
    }

    public static TimeInterpolator d(Context r8, int r10, Interpolator r11) {
        TypedValue r12 = new TypedValue();
        if (r8.getTheme().resolveAttribute(r10, r12, true) == true) goto L6;
        return r11;
    L6:
        if (r12.type != 3) goto L31;
        String r13 = String.valueOf(r12.string);
        if (b(r13, "cubic-bezier") == false) goto L10;
    L13:
        boolean r14 = true;
    L14:
        if (r14 == false) goto L29;
        if (b(r13, "cubic-bezier") == false) goto L23;
        String[] r15 = r13.substring(13, r13.length() - 1).split(",");
        if (r15.length != 4) goto L21;
        return l0.a.b(a(0, r15), a(1, r15), a(2, r15), a(3, r15));
    L21:
        throw new IllegalArgumentException("Motion easing theme attribute must have 4 control points if using bezier curve format; instead got: " + r15.length);
    L23:
        if (b(r13, "path") == false) goto L27;
        return l0.a.c(a0.d.d(r13.substring(5, r13.length() - 1)));
    L27:
        throw new IllegalArgumentException("Invalid motion easing type: ".concat(r13));
    L29:
        return AnimationUtils.loadInterpolator(r8, r12.resourceId);
    L10:
        if (b(r13, "path") == true) goto L13;
        r14 = false;
        goto L14
    L31:
        throw new IllegalArgumentException("Motion easing theme attribute must be an @interpolator resource for ?attr/motionEasing*Interpolator attributes or a string for ?attr/motionEasing* attributes.");
    }
}
