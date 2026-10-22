package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
public final class ViewGroupCompat {
    public static final int LAYOUT_MODE_CLIP_BOUNDS = 0;
    public static final int LAYOUT_MODE_OPTICAL_BOUNDS = 1;

    @RequiresApi(21)
    public static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        public static int getNestedScrollAxes(ViewGroup r5) {
            return r5.getNestedScrollAxes();
        }

        @DoNotInline
        public static boolean isTransitionGroup(ViewGroup r5) {
            return r5.isTransitionGroup();
        }

        @DoNotInline
        public static void setTransitionGroup(ViewGroup r5, boolean r10) {
            r5.setTransitionGroup(r10);
        }
    }

    private ViewGroupCompat() {
    }

    public static int getLayoutMode(@NonNull ViewGroup r5) {
        return r5.getLayoutMode();
    }

    public static int getNestedScrollAxes(@NonNull ViewGroup r5) {
        return Api21Impl.getNestedScrollAxes(r5);
    }

    public static boolean isTransitionGroup(@NonNull ViewGroup r5) {
        return Api21Impl.isTransitionGroup(r5);
    }

    @Deprecated
    public static boolean onRequestSendAccessibilityEvent(ViewGroup r5, View r10, AccessibilityEvent r11) {
        return r5.onRequestSendAccessibilityEvent(r10, r11);
    }

    public static void setLayoutMode(@NonNull ViewGroup r5, int r10) {
        r5.setLayoutMode(r10);
    }

    @Deprecated
    public static void setMotionEventSplittingEnabled(ViewGroup r5, boolean r10) {
        r5.setMotionEventSplittingEnabled(r10);
    }

    public static void setTransitionGroup(@NonNull ViewGroup r5, boolean r10) {
        Api21Impl.setTransitionGroup(r5, r10);
    }
}
