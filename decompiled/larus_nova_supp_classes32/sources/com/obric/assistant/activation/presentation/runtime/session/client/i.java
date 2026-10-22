package com.obric.assistant.activation.presentation.runtime.session.client;

import android.content.Context;
import android.os.RemoteException;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.activation.presentation.contract.ipc.IObricInteractorBridgeService;
import com.obric.assistant.activation.presentation.runtime.manager.ObricInteractorPresentationBridge;
import com.obric.assistant.activation.presentation.runtime.manager.ObricInteractorPresentationBridge$binder$1;
import com.obric.assistant.activation.presentation.runtime.manager.ObricListeningChildCoordinator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.Channel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class i implements Function0 {
    public final /* synthetic */ Context a;

    public /* synthetic */ i(Context r1) {
        this.a = r1;
    }

    public final Object invoke() {
        Context r0 = this.a;
        Channel<InteractionSessionProxyClient.a> r1 = InteractionSessionProxyClient.a;
        Intrinsics.checkNotNull(r0);
        FLogger r2 = FLogger.a;
        r2.i("InteractionSessionPC", "destroy start, " + InteractionSessionProxyClient.a());
        InteractionSessionProxyClient.j = false;
        ObricInteractorPresentationBridge$binder$1 r3 = InteractionSessionProxyClient.g;
        if (r3 == null) goto L14;
        a r5 = InteractionSessionProxyClient.c;
        if (r5 == null) goto L7;
        IObricInteractorBridgeService r6 = r5.c();
    L20:
        if (r6 == null) goto L10;
        r6.unregisterPresentationBridge(r3.asBinder());     // Catch: RemoteException -> L12
        r2.i("InteractionSessionPC", "presentation bridge unregistered");     // Catch: RemoteException -> L12
    L19:
        goto L14
    L10:
        r2.i("InteractionSessionPC", "skip presentation unregister: service is disconnected");     // Catch: RemoteException -> L12
    L12:
        e = move-exception;
        FLogger.a.w("InteractionSessionPC", "interactor bridge unregistration failed", e);
        goto L14
    L7:
        r6 = null;
    L14:
        InteractionSessionProxyClient.e = null;
        InteractionSessionProxyClient.f = null;
        InteractionSessionProxyClient.k.clear();
        InteractionSessionProxyClient.h = null;
        InteractionSessionProxyClient.i = null;
        InteractionSessionProxyClient.g = null;
        a r4 = InteractionSessionProxyClient.c;
        if (r4 == null) goto L17;
        r4.b(r0);
    L17:
        ObricInteractorPresentationBridge.a r7 = ObricInteractorPresentationBridge.a;
        FLogger r8 = FLogger.a;
        r8.i("ObricInteractorPresentationB", "destroy, binder=" + ObricInteractorPresentationBridge.b.hashCode());
        ObricInteractorPresentationBridge.a = null;
        ObricListeningChildCoordinator.a.getClass();
        ObricListeningChildCoordinator.i(new com.obric.assistant.activation.presentation.runtime.manager.g());
        InteractionSessionProxyClient.d = null;
        r8.i("InteractionSessionPC", "destroy complete, " + InteractionSessionProxyClient.a());
        return Unit.INSTANCE;
    }
}
