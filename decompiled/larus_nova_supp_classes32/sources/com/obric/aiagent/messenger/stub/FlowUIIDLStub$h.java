package com.obric.aiagent.messenger.stub;

import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.interaction.api.IAssistantInteractionServiceKt;
import com.obric.assistant.interaction.api.service.IAuthenticationOnLockScreenService;
import com.obric.assistant.interaction.base.feedback.VibratorSmtFeedbackEffect;
import com.obric.assistant.interaction.base.util.SoundEffectHelper;
import com.obric.assistant.interaction.base.util.SystemHiddenApiHelper;
import kotlin.Result;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class FlowUIIDLStub$h implements oga.a {
    public final /* synthetic */ kotlinx.coroutines.i<Boolean> a;
    public final /* synthetic */ String b;

    public final void onDismissFailed() {
        if (this.a.isCompleted() == true) goto L9;
        FLogger.a.i("FlowUIIDLStub", "onDismissFailed");
        kotlinx.coroutines.i<Boolean> r0 = this.a;
        Result.Companion r1 = Result.Companion;
        r0.resumeWith(Result.constructor-impl(Boolean.FALSE));
        IAuthenticationOnLockScreenService r2 = IAssistantInteractionServiceKt.getAuthenOnLockScreenService();
        String r3 = this.b;
        if (r3 != null) goto L7;
        r3 = NameKeys.UnloadStrategy_No_Strategy;
    L7:
        r2.stop(r3);
        SoundEffectHelper.INSTANCE.playWarning();
        SystemHiddenApiHelper.INSTANCE.performVibratorSmtFeedback(VibratorSmtFeedbackEffect.EFFECT_WARNING);
        return;
    }

    public final void onDismissSucceeded() {
        if (this.a.isCompleted() == true) goto L9;
        FLogger.a.i("FlowUIIDLStub", "onDismissSucceeded");
        kotlinx.coroutines.i<Boolean> r0 = this.a;
        Result.Companion r1 = Result.Companion;
        r0.resumeWith(Result.constructor-impl(Boolean.TRUE));
        IAuthenticationOnLockScreenService r2 = IAssistantInteractionServiceKt.getAuthenOnLockScreenService();
        String r3 = this.b;
        if (r3 != null) goto L7;
        r3 = NameKeys.UnloadStrategy_No_Strategy;
    L7:
        r2.stop(r3);
        return;
    }

    public FlowUIIDLStub$h(kotlinx.coroutines.j r1, String r2) {
        this.a = r1;
        this.b = r2;
    }
}
