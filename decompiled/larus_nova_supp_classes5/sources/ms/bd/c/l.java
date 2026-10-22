package ms.bd.c;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.bytedance.mobsec.metasec.ml.MSC;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class l implements Application.ActivityLifecycleCallbacks {
    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity r1) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity r1) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity r1, Bundle r2) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity r1) {
    }

    public l() {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity r3) {
        if (n.e == true) goto L6;
        n.e = true;
        n.h.post(new i(r3));
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity r2) {
        if (n.e == false) goto L6;
        n.h.post(new k(this));
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity r8, Bundle r9) {
        if (((String) p2.a(16777217, 0, 0, "5e1c26", new byte[]{32, 104, 87, 14, 4, 47})).equals((String) p2.a(16777217, 0, 0, "18ed96", new byte[]{36, 53, 3, 9, 15, 47})) == true) goto L5;
        return;
    L5:
        if ((MSC.GetABSwitch() & 256) != 256) goto L9;
        n.h.post(new l4(r8));
        return;
    }
}
