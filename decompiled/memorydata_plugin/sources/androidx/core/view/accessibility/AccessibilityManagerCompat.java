package androidx.core.view.accessibility;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.os.Build;
import android.view.accessibility.AccessibilityManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class AccessibilityManagerCompat {

    @Deprecated
    public interface AccessibilityStateChangeListener {
        @Deprecated
        void onAccessibilityStateChanged(boolean r1);
    }

    @Deprecated
    public static abstract class AccessibilityStateChangeListenerCompat implements AccessibilityStateChangeListener {
        public AccessibilityStateChangeListenerCompat() {
        }
    }

    private static class AccessibilityStateChangeListenerWrapper implements AccessibilityManager.AccessibilityStateChangeListener {
        AccessibilityStateChangeListener mListener;

        AccessibilityStateChangeListenerWrapper(AccessibilityStateChangeListener r3) {
            this.mListener = (AccessibilityStateChangeListener) ZeusTransformUtils.wrapperContextForParams(r3, AccessibilityStateChangeListener.class, "com.obric.memorydata.plugin");
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L7;
            return true;
        L7:
            if (ZeusTransformUtils.instanceOf(r3, AccessibilityStateChangeListenerWrapper.class) == true) goto L10;
            return false;
        L10:
            AccessibilityStateChangeListenerWrapper r4 = (AccessibilityStateChangeListenerWrapper) ZeusTransformUtils.preCheckCast(r3, AccessibilityStateChangeListenerWrapper.class, "com.obric.memorydata.plugin");
            return this.mListener.equals(r4.mListener);
        }

        public int hashCode() {
            return this.mListener.hashCode();
        }

        @Override // android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener
        public void onAccessibilityStateChanged(boolean r1) {
            this.mListener.onAccessibilityStateChanged(r1);
        }
    }

    static class Api19Impl {
        private Api19Impl() {
        }

        static boolean addTouchExplorationStateChangeListenerWrapper(AccessibilityManager r2, TouchExplorationStateChangeListener r3) {
            return r2.addTouchExplorationStateChangeListener(new TouchExplorationStateChangeListenerWrapper((TouchExplorationStateChangeListener) ZeusTransformUtils.wrapperContextForParams(r3, TouchExplorationStateChangeListener.class, "com.obric.memorydata.plugin")));
        }

        static boolean removeTouchExplorationStateChangeListenerWrapper(AccessibilityManager r2, TouchExplorationStateChangeListener r3) {
            return r2.removeTouchExplorationStateChangeListener(new TouchExplorationStateChangeListenerWrapper((TouchExplorationStateChangeListener) ZeusTransformUtils.wrapperContextForParams(r3, TouchExplorationStateChangeListener.class, "com.obric.memorydata.plugin")));
        }
    }

    static class Api34Impl {
        private Api34Impl() {
        }

        static boolean isRequestFromAccessibilityTool(AccessibilityManager r0) {
            return r0.isRequestFromAccessibilityTool();
        }
    }

    public interface TouchExplorationStateChangeListener {
        void onTouchExplorationStateChanged(boolean r1);
    }

    private static final class TouchExplorationStateChangeListenerWrapper implements AccessibilityManager.TouchExplorationStateChangeListener {
        final TouchExplorationStateChangeListener mListener;

        TouchExplorationStateChangeListenerWrapper(TouchExplorationStateChangeListener r3) {
            this.mListener = (TouchExplorationStateChangeListener) ZeusTransformUtils.wrapperContextForParams(r3, TouchExplorationStateChangeListener.class, "com.obric.memorydata.plugin");
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L7;
            return true;
        L7:
            if (ZeusTransformUtils.instanceOf(r3, TouchExplorationStateChangeListenerWrapper.class) == true) goto L10;
            return false;
        L10:
            TouchExplorationStateChangeListenerWrapper r4 = (TouchExplorationStateChangeListenerWrapper) ZeusTransformUtils.preCheckCast(r3, TouchExplorationStateChangeListenerWrapper.class, "com.obric.memorydata.plugin");
            return this.mListener.equals(r4.mListener);
        }

        public int hashCode() {
            return this.mListener.hashCode();
        }

        @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
        public void onTouchExplorationStateChanged(boolean r1) {
            this.mListener.onTouchExplorationStateChanged(r1);
        }
    }

    private AccessibilityManagerCompat() {
    }

    @Deprecated
    public static boolean addAccessibilityStateChangeListener(AccessibilityManager r2, AccessibilityStateChangeListener r3) {
        AccessibilityStateChangeListener r4 = (AccessibilityStateChangeListener) ZeusTransformUtils.wrapperContextForParams(r3, AccessibilityStateChangeListener.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L7;
        return false;
    L7:
        return r2.addAccessibilityStateChangeListener(new AccessibilityStateChangeListenerWrapper(r4));
    }

    public static boolean addTouchExplorationStateChangeListener(AccessibilityManager r2, TouchExplorationStateChangeListener r3) {
        TouchExplorationStateChangeListener r4 = (TouchExplorationStateChangeListener) ZeusTransformUtils.wrapperContextForParams(r3, TouchExplorationStateChangeListener.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        return false;
    L5:
        return Api19Impl.addTouchExplorationStateChangeListenerWrapper(r2, r4);
    }

    @Deprecated
    public static List<AccessibilityServiceInfo> getEnabledAccessibilityServiceList(AccessibilityManager r0, int r1) {
        return r0.getEnabledAccessibilityServiceList(r1);
    }

    @Deprecated
    public static List<AccessibilityServiceInfo> getInstalledAccessibilityServiceList(AccessibilityManager r0) {
        return r0.getInstalledAccessibilityServiceList();
    }

    public static boolean isRequestFromAccessibilityTool(AccessibilityManager r2) {
        if (Build.VERSION.SDK_INT >= 34) goto L5;
        return true;
    L5:
        return Api34Impl.isRequestFromAccessibilityTool(r2);
    }

    @Deprecated
    public static boolean isTouchExplorationEnabled(AccessibilityManager r0) {
        return r0.isTouchExplorationEnabled();
    }

    @Deprecated
    public static boolean removeAccessibilityStateChangeListener(AccessibilityManager r2, AccessibilityStateChangeListener r3) {
        AccessibilityStateChangeListener r4 = (AccessibilityStateChangeListener) ZeusTransformUtils.wrapperContextForParams(r3, AccessibilityStateChangeListener.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L7;
        return false;
    L7:
        return r2.removeAccessibilityStateChangeListener(new AccessibilityStateChangeListenerWrapper(r4));
    }

    public static boolean removeTouchExplorationStateChangeListener(AccessibilityManager r2, TouchExplorationStateChangeListener r3) {
        TouchExplorationStateChangeListener r4 = (TouchExplorationStateChangeListener) ZeusTransformUtils.wrapperContextForParams(r3, TouchExplorationStateChangeListener.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        return false;
    L5:
        return Api19Impl.removeTouchExplorationStateChangeListenerWrapper(r2, r4);
    }
}
