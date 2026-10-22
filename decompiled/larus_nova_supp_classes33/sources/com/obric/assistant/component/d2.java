package com.obric.assistant.component;

import com.obric.assistant.activation.presentation.contract.ObricListeningVisualMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class d2 implements Runnable {
    public final /* synthetic */ ObricIntercomComponent a;
    public final /* synthetic */ laa.n b;

    public /* synthetic */ d2(ObricIntercomComponent r1, com.obric.assistant.view.listening.b r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        final ObricIntercomComponent r0 = this.a;
        laa.n r2 = this.b;
        int r1 = ObricIntercomComponent.h1;
        r0.V3().f(r2, ObricListeningVisualMode.PRESS_TALK, "long_press", new g2(r0), new h2(r0));
    }
}
