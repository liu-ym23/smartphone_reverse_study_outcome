package cpb;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.ss.android.lark.language.api.LocaleWatchScene;
import com.ss.android.lark.log.LogLevel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements Application.ActivityLifecycleCallbacks {
    public final /* synthetic */ Application a;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "outState");
    }

    public a(Application r1) {
        this.a = r1;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity r3) {
        Intrinsics.checkNotNullParameter(r3, "activity");
        int r0 = d.a;
        d.a.b(LocaleWatchScene.ACTIVITY_START, r3, this.a).a(LogLevel.DEBUG);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity r3) {
        Intrinsics.checkNotNullParameter(r3, "activity");
        int r0 = d.a;
        d.a.b(LocaleWatchScene.ACTIVITY_STOP, r3, this.a).a(LogLevel.DEBUG);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        int r4 = d.a;
        d.a.b(LocaleWatchScene.ACTIVITY_CREATE, r2, this.a).a(LogLevel.INFO);
    }
}
