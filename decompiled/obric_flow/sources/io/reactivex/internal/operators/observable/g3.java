package io.reactivex.internal.operators.observable;

/* JADX INFO: loaded from: classes3.dex */
public final class g3 implements d3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f17793a;

    public g3(int r5) {
        this.f17793a = r5;
    }

    @Override // io.reactivex.internal.operators.observable.d3
    public final f3 call() {
        final int r5 = this.f17793a;
        return new ObservableReplay$SizeBoundReplayBuffer(r5);
    }
}
