package androidx.core.view;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContentInfo;
import android.view.Display;
import android.view.KeyEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.autofill.AutofillId;
import android.view.contentcapture.ContentCaptureSession;
import androidx.collection.SimpleArrayMap;
import androidx.core.util.Preconditions;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.core.view.autofill.AutofillIdCompat;
import androidx.core.view.contentcapture.ContentCaptureSessionCompat;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class ViewCompat {
    private static final int[] ACCESSIBILITY_ACTIONS_RESOURCE_IDS = null;
    public static final int ACCESSIBILITY_LIVE_REGION_ASSERTIVE = 2;
    public static final int ACCESSIBILITY_LIVE_REGION_NONE = 0;
    public static final int ACCESSIBILITY_LIVE_REGION_POLITE = 1;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_AUTO = 0;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_NO = 2;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_NO_HIDE_DESCENDANTS = 4;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_YES = 1;
    public static final int IMPORTANT_FOR_CONTENT_CAPTURE_AUTO = 0;
    public static final int IMPORTANT_FOR_CONTENT_CAPTURE_NO = 2;
    public static final int IMPORTANT_FOR_CONTENT_CAPTURE_NO_EXCLUDE_DESCENDANTS = 8;
    public static final int IMPORTANT_FOR_CONTENT_CAPTURE_YES = 1;
    public static final int IMPORTANT_FOR_CONTENT_CAPTURE_YES_EXCLUDE_DESCENDANTS = 4;

    @Deprecated
    public static final int LAYER_TYPE_HARDWARE = 2;

    @Deprecated
    public static final int LAYER_TYPE_NONE = 0;

    @Deprecated
    public static final int LAYER_TYPE_SOFTWARE = 1;
    public static final int LAYOUT_DIRECTION_INHERIT = 2;
    public static final int LAYOUT_DIRECTION_LOCALE = 3;
    public static final int LAYOUT_DIRECTION_LTR = 0;
    public static final int LAYOUT_DIRECTION_RTL = 1;

    @Deprecated
    public static final int MEASURED_HEIGHT_STATE_SHIFT = 16;

    @Deprecated
    public static final int MEASURED_SIZE_MASK = 16777215;

    @Deprecated
    public static final int MEASURED_STATE_MASK = -16777216;

    @Deprecated
    public static final int MEASURED_STATE_TOO_SMALL = 16777216;
    private static final OnReceiveContentViewBehavior NO_OP_ON_RECEIVE_CONTENT_VIEW_BEHAVIOR = null;

    @Deprecated
    public static final int OVER_SCROLL_ALWAYS = 0;

    @Deprecated
    public static final int OVER_SCROLL_IF_CONTENT_SCROLLS = 1;

    @Deprecated
    public static final int OVER_SCROLL_NEVER = 2;
    public static final int SCROLL_AXIS_HORIZONTAL = 1;
    public static final int SCROLL_AXIS_NONE = 0;
    public static final int SCROLL_AXIS_VERTICAL = 2;
    public static final int SCROLL_INDICATOR_BOTTOM = 2;
    public static final int SCROLL_INDICATOR_END = 32;
    public static final int SCROLL_INDICATOR_LEFT = 4;
    public static final int SCROLL_INDICATOR_RIGHT = 8;
    public static final int SCROLL_INDICATOR_START = 16;
    public static final int SCROLL_INDICATOR_TOP = 1;
    private static final String TAG = "ViewCompat";
    public static final int TYPE_NON_TOUCH = 1;
    public static final int TYPE_TOUCH = 0;
    private static boolean sAccessibilityDelegateCheckFailed;
    private static Field sAccessibilityDelegateField;
    private static final AccessibilityPaneVisibilityManager sAccessibilityPaneVisibilityManager = null;
    private static Method sChildrenDrawingOrderMethod;
    private static Method sDispatchFinishTemporaryDetach;
    private static Method sDispatchStartTemporaryDetach;
    private static Field sMinHeightField;
    private static boolean sMinHeightFieldFetched;
    private static Field sMinWidthField;
    private static boolean sMinWidthFieldFetched;
    private static final AtomicInteger sNextGeneratedId = null;
    private static boolean sTempDetachBound;
    private static ThreadLocal<Rect> sThreadLocalRect;
    private static WeakHashMap<View, String> sTransitionNameMap;
    private static WeakHashMap<View, ViewPropertyAnimatorCompat> sViewPropertyAnimatorMap;

    static class AccessibilityPaneVisibilityManager implements View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener {
        private final WeakHashMap<View, Boolean> mPanesToVisible;

        AccessibilityPaneVisibilityManager() {
            this.mPanesToVisible = new WeakHashMap();
        }

        private void checkPaneVisibility(View r2, boolean r3) {
            if (r2.isShown() == true) goto L5;
        L7:
            boolean r0 = false;
        L8:
            if (r3 == r0) goto L14;
            if (r0 == false) goto L11;
            int r4 = 16;
        L12:
            ViewCompat.notifyViewAccessibilityStateChangedIfNeeded(r2, r4);
            this.mPanesToVisible.put(r2, Boolean.valueOf(r0));
            return;
        L11:
            r4 = 32;
            goto L12
        L14:
            return;
        L5:
            if (r2.getWindowVisibility() != 0) goto L7;
            r0 = true;
            goto L8
        }

        private void registerForLayoutCallback(View r1) {
            r1.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }

        private void unregisterForLayoutCallback(View r1) {
            Api16Impl.removeOnGlobalLayoutListener(r1.getViewTreeObserver(), this);
        }

        void addAccessibilityPane(View r3) {
            WeakHashMap<View, Boolean> r0 = this.mPanesToVisible;
            if (r3.isShown() == true) goto L5;
        L7:
            boolean r1 = false;
        L8:
            r0.put(r3, Boolean.valueOf(r1));
            r3.addOnAttachStateChangeListener(this);
            if (Api19Impl.isAttachedToWindow(r3) == false) goto L12;
            registerForLayoutCallback(r3);
            return;
        L12:
            return;
        L5:
            if (r3.getWindowVisibility() != 0) goto L7;
            r1 = true;
            goto L8
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (Build.VERSION.SDK_INT >= 28) goto L8;
            Iterator<Map.Entry<View, Boolean>> r0 = this.mPanesToVisible.entrySet().iterator();
        L6:
            if (r0.hasNext() == false) goto L10;
            Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.memorydata.plugin");
            checkPaneVisibility((View) ZeusTransformUtils.preCheckCast(r1.getKey(), View.class, "com.obric.memorydata.plugin"), ((Boolean) ZeusTransformUtils.preCheckCast(r1.getValue(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue());
            goto L6
        L10:
            return;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View r1) {
            registerForLayoutCallback(r1);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View r1) {
        }

        void removeAccessibilityPane(View r2) {
            this.mPanesToVisible.remove(r2);
            r2.removeOnAttachStateChangeListener(this);
            unregisterForLayoutCallback(r2);
        }
    }

    static abstract class AccessibilityViewProperty<T> {
        private final int mContentChangeType;
        private final int mFrameworkMinimumSdk;
        private final int mTagKey;
        private final Class<T> mType;

        AccessibilityViewProperty(int r2, Class<T> r3, int r4) {
            this(r2, r3, 0, r4);
        }

        AccessibilityViewProperty(int r1, Class<T> r2, int r3, int r4) {
            this.mTagKey = r1;
            this.mType = r2;
            this.mContentChangeType = r3;
            this.mFrameworkMinimumSdk = r4;
        }

        private boolean extrasAvailable() {
            if (Build.VERSION.SDK_INT < 19) goto L5;
            return true;
        L5:
            return false;
        }

        private boolean frameworkAvailable() {
            if (Build.VERSION.SDK_INT < this.mFrameworkMinimumSdk) goto L5;
            return true;
        L5:
            return false;
        }

        boolean booleanNullToFalseEquals(Boolean r2, Boolean r3) {
            if (r2 != null) goto L5;
        L7:
            boolean r4 = false;
        L8:
            if (r3 != null) goto L10;
        L12:
            boolean r5 = false;
        L13:
            if (r4 != r5) goto L16;
            return true;
        L16:
            return false;
        L10:
            if (r3.booleanValue() == false) goto L12;
            r5 = true;
            goto L13
        L5:
            if (r2.booleanValue() == false) goto L7;
            r4 = true;
            goto L8
        }

        abstract T frameworkGet(View r1);

        abstract void frameworkSet(View r1, T r2);

        T get(View r2) {
            if (frameworkAvailable() == false) goto L7;
            return frameworkGet(r2);
        L7:
            if (extrasAvailable() == false) goto L11;
            T r3 = (T) r2.getTag(this.mTagKey);
            if (ZeusTransformUtils.instanceOf(this.mType, r3) == false) goto L13;
            return r3;
        L13:
            return null;
        L11:
            return null;
        }

        void set(View r2, T r3) {
            if (frameworkAvailable() == false) goto L6;
            frameworkSet(r2, r3);
            return;
        L6:
            if (extrasAvailable() == true) goto L8;
            return;
        L8:
            if (shouldUpdate(get(r2), r3) == false) goto L13;
            ViewCompat.ensureAccessibilityDelegateCompat(r2);
            r2.setTag(this.mTagKey, r3);
            ViewCompat.notifyViewAccessibilityStateChangedIfNeeded(r2, this.mContentChangeType);
            return;
        }

        boolean shouldUpdate(T r1, T r2) {
            return !r2.equals(r1);
        }
    }

    static class Api15Impl {
        private Api15Impl() {
        }

        static boolean hasOnClickListeners(View r0) {
            return r0.hasOnClickListeners();
        }
    }

    static class Api16Impl {
        private Api16Impl() {
        }

        static AccessibilityNodeProvider getAccessibilityNodeProvider(View r0) {
            return r0.getAccessibilityNodeProvider();
        }

        static boolean getFitsSystemWindows(View r0) {
            return r0.getFitsSystemWindows();
        }

        static int getImportantForAccessibility(View r0) {
            return r0.getImportantForAccessibility();
        }

        static int getMinimumHeight(View r0) {
            return r0.getMinimumHeight();
        }

        static int getMinimumWidth(View r0) {
            return r0.getMinimumWidth();
        }

        static ViewParent getParentForAccessibility(View r0) {
            return r0.getParentForAccessibility();
        }

        static int getWindowSystemUiVisibility(View r0) {
            return r0.getWindowSystemUiVisibility();
        }

        static boolean hasOverlappingRendering(View r0) {
            return r0.hasOverlappingRendering();
        }

        static boolean hasTransientState(View r0) {
            return r0.hasTransientState();
        }

        static boolean performAccessibilityAction(View r0, int r1, Bundle r2) {
            return r0.performAccessibilityAction(r1, r2);
        }

        static void postInvalidateOnAnimation(View r0) {
            r0.postInvalidateOnAnimation();
        }

        static void postInvalidateOnAnimation(View r0, int r1, int r2, int r3, int r4) {
            r0.postInvalidateOnAnimation(r1, r2, r3, r4);
        }

        static void postOnAnimation(View r2, Runnable r3) {
            r2.postOnAnimation((Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin"));
        }

        static void postOnAnimationDelayed(View r2, Runnable r3, long r4) {
            r2.postOnAnimationDelayed((Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin"), r4);
        }

        static void removeOnGlobalLayoutListener(ViewTreeObserver r2, ViewTreeObserver.OnGlobalLayoutListener r3) {
            r2.removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener) ZeusTransformUtils.wrapperContextForParams(r3, ViewTreeObserver.OnGlobalLayoutListener.class, "com.obric.memorydata.plugin"));
        }

        static void requestFitSystemWindows(View r0) {
            r0.requestFitSystemWindows();
        }

        static void setBackground(View r0, Drawable r1) {
            r0.setBackground(r1);
        }

        static void setHasTransientState(View r0, boolean r1) {
            r0.setHasTransientState(r1);
        }

        static void setImportantForAccessibility(View r0, int r1) {
            r0.setImportantForAccessibility(r1);
        }
    }

    static class Api17Impl {
        private Api17Impl() {
        }

        static int generateViewId() {
            return View.generateViewId();
        }

        static Display getDisplay(View r0) {
            return r0.getDisplay();
        }

        static int getLabelFor(View r0) {
            return r0.getLabelFor();
        }

        static int getLayoutDirection(View r0) {
            return r0.getLayoutDirection();
        }

        static int getPaddingEnd(View r0) {
            return r0.getPaddingEnd();
        }

        static int getPaddingStart(View r0) {
            return r0.getPaddingStart();
        }

        static boolean isPaddingRelative(View r0) {
            return r0.isPaddingRelative();
        }

        static void setLabelFor(View r0, int r1) {
            r0.setLabelFor(r1);
        }

        static void setLayerPaint(View r0, Paint r1) {
            r0.setLayerPaint(r1);
        }

        static void setLayoutDirection(View r0, int r1) {
            r0.setLayoutDirection(r1);
        }

        static void setPaddingRelative(View r0, int r1, int r2, int r3, int r4) {
            r0.setPaddingRelative(r1, r2, r3, r4);
        }
    }

    static class Api18Impl {
        private Api18Impl() {
        }

        static Rect getClipBounds(View r0) {
            return r0.getClipBounds();
        }

        static boolean isInLayout(View r0) {
            return r0.isInLayout();
        }

        static void setClipBounds(View r0, Rect r1) {
            r0.setClipBounds(r1);
        }
    }

    static class Api19Impl {
        private Api19Impl() {
        }

        static int getAccessibilityLiveRegion(View r0) {
            return r0.getAccessibilityLiveRegion();
        }

        static boolean isAttachedToWindow(View r0) {
            return r0.isAttachedToWindow();
        }

        static boolean isLaidOut(View r0) {
            return r0.isLaidOut();
        }

        static boolean isLayoutDirectionResolved(View r0) {
            return r0.isLayoutDirectionResolved();
        }

        static void notifySubtreeAccessibilityStateChanged(ViewParent r2, View r3, View r4, int r5) {
            ((ViewParent) ZeusTransformUtils.wrapperContextForParams(r2, ViewParent.class, "com.obric.memorydata.plugin")).notifySubtreeAccessibilityStateChanged(r3, r4, r5);
        }

        static void setAccessibilityLiveRegion(View r0, int r1) {
            r0.setAccessibilityLiveRegion(r1);
        }

        static void setContentChangeTypes(AccessibilityEvent r0, int r1) {
            r0.setContentChangeTypes(r1);
        }
    }

    static class Api20Impl {
        private Api20Impl() {
        }

        static WindowInsets dispatchApplyWindowInsets(View r0, WindowInsets r1) {
            return r0.dispatchApplyWindowInsets(r1);
        }

        static WindowInsets onApplyWindowInsets(View r0, WindowInsets r1) {
            return r0.onApplyWindowInsets(r1);
        }

        static void requestApplyInsets(View r0) {
            r0.requestApplyInsets();
        }
    }

    private static class Api21Impl {
        private Api21Impl() {
        }

        static void callCompatInsetAnimationCallback(WindowInsets r3, View r4) {
            View.OnApplyWindowInsetsListener r0 = (View.OnApplyWindowInsetsListener) ZeusTransformUtils.preCheckCast(r4.getTag(ZeusTransformUtils.mapRes(R.id.tag_window_insets_animation_callback, OaidModel.KEY_ID, "tag_window_insets_animation_callback")), View.OnApplyWindowInsetsListener.class, "com.obric.memorydata.plugin");
            if (r0 == null) goto L6;
            r0.onApplyWindowInsets(r4, r3);
            return;
        }

        static WindowInsetsCompat computeSystemWindowInsets(View r1, WindowInsetsCompat r2, Rect r3) {
            WindowInsets r0 = r2.toWindowInsets();
            if (r0 != null) goto L5;
            r3.setEmpty();
            return r2;
        L5:
            return WindowInsetsCompat.toWindowInsetsCompat(r1.computeSystemWindowInsets(r0, r3), r1);
        }

        static boolean dispatchNestedFling(View r0, float r1, float r2, boolean r3) {
            return r0.dispatchNestedFling(r1, r2, r3);
        }

        static boolean dispatchNestedPreFling(View r0, float r1, float r2) {
            return r0.dispatchNestedPreFling(r1, r2);
        }

        static boolean dispatchNestedPreScroll(View r0, int r1, int r2, int[] r3, int[] r4) {
            return r0.dispatchNestedPreScroll(r1, r2, r3, r4);
        }

        static boolean dispatchNestedScroll(View r0, int r1, int r2, int r3, int r4, int[] r5) {
            return r0.dispatchNestedScroll(r1, r2, r3, r4, r5);
        }

        static ColorStateList getBackgroundTintList(View r0) {
            return r0.getBackgroundTintList();
        }

        static PorterDuff.Mode getBackgroundTintMode(View r0) {
            return r0.getBackgroundTintMode();
        }

        static float getElevation(View r0) {
            return r0.getElevation();
        }

        public static WindowInsetsCompat getRootWindowInsets(View r0) {
            return WindowInsetsCompat.Api21ReflectionHolder.getRootWindowInsets(r0);
        }

        static String getTransitionName(View r0) {
            return r0.getTransitionName();
        }

        static float getTranslationZ(View r0) {
            return r0.getTranslationZ();
        }

        static float getZ(View r0) {
            return r0.getZ();
        }

        static boolean hasNestedScrollingParent(View r0) {
            return r0.hasNestedScrollingParent();
        }

        static boolean isImportantForAccessibility(View r0) {
            return r0.isImportantForAccessibility();
        }

        static boolean isNestedScrollingEnabled(View r0) {
            return r0.isNestedScrollingEnabled();
        }

        static void setBackgroundTintList(View r0, ColorStateList r1) {
            r0.setBackgroundTintList(r1);
        }

        static void setBackgroundTintMode(View r0, PorterDuff.Mode r1) {
            r0.setBackgroundTintMode(r1);
        }

        static void setElevation(View r0, float r1) {
            r0.setElevation(r1);
        }

        static void setNestedScrollingEnabled(View r0, boolean r1) {
            r0.setNestedScrollingEnabled(r1);
        }

        static void setOnApplyWindowInsetsListener(final View r4, OnApplyWindowInsetsListener r5) {
            final OnApplyWindowInsetsListener r6 = (OnApplyWindowInsetsListener) ZeusTransformUtils.wrapperContextForParams(r5, OnApplyWindowInsetsListener.class, "com.obric.memorydata.plugin");
            if (Build.VERSION.SDK_INT >= 30) goto L5;
            r4.setTag(ZeusTransformUtils.mapRes(R.id.tag_on_apply_window_listener, OaidModel.KEY_ID, "tag_on_apply_window_listener"), r6);
        L5:
            if (r6 != null) goto L8;
            r4.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) ZeusTransformUtils.preCheckCast(r4.getTag(ZeusTransformUtils.mapRes(R.id.tag_window_insets_animation_callback, OaidModel.KEY_ID, "tag_window_insets_animation_callback")), View.OnApplyWindowInsetsListener.class, "com.obric.memorydata.plugin"));
            return;
        L8:
            r4.setOnApplyWindowInsetsListener(new AnonymousClass1(r4, r6));
        }

        static void setTransitionName(View r0, String r1) {
            r0.setTransitionName(r1);
        }

        static void setTranslationZ(View r0, float r1) {
            r0.setTranslationZ(r1);
        }

        static void setZ(View r0, float r1) {
            r0.setZ(r1);
        }

        static boolean startNestedScroll(View r0, int r1) {
            return r0.startNestedScroll(r1);
        }

        static void stopNestedScroll(View r0) {
            r0.stopNestedScroll();
        }
    }

    private static class Api23Impl {
        private Api23Impl() {
        }

        public static WindowInsetsCompat getRootWindowInsets(View r1) {
            WindowInsets r0 = r1.getRootWindowInsets();
            if (r0 != null) goto L6;
            return null;
        L6:
            WindowInsetsCompat r2 = WindowInsetsCompat.toWindowInsetsCompat(r0);
            r2.setRootWindowInsets(r2);
            r2.copyRootViewBounds(r1.getRootView());
            return r2;
        }

        static int getScrollIndicators(View r0) {
            return r0.getScrollIndicators();
        }

        static void setScrollIndicators(View r0, int r1) {
            r0.setScrollIndicators(r1);
        }

        static void setScrollIndicators(View r0, int r1, int r2) {
            r0.setScrollIndicators(r1, r2);
        }
    }

    static class Api24Impl {
        private Api24Impl() {
        }

        static void cancelDragAndDrop(View r0) {
            r0.cancelDragAndDrop();
        }

        static void dispatchFinishTemporaryDetach(View r0) {
            r0.dispatchFinishTemporaryDetach();
        }

        static void dispatchStartTemporaryDetach(View r0) {
            r0.dispatchStartTemporaryDetach();
        }

        static void setPointerIcon(View r0, PointerIcon r1) {
            r0.setPointerIcon(r1);
        }

        static boolean startDragAndDrop(View r0, ClipData r1, View.DragShadowBuilder r2, Object r3, int r4) {
            return r0.startDragAndDrop(r1, r2, r3, r4);
        }

        static void updateDragShadow(View r0, View.DragShadowBuilder r1) {
            r0.updateDragShadow(r1);
        }
    }

    static class Api26Impl {
        private Api26Impl() {
        }

        static void addKeyboardNavigationClusters(View r2, Collection<View> r3, int r4) {
            r2.addKeyboardNavigationClusters((Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin"), r4);
        }

        public static AutofillId getAutofillId(View r0) {
            return r0.getAutofillId();
        }

        static int getImportantForAutofill(View r0) {
            return r0.getImportantForAutofill();
        }

        static int getNextClusterForwardId(View r0) {
            return r0.getNextClusterForwardId();
        }

        static boolean hasExplicitFocusable(View r0) {
            return r0.hasExplicitFocusable();
        }

        static boolean isFocusedByDefault(View r0) {
            return r0.isFocusedByDefault();
        }

        static boolean isImportantForAutofill(View r0) {
            return r0.isImportantForAutofill();
        }

        static boolean isKeyboardNavigationCluster(View r0) {
            return r0.isKeyboardNavigationCluster();
        }

        static View keyboardNavigationClusterSearch(View r0, View r1, int r2) {
            return r0.keyboardNavigationClusterSearch(r1, r2);
        }

        static boolean restoreDefaultFocus(View r0) {
            return r0.restoreDefaultFocus();
        }

        static void setAutofillHints(View r0, String... r1) {
            r0.setAutofillHints(r1);
        }

        static void setFocusedByDefault(View r0, boolean r1) {
            r0.setFocusedByDefault(r1);
        }

        static void setImportantForAutofill(View r0, int r1) {
            r0.setImportantForAutofill(r1);
        }

        static void setKeyboardNavigationCluster(View r0, boolean r1) {
            r0.setKeyboardNavigationCluster(r1);
        }

        static void setNextClusterForwardId(View r0, int r1) {
            r0.setNextClusterForwardId(r1);
        }

        static void setTooltipText(View r2, CharSequence r3) {
            r2.setTooltipText((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin"));
        }
    }

    static class Api28Impl {
        private Api28Impl() {
        }

        static void addOnUnhandledKeyEventListener(View r5, OnUnhandledKeyEventListenerCompat r6) {
            final OnUnhandledKeyEventListenerCompat r7 = (OnUnhandledKeyEventListenerCompat) ZeusTransformUtils.wrapperContextForParams(r6, OnUnhandledKeyEventListenerCompat.class, "com.obric.memorydata.plugin");
            SimpleArrayMap r0 = (SimpleArrayMap) ZeusTransformUtils.preCheckCast(r5.getTag(ZeusTransformUtils.mapRes(R.id.tag_unhandled_key_listeners, OaidModel.KEY_ID, "tag_unhandled_key_listeners")), SimpleArrayMap.class, "com.obric.memorydata.plugin");
            if (r0 != null) goto L5;
            r0 = new SimpleArrayMap();
            r5.setTag(ZeusTransformUtils.mapRes(R.id.tag_unhandled_key_listeners, OaidModel.KEY_ID, "tag_unhandled_key_listeners"), r0);
        L5:
            Objects.requireNonNull(r7);
            View.OnUnhandledKeyEventListener r1 = new $$Lambda$qTe0NwPXctqJdOm6gRIs26tsx8(r7);
            r0.put(r7, r1);
            r5.addOnUnhandledKeyEventListener(r1);
        }

        static CharSequence getAccessibilityPaneTitle(View r0) {
            return r0.getAccessibilityPaneTitle();
        }

        static boolean isAccessibilityHeading(View r0) {
            return r0.isAccessibilityHeading();
        }

        static boolean isScreenReaderFocusable(View r0) {
            return r0.isScreenReaderFocusable();
        }

        static void removeOnUnhandledKeyEventListener(View r4, OnUnhandledKeyEventListenerCompat r5) {
            OnUnhandledKeyEventListenerCompat r6 = (OnUnhandledKeyEventListenerCompat) ZeusTransformUtils.wrapperContextForParams(r5, OnUnhandledKeyEventListenerCompat.class, "com.obric.memorydata.plugin");
            SimpleArrayMap r0 = (SimpleArrayMap) ZeusTransformUtils.preCheckCast(r4.getTag(ZeusTransformUtils.mapRes(R.id.tag_unhandled_key_listeners, OaidModel.KEY_ID, "tag_unhandled_key_listeners")), SimpleArrayMap.class, "com.obric.memorydata.plugin");
            if (r0 != null) goto L5;
            return;
        L5:
            View.OnUnhandledKeyEventListener r7 = (View.OnUnhandledKeyEventListener) ZeusTransformUtils.preCheckCast(r0.get(r6), View.OnUnhandledKeyEventListener.class, "com.obric.memorydata.plugin");
            if (r7 == null) goto L9;
            r4.removeOnUnhandledKeyEventListener(r7);
            return;
        }

        static <T> T requireViewById(View r0, int r1) {
            return (T) r0.requireViewById(r1);
        }

        static void setAccessibilityHeading(View r0, boolean r1) {
            r0.setAccessibilityHeading(r1);
        }

        static void setAccessibilityPaneTitle(View r2, CharSequence r3) {
            r2.setAccessibilityPaneTitle((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin"));
        }

        public static void setAutofillId(View r0, AutofillId r1) {
            r0.setAutofillId(r1);
        }

        static void setScreenReaderFocusable(View r0, boolean r1) {
            r0.setScreenReaderFocusable(r1);
        }
    }

    private static class Api29Impl {
        private Api29Impl() {
        }

        static View.AccessibilityDelegate getAccessibilityDelegate(View r0) {
            return r0.getAccessibilityDelegate();
        }

        static ContentCaptureSession getContentCaptureSession(View r0) {
            return r0.getContentCaptureSession();
        }

        static List<Rect> getSystemGestureExclusionRects(View r0) {
            return r0.getSystemGestureExclusionRects();
        }

        static void saveAttributeDataForStyleable(View r9, Context r10, int[] r11, AttributeSet r12, TypedArray r13, int r14, int r15) {
            r9.saveAttributeDataForStyleable((Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin"), r11, (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r12, AttributeSet.class, "com.obric.memorydata.plugin"), r13, r14, r15);
        }

        static void setContentCaptureSession(View r0, ContentCaptureSession r1) {
            r0.setContentCaptureSession(r1);
        }

        static void setSystemGestureExclusionRects(View r2, List<Rect> r3) {
            r2.setSystemGestureExclusionRects((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
        }
    }

    private static class Api30Impl {
        private Api30Impl() {
        }

        static int getImportantForContentCapture(View r0) {
            return r0.getImportantForContentCapture();
        }

        static CharSequence getStateDescription(View r0) {
            return r0.getStateDescription();
        }

        public static WindowInsetsControllerCompat getWindowInsetsController(View r0) {
            WindowInsetsController r1 = r0.getWindowInsetsController();
            if (r1 != null) goto L7;
            return null;
        L7:
            return WindowInsetsControllerCompat.toWindowInsetsControllerCompat(r1);
        }

        static boolean isImportantForContentCapture(View r0) {
            return r0.isImportantForContentCapture();
        }

        static void setImportantForContentCapture(View r0, int r1) {
            r0.setImportantForContentCapture(r1);
        }

        static void setStateDescription(View r2, CharSequence r3) {
            r2.setStateDescription((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin"));
        }
    }

    private static final class Api31Impl {
        private Api31Impl() {
        }

        public static String[] getReceiveContentMimeTypes(View r0) {
            return r0.getReceiveContentMimeTypes();
        }

        public static ContentInfoCompat performReceiveContent(View r1, ContentInfoCompat r2) {
            ContentInfo r0 = r2.toContentInfo();
            ContentInfo r3 = r1.performReceiveContent(r0);
            if (r3 != null) goto L6;
            return null;
        L6:
            if (r3 != r0) goto L9;
            return r2;
        L9:
            return ContentInfoCompat.toContentInfoCompat(r3);
        }

        public static void setOnReceiveContentListener(View r2, String[] r3, OnReceiveContentListener r4) {
            OnReceiveContentListener r5 = (OnReceiveContentListener) ZeusTransformUtils.wrapperContextForParams(r4, OnReceiveContentListener.class, "com.obric.memorydata.plugin");
            if (r5 != null) goto L5;
            r2.setOnReceiveContentListener(r3, null);
            return;
        L5:
            r2.setOnReceiveContentListener(r3, new OnReceiveContentListenerAdapter(r5));
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface FocusDirection {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface FocusRealDirection {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface FocusRelativeDirection {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface NestedScrollType {
    }

    private static final class OnReceiveContentListenerAdapter implements android.view.OnReceiveContentListener {
        private final OnReceiveContentListener mJetpackListener;

        OnReceiveContentListenerAdapter(OnReceiveContentListener r3) {
            this.mJetpackListener = (OnReceiveContentListener) ZeusTransformUtils.wrapperContextForParams(r3, OnReceiveContentListener.class, "com.obric.memorydata.plugin");
        }

        @Override // android.view.OnReceiveContentListener
        public ContentInfo onReceiveContent(View r2, ContentInfo r3) {
            ContentInfoCompat r0 = ContentInfoCompat.toContentInfoCompat(r3);
            ContentInfoCompat r1 = this.mJetpackListener.onReceiveContent(r2, r0);
            if (r1 != null) goto L6;
            return null;
        L6:
            if (r1 != r0) goto L9;
            return r3;
        L9:
            return r1.toContentInfo();
        }
    }

    public interface OnUnhandledKeyEventListenerCompat {
        boolean onUnhandledKeyEvent(View r1, KeyEvent r2);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ScrollAxis {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ScrollIndicators {
    }

    static class UnhandledKeyEventManager {
        private static final ArrayList<WeakReference<View>> sViewsWithListeners = null;
        private SparseArray<WeakReference<View>> mCapturedKeys;
        private WeakReference<KeyEvent> mLastDispatchedPreViewKeyEvent;
        private WeakHashMap<View, Boolean> mViewsContainingListeners;

        static {
            sViewsWithListeners = new ArrayList();
        }

        UnhandledKeyEventManager() {
            this.mViewsContainingListeners = null;
            this.mCapturedKeys = null;
            this.mLastDispatchedPreViewKeyEvent = null;
        }

        static UnhandledKeyEventManager at(View r5) {
            UnhandledKeyEventManager r0 = (UnhandledKeyEventManager) ZeusTransformUtils.preCheckCast(r5.getTag(ZeusTransformUtils.mapRes(R.id.tag_unhandled_key_event_manager, OaidModel.KEY_ID, "tag_unhandled_key_event_manager")), UnhandledKeyEventManager.class, "com.obric.memorydata.plugin");
            if (r0 != null) goto L6;
            UnhandledKeyEventManager r1 = new UnhandledKeyEventManager();
            r5.setTag(ZeusTransformUtils.mapRes(R.id.tag_unhandled_key_event_manager, OaidModel.KEY_ID, "tag_unhandled_key_event_manager"), r1);
            return r1;
        L6:
            return r0;
        }

        private View dispatchInOrder(View r5, KeyEvent r6) {
            WeakHashMap<View, Boolean> r0 = this.mViewsContainingListeners;
            if (r0 != null) goto L5;
        L18:
            return null;
        L5:
            if (r0.containsKey(r5) == false) goto L18;
            if (ZeusTransformUtils.instanceOf(r5, ViewGroup.class) == false) goto L16;
            ViewGroup r1 = (ViewGroup) ZeusTransformUtils.preCheckCast(r5, ViewGroup.class, "com.obric.memorydata.plugin");
            int r2 = r1.getChildCount() - 1;
        L10:
            if (r2 < 0) goto L16;
            View r3 = dispatchInOrder(r1.getChildAt(r2), r6);
            if (r3 != null) goto L13;
            r2 = r2 - 1;
            goto L10
        L13:
            return r3;
        L16:
            if (onUnhandledKeyEvent(r5, r6) == false) goto L18;
            return r5;
        }

        private SparseArray<WeakReference<View>> getCapturedKeys() {
            if (this.mCapturedKeys != null) goto L6;
            this.mCapturedKeys = new SparseArray();
        L6:
            return this.mCapturedKeys;
        }

        private boolean onUnhandledKeyEvent(View r6, KeyEvent r7) {
            ArrayList r5 = (ArrayList) ZeusTransformUtils.preCheckCast(r6.getTag(ZeusTransformUtils.mapRes(R.id.tag_unhandled_key_listeners, OaidModel.KEY_ID, "tag_unhandled_key_listeners")), ArrayList.class, "com.obric.memorydata.plugin");
            if (r5 == null) goto L10;
            int r0 = r5.size() - 1;
        L5:
            if (r0 < 0) goto L14;
            if (((OnUnhandledKeyEventListenerCompat) ZeusTransformUtils.preCheckCast(r5.get(r0), OnUnhandledKeyEventListenerCompat.class, "com.obric.memorydata.plugin")).onUnhandledKeyEvent(r6, r7) == true) goto L8;
            r0 = r0 - 1;
            goto L5
        L8:
            return true;
        L14:
            return false;
        L10:
            return false;
        }

        private void recalcViewsWithUnhandled() {
            WeakHashMap<View, Boolean> r0 = this.mViewsContainingListeners;
            if (r0 == null) goto L5;
            r0.clear();
        L5:
            ArrayList<WeakReference<View>> r1 = sViewsWithListeners;
            if (r1.isEmpty() == false) goto L8;
            return;
        L8:
            monitor-enter(r1);
        L24:
            th = move-exception;
            throw th;
        L10:
            if (this.mViewsContainingListeners != null) goto L12;
            this.mViewsContainingListeners = new WeakHashMap();     // Catch: Throwable -> L24
        L12:
            int r2 = r1.size() - 1;     // Catch: Throwable -> L24
        L13:
            if (r2 < 0) goto L22;
            ArrayList<WeakReference<View>> r3 = sViewsWithListeners;     // Catch: Throwable -> L24
            View r4 = (View) ZeusTransformUtils.preCheckCast(((WeakReference) ZeusTransformUtils.preCheckCast(r3.get(r2), WeakReference.class, "com.obric.memorydata.plugin")).get(), View.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L24
            if (r4 != null) goto L17;
            r3.remove(r2);     // Catch: Throwable -> L24
        L21:
            r2 = r2 - 1;     // Catch: Throwable -> L24
            goto L13
        L17:
            this.mViewsContainingListeners.put(r4, Boolean.TRUE);     // Catch: Throwable -> L24
            ViewParent r5 = r4.getParent();     // Catch: Throwable -> L24
        L19:
            if (ZeusTransformUtils.instanceOf(r5, View.class) == false) goto L21;
            this.mViewsContainingListeners.put((View) ZeusTransformUtils.preCheckCast(r5, View.class, "com.obric.memorydata.plugin"), Boolean.TRUE);     // Catch: Throwable -> L24
            r5 = r5.getParent();     // Catch: Throwable -> L24
            goto L19
        L22:
            monitor-exit(r1);     // Catch: Throwable -> L24
        }

        static void registerListeningView(View r5) {
            ArrayList<WeakReference<View>> r0 = sViewsWithListeners;
            monitor-enter(r0);
            Iterator<WeakReference<View>> r1 = r0.iterator();     // Catch: Throwable -> L14
        L6:
            if (r1.hasNext() == false) goto L11;
            if (((WeakReference) ZeusTransformUtils.preCheckCast(r1.next(), WeakReference.class, "com.obric.memorydata.plugin")).get() != r5) goto L6;
            monitor-exit(r0);     // Catch: Throwable -> L14
            return;
        L11:
            sViewsWithListeners.add(new WeakReference(r5));     // Catch: Throwable -> L14
            monitor-exit(r0);     // Catch: Throwable -> L14
            return;
        L14:
            th = move-exception;
            throw th;
        }

        static void unregisterListeningView(View r6) {
            ArrayList<WeakReference<View>> r0 = sViewsWithListeners;
            monitor-enter(r0);
            int r1 = 0;
        L18:
            ArrayList<WeakReference<View>> r2 = sViewsWithListeners;     // Catch: Throwable -> L15
            if (r1 >= r2.size()) goto L13;
            if (((WeakReference) ZeusTransformUtils.preCheckCast(r2.get(r1), WeakReference.class, "com.obric.memorydata.plugin")).get() == r6) goto L9;
            r1 = r1 + 1;     // Catch: Throwable -> L15
            goto L18
        L9:
            r2.remove(r1);     // Catch: Throwable -> L15
            monitor-exit(r0);     // Catch: Throwable -> L15
            return;
        L13:
            monitor-exit(r0);     // Catch: Throwable -> L15
            return;
        L15:
            th = move-exception;
            throw th;
        }

        boolean dispatch(View r2, KeyEvent r3) {
            if (r3.getAction() != 0) goto L5;
            recalcViewsWithUnhandled();
        L5:
            View r4 = dispatchInOrder(r2, r3);
            if (r3.getAction() != 0) goto L12;
            int r5 = r3.getKeyCode();
            if (r4 == null) goto L12;
            if (KeyEvent.isModifierKey(r5) == true) goto L12;
            getCapturedKeys().put(r5, new WeakReference(r4));
        L12:
            if (r4 == null) goto L14;
            return true;
        L14:
            return false;
        }

        boolean preDispatch(KeyEvent r8) {
            WeakReference<KeyEvent> r0 = this.mLastDispatchedPreViewKeyEvent;
            if (r0 != null) goto L5;
        L7:
            this.mLastDispatchedPreViewKeyEvent = new WeakReference(r8);
            WeakReference r1 = null;
            SparseArray<WeakReference<View>> r2 = getCapturedKeys();
            if (r8.getAction() != 1) goto L12;
            int r3 = r2.indexOfKey(r8.getKeyCode());
            if (r3 < 0) goto L12;
            r1 = (WeakReference) ZeusTransformUtils.preCheckCast(r2.valueAt(r3), WeakReference.class, "com.obric.memorydata.plugin");
            r2.removeAt(r3);
        L12:
            if (r1 != null) goto L14;
            r1 = (WeakReference) ZeusTransformUtils.preCheckCast(r2.get(r8.getKeyCode()), WeakReference.class, "com.obric.memorydata.plugin");
        L14:
            if (r1 == null) goto L21;
            View r4 = (View) ZeusTransformUtils.preCheckCast(r1.get(), View.class, "com.obric.memorydata.plugin");
            if (r4 != null) goto L18;
        L20:
            return true;
        L18:
            if (ViewCompat.isAttachedToWindow(r4) == false) goto L20;
            onUnhandledKeyEvent(r4, r8);
            goto L20
        L21:
            return false;
        L5:
            if (r0.get() != r8) goto L7;
            return false;
        }
    }

    static {
        sNextGeneratedId = new AtomicInteger(1);
        sViewPropertyAnimatorMap = null;
        sAccessibilityDelegateCheckFailed = false;
        ACCESSIBILITY_ACTIONS_RESOURCE_IDS = new int[]{ZeusTransformUtils.mapRes(R.id.accessibility_custom_action_0, OaidModel.KEY_ID, "accessibility_custom_action_0"), ZeusTransformUtils.mapRes(R.id.accessibility_custom_action_1, OaidModel.KEY_ID, "accessibility_custom_action_1"), ZeusTransformUtils.mapRes(R.id.accessibility_custom_action_2, OaidModel.KEY_ID, "accessibility_custom_action_2"), ZeusTransformUtils.mapRes(R.id.accessibility_custom_action_3, OaidModel.KEY_ID, "accessibility_custom_action_3"), ZeusTransformUtils.mapRes(R.id.accessibility_custom_action_4, OaidModel.KEY_ID, "accessibility_custom_action_4"), ZeusTransformUtils.mapRes(R.id.accessibility_custom_action_5, OaidModel.KEY_ID, "accessibility_custom_action_5"), ZeusTransformUtils.mapRes(R.id.accessibility_custom_action_6, OaidModel.KEY_ID, "accessibility_custom_action_6"), ZeusTransformUtils.mapRes(R.id.accessibility_custom_action_7, OaidModel.KEY_ID, "accessibility_custom_action_7"), ZeusTransformUtils.mapRes(R.id.accessibility_custom_action_8, OaidModel.KEY_ID, "accessibility_custom_action_8"), ZeusTransformUtils.mapRes(R.id.accessibility_custom_action_9, OaidModel.KEY_ID, "accessibility_custom_action_9"), ZeusTransformUtils.mapRes(R.id.accessibility_custom_action_10, OaidModel.KEY_ID, "accessibility_custom_action_10"), ZeusTransformUtils.mapRes(R.id.accessibility_custom_action_11, OaidModel.KEY_ID, "accessibility_custom_action_11"), ZeusTransformUtils.mapRes(R.id.accessibility_custom_action_12, OaidModel.KEY_ID, "accessibility_custom_action_12"), ZeusTransformUtils.mapRes(R.id.accessibility_custom_action_13, OaidModel.KEY_ID, "accessibility_custom_action_13"), ZeusTransformUtils.mapRes(R.id.accessibility_custom_action_14, OaidModel.KEY_ID, "accessibility_custom_action_14"), ZeusTransformUtils.mapRes(R.id.accessibility_custom_action_15, OaidModel.KEY_ID, "accessibility_custom_action_15"), ZeusTransformUtils.mapRes(R.id.accessibility_custom_action_16, OaidModel.KEY_ID, "accessibility_custom_action_16"), ZeusTransformUtils.mapRes(R.id.accessibility_custom_action_17, OaidModel.KEY_ID, "accessibility_custom_action_17"), ZeusTransformUtils.mapRes(R.id.accessibility_custom_action_18, OaidModel.KEY_ID, "accessibility_custom_action_18"), ZeusTransformUtils.mapRes(R.id.accessibility_custom_action_19, OaidModel.KEY_ID, "accessibility_custom_action_19"), ZeusTransformUtils.mapRes(R.id.accessibility_custom_action_20, OaidModel.KEY_ID, "accessibility_custom_action_20"), ZeusTransformUtils.mapRes(R.id.accessibility_custom_action_21, OaidModel.KEY_ID, "accessibility_custom_action_21"), ZeusTransformUtils.mapRes(R.id.accessibility_custom_action_22, OaidModel.KEY_ID, "accessibility_custom_action_22"), ZeusTransformUtils.mapRes(R.id.accessibility_custom_action_23, OaidModel.KEY_ID, "accessibility_custom_action_23"), ZeusTransformUtils.mapRes(R.id.accessibility_custom_action_24, OaidModel.KEY_ID, "accessibility_custom_action_24"), ZeusTransformUtils.mapRes(R.id.accessibility_custom_action_25, OaidModel.KEY_ID, "accessibility_custom_action_25"), ZeusTransformUtils.mapRes(R.id.accessibility_custom_action_26, OaidModel.KEY_ID, "accessibility_custom_action_26"), ZeusTransformUtils.mapRes(R.id.accessibility_custom_action_27, OaidModel.KEY_ID, "accessibility_custom_action_27"), ZeusTransformUtils.mapRes(R.id.accessibility_custom_action_28, OaidModel.KEY_ID, "accessibility_custom_action_28"), ZeusTransformUtils.mapRes(R.id.accessibility_custom_action_29, OaidModel.KEY_ID, "accessibility_custom_action_29"), ZeusTransformUtils.mapRes(R.id.accessibility_custom_action_30, OaidModel.KEY_ID, "accessibility_custom_action_30"), ZeusTransformUtils.mapRes(R.id.accessibility_custom_action_31, OaidModel.KEY_ID, "accessibility_custom_action_31")};
        NO_OP_ON_RECEIVE_CONTENT_VIEW_BEHAVIOR = $$Lambda$ViewCompat$wxf3s7r4ODqhaNnVVlzx9IRcwjg.INSTANCE;
        sAccessibilityPaneVisibilityManager = new AccessibilityPaneVisibilityManager();
    }

    @Deprecated
    public ViewCompat() {
    }

    private static AccessibilityViewProperty<Boolean> accessibilityHeadingProperty() {
        final int r1 = ZeusTransformUtils.mapRes(R.id.tag_accessibility_heading, OaidModel.KEY_ID, "tag_accessibility_heading");
        final Class<Boolean> r2 = Boolean.class;
        final int r3 = 28;
        return new AnonymousClass4(r1, r2, r3);
    }

    public static int addAccessibilityAction(View r2, CharSequence r3, AccessibilityViewCommand r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        AccessibilityViewCommand r6 = (AccessibilityViewCommand) ZeusTransformUtils.wrapperContextForParams(r4, AccessibilityViewCommand.class, "com.obric.memorydata.plugin");
        int r0 = getAvailableActionIdFromResources(r2, r5);
        if (r0 == (-1)) goto L5;
        addAccessibilityAction(r2, new AccessibilityNodeInfoCompat.AccessibilityActionCompat(r0, r5, r6));
    L5:
        return r0;
    }

    private static void addAccessibilityAction(View r2, AccessibilityNodeInfoCompat.AccessibilityActionCompat r3) {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        ensureAccessibilityDelegateCompat(r2);
        removeActionWithId(r3.getId(), r2);
        getActionList(r2).add(r3);
        notifyViewAccessibilityStateChangedIfNeeded(r2, 0);
        return;
    }

    public static void addKeyboardNavigationClusters(View r2, Collection<View> r3, int r4) {
        Collection r5 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 26) goto L6;
        Api26Impl.addKeyboardNavigationClusters(r2, r5, r4);
        return;
    }

    public static void addOnUnhandledKeyEventListener(View r5, OnUnhandledKeyEventListenerCompat r6) {
        OnUnhandledKeyEventListenerCompat r7 = (OnUnhandledKeyEventListenerCompat) ZeusTransformUtils.wrapperContextForParams(r6, OnUnhandledKeyEventListenerCompat.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 28) goto L6;
        Api28Impl.addOnUnhandledKeyEventListener(r5, r7);
        return;
    L6:
        ArrayList r0 = (ArrayList) ZeusTransformUtils.preCheckCast(r5.getTag(ZeusTransformUtils.mapRes(R.id.tag_unhandled_key_listeners, OaidModel.KEY_ID, "tag_unhandled_key_listeners")), ArrayList.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L9;
        r0 = new ArrayList();
        r5.setTag(ZeusTransformUtils.mapRes(R.id.tag_unhandled_key_listeners, OaidModel.KEY_ID, "tag_unhandled_key_listeners"), r0);
    L9:
        r0.add(r7);
        if (r0.size() != 1) goto L13;
        UnhandledKeyEventManager.registerListeningView(r5);
        return;
    }

    public static ViewPropertyAnimatorCompat animate(View r3) {
        if (sViewPropertyAnimatorMap != null) goto L5;
        sViewPropertyAnimatorMap = new WeakHashMap();
    L5:
        ViewPropertyAnimatorCompat r0 = (ViewPropertyAnimatorCompat) ZeusTransformUtils.preCheckCast(sViewPropertyAnimatorMap.get(r3), ViewPropertyAnimatorCompat.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L9;
        ViewPropertyAnimatorCompat r1 = new ViewPropertyAnimatorCompat(r3);
        sViewPropertyAnimatorMap.put(r3, r1);
        return r1;
    L9:
        return r0;
    }

    private static void bindTempDetach() {
        sDispatchStartTemporaryDetach = View.class.getDeclaredMethod("dispatchStartTemporaryDetach", new Class[0]);     // Catch: NoSuchMethodException -> L4
        sDispatchFinishTemporaryDetach = View.class.getDeclaredMethod("dispatchFinishTemporaryDetach", new Class[0]);     // Catch: NoSuchMethodException -> L4
    L6:
        sTempDetachBound = true;
        return;
    L4:
        e = move-exception;
        Log.e(TAG, "Couldn't find method", e);
        goto L6
    }

    @Deprecated
    public static boolean canScrollHorizontally(View r0, int r1) {
        return r0.canScrollHorizontally(r1);
    }

    @Deprecated
    public static boolean canScrollVertically(View r0, int r1) {
        return r0.canScrollVertically(r1);
    }

    public static void cancelDragAndDrop(View r2) {
        if (Build.VERSION.SDK_INT < 24) goto L6;
        Api24Impl.cancelDragAndDrop(r2);
        return;
    }

    @Deprecated
    public static int combineMeasuredStates(int r0, int r1) {
        return View.combineMeasuredStates(r0, r1);
    }

    private static void compatOffsetLeftAndRight(View r1, int r2) {
        r1.offsetLeftAndRight(r2);
        if (r1.getVisibility() != 0) goto L8;
        tickleInvalidationFlag(r1);
        ViewParent r3 = r1.getParent();
        if (ZeusTransformUtils.instanceOf(r3, View.class) == false) goto L9;
        tickleInvalidationFlag((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.memorydata.plugin"));
        return;
    L9:
        return;
    }

    private static void compatOffsetTopAndBottom(View r1, int r2) {
        r1.offsetTopAndBottom(r2);
        if (r1.getVisibility() != 0) goto L8;
        tickleInvalidationFlag(r1);
        ViewParent r3 = r1.getParent();
        if (ZeusTransformUtils.instanceOf(r3, View.class) == false) goto L9;
        tickleInvalidationFlag((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.memorydata.plugin"));
        return;
    L9:
        return;
    }

    public static WindowInsetsCompat computeSystemWindowInsets(View r2, WindowInsetsCompat r3, Rect r4) {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return r3;
    L5:
        return Api21Impl.computeSystemWindowInsets(r2, r3, r4);
    }

    public static WindowInsetsCompat dispatchApplyWindowInsets(View r2, WindowInsetsCompat r3) {
        if (Build.VERSION.SDK_INT < 21) goto L10;
        WindowInsets r0 = r3.toWindowInsets();
        if (r0 == null) goto L10;
        WindowInsets r1 = Api20Impl.dispatchApplyWindowInsets(r2, r0);
        if (r1.equals(r0) == true) goto L10;
        return WindowInsetsCompat.toWindowInsetsCompat(r1, r2);
    L10:
        return r3;
    }

    public static void dispatchFinishTemporaryDetach(View r2) {
        if (Build.VERSION.SDK_INT < 24) goto L6;
        Api24Impl.dispatchFinishTemporaryDetach(r2);
        return;
    L6:
        if (sTempDetachBound == true) goto L8;
        bindTempDetach();
    L8:
        Method r0 = sDispatchFinishTemporaryDetach;
        if (r0 != null) goto L17;
        r2.onFinishTemporaryDetach();
        return;
    L17:
        r0.invoke(r2, new Object[0]);     // Catch: Exception -> L13
        return;
    L13:
        e = move-exception;
        Log.d(TAG, "Error calling dispatchFinishTemporaryDetach", e);
    }

    public static boolean dispatchNestedFling(View r2, float r3, float r4, boolean r5) {
        if (Build.VERSION.SDK_INT < 21) goto L7;
        return Api21Impl.dispatchNestedFling(r2, r3, r4, r5);
    L7:
        if (ZeusTransformUtils.instanceOf(r2, NestedScrollingChild.class) == true) goto L9;
        return false;
    L9:
        return ((NestedScrollingChild) ZeusTransformUtils.preCheckCast(r2, NestedScrollingChild.class, "com.obric.memorydata.plugin")).dispatchNestedFling(r3, r4, r5);
    }

    public static boolean dispatchNestedPreFling(View r2, float r3, float r4) {
        if (Build.VERSION.SDK_INT < 21) goto L7;
        return Api21Impl.dispatchNestedPreFling(r2, r3, r4);
    L7:
        if (ZeusTransformUtils.instanceOf(r2, NestedScrollingChild.class) == true) goto L9;
        return false;
    L9:
        return ((NestedScrollingChild) ZeusTransformUtils.preCheckCast(r2, NestedScrollingChild.class, "com.obric.memorydata.plugin")).dispatchNestedPreFling(r3, r4);
    }

    public static boolean dispatchNestedPreScroll(View r2, int r3, int r4, int[] r5, int[] r6) {
        if (Build.VERSION.SDK_INT < 21) goto L7;
        return Api21Impl.dispatchNestedPreScroll(r2, r3, r4, r5, r6);
    L7:
        if (ZeusTransformUtils.instanceOf(r2, NestedScrollingChild.class) == true) goto L9;
        return false;
    L9:
        return ((NestedScrollingChild) ZeusTransformUtils.preCheckCast(r2, NestedScrollingChild.class, "com.obric.memorydata.plugin")).dispatchNestedPreScroll(r3, r4, r5, r6);
    }

    public static boolean dispatchNestedPreScroll(View r6, int r7, int r8, int[] r9, int[] r10, int r11) {
        if (ZeusTransformUtils.instanceOf(r6, NestedScrollingChild2.class) == true) goto L5;
        if (r11 == 0) goto L8;
        return false;
    L8:
        return dispatchNestedPreScroll(r6, r7, r8, r9, r10);
    L5:
        return ((NestedScrollingChild2) ZeusTransformUtils.preCheckCast(r6, NestedScrollingChild2.class, "com.obric.memorydata.plugin")).dispatchNestedPreScroll(r7, r8, r9, r10, r11);
    }

    public static void dispatchNestedScroll(View r8, int r9, int r10, int r11, int r12, int[] r13, int r14, int[] r15) {
        if (ZeusTransformUtils.instanceOf(r8, NestedScrollingChild3.class) == false) goto L5;
        ((NestedScrollingChild3) ZeusTransformUtils.preCheckCast(r8, NestedScrollingChild3.class, "com.obric.memorydata.plugin")).dispatchNestedScroll(r9, r10, r11, r12, r13, r14, r15);
        return;
    L5:
        dispatchNestedScroll(r8, r9, r10, r11, r12, r13, r14);
    }

    public static boolean dispatchNestedScroll(View r6, int r7, int r8, int r9, int r10, int[] r11) {
        if (Build.VERSION.SDK_INT < 21) goto L7;
        return Api21Impl.dispatchNestedScroll(r6, r7, r8, r9, r10, r11);
    L7:
        if (ZeusTransformUtils.instanceOf(r6, NestedScrollingChild.class) == true) goto L9;
        return false;
    L9:
        return ((NestedScrollingChild) ZeusTransformUtils.preCheckCast(r6, NestedScrollingChild.class, "com.obric.memorydata.plugin")).dispatchNestedScroll(r7, r8, r9, r10, r11);
    }

    public static boolean dispatchNestedScroll(View r7, int r8, int r9, int r10, int r11, int[] r12, int r13) {
        if (ZeusTransformUtils.instanceOf(r7, NestedScrollingChild2.class) == true) goto L5;
        if (r13 == 0) goto L8;
        return false;
    L8:
        return dispatchNestedScroll(r7, r8, r9, r10, r11, r12);
    L5:
        return ((NestedScrollingChild2) ZeusTransformUtils.preCheckCast(r7, NestedScrollingChild2.class, "com.obric.memorydata.plugin")).dispatchNestedScroll(r8, r9, r10, r11, r12, r13);
    }

    public static void dispatchStartTemporaryDetach(View r2) {
        if (Build.VERSION.SDK_INT < 24) goto L6;
        Api24Impl.dispatchStartTemporaryDetach(r2);
        return;
    L6:
        if (sTempDetachBound == true) goto L8;
        bindTempDetach();
    L8:
        Method r0 = sDispatchStartTemporaryDetach;
        if (r0 != null) goto L17;
        r2.onStartTemporaryDetach();
        return;
    L17:
        r0.invoke(r2, new Object[0]);     // Catch: Exception -> L13
        return;
    L13:
        e = move-exception;
        Log.d(TAG, "Error calling dispatchStartTemporaryDetach", e);
    }

    static boolean dispatchUnhandledKeyEventBeforeCallback(View r2, KeyEvent r3) {
        if (Build.VERSION.SDK_INT < 28) goto L7;
        return false;
    L7:
        return UnhandledKeyEventManager.at(r2).dispatch(r2, r3);
    }

    static boolean dispatchUnhandledKeyEventBeforeHierarchy(View r2, KeyEvent r3) {
        if (Build.VERSION.SDK_INT < 28) goto L7;
        return false;
    L7:
        return UnhandledKeyEventManager.at(r2).preDispatch(r3);
    }

    public static void enableAccessibleClickableSpanSupport(View r2) {
        if (Build.VERSION.SDK_INT < 19) goto L6;
        ensureAccessibilityDelegateCompat(r2);
        return;
    }

    static void ensureAccessibilityDelegateCompat(View r1) {
        AccessibilityDelegateCompat r0 = getAccessibilityDelegate(r1);
        if (r0 != null) goto L5;
        r0 = new AccessibilityDelegateCompat();
    L5:
        setAccessibilityDelegate(r1, r0);
    }

    public static int generateViewId() {
        if (Build.VERSION.SDK_INT >= 17) goto L5;
    L6:
        AtomicInteger r0 = sNextGeneratedId;
        int r1 = r0.get();
        int r2 = r1 + 1;
        if (r2 <= 16777215) goto L10;
        r2 = 1;
    L10:
        if (r0.compareAndSet(r1, r2) == false) goto L6;
        return r1;
    L5:
        return Api17Impl.generateViewId();
    }

    public static AccessibilityDelegateCompat getAccessibilityDelegate(View r2) {
        View.AccessibilityDelegate r3 = getAccessibilityDelegateInternal(r2);
        if (r3 != null) goto L7;
        return null;
    L7:
        if (ZeusTransformUtils.instanceOf(r3, AccessibilityDelegateCompat.AccessibilityDelegateAdapter.class) == false) goto L11;
        return ((AccessibilityDelegateCompat.AccessibilityDelegateAdapter) ZeusTransformUtils.preCheckCast(r3, AccessibilityDelegateCompat.AccessibilityDelegateAdapter.class, "com.obric.memorydata.plugin")).mCompat;
    L11:
        return new AccessibilityDelegateCompat(r3);
    }

    private static View.AccessibilityDelegate getAccessibilityDelegateInternal(View r2) {
        if (Build.VERSION.SDK_INT < 29) goto L7;
        return Api29Impl.getAccessibilityDelegate(r2);
    L7:
        return getAccessibilityDelegateThroughReflection(r2);
    }

    private static View.AccessibilityDelegate getAccessibilityDelegateThroughReflection(View r4) {
        if (sAccessibilityDelegateCheckFailed == false) goto L6;
        return null;
    L6:
        if (sAccessibilityDelegateField == null) goto L20;
    L18:
        Object r5 = sAccessibilityDelegateField.get(r4);     // Catch: Throwable -> L16
        if (ZeusTransformUtils.instanceOf(r5, View.AccessibilityDelegate.class) == false) goto L15;
        return (View.AccessibilityDelegate) ZeusTransformUtils.preCheckCast(r5, View.AccessibilityDelegate.class, "com.obric.memorydata.plugin");
    L15:
        return null;
    L16:
        sAccessibilityDelegateCheckFailed = true;
        return null;
    L20:
        Field r0 = View.class.getDeclaredField("mAccessibilityDelegate");     // Catch: Throwable -> L9
        sAccessibilityDelegateField = r0;     // Catch: Throwable -> L9
        r0.setAccessible(true);     // Catch: Throwable -> L9
    L9:
        sAccessibilityDelegateCheckFailed = true;
        return null;
    }

    public static int getAccessibilityLiveRegion(View r2) {
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        return 0;
    L5:
        return Api19Impl.getAccessibilityLiveRegion(r2);
    }

    public static AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View r2) {
        if (Build.VERSION.SDK_INT < 16) goto L8;
        AccessibilityNodeProvider r3 = Api16Impl.getAccessibilityNodeProvider(r2);
        if (r3 != null) goto L7;
        return null;
    L7:
        return new AccessibilityNodeProviderCompat(r3);
    L8:
        return null;
    }

    public static CharSequence getAccessibilityPaneTitle(View r2) {
        return (CharSequence) ZeusTransformUtils.preCheckCast(paneTitleProperty().get(r2), CharSequence.class, "com.obric.memorydata.plugin");
    }

    private static List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> getActionList(View r5) {
        ArrayList r0 = (ArrayList) ZeusTransformUtils.preCheckCast(r5.getTag(ZeusTransformUtils.mapRes(R.id.tag_accessibility_actions, OaidModel.KEY_ID, "tag_accessibility_actions")), ArrayList.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L6;
        ArrayList r1 = new ArrayList();
        r5.setTag(ZeusTransformUtils.mapRes(R.id.tag_accessibility_actions, OaidModel.KEY_ID, "tag_accessibility_actions"), r1);
        return r1;
    L6:
        return r0;
    }

    @Deprecated
    public static float getAlpha(View r0) {
        return r0.getAlpha();
    }

    public static AutofillIdCompat getAutofillId(View r2) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return null;
    L5:
        return AutofillIdCompat.toAutofillIdCompat(Api26Impl.getAutofillId(r2));
    }

    private static int getAvailableActionIdFromResources(View r10, CharSequence r11) {
        CharSequence r12 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r11, CharSequence.class, "com.obric.memorydata.plugin");
        List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> r13 = getActionList(r10);
        int r2 = 0;
    L4:
        if (r2 >= r13.size()) goto L10;
        if (TextUtils.equals(r12, ((AccessibilityNodeInfoCompat.AccessibilityActionCompat) ZeusTransformUtils.preCheckCast(r13.get(r2), AccessibilityNodeInfoCompat.AccessibilityActionCompat.class, "com.obric.memorydata.plugin")).getLabel()) == true) goto L8;
        r2 = r2 + 1;
        goto L4
    L8:
        return ((AccessibilityNodeInfoCompat.AccessibilityActionCompat) ZeusTransformUtils.preCheckCast(r13.get(r2), AccessibilityNodeInfoCompat.AccessibilityActionCompat.class, "com.obric.memorydata.plugin")).getId();
    L10:
        int r3 = -1;
        int r4 = 0;
    L11:
        int[] r5 = ACCESSIBILITY_ACTIONS_RESOURCE_IDS;
        if (r4 >= r5.length) goto L25;
        if (r3 != (-1)) goto L25;
        int r6 = r5[r4];
        int r7 = 0;
        boolean r8 = true;
    L16:
        if (r7 >= r13.size()) goto L22;
        if (((AccessibilityNodeInfoCompat.AccessibilityActionCompat) ZeusTransformUtils.preCheckCast(r13.get(r7), AccessibilityNodeInfoCompat.AccessibilityActionCompat.class, "com.obric.memorydata.plugin")).getId() == r6) goto L20;
        boolean r9 = true;
    L21:
        r8 = r8 & r9;
        r7 = r7 + 1;
        goto L16
    L20:
        r9 = false;
        goto L21
    L22:
        if (r8 == false) goto L24;
        r3 = r6;
    L24:
        r4 = r4 + 1;
    L25:
        return r3;
    }

    public static ColorStateList getBackgroundTintList(View r2) {
        if (Build.VERSION.SDK_INT < 21) goto L7;
        return Api21Impl.getBackgroundTintList(r2);
    L7:
        if (ZeusTransformUtils.instanceOf(r2, TintableBackgroundView.class) == true) goto L11;
        return null;
    L11:
        return ((TintableBackgroundView) ZeusTransformUtils.preCheckCast(r2, TintableBackgroundView.class, "com.obric.memorydata.plugin")).getSupportBackgroundTintList();
    }

    public static PorterDuff.Mode getBackgroundTintMode(View r2) {
        if (Build.VERSION.SDK_INT < 21) goto L7;
        return Api21Impl.getBackgroundTintMode(r2);
    L7:
        if (ZeusTransformUtils.instanceOf(r2, TintableBackgroundView.class) == true) goto L11;
        return null;
    L11:
        return ((TintableBackgroundView) ZeusTransformUtils.preCheckCast(r2, TintableBackgroundView.class, "com.obric.memorydata.plugin")).getSupportBackgroundTintMode();
    }

    public static Rect getClipBounds(View r2) {
        if (Build.VERSION.SDK_INT >= 18) goto L5;
        return null;
    L5:
        return Api18Impl.getClipBounds(r2);
    }

    public static ContentCaptureSessionCompat getContentCaptureSession(View r3) {
        if (Build.VERSION.SDK_INT < 29) goto L9;
        ContentCaptureSession r0 = Api29Impl.getContentCaptureSession(r3);
        if (r0 != null) goto L8;
        return null;
    L8:
        return ContentCaptureSessionCompat.toContentCaptureSessionCompat(r0, r3);
    L9:
        return null;
    }

    public static Display getDisplay(View r2) {
        if (Build.VERSION.SDK_INT < 17) goto L7;
        return Api17Impl.getDisplay(r2);
    L7:
        if (isAttachedToWindow(r2) == true) goto L9;
        return null;
    L9:
        return ((WindowManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService("window"), WindowManager.class, "com.obric.memorydata.plugin")).getDefaultDisplay();
    }

    public static float getElevation(View r2) {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return 0.0f;
    L5:
        return Api21Impl.getElevation(r2);
    }

    private static Rect getEmptyTempRect() {
        if (sThreadLocalRect != null) goto L5;
        sThreadLocalRect = new ThreadLocal();
    L5:
        Rect r0 = (Rect) ZeusTransformUtils.preCheckCast(sThreadLocalRect.get(), Rect.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L8;
        r0 = new Rect();
        sThreadLocalRect.set(r0);
    L8:
        r0.setEmpty();
        return r0;
    }

    private static OnReceiveContentViewBehavior getFallback(View r2) {
        if (ZeusTransformUtils.instanceOf(r2, OnReceiveContentViewBehavior.class) == false) goto L7;
        return (OnReceiveContentViewBehavior) ZeusTransformUtils.preCheckCast(r2, OnReceiveContentViewBehavior.class, "com.obric.memorydata.plugin");
    L7:
        return NO_OP_ON_RECEIVE_CONTENT_VIEW_BEHAVIOR;
    }

    public static boolean getFitsSystemWindows(View r2) {
        if (Build.VERSION.SDK_INT >= 16) goto L5;
        return false;
    L5:
        return Api16Impl.getFitsSystemWindows(r2);
    }

    public static int getImportantForAccessibility(View r2) {
        if (Build.VERSION.SDK_INT >= 16) goto L5;
        return 0;
    L5:
        return Api16Impl.getImportantForAccessibility(r2);
    }

    public static int getImportantForAutofill(View r2) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return 0;
    L5:
        return Api26Impl.getImportantForAutofill(r2);
    }

    public static int getImportantForContentCapture(View r2) {
        if (Build.VERSION.SDK_INT >= 30) goto L5;
        return 0;
    L5:
        return Api30Impl.getImportantForContentCapture(r2);
    }

    public static int getLabelFor(View r2) {
        if (Build.VERSION.SDK_INT >= 17) goto L5;
        return 0;
    L5:
        return Api17Impl.getLabelFor(r2);
    }

    @Deprecated
    public static int getLayerType(View r0) {
        return r0.getLayerType();
    }

    public static int getLayoutDirection(View r2) {
        if (Build.VERSION.SDK_INT >= 17) goto L5;
        return 0;
    L5:
        return Api17Impl.getLayoutDirection(r2);
    }

    @Deprecated
    public static Matrix getMatrix(View r0) {
        return r0.getMatrix();
    }

    @Deprecated
    public static int getMeasuredHeightAndState(View r0) {
        return r0.getMeasuredHeightAndState();
    }

    @Deprecated
    public static int getMeasuredState(View r0) {
        return r0.getMeasuredState();
    }

    @Deprecated
    public static int getMeasuredWidthAndState(View r0) {
        return r0.getMeasuredWidthAndState();
    }

    public static int getMinimumHeight(View r3) {
        if (Build.VERSION.SDK_INT < 16) goto L7;
        return Api16Impl.getMinimumHeight(r3);
    L7:
        if (sMinHeightFieldFetched == false) goto L19;
    L11:
        Field r0 = sMinHeightField;
        if (r0 != null) goto L21;
        return 0;
    L21:
        return ((Integer) ZeusTransformUtils.preCheckCast(r0.get(r3), Integer.class, "com.obric.memorydata.plugin")).intValue();
    L23:
        return 0;
    L19:
        Field r1 = View.class.getDeclaredField("mMinHeight");     // Catch: NoSuchFieldException -> L17
        sMinHeightField = r1;     // Catch: NoSuchFieldException -> L17
        r1.setAccessible(true);     // Catch: NoSuchFieldException -> L17
    L10:
        sMinHeightFieldFetched = true;
        goto L11
    }

    public static int getMinimumWidth(View r3) {
        if (Build.VERSION.SDK_INT < 16) goto L7;
        return Api16Impl.getMinimumWidth(r3);
    L7:
        if (sMinWidthFieldFetched == false) goto L19;
    L11:
        Field r0 = sMinWidthField;
        if (r0 != null) goto L21;
        return 0;
    L21:
        return ((Integer) ZeusTransformUtils.preCheckCast(r0.get(r3), Integer.class, "com.obric.memorydata.plugin")).intValue();
    L23:
        return 0;
    L19:
        Field r1 = View.class.getDeclaredField("mMinWidth");     // Catch: NoSuchFieldException -> L17
        sMinWidthField = r1;     // Catch: NoSuchFieldException -> L17
        r1.setAccessible(true);     // Catch: NoSuchFieldException -> L17
    L10:
        sMinWidthFieldFetched = true;
        goto L11
    }

    public static int getNextClusterForwardId(View r2) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return -1;
    L5:
        return Api26Impl.getNextClusterForwardId(r2);
    }

    public static String[] getOnReceiveContentMimeTypes(View r3) {
        if (Build.VERSION.SDK_INT < 31) goto L7;
        return Api31Impl.getReceiveContentMimeTypes(r3);
    L7:
        return (String[]) ZeusTransformUtils.preCheckCast(r3.getTag(ZeusTransformUtils.mapRes(R.id.tag_on_receive_content_mime_types, OaidModel.KEY_ID, "tag_on_receive_content_mime_types")), String[].class, "com.obric.memorydata.plugin");
    }

    @Deprecated
    public static int getOverScrollMode(View r0) {
        return r0.getOverScrollMode();
    }

    public static int getPaddingEnd(View r2) {
        if (Build.VERSION.SDK_INT < 17) goto L7;
        return Api17Impl.getPaddingEnd(r2);
    L7:
        return r2.getPaddingRight();
    }

    public static int getPaddingStart(View r2) {
        if (Build.VERSION.SDK_INT < 17) goto L7;
        return Api17Impl.getPaddingStart(r2);
    L7:
        return r2.getPaddingLeft();
    }

    public static ViewParent getParentForAccessibility(View r2) {
        if (Build.VERSION.SDK_INT < 16) goto L7;
        return Api16Impl.getParentForAccessibility(r2);
    L7:
        return r2.getParent();
    }

    @Deprecated
    public static float getPivotX(View r0) {
        return r0.getPivotX();
    }

    @Deprecated
    public static float getPivotY(View r0) {
        return r0.getPivotY();
    }

    public static WindowInsetsCompat getRootWindowInsets(View r2) {
        if (Build.VERSION.SDK_INT < 23) goto L7;
        return Api23Impl.getRootWindowInsets(r2);
    L7:
        if (Build.VERSION.SDK_INT >= 21) goto L9;
        return null;
    L9:
        return Api21Impl.getRootWindowInsets(r2);
    }

    @Deprecated
    public static float getRotation(View r0) {
        return r0.getRotation();
    }

    @Deprecated
    public static float getRotationX(View r0) {
        return r0.getRotationX();
    }

    @Deprecated
    public static float getRotationY(View r0) {
        return r0.getRotationY();
    }

    @Deprecated
    public static float getScaleX(View r0) {
        return r0.getScaleX();
    }

    @Deprecated
    public static float getScaleY(View r0) {
        return r0.getScaleY();
    }

    public static int getScrollIndicators(View r2) {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        return 0;
    L5:
        return Api23Impl.getScrollIndicators(r2);
    }

    public static CharSequence getStateDescription(View r2) {
        return (CharSequence) ZeusTransformUtils.preCheckCast(stateDescriptionProperty().get(r2), CharSequence.class, "com.obric.memorydata.plugin");
    }

    public static List<Rect> getSystemGestureExclusionRects(View r2) {
        if (Build.VERSION.SDK_INT < 29) goto L7;
        return Api29Impl.getSystemGestureExclusionRects(r2);
    L7:
        return Collections.emptyList();
    }

    public static String getTransitionName(View r2) {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        WeakHashMap<View, String> r0 = sTransitionNameMap;
        if (r0 != null) goto L11;
        return null;
    L11:
        return (String) ZeusTransformUtils.preCheckCast(r0.get(r2), String.class, "com.obric.memorydata.plugin");
    L5:
        return Api21Impl.getTransitionName(r2);
    }

    @Deprecated
    public static float getTranslationX(View r0) {
        return r0.getTranslationX();
    }

    @Deprecated
    public static float getTranslationY(View r0) {
        return r0.getTranslationY();
    }

    public static float getTranslationZ(View r2) {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return 0.0f;
    L5:
        return Api21Impl.getTranslationZ(r2);
    }

    @Deprecated
    public static WindowInsetsControllerCompat getWindowInsetsController(View r4) {
        if (Build.VERSION.SDK_INT >= 30) goto L5;
        Context r0 = r4.getContext();
    L7:
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0, "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, ContextWrapper.class) == false) goto L16;
        if (ZeusTransformUtils.instanceOf(r1, Activity.class) == true) goto L11;
        r0 = ((ContextWrapper) ZeusTransformUtils.preCheckCast(r1, ContextWrapper.class, "com.obric.memorydata.plugin")).getBaseContext();
        goto L7
    L11:
        Window r2 = ZeusTransformUtils.getWindow((Activity) ZeusTransformUtils.preCheckCast(r1, Activity.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        if (r2 != null) goto L14;
        return null;
    L14:
        return WindowCompat.getInsetsController(r2, r4);
    L16:
        return null;
    L5:
        return Api30Impl.getWindowInsetsController(r4);
    }

    @Deprecated
    public static int getWindowSystemUiVisibility(View r2) {
        if (Build.VERSION.SDK_INT >= 16) goto L5;
        return 0;
    L5:
        return Api16Impl.getWindowSystemUiVisibility(r2);
    }

    @Deprecated
    public static float getX(View r0) {
        return r0.getX();
    }

    @Deprecated
    public static float getY(View r0) {
        return r0.getY();
    }

    public static float getZ(View r2) {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return 0.0f;
    L5:
        return Api21Impl.getZ(r2);
    }

    public static boolean hasAccessibilityDelegate(View r0) {
        if (getAccessibilityDelegateInternal(r0) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean hasExplicitFocusable(View r2) {
        if (Build.VERSION.SDK_INT < 26) goto L7;
        return Api26Impl.hasExplicitFocusable(r2);
    L7:
        return r2.hasFocusable();
    }

    public static boolean hasNestedScrollingParent(View r2) {
        if (Build.VERSION.SDK_INT < 21) goto L7;
        return Api21Impl.hasNestedScrollingParent(r2);
    L7:
        if (ZeusTransformUtils.instanceOf(r2, NestedScrollingChild.class) == true) goto L9;
        return false;
    L9:
        return ((NestedScrollingChild) ZeusTransformUtils.preCheckCast(r2, NestedScrollingChild.class, "com.obric.memorydata.plugin")).hasNestedScrollingParent();
    }

    public static boolean hasNestedScrollingParent(View r2, int r3) {
        if (ZeusTransformUtils.instanceOf(r2, NestedScrollingChild2.class) == false) goto L5;
        ((NestedScrollingChild2) ZeusTransformUtils.preCheckCast(r2, NestedScrollingChild2.class, "com.obric.memorydata.plugin")).hasNestedScrollingParent(r3);
        return false;
    L5:
        if (r3 == 0) goto L7;
        return false;
    L7:
        return hasNestedScrollingParent(r2);
    }

    public static boolean hasOnClickListeners(View r2) {
        if (Build.VERSION.SDK_INT >= 15) goto L5;
        return false;
    L5:
        return Api15Impl.hasOnClickListeners(r2);
    }

    public static boolean hasOverlappingRendering(View r2) {
        if (Build.VERSION.SDK_INT >= 16) goto L5;
        return true;
    L5:
        return Api16Impl.hasOverlappingRendering(r2);
    }

    public static boolean hasTransientState(View r2) {
        if (Build.VERSION.SDK_INT >= 16) goto L5;
        return false;
    L5:
        return Api16Impl.hasTransientState(r2);
    }

    public static boolean isAccessibilityHeading(View r2) {
        Boolean r3 = (Boolean) ZeusTransformUtils.preCheckCast(accessibilityHeadingProperty().get(r2), Boolean.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L5;
    L7:
        return false;
    L5:
        if (r3.booleanValue() == false) goto L7;
        return true;
    }

    public static boolean isAttachedToWindow(View r2) {
        if (Build.VERSION.SDK_INT < 19) goto L7;
        return Api19Impl.isAttachedToWindow(r2);
    L7:
        if (r2.getWindowToken() == null) goto L9;
        return true;
    L9:
        return false;
    }

    public static boolean isFocusedByDefault(View r2) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return false;
    L5:
        return Api26Impl.isFocusedByDefault(r2);
    }

    public static boolean isImportantForAccessibility(View r2) {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return true;
    L5:
        return Api21Impl.isImportantForAccessibility(r2);
    }

    public static boolean isImportantForAutofill(View r2) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return true;
    L5:
        return Api26Impl.isImportantForAutofill(r2);
    }

    public static boolean isImportantForContentCapture(View r2) {
        if (Build.VERSION.SDK_INT >= 30) goto L5;
        return false;
    L5:
        return Api30Impl.isImportantForContentCapture(r2);
    }

    public static boolean isInLayout(View r2) {
        if (Build.VERSION.SDK_INT >= 18) goto L5;
        return false;
    L5:
        return Api18Impl.isInLayout(r2);
    }

    public static boolean isKeyboardNavigationCluster(View r2) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return false;
    L5:
        return Api26Impl.isKeyboardNavigationCluster(r2);
    }

    public static boolean isLaidOut(View r2) {
        if (Build.VERSION.SDK_INT < 19) goto L7;
        return Api19Impl.isLaidOut(r2);
    L7:
        if (r2.getWidth() > 0) goto L9;
    L11:
        return false;
    L9:
        if (r2.getHeight() <= 0) goto L11;
        return true;
    }

    public static boolean isLayoutDirectionResolved(View r2) {
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        return false;
    L5:
        return Api19Impl.isLayoutDirectionResolved(r2);
    }

    public static boolean isNestedScrollingEnabled(View r2) {
        if (Build.VERSION.SDK_INT < 21) goto L7;
        return Api21Impl.isNestedScrollingEnabled(r2);
    L7:
        if (ZeusTransformUtils.instanceOf(r2, NestedScrollingChild.class) == true) goto L9;
        return false;
    L9:
        return ((NestedScrollingChild) ZeusTransformUtils.preCheckCast(r2, NestedScrollingChild.class, "com.obric.memorydata.plugin")).isNestedScrollingEnabled();
    }

    @Deprecated
    public static boolean isOpaque(View r0) {
        return r0.isOpaque();
    }

    public static boolean isPaddingRelative(View r2) {
        if (Build.VERSION.SDK_INT >= 17) goto L5;
        return false;
    L5:
        return Api17Impl.isPaddingRelative(r2);
    }

    public static boolean isScreenReaderFocusable(View r2) {
        Boolean r3 = (Boolean) ZeusTransformUtils.preCheckCast(screenReaderFocusableProperty().get(r2), Boolean.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L5;
    L7:
        return false;
    L5:
        if (r3.booleanValue() == false) goto L7;
        return true;
    }

    @Deprecated
    public static void jumpDrawablesToCurrentState(View r0) {
        r0.jumpDrawablesToCurrentState();
    }

    public static View keyboardNavigationClusterSearch(View r2, View r3, int r4) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return null;
    L5:
        return Api26Impl.keyboardNavigationClusterSearch(r2, r3, r4);
    }

    static /* synthetic */ ContentInfoCompat lambda$static$0(ContentInfoCompat r0) {
        return r0;
    }

    static void notifyViewAccessibilityStateChangedIfNeeded(View r4, int r5) {
        AccessibilityManager r0 = (AccessibilityManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService("accessibility"), AccessibilityManager.class, "com.obric.memorydata.plugin");
        if (r0.isEnabled() == true) goto L6;
        return;
    L6:
        if (getAccessibilityPaneTitle(r4) != null) goto L8;
    L12:
        boolean r1 = false;
    L13:
        int r3 = 32;
        if (getAccessibilityLiveRegion(r4) != 0) goto L26;
        if (r1 == true) goto L26;
        if (r5 != 32) goto L20;
        AccessibilityEvent r2 = AccessibilityEvent.obtain();
        r4.onInitializeAccessibilityEvent(r2);
        r2.setEventType(32);
        Api19Impl.setContentChangeTypes(r2, r5);
        r2.setSource(r4);
        r4.onPopulateAccessibilityEvent(r2);
        r2.getText().add(getAccessibilityPaneTitle(r4));
        r0.sendAccessibilityEvent(r2);
        return;
    L20:
        if (r4.getParent() != null) goto L35;
        return;
    L35:
        Api19Impl.notifySubtreeAccessibilityStateChanged(r4.getParent(), r4, r4, r5);     // Catch: AbstractMethodError -> L24
        return;
    L24:
        e = move-exception;
        Log.e(TAG, r4.getParent().getClass().getSimpleName() + " does not fully implement ViewParent", e);
        return;
    L26:
        AccessibilityEvent r6 = AccessibilityEvent.obtain();
        if (r1 == true) goto L30;
        r3 = 2048;
    L30:
        r6.setEventType(r3);
        Api19Impl.setContentChangeTypes(r6, r5);
        if (r1 == false) goto L33;
        r6.getText().add(getAccessibilityPaneTitle(r4));
        setImportantForAccessibilityIfNeeded(r4);
    L33:
        r4.sendAccessibilityEventUnchecked(r6);
        return;
    L8:
        if (r4.isShown() == false) goto L12;
        if (r4.getWindowVisibility() != 0) goto L12;
        r1 = true;
        goto L13
    }

    public static void offsetLeftAndRight(View r7, int r8) {
        if (Build.VERSION.SDK_INT < 23) goto L6;
        r7.offsetLeftAndRight(r8);
        return;
    L6:
        if (Build.VERSION.SDK_INT < 21) goto L15;
        Rect r0 = getEmptyTempRect();
        boolean r1 = false;
        ViewParent r2 = r7.getParent();
        if (ZeusTransformUtils.instanceOf(r2, View.class) == false) goto L10;
        View r3 = (View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.memorydata.plugin");
        r0.set(r3.getLeft(), r3.getTop(), r3.getRight(), r3.getBottom());
        r1 = !r0.intersects(r7.getLeft(), r7.getTop(), r7.getRight(), r7.getBottom());
    L10:
        compatOffsetLeftAndRight(r7, r8);
        if (r1 == true) goto L13;
        return;
    L13:
        if (r0.intersect(r7.getLeft(), r7.getTop(), r7.getRight(), r7.getBottom()) == false) goto L19;
        ((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.memorydata.plugin")).invalidate(r0);
        return;
    L19:
        return;
    L15:
        compatOffsetLeftAndRight(r7, r8);
    }

    public static void offsetTopAndBottom(View r7, int r8) {
        if (Build.VERSION.SDK_INT < 23) goto L6;
        r7.offsetTopAndBottom(r8);
        return;
    L6:
        if (Build.VERSION.SDK_INT < 21) goto L15;
        Rect r0 = getEmptyTempRect();
        boolean r1 = false;
        ViewParent r2 = r7.getParent();
        if (ZeusTransformUtils.instanceOf(r2, View.class) == false) goto L10;
        View r3 = (View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.memorydata.plugin");
        r0.set(r3.getLeft(), r3.getTop(), r3.getRight(), r3.getBottom());
        r1 = !r0.intersects(r7.getLeft(), r7.getTop(), r7.getRight(), r7.getBottom());
    L10:
        compatOffsetTopAndBottom(r7, r8);
        if (r1 == true) goto L13;
        return;
    L13:
        if (r0.intersect(r7.getLeft(), r7.getTop(), r7.getRight(), r7.getBottom()) == false) goto L19;
        ((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.memorydata.plugin")).invalidate(r0);
        return;
    L19:
        return;
    L15:
        compatOffsetTopAndBottom(r7, r8);
    }

    public static WindowInsetsCompat onApplyWindowInsets(View r2, WindowInsetsCompat r3) {
        if (Build.VERSION.SDK_INT < 21) goto L10;
        WindowInsets r0 = r3.toWindowInsets();
        if (r0 == null) goto L10;
        WindowInsets r1 = Api20Impl.onApplyWindowInsets(r2, r0);
        if (r1.equals(r0) == true) goto L10;
        return WindowInsetsCompat.toWindowInsetsCompat(r1, r2);
    L10:
        return r3;
    }

    @Deprecated
    public static void onInitializeAccessibilityEvent(View r0, AccessibilityEvent r1) {
        r0.onInitializeAccessibilityEvent(r1);
    }

    public static void onInitializeAccessibilityNodeInfo(View r0, AccessibilityNodeInfoCompat r1) {
        r0.onInitializeAccessibilityNodeInfo(r1.unwrap());
    }

    @Deprecated
    public static void onPopulateAccessibilityEvent(View r0, AccessibilityEvent r1) {
        r0.onPopulateAccessibilityEvent(r1);
    }

    private static AccessibilityViewProperty<CharSequence> paneTitleProperty() {
        final int r1 = ZeusTransformUtils.mapRes(R.id.tag_accessibility_pane_title, OaidModel.KEY_ID, "tag_accessibility_pane_title");
        final Class<CharSequence> r2 = CharSequence.class;
        final int r3 = 8;
        final int r4 = 28;
        return new AnonymousClass2(r1, r2, r3, r4);
    }

    public static boolean performAccessibilityAction(View r2, int r3, Bundle r4) {
        if (Build.VERSION.SDK_INT >= 16) goto L5;
        return false;
    L5:
        return Api16Impl.performAccessibilityAction(r2, r3, r4);
    }

    public static boolean performHapticFeedback(View r1, int r2) {
        int r3 = HapticFeedbackConstantsCompat.getFeedbackConstantOrFallback(r2);
        if (r3 != (-1)) goto L7;
        return false;
    L7:
        return r1.performHapticFeedback(r3);
    }

    public static boolean performHapticFeedback(View r1, int r2, int r3) {
        int r4 = HapticFeedbackConstantsCompat.getFeedbackConstantOrFallback(r2);
        if (r4 != (-1)) goto L7;
        return false;
    L7:
        return r1.performHapticFeedback(r4, r3);
    }

    public static ContentInfoCompat performReceiveContent(View r3, ContentInfoCompat r4) {
        if (Log.isLoggable(TAG, 3) == false) goto L6;
        Log.d(TAG, "performReceiveContent: " + r4 + ", view=" + r3.getClass().getSimpleName() + "[" + r3.getId() + "]");
    L6:
        if (Build.VERSION.SDK_INT >= 31) goto L8;
        OnReceiveContentListener r0 = (OnReceiveContentListener) ZeusTransformUtils.preCheckCast(r3.getTag(ZeusTransformUtils.mapRes(R.id.tag_on_receive_content_listener, OaidModel.KEY_ID, "tag_on_receive_content_listener")), OnReceiveContentListener.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L17;
        ContentInfoCompat r5 = r0.onReceiveContent(r3, r4);
        if (r5 != null) goto L15;
        return null;
    L15:
        return getFallback(r3).onReceiveContent(r5);
    L17:
        return getFallback(r3).onReceiveContent(r4);
    L8:
        return Api31Impl.performReceiveContent(r3, r4);
    }

    public static void postInvalidateOnAnimation(View r2) {
        if (Build.VERSION.SDK_INT < 16) goto L5;
        Api16Impl.postInvalidateOnAnimation(r2);
        return;
    L5:
        r2.postInvalidate();
    }

    public static void postInvalidateOnAnimation(View r2, int r3, int r4, int r5, int r6) {
        if (Build.VERSION.SDK_INT < 16) goto L5;
        Api16Impl.postInvalidateOnAnimation(r2, r3, r4, r5, r6);
        return;
    L5:
        r2.postInvalidate(r3, r4, r5, r6);
    }

    public static void postOnAnimation(View r2, Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 16) goto L5;
        Api16Impl.postOnAnimation(r2, r4);
        return;
    L5:
        r2.postDelayed(r4, ValueAnimator.getFrameDelay());
    }

    public static void postOnAnimationDelayed(View r2, Runnable r3, long r4) {
        Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 16) goto L5;
        Api16Impl.postOnAnimationDelayed(r2, r5, r4);
        return;
    L5:
        r2.postDelayed(r5, ValueAnimator.getFrameDelay() + r4);
    }

    public static void removeAccessibilityAction(View r2, int r3) {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        removeActionWithId(r3, r2);
        notifyViewAccessibilityStateChangedIfNeeded(r2, 0);
        return;
    }

    private static void removeActionWithId(int r4, View r5) {
        List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> r6 = getActionList(r5);
        int r0 = 0;
    L4:
        if (r0 >= r6.size()) goto L12;
        if (((AccessibilityNodeInfoCompat.AccessibilityActionCompat) ZeusTransformUtils.preCheckCast(r6.get(r0), AccessibilityNodeInfoCompat.AccessibilityActionCompat.class, "com.obric.memorydata.plugin")).getId() == r4) goto L7;
        r0 = r0 + 1;
        goto L4
    L7:
        r6.remove(r0);
        return;
    }

    public static void removeOnUnhandledKeyEventListener(View r4, OnUnhandledKeyEventListenerCompat r5) {
        OnUnhandledKeyEventListenerCompat r6 = (OnUnhandledKeyEventListenerCompat) ZeusTransformUtils.wrapperContextForParams(r5, OnUnhandledKeyEventListenerCompat.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 28) goto L6;
        Api28Impl.removeOnUnhandledKeyEventListener(r4, r6);
        return;
    L6:
        ArrayList r0 = (ArrayList) ZeusTransformUtils.preCheckCast(r4.getTag(ZeusTransformUtils.mapRes(R.id.tag_unhandled_key_listeners, OaidModel.KEY_ID, "tag_unhandled_key_listeners")), ArrayList.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L12;
        r0.remove(r6);
        if (r0.size() != 0) goto L13;
        UnhandledKeyEventManager.unregisterListeningView(r4);
        return;
    L13:
        return;
    }

    public static void replaceAccessibilityAction(View r2, AccessibilityNodeInfoCompat.AccessibilityActionCompat r3, CharSequence r4, AccessibilityViewCommand r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin");
        AccessibilityViewCommand r7 = (AccessibilityViewCommand) ZeusTransformUtils.wrapperContextForParams(r5, AccessibilityViewCommand.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L6;
        if (r6 != null) goto L6;
        removeAccessibilityAction(r2, r3.getId());
        return;
    L6:
        addAccessibilityAction(r2, r3.createReplacementAction(r6, r7));
    }

    public static void requestApplyInsets(View r2) {
        if (Build.VERSION.SDK_INT < 20) goto L6;
        Api20Impl.requestApplyInsets(r2);
        return;
    L6:
        if (Build.VERSION.SDK_INT < 16) goto L10;
        Api16Impl.requestFitSystemWindows(r2);
        return;
    }

    public static <T extends View> T requireViewById(View r2, int r3) {
        if (Build.VERSION.SDK_INT >= 28) goto L5;
        T r4 = (T) r2.findViewById(r3);
        if (r4 == null) goto L10;
        return r4;
    L10:
        throw new IllegalArgumentException("ID does not reference a View inside this View");
    L5:
        return (T) ZeusTransformUtils.preCheckCast(Api28Impl.requireViewById(r2, r3), View.class, "com.obric.memorydata.plugin");
    }

    @Deprecated
    public static int resolveSizeAndState(int r0, int r1, int r2) {
        return View.resolveSizeAndState(r0, r1, r2);
    }

    public static boolean restoreDefaultFocus(View r2) {
        if (Build.VERSION.SDK_INT < 26) goto L7;
        return Api26Impl.restoreDefaultFocus(r2);
    L7:
        return r2.requestFocus();
    }

    public static void saveAttributeDataForStyleable(View r9, Context r10, int[] r11, AttributeSet r12, TypedArray r13, int r14, int r15) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r5 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r12, AttributeSet.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 29) goto L6;
        Api29Impl.saveAttributeDataForStyleable(r9, r3, r11, r5, r13, r14, r15);
        return;
    }

    private static AccessibilityViewProperty<Boolean> screenReaderFocusableProperty() {
        final int r1 = ZeusTransformUtils.mapRes(R.id.tag_screen_reader_focusable, OaidModel.KEY_ID, "tag_screen_reader_focusable");
        final Class<Boolean> r2 = Boolean.class;
        final int r3 = 28;
        return new AnonymousClass1(r1, r2, r3);
    }

    public static void setAccessibilityDelegate(View r2, AccessibilityDelegateCompat r3) {
        if (r3 == null) goto L4;
    L6:
        setImportantForAccessibilityIfNeeded(r2);
        if (r3 != null) goto L9;
        View.AccessibilityDelegate r4 = null;
    L10:
        r2.setAccessibilityDelegate(r4);
        return;
    L9:
        r4 = r3.getBridge();
        goto L10
    L4:
        if (ZeusTransformUtils.instanceOf(getAccessibilityDelegateInternal(r2), AccessibilityDelegateCompat.AccessibilityDelegateAdapter.class) == false) goto L6;
        r3 = new AccessibilityDelegateCompat();
        goto L6
    }

    public static void setAccessibilityHeading(View r1, boolean r2) {
        accessibilityHeadingProperty().set(r1, Boolean.valueOf(r2));
    }

    public static void setAccessibilityLiveRegion(View r2, int r3) {
        if (Build.VERSION.SDK_INT < 19) goto L6;
        Api19Impl.setAccessibilityLiveRegion(r2, r3);
        return;
    }

    public static void setAccessibilityPaneTitle(View r2, CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 19) goto L9;
        paneTitleProperty().set(r2, r4);
        if (r4 == null) goto L7;
        sAccessibilityPaneVisibilityManager.addAccessibilityPane(r2);
        return;
    L7:
        sAccessibilityPaneVisibilityManager.removeAccessibilityPane(r2);
        return;
    }

    @Deprecated
    public static void setActivated(View r0, boolean r1) {
        r0.setActivated(r1);
    }

    @Deprecated
    public static void setAlpha(View r0, float r1) {
        r0.setAlpha(r1);
    }

    public static void setAutofillHints(View r2, String... r3) {
        if (Build.VERSION.SDK_INT < 26) goto L6;
        Api26Impl.setAutofillHints(r2, r3);
        return;
    }

    public static void setAutofillId(View r2, AutofillIdCompat r3) {
        if (Build.VERSION.SDK_INT < 28) goto L6;
        Api28Impl.setAutofillId(r2, r3.toAutofillId());
        return;
    }

    public static void setBackground(View r2, Drawable r3) {
        if (Build.VERSION.SDK_INT < 16) goto L5;
        Api16Impl.setBackground(r2, r3);
        return;
    L5:
        r2.setBackgroundDrawable(r3);
    }

    public static void setBackgroundTintList(View r2, ColorStateList r3) {
        if (Build.VERSION.SDK_INT < 21) goto L20;
        Api21Impl.setBackgroundTintList(r2, r3);
        if (Build.VERSION.SDK_INT != 21) goto L23;
        Drawable r4 = r2.getBackground();
        if (Api21Impl.getBackgroundTintList(r2) == null) goto L9;
    L12:
        boolean r0 = true;
    L13:
        if (r4 == null) goto L24;
        if (r0 == true) goto L16;
        return;
    L16:
        if (r4.isStateful() == false) goto L18;
        r4.setState(r2.getDrawableState());
    L18:
        Api16Impl.setBackground(r2, r4);
        return;
    L24:
        return;
    L9:
        if (Api21Impl.getBackgroundTintMode(r2) != null) goto L12;
        r0 = false;
        goto L13
    L23:
        return;
    L20:
        if (ZeusTransformUtils.instanceOf(r2, TintableBackgroundView.class) == false) goto L27;
        ((TintableBackgroundView) ZeusTransformUtils.preCheckCast(r2, TintableBackgroundView.class, "com.obric.memorydata.plugin")).setSupportBackgroundTintList(r3);
        return;
    }

    public static void setBackgroundTintMode(View r2, PorterDuff.Mode r3) {
        if (Build.VERSION.SDK_INT < 21) goto L20;
        Api21Impl.setBackgroundTintMode(r2, r3);
        if (Build.VERSION.SDK_INT != 21) goto L23;
        Drawable r4 = r2.getBackground();
        if (Api21Impl.getBackgroundTintList(r2) == null) goto L9;
    L12:
        boolean r0 = true;
    L13:
        if (r4 == null) goto L24;
        if (r0 == true) goto L16;
        return;
    L16:
        if (r4.isStateful() == false) goto L18;
        r4.setState(r2.getDrawableState());
    L18:
        Api16Impl.setBackground(r2, r4);
        return;
    L24:
        return;
    L9:
        if (Api21Impl.getBackgroundTintMode(r2) != null) goto L12;
        r0 = false;
        goto L13
    L23:
        return;
    L20:
        if (ZeusTransformUtils.instanceOf(r2, TintableBackgroundView.class) == false) goto L27;
        ((TintableBackgroundView) ZeusTransformUtils.preCheckCast(r2, TintableBackgroundView.class, "com.obric.memorydata.plugin")).setSupportBackgroundTintMode(r3);
        return;
    }

    @Deprecated
    public static void setChildrenDrawingOrderEnabled(ViewGroup r8, boolean r9) {
        if (sChildrenDrawingOrderMethod != null) goto L16;
        sChildrenDrawingOrderMethod = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", new Class[]{Boolean.TYPE});     // Catch: NoSuchMethodException -> L6
    L8:
        sChildrenDrawingOrderMethod.setAccessible(true);
    L6:
        e = move-exception;
        Log.e(TAG, "Unable to find childrenDrawingOrderEnabled", e);
    L16:
        sChildrenDrawingOrderMethod.invoke(r8, new Object[]{Boolean.valueOf(r9)});     // Catch: Throwable -> L11
        return;
    L11:
        e = move-exception;
        Log.e(TAG, "Unable to invoke childrenDrawingOrderEnabled", e);
    }

    public static void setClipBounds(View r2, Rect r3) {
        if (Build.VERSION.SDK_INT < 18) goto L6;
        Api18Impl.setClipBounds(r2, r3);
        return;
    }

    public static void setContentCaptureSession(View r2, ContentCaptureSessionCompat r3) {
        if (Build.VERSION.SDK_INT < 29) goto L6;
        Api29Impl.setContentCaptureSession(r2, r3.toContentCaptureSession());
        return;
    }

    public static void setElevation(View r2, float r3) {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        Api21Impl.setElevation(r2, r3);
        return;
    }

    @Deprecated
    public static void setFitsSystemWindows(View r0, boolean r1) {
        r0.setFitsSystemWindows(r1);
    }

    public static void setFocusedByDefault(View r2, boolean r3) {
        if (Build.VERSION.SDK_INT < 26) goto L6;
        Api26Impl.setFocusedByDefault(r2, r3);
        return;
    }

    public static void setHasTransientState(View r2, boolean r3) {
        if (Build.VERSION.SDK_INT < 16) goto L6;
        Api16Impl.setHasTransientState(r2, r3);
        return;
    }

    public static void setImportantForAccessibility(View r2, int r3) {
        if (Build.VERSION.SDK_INT < 19) goto L6;
    L4:
        Api16Impl.setImportantForAccessibility(r2, r3);
        return;
    L6:
        if (Build.VERSION.SDK_INT >= 16) goto L8;
        return;
    L8:
        if (r3 != 4) goto L4;
        r3 = 2;
        goto L4
    }

    private static void setImportantForAccessibilityIfNeeded(View r1) {
        if (getImportantForAccessibility(r1) != 0) goto L6;
        setImportantForAccessibility(r1, 1);
        return;
    }

    public static void setImportantForAutofill(View r2, int r3) {
        if (Build.VERSION.SDK_INT < 26) goto L6;
        Api26Impl.setImportantForAutofill(r2, r3);
        return;
    }

    public static void setImportantForContentCapture(View r2, int r3) {
        if (Build.VERSION.SDK_INT < 30) goto L6;
        Api30Impl.setImportantForContentCapture(r2, r3);
        return;
    }

    public static void setKeyboardNavigationCluster(View r2, boolean r3) {
        if (Build.VERSION.SDK_INT < 26) goto L6;
        Api26Impl.setKeyboardNavigationCluster(r2, r3);
        return;
    }

    public static void setLabelFor(View r2, int r3) {
        if (Build.VERSION.SDK_INT < 17) goto L6;
        Api17Impl.setLabelFor(r2, r3);
        return;
    }

    public static void setLayerPaint(View r2, Paint r3) {
        if (Build.VERSION.SDK_INT < 17) goto L5;
        Api17Impl.setLayerPaint(r2, r3);
        return;
    L5:
        r2.setLayerType(r2.getLayerType(), r3);
        r2.invalidate();
    }

    @Deprecated
    public static void setLayerType(View r0, int r1, Paint r2) {
        r0.setLayerType(r1, r2);
    }

    public static void setLayoutDirection(View r2, int r3) {
        if (Build.VERSION.SDK_INT < 17) goto L6;
        Api17Impl.setLayoutDirection(r2, r3);
        return;
    }

    public static void setNestedScrollingEnabled(View r2, boolean r3) {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        Api21Impl.setNestedScrollingEnabled(r2, r3);
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r2, NestedScrollingChild.class) == false) goto L10;
        ((NestedScrollingChild) ZeusTransformUtils.preCheckCast(r2, NestedScrollingChild.class, "com.obric.memorydata.plugin")).setNestedScrollingEnabled(r3);
        return;
    }

    public static void setNextClusterForwardId(View r2, int r3) {
        if (Build.VERSION.SDK_INT < 26) goto L6;
        Api26Impl.setNextClusterForwardId(r2, r3);
        return;
    }

    public static void setOnApplyWindowInsetsListener(View r2, OnApplyWindowInsetsListener r3) {
        OnApplyWindowInsetsListener r4 = (OnApplyWindowInsetsListener) ZeusTransformUtils.wrapperContextForParams(r3, OnApplyWindowInsetsListener.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 21) goto L6;
        Api21Impl.setOnApplyWindowInsetsListener(r2, r4);
        return;
    }

    public static void setOnReceiveContentListener(View r6, String[] r7, OnReceiveContentListener r8) {
        OnReceiveContentListener r9 = (OnReceiveContentListener) ZeusTransformUtils.wrapperContextForParams(r8, OnReceiveContentListener.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 31) goto L6;
        Api31Impl.setOnReceiveContentListener(r6, r7, r9);
        return;
    L6:
        if (r7 != null) goto L8;
    L9:
        r7 = null;
    L10:
        boolean r0 = false;
        if (r9 == null) goto L16;
        if (r7 == null) goto L14;
        boolean r2 = true;
    L15:
        Preconditions.checkArgument(r2, "When the listener is set, MIME types must also be set");
        goto L16
    L14:
        r2 = false;
    L16:
        if (r7 == null) goto L24;
        int r3 = r7.length;
        int r4 = 0;
    L18:
        if (r4 >= r3) goto L23;
        if (r7[r4].startsWith("*") == true) goto L21;
        r4 = r4 + 1;
        goto L18
    L21:
        r0 = true;
    L23:
        Preconditions.checkArgument(!r0, "A MIME type set here must not start with *: " + Arrays.toString(r7));
    L24:
        r6.setTag(ZeusTransformUtils.mapRes(R.id.tag_on_receive_content_mime_types, OaidModel.KEY_ID, "tag_on_receive_content_mime_types"), r7);
        r6.setTag(ZeusTransformUtils.mapRes(R.id.tag_on_receive_content_listener, OaidModel.KEY_ID, "tag_on_receive_content_listener"), r9);
        return;
    L8:
        if (r7.length != 0) goto L10;
        goto L9
    }

    @Deprecated
    public static void setOverScrollMode(View r0, int r1) {
        r0.setOverScrollMode(r1);
    }

    public static void setPaddingRelative(View r2, int r3, int r4, int r5, int r6) {
        if (Build.VERSION.SDK_INT < 17) goto L5;
        Api17Impl.setPaddingRelative(r2, r3, r4, r5, r6);
        return;
    L5:
        r2.setPadding(r3, r4, r5, r6);
    }

    @Deprecated
    public static void setPivotX(View r0, float r1) {
        r0.setPivotX(r1);
    }

    @Deprecated
    public static void setPivotY(View r0, float r1) {
        r0.setPivotY(r1);
    }

    public static void setPointerIcon(View r2, PointerIconCompat r3) {
        if (Build.VERSION.SDK_INT < 24) goto L9;
        if (r3 == null) goto L6;
        Object r4 = r3.getPointerIcon();
    L7:
        Api24Impl.setPointerIcon(r2, (PointerIcon) ZeusTransformUtils.preCheckCast(r4, PointerIcon.class, "com.obric.memorydata.plugin"));
        return;
    L6:
        r4 = null;
        goto L7
    }

    @Deprecated
    public static void setRotation(View r0, float r1) {
        r0.setRotation(r1);
    }

    @Deprecated
    public static void setRotationX(View r0, float r1) {
        r0.setRotationX(r1);
    }

    @Deprecated
    public static void setRotationY(View r0, float r1) {
        r0.setRotationY(r1);
    }

    @Deprecated
    public static void setSaveFromParentEnabled(View r0, boolean r1) {
        r0.setSaveFromParentEnabled(r1);
    }

    @Deprecated
    public static void setScaleX(View r0, float r1) {
        r0.setScaleX(r1);
    }

    @Deprecated
    public static void setScaleY(View r0, float r1) {
        r0.setScaleY(r1);
    }

    public static void setScreenReaderFocusable(View r1, boolean r2) {
        screenReaderFocusableProperty().set(r1, Boolean.valueOf(r2));
    }

    public static void setScrollIndicators(View r2, int r3) {
        if (Build.VERSION.SDK_INT < 23) goto L6;
        Api23Impl.setScrollIndicators(r2, r3);
        return;
    }

    public static void setScrollIndicators(View r2, int r3, int r4) {
        if (Build.VERSION.SDK_INT < 23) goto L6;
        Api23Impl.setScrollIndicators(r2, r3, r4);
        return;
    }

    public static void setStateDescription(View r2, CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 19) goto L6;
        stateDescriptionProperty().set(r2, r4);
        return;
    }

    public static void setSystemGestureExclusionRects(View r2, List<Rect> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 29) goto L6;
        Api29Impl.setSystemGestureExclusionRects(r2, r4);
        return;
    }

    public static void setTooltipText(View r2, CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 26) goto L6;
        Api26Impl.setTooltipText(r2, r4);
        return;
    }

    public static void setTransitionName(View r2, String r3) {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        Api21Impl.setTransitionName(r2, r3);
        return;
    L6:
        if (sTransitionNameMap != null) goto L8;
        sTransitionNameMap = new WeakHashMap();
    L8:
        sTransitionNameMap.put(r2, r3);
    }

    @Deprecated
    public static void setTranslationX(View r0, float r1) {
        r0.setTranslationX(r1);
    }

    @Deprecated
    public static void setTranslationY(View r0, float r1) {
        r0.setTranslationY(r1);
    }

    public static void setTranslationZ(View r2, float r3) {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        Api21Impl.setTranslationZ(r2, r3);
        return;
    }

    public static void setWindowInsetsAnimationCallback(View r0, WindowInsetsAnimationCompat.Callback r1) {
        WindowInsetsAnimationCompat.setCallback(r0, r1);
    }

    @Deprecated
    public static void setX(View r0, float r1) {
        r0.setX(r1);
    }

    @Deprecated
    public static void setY(View r0, float r1) {
        r0.setY(r1);
    }

    public static void setZ(View r2, float r3) {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        Api21Impl.setZ(r2, r3);
        return;
    }

    public static boolean startDragAndDrop(View r2, ClipData r3, View.DragShadowBuilder r4, Object r5, int r6) {
        if (Build.VERSION.SDK_INT < 24) goto L7;
        return Api24Impl.startDragAndDrop(r2, r3, r4, r5, r6);
    L7:
        return r2.startDrag(r3, r4, r5, r6);
    }

    public static boolean startNestedScroll(View r2, int r3) {
        if (Build.VERSION.SDK_INT < 21) goto L7;
        return Api21Impl.startNestedScroll(r2, r3);
    L7:
        if (ZeusTransformUtils.instanceOf(r2, NestedScrollingChild.class) == true) goto L9;
        return false;
    L9:
        return ((NestedScrollingChild) ZeusTransformUtils.preCheckCast(r2, NestedScrollingChild.class, "com.obric.memorydata.plugin")).startNestedScroll(r3);
    }

    public static boolean startNestedScroll(View r2, int r3, int r4) {
        if (ZeusTransformUtils.instanceOf(r2, NestedScrollingChild2.class) == true) goto L5;
        if (r4 == 0) goto L8;
        return false;
    L8:
        return startNestedScroll(r2, r3);
    L5:
        return ((NestedScrollingChild2) ZeusTransformUtils.preCheckCast(r2, NestedScrollingChild2.class, "com.obric.memorydata.plugin")).startNestedScroll(r3, r4);
    }

    private static AccessibilityViewProperty<CharSequence> stateDescriptionProperty() {
        final int r1 = ZeusTransformUtils.mapRes(R.id.tag_state_description, OaidModel.KEY_ID, "tag_state_description");
        final Class<CharSequence> r2 = CharSequence.class;
        final int r3 = 64;
        final int r4 = 30;
        return new AnonymousClass3(r1, r2, r3, r4);
    }

    public static void stopNestedScroll(View r2) {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        Api21Impl.stopNestedScroll(r2);
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r2, NestedScrollingChild.class) == false) goto L10;
        ((NestedScrollingChild) ZeusTransformUtils.preCheckCast(r2, NestedScrollingChild.class, "com.obric.memorydata.plugin")).stopNestedScroll();
        return;
    }

    public static void stopNestedScroll(View r2, int r3) {
        if (ZeusTransformUtils.instanceOf(r2, NestedScrollingChild2.class) == false) goto L5;
        ((NestedScrollingChild2) ZeusTransformUtils.preCheckCast(r2, NestedScrollingChild2.class, "com.obric.memorydata.plugin")).stopNestedScroll(r3);
        return;
    L5:
        if (r3 != 0) goto L9;
        stopNestedScroll(r2);
        return;
    }

    private static void tickleInvalidationFlag(View r2) {
        float r0 = r2.getTranslationY();
        r2.setTranslationY(1.0f + r0);
        r2.setTranslationY(r0);
    }

    public static void updateDragShadow(View r2, View.DragShadowBuilder r3) {
        if (Build.VERSION.SDK_INT < 24) goto L6;
        Api24Impl.updateDragShadow(r2, r3);
        return;
    }
}
