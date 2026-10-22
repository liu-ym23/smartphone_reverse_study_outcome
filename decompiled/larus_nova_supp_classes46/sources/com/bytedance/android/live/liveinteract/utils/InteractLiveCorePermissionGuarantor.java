package com.bytedance.android.live.liveinteract.utils;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.larus.apm.impl.protector.RunnableProtector;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class InteractLiveCorePermissionGuarantor {
    public final String a;
    public final String[] b;
    public final String[] c;
    public final String[] d;
    public final String[] e;
    public final String[] f;
    public boolean g;
    public boolean h;
    public boolean i;
    public Runnable j;
    public final Handler k;
    public WeakReference<FragmentActivity> l;
    public WeakReference<a> m;
    public final c n;
    public final b o;
    public boolean p;
    public final InteractLiveCorePermissionGuarantor$fragmentLifeCycleCb$1 q;

    public interface a {
        void a(boolean r1);

        void b(boolean r1);
    }

    public static final class b implements Application.ActivityLifecycleCallbacks {
        public final /* synthetic */ InteractLiveCorePermissionGuarantor a;

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity r1, Bundle r2) {
            Intrinsics.checkNotNullParameter(r1, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity r2) {
            Intrinsics.checkNotNullParameter(r2, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity r2, Bundle r3) {
            Intrinsics.checkNotNullParameter(r2, "activity");
            Intrinsics.checkNotNullParameter(r3, "outState");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity r2) {
            Intrinsics.checkNotNullParameter(r2, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity r2) {
            Intrinsics.checkNotNullParameter(r2, "activity");
        }

        public b(InteractLiveCorePermissionGuarantor r1) {
            this.a = r1;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity r6) {
            Intrinsics.checkNotNullParameter(r6, "activity");
            InteractLiveCorePermissionGuarantor r0 = this.a;
            boolean r3 = true;
            if (r0.g == false) goto L19;
            String[] r1 = r0.f;
            if (r1 == null) goto L19;
            if (r1.length != 0) goto L9;
            boolean r2 = true;
        L10:
            if (r2 == true) goto L19;
            ALogger.e(r0.a, "common launch activity paused:".concat(r6.getClass().getName()));
            if (this.a.a(r6) == false) goto L19;
            ALogger.e(this.a.a, "onKeepAudioTargetPageShow false");
            WeakReference<a> r7 = this.a.m;
            if (r7 == null) goto L31;
            a r8 = r7.get();
            if (r8 == null) goto L32;
            r8.b(false);
            return;
        L32:
            return;
        L31:
            return;
        L9:
            r2 = false;
        L19:
            InteractLiveCorePermissionGuarantor r4 = this.a;
            String[] r5 = r4.b;
            if (r5 != null) goto L22;
            return;
        L22:
            if (r5.length == 0) goto L25;
            r3 = false;
        L25:
            if (r3 == true) goto L35;
            ALogger.e(r4.a, "common launch activity paused:".concat(r6.getClass().getName()));
            if (this.a.b(r6) == false) goto L34;
            TalkRoomBusinessFullLinkMonitor r9 = TalkRoomBusinessFullLinkMonitor.a;
            String r10 = this.a.a;
            String r11 = "common launch activity paused:".concat(r6.getClass().getName());
            r9.getClass();
            TalkRoomBusinessFullLinkMonitor.g(r10, r11);
            this.a.i = false;
            return;
        L34:
            return;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity r10) {
            Intrinsics.checkNotNullParameter(r10, "activity");
            InteractLiveCorePermissionGuarantor r3 = this.a;
            boolean r6 = false;
            if (r3.g == false) goto L22;
            String[] r4 = r3.f;
            if (r4 == null) goto L22;
            if (r4.length != 0) goto L9;
            boolean r5 = true;
        L10:
            if (r5 == true) goto L22;
            ALogger.e(r3.a, "common launch activity resume:".concat(r10.getClass().getName()));
            if (this.a.a(r10) == false) goto L22;
            ALogger.e(this.a.a, "onKeepAudioTargetPageShow true");
            InteractLiveCorePermissionGuarantor r11 = this.a;
            Runnable r0 = r11.j;
            if (r0 == null) goto L16;
            r11.k.removeCallbacks(r0);
        L16:
            WeakReference<a> r12 = this.a.m;
            if (r12 == null) goto L55;
            a r13 = r12.get();
            if (r13 == null) goto L56;
            r13.b(true);
            return;
        L56:
            return;
        L55:
            return;
        L9:
            r5 = false;
        L22:
            InteractLiveCorePermissionGuarantor r7 = this.a;
            String[] r8 = r7.b;
            if (r8 != null) goto L25;
            return;
        L25:
            if (r8.length != 0) goto L27;
            boolean r9 = true;
        L28:
            if (r9 == true) goto L62;
            ALogger.e(r7.a, "common launch activity resume:".concat(r10.getClass().getName()));
        L49:
            e = move-exception;
            ALogger.e(this.a.a, e);
            TalkRoomBusinessFullLinkMonitor r1 = TalkRoomBusinessFullLinkMonitor.a;
            String r2 = this.a.a;
            String r14 = e.toString();
            r1.getClass();
            TalkRoomBusinessFullLinkMonitor.g(r2, r14);
            return;
        L32:
            if (this.a.b(r10) == true) goto L34;
            return;
        L34:
            if (ArraysKt.contains(this.a.c, r10.getClass().getSimpleName()) == false) goto L43;
            Intrinsics.checkNotNullParameter(r10, "activity");     // Catch: Exception -> L49
            Intrinsics.checkNotNullParameter("LivePlayFragment", "fragmentName");     // Catch: Exception -> L49
            if ((r10 instanceof FragmentActivity) == true) goto L52;
        L41:
            if (r6 == false) goto L43;
            ALogger.i(this.a.a, "checkCommonTargetActivity " + r10.getClass().getSimpleName() + " hit " + Arrays.toString(this.a.c) + " and load LivePlayFragment");     // Catch: Exception -> L49
            return;
        L52:
            r6 = i.a(((FragmentActivity) r10).getSupportFragmentManager());     // Catch: Exception -> L40
        L43:
            TalkRoomBusinessFullLinkMonitor r15 = TalkRoomBusinessFullLinkMonitor.a;     // Catch: Exception -> L49
            String r16 = this.a.a;     // Catch: Exception -> L49
            String r17 = "common launch activity resume:".concat(r10.getClass().getName());     // Catch: Exception -> L49
            r15.getClass();     // Catch: Exception -> L49
            TalkRoomBusinessFullLinkMonitor.g(r16, r17);     // Catch: Exception -> L49
            InteractLiveCorePermissionGuarantor r18 = this.a;     // Catch: Exception -> L49
            r18.i = true;     // Catch: Exception -> L49
            WeakReference<a> r19 = r18.m;     // Catch: Exception -> L49
            if (r19 == null) goto L60;
            a r110 = r19.get();     // Catch: Exception -> L49
            if (r110 == null) goto L61;
            r110.a(true);     // Catch: Exception -> L49
            return;
        L61:
            return;
        L60:
            return;
        L62:
            return;
        L27:
            r9 = false;
            goto L28
        }
    }

    public static final class c implements Application.ActivityLifecycleCallbacks {
        public final /* synthetic */ InteractLiveCorePermissionGuarantor a;

        public static final class a implements Runnable {
            public final /* synthetic */ c a;
            public final /* synthetic */ Activity b;

            public a(c r1, Activity r2) {
                this.a = r1;
                this.b = r2;
            }

            public final void a() {
                Activity r0 = this.b;     // Catch: Exception -> L12
                if (r0 != null) goto L5;
                return;
            L5:
                if (this.a.a.c(r0) == false) goto L18;
                WeakReference<a> r1 = this.a.a.m;     // Catch: Exception -> L12
                if (r1 == null) goto L19;
                a r2 = r1.get();     // Catch: Exception -> L12
                if (r2 == null) goto L20;
                r2.a(true);     // Catch: Exception -> L12
                return;
            L20:
                return;
            L19:
                return;
            L18:
                return;
            L12:
                e = move-exception;
                ALogger.e(this.a.a.a, e);
                TalkRoomBusinessFullLinkMonitor r3 = TalkRoomBusinessFullLinkMonitor.a;
                String r4 = this.a.a.a;
                String r5 = e.toString();
                r3.getClass();
                TalkRoomBusinessFullLinkMonitor.g(r4, r5);
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

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity r2) {
            Intrinsics.checkNotNullParameter(r2, "activity");
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

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity r2) {
            Intrinsics.checkNotNullParameter(r2, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity r2) {
            Intrinsics.checkNotNullParameter(r2, "activity");
        }

        public c(InteractLiveCorePermissionGuarantor r1) {
            this.a = r1;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity r4, Bundle r5) {
            Intrinsics.checkNotNullParameter(r4, "activity");
            InteractLiveCorePermissionGuarantor r6 = this.a;
            String[] r0 = r6.d;
            if (r0 != null) goto L5;
            return;
        L5:
            if (r0.length != 0) goto L7;
            boolean r1 = true;
        L8:
            if (r1 == true) goto L16;
            ALogger.e(r6.a, "launch activity create:" + r4.getClass().getName());
            InteractLiveCorePermissionGuarantor r7 = this.a;
            Runnable r2 = r7.j;
            if (r2 == null) goto L13;
            r7.k.removeCallbacks(r2);
        L13:
            InteractLiveCorePermissionGuarantor r8 = this.a;
            a r3 = new a(this, r4);
            r8.j = r3;
            r8.k.postDelayed(r3, 1200);
            return;
        L16:
            return;
        L7:
            r1 = false;
            goto L8
        }
    }

    public final void e() {
        if (this.h == false) goto L5;
        ALogger.e(this.a, "onStop , globalLifecycleCb unregister from lifecycleCallbacks");
        jc1.a.b().unregisterActivityLifecycleCallbacks(this.n);
        this.h = false;
    L5:
        ALogger.e(this.a, "onStop , globalLifecycleCb unregister from lifecycleCallbacks");
        jc1.a.b().unregisterActivityLifecycleCallbacks(this.o);
        WeakReference<FragmentActivity> r0 = this.l;
        if (r0 == null) goto L13;
        FragmentActivity r1 = r0.get();
        if (r1 == null) goto L14;
        FragmentManager r2 = r1.getSupportFragmentManager();
        if (r2 == null) goto L15;
        r2.unregisterFragmentLifecycleCallbacks(this.q);
        return;
    L15:
        return;
    L14:
        return;
    }

    public final void f() {
        if (this.d != null) goto L5;
        return;
    L5:
        this.h = true;
        ALogger.e(this.a, "onPause , globalLifecycleCb and commonGlobalLifecycleCb registered with lifecycleCallbacks");
        jc1.a.b().registerActivityLifecycleCallbacks(this.n);
        jc1.a.b().registerActivityLifecycleCallbacks(this.o);
    }

    public final void g() {
        if (this.h == false) goto L5;
        ALogger.e(this.a, "onResume , globalLifecycleCb unregistered from lifecycleCallbacks");
        jc1.a.b().unregisterActivityLifecycleCallbacks(this.n);
        this.h = false;
    L5:
        ALogger.e(this.a, "onResume , commonGlobalLifecycleCb unregistered from lifecycleCallbacks");
        jc1.a.b().unregisterActivityLifecycleCallbacks(this.o);
    }

    public final void h() {
        if (this.h == false) goto L9;
        Runnable r0 = this.j;
        if (r0 == null) goto L7;
        this.k.removeCallbacks(r0);
        this.j = null;
    L7:
        ALogger.e(this.a, "onStop , globalLifecycleCb unregistered from lifecycleCallbacks");
        jc1.a.b().unregisterActivityLifecycleCallbacks(this.n);
        this.h = false;
        return;
    }

    /* JADX WARN: Type inference failed for: r0v19, types: [com.bytedance.android.live.liveinteract.utils.InteractLiveCorePermissionGuarantor$fragmentLifeCycleCb$1] */
    public InteractLiveCorePermissionGuarantor() {
        this.a = "InteractLiveCorePermissionGuarantor";
        ReadOnlyProperty r0 = vm2.d.i8;
        KProperty[] r1 = vm2.d.a;
        this.b = (String[]) r0.getValue(null, r1[473(0x1d9, float:6.63E-43)]);
        this.c = (String[]) vm2.d.j8.getValue(null, r1[474(0x1da, float:6.64E-43)]);
        this.d = (String[]) vm2.d.h8.getValue(null, r1[472(0x1d8, float:6.61E-43)]);
        this.e = (String[]) vm2.d.g8.getValue(null, r1[471(0x1d7, float:6.6E-43)]);
        this.f = (String[]) vm2.f.c.getValue(null, vm2.f.a[1]);
        this.k = new Handler(Looper.getMainLooper());
        this.n = new c(this);
        this.o = new b(this);
        this.q = new InteractLiveCorePermissionGuarantor$fragmentLifeCycleCb$1(this);
    }

    public final boolean a(Activity r7) {
        Intrinsics.checkNotNullParameter(r7, "activity");
        String r8 = r7.getClass().getSimpleName();
        ALogger.i(this.a, "checkAudioPermissionWhiteActivity simpleName:" + r8 + ", config:" + Arrays.toString(this.f));
        String[] r0 = this.f;
        int r1 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L11;
        String r4 = r0[r3];
        if (TextUtils.isEmpty(r8) == true) goto L10;
        if (r8.equals(r4) == false) goto L10;
        return true;
    L10:
        r3 = r3 + 1;
        goto L3
    L11:
        return false;
    }

    public final boolean b(Activity r7) {
        Intrinsics.checkNotNullParameter(r7, "activity");
        String r8 = r7.getClass().getSimpleName();
        ALogger.i(this.a, "common check target activity simpleName:" + r8 + ", config:" + Arrays.toString(this.b));
        String[] r0 = this.b;
        int r1 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L11;
        String r4 = r0[r3];
        if (TextUtils.isEmpty(r8) == true) goto L10;
        if (r8.equals(r4) == false) goto L10;
        return true;
    L10:
        r3 = r3 + 1;
        goto L3
    L11:
        return false;
    }

    public final boolean c(Activity r7) {
        Intrinsics.checkNotNullParameter(r7, "activity");
        String r8 = r7.getClass().getSimpleName();
        ALogger.i(this.a, "check target activity simpleName:" + r8 + ", config:" + Arrays.toString(this.d));
        String[] r0 = this.d;
        int r1 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L11;
        String r4 = r0[r3];
        if (TextUtils.isEmpty(r8) == true) goto L10;
        if (r8.equals(r4) == false) goto L10;
        return true;
    L10:
        r3 = r3 + 1;
        goto L3
    L11:
        return false;
    }

    public final boolean d(Fragment r11) {
        Intrinsics.checkNotNullParameter(r11, "fragment");
        String r0 = r11.getClass().getName();
        String r12 = r11.getTag();
        ALogger.i(this.a, "check target fragment:" + r0 + ", config:" + Arrays.toString(this.e));
        String[] r1 = this.e;
        int r2 = r1.length;
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L16;
        String r5 = r1[r4];
        if (TextUtils.isEmpty(r0) == true) goto L10;
        if (StringsKt.contains$default(r0, r5, false, 2, null) == false) goto L10;
        return true;
    L10:
        if (TextUtils.isEmpty(r12) == true) goto L15;
        if (r12 == null) goto L15;
        if (StringsKt.contains$default(r12, r5, false, 2, null) != true) goto L15;
        return true;
    L15:
        r4 = r4 + 1;
        goto L3
    L16:
        return false;
    }

    public final void i(FragmentActivity r4) {
        Intrinsics.checkNotNullParameter(r4, "act");
        FragmentManager r0 = r4.getSupportFragmentManager();
        if (r0 == null) goto L5;
        r0.registerFragmentLifecycleCallbacks(this.q, false);
    L5:
        this.l = new WeakReference(r4);
    }

    public final void j(a r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.m = new WeakReference(r2);
    }
}
