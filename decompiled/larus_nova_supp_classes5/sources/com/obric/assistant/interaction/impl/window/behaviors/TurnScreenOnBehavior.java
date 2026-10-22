package com.obric.assistant.interaction.impl.window.behaviors;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.common.utils.a0;
import com.obric.assistant.interaction.api.window.IBehavior;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\b"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/behaviors/TurnScreenOnBehavior;", "Lcom/obric/assistant/interaction/api/window/IBehavior;", "<init>", "()V", "init", "", "onWindowPreShow", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TurnScreenOnBehavior implements IBehavior {
    public static final Companion Companion = null;
    private static final String TAG = "TurnScreenOnBehavior";

    static {
        Companion = new Companion(null);
    }

    public TurnScreenOnBehavior() {
    }

    public void init() {
    }

    public void onWindowPreShow() {
        IBehavior.DefaultImpls.onWindowPreShow(this);
        if (a0.a() == true) goto L6;
        FLogger.a.i(TAG, "turn screen on");
        a0.b();
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
