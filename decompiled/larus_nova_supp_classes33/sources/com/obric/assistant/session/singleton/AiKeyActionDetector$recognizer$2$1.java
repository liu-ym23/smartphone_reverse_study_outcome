package com.obric.assistant.session.singleton;

import com.obric.assistant.t1;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class AiKeyActionDetector$recognizer$2$1 extends FunctionReferenceImpl implements Function0<bba.a> {
    public AiKeyActionDetector$recognizer$2$1(Object r8) {
        super(0, r8, AiKeyActionDetector.class, "currentGestureConfig", "currentGestureConfig()Lcom/obric/assistant/activation/presentation/runtime/config/ObricAiKeyGestureConfig;", 0);
    }

    public final bba.a invoke() {
        AiKeyActionDetector r0 = (AiKeyActionDetector) ((CallableReference) this).receiver;
        AiKeyActionDetector r1 = AiKeyActionDetector.a;
        r0.getClass();
        return ((bba.b) AiKeyActionDetector.e.getValue()).a(Long.valueOf(t1.a.getObricAiKeyConfig().getAiKeyDownTimeout()));
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m11invoke() {
        return invoke();
    }
}
