package com.obric.assistant.activation.presentation.runtime.manager;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class ObricListeningMainProcessManager$onHostWindowHidden$1$1 extends FunctionReferenceImpl implements Function0<Unit> {
    public ObricListeningMainProcessManager$onHostWindowHidden$1$1(Object r8) {
        super(0, r8, ObricListeningMainProcessManager.class, "onHostWindowHidden", "onHostWindowHidden()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m409invoke() {
        ((ObricListeningMainProcessManager) ((CallableReference) this).receiver).getClass();
        ObricListeningMainProcessManager.k(new w0());
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m409invoke();
        return Unit.INSTANCE;
    }
}
