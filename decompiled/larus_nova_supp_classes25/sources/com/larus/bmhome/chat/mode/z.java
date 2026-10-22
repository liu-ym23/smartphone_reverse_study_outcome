package com.larus.bmhome.chat.mode;

import com.larus.bmhome.auth.ConversationMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class z implements Runnable {
    public final /* synthetic */ ModeSwitchComponent a;

    public /* synthetic */ z(ModeSwitchComponent r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ModeSwitchComponent r0 = this.a;
        int r1 = ModeSwitchComponent.k0;
        r0.Q3((ConversationMode) r0.Si().getValue());
    }
}
