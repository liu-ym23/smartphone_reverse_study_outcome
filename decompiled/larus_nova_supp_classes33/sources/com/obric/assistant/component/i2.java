package com.obric.assistant.component;

import com.obric.assistant.activation.presentation.contract.ObricListeningVisualMode;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class i2 implements Runnable {
    public final /* synthetic */ ObricIntercomComponent a;

    public /* synthetic */ i2(ObricIntercomComponent r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        final ObricIntercomComponent r0 = this.a;
        int r1 = ObricIntercomComponent.h1;
        com.obric.assistant.view.listening.f r2 = r0.V3();
        ObricListeningVisualMode r3 = ObricListeningVisualMode.CLICK_TALK;
        Function0<Boolean> r4 = new l2(r0);
        AtomicLong r5 = com.obric.assistant.view.listening.f.l;
        r2.g(r3, "ai_key_short_click", r4, new com.obric.assistant.view.listening.e());
    }
}
