package f0;

import android.os.Build;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static boolean a() {
        int r8 = Build.VERSION.SDK_INT;
        if (r8 < 33) goto L5;
        return true;
    L5:
        if (r8 < 32) goto L16;
        String r10 = Build.VERSION.CODENAME;
        if ("REL".equals(r10) == true) goto L12;
        Locale r11 = Locale.ROOT;
        if (r10.toUpperCase(r11).compareTo("Tiramisu".toUpperCase(r11)) < 0) goto L12;
        boolean r12 = true;
    L13:
        if (r12 == false) goto L16;
        return true;
    L12:
        r12 = false;
    L16:
        return false;
    }
}
