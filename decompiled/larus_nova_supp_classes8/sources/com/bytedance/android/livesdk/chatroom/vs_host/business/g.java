package com.bytedance.android.livesdk.chatroom.vs_host.business;

import android.app.Activity;
import com.bytedance.android.livesdk.projectmode.EmptyDebugWidget;
import com.bytedance.android.livesdk.projectmode.ILiveSdkProjectModeService;
import com.bytedance.ies.sdk.widgets.Widget;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g implements yr1.e, com.bytedance.android.scope.o {
    public g() {
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // yr1.e
    public final Class<? extends Widget> c() {
        ILiveSdkProjectModeService r0 = jc1.k.f(ILiveSdkProjectModeService.class);
        if (r0 == null) goto L6;
        Class<? extends Widget> r1 = r0.getDebugTestInfoElementClass();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return EmptyDebugWidget.class;
    }

    @Override // yr1.e
    public final void a(Activity r2) {
        ILiveSdkProjectModeService r0 = jc1.k.f(ILiveSdkProjectModeService.class);
        if (r0 == null) goto L6;
        r0.showLiveDebugDialog(r2);
        return;
    }
}
