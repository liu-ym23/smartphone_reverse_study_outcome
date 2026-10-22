package com.obric.assistant.voice;

import com.obric.assistant.activation.presentation.contract.ObricListeningViewState;
import com.obric.assistant.activation.presentation.runtime.manager.ObricListeningMainProcessManager;
import com.obric.assistant.activation.presentation.runtime.manager.p0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class ObricVoiceServiceImpl$b implements d {
    public static final ObricVoiceServiceImpl$b a = null;

    static {
        a = new ObricVoiceServiceImpl$b();
    }

    public ObricVoiceServiceImpl$b() {
    }

    @Override // com.obric.assistant.voice.d
    public final boolean b() {
        int r0 = sha.b.a;
        ObricListeningMainProcessManager.a.getClass();
        ObricListeningMainProcessManager.c r1 = (ObricListeningMainProcessManager.c) ObricListeningMainProcessManager.t.get();
        if (r1 == null) goto L11;
        if (r1.b == true) goto L8;
        return false;
    L8:
        if (r1.c.isValid() == false) goto L11;
        return true;
    L11:
        return ObricListeningMainProcessManager.f;
    }

    @Override // com.obric.assistant.voice.d
    public final void confirmListeningStarted() {
        int r0 = sha.b.a;
        ObricListeningMainProcessManager.a.getClass();
        ObricListeningMainProcessManager.k(new p0());
    }

    @Override // com.obric.assistant.voice.d
    public final void finish() {
        int r0 = sha.b.a;
        ObricListeningMainProcessManager r1 = ObricListeningMainProcessManager.a;
        ObricListeningViewState r2 = ObricListeningViewState.d;
        r1.getClass();
        ObricListeningMainProcessManager.p(r2);
    }

    @Override // com.obric.assistant.voice.d
    public final boolean isActive() {
        return sha.b.b();
    }

    @Override // com.obric.assistant.voice.d
    public final void a(ObricListeningViewState r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
        int r0 = sha.b.a;
        Intrinsics.checkNotNullParameter(r2, "data");
        ObricListeningMainProcessManager.a.getClass();
        ObricListeningMainProcessManager.p(r2);
    }
}
