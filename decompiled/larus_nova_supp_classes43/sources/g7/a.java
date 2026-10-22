package g7;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import b8.b;
import com.bytedance.android.annie.bridge.method.abs.GetAppInfoResultModel;
import com.bytedance.android.annie.log.LogLevel;
import com.larus.home.impl.utils.c;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public static int a;
    public static int b;

    static {
        a = -1;
        b = -1;
    }

    public static View a(Window r10) {
        View r11 = r10.getDecorView();
        if (c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == c.a) goto L7;
        c.a(r0, "getDecorView");
    L7:
        return r11;
    }

    public static int d(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        int r0 = r10.getResources().getIdentifier("status_bar_height", "dimen", "android");
        return r10.getResources().getDimensionPixelSize(r0);
    }

    public static void e(Context r10) {
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
        a = r12.y;     // Catch: Exception -> L13
        b = r12.x;     // Catch: Exception -> L13
        return;
    L11:
        Resources r13 = r10.getResources();     // Catch: Exception -> L13
        DisplayMetrics r14 = WindowDisplayMetricsOverride.apply(r13, r13.getDisplayMetrics());     // Catch: Exception -> L13
        a = r14.heightPixels;     // Catch: Exception -> L13
        b = r14.widthPixels;     // Catch: Exception -> L13
        return;
    L5:
        r1 = null;
        goto L6
    }

    public static GetAppInfoResultModel.GetAppInfoSafeArea b(Activity r10, Context r11) {
        Intrinsics.checkNotNullParameter(r11, "applicationContext");
        if (r10 != null) goto L22;
        return null;
    L22:
    L18:
        e = move-exception;
        b8.a r12 = b8.a.a;
        b8.a.a(new b("getSafeArea", LogLevel.ERROR, e, null, 8), true);
        return null;
    L6:
        if (r10.getResources().getConfiguration().orientation != 2) goto L8;
        boolean r1 = true;
    L9:
        int r13 = f(d(r11), r11);     // Catch: Exception -> L18
        Rect r14 = new Rect();     // Catch: Exception -> L18
        a(r10.getWindow()).getWindowVisibleDisplayFrame(r14);     // Catch: Exception -> L18
        int r15 = f(a(r10.getWindow()).getHeight(), r10);     // Catch: Exception -> L18
        int r16 = f(r14.top, r11);     // Catch: Exception -> L18
        int r17 = f(r14.bottom, r11);     // Catch: Exception -> L18
        if (r15 != 0) goto L13;
        if (r16 != 0) goto L13;
        r17 = r17 + r13;     // Catch: Exception -> L18
    L13:
        int r18 = Math.max(c(r10, r11) - r17, 0);     // Catch: Exception -> L18
        if (r1 == false) goto L16;
        GetAppInfoResultModel.GetAppInfoSafeArea r19 = new GetAppInfoResultModel.GetAppInfoSafeArea();     // Catch: Exception -> L18
        r19.setMarginLeft(Integer.valueOf(r13));     // Catch: Exception -> L18
        r19.setMarginRight(Integer.valueOf(r18));     // Catch: Exception -> L18
        r19.setMarginTop(0);     // Catch: Exception -> L18
        r19.setMarginBottom(0);     // Catch: Exception -> L18
        return r19;
    L16:
        GetAppInfoResultModel.GetAppInfoSafeArea r110 = new GetAppInfoResultModel.GetAppInfoSafeArea();     // Catch: Exception -> L18
        r110.setMarginTop(Integer.valueOf(r13));     // Catch: Exception -> L18
        r110.setMarginBottom(Integer.valueOf(r18));     // Catch: Exception -> L18
        r110.setMarginRight(0);     // Catch: Exception -> L18
        r110.setMarginLeft(0);     // Catch: Exception -> L18
        return r110;
    L8:
        r1 = false;
        goto L9
    }

    public static int c(Context r10, Context r11) {
        Intrinsics.checkNotNullParameter(r11, "applicationContext");
        if (r10 != null) goto L5;
        r10 = r11;
    L5:
        int r1 = 0;
        if (r10.getResources().getConfiguration().orientation != 2) goto L8;
        boolean r12 = true;
    L9:
        int r0 = b;
        if (r0 > 0) goto L16;
        e(r10);
        r0 = b;
        if (r0 > 0) goto L16;
        r0 = 0;
    L16:
        int r13 = f(r0, r10);
        int r14 = a;
        if (r14 > 0) goto L23;
        e(r10);
        int r15 = a;
        if (r15 <= 0) goto L22;
        r1 = r15;
    L22:
        r14 = r1;
    L23:
        int r16 = f(r14, r10);
        if (r12 == false) goto L27;
        return Math.min(r13, r16);
    L27:
        return Math.max(r13, r16);
    L8:
        r12 = false;
        goto L9
    }

    public static int f(double r10, Context r11) {
        Intrinsics.checkNotNullParameter(r11, "context");
        Resources r12 = r11.getResources();
        return (int) ((r10 / ((double) WindowDisplayMetricsOverride.apply(r12, r12.getDisplayMetrics()).density)) + ((double) 0.5f));
    }
}
