package com.obric.assistant.activation.presentation.runtime.session.dispatch;

import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class InteractionSessionEventDispatcher$init$1 extends FunctionReferenceImpl implements Function0<Unit> {
    public InteractionSessionEventDispatcher$init$1(Object r8) {
        super(0, r8, InteractionSessionEventDispatcher.class, "onAiKeyDownReadyToDispatch", "onAiKeyDownReadyToDispatch()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m410invoke() {
        InteractionSessionEventDispatcher r0 = (InteractionSessionEventDispatcher) ((CallableReference) this).receiver;
        InteractionSessionEventDispatcher r1 = InteractionSessionEventDispatcher.a;
        monitor-enter(r0);
        a.b<InteractionSessionEventDispatcher.a> r2 = InteractionSessionEventDispatcher.b.g();     // Catch: Throwable -> L7
        FLogger.a.i("InteractionSessionED", "ai_key_down_ready: released=" + r2.a.size() + " activeSessionId=" + InteractionSessionEventDispatcher.c);     // Catch: Throwable -> L7
        InteractionSessionEventDispatcher.b("ai_key_down_ready", null, r2);     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m410invoke();
        return Unit.INSTANCE;
    }
}
