package androidx.core.view;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
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
import androidx.annotation.DoNotInline;
import androidx.annotation.FloatRange;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.UiThread;
import androidx.collection.SimpleArrayMap;
import androidx.core.R;
import androidx.core.util.Preconditions;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
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
@SuppressLint({"PrivateConstructorForUtilityClass"})
public class ViewCompat {
    private static final int[] ACCESSIBILITY_ACTIONS_RESOURCE_IDS = null;
    public static final int ACCESSIBILITY_LIVE_REGION_ASSERTIVE = 2;
    public static final int ACCESSIBILITY_LIVE_REGION_NONE = 0;
    public static final int ACCESSIBILITY_LIVE_REGION_POLITE = 1;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_AUTO = 0;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_NO = 2;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_NO_HIDE_DESCENDANTS = 4;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_YES = 1;

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

    static class AccessibilityPaneVisibilityManager implements ViewTreeObserver.OnGlobalLayoutListener, View.OnAttachStateChangeListener {
        private final WeakHashMap<View, Boolean> mPanesToVisible;

        AccessibilityPaneVisibilityManager() {
            this.mPanesToVisible = new WeakHashMap();
        }

        @RequiresApi(19)
        private void checkPaneVisibility(View r10, boolean r11) {
            if (r10.isShown() == true) goto L5;
        L7:
            boolean r12 = false;
        L8:
            if (r11 == r12) goto L14;
            if (r12 == false) goto L11;
            int r13 = 16;
        L12:
            ViewCompat.notifyViewAccessibilityStateChangedIfNeeded(r10, r13);
            this.mPanesToVisible.put(r10, Boolean.valueOf(r12));
            return;
        L11:
            r13 = 32;
            goto L12
        L14:
            return;
        L5:
            if (r10.getWindowVisibility() != 0) goto L7;
            r12 = true;
            goto L8
        }

        @RequiresApi(19)
        private void registerForLayoutCallback(View r10) {
            r10.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }

        @RequiresApi(19)
        private void unregisterForLayoutCallback(View r10) {
            Api16Impl.removeOnGlobalLayoutListener(r10.getViewTreeObserver(), this);
        }

        @RequiresApi(19)
        void addAccessibilityPane(View r10) {
            WeakHashMap<View, Boolean> r11 = this.mPanesToVisible;
            if (r10.isShown() == true) goto L5;
        L7:
            boolean r12 = false;
        L8:
            r11.put(r10, Boolean.valueOf(r12));
            r10.addOnAttachStateChangeListener(this);
            if (Api19Impl.isAttachedToWindow(r10) == false) goto L12;
            registerForLayoutCallback(r10);
            return;
        L12:
            return;
        L5:
            if (r10.getWindowVisibility() != 0) goto L7;
            r12 = true;
            goto L8
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        @RequiresApi(19)
        public void onGlobalLayout() {
            if (Build.VERSION.SDK_INT >= 28) goto L8;
            Iterator<Map.Entry<View, Boolean>> r10 = this.mPanesToVisible.entrySet().iterator();
        L6:
            if (r10.hasNext() == false) goto L10;
            Map.Entry<View, Boolean> r11 = r10.next();
            checkPaneVisibility(r11.getKey(), r11.getValue().booleanValue());
            goto L6
        L10:
            return;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        @RequiresApi(19)
        public void onViewAttachedToWindow(View r10) {
            registerForLayoutCallback(r10);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View r10) {
        }

        @RequiresApi(19)
        void removeAccessibilityPane(View r10) {
            this.mPanesToVisible.remove(r10);
            r10.removeOnAttachStateChangeListener(this);
            unregisterForLayoutCallback(r10);
        }
    }

    static abstract class AccessibilityViewProperty<T> {
        private final int mContentChangeType;
        private final int mFrameworkMinimumSdk;
        private final int mTagKey;
        private final Class<T> mType;

        AccessibilityViewProperty(int r10, Class<T> r11, int r12) {
            this(r10, r11, 0, r12);
        }

        AccessibilityViewProperty(int r10, Class<T> r11, int r12, int r13) {
            this.mTagKey = r10;
            this.mType = r11;
            this.mContentChangeType = r12;
            this.mFrameworkMinimumSdk = r13;
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

        boolean booleanNullToFalseEquals(Boolean r10, Boolean r11) {
            if (r10 != null) goto L5;
        L7:
            boolean r12 = false;
        L8:
            if (r11 != null) goto L10;
        L12:
            boolean r13 = false;
        L13:
            if (r12 != r13) goto L16;
            return true;
        L16:
            return false;
        L10:
            if (r11.booleanValue() == false) goto L12;
            r13 = true;
            goto L13
        L5:
            if (r10.booleanValue() == false) goto L7;
            r12 = true;
            goto L8
        }

        abstract T frameworkGet(View r10);

        abstract void frameworkSet(View r10, T r11);

        T get(View r10) {
            if (frameworkAvailable() == false) goto L7;
            return frameworkGet(r10);
        L7:
            if (extrasAvailable() == false) goto L11;
            T r11 = (T) r10.getTag(this.mTagKey);
            if (this.mType.isInstance(r11) == false) goto L13;
            return r11;
        L13:
            return null;
        L11:
            return null;
        }

        void set(View r10, T r11) {
            if (frameworkAvailable() == false) goto L6;
            frameworkSet(r10, r11);
            return;
        L6:
            if (extrasAvailable() == true) goto L8;
            return;
        L8:
            if (shouldUpdate(get(r10), r11) == false) goto L13;
            ViewCompat.ensureAccessibilityDelegateCompat(r10);
            r10.setTag(this.mTagKey, r11);
            ViewCompat.notifyViewAccessibilityStateChangedIfNeeded(r10, this.mContentChangeType);
            return;
        }

        boolean shouldUpdate(T r10, T r11) {
            return !r11.equals(r10);
        }
    }

    @RequiresApi(15)
    static class Api15Impl {
        private Api15Impl() {
        }

        @DoNotInline
        static boolean hasOnClickListeners(@NonNull View r10) {
            return r10.hasOnClickListeners();
        }
    }

    @RequiresApi(16)
    static class Api16Impl {
        private Api16Impl() {
        }

        @DoNotInline
        static AccessibilityNodeProvider getAccessibilityNodeProvider(View r10) {
            return r10.getAccessibilityNodeProvider();
        }

        @DoNotInline
        static boolean getFitsSystemWindows(View r10) {
            return r10.getFitsSystemWindows();
        }

        @DoNotInline
        static int getImportantForAccessibility(View r10) {
            return r10.getImportantForAccessibility();
        }

        @DoNotInline
        static int getMinimumHeight(View r10) {
            return r10.getMinimumHeight();
        }

        @DoNotInline
        static int getMinimumWidth(View r10) {
            return r10.getMinimumWidth();
        }

        @DoNotInline
        static ViewParent getParentForAccessibility(View r10) {
            return r10.getParentForAccessibility();
        }

        @DoNotInline
        static int getWindowSystemUiVisibility(View r10) {
            return r10.getWindowSystemUiVisibility();
        }

        @DoNotInline
        static boolean hasOverlappingRendering(View r10) {
            return r10.hasOverlappingRendering();
        }

        @DoNotInline
        static boolean hasTransientState(View r10) {
            return r10.hasTransientState();
        }

        @DoNotInline
        static boolean performAccessibilityAction(View r10, int r11, Bundle r12) {
            return r10.performAccessibilityAction(r11, r12);
        }

        @DoNotInline
        static void postInvalidateOnAnimation(View r10) {
            r10.postInvalidateOnAnimation();
        }

        @DoNotInline
        static void postInvalidateOnAnimation(View r10, int r11, int r12, int r13, int r14) {
            r10.postInvalidateOnAnimation(r11, r12, r13, r14);
        }

        @DoNotInline
        static void postOnAnimation(View r10, Runnable r11) {
            r10.postOnAnimation(r11);
        }

        @DoNotInline
        static void postOnAnimationDelayed(View r10, Runnable r11, long r12) {
            r10.postOnAnimationDelayed(r11, r12);
        }

        @DoNotInline
        static void removeOnGlobalLayoutListener(ViewTreeObserver r10, ViewTreeObserver.OnGlobalLayoutListener r11) {
            r10.removeOnGlobalLayoutListener(r11);
        }

        @DoNotInline
        static void requestFitSystemWindows(View r10) {
            r10.requestFitSystemWindows();
        }

        @DoNotInline
        static void setBackground(View r10, Drawable r11) {
            r10.setBackground(r11);
        }

        @DoNotInline
        static void setHasTransientState(View r10, boolean r11) {
            r10.setHasTransientState(r11);
        }

        @DoNotInline
        static void setImportantForAccessibility(View r10, int r11) {
            r10.setImportantForAccessibility(r11);
        }
    }

    @RequiresApi(17)
    static class Api17Impl {
        private Api17Impl() {
        }

        @DoNotInline
        static int generateViewId() {
            return View.generateViewId();
        }

        @DoNotInline
        static Display getDisplay(@NonNull View r10) {
            return r10.getDisplay();
        }

        @DoNotInline
        static int getLabelFor(View r10) {
            return r10.getLabelFor();
        }

        @DoNotInline
        static int getLayoutDirection(View r10) {
            return r10.getLayoutDirection();
        }

        @DoNotInline
        static int getPaddingEnd(View r10) {
            return r10.getPaddingEnd();
        }

        @DoNotInline
        static int getPaddingStart(View r10) {
            return r10.getPaddingStart();
        }

        @DoNotInline
        static boolean isPaddingRelative(View r10) {
            return r10.isPaddingRelative();
        }

        @DoNotInline
        static void setLabelFor(View r10, int r11) {
            r10.setLabelFor(r11);
        }

        @DoNotInline
        static void setLayerPaint(View r10, Paint r11) {
            r10.setLayerPaint(r11);
        }

        @DoNotInline
        static void setLayoutDirection(View r10, int r11) {
            r10.setLayoutDirection(r11);
        }

        @DoNotInline
        static void setPaddingRelative(View r10, int r11, int r12, int r13, int r14) {
            r10.setPaddingRelative(r11, r12, r13, r14);
        }
    }

    @RequiresApi(18)
    static class Api18Impl {
        private Api18Impl() {
        }

        @DoNotInline
        static Rect getClipBounds(@NonNull View r10) {
            return r10.getClipBounds();
        }

        @DoNotInline
        static boolean isInLayout(@NonNull View r10) {
            return r10.isInLayout();
        }

        @DoNotInline
        static void setClipBounds(@NonNull View r10, Rect r11) {
            r10.setClipBounds(r11);
        }
    }

    @RequiresApi(19)
    static class Api19Impl {
        private Api19Impl() {
        }

        @DoNotInline
        static int getAccessibilityLiveRegion(View r10) {
            return r10.getAccessibilityLiveRegion();
        }

        @DoNotInline
        static boolean isAttachedToWindow(@NonNull View r10) {
            return r10.isAttachedToWindow();
        }

        @DoNotInline
        static boolean isLaidOut(@NonNull View r10) {
            return r10.isLaidOut();
        }

        @DoNotInline
        static boolean isLayoutDirectionResolved(@NonNull View r10) {
            return r10.isLayoutDirectionResolved();
        }

        @DoNotInline
        static void notifySubtreeAccessibilityStateChanged(ViewParent r10, View r11, View r12, int r13) {
            r10.notifySubtreeAccessibilityStateChanged(r11, r12, r13);
        }

        @DoNotInline
        static void setAccessibilityLiveRegion(View r10, int r11) {
            r10.setAccessibilityLiveRegion(r11);
        }

        @DoNotInline
        static void setContentChangeTypes(AccessibilityEvent r10, int r11) {
            r10.setContentChangeTypes(r11);
        }
    }

    @RequiresApi(20)
    static class Api20Impl {
        private Api20Impl() {
        }

        @DoNotInline
        static WindowInsets dispatchApplyWindowInsets(View r10, WindowInsets r11) {
            return r10.dispatchApplyWindowInsets(r11);
        }

        @DoNotInline
        static WindowInsets onApplyWindowInsets(View r10, WindowInsets r11) {
            return r10.onApplyWindowInsets(r11);
        }

        @DoNotInline
        static void requestApplyInsets(View r10) {
            r10.requestApplyInsets();
        }
    }

    @RequiresApi(21)
    private static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static void callCompatInsetAnimationCallback(@NonNull WindowInsets r10, @NonNull View r11) {
            View.OnApplyWindowInsetsListener r12 = (View.OnApplyWindowInsetsListener) r11.getTag(R.id.tag_window_insets_animation_callback);
            if (r12 == null) goto L6;
            r12.onApplyWindowInsets(r11, r10);
            return;
        }

        @DoNotInline
        static WindowInsetsCompat computeSystemWindowInsets(@NonNull View r10, @NonNull WindowInsetsCompat r11, @NonNull Rect r12) {
            WindowInsets r13 = r11.toWindowInsets();
            if (r13 != null) goto L5;
            r12.setEmpty();
            return r11;
        L5:
            return WindowInsetsCompat.toWindowInsetsCompat(r10.computeSystemWindowInsets(r13, r12), r10);
        }

        @DoNotInline
        static boolean dispatchNestedFling(@NonNull View r10, float r11, float r12, boolean r13) {
            return r10.dispatchNestedFling(r11, r12, r13);
        }

        @DoNotInline
        static boolean dispatchNestedPreFling(@NonNull View r10, float r11, float r12) {
            return r10.dispatchNestedPreFling(r11, r12);
        }

        @DoNotInline
        static boolean dispatchNestedPreScroll(View r10, int r11, int r12, int[] r13, int[] r14) {
            return r10.dispatchNestedPreScroll(r11, r12, r13, r14);
        }

        @DoNotInline
        static boolean dispatchNestedScroll(View r10, int r11, int r12, int r13, int r14, int[] r15) {
            return r10.dispatchNestedScroll(r11, r12, r13, r14, r15);
        }

        @DoNotInline
        static ColorStateList getBackgroundTintList(View r10) {
            return r10.getBackgroundTintList();
        }

        @DoNotInline
        static PorterDuff.Mode getBackgroundTintMode(View r10) {
            return r10.getBackgroundTintMode();
        }

        @DoNotInline
        static float getElevation(View r10) {
            return r10.getElevation();
        }

        @Nullable
        @DoNotInline
        public static WindowInsetsCompat getRootWindowInsets(@NonNull View r10) {
            return WindowInsetsCompat.Api21ReflectionHolder.getRootWindowInsets(r10);
        }

        @DoNotInline
        static String getTransitionName(View r10) {
            return r10.getTransitionName();
        }

        @DoNotInline
        static float getTranslationZ(View r10) {
            return r10.getTranslationZ();
        }

        @DoNotInline
        static float getZ(@NonNull View r10) {
            return r10.getZ();
        }

        @DoNotInline
        static boolean hasNestedScrollingParent(View r10) {
            return r10.hasNestedScrollingParent();
        }

        @DoNotInline
        static boolean isImportantForAccessibility(View r10) {
            return r10.isImportantForAccessibility();
        }

        @DoNotInline
        static boolean isNestedScrollingEnabled(View r10) {
            return r10.isNestedScrollingEnabled();
        }

        @DoNotInline
        static void setBackgroundTintList(View r10, ColorStateList r11) {
            r10.setBackgroundTintList(r11);
        }

        @DoNotInline
        static void setBackgroundTintMode(View r10, PorterDuff.Mode r11) {
            r10.setBackgroundTintMode(r11);
        }

        @DoNotInline
        static void setElevation(View r10, float r11) {
            r10.setElevation(r11);
        }

        @DoNotInline
        static void setNestedScrollingEnabled(View r10, boolean r11) {
            r10.setNestedScrollingEnabled(r11);
        }

        @DoNotInline
        static void setOnApplyWindowInsetsListener(@NonNull final View r10, @Nullable final OnApplyWindowInsetsListener r11) {
            if (Build.VERSION.SDK_INT >= 30) goto L5;
            r10.setTag(R.id.tag_on_apply_window_listener, r11);
        L5:
            if (r11 != null) goto L8;
            r10.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) r10.getTag(R.id.tag_window_insets_animation_callback));
            return;
        L8:
            r10.setOnApplyWindowInsetsListener(new AnonymousClass1(r10, r11));
        }

        @DoNotInline
        static void setTransitionName(View r10, String r11) {
            r10.setTransitionName(r11);
        }

        @DoNotInline
        static void setTranslationZ(View r10, float r11) {
            r10.setTranslationZ(r11);
        }

        @DoNotInline
        static void setZ(@NonNull View r10, float r11) {
            r10.setZ(r11);
        }

        @DoNotInline
        static boolean startNestedScroll(View r10, int r11) {
            return r10.startNestedScroll(r11);
        }

        @DoNotInline
        static void stopNestedScroll(View r10) {
            r10.stopNestedScroll();
        }
    }

    @RequiresApi(23)
    private static class Api23Impl {
        private Api23Impl() {
        }

        @Nullable
        public static WindowInsetsCompat getRootWindowInsets(@NonNull View r10) {
            WindowInsets r11 = r10.getRootWindowInsets();
            if (r11 != null) goto L6;
            return null;
        L6:
            WindowInsetsCompat r12 = WindowInsetsCompat.toWindowInsetsCompat(r11);
            r12.setRootWindowInsets(r12);
            r12.copyRootViewBounds(r10.getRootView());
            return r12;
        }

        @DoNotInline
        static int getScrollIndicators(@NonNull View r10) {
            return r10.getScrollIndicators();
        }

        @DoNotInline
        static void setScrollIndicators(@NonNull View r10, int r11) {
            r10.setScrollIndicators(r11);
        }

        @DoNotInline
        static void setScrollIndicators(@NonNull View r10, int r11, int r12) {
            r10.setScrollIndicators(r11, r12);
        }
    }

    @RequiresApi(24)
    static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        static void cancelDragAndDrop(@NonNull View r10) {
            r10.cancelDragAndDrop();
        }

        @DoNotInline
        static void dispatchFinishTemporaryDetach(View r10) {
            r10.dispatchFinishTemporaryDetach();
        }

        @DoNotInline
        static void dispatchStartTemporaryDetach(View r10) {
            r10.dispatchStartTemporaryDetach();
        }

        @DoNotInline
        static void setPointerIcon(@NonNull View r10, PointerIcon r11) {
            r10.setPointerIcon(r11);
        }

        @DoNotInline
        static boolean startDragAndDrop(@NonNull View r10, @Nullable ClipData r11, @NonNull View.DragShadowBuilder r12, @Nullable Object r13, int r14) {
            return r10.startDragAndDrop(r11, r12, r13, r14);
        }

        @DoNotInline
        static void updateDragShadow(@NonNull View r10, @NonNull View.DragShadowBuilder r11) {
            r10.updateDragShadow(r11);
        }
    }

    @RequiresApi(26)
    static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        static void addKeyboardNavigationClusters(@NonNull View r10, Collection<View> r11, int r12) {
            r10.addKeyboardNavigationClusters(r11, r12);
        }

        @DoNotInline
        static int getImportantForAutofill(View r10) {
            return r10.getImportantForAutofill();
        }

        @DoNotInline
        static int getNextClusterForwardId(@NonNull View r10) {
            return r10.getNextClusterForwardId();
        }

        @DoNotInline
        static boolean hasExplicitFocusable(@NonNull View r10) {
            return r10.hasExplicitFocusable();
        }

        @DoNotInline
        static boolean isFocusedByDefault(@NonNull View r10) {
            return r10.isFocusedByDefault();
        }

        @DoNotInline
        static boolean isImportantForAutofill(View r10) {
            return r10.isImportantForAutofill();
        }

        @DoNotInline
        static boolean isKeyboardNavigationCluster(@NonNull View r10) {
            return r10.isKeyboardNavigationCluster();
        }

        @DoNotInline
        static View keyboardNavigationClusterSearch(@NonNull View r10, View r11, int r12) {
            return r10.keyboardNavigationClusterSearch(r11, r12);
        }

        @DoNotInline
        static boolean restoreDefaultFocus(@NonNull View r10) {
            return r10.restoreDefaultFocus();
        }

        @DoNotInline
        static void setAutofillHints(@NonNull View r10, String... r11) {
            r10.setAutofillHints(r11);
        }

        @DoNotInline
        static void setFocusedByDefault(@NonNull View r10, boolean r11) {
            r10.setFocusedByDefault(r11);
        }

        @DoNotInline
        static void setImportantForAutofill(View r10, int r11) {
            r10.setImportantForAutofill(r11);
        }

        @DoNotInline
        static void setKeyboardNavigationCluster(@NonNull View r10, boolean r11) {
            r10.setKeyboardNavigationCluster(r11);
        }

        @DoNotInline
        static void setNextClusterForwardId(View r10, int r11) {
            r10.setNextClusterForwardId(r11);
        }

        @DoNotInline
        static void setTooltipText(@NonNull View r10, CharSequence r11) {
            r10.setTooltipText(r11);
        }
    }

    @RequiresApi(28)
    static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        static void addOnUnhandledKeyEventListener(@NonNull View r10, @NonNull final OnUnhandledKeyEventListenerCompat r11) {
            int r12 = R.id.tag_unhandled_key_listeners;
            SimpleArrayMap r13 = (SimpleArrayMap) r10.getTag(r12);
            if (r13 != null) goto L5;
            r13 = new SimpleArrayMap();
            r10.setTag(r12, r13);
        L5:
            Objects.requireNonNull(r11);
            View.OnUnhandledKeyEventListener r14 = new g(r11);
            r13.put(r11, r14);
            r10.addOnUnhandledKeyEventListener(r14);
        }

        @DoNotInline
        static CharSequence getAccessibilityPaneTitle(View r10) {
            return r10.getAccessibilityPaneTitle();
        }

        @DoNotInline
        static boolean isAccessibilityHeading(View r10) {
            return r10.isAccessibilityHeading();
        }

        @DoNotInline
        static boolean isScreenReaderFocusable(View r10) {
            return r10.isScreenReaderFocusable();
        }

        @DoNotInline
        static void removeOnUnhandledKeyEventListener(@NonNull View r10, @NonNull OnUnhandledKeyEventListenerCompat r11) {
            SimpleArrayMap r12 = (SimpleArrayMap) r10.getTag(R.id.tag_unhandled_key_listeners);
            if (r12 != null) goto L5;
            return;
        L5:
            View.OnUnhandledKeyEventListener r13 = (View.OnUnhandledKeyEventListener) r12.get(r11);
            if (r13 == null) goto L9;
            r10.removeOnUnhandledKeyEventListener(r13);
            return;
        }

        @DoNotInline
        static <T> T requireViewById(View r10, int r11) {
            return (T) r10.requireViewById(r11);
        }

        @DoNotInline
        static void setAccessibilityHeading(View r10, boolean r11) {
            r10.setAccessibilityHeading(r11);
        }

        @DoNotInline
        static void setAccessibilityPaneTitle(View r10, CharSequence r11) {
            r10.setAccessibilityPaneTitle(r11);
        }

        @DoNotInline
        static void setScreenReaderFocusable(View r10, boolean r11) {
            r10.setScreenReaderFocusable(r11);
        }
    }

    @RequiresApi(29)
    private static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        static View.AccessibilityDelegate getAccessibilityDelegate(View r10) {
            return r10.getAccessibilityDelegate();
        }

        @DoNotInline
        static List<Rect> getSystemGestureExclusionRects(View r10) {
            return r10.getSystemGestureExclusionRects();
        }

        @DoNotInline
        static void saveAttributeDataForStyleable(@NonNull View r10, @NonNull Context r11, @NonNull int[] r12, @Nullable AttributeSet r13, @NonNull TypedArray r14, int r15, int r16) {
            r10.saveAttributeDataForStyleable(r11, r12, r13, r14, r15, r16);
        }

        @DoNotInline
        static void setSystemGestureExclusionRects(View r10, List<Rect> r11) {
            r10.setSystemGestureExclusionRects(r11);
        }
    }

    @RequiresApi(30)
    private static class Api30Impl {
        private Api30Impl() {
        }

        @DoNotInline
        static CharSequence getStateDescription(View r10) {
            return r10.getStateDescription();
        }

        @Nullable
        public static WindowInsetsControllerCompat getWindowInsetsController(@NonNull View r10) {
            WindowInsetsController r11 = r10.getWindowInsetsController();
            if (r11 != null) goto L7;
            return null;
        L7:
            return WindowInsetsControllerCompat.toWindowInsetsControllerCompat(r11);
        }

        @DoNotInline
        static void setStateDescription(View r10, CharSequence r11) {
            r10.setStateDescription(r11);
        }
    }

    @RequiresApi(31)
    private static final class Api31Impl {
        private Api31Impl() {
        }

        @Nullable
        @DoNotInline
        public static String[] getReceiveContentMimeTypes(@NonNull View r10) {
            return r10.getReceiveContentMimeTypes();
        }

        @Nullable
        @DoNotInline
        public static ContentInfoCompat performReceiveContent(@NonNull View r10, @NonNull ContentInfoCompat r11) {
            ContentInfo r12 = r11.toContentInfo();
            ContentInfo r13 = r10.performReceiveContent(r12);
            if (r13 != null) goto L6;
            return null;
        L6:
            if (r13 != r12) goto L9;
            return r11;
        L9:
            return ContentInfoCompat.toContentInfoCompat(r13);
        }

        @DoNotInline
        public static void setOnReceiveContentListener(@NonNull View r10, @Nullable String[] r11, @Nullable OnReceiveContentListener r12) {
            if (r12 != null) goto L4;
            r10.setOnReceiveContentListener(r11, null);
            return;
        L4:
            r10.setOnReceiveContentListener(r11, new OnReceiveContentListenerAdapter(r12));
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface FocusDirection {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface FocusRealDirection {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface FocusRelativeDirection {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface NestedScrollType {
    }

    @RequiresApi(31)
    private static final class OnReceiveContentListenerAdapter implements android.view.OnReceiveContentListener {

        @NonNull
        private final OnReceiveContentListener mJetpackListener;

        OnReceiveContentListenerAdapter(@NonNull OnReceiveContentListener r10) {
            this.mJetpackListener = r10;
        }

        @Override // android.view.OnReceiveContentListener
        @Nullable
        public ContentInfo onReceiveContent(@NonNull View r10, @NonNull ContentInfo r11) {
            ContentInfoCompat r12 = ContentInfoCompat.toContentInfoCompat(r11);
            ContentInfoCompat r13 = this.mJetpackListener.onReceiveContent(r10, r12);
            if (r13 != null) goto L6;
            return null;
        L6:
            if (r13 != r12) goto L9;
            return r11;
        L9:
            return r13.toContentInfo();
        }
    }

    public interface OnUnhandledKeyEventListenerCompat {
        boolean onUnhandledKeyEvent(@NonNull View r10, @NonNull KeyEvent r11);
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface ScrollAxis {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface ScrollIndicators {
    }

    static class UnhandledKeyEventManager {
        private static final ArrayList<WeakReference<View>> sViewsWithListeners = null;
        private SparseArray<WeakReference<View>> mCapturedKeys;
        private WeakReference<KeyEvent> mLastDispatchedPreViewKeyEvent;

        @Nullable
        private WeakHashMap<View, Boolean> mViewsContainingListeners;

        static {
            sViewsWithListeners = new ArrayList();
        }

        UnhandledKeyEventManager() {
            this.mViewsContainingListeners = null;
            this.mCapturedKeys = null;
            this.mLastDispatchedPreViewKeyEvent = null;
        }

        static UnhandledKeyEventManager at(View r10) {
            int r11 = R.id.tag_unhandled_key_event_manager;
            UnhandledKeyEventManager r12 = (UnhandledKeyEventManager) r10.getTag(r11);
            if (r12 != null) goto L6;
            UnhandledKeyEventManager r13 = new UnhandledKeyEventManager();
            r10.setTag(r11, r13);
            return r13;
        L6:
            return r12;
        }

        @Nullable
        private View dispatchInOrder(View r10, KeyEvent r11) {
            WeakHashMap<View, Boolean> r12 = this.mViewsContainingListeners;
            if (r12 != null) goto L5;
        L18:
            return null;
        L5:
            if (r12.containsKey(r10) == false) goto L18;
            if ((r10 instanceof ViewGroup) == false) goto L16;
            ViewGroup r13 = (ViewGroup) r10;
            int r14 = r13.getChildCount() - 1;
        L10:
            if (r14 < 0) goto L16;
            View r15 = dispatchInOrder(r13.getChildAt(r14), r11);
            if (r15 != null) goto L13;
            r14 = r14 - 1;
            goto L10
        L13:
            return r15;
        L16:
            if (onUnhandledKeyEvent(r10, r11) == false) goto L18;
            return r10;
        }

        private SparseArray<WeakReference<View>> getCapturedKeys() {
            if (this.mCapturedKeys != null) goto L6;
            this.mCapturedKeys = new SparseArray();
        L6:
            return this.mCapturedKeys;
        }

        private boolean onUnhandledKeyEvent(@NonNull View r10, @NonNull KeyEvent r11) {
            ArrayList r12 = (ArrayList) r10.getTag(R.id.tag_unhandled_key_listeners);
            if (r12 == null) goto L10;
            int r13 = r12.size() - 1;
        L5:
            if (r13 < 0) goto L14;
            if (((OnUnhandledKeyEventListenerCompat) r12.get(r13)).onUnhandledKeyEvent(r10, r11) == true) goto L8;
            r13 = r13 - 1;
            goto L5
        L8:
            return true;
        L14:
            return false;
        L10:
            return false;
        }

        private void recalcViewsWithUnhandled() {
            WeakHashMap<View, Boolean> r10 = this.mViewsContainingListeners;
            if (r10 == null) goto L5;
            r10.clear();
        L5:
            ArrayList<WeakReference<View>> r11 = sViewsWithListeners;
            if (r11.isEmpty() == false) goto L8;
            return;
        L8:
            monitor-enter(r11);
        L24:
            th = move-exception;
            throw th;
        L10:
            if (this.mViewsContainingListeners != null) goto L12;
            this.mViewsContainingListeners = new WeakHashMap();     // Catch: Throwable -> L24
        L12:
            int r12 = r11.size() - 1;     // Catch: Throwable -> L24
        L13:
            if (r12 < 0) goto L22;
            ArrayList<WeakReference<View>> r13 = sViewsWithListeners;     // Catch: Throwable -> L24
            View r14 = r13.get(r12).get();     // Catch: Throwable -> L24
            if (r14 != null) goto L17;
            r13.remove(r12);     // Catch: Throwable -> L24
        L21:
            r12 = r12 - 1;     // Catch: Throwable -> L24
            goto L13
        L17:
            this.mViewsContainingListeners.put(r14, Boolean.TRUE);     // Catch: Throwable -> L24
            ViewParent r15 = r14.getParent();     // Catch: Throwable -> L24
        L19:
            if ((r15 instanceof View) == false) goto L21;
            this.mViewsContainingListeners.put((View) r15, Boolean.TRUE);     // Catch: Throwable -> L24
            r15 = r15.getParent();     // Catch: Throwable -> L24
            goto L19
        L22:
            monitor-exit(r11);     // Catch: Throwable -> L24
        }

        static void registerListeningView(View r10) {
            ArrayList<WeakReference<View>> r11 = sViewsWithListeners;
            monitor-enter(r11);
            Iterator<WeakReference<View>> r12 = r11.iterator();     // Catch: Throwable -> L14
        L6:
            if (r12.hasNext() == false) goto L11;
            if (r12.next().get() != r10) goto L6;
            monitor-exit(r11);     // Catch: Throwable -> L14
            return;
        L11:
            sViewsWithListeners.add(new WeakReference(r10));     // Catch: Throwable -> L14
            monitor-exit(r11);     // Catch: Throwable -> L14
            return;
        L14:
            th = move-exception;
            throw th;
        }

        static void unregisterListeningView(View r10) {
            ArrayList<WeakReference<View>> r11 = sViewsWithListeners;
            monitor-enter(r11);
            int r12 = 0;
        L18:
            ArrayList<WeakReference<View>> r13 = sViewsWithListeners;     // Catch: Throwable -> L15
            if (r12 >= r13.size()) goto L13;
            if (r13.get(r12).get() == r10) goto L9;
            r12 = r12 + 1;     // Catch: Throwable -> L15
            goto L18
        L9:
            r13.remove(r12);     // Catch: Throwable -> L15
            monitor-exit(r11);     // Catch: Throwable -> L15
            return;
        L13:
            monitor-exit(r11);     // Catch: Throwable -> L15
            return;
        L15:
            th = move-exception;
            throw th;
        }

        boolean dispatch(View r10, KeyEvent r11) {
            if (r11.getAction() != 0) goto L5;
            recalcViewsWithUnhandled();
        L5:
            View r12 = dispatchInOrder(r10, r11);
            if (r11.getAction() != 0) goto L12;
            int r13 = r11.getKeyCode();
            if (r12 == null) goto L12;
            if (KeyEvent.isModifierKey(r13) == true) goto L12;
            getCapturedKeys().put(r13, new WeakReference(r12));
        L12:
            if (r12 == null) goto L14;
            return true;
        L14:
            return false;
        }

        boolean preDispatch(KeyEvent r10) {
            WeakReference<KeyEvent> r11 = this.mLastDispatchedPreViewKeyEvent;
            if (r11 != null) goto L5;
        L7:
            this.mLastDispatchedPreViewKeyEvent = new WeakReference(r10);
            WeakReference<View> r12 = null;
            SparseArray<WeakReference<View>> r13 = getCapturedKeys();
            if (r10.getAction() != 1) goto L12;
            int r14 = r13.indexOfKey(r10.getKeyCode());
            if (r14 < 0) goto L12;
            r12 = r13.valueAt(r14);
            r13.removeAt(r14);
        L12:
            if (r12 != null) goto L14;
            r12 = r13.get(r10.getKeyCode());
        L14:
            if (r12 == null) goto L21;
            View r15 = r12.get();
            if (r15 != null) goto L18;
        L20:
            return true;
        L18:
            if (ViewCompat.isAttachedToWindow(r15) == false) goto L20;
            onUnhandledKeyEvent(r15, r10);
            goto L20
        L21:
            return false;
        L5:
            if (r11.get() != r10) goto L7;
            return false;
        }
    }

    static {
        sNextGeneratedId = new AtomicInteger(1);
        sViewPropertyAnimatorMap = null;
        sAccessibilityDelegateCheckFailed = false;
        ACCESSIBILITY_ACTIONS_RESOURCE_IDS = new int[]{R.id.accessibility_custom_action_0, R.id.accessibility_custom_action_1, R.id.accessibility_custom_action_2, R.id.accessibility_custom_action_3, R.id.accessibility_custom_action_4, R.id.accessibility_custom_action_5, R.id.accessibility_custom_action_6, R.id.accessibility_custom_action_7, R.id.accessibility_custom_action_8, R.id.accessibility_custom_action_9, R.id.accessibility_custom_action_10, R.id.accessibility_custom_action_11, R.id.accessibility_custom_action_12, R.id.accessibility_custom_action_13, R.id.accessibility_custom_action_14, R.id.accessibility_custom_action_15, R.id.accessibility_custom_action_16, R.id.accessibility_custom_action_17, R.id.accessibility_custom_action_18, R.id.accessibility_custom_action_19, R.id.accessibility_custom_action_20, R.id.accessibility_custom_action_21, R.id.accessibility_custom_action_22, R.id.accessibility_custom_action_23, R.id.accessibility_custom_action_24, R.id.accessibility_custom_action_25, R.id.accessibility_custom_action_26, R.id.accessibility_custom_action_27, R.id.accessibility_custom_action_28, R.id.accessibility_custom_action_29, R.id.accessibility_custom_action_30, R.id.accessibility_custom_action_31};
        NO_OP_ON_RECEIVE_CONTENT_VIEW_BEHAVIOR = f.f354c;
        sAccessibilityPaneVisibilityManager = new AccessibilityPaneVisibilityManager();
    }

    @Deprecated
    protected ViewCompat() {
    }

    public static /* synthetic */ ContentInfoCompat a(ContentInfoCompat r10) {
        return lambda$static$0(r10);
    }

    private static AccessibilityViewProperty<Boolean> accessibilityHeadingProperty() {
        final int r10 = R.id.tag_accessibility_heading;
        final Class<Boolean> r11 = Boolean.class;
        final int r12 = 28;
        return new AnonymousClass4(r10, r11, r12);
    }

    public static int addAccessibilityAction(@NonNull View r10, @NonNull CharSequence r11, @NonNull AccessibilityViewCommand r12) {
        int r13 = getAvailableActionIdFromResources(r10, r11);
        if (r13 == (-1)) goto L5;
        addAccessibilityAction(r10, new AccessibilityNodeInfoCompat.AccessibilityActionCompat(r13, r11, r12));
    L5:
        return r13;
    }

    private static void addAccessibilityAction(@NonNull View r10, @NonNull AccessibilityNodeInfoCompat.AccessibilityActionCompat r11) {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        ensureAccessibilityDelegateCompat(r10);
        removeActionWithId(r11.getId(), r10);
        getActionList(r10).add(r11);
        notifyViewAccessibilityStateChangedIfNeeded(r10, 0);
        return;
    }

    public static void addKeyboardNavigationClusters(@NonNull View r10, @NonNull Collection<View> r11, int r12) {
        if (Build.VERSION.SDK_INT < 26) goto L6;
        Api26Impl.addKeyboardNavigationClusters(r10, r11, r12);
        return;
    }

    public static void addOnUnhandledKeyEventListener(@NonNull View r10, @NonNull OnUnhandledKeyEventListenerCompat r11) {
        if (Build.VERSION.SDK_INT < 28) goto L6;
        Api28Impl.addOnUnhandledKeyEventListener(r10, r11);
        return;
    L6:
        int r12 = R.id.tag_unhandled_key_listeners;
        ArrayList r13 = (ArrayList) r10.getTag(r12);
        if (r13 != null) goto L9;
        r13 = new ArrayList();
        r10.setTag(r12, r13);
    L9:
        r13.add(r11);
        if (r13.size() != 1) goto L13;
        UnhandledKeyEventManager.registerListeningView(r10);
        return;
    }

    @NonNull
    public static ViewPropertyAnimatorCompat animate(@NonNull View r10) {
        if (sViewPropertyAnimatorMap != null) goto L5;
        sViewPropertyAnimatorMap = new WeakHashMap();
    L5:
        ViewPropertyAnimatorCompat r11 = sViewPropertyAnimatorMap.get(r10);
        if (r11 != null) goto L9;
        ViewPropertyAnimatorCompat r12 = new ViewPropertyAnimatorCompat(r10);
        sViewPropertyAnimatorMap.put(r10, r12);
        return r12;
    L9:
        return r11;
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
    public static boolean canScrollHorizontally(View r10, int r11) {
        return r10.canScrollHorizontally(r11);
    }

    @Deprecated
    public static boolean canScrollVertically(View r10, int r11) {
        return r10.canScrollVertically(r11);
    }

    public static void cancelDragAndDrop(@NonNull View r10) {
        if (Build.VERSION.SDK_INT < 24) goto L6;
        Api24Impl.cancelDragAndDrop(r10);
        return;
    }

    @Deprecated
    public static int combineMeasuredStates(int r10, int r11) {
        return View.combineMeasuredStates(r10, r11);
    }

    private static void compatOffsetLeftAndRight(View r10, int r11) {
        r10.offsetLeftAndRight(r11);
        if (r10.getVisibility() != 0) goto L8;
        tickleInvalidationFlag(r10);
        Object r12 = r10.getParent();
        if ((r12 instanceof View) == false) goto L9;
        tickleInvalidationFlag((View) r12);
        return;
    L9:
        return;
    }

    private static void compatOffsetTopAndBottom(View r10, int r11) {
        r10.offsetTopAndBottom(r11);
        if (r10.getVisibility() != 0) goto L8;
        tickleInvalidationFlag(r10);
        Object r12 = r10.getParent();
        if ((r12 instanceof View) == false) goto L9;
        tickleInvalidationFlag((View) r12);
        return;
    L9:
        return;
    }

    @NonNull
    public static WindowInsetsCompat computeSystemWindowInsets(@NonNull View r10, @NonNull WindowInsetsCompat r11, @NonNull Rect r12) {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return r11;
    L5:
        return Api21Impl.computeSystemWindowInsets(r10, r11, r12);
    }

    @NonNull
    public static WindowInsetsCompat dispatchApplyWindowInsets(@NonNull View r10, @NonNull WindowInsetsCompat r11) {
        if (Build.VERSION.SDK_INT < 21) goto L10;
        WindowInsets r12 = r11.toWindowInsets();
        if (r12 == null) goto L10;
        WindowInsets r13 = Api20Impl.dispatchApplyWindowInsets(r10, r12);
        if (r13.equals(r12) == true) goto L10;
        return WindowInsetsCompat.toWindowInsetsCompat(r13, r10);
    L10:
        return r11;
    }

    public static void dispatchFinishTemporaryDetach(@NonNull View r10) {
        if (Build.VERSION.SDK_INT < 24) goto L6;
        Api24Impl.dispatchFinishTemporaryDetach(r10);
        return;
    L6:
        if (sTempDetachBound == true) goto L8;
        bindTempDetach();
    L8:
        Method r11 = sDispatchFinishTemporaryDetach;
        if (r11 != null) goto L17;
        r10.onFinishTemporaryDetach();
        return;
    L17:
        r11.invoke(r10, new Object[0]);     // Catch: Exception -> L13
        return;
    L13:
        e = move-exception;
        Log.d(TAG, "Error calling dispatchFinishTemporaryDetach", e);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean dispatchNestedFling(@NonNull View r10, float r11, float r12, boolean r13) {
        if (Build.VERSION.SDK_INT < 21) goto L7;
        return Api21Impl.dispatchNestedFling(r10, r11, r12, r13);
    L7:
        if ((r10 instanceof NestedScrollingChild) == true) goto L9;
        return false;
    L9:
        return ((NestedScrollingChild) r10).dispatchNestedFling(r11, r12, r13);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean dispatchNestedPreFling(@NonNull View r10, float r11, float r12) {
        if (Build.VERSION.SDK_INT < 21) goto L7;
        return Api21Impl.dispatchNestedPreFling(r10, r11, r12);
    L7:
        if ((r10 instanceof NestedScrollingChild) == true) goto L9;
        return false;
    L9:
        return ((NestedScrollingChild) r10).dispatchNestedPreFling(r11, r12);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean dispatchNestedPreScroll(@NonNull View r10, int r11, int r12, @Nullable int[] r13, @Nullable int[] r14) {
        if (Build.VERSION.SDK_INT < 21) goto L7;
        return Api21Impl.dispatchNestedPreScroll(r10, r11, r12, r13, r14);
    L7:
        if ((r10 instanceof NestedScrollingChild) == true) goto L9;
        return false;
    L9:
        return ((NestedScrollingChild) r10).dispatchNestedPreScroll(r11, r12, r13, r14);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean dispatchNestedPreScroll(@NonNull View r10, int r11, int r12, @Nullable int[] r13, @Nullable int[] r14, int r15) {
        if ((r10 instanceof NestedScrollingChild2) == true) goto L5;
        if (r15 == 0) goto L8;
        return false;
    L8:
        return dispatchNestedPreScroll(r10, r11, r12, r13, r14);
    L5:
        return ((NestedScrollingChild2) r10).dispatchNestedPreScroll(r11, r12, r13, r14, r15);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void dispatchNestedScroll(@NonNull View r10, int r11, int r12, int r13, int r14, @Nullable int[] r15, int r16, @NonNull int[] r17) {
        if ((r10 instanceof NestedScrollingChild3) == false) goto L5;
        ((NestedScrollingChild3) r10).dispatchNestedScroll(r11, r12, r13, r14, r15, r16, r17);
        return;
    L5:
        dispatchNestedScroll(r10, r11, r12, r13, r14, r15, r16);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean dispatchNestedScroll(@NonNull View r10, int r11, int r12, int r13, int r14, @Nullable int[] r15) {
        if (Build.VERSION.SDK_INT < 21) goto L7;
        return Api21Impl.dispatchNestedScroll(r10, r11, r12, r13, r14, r15);
    L7:
        if ((r10 instanceof NestedScrollingChild) == true) goto L9;
        return false;
    L9:
        return ((NestedScrollingChild) r10).dispatchNestedScroll(r11, r12, r13, r14, r15);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean dispatchNestedScroll(@NonNull View r10, int r11, int r12, int r13, int r14, @Nullable int[] r15, int r16) {
        if ((r10 instanceof NestedScrollingChild2) == true) goto L5;
        if (r16 == 0) goto L8;
        return false;
    L8:
        return dispatchNestedScroll(r10, r11, r12, r13, r14, r15);
    L5:
        return ((NestedScrollingChild2) r10).dispatchNestedScroll(r11, r12, r13, r14, r15, r16);
    }

    public static void dispatchStartTemporaryDetach(@NonNull View r10) {
        if (Build.VERSION.SDK_INT < 24) goto L6;
        Api24Impl.dispatchStartTemporaryDetach(r10);
        return;
    L6:
        if (sTempDetachBound == true) goto L8;
        bindTempDetach();
    L8:
        Method r11 = sDispatchStartTemporaryDetach;
        if (r11 != null) goto L17;
        r10.onStartTemporaryDetach();
        return;
    L17:
        r11.invoke(r10, new Object[0]);     // Catch: Exception -> L13
        return;
    L13:
        e = move-exception;
        Log.d(TAG, "Error calling dispatchStartTemporaryDetach", e);
    }

    @UiThread
    static boolean dispatchUnhandledKeyEventBeforeCallback(View r10, KeyEvent r11) {
        if (Build.VERSION.SDK_INT < 28) goto L7;
        return false;
    L7:
        return UnhandledKeyEventManager.at(r10).dispatch(r10, r11);
    }

    @UiThread
    static boolean dispatchUnhandledKeyEventBeforeHierarchy(View r10, KeyEvent r11) {
        if (Build.VERSION.SDK_INT < 28) goto L7;
        return false;
    L7:
        return UnhandledKeyEventManager.at(r10).preDispatch(r11);
    }

    public static void enableAccessibleClickableSpanSupport(@NonNull View r10) {
        if (Build.VERSION.SDK_INT < 19) goto L6;
        ensureAccessibilityDelegateCompat(r10);
        return;
    }

    static void ensureAccessibilityDelegateCompat(@NonNull View r10) {
        AccessibilityDelegateCompat r11 = getAccessibilityDelegate(r10);
        if (r11 != null) goto L5;
        r11 = new AccessibilityDelegateCompat();
    L5:
        setAccessibilityDelegate(r10, r11);
    }

    public static int generateViewId() {
        if (Build.VERSION.SDK_INT >= 17) goto L5;
    L6:
        AtomicInteger r10 = sNextGeneratedId;
        int r11 = r10.get();
        int r12 = r11 + 1;
        if (r12 <= 16777215) goto L10;
        r12 = 1;
    L10:
        if (r10.compareAndSet(r11, r12) == false) goto L6;
        return r11;
    L5:
        return Api17Impl.generateViewId();
    }

    @Nullable
    public static AccessibilityDelegateCompat getAccessibilityDelegate(@NonNull View r10) {
        View.AccessibilityDelegate r11 = getAccessibilityDelegateInternal(r10);
        if (r11 != null) goto L7;
        return null;
    L7:
        if ((r11 instanceof AccessibilityDelegateCompat.AccessibilityDelegateAdapter) == false) goto L11;
        return ((AccessibilityDelegateCompat.AccessibilityDelegateAdapter) r11).mCompat;
    L11:
        return new AccessibilityDelegateCompat(r11);
    }

    @Nullable
    private static View.AccessibilityDelegate getAccessibilityDelegateInternal(@NonNull View r10) {
        if (Build.VERSION.SDK_INT < 29) goto L7;
        return Api29Impl.getAccessibilityDelegate(r10);
    L7:
        return getAccessibilityDelegateThroughReflection(r10);
    }

    @Nullable
    private static View.AccessibilityDelegate getAccessibilityDelegateThroughReflection(@NonNull View r10) {
        if (sAccessibilityDelegateCheckFailed == false) goto L6;
        return null;
    L6:
        if (sAccessibilityDelegateField != null) goto L20;
        Field r11 = View.class.getDeclaredField("mAccessibilityDelegate");     // Catch: Throwable -> L9
        sAccessibilityDelegateField = r11;     // Catch: Throwable -> L9
        r11.setAccessible(true);     // Catch: Throwable -> L9
    L9:
        sAccessibilityDelegateCheckFailed = true;
        return null;
    L20:
        Object r12 = sAccessibilityDelegateField.get(r10);     // Catch: Throwable -> L16
        if ((r12 instanceof View.AccessibilityDelegate) == false) goto L15;
        return (View.AccessibilityDelegate) r12;
    L15:
        return null;
    L16:
        sAccessibilityDelegateCheckFailed = true;
        return null;
    }

    public static int getAccessibilityLiveRegion(@NonNull View r10) {
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        return 0;
    L5:
        return Api19Impl.getAccessibilityLiveRegion(r10);
    }

    @Nullable
    public static AccessibilityNodeProviderCompat getAccessibilityNodeProvider(@NonNull View r10) {
        if (Build.VERSION.SDK_INT < 16) goto L8;
        AccessibilityNodeProvider r11 = Api16Impl.getAccessibilityNodeProvider(r10);
        if (r11 != null) goto L7;
        return null;
    L7:
        return new AccessibilityNodeProviderCompat(r11);
    L8:
        return null;
    }

    @Nullable
    @UiThread
    public static CharSequence getAccessibilityPaneTitle(@NonNull View r10) {
        return paneTitleProperty().get(r10);
    }

    private static List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> getActionList(View r10) {
        int r11 = R.id.tag_accessibility_actions;
        ArrayList r12 = (ArrayList) r10.getTag(r11);
        if (r12 != null) goto L6;
        ArrayList r13 = new ArrayList();
        r10.setTag(r11, r13);
        return r13;
    L6:
        return r12;
    }

    @Deprecated
    public static float getAlpha(View r10) {
        return r10.getAlpha();
    }

    private static int getAvailableActionIdFromResources(View r10, @NonNull CharSequence r11) {
        List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> r12 = getActionList(r10);
        int r13 = 0;
    L4:
        if (r13 >= r12.size()) goto L10;
        if (TextUtils.equals(r11, r12.get(r13).getLabel()) == true) goto L8;
        r13 = r13 + 1;
        goto L4
    L8:
        return r12.get(r13).getId();
    L10:
        int r14 = -1;
        int r15 = 0;
    L11:
        int[] r16 = ACCESSIBILITY_ACTIONS_RESOURCE_IDS;
        if (r15 >= r16.length) goto L25;
        if (r14 != (-1)) goto L25;
        int r17 = r16[r15];
        int r18 = 0;
        boolean r19 = true;
    L16:
        if (r18 >= r12.size()) goto L22;
        if (r12.get(r18).getId() == r17) goto L20;
        boolean r20 = true;
    L21:
        r19 = r19 & r20;
        r18 = r18 + 1;
        goto L16
    L20:
        r20 = false;
        goto L21
    L22:
        if (r19 == false) goto L24;
        r14 = r17;
    L24:
        r15 = r15 + 1;
    L25:
        return r14;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public static ColorStateList getBackgroundTintList(@NonNull View r10) {
        if (Build.VERSION.SDK_INT < 21) goto L7;
        return Api21Impl.getBackgroundTintList(r10);
    L7:
        if ((r10 instanceof TintableBackgroundView) == true) goto L11;
        return null;
    L11:
        return ((TintableBackgroundView) r10).getSupportBackgroundTintList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public static PorterDuff.Mode getBackgroundTintMode(@NonNull View r10) {
        if (Build.VERSION.SDK_INT < 21) goto L7;
        return Api21Impl.getBackgroundTintMode(r10);
    L7:
        if ((r10 instanceof TintableBackgroundView) == true) goto L11;
        return null;
    L11:
        return ((TintableBackgroundView) r10).getSupportBackgroundTintMode();
    }

    @Nullable
    public static Rect getClipBounds(@NonNull View r10) {
        if (Build.VERSION.SDK_INT >= 18) goto L5;
        return null;
    L5:
        return Api18Impl.getClipBounds(r10);
    }

    @Nullable
    public static Display getDisplay(@NonNull View r10) {
        if (Build.VERSION.SDK_INT < 17) goto L7;
        return Api17Impl.getDisplay(r10);
    L7:
        if (isAttachedToWindow(r10) == true) goto L9;
        return null;
    L9:
        return ((WindowManager) r10.getContext().getSystemService("window")).getDefaultDisplay();
    }

    public static float getElevation(@NonNull View r10) {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return 0.0f;
    L5:
        return Api21Impl.getElevation(r10);
    }

    private static Rect getEmptyTempRect() {
        if (sThreadLocalRect != null) goto L5;
        sThreadLocalRect = new ThreadLocal();
    L5:
        Rect r10 = sThreadLocalRect.get();
        if (r10 != null) goto L8;
        r10 = new Rect();
        sThreadLocalRect.set(r10);
    L8:
        r10.setEmpty();
        return r10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static OnReceiveContentViewBehavior getFallback(@NonNull View r10) {
        if ((r10 instanceof OnReceiveContentViewBehavior) == false) goto L7;
        return (OnReceiveContentViewBehavior) r10;
    L7:
        return NO_OP_ON_RECEIVE_CONTENT_VIEW_BEHAVIOR;
    }

    public static boolean getFitsSystemWindows(@NonNull View r10) {
        if (Build.VERSION.SDK_INT >= 16) goto L5;
        return false;
    L5:
        return Api16Impl.getFitsSystemWindows(r10);
    }

    public static int getImportantForAccessibility(@NonNull View r10) {
        if (Build.VERSION.SDK_INT >= 16) goto L5;
        return 0;
    L5:
        return Api16Impl.getImportantForAccessibility(r10);
    }

    @SuppressLint({"InlinedApi"})
    public static int getImportantForAutofill(@NonNull View r10) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return 0;
    L5:
        return Api26Impl.getImportantForAutofill(r10);
    }

    public static int getLabelFor(@NonNull View r10) {
        if (Build.VERSION.SDK_INT >= 17) goto L5;
        return 0;
    L5:
        return Api17Impl.getLabelFor(r10);
    }

    @Deprecated
    public static int getLayerType(View r10) {
        return r10.getLayerType();
    }

    public static int getLayoutDirection(@NonNull View r10) {
        if (Build.VERSION.SDK_INT >= 17) goto L5;
        return 0;
    L5:
        return Api17Impl.getLayoutDirection(r10);
    }

    @Nullable
    @Deprecated
    public static Matrix getMatrix(View r10) {
        return r10.getMatrix();
    }

    @Deprecated
    public static int getMeasuredHeightAndState(View r10) {
        return r10.getMeasuredHeightAndState();
    }

    @Deprecated
    public static int getMeasuredState(View r10) {
        return r10.getMeasuredState();
    }

    @Deprecated
    public static int getMeasuredWidthAndState(View r10) {
        return r10.getMeasuredWidthAndState();
    }

    public static int getMinimumHeight(@NonNull View r10) {
        if (Build.VERSION.SDK_INT < 16) goto L7;
        return Api16Impl.getMinimumHeight(r10);
    L7:
        if (sMinHeightFieldFetched == false) goto L21;
    L11:
        Field r11 = sMinHeightField;
        if (r11 != null) goto L19;
        return 0;
    L19:
        return ((Integer) r11.get(r10)).intValue();
    L23:
        return 0;
    L21:
        Field r12 = View.class.getDeclaredField("mMinHeight");     // Catch: NoSuchFieldException -> L17
        sMinHeightField = r12;     // Catch: NoSuchFieldException -> L17
        r12.setAccessible(true);     // Catch: NoSuchFieldException -> L17
    L10:
        sMinHeightFieldFetched = true;
        goto L11
    }

    public static int getMinimumWidth(@NonNull View r10) {
        if (Build.VERSION.SDK_INT < 16) goto L7;
        return Api16Impl.getMinimumWidth(r10);
    L7:
        if (sMinWidthFieldFetched == false) goto L21;
    L11:
        Field r11 = sMinWidthField;
        if (r11 != null) goto L19;
        return 0;
    L19:
        return ((Integer) r11.get(r10)).intValue();
    L23:
        return 0;
    L21:
        Field r12 = View.class.getDeclaredField("mMinWidth");     // Catch: NoSuchFieldException -> L17
        sMinWidthField = r12;     // Catch: NoSuchFieldException -> L17
        r12.setAccessible(true);     // Catch: NoSuchFieldException -> L17
    L10:
        sMinWidthFieldFetched = true;
        goto L11
    }

    public static int getNextClusterForwardId(@NonNull View r10) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return -1;
    L5:
        return Api26Impl.getNextClusterForwardId(r10);
    }

    @Nullable
    public static String[] getOnReceiveContentMimeTypes(@NonNull View r10) {
        if (Build.VERSION.SDK_INT < 31) goto L7;
        return Api31Impl.getReceiveContentMimeTypes(r10);
    L7:
        return (String[]) r10.getTag(R.id.tag_on_receive_content_mime_types);
    }

    @Deprecated
    public static int getOverScrollMode(View r10) {
        return r10.getOverScrollMode();
    }

    @Px
    public static int getPaddingEnd(@NonNull View r10) {
        if (Build.VERSION.SDK_INT < 17) goto L7;
        return Api17Impl.getPaddingEnd(r10);
    L7:
        return r10.getPaddingRight();
    }

    @Px
    public static int getPaddingStart(@NonNull View r10) {
        if (Build.VERSION.SDK_INT < 17) goto L7;
        return Api17Impl.getPaddingStart(r10);
    L7:
        return r10.getPaddingLeft();
    }

    @Nullable
    public static ViewParent getParentForAccessibility(@NonNull View r10) {
        if (Build.VERSION.SDK_INT < 16) goto L7;
        return Api16Impl.getParentForAccessibility(r10);
    L7:
        return r10.getParent();
    }

    @Deprecated
    public static float getPivotX(View r10) {
        return r10.getPivotX();
    }

    @Deprecated
    public static float getPivotY(View r10) {
        return r10.getPivotY();
    }

    @Nullable
    public static WindowInsetsCompat getRootWindowInsets(@NonNull View r10) {
        int r11 = Build.VERSION.SDK_INT;
        if (r11 < 23) goto L7;
        return Api23Impl.getRootWindowInsets(r10);
    L7:
        if (r11 >= 21) goto L9;
        return null;
    L9:
        return Api21Impl.getRootWindowInsets(r10);
    }

    @Deprecated
    public static float getRotation(View r10) {
        return r10.getRotation();
    }

    @Deprecated
    public static float getRotationX(View r10) {
        return r10.getRotationX();
    }

    @Deprecated
    public static float getRotationY(View r10) {
        return r10.getRotationY();
    }

    @Deprecated
    public static float getScaleX(View r10) {
        return r10.getScaleX();
    }

    @Deprecated
    public static float getScaleY(View r10) {
        return r10.getScaleY();
    }

    public static int getScrollIndicators(@NonNull View r10) {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        return 0;
    L5:
        return Api23Impl.getScrollIndicators(r10);
    }

    @Nullable
    @UiThread
    public static CharSequence getStateDescription(@NonNull View r10) {
        return stateDescriptionProperty().get(r10);
    }

    @NonNull
    public static List<Rect> getSystemGestureExclusionRects(@NonNull View r10) {
        if (Build.VERSION.SDK_INT < 29) goto L7;
        return Api29Impl.getSystemGestureExclusionRects(r10);
    L7:
        return Collections.emptyList();
    }

    @Nullable
    public static String getTransitionName(@NonNull View r10) {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        WeakHashMap<View, String> r11 = sTransitionNameMap;
        if (r11 != null) goto L11;
        return null;
    L11:
        return r11.get(r10);
    L5:
        return Api21Impl.getTransitionName(r10);
    }

    @Deprecated
    public static float getTranslationX(View r10) {
        return r10.getTranslationX();
    }

    @Deprecated
    public static float getTranslationY(View r10) {
        return r10.getTranslationY();
    }

    public static float getTranslationZ(@NonNull View r10) {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return 0.0f;
    L5:
        return Api21Impl.getTranslationZ(r10);
    }

    @Nullable
    @Deprecated
    public static WindowInsetsControllerCompat getWindowInsetsController(@NonNull View r10) {
        if (Build.VERSION.SDK_INT >= 30) goto L5;
        Context r11 = r10.getContext();
    L8:
        if ((r11 instanceof ContextWrapper) == false) goto L16;
        if ((r11 instanceof Activity) == true) goto L11;
        r11 = ((ContextWrapper) r11).getBaseContext();
        goto L8
    L11:
        Window r12 = ((Activity) r11).getWindow();
        if (r12 != null) goto L14;
        return null;
    L14:
        return WindowCompat.getInsetsController(r12, r10);
    L16:
        return null;
    L5:
        return Api30Impl.getWindowInsetsController(r10);
    }

    @Deprecated
    public static int getWindowSystemUiVisibility(@NonNull View r10) {
        if (Build.VERSION.SDK_INT >= 16) goto L5;
        return 0;
    L5:
        return Api16Impl.getWindowSystemUiVisibility(r10);
    }

    @Deprecated
    public static float getX(View r10) {
        return r10.getX();
    }

    @Deprecated
    public static float getY(View r10) {
        return r10.getY();
    }

    public static float getZ(@NonNull View r10) {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return 0.0f;
    L5:
        return Api21Impl.getZ(r10);
    }

    public static boolean hasAccessibilityDelegate(@NonNull View r10) {
        if (getAccessibilityDelegateInternal(r10) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean hasExplicitFocusable(@NonNull View r10) {
        if (Build.VERSION.SDK_INT < 26) goto L7;
        return Api26Impl.hasExplicitFocusable(r10);
    L7:
        return r10.hasFocusable();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean hasNestedScrollingParent(@NonNull View r10) {
        if (Build.VERSION.SDK_INT < 21) goto L7;
        return Api21Impl.hasNestedScrollingParent(r10);
    L7:
        if ((r10 instanceof NestedScrollingChild) == true) goto L9;
        return false;
    L9:
        return ((NestedScrollingChild) r10).hasNestedScrollingParent();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean hasNestedScrollingParent(@NonNull View r10, int r11) {
        if ((r10 instanceof NestedScrollingChild2) == false) goto L5;
        ((NestedScrollingChild2) r10).hasNestedScrollingParent(r11);
        return false;
    L5:
        if (r11 == 0) goto L7;
        return false;
    L7:
        return hasNestedScrollingParent(r10);
    }

    public static boolean hasOnClickListeners(@NonNull View r10) {
        if (Build.VERSION.SDK_INT >= 15) goto L5;
        return false;
    L5:
        return Api15Impl.hasOnClickListeners(r10);
    }

    public static boolean hasOverlappingRendering(@NonNull View r10) {
        if (Build.VERSION.SDK_INT >= 16) goto L5;
        return true;
    L5:
        return Api16Impl.hasOverlappingRendering(r10);
    }

    public static boolean hasTransientState(@NonNull View r10) {
        if (Build.VERSION.SDK_INT >= 16) goto L5;
        return false;
    L5:
        return Api16Impl.hasTransientState(r10);
    }

    @UiThread
    public static boolean isAccessibilityHeading(@NonNull View r10) {
        Boolean r11 = accessibilityHeadingProperty().get(r10);
        if (r11 != null) goto L5;
    L7:
        return false;
    L5:
        if (r11.booleanValue() == false) goto L7;
        return true;
    }

    public static boolean isAttachedToWindow(@NonNull View r10) {
        if (Build.VERSION.SDK_INT < 19) goto L7;
        return Api19Impl.isAttachedToWindow(r10);
    L7:
        if (r10.getWindowToken() == null) goto L9;
        return true;
    L9:
        return false;
    }

    public static boolean isFocusedByDefault(@NonNull View r10) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return false;
    L5:
        return Api26Impl.isFocusedByDefault(r10);
    }

    public static boolean isImportantForAccessibility(@NonNull View r10) {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return true;
    L5:
        return Api21Impl.isImportantForAccessibility(r10);
    }

    public static boolean isImportantForAutofill(@NonNull View r10) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return true;
    L5:
        return Api26Impl.isImportantForAutofill(r10);
    }

    public static boolean isInLayout(@NonNull View r10) {
        if (Build.VERSION.SDK_INT >= 18) goto L5;
        return false;
    L5:
        return Api18Impl.isInLayout(r10);
    }

    public static boolean isKeyboardNavigationCluster(@NonNull View r10) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return false;
    L5:
        return Api26Impl.isKeyboardNavigationCluster(r10);
    }

    public static boolean isLaidOut(@NonNull View r10) {
        if (Build.VERSION.SDK_INT < 19) goto L7;
        return Api19Impl.isLaidOut(r10);
    L7:
        if (r10.getWidth() > 0) goto L9;
    L11:
        return false;
    L9:
        if (r10.getHeight() <= 0) goto L11;
        return true;
    }

    public static boolean isLayoutDirectionResolved(@NonNull View r10) {
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        return false;
    L5:
        return Api19Impl.isLayoutDirectionResolved(r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean isNestedScrollingEnabled(@NonNull View r10) {
        if (Build.VERSION.SDK_INT < 21) goto L7;
        return Api21Impl.isNestedScrollingEnabled(r10);
    L7:
        if ((r10 instanceof NestedScrollingChild) == true) goto L9;
        return false;
    L9:
        return ((NestedScrollingChild) r10).isNestedScrollingEnabled();
    }

    @Deprecated
    public static boolean isOpaque(View r10) {
        return r10.isOpaque();
    }

    public static boolean isPaddingRelative(@NonNull View r10) {
        if (Build.VERSION.SDK_INT >= 17) goto L5;
        return false;
    L5:
        return Api17Impl.isPaddingRelative(r10);
    }

    @UiThread
    public static boolean isScreenReaderFocusable(@NonNull View r10) {
        Boolean r11 = screenReaderFocusableProperty().get(r10);
        if (r11 != null) goto L5;
    L7:
        return false;
    L5:
        if (r11.booleanValue() == false) goto L7;
        return true;
    }

    @Deprecated
    public static void jumpDrawablesToCurrentState(View r10) {
        r10.jumpDrawablesToCurrentState();
    }

    @Nullable
    public static View keyboardNavigationClusterSearch(@NonNull View r10, @Nullable View r11, int r12) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return null;
    L5:
        return Api26Impl.keyboardNavigationClusterSearch(r10, r11, r12);
    }

    private static /* synthetic */ ContentInfoCompat lambda$static$0(ContentInfoCompat r10) {
        return r10;
    }

    @RequiresApi(19)
    static void notifyViewAccessibilityStateChangedIfNeeded(View r10, int r11) {
        AccessibilityManager r12 = (AccessibilityManager) r10.getContext().getSystemService("accessibility");
        if (r12.isEnabled() == true) goto L6;
        return;
    L6:
        if (getAccessibilityPaneTitle(r10) != null) goto L8;
    L12:
        boolean r13 = false;
    L13:
        int r14 = 32;
        if (getAccessibilityLiveRegion(r10) != 0) goto L26;
        if (r13 == true) goto L26;
        if (r11 != 32) goto L20;
        AccessibilityEvent r15 = AccessibilityEvent.obtain();
        r10.onInitializeAccessibilityEvent(r15);
        r15.setEventType(32);
        Api19Impl.setContentChangeTypes(r15, r11);
        r15.setSource(r10);
        r10.onPopulateAccessibilityEvent(r15);
        r15.getText().add(getAccessibilityPaneTitle(r10));
        r12.sendAccessibilityEvent(r15);
        return;
    L20:
        if (r10.getParent() != null) goto L35;
        return;
    L35:
        Api19Impl.notifySubtreeAccessibilityStateChanged(r10.getParent(), r10, r10, r11);     // Catch: AbstractMethodError -> L24
        return;
    L24:
        e = move-exception;
        Log.e(TAG, r10.getParent().getClass().getSimpleName() + " does not fully implement ViewParent", e);
        return;
    L26:
        AccessibilityEvent r16 = AccessibilityEvent.obtain();
        if (r13 == true) goto L30;
        r14 = 2048;
    L30:
        r16.setEventType(r14);
        Api19Impl.setContentChangeTypes(r16, r11);
        if (r13 == false) goto L33;
        r16.getText().add(getAccessibilityPaneTitle(r10));
        setViewImportanceForAccessibilityIfNeeded(r10);
    L33:
        r10.sendAccessibilityEventUnchecked(r16);
        return;
    L8:
        if (r10.isShown() == false) goto L12;
        if (r10.getWindowVisibility() != 0) goto L12;
        r13 = true;
        goto L13
    }

    public static void offsetLeftAndRight(@NonNull View r10, int r11) {
        int r12 = Build.VERSION.SDK_INT;
        if (r12 < 23) goto L6;
        r10.offsetLeftAndRight(r11);
        return;
    L6:
        if (r12 < 21) goto L15;
        Rect r13 = getEmptyTempRect();
        boolean r14 = false;
        Object r15 = r10.getParent();
        if ((r15 instanceof View) == false) goto L10;
        View r16 = (View) r15;
        r13.set(r16.getLeft(), r16.getTop(), r16.getRight(), r16.getBottom());
        r14 = !r13.intersects(r10.getLeft(), r10.getTop(), r10.getRight(), r10.getBottom());
    L10:
        compatOffsetLeftAndRight(r10, r11);
        if (r14 == true) goto L13;
        return;
    L13:
        if (r13.intersect(r10.getLeft(), r10.getTop(), r10.getRight(), r10.getBottom()) == false) goto L19;
        ((View) r15).invalidate(r13);
        return;
    L19:
        return;
    L15:
        compatOffsetLeftAndRight(r10, r11);
    }

    public static void offsetTopAndBottom(@NonNull View r10, int r11) {
        int r12 = Build.VERSION.SDK_INT;
        if (r12 < 23) goto L6;
        r10.offsetTopAndBottom(r11);
        return;
    L6:
        if (r12 < 21) goto L15;
        Rect r13 = getEmptyTempRect();
        boolean r14 = false;
        Object r15 = r10.getParent();
        if ((r15 instanceof View) == false) goto L10;
        View r16 = (View) r15;
        r13.set(r16.getLeft(), r16.getTop(), r16.getRight(), r16.getBottom());
        r14 = !r13.intersects(r10.getLeft(), r10.getTop(), r10.getRight(), r10.getBottom());
    L10:
        compatOffsetTopAndBottom(r10, r11);
        if (r14 == true) goto L13;
        return;
    L13:
        if (r13.intersect(r10.getLeft(), r10.getTop(), r10.getRight(), r10.getBottom()) == false) goto L19;
        ((View) r15).invalidate(r13);
        return;
    L19:
        return;
    L15:
        compatOffsetTopAndBottom(r10, r11);
    }

    @NonNull
    public static WindowInsetsCompat onApplyWindowInsets(@NonNull View r10, @NonNull WindowInsetsCompat r11) {
        if (Build.VERSION.SDK_INT < 21) goto L10;
        WindowInsets r12 = r11.toWindowInsets();
        if (r12 == null) goto L10;
        WindowInsets r13 = Api20Impl.onApplyWindowInsets(r10, r12);
        if (r13.equals(r12) == true) goto L10;
        return WindowInsetsCompat.toWindowInsetsCompat(r13, r10);
    L10:
        return r11;
    }

    @Deprecated
    public static void onInitializeAccessibilityEvent(View r10, AccessibilityEvent r11) {
        r10.onInitializeAccessibilityEvent(r11);
    }

    public static void onInitializeAccessibilityNodeInfo(@NonNull View r10, @NonNull AccessibilityNodeInfoCompat r11) {
        r10.onInitializeAccessibilityNodeInfo(r11.unwrap());
    }

    @Deprecated
    public static void onPopulateAccessibilityEvent(View r10, AccessibilityEvent r11) {
        r10.onPopulateAccessibilityEvent(r11);
    }

    private static AccessibilityViewProperty<CharSequence> paneTitleProperty() {
        final int r10 = R.id.tag_accessibility_pane_title;
        final Class<CharSequence> r11 = CharSequence.class;
        final int r12 = 8;
        final int r13 = 28;
        return new AnonymousClass2(r10, r11, r12, r13);
    }

    public static boolean performAccessibilityAction(@NonNull View r10, int r11, @Nullable Bundle r12) {
        if (Build.VERSION.SDK_INT >= 16) goto L5;
        return false;
    L5:
        return Api16Impl.performAccessibilityAction(r10, r11, r12);
    }

    @Nullable
    public static ContentInfoCompat performReceiveContent(@NonNull View r10, @NonNull ContentInfoCompat r11) {
        if (Log.isLoggable(TAG, 3) == false) goto L6;
        Log.d(TAG, "performReceiveContent: " + r11 + ", view=" + r10.getClass().getSimpleName() + "[" + r10.getId() + "]");
    L6:
        if (Build.VERSION.SDK_INT >= 31) goto L8;
        OnReceiveContentListener r12 = (OnReceiveContentListener) r10.getTag(R.id.tag_on_receive_content_listener);
        if (r12 == null) goto L17;
        ContentInfoCompat r13 = r12.onReceiveContent(r10, r11);
        if (r13 != null) goto L15;
        return null;
    L15:
        return getFallback(r10).onReceiveContent(r13);
    L17:
        return getFallback(r10).onReceiveContent(r11);
    L8:
        return Api31Impl.performReceiveContent(r10, r11);
    }

    public static void postInvalidateOnAnimation(@NonNull View r10) {
        if (Build.VERSION.SDK_INT < 16) goto L5;
        Api16Impl.postInvalidateOnAnimation(r10);
        return;
    L5:
        r10.postInvalidate();
    }

    public static void postInvalidateOnAnimation(@NonNull View r10, int r11, int r12, int r13, int r14) {
        if (Build.VERSION.SDK_INT < 16) goto L5;
        Api16Impl.postInvalidateOnAnimation(r10, r11, r12, r13, r14);
        return;
    L5:
        r10.postInvalidate(r11, r12, r13, r14);
    }

    public static void postOnAnimation(@NonNull View r10, @NonNull Runnable r11) {
        if (Build.VERSION.SDK_INT < 16) goto L5;
        Api16Impl.postOnAnimation(r10, r11);
        return;
    L5:
        r10.postDelayed(r11, ValueAnimator.getFrameDelay());
    }

    @SuppressLint({"LambdaLast"})
    public static void postOnAnimationDelayed(@NonNull View r10, @NonNull Runnable r11, long r12) {
        if (Build.VERSION.SDK_INT < 16) goto L5;
        Api16Impl.postOnAnimationDelayed(r10, r11, r12);
        return;
    L5:
        r10.postDelayed(r11, ValueAnimator.getFrameDelay() + r12);
    }

    public static void removeAccessibilityAction(@NonNull View r10, int r11) {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        removeActionWithId(r11, r10);
        notifyViewAccessibilityStateChangedIfNeeded(r10, 0);
        return;
    }

    private static void removeActionWithId(int r10, View r11) {
        List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> r12 = getActionList(r11);
        int r13 = 0;
    L4:
        if (r13 >= r12.size()) goto L12;
        if (r12.get(r13).getId() == r10) goto L7;
        r13 = r13 + 1;
        goto L4
    L7:
        r12.remove(r13);
        return;
    }

    public static void removeOnUnhandledKeyEventListener(@NonNull View r10, @NonNull OnUnhandledKeyEventListenerCompat r11) {
        if (Build.VERSION.SDK_INT < 28) goto L6;
        Api28Impl.removeOnUnhandledKeyEventListener(r10, r11);
        return;
    L6:
        ArrayList r12 = (ArrayList) r10.getTag(R.id.tag_unhandled_key_listeners);
        if (r12 == null) goto L12;
        r12.remove(r11);
        if (r12.size() != 0) goto L13;
        UnhandledKeyEventManager.unregisterListeningView(r10);
        return;
    L13:
        return;
    }

    public static void replaceAccessibilityAction(@NonNull View r10, @NonNull AccessibilityNodeInfoCompat.AccessibilityActionCompat r11, @Nullable CharSequence r12, @Nullable AccessibilityViewCommand r13) {
        if (r13 != null) goto L5;
        if (r12 != null) goto L5;
        removeAccessibilityAction(r10, r11.getId());
        return;
    L5:
        addAccessibilityAction(r10, r11.createReplacementAction(r12, r13));
    }

    public static void requestApplyInsets(@NonNull View r10) {
        int r11 = Build.VERSION.SDK_INT;
        if (r11 < 20) goto L6;
        Api20Impl.requestApplyInsets(r10);
        return;
    L6:
        if (r11 < 16) goto L10;
        Api16Impl.requestFitSystemWindows(r10);
        return;
    }

    @NonNull
    public static <T extends View> T requireViewById(@NonNull View r10, @IdRes int r11) {
        if (Build.VERSION.SDK_INT >= 28) goto L5;
        T r12 = (T) r10.findViewById(r11);
        if (r12 == null) goto L10;
        return r12;
    L10:
        throw new IllegalArgumentException("ID does not reference a View inside this View");
    L5:
        return (T) Api28Impl.requireViewById(r10, r11);
    }

    @Deprecated
    public static int resolveSizeAndState(int r10, int r11, int r12) {
        return View.resolveSizeAndState(r10, r11, r12);
    }

    public static boolean restoreDefaultFocus(@NonNull View r10) {
        if (Build.VERSION.SDK_INT < 26) goto L7;
        return Api26Impl.restoreDefaultFocus(r10);
    L7:
        return r10.requestFocus();
    }

    public static void saveAttributeDataForStyleable(@NonNull View r10, @NonNull @SuppressLint({"ContextFirst"}) Context r11, @NonNull int[] r12, @Nullable AttributeSet r13, @NonNull TypedArray r14, int r15, int r16) {
        if (Build.VERSION.SDK_INT < 29) goto L6;
        Api29Impl.saveAttributeDataForStyleable(r10, r11, r12, r13, r14, r15, r16);
        return;
    }

    private static AccessibilityViewProperty<Boolean> screenReaderFocusableProperty() {
        final int r10 = R.id.tag_screen_reader_focusable;
        final Class<Boolean> r11 = Boolean.class;
        final int r12 = 28;
        return new AnonymousClass1(r10, r11, r12);
    }

    public static void setAccessibilityDelegate(@NonNull View r10, @Nullable AccessibilityDelegateCompat r11) {
        if (r11 == null) goto L4;
    L6:
        if (r11 != null) goto L8;
        View.AccessibilityDelegate r12 = null;
    L9:
        r10.setAccessibilityDelegate(r12);
        return;
    L8:
        r12 = r11.getBridge();
        goto L9
    L4:
        if ((getAccessibilityDelegateInternal(r10) instanceof AccessibilityDelegateCompat.AccessibilityDelegateAdapter) == false) goto L6;
        r11 = new AccessibilityDelegateCompat();
        goto L6
    }

    @UiThread
    public static void setAccessibilityHeading(@NonNull View r10, boolean r11) {
        accessibilityHeadingProperty().set(r10, Boolean.valueOf(r11));
    }

    public static void setAccessibilityLiveRegion(@NonNull View r10, int r11) {
        if (Build.VERSION.SDK_INT < 19) goto L6;
        Api19Impl.setAccessibilityLiveRegion(r10, r11);
        return;
    }

    @UiThread
    public static void setAccessibilityPaneTitle(@NonNull View r10, @Nullable CharSequence r11) {
        if (Build.VERSION.SDK_INT < 19) goto L9;
        paneTitleProperty().set(r10, r11);
        if (r11 == null) goto L7;
        sAccessibilityPaneVisibilityManager.addAccessibilityPane(r10);
        return;
    L7:
        sAccessibilityPaneVisibilityManager.removeAccessibilityPane(r10);
        return;
    }

    @Deprecated
    public static void setActivated(View r10, boolean r11) {
        r10.setActivated(r11);
    }

    @Deprecated
    public static void setAlpha(View r10, @FloatRange(from = 0.0d, to = 1.0d) float r11) {
        r10.setAlpha(r11);
    }

    public static void setAutofillHints(@NonNull View r10, @Nullable String... r11) {
        if (Build.VERSION.SDK_INT < 26) goto L6;
        Api26Impl.setAutofillHints(r10, r11);
        return;
    }

    public static void setBackground(@NonNull View r10, @Nullable Drawable r11) {
        if (Build.VERSION.SDK_INT < 16) goto L5;
        Api16Impl.setBackground(r10, r11);
        return;
    L5:
        r10.setBackgroundDrawable(r11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void setBackgroundTintList(@NonNull View r10, @Nullable ColorStateList r11) {
        int r12 = Build.VERSION.SDK_INT;
        if (r12 < 21) goto L20;
        Api21Impl.setBackgroundTintList(r10, r11);
        if (r12 != 21) goto L23;
        Drawable r13 = r10.getBackground();
        if (Api21Impl.getBackgroundTintList(r10) == null) goto L9;
    L12:
        boolean r14 = true;
    L13:
        if (r13 == null) goto L24;
        if (r14 == true) goto L16;
        return;
    L16:
        if (r13.isStateful() == false) goto L18;
        r13.setState(r10.getDrawableState());
    L18:
        Api16Impl.setBackground(r10, r13);
        return;
    L24:
        return;
    L9:
        if (Api21Impl.getBackgroundTintMode(r10) != null) goto L12;
        r14 = false;
        goto L13
    L23:
        return;
    L20:
        if ((r10 instanceof TintableBackgroundView) == false) goto L27;
        ((TintableBackgroundView) r10).setSupportBackgroundTintList(r11);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void setBackgroundTintMode(@NonNull View r10, @Nullable PorterDuff.Mode r11) {
        int r12 = Build.VERSION.SDK_INT;
        if (r12 < 21) goto L20;
        Api21Impl.setBackgroundTintMode(r10, r11);
        if (r12 != 21) goto L23;
        Drawable r13 = r10.getBackground();
        if (Api21Impl.getBackgroundTintList(r10) == null) goto L9;
    L12:
        boolean r14 = true;
    L13:
        if (r13 == null) goto L24;
        if (r14 == true) goto L16;
        return;
    L16:
        if (r13.isStateful() == false) goto L18;
        r13.setState(r10.getDrawableState());
    L18:
        Api16Impl.setBackground(r10, r13);
        return;
    L24:
        return;
    L9:
        if (Api21Impl.getBackgroundTintMode(r10) != null) goto L12;
        r14 = false;
        goto L13
    L23:
        return;
    L20:
        if ((r10 instanceof TintableBackgroundView) == false) goto L27;
        ((TintableBackgroundView) r10).setSupportBackgroundTintMode(r11);
        return;
    }

    @SuppressLint({"BanUncheckedReflection"})
    @Deprecated
    public static void setChildrenDrawingOrderEnabled(ViewGroup r10, boolean r11) {
        if (sChildrenDrawingOrderMethod != null) goto L16;
        sChildrenDrawingOrderMethod = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", new Class[]{Boolean.TYPE});     // Catch: NoSuchMethodException -> L6
    L8:
        sChildrenDrawingOrderMethod.setAccessible(true);
    L6:
        e = move-exception;
        Log.e(TAG, "Unable to find childrenDrawingOrderEnabled", e);
    L16:
        sChildrenDrawingOrderMethod.invoke(r10, new Object[]{Boolean.valueOf(r11)});     // Catch: Throwable -> L11
        return;
    L11:
        e = move-exception;
        Log.e(TAG, "Unable to invoke childrenDrawingOrderEnabled", e);
    }

    public static void setClipBounds(@NonNull View r10, @Nullable Rect r11) {
        if (Build.VERSION.SDK_INT < 18) goto L6;
        Api18Impl.setClipBounds(r10, r11);
        return;
    }

    public static void setElevation(@NonNull View r10, float r11) {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        Api21Impl.setElevation(r10, r11);
        return;
    }

    @Deprecated
    public static void setFitsSystemWindows(View r10, boolean r11) {
        r10.setFitsSystemWindows(r11);
    }

    public static void setFocusedByDefault(@NonNull View r10, boolean r11) {
        if (Build.VERSION.SDK_INT < 26) goto L6;
        Api26Impl.setFocusedByDefault(r10, r11);
        return;
    }

    public static void setHasTransientState(@NonNull View r10, boolean r11) {
        if (Build.VERSION.SDK_INT < 16) goto L6;
        Api16Impl.setHasTransientState(r10, r11);
        return;
    }

    @UiThread
    public static void setImportantForAccessibility(@NonNull View r10, int r11) {
        int r12 = Build.VERSION.SDK_INT;
        if (r12 < 19) goto L6;
    L4:
        Api16Impl.setImportantForAccessibility(r10, r11);
        return;
    L6:
        if (r12 >= 16) goto L8;
        return;
    L8:
        if (r11 != 4) goto L4;
        r11 = 2;
        goto L4
    }

    public static void setImportantForAutofill(@NonNull View r10, int r11) {
        if (Build.VERSION.SDK_INT < 26) goto L6;
        Api26Impl.setImportantForAutofill(r10, r11);
        return;
    }

    public static void setKeyboardNavigationCluster(@NonNull View r10, boolean r11) {
        if (Build.VERSION.SDK_INT < 26) goto L6;
        Api26Impl.setKeyboardNavigationCluster(r10, r11);
        return;
    }

    public static void setLabelFor(@NonNull View r10, @IdRes int r11) {
        if (Build.VERSION.SDK_INT < 17) goto L6;
        Api17Impl.setLabelFor(r10, r11);
        return;
    }

    public static void setLayerPaint(@NonNull View r10, @Nullable Paint r11) {
        if (Build.VERSION.SDK_INT < 17) goto L5;
        Api17Impl.setLayerPaint(r10, r11);
        return;
    L5:
        r10.setLayerType(r10.getLayerType(), r11);
        r10.invalidate();
    }

    @Deprecated
    public static void setLayerType(View r10, int r11, Paint r12) {
        r10.setLayerType(r11, r12);
    }

    public static void setLayoutDirection(@NonNull View r10, int r11) {
        if (Build.VERSION.SDK_INT < 17) goto L6;
        Api17Impl.setLayoutDirection(r10, r11);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void setNestedScrollingEnabled(@NonNull View r10, boolean r11) {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        Api21Impl.setNestedScrollingEnabled(r10, r11);
        return;
    L6:
        if ((r10 instanceof NestedScrollingChild) == false) goto L10;
        ((NestedScrollingChild) r10).setNestedScrollingEnabled(r11);
        return;
    }

    public static void setNextClusterForwardId(@NonNull View r10, int r11) {
        if (Build.VERSION.SDK_INT < 26) goto L6;
        Api26Impl.setNextClusterForwardId(r10, r11);
        return;
    }

    public static void setOnApplyWindowInsetsListener(@NonNull View r10, @Nullable OnApplyWindowInsetsListener r11) {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        Api21Impl.setOnApplyWindowInsetsListener(r10, r11);
        return;
    }

    public static void setOnReceiveContentListener(@NonNull View r10, @Nullable String[] r11, @Nullable OnReceiveContentListener r12) {
        if (Build.VERSION.SDK_INT < 31) goto L6;
        Api31Impl.setOnReceiveContentListener(r10, r11, r12);
        return;
    L6:
        if (r11 != null) goto L8;
    L9:
        r11 = null;
    L10:
        boolean r13 = false;
        if (r12 == null) goto L16;
        if (r11 == null) goto L14;
        boolean r14 = true;
    L15:
        Preconditions.checkArgument(r14, "When the listener is set, MIME types must also be set");
        goto L16
    L14:
        r14 = false;
    L16:
        if (r11 == null) goto L24;
        int r15 = r11.length;
        int r16 = 0;
    L18:
        if (r16 >= r15) goto L23;
        if (r11[r16].startsWith("*") == true) goto L21;
        r16 = r16 + 1;
        goto L18
    L21:
        r13 = true;
    L23:
        Preconditions.checkArgument(!r13, "A MIME type set here must not start with *: " + Arrays.toString(r11));
    L24:
        r10.setTag(R.id.tag_on_receive_content_mime_types, r11);
        r10.setTag(R.id.tag_on_receive_content_listener, r12);
        return;
    L8:
        if (r11.length != 0) goto L10;
        goto L9
    }

    @Deprecated
    public static void setOverScrollMode(View r10, int r11) {
        r10.setOverScrollMode(r11);
    }

    public static void setPaddingRelative(@NonNull View r10, @Px int r11, @Px int r12, @Px int r13, @Px int r14) {
        if (Build.VERSION.SDK_INT < 17) goto L5;
        Api17Impl.setPaddingRelative(r10, r11, r12, r13, r14);
        return;
    L5:
        r10.setPadding(r11, r12, r13, r14);
    }

    @Deprecated
    public static void setPivotX(View r10, float r11) {
        r10.setPivotX(r11);
    }

    @Deprecated
    public static void setPivotY(View r10, float r11) {
        r10.setPivotY(r11);
    }

    public static void setPointerIcon(@NonNull View r10, @Nullable PointerIconCompat r11) {
        if (Build.VERSION.SDK_INT < 24) goto L9;
        if (r11 == null) goto L6;
        Object r12 = r11.getPointerIcon();
    L7:
        Api24Impl.setPointerIcon(r10, (PointerIcon) r12);
        return;
    L6:
        r12 = null;
        goto L7
    }

    @Deprecated
    public static void setRotation(View r10, float r11) {
        r10.setRotation(r11);
    }

    @Deprecated
    public static void setRotationX(View r10, float r11) {
        r10.setRotationX(r11);
    }

    @Deprecated
    public static void setRotationY(View r10, float r11) {
        r10.setRotationY(r11);
    }

    @Deprecated
    public static void setSaveFromParentEnabled(View r10, boolean r11) {
        r10.setSaveFromParentEnabled(r11);
    }

    @Deprecated
    public static void setScaleX(View r10, float r11) {
        r10.setScaleX(r11);
    }

    @Deprecated
    public static void setScaleY(View r10, float r11) {
        r10.setScaleY(r11);
    }

    @UiThread
    public static void setScreenReaderFocusable(@NonNull View r10, boolean r11) {
        screenReaderFocusableProperty().set(r10, Boolean.valueOf(r11));
    }

    public static void setScrollIndicators(@NonNull View r10, int r11) {
        if (Build.VERSION.SDK_INT < 23) goto L6;
        Api23Impl.setScrollIndicators(r10, r11);
        return;
    }

    public static void setScrollIndicators(@NonNull View r10, int r11, int r12) {
        if (Build.VERSION.SDK_INT < 23) goto L6;
        Api23Impl.setScrollIndicators(r10, r11, r12);
        return;
    }

    @UiThread
    public static void setStateDescription(@NonNull View r10, @Nullable CharSequence r11) {
        if (Build.VERSION.SDK_INT < 19) goto L6;
        stateDescriptionProperty().set(r10, r11);
        return;
    }

    public static void setSystemGestureExclusionRects(@NonNull View r10, @NonNull List<Rect> r11) {
        if (Build.VERSION.SDK_INT < 29) goto L6;
        Api29Impl.setSystemGestureExclusionRects(r10, r11);
        return;
    }

    public static void setTooltipText(@NonNull View r10, @Nullable CharSequence r11) {
        if (Build.VERSION.SDK_INT < 26) goto L6;
        Api26Impl.setTooltipText(r10, r11);
        return;
    }

    public static void setTransitionName(@NonNull View r10, @Nullable String r11) {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        Api21Impl.setTransitionName(r10, r11);
        return;
    L6:
        if (sTransitionNameMap != null) goto L8;
        sTransitionNameMap = new WeakHashMap();
    L8:
        sTransitionNameMap.put(r10, r11);
    }

    @Deprecated
    public static void setTranslationX(View r10, float r11) {
        r10.setTranslationX(r11);
    }

    @Deprecated
    public static void setTranslationY(View r10, float r11) {
        r10.setTranslationY(r11);
    }

    public static void setTranslationZ(@NonNull View r10, float r11) {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        Api21Impl.setTranslationZ(r10, r11);
        return;
    }

    private static void setViewImportanceForAccessibilityIfNeeded(View r10) {
        if (getImportantForAccessibility(r10) != 0) goto L5;
        setImportantForAccessibility(r10, 1);
    L5:
        ViewParent r11 = r10.getParent();
    L7:
        if ((r11 instanceof View) == false) goto L15;
        if (getImportantForAccessibility((View) r11) == 4) goto L10;
        r11 = r11.getParent();
        goto L7
    L10:
        setImportantForAccessibility(r10, 2);
        return;
    }

    public static void setWindowInsetsAnimationCallback(@NonNull View r10, @Nullable WindowInsetsAnimationCompat.Callback r11) {
        WindowInsetsAnimationCompat.setCallback(r10, r11);
    }

    @Deprecated
    public static void setX(View r10, float r11) {
        r10.setX(r11);
    }

    @Deprecated
    public static void setY(View r10, float r11) {
        r10.setY(r11);
    }

    public static void setZ(@NonNull View r10, float r11) {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        Api21Impl.setZ(r10, r11);
        return;
    }

    public static boolean startDragAndDrop(@NonNull View r10, @Nullable ClipData r11, @NonNull View.DragShadowBuilder r12, @Nullable Object r13, int r14) {
        if (Build.VERSION.SDK_INT < 24) goto L7;
        return Api24Impl.startDragAndDrop(r10, r11, r12, r13, r14);
    L7:
        return r10.startDrag(r11, r12, r13, r14);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean startNestedScroll(@NonNull View r10, int r11) {
        if (Build.VERSION.SDK_INT < 21) goto L7;
        return Api21Impl.startNestedScroll(r10, r11);
    L7:
        if ((r10 instanceof NestedScrollingChild) == true) goto L9;
        return false;
    L9:
        return ((NestedScrollingChild) r10).startNestedScroll(r11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean startNestedScroll(@NonNull View r10, int r11, int r12) {
        if ((r10 instanceof NestedScrollingChild2) == true) goto L5;
        if (r12 == 0) goto L8;
        return false;
    L8:
        return startNestedScroll(r10, r11);
    L5:
        return ((NestedScrollingChild2) r10).startNestedScroll(r11, r12);
    }

    private static AccessibilityViewProperty<CharSequence> stateDescriptionProperty() {
        final int r10 = R.id.tag_state_description;
        final Class<CharSequence> r11 = CharSequence.class;
        final int r12 = 64;
        final int r13 = 30;
        return new AnonymousClass3(r10, r11, r12, r13);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void stopNestedScroll(@NonNull View r10) {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        Api21Impl.stopNestedScroll(r10);
        return;
    L6:
        if ((r10 instanceof NestedScrollingChild) == false) goto L10;
        ((NestedScrollingChild) r10).stopNestedScroll();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void stopNestedScroll(@NonNull View r10, int r11) {
        if ((r10 instanceof NestedScrollingChild2) == false) goto L5;
        ((NestedScrollingChild2) r10).stopNestedScroll(r11);
        return;
    L5:
        if (r11 != 0) goto L9;
        stopNestedScroll(r10);
        return;
    }

    private static void tickleInvalidationFlag(View r10) {
        float r11 = r10.getTranslationY();
        r10.setTranslationY(1.0f + r11);
        r10.setTranslationY(r11);
    }

    public static void updateDragShadow(@NonNull View r10, @NonNull View.DragShadowBuilder r11) {
        if (Build.VERSION.SDK_INT < 24) goto L6;
        Api24Impl.updateDragShadow(r10, r11);
        return;
    }
}
