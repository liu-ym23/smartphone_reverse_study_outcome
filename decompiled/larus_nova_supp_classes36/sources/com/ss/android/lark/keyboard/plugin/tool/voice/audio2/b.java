package com.ss.android.lark.keyboard.plugin.tool.voice.audio2;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements Runnable {
    public final /* synthetic */ AudioAsrLanguageSwitcher a;

    public b(AudioAsrLanguageSwitcher r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AudioAsrLanguageSwitcher r0 = this.a;     // Catch: Throwable -> L7
        Iterator r1 = ((ArrayList) r0.d).iterator();     // Catch: Throwable -> L7
    L4:
        if (r1.hasNext() == false) goto L16;
        ((AudioAsrLanguageSwitcher.b) r1.next()).c(r0.f, r0.e, true);     // Catch: Throwable -> L7
        goto L4
    L16:
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }
}
