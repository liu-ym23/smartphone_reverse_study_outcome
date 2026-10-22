package com.bytedance.frameworks.baselib.network;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Looper;
import ca.f;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f4660b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final WeakHandler f4661c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CopyOnWriteArrayList f4662a;

    static {
        f4661c = new WeakHandler(Looper.getMainLooper(), new a());
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity r5, Bundle r10) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity r5) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity r5) {
        if (f4660b == false) goto L8;
        Iterator r10 = this.f4662a.iterator();
    L6:
        if (r10.hasNext() == false) goto L10;
        f r11 = (f) r10.next();
        f4661c.postDelayed(r11.f1160b, r11.f1159a);
        goto L6
    L10:
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity r5) {
        if (f4660b == true) goto L10;
        f4660b = true;
        Iterator r10 = this.f4662a.iterator();
    L6:
        if (r10.hasNext() == false) goto L10;
        ((f) r10.next()).f1161c.set(false);
        if (Logger.debug() == false) goto L6;
        Logger.d("QueryFilterStateListener", "onEnterToForeground");
    L10:
        f4661c.removeCallbacksAndMessages(null);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity r5, Bundle r10) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity r5) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity r5) {
    }
}
