package com.google.android.material.color;

import android.app.Activity;
import android.app.Application;
import android.app.UiModeManager;
import android.app.UiModeManager$ContrastChangeListener;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import androidx.annotation.ChecksSdkIntAtLeast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.room.b;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class ColorContrast {
    private static final float HIGH_CONTRAST_THRESHOLD = 0.6666667f;
    private static final float MEDIUM_CONTRAST_THRESHOLD = 0.33333334f;

    @RequiresApi(34)
    public static class ColorContrastActivityLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
        private final Set<Activity> activitiesInStack;
        private final ColorContrastOptions colorContrastOptions;

        @Nullable
        private UiModeManager$ContrastChangeListener contrastChangeListener;

        public ColorContrastActivityLifecycleCallbacks(ColorContrastOptions r5) {
            this.activitiesInStack = new LinkedHashSet();
            this.colorContrastOptions = r5;
        }

        public static /* synthetic */ Set access$000(ColorContrastActivityLifecycleCallbacks r5) {
            return r5.activitiesInStack;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(@NonNull Activity r5, @Nullable Bundle r10) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(@NonNull Activity r5) {
            this.activitiesInStack.remove(r5);
            UiModeManager r10 = (UiModeManager) r5.getSystemService("uimode");
            if (r10 != null) goto L5;
            return;
        L5:
            if (this.contrastChangeListener != null) goto L7;
            return;
        L7:
            if (this.activitiesInStack.isEmpty() == false) goto L12;
            b.e(r10, this.contrastChangeListener);
            this.contrastChangeListener = null;
            return;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(@NonNull Activity r5) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreCreated(@NonNull Activity r5, @Nullable Bundle r10) {
            UiModeManager r11 = (UiModeManager) r5.getSystemService("uimode");
            if (r11 != null) goto L5;
        L9:
            this.activitiesInStack.add(r5);
            if (r11 == null) goto L13;
            ColorContrast.applyToActivityIfAvailable(r5, this.colorContrastOptions);
            return;
        L13:
            return;
        L5:
            if (this.activitiesInStack.isEmpty() == false) goto L9;
            if (this.contrastChangeListener != null) goto L9;
            this.contrastChangeListener = new AnonymousClass1(this);
            b.f(r11, ContextCompat.getMainExecutor(r5.getApplicationContext()), this.contrastChangeListener);
            goto L9
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

    private ColorContrast() {
    }

    public static void applyToActivitiesIfAvailable(@NonNull Application r5, @NonNull ColorContrastOptions r10) {
        if (isContrastAvailable() == true) goto L5;
        return;
    L5:
        r5.registerActivityLifecycleCallbacks(new ColorContrastActivityLifecycleCallbacks(r10));
    }

    public static void applyToActivityIfAvailable(@NonNull Activity r5, @NonNull ColorContrastOptions r10) {
        if (isContrastAvailable() == true) goto L5;
        return;
    L5:
        int r11 = getContrastThemeOverlayResourceId(r5, r10);
        if (r11 == 0) goto L9;
        ThemeUtils.applyThemeOverlay(r5, r11);
        return;
    }

    private static int getContrastThemeOverlayResourceId(Context r5, ColorContrastOptions r10) {
        UiModeManager r11 = (UiModeManager) r5.getSystemService("uimode");
        if (isContrastAvailable() == false) goto L17;
        if (r11 == null) goto L17;
        float r12 = b.a(r11);
        int r13 = r10.getMediumContrastThemeOverlay();
        int r14 = r10.getHighContrastThemeOverlay();
        if (r12 < HIGH_CONTRAST_THRESHOLD) goto L13;
        if (r14 != 0) goto L11;
        return r13;
    L11:
        return r14;
    L13:
        if (r12 < MEDIUM_CONTRAST_THRESHOLD) goto L17;
        if (r13 == 0) goto L16;
        return r13;
    L16:
        return r14;
    L17:
        return 0;
    }

    @ChecksSdkIntAtLeast(api = 34)
    public static boolean isContrastAvailable() {
        if (Build.VERSION.SDK_INT < 34) goto L5;
        return true;
    L5:
        return false;
    }

    @NonNull
    public static Context wrapContextIfAvailable(@NonNull Context r5, @NonNull ColorContrastOptions r10) {
        if (isContrastAvailable() == true) goto L5;
        return r5;
    L5:
        int r11 = getContrastThemeOverlayResourceId(r5, r10);
        if (r11 != 0) goto L9;
        return r5;
    L9:
        return new ContextThemeWrapper(r5, r11);
    }
}
