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
        void onAccessibilityStateChanged(boolean r10);
    }

    @Deprecated
    public static abstract class AccessibilityStateChangeListenerCompat implements AccessibilityStateChangeListener {
        public AccessibilityStateChangeListenerCompat() {
        }
    }

    private static class AccessibilityStateChangeListenerWrapper implements AccessibilityManager.AccessibilityStateChangeListener {
        AccessibilityStateChangeListener mListener;

        AccessibilityStateChangeListenerWrapper(@NonNull AccessibilityStateChangeListener r10) {
            this.mListener = r10;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof AccessibilityStateChangeListenerWrapper) == true) goto L10;
            return false;
        L10:
            return this.mListener.equals(((AccessibilityStateChangeListenerWrapper) r10).mListener);
        }

        public int hashCode() {
            return this.mListener.hashCode();
        }

        @Override // android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener
        public void onAccessibilityStateChanged(boolean r10) {
            this.mListener.onAccessibilityStateChanged(r10);
        }
    }

    @RequiresApi(19)
    static class Api19Impl {
        private Api19Impl() {
        }

        @DoNotInline
        static boolean addTouchExplorationStateChangeListenerWrapper(AccessibilityManager r10, TouchExplorationStateChangeListener r11) {
            return r10.addTouchExplorationStateChangeListener(new TouchExplorationStateChangeListenerWrapper(r11));
        }

        @DoNotInline
        static boolean removeTouchExplorationStateChangeListenerWrapper(AccessibilityManager r10, TouchExplorationStateChangeListener r11) {
            return r10.removeTouchExplorationStateChangeListener(new TouchExplorationStateChangeListenerWrapper(r11));
        }
    }

    public interface TouchExplorationStateChangeListener {
        void onTouchExplorationStateChanged(boolean r10);
    }

    @RequiresApi(19)
    private static final class TouchExplorationStateChangeListenerWrapper implements AccessibilityManager.TouchExplorationStateChangeListener {
        final TouchExplorationStateChangeListener mListener;

        TouchExplorationStateChangeListenerWrapper(@NonNull TouchExplorationStateChangeListener r10) {
            this.mListener = r10;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof TouchExplorationStateChangeListenerWrapper) == true) goto L10;
            return false;
        L10:
            return this.mListener.equals(((TouchExplorationStateChangeListenerWrapper) r10).mListener);
        }

        public int hashCode() {
            return this.mListener.hashCode();
        }

        @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
        public void onTouchExplorationStateChanged(boolean r10) {
            this.mListener.onTouchExplorationStateChanged(r10);
        }
    }

    private AccessibilityManagerCompat() {
    }

    @Deprecated
    public static boolean addAccessibilityStateChangeListener(AccessibilityManager r10, AccessibilityStateChangeListener r11) {
        if (r11 != null) goto L6;
        return false;
    L6:
        return r10.addAccessibilityStateChangeListener(new AccessibilityStateChangeListenerWrapper(r11));
    }

    public static boolean addTouchExplorationStateChangeListener(@NonNull AccessibilityManager r10, @NonNull TouchExplorationStateChangeListener r11) {
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        return false;
    L5:
        return Api19Impl.addTouchExplorationStateChangeListenerWrapper(r10, r11);
    }

    @Deprecated
    public static List<AccessibilityServiceInfo> getEnabledAccessibilityServiceList(AccessibilityManager r10, int r11) {
        return r10.getEnabledAccessibilityServiceList(r11);
    }

    @Deprecated
    public static List<AccessibilityServiceInfo> getInstalledAccessibilityServiceList(AccessibilityManager r10) {
        return r10.getInstalledAccessibilityServiceList();
    }

    @Deprecated
    public static boolean isTouchExplorationEnabled(AccessibilityManager r10) {
        return r10.isTouchExplorationEnabled();
    }

    @Deprecated
    public static boolean removeAccessibilityStateChangeListener(AccessibilityManager r10, AccessibilityStateChangeListener r11) {
        if (r11 != null) goto L6;
        return false;
    L6:
        return r10.removeAccessibilityStateChangeListener(new AccessibilityStateChangeListenerWrapper(r11));
    }

    public static boolean removeTouchExplorationStateChangeListener(@NonNull AccessibilityManager r10, @NonNull TouchExplorationStateChangeListener r11) {
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        return false;
    L5:
        return Api19Impl.removeTouchExplorationStateChangeListenerWrapper(r10, r11);
    }
}
