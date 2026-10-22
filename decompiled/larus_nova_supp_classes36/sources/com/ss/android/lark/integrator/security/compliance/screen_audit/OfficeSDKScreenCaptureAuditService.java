package com.ss.android.lark.integrator.security.compliance.screen_audit;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.featuregating.interfaces.IFeatureGatingService;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.q;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.lark.utils.LarkContext;
import f0c.h;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@UserScope
public final class OfficeSDKScreenCaptureAuditService implements q {
    public static final /* synthetic */ int n = 0;
    public final IFeatureGatingService a;
    public final com.ss.android.lark.integrator.security.compliance.screen_audit.d b;
    public final com.ss.android.lark.integrator.security.compliance.screen_audit.b c;
    public final Handler d;
    public final com.ss.android.lark.auditsdk.screen.b e;
    public final f f;
    public final c g;
    public final e h;
    public final d i;
    public boolean j;
    public boolean k;
    public boolean l;
    public Application m;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ OfficeSDKScreenCaptureAuditService a;

        public b(OfficeSDKScreenCaptureAuditService r1) {
            this.a = r1;
        }

        public final void a() {
            OfficeSDKScreenCaptureAuditService r0 = this.a;
            if (r0.k == false) goto L5;
            Log.w("OfficeSDKScreenAudit", "start() called more than once, ignored");
            return;
        L5:
            r0.k = true;
            Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L8
            com.ss.android.lark.auditsdk.wrapper.b.d.a.b();     // Catch: Throwable -> L8
            Object r4 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
        L10:
            Throwable r5 = Result.exceptionOrNull-impl(r4);
            if (r5 == null) goto L14;
            Log.e("OfficeSDKScreenAudit", "AuditModule.init failed", r5);
        L14:
            if (r0.l == true) goto L17;
            r0.a.addFeatureGatingUpdateListener("admin.security.activity_auditing_for_doubao_chat", r0.g, "_normal_fg");
            r0.a.addFeatureGatingUpdateListener("core.custom_mobile.enable_audit_device", r0.h, "_normal_fg");
            r0.a.addFeatureGatingUpdateListener("lark.security.screen_audit.officesdk_common_chain_disabled", r0.i, "_normal_fg");
            r0.l = true;
            Log.i("OfficeSDKScreenAudit", "fg update listeners registered");
        L17:
            r0.b("start");
            return;
        L8:
            th = move-exception;
            Result.Companion r6 = Result.Companion;
            r4 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L10
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

    public static final class c implements jdb.c {
        public final /* synthetic */ OfficeSDKScreenCaptureAuditService a;

        public static final class a implements Runnable {
            public final /* synthetic */ OfficeSDKScreenCaptureAuditService a;

            public a(OfficeSDKScreenCaptureAuditService r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                OfficeSDKScreenCaptureAuditService r0 = this.a;     // Catch: Throwable -> L4
                int r1 = OfficeSDKScreenCaptureAuditService.n;     // Catch: Throwable -> L4
                r0.b("audit fg update");     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public c(OfficeSDKScreenCaptureAuditService r1) {
            this.a = r1;
        }

        public final void a(boolean r3) {
            OfficeSDKScreenCaptureAuditService r4 = this.a;
            r4.d.post(new a(r4));
        }
    }

    public static final class d implements jdb.c {
        public final /* synthetic */ OfficeSDKScreenCaptureAuditService a;

        public static final class a implements Runnable {
            public final /* synthetic */ OfficeSDKScreenCaptureAuditService a;

            public a(OfficeSDKScreenCaptureAuditService r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                OfficeSDKScreenCaptureAuditService r0 = this.a;     // Catch: Throwable -> L4
                int r1 = OfficeSDKScreenCaptureAuditService.n;     // Catch: Throwable -> L4
                r0.b("chain-mode fg update");     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public d(OfficeSDKScreenCaptureAuditService r1) {
            this.a = r1;
        }

        public final void a(boolean r3) {
            OfficeSDKScreenCaptureAuditService r4 = this.a;
            r4.d.post(new a(r4));
        }
    }

    public static final class e implements jdb.c {
        public final /* synthetic */ OfficeSDKScreenCaptureAuditService a;

        public static final class a implements Runnable {
            public final /* synthetic */ OfficeSDKScreenCaptureAuditService a;

            public a(OfficeSDKScreenCaptureAuditService r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                OfficeSDKScreenCaptureAuditService r0 = this.a;     // Catch: Throwable -> L4
                int r1 = OfficeSDKScreenCaptureAuditService.n;     // Catch: Throwable -> L4
                r0.b("device fg update");     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public e(OfficeSDKScreenCaptureAuditService r1) {
            this.a = r1;
        }

        public final void a(boolean r3) {
            OfficeSDKScreenCaptureAuditService r4 = this.a;
            r4.d.post(new a(r4));
        }
    }

    public static final class f implements Application.ActivityLifecycleCallbacks {
        public final /* synthetic */ OfficeSDKScreenCaptureAuditService a;

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity r1, Bundle r2) {
            Intrinsics.checkNotNullParameter(r1, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity r2) {
            Intrinsics.checkNotNullParameter(r2, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity r2) {
            Intrinsics.checkNotNullParameter(r2, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity r2, Bundle r3) {
            Intrinsics.checkNotNullParameter(r2, "activity");
            Intrinsics.checkNotNullParameter(r3, "outState");
        }

        public f(OfficeSDKScreenCaptureAuditService r1) {
            this.a = r1;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity r3) {
            Intrinsics.checkNotNullParameter(r3, "activity");
            com.ss.android.lark.integrator.security.compliance.screen_audit.d r1 = this.a.b;
            r1.getClass();
            Intrinsics.checkNotNullParameter(r3, "activity");
            r1.c(r3);
            this.a.c.getClass();
            Intrinsics.checkNotNullParameter(r3, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity r2) {
            Intrinsics.checkNotNullParameter(r2, "activity");
            this.a.b.b(r2);
            this.a.c.b(r2);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity r3) {
            Intrinsics.checkNotNullParameter(r3, "activity");
            this.a.b.c(r3);
            this.a.c.getClass();
            Intrinsics.checkNotNullParameter(r3, "activity");
        }
    }

    public static final class g implements Runnable {
        public final /* synthetic */ OfficeSDKScreenCaptureAuditService a;

        public g(OfficeSDKScreenCaptureAuditService r1) {
            this.a = r1;
        }

        public final void a() {
            OfficeSDKScreenCaptureAuditService r0 = this.a;
            if (r0.k == true) goto L5;
            Log.i("OfficeSDKScreenAudit", "stop() called but not started, skip");
            return;
        L5:
            Log.i("OfficeSDKScreenAudit", "stop, cleaning up");
            if (r0.l == true) goto L43;
        L30:
            Application r1 = LarkContext.getApplication();
            if (r1 != null) goto L34;
            r1 = r0.m;
        L34:
            if (r1 != null) goto L36;
            Log.e("OfficeSDKScreenAudit", "application is null, cleanup managers without lifecycle unregister");
            r0.b.a();
            com.ss.android.lark.integrator.security.compliance.screen_audit.b r2 = r0.c;
            int r3 = com.ss.android.lark.integrator.security.compliance.screen_audit.b.d;
            r2.a(LarkContext.getApplication());
            r0.e.a(null);
        L37:
            r0.k = false;
            return;
        L36:
            r0.c(r1, false);
            r0.a(r1, false);
            r0.m = null;
            goto L37
        L43:
            Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L10
            r0.a.removeFeatureGatingUpdateListener(r0.g, "_normal_fg");     // Catch: Throwable -> L10
            Object r5 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L10
        L12:
            Throwable r6 = Result.exceptionOrNull-impl(r5);
            if (r6 == null) goto L39;
            Log.e("OfficeSDKScreenAudit", "remove audit fg listener failed", r6);
        L39:
            r0.a.removeFeatureGatingUpdateListener(r0.h, "_normal_fg");     // Catch: Throwable -> L17
            Object r7 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L17
        L19:
            Throwable r8 = Result.exceptionOrNull-impl(r7);
            if (r8 == null) goto L41;
            Log.e("OfficeSDKScreenAudit", "remove device fg listener failed", r8);
        L41:
            r0.a.removeFeatureGatingUpdateListener(r0.i, "_normal_fg");     // Catch: Throwable -> L24
            Object r9 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L24
        L26:
            Throwable r10 = Result.exceptionOrNull-impl(r9);
            if (r10 == null) goto L29;
            Log.e("OfficeSDKScreenAudit", "remove chain-mode fg listener failed", r10);
        L29:
            r0.l = false;
            Log.i("OfficeSDKScreenAudit", "fg update listeners removed");
        L24:
            th = move-exception;
            Result.Companion r11 = Result.Companion;
            r9 = Result.constructor-impl(ResultKt.createFailure(th));
        L17:
            th = move-exception;
            Result.Companion r12 = Result.Companion;
            r7 = Result.constructor-impl(ResultKt.createFailure(th));
        L10:
            th = move-exception;
            Result.Companion r13 = Result.Companion;
            r5 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L12
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

    static {
    }

    public final void afterUserOffline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void onUserOnline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    @Inject
    public OfficeSDKScreenCaptureAuditService(com.ss.android.lark.integrator.security.compliance.screen_audit.a r3) {
        Intrinsics.checkNotNullParameter(r3, "reporter");
        this.a = FeatureGatingModule.getFeatureGatingService();
        this.b = new com.ss.android.lark.integrator.security.compliance.screen_audit.d(r3);
        this.c = new com.ss.android.lark.integrator.security.compliance.screen_audit.b(r3);
        this.d = new Handler(Looper.getMainLooper());
        this.e = new com.ss.android.lark.auditsdk.screen.b(r3, new OfficeSDKScreenCaptureAuditService$coordinator$1(this));
        this.f = new f(this);
        this.g = new c(this);
        this.h = new e(this);
        this.i = new d(this);
    }

    public final void afterUserOnline(h r3) {
        Intrinsics.checkNotNullParameter(r3, "state");
        Intrinsics.checkNotNullParameter(r3, "state");
        Log.i("OfficeSDKScreenAudit", "afterUserOnline scene=" + r3.b);
        this.d.post(new b(this));
    }

    public final void b(String r11) {
        if (this.k == true) goto L6;
        Log.i("OfficeSDKScreenAudit", "service stopped, ignore fg state update, reason=".concat(r11));
        return;
    L6:
        Application r0 = LarkContext.getApplication();
        if (r0 != null) goto L10;
        Log.e("OfficeSDKScreenAudit", "application is null, skip applyCurrentFGState, reason=".concat(r11));
        return;
    L10:
        this.m = r0;
        boolean r2 = this.a.isCurrentEnable("lark.security.screen_audit.officesdk_common_chain_disabled");
        boolean r3 = !r2;
        boolean r4 = this.a.isCurrentEnable("admin.security.activity_auditing_for_doubao_chat");
        boolean r5 = this.a.isCurrentEnable("core.custom_mobile.enable_audit_device");
        if (r4 == false) goto L14;
        if (r5 == false) goto L14;
        boolean r7 = true;
    L15:
        Log.i("OfficeSDKScreenAudit", "apply fg state, reason=" + r11 + " commonChainDisabled=" + r2 + " useCommonChain=" + r3 + " audit=" + r4 + " device=" + r5 + " commonFlowEnabled=" + r5 + " legacyEnabled=" + r7);
        if (r3 == false) goto L18;
        c(r0, false);
        a(r0, r5);
        return;
    L18:
        a(r0, false);
        c(r0, r7);
        return;
    L14:
        r7 = false;
        goto L15
    }

    public final void onUserOffline(h r3) {
        Intrinsics.checkNotNullParameter(r3, "state");
        Intrinsics.checkNotNullParameter(r3, "state");
        Log.i("OfficeSDKScreenAudit", "onUserOffline scene=" + r3.b);
        this.d.post(new g(this));
    }

    public final void a(Application r4, boolean r5) {
        if (r5 == false) goto L25;
        Log.i("OfficeSDKScreenAudit", "common chain enabled, start screen audit coordinator");
        com.ss.android.lark.auditsdk.screen.b r6 = this.e;
        r6.getClass();
        Intrinsics.checkNotNullParameter(r4, "application");
        if (r6.d == true) goto L33;
        r4.registerActivityLifecycleCallbacks(r6.i);     // Catch: Throwable -> L23
        r6.d = true;
        r6.e = r4;
        Log.i("ScreenAuditCore", "[" + r6.a + "] coordinator started");
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L11
        com.ss.android.lark.appcontext.applifecycle.c r8 = com.ss.android.lark.appcontext.applifecycle.c.a.a;     // Catch: Throwable -> L11
        r8.getClass();     // Catch: Throwable -> L11
        Object r9 = Result.constructor-impl(Collections.unmodifiableSet(new LinkedHashSet(r8.b)));     // Catch: Throwable -> L11
    L14:
        if (Result.isFailure-impl(r9) == false) goto L16;
        r9 = null;
    L16:
        Set r10 = (Set) r9;
        if (r10 != null) goto L19;
        r10 = SetsKt.emptySet();
    L19:
        Log.i("ScreenAuditCore", "[" + r6.a + "] arm existing activities, count=" + r10.size());
        Iterator r11 = r10.iterator();
    L21:
        if (r11.hasNext() == false) goto L34;
        Activity r0 = (Activity) r11.next();
        r6.f = new WeakReference(r0);
        com.ss.android.lark.auditsdk.screen.h r1 = r6.g;
        Intrinsics.checkNotNull(r0);
        r1.a(r0);
        r6.h.a(r0);
        goto L21
    L34:
        return;
    L11:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
    L23:
        th = move-exception;
        Log.e("ScreenAuditCore", "[" + r6.a + "] register lifecycle failed", th);
        return;
    L33:
        return;
    L25:
        Log.i("OfficeSDKScreenAudit", "common chain disabled, stop screen audit coordinator");
        this.e.a(r4);
    }

    public final void c(Application r4, boolean r5) {
        if (r5 == false) goto L27;
        if (this.j == false) goto L7;
        return;
    L7:
        r4.registerActivityLifecycleCallbacks(this.f);
        this.j = true;
        Log.i("OfficeSDKScreenAudit", "legacy lifecycle callbacks registered, capture / recording listeners armed");
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L10
        com.ss.android.lark.appcontext.applifecycle.c r7 = com.ss.android.lark.appcontext.applifecycle.c.a.a;     // Catch: Throwable -> L10
        r7.getClass();     // Catch: Throwable -> L10
        Object r8 = Result.constructor-impl(Collections.unmodifiableSet(new LinkedHashSet(r7.b)));     // Catch: Throwable -> L10
    L13:
        if (Result.isFailure-impl(r8) == false) goto L15;
        r8 = null;
    L15:
        Set r9 = (Set) r8;
        if (r9 != null) goto L19;
        r9 = SetsKt.emptySet();
    L19:
        if (r9.isEmpty() == false) goto L21;
        Log.i("OfficeSDKScreenAudit", "no already-started activities to arm");
        return;
    L21:
        Iterator r10 = r9.iterator();
    L23:
        if (r10.hasNext() == false) goto L25;
        Activity r1 = (Activity) r10.next();
        com.ss.android.lark.integrator.security.compliance.screen_audit.d r2 = this.b;
        Intrinsics.checkNotNull(r1);
        r2.b(r1);
        this.c.b(r1);
        goto L23
    L25:
        Log.i("OfficeSDKScreenAudit", "armed existing started activities for legacy chain: count=" + r9.size());
        return;
    L10:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    L27:
        if (this.j == true) goto L29;
        return;
    L29:
        r4.unregisterActivityLifecycleCallbacks(this.f);
        this.j = false;
        this.b.a();
        this.c.a(r4);
        Log.i("OfficeSDKScreenAudit", "legacy lifecycle callbacks unregistered, all listeners cleaned");
    }
}
