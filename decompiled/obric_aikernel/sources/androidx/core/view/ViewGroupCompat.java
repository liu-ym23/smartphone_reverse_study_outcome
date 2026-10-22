package androidx.core.view;

import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.R;

/* JADX INFO: loaded from: classes.dex */
public final class ViewGroupCompat {
    public static final int LAYOUT_MODE_CLIP_BOUNDS = 0;
    public static final int LAYOUT_MODE_OPTICAL_BOUNDS = 1;

    @RequiresApi(18)
    static class Api18Impl {
        private Api18Impl() {
        }

        @DoNotInline
        static int getLayoutMode(ViewGroup r10) {
            return r10.getLayoutMode();
        }

        @DoNotInline
        static void setLayoutMode(ViewGroup r10, int r11) {
            r10.setLayoutMode(r11);
        }
    }

    @RequiresApi(21)
    static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static int getNestedScrollAxes(ViewGroup r10) {
            return r10.getNestedScrollAxes();
        }

        @DoNotInline
        static boolean isTransitionGroup(ViewGroup r10) {
            return r10.isTransitionGroup();
        }

        @DoNotInline
        static void setTransitionGroup(ViewGroup r10, boolean r11) {
            r10.setTransitionGroup(r11);
        }
    }

    private ViewGroupCompat() {
    }

    public static int getLayoutMode(@NonNull ViewGroup r10) {
        if (Build.VERSION.SDK_INT >= 18) goto L5;
        return 0;
    L5:
        return Api18Impl.getLayoutMode(r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static int getNestedScrollAxes(@NonNull ViewGroup r10) {
        if (Build.VERSION.SDK_INT < 21) goto L7;
        return Api21Impl.getNestedScrollAxes(r10);
    L7:
        if ((r10 instanceof NestedScrollingParent) == true) goto L9;
        return 0;
    L9:
        return ((NestedScrollingParent) r10).getNestedScrollAxes();
    }

    public static boolean isTransitionGroup(@NonNull ViewGroup r10) {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        Boolean r11 = (Boolean) r10.getTag(R.id.tag_transition_group);
        if (r11 == null) goto L11;
        if (r11.booleanValue() == false) goto L11;
    L16:
        return true;
    L11:
        if (r10.getBackground() != null) goto L16;
        if (ViewCompat.getTransitionName(r10) != null) goto L16;
        return false;
    L5:
        return Api21Impl.isTransitionGroup(r10);
    }

    @Deprecated
    public static boolean onRequestSendAccessibilityEvent(ViewGroup r10, View r11, AccessibilityEvent r12) {
        return r10.onRequestSendAccessibilityEvent(r11, r12);
    }

    public static void setLayoutMode(@NonNull ViewGroup r10, int r11) {
        if (Build.VERSION.SDK_INT < 18) goto L6;
        Api18Impl.setLayoutMode(r10, r11);
        return;
    }

    @Deprecated
    public static void setMotionEventSplittingEnabled(ViewGroup r10, boolean r11) {
        r10.setMotionEventSplittingEnabled(r11);
    }

    public static void setTransitionGroup(@NonNull ViewGroup r10, boolean r11) {
        if (Build.VERSION.SDK_INT < 21) goto L5;
        Api21Impl.setTransitionGroup(r10, r11);
        return;
    L5:
        r10.setTag(R.id.tag_transition_group, Boolean.valueOf(r11));
    }
}
