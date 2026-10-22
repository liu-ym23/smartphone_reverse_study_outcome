package com.obric.assistant.view.glowui;

import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class u implements Runnable {
    public final /* synthetic */ View a;
    public final /* synthetic */ OverlayerAudioView b;
    public final /* synthetic */ int c;
    public final /* synthetic */ Function0 d;

    public u(OverlayerAudioView r1, OverlayerAudioView r2, int r3, j r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        OverlayerAudioView r0 = this.b;     // Catch: Throwable -> L4
        r0.postOnAnimation(new v(r0, this.c, this.d));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
