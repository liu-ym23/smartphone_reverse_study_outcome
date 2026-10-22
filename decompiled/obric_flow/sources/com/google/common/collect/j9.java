package com.google.common.collect;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class j9 implements com.google.common.base.q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9044a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Synchronized$SynchronizedTable f9045b;

    public /* synthetic */ j9(Synchronized$SynchronizedTable r5, int r10) {
        this.f9044a = r10;
        this.f9045b = r5;
    }

    @Override // java.util.function.Function
    public final Object apply(Object r5) {
        switch(this.f9044a) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return new Synchronized$SynchronizedMap((Map) r5, this.f9045b.mutex);
    L7:
        return new Synchronized$SynchronizedMap((Map) r5, this.f9045b.mutex);
    }
}
