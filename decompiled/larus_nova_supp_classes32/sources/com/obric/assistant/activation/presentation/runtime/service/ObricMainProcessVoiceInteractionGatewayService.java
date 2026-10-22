package com.obric.assistant.activation.presentation.runtime.service;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Process;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.activation.presentation.contract.ipc.IObricInteractorPresentationBridgeService;
import com.obric.assistant.activation.presentation.runtime.manager.ObricListeningMainProcessManager;
import com.obric.assistant.activation.presentation.runtime.manager.a0;
import com.obric.assistant.activation.presentation.runtime.session.server.InteractionSessionProxyBinder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000]\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\r\u0018\u0000 %2\u00020\u0001:\u0001%B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\"\u0010\u0015\u001a\u00020\u00162\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0016H\u0016J\u0012\u0010\u0019\u001a\u00020\u001a2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u001b\u001a\u00020\u0010H\u0016J\u0010\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\tH\u0002J\u001a\u0010\u001e\u001a\u00020\u00102\b\u0010\u001f\u001a\u0004\u0018\u00010\u00122\u0006\u0010 \u001a\u00020!H\u0002J\u0016\u0010\"\u001a\u00020\u00102\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00100$H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000e¨\u0006&"}, d2 = {"Lcom/obric/assistant/activation/presentation/runtime/service/ObricMainProcessVoiceInteractionGatewayService;", "Landroid/app/Service;", "<init>", "()V", "mainHandler", "Landroid/os/Handler;", "sessionBinder", "Lcom/obric/assistant/activation/presentation/runtime/session/server/InteractionSessionProxyBinder;", "interactorBridge", "Lcom/obric/assistant/activation/presentation/contract/ipc/IObricInteractorPresentationBridgeService;", "interactorBridgeDeathRecipient", "Landroid/os/IBinder$DeathRecipient;", "serviceBinder", "com/obric/assistant/activation/presentation/runtime/service/ObricMainProcessVoiceInteractionGatewayService$serviceBinder$1", "Lcom/obric/assistant/activation/presentation/runtime/service/ObricMainProcessVoiceInteractionGatewayService$serviceBinder$1;", "onCreate", NameKeys.UnloadStrategy_No_Strategy, "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onStartCommand", NameKeys.UnloadStrategy_No_Strategy, "flags", "startId", "onUnbind", NameKeys.UnloadStrategy_No_Strategy, "onDestroy", "replaceInteractorBridge", "incoming", "clearInteractorBridge", "expectedBinder", "reason", NameKeys.UnloadStrategy_No_Strategy, "onMain", "block", "Lkotlin/Function0;", "Companion", "runtime_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricMainProcessVoiceInteractionGatewayService extends Service {
    public static final /* synthetic */ int f = 0;
    public final Handler a;
    public InteractionSessionProxyBinder b;
    public IObricInteractorPresentationBridgeService c;
    public com.obric.assistant.activation.presentation.runtime.service.a d;
    public final ObricMainProcessVoiceInteractionGatewayService$serviceBinder$1 e;

    public static final class a {
        public static final String a() {
            int r0 = ObricMainProcessVoiceInteractionGatewayService.f;
            return "callerPid=" + Binder.getCallingPid() + ", callerUid=" + Binder.getCallingUid();
        }

        public a() {
        }
    }

    static {
        new a();
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent r1, int r2, int r3) {
        return 2;
    }

    @Override // android.app.Service
    public final void onDestroy() {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("onDestroy start, hasPresentation=");
        if (this.c == null) goto L5;
        boolean r2 = true;
    L6:
        r1.append(r2);
        r0.i("ObricMainVoiceGateS", r1.toString());
        InteractionSessionProxyBinder r3 = this.b;
        IBinder r4 = null;
        if (r3 == null) goto L11;
        if (r3 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("sessionBinder");
        r3 = null;
    L10:
        r3.release();
    L11:
        IObricInteractorPresentationBridgeService r5 = this.c;
        if (r5 == null) goto L14;
        r4 = r5.asBinder();
    L14:
        a(r4, "service destroyed");
        super.onDestroy();
        r0.i("ObricMainVoiceGateS", "onDestroy complete");
        return;
    L5:
        r2 = false;
        goto L6
    }

    public ObricMainProcessVoiceInteractionGatewayService() {
        this.a = new Handler(Looper.getMainLooper());
        this.e = new ObricMainProcessVoiceInteractionGatewayService$serviceBinder$1(this);
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        this.b = new InteractionSessionProxyBinder(this);
        FLogger.a.i("ObricMainVoiceGateS", "onCreate, main-process voice interaction gateway ready, pid=" + Process.myPid());
    }

    public final void b(final Function0<Unit> r3) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        r3.invoke();
        return;
    L5:
        this.a.post(new c(r3));
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent r5) {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("onBind, action=");
        ComponentName r2 = null;
        if (r5 == null) goto L5;
        String r3 = r5.getAction();
    L6:
        r1.append(r3);
        r1.append(", component=");
        if (r5 == null) goto L9;
        r2 = r5.getComponent();
    L9:
        r1.append(r2);
        r1.append(", pid=");
        r1.append(Process.myPid());
        r0.i("ObricMainVoiceGateS", r1.toString());
        return this.e;
    L5:
        r3 = null;
        goto L6
    }

    @Override // android.app.Service
    public final boolean onUnbind(Intent r4) {
        FLogger.a.i("ObricMainVoiceGateS", "onUnbind, keep registered binders for reconnect");
        return super.onUnbind(r4);
    }

    public final void a(IBinder r8, String r9) {
        IObricInteractorPresentationBridgeService r0 = this.c;
        Object r3 = null;
        if (r0 != null) goto L9;
        FLogger r1 = FLogger.a;
        StringBuilder r4 = new StringBuilder("ignore presentation detach without current, expected=");
        if (r8 == null) goto L7;
        r3 = Integer.valueOf(r8.hashCode());
    L7:
        r4.append(r3);
        r4.append(", reason=");
        r4.append(r9);
        r1.i("ObricMainVoiceGateS", r4.toString());
        return;
    L9:
        if (r8 != null) goto L11;
    L18:
        FLogger r5 = FLogger.a;
        StringBuilder r6 = new StringBuilder("ignore stale presentation detach, expected=");
        if (r8 == null) goto L21;
        r3 = Integer.valueOf(r8.hashCode());
    L21:
        r6.append(r3);
        r6.append(", current=");
        r6.append(r0.asBinder().hashCode());
        r6.append(", reason=");
        r6.append(r9);
        r5.i("ObricMainVoiceGateS", r6.toString());
        return;
    L11:
        if (r0.asBinder() != r8) goto L18;
        com.obric.assistant.activation.presentation.runtime.service.a r10 = this.d;
        this.c = null;
        this.d = null;
        if (r10 == null) goto L16;
        r3 = Boolean.valueOf(r0.asBinder().unlinkToDeath(r10, 0));
    L16:
        ObricListeningMainProcessManager.a.getClass();
        Intrinsics.checkNotNullParameter(r0, "expected");
        ObricListeningMainProcessManager.k(new a0(r0));
        FLogger.a.i("ObricMainVoiceGateS", "interactor presentation bridge detached, binder=" + r0.asBinder().hashCode() + ", deathRecipientUnlinked=" + r3 + ", reason=" + r9);
    }
}
