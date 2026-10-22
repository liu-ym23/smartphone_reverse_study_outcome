package androidx.core.view;

import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
public final class ViewParentCompat {
    private static final String TAG = "ViewParentCompat";
    private static int[] sTempNestedScrollConsumed;

    @RequiresApi(21)
    public static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        public static boolean onNestedFling(ViewParent r5, View r10, float r11, float r12, boolean r13) {
            return r5.onNestedFling(r10, r11, r12, r13);
        }

        @DoNotInline
        public static boolean onNestedPreFling(ViewParent r5, View r10, float r11, float r12) {
            return r5.onNestedPreFling(r10, r11, r12);
        }

        @DoNotInline
        public static void onNestedPreScroll(ViewParent r5, View r10, int r11, int r12, int[] r13) {
            r5.onNestedPreScroll(r10, r11, r12, r13);
        }

        @DoNotInline
        public static void onNestedScroll(ViewParent r5, View r10, int r11, int r12, int r13, int r14) {
            r5.onNestedScroll(r10, r11, r12, r13, r14);
        }

        @DoNotInline
        public static void onNestedScrollAccepted(ViewParent r5, View r10, View r11, int r12) {
            r5.onNestedScrollAccepted(r10, r11, r12);
        }

        @DoNotInline
        public static boolean onStartNestedScroll(ViewParent r5, View r10, View r11, int r12) {
            return r5.onStartNestedScroll(r10, r11, r12);
        }

        @DoNotInline
        public static void onStopNestedScroll(ViewParent r5, View r10) {
            r5.onStopNestedScroll(r10);
        }
    }

    private ViewParentCompat() {
    }

    private static int[] getTempNestedScrollConsumed() {
        int[] r5 = sTempNestedScrollConsumed;
        if (r5 != null) goto L5;
        sTempNestedScrollConsumed = new int[2];
    L7:
        return sTempNestedScrollConsumed;
    L5:
        r5[0] = 0;
        r5[1] = 0;
        goto L7
    }

    public static void notifySubtreeAccessibilityStateChanged(@NonNull ViewParent r5, @NonNull View r10, @NonNull View r11, int r12) {
        r5.notifySubtreeAccessibilityStateChanged(r10, r11, r12);
    }

    public static boolean onNestedFling(@NonNull ViewParent r5, @NonNull View r10, float r11, float r12, boolean r13) {
        return Api21Impl.onNestedFling(r5, r10, r11, r12, r13);
    L4:
        e = move-exception;
        Log.e(TAG, "ViewParent " + r5 + " does not implement interface method onNestedFling", e);
        return false;
    }

    public static boolean onNestedPreFling(@NonNull ViewParent r5, @NonNull View r10, float r11, float r12) {
        return Api21Impl.onNestedPreFling(r5, r10, r11, r12);
    L4:
        e = move-exception;
        Log.e(TAG, "ViewParent " + r5 + " does not implement interface method onNestedPreFling", e);
        return false;
    }

    public static void onNestedPreScroll(@NonNull ViewParent r10, @NonNull View r11, int r12, int r13, @NonNull int[] r14) {
        onNestedPreScroll(r10, r11, r12, r13, r14, 0);
    }

    public static void onNestedScroll(@NonNull ViewParent r10, @NonNull View r11, int r12, int r13, int r14, int r15) {
        onNestedScroll(r10, r11, r12, r13, r14, r15, 0, getTempNestedScrollConsumed());
    }

    public static void onNestedScrollAccepted(@NonNull ViewParent r5, @NonNull View r10, @NonNull View r11, int r12) {
        onNestedScrollAccepted(r5, r10, r11, r12, 0);
    }

    public static boolean onStartNestedScroll(@NonNull ViewParent r5, @NonNull View r10, @NonNull View r11, int r12) {
        return onStartNestedScroll(r5, r10, r11, r12, 0);
    }

    public static void onStopNestedScroll(@NonNull ViewParent r5, @NonNull View r10) {
        onStopNestedScroll(r5, r10, 0);
    }

    @Deprecated
    public static boolean requestSendAccessibilityEvent(ViewParent r5, View r10, AccessibilityEvent r11) {
        return r5.requestSendAccessibilityEvent(r10, r11);
    }

    public static void onNestedPreScroll(@NonNull ViewParent r10, @NonNull View r11, int r12, int r13, @NonNull int[] r14, int r15) {
        if ((r10 instanceof NestedScrollingParent2) == false) goto L5;
        ((NestedScrollingParent2) r10).onNestedPreScroll(r11, r12, r13, r14, r15);
        return;
    L5:
        if (r15 != 0) goto L14;
        Api21Impl.onNestedPreScroll(r10, r11, r12, r13, r14);     // Catch: AbstractMethodError -> L8
        return;
    L8:
        e = move-exception;
        Log.e(TAG, "ViewParent " + r10 + " does not implement interface method onNestedPreScroll", e);
        return;
    }

    public static void onNestedScrollAccepted(@NonNull ViewParent r5, @NonNull View r10, @NonNull View r11, int r12, int r13) {
        if ((r5 instanceof NestedScrollingParent2) == false) goto L5;
        ((NestedScrollingParent2) r5).onNestedScrollAccepted(r10, r11, r12, r13);
        return;
    L5:
        if (r13 != 0) goto L14;
        Api21Impl.onNestedScrollAccepted(r5, r10, r11, r12);     // Catch: AbstractMethodError -> L8
        return;
    L8:
        e = move-exception;
        Log.e(TAG, "ViewParent " + r5 + " does not implement interface method onNestedScrollAccepted", e);
        return;
    }

    public static boolean onStartNestedScroll(@NonNull ViewParent r5, @NonNull View r10, @NonNull View r11, int r12, int r13) {
        if ((r5 instanceof NestedScrollingParent2) == true) goto L5;
        if (r13 != 0) goto L15;
        return Api21Impl.onStartNestedScroll(r5, r10, r11, r12);
    L9:
        e = move-exception;
        Log.e(TAG, "ViewParent " + r5 + " does not implement interface method onStartNestedScroll", e);
        return false;
    L15:
        return false;
    L5:
        return ((NestedScrollingParent2) r5).onStartNestedScroll(r10, r11, r12, r13);
    }

    public static void onStopNestedScroll(@NonNull ViewParent r5, @NonNull View r10, int r11) {
        if ((r5 instanceof NestedScrollingParent2) == false) goto L5;
        ((NestedScrollingParent2) r5).onStopNestedScroll(r10, r11);
        return;
    L5:
        if (r11 != 0) goto L14;
        Api21Impl.onStopNestedScroll(r5, r10);     // Catch: AbstractMethodError -> L8
        return;
    L8:
        e = move-exception;
        Log.e(TAG, "ViewParent " + r5 + " does not implement interface method onStopNestedScroll", e);
        return;
    }

    public static void onNestedScroll(@NonNull ViewParent r10, @NonNull View r11, int r12, int r13, int r14, int r15, int r16) {
        onNestedScroll(r10, r11, r12, r13, r14, r15, r16, getTempNestedScrollConsumed());
    }

    public static void onNestedScroll(@NonNull ViewParent r10, @NonNull View r11, int r12, int r13, int r14, int r15, int r16, @NonNull int[] r17) {
        if ((r10 instanceof NestedScrollingParent3) == false) goto L5;
        ((NestedScrollingParent3) r10).onNestedScroll(r11, r12, r13, r14, r15, r16, r17);
        return;
    L5:
        r17[0] = r17[0] + r14;
        r17[1] = r17[1] + r15;
        if ((r10 instanceof NestedScrollingParent2) == false) goto L8;
        ((NestedScrollingParent2) r10).onNestedScroll(r11, r12, r13, r14, r15, r16);
        return;
    L8:
        if (r16 != 0) goto L18;
        Api21Impl.onNestedScroll(r10, r11, r12, r13, r14, r15);     // Catch: AbstractMethodError -> L11
        return;
    L11:
        e = move-exception;
        Log.e(TAG, "ViewParent " + r10 + " does not implement interface method onNestedScroll", e);
        return;
    }
}
