package v2c;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.desktopmode.utils.DesktopUtil;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a {
    public static int d(Context r1) {
        DesktopUtil.a(r1);
        WindowManager r2 = (WindowManager) r1.getSystemService("window");
        DisplayMetrics r0 = new DisplayMetrics();
        r2.getDefaultDisplay().getRealMetrics(r0);
        return r0.heightPixels;
    }

    public static Resources getResources(Context r0) {
        return r0.getResources();
    }

    public static int a(Context r1, float r2) {
        Resources r3 = r1.getResources();
        return (int) ((r2 * WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics()).density) + 0.5f);
    }

    public static int b(Context r0, int r1) {
        return getResources(r0).getColor(r1);
    }

    public static Drawable c(Context r0, int r1) {
        return getResources(r0).getDrawable(r1);
    }

    public static String e(Context r3, String r4) {
        String r5 = getResources(r3).getString(2131892095);
        if (r4 != null) goto L6;
        return r5;
    L6:
        return r5.replace(String.format("{{%s}}", new Object[]{"count"}), r4);
    }
}
