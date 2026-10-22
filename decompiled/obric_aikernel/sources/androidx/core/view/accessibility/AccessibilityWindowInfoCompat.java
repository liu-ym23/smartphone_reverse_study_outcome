package androidx.core.view.accessibility;

import android.graphics.Rect;
import android.graphics.Region;
import android.os.Build;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityWindowInfo;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
public class AccessibilityWindowInfoCompat {
    public static final int TYPE_ACCESSIBILITY_OVERLAY = 4;
    public static final int TYPE_APPLICATION = 1;
    public static final int TYPE_INPUT_METHOD = 2;
    public static final int TYPE_SPLIT_SCREEN_DIVIDER = 5;
    public static final int TYPE_SYSTEM = 3;
    private static final int UNDEFINED = -1;
    private final Object mInfo;

    @RequiresApi(21)
    private static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static void getBoundsInScreen(AccessibilityWindowInfo r10, Rect r11) {
            r10.getBoundsInScreen(r11);
        }

        @DoNotInline
        static AccessibilityWindowInfo getChild(AccessibilityWindowInfo r10, int r11) {
            return r10.getChild(r11);
        }

        @DoNotInline
        static int getChildCount(AccessibilityWindowInfo r10) {
            return r10.getChildCount();
        }

        @DoNotInline
        static int getId(AccessibilityWindowInfo r10) {
            return r10.getId();
        }

        @DoNotInline
        static int getLayer(AccessibilityWindowInfo r10) {
            return r10.getLayer();
        }

        @DoNotInline
        static AccessibilityWindowInfo getParent(AccessibilityWindowInfo r10) {
            return r10.getParent();
        }

        @DoNotInline
        static AccessibilityNodeInfo getRoot(AccessibilityWindowInfo r10) {
            return r10.getRoot();
        }

        @DoNotInline
        static int getType(AccessibilityWindowInfo r10) {
            return r10.getType();
        }

        @DoNotInline
        static boolean isAccessibilityFocused(AccessibilityWindowInfo r10) {
            return r10.isAccessibilityFocused();
        }

        @DoNotInline
        static boolean isActive(AccessibilityWindowInfo r10) {
            return r10.isActive();
        }

        @DoNotInline
        static boolean isFocused(AccessibilityWindowInfo r10) {
            return r10.isFocused();
        }

        @DoNotInline
        static AccessibilityWindowInfo obtain() {
            return AccessibilityWindowInfo.obtain();
        }

        @DoNotInline
        static AccessibilityWindowInfo obtain(AccessibilityWindowInfo r10) {
            return AccessibilityWindowInfo.obtain(r10);
        }
    }

    @RequiresApi(24)
    private static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        static AccessibilityNodeInfo getAnchor(AccessibilityWindowInfo r10) {
            return r10.getAnchor();
        }

        @DoNotInline
        static CharSequence getTitle(AccessibilityWindowInfo r10) {
            return r10.getTitle();
        }
    }

    @RequiresApi(33)
    private static class Api33Impl {
        private Api33Impl() {
        }

        @DoNotInline
        static int getDisplayId(AccessibilityWindowInfo r10) {
            return r10.getDisplayId();
        }

        @DoNotInline
        static void getRegionInScreen(AccessibilityWindowInfo r10, Region r11) {
            r10.getRegionInScreen(r11);
        }

        @DoNotInline
        static boolean isInPictureInPictureMode(AccessibilityWindowInfo r10) {
            return r10.isInPictureInPictureMode();
        }
    }

    private AccessibilityWindowInfoCompat(Object r10) {
        this.mInfo = r10;
    }

    @Nullable
    public static AccessibilityWindowInfoCompat obtain() {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return null;
    L5:
        return wrapNonNullInstance(Api21Impl.obtain());
    }

    @Nullable
    public static AccessibilityWindowInfoCompat obtain(@Nullable AccessibilityWindowInfoCompat r10) {
        if (Build.VERSION.SDK_INT < 21) goto L8;
        if (r10 != null) goto L7;
        return null;
    L7:
        return wrapNonNullInstance(Api21Impl.obtain((AccessibilityWindowInfo) r10.mInfo));
    L8:
        return null;
    }

    private static String typeToString(int r10) {
        if (r10 != 1) goto L5;
        return "TYPE_APPLICATION";
    L5:
        if (r10 != 2) goto L7;
        return "TYPE_INPUT_METHOD";
    L7:
        if (r10 != 3) goto L9;
        return "TYPE_SYSTEM";
    L9:
        if (r10 == 4) goto L12;
        return "<UNKNOWN>";
    L12:
        return "TYPE_ACCESSIBILITY_OVERLAY";
    }

    static AccessibilityWindowInfoCompat wrapNonNullInstance(Object r10) {
        if (r10 != null) goto L4;
        return null;
    L4:
        return new AccessibilityWindowInfoCompat(r10);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if (r10 != null) goto L9;
        return false;
    L9:
        if ((r10 instanceof AccessibilityWindowInfoCompat) == true) goto L11;
        return false;
    L11:
        AccessibilityWindowInfoCompat r11 = (AccessibilityWindowInfoCompat) r10;
        Object r12 = this.mInfo;
        if (r12 != null) goto L19;
        if (r11.mInfo != null) goto L17;
        return true;
    L17:
        return false;
    L19:
        return r12.equals(r11.mInfo);
    }

    @Nullable
    public AccessibilityNodeInfoCompat getAnchor() {
        if (Build.VERSION.SDK_INT >= 24) goto L5;
        return null;
    L5:
        return AccessibilityNodeInfoCompat.wrapNonNullInstance(Api24Impl.getAnchor((AccessibilityWindowInfo) this.mInfo));
    }

    public void getBoundsInScreen(@NonNull Rect r10) {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        Api21Impl.getBoundsInScreen((AccessibilityWindowInfo) this.mInfo, r10);
        return;
    }

    @Nullable
    public AccessibilityWindowInfoCompat getChild(int r10) {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return null;
    L5:
        return wrapNonNullInstance(Api21Impl.getChild((AccessibilityWindowInfo) this.mInfo, r10));
    }

    public int getChildCount() {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return 0;
    L5:
        return Api21Impl.getChildCount((AccessibilityWindowInfo) this.mInfo);
    }

    public int getDisplayId() {
        if (Build.VERSION.SDK_INT >= 33) goto L5;
        return 0;
    L5:
        return Api33Impl.getDisplayId((AccessibilityWindowInfo) this.mInfo);
    }

    public int getId() {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return -1;
    L5:
        return Api21Impl.getId((AccessibilityWindowInfo) this.mInfo);
    }

    public int getLayer() {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return -1;
    L5:
        return Api21Impl.getLayer((AccessibilityWindowInfo) this.mInfo);
    }

    @Nullable
    public AccessibilityWindowInfoCompat getParent() {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return null;
    L5:
        return wrapNonNullInstance(Api21Impl.getParent((AccessibilityWindowInfo) this.mInfo));
    }

    public void getRegionInScreen(@NonNull Region r10) {
        int r11 = Build.VERSION.SDK_INT;
        if (r11 < 33) goto L6;
        Api33Impl.getRegionInScreen((AccessibilityWindowInfo) this.mInfo, r10);
        return;
    L6:
        if (r11 < 21) goto L10;
        Rect r12 = new Rect();
        Api21Impl.getBoundsInScreen((AccessibilityWindowInfo) this.mInfo, r12);
        r10.set(r12);
        return;
    }

    @Nullable
    public AccessibilityNodeInfoCompat getRoot() {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return null;
    L5:
        return AccessibilityNodeInfoCompat.wrapNonNullInstance(Api21Impl.getRoot((AccessibilityWindowInfo) this.mInfo));
    }

    @Nullable
    public CharSequence getTitle() {
        if (Build.VERSION.SDK_INT >= 24) goto L5;
        return null;
    L5:
        return Api24Impl.getTitle((AccessibilityWindowInfo) this.mInfo);
    }

    public int getType() {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return -1;
    L5:
        return Api21Impl.getType((AccessibilityWindowInfo) this.mInfo);
    }

    public int hashCode() {
        Object r10 = this.mInfo;
        if (r10 != null) goto L6;
        return 0;
    L6:
        return r10.hashCode();
    }

    public boolean isAccessibilityFocused() {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return true;
    L5:
        return Api21Impl.isAccessibilityFocused((AccessibilityWindowInfo) this.mInfo);
    }

    public boolean isActive() {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return true;
    L5:
        return Api21Impl.isActive((AccessibilityWindowInfo) this.mInfo);
    }

    public boolean isFocused() {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return true;
    L5:
        return Api21Impl.isFocused((AccessibilityWindowInfo) this.mInfo);
    }

    public boolean isInPictureInPictureMode() {
        if (Build.VERSION.SDK_INT >= 33) goto L5;
        return false;
    L5:
        return Api33Impl.isInPictureInPictureMode((AccessibilityWindowInfo) this.mInfo);
    }

    @Deprecated
    public void recycle() {
    }

    @NonNull
    public String toString() {
        StringBuilder r10 = new StringBuilder();
        Rect r11 = new Rect();
        getBoundsInScreen(r11);
        r10.append("AccessibilityWindowInfo[");
        r10.append("id=");
        r10.append(getId());
        r10.append(", type=");
        r10.append(typeToString(getType()));
        r10.append(", layer=");
        r10.append(getLayer());
        r10.append(", bounds=");
        r10.append(r11);
        r10.append(", focused=");
        r10.append(isFocused());
        r10.append(", active=");
        r10.append(isActive());
        r10.append(", hasParent=");
        boolean r12 = true;
        if (getParent() == null) goto L5;
        boolean r13 = true;
    L6:
        r10.append(r13);
        r10.append(", hasChildren=");
        if (getChildCount() > 0) goto L10;
        r12 = false;
    L10:
        r10.append(r12);
        r10.append(']');
        return r10.toString();
    L5:
        r13 = false;
        goto L6
    }

    @Nullable
    public AccessibilityWindowInfo unwrap() {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return null;
    L5:
        return (AccessibilityWindowInfo) this.mInfo;
    }
}
