package com.obric.assistant.special_input;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.api.IAssistantChatWindow;
import com.obric.assistant.interaction.api.IAssistantChatWindowKt;
import com.obric.assistant.interaction.api.window.IBehavior;
import kotlin.Metadata;
import kotlin.jvm.internal.Reflection;
import laa.d;
import t1a.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016¨\u0006\t"}, d2 = {"Lcom/obric/assistant/special_input/SpecialInputBehavior;", "Lcom/obric/assistant/interaction/api/window/IBehavior;", "<init>", "()V", "init", "", "onWindowShow", "onWindowHide", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SpecialInputBehavior implements IBehavior {
    static {
    }

    public SpecialInputBehavior() {
    }

    public final void init() {
        FLogger.a.i("SpecialInputBehavior", "init");
    }

    public final void onWindowHide() {
        FLogger.a.i("SpecialInputBehavior", "onWindowHide");
        IAssistantChatWindow r0 = IAssistantChatWindowKt.getAssistantChatWindow();
        if (r0 == null) goto L10;
        b r1 = r0.provideWindowVContext();
        if (r1 == null) goto L11;
        d r2 = r1.o(Reflection.getOrCreateKotlinClass(d.class));
        if (r2 == null) goto L12;
        r2.tV();
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void onWindowShow() {
        FLogger.a.i("SpecialInputBehavior", "onWindowShow");
    }

    public final void onAppBackground() {
        IBehavior.DefaultImpls.onAppBackground(this);
    }

    public final void onAppForeground() {
        IBehavior.DefaultImpls.onAppForeground(this);
    }

    public final void onWindowDismiss() {
        IBehavior.DefaultImpls.onWindowDismiss(this);
    }

    public final void onWindowPreDismiss() {
        IBehavior.DefaultImpls.onWindowPreDismiss(this);
    }

    public final void onWindowPreHide() {
        IBehavior.DefaultImpls.onWindowPreHide(this);
    }

    public final void onWindowPreOpenClear() {
        IBehavior.DefaultImpls.onWindowPreOpenClear(this);
    }

    public final void onWindowPreShow() {
        IBehavior.DefaultImpls.onWindowPreShow(this);
    }

    public final void onWindowPreloaded() {
        IBehavior.DefaultImpls.onWindowPreloaded(this);
    }

    public final void onScreenRotationChanged(int r1, int r2) {
        IBehavior.DefaultImpls.onScreenRotationChanged(this, r1, r2);
    }
}
