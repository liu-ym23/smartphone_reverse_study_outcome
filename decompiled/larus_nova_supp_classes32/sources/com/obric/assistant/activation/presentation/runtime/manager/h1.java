package com.obric.assistant.activation.presentation.runtime.manager;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.spi.startup.AssistantStartupTelemetry;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class h1 implements Function0 {
    public final /* synthetic */ String a;
    public final /* synthetic */ boolean b;

    public /* synthetic */ h1(String r1, boolean r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke() {
        final String r0 = this.a;
        boolean r1 = this.b;
        AssistantStartupTelemetry r2 = AssistantStartupTelemetry.a;
        if (Intrinsics.areEqual(r2.h(), r0) == true) goto L15;
        ObricListeningMainProcessManager.b r3 = ObricListeningMainProcessManager.u;
        if (r3 == null) goto L7;
        String r4 = r3.b;
    L9:
        if (Intrinsics.areEqual(r4, r0) == false) goto L12;
        ObricListeningMainProcessManager.u = null;
    L12:
        if (Intrinsics.areEqual(ObricListeningMainProcessManager.v, r0) == false) goto L14;
        ObricListeningMainProcessManager.v = null;
    L14:
        FLogger.a.g("ObricListeningMainPM", new j0(r0));
        return Unit.INSTANCE;
    L7:
        r4 = null;
        goto L9
    L15:
        if (r1 == false) goto L17;
        ObricListeningMainProcessManager.v = r0;
    L17:
        ObricListeningMainProcessManager.b r5 = ObricListeningMainProcessManager.u;
        if (r5 != null) goto L21;
        return Unit.INSTANCE;
    L21:
        if (Intrinsics.areEqual(r5.b, r0) == true) goto L24;
        return Unit.INSTANCE;
    L24:
        if (Intrinsics.areEqual(r2.i("window_content_ready"), r0) == true) goto L27;
        if (r1 == true) goto L27;
        ObricListeningMainProcessManager.u = null;
        FLogger.a.g("ObricListeningMainPM", new k0(r0));
        return Unit.INSTANCE;
    L27:
        ObricListeningMainProcessManager.a.getClass();
        ObricListeningMainProcessManager.a(r5, r1);
        return Unit.INSTANCE;
    }
}
