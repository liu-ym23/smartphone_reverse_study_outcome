package androidx.core.view.accessibility;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.os.Build;
import android.view.accessibility.AccessibilityManager;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class AccessibilityManagerCompat {

    @Deprecated
    public interface AccessibilityStateChangeListener {
        @Deprecated
        void onAccessibilityStateChanged(boolean r5);
    }

    @Deprecated
    public static abstract class AccessibilityStateChangeListenerCompat implements AccessibilityStateChangeListener {
        public AccessibilityStateChangeListenerCompat() {
        }
    }

    public static class AccessibilityStateChangeListenerWrapper implements AccessibilityManager.AccessibilityStateChangeListener {
        AccessibilityStateChangeListener mListener;

        public AccessibilityStateChangeListenerWrapper(@NonNull AccessibilityStateChangeListener r5) {
            this.mListener = r5;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof AccessibilityStateChangeListenerWrapper) == true) goto L10;
            return false;
        L10:
            return this.mListener.equals(((AccessibilityStateChangeListenerWrapper) r5).mListener);
        }

        public int hashCode() {
            return this.mListener.hashCode();
        }

        @Override // android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener
        public void onAccessibilityStateChanged(boolean r5) {
            this.mListener.onAccessibilityStateChanged(r5);
        }
    }

    @RequiresApi(34)
    public static class Api34Impl {
        private Api34Impl() {
        }

        @DoNotInline
        public static boolean isRequestFromAccessibilityTool(AccessibilityManager r5) {
            return r5.isRequestFromAccessibilityTool();
        }
    }

    public interface TouchExplorationStateChangeListener {
        void onTouchExplorationStateChanged(boolean r5);
    }

    public static final class TouchExplorationStateChangeListenerWrapper implements AccessibilityManager.TouchExplorationStateChangeListener {
        final TouchExplorationStateChangeListener mListener;

        public TouchExplorationStateChangeListenerWrapper(@NonNull TouchExplorationStateChangeListener r5) {
            this.mListener = r5;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof TouchExplorationStateChangeListenerWrapper) == true) goto L10;
            return false;
        L10:
            return this.mListener.equals(((TouchExplorationStateChangeListenerWrapper) r5).mListener);
        }

        public int hashCode() {
            return this.mListener.hashCode();
        }

        @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
        public void onTouchExplorationStateChanged(boolean r5) {
            this.mListener.onTouchExplorationStateChanged(r5);
        }
    }

    private AccessibilityManagerCompat() {
    }

    @Deprecated
    public static boolean addAccessibilityStateChangeListener(AccessibilityManager r5, AccessibilityStateChangeListener r10) {
        if (r10 != null) goto L6;
        return false;
    L6:
        return r5.addAccessibilityStateChangeListener(new AccessibilityStateChangeListenerWrapper(r10));
    }

    public static boolean addTouchExplorationStateChangeListener(@NonNull AccessibilityManager r5, @NonNull TouchExplorationStateChangeListener r10) {
        return r5.addTouchExplorationStateChangeListener(new TouchExplorationStateChangeListenerWrapper(r10));
    }

    @Deprecated
    public static List<AccessibilityServiceInfo> getEnabledAccessibilityServiceList(AccessibilityManager r5, int r10) {
        return r5.getEnabledAccessibilityServiceList(r10);
    }

    @Deprecated
    public static List<AccessibilityServiceInfo> getInstalledAccessibilityServiceList(AccessibilityManager r5) {
        return r5.getInstalledAccessibilityServiceList();
    }

    public static boolean isRequestFromAccessibilityTool(@NonNull AccessibilityManager r5) {
        if (Build.VERSION.SDK_INT >= 34) goto L5;
        return true;
    L5:
        return Api34Impl.isRequestFromAccessibilityTool(r5);
    }

    @Deprecated
    public static boolean isTouchExplorationEnabled(AccessibilityManager r5) {
        return r5.isTouchExplorationEnabled();
    }

    @Deprecated
    public static boolean removeAccessibilityStateChangeListener(AccessibilityManager r5, AccessibilityStateChangeListener r10) {
        if (r10 != null) goto L6;
        return false;
    L6:
        return r5.removeAccessibilityStateChangeListener(new AccessibilityStateChangeListenerWrapper(r10));
    }

    public static boolean removeTouchExplorationStateChangeListener(@NonNull AccessibilityManager r5, @NonNull TouchExplorationStateChangeListener r10) {
        return r5.removeTouchExplorationStateChangeListener(new TouchExplorationStateChangeListenerWrapper(r10));
    }
}
