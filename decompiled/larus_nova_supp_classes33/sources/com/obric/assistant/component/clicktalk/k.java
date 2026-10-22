package com.obric.assistant.component.clicktalk;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.ability.audio.ExitClickSpeakerType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class k implements Runnable {
    public final /* synthetic */ ChatClickTalkComponent a;
    public final /* synthetic */ ExitClickSpeakerType b;

    public /* synthetic */ k(ChatClickTalkComponent r1, ExitClickSpeakerType r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ChatClickTalkComponent r0 = this.a;
        ExitClickSpeakerType r1 = this.b;
        int r2 = ChatClickTalkComponent.L0;
        maa.g r3 = r0.E3();
        boolean r4 = false;
        if (r3 != null) goto L5;
    L7:
        boolean r5 = false;
    L8:
        maa.g r6 = r0.E3();
        if (r6 != null) goto L11;
    L13:
        if (r5 == false) goto L23;
        if (r4 == false) goto L24;
        FLogger r7 = FLogger.a;
        StringBuilder r8 = new StringBuilder("click talk still closing, force close session, type:");
        r8.append(r1);
        r8.append(", state:");
        maa.g r9 = r0.E3();
        if (r9 == null) goto L18;
        maa.d r10 = r9.vD();
    L19:
        r8.append(r10);
        r7.w("ChatClickTalkComponent", r8.toString());
        maa.g r11 = r0.E3();
        if (r11 == null) goto L25;
        r11.Uh(r1);
        return;
    L25:
        return;
    L18:
        r10 = null;
        goto L19
    L24:
        return;
    L23:
        return;
    L11:
        if (r6.L4() != true) goto L13;
        r4 = true;
        goto L13
    L5:
        if (r3.x3() != true) goto L7;
        r5 = true;
        goto L8
    }
}
