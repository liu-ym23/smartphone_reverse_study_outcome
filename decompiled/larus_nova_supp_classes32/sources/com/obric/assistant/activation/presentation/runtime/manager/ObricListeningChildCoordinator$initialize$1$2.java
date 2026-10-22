package com.obric.assistant.activation.presentation.runtime.manager;

import android.os.RemoteException;
import android.view.SurfaceControl;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.activation.presentation.contract.ipc.IObricMainPresentationBridgeCallback;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class ObricListeningChildCoordinator$initialize$1$2 extends FunctionReferenceImpl implements Function4<SurfaceControl, Integer, Integer, Integer, Unit> {
    public ObricListeningChildCoordinator$initialize$1$2(Object r8) {
        super(4, r8, ObricListeningChildCoordinator.class, "onChildSurfaceAvailable", "onChildSurfaceAvailable(Landroid/view/SurfaceControl;III)V", 0);
    }

    public final void invoke(SurfaceControl r4, int r5, int r6, int r7) {
        Intrinsics.checkNotNullParameter(r4, "p0");
        ObricListeningChildCoordinator r0 = (ObricListeningChildCoordinator) ((CallableReference) this).receiver;
        ObricListeningChildCoordinator r1 = ObricListeningChildCoordinator.a;
        r0.getClass();
        if (ObricListeningChildCoordinator.q == true) goto L5;
        FLogger.a.i("ObricListeningChildCoordinator", "child_surface_available_ignored: reason=child_not_owned");
        return;
    L5:
        IObricMainPresentationBridgeCallback r2 = ObricListeningChildCoordinator.i;
        if (r2 != null) goto L12;
        FLogger.a.i("ObricListeningChildCoordinator", "child_surface_available_ignored: reason=callback_unavailable");
        return;
    L12:
        r2.onChildSurfaceChanged(r5, r6, r7, r4);     // Catch: RemoteException -> L10
        FLogger.a.i("ObricListeningChildCoordinator", "child_surface_available_finished: generation=" + r5);     // Catch: RemoteException -> L10
        return;
    L10:
        FLogger.a.w("ObricListeningChildCoordinator", "child_surface_available_failed: reason=remote_exception");
        ObricListeningChildCoordinator.a(r2.asBinder());
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3, Object r4) {
        invoke((SurfaceControl) r1, ((Number) r2).intValue(), ((Number) r3).intValue(), ((Number) r4).intValue());
        return Unit.INSTANCE;
    }
}
