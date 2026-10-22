package io.reactivex.internal.operators.observable;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class c2 implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final mt.n f17743a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f17744b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TimeUnit f17745c;
    public final mt.z d;

    public c2(mt.n r5, long r10, TimeUnit r11, mt.z r12) {
        this.f17743a = r5;
        this.f17744b = r10;
        this.f17745c = r11;
        this.d = r12;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return this.f17743a.replay(this.f17744b, this.f17745c, this.d);
    }
}
