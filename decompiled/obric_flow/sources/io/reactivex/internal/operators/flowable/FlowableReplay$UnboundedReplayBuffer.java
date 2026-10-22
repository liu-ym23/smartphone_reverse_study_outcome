package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.util.NotificationLite;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
final class FlowableReplay$UnboundedReplayBuffer<T> extends ArrayList<Object> implements r {
    private static final long serialVersionUID = 7063189396499112664L;
    volatile int size;

    public FlowableReplay$UnboundedReplayBuffer(int r5) {
        super(r5);
    }

    @Override // io.reactivex.internal.operators.flowable.r
    public void complete() {
        add(NotificationLite.complete());
        this.size++;
    }

    @Override // io.reactivex.internal.operators.flowable.r
    public void error(Throwable r5) {
        add(NotificationLite.error(r5));
        this.size++;
    }

    @Override // io.reactivex.internal.operators.flowable.r
    public void next(T r5) {
        add(NotificationLite.next(r5));
        this.size++;
    }

    @Override // io.reactivex.internal.operators.flowable.r
    public void replay(FlowableReplay$InnerSubscription<T> r15) {
        monitor-enter(r15);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (r15.emitting == false) goto L10;
        r15.missed = true;     // Catch: Throwable -> L8
        monitor-exit(r15);     // Catch: Throwable -> L8
        return;
    L10:
        r15.emitting = true;     // Catch: Throwable -> L8
        monitor-exit(r15);     // Catch: Throwable -> L8
        zu.c r5 = r15.child;
    L14:
        if (r15.isDisposed() == true) goto L15;
        int r10 = this.size;
        Integer r11 = (Integer) r15.index();
        if (r11 == null) goto L19;
        int r12 = r11.intValue();
    L20:
        long r13 = r15.get();
        long r14 = r13;
        long r16 = 0;
    L22:
        if (r14 == 0) goto L40;
        if (r12 >= r10) goto L40;
        Object r17 = get(r12);
        if (NotificationLite.accept(r17, r5) == true) goto L27;
        if (r15.isDisposed() == true) goto L30;
        r12 = r12 + 1;
        r14 = r14 - 1;
        r16 = r16 + 1;
        goto L22
    L30:
        return;
    L27:
        return;
    L32:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        r15.dispose();
        if (NotificationLite.isError(r17) == false) goto L36;
        return;
    L36:
        if (NotificationLite.isComplete(r17) == true) goto L71;
        r5.onError(th);
        return;
    L71:
        return;
    L40:
        if (r16 == 0) goto L44;
        r15.index = Integer.valueOf(r12);
        if (r13 == Long.MAX_VALUE) goto L44;
        r15.produced(r16);
    L44:
        monitor-enter(r15);
    L50:
        th = move-exception;
        throw th;
    L46:
        if (r15.missed == false) goto L47;
        r15.missed = false;     // Catch: Throwable -> L50
        monitor-exit(r15);     // Catch: Throwable -> L50
        goto L14
    L47:
        r15.emitting = false;     // Catch: Throwable -> L50
        monitor-exit(r15);     // Catch: Throwable -> L50
        return;
    L19:
        r12 = 0;
        goto L20
    }
}
