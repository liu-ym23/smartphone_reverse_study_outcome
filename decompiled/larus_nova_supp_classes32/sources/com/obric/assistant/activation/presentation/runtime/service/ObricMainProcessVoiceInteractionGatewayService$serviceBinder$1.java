package com.obric.assistant.activation.presentation.runtime.service;

import android.os.IBinder;
import android.os.RemoteException;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.activation.presentation.contract.ipc.IInteractionSessionProxy;
import com.obric.assistant.activation.presentation.contract.ipc.IObricInteractorBridgeService;
import com.obric.assistant.activation.presentation.contract.ipc.IObricInteractorPresentationBridgeService;
import com.obric.assistant.activation.presentation.runtime.manager.ObricListeningMainProcessManager;
import com.obric.assistant.activation.presentation.runtime.manager.i0;
import com.obric.assistant.activation.presentation.runtime.session.server.InteractionSessionProxyBinder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\t"}, d2 = {"com/obric/assistant/activation/presentation/runtime/service/ObricMainProcessVoiceInteractionGatewayService$serviceBinder$1", "Lcom/obric/assistant/activation/presentation/contract/ipc/IObricInteractorBridgeService$Stub;", "getInteractionSessionProxy", "Lcom/obric/assistant/activation/presentation/contract/ipc/IInteractionSessionProxy;", "registerPresentationBridge", NameKeys.UnloadStrategy_No_Strategy, "presentationBridge", "Landroid/os/IBinder;", "unregisterPresentationBridge", "runtime_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricMainProcessVoiceInteractionGatewayService$serviceBinder$1 extends IObricInteractorBridgeService.Stub {
    final /* synthetic */ ObricMainProcessVoiceInteractionGatewayService this$0;

    public static /* synthetic */ Unit a(ObricMainProcessVoiceInteractionGatewayService r0, IObricInteractorPresentationBridgeService r1) {
        return registerPresentationBridge$lambda$0(r0, r1);
    }

    public static /* synthetic */ Unit b(ObricMainProcessVoiceInteractionGatewayService r0, IBinder r1) {
        return unregisterPresentationBridge$lambda$1(r0, r1);
    }

    @Override // com.obric.assistant.activation.presentation.contract.ipc.IObricInteractorBridgeService
    public IInteractionSessionProxy getInteractionSessionProxy() {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("getInteractionSessionProxy, ");
        int r2 = ObricMainProcessVoiceInteractionGatewayService.f;
        r1.append(ObricMainProcessVoiceInteractionGatewayService.a.a());
        r0.i("ObricMainVoiceGateS", r1.toString());
        InteractionSessionProxyBinder r3 = this.this$0.b;
        if (r3 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("sessionBinder");
        return null;
    L6:
        return r3;
    }

    public ObricMainProcessVoiceInteractionGatewayService$serviceBinder$1(ObricMainProcessVoiceInteractionGatewayService r1) {
        this.this$0 = r1;
    }

    @Override // com.obric.assistant.activation.presentation.contract.ipc.IObricInteractorBridgeService
    public void registerPresentationBridge(IBinder r6) {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("registerPresentationBridge, ");
        int r2 = ObricMainProcessVoiceInteractionGatewayService.f;
        r1.append(ObricMainProcessVoiceInteractionGatewayService.a.a());
        r1.append(", hasBinder=");
        boolean r3 = false;
        if (r6 == null) goto L5;
        boolean r4 = true;
    L6:
        r1.append(r4);
        r1.append(", binderAlive=");
        if (r6 != null) goto L9;
    L11:
        r1.append(r3);
        r0.i("ObricMainVoiceGateS", r1.toString());
        if (r6 != null) goto L15;
        r0.w("ObricMainVoiceGateS", "ignore null presentation bridge registration");
        return;
    L15:
        final IObricInteractorPresentationBridgeService r7 = IObricInteractorPresentationBridgeService.Stub.asInterface(r6);
        final ObricMainProcessVoiceInteractionGatewayService r5 = this.this$0;
        r5.b(new d(r5, r7));
        return;
    L9:
        if (r6.isBinderAlive() != true) goto L11;
        r3 = true;
        goto L11
    L5:
        r4 = false;
        goto L6
    }

    @Override // com.obric.assistant.activation.presentation.contract.ipc.IObricInteractorBridgeService
    public void unregisterPresentationBridge(final IBinder r4) {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("unregisterPresentationBridge, ");
        int r2 = ObricMainProcessVoiceInteractionGatewayService.f;
        r1.append(ObricMainProcessVoiceInteractionGatewayService.a.a());
        r1.append(", hasBinder=");
        if (r4 == null) goto L5;
        boolean r3 = true;
    L6:
        r1.append(r3);
        r0.i("ObricMainVoiceGateS", r1.toString());
        if (r4 != null) goto L10;
        r0.w("ObricMainVoiceGateS", "ignore null presentation bridge unregistration");
        return;
    L10:
        final ObricMainProcessVoiceInteractionGatewayService r5 = this.this$0;
        r5.b(new e(r5, r4));
        return;
    L5:
        r3 = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [android.os.IBinder$DeathRecipient, com.obric.assistant.activation.presentation.runtime.service.a] */
    private static final Unit registerPresentationBridge$lambda$0(final ObricMainProcessVoiceInteractionGatewayService r8, final IObricInteractorPresentationBridgeService r9) {
        Intrinsics.checkNotNull(r9);
        int r0 = ObricMainProcessVoiceInteractionGatewayService.f;
        r8.getClass();
        final IBinder r1 = r9.asBinder();
        IObricInteractorPresentationBridgeService r2 = r8.c;
        IBinder r3 = null;
        if (r2 == null) goto L5;
        IBinder r4 = r2.asBinder();
    L7:
        if (r4 != r1) goto L9;
        FLogger.a.i("ObricMainVoiceGateS", "reuse registered presentation bridge, binder=" + r1.hashCode() + ", alive=" + r1.isBinderAlive());
        ObricListeningMainProcessManager.a.getClass();
        Intrinsics.checkNotNullParameter(r9, "incoming");
        ObricListeningMainProcessManager.k(new i0(r9));
    L27:
        return Unit.INSTANCE;
    L9:
        IObricInteractorPresentationBridgeService r5 = r8.c;
        if (r5 == null) goto L12;
        boolean r6 = true;
    L13:
        if (r5 == null) goto L17;
        IBinder r7 = r5.asBinder();
        if (r7 == null) goto L17;
        Integer r10 = Integer.valueOf(r7.hashCode());
    L18:
        IObricInteractorPresentationBridgeService r11 = r8.c;
        if (r11 == null) goto L21;
        r3 = r11.asBinder();
    L21:
        r8.a(r3, "bridge replaced");
        ?? r12 = new a(r8, r1);
        r1.linkToDeath(r12, 0);     // Catch: RemoteException -> L24
        r8.c = r9;
        r8.d = r12;
        ObricListeningMainProcessManager.a.getClass();
        Intrinsics.checkNotNullParameter(r9, "incoming");
        ObricListeningMainProcessManager.k(new i0(r9));
        FLogger.a.i("ObricMainVoiceGateS", "interactor presentation bridge attached, binder=" + r1.hashCode() + ", replacing=" + r6 + ", previousBinder=" + r10);
    L24:
        e = move-exception;
        FLogger.a.w("ObricMainVoiceGateS", "interactor bridge already dead", e);
    L17:
        r10 = null;
        goto L18
    L12:
        r6 = false;
        goto L13
    L5:
        r4 = null;
        goto L7
    }

    private static final Unit unregisterPresentationBridge$lambda$1(ObricMainProcessVoiceInteractionGatewayService r1, IBinder r2) {
        int r0 = ObricMainProcessVoiceInteractionGatewayService.f;
        r1.a(r2, "client unregistered");
        return Unit.INSTANCE;
    }
}
