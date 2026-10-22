package com.obric.assistant.util;

import com.obric.assistant.state.api.multitask.IVoiceCaptureStateProducerService;
import com.obric.assistant.state.api.multitask.VoiceCaptureStateProducerDelegate;
import com.obric.assistant.state.api.multitask.state.VoiceCaptureScene;
import com.obric.assistant.state.api.v2.core.IObricStateDispatcherService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class e2 implements hca.c {
    public e2() {
    }

    public final void a(String r2, Integer r3, String r4) {
        IObricStateDispatcherService r5 = (IObricStateDispatcherService) ServiceManager.get().getService(IObricStateDispatcherService.class);
        if (r5 == null) goto L6;
        r5.h(r2, r3);
        return;
    }

    public final void b(String r3, Integer r4, String r5) {
        IObricStateDispatcherService r0 = (IObricStateDispatcherService) ServiceManager.get().getService(IObricStateDispatcherService.class);
        if (r0 == null) goto L5;
        r0.m(r3, r4);
    L5:
        IVoiceCaptureStateProducerService.a.a(VoiceCaptureStateProducerDelegate.b, r3, VoiceCaptureScene.CLICK_TALK, r5, r4);
    }

    public final void c(String r3, Integer r4, String r5) {
        VoiceCaptureStateProducerDelegate.b.c(r3, VoiceCaptureScene.CLICK_TALK, r5, r4);
    }

    public final void d(String r3, Integer r4, String r5) {
        IObricStateDispatcherService r0 = (IObricStateDispatcherService) ServiceManager.get().getService(IObricStateDispatcherService.class);
        if (r0 == null) goto L5;
        r0.n(r3, r4);
    L5:
        VoiceCaptureStateProducerDelegate.b.d(r3, VoiceCaptureScene.CLICK_TALK, r5, r4);
    }

    public final void e(String r3, Integer r4, String r5) {
        IObricStateDispatcherService r0 = (IObricStateDispatcherService) ServiceManager.get().getService(IObricStateDispatcherService.class);
        if (r0 == null) goto L5;
        r0.b(r3, r4);
    L5:
        VoiceCaptureStateProducerDelegate.b.e(r3, VoiceCaptureScene.CLICK_TALK, r5, r4);
    }
}
