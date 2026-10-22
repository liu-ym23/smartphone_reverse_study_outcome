package com.obric.assistant.interaction.impl.window.behaviors;

import com.obric.assistant.interaction.api.IKeyguardStateKt;
import com.obric.assistant.interaction.api.window.IBehavior;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/behaviors/RemoveTopChatActivityBehavior;", "Lcom/obric/assistant/interaction/api/window/IBehavior;", "<init>", "()V", "init", "", "onWindowPreShow", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RemoveTopChatActivityBehavior implements IBehavior {
    public RemoveTopChatActivityBehavior() {
    }

    public void init() {
    }

    public void onWindowPreShow() {
        if (IKeyguardStateKt.getKeyguardState().isKeyguardLocked() == true) goto L5;
        return;
    L5:
        LockedTopChatActivityCleaner.INSTANCE.removeIfNeeded("windowPreShow", true);
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

    public void onWindowPreOpenClear() {
        IBehavior.DefaultImpls.onWindowPreOpenClear(this);
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
