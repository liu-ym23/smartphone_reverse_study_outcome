package com.obric.assistant.voice;

import android.os.Build;
import android.service.voice.VoiceInteractionSession;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.utils.DefaultAssistantStatus;
import com.obric.assistant.activation.presentation.runtime.manager.ObricListeningMainProcessManager;
import com.obric.assistant.activation.presentation.runtime.manager.f0;
import com.obric.assistant.activation.presentation.runtime.manager.g0;
import com.obric.assistant.activation.presentation.runtime.manager.h0;
import com.obric.assistant.activation.presentation.runtime.manager.m0;
import com.obric.assistant.activation.presentation.runtime.manager.n0;
import com.obric.assistant.activation.presentation.runtime.manager.q0;
import com.obric.assistant.interaction.api.service.IInteractionStateService;
import com.obric.assistant.ipc.HostStateSyncManager;
import com.obric.assistant.ipc.IpcMessenger;
import com.obric.assistant.session.AiIslandVoiceInteractionSession;
import com.obric.assistant.session.model.IAiKeyOperation;
import com.obric.assistant.session.model.IDoraOperation;
import com.obric.assistant.session.model.ISessionMaintaining;
import com.obric.assistant.session.model.IVoiceWakeupOperation;
import com.obric.assistant.system.ITaskStackService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sha.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 .2\u00020\u0001:\u0002-.B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0016J\n\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\r\u001a\u00020\tH\u0016J\b\u0010\u000e\u001a\u00020\tH\u0017J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0010H\u0016J\u001a\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0017\u001a\u00020\u0010H\u0016J\b\u0010\u0018\u001a\u00020\u0010H\u0016J\u000f\u0010\u0019\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0002\u0010\u001aJ\b\u0010\u001b\u001a\u00020\u0010H\u0016J\b\u0010\u001c\u001a\u00020\tH\u0016J\b\u0010\u001d\u001a\u00020\u0010H\u0016J\b\u0010\u001e\u001a\u00020\tH\u0016J\n\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0010\u0010!\u001a\u00020\t2\u0006\u0010\"\u001a\u00020#H\u0016J\u0010\u0010$\u001a\u00020\t2\u0006\u0010\"\u001a\u00020#H\u0016J\b\u0010%\u001a\u00020&H\u0016J\u0010\u0010'\u001a\u00020\t2\u0006\u0010\"\u001a\u00020(H\u0016J\u0010\u0010)\u001a\u00020\t2\u0006\u0010\"\u001a\u00020(H\u0016J\u0010\u0010*\u001a\u00020\t2\u0006\u0010+\u001a\u00020\u0015H\u0016J\u0010\u0010,\u001a\u00020\t2\u0006\u0010+\u001a\u00020\u0015H\u0016R\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/obric/assistant/voice/ObricVoiceServiceImpl;", "Lcom/obric/assistant/voice/IObricVoiceService;", "<init>", "()V", "TAG", "", "kotlin.jvm.PlatformType", "AI_KEY_FINGER_PRINT_ENROLLING_CLASS", "wakeupAssistant", "", "requestFrom", "getVoiceInteractionSession", "Landroid/service/voice/VoiceInteractionSession;", "initSessionEnvironment", "pullUpAssistOnce", "isCurrentSessionFromBreathWakeup", "", "setEnrollingStatus", "status", "trackEnrollData", "trackerId", "", "metaData", "isAiKeyPressing", "isDoraPressing", "getCurrentWakeupID", "()Ljava/lang/Integer;", "isCurrentSessionFromWakeup", "registerTaskStackListener", "isDefaultAssistant", "onUserSpeaking", "getCurrentListeningPresentation", "Lcom/obric/assistant/voice/ObricListeningPresentation;", "registerListeningPresentationListener", "listener", "Lcom/obric/assistant/activation/presentation/contract/ObricListeningPresentationListener;", "unregisterListeningPresentationListener", "getChildListeningSurfaceSnapshot", "Lcom/obric/assistant/activation/presentation/contract/surface/ObricChildListeningSurfaceSnapshot;", "registerChildListeningSurfaceListener", "Lcom/obric/assistant/activation/presentation/contract/surface/ObricChildListeningSurfaceListener;", "unregisterChildListeningSurfaceListener", "acknowledgeChildListeningSurfaceLinked", "generation", "releaseChildListeningSurfaceLink", "ListeningPresentation", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricVoiceServiceImpl implements IObricVoiceService {
    public static volatile VoiceInteractionSession d;
    public final String b;
    public final String c;

    public static final class a {
    }

    static {
    }

    @Override // com.obric.assistant.voice.IObricVoiceService
    public final boolean a() {
        int r0 = com.obric.aiagent.assistant.utils.a.a;
        if (com.obric.aiagent.assistant.utils.a.a(AppHost.a.getApplication()) != DefaultAssistantStatus.IsDefaultAssistant) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.assistant.voice.IObricVoiceService
    public final boolean d() {
        AiIslandVoiceInteractionSession r0 = d;
        String r2 = null;
        if ((r0 instanceof AiIslandVoiceInteractionSession) == false) goto L5;
        AiIslandVoiceInteractionSession r1 = r0;
    L6:
        boolean r4 = false;
        if (Build.VERSION.SDK_INT < 33) goto L22;
        if (r1 == null) goto L22;
        ISessionMaintaining r3 = bga.j.b();
        if (r3 == null) goto L12;
        String r5 = r3.w();
    L14:
        if (Intrinsics.areEqual(r5, IInteractionStateService.WAKEUP_SOURCE_VOICE) == false) goto L21;
        ISessionMaintaining r6 = bga.j.b();
        if (r6 == null) goto L19;
        r2 = r6.o();
    L19:
        if (Intrinsics.areEqual(r2, "BREATH") == false) goto L21;
        r4 = true;
    L21:
        FLogger.a.i("AiIsland-SessionUtils", "isCurrentSessionFromBreathWakeup ? " + r4);
        goto L22
    L12:
        r5 = null;
    L22:
        return r4;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.obric.assistant.voice.IObricVoiceService
    public final b f() {
        b r0 = b.a;
        if (b.a() == true) goto L7;
        return null;
    L7:
        return r0;
    }

    @Override // com.obric.assistant.voice.IObricVoiceService
    public final void j() {
        IpcMessenger.a.getClass();
        IpcMessenger.d();
        xna.a.c(new e(), new f(), new g(), new h(), new i());
        ITaskStackService r0 = (ITaskStackService) ServiceManager.get().getService(ITaskStackService.class);
        if (r0 == null) goto L5;
        r0.d(new j(this));
    L5:
        HostStateSyncManager.a.getClass();
        HostStateSyncManager.c("session_environment_ready");
    }

    @Override // com.obric.assistant.voice.IObricVoiceService
    public final VoiceInteractionSession m() {
        VoiceInteractionSession r0 = d;
        if (r0 != null) goto L6;
        FLogger.a.i(this.b, "getVoiceInteractionSession session = null");
        return null;
    L6:
        return r0;
    }

    @Override // com.obric.assistant.voice.IObricVoiceService
    public final boolean n() {
        AiIslandVoiceInteractionSession r0 = d;
        String r2 = null;
        if ((r0 instanceof AiIslandVoiceInteractionSession) == false) goto L5;
        AiIslandVoiceInteractionSession r1 = r0;
    L7:
        if (Build.VERSION.SDK_INT < 33) goto L14;
        if (r1 == null) goto L15;
        ISessionMaintaining r3 = bga.j.b();
        if (r3 == null) goto L12;
        r2 = r3.w();
    L12:
        boolean r4 = Intrinsics.areEqual(r2, IInteractionStateService.WAKEUP_SOURCE_VOICE);
        FLogger.a.i("AiIsland-SessionUtils", "isCurrentSessionFromAnyWakeup ? " + r4);
        return r4;
    L15:
        return false;
    L14:
        return false;
    L5:
        r1 = null;
        goto L7
    }

    @Override // com.obric.assistant.voice.IObricVoiceService
    public final aba.b p() {
        int r0 = b.a;
        ObricListeningMainProcessManager.a.getClass();
        return ObricListeningMainProcessManager.d();
    }

    @Override // com.obric.assistant.voice.IObricVoiceService
    public final Integer q() {
        IVoiceWakeupOperation r0 = (IVoiceWakeupOperation) ServiceManager.get().getService(IVoiceWakeupOperation.class);
        if (r0 != null) goto L7;
        return null;
    L7:
        return Integer.valueOf(r0.b());
    }

    public ObricVoiceServiceImpl() {
        this.b = "ObricVoiceServiceImpl";
        this.c = "com.android.settings.fingerprint.AIPoweredFingerprintEnrollingActivity";
    }

    @Override // com.obric.assistant.voice.IObricVoiceService
    public final boolean b() {
        IDoraOperation r0 = bga.f.a();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.b();
    }

    @Override // com.obric.assistant.voice.IObricVoiceService
    public final boolean isAiKeyPressing() {
        IAiKeyOperation r0 = bga.b.a();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isAiKeyPressing();
    }

    @Override // com.obric.assistant.voice.IObricVoiceService
    public final void c(int r2) {
        int r0 = b.a;
        ObricListeningMainProcessManager.a.getClass();
        ObricListeningMainProcessManager.k(new m0(r2));
    }

    @Override // com.obric.assistant.voice.IObricVoiceService
    public final void g(com.obric.assistant.view.listening.h r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        int r1 = b.a;
        Intrinsics.checkNotNullParameter(r3, "listener");
        ObricListeningMainProcessManager.a.getClass();
        Intrinsics.checkNotNullParameter(r3, "listener");
        ObricListeningMainProcessManager.k(new q0(r3));
    }

    @Override // com.obric.assistant.voice.IObricVoiceService
    public final void h(com.obric.assistant.view.listening.h r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        int r1 = b.a;
        Intrinsics.checkNotNullParameter(r3, "listener");
        ObricListeningMainProcessManager.a.getClass();
        Intrinsics.checkNotNullParameter(r3, "listener");
        ObricListeningMainProcessManager.k(new h0(r3));
    }

    @Override // com.obric.assistant.voice.IObricVoiceService
    public final void i(boolean r2) {
        IpcMessenger.a.getClass();
        n.a = r2;
        IpcMessenger.d.setValue(Boolean.valueOf(r2));
    }

    @Override // com.obric.assistant.voice.IObricVoiceService
    public final void k(aba.a r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        int r1 = b.a;
        Intrinsics.checkNotNullParameter(r3, "listener");
        ObricListeningMainProcessManager.a.getClass();
        Intrinsics.checkNotNullParameter(r3, "listener");
        ObricListeningMainProcessManager.k(new g0(r3));
    }

    @Override // com.obric.assistant.voice.IObricVoiceService
    public final void l(aba.a r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        int r1 = b.a;
        Intrinsics.checkNotNullParameter(r3, "listener");
        ObricListeningMainProcessManager.a.getClass();
        Intrinsics.checkNotNullParameter(r3, "listener");
        ObricListeningMainProcessManager.k(new f0(r3));
    }

    @Override // com.obric.assistant.voice.IObricVoiceService
    public final void o(int r2) {
        int r0 = b.a;
        ObricListeningMainProcessManager.a.getClass();
        ObricListeningMainProcessManager.k(new n0(r2));
    }

    @Override // com.obric.assistant.voice.IObricVoiceService
    public final void e(int r2, String r3) {
        IpcMessenger.a.getClass();
        IpcMessenger.c(r2, r3);
    }
}
