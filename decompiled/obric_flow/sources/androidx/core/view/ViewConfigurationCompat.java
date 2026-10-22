package androidx.core.view;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import android.util.TypedValue;
import android.view.InputDevice;
import android.view.ViewConfiguration;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.util.Supplier;
import java.lang.reflect.Method;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class ViewConfigurationCompat {
    private static final int NO_FLING_MAX_VELOCITY = Integer.MIN_VALUE;
    private static final int NO_FLING_MIN_VELOCITY = Integer.MAX_VALUE;
    private static final int RESOURCE_ID_NOT_SUPPORTED = -1;
    private static final int RESOURCE_ID_SUPPORTED_BUT_NOT_FOUND = 0;
    private static final String TAG = "ViewConfigCompat";
    private static Method sGetScaledScrollFactorMethod;

    @RequiresApi(26)
    public static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        public static float getScaledHorizontalScrollFactor(ViewConfiguration r5) {
            return r5.getScaledHorizontalScrollFactor();
        }

        @DoNotInline
        public static float getScaledVerticalScrollFactor(ViewConfiguration r5) {
            return r5.getScaledVerticalScrollFactor();
        }
    }

    @RequiresApi(28)
    public static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        public static int getScaledHoverSlop(ViewConfiguration r5) {
            return r5.getScaledHoverSlop();
        }

        @DoNotInline
        public static boolean shouldShowMenuShortcutsWhenKeyboardPresent(ViewConfiguration r5) {
            return r5.shouldShowMenuShortcutsWhenKeyboardPresent();
        }
    }

    @RequiresApi(34)
    public static class Api34Impl {
        private Api34Impl() {
        }

        @DoNotInline
        public static int getScaledMaximumFlingVelocity(@NonNull ViewConfiguration r5, int r10, int r11, int r12) {
            return r5.getScaledMaximumFlingVelocity(r10, r11, r12);
        }

        @DoNotInline
        public static int getScaledMinimumFlingVelocity(@NonNull ViewConfiguration r5, int r10, int r11, int r12) {
            return r5.getScaledMinimumFlingVelocity(r10, r11, r12);
        }
    }

    private ViewConfigurationCompat() {
    }

    private static int getCompatFlingVelocityThreshold(Resources r5, int r10, Supplier<Integer> r11, int r12) {
        if (r10 == (-1)) goto L11;
        if (r10 == 0) goto L12;
        int r13 = r5.getDimensionPixelSize(r10);
        if (r13 >= 0) goto L9;
        return r12;
    L9:
        return r13;
    L12:
        return r12;
    L11:
        return r11.get().intValue();
    }

    private static float getLegacyScrollFactor(ViewConfiguration r5, Context r10) {
        Method r11 = sGetScaledScrollFactorMethod;
        if (r11 != null) goto L15;
    L9:
        TypedValue r12 = new TypedValue();
        if (r10.getTheme().resolveAttribute(R.attr.listPreferredItemHeight, r12, true) == true) goto L12;
        return 0.0f;
    L12:
        return r12.getDimension(r10.getResources().getDisplayMetrics());
    L15:
        return ((Integer) r11.invoke(r5, null)).intValue();
    L8:
        Log.i(TAG, "Could not find method getScaledScrollFactor() on ViewConfiguration");
        goto L9
    }

    private static int getPlatformResId(Resources r5, String r10, String r11) {
        return r5.getIdentifier(r10, r11, "android");
    }

    private static int getPreApi34MaximumFlingVelocityResId(Resources r5, int r10, int r11) {
        if (r10 == 4194304) goto L5;
        return -1;
    L5:
        if (r11 == 26) goto L7;
        return -1;
    L7:
        return getPlatformResId(r5, "config_viewMaxRotaryEncoderFlingVelocity", "dimen");
    }

    private static int getPreApi34MinimumFlingVelocityResId(Resources r5, int r10, int r11) {
        if (r10 == 4194304) goto L5;
        return -1;
    L5:
        if (r11 == 26) goto L7;
        return -1;
    L7:
        return getPlatformResId(r5, "config_viewMinRotaryEncoderFlingVelocity", "dimen");
    }

    public static float getScaledHorizontalScrollFactor(@NonNull ViewConfiguration r5, @NonNull Context r10) {
        return Api26Impl.getScaledHorizontalScrollFactor(r5);
    }

    public static int getScaledHoverSlop(@NonNull ViewConfiguration r5) {
        return Api28Impl.getScaledHoverSlop(r5);
    }

    public static int getScaledMaximumFlingVelocity(@NonNull Context r5, @NonNull ViewConfiguration r10, int r11, int r12, int r13) {
        if (Build.VERSION.SDK_INT < 34) goto L7;
        return Api34Impl.getScaledMaximumFlingVelocity(r10, r11, r12, r13);
    L7:
        if (isInputDeviceInfoValid(r11, r12, r13) == true) goto L9;
        return Integer.MIN_VALUE;
    L9:
        Resources r14 = r5.getResources();
        int r15 = getPreApi34MaximumFlingVelocityResId(r14, r13, r12);
        Objects.requireNonNull(r10);
        return getCompatFlingVelocityThreshold(r14, r15, new k(r10, 0), Integer.MIN_VALUE);
    }

    public static int getScaledMinimumFlingVelocity(@NonNull Context r5, @NonNull ViewConfiguration r10, int r11, int r12, int r13) {
        if (Build.VERSION.SDK_INT < 34) goto L7;
        return Api34Impl.getScaledMinimumFlingVelocity(r10, r11, r12, r13);
    L7:
        if (isInputDeviceInfoValid(r11, r12, r13) == true) goto L9;
        return Integer.MAX_VALUE;
    L9:
        Resources r14 = r5.getResources();
        int r15 = getPreApi34MinimumFlingVelocityResId(r14, r13, r12);
        Objects.requireNonNull(r10);
        return getCompatFlingVelocityThreshold(r14, r15, new k(r10, 1), Integer.MAX_VALUE);
    }

    @Deprecated
    public static int getScaledPagingTouchSlop(ViewConfiguration r5) {
        return r5.getScaledPagingTouchSlop();
    }

    public static float getScaledVerticalScrollFactor(@NonNull ViewConfiguration r5, @NonNull Context r10) {
        return Api26Impl.getScaledVerticalScrollFactor(r5);
    }

    @Deprecated
    public static boolean hasPermanentMenuKey(ViewConfiguration r5) {
        return r5.hasPermanentMenuKey();
    }

    private static boolean isInputDeviceInfoValid(int r5, int r10, int r11) {
        InputDevice r12 = InputDevice.getDevice(r5);
        if (r12 != null) goto L5;
    L7:
        return false;
    L5:
        if (r12.getMotionRange(r10, r11) == null) goto L7;
        return true;
    }

    public static boolean shouldShowMenuShortcutsWhenKeyboardPresent(@NonNull ViewConfiguration r5, @NonNull Context r10) {
        return Api28Impl.shouldShowMenuShortcutsWhenKeyboardPresent(r5);
    }
}
