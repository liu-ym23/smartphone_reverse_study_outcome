package com.obric.assistant.component.clicktalk;

import com.larus.bmhome.chat.component.list.u7;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.ability.audio.ExitClickSpeakerType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class l implements Runnable {
    public final /* synthetic */ ExitClickSpeakerType a;
    public final /* synthetic */ ChatClickTalkComponent b;

    public /* synthetic */ l(ExitClickSpeakerType r1, ChatClickTalkComponent r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ExitClickSpeakerType r0 = this.a;
        final ChatClickTalkComponent r1 = this.b;
        int r2 = ChatClickTalkComponent.L0;
        switch(ChatClickTalkComponent$d.a[r0.ordinal()]) {
            case 1: goto L9;
            case 2: goto L9;
            case 3: goto L8;
            case 4: goto L7;
            case 5: goto L6;
            case 6: goto L5;
            default: goto L4;
        };
    L4:
        ChatClickTalkComponent.i4(r1, "", "external_interrupt");
    L10:
        r1.W3(new s(r1));
        ((ChatClickTalkComponent$w) r1.H.getValue()).a();
        if (r1.E3() == null) goto L15;
        maa.g r3 = r1.E3();
        if (r3 == null) goto L18;
        r3.Uh(r0);
    L18:
        va8.o r4 = (va8.o) r1.t.getValue();
        if (r4 == null) goto L21;
        r4.nX();
    L21:
        u7 r5 = (u7) r1.u.getValue();
        if (r5 == null) goto L24;
        r5.tU(0);
    L24:
        u7 r6 = (u7) r1.u.getValue();
        if (r6 == null) goto L27;
        u7.a.a(r6, r1.I);
    L27:
        com.larus.bmhome.instruction.g r7 = (com.larus.bmhome.instruction.g) r1.v.getValue();
        if (r7 == null) goto L31;
        r7.vW(true);
        return;
    L31:
        return;
    L15:
        FLogger.a.w("ChatClickTalkComponent", "clickTalkSessionFacade is null, performCancel as fallback");
        com.larus.bmhome.chat.component.bottom.core.speaker.l r8 = r1.Ak();
        if (r8 == null) goto L18;
        r8.A9();
        goto L18
    L5:
        ChatClickTalkComponent.i4(r1, "", "manual_interrupt");
        goto L10
    L6:
        ChatClickTalkComponent.i4(r1, "", "over_time");
        goto L10
    L7:
        ChatClickTalkComponent.i4(r1, "", "manual_interrupt");
        goto L10
    L8:
        ChatClickTalkComponent.i4(r1, "", "restart_assistant");
        goto L10
    L9:
        ChatClickTalkComponent.i4(r1, "", "asr_end");
        goto L10
    }
}
