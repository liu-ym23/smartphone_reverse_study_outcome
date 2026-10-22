package com.larus.reach.impl;

import android.R;
import android.app.Activity;
import android.app.Application;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.larus.common_ui.presentation.UiPresentationChannel;
import com.larus.platform.model.video.sdkwrapper.feed.CustomFeedPlayerEvent;
import com.larus.reach.api.ReachCloseReason;
import com.larus.reach.api.ReachPresentationCapability;
import com.larus.reach.api.ReachPresentationCapabilityProvider;
import com.larus.reach.api.ReachSceneLifecycleListener;
import com.larus.reach.ui.ReachSwipeDismissLayout;
import com.larus.utils.i0;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.WindowManagerLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import ns9.k;
import v19.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class c0 implements n19.b {
    public final Handler a;
    public boolean b;
    public int c;
    public WeakReference<Activity> d;
    public FrameLayout e;
    public WindowManager f;
    public boolean g;
    public final LinkedHashMap<String, c> h;
    public Context i;
    public boolean j;
    public final d k;

    public static final class a {
    }

    public static final class b {
        public final String a;
        public final ReachCloseReason b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "PendingReplacement(reachUniqueId=" + this.a + ", reason=" + this.b + ')';
        }

        public b(String r2, ReachCloseReason r3) {
            Intrinsics.checkNotNullParameter(r2, "reachUniqueId");
            Intrinsics.checkNotNullParameter(r3, CustomFeedPlayerEvent.EXTRA_KEY_REASON);
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class c {
        public final ns9.t a;
        public final ns9.g b;
        public final boolean c;
        public final WeakReference<Activity> d;
        public b e;
        public final ns9.c f;
        public boolean g;
        public boolean h;
        public long i;

        public c() {
            throw null;
        }

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof c) == true) goto L8;
            return false;
        L8:
            c r9 = (c) r8;
            if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
            return false;
        L15:
            if (this.c == r9.c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r9.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r9.e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r9.f) == true) goto L27;
            return false;
        L27:
            if (this.g == r9.g) goto L30;
            return false;
        L30:
            if (this.h == r9.h) goto L33;
            return false;
        L33:
            if (this.i == r9.i) goto L35;
            return false;
        L35:
            return true;
        }

        public final int hashCode() {
            int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
            int r2 = 1231;
            if (this.c == false) goto L5;
            int r1 = 1231;
        L6:
            int r3 = (r0 + r1) * 31;
            WeakReference<Activity> r4 = this.d;
            int r5 = 0;
            if (r4 != null) goto L9;
            int r6 = 0;
        L10:
            int r7 = (r3 + r6) * 31;
            b r8 = this.e;
            if (r8 != null) goto L13;
            int r9 = 0;
        L14:
            int r10 = (r7 + r9) * 31;
            ns9.c r11 = this.f;
            if (r11 == null) goto L18;
            r5 = r11.hashCode();
        L18:
            int r12 = (r10 + r5) * 31;
            if (this.g == false) goto L21;
            int r13 = 1231;
        L22:
            int r14 = (r12 + r13) * 31;
            if (this.h == true) goto L26;
            r2 = 1237;
        L26:
            long r15 = this.i;
            return ((r14 + r2) * 31) + ((int) (r15 ^ (r15 >>> 32)));
        L21:
            r13 = 1237;
            goto L22
        L13:
            r9 = r8.hashCode();
            goto L14
        L9:
            r6 = r4.hashCode();
            goto L10
        L5:
            r1 = 1237;
            goto L6
        }

        public final String toString() {
            return "StackEntry(request=" + this.a + ", session=" + this.b + ", isP0=" + this.c + ", boundActivity=" + this.d + ", pendingReplacement=" + this.e + ", content=" + this.f + ", foreground=" + this.g + ", dismissing=" + this.h + ", transitionGeneration=" + this.i + ')';
        }

        public c(ns9.t r2, ns9.g r3, boolean r4, WeakReference r5, b r6, ns9.c r7) {
            Intrinsics.checkNotNullParameter(r2, "request");
            Intrinsics.checkNotNullParameter(r3, "session");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
            this.g = false;
            this.h = false;
            this.i = 0;
        }
    }

    public static final class d implements Application.ActivityLifecycleCallbacks {
        public final /* synthetic */ c0 a;

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity r1, Bundle r2) {
            Intrinsics.checkNotNullParameter(r1, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity r2, Bundle r3) {
            Intrinsics.checkNotNullParameter(r2, "activity");
            Intrinsics.checkNotNullParameter(r3, "outState");
        }

        public d(c0 r1) {
            this.a = r1;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity r3) {
            Intrinsics.checkNotNullParameter(r3, "activity");
            WeakReference<Activity> r0 = this.a.d;
            Context r1 = null;
            if (r0 == null) goto L5;
            Activity r2 = r0.get();
        L7:
            if (Intrinsics.areEqual(r2, r3) == false) goto L9;
            this.a.d = null;
        L9:
            FrameLayout r4 = this.a.e;
            if (r4 == null) goto L13;
            r1 = r4.getContext();
        L13:
            if (Intrinsics.areEqual(r1, r3) == false) goto L16;
            this.a.d();
            return;
        L16:
            return;
        L5:
            r2 = null;
            goto L7
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity r8) {
            Intrinsics.checkNotNullParameter(r8, "activity");
            Collection<c> r0 = this.a.h.values();
            ArrayList r1 = new ArrayList();
            Iterator<T> r2 = r0.iterator();
        L4:
            if (r2.hasNext() == false) goto L8;
            Object r3 = r2.next();
            if (((c) r3).h == true) goto L4;
            r1.add(r3);
            goto L4
        L8:
            c0 r4 = this.a;
            ArrayList r5 = new ArrayList();
            Iterator r6 = r1.iterator();
        L9:
            Activity r7 = null;
            if (r6.hasNext() == false) goto L21;
            Object r9 = r6.next();
            c r10 = (c) r9;
            WeakReference<Activity> r11 = r10.d;
            if (r11 == null) goto L14;
            r7 = r11.get();
        L14:
            if (r7 != r8) goto L18;
            ns9.t r12 = r10.a;
            r4.getClass();
            boolean r13 = true;
            if (StringsKt.equals(r12.e.b.get("dismiss_on_activity_pause"), "true", true) == false) goto L18;
        L19:
            if (r13 == false) goto L9;
            r5.add(r9);
        L18:
            r13 = false;
            goto L19
        L21:
            List r14 = CollectionsKt.toList(r5);
            c0 r15 = this.a;
            Iterator r16 = r14.iterator();
        L23:
            if (r16.hasNext() == false) goto L25;
            r15.e(((c) r16.next()).a.a.h, ReachCloseReason.PAGE_LEAVE);
            goto L23
        L25:
            int r17 = com.larus.reach.runtime.v.a;
            k r18 = k.a;
            monitor-enter(r18);
            k.c++;     // Catch: Throwable -> L32
            Function0<Unit> r19 = k.b;     // Catch: Throwable -> L32
            k.b = null;     // Catch: Throwable -> L32
            monitor-exit(r18);
            if (r19 == null) goto L48;
            r19.invoke();
            return;
        L48:
            return;
        L32:
            th = move-exception;
            throw th;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity r6) {
            Intrinsics.checkNotNullParameter(r6, "activity");
            this.a.d = new WeakReference(r6);
            int r0 = com.larus.reach.runtime.v.a;
            k r1 = k.a;
            monitor-enter(r1);
            k.c++;     // Catch: Throwable -> L10
            Function0<Unit> r2 = k.b;     // Catch: Throwable -> L10
            k.b = null;     // Catch: Throwable -> L10
            monitor-exit(r1);
            if (r2 == null) goto L8;
            r2.invoke();
        L8:
            this.a.m(r6, null, true);
            return;
        L10:
            th = move-exception;
            throw th;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity r8) {
            Intrinsics.checkNotNullParameter(r8, "activity");
            c0 r0 = this.a;
            r0.c++;
            r0.d = new WeakReference(r8);
            int r1 = com.larus.reach.runtime.v.a;
            k r2 = k.a;
            monitor-enter(r2);
            k.c++;     // Catch: Throwable -> L10
            Function0<Unit> r3 = k.b;     // Catch: Throwable -> L10
            k.b = null;     // Catch: Throwable -> L10
            monitor-exit(r2);
            if (r3 == null) goto L8;
            r3.invoke();
        L8:
            this.a.m(r8, null, true);
            return;
        L10:
            th = move-exception;
            throw th;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity r6) {
            Intrinsics.checkNotNullParameter(r6, "activity");
            c0 r7 = this.a;
            r7.c = RangesKt.coerceAtLeast(r7.c - 1, 0);
            c0 r8 = this.a;
            if (r8.c != 0) goto L29;
            Collection<c> r9 = r8.h.values();
            c0 r0 = this.a;
            ArrayList r2 = new ArrayList();
            Iterator<T> r10 = r9.iterator();
        L6:
            if (r10.hasNext() == false) goto L10;
            Object r3 = r10.next();
            ns9.t r4 = ((c) r3).a;
            r0.getClass();
            if (c0.p(r4) == true) goto L6;
            r2.add(r3);
            goto L6
        L10:
            ArrayList r11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
            Iterator r1 = r2.iterator();
        L12:
            if (r1.hasNext() == false) goto L14;
            r11.add(((c) r1.next()).a.a.h);
            goto L12
        L14:
            c0 r5 = this.a;
            Iterator r12 = r11.iterator();
        L16:
            if (r12.hasNext() == false) goto L19;
            r5.e((String) r12.next(), ReachCloseReason.PAGE_LEAVE);
            goto L16
        L19:
            if ((!this.a.h.isEmpty()) == false) goto L30;
            this.a.o(null, true);
            return;
        L30:
            return;
        }
    }

    static {
    }

    public final void a() {
        if (this.h.isEmpty() == false) goto L12;
        FrameLayout r0 = this.e;
        boolean r1 = false;
        if (r0 != null) goto L7;
    L9:
        if (r1 == false) goto L13;
        d();
        return;
    L13:
        return;
    L7:
        if (r0.getChildCount() != 0) goto L9;
        r1 = true;
        goto L9
    }

    public final Activity b() {
        WeakReference<Activity> r0 = this.d;
        if (r0 == null) goto L7;
        Activity r1 = r0.get();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return com.larus.reach.runtime.t.b();
    }

    public final void d() {
        FrameLayout r0 = this.e;
        if (r0 != null) goto L5;
    L15:
        if (r0 == null) goto L22;
        ViewParent r2 = r0.getParent();
        if ((r2 instanceof ViewGroup) == false) goto L19;
        ViewGroup r3 = (ViewGroup) r2;
    L20:
        if (r3 == null) goto L22;
        r3.removeView(r0);
        goto L22
    L19:
        r3 = null;
    L22:
        this.e = null;
        this.f = null;
        this.g = false;
        return;
    L5:
        if (this.g == false) goto L15;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L12
        WindowManager r5 = this.f;     // Catch: Throwable -> L12
        if (r5 == null) goto L9;
        r5.removeViewImmediate(r0);     // Catch: Throwable -> L12
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L12
    L10:
        Object r6 = Result.constructor-impl(r1);     // Catch: Throwable -> L12
    L14:
        Result.box-impl(r6);
        goto L22
    L9:
        r1 = null;
    L12:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    }

    public final void i() {
        if (this.b == false) goto L5;
        return;
    L5:
        this.b = true;
        n19.a r1 = n19.a.a;
        r1.c(UiPresentationChannel.REACH, this);
        r1.c(UiPresentationChannel.LEGACY_ACTIVITY_NOTIFICATION, this);
        com.larus.reach.runtime.t.a().registerActivityLifecycleCallbacks(this.k);
        Activity r2 = com.larus.reach.runtime.t.b();
        if (r2 == null) goto L9;
        this.d = new WeakReference(r2);
        this.c = 1;
        return;
    }

    public c0() {
        this.a = new Handler(Looper.getMainLooper());
        this.h = new LinkedHashMap();
        this.k = new d(this);
    }

    public static Integer q() {
        Application r0 = com.larus.reach.runtime.t.a();
        Object r1 = r0.getSystemService("keyguard");
        if ((r1 instanceof KeyguardManager) == false) goto L5;
        KeyguardManager r2 = (KeyguardManager) r1;
    L6:
        if (r2 == null) goto L10;
        boolean r3 = true;
        if (r2.isKeyguardLocked() != true) goto L10;
    L11:
        if (r3 == false) goto L13;
    L17:
        if (r3 == false) goto L20;
        return 2009;
    L20:
        if (Build.VERSION.SDK_INT < 26) goto L23;
        return 2038;
    L23:
        return 2002;
    L13:
        if (Build.VERSION.SDK_INT < 23) goto L17;
        if (Settings.canDrawOverlays(r0) == true) goto L17;
        return null;
    L10:
        r3 = false;
        goto L11
    L5:
        r2 = null;
        goto L6
    }

    public final Activity c() {
        Activity r0 = b();
        if (r0 == null) goto L15;
        if (r0.isFinishing() == false) goto L7;
    L11:
        boolean r2 = false;
    L12:
        if (r2 == false) goto L15;
        return r0;
    L7:
        if (r0.isDestroyed() == true) goto L11;
        if (k(r0) == false) goto L11;
        r2 = true;
    L15:
        return null;
    }

    public static boolean p(ns9.t r7) {
        Map<String, ? extends List<? extends ReachSceneLifecycleListener>> r0 = com.larus.reach.runtime.y.a;
        Intrinsics.checkNotNullParameter(r7, "request");
        String r1 = r7.a.c;
        List r2 = (List) com.larus.reach.runtime.y.b().get("*");
        if (r2 != null) goto L5;
        r2 = CollectionsKt.emptyList();
    L5:
        List r3 = r2;
        List r4 = (List) com.larus.reach.runtime.y.b().get(r1);
        if (r4 != null) goto L8;
        r4 = CollectionsKt.emptyList();
    L8:
        List r5 = CollectionsKt.plus(r3, r4);
        ArrayList r6 = new ArrayList();
        Iterator r8 = r5.iterator();
    L10:
        if (r8.hasNext() == false) goto L24;
        ReachPresentationCapabilityProvider r9 = (ReachPresentationCapabilityProvider) r8.next();
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L14
        Object r11 = Result.constructor-impl(r9.e(r7));     // Catch: Throwable -> L14
    L16:
        Throwable r12 = Result.exceptionOrNull-impl(r11);
        if (r12 == null) goto L19;
        FLogger.a.w("ReachSceneDispatcher", "reach scene capability failed, reachUniqueId=" + r7.a.h + ", scene=" + r7.a.c, r12);
    L19:
        Set r13 = SetsKt.emptySet();
        if (Result.isFailure-impl(r11) == false) goto L22;
        r11 = r13;
    L22:
        CollectionsKt.addAll(r6, (Iterable) r11);
    L14:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L16
    L24:
        return CollectionsKt.toSet(r6).contains(ReachPresentationCapability.APPLICATION_OVERLAY);
    }

    public final boolean k(Activity r4) {
        if ((r4 instanceof LifecycleOwner) == false) goto L5;
        LifecycleOwner r0 = (LifecycleOwner) r4;
    L6:
        if (r0 == null) goto L12;
        Lifecycle r1 = r0.getLifecycle();
        if (r1 == null) goto L12;
        Lifecycle.State r2 = r1.getCurrentState();
        if (r2 == null) goto L12;
        return r2.isAtLeast(Lifecycle.State.RESUMED);
    L12:
        boolean r5 = r4.hasWindowFocus();
        if (com.larus.home.impl.utils.c.e == false) goto L19;
        FLogger.a.i("DecorViewLancet", "hasWindowFocus");
        Thread r3 = ThreadMethodProxy.currentThread();
        if (r3 == com.larus.home.impl.utils.c.a) goto L20;
        com.larus.home.impl.utils.c.a(r3, "hasWindowFocus");
        return r5;
    L20:
        return r5;
    L19:
        return r5;
    L5:
        r0 = null;
        goto L6
    }

    public final void l(c r3) {
        if (CollectionsKt.lastOrNull(this.h.values()) == r3) goto L5;
        return;
    L5:
        if (r3.h == false) goto L7;
        return;
    L7:
        if (r3.g == false) goto L9;
        return;
    L9:
        if (n19.a.a.d(UiPresentationChannel.LEGACY_ACTIVITY_NOTIFICATION) == true) goto L22;
        r3.g = true;
        r3.b.c();
        ns9.c r4 = r3.f;
        if (r4 == null) goto L20;
        View r5 = r4.b;
        if (r5 == null) goto L21;
        s(r5, true);
        return;
    L21:
        return;
    L20:
        return;
    }

    public final void r(final Function0<Unit> r3) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        r3.invoke();
        return;
    L5:
        this.a.post(new q(r3));
    }

    public static void s(View r0, boolean r1) {
        r0.setClickable(r1);
        r0.setFocusable(r1);
        if (r1 == false) goto L5;
        int r2 = 0;
    L6:
        r0.setImportantForAccessibility(r2);
        return;
    L5:
        r2 = 4;
        goto L6
    }

    public final void e(final String r2, final ReachCloseReason r3) {
        Intrinsics.checkNotNullParameter(r2, "reachUniqueId");
        Intrinsics.checkNotNullParameter(r3, CustomFeedPlayerEvent.EXTRA_KEY_REASON);
        r(new v(this, r2, r3));
    }

    public final void f(UiPresentationChannel r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r5, "channel");
        if (r5 != UiPresentationChannel.LEGACY_ACTIVITY_NOTIFICATION) goto L11;
        if (r6 == false) goto L6;
        r(new o(this));
        return;
    L6:
        boolean r7 = !this.j;
        this.j = false;
        if (r7 == false) goto L9;
        r(new w(this));
    L9:
        com.larus.reach.runtime.v.c();
        return;
    L11:
        if (r6 == false) goto L13;
        return;
    L13:
        if (r5 != UiPresentationChannel.REACH) goto L27;
        int r8 = com.larus.reach.runtime.v.a;
        k r9 = k.a;
        monitor-enter(r9);
        k.c++;     // Catch: Throwable -> L20
        Function0<Unit> r10 = k.b;     // Catch: Throwable -> L20
        k.b = null;     // Catch: Throwable -> L20
        monitor-exit(r9);
        if (r10 == null) goto L28;
        r10.invoke();
        return;
    L28:
        return;
    L20:
        th = move-exception;
        throw th;
    }

    public final void g(c r5, ReachCloseReason r6) {
        if (this.h.get(r5.a.a.h) == r5) goto L5;
        return;
    L5:
        this.h.remove(r5.a.a.h);
        ns9.c r0 = r5.f;
        ViewGroup r1 = null;
        if (r0 == null) goto L8;
        View r2 = r0.a;
    L9:
        if (r2 == null) goto L13;
        ViewPropertyAnimator r3 = r2.animate();
        if (r3 == null) goto L13;
        r3.cancel();
    L13:
        if (r2 == null) goto L15;
        ViewParent r4 = r2.getParent();
    L17:
        if ((r4 instanceof ViewGroup) == false) goto L19;
        r1 = (ViewGroup) r4;
    L19:
        if (r1 == null) goto L21;
        r1.removeView(r2);
    L21:
        r5.b.b(r6);
        return;
    L15:
        r4 = null;
        goto L17
    L8:
        r2 = null;
        goto L9
    }

    public final int h(int r2, View r3) {
        Resources r4 = r3.getResources();
        return (int) ((r2 * WindowDisplayMetricsOverride.apply(r4, r4.getDisplayMetrics()).density) + 0.5f);
    }

    public final void j(c r8, ReachCloseReason r9) {
        if (this.h.get(r8.a.a.h) == r8) goto L6;
        return;
    L6:
        if (CollectionsKt.lastOrNull(this.h.values()) != r8) goto L8;
        boolean r0 = true;
    L9:
        this.h.remove(r8.a.a.h);
        ns9.c r3 = r8.f;
        if (r3 == null) goto L12;
        View r4 = r3.a;
    L13:
        if (r4 == null) goto L17;
        ViewPropertyAnimator r5 = r4.animate();
        if (r5 == null) goto L17;
        r5.cancel();
    L17:
        if (r4 == null) goto L19;
        ViewParent r6 = r4.getParent();
    L21:
        if ((r6 instanceof ViewGroup) == false) goto L23;
        ViewGroup r7 = (ViewGroup) r6;
    L24:
        if (r7 == null) goto L26;
        r7.removeView(r4);
    L26:
        r8.b.b(r9);
        Activity r10 = c();
        if (r0 == true) goto L29;
    L31:
        boolean r11 = false;
    L32:
        if (r0 == false) goto L38;
        if (r10 == null) goto L36;
        m(r10, null, r11);
    L43:
        a();
        return;
    L36:
        if ((!this.h.isEmpty()) == false) goto L43;
        o(null, r11);
        goto L43
    L38:
        if (r10 == null) goto L41;
        m(r10, null, false);
        goto L43
    L41:
        if ((!this.h.isEmpty()) == false) goto L43;
        o(null, false);
        goto L43
    L29:
        if (n19.a.a.d(UiPresentationChannel.LEGACY_ACTIVITY_NOTIFICATION) == true) goto L31;
        r11 = true;
        goto L32
    L23:
        r7 = null;
        goto L24
    L19:
        r6 = null;
        goto L21
    L12:
        r4 = null;
        goto L13
    L8:
        r0 = false;
        goto L9
    }

    public final boolean o(final String r13, final boolean r14) {
        if (this.h.isEmpty() == false) goto L6;
        a();
        return true;
    L6:
        c r0 = (c) CollectionsKt.lastOrNull(this.h.values());
        if (r0 == null) goto L13;
        ns9.t r1 = r0.a;
        if (r1 == null) goto L13;
        if (p(r1) != true) goto L13;
        boolean r2 = true;
    L14:
        if (r2 == true) goto L16;
        return false;
    L16:
        FrameLayout r3 = this.e;
        final FrameLayout r4 = null;
        Object r5 = null;
        r4 = null;
        if (r3 != null) goto L19;
    L24:
        Integer r6 = q();
        if (r6 == null) goto L45;
        int r7 = r6.intValue();
        d();
        Object r8 = com.larus.reach.runtime.t.a().getSystemService("window");
        if ((r8 instanceof WindowManager) == false) goto L29;
        WindowManager r9 = (WindowManager) r8;
    L30:
        if (r9 == null) goto L45;
        Context r10 = this.i;
        if (r10 != null) goto L35;
        r10 = f.d(com.larus.reach.runtime.t.a());
        this.i = r10;
    L35:
        FrameLayout r11 = new FrameLayout(r10);
        r11.setClipChildren(false);
        r11.setClipToPadding(false);
        r11.setClickable(false);
        r11.setImportantForAccessibility(2);
        WindowManager.LayoutParams r12 = new WindowManager.LayoutParams(-1, -2, r7, 8, -3);
        r12.gravity = 48;
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L38
        WindowManagerLancet.bindToAssistantWindowIfNeeded(r11, r12);     // Catch: Throwable -> L38
        r9.addView(r11, r12);     // Catch: Throwable -> L38
        this.e = r11;     // Catch: Throwable -> L38
        this.f = r9;     // Catch: Throwable -> L38
        this.g = true;     // Catch: Throwable -> L38
        Object r16 = Result.constructor-impl(r11);     // Catch: Throwable -> L38
    L41:
        if (Result.isFailure-impl(r16) == true) goto L44;
        r5 = r16;
    L44:
        r4 = (FrameLayout) r5;
    L38:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L41
    L29:
        r9 = null;
    L45:
        if (r4 != null) goto L48;
        return false;
    L48:
        if (r4.getWidth() > 0) goto L51;
        r4.post(new t(this, r4, r13, r14));
        return true;
    L51:
        n(r4, r4, r13, r14);
        return true;
    L19:
        if (this.g == true) goto L22;
        r3 = null;
    L22:
        if (r3 == null) goto L24;
        r4 = r3;
    L13:
        r2 = false;
        goto L14
    }

    public final void m(final Activity r7, final String r8, final boolean r9) {
        if (this.h.isEmpty() == false) goto L6;
        a();
        return;
    L6:
        FrameLayout r0 = (FrameLayout) r7.findViewById(R.id.content);
        if (r0 != null) goto L10;
        return;
    L10:
        if (r0.getWidth() > 0) goto L13;
        r0.post(new u(this, r7, r8, r9));
        return;
    L13:
        Collection<c> r10 = this.h.values();
        ArrayList r1 = new ArrayList();
        Iterator<T> r11 = r10.iterator();
    L15:
        if (r11.hasNext() == false) goto L19;
        Object r2 = r11.next();
        if (((c) r2).h == true) goto L15;
        r1.add(r2);
        goto L15
    L19:
        ArrayList r12 = new ArrayList();
        Iterator r3 = r1.iterator();
    L20:
        boolean r4 = true;
        if (r3.hasNext() == false) goto L25;
        Object r5 = r3.next();
        Map<String, ? extends List<? extends ReachSceneLifecycleListener>> r6 = com.larus.reach.runtime.y.a;
        if ((true ^ com.larus.reach.runtime.y.a(((c) r5).a)) == false) goto L20;
        r12.add(r5);
        goto L20
    L25:
        Iterator r13 = r12.iterator();
    L27:
        if (r13.hasNext() == false) goto L30;
        c r14 = (c) r13.next();
        Intrinsics.checkNotNull(r14);
        g(r14, ReachCloseReason.BUSINESS_NOT_ALLOWED);
        goto L27
    L30:
        if ((!r12.isEmpty()) == false) goto L33;
        a();
    L33:
        if (this.h.isEmpty() == false) goto L36;
        a();
        return;
    L36:
        FrameLayout r15 = this.e;
        if (r15 != null) goto L39;
    L49:
        d();
        r15 = new FrameLayout(r0.getContext());
        r15.setClipChildren(false);
        r15.setClipToPadding(false);
        r15.setClickable(false);
        r15.setImportantForAccessibility(2);
        r0.addView(r15, new FrameLayout.LayoutParams(-1, -1));
        this.e = r15;
    L50:
        n(r0, r15, r8, r9);
        return;
    L39:
        if (this.g == false) goto L41;
    L43:
        r4 = false;
    L44:
        if (r4 == true) goto L47;
        r15 = null;
    L47:
        if (r15 == null) goto L49;
    L41:
        if (Intrinsics.areEqual(r15.getParent(), r0) == false) goto L43;
        goto L43
    }

    public final void n(FrameLayout r20, FrameLayout r21, String r22, boolean r23) {
        if (r22 != null) goto L19;
        Iterator<T> r5 = this.h.values().iterator();
        Object r7 = null;
    L6:
        if (r5.hasNext() == false) goto L13;
        Object r8 = r5.next();
        if (((c) r8).e == null) goto L10;
        boolean r9 = true;
    L11:
        if (r9 == false) goto L6;
        r7 = r8;
        goto L6
    L10:
        r9 = false;
        goto L11
    L13:
        c r10 = (c) r7;
        if (r10 == null) goto L18;
        ns9.t r6 = r10.a;
        if (r6 == null) goto L18;
        String r11 = r6.a.h;
    L20:
        Collection<c> r12 = this.h.values();
        ArrayList r13 = new ArrayList();
        Iterator<T> r14 = r12.iterator();
    L22:
        if (r14.hasNext() == false) goto L26;
        Object r15 = r14.next();
        if (((c) r15).h == true) goto L22;
        r13.add(r15);
        goto L22
    L26:
        Iterator r16 = r13.iterator();
        int r17 = 0;
    L28:
        if (r16.hasNext() == false) goto L83;
        Object r18 = r16.next();
        int r19 = r17 + 1;
        if (r17 >= 0) goto L32;
        CollectionsKt.throwIndexOverflow();
    L32:
        final c r110 = (c) r18;
        ns9.c r111 = r110.f;
        if (r111 == null) goto L82;
        View r112 = r111.a;
        if (r112 == null) goto L82;
        if (r112.getParent() == r21) goto L46;
        ViewParent r113 = r112.getParent();
        if ((r113 instanceof ViewGroup) == false) goto L42;
        ViewGroup r114 = (ViewGroup) r113;
    L43:
        if (r114 == null) goto L45;
        r114.removeView(r112);
    L45:
        r21.addView(r112);
        goto L46
    L42:
        r114 = null;
    L46:
        ns9.c r115 = r110.f;
        if (r115 == null) goto L49;
        Object r116 = r115.b;
    L51:
        if ((r116 instanceof ReachSwipeDismissLayout) == false) goto L53;
        ReachSwipeDismissLayout r117 = (ReachSwipeDismissLayout) r116;
    L54:
        if (r117 == null) goto L56;
        r117.setCanHandleSwipe(new x(r110, this));
        r117.setSwipeDirection(-1);
        r117.setOnSwipeDismiss(new y(this, r110));
    L56:
        int r118 = h(12, r20) * 2;
        int r3 = RangesKt.coerceAtMost(RangesKt.coerceAtMost(RangesKt.coerceAtLeast(r20.getWidth() - r118, 0), h(430, r20)) + r118, r20.getWidth());
        int[] r119 = new int[2];
        r20.getLocationOnScreen(r119);
        WindowInsetsCompat r120 = ViewCompat.getRootWindowInsets(r20);
        if (r120 == null) goto L61;
        Insets r2 = r120.getInsets(WindowInsetsCompat.Type.statusBars());
        if (r2 == null) goto L61;
        int r4 = r2.top;
    L62:
        int r24 = RangesKt.coerceAtLeast(((r4 + h(0, r20)) - h(12, r20)) + (-r119[1]), 0);
        FrameLayout.LayoutParams r121 = new FrameLayout.LayoutParams(r3, -2);
        r121.leftMargin = RangesKt.coerceAtLeast((r20.getWidth() - r3) / 2, 0);
        r121.topMargin = r24;
        r112.setLayoutParams(r121);
        r112.setTranslationX(0.0f);
        r112.setClipBounds(null);
        r112.bringToFront();
        int r25 = CollectionsKt.getLastIndex(r13) - r17;
        if (r22 != null) goto L71;
        if (r23 == true) goto L71;
        if (r25 != 0) goto L71;
        if (r110.g == true) goto L71;
        if (r110.i <= 0) goto L71;
        boolean r26 = true;
    L72:
        if (r26 == true) goto L82;
        boolean r27 = !Intrinsics.areEqual(r11, r110.a.a.h);
        int r122 = RangesKt.coerceAtMost(r25, 1);
        float r123 = h(r122 * 15, r112);
        float r124 = RangesKt.coerceAtLeast(1.0f - (r122 * 0.1f), 0.7f);
        if (r25 != 0) goto L76;
        boolean r28 = true;
    L77:
        s(r112, r28);
        r112.setTranslationZ(RangesKt.coerceAtLeast(3 - r122, 0));
        if (r27 == true) goto L80;
        r112.animate().cancel();
        r112.setTranslationY(r123);
        r112.setScaleX(r124);
        r112.setScaleY(r124);
        r112.setAlpha(1.0f);
        goto L82
    L80:
        r112.animate().translationY(r123).scaleX(r124).scaleY(r124).alpha(1.0f).setDuration(430).start();
        goto L82
    L76:
        r28 = false;
    L71:
        r26 = false;
    L61:
        i0.a.getClass();
        r4 = RangesKt.coerceAtLeast(i0.g(), 0);
        goto L62
    L53:
        r117 = null;
        goto L54
    L49:
        r116 = null;
    L82:
        r17 = r19;
        goto L28
    L83:
        Object r29 = null;
        if (r11 == null) goto L86;
        c r30 = this.h.get(r11);
    L87:
        if (r30 != null) goto L99;
        if (r23 == false) goto L126;
        Iterator<T> r0 = this.h.values().iterator();
    L91:
        if (r0.hasNext() == false) goto L95;
        Object r1 = r0.next();
        if ((!((c) r1).h) == false) goto L91;
        r29 = r1;
        goto L91
    L95:
        c r31 = (c) r29;
        if (r31 == null) goto L127;
        l(r31);
        return;
    L127:
        return;
    L126:
        return;
    L99:
        ns9.c r32 = r30.f;
        if (r32 == null) goto L128;
        final View r33 = r32.a;
        if (r33 == null) goto L129;
        final long r34 = 1 + r30.i;
        r30.i = r34;
        ViewGroup.LayoutParams r35 = r33.getLayoutParams();
        Intrinsics.checkNotNull(r35, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        int r36 = ((FrameLayout.LayoutParams) r35).topMargin;
        s(r33, false);
        r33.animate().cancel();
        r33.setAlpha(0.0f);
        r33.setTranslationY(-(r36 + RangesKt.coerceAtLeast(r33.getHeight(), 1)));
        r33.setScaleX(1.0f);
        r33.setScaleY(1.0f);
        final c r37 = r30;
        r33.post(new z(this, r37, r34, r33));
        return;
    L129:
        return;
    L128:
        return;
    L86:
        r30 = null;
    L18:
        r11 = null;
        goto L20
    L19:
        r11 = r22;
        goto L20
    }
}
