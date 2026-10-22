package com.ss.ttvideoengine.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class ScreenUtils {
    public static final int MAX_SYSTEM_BRIGHTNESS = 255;
    public static final int MIN_SYSTEM_BRIGHTNESS = 0;

    public ScreenUtils() {
    }

    public static int getScreenHeight() {
        return INVOKEVIRTUAL_com_ss_ttvideoengine_utils_ScreenUtils_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem()).heightPixels;
    }

    public static int getScreenPixelDensity() {
        return INVOKEVIRTUAL_com_ss_ttvideoengine_utils_ScreenUtils_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem()).densityDpi;
    }

    public static int getScreenWidth() {
        return INVOKEVIRTUAL_com_ss_ttvideoengine_utils_ScreenUtils_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem()).widthPixels;
    }

    public static float getScreenXdpi() {
        return INVOKEVIRTUAL_com_ss_ttvideoengine_utils_ScreenUtils_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem()).xdpi;
    }

    public static float getScreenYdpi() {
        return INVOKEVIRTUAL_com_ss_ttvideoengine_utils_ScreenUtils_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem()).ydpi;
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_ss_ttvideoengine_utils_ScreenUtils_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r1) {
        return WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics());
    }

    public static float getNormalizedBrightness(Context r1) {
        return (getSystemBrightness(r1) * 1.0f) / 255.0f;
    }

    public static Point getRealScreenSize(Context r2) {
        Point r0 = new Point();
        ((WindowManager) r2.getSystemService("window")).getDefaultDisplay().getRealSize(r0);
        return r0;
    }

    public static int getSystemBrightness(Context r1) {
        return Settings.System.getInt(r1.getContentResolver(), "screen_brightness");
    L4:
        e = move-exception;
        e.printStackTrace();
        return 0;
    }
}
