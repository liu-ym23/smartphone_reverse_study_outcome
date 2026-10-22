package io.reactivex.internal.operators.observable;

/* JADX INFO: loaded from: classes2.dex */
final class n implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final m f9578c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final long f9579g;

    n(long r10, m r11) {
        this.f9579g = r10;
        this.f9578c = r11;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f9578c.onTimeout(this.f9579g);
    }
}
