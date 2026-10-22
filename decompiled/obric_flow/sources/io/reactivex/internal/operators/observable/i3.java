package io.reactivex.internal.operators.observable;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class i3 implements d3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f17817a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f17818b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TimeUnit f17819c;
    public final mt.z d;

    public i3(int r5, long r10, TimeUnit r11, mt.z r12) {
        this.f17817a = r5;
        this.f17818b = r10;
        this.f17819c = r11;
        this.d = r12;
    }

    @Override // io.reactivex.internal.operators.observable.d3
    public final f3 call() {
        final TimeUnit r5 = this.f17819c;
        final mt.z r10 = this.d;
        final int r11 = this.f17817a;
        final long r12 = this.f17818b;
        return new ObservableReplay$SizeAndTimeBoundReplayBuffer(r11, r12, r5, r10);
    }
}
