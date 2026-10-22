package yub;

import android.app.Activity;
import android.os.Bundle;
import com.ss.android.lark.officesdk.minutes.assembly.recording.common.hardware.MmHardwareOfflineRecordingForegroundRetryController$register$1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b extends com.ss.android.lark.appcontext.applifecycle.a {
    public final /* synthetic */ a.b a;

    public b(MmHardwareOfflineRecordingForegroundRetryController$register$1.a r1) {
        this.a = r1;
    }

    public final void onActivityDestroyed(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        this.a.onActivityDestroyed(r2);
    }

    public final void onActivityPaused(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        this.a.onActivityPaused(r2);
    }

    public final void onActivityResumed(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        this.a.onActivityResumed(r2);
    }

    public final void onActivityStarted(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        this.a.onActivityStarted(r2);
    }

    public final void onActivityStopped(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        this.a.onActivityStopped(r2);
    }

    public final void onActivityCreated(Activity r1, Bundle r2) {
        Intrinsics.checkNotNullParameter(r1, "activity");
        this.a.onActivityCreated(r1);
    }

    public final void onActivitySaveInstanceState(Activity r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "outState");
        this.a.onActivitySaveInstanceState(r2, r3);
    }
}
