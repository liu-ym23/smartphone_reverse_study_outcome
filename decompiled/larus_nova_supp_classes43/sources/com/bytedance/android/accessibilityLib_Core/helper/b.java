package com.bytedance.android.accessibilityLib_Core.helper;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b implements Application.ActivityLifecycleCallbacks {
    public final List<e> a;

    public b() {
        this.a = new ArrayList();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity r10) {
        Iterator r11 = ((ArrayList) this.a).iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        boolean r0 = ((e) r11.next()).a;
        goto L4
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity r10) {
        Iterator r11 = ((ArrayList) this.a).iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        boolean r0 = ((e) r11.next()).a;
        goto L4
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity r10) {
        Iterator r11 = ((ArrayList) this.a).iterator();
    L4:
        if (r11.hasNext() == false) goto L9;
        e r0 = (e) r11.next();
        if (r0.a == false) goto L4;
        r0.a = true;
        goto L4
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity r10) {
        Iterator r11 = ((ArrayList) this.a).iterator();
    L4:
        if (r11.hasNext() == false) goto L9;
        e r0 = (e) r11.next();
        if (r0.a == false) goto L4;
        r0.a = true;
        goto L4
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity r10) {
        Iterator r11 = ((ArrayList) this.a).iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        boolean r0 = ((e) r11.next()).a;
        goto L4
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity r10, Bundle r11) {
        Iterator r12 = ((ArrayList) this.a).iterator();
    L4:
        if (r12.hasNext() == false) goto L9;
        e r13 = (e) r12.next();
        if (r13.a == false) goto L4;
        r13.a = true;
        goto L4
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity r1, Bundle r10) {
        Iterator r11 = ((ArrayList) this.a).iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        boolean r12 = ((e) r11.next()).a;
        goto L4
    }
}
