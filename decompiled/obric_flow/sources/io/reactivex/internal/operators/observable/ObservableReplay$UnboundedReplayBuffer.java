package io.reactivex.internal.operators.observable;

import io.reactivex.internal.util.NotificationLite;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
final class ObservableReplay$UnboundedReplayBuffer<T> extends ArrayList<Object> implements f3 {
    private static final long serialVersionUID = 7063189396499112664L;
    volatile int size;

    public ObservableReplay$UnboundedReplayBuffer(int r5) {
        super(r5);
    }

    @Override // io.reactivex.internal.operators.observable.f3
    public void complete() {
        add(NotificationLite.complete());
        this.size++;
    }

    @Override // io.reactivex.internal.operators.observable.f3
    public void error(Throwable r5) {
        add(NotificationLite.error(r5));
        this.size++;
    }

    @Override // io.reactivex.internal.operators.observable.f3
    public void next(T r5) {
        add(NotificationLite.next(r5));
        this.size++;
    }

    @Override // io.reactivex.internal.operators.observable.f3
    public void replay(ObservableReplay$InnerDisposable<T> r10) {
        if (r10.getAndIncrement() == 0) goto L5;
        return;
    L5:
        mt.u r5 = r10.child;
        int r11 = 1;
    L7:
        if (r10.isDisposed() == true) goto L8;
        int r12 = this.size;
        Integer r13 = (Integer) r10.index();
        if (r13 == null) goto L12;
        int r14 = r13.intValue();
    L13:
        if (r14 >= r12) goto L21;
        if (NotificationLite.accept(get(r14), r5) == true) goto L16;
        if (r10.isDisposed() == true) goto L19;
        r14 = r14 + 1;
        goto L13
    L19:
        return;
    L16:
        return;
    L21:
        r10.index = Integer.valueOf(r14);
        r11 = r10.addAndGet(-r11);
        if (r11 != 0) goto L7;
        return;
    L12:
        r14 = 0;
        goto L13
    }
}
