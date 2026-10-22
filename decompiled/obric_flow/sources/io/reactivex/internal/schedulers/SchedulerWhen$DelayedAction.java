package io.reactivex.internal.schedulers;

import com.lynx.tasm.ui.image.v;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;
import mt.y;

/* JADX INFO: loaded from: classes3.dex */
class SchedulerWhen$DelayedAction extends SchedulerWhen$ScheduledAction {
    private final Runnable action;
    private final long delayTime;
    private final TimeUnit unit;

    public SchedulerWhen$DelayedAction(Runnable r5, long r10, TimeUnit r11) {
        this.action = r5;
        this.delayTime = r10;
        this.unit = r11;
    }

    @Override // io.reactivex.internal.schedulers.SchedulerWhen$ScheduledAction
    public Disposable callActual(y r5, mt.b r10) {
        return r5.b(new v(10, this.action, r10), this.delayTime, this.unit);
    }
}
