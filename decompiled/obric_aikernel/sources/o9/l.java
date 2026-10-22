package o9;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;

/* JADX INFO: loaded from: classes2.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static TypedValue f11588a;

    public static int a(Context r10, int r11) {
        if (f11588a != null) goto L6;
        f11588a = new TypedValue();
    L6:
        if (r10.getTheme().resolveAttribute(r11, f11588a, true) == true) goto L10;
        return 0;
    L10:
        return TypedValue.complexToDimensionPixelSize(f11588a.data, h.a(r10));
    }

    public static float b(Context r10, int r11) {
        return c(r10.getTheme(), r11);
    }

    public static float c(Resources.Theme r10, int r11) {
        if (f11588a != null) goto L6;
        f11588a = new TypedValue();
    L6:
        if (r10.resolveAttribute(r11, f11588a, true) == true) goto L10;
        return -1.0f;
    L10:
        return f11588a.getFloat();
    }

    public static TypedArray d(Resources r10, Resources.Theme r11, AttributeSet r12, int[] r13) {
        if (r11 != null) goto L5;
        return r10.obtainAttributes(r12, r13);
    L5:
        return r11.obtainStyledAttributes(r12, r13, 0, 0);
    }
}
