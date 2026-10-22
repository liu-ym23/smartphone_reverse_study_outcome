package io.reactivex.internal.functions;

import java.util.ArrayList;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f17614a;

    public a(int r5) {
        this.f17614a = r5;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return new ArrayList(this.f17614a);
    }
}
