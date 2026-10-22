package mt;

import io.reactivex.internal.subscribers.StrictSubscriber;

/* JADX INFO: loaded from: classes3.dex */
public abstract class e implements zu.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f20168a = 0;

    static {
        f20168a = Math.max(1, Integer.getInteger("rx2.buffer-size", 128).intValue());
    }

    public final void a(g r5) {
        io.reactivex.internal.functions.e.d(r5, "s is null");
        b(r5);     // Catch: Throwable -> L5 NullPointerException -> L8
        return;
    L8:
        e = move-exception;
        throw e;
    L5:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        wn.f.k(th);
        NullPointerException r10 = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
        r10.initCause(th);
        throw r10;
    }

    public abstract void b(g r5);

    @Override // zu.b
    public final void subscribe(zu.c r5) {
        if ((r5 instanceof g) == false) goto L5;
        a((g) r5);
        return;
    L5:
        io.reactivex.internal.functions.e.d(r5, "s is null");
        a(new StrictSubscriber(r5));
    }
}
