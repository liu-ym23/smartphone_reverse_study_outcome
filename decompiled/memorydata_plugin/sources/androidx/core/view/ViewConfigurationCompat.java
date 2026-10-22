package androidx.core.view;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import android.util.TypedValue;
import android.view.InputDevice;
import android.view.ViewConfiguration;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public final class ViewConfigurationCompat {
    private static final String TAG = "ViewConfigCompat";
    private static Method sGetScaledScrollFactorMethod;

    static class Api26Impl {
        private Api26Impl() {
        }

        static float getScaledHorizontalScrollFactor(ViewConfiguration r0) {
            return r0.getScaledHorizontalScrollFactor();
        }

        static float getScaledVerticalScrollFactor(ViewConfiguration r0) {
            return r0.getScaledVerticalScrollFactor();
        }
    }

    static class Api28Impl {
        private Api28Impl() {
        }

        static int getScaledHoverSlop(ViewConfiguration r0) {
            return r0.getScaledHoverSlop();
        }

        static boolean shouldShowMenuShortcutsWhenKeyboardPresent(ViewConfiguration r0) {
            return r0.shouldShowMenuShortcutsWhenKeyboardPresent();
        }
    }

    static class Api34Impl {
        private Api34Impl() {
        }

        static int getScaledMaximumFlingVelocity(ViewConfiguration r0, int r1, int r2, int r3) {
            return r0.getScaledMaximumFlingVelocity(r1, r2, r3);
        }

        static int getScaledMinimumFlingVelocity(ViewConfiguration r0, int r1, int r2, int r3) {
            return r0.getScaledMinimumFlingVelocity(r1, r2, r3);
        }
    }

    static {
        if (Build.VERSION.SDK_INT != 25) goto L10;
        sGetScaledScrollFactorMethod = ViewConfiguration.class.getDeclaredMethod("getScaledScrollFactor", new Class[0]);     // Catch: Exception -> L6
        return;
    L6:
        Log.i(TAG, "Could not find method getScaledScrollFactor() on ViewConfiguration");
        return;
    }

    private ViewConfigurationCompat() {
    }

    private static float getLegacyScrollFactor(ViewConfiguration r4, Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 25) goto L11;
        Method r0 = sGetScaledScrollFactorMethod;
        if (r0 == null) goto L11;
        return ((Integer) ZeusTransformUtils.preCheckCast(r0.invoke(r4, new Object[0]), Integer.class, "com.obric.memorydata.plugin")).intValue();
    L10:
        Log.i(TAG, "Could not find method getScaledScrollFactor() on ViewConfiguration");
    L11:
        TypedValue r7 = new TypedValue();
        if (r6.getTheme().resolveAttribute(R.attr.listPreferredItemHeight, r7, true) == true) goto L14;
        return 0.0f;
    L14:
        return r7.getDimension(ZeusTransformUtils.getResources(r6, "com.obric.memorydata.plugin").getDisplayMetrics());
    }

    private static int getPlatformResId(Resources r2, String r3, String r4) {
        return ZeusTransformUtils.getIdentifier(r2, r3, r4, "android", "com.obric.memorydata.plugin");
    }

    private static int getPreApi34MaximumFlingVelocityResId(Resources r1, int r2, int r3) {
        if (r2 == 4194304) goto L5;
        return 0;
    L5:
        if (r3 == 26) goto L7;
        return 0;
    L7:
        return getPlatformResId(r1, "config_viewMaxRotaryEncoderFlingVelocity", "dimen");
    }

    private static int getPreApi34MinimumFlingVelocityResId(Resources r1, int r2, int r3) {
        if (r2 == 4194304) goto L5;
        return 0;
    L5:
        if (r3 == 26) goto L7;
        return 0;
    L7:
        return getPlatformResId(r1, "config_viewMinRotaryEncoderFlingVelocity", "dimen");
    }

    public static float getScaledHorizontalScrollFactor(ViewConfiguration r2, Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 26) goto L7;
        return Api26Impl.getScaledHorizontalScrollFactor(r2);
    L7:
        return getLegacyScrollFactor(r2, r4);
    }

    public static int getScaledHoverSlop(ViewConfiguration r2) {
        if (Build.VERSION.SDK_INT < 28) goto L7;
        return Api28Impl.getScaledHoverSlop(r2);
    L7:
        return r2.getScaledTouchSlop() / 2;
    }

    public static int getScaledMaximumFlingVelocity(Context r3, ViewConfiguration r4, int r5, int r6, int r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 34) goto L7;
        return Api34Impl.getScaledMaximumFlingVelocity(r4, r5, r6, r7);
    L7:
        if (isInputDeviceInfoValid(r5, r6, r7) == true) goto L9;
        return Integer.MIN_VALUE;
    L9:
        Resources r9 = ZeusTransformUtils.getResources(r8, "com.obric.memorydata.plugin");
        int r10 = getPreApi34MaximumFlingVelocityResId(r9, r7, r6);
        if (r10 == 0) goto L17;
        int r11 = r9.getDimensionPixelSize(r10);
        if (r11 >= 0) goto L15;
        return Integer.MIN_VALUE;
    L15:
        return r11;
    L17:
        return r4.getScaledMaximumFlingVelocity();
    }

    public static int getScaledMinimumFlingVelocity(Context r3, ViewConfiguration r4, int r5, int r6, int r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 34) goto L7;
        return Api34Impl.getScaledMinimumFlingVelocity(r4, r5, r6, r7);
    L7:
        if (isInputDeviceInfoValid(r5, r6, r7) == true) goto L9;
        return Integer.MAX_VALUE;
    L9:
        Resources r9 = ZeusTransformUtils.getResources(r8, "com.obric.memorydata.plugin");
        int r10 = getPreApi34MinimumFlingVelocityResId(r9, r7, r6);
        if (r10 == 0) goto L17;
        int r11 = r9.getDimensionPixelSize(r10);
        if (r11 >= 0) goto L15;
        return Integer.MAX_VALUE;
    L15:
        return r11;
    L17:
        return r4.getScaledMinimumFlingVelocity();
    }

    @Deprecated
    public static int getScaledPagingTouchSlop(ViewConfiguration r0) {
        return r0.getScaledPagingTouchSlop();
    }

    public static float getScaledVerticalScrollFactor(ViewConfiguration r2, Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 26) goto L7;
        return Api26Impl.getScaledVerticalScrollFactor(r2);
    L7:
        return getLegacyScrollFactor(r2, r4);
    }

    @Deprecated
    public static boolean hasPermanentMenuKey(ViewConfiguration r0) {
        return r0.hasPermanentMenuKey();
    }

    private static boolean isInputDeviceInfoValid(int r0, int r1, int r2) {
        InputDevice r3 = InputDevice.getDevice(r0);
        if (r3 != null) goto L5;
    L7:
        return false;
    L5:
        if (r3.getMotionRange(r1, r2) == null) goto L7;
        return true;
    }

    public static boolean shouldShowMenuShortcutsWhenKeyboardPresent(ViewConfiguration r3, Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT >= 28) goto L5;
        Resources r6 = ZeusTransformUtils.getResources(r5, "com.obric.memorydata.plugin");
        int r7 = getPlatformResId(r6, "config_showMenuShortcutsWhenKeyboardPresent", "bool");
        if (r7 != 0) goto L9;
    L11:
        return false;
    L9:
        if (r6.getBoolean(r7) == false) goto L11;
        return true;
    L5:
        return Api28Impl.shouldShowMenuShortcutsWhenKeyboardPresent(r3);
    }
}
