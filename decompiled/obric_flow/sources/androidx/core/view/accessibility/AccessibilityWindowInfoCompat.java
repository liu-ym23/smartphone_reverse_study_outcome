package androidx.core.view.accessibility;

import android.graphics.Rect;
import android.graphics.Region;
import android.os.Build;
import android.os.LocaleList;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityWindowInfo;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.os.LocaleListCompat;

/* JADX INFO: loaded from: classes.dex */
public class AccessibilityWindowInfoCompat {
    public static final int TYPE_ACCESSIBILITY_OVERLAY = 4;
    public static final int TYPE_APPLICATION = 1;
    public static final int TYPE_INPUT_METHOD = 2;
    public static final int TYPE_MAGNIFICATION_OVERLAY = 6;
    public static final int TYPE_SPLIT_SCREEN_DIVIDER = 5;
    public static final int TYPE_SYSTEM = 3;
    private static final int UNDEFINED = -1;
    private final Object mInfo;

    @RequiresApi(21)
    public static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        public static void getBoundsInScreen(AccessibilityWindowInfo r5, Rect r10) {
            r5.getBoundsInScreen(r10);
        }

        @DoNotInline
        public static AccessibilityWindowInfo getChild(AccessibilityWindowInfo r5, int r10) {
            return r5.getChild(r10);
        }

        @DoNotInline
        public static int getChildCount(AccessibilityWindowInfo r5) {
            return r5.getChildCount();
        }

        @DoNotInline
        public static int getId(AccessibilityWindowInfo r5) {
            return r5.getId();
        }

        @DoNotInline
        public static int getLayer(AccessibilityWindowInfo r5) {
            return r5.getLayer();
        }

        @DoNotInline
        public static AccessibilityWindowInfo getParent(AccessibilityWindowInfo r5) {
            return r5.getParent();
        }

        @DoNotInline
        public static AccessibilityNodeInfo getRoot(AccessibilityWindowInfo r5) {
            return r5.getRoot();
        }

        @DoNotInline
        public static int getType(AccessibilityWindowInfo r5) {
            return r5.getType();
        }

        @DoNotInline
        public static boolean isAccessibilityFocused(AccessibilityWindowInfo r5) {
            return r5.isAccessibilityFocused();
        }

        @DoNotInline
        public static boolean isActive(AccessibilityWindowInfo r5) {
            return r5.isActive();
        }

        @DoNotInline
        public static boolean isFocused(AccessibilityWindowInfo r5) {
            return r5.isFocused();
        }

        @DoNotInline
        public static AccessibilityWindowInfo obtain() {
            return AccessibilityWindowInfo.obtain();
        }

        @DoNotInline
        public static AccessibilityWindowInfo obtain(AccessibilityWindowInfo r5) {
            return AccessibilityWindowInfo.obtain(r5);
        }
    }

    @RequiresApi(24)
    public static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        public static AccessibilityNodeInfo getAnchor(AccessibilityWindowInfo r5) {
            return r5.getAnchor();
        }

        @DoNotInline
        public static CharSequence getTitle(AccessibilityWindowInfo r5) {
            return r5.getTitle();
        }
    }

    @RequiresApi(26)
    public static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        public static boolean isInPictureInPictureMode(AccessibilityWindowInfo r5) {
            return r5.isInPictureInPictureMode();
        }
    }

    @RequiresApi(30)
    public static class Api30Impl {
        private Api30Impl() {
        }

        @DoNotInline
        public static AccessibilityWindowInfo instantiateAccessibilityWindowInfo() {
            return new AccessibilityWindowInfo();
        }
    }

    @RequiresApi(33)
    public static class Api33Impl {
        private Api33Impl() {
        }

        @DoNotInline
        public static int getDisplayId(AccessibilityWindowInfo r5) {
            return r5.getDisplayId();
        }

        @DoNotInline
        public static void getRegionInScreen(AccessibilityWindowInfo r5, Region r10) {
            r5.getRegionInScreen(r10);
        }

        @DoNotInline
        public static AccessibilityNodeInfoCompat getRoot(Object r5, int r10) {
            return AccessibilityNodeInfoCompat.wrapNonNullInstance(((AccessibilityWindowInfo) r5).getRoot(r10));
        }
    }

    @RequiresApi(34)
    public static class Api34Impl {
        private Api34Impl() {
        }

        @DoNotInline
        public static LocaleList getLocales(AccessibilityWindowInfo r5) {
            return r5.getLocales();
        }

        @DoNotInline
        public static long getTransitionTimeMillis(AccessibilityWindowInfo r5) {
            return r5.getTransitionTimeMillis();
        }
    }

    public AccessibilityWindowInfoCompat() {
        this.mInfo = Api30Impl.instantiateAccessibilityWindowInfo();
    }

    @Nullable
    public static AccessibilityWindowInfoCompat obtain() {
        return wrapNonNullInstance(Api21Impl.obtain());
    }

    private static String typeToString(int r5) {
        if (r5 != 1) goto L5;
        return "TYPE_APPLICATION";
    L5:
        if (r5 != 2) goto L7;
        return "TYPE_INPUT_METHOD";
    L7:
        if (r5 != 3) goto L9;
        return "TYPE_SYSTEM";
    L9:
        if (r5 == 4) goto L12;
        return "<UNKNOWN>";
    L12:
        return "TYPE_ACCESSIBILITY_OVERLAY";
    }

    public static AccessibilityWindowInfoCompat wrapNonNullInstance(Object r5) {
        if (r5 != null) goto L4;
        return null;
    L4:
        return new AccessibilityWindowInfoCompat(r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L9;
        return false;
    L9:
        if ((r5 instanceof AccessibilityWindowInfoCompat) == true) goto L11;
        return false;
    L11:
        AccessibilityWindowInfoCompat r10 = (AccessibilityWindowInfoCompat) r5;
        Object r11 = this.mInfo;
        if (r11 != null) goto L19;
        if (r10.mInfo != null) goto L17;
        return true;
    L17:
        return false;
    L19:
        return r11.equals(r10.mInfo);
    }

    @Nullable
    public AccessibilityNodeInfoCompat getAnchor() {
        return AccessibilityNodeInfoCompat.wrapNonNullInstance(Api24Impl.getAnchor((AccessibilityWindowInfo) this.mInfo));
    }

    public void getBoundsInScreen(@NonNull Rect r5) {
        Api21Impl.getBoundsInScreen((AccessibilityWindowInfo) this.mInfo, r5);
    }

    @Nullable
    public AccessibilityWindowInfoCompat getChild(int r5) {
        return wrapNonNullInstance(Api21Impl.getChild((AccessibilityWindowInfo) this.mInfo, r5));
    }

    public int getChildCount() {
        return Api21Impl.getChildCount((AccessibilityWindowInfo) this.mInfo);
    }

    public int getDisplayId() {
        if (Build.VERSION.SDK_INT >= 33) goto L5;
        return 0;
    L5:
        return Api33Impl.getDisplayId((AccessibilityWindowInfo) this.mInfo);
    }

    public int getId() {
        return Api21Impl.getId((AccessibilityWindowInfo) this.mInfo);
    }

    public int getLayer() {
        return Api21Impl.getLayer((AccessibilityWindowInfo) this.mInfo);
    }

    @NonNull
    public LocaleListCompat getLocales() {
        if (Build.VERSION.SDK_INT < 34) goto L7;
        return LocaleListCompat.wrap(Api34Impl.getLocales((AccessibilityWindowInfo) this.mInfo));
    L7:
        return LocaleListCompat.getEmptyLocaleList();
    }

    @Nullable
    public AccessibilityWindowInfoCompat getParent() {
        return wrapNonNullInstance(Api21Impl.getParent((AccessibilityWindowInfo) this.mInfo));
    }

    public void getRegionInScreen(@NonNull Region r5) {
        if (Build.VERSION.SDK_INT < 33) goto L5;
        Api33Impl.getRegionInScreen((AccessibilityWindowInfo) this.mInfo, r5);
        return;
    L5:
        Rect r10 = new Rect();
        Api21Impl.getBoundsInScreen((AccessibilityWindowInfo) this.mInfo, r10);
        r5.set(r10);
    }

    @Nullable
    public AccessibilityNodeInfoCompat getRoot() {
        return AccessibilityNodeInfoCompat.wrapNonNullInstance(Api21Impl.getRoot((AccessibilityWindowInfo) this.mInfo));
    }

    @Nullable
    public CharSequence getTitle() {
        return Api24Impl.getTitle((AccessibilityWindowInfo) this.mInfo);
    }

    public long getTransitionTimeMillis() {
        if (Build.VERSION.SDK_INT >= 34) goto L5;
        return 0;
    L5:
        return Api34Impl.getTransitionTimeMillis((AccessibilityWindowInfo) this.mInfo);
    }

    public int getType() {
        return Api21Impl.getType((AccessibilityWindowInfo) this.mInfo);
    }

    public int hashCode() {
        Object r5 = this.mInfo;
        if (r5 != null) goto L6;
        return 0;
    L6:
        return r5.hashCode();
    }

    public boolean isAccessibilityFocused() {
        return Api21Impl.isAccessibilityFocused((AccessibilityWindowInfo) this.mInfo);
    }

    public boolean isActive() {
        return Api21Impl.isActive((AccessibilityWindowInfo) this.mInfo);
    }

    public boolean isFocused() {
        return Api21Impl.isFocused((AccessibilityWindowInfo) this.mInfo);
    }

    public boolean isInPictureInPictureMode() {
        return Api26Impl.isInPictureInPictureMode((AccessibilityWindowInfo) this.mInfo);
    }

    @Deprecated
    public void recycle() {
    }

    @NonNull
    public String toString() {
        StringBuilder r5 = new StringBuilder("AccessibilityWindowInfo[id=");
        Rect r10 = new Rect();
        getBoundsInScreen(r10);
        r5.append(getId());
        r5.append(", type=");
        r5.append(typeToString(getType()));
        r5.append(", layer=");
        r5.append(getLayer());
        r5.append(", bounds=");
        r5.append(r10);
        r5.append(", focused=");
        r5.append(isFocused());
        r5.append(", active=");
        r5.append(isActive());
        r5.append(", hasParent=");
        boolean r11 = false;
        if (getParent() == null) goto L5;
        boolean r12 = true;
    L6:
        r5.append(r12);
        r5.append(", hasChildren=");
        if (getChildCount() <= 0) goto L9;
        r11 = true;
    L9:
        r5.append(r11);
        r5.append(", transitionTime=");
        r5.append(getTransitionTimeMillis());
        r5.append(", locales=");
        r5.append(getLocales());
        r5.append(']');
        return r5.toString();
    L5:
        r12 = false;
        goto L6
    }

    @Nullable
    public AccessibilityWindowInfo unwrap() {
        return (AccessibilityWindowInfo) this.mInfo;
    }

    @Nullable
    public static AccessibilityWindowInfoCompat obtain(@Nullable AccessibilityWindowInfoCompat r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        return wrapNonNullInstance(Api21Impl.obtain((AccessibilityWindowInfo) r5.mInfo));
    }

    private AccessibilityWindowInfoCompat(Object r5) {
        this.mInfo = r5;
    }

    @Nullable
    public AccessibilityNodeInfoCompat getRoot(int r5) {
        if (Build.VERSION.SDK_INT < 33) goto L7;
        return Api33Impl.getRoot(this.mInfo, r5);
    L7:
        return getRoot();
    }
}
