package com.obric.assistant.feedback;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.activation.presentation.runtime.manager.ObricListeningMainProcessManager;
import com.obric.assistant.interaction.base.feedback.VibratorSmtFeedbackEffect;
import com.obric.assistant.interaction.base.util.SoundEffectHelper;
import com.obric.assistant.interaction.base.util.SystemHiddenApiHelper;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a() {
        int r0 = sha.b.a;
        ObricListeningMainProcessManager.a.getClass();
        ObricListeningMainProcessManager.c r1 = (ObricListeningMainProcessManager.c) ObricListeningMainProcessManager.t.get();
        if (r1 == null) goto L11;
        if (r1.b == true) goto L7;
    L12:
        return false;
    L7:
        if (r1.c.isValid() == false) goto L12;
        return r1.c.f;
    L11:
        if (ObricListeningMainProcessManager.f == false) goto L12;
        return ObricListeningMainProcessManager.g.f;
    }

    public static void b(boolean r2) {
        if (a() == false) goto L6;
        FLogger.a.i("ActivationFeedbackDispatch", "skip main start-listening feedback: reason=child_already_played");
        return;
    L6:
        SystemHiddenApiHelper.INSTANCE.performVibratorSmtFeedback(VibratorSmtFeedbackEffect.EFFECT_LONG_PRESS);
        if (r2 == false) goto L10;
        SoundEffectHelper.INSTANCE.playListening();
        return;
    }
}
