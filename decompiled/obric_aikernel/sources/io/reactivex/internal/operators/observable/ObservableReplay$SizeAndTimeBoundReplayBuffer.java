package io.reactivex.internal.operators.observable;

import io.reactivex.internal.util.NotificationLite;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
final class ObservableReplay$SizeAndTimeBoundReplayBuffer<T> extends ObservableReplay$BoundedReplayBuffer<T> {
    private static final long serialVersionUID = 3457957419649567404L;
    final int limit;
    final long maxAge;
    final xb.p scheduler;
    final TimeUnit unit;

    ObservableReplay$SizeAndTimeBoundReplayBuffer(int r10, long r11, TimeUnit r12, xb.p r13) {
        this.scheduler = r13;
        this.limit = r10;
        this.maxAge = r11;
        this.unit = r12;
    }

    @Override // io.reactivex.internal.operators.observable.ObservableReplay$BoundedReplayBuffer
    Object enterTransform(Object r10) {
        return new ec.b(r10, this.scheduler.b(this.unit), this.unit);
    }

    @Override // io.reactivex.internal.operators.observable.ObservableReplay$BoundedReplayBuffer
    ObservableReplay$Node getHead() {
        long r10 = this.scheduler.b(this.unit) - this.maxAge;
        ObservableReplay$Node r11 = get();
    L3:
        ObservableReplay$Node r12 = r11.get();
        ObservableReplay$Node r13 = r11;
        r11 = r12;
        if (r11 == null) goto L14;
        ec.b r14 = (ec.b) r11.value;
        if (NotificationLite.isComplete(r14.b()) == true) goto L14;
        if (NotificationLite.isError(r14.b()) == true) goto L14;
        if (r14.a() <= r10) goto L3;
    L14:
        return r13;
    }

    @Override // io.reactivex.internal.operators.observable.ObservableReplay$BoundedReplayBuffer
    Object leaveTransform(Object r10) {
        return ((ec.b) r10).b();
    }

    @Override // io.reactivex.internal.operators.observable.ObservableReplay$BoundedReplayBuffer
    void truncate() {
        long r10 = this.scheduler.b(this.unit) - this.maxAge;
        ObservableReplay$Node r11 = get();
        ObservableReplay$Node r12 = r11.get();
        int r13 = 0;
    L3:
        ObservableReplay$Node r14 = r12;
        ObservableReplay$Node r15 = r11;
        r11 = r14;
        if (r11 == null) goto L12;
        int r16 = this.size;
        if (r16 <= this.limit) goto L10;
        r13 = r13 + 1;
        this.size = r16 - 1;
    L8:
        r12 = r11.get();
        goto L3
    L10:
        if (((ec.b) r11.value).a() > r10) goto L12;
        r13 = r13 + 1;
        this.size--;
    L12:
        if (r13 == 0) goto L19;
        setFirst(r15);
        return;
    }

    @Override // io.reactivex.internal.operators.observable.ObservableReplay$BoundedReplayBuffer
    void truncateFinal() {
        long r10 = this.scheduler.b(this.unit) - this.maxAge;
        ObservableReplay$Node r11 = get();
        ObservableReplay$Node r12 = r11.get();
        int r13 = 0;
    L3:
        ObservableReplay$Node r14 = r12;
        ObservableReplay$Node r15 = r11;
        r11 = r14;
        if (r11 == null) goto L10;
        if (this.size <= 1) goto L10;
        if (((ec.b) r11.value).a() > r10) goto L10;
        r13 = r13 + 1;
        this.size--;
        r12 = r11.get();
    L10:
        if (r13 == 0) goto L16;
        setFirst(r15);
        return;
    }
}
