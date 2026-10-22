package com.larus.reach.runtime;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class s implements Application.ActivityLifecycleCallbacks {
    public s() {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity r1, Bundle r2) {
        Intrinsics.checkNotNullParameter(r1, "activity");
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
        WeakReference<Activity> r0 = t.b;
        if (r0 == null) goto L5;
        Activity r1 = r0.get();
    L6:
        if (r1 != r3) goto L9;
        AtomicBoolean r4 = t.a;
        t.b = null;
        return;
    L9:
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity r3) {
        Intrinsics.checkNotNullParameter(r3, "activity");
        WeakReference<Activity> r0 = t.b;
        if (r0 == null) goto L5;
        Activity r1 = r0.get();
    L6:
        if (r1 != r3) goto L9;
        AtomicBoolean r4 = t.a;
        t.b = null;
        return;
    L9:
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        AtomicBoolean r0 = t.a;
        t.b = new WeakReference(r2);
    }
}
