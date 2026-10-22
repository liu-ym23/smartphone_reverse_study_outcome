package io.reactivex.internal.functions;

import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f17616a;

    public /* synthetic */ d(int r5) {
        this.f17616a = r5;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch(this.f17616a) {
            case 0: goto L14;
            case 1: goto L13;
            case 2: goto L11;
            case 3: goto L9;
            case 4: goto L7;
            default: goto L5;
        };
    L14:
        return null;
    L5:
        return ut.d.f22460a;
    L7:
        return ut.c.f22459a;
    L9:
        return ut.b.f22458a;
    L11:
        return ut.a.f22457a;
    L13:
        return m9.c.e().a();
    }
}
