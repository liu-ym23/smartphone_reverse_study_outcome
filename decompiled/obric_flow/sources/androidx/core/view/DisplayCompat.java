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

    @RequiresApi(23)
    public static class Api23Impl {
        private Api23Impl() {
        }

        @NonNull
        public static ModeCompat getMode(@NonNull Context r5, @NonNull Display r10) {
            Display.Mode r11 = r10.getMode();
            Point r12 = DisplayCompat.getCurrentDisplaySizeFromWorkarounds(r5, r10);
            if (r12 == null) goto L9;
            if (physicalSizeEquals(r11, r12) == true) goto L9;
            return new ModeCompat(r11, r12);
        L9:
            return new ModeCompat(r11, true);
        }

        @NonNull
        @SuppressLint({"ArrayReturn"})
        public static ModeCompat[] getSupportedModes(@NonNull Context r10, @NonNull Display r11) {
            Display.Mode[] r5 = r11.getSupportedModes();
            ModeCompat[] r12 = new ModeCompat[r5.length];
            Display.Mode r13 = r11.getMode();
            Point r14 = DisplayCompat.getCurrentDisplaySizeFromWorkarounds(r10, r11);
            int r15 = 0;
            if (r14 == null) goto L16;
            if (physicalSizeEquals(r13, r14) == true) goto L16;
            int r16 = 0;
        L9:
            if (r16 >= r5.length) goto L18;
            if (physicalSizeEquals(r5[r16], r13) == false) goto L13;
            ModeCompat r17 = new ModeCompat(r5[r16], r14);
        L14:
            r12[r16] = r17;
            r16 = r16 + 1;
            goto L9
        L13:
            r17 = new ModeCompat(r5[r16], false);
        L18:
            return r12;
        L16:
            if (r15 >= r5.length) goto L18;
            r12[r15] = new ModeCompat(r5[r15], physicalSizeEquals(r5[r15], r13));
            r15 = r15 + 1;
            goto L16
        }

        public static boolean isCurrentModeTheLargestMode(@NonNull Display r10) {
            Display.Mode r5 = r10.getMode();
            Display.Mode[] r11 = r10.getSupportedModes();
            int r12 = r11.length;
            int r13 = 0;
        L3:
            if (r13 >= r12) goto L11;
            Display.Mode r14 = r11[r13];
            if (r5.getPhysicalHeight() < r14.getPhysicalHeight()) goto L10;
            if (r5.getPhysicalWidth() < r14.getPhysicalWidth()) goto L10;
            r13 = r13 + 1;
        L10:
            return false;
        L11:
            return true;
        }

        public static boolean physicalSizeEquals(Display.Mode r5, Point r10) {
            if (r5.getPhysicalWidth() != r10.x) goto L7;
            if (r5.getPhysicalHeight() != r10.y) goto L7;
        L10:
            return true;
        L7:
            if (r5.getPhysicalWidth() == r10.y) goto L9;
        L11:
            return false;
        L9:
            if (r5.getPhysicalHeight() != r10.x) goto L11;
            goto L10
        }

        public static boolean physicalSizeEquals(Display.Mode r5, Display.Mode r10) {
            if (r5.getPhysicalWidth() == r10.getPhysicalWidth()) goto L5;
        L7:
            return false;
        L5:
            if (r5.getPhysicalHeight() != r10.getPhysicalHeight()) goto L7;
            return true;
        }
    }

    public static final class ModeCompat {
        private final boolean mIsNative;
        private final Display.Mode mMode;
        private final Point mPhysicalSize;

        @RequiresApi(23)
        public static class Api23Impl {
            private Api23Impl() {
            }

            @DoNotInline
            public static int getPhysicalHeight(Display.Mode r5) {
                return r5.getPhysicalHeight();
            }

            @DoNotInline
            public static int getPhysicalWidth(Display.Mode r5) {
                return r5.getPhysicalWidth();
            }
        }

        public ModeCompat(@NonNull Point r5) {
            Preconditions.checkNotNull(r5, "physicalSize == null");
            this.mPhysicalSize = r5;
            this.mMode = null;
            this.mIsNative = true;
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

        @RequiresApi(23)
        public ModeCompat(@NonNull Display.Mode r5, boolean r10) {
            Preconditions.checkNotNull(r5, "mode == null, can't wrap a null reference");
            this.mPhysicalSize = new Point(Api23Impl.getPhysicalWidth(r5), Api23Impl.getPhysicalHeight(r5));
            this.mMode = r5;
            this.mIsNative = r10;
        }

        @RequiresApi(23)
        public ModeCompat(@NonNull Display.Mode r5, @NonNull Point r10) {
            Preconditions.checkNotNull(r5, "mode == null, can't wrap a null reference");
            Preconditions.checkNotNull(r10, "physicalSize == null");
            this.mPhysicalSize = r10;
            this.mMode = r5;
            this.mIsNative = true;
        }
    }

    private DisplayCompat() {
    }

    public static Point getCurrentDisplaySizeFromWorkarounds(@NonNull Context r5, @NonNull Display r10) {
        Point r11 = parsePhysicalDisplaySizeFromSystemProperties("vendor.display-size", r10);
        if (r11 == null) goto L6;
        return r11;
    L6:
        if (isSonyBravia4kTv(r5) == true) goto L8;
        return null;
    L8:
        if (isCurrentModeTheLargestMode(r10) == true) goto L10;
        return null;
    L10:
        return new Point(DISPLAY_SIZE_4K_WIDTH, DISPLAY_SIZE_4K_HEIGHT);
    }

    @NonNull
    private static Point getDisplaySize(@NonNull Context r5, @NonNull Display r10) {
        Point r11 = getCurrentDisplaySizeFromWorkarounds(r5, r10);
        if (r11 == null) goto L5;
        return r11;
    L5:
        Point r12 = new Point();
        r10.getRealSize(r12);
        return r12;
    }

    @NonNull
    public static ModeCompat getMode(@NonNull Context r5, @NonNull Display r10) {
        return Api23Impl.getMode(r5, r10);
    }

    @NonNull
    @SuppressLint({"ArrayReturn"})
    public static ModeCompat[] getSupportedModes(@NonNull Context r5, @NonNull Display r10) {
        return Api23Impl.getSupportedModes(r5, r10);
    }

    @Nullable
    private static String getSystemProperty(String r5) {
        Class<?> r10 = Class.forName("android.os.SystemProperties");     // Catch: Exception -> L4
        return (String) r10.getMethod("get", new Class[]{String.class}).invoke(r10, new Object[]{r5});
    L4:
        return null;
    }

    public static boolean isCurrentModeTheLargestMode(@NonNull Display r5) {
        return Api23Impl.isCurrentModeTheLargestMode(r5);
    }

    private static boolean isSonyBravia4kTv(@NonNull Context r5) {
        if (isTv(r5) == true) goto L5;
    L11:
        return false;
    L5:
        if ("Sony".equals(Build.MANUFACTURER) == false) goto L11;
        if (Build.MODEL.startsWith("BRAVIA") == false) goto L11;
        if (r5.getPackageManager().hasSystemFeature("com.sony.dtv.hardware.panel.qfhd") == false) goto L11;
        return true;
    }

    private static boolean isTv(@NonNull Context r5) {
        UiModeManager r10 = (UiModeManager) r5.getSystemService("uimode");
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.getCurrentModeType() != 4) goto L7;
        return true;
    }

    private static Point parseDisplaySize(@NonNull String r5) throws NumberFormatException {
        String[] r10 = r5.trim().split("x", -1);
        if (r10.length != 2) goto L10;
        int r11 = Integer.parseInt(r10[0]);
        int r12 = Integer.parseInt(r10[1]);
        if (r11 <= 0) goto L10;
        if (r12 <= 0) goto L10;
        return new Point(r11, r12);
    L10:
        throw new NumberFormatException();
    }

    @Nullable
    private static Point parsePhysicalDisplaySizeFromSystemProperties(@NonNull String r5, @NonNull Display r10) {
        if (r10.getDisplayId() == 0) goto L5;
        return null;
    L5:
        String r11 = getSystemProperty(r5);
        if (TextUtils.isEmpty(r11) == true) goto L11;
        if (r11 == null) goto L11;
        return parseDisplaySize(r11);
    L11:
        return null;
    }
}
