package com.obric.oui.view;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes5.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AtomicInteger f14820a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static WeakHashMap<View, ViewPropertyAnimatorCompat> f14821b;
    private static boolean c;
    private static final int[] d = null;
    private static a e;

    static class a implements View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private WeakHashMap<View, Boolean> f14822a;

        a() {
            this.f14822a = new WeakHashMap();
        }

        private void a(View r1) {
            r1.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }

        private void a(View r2, boolean r3) {
            if (r2.getVisibility() != 0) goto L5;
            boolean r0 = true;
        L6:
            if (r3 == r0) goto L12;
            if (r0 == false) goto L9;
            int r4 = 16;
        L10:
            d.b(r2, r4);
            this.f14822a.put(r2, Boolean.valueOf(r0));
            return;
        L9:
            r4 = 32;
            goto L10
        L12:
            return;
        L5:
            r0 = false;
            goto L6
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (Build.VERSION.SDK_INT >= 28) goto L8;
            Iterator<Map.Entry<View, Boolean>> r0 = this.f14822a.entrySet().iterator();
        L6:
            if (r0.hasNext() == false) goto L10;
            Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.memorydata.plugin");
            a((View) ZeusTransformUtils.preCheckCast(r1.getKey(), View.class, "com.obric.memorydata.plugin"), ((Boolean) ZeusTransformUtils.preCheckCast(r1.getValue(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue());
            goto L6
        L10:
            return;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View r1) {
            a(r1);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View r1) {
        }
    }

    static abstract class b<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f14823a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Class<T> f14824b;
        private final int c;
        private final int d;

        b(int r1, Class<T> r2, int r3, int r4) {
            this.f14823a = r1;
            this.f14824b = r2;
            this.d = r3;
            this.c = r4;
        }

        private boolean a() {
            if (Build.VERSION.SDK_INT < this.c) goto L5;
            return true;
        L5:
            return false;
        }

        private boolean b() {
            if (Build.VERSION.SDK_INT < 19) goto L5;
            return true;
        L5:
            return false;
        }

        abstract T b(View r1);

        T c(View r2) {
            if (a() == false) goto L7;
            return b(r2);
        L7:
            if (b() == false) goto L11;
            T r3 = (T) r2.getTag(this.f14823a);
            if (ZeusTransformUtils.instanceOf(this.f14824b, r3) == false) goto L13;
            return r3;
        L13:
            return null;
        L11:
            return null;
        }
    }

    private static class c {
        public static e a(View r0) {
            return e.a.a(r0);
        }

        static void a(final View r4, com.obric.oui.view.c r5) {
            final com.obric.oui.view.c r6 = (com.obric.oui.view.c) ZeusTransformUtils.wrapperContextForParams(r5, com.obric.oui.view.c.class, "com.obric.memorydata.plugin");
            if (Build.VERSION.SDK_INT >= 30) goto L5;
            r4.setTag(ZeusTransformUtils.mapRes(R.id.o_tag_on_apply_window_listener, OaidModel.KEY_ID, "o_tag_on_apply_window_listener"), r6);
        L5:
            if (r6 != null) goto L8;
            r4.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) ZeusTransformUtils.preCheckCast(r4.getTag(ZeusTransformUtils.mapRes(R.id.o_tag_window_insets_animation_callback, OaidModel.KEY_ID, "o_tag_window_insets_animation_callback")), View.OnApplyWindowInsetsListener.class, "com.obric.memorydata.plugin"));
            return;
        L8:
            r4.setOnApplyWindowInsetsListener(new AnonymousClass1(r4, r6));
        }

        static void a(WindowInsets r3, View r4) {
            View.OnApplyWindowInsetsListener r0 = (View.OnApplyWindowInsetsListener) ZeusTransformUtils.preCheckCast(r4.getTag(ZeusTransformUtils.mapRes(R.id.tag_window_insets_animation_callback, OaidModel.KEY_ID, "tag_window_insets_animation_callback")), View.OnApplyWindowInsetsListener.class, "com.obric.memorydata.plugin");
            if (r0 == null) goto L6;
            r0.onApplyWindowInsets(r4, r3);
            return;
        }
    }

    /* JADX INFO: renamed from: com.obric.oui.view.d$d, reason: collision with other inner class name */
    private static class C0790d {
        public static e a(View r1) {
            WindowInsets r0 = r1.getRootWindowInsets();
            if (r0 != null) goto L6;
            return null;
        L6:
            e r2 = e.a(r0);
            r2.a(r2);
            r2.a(r1.getRootView());
            return r2;
        }
    }

    static {
        f14820a = new AtomicInteger(1);
        f14821b = null;
        c = false;
        d = new int[]{ZeusTransformUtils.mapRes(R.id.accessibility_custom_action_0, OaidModel.KEY_ID, "accessibility_custom_action_0"), ZeusTransformUtils.mapRes(R.id.accessibility_custom_action_1, OaidModel.KEY_ID, "accessibility_custom_action_1"), ZeusTransformUtils.mapRes(R.id.accessibility_custom_action_2, OaidModel.KEY_ID, "accessibility_custom_action_2"), ZeusTransformUtils.mapRes(R.id.accessibility_custom_action_3, OaidModel.KEY_ID, "accessibility_custom_action_3"), ZeusTransformUtils.mapRes(R.id.accessibility_custom_action_4, OaidModel.KEY_ID, "accessibility_custom_action_4"), ZeusTransformUtils.mapRes(R.id.accessibility_custom_action_5, OaidModel.KEY_ID, "accessibility_custom_action_5"), ZeusTransformUtils.mapRes(R.id.accessibility_custom_action_6, OaidModel.KEY_ID, "accessibility_custom_action_6"), ZeusTransformUtils.mapRes(R.id.accessibility_custom_action_7, OaidModel.KEY_ID, "accessibility_custom_action_7"), ZeusTransformUtils.mapRes(R.id.accessibility_custom_action_8, OaidModel.KEY_ID, "accessibility_custom_action_8"), ZeusTransformUtils.mapRes(R.id.accessibility_custom_action_9, OaidModel.KEY_ID, "accessibility_custom_action_9"), ZeusTransformUtils.mapRes(R.id.accessibility_custom_action_10, OaidModel.KEY_ID, "accessibility_custom_action_10"), ZeusTransformUtils.mapRes(R.id.accessibility_custom_action_11, OaidModel.KEY_ID, "accessibility_custom_action_11"), ZeusTransformUtils.mapRes(R.id.accessibility_custom_action_12, OaidModel.KEY_ID, "accessibility_custom_action_12"), ZeusTransformUtils.mapRes(R.id.accessibility_custom_action_13, OaidModel.KEY_ID, "accessibility_custom_action_13"), ZeusTransformUtils.mapRes(R.id.accessibility_custom_action_14, OaidModel.KEY_ID, "accessibility_custom_action_14"), ZeusTransformUtils.mapRes(R.id.accessibility_custom_action_15, OaidModel.KEY_ID, "accessibility_custom_action_15"), ZeusTransformUtils.mapRes(R.id.accessibility_custom_action_16, OaidModel.KEY_ID, "accessibility_custom_action_16"), ZeusTransformUtils.mapRes(R.id.accessibility_custom_action_17, OaidModel.KEY_ID, "accessibility_custom_action_17"), ZeusTransformUtils.mapRes(R.id.accessibility_custom_action_18, OaidModel.KEY_ID, "accessibility_custom_action_18"), ZeusTransformUtils.mapRes(R.id.accessibility_custom_action_19, OaidModel.KEY_ID, "accessibility_custom_action_19"), ZeusTransformUtils.mapRes(R.id.accessibility_custom_action_20, OaidModel.KEY_ID, "accessibility_custom_action_20"), ZeusTransformUtils.mapRes(R.id.accessibility_custom_action_21, OaidModel.KEY_ID, "accessibility_custom_action_21"), ZeusTransformUtils.mapRes(R.id.accessibility_custom_action_22, OaidModel.KEY_ID, "accessibility_custom_action_22"), ZeusTransformUtils.mapRes(R.id.accessibility_custom_action_23, OaidModel.KEY_ID, "accessibility_custom_action_23"), ZeusTransformUtils.mapRes(R.id.accessibility_custom_action_24, OaidModel.KEY_ID, "accessibility_custom_action_24"), ZeusTransformUtils.mapRes(R.id.accessibility_custom_action_25, OaidModel.KEY_ID, "accessibility_custom_action_25"), ZeusTransformUtils.mapRes(R.id.accessibility_custom_action_26, OaidModel.KEY_ID, "accessibility_custom_action_26"), ZeusTransformUtils.mapRes(R.id.accessibility_custom_action_27, OaidModel.KEY_ID, "accessibility_custom_action_27"), ZeusTransformUtils.mapRes(R.id.accessibility_custom_action_28, OaidModel.KEY_ID, "accessibility_custom_action_28"), ZeusTransformUtils.mapRes(R.id.accessibility_custom_action_29, OaidModel.KEY_ID, "accessibility_custom_action_29"), ZeusTransformUtils.mapRes(R.id.accessibility_custom_action_30, OaidModel.KEY_ID, "accessibility_custom_action_30"), ZeusTransformUtils.mapRes(R.id.accessibility_custom_action_31, OaidModel.KEY_ID, "accessibility_custom_action_31")};
        e = new a();
    }

    public static int a(View r2) {
        if (Build.VERSION.SDK_INT >= 16) goto L5;
        return 0;
    L5:
        return r2.getImportantForAccessibility();
    }

    private static b<CharSequence> a() {
        final int r1 = ZeusTransformUtils.mapRes(R.id.tag_accessibility_pane_title, OaidModel.KEY_ID, "tag_accessibility_pane_title");
        final Class<CharSequence> r2 = CharSequence.class;
        final int r3 = 8;
        final int r4 = 28;
        return new AnonymousClass1(r1, r2, r3, r4);
    }

    public static void a(View r2, int r3) {
        if (Build.VERSION.SDK_INT < 19) goto L6;
    L4:
        r2.setImportantForAccessibility(r3);
        return;
    L6:
        if (Build.VERSION.SDK_INT >= 16) goto L8;
        return;
    L8:
        if (r3 != 4) goto L4;
        r3 = 2;
        goto L4
    }

    public static void a(View r2, com.obric.oui.view.c r3) {
        com.obric.oui.view.c r4 = (com.obric.oui.view.c) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.oui.view.c.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 21) goto L6;
        c.a(r2, r4);
        return;
    }

    public static int b(View r2) {
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        return 0;
    L5:
        return r2.getAccessibilityLiveRegion();
    }

    static void b(View r4, int r5) {
        AccessibilityManager r0 = (AccessibilityManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService("accessibility"), AccessibilityManager.class, "com.obric.memorydata.plugin");
        if (r0.isEnabled() == true) goto L6;
        return;
    L6:
        if (e(r4) != null) goto L8;
    L10:
        boolean r1 = false;
    L11:
        int r3 = 32;
        if (b(r4) != 0) goto L23;
        if (r1 == true) goto L23;
        if (r5 != 32) goto L18;
        AccessibilityEvent r2 = AccessibilityEvent.obtain();
        r4.onInitializeAccessibilityEvent(r2);
        r2.setEventType(32);
        r2.setContentChangeTypes(r5);
        r2.setSource(r4);
        r4.onPopulateAccessibilityEvent(r2);
        r2.getText().add(e(r4));
        r0.sendAccessibilityEvent(r2);
        return;
    L18:
        if (r4.getParent() == null) goto L35;
        r4.getParent().notifySubtreeAccessibilityStateChanged(r4, r4, r5);     // Catch: AbstractMethodError -> L21
        return;
    L21:
        e = move-exception;
        Log.e("ViewCompat", r4.getParent().getClass().getSimpleName() + " does not fully implement ViewParent", e);
        return;
    L35:
        return;
    L23:
        AccessibilityEvent r6 = AccessibilityEvent.obtain();
        if (r1 == true) goto L27;
        r3 = 2048;
    L27:
        r6.setEventType(r3);
        r6.setContentChangeTypes(r5);
        if (r1 == false) goto L30;
        r6.getText().add(e(r4));
        f(r4);
    L30:
        r4.sendAccessibilityEventUnchecked(r6);
        return;
    L8:
        if (r4.getVisibility() != 0) goto L10;
        r1 = true;
        goto L11
    }

    public static void c(View r2) {
        if (Build.VERSION.SDK_INT < 20) goto L6;
        r2.requestApplyInsets();
        return;
    L6:
        if (Build.VERSION.SDK_INT < 16) goto L10;
        r2.requestFitSystemWindows();
        return;
    }

    public static e d(View r2) {
        if (Build.VERSION.SDK_INT < 23) goto L7;
        return C0790d.a(r2);
    L7:
        if (Build.VERSION.SDK_INT >= 21) goto L9;
        return null;
    L9:
        return c.a(r2);
    }

    public static CharSequence e(View r2) {
        return (CharSequence) ZeusTransformUtils.preCheckCast(a().c(r2), CharSequence.class, "com.obric.memorydata.plugin");
    }

    private static void f(View r3) {
        if (a(r3) != 0) goto L5;
        a(r3, 1);
    L5:
        ViewParent r0 = r3.getParent();
    L7:
        if (ZeusTransformUtils.instanceOf(r0, View.class) == false) goto L15;
        if (a((View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.memorydata.plugin")) == 4) goto L10;
        r0 = r0.getParent();
        goto L7
    L10:
        a(r3, 2);
        return;
    }
}
