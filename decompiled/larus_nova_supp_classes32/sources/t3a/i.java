package t3a;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class i implements Application.ActivityLifecycleCallbacks {
    public final /* synthetic */ g a;

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

    public i(g r1) {
        this.a = r1;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        g r3 = this.a;
        if (r3.c == false) goto L12;
        b r4 = r3.d;
        if (r4 != null) goto L7;
        return;
    L7:
        if (r4.l != 0) goto L9;
        return;
    L9:
        if (r4.j == null) goto L15;
        r4.c(r4.b);
        r4.l = 0;
        return;
    L15:
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity r3) {
        Intrinsics.checkNotNullParameter(r3, "activity");
        g r0 = this.a;
        if (r0.c == false) goto L8;
        b r1 = r0.d;
        if (r1 == null) goto L9;
        r1.a(r3);
        return;
    L9:
        return;
    }
}
