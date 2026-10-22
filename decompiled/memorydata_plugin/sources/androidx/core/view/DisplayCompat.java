package androidx.core.view;

import android.app.UiModeManager;
import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.text.TextUtils;
import android.view.Display;
import androidx.core.util.Preconditions;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public final class DisplayCompat {
    private static final int DISPLAY_SIZE_4K_HEIGHT = 2160;
    private static final int DISPLAY_SIZE_4K_WIDTH = 3840;

    static class Api17Impl {
        private Api17Impl() {
        }

        static void getRealSize(Display r0, Point r1) {
            r0.getRealSize(r1);
        }
    }

    static class Api23Impl {
        private Api23Impl() {
        }

        static ModeCompat getMode(Context r2, Display r3) {
            Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
            Display.Mode r0 = r3.getMode();
            Point r5 = DisplayCompat.getCurrentDisplaySizeFromWorkarounds(r4, r3);
            if (r5 == null) goto L9;
            if (physicalSizeEquals(r0, r5) == true) goto L9;
            return new ModeCompat(r0, r5);
        L9:
            return new ModeCompat(r0, true);
        }

        public static ModeCompat[] getSupportedModes(Context r6, Display r7) {
            Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
            Display.Mode[] r0 = r7.getSupportedModes();
            ModeCompat[] r1 = new ModeCompat[r0.length];
            Display.Mode r2 = r7.getMode();
            Point r9 = DisplayCompat.getCurrentDisplaySizeFromWorkarounds(r8, r7);
            int r10 = 0;
            if (r9 == null) goto L16;
            if (physicalSizeEquals(r2, r9) == true) goto L16;
            int r3 = 0;
        L9:
            if (r3 >= r0.length) goto L18;
            if (physicalSizeEquals(r0[r3], r2) == false) goto L13;
            ModeCompat r4 = new ModeCompat(r0[r3], r9);
        L14:
            r1[r3] = r4;
            r3 = r3 + 1;
            goto L9
        L13:
            r4 = new ModeCompat(r0[r3], false);
        L18:
            return r1;
        L16:
            if (r10 >= r0.length) goto L18;
            r1[r10] = new ModeCompat(r0[r10], physicalSizeEquals(r0[r10], r2));
            r10 = r10 + 1;
            goto L16
        }

        static boolean isCurrentModeTheLargestMode(Display r7) {
            Display.Mode r0 = r7.getMode();
            Display.Mode[] r8 = r7.getSupportedModes();
            int r1 = r8.length;
            int r3 = 0;
        L3:
            if (r3 >= r1) goto L11;
            Display.Mode r4 = r8[r3];
            if (r0.getPhysicalHeight() < r4.getPhysicalHeight()) goto L10;
            if (r0.getPhysicalWidth() < r4.getPhysicalWidth()) goto L10;
            r3 = r3 + 1;
        L10:
            return false;
        L11:
            return true;
        }

        static boolean physicalSizeEquals(Display.Mode r2, Point r3) {
            if (r2.getPhysicalWidth() != r3.x) goto L7;
            if (r2.getPhysicalHeight() != r3.y) goto L7;
        L10:
            return true;
        L7:
            if (r2.getPhysicalWidth() == r3.y) goto L9;
        L11:
            return false;
        L9:
            if (r2.getPhysicalHeight() != r3.x) goto L11;
            goto L10
        }

        static boolean physicalSizeEquals(Display.Mode r2, Display.Mode r3) {
            if (r2.getPhysicalWidth() == r3.getPhysicalWidth()) goto L5;
        L7:
            return false;
        L5:
            if (r2.getPhysicalHeight() != r3.getPhysicalHeight()) goto L7;
            return true;
        }
    }

    public static final class ModeCompat {
        private final boolean mIsNative;
        private final Display.Mode mMode;
        private final Point mPhysicalSize;

        static class Api23Impl {
            private Api23Impl() {
            }

            static int getPhysicalHeight(Display.Mode r0) {
                return r0.getPhysicalHeight();
            }

            static int getPhysicalWidth(Display.Mode r0) {
                return r0.getPhysicalWidth();
            }
        }

        ModeCompat(Point r2) {
            Preconditions.checkNotNull(r2, "physicalSize == null");
            this.mPhysicalSize = r2;
            this.mMode = null;
            this.mIsNative = true;
        }

        ModeCompat(Display.Mode r2, Point r3) {
            Preconditions.checkNotNull(r2, "mode == null, can't wrap a null reference");
            Preconditions.checkNotNull(r3, "physicalSize == null");
            this.mPhysicalSize = r3;
            this.mMode = r2;
            this.mIsNative = true;
        }

        ModeCompat(Display.Mode r4, boolean r5) {
            Preconditions.checkNotNull(r4, "mode == null, can't wrap a null reference");
            this.mPhysicalSize = new Point(Api23Impl.getPhysicalWidth(r4), Api23Impl.getPhysicalHeight(r4));
            this.mMode = r4;
            this.mIsNative = r5;
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

        public Display.Mode toMode() {
            return this.mMode;
        }
    }

    private DisplayCompat() {
    }

    static Point getCurrentDisplaySizeFromWorkarounds(Context r2, Display r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT >= 28) goto L5;
        String r0 = "sys.display-size";
    L6:
        Point r1 = parsePhysicalDisplaySizeFromSystemProperties(r0, r3);
        if (r1 == null) goto L10;
        return r1;
    L10:
        if (isSonyBravia4kTv(r4) == true) goto L12;
        return null;
    L12:
        if (isCurrentModeTheLargestMode(r3) == true) goto L14;
        return null;
    L14:
        return new Point(3840, DISPLAY_SIZE_4K_HEIGHT);
    L5:
        r0 = "vendor.display-size";
        goto L6
    }

    private static Point getDisplaySize(Context r2, Display r3) {
        Point r4 = getCurrentDisplaySizeFromWorkarounds((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), r3);
        if (r4 == null) goto L5;
        return r4;
    L5:
        Point r5 = new Point();
        if (Build.VERSION.SDK_INT < 17) goto L8;
        Api17Impl.getRealSize(r3, r5);
    L9:
        return r5;
    L8:
        r3.getSize(r5);
        goto L9
    }

    public static ModeCompat getMode(Context r2, Display r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 23) goto L7;
        return Api23Impl.getMode(r4, r3);
    L7:
        return new ModeCompat(getDisplaySize(r4, r3));
    }

    public static ModeCompat[] getSupportedModes(Context r2, Display r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 23) goto L7;
        return Api23Impl.getSupportedModes(r4, r3);
    L7:
        return new ModeCompat[]{getMode(r4, r3)};
    }

    private static String getSystemProperty(String r7) {
        Class r1 = ZeusTransformUtils.forName("android.os.SystemProperties", "com.obric.memorydata.plugin");     // Catch: Exception -> L5
        return (String) ZeusTransformUtils.preCheckCast(r1.getMethod("get", new Class[]{String.class}).invoke(r1, new Object[]{r7}), String.class, "com.obric.memorydata.plugin");
    L5:
        return null;
    }

    static boolean isCurrentModeTheLargestMode(Display r2) {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        return true;
    L5:
        return Api23Impl.isCurrentModeTheLargestMode(r2);
    }

    private static boolean isSonyBravia4kTv(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (isTv(r3) == true) goto L5;
    L11:
        return false;
    L5:
        if ("Sony".equals(Build.MANUFACTURER) == false) goto L11;
        if (Build.MODEL.startsWith("BRAVIA") == false) goto L11;
        if (r3.getPackageManager().hasSystemFeature("com.sony.dtv.hardware.panel.qfhd") == false) goto L11;
        return true;
    }

    private static boolean isTv(Context r2) {
        UiModeManager r3 = (UiModeManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getSystemService("uimode"), UiModeManager.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L5;
    L7:
        return false;
    L5:
        if (r3.getCurrentModeType() != 4) goto L7;
        return true;
    }

    private static Point parseDisplaySize(String r2) {
        String[] r3 = r2.trim().split("x", -1);
        if (r3.length != 2) goto L10;
        int r0 = Integer.parseInt(r3[0]);
        int r4 = Integer.parseInt(r3[1]);
        if (r0 <= 0) goto L10;
        if (r4 <= 0) goto L10;
        return new Point(r0, r4);
    L10:
        throw new NumberFormatException();
    }

    private static Point parsePhysicalDisplaySizeFromSystemProperties(String r1, Display r2) {
        if (r2.getDisplayId() == 0) goto L5;
        return null;
    L5:
        String r3 = getSystemProperty(r1);
        if (TextUtils.isEmpty(r3) == true) goto L11;
        if (r3 == null) goto L11;
        return parseDisplaySize(r3);
    L11:
        return null;
    }
}
