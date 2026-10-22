package com.ss.android.lark.insets;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.os.Build;
import android.view.View;
import android.view.Window;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelProvider;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class WindowInsetsUtils {
    public static final /* synthetic */ int a = 0;

    public static final class a implements Runnable {
        public final /* synthetic */ View a;

        public a(View r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.requestApplyInsets();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ View a;
        public final /* synthetic */ View b;

        public b(View r1, View r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            View r0 = this.b.findViewById(R.id.statusBarBackground);     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            r0.setBackgroundColor(0);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    static {
    }

    @JvmStatic
    public static final f a(Dialog r5) {
        Intrinsics.checkNotNullParameter(r5, "dialog");
        r5.findViewById(R.id.content);
        Map<Integer, WeakReference<j>> r1 = e.r;
        Intrinsics.checkNotNullParameter(r5, "dialog");
        Window r0 = r5.getWindow();
        if (r0 == null) goto L5;
        e.a.a(r0);
        int r6 = h.q;
        return h.a.a(r0);
    L5:
        int r2 = r5.hashCode();
        Ref.ObjectRef r3 = new Ref.ObjectRef();
        Map<Integer, WeakReference<j>> r4 = e.r;
        LinkedHashMap r7 = (LinkedHashMap) r4;
        WeakReference r8 = (WeakReference) r7.get(Integer.valueOf(r2));
        if (r8 == null) goto L8;
        j r9 = (j) r8.get();
    L9:
        r3.element = r9;
        if (r9 != null) goto L13;
        r3.element = new j();
        r5.setOnShowListener(new d(r5, r3, r2));
        r4.put(Integer.valueOf(r2), new WeakReference(r3.element));
    L13:
        return (f) r3.element;
    L8:
        r9 = null;
        goto L9
    }

    @JvmStatic
    public static final f b(final Fragment r5) {
        Intrinsics.checkNotNullParameter(r5, "fragment");
        Map<Integer, j> r1 = FragmentWindowInsetsHandler.p;
        Intrinsics.checkNotNullParameter(r5, "fragment");
        if (r5.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.CREATED) == true) goto L10;
        final int r0 = r5.hashCode();
        final Ref.ObjectRef r2 = new Ref.ObjectRef();
        Map<Integer, j> r3 = FragmentWindowInsetsHandler.p;
        LinkedHashMap r4 = (LinkedHashMap) r3;
        Object r6 = r4.get(Integer.valueOf(r0));
        r2.element = r6;
        if (r6 != null) goto L9;
        r2.element = new j();
        r3.put(Integer.valueOf(r0), (j) r2.element);
        r5.getLifecycle().addObserver(new FragmentWindowInsetsHandler$Companion$obtainHandler$1(r5, r0, r2));
    L9:
        return (f) r2.element;
    L10:
        return ((FragmentWindowInsetsHandler.InsetsHandlerHolder) new ViewModelProvider(r5, new FragmentWindowInsetsHandler$Companion$obtainHandlerCreated$1(r5)).get(FragmentWindowInsetsHandler.InsetsHandlerHolder.class)).getInsetsHandler();
    }

    @JvmStatic
    public static final h c(Activity r5) {
        Intrinsics.checkNotNullParameter(r5, "activity");
        int r1 = com.ss.android.lark.insets.b.a;
        Intrinsics.checkNotNullParameter(r5, "activity");
        r5.findViewById(R.id.content);     // Catch: NullPointerException -> L5
    L11:
        int r0 = h.q;
        return h.a.a(r5.getWindow());
    L5:
        View r2 = r5.getWindow().getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L10;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r3 = ThreadMethodProxy.currentThread();
        if (r3 == com.larus.home.impl.utils.c.a) goto L10;
        com.larus.home.impl.utils.c.a(r3, "getDecorView");
    L10:
        r2.findViewById(R.id.content);
        goto L11
    }

    @JvmStatic
    public static final void d(Activity r1) {
        Intrinsics.checkNotNullParameter(r1, "activity");
        h r2 = c(r1);
        r2.f(false);
        r2.o(false);
        r2.c(false);
    }

    @JvmStatic
    public static final void e(Activity r1) {
        Intrinsics.checkNotNullParameter(r1, "activity");
        h(r1.getWindow(), c(r1));
    }

    @JvmStatic
    public static final void f(Activity r4) {
        Intrinsics.checkNotNullParameter(r4, "activity");
        boolean r1 = false;
        WindowCompat.setDecorFitsSystemWindows(r4.getWindow(), false);
        int r0 = Build.VERSION.SDK_INT;
        if (29 <= r0) goto L5;
    L7:
        if (r1 == false) goto L10;
        r4.getWindow().getAttributes().layoutInDisplayCutoutMode = 1;
        return;
    L10:
        return;
    L5:
        if (r0 >= 35) goto L7;
        r1 = true;
        goto L7
    }

    @JvmStatic
    public static final void h(Window r6, f r7) {
        Intrinsics.checkNotNullParameter(r6, "window");
        Intrinsics.checkNotNullParameter(r7, "insetsHandler");
        int r0 = Build.VERSION.SDK_INT;
        if (r0 >= 35) goto L5;
        r6.setStatusBarColor(0);
        r6.setNavigationBarColor(0);
    L5:
        View r1 = r6.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L10;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r3 = ThreadMethodProxy.currentThread();
        if (r3 == com.larus.home.impl.utils.c.a) goto L10;
        com.larus.home.impl.utils.c.a(r3, "getDecorView");
    L10:
        OneShotPreDrawListener.add(r1, new b(r1, r1));
        if (r0 < 29) goto L13;
        r6.setNavigationBarContrastEnforced(false);
        r6.setStatusBarContrastEnforced(false);
    L13:
        r7.b(0);
        r7.i(0);
    }

    @JvmStatic
    public static final void g(View r1, final boolean r2, final boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "view");
        if (r2 == true) goto L7;
        if (r3 == true) goto L7;
        ViewCompat.setOnApplyWindowInsetsListener(r1, null);
        return;
    L7:
        ViewCompat.setOnApplyWindowInsetsListener(r1, new WindowInsetsUtils$setViewFitSystemWindow$1(r2, r3));
        if (r1.isAttachedToWindow() == false) goto L10;
        r1.requestApplyInsets();
        return;
    L10:
        r1.post(new a(r1));
    }
}
