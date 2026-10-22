package com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.view.aiagent;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h implements Runnable {
    public final /* synthetic */ AiAgentPSSelectedMsgView a;

    public h(AiAgentPSSelectedMsgView r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AiAgentPSSelectedMsgView r0 = this.a;     // Catch: Throwable -> L4
        r0.b = false;     // Catch: Throwable -> L4
        r0.s(false);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
