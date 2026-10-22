package com.obric.assistant.voice.presentation;

import com.obric.assistant.activation.presentation.runtime.manager.ObricListeningMainProcessManager;
import com.obric.assistant.activation.presentation.runtime.manager.w0;
import com.obric.assistant.interaction.api.window.IBehavior;
import kotlin.Metadata;
import sha.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\u0005H\u0002¨\u0006\u000b"}, d2 = {"Lcom/obric/assistant/voice/presentation/ListeningPresentationWindowBehavior;", "Lcom/obric/assistant/interaction/api/window/IBehavior;", "<init>", "()V", "init", "", "onWindowPreHide", "onWindowPreDismiss", "onWindowHide", "onWindowDismiss", "finishChildPresentation", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ListeningPresentationWindowBehavior implements IBehavior {
    public ListeningPresentationWindowBehavior() {
    }

    public final void init() {
    }

    public final void onWindowDismiss() {
        int r0 = b.a;
        ObricListeningMainProcessManager.a.getClass();
        ObricListeningMainProcessManager.k(new w0());
    }

    public final void onWindowHide() {
        int r0 = b.a;
        ObricListeningMainProcessManager.a.getClass();
        ObricListeningMainProcessManager.k(new w0());
    }

    public final void onWindowPreDismiss() {
        int r0 = b.a;
        ObricListeningMainProcessManager.a.getClass();
        ObricListeningMainProcessManager.k(new w0());
    }

    public final void onWindowPreHide() {
        int r0 = b.a;
        ObricListeningMainProcessManager.a.getClass();
        ObricListeningMainProcessManager.k(new w0());
    }

    public final void onAppBackground() {
        IBehavior.DefaultImpls.onAppBackground(this);
    }

    public final void onAppForeground() {
        IBehavior.DefaultImpls.onAppForeground(this);
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

    public final void onWindowShow() {
        IBehavior.DefaultImpls.onWindowShow(this);
    }

    public final void onScreenRotationChanged(int r1, int r2) {
        IBehavior.DefaultImpls.onScreenRotationChanged(this, r1, r2);
    }
}
