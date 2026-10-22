package com.bytedance.android.accessibilityLib_Core.helper;

import android.app.Activity;
import android.content.Context;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.widget.FrameLayout;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class AppWindows {
    public Class<?> a;
    public Object b;
    public List<? extends Object> c;
    public final Map<Integer, WeakReference<b>> d;
    public final Lazy e;
    public final CopyOnWriteArrayList<a> f;
    public boolean g;

    public interface a {
        void a();

        void b(Window r1, View r10, String r11);

        void c(View r1, String r10);
    }

    public final class b implements Window.Callback {
        public final Window.Callback a;
        public boolean b;
        public final Window.Callback c;
        public final Window d;
        public final View e;
        public final /* synthetic */ AppWindows f;

        @Override // android.view.Window.Callback
        public final boolean dispatchGenericMotionEvent(MotionEvent r10) {
            return this.c.dispatchGenericMotionEvent(r10);
        }

        @Override // android.view.Window.Callback
        public final boolean dispatchKeyShortcutEvent(KeyEvent r10) {
            return this.c.dispatchKeyShortcutEvent(r10);
        }

        @Override // android.view.Window.Callback
        public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent r10) {
            return this.c.dispatchPopulateAccessibilityEvent(r10);
        }

        @Override // android.view.Window.Callback
        public final boolean dispatchTrackballEvent(MotionEvent r10) {
            return this.c.dispatchTrackballEvent(r10);
        }

        @Override // android.view.Window.Callback
        public final void onActionModeFinished(ActionMode r10) {
            this.c.onActionModeFinished(r10);
        }

        @Override // android.view.Window.Callback
        public final void onActionModeStarted(ActionMode r10) {
            this.c.onActionModeStarted(r10);
        }

        @Override // android.view.Window.Callback
        public final void onAttachedToWindow() {
            this.c.onAttachedToWindow();
        }

        @Override // android.view.Window.Callback
        public final void onContentChanged() {
            this.c.onContentChanged();
        }

        @Override // android.view.Window.Callback
        public final boolean onCreatePanelMenu(int r10, Menu r11) {
            return this.c.onCreatePanelMenu(r10, r11);
        }

        @Override // android.view.Window.Callback
        public final View onCreatePanelView(int r10) {
            return this.c.onCreatePanelView(r10);
        }

        @Override // android.view.Window.Callback
        public final void onDetachedFromWindow() {
            this.c.onDetachedFromWindow();
        }

        @Override // android.view.Window.Callback
        public final boolean onMenuItemSelected(int r10, MenuItem r11) {
            return this.c.onMenuItemSelected(r10, r11);
        }

        @Override // android.view.Window.Callback
        public final boolean onMenuOpened(int r10, Menu r11) {
            return this.c.onMenuOpened(r10, r11);
        }

        @Override // android.view.Window.Callback
        public final void onPanelClosed(int r10, Menu r11) {
            this.c.onPanelClosed(r10, r11);
        }

        @Override // android.view.Window.Callback
        public final boolean onPreparePanel(int r10, View r11, Menu r12) {
            return this.c.onPreparePanel(r10, r11, r12);
        }

        @Override // android.view.Window.Callback
        public final boolean onSearchRequested() {
            return this.c.onSearchRequested();
        }

        @Override // android.view.Window.Callback
        public final boolean onSearchRequested(SearchEvent r10) {
            return this.c.onSearchRequested(r10);
        }

        @Override // android.view.Window.Callback
        public final void onWindowAttributesChanged(WindowManager.LayoutParams r10) {
            this.c.onWindowAttributesChanged(r10);
        }

        @Override // android.view.Window.Callback
        public final void onWindowFocusChanged(boolean r10) {
            this.c.onWindowFocusChanged(r10);
        }

        @Override // android.view.Window.Callback
        public final ActionMode onWindowStartingActionMode(ActionMode.Callback r10) {
            return this.c.onWindowStartingActionMode(r10);
        }

        @Override // android.view.Window.Callback
        public final ActionMode onWindowStartingActionMode(ActionMode.Callback r10, int r11) {
            return this.c.onWindowStartingActionMode(r10, r11);
        }

        @Override // android.view.Window.Callback
        public final boolean dispatchKeyEvent(KeyEvent r10) {
            return this.c.dispatchKeyEvent(r10);
        }

        @Override // android.view.Window.Callback
        public final boolean dispatchTouchEvent(MotionEvent r11) {
            if (this.f.g == false) goto L45;
            if (this.a != null) goto L7;
        L40:
            Iterator<a> r0 = this.f.f.iterator();
        L42:
            if (r0.hasNext() == false) goto L45;
            r0.next().a();
            goto L42
        L7:
            if (r11.getAction() != 0) goto L29;
            View r1 = this.e;
            if ((r1 instanceof ViewGroup) == true) goto L11;
            r1 = null;
        L11:
            ViewGroup r10 = (ViewGroup) r1;
            if (r10 == null) goto L29;
            int r12 = r10.getChildCount();
            int r13 = 0;
        L14:
            if (r13 >= r12) goto L29;
            View r14 = r10.getChildAt(r13);
            this.f.getClass();
            int[] r15 = new int[2];
            r14.getLocationOnScreen(r15);
            int r16 = r15[0];
            int r17 = r15[1];
            if (r11.getX() >= r16) goto L18;
        L24:
            boolean r18 = false;
        L25:
            if (r18 == false) goto L27;
            this.b = true;
        L27:
            r13 = r13 + 1;
            goto L14
        L18:
            if (r11.getX() > (r16 + r14.getWidth())) goto L24;
            if (r11.getY() < r17) goto L24;
            if (r11.getY() > (r17 + r14.getHeight())) goto L24;
            r18 = true;
        L29:
            if (this.b == false) goto L36;
            Window.Callback r19 = this.a;
            if (r19 != null) goto L34;
            Intrinsics.throwNpe();
        L34:
            return r19.dispatchTouchEvent(r11);
        L36:
            if (r11.getAction() != 1) goto L38;
        L39:
            this.b = false;
            goto L40
        L38:
            if (r11.getAction() != 3) goto L40;
        L45:
            return this.c.dispatchTouchEvent(r11);
        }

        public b(AppWindows r1, Window.Callback r10, Window r11, View r12) {
            this.f = r1;
            this.c = r10;
            this.d = r11;
            this.e = r12;
            if (((Class) r1.e.getValue()) == null) goto L21;
            Class r13 = (Class) r1.e.getValue();
            if (r13 != null) goto L8;
            Intrinsics.throwNpe();
        L8:
            if (r13.isAssignableFrom(r10.getClass()) == false) goto L22;
            Class r14 = (Class) r1.e.getValue();     // Catch: Throwable -> L17
            if (r14 != null) goto L12;
            Intrinsics.throwNpe();     // Catch: Throwable -> L17
        L12:
            Field r15 = r14.getDeclaredField("mWrapped");     // Catch: Throwable -> L17
            r15.setAccessible(true);     // Catch: Throwable -> L17
            Object r16 = r15.get(r10);     // Catch: Throwable -> L17
            if (r16 == null) goto L16;
            this.a = (Window.Callback) r16;     // Catch: Throwable -> L17
            return;
        L16:
            throw new TypeCastException("null cannot be cast to non-null type android.view.Window.Callback");     // Catch: Throwable -> L17
        L17:
            th = move-exception;
            th.getMessage();
            return;
        L22:
            return;
        }
    }

    public static final class c implements ViewTreeObserver.OnGlobalLayoutListener {
        public final /* synthetic */ AppWindows a;
        public final /* synthetic */ Window b;
        public final /* synthetic */ View c;
        public final /* synthetic */ Object d;

        public c(AppWindows r1, Window r10, View r11, Object r12) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
            this.d = r12;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            if ((this.b.getCallback() instanceof b) == false) goto L5;
            return;
        L5:
            if (this.b.getCallback() == null) goto L9;
            Window r0 = this.b;
            b r1 = new b(this.a, r0.getCallback(), this.b, this.c);
            this.a.d.put(Integer.valueOf(this.d.hashCode()), new WeakReference(r1));
            Unit r10 = Unit.INSTANCE;
            r0.setCallback(r1);
            return;
        }
    }

    public static final class d implements InvocationHandler {
        public final /* synthetic */ AppWindows a;

        public d(AppWindows r1) {
            this.a = r1;
        }

        @Override // java.lang.reflect.InvocationHandler
        public final Object invoke(Object r10, Method r11, Object[] r12) {
            if (r12 != null) goto L8;
            Object r13 = this.a.b;
            if (r13 != null) goto L7;
            Intrinsics.throwUninitializedPropertyAccessException("windowSession");
        L7:
            Object r14 = r11.invoke(r13, new Object[0]);
        L13:
            if (StringsKt.startsWith$default(r11.getName(), "addToDisplay", false, 2, null) == true) goto L20;
        L18:
            return r14;
        L20:
            AppWindows r15 = this.a;     // Catch: Throwable -> L19
            List<? extends Object> r16 = r15.c;     // Catch: Throwable -> L19
            if (r16 != null) goto L17;
            Intrinsics.throwUninitializedPropertyAccessException("viewRoots");     // Catch: Throwable -> L19
        L17:
            r15.c(CollectionsKt.last(r16));     // Catch: Throwable -> L19
            goto L18
        L8:
            Object r1 = this.a.b;
            if (r1 != null) goto L11;
            Intrinsics.throwUninitializedPropertyAccessException("windowSession");
        L11:
            r14 = r11.invoke(r1, Arrays.copyOf(r12, r12.length));
            goto L13
        }
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r10 = Class.forName("android.view.WindowManagerGlobal");     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.view.WindowManagerGlobal");     // Catch: Throwable -> L8
    L7:
        return r10;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.view.WindowManagerGlobal");
    L12:
        throw th;
    L34:
        Class<?> r11 = Class.forName("android.view.WindowManagerGlobal");     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.view.WindowManagerGlobal");     // Catch: Throwable -> L17
    L16:
        return r11;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("android.view.WindowManagerGlobal");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("android.view.WindowManagerGlobal");
    }

    public final void d() {
        Class<?> r0 = this.a;     // Catch: Throwable -> L14
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("classWindowManagerGlobal");     // Catch: Throwable -> L14
    L6:
        Object r1 = r0.getDeclaredMethod("getWindowSession", new Class[0]).invoke(null, new Object[0]);     // Catch: Throwable -> L14
        this.b = r1;     // Catch: Throwable -> L14
        if (r1 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("windowSession");     // Catch: Throwable -> L14
    L9:
        Class<?> r10 = r1.getClass();     // Catch: Throwable -> L14
        Object r11 = Proxy.newProxyInstance(r10.getClassLoader(), r10.getInterfaces(), new d(this));     // Catch: Throwable -> L14
        Class<?> r12 = this.a;     // Catch: Throwable -> L14
        if (r12 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("classWindowManagerGlobal");     // Catch: Throwable -> L14
    L12:
        Field r13 = r12.getDeclaredField("sWindowSession");     // Catch: Throwable -> L14
        r13.setAccessible(true);     // Catch: Throwable -> L14
        r13.set(null, r11);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        th.getMessage();
    }

    public final void e() {
        Class<?> r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("classWindowManagerGlobal");
    L5:
        Method r1 = r0.getDeclaredMethod("getInstance", new Class[0]);
        r1.setAccessible(true);
        Object r10 = r1.invoke(null, new Object[0]);
        Class<?> r11 = this.a;
        if (r11 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("classWindowManagerGlobal");
    L8:
        Field r12 = r11.getDeclaredField("mRoots");
        r12.setAccessible(true);
        Object r13 = r12.get(r10);
        if (r13 == null) goto L17;
        List<? extends Object> r14 = (List) r13;
        ArrayList<Object> r15 = new AppWindows$hookViewRootsOfWMG$replacedViewRoots$1(this);     // Catch: Throwable -> L13
        r15.addAll(r14);     // Catch: Throwable -> L13
        r12.set(r10, r15);     // Catch: Throwable -> L13
        this.c = r15;     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        this.c = r14;
        th.getMessage();
        return;
    L17:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
    }

    public AppWindows() {
        this.d = new LinkedHashMap();
        this.e = LazyKt.lazy(AppWindows$xiguaWindowCallbackClazz$2.INSTANCE);
        this.f = new CopyOnWriteArrayList();
    }

    public final void c(Object r10) {
        Field r0 = r10.getClass().getDeclaredField("mView");
        r0.setAccessible(true);
        Object r1 = r0.get(r10);
        Window r11 = null;
        if ((r1 instanceof View) == true) goto L5;
        r1 = null;
    L5:
        View r12 = (View) r1;
        if (r12 != null) goto L8;
        return;
    L8:
        if (StringsKt.contains$default(r12.getClass().getName(), "DecorView", false, 2, null) == true) goto L37;
        return;
    L37:
        Field r13 = r12.getClass().getDeclaredField("mWindow");     // Catch: NoSuchFieldException -> L16
        r13.setAccessible(true);     // Catch: NoSuchFieldException -> L16
        Object r14 = r13.get(r12);     // Catch: NoSuchFieldException -> L16
        if (r14 == null) goto L15;
        Window r15 = (Window) r14;     // Catch: NoSuchFieldException -> L16
    L13:
        r11 = r15;
    L21:
        if (r11 == null) goto L44;
        Window.Callback r16 = r11.getCallback();
        if (r16 == null) goto L26;
        b r17 = new b(this, r16, r11, r12);
        this.d.put(Integer.valueOf(r10.hashCode()), new WeakReference(r17));
        Unit r18 = Unit.INSTANCE;
        r11.setCallback(r17);
    L26:
        if (this.g == false) goto L35;
        Iterator<a> r19 = this.f.iterator();
    L29:
        if (r19.hasNext() == false) goto L35;
        a r20 = r19.next();
        Context r21 = r11.getContext();
        if ((r21 instanceof Activity) == false) goto L33;
        String r22 = ((Activity) r21).getClass().getSimpleName();
    L34:
        r20.b(r11, r12, r22);
        goto L29
    L33:
        r22 = "";
    L35:
        r12.getViewTreeObserver().addOnGlobalLayoutListener(new c(this, r11, r12, r10));
        return;
    L44:
        return;
    L15:
        throw new TypeCastException("null cannot be cast to non-null type android.view.Window");     // Catch: NoSuchFieldException -> L16
    L17:
        if (StringsKt.contains$default(r12.getClass().getName(), "PopupDecorView", false, 2, null) == false) goto L21;
        r15 = new com.bytedance.android.accessibilityLib_Core.helper.d(com.bytedance.android.accessibilityLib_Core.helper.a.a(), (FrameLayout) r12);     // Catch: ClassCastException -> L20
        goto L13
    }

    public final void f(boolean r10) {
        this.g = r10;
        if (r10 == true) goto L5;
        return;
    L5:
        if (this.b != null) goto L28;
        this.a = a();     // Catch: Throwable -> L16
        d();     // Catch: Throwable -> L16
        e();     // Catch: Throwable -> L16
        List<? extends Object> r11 = this.c;     // Catch: Throwable -> L16
        if (r11 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("viewRoots");     // Catch: Throwable -> L16
    L10:
        Iterator<T> r12 = r11.iterator();     // Catch: Throwable -> L16
    L11:
        if (r12.hasNext() == false) goto L29;
        c(r12.next());     // Catch: Throwable -> L19
        goto L11
    L29:
        return;
    L16:
        th = move-exception;
        th.getMessage();
        return;
    }

    public static final void b(AppWindows r10, Object r11) {
        WeakReference<b> r12 = r10.d.remove(Integer.valueOf(r11.hashCode()));
        if (r10.g == false) goto L15;
        if (r12 == null) goto L19;
        b r13 = r12.get();
        if (r13 == null) goto L20;
        Window r0 = r13.d;
        Iterator<a> r14 = r10.f.iterator();
    L9:
        if (r14.hasNext() == false) goto L21;
        a r1 = r14.next();
        View r15 = r13.e;
        Context r16 = r0.getContext();
        if ((r16 instanceof Activity) == false) goto L13;
        String r17 = ((Activity) r16).getClass().getSimpleName();
    L14:
        r1.c(r15, r17);
        goto L9
    L13:
        r17 = "";
        goto L14
    L21:
        return;
    L20:
        return;
    L19:
        return;
    }
}
