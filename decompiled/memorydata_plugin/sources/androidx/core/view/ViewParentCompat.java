package androidx.core.view;

import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public final class ViewParentCompat {
    private static final String TAG = "ViewParentCompat";
    private static int[] sTempNestedScrollConsumed;

    static class Api19Impl {
        private Api19Impl() {
        }

        static void notifySubtreeAccessibilityStateChanged(ViewParent r2, View r3, View r4, int r5) {
            ((ViewParent) ZeusTransformUtils.wrapperContextForParams(r2, ViewParent.class, "com.obric.memorydata.plugin")).notifySubtreeAccessibilityStateChanged(r3, r4, r5);
        }
    }

    static class Api21Impl {
        private Api21Impl() {
        }

        static boolean onNestedFling(ViewParent r2, View r3, float r4, float r5, boolean r6) {
            return ((ViewParent) ZeusTransformUtils.wrapperContextForParams(r2, ViewParent.class, "com.obric.memorydata.plugin")).onNestedFling(r3, r4, r5, r6);
        }

        static boolean onNestedPreFling(ViewParent r2, View r3, float r4, float r5) {
            return ((ViewParent) ZeusTransformUtils.wrapperContextForParams(r2, ViewParent.class, "com.obric.memorydata.plugin")).onNestedPreFling(r3, r4, r5);
        }

        static void onNestedPreScroll(ViewParent r2, View r3, int r4, int r5, int[] r6) {
            ((ViewParent) ZeusTransformUtils.wrapperContextForParams(r2, ViewParent.class, "com.obric.memorydata.plugin")).onNestedPreScroll(r3, r4, r5, r6);
        }

        static void onNestedScroll(ViewParent r6, View r7, int r8, int r9, int r10, int r11) {
            ((ViewParent) ZeusTransformUtils.wrapperContextForParams(r6, ViewParent.class, "com.obric.memorydata.plugin")).onNestedScroll(r7, r8, r9, r10, r11);
        }

        static void onNestedScrollAccepted(ViewParent r2, View r3, View r4, int r5) {
            ((ViewParent) ZeusTransformUtils.wrapperContextForParams(r2, ViewParent.class, "com.obric.memorydata.plugin")).onNestedScrollAccepted(r3, r4, r5);
        }

        static boolean onStartNestedScroll(ViewParent r2, View r3, View r4, int r5) {
            return ((ViewParent) ZeusTransformUtils.wrapperContextForParams(r2, ViewParent.class, "com.obric.memorydata.plugin")).onStartNestedScroll(r3, r4, r5);
        }

        static void onStopNestedScroll(ViewParent r2, View r3) {
            ((ViewParent) ZeusTransformUtils.wrapperContextForParams(r2, ViewParent.class, "com.obric.memorydata.plugin")).onStopNestedScroll(r3);
        }
    }

    private ViewParentCompat() {
    }

    private static int[] getTempNestedScrollConsumed() {
        int[] r0 = sTempNestedScrollConsumed;
        if (r0 != null) goto L5;
        sTempNestedScrollConsumed = new int[2];
    L7:
        return sTempNestedScrollConsumed;
    L5:
        r0[0] = 0;
        r0[1] = 0;
        goto L7
    }

    public static void notifySubtreeAccessibilityStateChanged(ViewParent r2, View r3, View r4, int r5) {
        ViewParent r6 = (ViewParent) ZeusTransformUtils.wrapperContextForParams(r2, ViewParent.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 19) goto L6;
        Api19Impl.notifySubtreeAccessibilityStateChanged(r6, r3, r4, r5);
        return;
    }

    public static boolean onNestedFling(ViewParent r3, View r4, float r5, float r6, boolean r7) {
        ViewParent r8 = (ViewParent) ZeusTransformUtils.wrapperContextForParams(r3, ViewParent.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 21) goto L9;
        return Api21Impl.onNestedFling(r8, r4, r5, r6, r7);
    L6:
        e = move-exception;
        Log.e(TAG, "ViewParent " + r8 + " does not implement interface method onNestedFling", e);
        return false;
    L9:
        if (ZeusTransformUtils.instanceOf(r8, NestedScrollingParent.class) == true) goto L11;
        return false;
    L11:
        return ((NestedScrollingParent) ZeusTransformUtils.preCheckCast(r8, NestedScrollingParent.class, "com.obric.memorydata.plugin")).onNestedFling(r4, r5, r6, r7);
    }

    public static boolean onNestedPreFling(ViewParent r3, View r4, float r5, float r6) {
        ViewParent r7 = (ViewParent) ZeusTransformUtils.wrapperContextForParams(r3, ViewParent.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 21) goto L9;
        return Api21Impl.onNestedPreFling(r7, r4, r5, r6);
    L6:
        e = move-exception;
        Log.e(TAG, "ViewParent " + r7 + " does not implement interface method onNestedPreFling", e);
        return false;
    L9:
        if (ZeusTransformUtils.instanceOf(r7, NestedScrollingParent.class) == true) goto L11;
        return false;
    L11:
        return ((NestedScrollingParent) ZeusTransformUtils.preCheckCast(r7, NestedScrollingParent.class, "com.obric.memorydata.plugin")).onNestedPreFling(r4, r5, r6);
    }

    public static void onNestedPreScroll(ViewParent r6, View r7, int r8, int r9, int[] r10) {
        onNestedPreScroll((ViewParent) ZeusTransformUtils.wrapperContextForParams(r6, ViewParent.class, "com.obric.memorydata.plugin"), r7, r8, r9, r10, 0);
    }

    public static void onNestedPreScroll(ViewParent r6, View r7, int r8, int r9, int[] r10, int r11) {
        ViewParent r12 = (ViewParent) ZeusTransformUtils.wrapperContextForParams(r6, ViewParent.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r12, NestedScrollingParent2.class) == false) goto L5;
        ((NestedScrollingParent2) ZeusTransformUtils.preCheckCast(r12, NestedScrollingParent2.class, "com.obric.memorydata.plugin")).onNestedPreScroll(r7, r8, r9, r10, r11);
        return;
    L5:
        if (r11 == 0) goto L7;
        return;
    L7:
        if (Build.VERSION.SDK_INT < 21) goto L13;
        Api21Impl.onNestedPreScroll(r12, r7, r8, r9, r10);     // Catch: AbstractMethodError -> L10
        return;
    L10:
        e = move-exception;
        Log.e(TAG, "ViewParent " + r12 + " does not implement interface method onNestedPreScroll", e);
        return;
    L13:
        if (ZeusTransformUtils.instanceOf(r12, NestedScrollingParent.class) == false) goto L21;
        ((NestedScrollingParent) ZeusTransformUtils.preCheckCast(r12, NestedScrollingParent.class, "com.obric.memorydata.plugin")).onNestedPreScroll(r7, r8, r9, r10);
        return;
    }

    public static void onNestedScroll(ViewParent r8, View r9, int r10, int r11, int r12, int r13) {
        onNestedScroll((ViewParent) ZeusTransformUtils.wrapperContextForParams(r8, ViewParent.class, "com.obric.memorydata.plugin"), r9, r10, r11, r12, r13, 0, getTempNestedScrollConsumed());
    }

    public static void onNestedScroll(ViewParent r8, View r9, int r10, int r11, int r12, int r13, int r14) {
        onNestedScroll((ViewParent) ZeusTransformUtils.wrapperContextForParams(r8, ViewParent.class, "com.obric.memorydata.plugin"), r9, r10, r11, r12, r13, r14, getTempNestedScrollConsumed());
    }

    public static void onNestedScroll(ViewParent r8, View r9, int r10, int r11, int r12, int r13, int r14, int[] r15) {
        ViewParent r16 = (ViewParent) ZeusTransformUtils.wrapperContextForParams(r8, ViewParent.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r16, NestedScrollingParent3.class) == false) goto L5;
        ((NestedScrollingParent3) ZeusTransformUtils.preCheckCast(r16, NestedScrollingParent3.class, "com.obric.memorydata.plugin")).onNestedScroll(r9, r10, r11, r12, r13, r14, r15);
        return;
    L5:
        r15[0] = r15[0] + r12;
        r15[1] = r15[1] + r13;
        if (ZeusTransformUtils.instanceOf(r16, NestedScrollingParent2.class) == false) goto L8;
        ((NestedScrollingParent2) ZeusTransformUtils.preCheckCast(r16, NestedScrollingParent2.class, "com.obric.memorydata.plugin")).onNestedScroll(r9, r10, r11, r12, r13, r14);
        return;
    L8:
        if (r14 == 0) goto L10;
        return;
    L10:
        if (Build.VERSION.SDK_INT < 21) goto L17;
        Api21Impl.onNestedScroll(r16, r9, r10, r11, r12, r13);     // Catch: AbstractMethodError -> L14
        return;
    L14:
        e = move-exception;
        Log.e(TAG, "ViewParent " + r16 + " does not implement interface method onNestedScroll", e);
        return;
    L17:
        if (ZeusTransformUtils.instanceOf(r16, NestedScrollingParent.class) == false) goto L26;
        ((NestedScrollingParent) ZeusTransformUtils.preCheckCast(r16, NestedScrollingParent.class, "com.obric.memorydata.plugin")).onNestedScroll(r9, r10, r11, r12, r13);
        return;
    }

    public static void onNestedScrollAccepted(ViewParent r2, View r3, View r4, int r5) {
        onNestedScrollAccepted((ViewParent) ZeusTransformUtils.wrapperContextForParams(r2, ViewParent.class, "com.obric.memorydata.plugin"), r3, r4, r5, 0);
    }

    public static void onNestedScrollAccepted(ViewParent r2, View r3, View r4, int r5, int r6) {
        ViewParent r7 = (ViewParent) ZeusTransformUtils.wrapperContextForParams(r2, ViewParent.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r7, NestedScrollingParent2.class) == false) goto L5;
        ((NestedScrollingParent2) ZeusTransformUtils.preCheckCast(r7, NestedScrollingParent2.class, "com.obric.memorydata.plugin")).onNestedScrollAccepted(r3, r4, r5, r6);
        return;
    L5:
        if (r6 == 0) goto L7;
        return;
    L7:
        if (Build.VERSION.SDK_INT < 21) goto L13;
        Api21Impl.onNestedScrollAccepted(r7, r3, r4, r5);     // Catch: AbstractMethodError -> L10
        return;
    L10:
        e = move-exception;
        Log.e(TAG, "ViewParent " + r7 + " does not implement interface method onNestedScrollAccepted", e);
        return;
    L13:
        if (ZeusTransformUtils.instanceOf(r7, NestedScrollingParent.class) == false) goto L21;
        ((NestedScrollingParent) ZeusTransformUtils.preCheckCast(r7, NestedScrollingParent.class, "com.obric.memorydata.plugin")).onNestedScrollAccepted(r3, r4, r5);
        return;
    }

    public static boolean onStartNestedScroll(ViewParent r2, View r3, View r4, int r5) {
        return onStartNestedScroll((ViewParent) ZeusTransformUtils.wrapperContextForParams(r2, ViewParent.class, "com.obric.memorydata.plugin"), r3, r4, r5, 0);
    }

    public static boolean onStartNestedScroll(ViewParent r2, View r3, View r4, int r5, int r6) {
        ViewParent r7 = (ViewParent) ZeusTransformUtils.wrapperContextForParams(r2, ViewParent.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r7, NestedScrollingParent2.class) == true) goto L5;
        if (r6 == 0) goto L8;
        return false;
    L8:
        if (Build.VERSION.SDK_INT < 21) goto L14;
        return Api21Impl.onStartNestedScroll(r7, r3, r4, r5);
    L11:
        e = move-exception;
        Log.e(TAG, "ViewParent " + r7 + " does not implement interface method onStartNestedScroll", e);
        return false;
    L14:
        if (ZeusTransformUtils.instanceOf(r7, NestedScrollingParent.class) == true) goto L16;
        return false;
    L16:
        return ((NestedScrollingParent) ZeusTransformUtils.preCheckCast(r7, NestedScrollingParent.class, "com.obric.memorydata.plugin")).onStartNestedScroll(r3, r4, r5);
    L5:
        return ((NestedScrollingParent2) ZeusTransformUtils.preCheckCast(r7, NestedScrollingParent2.class, "com.obric.memorydata.plugin")).onStartNestedScroll(r3, r4, r5, r6);
    }

    public static void onStopNestedScroll(ViewParent r2, View r3) {
        onStopNestedScroll((ViewParent) ZeusTransformUtils.wrapperContextForParams(r2, ViewParent.class, "com.obric.memorydata.plugin"), r3, 0);
    }

    public static void onStopNestedScroll(ViewParent r2, View r3, int r4) {
        ViewParent r5 = (ViewParent) ZeusTransformUtils.wrapperContextForParams(r2, ViewParent.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, NestedScrollingParent2.class) == false) goto L5;
        ((NestedScrollingParent2) ZeusTransformUtils.preCheckCast(r5, NestedScrollingParent2.class, "com.obric.memorydata.plugin")).onStopNestedScroll(r3, r4);
        return;
    L5:
        if (r4 == 0) goto L7;
        return;
    L7:
        if (Build.VERSION.SDK_INT < 21) goto L13;
        Api21Impl.onStopNestedScroll(r5, r3);     // Catch: AbstractMethodError -> L10
        return;
    L10:
        e = move-exception;
        Log.e(TAG, "ViewParent " + r5 + " does not implement interface method onStopNestedScroll", e);
        return;
    L13:
        if (ZeusTransformUtils.instanceOf(r5, NestedScrollingParent.class) == false) goto L21;
        ((NestedScrollingParent) ZeusTransformUtils.preCheckCast(r5, NestedScrollingParent.class, "com.obric.memorydata.plugin")).onStopNestedScroll(r3);
        return;
    }

    @Deprecated
    public static boolean requestSendAccessibilityEvent(ViewParent r2, View r3, AccessibilityEvent r4) {
        return ((ViewParent) ZeusTransformUtils.wrapperContextForParams(r2, ViewParent.class, "com.obric.memorydata.plugin")).requestSendAccessibilityEvent(r3, r4);
    }
}
