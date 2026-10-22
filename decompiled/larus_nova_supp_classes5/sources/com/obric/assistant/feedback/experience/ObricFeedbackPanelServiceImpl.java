package com.obric.assistant.feedback.experience;

import com.larus.account.base.api.ILoginService;
import com.obric.assistant.settings.experience.ObricUserExperiencePlanManager;
import com.obric.assistant.spi.feedback.IObricFeedbackPanelService;
import kotlin.Metadata;
import kotlin.Unit;
import nga.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/obric/assistant/feedback/experience/ObricFeedbackPanelServiceImpl;", "Lcom/obric/assistant/spi/feedback/IObricFeedbackPanelService;", "<init>", "()V", "initExperiencePlan", "", "createExperiencePlanProvider", "Lcom/obric/assistant/spi/feedback/IObricExperiencePlanFeedbackProvider;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricFeedbackPanelServiceImpl implements IObricFeedbackPanelService {
    public ObricFeedbackPanelServiceImpl() {
    }

    public final void a() {
        ObricUserExperiencePlanManager r0 = ObricUserExperiencePlanManager.a;
        if (ObricUserExperiencePlanManager.f == true) goto L22;
        monitor-enter(r0);
    L16:
        th = move-exception;
        throw th;
    L7:
        if (ObricUserExperiencePlanManager.f == false) goto L10;
        monitor-exit(r0);
        return;
    L10:
        ILoginService.Companion r1 = ILoginService.a;     // Catch: Throwable -> L16
        r1.f(ObricUserExperiencePlanManager.g, Boolean.FALSE);     // Catch: Throwable -> L16
        ObricUserExperiencePlanManager.f = true;     // Catch: Throwable -> L16
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L16
        monitor-exit(r0);
        if (r1.getAccountInfo().a == false) goto L21;
        ObricUserExperiencePlanManager.g();
        return;
    L21:
        return;
    }

    public final a b() {
        return new ObricExperiencePlanFeedbackProvider();
    }
}
