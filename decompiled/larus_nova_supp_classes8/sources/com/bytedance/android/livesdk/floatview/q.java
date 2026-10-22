package com.bytedance.android.livesdk.floatview;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.bytedance.android.livehostapi.foundation.depend.IHostAppMonitorListener;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class q implements IHostAppMonitorListener {
    public boolean a;
    public final nz.s b;
    public final Context c;

    public static final class a {
    }

    static {
    }

    public final void onActivitySaveInstanceState(Activity r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "bundle");
    }

    public final Context getContext() {
        return this.c;
    }

    public final void onActivityDestroyed(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        nz.s r0 = this.b;
        if (r0 == null) goto L6;
        r0.a(r2);
        return;
    }

    public final void onActivityPaused(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        nz.s r0 = this.b;
        if (r0 == null) goto L6;
        r0.onPause(r2);
        return;
    }

    public final void onActivityResumed(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        nz.s r0 = this.b;
        if (r0 == null) goto L6;
        r0.onResume(r2);
        return;
    }

    public final void onActivityStarted(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        nz.s r0 = this.b;
        if (r0 == null) goto L6;
        r0.onStart(r2);
        return;
    }

    public final void onActivityStopped(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        if (this.a == false) goto L7;
        nz.s r0 = this.b;
        if (r0 == null) goto L7;
        r0.c(r2);
    L7:
        nz.s r1 = this.b;
        if (r1 == null) goto L11;
        r1.onStop(r2);
        return;
    }

    public q(Context r2, nz.s r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.c = r2;
        this.b = r3;
    }

    public final void appEnterBackground(boolean r2, boolean r3) {
        this.a = r2;
        if (r3 == true) goto L8;
        if (r2 == true) goto L8;
        nz.s r0 = this.b;
        if (r0 == null) goto L8;
        r0.b();
    L8:
        if (r3 == true) goto L14;
        if (r2 == false) goto L15;
        nz.s r4 = this.b;
        if (r4 == null) goto L16;
        r4.c(null);
        return;
    L16:
        return;
    L15:
        return;
    }

    public final void onActivityCreated(Activity r1, Bundle r2) {
        Intrinsics.checkNotNullParameter(r1, "activity");
        nz.s r3 = this.b;
        if (r3 == null) goto L6;
        r3.onCreate(r1);
        return;
    }
}
