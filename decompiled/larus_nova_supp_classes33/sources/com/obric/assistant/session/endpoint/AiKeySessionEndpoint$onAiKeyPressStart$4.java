package com.obric.assistant.session.endpoint;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class AiKeySessionEndpoint$onAiKeyPressStart$4 extends FunctionReferenceImpl implements Function0<Unit> {
    public AiKeySessionEndpoint$onAiKeyPressStart$4(Object r8) {
        super(0, r8, AiKeySessionEndpoint.class, "playAiKeyStartListeningFeedbackIfNeeded", "playAiKeyStartListeningFeedbackIfNeeded()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m10invoke() {
        AiKeySessionEndpoint.r((AiKeySessionEndpoint) ((CallableReference) this).receiver);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m10invoke();
        return Unit.INSTANCE;
    }
}
