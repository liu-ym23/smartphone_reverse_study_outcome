package androidx.core.view;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.Context;
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
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.autofill.AutofillId;
import android.view.contentcapture.ContentCaptureSession;
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
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.core.view.autofill.AutofillIdCompat;
import androidx.core.view.contentcapture.ContentCaptureSessionCompat;
import com.google.android.material.color.utilities.Contrast;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"PrivateConstructorForUtilityClass"})
public class ViewCompat {
    private static final int[] ACCESSIBILITY_ACTIONS_RESOURCE_IDS = null;
    public static final int ACCESSIBILITY_LIVE_REGION_ASSERTIVE = 2;
    public static final int ACCESSIBILITY_LIVE_REGION_NONE = 0;
    public static final int ACCESSIBILITY_LIVE_REGION_POLITE = 1;

    @Deprecated
    public static final int IMPORTANT_FOR_ACCESSIBILITY_AUTO = 0;

    @Deprecated
    public static final int IMPORTANT_FOR_ACCESSIBILITY_NO = 2;

    @Deprecated
    public static final int IMPORTANT_FOR_ACCESSIBILITY_NO_HIDE_DESCENDANTS = 4;

    @Deprecated
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

    @Deprecated
    public static final int LAYOUT_DIRECTION_INHERIT = 2;

    @Deprecated
    public static final int LAYOUT_DIRECTION_LOCALE = 3;

    @Deprecated
    public static final int LAYOUT_DIRECTION_LTR = 0;

    @Deprecated
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
    private static boolean sAccessibilityDelegateCheckFailed = false;
    private static Field sAccessibilityDelegateField;
    private static final AccessibilityPaneVisibilityManager sAccessibilityPaneVisibilityManager = null;
    private static Method sChildrenDrawingOrderMethod;
    private static Method sDispatchFinishTemporaryDetach;
    private static Method sDispatchStartTemporaryDetach;
    private static boolean sTempDetachBound;
    private static ThreadLocal<Rect> sThreadLocalRect;
    private static WeakHashMap<View, String> sTransitionNameMap;
    private static WeakHashMap<View, ViewPropertyAnimatorCompat> sViewPropertyAnimatorMap;

    public static class AccessibilityPaneVisibilityManager implements ViewTreeObserver.OnGlobalLayoutListener, View.OnAttachStateChangeListener {
        private final WeakHashMap<View, Boolean> mPanesToVisible;

        public AccessibilityPaneVisibilityManager() {
            this.mPanesToVisible = new WeakHashMap();
        }

        private void checkPaneVisibility(Map.Entry<View, Boolean> r5) {
            View r10 = r5.getKey();
            boolean r11 = r5.getValue().booleanValue();
            if (r10.isShown() == true) goto L5;
        L7:
            boolean r12 = false;
        L8:
            if (r11 == r12) goto L14;
            if (r12 == false) goto L11;
            int r13 = 16;
        L12:
            ViewCompat.notifyViewAccessibilityStateChangedIfNeeded(r10, r13);
            r5.setValue(Boolean.valueOf(r12));
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

        private void registerForLayoutCallback(View r5) {
            r5.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }

        private void unregisterForLayoutCallback(View r5) {
            r5.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }

        public void addAccessibilityPane(View r5) {
            WeakHashMap<View, Boolean> r10 = this.mPanesToVisible;
            if (r5.isShown() == true) goto L5;
        L7:
            boolean r11 = false;
        L8:
            r10.put(r5, Boolean.valueOf(r11));
            r5.addOnAttachStateChangeListener(this);
            if (r5.isAttachedToWindow() == false) goto L12;
            registerForLayoutCallback(r5);
            return;
        L12:
            return;
        L5:
            if (r5.getWindowVisibility() != 0) goto L7;
            r11 = true;
            goto L8
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View r5) {
            registerForLayoutCallback(r5);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View r5) {
        }

        public void removeAccessibilityPane(View r5) {
            this.mPanesToVisible.remove(r5);
            r5.removeOnAttachStateChangeListener(this);
            unregisterForLayoutCallback(r5);
        }
    }

    public static abstract class AccessibilityViewProperty<T> {
        private final int mContentChangeType;
        private final int mFrameworkMinimumSdk;
        private final int mTagKey;
        private final Class<T> mType;

        public AccessibilityViewProperty(int r5, Class<T> r10, int r11) {
            this(r5, r10, 0, r11);
        }

        private boolean frameworkAvailable() {
            if (Build.VERSION.SDK_INT < this.mFrameworkMinimumSdk) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean booleanNullToFalseEquals(Boolean r5, Boolean r10) {
            if (r5 != null) goto L5;
        L7:
            boolean r11 = false;
        L8:
            if (r10 != null) goto L10;
        L12:
            boolean r12 = false;
        L13:
            if (r11 == r12) goto L15;
            return false;
        L15:
            return true;
        L10:
            if (r10.booleanValue() == false) goto L12;
            r12 = true;
            goto L13
        L5:
            if (r5.booleanValue() == false) goto L7;
            r11 = true;
            goto L8
        }

        public abstract T frameworkGet(View r5);

        public abstract void frameworkSet(View r5, T r10);

        public T get(View r5) {
            if (frameworkAvailable() == true) goto L5;
            T r10 = (T) r5.getTag(this.mTagKey);
            if (this.mType.isInstance(r10) == false) goto L9;
            return r10;
        L9:
            return null;
        L5:
            return frameworkGet(r5);
        }

        public void set(View r5, T r10) {
            if (frameworkAvailable() == false) goto L6;
            frameworkSet(r5, r10);
            return;
        L6:
            if (shouldUpdate(get(r5), r10) == false) goto L10;
            ViewCompat.ensureAccessibilityDelegateCompat(r5);
            r5.setTag(this.mTagKey, r10);
            ViewCompat.notifyViewAccessibilityStateChangedIfNeeded(r5, this.mContentChangeType);
            return;
        }

        public boolean shouldUpdate(T r5, T r10) {
            return !r10.equals(r5);
        }

        public AccessibilityViewProperty(int r5, Class<T> r10, int r11, int r12) {
            this.mTagKey = r5;
            this.mType = r10;
            this.mContentChangeType = r11;
            this.mFrameworkMinimumSdk = r12;
        }
    }

    @RequiresApi(20)
    public static class Api20Impl {
        private Api20Impl() {
        }

        @DoNotInline
        public static WindowInsets dispatchApplyWindowInsets(View r5, WindowInsets r10) {
            return r5.dispatchApplyWindowInsets(r10);
        }

        @DoNotInline
        public static WindowInsets onApplyWindowInsets(View r5, WindowInsets r10) {
            return r5.onApplyWindowInsets(r10);
        }

        @DoNotInline
        public static void requestApplyInsets(View r5) {
            r5.requestApplyInsets();
        }
    }

    @RequiresApi(21)
    public static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        public static void callCompatInsetAnimationCallback(@NonNull WindowInsets r5, @NonNull View r10) {
            View.OnApplyWindowInsetsListener r11 = (View.OnApplyWindowInsetsListener) r10.getTag(R.id.tag_window_insets_animation_callback);
            if (r11 == null) goto L6;
            r11.onApplyWindowInsets(r10, r5);
            return;
        }

        @DoNotInline
        public static WindowInsetsCompat computeSystemWindowInsets(@NonNull View r5, @NonNull WindowInsetsCompat r10, @NonNull Rect r11) {
            WindowInsets r12 = r10.toWindowInsets();
            if (r12 != null) goto L5;
            r11.setEmpty();
            return r10;
        L5:
            return WindowInsetsCompat.toWindowInsetsCompat(r5.computeSystemWindowInsets(r12, r11), r5);
        }

        @DoNotInline
        public static boolean dispatchNestedFling(@NonNull View r5, float r10, float r11, boolean r12) {
            return r5.dispatchNestedFling(r10, r11, r12);
        }

        @DoNotInline
        public static boolean dispatchNestedPreFling(@NonNull View r5, float r10, float r11) {
            return r5.dispatchNestedPreFling(r10, r11);
        }

        @DoNotInline
        public static boolean dispatchNestedPreScroll(View r5, int r10, int r11, int[] r12, int[] r13) {
            return r5.dispatchNestedPreScroll(r10, r11, r12, r13);
        }

        @DoNotInline
        public static boolean dispatchNestedScroll(View r5, int r10, int r11, int r12, int r13, int[] r14) {
            return r5.dispatchNestedScroll(r10, r11, r12, r13, r14);
        }

        @DoNotInline
        public static ColorStateList getBackgroundTintList(View r5) {
            return r5.getBackgroundTintList();
        }

        @DoNotInline
        public static PorterDuff.Mode getBackgroundTintMode(View r5) {
            return r5.getBackgroundTintMode();
        }

        @DoNotInline
        public static float getElevation(View r5) {
            return r5.getElevation();
        }

        @Nullable
        @DoNotInline
        public static WindowInsetsCompat getRootWindowInsets(@NonNull View r5) {
            return WindowInsetsCompat.Api21ReflectionHolder.getRootWindowInsets(r5);
        }

        @DoNotInline
        public static String getTransitionName(View r5) {
            return r5.getTransitionName();
        }

        @DoNotInline
        public static float getTranslationZ(View r5) {
            return r5.getTranslationZ();
        }

        @DoNotInline
        public static float getZ(@NonNull View r5) {
            return r5.getZ();
        }

        @DoNotInline
        public static boolean hasNestedScrollingParent(View r5) {
            return r5.hasNestedScrollingParent();
        }

        @DoNotInline
        public static boolean isImportantForAccessibility(View r5) {
            return r5.isImportantForAccessibility();
        }

        @DoNotInline
        public static boolean isNestedScrollingEnabled(View r5) {
            return r5.isNestedScrollingEnabled();
        }

        @DoNotInline
        public static void setBackgroundTintList(View r5, ColorStateList r10) {
            r5.setBackgroundTintList(r10);
        }

        @DoNotInline
        public static void setBackgroundTintMode(View r5, PorterDuff.Mode r10) {
            r5.setBackgroundTintMode(r10);
        }

        @DoNotInline
        public static void setElevation(View r5, float r10) {
            r5.setElevation(r10);
        }

        @DoNotInline
        public static void setNestedScrollingEnabled(View r5, boolean r10) {
            r5.setNestedScrollingEnabled(r10);
        }

        @DoNotInline
        public static void setOnApplyWindowInsetsListener(@NonNull final View r5, @Nullable final OnApplyWindowInsetsListener r10) {
            if (r10 != null) goto L5;
            r5.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) r5.getTag(R.id.tag_window_insets_animation_callback));
            return;
        L5:
            r5.setOnApplyWindowInsetsListener(new AnonymousClass1(r5, r10));
        }

        @DoNotInline
        public static void setTransitionName(View r5, String r10) {
            r5.setTransitionName(r10);
        }

        @DoNotInline
        public static void setTranslationZ(View r5, float r10) {
            r5.setTranslationZ(r10);
        }

        @DoNotInline
        public static void setZ(@NonNull View r5, float r10) {
            r5.setZ(r10);
        }

        @DoNotInline
        public static boolean startNestedScroll(View r5, int r10) {
            return r5.startNestedScroll(r10);
        }

        @DoNotInline
        public static void stopNestedScroll(View r5) {
            r5.stopNestedScroll();
        }
    }

    @RequiresApi(23)
    public static class Api23Impl {
        private Api23Impl() {
        }

        @Nullable
        public static WindowInsetsCompat getRootWindowInsets(@NonNull View r5) {
            WindowInsets r10 = r5.getRootWindowInsets();
            if (r10 != null) goto L6;
            return null;
        L6:
            WindowInsetsCompat r11 = WindowInsetsCompat.toWindowInsetsCompat(r10);
            r11.setRootWindowInsets(r11);
            r11.copyRootViewBounds(r5.getRootView());
            return r11;
        }

        @DoNotInline
        public static int getScrollIndicators(@NonNull View r5) {
            return r5.getScrollIndicators();
        }

        @DoNotInline
        public static void setScrollIndicators(@NonNull View r5, int r10) {
            r5.setScrollIndicators(r10);
        }

        @DoNotInline
        public static void setScrollIndicators(@NonNull View r5, int r10, int r11) {
            r5.setScrollIndicators(r10, r11);
        }
    }

    @RequiresApi(24)
    public static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        public static void cancelDragAndDrop(@NonNull View r5) {
            r5.cancelDragAndDrop();
        }

        @DoNotInline
        public static void dispatchFinishTemporaryDetach(View r5) {
            r5.dispatchFinishTemporaryDetach();
        }

        @DoNotInline
        public static void dispatchStartTemporaryDetach(View r5) {
            r5.dispatchStartTemporaryDetach();
        }

        @DoNotInline
        public static void setPointerIcon(@NonNull View r5, PointerIcon r10) {
            r5.setPointerIcon(r10);
        }

        @DoNotInline
        public static boolean startDragAndDrop(@NonNull View r5, @Nullable ClipData r10, @NonNull View.DragShadowBuilder r11, @Nullable Object r12, int r13) {
            return r5.startDragAndDrop(r10, r11, r12, r13);
        }

        @DoNotInline
        public static void updateDragShadow(@NonNull View r5, @NonNull View.DragShadowBuilder r10) {
            r5.updateDragShadow(r10);
        }
    }

    @RequiresApi(26)
    public static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        public static void addKeyboardNavigationClusters(@NonNull View r5, Collection<View> r10, int r11) {
            r5.addKeyboardNavigationClusters(r10, r11);
        }

        @DoNotInline
        public static AutofillId getAutofillId(View r5) {
            return r5.getAutofillId();
        }

        @DoNotInline
        public static int getImportantForAutofill(View r5) {
            return r5.getImportantForAutofill();
        }

        @DoNotInline
        public static int getNextClusterForwardId(@NonNull View r5) {
            return r5.getNextClusterForwardId();
        }

        @DoNotInline
        public static boolean hasExplicitFocusable(@NonNull View r5) {
            return r5.hasExplicitFocusable();
        }

        @DoNotInline
        public static boolean isFocusedByDefault(@NonNull View r5) {
            return r5.isFocusedByDefault();
        }

        @DoNotInline
        public static boolean isImportantForAutofill(View r5) {
            return r5.isImportantForAutofill();
        }

        @DoNotInline
        public static boolean isKeyboardNavigationCluster(@NonNull View r5) {
            return r5.isKeyboardNavigationCluster();
        }

        @DoNotInline
        public static View keyboardNavigationClusterSearch(@NonNull View r5, View r10, int r11) {
            return r5.keyboardNavigationClusterSearch(r10, r11);
        }

        @DoNotInline
        public static boolean restoreDefaultFocus(@NonNull View r5) {
            return r5.restoreDefaultFocus();
        }

        @DoNotInline
        public static void setAutofillHints(@NonNull View r5, String... r10) {
            r5.setAutofillHints(r10);
        }

        @DoNotInline
        public static void setFocusedByDefault(@NonNull View r5, boolean r10) {
            r5.setFocusedByDefault(r10);
        }

        @DoNotInline
        public static void setImportantForAutofill(View r5, int r10) {
            r5.setImportantForAutofill(r10);
        }

        @DoNotInline
        public static void setKeyboardNavigationCluster(@NonNull View r5, boolean r10) {
            r5.setKeyboardNavigationCluster(r10);
        }

        @DoNotInline
        public static void setNextClusterForwardId(View r5, int r10) {
            r5.setNextClusterForwardId(r10);
        }

        @DoNotInline
        public static void setTooltipText(@NonNull View r5, CharSequence r10) {
            r5.setTooltipText(r10);
        }
    }

    @RequiresApi(28)
    public static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        public static void addOnUnhandledKeyEventListener(@NonNull View r5, @NonNull final OnUnhandledKeyEventListenerCompat r10) {
            SimpleArrayMap r11 = (SimpleArrayMap) r5.getTag(R.id.tag_unhandled_key_listeners);
            if (r11 != null) goto L5;
            r11 = new SimpleArrayMap();
            r5.setTag(R.id.tag_unhandled_key_listeners, r11);
        L5:
            Objects.requireNonNull(r10);
            View.OnUnhandledKeyEventListener r12 = new j(r10);
            r11.put(r10, r12);
            r5.addOnUnhandledKeyEventListener(r12);
        }

        @DoNotInline
        public static CharSequence getAccessibilityPaneTitle(View r5) {
            return r5.getAccessibilityPaneTitle();
        }

        @DoNotInline
        public static boolean isAccessibilityHeading(View r5) {
            return r5.isAccessibilityHeading();
        }

        @DoNotInline
        public static boolean isScreenReaderFocusable(View r5) {
            return r5.isScreenReaderFocusable();
        }

        @DoNotInline
        public static void removeOnUnhandledKeyEventListener(@NonNull View r5, @NonNull OnUnhandledKeyEventListenerCompat r10) {
            SimpleArrayMap r11 = (SimpleArrayMap) r5.getTag(R.id.tag_unhandled_key_listeners);
            if (r11 != null) goto L5;
            return;
        L5:
            View.OnUnhandledKeyEventListener r12 = (View.OnUnhandledKeyEventListener) r11.get(r10);
            if (r12 == null) goto L9;
            r5.removeOnUnhandledKeyEventListener(r12);
            return;
        }

        @DoNotInline
        public static <T> T requireViewById(View r5, int r10) {
            return (T) r5.requireViewById(r10);
        }

        @DoNotInline
        public static void setAccessibilityHeading(View r5, boolean r10) {
            r5.setAccessibilityHeading(r10);
        }

        @DoNotInline
        public static void setAccessibilityPaneTitle(View r5, CharSequence r10) {
            r5.setAccessibilityPaneTitle(r10);
        }

        @DoNotInline
        public static void setAutofillId(View r5, AutofillIdCompat r10) {
            if (r10 != null) goto L4;
            AutofillId r11 = null;
        L5:
            r5.setAutofillId(r11);
            return;
        L4:
            r11 = r10.toAutofillId();
            goto L5
        }

        @DoNotInline
        public static void setScreenReaderFocusable(View r5, boolean r10) {
            r5.setScreenReaderFocusable(r10);
        }
    }

    @RequiresApi(29)
    public static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        public static View.AccessibilityDelegate getAccessibilityDelegate(View r5) {
            return r5.getAccessibilityDelegate();
        }

        @DoNotInline
        public static ContentCaptureSession getContentCaptureSession(View r5) {
            return r5.getContentCaptureSession();
        }

        @DoNotInline
        public static List<Rect> getSystemGestureExclusionRects(View r5) {
            return r5.getSystemGestureExclusionRects();
        }

        @DoNotInline
        public static void saveAttributeDataForStyleable(@NonNull View r5, @NonNull Context r10, @NonNull int[] r11, @Nullable AttributeSet r12, @NonNull TypedArray r13, int r14, int r15) {
            r5.saveAttributeDataForStyleable(r10, r11, r12, r13, r14, r15);
        }

        @DoNotInline
        public static void setContentCaptureSession(View r5, ContentCaptureSessionCompat r10) {
            if (r10 != null) goto L4;
            ContentCaptureSession r11 = null;
        L5:
            r5.setContentCaptureSession(r11);
            return;
        L4:
            r11 = r10.toContentCaptureSession();
            goto L5
        }

        @DoNotInline
        public static void setSystemGestureExclusionRects(View r5, List<Rect> r10) {
            r5.setSystemGestureExclusionRects(r10);
        }
    }

    @RequiresApi(30)
    public static class Api30Impl {
        private Api30Impl() {
        }

        @DoNotInline
        public static int getImportantForContentCapture(View r5) {
            return r5.getImportantForContentCapture();
        }

        @DoNotInline
        public static CharSequence getStateDescription(View r5) {
            return r5.getStateDescription();
        }

        @Nullable
        public static WindowInsetsControllerCompat getWindowInsetsController(@NonNull View r5) {
            WindowInsetsController r10 = r5.getWindowInsetsController();
            if (r10 != null) goto L7;
            return null;
        L7:
            return WindowInsetsControllerCompat.toWindowInsetsControllerCompat(r10);
        }

        @DoNotInline
        public static boolean isImportantForContentCapture(View r5) {
            return r5.isImportantForContentCapture();
        }

        @DoNotInline
        public static void setImportantForContentCapture(View r5, int r10) {
            r5.setImportantForContentCapture(r10);
        }

        @DoNotInline
        public static void setStateDescription(View r5, CharSequence r10) {
            r5.setStateDescription(r10);
        }
    }

    @RequiresApi(31)
    public static final class Api31Impl {
        private Api31Impl() {
        }

        @Nullable
        @DoNotInline
        public static String[] getReceiveContentMimeTypes(@NonNull View r5) {
            return r5.getReceiveContentMimeTypes();
        }

        @Nullable
        @DoNotInline
        public static ContentInfoCompat performReceiveContent(@NonNull View r5, @NonNull ContentInfoCompat r10) {
            ContentInfo r11 = r10.toContentInfo();
            ContentInfo r12 = r5.performReceiveContent(r11);
            if (r12 != null) goto L6;
            return null;
        L6:
            if (r12 != r11) goto L9;
            return r10;
        L9:
            return ContentInfoCompat.toContentInfoCompat(r12);
        }

        @DoNotInline
        public static void setOnReceiveContentListener(@NonNull View r5, @Nullable String[] r10, @Nullable OnReceiveContentListener r11) {
            if (r11 != null) goto L4;
            r5.setOnReceiveContentListener(r10, null);
            return;
        L4:
            r5.setOnReceiveContentListener(r10, new OnReceiveContentListenerAdapter(r11));
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
    public static final class OnReceiveContentListenerAdapter implements android.view.OnReceiveContentListener {

        @NonNull
        private final OnReceiveContentListener mJetpackListener;

        public OnReceiveContentListenerAdapter(@NonNull OnReceiveContentListener r5) {
            this.mJetpackListener = r5;
        }

        @Override // android.view.OnReceiveContentListener
        @Nullable
        public ContentInfo onReceiveContent(@NonNull View r5, @NonNull ContentInfo r10) {
            ContentInfoCompat r11 = ContentInfoCompat.toContentInfoCompat(r10);
            ContentInfoCompat r12 = this.mJetpackListener.onReceiveContent(r5, r11);
            if (r12 != null) goto L6;
            return null;
        L6:
            if (r12 != r11) goto L9;
            return r10;
        L9:
            return r12.toContentInfo();
        }
    }

    public interface OnUnhandledKeyEventListenerCompat {
        boolean onUnhandledKeyEvent(@NonNull View r5, @NonNull KeyEvent r10);
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface ScrollAxis {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface ScrollIndicators {
    }

    public static class UnhandledKeyEventManager {
        private static final ArrayList<WeakReference<View>> sViewsWithListeners = null;
        private SparseArray<WeakReference<View>> mCapturedKeys;
        private WeakReference<KeyEvent> mLastDispatchedPreViewKeyEvent;

        @Nullable
        private WeakHashMap<View, Boolean> mViewsContainingListeners;

        static {
            sViewsWithListeners = new ArrayList();
        }

        public UnhandledKeyEventManager() {
            this.mViewsContainingListeners = null;
            this.mCapturedKeys = null;
            this.mLastDispatchedPreViewKeyEvent = null;
        }

        public static UnhandledKeyEventManager at(View r5) {
            UnhandledKeyEventManager r10 = (UnhandledKeyEventManager) r5.getTag(R.id.tag_unhandled_key_event_manager);
            if (r10 != null) goto L6;
            UnhandledKeyEventManager r11 = new UnhandledKeyEventManager();
            r5.setTag(R.id.tag_unhandled_key_event_manager, r11);
            return r11;
        L6:
            return r10;
        }

        @Nullable
        private View dispatchInOrder(View r5, KeyEvent r10) {
            WeakHashMap<View, Boolean> r11 = this.mViewsContainingListeners;
            if (r11 != null) goto L5;
        L18:
            return null;
        L5:
            if (r11.containsKey(r5) == false) goto L18;
            if ((r5 instanceof ViewGroup) == false) goto L16;
            ViewGroup r12 = (ViewGroup) r5;
            int r13 = r12.getChildCount() - 1;
        L10:
            if (r13 < 0) goto L16;
            View r14 = dispatchInOrder(r12.getChildAt(r13), r10);
            if (r14 != null) goto L13;
            r13 = r13 - 1;
            goto L10
        L13:
            return r14;
        L16:
            if (onUnhandledKeyEvent(r5, r10) == false) goto L18;
            return r5;
        }

        private SparseArray<WeakReference<View>> getCapturedKeys() {
            if (this.mCapturedKeys != null) goto L6;
            this.mCapturedKeys = new SparseArray();
        L6:
            return this.mCapturedKeys;
        }

        private boolean onUnhandledKeyEvent(@NonNull View r5, @NonNull KeyEvent r10) {
            ArrayList r11 = (ArrayList) r5.getTag(R.id.tag_unhandled_key_listeners);
            if (r11 == null) goto L10;
            int r12 = r11.size() - 1;
        L5:
            if (r12 < 0) goto L14;
            if (((OnUnhandledKeyEventListenerCompat) r11.get(r12)).onUnhandledKeyEvent(r5, r10) == true) goto L8;
            r12 = r12 - 1;
            goto L5
        L8:
            return true;
        L14:
            return false;
        L10:
            return false;
        }

        private void recalcViewsWithUnhandled() {
            WeakHashMap<View, Boolean> r5 = this.mViewsContainingListeners;
            if (r5 == null) goto L5;
            r5.clear();
        L5:
            ArrayList<WeakReference<View>> r10 = sViewsWithListeners;
            if (r10.isEmpty() == false) goto L8;
            return;
        L8:
            monitor-enter(r10);
        L12:
            th = move-exception;
            throw th;
        L10:
            if (this.mViewsContainingListeners != null) goto L14;
            this.mViewsContainingListeners = new WeakHashMap();     // Catch: Throwable -> L12
        L14:
            int r11 = r10.size() - 1;     // Catch: Throwable -> L12
        L15:
            if (r11 < 0) goto L24;
            ArrayList<WeakReference<View>> r12 = sViewsWithListeners;     // Catch: Throwable -> L12
            View r13 = r12.get(r11).get();     // Catch: Throwable -> L12
            if (r13 != null) goto L19;
            r12.remove(r11);     // Catch: Throwable -> L12
        L23:
            r11 = r11 - 1;     // Catch: Throwable -> L12
            goto L15
        L19:
            this.mViewsContainingListeners.put(r13, Boolean.TRUE);     // Catch: Throwable -> L12
            ViewParent r14 = r13.getParent();     // Catch: Throwable -> L12
        L21:
            if ((r14 instanceof View) == false) goto L23;
            this.mViewsContainingListeners.put((View) r14, Boolean.TRUE);     // Catch: Throwable -> L12
            r14 = r14.getParent();     // Catch: Throwable -> L12
            goto L21
        L24:
            monitor-exit(r10);     // Catch: Throwable -> L12
        }

        public static void registerListeningView(View r5) {
            ArrayList<WeakReference<View>> r10 = sViewsWithListeners;
            monitor-enter(r10);
            Iterator<WeakReference<View>> r11 = r10.iterator();     // Catch: Throwable -> L11
        L6:
            if (r11.hasNext() == false) goto L13;
            if (r11.next().get() != r5) goto L6;
            monitor-exit(r10);     // Catch: Throwable -> L11
            return;
        L13:
            sViewsWithListeners.add(new WeakReference(r5));     // Catch: Throwable -> L11
            monitor-exit(r10);     // Catch: Throwable -> L11
            return;
        L11:
            th = move-exception;
            throw th;
        }

        public static void unregisterListeningView(View r5) {
            ArrayList<WeakReference<View>> r10 = sViewsWithListeners;
            monitor-enter(r10);
            int r11 = 0;
        L19:
            ArrayList<WeakReference<View>> r12 = sViewsWithListeners;     // Catch: Throwable -> L12
            if (r11 >= r12.size()) goto L15;
            if (r12.get(r11).get() == r5) goto L9;
            r11 = r11 + 1;     // Catch: Throwable -> L12
            goto L19
        L9:
            r12.remove(r11);     // Catch: Throwable -> L12
            monitor-exit(r10);     // Catch: Throwable -> L12
            return;
        L15:
            monitor-exit(r10);     // Catch: Throwable -> L12
            return;
        L12:
            th = move-exception;
            throw th;
        }

        public boolean dispatch(View r5, KeyEvent r10) {
            if (r10.getAction() != 0) goto L5;
            recalcViewsWithUnhandled();
        L5:
            View r11 = dispatchInOrder(r5, r10);
            if (r10.getAction() != 0) goto L12;
            int r12 = r10.getKeyCode();
            if (r11 == null) goto L12;
            if (KeyEvent.isModifierKey(r12) == true) goto L12;
            getCapturedKeys().put(r12, new WeakReference(r11));
        L12:
            if (r11 == null) goto L14;
            return true;
        L14:
            return false;
        }

        public boolean preDispatch(KeyEvent r10) {
            WeakReference<KeyEvent> r5 = this.mLastDispatchedPreViewKeyEvent;
            if (r5 != null) goto L5;
        L7:
            this.mLastDispatchedPreViewKeyEvent = new WeakReference(r10);
            SparseArray<WeakReference<View>> r11 = getCapturedKeys();
            if (r10.getAction() != 1) goto L12;
            int r12 = r11.indexOfKey(r10.getKeyCode());
            if (r12 < 0) goto L12;
            WeakReference<View> r13 = r11.valueAt(r12);
            r11.removeAt(r12);
        L13:
            if (r13 != null) goto L15;
            r13 = r11.get(r10.getKeyCode());
        L15:
            if (r13 == null) goto L22;
            View r14 = r13.get();
            if (r14 != null) goto L19;
        L21:
            return true;
        L19:
            if (r14.isAttachedToWindow() == false) goto L21;
            onUnhandledKeyEvent(r14, r10);
            goto L21
        L22:
            return false;
        L12:
            r13 = null;
            goto L13
        L5:
            if (r5.get() != r10) goto L7;
            return false;
        }
    }

    static {
        ACCESSIBILITY_ACTIONS_RESOURCE_IDS = new int[]{R.id.accessibility_custom_action_0, R.id.accessibility_custom_action_1, R.id.accessibility_custom_action_2, R.id.accessibility_custom_action_3, R.id.accessibility_custom_action_4, R.id.accessibility_custom_action_5, R.id.accessibility_custom_action_6, R.id.accessibility_custom_action_7, R.id.accessibility_custom_action_8, R.id.accessibility_custom_action_9, R.id.accessibility_custom_action_10, R.id.accessibility_custom_action_11, R.id.accessibility_custom_action_12, R.id.accessibility_custom_action_13, R.id.accessibility_custom_action_14, R.id.accessibility_custom_action_15, R.id.accessibility_custom_action_16, R.id.accessibility_custom_action_17, R.id.accessibility_custom_action_18, R.id.accessibility_custom_action_19, R.id.accessibility_custom_action_20, R.id.accessibility_custom_action_21, R.id.accessibility_custom_action_22, R.id.accessibility_custom_action_23, R.id.accessibility_custom_action_24, R.id.accessibility_custom_action_25, R.id.accessibility_custom_action_26, R.id.accessibility_custom_action_27, R.id.accessibility_custom_action_28, R.id.accessibility_custom_action_29, R.id.accessibility_custom_action_30, R.id.accessibility_custom_action_31};
        NO_OP_ON_RECEIVE_CONTENT_VIEW_BEHAVIOR = new i();
        sAccessibilityPaneVisibilityManager = new AccessibilityPaneVisibilityManager();
    }

    @Deprecated
    public ViewCompat() {
    }

    public static /* synthetic */ ContentInfoCompat a(ContentInfoCompat r5) {
        return lambda$static$0(r5);
    }

    private static AccessibilityViewProperty<Boolean> accessibilityHeadingProperty() {
        final int r5 = R.id.tag_accessibility_heading;
        final Class<Boolean> r10 = Boolean.class;
        final int r11 = 28;
        return new AnonymousClass4(r5, r10, r11);
    }

    public static int addAccessibilityAction(@NonNull View r5, @NonNull CharSequence r10, @NonNull AccessibilityViewCommand r11) {
        int r12 = getAvailableActionIdFromResources(r5, r10);
        if (r12 == (-1)) goto L5;
        addAccessibilityAction(r5, new AccessibilityNodeInfoCompat.AccessibilityActionCompat(r12, r10, r11));
    L5:
        return r12;
    }

    public static void addKeyboardNavigationClusters(@NonNull View r5, @NonNull Collection<View> r10, int r11) {
        Api26Impl.addKeyboardNavigationClusters(r5, r10, r11);
    }

    public static void addOnUnhandledKeyEventListener(@NonNull View r5, @NonNull OnUnhandledKeyEventListenerCompat r10) {
        Api28Impl.addOnUnhandledKeyEventListener(r5, r10);
    }

    @NonNull
    @Deprecated
    public static ViewPropertyAnimatorCompat animate(@NonNull View r5) {
        if (sViewPropertyAnimatorMap != null) goto L5;
        sViewPropertyAnimatorMap = new WeakHashMap();
    L5:
        ViewPropertyAnimatorCompat r10 = sViewPropertyAnimatorMap.get(r5);
        if (r10 != null) goto L9;
        ViewPropertyAnimatorCompat r11 = new ViewPropertyAnimatorCompat(r5);
        sViewPropertyAnimatorMap.put(r5, r11);
        return r11;
    L9:
        return r10;
    }

    private static void bindTempDetach() {
        sDispatchStartTemporaryDetach = View.class.getDeclaredMethod("dispatchStartTemporaryDetach", null);     // Catch: NoSuchMethodException -> L5
        sDispatchFinishTemporaryDetach = View.class.getDeclaredMethod("dispatchFinishTemporaryDetach", null);     // Catch: NoSuchMethodException -> L5
    L7:
        sTempDetachBound = true;
        return;
    L5:
        e = move-exception;
        Log.e(TAG, "Couldn't find method", e);
        goto L7
    }

    @Deprecated
    public static boolean canScrollHorizontally(View r5, int r10) {
        return r5.canScrollHorizontally(r10);
    }

    @Deprecated
    public static boolean canScrollVertically(View r5, int r10) {
        return r5.canScrollVertically(r10);
    }

    public static void cancelDragAndDrop(@NonNull View r5) {
        Api24Impl.cancelDragAndDrop(r5);
    }

    @Deprecated
    public static int combineMeasuredStates(int r5, int r10) {
        return View.combineMeasuredStates(r5, r10);
    }

    private static void compatOffsetLeftAndRight(View r5, int r10) {
        r5.offsetLeftAndRight(r10);
        if (r5.getVisibility() != 0) goto L8;
        tickleInvalidationFlag(r5);
        Object r11 = r5.getParent();
        if ((r11 instanceof View) == false) goto L9;
        tickleInvalidationFlag((View) r11);
        return;
    L9:
        return;
    }

    private static void compatOffsetTopAndBottom(View r5, int r10) {
        r5.offsetTopAndBottom(r10);
        if (r5.getVisibility() != 0) goto L8;
        tickleInvalidationFlag(r5);
        Object r11 = r5.getParent();
        if ((r11 instanceof View) == false) goto L9;
        tickleInvalidationFlag((View) r11);
        return;
    L9:
        return;
    }

    @NonNull
    public static WindowInsetsCompat computeSystemWindowInsets(@NonNull View r5, @NonNull WindowInsetsCompat r10, @NonNull Rect r11) {
        return Api21Impl.computeSystemWindowInsets(r5, r10, r11);
    }

    @NonNull
    public static WindowInsetsCompat dispatchApplyWindowInsets(@NonNull View r5, @NonNull WindowInsetsCompat r10) {
        WindowInsets r11 = r10.toWindowInsets();
        if (r11 == null) goto L8;
        WindowInsets r12 = Api20Impl.dispatchApplyWindowInsets(r5, r11);
        if (r12.equals(r11) == true) goto L8;
        return WindowInsetsCompat.toWindowInsetsCompat(r12, r5);
    L8:
        return r10;
    }

    public static void dispatchFinishTemporaryDetach(@NonNull View r5) {
        Api24Impl.dispatchFinishTemporaryDetach(r5);
    }

    public static boolean dispatchNestedFling(@NonNull View r5, float r10, float r11, boolean r12) {
        return Api21Impl.dispatchNestedFling(r5, r10, r11, r12);
    }

    public static boolean dispatchNestedPreFling(@NonNull View r5, float r10, float r11) {
        return Api21Impl.dispatchNestedPreFling(r5, r10, r11);
    }

    public static boolean dispatchNestedPreScroll(@NonNull View r5, int r10, int r11, @Nullable int[] r12, @Nullable int[] r13) {
        return Api21Impl.dispatchNestedPreScroll(r5, r10, r11, r12, r13);
    }

    public static boolean dispatchNestedScroll(@NonNull View r5, int r10, int r11, int r12, int r13, @Nullable int[] r14) {
        return Api21Impl.dispatchNestedScroll(r5, r10, r11, r12, r13, r14);
    }

    public static void dispatchStartTemporaryDetach(@NonNull View r5) {
        Api24Impl.dispatchStartTemporaryDetach(r5);
    }

    @UiThread
    public static boolean dispatchUnhandledKeyEventBeforeCallback(View r5, KeyEvent r10) {
        return false;
    }

    @UiThread
    public static boolean dispatchUnhandledKeyEventBeforeHierarchy(View r5, KeyEvent r10) {
        return false;
    }

    public static void enableAccessibleClickableSpanSupport(@NonNull View r5) {
        ensureAccessibilityDelegateCompat(r5);
    }

    public static void ensureAccessibilityDelegateCompat(@NonNull View r5) {
        AccessibilityDelegateCompat r10 = getAccessibilityDelegate(r5);
        if (r10 != null) goto L5;
        r10 = new AccessibilityDelegateCompat();
    L5:
        setAccessibilityDelegate(r5, r10);
    }

    @Deprecated
    public static int generateViewId() {
        return View.generateViewId();
    }

    @Nullable
    public static AccessibilityDelegateCompat getAccessibilityDelegate(@NonNull View r5) {
        View.AccessibilityDelegate r10 = getAccessibilityDelegateInternal(r5);
        if (r10 != null) goto L7;
        return null;
    L7:
        if ((r10 instanceof AccessibilityDelegateCompat.AccessibilityDelegateAdapter) == false) goto L11;
        return ((AccessibilityDelegateCompat.AccessibilityDelegateAdapter) r10).mCompat;
    L11:
        return new AccessibilityDelegateCompat(r10);
    }

    @Nullable
    private static View.AccessibilityDelegate getAccessibilityDelegateInternal(@NonNull View r5) {
        return Api29Impl.getAccessibilityDelegate(r5);
    }

    @Nullable
    private static View.AccessibilityDelegate getAccessibilityDelegateThroughReflection(@NonNull View r5) {
        if (sAccessibilityDelegateCheckFailed == false) goto L6;
        return null;
    L6:
        if (sAccessibilityDelegateField != null) goto L20;
        Field r10 = View.class.getDeclaredField("mAccessibilityDelegate");     // Catch: Throwable -> L9
        sAccessibilityDelegateField = r10;     // Catch: Throwable -> L9
        r10.setAccessible(true);     // Catch: Throwable -> L9
    L9:
        sAccessibilityDelegateCheckFailed = true;
        return null;
    L20:
        Object r11 = sAccessibilityDelegateField.get(r5);     // Catch: Throwable -> L16
        if ((r11 instanceof View.AccessibilityDelegate) == false) goto L15;
        return (View.AccessibilityDelegate) r11;
    L15:
        return null;
    L16:
        sAccessibilityDelegateCheckFailed = true;
        return null;
    }

    @Deprecated
    public static int getAccessibilityLiveRegion(@NonNull View r5) {
        return r5.getAccessibilityLiveRegion();
    }

    @Nullable
    public static AccessibilityNodeProviderCompat getAccessibilityNodeProvider(@NonNull View r5) {
        AccessibilityNodeProvider r10 = r5.getAccessibilityNodeProvider();
        if (r10 != null) goto L5;
        return null;
    L5:
        return new AccessibilityNodeProviderCompat(r10);
    }

    @Nullable
    @UiThread
    public static CharSequence getAccessibilityPaneTitle(@NonNull View r5) {
        return paneTitleProperty().get(r5);
    }

    private static List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> getActionList(View r5) {
        ArrayList r10 = (ArrayList) r5.getTag(R.id.tag_accessibility_actions);
        if (r10 != null) goto L6;
        ArrayList r11 = new ArrayList();
        r5.setTag(R.id.tag_accessibility_actions, r11);
        return r11;
    L6:
        return r10;
    }

    @Deprecated
    public static float getAlpha(View r5) {
        return r5.getAlpha();
    }

    @Nullable
    public static AutofillIdCompat getAutofillId(@NonNull View r5) {
        return AutofillIdCompat.toAutofillIdCompat(Api26Impl.getAutofillId(r5));
    }

    private static int getAvailableActionIdFromResources(View r10, @NonNull CharSequence r11) {
        List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> r12 = getActionList(r10);
        int r5 = 0;
    L4:
        if (r5 >= r12.size()) goto L10;
        if (TextUtils.equals(r11, r12.get(r5).getLabel()) == true) goto L8;
        r5 = r5 + 1;
        goto L4
    L8:
        return r12.get(r5).getId();
    L10:
        int r13 = -1;
        int r14 = 0;
    L11:
        int[] r15 = ACCESSIBILITY_ACTIONS_RESOURCE_IDS;
        if (r14 >= r15.length) goto L25;
        if (r13 != (-1)) goto L25;
        int r16 = r15[r14];
        int r17 = 0;
        boolean r18 = true;
    L16:
        if (r17 >= r12.size()) goto L22;
        if (r12.get(r17).getId() == r16) goto L20;
        boolean r19 = true;
    L21:
        r18 = r18 & r19;
        r17 = r17 + 1;
        goto L16
    L20:
        r19 = false;
        goto L21
    L22:
        if (r18 == false) goto L24;
        r13 = r16;
    L24:
        r14 = r14 + 1;
    L25:
        return r13;
    }

    @Nullable
    public static ColorStateList getBackgroundTintList(@NonNull View r5) {
        return Api21Impl.getBackgroundTintList(r5);
    }

    @Nullable
    public static PorterDuff.Mode getBackgroundTintMode(@NonNull View r5) {
        return Api21Impl.getBackgroundTintMode(r5);
    }

    @Nullable
    @Deprecated
    public static Rect getClipBounds(@NonNull View r5) {
        return r5.getClipBounds();
    }

    @Nullable
    public static ContentCaptureSessionCompat getContentCaptureSession(@NonNull View r5) {
        ContentCaptureSession r10 = Api29Impl.getContentCaptureSession(r5);
        if (r10 != null) goto L7;
        return null;
    L7:
        return ContentCaptureSessionCompat.toContentCaptureSessionCompat(r10, r5);
    }

    @Nullable
    @Deprecated
    public static Display getDisplay(@NonNull View r5) {
        return r5.getDisplay();
    }

    public static float getElevation(@NonNull View r5) {
        return Api21Impl.getElevation(r5);
    }

    private static Rect getEmptyTempRect() {
        if (sThreadLocalRect != null) goto L5;
        sThreadLocalRect = new ThreadLocal();
    L5:
        Rect r5 = sThreadLocalRect.get();
        if (r5 != null) goto L8;
        r5 = new Rect();
        sThreadLocalRect.set(r5);
    L8:
        r5.setEmpty();
        return r5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static OnReceiveContentViewBehavior getFallback(@NonNull View r5) {
        if ((r5 instanceof OnReceiveContentViewBehavior) == false) goto L7;
        return (OnReceiveContentViewBehavior) r5;
    L7:
        return NO_OP_ON_RECEIVE_CONTENT_VIEW_BEHAVIOR;
    }

    @Deprecated
    public static boolean getFitsSystemWindows(@NonNull View r5) {
        return r5.getFitsSystemWindows();
    }

    @Deprecated
    public static int getImportantForAccessibility(@NonNull View r5) {
        return r5.getImportantForAccessibility();
    }

    @SuppressLint({"InlinedApi"})
    public static int getImportantForAutofill(@NonNull View r5) {
        return Api26Impl.getImportantForAutofill(r5);
    }

    public static int getImportantForContentCapture(@NonNull View r5) {
        return Api30Impl.getImportantForContentCapture(r5);
    }

    @Deprecated
    public static int getLabelFor(@NonNull View r5) {
        return r5.getLabelFor();
    }

    @Deprecated
    public static int getLayerType(View r5) {
        return r5.getLayerType();
    }

    @Deprecated
    public static int getLayoutDirection(@NonNull View r5) {
        return r5.getLayoutDirection();
    }

    @Nullable
    @Deprecated
    public static Matrix getMatrix(View r5) {
        return r5.getMatrix();
    }

    @Deprecated
    public static int getMeasuredHeightAndState(View r5) {
        return r5.getMeasuredHeightAndState();
    }

    @Deprecated
    public static int getMeasuredState(View r5) {
        return r5.getMeasuredState();
    }

    @Deprecated
    public static int getMeasuredWidthAndState(View r5) {
        return r5.getMeasuredWidthAndState();
    }

    @Deprecated
    public static int getMinimumHeight(@NonNull View r5) {
        return r5.getMinimumHeight();
    }

    @Deprecated
    public static int getMinimumWidth(@NonNull View r5) {
        return r5.getMinimumWidth();
    }

    public static int getNextClusterForwardId(@NonNull View r5) {
        return Api26Impl.getNextClusterForwardId(r5);
    }

    @Nullable
    public static String[] getOnReceiveContentMimeTypes(@NonNull View r5) {
        return Api31Impl.getReceiveContentMimeTypes(r5);
    }

    @Deprecated
    public static int getOverScrollMode(View r5) {
        return r5.getOverScrollMode();
    }

    @Px
    @Deprecated
    public static int getPaddingEnd(@NonNull View r5) {
        return r5.getPaddingEnd();
    }

    @Px
    @Deprecated
    public static int getPaddingStart(@NonNull View r5) {
        return r5.getPaddingStart();
    }

    @Nullable
    @Deprecated
    public static ViewParent getParentForAccessibility(@NonNull View r5) {
        return r5.getParentForAccessibility();
    }

    @Deprecated
    public static float getPivotX(View r5) {
        return r5.getPivotX();
    }

    @Deprecated
    public static float getPivotY(View r5) {
        return r5.getPivotY();
    }

    @Nullable
    public static WindowInsetsCompat getRootWindowInsets(@NonNull View r5) {
        return Api23Impl.getRootWindowInsets(r5);
    }

    @Deprecated
    public static float getRotation(View r5) {
        return r5.getRotation();
    }

    @Deprecated
    public static float getRotationX(View r5) {
        return r5.getRotationX();
    }

    @Deprecated
    public static float getRotationY(View r5) {
        return r5.getRotationY();
    }

    @Deprecated
    public static float getScaleX(View r5) {
        return r5.getScaleX();
    }

    @Deprecated
    public static float getScaleY(View r5) {
        return r5.getScaleY();
    }

    public static int getScrollIndicators(@NonNull View r5) {
        return Api23Impl.getScrollIndicators(r5);
    }

    @Nullable
    @UiThread
    public static CharSequence getStateDescription(@NonNull View r5) {
        return stateDescriptionProperty().get(r5);
    }

    @NonNull
    public static List<Rect> getSystemGestureExclusionRects(@NonNull View r5) {
        return Api29Impl.getSystemGestureExclusionRects(r5);
    }

    @Nullable
    public static String getTransitionName(@NonNull View r5) {
        return Api21Impl.getTransitionName(r5);
    }

    @Deprecated
    public static float getTranslationX(View r5) {
        return r5.getTranslationX();
    }

    @Deprecated
    public static float getTranslationY(View r5) {
        return r5.getTranslationY();
    }

    public static float getTranslationZ(@NonNull View r5) {
        return Api21Impl.getTranslationZ(r5);
    }

    @Nullable
    @Deprecated
    public static WindowInsetsControllerCompat getWindowInsetsController(@NonNull View r5) {
        return Api30Impl.getWindowInsetsController(r5);
    }

    @Deprecated
    public static int getWindowSystemUiVisibility(@NonNull View r5) {
        return r5.getWindowSystemUiVisibility();
    }

    @Deprecated
    public static float getX(View r5) {
        return r5.getX();
    }

    @Deprecated
    public static float getY(View r5) {
        return r5.getY();
    }

    public static float getZ(@NonNull View r5) {
        return Api21Impl.getZ(r5);
    }

    public static boolean hasAccessibilityDelegate(@NonNull View r5) {
        if (getAccessibilityDelegateInternal(r5) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean hasExplicitFocusable(@NonNull View r5) {
        return Api26Impl.hasExplicitFocusable(r5);
    }

    public static boolean hasNestedScrollingParent(@NonNull View r5) {
        return Api21Impl.hasNestedScrollingParent(r5);
    }

    @Deprecated
    public static boolean hasOnClickListeners(@NonNull View r5) {
        return r5.hasOnClickListeners();
    }

    @Deprecated
    public static boolean hasOverlappingRendering(@NonNull View r5) {
        return r5.hasOverlappingRendering();
    }

    @Deprecated
    public static boolean hasTransientState(@NonNull View r5) {
        return r5.hasTransientState();
    }

    @UiThread
    public static boolean isAccessibilityHeading(@NonNull View r5) {
        Boolean r10 = accessibilityHeadingProperty().get(r5);
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.booleanValue() == false) goto L7;
        return true;
    }

    @Deprecated
    public static boolean isAttachedToWindow(@NonNull View r5) {
        return r5.isAttachedToWindow();
    }

    public static boolean isFocusedByDefault(@NonNull View r5) {
        return Api26Impl.isFocusedByDefault(r5);
    }

    public static boolean isImportantForAccessibility(@NonNull View r5) {
        return Api21Impl.isImportantForAccessibility(r5);
    }

    public static boolean isImportantForAutofill(@NonNull View r5) {
        return Api26Impl.isImportantForAutofill(r5);
    }

    public static boolean isImportantForContentCapture(@NonNull View r5) {
        return Api30Impl.isImportantForContentCapture(r5);
    }

    @Deprecated
    public static boolean isInLayout(@NonNull View r5) {
        return r5.isInLayout();
    }

    public static boolean isKeyboardNavigationCluster(@NonNull View r5) {
        return Api26Impl.isKeyboardNavigationCluster(r5);
    }

    @Deprecated
    public static boolean isLaidOut(@NonNull View r5) {
        return r5.isLaidOut();
    }

    @Deprecated
    public static boolean isLayoutDirectionResolved(@NonNull View r5) {
        return r5.isLayoutDirectionResolved();
    }

    public static boolean isNestedScrollingEnabled(@NonNull View r5) {
        return Api21Impl.isNestedScrollingEnabled(r5);
    }

    @Deprecated
    public static boolean isOpaque(View r5) {
        return r5.isOpaque();
    }

    @Deprecated
    public static boolean isPaddingRelative(@NonNull View r5) {
        return r5.isPaddingRelative();
    }

    @UiThread
    public static boolean isScreenReaderFocusable(@NonNull View r5) {
        Boolean r10 = screenReaderFocusableProperty().get(r5);
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.booleanValue() == false) goto L7;
        return true;
    }

    @Deprecated
    public static void jumpDrawablesToCurrentState(View r5) {
        r5.jumpDrawablesToCurrentState();
    }

    @Nullable
    public static View keyboardNavigationClusterSearch(@NonNull View r5, @Nullable View r10, int r11) {
        return Api26Impl.keyboardNavigationClusterSearch(r5, r10, r11);
    }

    private static /* synthetic */ ContentInfoCompat lambda$static$0(ContentInfoCompat r5) {
        return r5;
    }

    public static void notifyViewAccessibilityStateChangedIfNeeded(View r5, int r10) {
        AccessibilityManager r11 = (AccessibilityManager) r5.getContext().getSystemService("accessibility");
        if (r11.isEnabled() == true) goto L6;
        return;
    L6:
        if (getAccessibilityPaneTitle(r5) != null) goto L8;
    L12:
        boolean r12 = false;
    L13:
        int r13 = 32;
        if (r5.getAccessibilityLiveRegion() != 0) goto L26;
        if (r12 == true) goto L26;
        if (r10 != 32) goto L20;
        AccessibilityEvent r14 = AccessibilityEvent.obtain();
        r5.onInitializeAccessibilityEvent(r14);
        r14.setEventType(32);
        r14.setContentChangeTypes(r10);
        r14.setSource(r5);
        r5.onPopulateAccessibilityEvent(r14);
        r14.getText().add(getAccessibilityPaneTitle(r5));
        r11.sendAccessibilityEvent(r14);
        return;
    L20:
        if (r5.getParent() != null) goto L35;
        return;
    L35:
        r5.getParent().notifySubtreeAccessibilityStateChanged(r5, r5, r10);     // Catch: AbstractMethodError -> L24
        return;
    L24:
        e = move-exception;
        Log.e(TAG, r5.getParent().getClass().getSimpleName().concat(" does not fully implement ViewParent"), e);
        return;
    L26:
        AccessibilityEvent r15 = AccessibilityEvent.obtain();
        if (r12 == true) goto L30;
        r13 = 2048;
    L30:
        r15.setEventType(r13);
        r15.setContentChangeTypes(r10);
        if (r12 == false) goto L33;
        r15.getText().add(getAccessibilityPaneTitle(r5));
        setImportantForAccessibilityIfNeeded(r5);
    L33:
        r5.sendAccessibilityEventUnchecked(r15);
        return;
    L8:
        if (r5.isShown() == false) goto L12;
        if (r5.getWindowVisibility() != 0) goto L12;
        r12 = true;
        goto L13
    }

    public static void offsetLeftAndRight(@NonNull View r5, int r10) {
        r5.offsetLeftAndRight(r10);
    }

    public static void offsetTopAndBottom(@NonNull View r5, int r10) {
        r5.offsetTopAndBottom(r10);
    }

    @NonNull
    public static WindowInsetsCompat onApplyWindowInsets(@NonNull View r5, @NonNull WindowInsetsCompat r10) {
        WindowInsets r11 = r10.toWindowInsets();
        if (r11 == null) goto L8;
        WindowInsets r12 = Api20Impl.onApplyWindowInsets(r5, r11);
        if (r12.equals(r11) == true) goto L8;
        return WindowInsetsCompat.toWindowInsetsCompat(r12, r5);
    L8:
        return r10;
    }

    @Deprecated
    public static void onInitializeAccessibilityEvent(View r5, AccessibilityEvent r10) {
        r5.onInitializeAccessibilityEvent(r10);
    }

    @Deprecated
    public static void onInitializeAccessibilityNodeInfo(@NonNull View r5, @NonNull AccessibilityNodeInfoCompat r10) {
        r5.onInitializeAccessibilityNodeInfo(r10.unwrap());
    }

    @Deprecated
    public static void onPopulateAccessibilityEvent(View r5, AccessibilityEvent r10) {
        r5.onPopulateAccessibilityEvent(r10);
    }

    private static AccessibilityViewProperty<CharSequence> paneTitleProperty() {
        final int r5 = R.id.tag_accessibility_pane_title;
        final int r10 = 8;
        final int r11 = 28;
        final Class<CharSequence> r12 = CharSequence.class;
        return new AnonymousClass2(r5, r12, r10, r11);
    }

    @Deprecated
    public static boolean performAccessibilityAction(@NonNull View r5, int r10, @Nullable Bundle r11) {
        return r5.performAccessibilityAction(r10, r11);
    }

    public static boolean performHapticFeedback(@NonNull View r5, int r10) {
        int r11 = HapticFeedbackConstantsCompat.getFeedbackConstantOrFallback(r10);
        if (r11 != (-1)) goto L7;
        return false;
    L7:
        return r5.performHapticFeedback(r11);
    }

    @Nullable
    public static ContentInfoCompat performReceiveContent(@NonNull View r5, @NonNull ContentInfoCompat r10) {
        if (Log.isLoggable(TAG, 3) == false) goto L6;
        Log.d(TAG, "performReceiveContent: " + r10 + ", view=" + r5.getClass().getSimpleName() + "[" + r5.getId() + "]");
    L6:
        return Api31Impl.performReceiveContent(r5, r10);
    }

    @Deprecated
    public static void postInvalidateOnAnimation(@NonNull View r5) {
        r5.postInvalidateOnAnimation();
    }

    @Deprecated
    public static void postOnAnimation(@NonNull View r5, @NonNull Runnable r10) {
        r5.postOnAnimation(r10);
    }

    @SuppressLint({"LambdaLast"})
    @Deprecated
    public static void postOnAnimationDelayed(@NonNull View r5, @NonNull Runnable r10, long r11) {
        r5.postOnAnimationDelayed(r10, r11);
    }

    public static void removeAccessibilityAction(@NonNull View r5, int r10) {
        removeActionWithId(r10, r5);
        notifyViewAccessibilityStateChangedIfNeeded(r5, 0);
    }

    private static void removeActionWithId(int r5, View r10) {
        List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> r11 = getActionList(r10);
        int r12 = 0;
    L4:
        if (r12 >= r11.size()) goto L12;
        if (r11.get(r12).getId() == r5) goto L7;
        r12 = r12 + 1;
        goto L4
    L7:
        r11.remove(r12);
        return;
    }

    public static void removeOnUnhandledKeyEventListener(@NonNull View r5, @NonNull OnUnhandledKeyEventListenerCompat r10) {
        Api28Impl.removeOnUnhandledKeyEventListener(r5, r10);
    }

    public static void replaceAccessibilityAction(@NonNull View r5, @NonNull AccessibilityNodeInfoCompat.AccessibilityActionCompat r10, @Nullable CharSequence r11, @Nullable AccessibilityViewCommand r12) {
        if (r12 != null) goto L5;
        if (r11 != null) goto L5;
        removeAccessibilityAction(r5, r10.getId());
        return;
    L5:
        addAccessibilityAction(r5, r10.createReplacementAction(r11, r12));
    }

    public static void requestApplyInsets(@NonNull View r5) {
        Api20Impl.requestApplyInsets(r5);
    }

    @NonNull
    public static <T extends View> T requireViewById(@NonNull View r5, @IdRes int r10) {
        return (T) Api28Impl.requireViewById(r5, r10);
    }

    @Deprecated
    public static int resolveSizeAndState(int r5, int r10, int r11) {
        return View.resolveSizeAndState(r5, r10, r11);
    }

    public static boolean restoreDefaultFocus(@NonNull View r5) {
        return Api26Impl.restoreDefaultFocus(r5);
    }

    public static void saveAttributeDataForStyleable(@NonNull View r5, @NonNull @SuppressLint({"ContextFirst"}) Context r10, @NonNull int[] r11, @Nullable AttributeSet r12, @NonNull TypedArray r13, int r14, int r15) {
        Api29Impl.saveAttributeDataForStyleable(r5, r10, r11, r12, r13, r14, r15);
    }

    private static AccessibilityViewProperty<Boolean> screenReaderFocusableProperty() {
        final int r5 = R.id.tag_screen_reader_focusable;
        final Class<Boolean> r10 = Boolean.class;
        final int r11 = 28;
        return new AnonymousClass1(r5, r10, r11);
    }

    public static void setAccessibilityDelegate(@NonNull View r5, @Nullable AccessibilityDelegateCompat r10) {
        if (r10 == null) goto L4;
    L6:
        setImportantForAccessibilityIfNeeded(r5);
        if (r10 != null) goto L9;
        View.AccessibilityDelegate r11 = null;
    L10:
        r5.setAccessibilityDelegate(r11);
        return;
    L9:
        r11 = r10.getBridge();
        goto L10
    L4:
        if ((getAccessibilityDelegateInternal(r5) instanceof AccessibilityDelegateCompat.AccessibilityDelegateAdapter) == false) goto L6;
        r10 = new AccessibilityDelegateCompat();
        goto L6
    }

    @UiThread
    public static void setAccessibilityHeading(@NonNull View r5, boolean r10) {
        accessibilityHeadingProperty().set(r5, Boolean.valueOf(r10));
    }

    @Deprecated
    public static void setAccessibilityLiveRegion(@NonNull View r5, int r10) {
        r5.setAccessibilityLiveRegion(r10);
    }

    @UiThread
    public static void setAccessibilityPaneTitle(@NonNull View r5, @Nullable CharSequence r10) {
        paneTitleProperty().set(r5, r10);
        if (r10 == null) goto L5;
        sAccessibilityPaneVisibilityManager.addAccessibilityPane(r5);
        return;
    L5:
        sAccessibilityPaneVisibilityManager.removeAccessibilityPane(r5);
    }

    @Deprecated
    public static void setActivated(View r5, boolean r10) {
        r5.setActivated(r10);
    }

    @Deprecated
    public static void setAlpha(View r5, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float r10) {
        r5.setAlpha(r10);
    }

    public static void setAutofillHints(@NonNull View r5, @Nullable String... r10) {
        Api26Impl.setAutofillHints(r5, r10);
    }

    public static void setAutofillId(@NonNull View r5, @Nullable AutofillIdCompat r10) {
        Api28Impl.setAutofillId(r5, r10);
    }

    @Deprecated
    public static void setBackground(@NonNull View r5, @Nullable Drawable r10) {
        r5.setBackground(r10);
    }

    public static void setBackgroundTintList(@NonNull View r5, @Nullable ColorStateList r10) {
        Api21Impl.setBackgroundTintList(r5, r10);
    }

    public static void setBackgroundTintMode(@NonNull View r5, @Nullable PorterDuff.Mode r10) {
        Api21Impl.setBackgroundTintMode(r5, r10);
    }

    @SuppressLint({"BanUncheckedReflection"})
    @Deprecated
    public static void setChildrenDrawingOrderEnabled(ViewGroup r5, boolean r10) {
        if (sChildrenDrawingOrderMethod != null) goto L23;
        sChildrenDrawingOrderMethod = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", new Class[]{Boolean.TYPE});     // Catch: NoSuchMethodException -> L6
    L8:
        sChildrenDrawingOrderMethod.setAccessible(true);
    L6:
        e = move-exception;
        Log.e(TAG, "Unable to find childrenDrawingOrderEnabled", e);
    L23:
        sChildrenDrawingOrderMethod.invoke(r5, new Object[]{Boolean.valueOf(r10)});     // Catch: InvocationTargetException -> L11 IllegalArgumentException -> L13 IllegalAccessException -> L15
    L27:
        return;
    L15:
        e = move-exception;
        Log.e(TAG, "Unable to invoke childrenDrawingOrderEnabled", e);
        return;
    L13:
        e = move-exception;
        Log.e(TAG, "Unable to invoke childrenDrawingOrderEnabled", e);
        return;
    L11:
        e = move-exception;
        Log.e(TAG, "Unable to invoke childrenDrawingOrderEnabled", e);
    }

    @Deprecated
    public static void setClipBounds(@NonNull View r5, @Nullable Rect r10) {
        r5.setClipBounds(r10);
    }

    public static void setContentCaptureSession(@NonNull View r5, @Nullable ContentCaptureSessionCompat r10) {
        Api29Impl.setContentCaptureSession(r5, r10);
    }

    public static void setElevation(@NonNull View r5, float r10) {
        Api21Impl.setElevation(r5, r10);
    }

    @Deprecated
    public static void setFitsSystemWindows(View r5, boolean r10) {
        r5.setFitsSystemWindows(r10);
    }

    public static void setFocusedByDefault(@NonNull View r5, boolean r10) {
        Api26Impl.setFocusedByDefault(r5, r10);
    }

    @Deprecated
    public static void setHasTransientState(@NonNull View r5, boolean r10) {
        r5.setHasTransientState(r10);
    }

    @UiThread
    @Deprecated
    public static void setImportantForAccessibility(@NonNull View r5, int r10) {
        r5.setImportantForAccessibility(r10);
    }

    private static void setImportantForAccessibilityIfNeeded(View r5) {
        if (r5.getImportantForAccessibility() != 0) goto L6;
        r5.setImportantForAccessibility(1);
        return;
    }

    public static void setImportantForAutofill(@NonNull View r5, int r10) {
        Api26Impl.setImportantForAutofill(r5, r10);
    }

    public static void setImportantForContentCapture(@NonNull View r5, int r10) {
        Api30Impl.setImportantForContentCapture(r5, r10);
    }

    public static void setKeyboardNavigationCluster(@NonNull View r5, boolean r10) {
        Api26Impl.setKeyboardNavigationCluster(r5, r10);
    }

    @Deprecated
    public static void setLabelFor(@NonNull View r5, @IdRes int r10) {
        r5.setLabelFor(r10);
    }

    @Deprecated
    public static void setLayerPaint(@NonNull View r5, @Nullable Paint r10) {
        r5.setLayerPaint(r10);
    }

    @Deprecated
    public static void setLayerType(View r5, int r10, Paint r11) {
        r5.setLayerType(r10, r11);
    }

    @Deprecated
    public static void setLayoutDirection(@NonNull View r5, int r10) {
        r5.setLayoutDirection(r10);
    }

    public static void setNestedScrollingEnabled(@NonNull View r5, boolean r10) {
        Api21Impl.setNestedScrollingEnabled(r5, r10);
    }

    public static void setNextClusterForwardId(@NonNull View r5, int r10) {
        Api26Impl.setNextClusterForwardId(r5, r10);
    }

    public static void setOnApplyWindowInsetsListener(@NonNull View r5, @Nullable OnApplyWindowInsetsListener r10) {
        Api21Impl.setOnApplyWindowInsetsListener(r5, r10);
    }

    public static void setOnReceiveContentListener(@NonNull View r5, @Nullable String[] r10, @Nullable OnReceiveContentListener r11) {
        Api31Impl.setOnReceiveContentListener(r5, r10, r11);
    }

    @Deprecated
    public static void setOverScrollMode(View r5, int r10) {
        r5.setOverScrollMode(r10);
    }

    @Deprecated
    public static void setPaddingRelative(@NonNull View r5, @Px int r10, @Px int r11, @Px int r12, @Px int r13) {
        r5.setPaddingRelative(r10, r11, r12, r13);
    }

    @Deprecated
    public static void setPivotX(View r5, float r10) {
        r5.setPivotX(r10);
    }

    @Deprecated
    public static void setPivotY(View r5, float r10) {
        r5.setPivotY(r10);
    }

    public static void setPointerIcon(@NonNull View r5, @Nullable PointerIconCompat r10) {
        if (r10 == null) goto L4;
        Object r11 = r10.getPointerIcon();
    L5:
        Api24Impl.setPointerIcon(r5, (PointerIcon) r11);
        return;
    L4:
        r11 = null;
        goto L5
    }

    @Deprecated
    public static void setRotation(View r5, float r10) {
        r5.setRotation(r10);
    }

    @Deprecated
    public static void setRotationX(View r5, float r10) {
        r5.setRotationX(r10);
    }

    @Deprecated
    public static void setRotationY(View r5, float r10) {
        r5.setRotationY(r10);
    }

    @Deprecated
    public static void setSaveFromParentEnabled(View r5, boolean r10) {
        r5.setSaveFromParentEnabled(r10);
    }

    @Deprecated
    public static void setScaleX(View r5, float r10) {
        r5.setScaleX(r10);
    }

    @Deprecated
    public static void setScaleY(View r5, float r10) {
        r5.setScaleY(r10);
    }

    @UiThread
    public static void setScreenReaderFocusable(@NonNull View r5, boolean r10) {
        screenReaderFocusableProperty().set(r5, Boolean.valueOf(r10));
    }

    public static void setScrollIndicators(@NonNull View r5, int r10) {
        Api23Impl.setScrollIndicators(r5, r10);
    }

    @UiThread
    public static void setStateDescription(@NonNull View r5, @Nullable CharSequence r10) {
        stateDescriptionProperty().set(r5, r10);
    }

    public static void setSystemGestureExclusionRects(@NonNull View r5, @NonNull List<Rect> r10) {
        Api29Impl.setSystemGestureExclusionRects(r5, r10);
    }

    public static void setTooltipText(@NonNull View r5, @Nullable CharSequence r10) {
        Api26Impl.setTooltipText(r5, r10);
    }

    public static void setTransitionName(@NonNull View r5, @Nullable String r10) {
        Api21Impl.setTransitionName(r5, r10);
    }

    @Deprecated
    public static void setTranslationX(View r5, float r10) {
        r5.setTranslationX(r10);
    }

    @Deprecated
    public static void setTranslationY(View r5, float r10) {
        r5.setTranslationY(r10);
    }

    public static void setTranslationZ(@NonNull View r5, float r10) {
        Api21Impl.setTranslationZ(r5, r10);
    }

    public static void setWindowInsetsAnimationCallback(@NonNull View r5, @Nullable WindowInsetsAnimationCompat.Callback r10) {
        WindowInsetsAnimationCompat.setCallback(r5, r10);
    }

    @Deprecated
    public static void setX(View r5, float r10) {
        r5.setX(r10);
    }

    @Deprecated
    public static void setY(View r5, float r10) {
        r5.setY(r10);
    }

    public static void setZ(@NonNull View r5, float r10) {
        Api21Impl.setZ(r5, r10);
    }

    public static boolean startDragAndDrop(@NonNull View r5, @Nullable ClipData r10, @NonNull View.DragShadowBuilder r11, @Nullable Object r12, int r13) {
        return Api24Impl.startDragAndDrop(r5, r10, r11, r12, r13);
    }

    public static boolean startNestedScroll(@NonNull View r5, int r10) {
        return Api21Impl.startNestedScroll(r5, r10);
    }

    private static AccessibilityViewProperty<CharSequence> stateDescriptionProperty() {
        final int r5 = R.id.tag_state_description;
        final int r10 = 64;
        final int r11 = 30;
        final Class<CharSequence> r12 = CharSequence.class;
        return new AnonymousClass3(r5, r12, r10, r11);
    }

    public static void stopNestedScroll(@NonNull View r5) {
        Api21Impl.stopNestedScroll(r5);
    }

    private static void tickleInvalidationFlag(View r5) {
        float r10 = r5.getTranslationY();
        r5.setTranslationY(1.0f + r10);
        r5.setTranslationY(r10);
    }

    public static void updateDragShadow(@NonNull View r5, @NonNull View.DragShadowBuilder r10) {
        Api24Impl.updateDragShadow(r5, r10);
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
    public static boolean hasNestedScrollingParent(@NonNull View r5, int r10) {
        if ((r5 instanceof NestedScrollingChild2) == false) goto L5;
        ((NestedScrollingChild2) r5).hasNestedScrollingParent(r10);
        return false;
    L5:
        if (r10 == 0) goto L7;
        return false;
    L7:
        return hasNestedScrollingParent(r5);
    }

    @Deprecated
    public static void postInvalidateOnAnimation(@NonNull View r5, int r10, int r11, int r12, int r13) {
        r5.postInvalidateOnAnimation(r10, r11, r12, r13);
    }

    public static void setScrollIndicators(@NonNull View r5, int r10, int r11) {
        Api23Impl.setScrollIndicators(r5, r10, r11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean startNestedScroll(@NonNull View r5, int r10, int r11) {
        if ((r5 instanceof NestedScrollingChild2) == true) goto L5;
        if (r11 == 0) goto L8;
        return false;
    L8:
        return startNestedScroll(r5, r10);
    L5:
        return ((NestedScrollingChild2) r5).startNestedScroll(r10, r11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void stopNestedScroll(@NonNull View r5, int r10) {
        if ((r5 instanceof NestedScrollingChild2) == false) goto L5;
        ((NestedScrollingChild2) r5).stopNestedScroll(r10);
        return;
    L5:
        if (r10 != 0) goto L9;
        stopNestedScroll(r5);
        return;
    }

    public static boolean performHapticFeedback(@NonNull View r5, int r10, int r11) {
        int r12 = HapticFeedbackConstantsCompat.getFeedbackConstantOrFallback(r10);
        if (r12 != (-1)) goto L7;
        return false;
    L7:
        return r5.performHapticFeedback(r12, r11);
    }

    private static void addAccessibilityAction(@NonNull View r5, @NonNull AccessibilityNodeInfoCompat.AccessibilityActionCompat r10) {
        ensureAccessibilityDelegateCompat(r5);
        removeActionWithId(r10.getId(), r5);
        getActionList(r5).add(r10);
        notifyViewAccessibilityStateChangedIfNeeded(r5, 0);
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
}
