package im.quar.autolayout.utils;

import android.content.Context;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

/* JADX INFO: loaded from: classes2.dex */
public class ScreenUtils {
    public ScreenUtils() {
    }

    public static double getDevicePhysicalSize(Context r8) {
        int[] r10 = getRealScreenSize(r8);
        DisplayMetrics r11 = r8.getResources().getDisplayMetrics();
        return Math.sqrt(Math.pow(r10[1] / r11.ydpi, 2.0d) + Math.pow(r10[0] / r11.xdpi, 2.0d));
    }

    public static int[] getRealScreenSize(Context r8) {
        Display r10 = ((WindowManager) r8.getSystemService("window")).getDefaultDisplay();
        r10.getMetrics(new DisplayMetrics());
        Point r11 = new Point();
        r10.getRealSize(r11);
        return new int[]{r11.x, r11.y};
    }
}
