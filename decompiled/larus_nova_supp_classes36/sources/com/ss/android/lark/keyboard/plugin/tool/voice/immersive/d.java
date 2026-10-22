package com.ss.android.lark.keyboard.plugin.tool.voice.immersive;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d implements Runnable {
    public final /* synthetic */ AsrInputVoiceView a;

    public d(AsrInputVoiceView r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.larksuite.component.universe_design.toast.c r0 = this.a.v;     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        r0.cancel();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
