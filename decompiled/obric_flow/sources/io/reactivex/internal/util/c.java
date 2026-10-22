package io.reactivex.internal.util;

import java.util.concurrent.CountDownLatch;
import pt.g;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends CountDownLatch implements g, pt.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Throwable f18172a;

    @Override // pt.g
    public final void accept(Object r5) {
        this.f18172a = (Throwable) r5;
        countDown();
    }

    @Override // pt.a
    public final void run() {
        countDown();
    }
}
