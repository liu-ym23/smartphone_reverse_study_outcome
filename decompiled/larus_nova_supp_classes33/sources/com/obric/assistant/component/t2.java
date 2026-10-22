package com.obric.assistant.component;

import androidx.lifecycle.Lifecycle;
import com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.spi.interact.ObricInteractDelegate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class t2 implements Runnable {
    public final /* synthetic */ ObricIntercomComponent a;
    public final /* synthetic */ String b;

    public /* synthetic */ t2(ObricIntercomComponent r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ObricIntercomComponent r0 = this.a;
        String r1 = this.b;
        ObricIntercomComponent$b r2 = r0.M;
        if (r2 != null) goto L6;
        FLogger.a.i("OrionIntercomComponent", "ignore conversation ready for pending TouchSpeak: no pending request, conversationId=" + r1);
        return;
    L6:
        if (((BaseComponentFeatureInternal) r0).a.getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L9;
        FLogger.a.i("OrionIntercomComponent", "ignore conversation ready for pending TouchSpeak: component not started, conversationId=" + r1 + ", lifecycleState=" + ((BaseComponentFeatureInternal) r0).a.getCurrentState().name());
        return;
    L9:
        if (ObricIntercomComponent.i4(r2.b) == true) goto L19;
        if (ObricIntercomComponent.k4() == false) goto L19;
        ObricIntercomComponent$b r3 = r0.m3("conversation_ready_after_key_release");
        if (r3 == null) goto L17;
        laa.n r4 = r3.d;
        if (r4 == null) goto L17;
        r0.V3().c(r4, "conversation_ready_after_key_release");
    L17:
        ObricIntercomComponent.z3();
        return;
    L19:
        if (Intrinsics.areEqual(ObricInteractDelegate.b.isAiKeyLongPress(), Boolean.TRUE) == true) goto L21;
        r0.m3("conversation_ready_but_key_inactive");
        return;
    L21:
        r0.M = null;
        FLogger.a.i("OrionIntercomComponent", "resume pending TouchSpeak, conversationId=" + r1);
        r0.B20(r2.a, r2.b, r2.c);
    }
}
