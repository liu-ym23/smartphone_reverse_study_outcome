package com.bytedance.ai.applet.app;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class s implements Application.ActivityLifecycleCallbacks {
    public final /* synthetic */ AppletFullScreenActivity a;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
        Intrinsics.checkNotNullParameter(r11, "outState");
    }

    public s(AppletFullScreenActivity r1) {
        this.a = r1;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
        WeakReference<Activity> r0 = this.a.r;
        if (r0 == null) goto L5;
        Activity r1 = r0.get();
    L6:
        if (r1 != r10) goto L9;
        AppletFullScreenActivity r11 = this.a;
        r11.s = false;
        r11.r = null;
        return;
    L9:
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
        if (Build.VERSION.SDK_INT >= 29) goto L6;
        AppletFullScreenActivity.c2(this.a, r10);
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPostPaused(Activity r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
        AppletFullScreenActivity.c2(this.a, r10);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPostResumed(Activity r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
        AppletFullScreenActivity.d2(this.a, r10);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
        AppletFullScreenActivity r0 = this.a;
        if (r10 != r0) goto L7;
        r0.r = null;
        r0.s = false;
        return;
    L7:
        if (Build.VERSION.SDK_INT >= 29) goto L10;
        AppletFullScreenActivity.d2(r0, r10);
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
        AppletFullScreenActivity r0 = this.a;
        int r1 = AppletFullScreenActivity.x;
        if (r0.i2(r10) == false) goto L6;
        this.a.q.add(r10);
        this.a.c.c("onActivityStarted: activity=" + r10.getClass().getSimpleName() + ", taskId=" + r10.getTaskId() + ", startedCount=" + this.a.q.size());
        AppletFullScreenActivity.g2(this.a);
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
        AppletFullScreenActivity r0 = this.a;
        int r1 = AppletFullScreenActivity.x;
        if (r0.i2(r10) == false) goto L6;
        this.a.q.remove(r10);
        this.a.c.c("onActivityStopped: activity=" + r10.getClass().getSimpleName() + ", taskId=" + r10.getTaskId() + ", startedCount=" + this.a.q.size());
        AppletFullScreenActivity.g2(this.a);
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
        WeakReference<Activity> r0 = this.a.r;
        if (r0 == null) goto L5;
        Activity r1 = r0.get();
    L6:
        if (r1 != null) goto L17;
        AppletFullScreenActivity r12 = this.a;
        if (r10 == r12) goto L17;
        if (r12.i2(r10) == false) goto L17;
        AppletFullScreenActivity r13 = this.a;
        r13.r = new WeakReference(r10);
        AppletFullScreenActivity r14 = this.a;
        if (r11 != null) goto L14;
        boolean r15 = true;
    L15:
        r14.s = r15;
        goto L17
    L14:
        r15 = false;
    L17:
        if (Build.VERSION.SDK_INT >= 29) goto L20;
        AppletFullScreenActivity.e2(this.a, r10);
        return;
    L20:
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPostCreated(Activity r1, Bundle r10) {
        Intrinsics.checkNotNullParameter(r1, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
        AppletFullScreenActivity.e2(this.a, r1);
    }
}
