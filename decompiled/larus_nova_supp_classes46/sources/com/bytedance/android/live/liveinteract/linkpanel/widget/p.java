package com.bytedance.android.live.liveinteract.linkpanel.widget;

import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class p implements Runnable {
    public final /* synthetic */ LinkInviteListWidget a;

    public p(LinkInviteListWidget r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        LinkInviteListWidget r0 = this.a;     // Catch: Throwable -> L8
        if (((Widget) r0).contentView == null) goto L11;
        WidgetManager r1 = r0.G;     // Catch: Throwable -> L8
        if (r1 == null) goto L15;
        r1.load(2131372686, r0.F);     // Catch: Throwable -> L8
        return;
    L15:
        return;
    L11:
        return;
    L8:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    }
}
