package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.util.NotificationLite;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
final class FlowableReplay$UnboundedReplayBuffer<T> extends ArrayList<Object> implements i<T> {
    private static final long serialVersionUID = 7063189396499112664L;
    volatile int size;

    FlowableReplay$UnboundedReplayBuffer(int r10) {
        super(r10);
    }

    @Override // io.reactivex.internal.operators.flowable.i
    public void complete() {
        add(NotificationLite.complete());
        this.size++;
    }

    @Override // io.reactivex.internal.operators.flowable.i
    public void error(Throwable r10) {
        add(NotificationLite.error(r10));
        this.size++;
    }

    @Override // io.reactivex.internal.operators.flowable.i
    public void next(T r10) {
        add(NotificationLite.next(r10));
        this.size++;
    }

    @Override // io.reactivex.internal.operators.flowable.i
    public void replay(FlowableReplay$InnerSubscription<T> r15) {
        monitor-enter(r15);
    L54:
        th = move-exception;
        throw th;
    L4:
        if (r15.emitting == false) goto L8;
        r15.missed = true;     // Catch: Throwable -> L54
        monitor-exit(r15);     // Catch: Throwable -> L54
        return;
    L8:
        r15.emitting = true;     // Catch: Throwable -> L54
        monitor-exit(r15);     // Catch: Throwable -> L54
        tc.c<? super T> r10 = r15.child;
    L12:
        if (r15.isDisposed() == true) goto L13;
        int r11 = this.size;
        Integer r12 = (Integer) r15.index();
        if (r12 == null) goto L17;
        int r13 = r12.intValue();
    L18:
        long r14 = r15.get();
        long r16 = r14;
        long r17 = 0;
    L20:
        if (r16 == 0) goto L38;
        if (r13 >= r11) goto L38;
        Object r18 = get(r13);
        if (NotificationLite.accept(r18, r10) == true) goto L25;
        if (r15.isDisposed() == true) goto L28;
        r13 = r13 + 1;
        r16 = r16 - 1;
        r17 = r17 + 1;
        goto L20
    L28:
        return;
    L25:
        return;
    L30:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        r15.dispose();
        if (NotificationLite.isError(r18) == false) goto L34;
        return;
    L34:
        if (NotificationLite.isComplete(r18) == true) goto L69;
        r10.onError(th);
        return;
    L69:
        return;
    L38:
        if (r17 == 0) goto L42;
        r15.index = Integer.valueOf(r13);
        if (r14 == Long.MAX_VALUE) goto L42;
        r15.produced(r17);
    L42:
        monitor-enter(r15);
    L51:
        th = move-exception;
        throw th;
    L44:
        if (r15.missed == false) goto L45;
        r15.missed = false;     // Catch: Throwable -> L51
        monitor-exit(r15);     // Catch: Throwable -> L51
        goto L12
    L45:
        r15.emitting = false;     // Catch: Throwable -> L51
        monitor-exit(r15);     // Catch: Throwable -> L51
        return;
    L17:
        r13 = 0;
        goto L18
    }
}
