package i2;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.core.os.HandlerCompat;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.ai.model.objects.PageInfo;
import com.bytedance.android.ec.base.api.ai.AIStateLogRequest;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import k2.s;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class f extends g implements Application.ActivityLifecycleCallbacks {
    public static final Lazy<f> i = null;
    public i2.a a;
    public FrameLayout b;
    public boolean c;
    public WeakReference<FrameLayout> d;
    public WeakReference<Activity> e;
    public s f;
    public final Lazy g;
    public final int h;

    public static final class a {
        public static f a() {
            return (f) f.i.getValue();
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ f a;
        public final /* synthetic */ Activity b;

        public b(f r1, Activity r10) {
            this.a = r1;
            this.b = r10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.p(this.b);     // Catch: Throwable -> L4
            this.a.k(this.b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity r1, Bundle r10) {
        Intrinsics.checkNotNullParameter(r1, "p0");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity r10) {
        Intrinsics.checkNotNullParameter(r10, "p0");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r10, "p0");
        Intrinsics.checkNotNullParameter(r11, "p1");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity r10) {
        Intrinsics.checkNotNullParameter(r10, "p0");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity r10) {
        Intrinsics.checkNotNullParameter(r10, "p0");
    }

    static {
        i = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new c());
    }

    @Override // i2.j
    public final boolean e() {
        WeakReference<FrameLayout> r0 = this.d;
        if (r0 == null) goto L11;
        FrameLayout r1 = r0.get();
        if (r1 == null) goto L11;
        i2.a r10 = this.a;
        if (r10 == null) goto L11;
        if (r1.indexOfChild(r10) == (-1)) goto L11;
        return true;
    L11:
        return false;
    }

    @Override // i2.j
    public final boolean h() {
        if (this.f == null) goto L5;
        return true;
    L5:
        return false;
    }

    public f() {
        this.c = true;
        this.g = LazyKt.lazy(new e());
        AtomicBoolean r0 = f2.b.a;
        h2.a r1 = f2.b.c;
        Application r10 = null;
        if (r1 == null) goto L5;
        Context r11 = r1.a;
    L7:
        if ((r11 instanceof Application) == false) goto L9;
        r10 = (Application) r11;
    L9:
        if (r10 == null) goto L11;
        r10.registerActivityLifecycleCallbacks(this);
    L11:
        this.h = 2131563320;
        return;
    L5:
        r11 = null;
        goto L7
    }

    @Override // i2.j
    public final s j() {
        return this.f;
    }

    public static FrameLayout o(Activity r10) {
        if (r10 != null) goto L46;
        return null;
    L46:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L24
        if ((r10 instanceof FragmentActivity) == false) goto L8;
        FragmentActivity r11 = (FragmentActivity) r10;     // Catch: Throwable -> L24
    L9:
        if (r11 == null) goto L17;
        FragmentManager r12 = r11.getSupportFragmentManager();     // Catch: Throwable -> L24
        if (r12 == null) goto L17;
        List r13 = r12.getFragments();     // Catch: Throwable -> L24
        if (r13 == null) goto L17;
        Fragment r14 = (Fragment) CollectionsKt.lastOrNull(r13);     // Catch: Throwable -> L24
        if (r14 == null) goto L17;
        View r15 = r14.getView();     // Catch: Throwable -> L24
    L19:
        if ((r15 instanceof FrameLayout) == false) goto L21;
        FrameLayout r16 = (FrameLayout) r15;     // Catch: Throwable -> L24
    L22:
        Object r17 = Result.constructor-impl(r16);     // Catch: Throwable -> L24
    L27:
        if (Result.isFailure-impl(r17) == false) goto L29;
        r17 = null;
    L29:
        FrameLayout r18 = (FrameLayout) r17;
        if (r18 == null) goto L44;
        return r18;
    L44:
        View r19 = r10.getWindow().getDecorView();     // Catch: ClassCastException -> L39
        if (com.larus.home.impl.utils.c.e == false) goto L37;
        FLogger.a.i("DecorViewLancet", "getDecorView");     // Catch: ClassCastException -> L39
        Thread r20 = ThreadMethodProxy.currentThread();     // Catch: ClassCastException -> L39
        if (r20 == com.larus.home.impl.utils.c.a) goto L37;
        com.larus.home.impl.utils.c.a(r20, "getDecorView");     // Catch: ClassCastException -> L39
    L37:
        Intrinsics.checkNotNull(r19, "null cannot be cast to non-null type android.widget.FrameLayout");     // Catch: ClassCastException -> L39
        return (FrameLayout) r19;
    L39:
        e = move-exception;
        String r21 = e.getMessage();
        if (r21 == null) goto L43;
        com.bytedance.ai.utils.g.a.e("WebViewFloatingPage", r21);
    L43:
        return null;
    L21:
        r16 = null;
    L17:
        r15 = null;
        goto L19
    L8:
        r11 = null;
    L24:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        r17 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L27
    }

    @Override // i2.j
    public final boolean g(String r10) {
        Intrinsics.checkNotNullParameter(r10, "viewId");
        s r0 = this.f;
        if (r0 == null) goto L5;
        String r1 = r0.getPageID();
    L7:
        if (Intrinsics.areEqual(r10, r1) == true) goto L10;
        return false;
    L10:
        WeakReference<Activity> r11 = this.e;
        if (r11 == null) goto L15;
        Activity r12 = r11.get();
        if (r12 == null) goto L15;
        m(r12, true);
    L15:
        s r13 = this.f;
        if (r13 == null) goto L18;
        r13.e();
    L18:
        this.f = null;
        return true;
    L5:
        r1 = null;
        goto L7
    }

    public final boolean k(Activity r10) {
        if (this.e != null) goto L6;
        if (r10 == null) goto L6;
        p(r10);
    L6:
        FrameLayout r11 = o(r10);
        i2.a r1 = this.a;
        if (r1 != null) goto L10;
        if (r11 == null) goto L10;
        this.d = new WeakReference(r11);
        return false;
    L10:
        ViewParent r12 = null;
        if (r1 == null) goto L13;
        ViewParent r13 = r1.getParent();
    L14:
        if (r13 != r11) goto L17;
        return false;
    L17:
        if (r11 != null) goto L19;
        com.bytedance.ai.utils.g.a.e("WebViewFloatingPage", "FloatingViewManager attach FloatingView fail, container is null");
        return false;
    L19:
        i2.a r14 = this.a;
        if (r14 == null) goto L22;
        ViewParent r15 = r14.getParent();
    L23:
        ViewGroup r16 = (ViewGroup) r15;
        if (r16 == null) goto L26;
        r16.removeView(this.a);
    L26:
        FrameLayout r17 = this.b;
        if (r17 == null) goto L29;
        r12 = r17.getParent();
    L29:
        ViewGroup r18 = (ViewGroup) r12;
        if (r18 == null) goto L32;
        r18.removeView(this.b);
    L32:
        this.d = new WeakReference(r11);
        FrameLayout r19 = this.b;     // Catch: IllegalArgumentException -> L43 IllegalStateException -> L45
        if (r19 == null) goto L36;
        r11.addView(r19);     // Catch: IllegalArgumentException -> L43 IllegalStateException -> L45
    L36:
        i2.a r20 = this.a;     // Catch: IllegalArgumentException -> L43 IllegalStateException -> L45
        if (r20 != null) goto L39;
    L41:
        com.bytedance.ai.utils.g.a.d("WebViewFloatingPage", "FloatingViewManager attach FloatingView success");     // Catch: IllegalArgumentException -> L43 IllegalStateException -> L45
        return true;
    L39:
        if (this.c == false) goto L41;
        r20.d();     // Catch: IllegalArgumentException -> L43 IllegalStateException -> L45
        r11.addView(r20);     // Catch: IllegalArgumentException -> L43 IllegalStateException -> L45
        r20.setVisibility(0);     // Catch: IllegalArgumentException -> L43 IllegalStateException -> L45
    L43:
        e = move-exception;
        com.bytedance.ai.utils.g.a.e("WebViewFloatingPage", "FloatingViewManager attach FloatingView fail, msg=" + e.getMessage(), e);
        return false;
    L45:
        e = move-exception;
        com.bytedance.ai.utils.g.a.e("WebViewFloatingPage", "FloatingViewManager attach FloatingView fail, msg=" + e.getMessage(), e);
        return false;
    L22:
        r15 = null;
        goto L23
    L13:
        r13 = null;
        goto L14
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity r10) {
        Intrinsics.checkNotNullParameter(r10, "p0");
        ((Handler) this.g.getValue()).removeCallbacksAndMessages(r10);
        m(r10, false);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity r10) {
        Intrinsics.checkNotNullParameter(r10, "p0");
        HandlerCompat.postDelayed((Handler) this.g.getValue(), new b(this, r10), r10, 100);
    }

    public final void p(Activity r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
        this.e = new WeakReference(r10);
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r0 = AppletRuntimeManager.d;
        if (r0 == null) goto L10;
        Pair<Integer, Integer> r11 = r0.L(r10);
        if (r11 == null) goto L11;
        i2.a r1 = this.a;
        if (r1 == null) goto L12;
        r1.e(r11);
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // i2.j
    public final boolean a(String r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "viewId");
        s r0 = this.f;
        Unit r1 = null;
        if (r0 == null) goto L5;
        String r12 = r0.getPageID();
    L7:
        if (Intrinsics.areEqual(r10, r12) == true) goto L9;
        return false;
    L9:
        WeakReference<FrameLayout> r13 = this.d;
        if (r13 == null) goto L38;
        FrameLayout r14 = r13.get();
        if (r14 == null) goto L38;
        i2.a r15 = this.a;
        if (r15 == null) goto L36;
        com.bytedance.ai.utils.g r16 = com.bytedance.ai.utils.g.a;
        r16.d("WebViewFloatingPage", "setFloatingWidgetVisible viewId=" + r10 + ", show=" + r11);
        if (r11 == true) goto L18;
        r14.removeView(r15);
        this.c = false;
        s r17 = this.f;
        if (r17 == null) goto L33;
        r17.i();
        r1 = Unit.INSTANCE;
    L33:
        if (r1 == null) goto L36;
        return true;
    L18:
        if (r14.indexOfChild(r15) == (-1)) goto L20;
        boolean r18 = true;
    L21:
        if (r18 == false) goto L24;
        r16.d("WebViewFloatingPage", "floating view already show, visible=" + r15.getVisibility() + ", top=" + r15.getTop() + ", left=" + r15.getLeft() + ", right=" + r15.getRight() + ", bottom=" + r15.getBottom());
        return true;
    L24:
        ViewGroup r19 = (ViewGroup) r15.getParent();
        if (r19 == null) goto L27;
        r19.removeView(r15);
    L27:
        r15.d();
        r14.addView(r15);
        this.c = true;
        s r110 = this.f;
        if (r110 == null) goto L33;
        r110.a();
        r1 = Unit.INSTANCE;
        goto L33
    L20:
        r18 = false;
    L36:
        IllegalStateException r20 = new IllegalStateException("FloatingView is null");
        com.bytedance.ai.utils.g.a.e("WebViewFloatingPage", r20.getMessage(), r20);
        return false;
    L38:
        IllegalStateException r21 = new IllegalStateException("Container is null");
        com.bytedance.ai.utils.g.a.e("WebViewFloatingPage", r21.getMessage(), r21);
        return false;
    L5:
        r12 = null;
        goto L7
    }

    @Override // i2.j
    public final boolean c(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "pageName");
        Intrinsics.checkNotNullParameter(r11, "packageName");
        s r0 = this.f;
        if (r0 == null) goto L11;
        PageInfo r1 = r0.getPageInfo();
        if (r1 == null) goto L11;
        if (Intrinsics.areEqual(r1.getPageName(), r10) == false) goto L11;
        if (Intrinsics.areEqual(r1.getPackageName(), r11) == false) goto L11;
        return true;
    L11:
        return false;
    }

    public final f m(Activity r10, boolean r11) {
        FrameLayout r12 = o(r10);
        i2.a r0 = this.a;     // Catch: IllegalArgumentException -> L30
        if (r0 != null) goto L6;
    L12:
        FrameLayout r1 = this.b;     // Catch: IllegalArgumentException -> L30
        if (r1 != null) goto L15;
    L21:
        WeakReference<FrameLayout> r13 = this.d;     // Catch: IllegalArgumentException -> L30
        if (r13 == null) goto L24;
        FrameLayout r14 = r13.get();     // Catch: IllegalArgumentException -> L30
    L25:
        if (r14 != r12) goto L27;
        this.d = null;     // Catch: IllegalArgumentException -> L30
    L27:
        if (r11 == false) goto L34;
        this.a = null;     // Catch: IllegalArgumentException -> L30
        this.b = null;     // Catch: IllegalArgumentException -> L30
    L34:
        return this;
    L24:
        r14 = null;
        goto L25
    L15:
        if (ViewCompat.isAttachedToWindow(r1) == true) goto L18;
        r1 = null;
    L18:
        if (r1 == null) goto L21;
        if (r12 == null) goto L21;
        r12.removeView(r1);     // Catch: IllegalArgumentException -> L30
        goto L21
    L6:
        if (ViewCompat.isAttachedToWindow(r0) == true) goto L9;
        r0 = null;
    L9:
        if (r0 == null) goto L12;
        if (r12 == null) goto L12;
        r12.removeView(r0);     // Catch: IllegalArgumentException -> L30
    L30:
        e = move-exception;
        String r15 = e.getMessage();
        if (r15 == null) goto L34;
        com.bytedance.ai.utils.g.a.e("WebViewFloatingPage", r15);
        goto L34
    }

    public final boolean n(String r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "viewId");
        s r0 = this.f;
        if (r0 == null) goto L5;
        String r1 = r0.getPageID();
    L7:
        if (Intrinsics.areEqual(r10, r1) == true) goto L9;
        return false;
    L9:
        FrameLayout r12 = this.b;
        if (r12 == null) goto L16;
        if (r11 == false) goto L13;
        r12.setVisibility(0);
        return true;
    L13:
        r12.setVisibility(8);
        return true;
    L16:
        return true;
    L5:
        r1 = null;
        goto L7
    }

    @Override // i2.j
    public final int d(s r10, PageInfo r11, FragmentActivity r12) {
        Intrinsics.checkNotNullParameter(r10, AIStateLogRequest.SOURCE_PAGE);
        Intrinsics.checkNotNullParameter(r11, "pageInfo");
        double r0 = r11.getPos();
        boolean r13 = r11.getAlignLeft();
        Intrinsics.checkNotNullParameter(r10, "webViewFloatingPage");
        monitor-enter(this);
        h2.a r14 = f2.b.c;     // Catch: Throwable -> L51
        if (r14 == null) goto L7;
        Context r15 = r14.a;     // Catch: Throwable -> L51
    L9:
        if (this.a != null) goto L35;
        if (r15 == null) goto L35;
        i2.a r16 = new i2.a(r15, this.h);     // Catch: Throwable -> L51
        this.a = r16;     // Catch: Throwable -> L51
        r16.setFirstPos(r0);     // Catch: Throwable -> L51
        FrameLayout.LayoutParams r1 = new FrameLayout.LayoutParams(-2, -2);     // Catch: Throwable -> L51
        if (r13 == false) goto L15;
        int r17 = 8388611;
    L16:
        r1.gravity = r17 | 48;     // Catch: Throwable -> L51
        r1.setMargins(0, r1.topMargin, 0, r1.bottomMargin);     // Catch: Throwable -> L51
        r16.setLayoutParams(r1);     // Catch: Throwable -> L51
        FrameLayout r18 = new FrameLayout(r15);     // Catch: Throwable -> L51
        this.b = r18;     // Catch: Throwable -> L51
        r18.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));     // Catch: Throwable -> L51
        FrameLayout r19 = this.b;     // Catch: Throwable -> L51
        if (r19 == null) goto L19;
        r19.setBackgroundColor(-16777216);     // Catch: Throwable -> L51
    L19:
        FrameLayout r20 = this.b;     // Catch: Throwable -> L51
        if (r20 == null) goto L24;
        Drawable r21 = r20.getBackground();     // Catch: Throwable -> L51
        if (r21 == null) goto L24;
        r21.setAlpha(40);     // Catch: Throwable -> L51
    L24:
        FrameLayout r22 = this.b;     // Catch: Throwable -> L51
        if (r22 == null) goto L27;
        r22.setVisibility(4);     // Catch: Throwable -> L51
    L27:
        FrameLayout r23 = this.b;     // Catch: Throwable -> L51
        if (r23 == null) goto L30;
        r23.setClickable(true);     // Catch: Throwable -> L51
    L30:
        FrameLayout r24 = this.b;     // Catch: Throwable -> L51
        if (r24 == null) goto L33;
        r24.setOnClickListener(new d(this));     // Catch: Throwable -> L51
    L33:
        monitor-exit(this);
        boolean r25 = true;
    L38:
        if (r25 == true) goto L40;
        com.bytedance.ai.utils.g.a.e("WebViewFloatingPage", "floating view already exist");
        boolean r26 = false;
    L46:
        boolean r110 = k(r12);
        r10.a();
        if (r26 == false) goto L55;
        if (r110 == false) goto L56;
        return 1;
    L56:
        return 0;
    L55:
        return 0;
    L40:
        View r27 = r10.realView();
        if (r27 == null) goto L45;
        r27.setVisibility(0);
        i2.a r28 = this.a;
        if (r28 == null) goto L45;
        r28.q.addView(r27);
    L45:
        this.f = r10;
        r26 = true;
        goto L46
    L15:
        r17 = 8388613;
    L35:
        IllegalStateException r29 = new IllegalStateException("ensureFloatingView: mFloatingView=" + this.a + ", context=" + r15);     // Catch: Throwable -> L51
        com.bytedance.ai.utils.g.a.e("WebViewFloatingPage", r29.getMessage(), r29);     // Catch: Throwable -> L51
        monitor-exit(this);
        r25 = false;
        goto L38
    L7:
        r15 = null;
    L51:
        th = move-exception;
        throw th;
    }

    @Override // i2.j
    public final void f(s r1, int r10, int r11) {
        Intrinsics.checkNotNullParameter(r1, AIStateLogRequest.SOURCE_PAGE);
        i2.a r12 = this.a;
        if (r12 == null) goto L6;
        r12.setRealWidth(r10);
        return;
    }
}
