package com.obric.assistant.interaction.impl.window.behaviors;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.api.IAssistantChatWindow;
import com.obric.assistant.interaction.api.IAssistantChatWindowKt;
import com.obric.assistant.interaction.api.window.IBehavior;
import kotlin.Metadata;
import t1a.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\b"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/behaviors/WindowMultimodalInputClearBehavior;", "Lcom/obric/assistant/interaction/api/window/IBehavior;", "<init>", "()V", "init", "", "onWindowPreOpenClear", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WindowMultimodalInputClearBehavior implements IBehavior {
    private static final Companion Companion = null;
    private static final String TAG = "WindowMultimodalInputClearBehavior";

    static {
        Companion = new Companion(null);
    }

    public WindowMultimodalInputClearBehavior() {
    }

    public void init() {
        FLogger.a.i(TAG, "init");
    }

    public void onWindowPreOpenClear() {
        FLogger.a.i(TAG, "onWindowPreOpenClear");
        IAssistantChatWindow r0 = IAssistantChatWindowKt.getAssistantChatWindow();
        if (r0 == null) goto L10;
        b r1 = r0.provideWindowVContext();
        if (r1 == null) goto L11;
        com.larus.bmhome.chat.component.bottom.multimodal.g r2 = r1.getAbility(com.larus.bmhome.chat.component.bottom.multimodal.g.class);
        if (r2 == null) goto L12;
        r2.cZ();
        return;
    L12:
        return;
    L11:
        return;
    }

    public void onAppBackground() {
        IBehavior.DefaultImpls.onAppBackground(this);
    }

    public void onAppForeground() {
        IBehavior.DefaultImpls.onAppForeground(this);
    }

    public void onWindowDismiss() {
        IBehavior.DefaultImpls.onWindowDismiss(this);
    }

    public void onWindowHide() {
        IBehavior.DefaultImpls.onWindowHide(this);
    }

    public void onWindowPreDismiss() {
        IBehavior.DefaultImpls.onWindowPreDismiss(this);
    }

    public void onWindowPreHide() {
        IBehavior.DefaultImpls.onWindowPreHide(this);
    }

    public void onWindowPreShow() {
        IBehavior.DefaultImpls.onWindowPreShow(this);
    }

    public void onWindowPreloaded() {
        IBehavior.DefaultImpls.onWindowPreloaded(this);
    }

    public void onWindowShow() {
        IBehavior.DefaultImpls.onWindowShow(this);
    }

    public void onScreenRotationChanged(int r1, int r2) {
        IBehavior.DefaultImpls.onScreenRotationChanged(this, r1, r2);
    }
}
