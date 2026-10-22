package com.obric.assistant.interaction.impl.window;

import com.obric.assistant.interaction.api.window.IBehavior;
import f09.a;
import java.util.Iterator;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016¨\u0006\u0006"}, d2 = {"com/obric/assistant/interaction/impl/window/BehaviorController$backgroundListener$1", "Lcom/larus/common/apphost/lifecycle/ActivityStackManager$OnAppBackGroundListener;", "onAppBackground", "", "onAppForeground", "onAllActivityDestroyed", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BehaviorController$backgroundListener$1 implements a.b {
    public BehaviorController$backgroundListener$1() {
    }

    public void onAllActivityDestroyed() {
    }

    public void onAppBackground() {
        Iterator r0 = BehaviorController.access$getBehaviorServices(BehaviorController.INSTANCE).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((IBehavior) r0.next()).onAppBackground();
        goto L4
    }

    public void onAppForeground() {
        Iterator r0 = BehaviorController.access$getBehaviorServices(BehaviorController.INSTANCE).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((IBehavior) r0.next()).onAppForeground();
        goto L4
    }
}
