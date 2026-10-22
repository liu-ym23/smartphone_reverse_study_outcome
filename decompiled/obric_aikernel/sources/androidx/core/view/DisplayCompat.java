package androidx.core.view;

import android.annotation.SuppressLint;
import android.app.UiModeManager;
import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.text.TextUtils;
import android.view.Display;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.util.Preconditions;

/* JADX INFO: loaded from: classes.dex */
public final class DisplayCompat {
    private static final int DISPLAY_SIZE_4K_HEIGHT = 2160;
    private static final int DISPLAY_SIZE_4K_WIDTH = 3840;

    @RequiresApi(17)
    static class Api17Impl {
        private Api17Impl() {
        }

        static void getRealSize(Display r10, Point r11) {
            r10.getRealSize(r11);
        }
    }

    @RequiresApi(23)
    static class Api23Impl {
        private Api23Impl() {
        }

        @NonNull
        static ModeCompat getMode(@NonNull Context r10, @NonNull Display r11) {
            Display.Mode r12 = r11.getMode();
            Point r13 = DisplayCompat.getCurrentDisplaySizeFromWorkarounds(r10, r11);
            if (r13 == null) goto L9;
            if (physicalSizeEquals(r12, r13) == true) goto L9;
            return new ModeCompat(r12, r13);
        L9:
            return new ModeCompat(r12, true);
        }

        @NonNull
        @SuppressLint({"ArrayReturn"})
        public static ModeCompat[] getSupportedModes(@NonNull Context r10, @NonNull Display r11) {
            Display.Mode[] r12 = r11.getSupportedModes();
            ModeCompat[] r13 = new ModeCompat[r12.length];
            Display.Mode r14 = r11.getMode();
            Point r15 = DisplayCompat.getCurrentDisplaySizeFromWorkarounds(r10, r11);
            int r16 = 0;
            if (r15 == null) goto L16;
            if (physicalSizeEquals(r14, r15) == true) goto L16;
            int r17 = 0;
        L9:
            if (r17 >= r12.length) goto L18;
            if (physicalSizeEquals(r12[r17], r14) == false) goto L13;
            ModeCompat r18 = new ModeCompat(r12[r17], r15);
        L14:
            r13[r17] = r18;
            r17 = r17 + 1;
            goto L9
        L13:
            r18 = new ModeCompat(r12[r17], false);
        L18:
            return r13;
        L16:
            if (r16 >= r12.length) goto L18;
            r13[r16] = new ModeCompat(r12[r16], physicalSizeEquals(r12[r16], r14));
            r16 = r16 + 1;
            goto L16
        }

        static boolean isCurrentModeTheLargestMode(@NonNull Display r10) {
            Display.Mode r11 = r10.getMode();
            Display.Mode[] r12 = r10.getSupportedModes();
            int r13 = r12.length;
            int r14 = 0;
        L3:
            if (r14 >= r13) goto L11;
            Display.Mode r15 = r12[r14];
            if (r11.getPhysicalHeight() < r15.getPhysicalHeight()) goto L10;
            if (r11.getPhysicalWidth() < r15.getPhysicalWidth()) goto L10;
            r14 = r14 + 1;
        L10:
            return false;
        L11:
            return true;
        }

        static boolean physicalSizeEquals(Display.Mode r10, Point r11) {
            if (r10.getPhysicalWidth() != r11.x) goto L7;
            if (r10.getPhysicalHeight() != r11.y) goto L7;
        L10:
            return true;
        L7:
            if (r10.getPhysicalWidth() == r11.y) goto L9;
        L11:
            return false;
        L9:
            if (r10.getPhysicalHeight() != r11.x) goto L11;
            goto L10
        }

        static boolean physicalSizeEquals(Display.Mode r10, Display.Mode r11) {
            if (r10.getPhysicalWidth() == r11.getPhysicalWidth()) goto L5;
        L7:
            return false;
        L5:
            if (r10.getPhysicalHeight() != r11.getPhysicalHeight()) goto L7;
            return true;
        }
    }

    public static final class ModeCompat {
        private final boolean mIsNative;
        private final Display.Mode mMode;
        private final Point mPhysicalSize;

        @RequiresApi(23)
        static class Api23Impl {
            private Api23Impl() {
            }

            @DoNotInline
            static int getPhysicalHeight(Display.Mode r10) {
                return r10.getPhysicalHeight();
            }

            @DoNotInline
            static int getPhysicalWidth(Display.Mode r10) {
                return r10.getPhysicalWidth();
            }
        }

        ModeCompat(@NonNull Point r10) {
            Preconditions.checkNotNull(r10, "physicalSize == null");
            this.mPhysicalSize = r10;
            this.mMode = null;
            this.mIsNative = true;
        }

        @RequiresApi(23)
        ModeCompat(@NonNull Display.Mode r10, @NonNull Point r11) {
            Preconditions.checkNotNull(r10, "mode == null, can't wrap a null reference");
            Preconditions.checkNotNull(r11, "physicalSize == null");
            this.mPhysicalSize = r11;
            this.mMode = r10;
            this.mIsNative = true;
        }

        @RequiresApi(23)
        ModeCompat(@NonNull Display.Mode r10, boolean r11) {
            Preconditions.checkNotNull(r10, "mode == null, can't wrap a null reference");
            this.mPhysicalSize = new Point(Api23Impl.getPhysicalWidth(r10), Api23Impl.getPhysicalHeight(r10));
            this.mMode = r10;
            this.mIsNative = r11;
        }

        public int getPhysicalHeight() {
            return this.mPhysicalSize.y;
        }

        public int getPhysicalWidth() {
            return this.mPhysicalSize.x;
        }

        @Deprecated
        public boolean isNative() {
            return this.mIsNative;
        }

        @Nullable
        @RequiresApi(23)
        public Display.Mode toMode() {
            return this.mMode;
        }
    }

    private DisplayCompat() {
    }

    static Point getCurrentDisplaySizeFromWorkarounds(@NonNull Context r10, @NonNull Display r11) {
        if (Build.VERSION.SDK_INT >= 28) goto L5;
        String r12 = "sys.display-size";
    L6:
        Point r13 = parsePhysicalDisplaySizeFromSystemProperties(r12, r11);
        if (r13 == null) goto L10;
        return r13;
    L10:
        if (isSonyBravia4kTv(r10) == true) goto L12;
        return null;
    L12:
        if (isCurrentModeTheLargestMode(r11) == true) goto L14;
        return null;
    L14:
        return new Point(DISPLAY_SIZE_4K_WIDTH, DISPLAY_SIZE_4K_HEIGHT);
    L5:
        r12 = "vendor.display-size";
        goto L6
    }

    @NonNull
    private static Point getDisplaySize(@NonNull Context r10, @NonNull Display r11) {
        Point r12 = getCurrentDisplaySizeFromWorkarounds(r10, r11);
        if (r12 == null) goto L5;
        return r12;
    L5:
        Point r13 = new Point();
        if (Build.VERSION.SDK_INT < 17) goto L8;
        Api17Impl.getRealSize(r11, r13);
    L9:
        return r13;
    L8:
        r11.getSize(r13);
        goto L9
    }

    @NonNull
    public static ModeCompat getMode(@NonNull Context r10, @NonNull Display r11) {
        if (Build.VERSION.SDK_INT < 23) goto L7;
        return Api23Impl.getMode(r10, r11);
    L7:
        return new ModeCompat(getDisplaySize(r10, r11));
    }

    @NonNull
    @SuppressLint({"ArrayReturn"})
    public static ModeCompat[] getSupportedModes(@NonNull Context r10, @NonNull Display r11) {
        if (Build.VERSION.SDK_INT < 23) goto L7;
        return Api23Impl.getSupportedModes(r10, r11);
    L7:
        return new ModeCompat[]{getMode(r10, r11)};
    }

    @Nullable
    private static String getSystemProperty(String r10) {
        Class<?> r11 = Class.forName("android.os.SystemProperties");     // Catch: Exception -> L4
        return (String) r11.getMethod("get", new Class[]{String.class}).invoke(r11, new Object[]{r10});
    L4:
        return null;
    }

    static boolean isCurrentModeTheLargestMode(@NonNull Display r10) {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        return true;
    L5:
        return Api23Impl.isCurrentModeTheLargestMode(r10);
    }

    private static boolean isSonyBravia4kTv(@NonNull Context r10) {
        if (isTv(r10) == true) goto L5;
    L11:
        return false;
    L5:
        if ("Sony".equals(Build.MANUFACTURER) == false) goto L11;
        if (Build.MODEL.startsWith("BRAVIA") == false) goto L11;
        if (r10.getPackageManager().hasSystemFeature("com.sony.dtv.hardware.panel.qfhd") == false) goto L11;
        return true;
    }

    private static boolean isTv(@NonNull Context r10) {
        UiModeManager r11 = (UiModeManager) r10.getSystemService("uimode");
        if (r11 != null) goto L5;
    L7:
        return false;
    L5:
        if (r11.getCurrentModeType() != 4) goto L7;
        return true;
    }

    private static Point parseDisplaySize(@NonNull String r10) {
        String[] r11 = r10.trim().split("x", -1);
        if (r11.length != 2) goto L10;
        int r12 = Integer.parseInt(r11[0]);
        int r13 = Integer.parseInt(r11[1]);
        if (r12 <= 0) goto L10;
        if (r13 <= 0) goto L10;
        return new Point(r12, r13);
    L10:
        throw new NumberFormatException();
    }

    @Nullable
    private static Point parsePhysicalDisplaySizeFromSystemProperties(@NonNull String r10, @NonNull Display r11) {
        if (r11.getDisplayId() == 0) goto L5;
        return null;
    L5:
        String r12 = getSystemProperty(r10);
        if (TextUtils.isEmpty(r12) == true) goto L11;
        if (r12 == null) goto L11;
        return parseDisplaySize(r12);
    L11:
        return null;
    }
}
