package com.bytedance.reparo;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class b implements Application.ActivityLifecycleCallbacks {
    public final /* synthetic */ c a;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity r1, Bundle r2) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity r1) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity r1) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity r1) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity r1, Bundle r2) {
    }

    public b(c r1) {
        this.a = r1;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity r3) {
        c r4 = this.a;
        if (r4.a != 0) goto L15;
        r4.getClass();
        c r5 = this.a;
        if (r5.c == true) goto L11;
        Iterator r6 = ((ArrayList) r5.b).iterator();
    L8:
        if (r6.hasNext() == false) goto L10;
        ((a) r6.next()).b();
        goto L8
    L10:
        this.a.c = true;
    L11:
        Iterator r7 = ((ArrayList) this.a.b).iterator();
    L13:
        if (r7.hasNext() == false) goto L15;
        ((a) r7.next()).a();
    L15:
        this.a.a++;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity r2) {
        c r3 = this.a;
        if (r3.c == true) goto L5;
        return;
    L5:
        int r0 = r3.a - 1;
        r3.a = r0;
        if (r0 != 0) goto L11;
        r3.getClass();
        Iterator r4 = ((ArrayList) this.a.b).iterator();
    L9:
        if (r4.hasNext() == false) goto L13;
        ((a) r4.next()).c();
        goto L9
    L13:
        return;
    }
}
