package l2;

import android.content.Context;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f19515a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f19516b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f19517c = -1;

    static {
        f19515a = new c();
    }

    public static void a(Context r5) {
        Object r10 = r5.getSystemService("window");     // Catch: Exception -> L14
        if ((r10 instanceof WindowManager) == false) goto L5;
        WindowManager r11 = (WindowManager) r10;     // Catch: Exception -> L14
    L6:
        if (r11 == null) goto L12;
        Display r12 = r11.getDefaultDisplay();     // Catch: Exception -> L14
        Point r13 = new Point();     // Catch: Exception -> L14
        if (r12 == null) goto L16;
        r12.getRealSize(r13);     // Catch: Exception -> L14
        f19516b = r13.y;     // Catch: Exception -> L14
        f19517c = r13.x;     // Catch: Exception -> L14
        return;
    L16:
        return;
    L12:
        DisplayMetrics r14 = r5.getResources().getDisplayMetrics();     // Catch: Exception -> L14
        f19516b = r14.heightPixels;     // Catch: Exception -> L14
        f19517c = r14.widthPixels;     // Catch: Exception -> L14
        return;
    L5:
        r11 = null;
        goto L6
    }
}
