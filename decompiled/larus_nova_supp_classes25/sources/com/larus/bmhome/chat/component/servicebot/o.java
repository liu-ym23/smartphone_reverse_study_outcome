package com.larus.bmhome.chat.component.servicebot;

import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.common_ui.widget.RedDotTextView;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class o implements nf9.e {
    public final /* synthetic */ ServiceBotComponent a;

    public final String a() {
        ServiceBotComponent r0 = this.a;
        int r1 = ServiceBotComponent.u;
        return r0.L2();
    }

    public o(ServiceBotComponent r1) {
        this.a = r1;
    }

    public final void onUpdate(final int r5) {
        FLogger.a.i("ServiceBotComponent", "update red dot cnt=" + r5);
        ServiceBotComponent r0 = this.a;
        final RedDotTextView r1 = r0.r;
        if (r1 != null) goto L5;
        return;
    L5:
        NovaTitleBarEx r2 = r0.P2();
        final ServiceBotComponent r3 = this.a;
        r2.post(new n(r3, r1, r5));
    }
}
