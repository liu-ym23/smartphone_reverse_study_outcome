package com.google.android.material.color;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.app.UiModeManager;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import androidx.annotation.ChecksSdkIntAtLeast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.core.os.BuildCompat;
import androidx.room.b;
import com.google.android.material.R;
import com.google.android.material.color.utilities.Hct;
import com.google.android.material.color.utilities.SchemeContent;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class DynamicColors {
    private static final DeviceSupportCondition DEFAULT_DEVICE_SUPPORT_CONDITION = null;
    private static final Map<String, DeviceSupportCondition> DYNAMIC_COLOR_SUPPORTED_BRANDS = null;
    private static final Map<String, DeviceSupportCondition> DYNAMIC_COLOR_SUPPORTED_MANUFACTURERS = null;
    private static final int[] DYNAMIC_COLOR_THEME_OVERLAY_ATTRIBUTE = null;

    @SuppressLint({"PrivateApi"})
    private static final DeviceSupportCondition SAMSUNG_DEVICE_SUPPORT_CONDITION = null;
    private static final String TAG = null;
    private static final int USE_DEFAULT_THEME_OVERLAY = 0;

    public interface DeviceSupportCondition {
        boolean isSupported();
    }

    public static class DynamicColorsActivityLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
        private final DynamicColorsOptions dynamicColorsOptions;

        public DynamicColorsActivityLifecycleCallbacks(@NonNull DynamicColorsOptions r5) {
            this.dynamicColorsOptions = r5;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(@NonNull Activity r5, @Nullable Bundle r10) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(@NonNull Activity r5) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(@NonNull Activity r5) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreCreated(@NonNull Activity r5, @Nullable Bundle r10) {
            DynamicColors.applyToActivityIfAvailable(r5, this.dynamicColorsOptions);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(@NonNull Activity r5) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(@NonNull Activity r5, @NonNull Bundle r10) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(@NonNull Activity r5) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(@NonNull Activity r5) {
        }
    }

    public interface OnAppliedCallback {
        void onApplied(@NonNull Activity r5);
    }

    public interface Precondition {
        boolean shouldApplyDynamicColors(@NonNull Activity r5, @StyleRes int r10);
    }

    static {
        DYNAMIC_COLOR_THEME_OVERLAY_ATTRIBUTE = new int[]{R.attr.dynamicColorThemeOverlay};
        DeviceSupportCondition r5 = new AnonymousClass1();
        DEFAULT_DEVICE_SUPPORT_CONDITION = r5;
        DeviceSupportCondition r10 = new AnonymousClass2();
        SAMSUNG_DEVICE_SUPPORT_CONDITION = r10;
        HashMap r11 = new HashMap();
        r11.put("fcnt", r5);
        r11.put("google", r5);
        r11.put("hmd global", r5);
        r11.put("infinix", r5);
        r11.put("infinix mobility limited", r5);
        r11.put("itel", r5);
        r11.put("kyocera", r5);
        r11.put("lenovo", r5);
        r11.put("lge", r5);
        r11.put("meizu", r5);
        r11.put("motorola", r5);
        r11.put("nothing", r5);
        r11.put("oneplus", r5);
        r11.put("oppo", r5);
        r11.put("realme", r5);
        r11.put("robolectric", r5);
        r11.put("samsung", r10);
        r11.put("sharp", r5);
        r11.put("shift", r5);
        r11.put("sony", r5);
        r11.put("tcl", r5);
        r11.put("tecno", r5);
        r11.put("tecno mobile limited", r5);
        r11.put("vivo", r5);
        r11.put("wingtech", r5);
        r11.put("xiaomi", r5);
        DYNAMIC_COLOR_SUPPORTED_MANUFACTURERS = Collections.unmodifiableMap(r11);
        HashMap r12 = new HashMap();
        r12.put("asus", r5);
        r12.put("jio", r5);
        DYNAMIC_COLOR_SUPPORTED_BRANDS = Collections.unmodifiableMap(r12);
        TAG = "DynamicColors";
    }

    private DynamicColors() {
    }

    @Deprecated
    public static void applyIfAvailable(@NonNull Activity r5) {
        applyToActivityIfAvailable(r5);
    }

    public static void applyToActivitiesIfAvailable(@NonNull Application r5) {
        applyToActivitiesIfAvailable(r5, new DynamicColorsOptions.Builder().build());
    }

    public static void applyToActivityIfAvailable(@NonNull Activity r5) {
        applyToActivityIfAvailable(r5, new DynamicColorsOptions.Builder().build());
    }

    private static int getDefaultThemeOverlay(@NonNull Context r5, int[] r10) {
        TypedArray r11 = r5.obtainStyledAttributes(r10);
        int r12 = r11.getResourceId(0, 0);
        r11.recycle();
        return r12;
    }

    private static float getSystemContrast(Context r5) {
        UiModeManager r10 = (UiModeManager) r5.getSystemService("uimode");
        if (r10 != null) goto L5;
    L8:
        return 0.0f;
    L5:
        if (Build.VERSION.SDK_INT < 34) goto L8;
        return b.a(r10);
    }

    @ChecksSdkIntAtLeast(api = 31)
    @SuppressLint({"DefaultLocale"})
    public static boolean isDynamicColorAvailable() {
        if (BuildCompat.isAtLeastT() == false) goto L5;
        return true;
    L5:
        Map<String, DeviceSupportCondition> r5 = DYNAMIC_COLOR_SUPPORTED_MANUFACTURERS;
        String r10 = Build.MANUFACTURER;
        Locale r11 = Locale.ROOT;
        DeviceSupportCondition r12 = r5.get(r10.toLowerCase(r11));
        if (r12 != null) goto L8;
        r12 = DYNAMIC_COLOR_SUPPORTED_BRANDS.get(Build.BRAND.toLowerCase(r11));
    L8:
        if (r12 != null) goto L10;
    L12:
        return false;
    L10:
        if (r12.isSupported() == false) goto L12;
        return true;
    }

    @NonNull
    public static Context wrapContextIfAvailable(@NonNull Context r5) {
        return wrapContextIfAvailable(r5, 0);
    }

    @Deprecated
    public static void applyIfAvailable(@NonNull Activity r5, @StyleRes int r10) {
        applyToActivityIfAvailable(r5, new DynamicColorsOptions.Builder().setThemeOverlay(r10).build());
    }

    @Deprecated
    public static void applyToActivitiesIfAvailable(@NonNull Application r5, @StyleRes int r10) {
        applyToActivitiesIfAvailable(r5, new DynamicColorsOptions.Builder().setThemeOverlay(r10).build());
    }

    public static void applyToActivityIfAvailable(@NonNull Activity r5, @NonNull DynamicColorsOptions r10) {
        if (isDynamicColorAvailable() == true) goto L6;
        return;
    L6:
        if (r10.getContentBasedSeedColor() == null) goto L8;
        int r11 = 0;
    L13:
        if (r10.getPrecondition().shouldApplyDynamicColors(r5, r11) == true) goto L15;
        return;
    L15:
        if (r10.getContentBasedSeedColor() == null) goto L22;
        SchemeContent r12 = new SchemeContent(Hct.fromInt(r10.getContentBasedSeedColor().intValue()), !MaterialColors.isLightTheme(r5), getSystemContrast(r5));
        ColorResourcesOverride r13 = ColorResourcesOverride.getInstance();
        if (r13 != null) goto L20;
        return;
    L20:
        if (r13.applyIfPossible(r5, MaterialColorUtilitiesHelper.createColorResourcesIdsToColorValues(r12)) == true) goto L23;
        return;
    L23:
        r10.getOnAppliedCallback().onApplied(r5);
        return;
    L22:
        ThemeUtils.applyThemeOverlay(r5, r11);
        goto L23
    L8:
        if (r10.getThemeOverlay() != 0) goto L10;
        r11 = getDefaultThemeOverlay(r5, DYNAMIC_COLOR_THEME_OVERLAY_ATTRIBUTE);
        goto L13
    L10:
        r11 = r10.getThemeOverlay();
        goto L13
    }

    @NonNull
    public static Context wrapContextIfAvailable(@NonNull Context r5, @StyleRes int r10) {
        return wrapContextIfAvailable(r5, new DynamicColorsOptions.Builder().setThemeOverlay(r10).build());
    }

    @Deprecated
    public static void applyIfAvailable(@NonNull Activity r5, @NonNull Precondition r10) {
        applyToActivityIfAvailable(r5, new DynamicColorsOptions.Builder().setPrecondition(r10).build());
    }

    @Deprecated
    public static void applyToActivitiesIfAvailable(@NonNull Application r5, @NonNull Precondition r10) {
        applyToActivitiesIfAvailable(r5, new DynamicColorsOptions.Builder().setPrecondition(r10).build());
    }

    @NonNull
    public static Context wrapContextIfAvailable(@NonNull Context r5, @NonNull DynamicColorsOptions r10) {
        if (isDynamicColorAvailable() == true) goto L5;
        return r5;
    L5:
        int r11 = r10.getThemeOverlay();
        if (r11 != 0) goto L8;
        r11 = getDefaultThemeOverlay(r5, DYNAMIC_COLOR_THEME_OVERLAY_ATTRIBUTE);
    L8:
        if (r11 != 0) goto L11;
        return r5;
    L11:
        if (r10.getContentBasedSeedColor() == null) goto L17;
        SchemeContent r12 = new SchemeContent(Hct.fromInt(r10.getContentBasedSeedColor().intValue()), !MaterialColors.isLightTheme(r5), getSystemContrast(r5));
        ColorResourcesOverride r13 = ColorResourcesOverride.getInstance();
        if (r13 == null) goto L17;
        return r13.wrapContextIfPossible(r5, MaterialColorUtilitiesHelper.createColorResourcesIdsToColorValues(r12));
    L17:
        return new ContextThemeWrapper(r5, r11);
    }

    @Deprecated
    public static void applyToActivitiesIfAvailable(@NonNull Application r5, @StyleRes int r10, @NonNull Precondition r11) {
        applyToActivitiesIfAvailable(r5, new DynamicColorsOptions.Builder().setThemeOverlay(r10).setPrecondition(r11).build());
    }

    public static void applyToActivitiesIfAvailable(@NonNull Application r5, @NonNull DynamicColorsOptions r10) {
        r5.registerActivityLifecycleCallbacks(new DynamicColorsActivityLifecycleCallbacks(r10));
    }
}
