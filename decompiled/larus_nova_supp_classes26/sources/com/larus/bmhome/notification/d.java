package com.larus.bmhome.notification;

import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class d implements f09.a.b {
    public final /* synthetic */ NotifyRedDotLifecycleObserver a;

    public final void onAllActivityDestroyed() {
    }

    public final void onAppBackground() {
        NotifyRedDotLifecycleObserver r0 = this.a;
        int r1 = NotifyRedDotLifecycleObserver.h;
        r0.getClass();
        FLogger.a.i("NotifyRedDotLifecycleObserver", "stopUnreadPollingTask");
        r0.c.removeCallbacks(r0.d);
    }

    public final void onAppForeground() {
        NotifyRedDotLifecycleObserver r0 = this.a;
        int r1 = NotifyRedDotLifecycleObserver.h;
        r0.b();
    }

    public d(NotifyRedDotLifecycleObserver r1) {
        this.a = r1;
    }
}
