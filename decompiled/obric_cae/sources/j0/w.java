package j0;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeProvider;
import com.obric.cae.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"PrivateConstructorForUtilityClass"})
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static WeakHashMap<View, h0> f8437a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f8438b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f8439c = null;

    public static class a implements ViewTreeObserver.OnGlobalLayoutListener, View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakHashMap<View, Boolean> f8440a;

        public a() {
            this.f8440a = new WeakHashMap();
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r8) {
            r8.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r8) {
        }
    }

    public static abstract class b<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f8441a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Class<T> f8442b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f8443c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f8444d;

        public b(int r8, Class<T> r10, int r11, int r12) {
            this.f8441a = r8;
            this.f8442b = r10;
            this.f8444d = r11;
            this.f8443c = r12;
        }

        public static boolean a(Boolean r8, Boolean r10) {
            if (r8 != null) goto L5;
        L7:
            boolean r11 = false;
        L8:
            if (r10 != null) goto L10;
        L12:
            boolean r12 = false;
        L13:
            if (r11 != r12) goto L16;
            return true;
        L16:
            return false;
        L10:
            if (r10.booleanValue() == false) goto L12;
            r12 = true;
            goto L13
        L5:
            if (r8.booleanValue() == false) goto L7;
            r11 = true;
            goto L8
        }

        public abstract T b(View r8);

        public abstract void c(View r8, T r10);

        public final T d(View r8) {
            if (Build.VERSION.SDK_INT < this.f8443c) goto L5;
            boolean r10 = true;
        L6:
            if (r10 == true) goto L8;
            T r11 = (T) r8.getTag(this.f8441a);
            if (this.f8442b.isInstance(r11) == false) goto L12;
            return r11;
        L12:
            return null;
        L8:
            return b(r8);
        L5:
            r10 = false;
            goto L6
        }

        public final void e(View r8, T r10) {
            if (Build.VERSION.SDK_INT < this.f8443c) goto L5;
            boolean r11 = true;
        L6:
            if (r11 == false) goto L9;
            c(r8, r10);
            return;
        L9:
            if (f(d(r8), r10) == false) goto L22;
            WeakHashMap<View, h0> r12 = w.f8437a;
            View.AccessibilityDelegate r13 = m.a(r8);
            if (r13 != null) goto L14;
            j0.a r14 = null;
        L17:
            if (r14 != null) goto L19;
            r14 = new j0.a();
        L19:
            w.m(r8, r14);
            r8.setTag(this.f8441a, r10);
            w.i(r8, this.f8444d);
            return;
        L14:
            if ((r13 instanceof j0.a.C0095a) == false) goto L16;
            r14 = ((j0.a.C0095a) r13).f8372a;
            goto L17
        L16:
            r14 = new j0.a(r13);
            goto L17
        L22:
            return;
        L5:
            r11 = false;
            goto L6
        }

        public abstract boolean f(T r8, T r10);
    }

    public static class c {
        public static boolean a(View r8) {
            return r8.hasOnClickListeners();
        }
    }

    public static class d {
        public static AccessibilityNodeProvider a(View r8) {
            return r8.getAccessibilityNodeProvider();
        }

        public static boolean b(View r8) {
            return r8.getFitsSystemWindows();
        }

        public static int c(View r8) {
            return r8.getImportantForAccessibility();
        }

        public static int d(View r8) {
            return r8.getMinimumHeight();
        }

        public static int e(View r8) {
            return r8.getMinimumWidth();
        }

        public static ViewParent f(View r8) {
            return r8.getParentForAccessibility();
        }

        public static int g(View r8) {
            return r8.getWindowSystemUiVisibility();
        }

        public static boolean h(View r8) {
            return r8.hasOverlappingRendering();
        }

        public static boolean i(View r8) {
            return r8.hasTransientState();
        }

        public static boolean j(View r8, int r10, Bundle r11) {
            return r8.performAccessibilityAction(r10, r11);
        }

        public static void k(View r8) {
            r8.postInvalidateOnAnimation();
        }

        public static void l(View r8, int r10, int r11, int r12, int r13) {
            r8.postInvalidateOnAnimation(r10, r11, r12, r13);
        }

        public static void m(View r8, Runnable r10) {
            r8.postOnAnimation(r10);
        }

        public static void n(View r8, Runnable r10, long r11) {
            r8.postOnAnimationDelayed(r10, r11);
        }

        public static void o(ViewTreeObserver r8, ViewTreeObserver.OnGlobalLayoutListener r10) {
            r8.removeOnGlobalLayoutListener(r10);
        }

        public static void p(View r8) {
            r8.requestFitSystemWindows();
        }

        public static void q(View r8, Drawable r10) {
            r8.setBackground(r10);
        }

        public static void r(View r8, boolean r10) {
            r8.setHasTransientState(r10);
        }

        public static void s(View r8, int r10) {
            r8.setImportantForAccessibility(r10);
        }
    }

    public static class e {
        public static int a() {
            return View.generateViewId();
        }

        public static Display b(View r8) {
            return r8.getDisplay();
        }

        public static int c(View r8) {
            return r8.getLabelFor();
        }

        public static int d(View r8) {
            return r8.getLayoutDirection();
        }

        public static int e(View r8) {
            return r8.getPaddingEnd();
        }

        public static int f(View r8) {
            return r8.getPaddingStart();
        }

        public static boolean g(View r8) {
            return r8.isPaddingRelative();
        }

        public static void h(View r8, int r10) {
            r8.setLabelFor(r10);
        }

        public static void i(View r8, Paint r10) {
            r8.setLayerPaint(r10);
        }

        public static void j(View r8, int r10) {
            r8.setLayoutDirection(r10);
        }

        public static void k(View r8, int r10, int r11, int r12, int r13) {
            r8.setPaddingRelative(r10, r11, r12, r13);
        }
    }

    public static class f {
        public static Rect a(View r8) {
            return r8.getClipBounds();
        }

        public static boolean b(View r8) {
            return r8.isInLayout();
        }

        public static void c(View r8, Rect r10) {
            r8.setClipBounds(r10);
        }
    }

    public static class g {
        public static int a(View r8) {
            return r8.getAccessibilityLiveRegion();
        }

        public static boolean b(View r8) {
            return r8.isAttachedToWindow();
        }

        public static boolean c(View r8) {
            return r8.isLaidOut();
        }

        public static boolean d(View r8) {
            return r8.isLayoutDirectionResolved();
        }

        public static void e(ViewParent r8, View r10, View r11, int r12) {
            r8.notifySubtreeAccessibilityStateChanged(r10, r11, r12);
        }

        public static void f(View r8, int r10) {
            r8.setAccessibilityLiveRegion(r10);
        }

        public static void g(AccessibilityEvent r8, int r10) {
            r8.setContentChangeTypes(r10);
        }
    }

    public static class h {
        public static WindowInsets a(View r8, WindowInsets r10) {
            return r8.dispatchApplyWindowInsets(r10);
        }

        public static WindowInsets b(View r8, WindowInsets r10) {
            return r8.onApplyWindowInsets(r10);
        }

        public static void c(View r8) {
            r8.requestApplyInsets();
        }
    }

    public static class i {

        public class a implements View.OnApplyWindowInsetsListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ q f8445a;

            public a(View r8, q r10) {
                this.f8445a = r10;
            }

            @Override // android.view.View.OnApplyWindowInsetsListener
            public WindowInsets onApplyWindowInsets(View r8, WindowInsets r10) {
                m0 r11 = m0.h(r8, r10);
                return this.f8445a.a(r8, r11).g();
            }
        }

        public static void a(WindowInsets r8, View r10) {
            View.OnApplyWindowInsetsListener r11 = (View.OnApplyWindowInsetsListener) r10.getTag(R.id.tag_window_insets_animation_callback);
            if (r11 == null) goto L6;
            r11.onApplyWindowInsets(r10, r8);
            return;
        }

        public static m0 b(View r8, m0 r10, Rect r11) {
            WindowInsets r12 = r10.g();
            if (r12 != null) goto L5;
            r11.setEmpty();
            return r10;
        L5:
            return m0.h(r8, r8.computeSystemWindowInsets(r12, r11));
        }

        public static boolean c(View r8, float r10, float r11, boolean r12) {
            return r8.dispatchNestedFling(r10, r11, r12);
        }

        public static boolean d(View r8, float r10, float r11) {
            return r8.dispatchNestedPreFling(r10, r11);
        }

        public static boolean e(View r8, int r10, int r11, int[] r12, int[] r13) {
            return r8.dispatchNestedPreScroll(r10, r11, r12, r13);
        }

        public static boolean f(View r8, int r10, int r11, int r12, int r13, int[] r14) {
            return r8.dispatchNestedScroll(r10, r11, r12, r13, r14);
        }

        public static ColorStateList g(View r8) {
            return r8.getBackgroundTintList();
        }

        public static PorterDuff.Mode h(View r8) {
            return r8.getBackgroundTintMode();
        }

        public static float i(View r8) {
            return r8.getElevation();
        }

        public static m0 j(View r8) {
            if (m0.a.f8413d == true) goto L5;
        L17:
            return null;
        L5:
            if (r8.isAttachedToWindow() == false) goto L17;
            Object r10 = m0.a.f8410a.get(r8.getRootView());     // Catch: IllegalAccessException -> L15
            if (r10 == null) goto L17;
            Rect r11 = (Rect) m0.a.f8411b.get(r10);     // Catch: IllegalAccessException -> L15
            Rect r12 = (Rect) m0.a.f8412c.get(r10);     // Catch: IllegalAccessException -> L15
            if (r11 == null) goto L17;
            if (r12 == null) goto L17;
            m0.b r13 = new m0.b();     // Catch: IllegalAccessException -> L15
            m0.d r14 = r13.f8414a;     // Catch: IllegalAccessException -> L15
            r14.g(a0.b.b(r11.left, r11.top, r11.right, r11.bottom));     // Catch: IllegalAccessException -> L15
            r14.d(a0.b.b(r12.left, r12.top, r12.right, r12.bottom));     // Catch: IllegalAccessException -> L15
            m0 r15 = r13.a();     // Catch: IllegalAccessException -> L15
            r15.f8409a.p(r15);     // Catch: IllegalAccessException -> L15
            r15.f8409a.d(r8.getRootView());     // Catch: IllegalAccessException -> L15
            return r15;
        L15:
            e = move-exception;
            Log.w("WindowInsetsCompat", "Failed to get insets from AttachInfo. " + e.getMessage(), e);
            goto L17
        }

        public static String k(View r8) {
            return r8.getTransitionName();
        }

        public static float l(View r8) {
            return r8.getTranslationZ();
        }

        public static float m(View r8) {
            return r8.getZ();
        }

        public static boolean n(View r8) {
            return r8.hasNestedScrollingParent();
        }

        public static boolean o(View r8) {
            return r8.isImportantForAccessibility();
        }

        public static boolean p(View r8) {
            return r8.isNestedScrollingEnabled();
        }

        public static void q(View r8, ColorStateList r10) {
            r8.setBackgroundTintList(r10);
        }

        public static void r(View r8, PorterDuff.Mode r10) {
            r8.setBackgroundTintMode(r10);
        }

        public static void s(View r8, float r10) {
            r8.setElevation(r10);
        }

        public static void t(View r8, boolean r10) {
            r8.setNestedScrollingEnabled(r10);
        }

        public static void u(View r8, q r10) {
            if (r10 != null) goto L5;
            r8.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) r8.getTag(R.id.tag_window_insets_animation_callback));
            return;
        L5:
            r8.setOnApplyWindowInsetsListener(new a(r8, r10));
        }

        public static void v(View r8, String r10) {
            r8.setTransitionName(r10);
        }

        public static void w(View r8, float r10) {
            r8.setTranslationZ(r10);
        }

        public static void x(View r8, float r10) {
            r8.setZ(r10);
        }

        public static boolean y(View r8, int r10) {
            return r8.startNestedScroll(r10);
        }

        public static void z(View r8) {
            r8.stopNestedScroll();
        }
    }

    public static class j {
        public static m0 a(View r8) {
            WindowInsets r10 = r8.getRootWindowInsets();
            if (r10 != null) goto L5;
            return null;
        L5:
            m0 r11 = m0.h(null, r10);
            m0.k r12 = r11.f8409a;
            r12.p(r11);
            r12.d(r8.getRootView());
            return r11;
        }

        public static int b(View r8) {
            return r8.getScrollIndicators();
        }

        public static void c(View r8, int r10) {
            r8.setScrollIndicators(r10);
        }

        public static void d(View r8, int r10, int r11) {
            r8.setScrollIndicators(r10, r11);
        }
    }

    public static class k {
        public static void a(View r8, Collection<View> r10, int r11) {
            r8.addKeyboardNavigationClusters(r10, r11);
        }

        public static int b(View r8) {
            return r8.getImportantForAutofill();
        }

        public static int c(View r8) {
            return r8.getNextClusterForwardId();
        }

        public static boolean d(View r8) {
            return r8.hasExplicitFocusable();
        }

        public static boolean e(View r8) {
            return r8.isFocusedByDefault();
        }

        public static boolean f(View r8) {
            return r8.isImportantForAutofill();
        }

        public static boolean g(View r8) {
            return r8.isKeyboardNavigationCluster();
        }

        public static View h(View r8, View r10, int r11) {
            return r8.keyboardNavigationClusterSearch(r10, r11);
        }

        public static boolean i(View r8) {
            return r8.restoreDefaultFocus();
        }

        public static void j(View r8, String... r10) {
            r8.setAutofillHints(r10);
        }

        public static void k(View r8, boolean r10) {
            r8.setFocusedByDefault(r10);
        }

        public static void l(View r8, int r10) {
            r8.setImportantForAutofill(r10);
        }

        public static void m(View r8, boolean r10) {
            r8.setKeyboardNavigationCluster(r10);
        }

        public static void n(View r8, int r10) {
            r8.setNextClusterForwardId(r10);
        }

        public static void o(View r8, CharSequence r10) {
            r8.setTooltipText(r10);
        }
    }

    public static class l {
        public static void a(View r8, final o r10) {
            n.h r11 = (n.h) r8.getTag(R.id.tag_unhandled_key_listeners);
            if (r11 != null) goto L5;
            r11 = new n.h();
            r8.setTag(R.id.tag_unhandled_key_listeners, r11);
        L5:
            Objects.requireNonNull(r10);
            View.OnUnhandledKeyEventListener r12 = new x(r10);
            r11.put(r10, r12);
            r8.addOnUnhandledKeyEventListener(r12);
        }

        public static CharSequence b(View r8) {
            return r8.getAccessibilityPaneTitle();
        }

        public static boolean c(View r8) {
            return r8.isAccessibilityHeading();
        }

        public static boolean d(View r8) {
            return r8.isScreenReaderFocusable();
        }

        public static void e(View r8, o r10) {
            n.h r11 = (n.h) r8.getTag(R.id.tag_unhandled_key_listeners);
            if (r11 != null) goto L5;
            return;
        L5:
            View.OnUnhandledKeyEventListener r12 = (View.OnUnhandledKeyEventListener) r11.getOrDefault(r10, null);
            if (r12 == null) goto L9;
            r8.removeOnUnhandledKeyEventListener(r12);
            return;
        }

        public static <T> T f(View r8, int r10) {
            return (T) r8.requireViewById(r10);
        }

        public static void g(View r8, boolean r10) {
            r8.setAccessibilityHeading(r10);
        }

        public static void h(View r8, CharSequence r10) {
            r8.setAccessibilityPaneTitle(r10);
        }

        public static void i(View r8, boolean r10) {
            r8.setScreenReaderFocusable(r10);
        }
    }

    public static class m {
        public static View.AccessibilityDelegate a(View r8) {
            return r8.getAccessibilityDelegate();
        }

        public static List<Rect> b(View r8) {
            return r8.getSystemGestureExclusionRects();
        }

        public static void c(View r8, Context r10, int[] r11, AttributeSet r12, TypedArray r13, int r14, int r15) {
            r8.saveAttributeDataForStyleable(r10, r11, r12, r13, r14, r15);
        }

        public static void d(View r8, List<Rect> r10) {
            r8.setSystemGestureExclusionRects(r10);
        }
    }

    public static class n {
        public static CharSequence a(View r8) {
            return r8.getStateDescription();
        }

        public static n0 b(View r8) {
            WindowInsetsController r10 = r8.getWindowInsetsController();
            if (r10 != null) goto L7;
            return null;
        L7:
            return new n0(r10);
        }

        public static void c(View r8, CharSequence r10) {
            r8.setStateDescription(r10);
        }
    }

    public interface o {
        boolean a();
    }

    static {
        new AtomicInteger(1);
        f8437a = null;
        f8438b = new int[]{R.id.accessibility_custom_action_0, R.id.accessibility_custom_action_1, R.id.accessibility_custom_action_2, R.id.accessibility_custom_action_3, R.id.accessibility_custom_action_4, R.id.accessibility_custom_action_5, R.id.accessibility_custom_action_6, R.id.accessibility_custom_action_7, R.id.accessibility_custom_action_8, R.id.accessibility_custom_action_9, R.id.accessibility_custom_action_10, R.id.accessibility_custom_action_11, R.id.accessibility_custom_action_12, R.id.accessibility_custom_action_13, R.id.accessibility_custom_action_14, R.id.accessibility_custom_action_15, R.id.accessibility_custom_action_16, R.id.accessibility_custom_action_17, R.id.accessibility_custom_action_18, R.id.accessibility_custom_action_19, R.id.accessibility_custom_action_20, R.id.accessibility_custom_action_21, R.id.accessibility_custom_action_22, R.id.accessibility_custom_action_23, R.id.accessibility_custom_action_24, R.id.accessibility_custom_action_25, R.id.accessibility_custom_action_26, R.id.accessibility_custom_action_27, R.id.accessibility_custom_action_28, R.id.accessibility_custom_action_29, R.id.accessibility_custom_action_30, R.id.accessibility_custom_action_31};
        new defpackage.a();
        f8439c = new a();
    }

    public static h0 a(View r8) {
        if (f8437a != null) goto L5;
        f8437a = new WeakHashMap();
    L5:
        h0 r10 = f8437a.get(r8);
        if (r10 != null) goto L9;
        h0 r11 = new h0(r8);
        f8437a.put(r8, r11);
        return r11;
    L9:
        return r10;
    }

    public static m0 b(View r8, m0 r10) {
        WindowInsets r11 = r10.g();
        if (r11 == null) goto L8;
        WindowInsets r12 = h.a(r8, r11);
        if (r12.equals(r11) == true) goto L8;
        return m0.h(r8, r12);
    L8:
        return r10;
    }

    public static CharSequence c(View r8) {
        return new t().d(r8);
    }

    public static ArrayList d(View r8) {
        ArrayList r10 = (ArrayList) r8.getTag(R.id.tag_accessibility_actions);
        if (r10 != null) goto L6;
        ArrayList r11 = new ArrayList();
        r8.setTag(R.id.tag_accessibility_actions, r11);
        return r11;
    L6:
        return r10;
    }

    public static boolean e(View r8) {
        return d.b(r8);
    }

    public static int f(View r8) {
        return e.d(r8);
    }

    public static int g(View r8) {
        return d.d(r8);
    }

    public static String h(View r8) {
        return i.k(r8);
    }

    public static void i(View r8, int r10) {
        AccessibilityManager r11 = (AccessibilityManager) r8.getContext().getSystemService("accessibility");
        if (r11.isEnabled() == true) goto L6;
        return;
    L6:
        if (c(r8) != null) goto L8;
    L12:
        boolean r12 = false;
    L13:
        int r13 = 32;
        if (g.a(r8) != 0) goto L26;
        if (r12 == true) goto L26;
        if (r10 != 32) goto L20;
        AccessibilityEvent r14 = AccessibilityEvent.obtain();
        r8.onInitializeAccessibilityEvent(r14);
        r14.setEventType(32);
        g.g(r14, r10);
        r14.setSource(r8);
        r8.onPopulateAccessibilityEvent(r14);
        r14.getText().add(c(r8));
        r11.sendAccessibilityEvent(r14);
        return;
    L20:
        if (r8.getParent() != null) goto L44;
        return;
    L44:
        g.e(r8.getParent(), r8, r8, r10);     // Catch: AbstractMethodError -> L24
        return;
    L24:
        e = move-exception;
        Log.e("ViewCompat", r8.getParent().getClass().getSimpleName().concat(" does not fully implement ViewParent"), e);
        return;
    L26:
        AccessibilityEvent r15 = AccessibilityEvent.obtain();
        if (r12 == true) goto L30;
        r13 = 2048;
    L30:
        r15.setEventType(r13);
        g.g(r15, r10);
        if (r12 == false) goto L42;
        r15.getText().add(c(r8));
        if (d.c(r8) != 0) goto L35;
        d.s(r8, 1);
    L35:
        ViewParent r16 = r8.getParent();
    L37:
        if ((r16 instanceof View) == false) goto L42;
        if (d.c((View) r16) == 4) goto L40;
        r16 = r16.getParent();
        goto L37
    L40:
        d.s(r8, 2);
    L42:
        r8.sendAccessibilityEventUnchecked(r15);
        return;
    L8:
        if (r8.isShown() == false) goto L12;
        if (r8.getWindowVisibility() != 0) goto L12;
        r12 = true;
        goto L13
    }

    public static m0 j(View r8, m0 r10) {
        WindowInsets r11 = r10.g();
        if (r11 == null) goto L8;
        WindowInsets r12 = h.b(r8, r11);
        if (r12.equals(r11) == true) goto L8;
        return m0.h(r8, r12);
    L8:
        return r10;
    }

    public static void k(View r8, int r10) {
        ArrayList r11 = d(r8);
        int r12 = 0;
    L4:
        if (r12 >= r11.size()) goto L12;
        if (((k0.f.a) r11.get(r12)).a() == r10) goto L7;
        r12 = r12 + 1;
        goto L4
    L7:
        r11.remove(r12);
        return;
    }

    public static void l(View r8, k0.f.a r10, k0.j r11) {
        k0.f.a r12 = new k0.f.a(null, r10.f8902b, null, r11, r10.f8903c);
        View.AccessibilityDelegate r13 = m.a(r8);
        if (r13 != null) goto L6;
        j0.a r14 = null;
    L9:
        if (r14 != null) goto L11;
        r14 = new j0.a();
    L11:
        m(r8, r14);
        k(r8, r12.a());
        d(r8).add(r12);
        i(r8, 0);
        return;
    L6:
        if ((r13 instanceof j0.a.C0095a) == false) goto L8;
        r14 = ((j0.a.C0095a) r13).f8372a;
        goto L9
    L8:
        r14 = new j0.a(r13);
        goto L9
    }

    public static void m(View r8, j0.a r10) {
        if (r10 == null) goto L4;
    L6:
        if (r10 != null) goto L8;
        j0.a.C0095a r11 = null;
    L9:
        r8.setAccessibilityDelegate(r11);
        return;
    L8:
        r11 = r10.f8371b;
        goto L9
    L4:
        if ((m.a(r8) instanceof j0.a.C0095a) == false) goto L6;
        r10 = new j0.a();
        goto L6
    }

    public static void n(View r8, CharSequence r10) {
        new t().e(r8, r10);
        a r11 = f8439c;
        if (r10 == null) goto L13;
        WeakHashMap<View, Boolean> r12 = r11.f8440a;
        if (r8.isShown() == true) goto L7;
    L9:
        boolean r13 = false;
    L10:
        r12.put(r8, Boolean.valueOf(r13));
        r8.addOnAttachStateChangeListener(r11);
        if (g.b(r8) == false) goto L15;
        r8.getViewTreeObserver().addOnGlobalLayoutListener(r11);
        return;
    L15:
        return;
    L7:
        if (r8.getWindowVisibility() != 0) goto L9;
        r13 = true;
        goto L10
    L13:
        r11.f8440a.remove(r8);
        r8.removeOnAttachStateChangeListener(r11);
        d.o(r8.getViewTreeObserver(), r11);
    }

    public static void o(View r8, boolean r10) {
        d.r(r8, r10);
    }
}
