package com.bytedance.android.live.core.utils;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a {
    public static WeakReference<Activity> a;
    public static final LinkedList<Activity> b = null;
    public static final Object c = null;
    public static final C0170a d = null;

    /* JADX INFO: renamed from: com.bytedance.android.live.core.utils.a$a, reason: collision with other inner class name */
    public static final class C0170a implements Application.ActivityLifecycleCallbacks {
        public C0170a() {
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

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity r3) {
            Intrinsics.checkNotNullParameter(r3, "activity");
            WeakReference<Activity> r0 = a.a;
            Object r1 = a.c;
            monitor-enter(r1);
            a.b.remove(r3);     // Catch: Throwable -> L7
            monitor-exit(r1);
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity r3) {
            Intrinsics.checkNotNullParameter(r3, "activity");
            WeakReference<Activity> r0 = a.a;
            WeakReference<Activity> r1 = a.a;
            if (r1 == null) goto L5;
            Activity r2 = r1.get();
        L7:
            if (Intrinsics.areEqual(r2, r3) == false) goto L10;
            a.a = null;
            return;
        L10:
            return;
        L5:
            r2 = null;
            goto L7
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity r2) {
            Intrinsics.checkNotNullParameter(r2, "activity");
            WeakReference<Activity> r0 = a.a;
            a.a = new WeakReference(r2);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity r2, Bundle r3) {
            Intrinsics.checkNotNullParameter(r2, "activity");
            WeakReference<Activity> r4 = a.a;
            Object r5 = a.c;
            monitor-enter(r5);
            LinkedList<Activity> r0 = a.b;     // Catch: Throwable -> L7
            r0.remove(r2);     // Catch: Throwable -> L7
            r0.add(r2);     // Catch: Throwable -> L7
            monitor-exit(r5);
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    static {
        b = new LinkedList();
        c = new Object();
        d = new C0170a();
    }

    public static Activity b() {
        Object r0 = c;
        monitor-enter(r0);
        LinkedList<Activity> r1 = b;     // Catch: Throwable -> L11
        if (r1.size() < 2) goto L8;
        Activity r2 = r1.get(r1.size() - 2);     // Catch: Throwable -> L11
    L9:
        monitor-exit(r0);
        return r2;
    L8:
        r2 = null;
    L11:
        th = move-exception;
        throw th;
    }

    public static Activity d() {
        Object r0 = c;
        monitor-enter(r0);
        IMiddlewareHostApp r1 = jc1.k.f(IMiddlewareHostApp.class);     // Catch: Throwable -> L16
        if (r1 == null) goto L7;
        Activity r2 = r1.getTopActivity();     // Catch: Throwable -> L16
    L8:
        if (r2 != null) goto L10;
    L14:
        monitor-exit(r0);
        return r2;
    L10:
        if (r2.isFinishing() == false) goto L14;
        LinkedList<Activity> r3 = b;     // Catch: Throwable -> L16
        if ((!r3.isEmpty()) == false) goto L14;
        r3.removeLast();     // Catch: Throwable -> L16
        r2 = d();     // Catch: Throwable -> L16
        goto L14
    L7:
        r2 = null;
    L16:
        th = move-exception;
        throw th;
    }

    public static boolean e(Context r1) {
        if ((r1 instanceof Activity) == true) goto L7;
        return false;
    L7:
        return Intrinsics.areEqual(r1, d());
    }

    public static Intent a(Context r6, String r7) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "packageName");
        PackageManager r8 = r6.getPackageManager();
        Intent r0 = new Intent("android.intent.action.MAIN");
        r0.addCategory("android.intent.category.LAUNCHER");
        r0.setFlags(270532608);
        List<ResolveInfo> r9 = r8.queryIntentActivities(r0, 1);
        int r1 = r9.size();
        int r2 = 0;
    L4:
        if (r2 >= r1) goto L9;
        ResolveInfo r4 = (ResolveInfo) ListProtector.get(r9, r2);
        if (Intrinsics.areEqual(r4.activityInfo.packageName, r7) == true) goto L7;
        r2 = r2 + 1;
        goto L4
    L7:
        String r11 = r4.activityInfo.name;
    L11:
        if (TextUtils.isEmpty(r11) == false) goto L13;
        return null;
    L13:
        if (r11 == null) goto L15;
        r0.setComponent(new ComponentName(r7, r11));
    L15:
        return r0;
    L9:
        r11 = null;
        goto L11
    }

    @JvmStatic
    public static final Context c(Context r1, boolean r2) {
        if (r2 == false) goto L11;
        Activity r3 = b();
        if (r3 == null) goto L6;
        return r3;
    L6:
        if (b.size() == 0) goto L8;
        return r3;
    L8:
        if (d() != null) goto L10;
        return r3;
    L10:
        return d();
    L11:
        if (r1 != null) goto L13;
    L16:
        Context r4 = d();
    L17:
        if (r4 != null) goto L19;
        return r1;
    L19:
        if ((r4 instanceof Activity) == true) goto L21;
        return r1;
    L21:
        if (((Activity) r4).isFinishing() == false) goto L23;
        return r1;
    L23:
        return r4;
    L13:
        if ((r1 instanceof Activity) == false) goto L16;
        r4 = r1;
        goto L17
    }
}
