package g8;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Looper;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.common.wschannel.WsConstants;
import com.lynx.tasm.ui.image.h;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f17061c = false;
    public static final WeakHandler d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f17062a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f17063b;

    static {
        d = new WeakHandler(Looper.getMainLooper(), new a());
    }

    public c() {
        this.f17063b = new h(this, 18);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity r5, Bundle r10) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity r5) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity r5) {
        if (f17061c == false) goto L6;
        d.postDelayed(this.f17063b, WsConstants.EXIT_DELAY_TIME);
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity r5) {
        if (f17061c == true) goto L8;
        f17061c = true;
        b r10 = this.f17062a;
        if (r10 == null) goto L8;
        r10.a();
    L8:
        if (Logger.debug() == false) goto L10;
        Logger.d("WsChannelSdk", "onResume sAppAlive = " + f17061c);
    L10:
        d.removeCallbacks(this.f17063b);
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
