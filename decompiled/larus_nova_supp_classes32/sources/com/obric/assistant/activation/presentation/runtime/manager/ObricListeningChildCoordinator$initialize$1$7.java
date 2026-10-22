package com.obric.assistant.activation.presentation.runtime.manager;

import com.larus.utils.logger.FLogger;
import com.larus.voice_setting.voice.base.VoiceDisplayScene;
import com.obric.aiagent.sharedstate.StateKey;
import com.obric.assistant.activation.presentation.runtime.precheck.ObricChildListeningPrecheck;
import com.obric.assistant.state.ISharedStateService;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class ObricListeningChildCoordinator$initialize$1$7 extends FunctionReferenceImpl implements Function1<ActivationSource, ObricChildListeningPrecheck.b> {
    public ObricListeningChildCoordinator$initialize$1$7(Object r8) {
        super(1, r8, ObricChildListeningPrecheck.class, "check", "check(Lcom/obric/assistant/activation/presentation/runtime/manager/ActivationSource;)Lcom/obric/assistant/activation/presentation/runtime/precheck/ObricChildListeningPrecheck$Result;", 0);
    }

    public final ObricChildListeningPrecheck.b invoke(ActivationSource r9) {
        Intrinsics.checkNotNullParameter(r9, "p0");
        ObricChildListeningPrecheck r0 = (ObricChildListeningPrecheck) ((CallableReference) this).receiver;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r9, "source");
        fba.b r1 = (fba.b) r0.a.invoke();
        ISharedStateService.a.getClass();
        ISharedStateService r2 = ISharedStateService.a.a();
        boolean r3 = false;
        if (r2 == null) goto L5;
        boolean r4 = Intrinsics.areEqual(r2.e(StateKey.KEY_DOUBAO_LOGIN_STATE), Boolean.TRUE);
    L6:
        sna.h r5 = sna.h.a;
        boolean r6 = sna.h.a().getBoolean("user_guide_completed", false);
        boolean r7 = sna.h.a().getBoolean("locked_screen_use_enabled", false);
        boolean r8 = sna.h.a().getBoolean("window_mode_enabled", false);
        Intrinsics.checkNotNullParameter(r1, "facts");
        if (((Boolean) r1.g.getValue()).booleanValue() == true) goto L9;
        ObricChildListeningPrecheck.b r10 = com.obric.assistant.activation.presentation.runtime.precheck.a.a(ObricChildListeningPrecheck.Reason.MIC_PERMISSION_MISSING);
    L48:
        FLogger r11 = FLogger.a;
        StringBuilder r12 = new StringBuilder("child_precheck_finished: source=");
        r12.append(r9);
        r12.append(" result=");
        r12.append(r10.a);
        r12.append(" reason=");
        r12.append(r10.b);
        r12.append(" evaluatedFacts=");
        StringBuilder r13 = new StringBuilder();
        fba.b.a(r13, "recordAudioPermission", r1.g);
        fba.b.a(r13, "screenInteractive", r1.a);
        fba.b.a(r13, "aiKeyEnabledWhenScreenOff", r1.b);
        fba.b.a(r13, "landscape", r1.c);
        fba.b.a(r13, "audioMode", r1.f);
        fba.b.a(r13, "micInUse", r1.h);
        fba.b.a(r13, "networkAvailable", r1.i);
        fba.b.a(r13, "keyguardLocked", r1.d);
        fba.b.a(r13, "deviceLocked", r1.e);
        fba.b.a(r13, "canDrawOverlays", r1.j);
        String r14 = r13.toString();
        if (r14.length() != 0) goto L51;
        r3 = true;
    L51:
        if (r3 == false) goto L53;
        r14 = VoiceDisplayScene.NONE;
    L53:
        r12.append(r14);
        r11.i("ChildListeningPrecheck", r12.toString());
        return r10;
    L9:
        if (r4 == true) goto L11;
        r10 = com.obric.assistant.activation.presentation.runtime.precheck.a.a(ObricChildListeningPrecheck.Reason.NOT_LOGGED_IN);
        goto L48
    L11:
        if (r6 == true) goto L14;
        r10 = com.obric.assistant.activation.presentation.runtime.precheck.a.a(ObricChildListeningPrecheck.Reason.USER_GUIDE_NOT_COMPLETED);
        goto L48
    L14:
        if (((Boolean) r1.a.getValue()).booleanValue() == true) goto L19;
        if (((Boolean) r1.b.getValue()).booleanValue() == true) goto L19;
        r10 = com.obric.assistant.activation.presentation.runtime.precheck.a.a(ObricChildListeningPrecheck.Reason.SCREEN_OFF_DISABLED);
    L19:
        if (((Boolean) r1.c.getValue()).booleanValue() == false) goto L23;
        if (r8 == true) goto L23;
        r10 = com.obric.assistant.activation.presentation.runtime.precheck.a.a(ObricChildListeningPrecheck.Reason.SCREEN_LANDSCAPE);
    L23:
        if (((Number) r1.f.getValue()).intValue() != 2) goto L25;
    L47:
        r10 = com.obric.assistant.activation.presentation.runtime.precheck.a.a(ObricChildListeningPrecheck.Reason.IN_CALL);
        goto L48
    L25:
        if (((Number) r1.f.getValue()).intValue() == 1) goto L47;
        if (((Number) r1.f.getValue()).intValue() == 3) goto L47;
        if (((Boolean) r1.h.getValue()).booleanValue() == false) goto L33;
        r10 = com.obric.assistant.activation.presentation.runtime.precheck.a.a(ObricChildListeningPrecheck.Reason.MIC_IN_USE);
        goto L48
    L33:
        if (((Boolean) r1.i.getValue()).booleanValue() == true) goto L36;
        r10 = com.obric.assistant.activation.presentation.runtime.precheck.a.a(ObricChildListeningPrecheck.Reason.NETWORK_UNAVAILABLE);
        goto L48
    L36:
        if (((Boolean) r1.d.getValue()).booleanValue() == false) goto L42;
        if (((Boolean) r1.e.getValue()).booleanValue() == false) goto L42;
        if (r7 == true) goto L42;
        r10 = com.obric.assistant.activation.presentation.runtime.precheck.a.a(ObricChildListeningPrecheck.Reason.KEYGUARD_BLOCKED);
    L42:
        if (((Boolean) r1.d.getValue()).booleanValue() == false) goto L44;
    L46:
        r10 = ObricChildListeningPrecheck.b.d;
        goto L48
    L44:
        if (((Boolean) r1.j.getValue()).booleanValue() == true) goto L46;
        r10 = com.obric.assistant.activation.presentation.runtime.precheck.a.a(ObricChildListeningPrecheck.Reason.OVERLAY_PERMISSION_MISSING);
        goto L48
    L5:
        r4 = false;
        goto L6
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((ActivationSource) r1);
    }
}
