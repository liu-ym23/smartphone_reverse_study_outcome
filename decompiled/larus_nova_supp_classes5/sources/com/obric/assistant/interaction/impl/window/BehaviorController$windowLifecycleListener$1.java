package com.obric.assistant.interaction.impl.window;

import com.obric.assistant.interaction.api.window.IBehavior;
import com.obric.assistant.spi.window.WindowOpenSource;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import wga.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016J\b\u0010\u000b\u001a\u00020\u0003H\u0016J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¨\u0006\u0010"}, d2 = {"com/obric/assistant/interaction/impl/window/BehaviorController$windowLifecycleListener$1", "Lcom/obric/assistant/spi/window/WindowLifecycleListener;", "onWindowPreOpenClear", "", "onWindowOpened", "source", "Lcom/obric/assistant/spi/window/WindowOpenSource;", "onWindowStashed", "onWindowPreOpened", "onWindowPreStashed", "onWindowDismissed", "onWindowPreDismissed", "onScreenRotationChanged", "previousRotation", "", "newRotation", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BehaviorController$windowLifecycleListener$1 implements b {
    public BehaviorController$windowLifecycleListener$1() {
    }

    @Override // wga.b
    public void onWindowDismissed() {
        Iterator r0 = BehaviorController.access$getBehaviorServices(BehaviorController.INSTANCE).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((IBehavior) r0.next()).onWindowDismiss();
        goto L4
    }

    @Override // wga.b
    public void onWindowPreDismissed() {
        Iterator r0 = BehaviorController.access$getBehaviorServices(BehaviorController.INSTANCE).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((IBehavior) r0.next()).onWindowPreDismiss();
        goto L4
    }

    @Override // wga.b
    public void onWindowPreOpenClear() {
        Iterator r0 = BehaviorController.access$getBehaviorServices(BehaviorController.INSTANCE).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((IBehavior) r0.next()).onWindowPreOpenClear();
        goto L4
    }

    @Override // wga.b
    public void onWindowPreStashed() {
        Iterator r0 = BehaviorController.access$getBehaviorServices(BehaviorController.INSTANCE).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((IBehavior) r0.next()).onWindowPreHide();
        goto L4
    }

    @Override // wga.b
    public void onWindowStashed() {
        Iterator r0 = BehaviorController.access$getBehaviorServices(BehaviorController.INSTANCE).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((IBehavior) r0.next()).onWindowHide();
        goto L4
    }

    @Override // wga.b
    public void onWindowOpened(WindowOpenSource r2) {
        Intrinsics.checkNotNullParameter(r2, "source");
        Iterator r3 = BehaviorController.access$getBehaviorServices(BehaviorController.INSTANCE).iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((IBehavior) r3.next()).onWindowShow();
        goto L4
    }

    @Override // wga.b
    public void onWindowPreOpened(WindowOpenSource r2) {
        Intrinsics.checkNotNullParameter(r2, "source");
        Iterator r3 = BehaviorController.access$getBehaviorServices(BehaviorController.INSTANCE).iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((IBehavior) r3.next()).onWindowPreShow();
        goto L4
    }

    @Override // wga.b
    public void onScreenRotationChanged(int r3, int r4) {
        Iterator r0 = BehaviorController.access$getBehaviorServices(BehaviorController.INSTANCE).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((IBehavior) r0.next()).onScreenRotationChanged(r3, r4);
        goto L4
    }
}
