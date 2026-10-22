package com.obric.assistant.activation.presentation.runtime.manager;

import android.os.RemoteException;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.activation.presentation.contract.ipc.IObricMainPresentationBridgeCallback;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class ObricListeningChildCoordinator$initialize$1$4 extends FunctionReferenceImpl implements Function1<Integer, Unit> {
    public ObricListeningChildCoordinator$initialize$1$4(Object r8) {
        super(1, r8, ObricListeningChildCoordinator.class, "onChildSurfaceDestroyed", "onChildSurfaceDestroyed(I)V", 0);
    }

    public final void invoke(int r6) {
        ObricListeningChildCoordinator r0 = (ObricListeningChildCoordinator) ((CallableReference) this).receiver;
        ObricListeningChildCoordinator r1 = ObricListeningChildCoordinator.a;
        r0.getClass();
        IObricMainPresentationBridgeCallback r2 = ObricListeningChildCoordinator.i;
        if (r2 != null) goto L9;
        FLogger.a.i("ObricListeningChildCoordinator", "child_surface_destroyed_ignored: reason=callback_unavailable");
        return;
    L9:
        r2.onChildSurfaceDestroyed(r6);     // Catch: RemoteException -> L7
        FLogger.a.i("ObricListeningChildCoordinator", "child_surface_destroyed_finished: generation=" + r6);     // Catch: RemoteException -> L7
        return;
    L7:
        FLogger.a.w("ObricListeningChildCoordinator", "child_surface_destroyed_failed: reason=remote_exception");
        ObricListeningChildCoordinator.a(r2.asBinder());
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke(((Number) r1).intValue());
        return Unit.INSTANCE;
    }
}
