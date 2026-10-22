package com.obric.assistant.component;

import com.larus.audio.AudioServiceDelegate;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.data.ObricFloatChatPageState;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class j1 implements Runnable {
    public final /* synthetic */ ObricIntercomComponent a;
    public final /* synthetic */ ObricIntercomComponent$c b;

    public /* synthetic */ j1(ObricIntercomComponent r1, ObricIntercomComponent$c r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ObricIntercomComponent r0 = this.a;
        ObricIntercomComponent$c r1 = this.b;
        if (r0.L != r1) goto L17;
        com.larus.bmhome.chat.component.bottom.core.speaker.l r2 = r0.a4();
        if (r2 == null) goto L10;
        boolean r4 = true;
        if (r2.m0() != true) goto L10;
    L11:
        AudioServiceDelegate.a.L().a(false);
        FLogger r3 = FLogger.a;
        StringBuilder r5 = new StringBuilder("stopTouchSpeak paused ");
        r5.append(r0.K);
        r5.append(", pageState: ");
        laa.d r6 = r0.Z3();
        if (r6 == null) goto L14;
        ObricFloatChatPageState r7 = r6.getPageState();
    L15:
        r5.append(r7);
        r5.append(", isSpeaking is ");
        r5.append(r4);
        r3.i("OrionIntercomComponent", r5.toString());
        ObricIntercomComponent$TouchTerminalIntent r8 = ObricIntercomComponent$TouchTerminalIntent.SUBMIT_ON_START;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r8, "<set-?>");
        r1.e = r8;
        r0.B3(r1, "touch_stop");
        return;
    L14:
        r7 = null;
    L10:
        r4 = false;
        goto L11
    }
}
