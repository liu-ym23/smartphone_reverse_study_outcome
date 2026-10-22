package com.suite.lark.platform.component.widget.floatingpanel.impl.container;

import android.R;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.appcontext.applifecycle.AppLifecycle;
import com.ss.android.lark.base.embedded.LKSplitController;
import com.ss.android.lark.log.Log;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.suite.lark.platform.component.widget.floatingpanel.impl.view.FloatingPanelView;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FloatingPanelTopPageViewContainer implements com.suite.lark.platform.component.widget.floatingpanel.impl.container.b {
    public static final /* synthetic */ int l = 0;
    public final Handler a;
    public final Application b;
    public boolean c;
    public WeakReference<Activity> d;
    public View e;
    public boolean f;
    public InterceptBackDialog g;
    public final d h;
    public final c i;
    public com.suite.lark.platform.component.widget.floatingpanel.impl.container.b.a j;
    public final b k;

    public static final class a {
    }

    public static final class b extends com.ss.android.lark.appcontext.applifecycle2.impl.b {
        public final /* synthetic */ FloatingPanelTopPageViewContainer a;

        public static final class a implements Runnable {
            public final /* synthetic */ Activity a;
            public final /* synthetic */ FloatingPanelTopPageViewContainer b;

            public a(Activity r1, FloatingPanelTopPageViewContainer r2) {
                this.a = r1;
                this.b = r2;
            }

            public final void a() {
                Activity r0 = AppLifecycle.a.a.f();
                Log.i("FloatingPanelTopPage", "use async get topActivity, same with sync one? " + Intrinsics.areEqual(r0, this.a));
                FloatingPanelTopPageViewContainer r1 = this.b;
                int r2 = FloatingPanelTopPageViewContainer.l;
                r1.e(r0);
            }

            @Override // java.lang.Runnable
            public final void run() {
                a();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public final void onActivityStarted(Activity r2) {
            Intrinsics.checkNotNullParameter(r2, "activity");
        }

        public b(FloatingPanelTopPageViewContainer r1) {
            this.a = r1;
        }

        public final void onActivityPaused(Activity r7) {
            Intrinsics.checkNotNullParameter(r7, "activity");
            Log.i("FloatingPanelTopPage", "onActivityPaused ".concat(r7.getClass().getName()));
            if (Build.VERSION.SDK_INT >= 24) goto L5;
            return;
        L5:
            if (r7.isInPictureInPictureMode() == false) goto L35;
            FloatingPanelTopPageViewContainer r0 = this.a;
            r0.getClass();
            Log.i("FloatingPanelTopPage", "removeViewFromActivity: ".concat(r7.getClass().getName()));
            View r2 = r0.e;
            if (r2 != null) goto L9;
            Log.e("FloatingPanelTopPage", "not view to be shown");
            return;
        L9:
            ViewGroup r3 = (ViewGroup) r7.findViewById(R.id.content);
            if (r3 != null) goto L12;
            Log.e("FloatingPanelTopPage", "can not get content view in ".concat(r7.getClass().getName()));
            return;
        L12:
            WeakReference<Activity> r4 = r0.d;
            ViewGroup r5 = null;
            if (r4 == null) goto L15;
            Activity r6 = r4.get();
        L17:
            if (Intrinsics.areEqual(r6, r7) == true) goto L19;
        L32:
            Log.w("FloatingPanelTopPage", "view is not showing in ".concat(r7.getClass().getName()));
            return;
        L19:
            if (Intrinsics.areEqual(r2.getParent(), r3) == false) goto L32;
            com.suite.lark.platform.component.widget.floatingpanel.impl.container.b.a r8 = r0.j;
            if (r8 == null) goto L24;
            r8.a();
        L24:
            r0.d = null;
            if (r2.getParent() == null) goto L38;
            Log.i("FloatingPanelTopPage", "remove from parent");
            ViewParent r9 = r2.getParent();
            if ((r9 instanceof ViewGroup) == false) goto L29;
            r5 = (ViewGroup) r9;
        L29:
            if (r5 == null) goto L31;
            r5.removeView(r2);
        L31:
            r2.removeOnLayoutChangeListener(r0.h);
            r2.removeOnAttachStateChangeListener(r0.i);
            return;
        L38:
            return;
        L15:
            r6 = null;
            goto L17
        }

        public final void onActivityResumed(Activity r3) {
            Intrinsics.checkNotNullParameter(r3, "activity");
            Log.i("FloatingPanelTopPage", "onActivityResumed ".concat(r3.getClass().getName()));
            this.a.e(r3);
        }

        public final void onActivityStopped(Activity r4) {
            Intrinsics.checkNotNullParameter(r4, "activity");
            Log.i("FloatingPanelTopPage", "onActivityStopped ".concat(r4.getClass().getName()));
            Activity r0 = AppLifecycle.a.a.f();
            if (Intrinsics.areEqual(r0, r4) == false) goto L5;
            Log.w("FloatingPanelTopPage", "topActivity is stopped");
            FloatingPanelTopPageViewContainer r1 = this.a;
            r1.a.post(new a(r4, r1));
            return;
        L5:
            this.a.e(r0);
        }
    }

    public static final class c implements View.OnAttachStateChangeListener {
        public final /* synthetic */ FloatingPanelTopPageViewContainer a;

        public static final class a implements Runnable {
            public final /* synthetic */ FloatingPanelTopPageViewContainer a;
            public final /* synthetic */ View b;
            public final /* synthetic */ ViewGroup c;

            public a(FloatingPanelTopPageViewContainer r1, View r2, ViewGroup r3) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
            }

            @Override // java.lang.Runnable
            public final void run() {
                FloatingPanelTopPageViewContainer r0 = this.a;     // Catch: Throwable -> L4
                View r1 = this.b;     // Catch: Throwable -> L4
                ViewGroup r2 = this.c;     // Catch: Throwable -> L4
                int r3 = FloatingPanelTopPageViewContainer.l;     // Catch: Throwable -> L4
                r0.getClass();     // Catch: Throwable -> L4
                FloatingPanelTopPageViewContainer.f(r1, r2);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r2) {
            Intrinsics.checkNotNullParameter(r2, "v");
        }

        public c(FloatingPanelTopPageViewContainer r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r4) {
            Intrinsics.checkNotNullParameter(r4, "contentView");
            ViewParent r0 = r4.getParent();
            if ((r0 instanceof ViewGroup) == false) goto L5;
            ViewGroup r1 = (ViewGroup) r0;
        L6:
            if (r1 != null) goto L8;
            return;
        L8:
            r1.post(new a(this.a, r4, r1));
            return;
        L5:
            r1 = null;
            goto L6
        }
    }

    public static final class d implements View.OnLayoutChangeListener {
        public final /* synthetic */ FloatingPanelTopPageViewContainer a;

        public static final class a implements Runnable {
            public final /* synthetic */ FloatingPanelTopPageViewContainer a;
            public final /* synthetic */ View b;
            public final /* synthetic */ ViewGroup c;

            public a(FloatingPanelTopPageViewContainer r1, View r2, ViewGroup r3) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
            }

            @Override // java.lang.Runnable
            public final void run() {
                FloatingPanelTopPageViewContainer r0 = this.a;     // Catch: Throwable -> L4
                View r1 = this.b;     // Catch: Throwable -> L4
                ViewGroup r2 = this.c;     // Catch: Throwable -> L4
                int r3 = FloatingPanelTopPageViewContainer.l;     // Catch: Throwable -> L4
                r0.getClass();     // Catch: Throwable -> L4
                FloatingPanelTopPageViewContainer.f(r1, r2);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public d(FloatingPanelTopPageViewContainer r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
            if (r2 != r6) goto L7;
            if (r3 != r7) goto L7;
            if (r4 != r8) goto L7;
            if (r5 != r9) goto L7;
            return;
        L7:
            if (r1 != null) goto L9;
            return;
        L9:
            ViewParent r10 = r1.getParent();
            if ((r10 instanceof ViewGroup) == false) goto L12;
            ViewGroup r11 = (ViewGroup) r10;
        L13:
            if (r11 != null) goto L15;
            return;
        L15:
            r11.post(new a(this.a, r1, r11));
            return;
        L12:
            r11 = null;
            goto L13
        }
    }

    public static final class e implements Runnable {
        public final /* synthetic */ Function0 a;

        public e(Function0 r2) {
            Intrinsics.checkNotNullParameter(r2, "function");
            this.a = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.invoke();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [android.app.Dialog, com.suite.lark.platform.component.widget.floatingpanel.impl.container.InterceptBackDialog, java.lang.Object] */
    @Override // com.suite.lark.platform.component.widget.floatingpanel.impl.container.b
    public final void a() {
        Log.i("FloatingPanelTopPage", "stopListenBackEvent");
        ?? r0 = this.g;
        if (r0 == 0) goto L22;
        Handler r1 = DialogLancet.resolveDialogHandler(r0);
        if (r1 != null) goto L7;
    L9:
        DialogLancet.beforeDialogDismiss(r0);
        r0.dismiss();     // Catch: Throwable -> L12 Exception -> L14
    L18:
        DialogLancet.afterDialogDismiss(r0);
    L19:
        this.g = null;
        return;
    L14:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
        Throwable r2 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
        if (r2 == null) goto L18;
        com.bytedance.crash.d.d(r2, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r0);
        throw th;
    L7:
        if (Looper.myLooper() == r1.getLooper()) goto L9;
        r1.post(DialogLancet.createDismissRunnable(r0));
        goto L19
    }

    @Override // com.suite.lark.platform.component.widget.floatingpanel.impl.container.b
    public final void dismiss() {
        Log.i("FloatingPanelTopPage", "dismiss");
        a();
        View r1 = this.e;
        if (r1 != null) goto L7;
        Log.e("FloatingPanelTopPage", "invoke dismiss while contentView not set");
        this.f = false;
        return;
    L7:
        if (r1.getParent() == null) goto L14;
        Log.i("FloatingPanelTopPage", "remove view from parent");
        ViewParent r0 = r1.getParent();
        if ((r0 instanceof ViewGroup) == false) goto L11;
        ViewGroup r2 = (ViewGroup) r0;
    L12:
        if (r2 == null) goto L14;
        r2.removeView(r1);
        goto L14
    L11:
        r2 = null;
    L14:
        r1.removeOnLayoutChangeListener(this.h);
        r1.removeOnAttachStateChangeListener(this.i);
        this.f = false;
        this.c = false;
        this.b.unregisterActivityLifecycleCallbacks(this.k);
    }

    @Override // com.suite.lark.platform.component.widget.floatingpanel.impl.container.b
    public final Activity getCurrentActivity() {
        WeakReference<Activity> r0 = this.d;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.get();
    }

    public FloatingPanelTopPageViewContainer(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this.a = new Handler(Looper.getMainLooper());
        Context r4 = r3.getApplicationContext();
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Application");
        this.b = (Application) r4;
        this.h = new d(this);
        this.i = new c(this);
        this.k = new b(this);
    }

    @Override // com.suite.lark.platform.component.widget.floatingpanel.impl.container.b
    public final void b(Function0<Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "onAttach");
        Log.i("FloatingPanelTopPage", "show");
        View r1 = this.e;
        if (r1 != null) goto L7;
        Log.e("FloatingPanelTopPage", "invoke show but contentView has not been set");
        return;
    L7:
        if (this.f == false) goto L15;
        if (r1 != null) goto L11;
        return;
    L11:
        if (r1.isAttachedToWindow() == true) goto L13;
        r1.post(new e(r3));
        return;
    L13:
        r3.invoke();
        return;
    L15:
        this.f = true;
        e(AppLifecycle.a.a.f());
        if (this.c == true) goto L19;
        this.c = true;
        this.b.registerActivityLifecycleCallbacks(this.k);
    L19:
        View r0 = this.e;
        if (r0 != null) goto L23;
        return;
    L23:
        if (r0.isAttachedToWindow() == true) goto L25;
        r0.post(new e(r3));
        return;
    L25:
        r3.invoke();
    }

    @Override // com.suite.lark.platform.component.widget.floatingpanel.impl.container.b
    public final void c(FloatingPanelView r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        if (this.e == null) goto L5;
        return;
    L5:
        this.e = r2;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [android.app.Dialog, com.suite.lark.platform.component.widget.floatingpanel.impl.container.InterceptBackDialog, java.lang.Object] */
    @Override // com.suite.lark.platform.component.widget.floatingpanel.impl.container.b
    public final void d(final Function0<Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "onBackEvent");
        Log.i("FloatingPanelTopPage", "startListenBackEvent");
        a();
        Activity r1 = getCurrentActivity();
        if (r1 != null) goto L5;
        return;
    L5:
        if ((r1 instanceof AppCompatActivity) == false) goto L26;
        ?? r2 = new InterceptBackDialog(r1);
        this.g = r2;
        r2.a = new FloatingPanelTopPageViewContainer$startListenBackEvent$1$1$1(r4, this);
    L15:
        e = move-exception;
        Log.e("FloatingPanelTopPage", "show dialog failed", e);
        return;
    L9:
        if (DialogLancet.shouldBlockDialogShow(r2) == false) goto L19;
        DialogLancet.handleBlockedDialogShow(r2);     // Catch: Exception -> L15
    L21:
        return;
    L19:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L18
    L13:
        DialogLancet.beforeDialogShow(r2);     // Catch: Exception -> L15
        r2.show();     // Catch: Exception -> L15
        DialogLancet.afterDialogShow(r2);     // Catch: Exception -> L15
        goto L21
    }

    public final void e(Activity r5) {
        Log.i("FloatingPanelTopPage", "showView: isShowing: " + this.f);
        if (r5 != null) goto L6;
        return;
    L6:
        if (this.f == true) goto L9;
        return;
    L9:
        if (Build.VERSION.SDK_INT >= 24) goto L11;
    L13:
        com.suite.lark.platform.component.widget.floatingpanel.impl.container.a r1 = new com.suite.lark.platform.component.widget.floatingpanel.impl.container.a(r5, new FloatingPanelTopPageViewContainer$showView$1(this));
        LKSplitController r0 = LKSplitController.b;
        LKSplitController r2 = LKSplitController.a.a();
        if (r2.e() == true) goto L17;
        r1.accept(Boolean.TRUE);
        return;
    L17:
        if (com.ss.android.lark.base.embedded.b.c(r5) == true) goto L19;
        r1.accept(Boolean.TRUE);
        return;
    L19:
        r2.a(r5, ContextCompat.getMainExecutor(r5), new com.ss.android.lark.base.embedded.a(r1, r5, r2));
        return;
    L11:
        if (r5.isInPictureInPictureMode() == false) goto L13;
    }

    public static void f(View r9, ViewGroup r10) {
        Context r0 = r10.getContext();
        Activity r2 = null;
        if ((r0 instanceof Activity) == false) goto L5;
        Activity r1 = (Activity) r0;
    L6:
        int r3 = 0;
        if (r1 != null) goto L9;
    L11:
        boolean r4 = false;
    L12:
        WindowInsetsCompat r5 = ViewCompat.getRootWindowInsets(r10);
        if (r5 == null) goto L17;
        if (r4 == false) goto L16;
        int r6 = r5.getInsets(WindowInsetsCompat.Type.statusBars()).top;
    L18:
        int[] r7 = new int[2];
        r10.getLocationInWindow(r7);
        int r8 = r7[1];
        int r11 = r10.getPaddingTop();
        int r12 = r8 + r11;
        Log.i("FloatingPanelTopPage", "getViewPaddingTop, windowInsetsTop: " + r6 + ", containerTopEdge: " + r12 + ", containerPaddingTop: " + r11);
        int r13 = Math.max(0, r6 - r12);
        Context r14 = r10.getContext();
        if ((r14 instanceof Activity) == false) goto L21;
        r2 = (Activity) r14;
    L21:
        if (r2 == null) goto L33;
        WindowInsetsCompat r15 = ViewCompat.getRootWindowInsets(r10);
        if (r15 == null) goto L26;
        int r16 = r15.getInsets(WindowInsetsCompat.Type.navigationBars()).bottom;
    L27:
        int[] r17 = new int[2];
        r10.getLocationInWindow(r17);
        int r18 = r17[1] + r10.getHeight();
        int r19 = r10.getPaddingBottom();
        View r20 = r2.getWindow().getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L32;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r21 = ThreadMethodProxy.currentThread();
        if (r21 == com.larus.home.impl.utils.c.a) goto L32;
        com.larus.home.impl.utils.c.a(r21, "getDecorView");
    L32:
        int r22 = r20.getHeight();
        int r23 = (r22 - r18) + r19;
        Log.i("FloatingPanelTopPage", "getViewPaddingBottom, windowInsetsBottom: " + r16 + ", containerBottomEdge: " + r23 + ", windowHeight: " + r22 + ", containerBottom: " + r18 + ", containerPaddingBottom: " + r19);
        r3 = Math.max(0, r16 - r23);
        goto L33
    L26:
        r16 = 0;
    L33:
        Log.i("FloatingPanelTopPage", "updateContentViewPadding, top: " + r13 + ", bottom: " + r3);
        r9.setPadding(r9.getPaddingLeft(), r13, r9.getPaddingRight(), r3);
        return;
    L16:
        r6 = r5.getInsetsIgnoringVisibility(WindowInsetsCompat.Type.statusBars()).top;
        goto L18
    L17:
        r6 = 0;
        goto L18
    L9:
        if (r1.getResources().getConfiguration().orientation != 2) goto L11;
        r4 = true;
        goto L12
    L5:
        r1 = null;
        goto L6
    }
}
