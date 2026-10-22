package io.reactivex.internal.schedulers;

import com.lynx.tasm.ui.image.v;
import io.reactivex.disposables.Disposable;
import mt.y;

/* JADX INFO: loaded from: classes3.dex */
class SchedulerWhen$ImmediateAction extends SchedulerWhen$ScheduledAction {
    private final Runnable action;

    public SchedulerWhen$ImmediateAction(Runnable r5) {
        this.action = r5;
    }

    @Override // io.reactivex.internal.schedulers.SchedulerWhen$ScheduledAction
    public Disposable callActual(y r5, mt.b r10) {
        return r5.a(new v(10, this.action, r10));
    }
}
