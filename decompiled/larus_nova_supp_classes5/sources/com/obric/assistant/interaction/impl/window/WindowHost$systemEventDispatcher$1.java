package com.obric.assistant.interaction.impl.window;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.api.window.animation.WindowAnimationType;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016¨\u0006\u0006"}, d2 = {"com/obric/assistant/interaction/impl/window/WindowHost$systemEventDispatcher$1", "Lcom/obric/assistant/interaction/impl/window/SystemEventListener;", "onHomeKeyOrRecent", "", "onScreenOff", "onAppBackground", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WindowHost$systemEventDispatcher$1 implements SystemEventListener {
    public WindowHost$systemEventDispatcher$1() {
    }

    public void onAppBackground() {
        FLogger.a.i("WindowHost", "onAppBackground");
    }

    public void onHomeKeyOrRecent() {
        FLogger.a.i("WindowHost", "onHomeOrRecent");
        WindowHost.onSystemHide$default(WindowHost.INSTANCE, "onHomeKeyOrRecent", null, 2, null);
    }

    public void onScreenOff() {
        FLogger.a.i("WindowHost", "onScreenOff");
        WindowHost.access$onSystemHide(WindowHost.INSTANCE, "onScreenOff", WindowAnimationType.None);
    }
}
