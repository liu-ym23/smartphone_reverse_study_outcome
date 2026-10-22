package io.reactivex.internal.operators.flowable;

/* JADX INFO: loaded from: classes2.dex */
final class o implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final n f9519c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final long f9520g;

    o(long r10, n r11) {
        this.f9520g = r10;
        this.f9519c = r11;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f9519c.onTimeout(this.f9520g);
    }
}
