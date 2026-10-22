package com.bytedance.android.live.browser;

import android.app.Activity;
import android.os.Bundle;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.livehostapi.foundation.depend.IHostAppMonitorListener;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class l extends IHostAppMonitorListener.Stub {
    public l() {
    }

    public final void appEnterBackground(boolean r1, boolean r2) {
        if (r2 == true) goto L5;
        Annie.appStateChange(r1);
        return;
    }

    public final void onActivityCreated(Activity r1, Bundle r2) {
        Intrinsics.checkNotNullParameter(r1, "p0");
        Annie.onNewActivityCreated(r1);
    }
}
