package com.bytedance.android.livesdk.chatroom.ui.framework.widget.multistate;

import com.bytedance.android.livesdk.chatroom.ui.framework.utils.h;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.larus.apm.impl.protector.RunnableProtector;
import jd0.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a implements Runnable {
    public final /* synthetic */ PKAndMultiCompositeWidget.e a;

    public a(PKAndMultiCompositeWidget.e r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DataCenter r0 = ((Widget) this.a.a).dataCenter;     // Catch: Throwable -> L9
        boolean r1 = false;
        if (r0 == null) goto L7;
        g r2 = (g) r0.get("cmd_interact_audio", new g(false));     // Catch: Throwable -> L9
        if (r2 == null) goto L7;
        r1 = r2.a;     // Catch: Throwable -> L9
    L7:
        PKAndMultiCompositeWidget r3 = this.a.a;     // Catch: Throwable -> L9
        int r4 = PKAndMultiCompositeWidget.g;     // Catch: Throwable -> L9
        h.a(((Widget) r3).dataCenter, "ForVoiceChat");     // Catch: Throwable -> L9
        r3.wq(r1);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L13;
        return;
    L13:
        throw th;
    }
}
