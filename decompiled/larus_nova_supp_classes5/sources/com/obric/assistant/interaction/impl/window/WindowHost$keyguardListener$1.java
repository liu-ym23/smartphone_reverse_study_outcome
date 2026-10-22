package com.obric.assistant.interaction.impl.window;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.api.OnKeyguardLockStateChangedListener;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/assistant/interaction/impl/window/WindowHost$keyguardListener$1", "Lcom/obric/assistant/interaction/api/OnKeyguardLockStateChangedListener;", "onKeyguardLockStateChanged", "", "isKeyguardLocked", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WindowHost$keyguardListener$1 implements OnKeyguardLockStateChangedListener {
    public WindowHost$keyguardListener$1() {
    }

    public static /* synthetic */ Unit a(boolean r0) {
        return onKeyguardLockStateChanged$lambda$0(r0);
    }

    private static final Unit onKeyguardLockStateChanged$lambda$0(boolean r1) {
        WindowHost.access$updateWindowType(WindowHost.INSTANCE, r1);
        return Unit.INSTANCE;
    }

    public void onKeyguardLockStateChanged(boolean r4) {
        FLogger.a.i("WindowHost", "onKeyguardLockStateChanged: isKeyguardLocked=" + r4);
        WindowHost.access$getWindowOperationExecutor$p().execute("updateWindowType", new u1(r4));
    }
}
