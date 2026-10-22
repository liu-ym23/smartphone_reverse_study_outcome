package com.obric.assistant.chat.component.interaction;

import com.obric.assistant.audio.service.IManualHalfDuplexModeService;
import com.obric.assistant.state.api.multitask.VoiceCaptureStateProducerDelegate;
import com.obric.assistant.state.api.multitask.state.VoiceCaptureScene;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class i implements Function1 {
    public final /* synthetic */ TouchSpeakerEventComponent a;
    public final /* synthetic */ TouchSpeakerEventComponent$b b;

    public /* synthetic */ i(TouchSpeakerEventComponent r1, TouchSpeakerEventComponent$b r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r9) {
        TouchSpeakerEventComponent r0 = this.a;
        TouchSpeakerEventComponent$b r1 = this.b;
        String r7 = (String) r9;
        int r10 = TouchSpeakerEventComponent.n;
        Intrinsics.checkNotNullParameter(r7, "botId");
        Object r11 = r0.l;
        monitor-enter(r11);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (r0.m == r1) goto L7;
    L12:
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L16
        monitor-exit(r11);
        return r2;
    L7:
        if (r1.e == false) goto L12;
        r1.f = r7;     // Catch: Throwable -> L16
        r1.g = ((IManualHalfDuplexModeService) r0.h.getValue()).c(r7, r1.c, r1.d);     // Catch: Throwable -> L16
        VoiceCaptureStateProducerDelegate.b.b(r1.c, VoiceCaptureScene.TOUCH_SPEAK, r1.a, Integer.valueOf(r1.b), r7);     // Catch: Throwable -> L16
        r1.i = true;     // Catch: Throwable -> L16
        r0.L2(r1);     // Catch: Throwable -> L16
        monitor-exit(r11);
        return Unit.INSTANCE;
    }
}
