package x9;

import android.content.Context;
import android.util.TypedValue;

/* JADX INFO: loaded from: classes.dex */
public final class b {
    public static TypedValue a(Context r8, int r10) {
        TypedValue r11 = new TypedValue();
        if (r8.getTheme().resolveAttribute(r10, r11, true) == false) goto L5;
        return r11;
    L5:
        return null;
    }

    public static boolean b(Context r8, boolean r10, int r11) {
        TypedValue r12 = a(r8, r11);
        if (r12 != null) goto L5;
        return r10;
    L5:
        if (r12.type == 18) goto L7;
        return r10;
    L7:
        if (r12.data == 0) goto L9;
        return true;
    L9:
        return false;
    }

    public static TypedValue c(Context r8, int r10, String r11) {
        TypedValue r12 = a(r8, r10);
        if (r12 == null) goto L6;
        return r12;
    L6:
        throw new IllegalArgumentException(String.format("%1$s requires a value for the %2$s attribute to be set in your app theme. You can either set the attribute in your theme or update your theme to inherit from Theme.MaterialComponents (or a descendant).", new Object[]{r11, r8.getResources().getResourceName(r10)}));
    }
}
