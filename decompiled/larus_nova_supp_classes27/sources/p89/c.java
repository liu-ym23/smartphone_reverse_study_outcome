package p89;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.larus.utils.logger.FLogger;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class c implements Application.ActivityLifecycleCallbacks {
    public final /* synthetic */ String a;
    public final /* synthetic */ Set<String> b;

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

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
    }

    public c(Set r2) {
        this.a = "ec_applet_page_id";
        this.b = r2;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "activity");
        if (r5 == null) goto L13;
        String r6 = r5.getString(this.a);
        if (r6 != null) goto L7;
        return;
    L7:
        if (this.b.contains(r6) == true) goto L10;
        r6 = null;
    L10:
        if (r6 == null) goto L15;
        FLogger.a.w("ECAppletStackGuard", "finish restored old record, act=" + r4.getClass().getName() + ", pageId=" + r6);
        r4.finish();
        return;
    L15:
        return;
    }
}
