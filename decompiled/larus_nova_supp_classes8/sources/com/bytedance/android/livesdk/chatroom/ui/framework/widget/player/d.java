package com.bytedance.android.livesdk.chatroom.ui.framework.widget.player;

import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.livesdk.chatroom.resolution.AudienceVideoResolutionManager;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d implements Runnable {
    public final /* synthetic */ AudiencePlayerCompositeWidget a;

    public d(AudiencePlayerCompositeWidget r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r0 = AudienceVideoResolutionManager.a;     // Catch: Throwable -> L8
        DataCenter r1 = ((Widget) this.a).dataCenter;     // Catch: Throwable -> L8
        if (r1 == null) goto L5;
        Room r2 = z.o(r1);     // Catch: Throwable -> L8
    L6:
        AudienceVideoResolutionManager.D(r2);     // Catch: Throwable -> L8
        return;
    L5:
        r2 = null;
    L8:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L12;
        return;
    L12:
        throw th;
    }
}
