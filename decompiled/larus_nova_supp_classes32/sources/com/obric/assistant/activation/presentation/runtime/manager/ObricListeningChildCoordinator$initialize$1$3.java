package com.obric.assistant.activation.presentation.runtime.manager;

import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class ObricListeningChildCoordinator$initialize$1$3 extends FunctionReferenceImpl implements Function2<Integer, Long, Unit> {
    public ObricListeningChildCoordinator$initialize$1$3(Object r8) {
        super(2, r8, ObricListeningChildCoordinator.class, "onChildFirstDrawReady", "onChildFirstDrawReady(IJ)V", 0);
    }

    public final void invoke(int r5, long r6) {
        ObricListeningChildCoordinator r0 = (ObricListeningChildCoordinator) ((CallableReference) this).receiver;
        ObricListeningChildCoordinator r1 = ObricListeningChildCoordinator.a;
        r0.getClass();
        if (ObricListeningChildCoordinator.q == true) goto L5;
        FLogger.a.g("ObricListeningChildCoordinator", new d());
        return;
    L5:
        String r2 = ObricListeningChildCoordinator.u;
        if (r2 == null) goto L26;
        String r3 = null;
        if ((!StringsKt.isBlank(r2)) == true) goto L11;
        r2 = null;
    L11:
        if (r2 == null) goto L26;
        ObricListeningChildCoordinator.a r4 = new ObricListeningChildCoordinator.a(r5, r2, r6);
        ObricListeningChildCoordinator.a r7 = ObricListeningChildCoordinator.w;
        if (r7 == null) goto L17;
        r3 = r7.b;
    L17:
        if (Intrinsics.areEqual(r3, r2) == true) goto L19;
    L21:
        r7 = r4;
    L22:
        ObricListeningChildCoordinator.w = r7;
        if (ObricListeningChildCoordinator.t != ActivationSource.AI_KEY) goto L25;
        r4 = ObricListeningChildCoordinator.w;
    L25:
        ObricListeningChildCoordinator.v = r4;
        ObricListeningChildCoordinator.b();
        return;
    L19:
        if (r7.c > r6) goto L21;
    L26:
        FLogger.a.g("ObricListeningChildCoordinator", new e());
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r3, Object r4) {
        invoke(((Number) r3).intValue(), ((Number) r4).longValue());
        return Unit.INSTANCE;
    }
}
