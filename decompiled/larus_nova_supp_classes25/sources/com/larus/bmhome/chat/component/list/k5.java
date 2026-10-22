package com.larus.bmhome.chat.component.list;

import com.larus.utils.logger.FLogger;
import ry8.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class k5 implements Runnable {
    public final /* synthetic */ ChatListComponent a;

    public /* synthetic */ k5(ChatListComponent r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ChatListComponent r0 = this.a;
        int r1 = ChatListComponent.W3;
        b r2 = r0.B4();
        if (r2 == null) goto L5;
        r2.setAudioBtnEnabled(false);
    L5:
        com.larus.bmhome.chat.component.bottom.bottommenu.f1 r3 = r0.k4();
        if (r3 == null) goto L8;
        r3.setAudioBtnEnabled(false);
    L8:
        FLogger.a.d(r0.n, "onRecordingStart");
        maa.e r4 = (maa.e) r0.c3.getValue();
        if (r4 == null) goto L12;
        maa.e.a.a(r4, null, null, false, 7);
        return;
    }
}
