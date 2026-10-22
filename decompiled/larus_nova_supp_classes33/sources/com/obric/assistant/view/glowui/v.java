package com.obric.assistant.view.glowui;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class v implements Runnable {
    public final /* synthetic */ OverlayerAudioView a;
    public final /* synthetic */ int b;
    public final /* synthetic */ Function0<Unit> c;

    public v(OverlayerAudioView r1, int r2, Function0<Unit> r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        OverlayerAudioView r0 = this.a;     // Catch: Throwable -> L4
        int r1 = this.b;     // Catch: Throwable -> L4
        Function0<Unit> r2 = this.c;     // Catch: Throwable -> L4
        float[] r3 = OverlayerAudioView.B;     // Catch: Throwable -> L4
        r0.g(r1, r2);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
