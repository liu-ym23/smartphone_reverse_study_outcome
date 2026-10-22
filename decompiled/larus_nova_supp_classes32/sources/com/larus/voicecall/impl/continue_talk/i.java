package com.larus.voicecall.impl.continue_talk;

import com.larus.im.bean.bot.BotModel;
import com.larus.utils.logger.FLogger;
import s1a.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class i implements Runnable {
    public final /* synthetic */ ChatContinuousTalkComponent a;

    public /* synthetic */ i(ChatContinuousTalkComponent r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ChatContinuousTalkComponent r0 = this.a;
        int r1 = ChatContinuousTalkComponent.M;
        if (a.c(r0).isAdded() == true) goto L5;
    L25:
        FLogger.a.w("ChatContinuousComponent", "[onViewCreated]_" + r0.hashCode() + " fragment is invalid, skip recreate logic");
        return;
    L5:
        if (a.c(r0).isRemoving() == true) goto L25;
        if (a.c(r0).isDetached() == true) goto L25;
        if (a.c(r0).getView() == null) goto L25;
        if (k1.a == false) goto L27;
        FLogger.a.i("ChatContinuousComponent", "[onViewCreated]_" + r0.hashCode() + " tryStartContinueTalkAtStart when recreate");
        com.larus.bmhome.chat.component.cvs.y r2 = r0.u0();
        BotModel r3 = null;
        if (r2 == null) goto L16;
        wc9.e r4 = r2.h();
    L17:
        if (r4 == null) goto L23;
        com.larus.bmhome.chat.component.cvs.y r5 = r0.u0();
        if (r5 == null) goto L21;
        r3 = r5.j0();
    L21:
        if (r3 == null) goto L23;
        r0.D3();
    L24:
        k1.a = false;
        return;
    L23:
        r0.B3();
        goto L24
    L16:
        r4 = null;
        goto L17
    }
}
