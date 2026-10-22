package com.bytedance.android.livesdk.chatroom.vs_host.business;

import android.content.Context;
import com.bytedance.android.livehostapi.foundation.IHostApp;
import com.bytedance.android.livehostapi.platform.IHostAction;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class x implements yr1.q, com.bytedance.android.scope.o {
    public x() {
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // yr1.q
    public final boolean a(Context r3, String r4) {
        IHostAction r0 = jc1.k.f(IHostAction.class);
        if (r0 == null) goto L6;
        r0.showStickyToast(r3, r4, 0);
        return true;
    L6:
        return false;
    }

    @Override // yr1.q
    public final boolean c(Context r3, String r4) {
        IHostApp r0 = jc1.k.f(IHostApp.class);
        if (r0 == null) goto L6;
        r0.systemToast(r3, r4, 0);
        return true;
    L6:
        return false;
    }

    @Override // yr1.q
    public final boolean centerToast(Context r2, String r3, int r4) {
        IHostApp r0 = jc1.k.f(IHostApp.class);
        if (r0 == null) goto L6;
        r0.centerToast(r2, r3, r4);
        return true;
    L6:
        return false;
    }
}
