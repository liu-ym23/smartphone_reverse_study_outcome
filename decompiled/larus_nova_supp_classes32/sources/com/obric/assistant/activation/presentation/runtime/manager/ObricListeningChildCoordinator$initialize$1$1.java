package com.obric.assistant.activation.presentation.runtime.manager;

import android.os.RemoteException;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.activation.presentation.contract.ipc.IObricMainPresentationBridgeCallback;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class ObricListeningChildCoordinator$initialize$1$1 extends FunctionReferenceImpl implements Function0<Unit> {
    public ObricListeningChildCoordinator$initialize$1$1(Object r8) {
        super(0, r8, ObricListeningChildCoordinator.class, "onChildWindowTimeout", "onChildWindowTimeout()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m408invoke() {
        ObricListeningChildCoordinator r0 = (ObricListeningChildCoordinator) ((CallableReference) this).receiver;
        ObricListeningChildCoordinator r1 = ObricListeningChildCoordinator.a;
        r0.getClass();
        if (ObricListeningChildCoordinator.q == true) goto L5;
        FLogger.a.i("ObricListeningChildCoordinator", "child_window_timeout_ignored: reason=child_not_owned");
        return;
    L5:
        long r3 = ObricListeningChildCoordinator.x.a;
        IObricMainPresentationBridgeCallback r2 = ObricListeningChildCoordinator.i;
        if (r2 != null) goto L13;
        FLogger.a.i("ObricListeningChildCoordinator", "child_window_timeout_notify_ignored: reason=callback_unavailable revision=" + r3);
    L11:
        ObricListeningChildCoordinator.d();
        return;
    L13:
        r2.onChildPresentationTimeout(r3);     // Catch: RemoteException -> L9
        FLogger.a.i("ObricListeningChildCoordinator", "child_window_timeout_notified: revision=" + r3);     // Catch: RemoteException -> L9
    L9:
        FLogger.a.w("ObricListeningChildCoordinator", "child_window_timeout_notify_failed: reason=remote_exception revision=" + r3);
        ObricListeningChildCoordinator.a(r2.asBinder());
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m408invoke();
        return Unit.INSTANCE;
    }
}
