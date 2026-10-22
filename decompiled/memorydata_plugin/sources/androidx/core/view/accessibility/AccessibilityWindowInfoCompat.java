package androidx.core.view.accessibility;

import android.graphics.Rect;
import android.graphics.Region;
import android.os.Build;
import android.os.LocaleList;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityWindowInfo;
import androidx.core.os.LocaleListCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;

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

    private static class Api21Impl {
        private Api21Impl() {
        }

        static void getBoundsInScreen(AccessibilityWindowInfo r0, Rect r1) {
            r0.getBoundsInScreen(r1);
        }

        static AccessibilityWindowInfo getChild(AccessibilityWindowInfo r0, int r1) {
            return r0.getChild(r1);
        }

        static int getChildCount(AccessibilityWindowInfo r0) {
            return r0.getChildCount();
        }

        static int getId(AccessibilityWindowInfo r0) {
            return r0.getId();
        }

        static int getLayer(AccessibilityWindowInfo r0) {
            return r0.getLayer();
        }

        static AccessibilityWindowInfo getParent(AccessibilityWindowInfo r0) {
            return r0.getParent();
        }

        static AccessibilityNodeInfo getRoot(AccessibilityWindowInfo r0) {
            return r0.getRoot();
        }

        static int getType(AccessibilityWindowInfo r0) {
            return r0.getType();
        }

        static boolean isAccessibilityFocused(AccessibilityWindowInfo r0) {
            return r0.isAccessibilityFocused();
        }

        static boolean isActive(AccessibilityWindowInfo r0) {
            return r0.isActive();
        }

        static boolean isFocused(AccessibilityWindowInfo r0) {
            return r0.isFocused();
        }

        static AccessibilityWindowInfo obtain() {
            return AccessibilityWindowInfo.obtain();
        }

        static AccessibilityWindowInfo obtain(AccessibilityWindowInfo r0) {
            return AccessibilityWindowInfo.obtain(r0);
        }
    }

    private static class Api24Impl {
        private Api24Impl() {
        }

        static AccessibilityNodeInfo getAnchor(AccessibilityWindowInfo r0) {
            return r0.getAnchor();
        }

        static CharSequence getTitle(AccessibilityWindowInfo r0) {
            return r0.getTitle();
        }
    }

    private static class Api26Impl {
        private Api26Impl() {
        }

        static boolean isInPictureInPictureMode(AccessibilityWindowInfo r0) {
            return r0.isInPictureInPictureMode();
        }
    }

    private static class Api30Impl {
        private Api30Impl() {
        }

        static AccessibilityWindowInfo instantiateAccessibilityWindowInfo() {
            return new AccessibilityWindowInfo();
        }
    }

    private static class Api33Impl {
        private Api33Impl() {
        }

        static int getDisplayId(AccessibilityWindowInfo r0) {
            return r0.getDisplayId();
        }

        static void getRegionInScreen(AccessibilityWindowInfo r0, Region r1) {
            r0.getRegionInScreen(r1);
        }

        public static AccessibilityNodeInfoCompat getRoot(Object r2, int r3) {
            return AccessibilityNodeInfoCompat.wrapNonNullInstance(((AccessibilityWindowInfo) ZeusTransformUtils.preCheckCast(r2, AccessibilityWindowInfo.class, "com.obric.memorydata.plugin")).getRoot(r3));
        }
    }

    private static class Api34Impl {
        private Api34Impl() {
        }

        static LocaleList getLocales(AccessibilityWindowInfo r0) {
            return r0.getLocales();
        }

        public static long getTransitionTimeMillis(AccessibilityWindowInfo r2) {
            return r2.getTransitionTimeMillis();
        }
    }

    public AccessibilityWindowInfoCompat() {
        if (Build.VERSION.SDK_INT < 30) goto L5;
        AccessibilityWindowInfo r0 = Api30Impl.instantiateAccessibilityWindowInfo();
    L6:
        this.mInfo = r0;
        return;
    L5:
        r0 = null;
        goto L6
    }

    private AccessibilityWindowInfoCompat(Object r1) {
        this.mInfo = r1;
    }

    public static AccessibilityWindowInfoCompat obtain() {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return null;
    L5:
        return wrapNonNullInstance(Api21Impl.obtain());
    }

    public static AccessibilityWindowInfoCompat obtain(AccessibilityWindowInfoCompat r3) {
        if (Build.VERSION.SDK_INT < 21) goto L8;
        if (r3 != null) goto L7;
        return null;
    L7:
        return wrapNonNullInstance(Api21Impl.obtain((AccessibilityWindowInfo) ZeusTransformUtils.preCheckCast(r3.mInfo, AccessibilityWindowInfo.class, "com.obric.memorydata.plugin")));
    L8:
        return null;
    }

    private static String typeToString(int r1) {
        if (r1 != 1) goto L5;
        return "TYPE_APPLICATION";
    L5:
        if (r1 != 2) goto L7;
        return "TYPE_INPUT_METHOD";
    L7:
        if (r1 != 3) goto L9;
        return "TYPE_SYSTEM";
    L9:
        if (r1 == 4) goto L12;
        return "<UNKNOWN>";
    L12:
        return "TYPE_ACCESSIBILITY_OVERLAY";
    }

    static AccessibilityWindowInfoCompat wrapNonNullInstance(Object r1) {
        if (r1 != null) goto L4;
        return null;
    L4:
        return new AccessibilityWindowInfoCompat(r1);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L9;
        return false;
    L9:
        if (ZeusTransformUtils.instanceOf(r5, AccessibilityWindowInfoCompat.class) == true) goto L11;
        return false;
    L11:
        AccessibilityWindowInfoCompat r6 = (AccessibilityWindowInfoCompat) ZeusTransformUtils.preCheckCast(r5, AccessibilityWindowInfoCompat.class, "com.obric.memorydata.plugin");
        Object r4 = this.mInfo;
        if (r4 != null) goto L19;
        if (r6.mInfo != null) goto L17;
        return true;
    L17:
        return false;
    L19:
        return r4.equals(r6.mInfo);
    }

    public AccessibilityNodeInfoCompat getAnchor() {
        if (Build.VERSION.SDK_INT >= 24) goto L5;
        return null;
    L5:
        return AccessibilityNodeInfoCompat.wrapNonNullInstance(Api24Impl.getAnchor((AccessibilityWindowInfo) ZeusTransformUtils.preCheckCast(this.mInfo, AccessibilityWindowInfo.class, "com.obric.memorydata.plugin")));
    }

    public void getBoundsInScreen(Rect r3) {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        Api21Impl.getBoundsInScreen((AccessibilityWindowInfo) ZeusTransformUtils.preCheckCast(this.mInfo, AccessibilityWindowInfo.class, "com.obric.memorydata.plugin"), r3);
        return;
    }

    public AccessibilityWindowInfoCompat getChild(int r3) {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return null;
    L5:
        return wrapNonNullInstance(Api21Impl.getChild((AccessibilityWindowInfo) ZeusTransformUtils.preCheckCast(this.mInfo, AccessibilityWindowInfo.class, "com.obric.memorydata.plugin"), r3));
    }

    public int getChildCount() {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return 0;
    L5:
        return Api21Impl.getChildCount((AccessibilityWindowInfo) ZeusTransformUtils.preCheckCast(this.mInfo, AccessibilityWindowInfo.class, "com.obric.memorydata.plugin"));
    }

    public int getDisplayId() {
        if (Build.VERSION.SDK_INT >= 33) goto L5;
        return 0;
    L5:
        return Api33Impl.getDisplayId((AccessibilityWindowInfo) ZeusTransformUtils.preCheckCast(this.mInfo, AccessibilityWindowInfo.class, "com.obric.memorydata.plugin"));
    }

    public int getId() {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return -1;
    L5:
        return Api21Impl.getId((AccessibilityWindowInfo) ZeusTransformUtils.preCheckCast(this.mInfo, AccessibilityWindowInfo.class, "com.obric.memorydata.plugin"));
    }

    public int getLayer() {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return -1;
    L5:
        return Api21Impl.getLayer((AccessibilityWindowInfo) ZeusTransformUtils.preCheckCast(this.mInfo, AccessibilityWindowInfo.class, "com.obric.memorydata.plugin"));
    }

    public LocaleListCompat getLocales() {
        if (Build.VERSION.SDK_INT < 34) goto L7;
        return LocaleListCompat.wrap(Api34Impl.getLocales((AccessibilityWindowInfo) ZeusTransformUtils.preCheckCast(this.mInfo, AccessibilityWindowInfo.class, "com.obric.memorydata.plugin")));
    L7:
        return LocaleListCompat.getEmptyLocaleList();
    }

    public AccessibilityWindowInfoCompat getParent() {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return null;
    L5:
        return wrapNonNullInstance(Api21Impl.getParent((AccessibilityWindowInfo) ZeusTransformUtils.preCheckCast(this.mInfo, AccessibilityWindowInfo.class, "com.obric.memorydata.plugin")));
    }

    public void getRegionInScreen(Region r4) {
        if (Build.VERSION.SDK_INT < 33) goto L6;
        Api33Impl.getRegionInScreen((AccessibilityWindowInfo) ZeusTransformUtils.preCheckCast(this.mInfo, AccessibilityWindowInfo.class, "com.obric.memorydata.plugin"), r4);
        return;
    L6:
        if (Build.VERSION.SDK_INT < 21) goto L10;
        Rect r0 = new Rect();
        Api21Impl.getBoundsInScreen((AccessibilityWindowInfo) ZeusTransformUtils.preCheckCast(this.mInfo, AccessibilityWindowInfo.class, "com.obric.memorydata.plugin"), r0);
        r4.set(r0);
        return;
    }

    public AccessibilityNodeInfoCompat getRoot() {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return null;
    L5:
        return AccessibilityNodeInfoCompat.wrapNonNullInstance(Api21Impl.getRoot((AccessibilityWindowInfo) ZeusTransformUtils.preCheckCast(this.mInfo, AccessibilityWindowInfo.class, "com.obric.memorydata.plugin")));
    }

    public AccessibilityNodeInfoCompat getRoot(int r3) {
        if (Build.VERSION.SDK_INT < 33) goto L7;
        return Api33Impl.getRoot(this.mInfo, r3);
    L7:
        return getRoot();
    }

    public CharSequence getTitle() {
        if (Build.VERSION.SDK_INT >= 24) goto L5;
        return null;
    L5:
        return Api24Impl.getTitle((AccessibilityWindowInfo) ZeusTransformUtils.preCheckCast(this.mInfo, AccessibilityWindowInfo.class, "com.obric.memorydata.plugin"));
    }

    public long getTransitionTimeMillis() {
        if (Build.VERSION.SDK_INT >= 34) goto L5;
        return 0;
    L5:
        return Api34Impl.getTransitionTimeMillis((AccessibilityWindowInfo) ZeusTransformUtils.preCheckCast(this.mInfo, AccessibilityWindowInfo.class, "com.obric.memorydata.plugin"));
    }

    public int getType() {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return -1;
    L5:
        return Api21Impl.getType((AccessibilityWindowInfo) ZeusTransformUtils.preCheckCast(this.mInfo, AccessibilityWindowInfo.class, "com.obric.memorydata.plugin"));
    }

    public int hashCode() {
        Object r0 = this.mInfo;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public boolean isAccessibilityFocused() {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return true;
    L5:
        return Api21Impl.isAccessibilityFocused((AccessibilityWindowInfo) ZeusTransformUtils.preCheckCast(this.mInfo, AccessibilityWindowInfo.class, "com.obric.memorydata.plugin"));
    }

    public boolean isActive() {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return true;
    L5:
        return Api21Impl.isActive((AccessibilityWindowInfo) ZeusTransformUtils.preCheckCast(this.mInfo, AccessibilityWindowInfo.class, "com.obric.memorydata.plugin"));
    }

    public boolean isFocused() {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return true;
    L5:
        return Api21Impl.isFocused((AccessibilityWindowInfo) ZeusTransformUtils.preCheckCast(this.mInfo, AccessibilityWindowInfo.class, "com.obric.memorydata.plugin"));
    }

    public boolean isInPictureInPictureMode() {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return false;
    L5:
        return Api26Impl.isInPictureInPictureMode((AccessibilityWindowInfo) ZeusTransformUtils.preCheckCast(this.mInfo, AccessibilityWindowInfo.class, "com.obric.memorydata.plugin"));
    }

    @Deprecated
    public void recycle() {
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        Rect r1 = new Rect();
        getBoundsInScreen(r1);
        r0.append("AccessibilityWindowInfo[");
        r0.append("id=").append(getId());
        r0.append(", type=").append(typeToString(getType()));
        r0.append(", layer=").append(getLayer());
        r0.append(", bounds=").append(r1);
        r0.append(", focused=").append(isFocused());
        r0.append(", active=").append(isActive());
        StringBuilder r2 = r0.append(", hasParent=");
        boolean r3 = true;
        if (getParent() == null) goto L5;
        boolean r4 = true;
    L6:
        r2.append(r4);
        StringBuilder r5 = r0.append(", hasChildren=");
        if (getChildCount() > 0) goto L10;
        r3 = false;
    L10:
        r5.append(r3);
        r0.append(", transitionTime=").append(getTransitionTimeMillis());
        r0.append(", locales=").append(getLocales());
        r0.append(']');
        return r0.toString();
    L5:
        r4 = false;
        goto L6
    }

    public AccessibilityWindowInfo unwrap() {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return null;
    L5:
        return (AccessibilityWindowInfo) ZeusTransformUtils.preCheckCast(this.mInfo, AccessibilityWindowInfo.class, "com.obric.memorydata.plugin");
    }
}
