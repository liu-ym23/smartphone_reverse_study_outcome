package androidx.core.view;

import android.os.Build;
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

    @RequiresApi(19)
    static class Api19Impl {
        private Api19Impl() {
        }

        @DoNotInline
        static void notifySubtreeAccessibilityStateChanged(ViewParent r10, View r11, View r12, int r13) {
            r10.notifySubtreeAccessibilityStateChanged(r11, r12, r13);
        }
    }

    @RequiresApi(21)
    static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static boolean onNestedFling(ViewParent r10, View r11, float r12, float r13, boolean r14) {
            return r10.onNestedFling(r11, r12, r13, r14);
        }

        @DoNotInline
        static boolean onNestedPreFling(ViewParent r10, View r11, float r12, float r13) {
            return r10.onNestedPreFling(r11, r12, r13);
        }

        @DoNotInline
        static void onNestedPreScroll(ViewParent r10, View r11, int r12, int r13, int[] r14) {
            r10.onNestedPreScroll(r11, r12, r13, r14);
        }

        @DoNotInline
        static void onNestedScroll(ViewParent r10, View r11, int r12, int r13, int r14, int r15) {
            r10.onNestedScroll(r11, r12, r13, r14, r15);
        }

        @DoNotInline
        static void onNestedScrollAccepted(ViewParent r10, View r11, View r12, int r13) {
            r10.onNestedScrollAccepted(r11, r12, r13);
        }

        @DoNotInline
        static boolean onStartNestedScroll(ViewParent r10, View r11, View r12, int r13) {
            return r10.onStartNestedScroll(r11, r12, r13);
        }

        @DoNotInline
        static void onStopNestedScroll(ViewParent r10, View r11) {
            r10.onStopNestedScroll(r11);
        }
    }

    private ViewParentCompat() {
    }

    private static int[] getTempNestedScrollConsumed() {
        int[] r10 = sTempNestedScrollConsumed;
        if (r10 != null) goto L5;
        sTempNestedScrollConsumed = new int[2];
    L7:
        return sTempNestedScrollConsumed;
    L5:
        r10[0] = 0;
        r10[1] = 0;
        goto L7
    }

    public static void notifySubtreeAccessibilityStateChanged(@NonNull ViewParent r10, @NonNull View r11, @NonNull View r12, int r13) {
        if (Build.VERSION.SDK_INT < 19) goto L6;
        Api19Impl.notifySubtreeAccessibilityStateChanged(r10, r11, r12, r13);
        return;
    }

    public static boolean onNestedFling(@NonNull ViewParent r10, @NonNull View r11, float r12, float r13, boolean r14) {
        if (Build.VERSION.SDK_INT < 21) goto L9;
        return Api21Impl.onNestedFling(r10, r11, r12, r13, r14);
    L6:
        e = move-exception;
        Log.e(TAG, "ViewParent " + r10 + " does not implement interface method onNestedFling", e);
        return false;
    L9:
        if ((r10 instanceof NestedScrollingParent) == true) goto L11;
        return false;
    L11:
        return ((NestedScrollingParent) r10).onNestedFling(r11, r12, r13, r14);
    }

    public static boolean onNestedPreFling(@NonNull ViewParent r10, @NonNull View r11, float r12, float r13) {
        if (Build.VERSION.SDK_INT < 21) goto L9;
        return Api21Impl.onNestedPreFling(r10, r11, r12, r13);
    L6:
        e = move-exception;
        Log.e(TAG, "ViewParent " + r10 + " does not implement interface method onNestedPreFling", e);
        return false;
    L9:
        if ((r10 instanceof NestedScrollingParent) == true) goto L11;
        return false;
    L11:
        return ((NestedScrollingParent) r10).onNestedPreFling(r11, r12, r13);
    }

    public static void onNestedPreScroll(@NonNull ViewParent r10, @NonNull View r11, int r12, int r13, @NonNull int[] r14) {
        onNestedPreScroll(r10, r11, r12, r13, r14, 0);
    }

    public static void onNestedPreScroll(@NonNull ViewParent r10, @NonNull View r11, int r12, int r13, @NonNull int[] r14, int r15) {
        if ((r10 instanceof NestedScrollingParent2) == false) goto L5;
        ((NestedScrollingParent2) r10).onNestedPreScroll(r11, r12, r13, r14, r15);
        return;
    L5:
        if (r15 == 0) goto L7;
        return;
    L7:
        if (Build.VERSION.SDK_INT < 21) goto L13;
        Api21Impl.onNestedPreScroll(r10, r11, r12, r13, r14);     // Catch: AbstractMethodError -> L10
        return;
    L10:
        e = move-exception;
        Log.e(TAG, "ViewParent " + r10 + " does not implement interface method onNestedPreScroll", e);
        return;
    L13:
        if ((r10 instanceof NestedScrollingParent) == false) goto L21;
        ((NestedScrollingParent) r10).onNestedPreScroll(r11, r12, r13, r14);
        return;
    }

    public static void onNestedScroll(@NonNull ViewParent r10, @NonNull View r11, int r12, int r13, int r14, int r15) {
        onNestedScroll(r10, r11, r12, r13, r14, r15, 0, getTempNestedScrollConsumed());
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
        if (r16 == 0) goto L10;
        return;
    L10:
        if (Build.VERSION.SDK_INT < 21) goto L16;
        Api21Impl.onNestedScroll(r10, r11, r12, r13, r14, r15);     // Catch: AbstractMethodError -> L13
        return;
    L13:
        e = move-exception;
        Log.e(TAG, "ViewParent " + r10 + " does not implement interface method onNestedScroll", e);
        return;
    L16:
        if ((r10 instanceof NestedScrollingParent) == false) goto L25;
        ((NestedScrollingParent) r10).onNestedScroll(r11, r12, r13, r14, r15);
        return;
    }

    public static void onNestedScrollAccepted(@NonNull ViewParent r10, @NonNull View r11, @NonNull View r12, int r13) {
        onNestedScrollAccepted(r10, r11, r12, r13, 0);
    }

    public static void onNestedScrollAccepted(@NonNull ViewParent r10, @NonNull View r11, @NonNull View r12, int r13, int r14) {
        if ((r10 instanceof NestedScrollingParent2) == false) goto L5;
        ((NestedScrollingParent2) r10).onNestedScrollAccepted(r11, r12, r13, r14);
        return;
    L5:
        if (r14 == 0) goto L7;
        return;
    L7:
        if (Build.VERSION.SDK_INT < 21) goto L13;
        Api21Impl.onNestedScrollAccepted(r10, r11, r12, r13);     // Catch: AbstractMethodError -> L10
        return;
    L10:
        e = move-exception;
        Log.e(TAG, "ViewParent " + r10 + " does not implement interface method onNestedScrollAccepted", e);
        return;
    L13:
        if ((r10 instanceof NestedScrollingParent) == false) goto L21;
        ((NestedScrollingParent) r10).onNestedScrollAccepted(r11, r12, r13);
        return;
    }

    public static boolean onStartNestedScroll(@NonNull ViewParent r10, @NonNull View r11, @NonNull View r12, int r13) {
        return onStartNestedScroll(r10, r11, r12, r13, 0);
    }

    public static boolean onStartNestedScroll(@NonNull ViewParent r10, @NonNull View r11, @NonNull View r12, int r13, int r14) {
        if ((r10 instanceof NestedScrollingParent2) == true) goto L5;
        if (r14 == 0) goto L8;
        return false;
    L8:
        if (Build.VERSION.SDK_INT < 21) goto L14;
        return Api21Impl.onStartNestedScroll(r10, r11, r12, r13);
    L11:
        e = move-exception;
        Log.e(TAG, "ViewParent " + r10 + " does not implement interface method onStartNestedScroll", e);
        return false;
    L14:
        if ((r10 instanceof NestedScrollingParent) == true) goto L16;
        return false;
    L16:
        return ((NestedScrollingParent) r10).onStartNestedScroll(r11, r12, r13);
    L5:
        return ((NestedScrollingParent2) r10).onStartNestedScroll(r11, r12, r13, r14);
    }

    public static void onStopNestedScroll(@NonNull ViewParent r10, @NonNull View r11) {
        onStopNestedScroll(r10, r11, 0);
    }

    public static void onStopNestedScroll(@NonNull ViewParent r10, @NonNull View r11, int r12) {
        if ((r10 instanceof NestedScrollingParent2) == false) goto L5;
        ((NestedScrollingParent2) r10).onStopNestedScroll(r11, r12);
        return;
    L5:
        if (r12 == 0) goto L7;
        return;
    L7:
        if (Build.VERSION.SDK_INT < 21) goto L13;
        Api21Impl.onStopNestedScroll(r10, r11);     // Catch: AbstractMethodError -> L10
        return;
    L10:
        e = move-exception;
        Log.e(TAG, "ViewParent " + r10 + " does not implement interface method onStopNestedScroll", e);
        return;
    L13:
        if ((r10 instanceof NestedScrollingParent) == false) goto L21;
        ((NestedScrollingParent) r10).onStopNestedScroll(r11);
        return;
    }

    @Deprecated
    public static boolean requestSendAccessibilityEvent(ViewParent r10, View r11, AccessibilityEvent r12) {
        return r10.requestSendAccessibilityEvent(r11, r12);
    }
}
