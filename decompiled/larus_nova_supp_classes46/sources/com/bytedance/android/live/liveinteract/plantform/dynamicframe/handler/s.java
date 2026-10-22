package com.bytedance.android.live.liveinteract.plantform.dynamicframe.handler;

import com.bytedance.android.livesdk.config.h30;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class s implements Runnable {
    public final /* synthetic */ v a;

    public s(v r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DataCenter r0 = this.a.c;     // Catch: Throwable -> L6
        Boolean r1 = Boolean.TRUE;     // Catch: Throwable -> L6
        r0.put("cmd_multi_enter_room_remove_view_mock", r1);     // Catch: Throwable -> L6
        if (((Boolean) h30.a.getValue()).booleanValue() == false) goto L9;
        this.a.c.put("cmd_multi_enter_room_lynx_micseat_remove_view_mock", r1);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
