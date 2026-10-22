package s4;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class f {
    public static final f a = null;
    public static int b;
    public static int c;

    public f() {
    }

    static {
        a = new f();
        b = -1;
        c = -1;
    }

    public static int a(Context r1) {
        int r0 = b;
        if (r0 <= 0) goto L6;
        return r0;
    L6:
        if (r1 != null) goto L8;
        return 0;
    L8:
        c(r1);
        int r10 = b;
        if (r10 > 0) goto L11;
        return 0;
    L11:
        return r10;
    }

    public static int b(Context r1) {
        int r0 = c;
        if (r0 <= 0) goto L6;
        return r0;
    L6:
        if (r1 != null) goto L8;
        return 0;
    L8:
        c(r1);
        int r10 = c;
        if (r10 > 0) goto L11;
        return 0;
    L11:
        return r10;
    }

    public static void c(Context r10) {
        Object r0 = r10.getSystemService("window");     // Catch: Exception -> L13
        if ((r0 instanceof WindowManager) == false) goto L5;
        WindowManager r1 = (WindowManager) r0;     // Catch: Exception -> L13
    L6:
        if (r1 == null) goto L11;
        Display r11 = r1.getDefaultDisplay();     // Catch: Exception -> L13
        Point r12 = new Point();     // Catch: Exception -> L13
        if (r11 != null) goto L10;
        return;
    L10:
        r11.getRealSize(r12);     // Catch: Exception -> L13
        b = r12.y;     // Catch: Exception -> L13
        c = r12.x;     // Catch: Exception -> L13
        return;
    L11:
        Resources r13 = r10.getResources();     // Catch: Exception -> L13
        DisplayMetrics r14 = WindowDisplayMetricsOverride.apply(r13, r13.getDisplayMetrics());     // Catch: Exception -> L13
        b = r14.heightPixels;     // Catch: Exception -> L13
        c = r14.widthPixels;     // Catch: Exception -> L13
        return;
    L5:
        r1 = null;
        goto L6
    }
}
