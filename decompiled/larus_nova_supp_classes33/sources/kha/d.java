package kha;

import android.app.Activity;
import android.os.Bundle;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class d implements f09.a.a {
    public final /* synthetic */ Activity a;

    public d(Activity r1) {
        this.a = r1;
    }

    public final void onPaused(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
    }

    public final void onPreDestroyed(Activity r4) {
        Intrinsics.checkNotNullParameter(r4, "activity");
        if (r4 == this.a) goto L5;
        return;
    L5:
        AppHost.a.a().f(this);
        FLogger.a.i("LowStorageGuard", "host activity pre-destroyed, release showing lease: " + r4);
        e.a.getClass();
        e.d();
    }

    public final void onResumed(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
    }

    public final void onStart(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
    }

    public final void onStopped(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
    }

    public final void onCreate(Activity r1, Bundle r2) {
        Intrinsics.checkNotNullParameter(r1, "activity");
    }
}
