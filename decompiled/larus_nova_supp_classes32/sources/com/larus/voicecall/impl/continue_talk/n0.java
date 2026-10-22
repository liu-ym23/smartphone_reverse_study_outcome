package com.larus.voicecall.impl.continue_talk;

import com.larus.bmhome.chat.component.list.u7;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class n0 implements Runnable {
    public final /* synthetic */ ChatContinuousTalkComponent a;

    public /* synthetic */ n0(ChatContinuousTalkComponent r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        final ChatContinuousTalkComponent r0 = this.a;
        if (r0.H == true) goto L13;
        FLogger.a.i("ChatContinuousComponent", "[adaptChatPage]");
        r0.H = true;
        u7 r1 = r0.u3();
        if (r1 == null) goto L8;
        r1.vk(false, new o(r0));
    L8:
        u7 r2 = r0.u3();
        if (r2 == null) goto L12;
        r2.TP(false);
        return;
    L12:
        return;
    }
}
