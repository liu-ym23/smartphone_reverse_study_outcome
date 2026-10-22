package kl;

import android.R;
import android.app.Activity;
import android.content.res.Resources;
import android.os.Build;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.DisplayCutout;
import android.view.Window;
import android.view.WindowInsets;
import androidx.fragment.app.FragmentActivity;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f18653a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f18654b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f18655c;
    public final int d;
    public final boolean e;
    public final float f;

    public a(FragmentActivity r10) {
        if (r10.getResources().getConfiguration().orientation != 1) goto L5;
        boolean r5 = true;
    L6:
        this.e = r5;
        DisplayMetrics r11 = new DisplayMetrics();
        r10.getWindowManager().getDefaultDisplay().getRealMetrics(r11);
        float r12 = r11.widthPixels;
        float r13 = r11.density;
        this.f = Math.min(r12 / r13, r11.heightPixels / r13);
        this.f18653a = a(r10, "status_bar_height");
        TypedValue r14 = new TypedValue();
        r10.getTheme().resolveAttribute(R.attr.actionBarSize, r14, true);
        TypedValue.complexToDimensionPixelSize(r14.data, r10.getResources().getDisplayMetrics());
        if (b(r10) == false) goto L12;
        if (r5 == false) goto L10;
        String r15 = "navigation_bar_height";
    L11:
        int r16 = a(r10, r15);
    L13:
        this.f18655c = r16;
        if (b(r10) == false) goto L16;
        int r17 = a(r10, "navigation_bar_width");
    L17:
        this.d = r17;
        if (r16 <= 0) goto L20;
        boolean r18 = true;
    L21:
        this.f18654b = r18;
        if (td.d.f22128c == false) goto L25;
        return;
    L25:
        if ("Xiaomi".equals(Build.MANUFACTURER) == true) goto L54;
    L28:
        int r19 = 0;
    L29:
        if (r19 == 1) goto L51;
        DisplayCutout r20 = null;
        Class<?> r21 = r10.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");     // Catch: Throwable -> L34
        boolean r22 = ((Boolean) r21.getMethod("hasNotchInScreen", null).invoke(r21, null)).booleanValue();     // Catch: Throwable -> L34
    L35:
        if (r22 == true) goto L51;
        boolean r23 = r10.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");     // Catch: Exception -> L38
    L39:
        if (r23 == true) goto L51;
        Class<?> r24 = r10.getClassLoader().loadClass("android.util.FtFeature");     // Catch: Throwable -> L42
        boolean r25 = ((Boolean) r24.getMethod("isFeatureSupport", new Class[]{Integer.TYPE}).invoke(r24, new Object[]{32})).booleanValue();     // Catch: Throwable -> L42
    L43:
        if (r25 == true) goto L51;
        Window r26 = r10.getWindow();
        if (r26 == null) goto L49;
        WindowInsets r27 = r26.getDecorView().getRootWindowInsets();
        if (r27 == null) goto L49;
        r20 = r27.getDisplayCutout();
    L49:
        if (r20 == null) goto L51;
    L42:
        r25 = false;
    L38:
        r23 = false;
    L34:
        r22 = false;
    L51:
        td.d.f22128c = true;
        return;
    L54:
        Class<?> r28 = r10.getClassLoader().loadClass("android.os.SystemProperties");     // Catch: Throwable -> L53
        r19 = ((Integer) r28.getMethod("getInt", new Class[]{String.class, Integer.TYPE}).invoke(r28, new Object[]{"ro.miui.notch", 0})).intValue();     // Catch: Throwable -> L53
    L20:
        r18 = false;
        goto L21
    L16:
        r17 = 0;
        goto L17
    L10:
        r15 = "navigation_bar_height_landscape";
        goto L11
    L12:
        r16 = 0;
        goto L13
    L5:
        r5 = false;
        goto L6
    }

    public static int a(Activity r5, String r10) {
        int r11 = Resources.getSystem().getIdentifier(r10, "dimen", "android");     // Catch: Resources.NotFoundException -> L11
        if (r11 <= 0) goto L10;
        int r12 = r5.getResources().getDimensionPixelSize(r11);     // Catch: Resources.NotFoundException -> L11
        int r13 = Resources.getSystem().getDimensionPixelSize(r11);     // Catch: Resources.NotFoundException -> L11
        if (r13 < r12) goto L8;
        return r13;
    L8:
        return Math.round((r12 * Resources.getSystem().getDisplayMetrics().density) / r5.getResources().getDisplayMetrics().density);
    L10:
        return 0;
    }

    public static boolean b(FragmentActivity r5) {
        if (Settings.Global.getInt(r5.getContentResolver(), "force_fsg_nav_bar", 0) == 0) goto L5;
        return false;
    L5:
        Display r10 = r5.getWindowManager().getDefaultDisplay();
        DisplayMetrics r11 = new DisplayMetrics();
        r10.getRealMetrics(r11);
        int r12 = r11.heightPixels;
        int r13 = r11.widthPixels;
        DisplayMetrics r14 = new DisplayMetrics();
        r10.getMetrics(r14);
        int r15 = r14.heightPixels;
        if ((r13 - r14.widthPixels) <= 0) goto L8;
    L9:
        return true;
    L8:
        if ((r12 - r15) > 0) goto L9;
        return false;
    }

    public final boolean c() {
        if (this.f < 600.0f) goto L5;
    L8:
        return true;
    L5:
        if (this.e == true) goto L8;
        return false;
    }
}
